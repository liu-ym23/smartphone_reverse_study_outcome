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
import kotlin.collections.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nAbstractAnnotationTypeQualifierResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractAnnotationTypeQualifierResolver.kt\norg/jetbrains/kotlin/load/java/AbstractAnnotationTypeQualifierResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,213:1\n1#2:214\n1#2:220\n1#2:225\n1#2:247\n1747#3,3:215\n288#3,2:221\n1611#3:223\n1855#3:224\n1856#3:226\n1612#3:227\n1747#3,3:228\n1789#3,3:231\n1789#3,3:234\n1603#3,9:237\n1855#3:246\n1856#3:248\n1612#3:249\n73#4,2:218\n361#5,7:250\n*S KotlinDebug\n*F\n+ 1 AbstractAnnotationTypeQualifierResolver.kt\norg/jetbrains/kotlin/load/java/AbstractAnnotationTypeQualifierResolver\n*L\n40#1:220\n81#1:225\n162#1:247\n30#1:215,3\n79#1:221,2\n81#1:223\n81#1:224\n81#1:226\n81#1:227\n88#1:228,3\n124#1:231,3\n136#1:234,3\n162#1:237,9\n162#1:246\n162#1:248\n162#1:249\n40#1:218,2\n208#1:250,7\n*E\n"})
public abstract class AbstractAnnotationTypeQualifierResolver<TAnnotation> {
    private static final Companion Companion = null;
    private static final Map<String, AnnotationQualifierApplicabilityType> JAVA_APPLICABILITY_TYPES = null;
    private final JavaTypeEnhancementState javaTypeEnhancementState;
    private final ConcurrentHashMap<Object, TAnnotation> resolvedNicknames;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        LinkedHashMap r5 = new LinkedHashMap();
        AnnotationQualifierApplicabilityType[] r10 = AnnotationQualifierApplicabilityType.values();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        AnnotationQualifierApplicabilityType r13 = r10[r12];
        String r14 = r13.getJavaTarget();
        if (r5.get(r14) != null) goto L7;
        r5.put(r14, r13);
    L7:
        r12 = r12 + 1;
        goto L3
    L8:
        JAVA_APPLICABILITY_TYPES = r5;
    }

    public AbstractAnnotationTypeQualifierResolver(JavaTypeEnhancementState r5) {
        Intrinsics.checkNotNullParameter(r5, "javaTypeEnhancementState");
        this.javaTypeEnhancementState = r5;
        this.resolvedNicknames = new ConcurrentHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Set<AnnotationQualifierApplicabilityType> allIfTypeUse(Set<? extends AnnotationQualifierApplicabilityType> r5) {
        if (r5.contains(AnnotationQualifierApplicabilityType.TYPE_USE) == true) goto L5;
        return r5;
    L5:
        return SetsKt.plus(SetsKt.a(ArraysKt.toSet(AnnotationQualifierApplicabilityType.values()), AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS), r5);
    }

    private final JavaDefaultQualifiers extractDefaultQualifiers(TAnnotation r10) {
        JavaDefaultQualifiers r5 = resolveQualifierBuiltInDefaultAnnotation(r10);
        if (r5 == null) goto L5;
        return r5;
    L5:
        Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> r11 = resolveTypeQualifierDefaultAnnotation(r10);
        if (r11 != null) goto L8;
        return null;
    L8:
        TAnnotation r12 = r11.component1();
        Set<AnnotationQualifierApplicabilityType> r13 = r11.component2();
        ReportLevel r14 = resolveJsr305CustomState(r10);
        if (r14 != null) goto L12;
        r14 = resolveJsr305AnnotationState(r12);
    L12:
        if (r14.isIgnore() == false) goto L14;
        return null;
    L14:
        NullabilityQualifierWithMigrationStatus r15 = extractNullability(r12, AbstractAnnotationTypeQualifierResolver$extractDefaultQualifiers$nullabilityQualifier$1.INSTANCE);
        if (r15 != null) goto L18;
        return null;
    L18:
        return new JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus.copy$default(r15, null, r14.isWarning(), 1, null), r13, false, 4, null);
    }

    private final TAnnotation findAnnotation(TAnnotation r5, FqName r10) {
        Iterator<TAnnotation> r11 = getMetaAnnotations(r5).iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        TAnnotation r12 = r11.next();
        if (Intrinsics.areEqual(getFqName(r12), r10) == false) goto L4;
        return r12;
    L8:
        return null;
    }

    private final boolean hasAnnotation(TAnnotation r5, FqName r10) {
        Iterable<TAnnotation> r11 = getMetaAnnotations(r5);
        if ((r11 instanceof Collection) == true) goto L5;
    L7:
        Iterator<TAnnotation> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(getFqName(r12.next()), r10) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) r11).isEmpty() == false) goto L7;
        return false;
    }

    private final NullabilityQualifierWithMigrationStatus knownNullability(TAnnotation r10, boolean r11) {
        FqName r5 = getFqName(r10);
        if (r5 != null) goto L5;
        return null;
    L5:
        ReportLevel r12 = this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(r5);
        if (r12.isIgnore() == false) goto L8;
        return null;
    L8:
        boolean r13 = false;
        if (JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS().contains(r5) == false) goto L12;
        NullabilityQualifier r14 = NullabilityQualifier.NULLABLE;
    L61:
        if (r12.isWarning() == true) goto L63;
        if (r11 == true) goto L63;
    L65:
        return new NullabilityQualifierWithMigrationStatus(r14, r13);
    L63:
        r13 = true;
        goto L65
    L12:
        if (JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS().contains(r5) == false) goto L15;
        r14 = NullabilityQualifier.NOT_NULL;
        goto L61
    L15:
        if (Intrinsics.areEqual(r5, JvmAnnotationNamesKt.getJSPECIFY_OLD_NULLABLE()) == false) goto L17;
        boolean r15 = true;
    L18:
        if (r15 == false) goto L21;
        r14 = NullabilityQualifier.NULLABLE;
        goto L61
    L21:
        if (Intrinsics.areEqual(r5, JvmAnnotationNamesKt.getJSPECIFY_OLD_NULLNESS_UNKNOWN()) == false) goto L23;
        boolean r16 = true;
    L24:
        if (r16 == false) goto L27;
        r14 = NullabilityQualifier.FORCE_FLEXIBILITY;
        goto L61
    L27:
        if (Intrinsics.areEqual(r5, JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION()) == false) goto L49;
        String r17 = (String) CollectionsKt.firstOrNull(enumArguments(r10, false));
        if (r17 != null) goto L31;
    L47:
        r14 = NullabilityQualifier.NOT_NULL;
        goto L61
    L31:
        switch(r17.hashCode()) {
            case 73135176: goto L44;
            case 74175084: goto L41;
            case 433141802: goto L37;
            case 1933739535: goto L34;
            default: goto L45;
        };
    L45:
        return null;
    L34:
        if (r17.equals("ALWAYS") == false) goto L45;
    L37:
        if (r17.equals("UNKNOWN") == false) goto L45;
        r14 = NullabilityQualifier.FORCE_FLEXIBILITY;
        goto L61
    L41:
        if (r17.equals("NEVER") == false) goto L45;
    L46:
        r14 = NullabilityQualifier.NULLABLE;
        goto L61
    L44:
        if (r17.equals("MAYBE") == true) goto L46;
    L49:
        if (Intrinsics.areEqual(r5, JvmAnnotationNamesKt.getCOMPATQUAL_NULLABLE_ANNOTATION()) == false) goto L52;
        r14 = NullabilityQualifier.NULLABLE;
        goto L61
    L52:
        if (Intrinsics.areEqual(r5, JvmAnnotationNamesKt.getCOMPATQUAL_NONNULL_ANNOTATION()) == false) goto L55;
        r14 = NullabilityQualifier.NOT_NULL;
        goto L61
    L55:
        if (Intrinsics.areEqual(r5, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NON_NULL_ANNOTATION()) == false) goto L58;
        r14 = NullabilityQualifier.NOT_NULL;
        goto L61
    L58:
        if (Intrinsics.areEqual(r5, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NULLABLE_ANNOTATION()) == false) goto L66;
        r14 = NullabilityQualifier.NULLABLE;
        goto L61
    L66:
        return null;
    L23:
        r16 = Intrinsics.areEqual(r5, JvmAnnotationNamesKt.getJSPECIFY_NULLNESS_UNKNOWN());
        goto L24
    L17:
        r15 = Intrinsics.areEqual(r5, JvmAnnotationNamesKt.getJSPECIFY_NULLABLE());
        goto L18
    }

    private final ReportLevel resolveDefaultAnnotationState(TAnnotation r5) {
        FqName r10 = getFqName(r5);
        if (r10 == null) goto L9;
        if (AnnotationQualifiersFqNamesKt.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(r10) == false) goto L9;
        return this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(r10);
    L9:
        return resolveJsr305AnnotationState(r5);
    }

    private final ReportLevel resolveJsr305AnnotationState(TAnnotation r5) {
        ReportLevel r10 = resolveJsr305CustomState(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.javaTypeEnhancementState.getJsr305().getGlobalLevel();
    }

    private final ReportLevel resolveJsr305CustomState(TAnnotation r5) {
        ReportLevel r10 = this.javaTypeEnhancementState.getJsr305().getUserDefinedLevelForSpecificAnnotation().get(getFqName(r5));
        if (r10 == null) goto L5;
        return r10;
    L5:
        TAnnotation r11 = findAnnotation(r5, AnnotationQualifiersFqNamesKt.getMIGRATION_ANNOTATION_FQNAME());
        if (r11 == null) goto L35;
        Iterable<String> r12 = enumArguments(r11, false);
        if (r12 == null) goto L36;
        String r13 = (String) CollectionsKt.firstOrNull(r12);
        if (r13 == null) goto L40;
        ReportLevel r14 = this.javaTypeEnhancementState.getJsr305().getMigrationLevel();
        if (r14 != null) goto L34;
        int r15 = r13.hashCode();
        if (r15 == (-2137067054)) goto L30;
        if (r15 == (-1838656823)) goto L26;
        if (r15 == 2656902) goto L22;
        return null;
    L22:
        if (r13.equals("WARN") == true) goto L37;
        return null;
    L37:
        return ReportLevel.WARN;
    L26:
        if (r13.equals("STRICT") == true) goto L38;
        return null;
    L38:
        return ReportLevel.STRICT;
    L30:
        if (r13.equals("IGNORE") == true) goto L39;
        return null;
    L39:
        return ReportLevel.IGNORE;
    L34:
        return r14;
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
        JavaDefaultQualifiers r5 = AnnotationQualifiersFqNamesKt.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(getFqName(r10));
        if (r5 == null) goto L15;
        ReportLevel r11 = resolveDefaultAnnotationState(r10);
        if (r11 != ReportLevel.IGNORE) goto L11;
        r11 = null;
    L11:
        if (r11 != null) goto L14;
        return null;
    L14:
        return JavaDefaultQualifiers.copy$default(r5, NullabilityQualifierWithMigrationStatus.copy$default(r5.getNullabilityQualifier(), null, r11.isWarning(), 1, null), null, false, 6, null);
    L15:
        return null;
    }

    private final Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> resolveTypeQualifierDefaultAnnotation(TAnnotation r5) {
        if (this.javaTypeEnhancementState.getJsr305().isDisabled() == false) goto L5;
        return null;
    L5:
        TAnnotation r10 = findAnnotation(r5, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_DEFAULT_FQNAME());
        if (r10 != null) goto L8;
        return null;
    L8:
        Iterator<TAnnotation> r11 = getMetaAnnotations(r5).iterator();
    L10:
        if (r11.hasNext() == false) goto L14;
        TAnnotation r12 = r11.next();
        if (resolveTypeQualifierAnnotation(r12) == null) goto L10;
    L15:
        if (r12 != null) goto L17;
        return null;
    L17:
        Iterable<String> r13 = enumArguments(r10, true);
        LinkedHashSet r14 = new LinkedHashSet();
        Iterator<String> r15 = r13.iterator();
    L19:
        if (r15.hasNext() == false) goto L24;
        AnnotationQualifierApplicabilityType r16 = JAVA_APPLICABILITY_TYPES.get(r15.next());
        if (r16 == null) goto L19;
        r14.add(r16);
        goto L19
    L24:
        return new Pair(r12, allIfTypeUse(r14));
    L14:
        r12 = null;
        goto L15
    }

    public abstract Iterable<String> enumArguments(TAnnotation r5, boolean r10);

    public final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(JavaTypeQualifiersByElementType r5, Iterable<? extends TAnnotation> r10) {
        Intrinsics.checkNotNullParameter(r10, "annotations");
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations() == false) goto L5;
        return r5;
    L5:
        ArrayList r11 = new ArrayList();
        Iterator<? extends TAnnotation> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        JavaDefaultQualifiers r13 = extractDefaultQualifiers(r12.next());
        if (r13 == null) goto L7;
        r11.add(r13);
        goto L7
    L12:
        if (r11.isEmpty() == false) goto L14;
        return r5;
    L14:
        if (r5 == null) goto L18;
        EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> r14 = r5.getDefaultQualifiers();
        if (r14 == null) goto L18;
        EnumMap r15 = new EnumMap(r14);
    L19:
        Iterator r16 = r11.iterator();
        boolean r17 = false;
    L21:
        if (r16.hasNext() == false) goto L26;
        JavaDefaultQualifiers r18 = (JavaDefaultQualifiers) r16.next();
        Iterator<AnnotationQualifierApplicabilityType> r19 = r18.getQualifierApplicabilityTypes().iterator();
    L24:
        if (r19.hasNext() == false) goto L21;
        r15.put(r19.next(), r18);
        r17 = true;
        goto L24
    L26:
        if (r17 == true) goto L29;
        return r5;
    L29:
        return new JavaTypeQualifiersByElementType(r15);
    L18:
        r15 = new EnumMap(AnnotationQualifierApplicabilityType.class);
        goto L19
    }

    public final MutabilityQualifier extractMutability(Iterable<? extends TAnnotation> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        Iterator<? extends TAnnotation> r10 = r5.iterator();
        MutabilityQualifier r11 = null;
    L4:
        if (r10.hasNext() == false) goto L15;
        FqName r12 = getFqName(r10.next());
        if (JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS().contains(r12) == true) goto L7;
        if (JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS().contains(r12) == false) goto L4;
        MutabilityQualifier r13 = MutabilityQualifier.MUTABLE;
    L11:
        if (r11 == null) goto L14;
        if (r11 == r13) goto L14;
        return null;
    L14:
        r11 = r13;
        goto L4
    L7:
        r13 = MutabilityQualifier.READ_ONLY;
        goto L11
    L15:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final NullabilityQualifierWithMigrationStatus extractNullability(Iterable<? extends TAnnotation> r5, Function1<? super TAnnotation, Boolean> r10) {
        Iterator r11 = a.k(r5, "annotations", r10, "forceWarning");
        NullabilityQualifierWithMigrationStatus r12 = null;
    L4:
        if (r11.hasNext() == false) goto L23;
        NullabilityQualifierWithMigrationStatus r13 = extractNullability(r11.next(), r10);
        if (r12 == null) goto L21;
        if (r13 == null) goto L4;
        if (Intrinsics.areEqual(r13, r12) == true) goto L4;
        if (r13.isForWarningOnly() == false) goto L18;
        if (r12.isForWarningOnly() == false) goto L4;
    L18:
        if (r13.isForWarningOnly() == true) goto L22;
        if (r12.isForWarningOnly() == true) goto L21;
    L22:
        return null;
    L21:
        r12 = r13;
        goto L4
    L23:
        return r12;
    }

    public abstract FqName getFqName(TAnnotation r5);

    public abstract Object getKey(TAnnotation r5);

    public abstract Iterable<TAnnotation> getMetaAnnotations(TAnnotation r5);

    public final boolean isTypeUseAnnotation(TAnnotation r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        TAnnotation r10 = findAnnotation(r5, StandardNames.FqNames.target);
        if (r10 != null) goto L5;
        return false;
    L5:
        Iterable<String> r11 = enumArguments(r10, false);
        if ((r11 instanceof Collection) == true) goto L8;
    L10:
        Iterator<String> r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(r12.next(), KotlinTarget.TYPE.name()) == false) goto L12;
        return true;
    L21:
        return false;
    L8:
        if (((Collection) r11).isEmpty() == false) goto L10;
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
        ConcurrentHashMap<Object, TAnnotation> r10 = this.resolvedNicknames;
        Object r11 = getKey(r5);
        TAnnotation r12 = r10.get(r11);
        if (r12 != null) goto L33;
        Iterator<TAnnotation> r13 = getMetaAnnotations(r5).iterator();
    L17:
        if (r13.hasNext() == false) goto L21;
        TAnnotation r14 = resolveTypeQualifierAnnotation(r13.next());
        if (r14 == null) goto L17;
    L22:
        if (r14 != null) goto L24;
        return null;
    L24:
        TAnnotation r15 = r10.putIfAbsent(r11, r14);
        if (r15 != null) goto L28;
        return r14;
    L28:
        return r15;
    L21:
        r14 = null;
        goto L22
    L33:
        return r12;
    }

    private final NullabilityQualifierWithMigrationStatus extractNullability(TAnnotation r5, Function1<? super TAnnotation, Boolean> r10) {
        NullabilityQualifierWithMigrationStatus r11 = knownNullability(r5, r10.invoke(r5).booleanValue());
        if (r11 == null) goto L5;
        return r11;
    L5:
        TAnnotation r12 = resolveTypeQualifierAnnotation(r5);
        if (r12 != null) goto L8;
        return null;
    L8:
        ReportLevel r13 = resolveJsr305AnnotationState(r5);
        if (r13.isIgnore() == false) goto L11;
        return null;
    L11:
        NullabilityQualifierWithMigrationStatus r14 = knownNullability(r12, r10.invoke(r12).booleanValue());
        if (r14 != null) goto L14;
        return null;
    L14:
        return NullabilityQualifierWithMigrationStatus.copy$default(r14, null, r13.isWarning(), 1, null);
    }
}
