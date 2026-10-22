package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.backtrack.LiveAnchorBacktrackPreviewDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.ya;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class ToolbarAnchorBacktrackBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, Observer<KVData> {
    public DataCenter a;
    public View b;
    public IAnchorBacktrackService c;
    public boolean d;

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
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final void a() {
        View r0 = this.b.findViewById(2131374718);
        ((TextView) this.b.findViewById(2131380593)).setText(2131914659);
        int r1 = ya.a.getValue().intValue();
        if (r1 > 0) goto L5;
        r1 = 5;
    L5:
        boolean r2 = true;
        if (r1 != 1) goto L8;
        int r3 = 2131250797;
    L18:
        r0.setBackgroundResource(r3);
        if (com.bytedance.android.livesdk.utils.j.b() == false) goto L21;
    L24:
        if (r2 == false) goto L26;
        this.b.setAlpha(1.0f);
        return;
    L26:
        this.b.setAlpha(0.5f);
        return;
    L21:
        if (this.c.getState() != IAnchorBacktrackService.State.IDLE) goto L24;
        r2 = false;
        goto L24
    L8:
        if (r1 != 2) goto L10;
        r3 = 2131250799;
        goto L18
    L10:
        if (r1 != 3) goto L12;
        r3 = 2131250798;
        goto L18
    L12:
        if (r1 == 4) goto L14;
        r3 = 2131250795;
        goto L18
    L14:
        r3 = 2131250796;
        goto L18
    }

    public ToolbarAnchorBacktrackBehavior() {
        this.d = false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return com.bytedance.android.livesdk.utils.j.d();
    }

    public final void onChanged(Object r2) {
        KVData r3 = (KVData) r2;
        if (r3 != null) goto L6;
        return;
    L6:
        if ("data_backtrack_state_changed".equals(r3.getKey()) == false) goto L9;
        a();
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (com.bytedance.android.livesdk.utils.j.d() == false) goto L5;
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.X1;
        Boolean r2 = Boolean.TRUE;
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r2);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.a).b(ToolbarButton.MORE, new pp1.j(false));
    L5:
        zf1.d.a(String.valueOf(jc1.k.f(IUserService.class).user().n()), String.valueOf(this.a.get("data_room_id", 0L)), (LiveMode) this.a.get("data_live_mode", LiveMode.VIDEO));
        Context r8 = r7.getContext();
        int r1 = ita.i.a;
        if (NetworkUtils.isNetworkAvailable(r8) == true) goto L10;
        com.bytedance.android.live.core.utils.f2.b(2131916005, 0);
        return;
    L10:
        if (com.bytedance.android.livesdk.utils.j.b() == false) goto L12;
    L15:
        boolean r9 = true;
    L16:
        if (r9 == true) goto L19;
        com.bytedance.android.live.core.utils.f2.b(2131914654, 0);
        return;
    L19:
        Room r10 = (Room) this.a.get("data_room", null);
        if (((System.currentTimeMillis() / 1000) - r10.getCreateTime()) >= 60) goto L23;
        com.bytedance.android.live.core.utils.f2.b(2131914657, 0);
        return;
    L23:
        IAnchorBacktrackService.State r11 = this.c.getState();
        if (r11 != IAnchorBacktrackService.State.IDLE) goto L31;
        if (com.bytedance.android.livesdk.chatroom.record.u.d(this.a) == false) goto L28;
        com.bytedance.android.live.core.utils.f2.b(2131921607, 0);
    L29:
        this.d = true;
        return;
    L28:
        this.c.startBacktrack();
        goto L29
    L31:
        if (r11 != IAnchorBacktrackService.State.BACKTRACK_DOING) goto L39;
        LiveAnchorBacktrackPreviewDialog r12 = new LiveAnchorBacktrackPreviewDialog(this.b.getContext(), this.a);
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L55;
        DialogLancet.handleBlockedDialogShow(r12);
    L37:
        this.d = true;
        return;
    L55:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L53
    L36:
        DialogLancet.beforeDialogShow(r12);
        r12.show();
        DialogLancet.afterDialogShow(r12);
        goto L37
    L39:
        if (r11 != IAnchorBacktrackService.State.DOWNLOAD) goto L42;
        com.bytedance.android.live.core.utils.f2.b(2131915236, 0);
        this.d = true;
        return;
    L42:
        if (r11 != IAnchorBacktrackService.State.SAVE_DRAFT) goto L45;
        com.bytedance.android.live.core.utils.f2.b(2131915237, 0);
        this.d = true;
        return;
    L45:
        if (r11 != IAnchorBacktrackService.State.BACKTRACK_DONE) goto L63;
        LiveAnchorBacktrackPreviewDialog r13 = new LiveAnchorBacktrackPreviewDialog(this.b.getContext(), this.a);
        if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L57;
        DialogLancet.handleBlockedDialogShow(r13);
    L51:
        this.d = true;
        return;
    L57:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L54
    L50:
        DialogLancet.beforeDialogShow(r13);
        r13.show();
        DialogLancet.afterDialogShow(r13);
        goto L51
    L63:
        return;
    L12:
        if (this.c.getState() != IAnchorBacktrackService.State.IDLE) goto L15;
        r9 = false;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r1, DataCenter r2) {
        this.a.removeObserver(this);
        this.a = null;
        this.c = null;
        this.b = null;
        this.d = false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        this.b = r2;
        this.a = r3;
        r3.observe("data_backtrack_state_changed", this);
        this.c = (IAnchorBacktrackService) this.a.get("data_backtrack_service", null);
        a();
    }
}
