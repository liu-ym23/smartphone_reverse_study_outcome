package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class CompanionObjectMappingUtilsKt {
    public static final boolean isMappedIntrinsicCompanionObject(CompanionObjectMapping r10, ClassDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "classDescriptor");
        if (DescriptorUtils.isCompanionObject(r11) == false) goto L11;
        Set<ClassId> r12 = r10.getClassIds();
        ClassId r13 = DescriptorUtilsKt.getClassId(r11);
        if (r13 == null) goto L7;
        ClassId r14 = r13.getOuterClassId();
    L9:
        if (CollectionsKt.contains(r12, r14) == false) goto L11;
        return true;
    L7:
        r14 = null;
    L11:
        return false;
    }
}
