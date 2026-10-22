package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nutil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 util.kt\norg/jetbrains/kotlin/load/java/descriptors/UtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n1549#2:69\n1620#2,3:70\n*S KotlinDebug\n*F\n+ 1 util.kt\norg/jetbrains/kotlin/load/java/descriptors/UtilKt\n*L\n40#1:69\n40#1:70,3\n*E\n"})
public final class UtilKt {
    public static final List<ValueParameterDescriptor> copyValueParameters(Collection<? extends KotlinType> r16, Collection<? extends ValueParameterDescriptor> r17, CallableDescriptor r18) {
        Intrinsics.checkNotNullParameter(r16, "newValueParameterTypes");
        Intrinsics.checkNotNullParameter(r17, "oldValueParameters");
        Intrinsics.checkNotNullParameter(r18, "newOwner");
        r16.size();
        r17.size();
        List r5 = CollectionsKt.zip(r16, r17);
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        Pair r12 = (Pair) r11.next();
        KotlinType r13 = (KotlinType) r12.component1();
        ValueParameterDescriptor r14 = (ValueParameterDescriptor) r12.component2();
        int r15 = r14.getIndex();
        Annotations r19 = r14.getAnnotations();
        Name r20 = r14.getName();
        boolean r110 = r14.declaresDefaultValue();
        boolean r111 = r14.isCrossinline();
        boolean r112 = r14.isNoinline();
        if (r14.getVarargElementType() == null) goto L9;
        KotlinType r21 = DescriptorUtilsKt.getModule(r18).getBuiltIns().getArrayElementType(r13);
    L8:
        KotlinType r113 = r21;
        r10.add(new ValueParameterDescriptorImpl(r18, null, r15, r19, r20, r13, r110, r111, r112, r113, r14.getSource()));
        r11 = r11;
        goto L4
    L9:
        r21 = null;
        goto L8
    L11:
        return r10;
    }

    public static final LazyJavaStaticClassScope getParentJavaStaticClassScope(ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ClassDescriptor r10 = DescriptorUtilsKt.getSuperClassNotAny(r5);
        LazyJavaStaticClassScope r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        MemberScope r12 = r10.getStaticScope();
        if ((r12 instanceof LazyJavaStaticClassScope) == false) goto L8;
        r11 = (LazyJavaStaticClassScope) r12;
    L8:
        if (r11 == null) goto L10;
        return r11;
    L10:
        return getParentJavaStaticClassScope(r10);
    }
}
