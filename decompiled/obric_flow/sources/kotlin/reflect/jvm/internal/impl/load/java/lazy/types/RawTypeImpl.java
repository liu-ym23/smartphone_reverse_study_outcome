package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nRawType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RawType.kt\norg/jetbrains/kotlin/load/java/lazy/types/RawTypeImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,98:1\n1726#2,3:99\n1549#2:102\n1620#2,3:103\n*S KotlinDebug\n*F\n+ 1 RawType.kt\norg/jetbrains/kotlin/load/java/lazy/types/RawTypeImpl\n*L\n80#1:99,3\n61#1:102\n61#1:103,3\n*E\n"})
public final class RawTypeImpl extends FlexibleType implements RawType {
    private RawTypeImpl(SimpleType r5, SimpleType r10, boolean r11) {
        super(r5, r10);
        if (r11 == true) goto L6;
        KotlinTypeChecker.DEFAULT.isSubtypeOf(r5, r10);
        return;
    }

    private static final boolean render$onlyOutDiffers(String r5, String r10) {
        if (Intrinsics.areEqual(r5, StringsKt.A(r10, "out ")) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r10, XPath.WILDCARD) == true) goto L8;
        return false;
    }

    private static final List<String> render$renderArguments(DescriptorRenderer r5, KotlinType r10) {
        List<TypeProjection> r11 = r10.getArguments();
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(r5.renderTypeProjection((TypeProjection) r13.next()));
        goto L4
    L6:
        return r12;
    }

    private static final String render$replaceArgs(String r5, String r10) {
        if (StringsKt.f(r5, Typography.less) == true) goto L6;
        return r5;
    L6:
        return StringsKt.W(r5, Typography.less) + Typography.less + r10 + Typography.greater + StringsKt.U(r5, Typography.greater);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public SimpleType getDelegate() {
        return getLowerBound();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        ClassifierDescriptor r5 = getConstructor().mo1402getDeclarationDescriptor();
        TypeParameterUpperBoundEraser r10 = null;
        Object[] r11 = 0;
        if ((r5 instanceof ClassDescriptor) == false) goto L5;
        ClassDescriptor r12 = (ClassDescriptor) r5;
    L6:
        if (r12 == null) goto L10;
        return r12.getMemberScope(new RawSubstitution(r10, 1, r11 == true ? 1 : 0));
    L10:
        throw new IllegalStateException(("Incorrect classifier: " + getConstructor().mo1402getDeclarationDescriptor()).toString());
    L5:
        r12 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r5) {
        return makeNullableAsSpecified(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r5) {
        return refine(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String render(DescriptorRenderer r12, DescriptorRendererOptions r13) {
        Intrinsics.checkNotNullParameter(r12, "renderer");
        Intrinsics.checkNotNullParameter(r13, "options");
        String r5 = r12.renderType(getLowerBound());
        String r10 = r12.renderType(getUpperBound());
        if (r13.getDebugMode() == false) goto L7;
        return "raw (" + r5 + ".." + r10 + ')';
    L7:
        if (getUpperBound().getArguments().isEmpty() == true) goto L9;
        List<String> r14 = render$renderArguments(r12, getLowerBound());
        List<String> r11 = render$renderArguments(r12, getUpperBound());
        String r15 = CollectionsKt.q(r14, ", ", null, null, 0, null, RawTypeImpl$render$newArgs$1.INSTANCE, 30);
        List r16 = CollectionsKt.zip(r14, r11);
        if (r16 != null) goto L13;
    L15:
        Iterator r17 = r16.iterator();
    L17:
        if (r17.hasNext() == false) goto L21;
        Pair r18 = (Pair) r17.next();
        if (render$onlyOutDiffers((String) r18.getFirst(), (String) r18.getSecond()) == true) goto L17;
    L22:
        String r19 = render$replaceArgs(r5, r15);
        if (Intrinsics.areEqual(r19, r10) == false) goto L26;
        return r19;
    L26:
        return r12.renderFlexibleType(r19, r10, TypeUtilsKt.getBuiltIns(this));
    L21:
        r10 = render$replaceArgs(r10, r15);
        goto L22
    L13:
        if (r16.isEmpty() == false) goto L15;
    L9:
        return r12.renderFlexibleType(r5, r10, TypeUtilsKt.getBuiltIns(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r5) {
        return replaceAttributes(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public RawTypeImpl makeNullableAsSpecified(boolean r5) {
        return new RawTypeImpl(getLowerBound().makeNullableAsSpecified(r5), getUpperBound().makeNullableAsSpecified(r5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r5) {
        return refine(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public RawTypeImpl replaceAttributes(TypeAttributes r5) {
        Intrinsics.checkNotNullParameter(r5, "newAttributes");
        return new RawTypeImpl(getLowerBound().replaceAttributes(r5), getUpperBound().replaceAttributes(r5));
    }

    public RawTypeImpl(SimpleType r5, SimpleType r10) {
        Intrinsics.checkNotNullParameter(r5, "lowerBound");
        Intrinsics.checkNotNullParameter(r10, "upperBound");
        this(r5, r10, false);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public FlexibleType refine(KotlinTypeRefiner r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinTypeRefiner");
        KotlinType r10 = r5.refineType(getLowerBound());
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType r11 = r5.refineType(getUpperBound());
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new RawTypeImpl((SimpleType) r10, (SimpleType) r11, true);
    }
}
