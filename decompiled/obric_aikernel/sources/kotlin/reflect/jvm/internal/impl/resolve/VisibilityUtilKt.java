package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;

/* JADX INFO: loaded from: classes3.dex */
public final class VisibilityUtilKt {
    public static final CallableMemberDescriptor findMemberWithMaxVisibility(Collection<? extends CallableMemberDescriptor> r10) {
        Intrinsics.checkNotNullParameter(r10, "descriptors");
        r10.isEmpty();
        CallableMemberDescriptor r11 = null;
        Iterator<? extends CallableMemberDescriptor> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L13;
        CallableMemberDescriptor r13 = r12.next();
        if (r11 == null) goto L12;
        Integer r14 = DescriptorVisibilities.compare(r11.getVisibility(), r13.getVisibility());
        if (r14 == null) goto L4;
        if (r14.intValue() >= 0) goto L4;
    L12:
        r11 = r13;
        goto L4
    L13:
        Intrinsics.checkNotNull(r11);
        return r11;
    }
}
