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
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class AbstractAnnotationTypeQualifierResolver<TAnnotation> {
    private static final Companion Companion = null;
    private static final Map<String, AnnotationQualifierApplicabilityType> JAVA_APPLICABILITY_TYPES = null;
    private final JavaTypeEnhancementState javaTypeEnhancementState;
    private final ConcurrentHashMap<Object, TAnnotation> resolvedNicknames;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    public static /* synthetic */ boolean accessor$AbstractAnnotationTypeQualifierResolver$lambda1(Object r0) {
        return extractDefaultQualifiers$lambda$16(r0);
    }

    private static final boolean extractDefaultQualifiers$lambda$16(Object r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$extractNullability");
        return false;
    }

    public abstract Iterable<String> enumArguments(TAnnotation r1, boolean r2);

    public abstract FqName getFqName(TAnnotation r1);

    public abstract Object getKey(TAnnotation r1);

    public abstract Iterable<TAnnotation> getMetaAnnotations(TAnnotation r1);

    static {
        Companion = new Companion(null);
        LinkedHashMap r0 = new LinkedHashMap();
        AnnotationQualifierApplicabilityType[] r1 = AnnotationQualifierApplicabilityType.values();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        AnnotationQualifierApplicabilityType r4 = r1[r3];
        String r5 = r4.getJavaTarget();
        if (r0.get(r5) != null) goto L7;
        r0.put(r5, r4);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        JAVA_APPLICABILITY_TYPES = r0;
    }

    public AbstractAnnotationTypeQualifierResolver(JavaTypeEnhancementState r2) {
        Intrinsics.checkNotNullParameter(r2, "javaTypeEnhancementState");
        this.javaTypeEnhancementState = r2;
        this.resolvedNicknames = new ConcurrentHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Set<AnnotationQualifierApplicabilityType> allIfTypeUse(Set<? extends AnnotationQualifierApplicabilityType> r3) {
        if (r3.contains(AnnotationQualifierApplicabilityType.TYPE_USE) == true) goto L5;
        return r3;
    L5:
        return SetsKt.plus(SetsKt.minus(ArraysKt.toSet(AnnotationQualifierApplicabilityType.values()), AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS), r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final JavaDefaultQualifiers extractDefaultQualifiers(TAnnotation r11) {
        JavaDefaultQualifiers r0 = resolveQualifierBuiltInDefaultAnnotation(r11);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Pair r1 = resolveTypeQualifierDefaultAnnotation(r11);
        if (r1 != null) goto L8;
        return null;
    L8:
        Object r2 = r1.component1();
        Set r3 = (Set) r1.component2();
        ReportLevel r12 = resolveJsr305CustomState(r11);
        if (r12 != null) goto L12;
        r12 = resolveJsr305AnnotationState(r2);
    L12:
        if (r12.isIgnore() == false) goto L14;
        return null;
    L14:
        NullabilityQualifierWithMigrationStatus r4 = extractNullability(r2, AbstractAnnotationTypeQualifierResolver$.Lambda.1.INSTANCE);
        if (r4 != null) goto L18;
        return null;
    L18:
        return new JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus.copy$default(r4, null, r12.isWarning(), 1, null), r3, false, 4, null);
    }

    private final ReportLevel resolveDefaultAnnotationState(TAnnotation r3) {
        FqName r0 = getFqName(r3);
        if (r0 == null) goto L9;
        if (AnnotationQualifiersFqNamesKt.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(r0) == false) goto L9;
        return (ReportLevel) this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(r0);
    L9:
        return resolveJsr305AnnotationState(r3);
    }

    private final ReportLevel resolveJsr305AnnotationState(TAnnotation r1) {
        ReportLevel r2 = resolveJsr305CustomState(r1);
        if (r2 == null) goto L6;
        return r2;
    L6:
        return this.javaTypeEnhancementState.getJsr305().getGlobalLevel();
    }

    private final ReportLevel resolveJsr305CustomState(TAnnotation r4) {
        ReportLevel r0 = this.javaTypeEnhancementState.getJsr305().getUserDefinedLevelForSpecificAnnotation().get(getFqName(r4));
        if (r0 == null) goto L5;
        return r0;
    L5:
        TAnnotation r5 = findAnnotation(r4, AnnotationQualifiersFqNamesKt.getMIGRATION_ANNOTATION_FQNAME());
        if (r5 == null) goto L35;
        Iterable<String> r6 = enumArguments(r5, false);
        if (r6 == null) goto L36;
        String r7 = (String) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L40;
        ReportLevel r1 = this.javaTypeEnhancementState.getJsr305().getMigrationLevel();
        if (r1 != null) goto L34;
        int r2 = r7.hashCode();
        if (r2 == (-2137067054)) goto L30;
        if (r2 == (-1838656823)) goto L26;
        if (r2 == 2656902) goto L22;
        return null;
    L22:
        if (r7.equals("WARN") == true) goto L37;
        return null;
    L37:
        return ReportLevel.WARN;
    L26:
        if (r7.equals("STRICT") == true) goto L38;
        return null;
    L38:
        return ReportLevel.STRICT;
    L30:
        if (r7.equals("IGNORE") == true) goto L39;
        return null;
    L39:
        return ReportLevel.IGNORE;
    L34:
        return r1;
    L40:
        return null;
    L36:
        return null;
    L35:
        return null;
    }

    private final JavaDefaultQualifiers resolveQualifierBuiltInDefaultAnnotation(TAnnotation r9) {
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations() == false) goto L5;
        return null;
    L5:
        JavaDefaultQualifiers r2 = (JavaDefaultQualifiers) AnnotationQualifiersFqNamesKt.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(getFqName(r9));
        if (r2 == null) goto L18;
        ReportLevel r10 = resolveDefaultAnnotationState(r9);
        if (r10 == ReportLevel.IGNORE) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L14;
        r10 = null;
    L14:
        if (r10 != null) goto L17;
        return null;
    L17:
        return JavaDefaultQualifiers.copy$default(r2, NullabilityQualifierWithMigrationStatus.copy$default(r2.getNullabilityQualifier(), null, r10.isWarning(), 1, null), null, false, 6, null);
    L10:
        r0 = false;
        goto L11
    L18:
        return null;
    }

    private final Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> resolveTypeQualifierDefaultAnnotation(TAnnotation r6) {
        if (this.javaTypeEnhancementState.getJsr305().isDisabled() == false) goto L5;
        return null;
    L5:
        TAnnotation r0 = findAnnotation(r6, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_DEFAULT_FQNAME());
        if (r0 != null) goto L8;
        return null;
    L8:
        Iterator<TAnnotation> r7 = getMetaAnnotations(r6).iterator();
    L10:
        if (r7.hasNext() == false) goto L17;
        TAnnotation r2 = r7.next();
        if (resolveTypeQualifierAnnotation(r2) == null) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L10;
    L18:
        if (r2 != null) goto L20;
        return null;
    L20:
        Iterable<String> r8 = enumArguments(r0, true);
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator<String> r9 = r8.iterator();
    L22:
        if (r9.hasNext() == false) goto L27;
        AnnotationQualifierApplicabilityType r3 = JAVA_APPLICABILITY_TYPES.get(r9.next());
        if (r3 == null) goto L22;
        r1.add(r3);
        goto L22
    L27:
        return new Pair(r2, allIfTypeUse(r1));
    L14:
        r4 = false;
        goto L15
    L17:
        r2 = null;
        goto L18
    }

    public final MutabilityQualifier extractMutability(Iterable<? extends TAnnotation> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        Iterator<? extends TAnnotation> r6 = r5.iterator();
        MutabilityQualifier r1 = null;
    L4:
        if (r6.hasNext() == false) goto L15;
        FqName r2 = getFqName(r6.next());
        if (JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS().contains(r2) == true) goto L7;
        if (JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS().contains(r2) == false) goto L4;
        MutabilityQualifier r3 = MutabilityQualifier.MUTABLE;
    L11:
        if (r1 == null) goto L14;
        if (r1 == r3) goto L14;
        return null;
    L14:
        r1 = r3;
        goto L4
    L7:
        r3 = MutabilityQualifier.READ_ONLY;
        goto L11
    L15:
        return r1;
    }

    public final boolean isTypeUseAnnotation(TAnnotation r4) {
        Intrinsics.checkNotNullParameter(r4, "annotation");
        TAnnotation r5 = findAnnotation(r4, StandardNames.FqNames.target);
        if (r5 != null) goto L5;
        return false;
    L5:
        Iterable<String> r6 = enumArguments(r5, false);
        if ((r6 instanceof Collection) == true) goto L8;
    L10:
        Iterator<String> r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(r7.next(), "TYPE") == false) goto L12;
        return true;
    L21:
        return false;
    L8:
        if (((Collection) r6).isEmpty() == false) goto L10;
        return false;
    }

    public final TAnnotation resolveTypeQualifierAnnotation(TAnnotation r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        if (this.javaTypeEnhancementState.getJsr305().isDisabled() == false) goto L6;
        return null;
    L6:
        if (CollectionsKt.contains(AnnotationQualifiersFqNamesKt.getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES(), getFqName(r5)) == false) goto L8;
    L29:
        return r5;
    L8:
        if (hasAnnotation(r5, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_FQNAME()) == true) goto L29;
        if (hasAnnotation(r5, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_NICKNAME_FQNAME()) == true) goto L13;
        return null;
    L13:
        ConcurrentHashMap<Object, TAnnotation> r0 = this.resolvedNicknames;
        Object r2 = getKey(r5);
        TAnnotation r3 = r0.get(r2);
        if (r3 != null) goto L33;
        Iterator<TAnnotation> r6 = getMetaAnnotations(r5).iterator();
    L17:
        if (r6.hasNext() == false) goto L21;
        TAnnotation r4 = resolveTypeQualifierAnnotation(r6.next());
        if (r4 == null) goto L17;
    L22:
        if (r4 != null) goto L24;
        return null;
    L24:
        TAnnotation r7 = r0.putIfAbsent(r2, r4);
        if (r7 != null) goto L28;
        return r4;
    L28:
        return r7;
    L21:
        r4 = null;
        goto L22
    L33:
        return r3;
    }

    private final TAnnotation findAnnotation(TAnnotation r3, FqName r4) {
        Iterator<TAnnotation> r5 = getMetaAnnotations(r3).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        TAnnotation r0 = r5.next();
        if (Intrinsics.areEqual(getFqName(r0), r4) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    private final boolean hasAnnotation(TAnnotation r3, FqName r4) {
        Iterable<TAnnotation> r5 = getMetaAnnotations(r3);
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator<TAnnotation> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(getFqName(r6.next()), r4) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) r5).isEmpty() == false) goto L7;
        return false;
    }

    private final NullabilityQualifierWithMigrationStatus knownNullability(TAnnotation r6, boolean r7) {
        FqName r0 = getFqName(r6);
        if (r0 != null) goto L5;
        return null;
    L5:
        ReportLevel r2 = (ReportLevel) this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(r0);
        if (r2.isIgnore() == false) goto L8;
        return null;
    L8:
        boolean r4 = false;
        if (JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS().contains(r0) == false) goto L12;
        NullabilityQualifier r8 = NullabilityQualifier.NULLABLE;
    L66:
        if (r2.isWarning() == true) goto L68;
        if (r7 == true) goto L68;
    L70:
        return new NullabilityQualifierWithMigrationStatus(r8, r4);
    L68:
        r4 = true;
        goto L70
    L12:
        if (JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS().contains(r0) == false) goto L15;
        r8 = NullabilityQualifier.NOT_NULL;
        goto L66
    L15:
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getJSPECIFY_OLD_NULLABLE()) == false) goto L17;
    L64:
        r8 = NullabilityQualifier.NULLABLE;
        goto L66
    L17:
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getJSPECIFY_NULLABLE()) == true) goto L64;
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getJSPECIFY_NON_NULL()) == false) goto L23;
        r8 = NullabilityQualifier.NOT_NULL;
        goto L66
    L23:
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getJSPECIFY_OLD_NULLNESS_UNKNOWN()) == false) goto L25;
    L63:
        r8 = NullabilityQualifier.FORCE_FLEXIBILITY;
        goto L66
    L25:
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getJSPECIFY_NULLNESS_UNKNOWN()) == true) goto L63;
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION()) == false) goto L51;
        String r9 = (String) CollectionsKt.firstOrNull(enumArguments(r6, false));
        if (r9 != null) goto L32;
    L49:
        r8 = NullabilityQualifier.NOT_NULL;
        goto L66
    L32:
        switch(r9.hashCode()) {
            case 73135176: goto L45;
            case 74175084: goto L42;
            case 433141802: goto L38;
            case 1933739535: goto L35;
            default: goto L48;
        };
    L48:
        return null;
    L35:
        if (r9.equals("ALWAYS") == false) goto L48;
    L38:
        if (r9.equals("UNKNOWN") == false) goto L48;
        r8 = NullabilityQualifier.FORCE_FLEXIBILITY;
        goto L66
    L42:
        if (r9.equals("NEVER") == false) goto L48;
    L47:
        r8 = NullabilityQualifier.NULLABLE;
        goto L66
    L45:
        if (r9.equals("MAYBE") == true) goto L47;
    L51:
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getCOMPATQUAL_NULLABLE_ANNOTATION()) == false) goto L54;
        r8 = NullabilityQualifier.NULLABLE;
        goto L66
    L54:
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getCOMPATQUAL_NONNULL_ANNOTATION()) == false) goto L57;
        r8 = NullabilityQualifier.NOT_NULL;
        goto L66
    L57:
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NON_NULL_ANNOTATION()) == false) goto L60;
        r8 = NullabilityQualifier.NOT_NULL;
        goto L66
    L60:
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NULLABLE_ANNOTATION()) == false) goto L62;
        r8 = NullabilityQualifier.NULLABLE;
        goto L66
    L62:
        return null;
    }

    public final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(JavaTypeQualifiersByElementType r6, Iterable<? extends TAnnotation> r7) {
        Intrinsics.checkNotNullParameter(r7, "annotations");
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations() == false) goto L5;
        return r6;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<? extends TAnnotation> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L12;
        JavaDefaultQualifiers r1 = extractDefaultQualifiers(r8.next());
        if (r1 == null) goto L7;
        r0.add(r1);
        goto L7
    L12:
        if (r0.isEmpty() == false) goto L14;
        return r6;
    L14:
        if (r6 == null) goto L18;
        EnumMap r9 = r6.getDefaultQualifiers();
        if (r9 == null) goto L18;
        EnumMap r2 = new EnumMap(r9);
    L19:
        Iterator r10 = r0.iterator();
        boolean r3 = false;
    L21:
        if (r10.hasNext() == false) goto L26;
        JavaDefaultQualifiers r4 = (JavaDefaultQualifiers) r10.next();
        Iterator r5 = r4.getQualifierApplicabilityTypes().iterator();
    L24:
        if (r5.hasNext() == false) goto L21;
        r2.put((AnnotationQualifierApplicabilityType) r5.next(), r4);
        r3 = true;
        goto L24
    L26:
        if (r3 == true) goto L29;
        return r6;
    L29:
        return new JavaTypeQualifiersByElementType(r2);
    L18:
        r2 = new EnumMap(AnnotationQualifierApplicabilityType.class);
        goto L19
    }

    public final NullabilityQualifierWithMigrationStatus extractNullability(Iterable<? extends TAnnotation> r5, Function1<? super TAnnotation, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        Intrinsics.checkNotNullParameter(r6, "forceWarning");
        Iterator<? extends TAnnotation> r7 = r5.iterator();
        NullabilityQualifierWithMigrationStatus r1 = null;
    L4:
        if (r7.hasNext() == false) goto L23;
        NullabilityQualifierWithMigrationStatus r2 = extractNullability(r7.next(), r6);
        if (r1 == null) goto L21;
        if (r2 == null) goto L4;
        if (Intrinsics.areEqual(r2, r1) == true) goto L4;
        if (r2.isForWarningOnly() == false) goto L18;
        if (r1.isForWarningOnly() == false) goto L4;
    L18:
        if (r2.isForWarningOnly() == true) goto L22;
        if (r1.isForWarningOnly() == true) goto L21;
    L22:
        return null;
    L21:
        r1 = r2;
        goto L4
    L23:
        return r1;
    }

    private final NullabilityQualifierWithMigrationStatus extractNullability(TAnnotation r4, Function1<? super TAnnotation, Boolean> r5) {
        NullabilityQualifierWithMigrationStatus r0 = knownNullability(r4, ((Boolean) r5.invoke(r4)).booleanValue());
        if (r0 == null) goto L5;
        return r0;
    L5:
        TAnnotation r1 = resolveTypeQualifierAnnotation(r4);
        if (r1 != null) goto L8;
        return null;
    L8:
        ReportLevel r6 = resolveJsr305AnnotationState(r4);
        if (r6.isIgnore() == false) goto L11;
        return null;
    L11:
        NullabilityQualifierWithMigrationStatus r7 = knownNullability(r1, ((Boolean) r5.invoke(r1)).booleanValue());
        if (r7 != null) goto L14;
        return null;
    L14:
        return NullabilityQualifierWithMigrationStatus.copy$default(r7, null, r6.isWarning(), 1, null);
    }
}
