package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d1 implements View.OnTouchListener {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ d1 a;
        public final /* synthetic */ boolean b;

        public a(d1 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            ILinkPanelService r3 = com.bytedance.android.live.liveinteract.component.b.a();
            if (r3 == null) goto L6;
            r3.close();
        L6:
            if (com.bytedance.android.live.liveinteract.linkpanel.util.o.b.a() == false) goto L8;
            ((Switch) this.a.a.ja0().findViewById(2131387900)).setChecked(!this.b);
        L9:
            com.bytedance.android.live.liveinteract.linkpanel.util.o.E(this.a.a.r, "confirm");
            return;
        L8:
            f2.b(2131917584, 0);
            goto L9
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ d1 a;

        public b(d1 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            com.bytedance.android.live.liveinteract.linkpanel.util.o.E(this.a.a.r, "cancel");
        }
    }

    public d1(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r6) {
        gd0.m r7 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r7 == null) goto L8;
        if (((LinkPanelTransitService) r7).f(r6) != true) goto L8;
        return true;
    L8:
        if (r6.getAction() != 0) goto L23;
        com.bytedance.android.live.liveinteract.revenue.battle.b0 r8 = ((IInteractService) jc1.k.n(IInteractService.class)).guestBattleContext();
        if (r8 == null) goto L23;
        if (r8.isGameShowing() != true) goto L23;
        boolean r9 = ((Switch) this.a.aa0(2131387900)).isChecked();
        com.bytedance.android.livesdk.widget.x0.b r1 = new com.bytedance.android.livesdk.widget.x0.b(this.a.getContext(), 0);
        r1.a.a = 4;
        if (r9 == true) goto L16;
        int r2 = 2131917233;
    L17:
        r1.a.d = com.bytedance.android.live.core.utils.s1.B(r2);
        r1.setCornerRadius(2.0f);
        if (r9 == true) goto L20;
        int r3 = 2131923131;
    L21:
        r1.i(0, r3, new a(this, r9));
        r1.i(1, 2131915442, new b(this));
        r1.a.k = false;
        r1.n();
        return true;
    L20:
        r3 = 2131923130;
        goto L21
    L16:
        r2 = 2131917232;
    L23:
        return false;
    }
}
