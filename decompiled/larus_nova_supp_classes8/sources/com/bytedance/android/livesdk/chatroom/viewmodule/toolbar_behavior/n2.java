package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public long a;
    public View b;
    public boolean c;
    public DataCenter d;

    public static final class a {
    }

    static {
    }

    public n2() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r1, DataCenter r2) {
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

    public final void a() {
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.a(this.d) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L18;
        if (this.c == false) goto L14;
        View r1 = this.b;
        if (r1 == null) goto L26;
        r1.setBackgroundResource(2131250864);
        return;
    L26:
        return;
    L14:
        View r2 = this.b;
        if (r2 == null) goto L28;
        r2.setBackgroundResource(2131250862);
        return;
    L28:
        return;
    L18:
        if (this.c == false) goto L22;
        View r3 = this.b;
        if (r3 == null) goto L30;
        r3.setBackgroundResource(2131250863);
        return;
    L30:
        return;
    L22:
        View r4 = this.b;
        if (r4 == null) goto L32;
        r4.setBackgroundResource(2131250861);
        return;
    L32:
        return;
    L5:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.b() == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        if (jc1.k.n(IInteractService.class).audioSubtitleOpen() == true) goto L7;
        com.bytedance.android.live.core.utils.f2.b(2131915143, 0);
        return;
    L7:
        if ((System.currentTimeMillis() - this.a) >= 3000) goto L10;
        com.bytedance.android.live.core.utils.f2.b(2131915148, 0);
        return;
    L10:
        this.a = System.currentTimeMillis();
        this.c = !this.c;
        StringBuilder r7 = new StringBuilder("[AudioSubtitle] ToolbarAudioSubtitleBehavior#onClick(), guest setting is ");
        com.bytedance.android.livesdk.sharedpref.e r1 = b6.x;
        r7.append((Boolean) r1.getValue());
        r7.append(" to ");
        r7.append(this.c);
        ALogger.i("ToolbarAudioSubtitleBehavior", r7.toString());
        Boolean r8 = Boolean.valueOf(this.c);
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r8);
        IInteractService r9 = jc1.k.f(IInteractService.class);
        if (r9 == null) goto L13;
        r9.guestAudioSubtitleSwitchSetting(this.c);
    L13:
        a();
        if (this.c == false) goto L16;
        int r10 = 2131915147;
    L17:
        com.bytedance.android.live.core.utils.f2.b(r10, 0);
        return;
    L16:
        r10 = 2131915146;
        goto L17
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.d = r3;
        this.b = r2.findViewById(2131374718);
        com.bytedance.android.livesdk.sharedpref.e r4 = b6.x;
        this.c = ((Boolean) r4.getValue()).booleanValue();
        ALogger.i("ToolbarAudioSubtitleBehavior", "[AudioSubtitle] ToolbarAudioSubtitleBehavior#onLoad(), guest setting is " + ((Boolean) r4.getValue()));
        a();
    }
}
