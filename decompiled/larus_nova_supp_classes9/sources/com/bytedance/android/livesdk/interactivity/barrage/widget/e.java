package com.bytedance.android.livesdk.interactivity.barrage.widget;

import android.view.View;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.interactivity.api.IBarrageService;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements c0.b {
    public n22.c a;
    public View b;
    public DataCenter c;

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final com.bytedance.android.livesdk.reddot.a h7() {
        IInteractivityInjectService r0 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.audienceRoomBarrageSetting();
    }

    public e() {
    }

    public final void onClick(View r7) {
        IBarrageService r0 = (IBarrageService) k.f(IBarrageService.class);
        HashMap<String, String> r1 = new HashMap();
        r1.put("position", "in");
        IRoomContextService r2 = k.f(IRoomContextService.class);
        if (r2 != null) goto L5;
    L7:
        LiveMode r3 = a0.n(this.c).getStreamType();
        int r4 = h1.a;
        String r5 = i1.a(r3);
    L8:
        r1.put("live_type", r5);
        if (r7.getContext() != null) goto L11;
        return;
    L11:
        if (this.c == null) goto L15;
        this.a = r0.showLandscapeBarrageSettingDialog(r7.getContext(), this.c, r1);
        return;
    L15:
        return;
    L5:
        if (r2.getRoomDataContext(this.c, 0).isVSRoom() != Boolean.TRUE) goto L7;
        r5 = "vs";
        goto L8
    }

    public final void R9(View r1, DataCenter r2) {
        n22.c r3 = this.a;
        if (r3 == null) goto L5;
        r3.dismiss();
    L5:
        this.a = null;
    }

    public final void p4(View r1, DataCenter r2) {
        this.b = r1;
        this.c = r2;
    }
}
