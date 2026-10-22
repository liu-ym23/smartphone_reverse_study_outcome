package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import android.widget.TextView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends lb6.a {
    public final /* synthetic */ BaseGuestLinkMainPageDialog a;

    public final void n() {
    }

    public c(BaseGuestLinkMainPageDialog r1) {
        this.a = r1;
    }

    public final void A(String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        this.a.X90(r2, r3);
    }

    public final void C2(long r3, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.c, Extra> r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        super.C2(r3, r5);
        com.bytedance.android.live.base.model.message.guestlink.a r4 = ((com.bytedance.android.livesdk.multilink.base.model.guestlink.c) r5.data).getChannelInfo();
        if (r4 == null) goto L5;
        long r0 = r4.getCallDuration();
    L7:
        if (r0 > 0) goto L9;
        this.a.aa0(-1);
        return;
    L9:
        TextView r6 = this.a.h;
        if (r6 == null) goto L14;
        r6.setText("");
        return;
    L14:
        return;
    L5:
        r0 = 0;
        goto L7
    }

    public final void e(long r1, long r3) {
        this.a.aa0(r3);
    }

    public final void J(String[] r2, boolean[] r3, int[] r4) {
        this.a.Y90(r2, r3, r4);
    }

    public final void h(long r1, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.b, Extra> r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        com.bytedance.android.live.base.model.message.guestlink.a r2 = ((com.bytedance.android.livesdk.multilink.base.model.guestlink.b) r3.data).getChannelInfo();
        if (r2 == null) goto L5;
        long r5 = r2.getCallDuration();
    L7:
        if (r5 > 0) goto L9;
        this.a.aa0(-1);
    L12:
        com.bytedance.android.live.liveinteract.revenue.guestlink.ui.c r6 = this.a.F;
        if (r6 == null) goto L16;
        r6.d();
        return;
    L16:
        return;
    L9:
        TextView r7 = this.a.h;
        if (r7 == null) goto L12;
        r7.setText("");
        goto L12
    L5:
        r5 = 0;
        goto L7
    }
}
