package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public boolean a;
    public View b;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public y2() {
        this.a = true;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        boolean r4 = !this.a;
        this.a = r4;
        if (r4 == false) goto L5;
        this.b.setBackgroundResource(2131250364);
        com.bytedance.android.live.core.utils.f2.b(2131917122, 0);
    L6:
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.b.F0;
        Boolean r0 = Boolean.valueOf(this.a);
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r0);
        xs2.b r6 = xs2.b.a();
        if (this.a == false) goto L9;
        int r1 = 4;
    L10:
        r6.post(new HorizontalPlayEvent(r1));
        return;
    L9:
        r1 = 3;
        goto L10
    L5:
        this.b.setBackgroundResource(2131250363);
        com.bytedance.android.live.core.utils.f2.b(2131917121, 0);
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        boolean r4 = ((Boolean) com.bytedance.android.livesdk.sharedpref.b.F0.getValue()).booleanValue();
        this.a = r4;
        this.b = r2;
        if (r4 == false) goto L5;
        r2.setBackgroundResource(2131250364);
    L6:
        xs2.b r5 = xs2.b.a();
        if (this.a == false) goto L9;
        int r0 = 4;
    L10:
        r5.post(new HorizontalPlayEvent(r0));
        return;
    L9:
        r0 = 3;
        goto L10
    L5:
        r2.setBackgroundResource(2131250363);
        goto L6
    }
}
