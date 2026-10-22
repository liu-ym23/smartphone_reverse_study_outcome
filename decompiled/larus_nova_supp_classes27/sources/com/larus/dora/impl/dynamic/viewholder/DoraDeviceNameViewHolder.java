package com.larus.dora.impl.dynamic.viewholder;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoGeneraGroupLayoutBinding;
import com.larus.dora.impl.dynamic.p1;
import com.larus.dora.impl.dynamic.s1;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JL\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¨\u0006\u0019"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DoraDeviceNameViewHolder;", "Lcom/larus/dora/impl/dynamic/viewholder/GeneraGroupHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoGeneraGroupLayoutBinding;", "traceNode", "Lcom/ixigua/lib/track/ITrackNode;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoGeneraGroupLayoutBinding;Lcom/ixigua/lib/track/ITrackNode;)V", "createChildView", "", "doraDevice", "Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "itemCount", "", "items", "", "Lcom/larus/dora/impl/dynamic/GeneraItem;", "context", "Landroid/content/Context;", "startling", "", "", "itemGroup", "Lcom/larus/bmhome/view/item/ItemGroup;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDeviceNameViewHolder extends GeneraGroupHolder {
    public static final /* synthetic */ int f = 0;

    public static final class a {
    }

    static {
    }

    public DoraDeviceNameViewHolder(LarusDoraDeviceInfoGeneraGroupLayoutBinding r3) {
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(null, "traceNode");
        super(r3);
    }

    @Override // com.larus.dora.impl.dynamic.viewholder.GeneraGroupHolder
    public final void X3(final z49.b r7, int r8, List r9, final Context r10, ItemGroup r11) {
        Intrinsics.checkNotNullParameter(r7, "doraDevice");
        Intrinsics.checkNotNullParameter(r9, "items");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "itemGroup");
        int r0 = 0;
    L3:
        if (r0 >= r8) goto L13;
        final p1 r1 = (p1) ListProtector.get(r9, r0);
        a59.a r2 = this.d;
        s1 r3 = r1.e();
        if (r3 == null) goto L7;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r4 = "";
    L8:
        String r5 = String.valueOf(r4);
        r2.getClass();
        final ItemTextArrow r6 = a59.a.b(r11, r5);
        if (TextUtils.isEmpty(r1.d()) == false) goto L11;
        e1.o(r6.getArrowView());
    L12:
        e1.d(r6, new k(r1, r10, r7, this));
        int r12 = com.larus.dora.impl.util.o.a;
        r6.Z5(com.larus.dora.impl.util.o.b(r7.c(), r7.e()), null);
        r6.setVisible(true);
        r6.post(new l(r6));
        r0 = r0 + 1;
        goto L3
    L11:
        e1.x(r6.getArrowView());
        goto L12
    L7:
        r4 = null;
        goto L8
    }
}
