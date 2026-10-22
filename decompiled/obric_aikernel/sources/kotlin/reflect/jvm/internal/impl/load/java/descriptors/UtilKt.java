package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class UtilKt {
    public static final List<ValueParameterDescriptor> copyValueParameters(Collection<? extends KotlinType> r16, Collection<? extends ValueParameterDescriptor> r17, CallableDescriptor r18) {
        Intrinsics.checkNotNullParameter(r16, "newValueParameterTypes");
        Intrinsics.checkNotNullParameter(r17, "oldValueParameters");
        Intrinsics.checkNotNullParameter(r18, "newOwner");
        r16.size();
        r17.size();
        List r10 = CollectionsKt.zip(r16, r17);
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Pair r12 = (Pair) r11.next();
        KotlinType r13 = (KotlinType) r12.component1();
        ValueParameterDescriptor r15 = (ValueParameterDescriptor) r12.component2();
        int r19 = r15.getIndex();
        Annotations r20 = r15.getAnnotations();
        Name r21 = r15.getName();
        Intrinsics.checkNotNullExpressionValue(r21, "oldParameter.name");
        boolean r22 = r15.declaresDefaultValue();
        boolean r23 = r15.isCrossinline();
        boolean r110 = r15.isNoinline();
        if (r15.getVarargElementType() == null) goto L8;
        KotlinType r24 = DescriptorUtilsKt.getModule(r18).getBuiltIns().getArrayElementType(r13);
    L9:
        SourceElement r111 = r15.getSource();
        Intrinsics.checkNotNullExpressionValue(r111, "oldParameter.source");
        r14.add(new ValueParameterDescriptorImpl(r18, null, r19, r20, r21, r13, r22, r23, r110, r24, r111));
        goto L4
    L8:
        r24 = null;
        goto L9
    L10:
        return r14;
    }

    public static final LazyJavaStaticClassScope getParentJavaStaticClassScope(ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ClassDescriptor r11 = DescriptorUtilsKt.getSuperClassNotAny(r10);
        LazyJavaStaticClassScope r12 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        MemberScope r13 = r11.getStaticScope();
        if ((r13 instanceof LazyJavaStaticClassScope) == false) goto L8;
        r12 = (LazyJavaStaticClassScope) r13;
    L8:
        if (r12 == null) goto L10;
        return r12;
    L10:
        return getParentJavaStaticClassScope(r11);
    }
}
