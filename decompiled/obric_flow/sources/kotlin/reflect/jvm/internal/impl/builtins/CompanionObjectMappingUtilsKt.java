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
    public static final boolean isMappedIntrinsicCompanionObject(CompanionObjectMapping r5, ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "classDescriptor");
        if (DescriptorUtils.isCompanionObject(r10) == false) goto L11;
        Set<ClassId> r11 = r5.getClassIds();
        ClassId r12 = DescriptorUtilsKt.getClassId(r10);
        if (r12 == null) goto L7;
        ClassId r13 = r12.getOuterClassId();
    L9:
        if (CollectionsKt.contains(r11, r13) == false) goto L11;
        return true;
    L7:
        r13 = null;
    L11:
        return false;
    }
}
