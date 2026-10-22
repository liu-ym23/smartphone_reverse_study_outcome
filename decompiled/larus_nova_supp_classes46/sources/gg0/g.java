package gg0;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPaidViewBinder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends b<MultiLinkPaidViewBinder.a> {
    public g() {
    }

    @Override // gg0.b
    public final boolean a(tf0.e r4, tf0.e r5) {
        MultiLinkPaidViewBinder.a r6 = (MultiLinkPaidViewBinder.a) r4;
        MultiLinkPaidViewBinder.a r7 = (MultiLinkPaidViewBinder.a) r5;
        Intrinsics.checkNotNullParameter(r6, "oldItem");
        Intrinsics.checkNotNullParameter(r7, "newItem");
        if (r6.k.getPaidCount() != r7.k.getPaidCount()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // gg0.b
    public final boolean b(tf0.e r2, tf0.e r3) {
        MultiLinkPaidViewBinder.a r4 = (MultiLinkPaidViewBinder.a) r2;
        MultiLinkPaidViewBinder.a r5 = (MultiLinkPaidViewBinder.a) r3;
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        return Intrinsics.areEqual(r4.k.getInteractId(), r5.k.getInteractId());
    }

    @Override // gg0.b
    public final Bundle d(tf0.e r1, tf0.e r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter((MultiLinkPaidViewBinder.a) r1, "oldItem");
        Intrinsics.checkNotNullParameter((MultiLinkPaidViewBinder.a) r2, "newItem");
        return new Bundle();
    }
}
