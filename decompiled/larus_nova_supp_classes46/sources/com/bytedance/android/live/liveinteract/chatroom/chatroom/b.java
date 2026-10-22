package com.bytedance.android.live.liveinteract.chatroom.chatroom;

import android.view.View;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements c0.b {
    public DataCenter a;
    public boolean b;
    public final c0.b c;

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final boolean showRedDot() {
        DataCenter r0 = this.a;
        if (r0 == null) goto L10;
        Intrinsics.checkNotNull(r0);
        Boolean r1 = Boolean.FALSE;
        Boolean r2 = (Boolean) r0.get("data_has_interact_more", r1);
        DataCenter r3 = this.a;
        Intrinsics.checkNotNull(r3);
        Boolean r4 = (Boolean) r3.get("data_interact_dot_show", r1);
        if (r2.booleanValue() == true) goto L7;
        return false;
    L7:
        if (r4.booleanValue() == true) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public b(c0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "parentBehavior");
        this.c = r2;
    }

    public final void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        DataCenter r0 = this.a;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.put("data_interact_dot_show", Boolean.TRUE);
    L5:
        com.bytedance.android.livesdk.sharedpref.e r1 = b6.u;
        Long r2 = Long.valueOf(System.currentTimeMillis());
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r2);
        this.c.onClick(r4);
        tc0.c.h().z = "more_panel_show";
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.b = false;
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r3;
        tc0.c.h().z = "more_panel_show";
        if (this.b == true) goto L6;
        com.bytedance.android.live.liveinteract.utils.d r4 = jf0.c.a;
        jf0.c.i();
        this.b = true;
        return;
    }
}
