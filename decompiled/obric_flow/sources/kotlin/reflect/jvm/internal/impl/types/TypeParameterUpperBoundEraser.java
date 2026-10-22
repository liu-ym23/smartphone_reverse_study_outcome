package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTypeParameterUpperBoundEraser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeParameterUpperBoundEraser.kt\norg/jetbrains/kotlin/types/TypeParameterUpperBoundEraser\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n1179#2,2:159\n1253#2,4:161\n1549#2:166\n1620#2,3:167\n1#3:165\n*S KotlinDebug\n*F\n+ 1 TypeParameterUpperBoundEraser.kt\norg/jetbrains/kotlin/types/TypeParameterUpperBoundEraser\n*L\n77#1:159,2\n77#1:161,4\n100#1:166\n100#1:167,3\n*E\n"})
public final class TypeParameterUpperBoundEraser {
    public static final Companion Companion = null;
    private final Lazy erroneousErasedBound$delegate;
    private final MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> getErasedUpperBound;
    private final TypeParameterErasureOptions options;
    private final ErasureProjectionComputer projectionComputer;
    private final LockBasedStorageManager storage;

    @SourceDebugExtension({"SMAP\nTypeParameterUpperBoundEraser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeParameterUpperBoundEraser.kt\norg/jetbrains/kotlin/types/TypeParameterUpperBoundEraser$Companion\n+ 2 TypeUtils.kt\norg/jetbrains/kotlin/types/typeUtil/TypeUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,158:1\n261#2,14:159\n276#2:177\n1549#3:173\n1620#3,3:174\n*S KotlinDebug\n*F\n+ 1 TypeParameterUpperBoundEraser.kt\norg/jetbrains/kotlin/types/TypeParameterUpperBoundEraser$Companion\n*L\n140#1:159,14\n140#1:177\n140#1:173\n140#1:174,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final KotlinType replaceArgumentsOfUpperBound(KotlinType r17, TypeSubstitutor r18, Set<? extends TypeParameterDescriptor> r19, boolean r20) {
            Intrinsics.checkNotNullParameter(r17, "<this>");
            Intrinsics.checkNotNullParameter(r18, "substitutor");
            UnwrappedType r5 = r17.unwrap();
            if ((r5 instanceof FlexibleType) == false) goto L62;
            FlexibleType r10 = (FlexibleType) r5;
            SimpleType r11 = r10.getLowerBound();
            if (r11.getConstructor().getParameters().isEmpty() == false) goto L7;
        L32:
            SimpleType r12 = r10.getUpperBound();
            if (r12.getConstructor().getParameters().isEmpty() == false) goto L35;
        L60:
            UnwrappedType r13 = KotlinTypeFactory.flexibleType(r11, r12);
        L93:
            return r18.safeSubstitute(TypeWithEnhancementKt.inheritEnhancement(r13, r5), Variance.OUT_VARIANCE);
        L35:
            if (r12.getConstructor().mo1402getDeclarationDescriptor() == null) goto L60;
            List<TypeParameterDescriptor> r14 = r12.getConstructor().getParameters();
            ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
            Iterator<T> r16 = r14.iterator();
        L39:
            if (r16.hasNext() == false) goto L59;
            TypeParameterDescriptor r110 = (TypeParameterDescriptor) r16.next();
            TypeProjection r111 = (TypeProjection) CollectionsKt.getOrNull(r17.getArguments(), r110.getIndex());
            if (r20 == false) goto L48;
            if (r111 == null) goto L48;
            KotlinType r112 = r111.getType();
            if (r112 == null) goto L48;
            if (TypeUtilsKt.containsTypeParameter(r112) == true) goto L48;
        L58:
            r15.add(r111);
        L48:
            if (r19 != null) goto L50;
        L52:
            boolean r113 = false;
        L53:
            if (r111 == null) goto L57;
            if (r113 == true) goto L57;
            if (r18.getSubstitution().mo1407get(r111.getType()) != null) goto L58;
        L57:
            r111 = new StarProjectionImpl(r110);
            goto L58
        L50:
            if (r19.contains(r110) == false) goto L52;
            r113 = true;
            goto L53
        L59:
            r12 = TypeSubstitutionKt.replace$default(r12, r15, null, 2, null);
            goto L60
        L7:
            if (r11.getConstructor().mo1402getDeclarationDescriptor() == null) goto L32;
            List<TypeParameterDescriptor> r114 = r11.getConstructor().getParameters();
            ArrayList r115 = new ArrayList(CollectionsKt.h(r114));
            Iterator<T> r116 = r114.iterator();
        L11:
            if (r116.hasNext() == false) goto L31;
            TypeParameterDescriptor r117 = (TypeParameterDescriptor) r116.next();
            TypeProjection r118 = (TypeProjection) CollectionsKt.getOrNull(r17.getArguments(), r117.getIndex());
            if (r20 == false) goto L20;
            if (r118 == null) goto L20;
            KotlinType r119 = r118.getType();
            if (r119 == null) goto L20;
            if (TypeUtilsKt.containsTypeParameter(r119) == true) goto L20;
        L30:
            r115.add(r118);
        L20:
            if (r19 != null) goto L22;
        L24:
            boolean r120 = false;
        L25:
            if (r118 == null) goto L29;
            if (r120 == true) goto L29;
            if (r18.getSubstitution().mo1407get(r118.getType()) != null) goto L30;
        L29:
            r118 = new StarProjectionImpl(r117);
            goto L30
        L22:
            if (r19.contains(r117) == false) goto L24;
            r120 = true;
            goto L25
        L31:
            r11 = TypeSubstitutionKt.replace$default(r11, r115, null, 2, null);
            goto L32
        L62:
            if ((r5 instanceof SimpleType) == false) goto L95;
            SimpleType r21 = (SimpleType) r5;
            if (r21.getConstructor().getParameters().isEmpty() == false) goto L66;
        L91:
            r13 = r21;
            goto L93
        L66:
            if (r21.getConstructor().mo1402getDeclarationDescriptor() == null) goto L91;
            List<TypeParameterDescriptor> r22 = r21.getConstructor().getParameters();
            ArrayList r121 = new ArrayList(CollectionsKt.h(r22));
            Iterator<T> r23 = r22.iterator();
        L70:
            if (r23.hasNext() == false) goto L90;
            TypeParameterDescriptor r122 = (TypeParameterDescriptor) r23.next();
            TypeProjection r123 = (TypeProjection) CollectionsKt.getOrNull(r17.getArguments(), r122.getIndex());
            if (r20 == false) goto L79;
            if (r123 == null) goto L79;
            KotlinType r124 = r123.getType();
            if (r124 == null) goto L79;
            if (TypeUtilsKt.containsTypeParameter(r124) == true) goto L79;
        L89:
            r121.add(r123);
        L79:
            if (r19 != null) goto L81;
        L83:
            boolean r125 = false;
        L84:
            if (r123 == null) goto L88;
            if (r125 == true) goto L88;
            if (r18.getSubstitution().mo1407get(r123.getType()) != null) goto L89;
        L88:
            r123 = new StarProjectionImpl(r122);
            goto L89
        L81:
            if (r19.contains(r122) == false) goto L83;
            r125 = true;
            goto L84
        L90:
            r13 = TypeSubstitutionKt.replace$default(r21, r121, null, 2, null);
            goto L93
        L95:
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

    public static final class DataToEraseUpperBound {
        private final ErasureTypeAttributes typeAttr;
        private final TypeParameterDescriptor typeParameter;

        public DataToEraseUpperBound(TypeParameterDescriptor r5, ErasureTypeAttributes r10) {
            Intrinsics.checkNotNullParameter(r5, "typeParameter");
            Intrinsics.checkNotNullParameter(r10, "typeAttr");
            this.typeParameter = r5;
            this.typeAttr = r10;
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof DataToEraseUpperBound) == true) goto L5;
            return false;
        L5:
            DataToEraseUpperBound r10 = (DataToEraseUpperBound) r5;
            if (Intrinsics.areEqual(r10.typeParameter, this.typeParameter) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(r10.typeAttr, this.typeAttr) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public final ErasureTypeAttributes getTypeAttr() {
            return this.typeAttr;
        }

        public final TypeParameterDescriptor getTypeParameter() {
            return this.typeParameter;
        }

        public int hashCode() {
            int r5 = this.typeParameter.hashCode();
            int r10 = this.typeAttr.hashCode();
            return (r10 + (r5 * 31)) + r5;
        }

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.typeParameter + ", typeAttr=" + this.typeAttr + ')';
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TypeParameterUpperBoundEraser(ErasureProjectionComputer r5, TypeParameterErasureOptions r10) {
        Intrinsics.checkNotNullParameter(r5, "projectionComputer");
        Intrinsics.checkNotNullParameter(r10, "options");
        this.projectionComputer = r5;
        this.options = r10;
        LockBasedStorageManager r11 = new LockBasedStorageManager("Type parameter upper bound erasure results");
        this.storage = r11;
        this.erroneousErasedBound$delegate = LazyKt.lazy(new TypeParameterUpperBoundEraser$erroneousErasedBound$2(this));
        this.getErasedUpperBound = r11.createMemoizedFunction(new AnonymousClass1(this));
    }

    public static final /* synthetic */ KotlinType access$getErasedUpperBoundInternal(TypeParameterUpperBoundEraser r5, TypeParameterDescriptor r10, ErasureTypeAttributes r11) {
        return r5.getErasedUpperBoundInternal(r10, r11);
    }

    private final KotlinType getDefaultType(ErasureTypeAttributes r5) {
        SimpleType r10 = r5.getDefaultType();
        if (r10 == null) goto L7;
        KotlinType r11 = TypeUtilsKt.replaceArgumentsWithStarProjections(r10);
        if (r11 == null) goto L7;
        return r11;
    L7:
        return getErroneousErasedBound();
    }

    private final KotlinType getErasedUpperBoundInternal(TypeParameterDescriptor r10, ErasureTypeAttributes r11) {
        Set<TypeParameterDescriptor> r5 = r11.getVisitedTypeParameters();
        if (r5 != null) goto L5;
    L8:
        Set<TypeParameterDescriptor> r12 = TypeUtilsKt.extractTypeParametersFromUpperBounds(r10.getDefaultType(), r5);
        LinkedHashMap r13 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r12)), 16));
        Iterator<T> r14 = r12.iterator();
    L10:
        if (r14.hasNext() == false) goto L19;
        TypeParameterDescriptor r15 = (TypeParameterDescriptor) r14.next();
        if (r5 != null) goto L14;
    L17:
        TypeProjection r16 = this.projectionComputer.computeProjection(r15, r11, this, getErasedUpperBound(r15, r11.withNewVisitedTypeParameter(r10)));
    L18:
        Pair r17 = TuplesKt.to(r15.getTypeConstructor(), r16);
        r13.put(r17.getFirst(), r17.getSecond());
        goto L10
    L14:
        if (r5.contains(r15) == false) goto L17;
        r16 = TypeUtils.makeStarProjection(r15, r11);
        goto L18
    L19:
        Set<KotlinType> r18 = substituteErasedUpperBounds(TypeSubstitutor.create(TypeConstructorSubstitution.Companion.createByConstructorsMap$default(TypeConstructorSubstitution.Companion, r13, false, 2, null)), r10.getUpperBounds(), r11);
        if (r18.isEmpty() == true) goto L36;
        if (this.options.getIntersectUpperBounds() == false) goto L24;
        List r19 = CollectionsKt.toList(r18);
        ArrayList r20 = new ArrayList(CollectionsKt.h(r19));
        Iterator r21 = r19.iterator();
    L31:
        if (r21.hasNext() == false) goto L34;
        r20.add(((KotlinType) r21.next()).unwrap());
        goto L31
    L34:
        return IntersectionTypeKt.intersectTypes(r20);
    L24:
        if (r18.size() != 1) goto L28;
        return (KotlinType) CollectionsKt.single(r18);
    L28:
        throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds");
    L36:
        return getDefaultType(r11);
    L5:
        if (r5.contains(r10.getOriginal()) == false) goto L8;
        return getDefaultType(r11);
    }

    private final ErrorType getErroneousErasedBound() {
        return (ErrorType) this.erroneousErasedBound$delegate.getValue();
    }

    private final Set<KotlinType> substituteErasedUpperBounds(TypeSubstitutor r10, List<? extends KotlinType> r11, ErasureTypeAttributes r12) {
        Set r5 = SetsKt.createSetBuilder();
        Iterator<? extends KotlinType> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L19;
        KotlinType r14 = r13.next();
        ClassifierDescriptor r15 = r14.getConstructor().mo1402getDeclarationDescriptor();
        if ((r15 instanceof ClassDescriptor) == false) goto L9;
        r5.add(Companion.replaceArgumentsOfUpperBound(r14, r10, r12.getVisitedTypeParameters(), this.options.getLeaveNonTypeParameterTypes()));
    L17:
        if (this.options.getIntersectUpperBounds() == true) goto L4;
    L9:
        if ((r15 instanceof TypeParameterDescriptor) == false) goto L17;
        Set<TypeParameterDescriptor> r16 = r12.getVisitedTypeParameters();
        if (r16 != null) goto L13;
    L15:
        r5.addAll(substituteErasedUpperBounds(r10, ((TypeParameterDescriptor) r15).getUpperBounds(), r12));
        goto L17
    L13:
        if (r16.contains(r15) != true) goto L15;
        r5.add(getDefaultType(r12));
    L19:
        return SetsKt.build(r5);
    }

    public final KotlinType getErasedUpperBound(TypeParameterDescriptor r5, ErasureTypeAttributes r10) {
        Intrinsics.checkNotNullParameter(r5, "typeParameter");
        Intrinsics.checkNotNullParameter(r10, "typeAttr");
        return this.getErasedUpperBound.invoke(new DataToEraseUpperBound(r5, r10));
    }

    public /* synthetic */ TypeParameterUpperBoundEraser(ErasureProjectionComputer r5, TypeParameterErasureOptions r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = new TypeParameterErasureOptions(false, false);
    L5:
        this(r5, r10);
    }
}
