package com.bytedance.android.live.revlink.impl.multianchor.dialog;

import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.livesdk.link.model.bridge.j;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.q;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final i11.b a;
    public final i b;
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.i c;
    public final v d;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.dialog.a$a, reason: collision with other inner class name */
    public static final class C0136a {
    }

    static {
    }

    public final void b() {
        i11.b r0 = this.a;
        if (r0 == null) goto L30;
        List<p> r1 = r0.getOnlineUserList();
        if (r1 == null) goto L38;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L39;
        j r3 = q.b((p) r2.next());
        if (r3 == null) goto L8;
        String r4 = r3.getMainLinkMicId();
        String r5 = "";
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        String r6 = r3.getBackupLinkMicId();
        if (r6 == null) goto L18;
        r5 = r6;
    L18:
        boolean r7 = r3.getUseBackupStream();
        i r8 = this.b;
        if (r8 == null) goto L21;
        r8.h(r4, r7, "rtcStartMainStream");
    L21:
        i r9 = this.b;
        if (r9 == null) goto L24;
        r9.D1(r4, r7, "rtcStartMainStream");
    L24:
        i r10 = this.b;
        if (r10 == null) goto L27;
        r10.h(r5, !r7, "rtcStartBackupStream");
    L27:
        i r12 = this.b;
        if (r12 == null) goto L8;
        r12.D1(r5, !r7, "rtcStartBackupStream");
        goto L8
    L39:
        return;
    L38:
        return;
    }

    public final boolean a(String r2) {
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.e(r2) != true) goto L7;
        return true;
    }

    public a(AnchorLinkUserCenterV2 r1, i r2, com.bytedance.android.live.revlink.link.domain.service.a r3, v r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
