package com.bytedance.android.livesdk.interactivity.comment;

import android.view.View;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.ui.RedDotView;
import com.bytedance.android.livesdk.interactivity.api.IBarrageService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d1 implements View.OnClickListener {
    public final /* synthetic */ CommentWidget a;

    public d1(CommentWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        CommentWidget r7 = this.a;
        if (((Widget) r7).dataCenter != null) goto L5;
        return;
    L5:
        if (((Widget) r7).context == null) goto L23;
        HashMap<String, String> r8 = new HashMap();
        r8.put("position", "out");
        CommentWidget r0 = this.a;
        int r1 = CommentWidget.V1;
        r0.getClass();
        IRoomContextService r2 = jc1.k.f(IRoomContextService.class);
        if (r2 != null) goto L9;
        String r3 = BuildConfig.FLAVOR;
    L16:
        r8.put("live_type", r3);
        IBarrageService r4 = (IBarrageService) jc1.k.f(IBarrageService.class);
        CommentWidget r5 = this.a;
        r4.showLandscapeBarrageSettingDialog(((Widget) r5).context, ((Widget) r5).dataCenter, r8);
        RedDotView r9 = this.a.e;
        if (r9 == null) goto L24;
        r9.setVisibility(8);
        com.bytedance.android.livesdk.sharedpref.e<l42.b> r10 = l42.a.r;
        l42.b r11 = (l42.b) r10.getValue();
        if (r11 == null) goto L25;
        r11.a = true;
        r10.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r10, r11);
        return;
    L25:
        return;
    L24:
        return;
    L9:
        Boolean r13 = r2.getRoomDataContext(((Widget) r0).dataCenter, 0).isVSRoom();
        if (r13 != null) goto L13;
        LiveMode r14 = r0.r.getStreamType();
        int r15 = com.bytedance.android.live.core.utils.h1.a;
        r3 = i1.a(r14);
        goto L16
    L13:
        if (r13.booleanValue() == false) goto L15;
        r3 = "vs";
        goto L16
    L15:
        LiveMode r16 = r0.r.getStreamType();
        int r17 = com.bytedance.android.live.core.utils.h1.a;
        r3 = i1.a(r16);
        goto L16
    }
}
