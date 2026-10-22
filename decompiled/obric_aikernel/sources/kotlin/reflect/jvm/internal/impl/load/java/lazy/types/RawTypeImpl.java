package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class RawTypeImpl extends FlexibleType implements RawType {
    public RawTypeImpl(SimpleType r10, SimpleType r11) {
        Intrinsics.checkNotNullParameter(r10, "lowerBound");
        Intrinsics.checkNotNullParameter(r11, "upperBound");
        this(r10, r11, false);
    }

    private RawTypeImpl(SimpleType r10, SimpleType r11, boolean r12) {
        super(r10, r11);
        if (r12 == true) goto L6;
        KotlinTypeChecker.DEFAULT.isSubtypeOf(r10, r11);
        return;
    }

    private static final boolean render$onlyOutDiffers(String r10, String r11) {
        if (Intrinsics.areEqual(r10, StringsKt.removePrefix(r11, "out ")) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r11, "*") == true) goto L8;
        return false;
    }

    private static final List<String> render$renderArguments(DescriptorRenderer r10, KotlinType r11) {
        List<TypeProjection> r12 = r11.getArguments();
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.add(r10.renderTypeProjection((TypeProjection) r14.next()));
        goto L4
    L6:
        return r13;
    }

    private static final String render$replaceArgs(String r10, String r11) {
        if (StringsKt.contains$default(r10, Typography.less, false, 2, null) == true) goto L6;
        return r10;
    L6:
        return StringsKt.substringBefore$default(r10, Typography.less, null, 2, null) + Typography.less + r11 + Typography.greater + StringsKt.substringAfterLast$default(r10, Typography.greater, null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public SimpleType getDelegate() {
        return getLowerBound();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        ClassifierDescriptor r10 = getConstructor().mo1323getDeclarationDescriptor();
        TypeParameterUpperBoundEraser r11 = null;
        Object[] r12 = 0;
        if ((r10 instanceof ClassDescriptor) == false) goto L5;
        ClassDescriptor r13 = (ClassDescriptor) r10;
    L6:
        if (r13 == null) goto L10;
        MemberScope r14 = r13.getMemberScope(new RawSubstitution(r11, 1, r12 == true ? 1 : 0));
        Intrinsics.checkNotNullExpressionValue(r14, "classDescriptor.getMemberScope(RawSubstitution())");
        return r14;
    L10:
        throw new IllegalStateException(("Incorrect classifier: " + getConstructor().mo1323getDeclarationDescriptor()).toString());
    L5:
        r13 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public RawTypeImpl makeNullableAsSpecified(boolean r10) {
        return new RawTypeImpl(getLowerBound().makeNullableAsSpecified(r10), getUpperBound().makeNullableAsSpecified(r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r10) {
        return makeNullableAsSpecified(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public FlexibleType refine(KotlinTypeRefiner r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefiner");
        KotlinType r11 = r10.refineType(getLowerBound());
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType r12 = r10.refineType(getUpperBound());
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new RawTypeImpl((SimpleType) r11, (SimpleType) r12, true);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r10) {
        return refine(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r10) {
        return refine(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String render(DescriptorRenderer r13, DescriptorRendererOptions r14) {
        Intrinsics.checkNotNullParameter(r13, "renderer");
        Intrinsics.checkNotNullParameter(r14, "options");
        String r10 = r13.renderType(getLowerBound());
        String r11 = r13.renderType(getUpperBound());
        if (r14.getDebugMode() == false) goto L7;
        return "raw (" + r10 + ".." + r11 + ')';
    L7:
        if (getUpperBound().getArguments().isEmpty() == true) goto L9;
        List<String> r15 = render$renderArguments(r13, getLowerBound());
        List<String> r12 = render$renderArguments(r13, getUpperBound());
        String r16 = CollectionsKt.joinToString$default(r15, ", ", null, null, 0, null, RawTypeImpl$render$newArgs$1.INSTANCE, 30, null);
        List r17 = CollectionsKt.zip(r15, r12);
        boolean r18 = true;
        if ((r17 instanceof Collection) == true) goto L13;
    L15:
        Iterator r19 = r17.iterator();
    L17:
        if (r19.hasNext() == false) goto L21;
        Pair r20 = (Pair) r19.next();
        if (render$onlyOutDiffers((String) r20.getFirst(), (String) r20.getSecond()) == true) goto L17;
        r18 = false;
    L21:
        if (r18 == false) goto L23;
        r11 = render$replaceArgs(r11, r16);
    L23:
        String r110 = render$replaceArgs(r10, r16);
        if (Intrinsics.areEqual(r110, r11) == false) goto L27;
        return r110;
    L27:
        return r13.renderFlexibleType(r110, r11, TypeUtilsKt.getBuiltIns(this));
    L13:
        if (r17.isEmpty() == false) goto L15;
    L9:
        return r13.renderFlexibleType(r10, r11, TypeUtilsKt.getBuiltIns(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public RawTypeImpl replaceAttributes(TypeAttributes r10) {
        Intrinsics.checkNotNullParameter(r10, "newAttributes");
        return new RawTypeImpl(getLowerBound().replaceAttributes(r10), getUpperBound().replaceAttributes(r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r10) {
        return replaceAttributes(r10);
    }
}
