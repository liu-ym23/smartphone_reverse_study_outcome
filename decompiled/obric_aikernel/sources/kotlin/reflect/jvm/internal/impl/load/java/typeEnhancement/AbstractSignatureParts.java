package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractSignatureParts<TAnnotation> {

    private static final class TypeAndDefaultQualifiers {
        private final JavaTypeQualifiersByElementType defaultQualifiers;
        private final KotlinTypeMarker type;
        private final TypeParameterMarker typeParameterForArgument;

        public TypeAndDefaultQualifiers(KotlinTypeMarker r10, JavaTypeQualifiersByElementType r11, TypeParameterMarker r12) {
            this.type = r10;
            this.defaultQualifiers = r11;
            this.typeParameterForArgument = r12;
        }

        public final JavaTypeQualifiersByElementType getDefaultQualifiers() {
            return this.defaultQualifiers;
        }

        public final KotlinTypeMarker getType() {
            return this.type;
        }

        public final TypeParameterMarker getTypeParameterForArgument() {
            return this.typeParameterForArgument;
        }
    }

    public AbstractSignatureParts() {
    }

    public static final /* synthetic */ JavaTypeQualifiersByElementType access$extractAndMergeDefaultQualifiers(AbstractSignatureParts r10, KotlinTypeMarker r11, JavaTypeQualifiersByElementType r12) {
        return r10.extractAndMergeDefaultQualifiers(r11, r12);
    }

    private final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(KotlinTypeMarker r10, JavaTypeQualifiersByElementType r11) {
        return getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(r11, getAnnotations(r10));
    }

    private final JavaTypeQualifiers extractQualifiers(KotlinTypeMarker r10) {
        NullabilityQualifier r11 = getNullabilityQualifier(r10);
        MutabilityQualifier r12 = null;
        if (r11 != null) goto L8;
        KotlinTypeMarker r13 = getEnhancedForWarnings(r10);
        if (r13 == null) goto L7;
        NullabilityQualifier r14 = getNullabilityQualifier(r13);
    L9:
        TypeSystemContext r15 = getTypeSystem();
        JavaToKotlinClassMap r16 = JavaToKotlinClassMap.INSTANCE;
        if (r16.isReadOnly(getFqNameUnsafe(r15.lowerBoundIfFlexible(r10))) == false) goto L13;
        r12 = MutabilityQualifier.READ_ONLY;
    L15:
        boolean r17 = false;
        if (getTypeSystem().isDefinitelyNotNullType(r10) == false) goto L18;
    L21:
        boolean r18 = true;
    L23:
        if (r14 == r11) goto L26;
        r17 = true;
    L26:
        return new JavaTypeQualifiers(r14, r12, r18, r17);
    L18:
        if (isNotNullTypeParameterCompat(r10) == true) goto L21;
        r18 = false;
        goto L23
    L13:
        if (r16.isMutable(getFqNameUnsafe(r15.upperBoundIfFlexible(r10))) == false) goto L15;
        r12 = MutabilityQualifier.MUTABLE;
        goto L15
    L7:
        r14 = null;
        goto L9
    L8:
        r14 = r11;
        goto L9
    }

    private final JavaTypeQualifiers extractQualifiersFromAnnotations(TypeAndDefaultQualifiers r12) {
        NullabilityQualifier r10 = null;
        if (r12.getType() != null) goto L12;
        TypeSystemContext r11 = getTypeSystem();
        TypeParameterMarker r13 = r12.getTypeParameterForArgument();
        if (r13 == null) goto L7;
        TypeVariance r14 = r11.getVariance(r13);
    L9:
        if (r14 != TypeVariance.IN) goto L12;
        return JavaTypeQualifiers.Companion.getNONE();
    L7:
        r14 = null;
    L12:
        boolean r15 = true;
        if (r12.getTypeParameterForArgument() != null) goto L15;
        boolean r16 = true;
    L16:
        KotlinTypeMarker r17 = r12.getType();
        if (r17 == null) goto L20;
        Iterable<TAnnotation> r18 = getAnnotations(r17);
        if (r18 == null) goto L20;
    L21:
        TypeSystemContext r19 = getTypeSystem();
        KotlinTypeMarker r20 = r12.getType();
        if (r20 == null) goto L26;
        TypeConstructorMarker r21 = r19.typeConstructor(r20);
        if (r21 == null) goto L26;
        TypeParameterMarker r22 = r19.getTypeParameterClassifier(r21);
    L28:
        if (getContainerApplicabilityType() != AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS) goto L30;
        boolean r23 = true;
    L31:
        if (r16 == false) goto L51;
        if (r23 == false) goto L35;
    L50:
        r18 = CollectionsKt.plus(getContainerAnnotations(), r18);
        goto L51
    L35:
        if (getEnableImprovementsInStrictMode() == false) goto L50;
        KotlinTypeMarker r24 = r12.getType();
        if (r24 != null) goto L39;
    L41:
        boolean r25 = false;
    L42:
        if (r25 == false) goto L50;
        Iterable<TAnnotation> r26 = getContainerAnnotations();
        ArrayList r27 = new ArrayList();
        Iterator<TAnnotation> r28 = r26.iterator();
    L45:
        if (r28.hasNext() == false) goto L49;
        TAnnotation r29 = r28.next();
        if ((!getAnnotationTypeQualifierResolver().isTypeUseAnnotation(r29)) == false) goto L45;
        r27.add(r29);
        goto L45
    L49:
        r18 = CollectionsKt.plus(r27, r18);
        goto L51
    L39:
        if (isArrayOrPrimitiveArray(r24) != true) goto L41;
        r25 = true;
    L51:
        MutabilityQualifier r30 = getAnnotationTypeQualifierResolver().extractMutability(r18);
        NullabilityQualifierWithMigrationStatus r31 = getAnnotationTypeQualifierResolver().extractNullability(r18, new AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1(this));
        if (r31 == null) goto L60;
        NullabilityQualifier r110 = r31.getQualifier();
        if (r31.getQualifier() != NullabilityQualifier.NOT_NULL) goto L57;
        if (r22 == null) goto L57;
    L59:
        return new JavaTypeQualifiers(r110, r30, r15, r31.isForWarningOnly());
    L57:
        r15 = false;
        goto L59
    L60:
        if (r16 == true) goto L64;
        if (r23 == true) goto L64;
        AnnotationQualifierApplicabilityType r32 = AnnotationQualifierApplicabilityType.TYPE_USE;
    L65:
        JavaTypeQualifiersByElementType r33 = r12.getDefaultQualifiers();
        if (r33 == null) goto L68;
        JavaDefaultQualifiers r34 = r33.get(r32);
    L69:
        if (r22 == null) goto L71;
        NullabilityQualifierWithMigrationStatus r35 = getBoundsNullability(r22);
    L73:
        if (r35 == null) goto L76;
        NullabilityQualifierWithMigrationStatus r36 = NullabilityQualifierWithMigrationStatus.copy$default(r35, NullabilityQualifier.NOT_NULL, false, 2, null);
        if (r36 == null) goto L76;
    L79:
        if (r35 == null) goto L81;
        NullabilityQualifier r37 = r35.getQualifier();
    L83:
        if (r37 == NullabilityQualifier.NOT_NULL) goto L93;
        if (r22 == null) goto L92;
        if (r34 != null) goto L87;
    L89:
        boolean r38 = false;
    L90:
        if (r38 == false) goto L92;
    L87:
        if (r34.getDefinitelyNotNull() != true) goto L89;
        r38 = true;
    L92:
        boolean r39 = false;
    L94:
        TypeParameterMarker r111 = r12.getTypeParameterForArgument();
        if (r111 == null) goto L101;
        NullabilityQualifierWithMigrationStatus r112 = getBoundsNullability(r111);
        if (r112 == null) goto L101;
        if (r112.getQualifier() != NullabilityQualifier.NULLABLE) goto L102;
        r112 = NullabilityQualifierWithMigrationStatus.copy$default(r112, NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null);
    L102:
        NullabilityQualifierWithMigrationStatus r113 = mostSpecific(r112, r36);
        if (r113 == null) goto L105;
        r10 = r113.getQualifier();
    L105:
        if (r113 != null) goto L107;
    L109:
        r15 = false;
    L111:
        return new JavaTypeQualifiers(r10, r30, r39, r15);
    L107:
        if (r113.isForWarningOnly() != true) goto L109;
    L101:
        r112 = null;
    L93:
        r39 = true;
        goto L94
    L81:
        r37 = null;
    L76:
        if (r34 == null) goto L78;
        r36 = r34.getNullabilityQualifier();
        goto L79
    L78:
        r36 = null;
        goto L79
    L71:
        r35 = null;
        goto L73
    L68:
        r34 = null;
    L64:
        r32 = getContainerApplicabilityType();
        goto L65
    L30:
        r23 = false;
    L26:
        r22 = null;
    L20:
        r18 = CollectionsKt.emptyList();
        goto L21
    L15:
        r16 = false;
        goto L16
    }

    private final <T> List<T> flattenTree(T r10, Function1<? super T, ? extends Iterable<? extends T>> r11) {
        ArrayList r12 = new ArrayList(1);
        flattenTree(r10, r12, r11);
        return r12;
    }

    private final <T> void flattenTree(T r10, List<T> r11, Function1<? super T, ? extends Iterable<? extends T>> r12) {
        r11.add(r10);
        Iterable<? extends T> r13 = r12.invoke(r10);
        if (r13 == null) goto L8;
        Iterator<? extends T> r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L10;
        flattenTree(r14.next(), r11, r12);
        goto L6
    L10:
        return;
    }

    private final NullabilityQualifierWithMigrationStatus getBoundsNullability(TypeParameterMarker r10) {
        TypeSystemContext r11 = getTypeSystem();
        if (isFromJava(r10) == true) goto L5;
        return null;
    L5:
        List<KotlinTypeMarker> r12 = r11.getUpperBounds(r10);
        boolean r13 = r12 instanceof Collection;
        boolean r14 = false;
        if (r13 == true) goto L8;
    L10:
        Iterator<T> r15 = r12.iterator();
    L12:
        if (r15.hasNext() == false) goto L9;
        if (r11.isError((KotlinTypeMarker) r15.next()) == true) goto L12;
        boolean r16 = false;
    L16:
        if (r16 == false) goto L18;
        return null;
    L18:
        if (r13 == true) goto L20;
    L22:
        Iterator<T> r17 = r12.iterator();
    L24:
        if (r17.hasNext() == false) goto L21;
        if (getNullabilityQualifier((KotlinTypeMarker) r17.next()) == null) goto L28;
        boolean r18 = true;
    L29:
        if (r18 == false) goto L24;
        boolean r19 = true;
    L31:
        if (r19 == false) goto L33;
        List<KotlinTypeMarker> r20 = r12;
    L54:
        if ((r20 instanceof Collection) == true) goto L56;
    L58:
        Iterator<T> r21 = r20.iterator();
    L60:
        if (r21.hasNext() == false) goto L57;
        if (r11.isNullableType((KotlinTypeMarker) r21.next()) == true) goto L60;
        boolean r22 = false;
    L64:
        if (r22 == false) goto L66;
        NullabilityQualifier r23 = NullabilityQualifier.NULLABLE;
    L68:
        if (r20 == r12) goto L71;
        r14 = true;
    L71:
        return new NullabilityQualifierWithMigrationStatus(r23, r14);
    L66:
        r23 = NullabilityQualifier.NOT_NULL;
    L57:
        r22 = true;
        goto L64
    L56:
        if (r20.isEmpty() == false) goto L58;
    L33:
        if (r13 == true) goto L35;
    L37:
        Iterator<T> r24 = r12.iterator();
    L39:
        if (r24.hasNext() == false) goto L36;
        if (getEnhancedForWarnings((KotlinTypeMarker) r24.next()) == null) goto L43;
        boolean r25 = true;
    L44:
        if (r25 == false) goto L39;
        boolean r26 = true;
    L46:
        if (r26 == false) goto L72;
        r20 = new ArrayList();
        Iterator<T> r27 = r12.iterator();
    L49:
        if (r27.hasNext() == false) goto L54;
        KotlinTypeMarker r28 = getEnhancedForWarnings((KotlinTypeMarker) r27.next());
        if (r28 == null) goto L49;
        r20.add(r28);
        goto L49
    L72:
        return null;
    L43:
        r25 = false;
    L36:
        r26 = false;
        goto L46
    L35:
        if (r12.isEmpty() == false) goto L37;
    L28:
        r18 = false;
    L21:
        r19 = false;
        goto L31
    L20:
        if (r12.isEmpty() == false) goto L22;
    L9:
        r16 = true;
        goto L16
    L8:
        if (r12.isEmpty() == false) goto L10;
        goto L9
    }

    private final NullabilityQualifier getNullabilityQualifier(KotlinTypeMarker r10) {
        TypeSystemContext r11 = getTypeSystem();
        if (r11.isMarkedNullable(r11.lowerBoundIfFlexible(r10)) == false) goto L6;
        return NullabilityQualifier.NULLABLE;
    L6:
        if (r11.isMarkedNullable(r11.upperBoundIfFlexible(r10)) == false) goto L11;
        return null;
    L11:
        return NullabilityQualifier.NOT_NULL;
    }

    private final NullabilityQualifierWithMigrationStatus mostSpecific(NullabilityQualifierWithMigrationStatus r10, NullabilityQualifierWithMigrationStatus r11) {
        if (r10 != null) goto L4;
        return r11;
    L4:
        if (r11 != null) goto L7;
        return r10;
    L7:
        if (r10.isForWarningOnly() == false) goto L12;
        if (r11.isForWarningOnly() == true) goto L12;
        return r11;
    L12:
        if (r10.isForWarningOnly() == true) goto L17;
        if (r11.isForWarningOnly() == false) goto L17;
        return r10;
    L17:
        if (r10.getQualifier().compareTo(r11.getQualifier()) >= 0) goto L20;
        return r11;
    L20:
        if (r10.getQualifier().compareTo(r11.getQualifier()) <= 0) goto L22;
        return r10;
    L22:
        return r11;
    }

    private final List<TypeAndDefaultQualifiers> toIndexed(KotlinTypeMarker r10) {
        final TypeSystemContext r11 = getTypeSystem();
        return flattenTree(new TypeAndDefaultQualifiers(r10, extractAndMergeDefaultQualifiers(r10, getContainerDefaultTypeQualifiers()), null), new AbstractSignatureParts$toIndexed$1$1(this, r11));
    }

    public final Function1<Integer, JavaTypeQualifiers> computeIndexedQualifiers(KotlinTypeMarker r10, Iterable<? extends KotlinTypeMarker> r11, final TypeEnhancementInfo r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "overrides");
        List<TypeAndDefaultQualifiers> r14 = toIndexed(r10);
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<? extends KotlinTypeMarker> r16 = r11.iterator();
    L4:
        if (r16.hasNext() == false) goto L7;
        r15.add(toIndexed(r16.next()));
        goto L4
    L7:
        if (getForceOnlyHeadTypeConstructor() == false) goto L9;
    L24:
        boolean r17 = true;
    L25:
        if (r17 == false) goto L27;
        int r18 = 1;
    L28:
        final JavaTypeQualifiers[] r19 = new JavaTypeQualifiers[r18];
        int r20 = 0;
    L29:
        if (r20 >= r18) goto L53;
        JavaTypeQualifiers r21 = extractQualifiersFromAnnotations(r14.get(r20));
        ArrayList r22 = new ArrayList();
        Iterator r23 = r15.iterator();
    L32:
        if (r23.hasNext() == false) goto L41;
        TypeAndDefaultQualifiers r24 = (TypeAndDefaultQualifiers) CollectionsKt.getOrNull((List) r23.next(), r20);
        if (r24 == null) goto L38;
        KotlinTypeMarker r25 = r24.getType();
        if (r25 == null) goto L38;
        JavaTypeQualifiers r26 = extractQualifiers(r25);
    L39:
        if (r26 == null) goto L32;
        r22.add(r26);
    L38:
        r26 = null;
        goto L39
    L41:
        if (r20 == 0) goto L43;
    L45:
        boolean r27 = false;
    L46:
        if (r20 == 0) goto L48;
    L50:
        boolean r28 = false;
    L51:
        r19[r20] = TypeEnhancementUtilsKt.computeQualifiersForOverride(r21, r22, r27, r28, r13);
        r20 = r20 + 1;
        goto L29
    L48:
        if (getContainerIsVarargParameter() == false) goto L50;
        r28 = true;
        goto L51
    L43:
        if (isCovariant() == false) goto L45;
        r27 = true;
        goto L46
    L53:
        return new AnonymousClass1(r12, r19);
    L27:
        r18 = r14.size();
        goto L28
    L9:
        if (isCovariant() == true) goto L11;
    L23:
        r17 = false;
        goto L25
    L11:
        if ((r11 instanceof Collection) == true) goto L13;
    L15:
        Iterator<? extends KotlinTypeMarker> r110 = r11.iterator();
    L17:
        if (r110.hasNext() == false) goto L14;
        if ((!isEqual(r10, r110.next())) == false) goto L17;
        boolean r111 = true;
    L21:
        if (r111 == false) goto L23;
    L14:
        r111 = false;
        goto L21
    L13:
        if (((Collection) r11).isEmpty() == false) goto L15;
        goto L14
    }

    public abstract AbstractAnnotationTypeQualifierResolver<TAnnotation> getAnnotationTypeQualifierResolver();

    public abstract Iterable<TAnnotation> getAnnotations(KotlinTypeMarker r10);

    public abstract Iterable<TAnnotation> getContainerAnnotations();

    public abstract AnnotationQualifierApplicabilityType getContainerApplicabilityType();

    public abstract JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers();

    public abstract boolean getContainerIsVarargParameter();

    public abstract boolean getEnableImprovementsInStrictMode();

    public abstract KotlinTypeMarker getEnhancedForWarnings(KotlinTypeMarker r10);

    public boolean getForceOnlyHeadTypeConstructor() {
        return false;
    }

    public abstract boolean getForceWarning(TAnnotation r10);

    public abstract FqNameUnsafe getFqNameUnsafe(KotlinTypeMarker r10);

    public abstract boolean getSkipRawTypeArguments();

    public abstract TypeSystemContext getTypeSystem();

    public abstract boolean isArrayOrPrimitiveArray(KotlinTypeMarker r10);

    public abstract boolean isCovariant();

    public abstract boolean isEqual(KotlinTypeMarker r10, KotlinTypeMarker r11);

    public abstract boolean isFromJava(TypeParameterMarker r10);

    public boolean isNotNullTypeParameterCompat(KotlinTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return false;
    }
}
