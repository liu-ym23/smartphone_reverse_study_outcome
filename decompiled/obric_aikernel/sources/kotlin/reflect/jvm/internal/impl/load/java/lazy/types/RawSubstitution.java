package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class RawSubstitution extends TypeSubstitution {
    public static final Companion Companion = null;
    private static final JavaTypeAttributes lowerTypeAttr = null;
    private static final JavaTypeAttributes upperTypeAttr = null;
    private final RawProjectionComputer projectionComputer;
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        TypeUsage r10 = TypeUsage.COMMON;
        lowerTypeAttr = JavaTypeAttributesKt.toAttributes$default(r10, false, true, null, 5, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
        upperTypeAttr = JavaTypeAttributesKt.toAttributes$default(r10, false, true, null, 5, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RawSubstitution() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public RawSubstitution(TypeParameterUpperBoundEraser r10) {
        RawProjectionComputer r11 = new RawProjectionComputer();
        this.projectionComputer = r11;
        if (r10 != null) goto L5;
        r10 = new TypeParameterUpperBoundEraser(r11, null, 2, null);
    L5:
        this.typeParameterUpperBoundEraser = r10;
    }

    public /* synthetic */ RawSubstitution(TypeParameterUpperBoundEraser r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }

    public static final /* synthetic */ Pair access$eraseInflexibleBasedOnClassDescriptor(RawSubstitution r10, SimpleType r11, ClassDescriptor r12, JavaTypeAttributes r13) {
        return r10.eraseInflexibleBasedOnClassDescriptor(r11, r12, r13);
    }

    private final Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor(final SimpleType r17, final ClassDescriptor r18, final JavaTypeAttributes r19) {
        if (r17.getConstructor().getParameters().isEmpty() == false) goto L7;
        return TuplesKt.to(r17, Boolean.FALSE);
    L7:
        if (KotlinBuiltIns.isArray(r17) == false) goto L11;
        TypeProjection r10 = r17.getArguments().get(0);
        Variance r11 = r10.getProjectionKind();
        KotlinType r12 = r10.getType();
        Intrinsics.checkNotNullExpressionValue(r12, "componentTypeProjection.type");
        return TuplesKt.to(KotlinTypeFactory.simpleType$default(r17.getAttributes(), r17.getConstructor(), CollectionsKt.listOf(new TypeProjectionImpl(r11, eraseType(r12, r19))), r17.isMarkedNullable(), null, 16, null), Boolean.FALSE);
    L11:
        if (KotlinTypeKt.isError(r17) == true) goto L13;
        MemberScope r13 = r18.getMemberScope(this);
        Intrinsics.checkNotNullExpressionValue(r13, "declaration.getMemberScope(this)");
        TypeAttributes r14 = r17.getAttributes();
        TypeConstructor r15 = r18.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r15, "declaration.typeConstructor");
        List<TypeParameterDescriptor> r16 = r18.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r16, "declaration.typeConstructor.parameters");
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r111 = r16.iterator();
    L16:
        if (r111.hasNext() == false) goto L19;
        TypeParameterDescriptor r20 = (TypeParameterDescriptor) r111.next();
        RawProjectionComputer r21 = this.projectionComputer;
        Intrinsics.checkNotNullExpressionValue(r20, "parameter");
        r110.add(ErasureProjectionComputer.computeProjection$default(r21, r20, r19, this.typeParameterUpperBoundEraser, null, 8, null));
        goto L16
    L19:
        return TuplesKt.to(KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(r14, r15, r110, r17.isMarkedNullable(), r13, new AnonymousClass2(r18, this, r17, r19)), Boolean.TRUE);
    L13:
        return TuplesKt.to(ErrorUtils.createErrorType(ErrorTypeKind.ERROR_RAW_TYPE, new String[]{r17.getConstructor().toString()}), Boolean.FALSE);
    }

    private final KotlinType eraseType(KotlinType r10, JavaTypeAttributes r11) {
        ClassifierDescriptor r12 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if ((r12 instanceof TypeParameterDescriptor) == false) goto L6;
        return eraseType(this.typeParameterUpperBoundEraser.getErasedUpperBound((TypeParameterDescriptor) r12, r11.markIsRaw(true)), r11);
    L6:
        if ((r12 instanceof ClassDescriptor) == false) goto L19;
        ClassifierDescriptor r13 = FlexibleTypesKt.upperIfFlexible(r10).getConstructor().mo1323getDeclarationDescriptor();
        if ((r13 instanceof ClassDescriptor) == false) goto L17;
        Pair<SimpleType, Boolean> r14 = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.lowerIfFlexible(r10), (ClassDescriptor) r12, lowerTypeAttr);
        SimpleType r15 = r14.component1();
        boolean r16 = r14.component2().booleanValue();
        Pair<SimpleType, Boolean> r17 = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.upperIfFlexible(r10), (ClassDescriptor) r13, upperTypeAttr);
        SimpleType r18 = r17.component1();
        boolean r19 = r17.component2().booleanValue();
        if (r16 == true) goto L15;
        if (r19 == true) goto L15;
        return KotlinTypeFactory.flexibleType(r15, r18);
    L15:
        return new RawTypeImpl(r15, r18);
    L17:
        throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + r13 + "\" while for lower it's \"" + r12 + Typography.quote).toString());
    L19:
        throw new IllegalStateException(("Unexpected declaration kind: " + r12).toString());
    }

    static /* synthetic */ KotlinType eraseType$default(RawSubstitution r10, KotlinType r11, JavaTypeAttributes r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = new JavaTypeAttributes(TypeUsage.COMMON, null, false, false, null, null, 62, null);
    L6:
        return r10.eraseType(r11, r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public /* bridge */ /* synthetic */ TypeProjection mo1328get(KotlinType r10) {
        return mo1328get(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjectionImpl mo1328get(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return new TypeProjectionImpl(eraseType$default(this, r10, null, 2, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }
}
