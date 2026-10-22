package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenLogUtils;
import com.bytedance.android.livesdk.config.n60;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;
    public final q2 b;
    public final boolean c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
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
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.p;
    }

    public p2(boolean r1) {
        this.c = r1;
        this.b = new q2(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        IUserService r7 = jc1.k.f(IUserService.class);
        IUser r0 = null;
        if (r7 == null) goto L7;
        com.bytedance.android.livesdk.user.f r8 = r7.user();
        if (r8 == null) goto L7;
        IUser r9 = r8.b();
    L9:
        if ((r9 instanceof User) == false) goto L12;
        r0 = r9;
    L12:
        User r1 = (User) r0;
        if (r1 == null) goto L40;
        IInteractService r2 = jc1.k.f(IInteractService.class);
        if (r2 == null) goto L21;
        rj0.m r3 = r2.getVideoTalkService();
        if (r3 == null) goto L21;
        if (r3.C(this.c, r1.getIdString()) != true) goto L21;
    L39:
        boolean r4 = true;
    L41:
        if (r4 == true) goto L43;
    L46:
        ClearScreenLogUtils.Companion r5 = ClearScreenLogUtils.a;
        DataCenter r10 = this.a;
        Map r11 = MapsKt.emptyMap();
        r5.getClass();
        ClearScreenLogUtils.Companion.d(r10, "more_panel", r11);
        ClearScreenHelper.m(true);
        com.bytedance.android.livesdk.chatroom.utils.p.b.getClass();
        com.bytedance.android.livesdk.chatroom.utils.p.a = System.currentTimeMillis();
        return;
    L43:
        if (n60.a.getValue().booleanValue() == false) goto L46;
        ALogger.w("guest_clear_screen", "try click clear screen button but refused. isClear:true");
        com.bytedance.android.live.core.utils.f2.b(2131917260, 0);
        return;
    L21:
        IInteractService r12 = jc1.k.f(IInteractService.class);
        if (r12 == null) goto L27;
        qd0.a r13 = r12.getAudioTalkService();
        if (r13 == null) goto L27;
        if (r13.q(this.c, r1.getIdString()) == true) goto L39;
    L27:
        IInteractService r14 = jc1.k.f(IInteractService.class);
        if (r14 == null) goto L33;
        com.bytedance.android.live.liveinteract.service.f r15 = r14.getInteractAudienceService();
        if (r15 == null) goto L33;
        if (r15.S(this.c, r1) == true) goto L39;
    L33:
        IInteractService r16 = jc1.k.f(IInteractService.class);
        if (r16 == null) goto L40;
        iy.g r17 = r16.getDynamicCenterService(this.a);
        if (r17 == null) goto L40;
        if (r17.Rp() == true) goto L39;
    L40:
        r4 = false;
    L7:
        r9 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        hd0.c.f().e(this.b);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        if (wt2.a.e(Boolean.valueOf(this.c)) == true) goto L5;
    L7:
        this.a = r3;
        return;
    L5:
        if (n60.a.getValue().booleanValue() == false) goto L7;
        hd0.c.f().c(this.b);
        goto L7
    }
}
