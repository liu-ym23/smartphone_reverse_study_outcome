package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractAnnotationTypeQualifierResolver<TAnnotation> {
    private static final Companion Companion = null;

    @Deprecated
    private static final Map<String, AnnotationQualifierApplicabilityType> JAVA_APPLICABILITY_TYPES = null;
    private final JavaTypeEnhancementState javaTypeEnhancementState;
    private final ConcurrentHashMap<Object, TAnnotation> resolvedNicknames;

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        LinkedHashMap r10 = new LinkedHashMap();
        AnnotationQualifierApplicabilityType[] r11 = AnnotationQualifierApplicabilityType.values();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        AnnotationQualifierApplicabilityType r14 = r11[r13];
        String r15 = r14.getJavaTarget();
        if (r10.get(r15) != null) goto L7;
        r10.put(r15, r14);
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        JAVA_APPLICABILITY_TYPES = r10;
    }

    public AbstractAnnotationTypeQualifierResolver(JavaTypeEnhancementState r10) {
        Intrinsics.checkNotNullParameter(r10, "javaTypeEnhancementState");
        this.javaTypeEnhancementState = r10;
        this.resolvedNicknames = new ConcurrentHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Set<AnnotationQualifierApplicabilityType> allIfTypeUse(Set<? extends AnnotationQualifierApplicabilityType> r10) {
        if (r10.contains(AnnotationQualifierApplicabilityType.TYPE_USE) == true) goto L5;
        return r10;
    L5:
        return SetsKt.plus(SetsKt.minus(ArraysKt.toSet(AnnotationQualifierApplicabilityType.values()), AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS), r10);
    }

    private final JavaDefaultQualifiers extractDefaultQualifiers(TAnnotation r10) {
        JavaDefaultQualifiers r11 = resolveQualifierBuiltInDefaultAnnotation(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> r12 = resolveTypeQualifierDefaultAnnotation(r10);
        if (r12 != null) goto L8;
        return null;
    L8:
        TAnnotation r13 = r12.component1();
        Set<AnnotationQualifierApplicabilityType> r14 = r12.component2();
        ReportLevel r15 = resolveJsr305CustomState(r10);
        if (r15 != null) goto L12;
        r15 = resolveJsr305AnnotationState(r13);
    L12:
        if (r15.isIgnore() == false) goto L14;
        return null;
    L14:
        NullabilityQualifierWithMigrationStatus r16 = extractNullability(r13, AbstractAnnotationTypeQualifierResolver$extractDefaultQualifiers$nullabilityQualifier$1.INSTANCE);
        if (r16 != null) goto L18;
        return null;
    L18:
        return new JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus.copy$default(r16, null, r15.isWarning(), 1, null), r14, false, 4, null);
    }

    private final NullabilityQualifierWithMigrationStatus extractNullability(TAnnotation r10, Function1<? super TAnnotation, Boolean> r11) {
        NullabilityQualifierWithMigrationStatus r12 = knownNullability(r10, r11.invoke(r10).booleanValue());
        if (r12 == null) goto L5;
        return r12;
    L5:
        TAnnotation r13 = resolveTypeQualifierAnnotation(r10);
        if (r13 != null) goto L8;
        return null;
    L8:
        ReportLevel r14 = resolveJsr305AnnotationState(r10);
        if (r14.isIgnore() == false) goto L11;
        return null;
    L11:
        NullabilityQualifierWithMigrationStatus r15 = knownNullability(r13, r11.invoke(r13).booleanValue());
        if (r15 != null) goto L14;
        return null;
    L14:
        return NullabilityQualifierWithMigrationStatus.copy$default(r15, null, r14.isWarning(), 1, null);
    }

    private final TAnnotation findAnnotation(TAnnotation r10, FqName r11) {
        Iterator<TAnnotation> r12 = getMetaAnnotations(r10).iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        TAnnotation r13 = r12.next();
        if (Intrinsics.areEqual(getFqName(r13), r11) == false) goto L4;
        return r13;
    L8:
        return null;
    }

    private final boolean hasAnnotation(TAnnotation r10, FqName r11) {
        Iterable<TAnnotation> r12 = getMetaAnnotations(r10);
        if ((r12 instanceof Collection) == true) goto L5;
    L7:
        Iterator<TAnnotation> r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(getFqName(r13.next()), r11) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) r12).isEmpty() == false) goto L7;
        return false;
    }

    private final NullabilityQualifierWithMigrationStatus knownNullability(TAnnotation r10, boolean r11) {
        FqName r12 = getFqName(r10);
        if (r12 != null) goto L5;
        return null;
    L5:
        ReportLevel r13 = this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(r12);
        if (r13.isIgnore() == false) goto L8;
        return null;
    L8:
        boolean r14 = false;
        if (JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS().contains(r12) == false) goto L12;
    L10:
        NullabilityQualifier r15 = NullabilityQualifier.NULLABLE;
    L52:
        if (r13.isWarning() == true) goto L54;
        if (r11 == true) goto L54;
    L56:
        return new NullabilityQualifierWithMigrationStatus(r15, r14);
    L54:
        r14 = true;
        goto L56
    L12:
        if (JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS().contains(r12) == false) goto L15;
    L13:
        r15 = NullabilityQualifier.NOT_NULL;
        goto L52
    L15:
        if (Intrinsics.areEqual(r12, JvmAnnotationNamesKt.getJSPECIFY_NULLABLE()) == true) goto L10;
        if (Intrinsics.areEqual(r12, JvmAnnotationNamesKt.getJSPECIFY_NULLNESS_UNKNOWN()) == false) goto L21;
    L19:
        r15 = NullabilityQualifier.FORCE_FLEXIBILITY;
        goto L52
    L21:
        if (Intrinsics.areEqual(r12, JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION()) == false) goto L40;
        String r16 = (String) CollectionsKt.firstOrNull(enumArguments(r10, false));
        if (r16 == null) goto L13;
        switch(r16.hashCode()) {
            case 73135176: goto L37;
            case 74175084: goto L34;
            case 433141802: goto L31;
            case 1933739535: goto L28;
            default: goto L38;
        };
    L38:
        return null;
    L28:
        if (r16.equals("ALWAYS") == false) goto L38;
    L31:
        if (r16.equals("UNKNOWN") == true) goto L19;
    L34:
        if (r16.equals("NEVER") == true) goto L10;
    L37:
        if (r16.equals("MAYBE") == true) goto L10;
    L40:
        if (Intrinsics.areEqual(r12, JvmAnnotationNamesKt.getCOMPATQUAL_NULLABLE_ANNOTATION()) == true) goto L10;
        if (Intrinsics.areEqual(r12, JvmAnnotationNamesKt.getCOMPATQUAL_NONNULL_ANNOTATION()) == true) goto L13;
        if (Intrinsics.areEqual(r12, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NON_NULL_ANNOTATION()) == true) goto L13;
        if (Intrinsics.areEqual(r12, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NULLABLE_ANNOTATION()) == true) goto L10;
        return null;
    }

    private final ReportLevel resolveDefaultAnnotationState(TAnnotation r10) {
        FqName r11 = getFqName(r10);
        if (r11 == null) goto L9;
        if (AnnotationQualifiersFqNamesKt.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(r11) == false) goto L9;
        return this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(r11);
    L9:
        return resolveJsr305AnnotationState(r10);
    }

    private final ReportLevel resolveJsr305AnnotationState(TAnnotation r10) {
        ReportLevel r11 = resolveJsr305CustomState(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return this.javaTypeEnhancementState.getJsr305().getGlobalLevel();
    }

    private final ReportLevel resolveJsr305CustomState(TAnnotation r10) {
        ReportLevel r11 = this.javaTypeEnhancementState.getJsr305().getUserDefinedLevelForSpecificAnnotation().get(getFqName(r10));
        if (r11 == null) goto L5;
        return r11;
    L5:
        TAnnotation r12 = findAnnotation(r10, AnnotationQualifiersFqNamesKt.getMIGRATION_ANNOTATION_FQNAME());
        if (r12 == null) goto L35;
        Iterable<String> r13 = enumArguments(r12, false);
        if (r13 == null) goto L36;
        String r14 = (String) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L40;
        ReportLevel r15 = this.javaTypeEnhancementState.getJsr305().getMigrationLevel();
        if (r15 != null) goto L34;
        int r16 = r14.hashCode();
        if (r16 == (-2137067054)) goto L30;
        if (r16 == (-1838656823)) goto L26;
        if (r16 == 2656902) goto L22;
        return null;
    L22:
        if (r14.equals("WARN") == true) goto L37;
        return null;
    L37:
        return ReportLevel.WARN;
    L26:
        if (r14.equals("STRICT") == true) goto L38;
        return null;
    L38:
        return ReportLevel.STRICT;
    L30:
        if (r14.equals("IGNORE") == true) goto L39;
        return null;
    L39:
        return ReportLevel.IGNORE;
    L34:
        return r15;
    L40:
        return null;
    L36:
        return null;
    L35:
        return null;
    }

    private final JavaDefaultQualifiers resolveQualifierBuiltInDefaultAnnotation(TAnnotation r10) {
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations() == false) goto L5;
        return null;
    L5:
        JavaDefaultQualifiers r11 = AnnotationQualifiersFqNamesKt.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(getFqName(r10));
        if (r11 == null) goto L18;
        ReportLevel r12 = resolveDefaultAnnotationState(r10);
        if (r12 == ReportLevel.IGNORE) goto L10;
        boolean r13 = true;
    L11:
        if (r13 == true) goto L14;
        r12 = null;
    L14:
        if (r12 != null) goto L17;
        return null;
    L17:
        return JavaDefaultQualifiers.copy$default(r11, NullabilityQualifierWithMigrationStatus.copy$default(r11.getNullabilityQualifier(), null, r12.isWarning(), 1, null), null, false, 6, null);
    L10:
        r13 = false;
        goto L11
    L18:
        return null;
    }

    private final Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> resolveTypeQualifierDefaultAnnotation(TAnnotation r10) {
        if (this.javaTypeEnhancementState.getJsr305().isDisabled() == false) goto L5;
        return null;
    L5:
        TAnnotation r11 = findAnnotation(r10, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_DEFAULT_FQNAME());
        if (r11 != null) goto L8;
        return null;
    L8:
        Iterator<TAnnotation> r12 = getMetaAnnotations(r10).iterator();
    L10:
        if (r12.hasNext() == false) goto L17;
        TAnnotation r13 = r12.next();
        if (resolveTypeQualifierAnnotation(r13) == null) goto L14;
        boolean r14 = true;
    L15:
        if (r14 == false) goto L10;
    L18:
        if (r13 != null) goto L20;
        return null;
    L20:
        Iterable<String> r15 = enumArguments(r11, true);
        LinkedHashSet r16 = new LinkedHashSet();
        Iterator<String> r17 = r15.iterator();
    L22:
        if (r17.hasNext() == false) goto L27;
        AnnotationQualifierApplicabilityType r18 = JAVA_APPLICABILITY_TYPES.get(r17.next());
        if (r18 == null) goto L22;
        r16.add(r18);
        goto L22
    L27:
        return new Pair(r13, allIfTypeUse(r16));
    L14:
        r14 = false;
        goto L15
    L17:
        r13 = null;
        goto L18
    }

    protected abstract Iterable<String> enumArguments(TAnnotation r10, boolean r11);

    public final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(JavaTypeQualifiersByElementType r10, Iterable<? extends TAnnotation> r11) {
        Intrinsics.checkNotNullParameter(r11, "annotations");
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations() == false) goto L5;
        return r10;
    L5:
        ArrayList r12 = new ArrayList();
        Iterator<? extends TAnnotation> r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L12;
        JavaDefaultQualifiers r14 = extractDefaultQualifiers(r13.next());
        if (r14 == null) goto L7;
        r12.add(r14);
        goto L7
    L12:
        if (r12.isEmpty() == false) goto L14;
        return r10;
    L14:
        if (r10 == null) goto L18;
        EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> r15 = r10.getDefaultQualifiers();
        if (r15 == null) goto L18;
        EnumMap r16 = new EnumMap(r15);
    L19:
        boolean r17 = false;
        Iterator r18 = r12.iterator();
    L21:
        if (r18.hasNext() == false) goto L26;
        JavaDefaultQualifiers r19 = (JavaDefaultQualifiers) r18.next();
        Iterator<AnnotationQualifierApplicabilityType> r20 = r19.getQualifierApplicabilityTypes().iterator();
    L24:
        if (r20.hasNext() == false) goto L21;
        r16.put(r20.next(), r19);
        r17 = true;
        goto L24
    L26:
        if (r17 == true) goto L29;
        return r10;
    L29:
        return new JavaTypeQualifiersByElementType(r16);
    L18:
        r16 = new EnumMap(AnnotationQualifierApplicabilityType.class);
        goto L19
    }

    public final MutabilityQualifier extractMutability(Iterable<? extends TAnnotation> r10) {
        Intrinsics.checkNotNullParameter(r10, "annotations");
        Iterator<? extends TAnnotation> r11 = r10.iterator();
        MutabilityQualifier r12 = null;
    L4:
        if (r11.hasNext() == false) goto L15;
        FqName r13 = getFqName(r11.next());
        if (JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS().contains(r13) == true) goto L7;
        if (JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS().contains(r13) == false) goto L4;
        MutabilityQualifier r14 = MutabilityQualifier.MUTABLE;
    L11:
        if (r12 == null) goto L14;
        if (r12 == r14) goto L14;
        return null;
    L14:
        r12 = r14;
        goto L4
    L7:
        r14 = MutabilityQualifier.READ_ONLY;
        goto L11
    L15:
        return r12;
    }

    public final NullabilityQualifierWithMigrationStatus extractNullability(Iterable<? extends TAnnotation> r10, Function1<? super TAnnotation, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "annotations");
        Intrinsics.checkNotNullParameter(r11, "forceWarning");
        Iterator<? extends TAnnotation> r12 = r10.iterator();
        NullabilityQualifierWithMigrationStatus r13 = null;
    L4:
        if (r12.hasNext() == false) goto L23;
        NullabilityQualifierWithMigrationStatus r14 = extractNullability(r12.next(), r11);
        if (r13 == null) goto L21;
        if (r14 == null) goto L4;
        if (Intrinsics.areEqual(r14, r13) == true) goto L4;
        if (r14.isForWarningOnly() == false) goto L18;
        if (r13.isForWarningOnly() == false) goto L4;
    L18:
        if (r14.isForWarningOnly() == true) goto L22;
        if (r13.isForWarningOnly() == true) goto L21;
    L22:
        return null;
    L21:
        r13 = r14;
        goto L4
    L23:
        return r13;
    }

    protected abstract FqName getFqName(TAnnotation r10);

    protected abstract Object getKey(TAnnotation r10);

    protected abstract Iterable<TAnnotation> getMetaAnnotations(TAnnotation r10);

    public final boolean isTypeUseAnnotation(TAnnotation r10) {
        Intrinsics.checkNotNullParameter(r10, "annotation");
        TAnnotation r11 = findAnnotation(r10, StandardNames.FqNames.target);
        if (r11 != null) goto L5;
        return false;
    L5:
        Iterable<String> r12 = enumArguments(r11, false);
        if ((r12 instanceof Collection) == true) goto L8;
    L10:
        Iterator<String> r13 = r12.iterator();
    L12:
        if (r13.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(r13.next(), KotlinTarget.TYPE.name()) == false) goto L12;
        return true;
    L21:
        return false;
    L8:
        if (((Collection) r12).isEmpty() == false) goto L10;
        return false;
    }

    public final TAnnotation resolveTypeQualifierAnnotation(TAnnotation r10) {
        Intrinsics.checkNotNullParameter(r10, "annotation");
        if (this.javaTypeEnhancementState.getJsr305().isDisabled() == false) goto L6;
        return null;
    L6:
        if (CollectionsKt.contains(AnnotationQualifiersFqNamesKt.getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES(), getFqName(r10)) == false) goto L8;
    L29:
        return r10;
    L8:
        if (hasAnnotation(r10, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_FQNAME()) == true) goto L29;
        if (hasAnnotation(r10, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_NICKNAME_FQNAME()) == true) goto L13;
        return null;
    L13:
        ConcurrentHashMap<Object, TAnnotation> r11 = this.resolvedNicknames;
        Object r12 = getKey(r10);
        TAnnotation r13 = r11.get(r12);
        if (r13 != null) goto L33;
        Iterator<TAnnotation> r14 = getMetaAnnotations(r10).iterator();
    L17:
        if (r14.hasNext() == false) goto L21;
        TAnnotation r15 = resolveTypeQualifierAnnotation(r14.next());
        if (r15 == null) goto L17;
    L22:
        if (r15 != null) goto L24;
        return null;
    L24:
        TAnnotation r16 = r11.putIfAbsent(r12, r15);
        if (r16 != null) goto L28;
        return r15;
    L28:
        return r16;
    L21:
        r15 = null;
        goto L22
    L33:
        return r13;
    }
}
