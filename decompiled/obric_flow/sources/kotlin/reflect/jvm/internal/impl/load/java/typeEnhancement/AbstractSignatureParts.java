package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nAbstractSignatureParts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSignatureParts.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/AbstractSignatureParts\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,228:1\n1#2:229\n1#2:252\n1#2:275\n766#3:230\n857#3,2:231\n1726#3,3:233\n1747#3,3:236\n1747#3,3:239\n1603#3,9:242\n1855#3:251\n1856#3:253\n1612#3:254\n1726#3,3:255\n1549#3:258\n1620#3,3:259\n1747#3,3:262\n1603#3,9:265\n1855#3:274\n1856#3:276\n1612#3:277\n1855#3,2:278\n*S KotlinDebug\n*F\n+ 1 AbstractSignatureParts.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/AbstractSignatureParts\n*L\n156#1:252\n182#1:275\n89#1:230\n89#1:231,2\n153#1:233,3\n155#1:236,3\n156#1:239,3\n156#1:242,9\n156#1:251\n156#1:253\n156#1:254\n159#1:255,3\n169#1:258\n169#1:259,3\n177#1:262,3\n182#1:265,9\n182#1:274\n182#1:276\n182#1:277\n195#1:278,2\n*E\n"})
public abstract class AbstractSignatureParts<TAnnotation> {

    public static final class TypeAndDefaultQualifiers {
        private final JavaTypeQualifiersByElementType defaultQualifiers;
        private final KotlinTypeMarker type;
        private final TypeParameterMarker typeParameterForArgument;

        public TypeAndDefaultQualifiers(KotlinTypeMarker r5, JavaTypeQualifiersByElementType r10, TypeParameterMarker r11) {
            this.type = r5;
            this.defaultQualifiers = r10;
            this.typeParameterForArgument = r11;
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

    public static final /* synthetic */ JavaTypeQualifiersByElementType access$extractAndMergeDefaultQualifiers(AbstractSignatureParts r5, KotlinTypeMarker r10, JavaTypeQualifiersByElementType r11) {
        return r5.extractAndMergeDefaultQualifiers(r10, r11);
    }

    private final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(KotlinTypeMarker r5, JavaTypeQualifiersByElementType r10) {
        return getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(r10, getAnnotations(r5));
    }

    private final JavaTypeQualifiers extractQualifiers(KotlinTypeMarker r10) {
        NullabilityQualifier r5 = getNullabilityQualifier(r10);
        MutabilityQualifier r11 = null;
        if (r5 != null) goto L8;
        KotlinTypeMarker r12 = getEnhancedForWarnings(r10);
        if (r12 == null) goto L7;
        NullabilityQualifier r13 = getNullabilityQualifier(r12);
    L9:
        TypeSystemContext r14 = getTypeSystem();
        JavaToKotlinClassMap r15 = JavaToKotlinClassMap.INSTANCE;
        if (r15.isReadOnly(getFqNameUnsafe(r14.lowerBoundIfFlexible(r10))) == false) goto L13;
        r11 = MutabilityQualifier.READ_ONLY;
    L15:
        boolean r16 = true;
        if (getTypeSystem().isDefinitelyNotNullType(r10) == false) goto L18;
    L21:
        boolean r17 = true;
    L23:
        if (r13 != r5) goto L27;
        r16 = false;
    L27:
        return new JavaTypeQualifiers(r13, r11, r17, r16);
    L18:
        if (isNotNullTypeParameterCompat(r10) == true) goto L21;
        r17 = false;
        goto L23
    L13:
        if (r15.isMutable(getFqNameUnsafe(r14.upperBoundIfFlexible(r10))) == false) goto L15;
        r11 = MutabilityQualifier.MUTABLE;
        goto L15
    L7:
        r13 = null;
        goto L9
    L8:
        r13 = r5;
        goto L9
    }

    private final JavaTypeQualifiers extractQualifiersFromAnnotations(final TypeAndDefaultQualifiers r12) {
        NullabilityQualifier r5 = null;
        if (r12.getType() != null) goto L12;
        TypeSystemContext r10 = getTypeSystem();
        TypeParameterMarker r11 = r12.getTypeParameterForArgument();
        if (r11 == null) goto L7;
        TypeVariance r13 = r10.getVariance(r11);
    L9:
        if (r13 != TypeVariance.IN) goto L12;
        return JavaTypeQualifiers.Companion.getNONE();
    L7:
        r13 = null;
    L12:
        boolean r14 = false;
        if (r12.getTypeParameterForArgument() != null) goto L15;
        boolean r15 = true;
    L16:
        KotlinTypeMarker r16 = r12.getType();
        if (r16 == null) goto L20;
        Iterable<TAnnotation> r17 = getAnnotations(r16);
        if (r17 == null) goto L20;
    L21:
        TypeSystemContext r18 = getTypeSystem();
        KotlinTypeMarker r19 = r12.getType();
        if (r19 == null) goto L26;
        TypeConstructorMarker r20 = r18.typeConstructor(r19);
        if (r20 == null) goto L26;
        TypeParameterMarker r21 = r18.getTypeParameterClassifier(r20);
    L28:
        if (getContainerApplicabilityType() != AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS) goto L30;
        boolean r22 = true;
    L31:
        if (r15 == false) goto L48;
        if (r22 == false) goto L35;
    L47:
        r17 = CollectionsKt.plus(getContainerAnnotations(), r17);
        goto L48
    L35:
        if (getEnableImprovementsInStrictMode() == false) goto L47;
        KotlinTypeMarker r23 = r12.getType();
        if (r23 == null) goto L47;
        if (isArrayOrPrimitiveArray(r23) != true) goto L47;
        Iterable<TAnnotation> r24 = getContainerAnnotations();
        ArrayList r25 = new ArrayList();
        Iterator<TAnnotation> r26 = r24.iterator();
    L42:
        if (r26.hasNext() == false) goto L46;
        TAnnotation r27 = r26.next();
        if (getAnnotationTypeQualifierResolver().isTypeUseAnnotation(r27) == true) goto L42;
        r25.add(r27);
        goto L42
    L46:
        r17 = CollectionsKt.plus(r25, r17);
    L48:
        MutabilityQualifier r28 = getAnnotationTypeQualifierResolver().extractMutability(r17);
        NullabilityQualifierWithMigrationStatus r29 = getAnnotationTypeQualifierResolver().extractNullability(r17, new AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1(this, r12));
        if (r29 == null) goto L56;
        NullabilityQualifier r110 = r29.getQualifier();
        if (r29.getQualifier() != NullabilityQualifier.NOT_NULL) goto L55;
        if (r21 == null) goto L55;
        r14 = true;
    L55:
        return new JavaTypeQualifiers(r110, r28, r14, r29.isForWarningOnly());
    L56:
        if (r15 == true) goto L60;
        if (r22 == true) goto L60;
        AnnotationQualifierApplicabilityType r30 = AnnotationQualifierApplicabilityType.TYPE_USE;
    L61:
        JavaTypeQualifiersByElementType r31 = r12.getDefaultQualifiers();
        if (r31 == null) goto L64;
        JavaDefaultQualifiers r32 = r31.get(r30);
    L65:
        if (r21 == null) goto L67;
        NullabilityQualifierWithMigrationStatus r33 = getBoundsNullability(r21);
    L69:
        if (r33 == null) goto L72;
        NullabilityQualifierWithMigrationStatus r34 = NullabilityQualifierWithMigrationStatus.copy$default(r33, NullabilityQualifier.NOT_NULL, false, 2, null);
        if (r34 == null) goto L72;
    L75:
        if (r33 == null) goto L77;
        NullabilityQualifier r35 = r33.getQualifier();
    L79:
        if (r35 == NullabilityQualifier.NOT_NULL) goto L86;
        if (r21 == null) goto L85;
        if (r32 == null) goto L85;
        if (r32.getDefinitelyNotNull() == true) goto L86;
    L85:
        boolean r36 = false;
    L87:
        TypeParameterMarker r111 = r12.getTypeParameterForArgument();
        if (r111 == null) goto L94;
        NullabilityQualifierWithMigrationStatus r112 = getBoundsNullability(r111);
        if (r112 == null) goto L94;
        if (r112.getQualifier() != NullabilityQualifier.NULLABLE) goto L95;
        r112 = NullabilityQualifierWithMigrationStatus.copy$default(r112, NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null);
    L95:
        NullabilityQualifierWithMigrationStatus r113 = mostSpecific(r112, r34);
        if (r113 == null) goto L98;
        r5 = r113.getQualifier();
    L98:
        if (r113 == null) goto L103;
        if (r113.isForWarningOnly() != true) goto L103;
        r14 = true;
    L103:
        return new JavaTypeQualifiers(r5, r28, r36, r14);
    L94:
        r112 = null;
    L86:
        r36 = true;
        goto L87
    L77:
        r35 = null;
    L72:
        if (r32 == null) goto L74;
        r34 = r32.getNullabilityQualifier();
        goto L75
    L74:
        r34 = null;
        goto L75
    L67:
        r33 = null;
        goto L69
    L64:
        r32 = null;
    L60:
        r30 = getContainerApplicabilityType();
        goto L61
    L30:
        r22 = false;
    L26:
        r21 = null;
    L20:
        r17 = CollectionsKt.emptyList();
        goto L21
    L15:
        r15 = false;
        goto L16
    }

    private final <T> void flattenTree(T r5, List<T> r10, Function1<? super T, ? extends Iterable<? extends T>> r11) {
        r10.add(r5);
        Iterable<? extends T> r12 = r11.invoke(r5);
        if (r12 == null) goto L8;
        Iterator<? extends T> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        flattenTree(r13.next(), r10, r11);
        goto L6
    L10:
        return;
    }

    private final NullabilityQualifierWithMigrationStatus getBoundsNullability(TypeParameterMarker r5) {
        TypeSystemContext r10 = getTypeSystem();
        if (isFromJava(r5) == true) goto L5;
        return null;
    L5:
        List<KotlinTypeMarker> r11 = r10.getUpperBounds(r5);
        if (r11 != null) goto L8;
    L10:
        Iterator<T> r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L57;
        if (r10.isError((KotlinTypeMarker) r12.next()) == true) goto L12;
        if (r11 != null) goto L17;
    L19:
        Iterator<T> r13 = r11.iterator();
    L21:
        if (r13.hasNext() == false) goto L25;
        if (getNullabilityQualifier((KotlinTypeMarker) r13.next()) == null) goto L21;
        List<KotlinTypeMarker> r14 = r11;
    L40:
        if (r14 != null) goto L42;
    L44:
        Iterator<T> r15 = r14.iterator();
    L46:
        if (r15.hasNext() == false) goto L50;
        if (r10.isNullableType((KotlinTypeMarker) r15.next()) == true) goto L46;
        NullabilityQualifier r16 = NullabilityQualifier.NOT_NULL;
    L52:
        if (r14 == r11) goto L54;
        boolean r17 = true;
    L56:
        return new NullabilityQualifierWithMigrationStatus(r16, r17);
    L54:
        r17 = false;
    L50:
        r16 = NullabilityQualifier.NULLABLE;
        goto L52
    L42:
        if (r14.isEmpty() == false) goto L44;
    L25:
        if (r11 != null) goto L27;
    L29:
        Iterator<T> r18 = r11.iterator();
    L31:
        if (r18.hasNext() == false) goto L57;
        if (getEnhancedForWarnings((KotlinTypeMarker) r18.next()) == null) goto L31;
        r14 = new ArrayList();
        Iterator<T> r19 = r11.iterator();
    L36:
        if (r19.hasNext() == false) goto L40;
        KotlinTypeMarker r20 = getEnhancedForWarnings((KotlinTypeMarker) r19.next());
        if (r20 == null) goto L36;
        r14.add(r20);
        goto L36
    L27:
        if (r11.isEmpty() == false) goto L29;
    L17:
        if (r11.isEmpty() == false) goto L19;
    L57:
        return null;
    L8:
        if (r11.isEmpty() == false) goto L10;
        goto L10
    }

    private final NullabilityQualifier getNullabilityQualifier(KotlinTypeMarker r5) {
        TypeSystemContext r10 = getTypeSystem();
        if (r10.isMarkedNullable(r10.lowerBoundIfFlexible(r5)) == false) goto L6;
        return NullabilityQualifier.NULLABLE;
    L6:
        if (r10.isMarkedNullable(r10.upperBoundIfFlexible(r5)) == false) goto L11;
        return null;
    L11:
        return NullabilityQualifier.NOT_NULL;
    }

    private final NullabilityQualifierWithMigrationStatus mostSpecific(NullabilityQualifierWithMigrationStatus r5, NullabilityQualifierWithMigrationStatus r10) {
        if (r5 != null) goto L4;
        return r10;
    L4:
        if (r10 != null) goto L7;
        return r5;
    L7:
        if (r5.isForWarningOnly() == false) goto L12;
        if (r10.isForWarningOnly() == true) goto L12;
        return r10;
    L12:
        if (r5.isForWarningOnly() == true) goto L17;
        if (r10.isForWarningOnly() == false) goto L17;
        return r5;
    L17:
        if (r5.getQualifier().compareTo(r10.getQualifier()) >= 0) goto L20;
        return r10;
    L20:
        if (r5.getQualifier().compareTo(r10.getQualifier()) <= 0) goto L22;
        return r5;
    L22:
        return r10;
    }

    private final List<TypeAndDefaultQualifiers> toIndexed(KotlinTypeMarker r5) {
        final TypeSystemContext r10 = getTypeSystem();
        return flattenTree(new TypeAndDefaultQualifiers(r5, extractAndMergeDefaultQualifiers(r5, getContainerDefaultTypeQualifiers()), null), new AbstractSignatureParts$toIndexed$1$1(this, r10));
    }

    public final Function1<Integer, JavaTypeQualifiers> computeIndexedQualifiers(KotlinTypeMarker r10, Iterable<? extends KotlinTypeMarker> r11, final TypeEnhancementInfo r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "overrides");
        List<TypeAndDefaultQualifiers> r5 = toIndexed(r10);
        ArrayList r14 = new ArrayList(CollectionsKt.h(r11));
        Iterator<? extends KotlinTypeMarker> r15 = r11.iterator();
    L4:
        if (r15.hasNext() == false) goto L7;
        r14.add(toIndexed(r15.next()));
        goto L4
    L7:
        if (getForceOnlyHeadTypeConstructor() == false) goto L9;
    L22:
        int r16 = 1;
    L23:
        final JavaTypeQualifiers[] r17 = new JavaTypeQualifiers[r16];
        int r18 = 0;
    L24:
        if (r18 >= r16) goto L48;
        JavaTypeQualifiers r19 = extractQualifiersFromAnnotations(r5.get(r18));
        ArrayList r20 = new ArrayList();
        Iterator r21 = r14.iterator();
    L27:
        if (r21.hasNext() == false) goto L36;
        TypeAndDefaultQualifiers r22 = (TypeAndDefaultQualifiers) CollectionsKt.getOrNull((List) r21.next(), r18);
        if (r22 == null) goto L33;
        KotlinTypeMarker r23 = r22.getType();
        if (r23 == null) goto L33;
        JavaTypeQualifiers r24 = extractQualifiers(r23);
    L34:
        if (r24 == null) goto L27;
        r20.add(r24);
    L33:
        r24 = null;
        goto L34
    L36:
        if (r18 == 0) goto L38;
    L40:
        boolean r25 = false;
    L41:
        if (r18 == 0) goto L43;
    L45:
        boolean r26 = false;
    L46:
        r17[r18] = TypeEnhancementUtilsKt.computeQualifiersForOverride(r19, r20, r25, r26, r13);
        r18 = r18 + 1;
        goto L24
    L43:
        if (getContainerIsVarargParameter() == false) goto L45;
        r26 = true;
        goto L46
    L38:
        if (isCovariant() == false) goto L40;
        r25 = true;
        goto L41
    L48:
        return new AnonymousClass1(r12, r17);
    L9:
        if (isCovariant() == true) goto L11;
    L21:
        r16 = r5.size();
        goto L23
    L11:
        if ((r11 instanceof Collection) == true) goto L13;
    L15:
        Iterator<? extends KotlinTypeMarker> r110 = r11.iterator();
    L17:
        if (r110.hasNext() == false) goto L21;
        if (isEqual(r10, r110.next()) == true) goto L17;
    L13:
        if (((Collection) r11).isEmpty() == false) goto L15;
        goto L15
    }

    public abstract boolean forceWarning(TAnnotation r5, KotlinTypeMarker r10);

    public abstract AbstractAnnotationTypeQualifierResolver<TAnnotation> getAnnotationTypeQualifierResolver();

    public abstract Iterable<TAnnotation> getAnnotations(KotlinTypeMarker r5);

    public abstract Iterable<TAnnotation> getContainerAnnotations();

    public abstract AnnotationQualifierApplicabilityType getContainerApplicabilityType();

    public abstract JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers();

    public abstract boolean getContainerIsVarargParameter();

    public abstract boolean getEnableImprovementsInStrictMode();

    public abstract KotlinTypeMarker getEnhancedForWarnings(KotlinTypeMarker r5);

    public boolean getForceOnlyHeadTypeConstructor() {
        return false;
    }

    public abstract FqNameUnsafe getFqNameUnsafe(KotlinTypeMarker r5);

    public abstract boolean getSkipRawTypeArguments();

    public abstract TypeSystemContext getTypeSystem();

    public abstract boolean isArrayOrPrimitiveArray(KotlinTypeMarker r5);

    public abstract boolean isCovariant();

    public abstract boolean isEqual(KotlinTypeMarker r5, KotlinTypeMarker r10);

    public abstract boolean isFromJava(TypeParameterMarker r5);

    public boolean isNotNullTypeParameterCompat(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return false;
    }

    private final <T> List<T> flattenTree(T r5, Function1<? super T, ? extends Iterable<? extends T>> r10) {
        ArrayList r11 = new ArrayList(1);
        flattenTree(r5, r11, r10);
        return r11;
    }
}
