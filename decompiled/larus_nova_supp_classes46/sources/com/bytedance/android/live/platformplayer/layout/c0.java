package com.bytedance.android.live.platformplayer.layout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.ui.v9;
import com.bytedance.android.livesdk.config.yt0;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public c0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Boolean r7 = (Boolean) r6;
        if (r7 == null) goto L41;
        r7.booleanValue();
        LivePlayerWidget r8 = this.a;
        int r0 = LivePlayerWidget.V2;
        r8.Er("resetPlayerWidget");
        v9 r1 = r8.n;
        if (r1 == null) goto L7;
        r1.exitVideoViewCrop(false, true);
    L7:
        Context r3 = null;
        if (((Boolean) yt0.a.getValue()).booleanValue() == true) goto L16;
        IRenderView r2 = r8.R8().getRenderView();
        if ((true ^ r8.U2.l()) == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L16;
        r2.reset();
    L16:
        if (r8.U2.l() == false) goto L21;
        Bundle r4 = ((com.bytedance.android.live.platformplayer.b) r8.ar().invoke()).getArguments();
        if (r4 == null) goto L20;
        r4.remove("live.intent.extra.PULL_SHARE_URL");
    L20:
        r8.U2.setEnterSmooth(false);
    L21:
        r8.U2.e().getHideLoading().setValue(Boolean.TRUE);
        if (r8.U2.isSmoothLeaveDoubleRender() == false) goto L24;
    L26:
        Context r5 = ((Widget) r8).context;
        if ((r5 instanceof Activity) == false) goto L30;
        r3 = r5;
    L30:
        Activity r9 = (Activity) r3;
        if (r9 != null) goto L33;
    L37:
        r8.U2.n = false;
        r8.hs();
        DataCenter r10 = ((Widget) r8).dataCenter;
        if (r10 == null) goto L42;
        r10.put("action_switch_live_resolution", Boolean.FALSE);
        return;
    L42:
        return;
    L33:
        if (r9.isFinishing() == true) goto L37;
        if (r8.er().getDisableGonePlayerViewWhenScrolled() == true) goto L37;
        r8.R8().setVisibility(8);
        goto L37
    L24:
        if (r8.U2.isSmoothEnterDoubleRender() == true) goto L26;
        r8.Xk("reset player");
        goto L26
    }
}
