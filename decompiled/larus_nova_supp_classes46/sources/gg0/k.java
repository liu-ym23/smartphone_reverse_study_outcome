package gg0;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k extends b<MultiLinkSpecialViewBinder.a> {

    public static final class a {
    }

    static {
    }

    public k() {
    }

    @Override // gg0.b
    public final boolean a(tf0.e r5, tf0.e r6) {
        MultiLinkSpecialViewBinder.a r7 = (MultiLinkSpecialViewBinder.a) r5;
        MultiLinkSpecialViewBinder.a r8 = (MultiLinkSpecialViewBinder.a) r6;
        Intrinsics.checkNotNullParameter(r7, "oldItem");
        Intrinsics.checkNotNullParameter(r8, "newItem");
        if (r7.l != r8.l) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        return false;
    L8:
        if (r7.n != r8.n) goto L10;
        return true;
    L5:
        r0 = false;
        goto L6
    }

    @Override // gg0.b
    public final boolean b(tf0.e r2, tf0.e r3) {
        MultiLinkSpecialViewBinder.a r4 = (MultiLinkSpecialViewBinder.a) r2;
        MultiLinkSpecialViewBinder.a r5 = (MultiLinkSpecialViewBinder.a) r3;
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        if (r4.k != r5.k) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // gg0.b
    public final Bundle d(tf0.e r3, tf0.e r4, int r5, int r6) {
        MultiLinkSpecialViewBinder.a r7 = (MultiLinkSpecialViewBinder.a) r3;
        MultiLinkSpecialViewBinder.a r8 = (MultiLinkSpecialViewBinder.a) r4;
        Intrinsics.checkNotNullParameter(r7, "oldItem");
        Intrinsics.checkNotNullParameter(r8, "newItem");
        Bundle r9 = new Bundle();
        if (r7.l != r8.l) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
        r9.putBoolean("payload_key_lock_status_update", true);
    L8:
        boolean r11 = r7.n;
        boolean r12 = r8.n;
        if (r11 == r12) goto L11;
        r9.putBoolean("payload_key_interact_state_update", r12);
    L11:
        return r9;
    L5:
        r10 = false;
        goto L6
    }
}
