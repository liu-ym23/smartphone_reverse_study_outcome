package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;

/* JADX INFO: loaded from: classes3.dex */
public final class VisibilityUtilKt {
    public static final CallableMemberDescriptor findMemberWithMaxVisibility(Collection<? extends CallableMemberDescriptor> r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptors");
        r5.isEmpty();
        Iterator<? extends CallableMemberDescriptor> r10 = r5.iterator();
        CallableMemberDescriptor r11 = null;
    L4:
        if (r10.hasNext() == false) goto L13;
        CallableMemberDescriptor r12 = r10.next();
        if (r11 == null) goto L12;
        Integer r13 = DescriptorVisibilities.compare(r11.getVisibility(), r12.getVisibility());
        if (r13 == null) goto L4;
        if (r13.intValue() >= 0) goto L4;
    L12:
        r11 = r12;
        goto L4
    L13:
        Intrinsics.checkNotNull(r11);
        return r11;
    }
}
