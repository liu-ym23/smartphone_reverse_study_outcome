package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.backtrack.LiveAnchorBacktrackPreviewDialog;
import com.bytedance.android.livesdk.chatroom.liverecord.RecordEntranceDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.widget.LiveCircleProgressView;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class ToolbarAnchorRecordBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, Observer<KVData> {
    public DataCenter a;
    public View b;
    public LiveCircleProgressView c;
    public IAnchorBacktrackService d;
    public boolean e;
    public final FragmentActivity f;
    public com.bytedance.android.live.pushstream.d g;
    public boolean h;
    public final a i;
    public final g2 j;

    public class a extends tp2.b {
        public a(ToolbarAnchorRecordBehavior r1) {
        }
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
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final void a() {
        zf1.d.a(String.valueOf(jc1.k.f(IUserService.class).user().n()), String.valueOf(this.a.get("data_room_id", 0L)), (LiveMode) this.a.get("data_live_mode", LiveMode.VIDEO));
        FragmentActivity r0 = this.f;
        int r1 = ita.i.a;
        if (NetworkUtils.isNetworkAvailable(r0) == true) goto L6;
        com.bytedance.android.live.core.utils.f2.b(2131916005, 0);
        return;
    L6:
        Room r2 = (Room) this.a.get("data_room", null);
        if (((System.currentTimeMillis() / 1000) - r2.getCreateTime()) >= 60) goto L10;
        com.bytedance.android.live.core.utils.f2.b(2131914657, 0);
        return;
    L10:
        IAnchorBacktrackService.State r3 = this.d.getState();
        if (r3 != IAnchorBacktrackService.State.IDLE) goto L18;
        if (com.bytedance.android.livesdk.chatroom.record.u.d(this.a) == false) goto L15;
        com.bytedance.android.live.core.utils.f2.b(2131921607, 0);
    L16:
        this.e = true;
        return;
    L15:
        this.d.startBacktrack();
        goto L16
    L18:
        if (r3 != IAnchorBacktrackService.State.BACKTRACK_DOING) goto L26;
        LiveAnchorBacktrackPreviewDialog r4 = new LiveAnchorBacktrackPreviewDialog(this.b.getContext(), this.a);
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L42;
        DialogLancet.handleBlockedDialogShow(r4);
    L24:
        this.e = true;
        return;
    L42:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40
    L23:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
        goto L24
    L26:
        if (r3 != IAnchorBacktrackService.State.DOWNLOAD) goto L29;
        com.bytedance.android.live.core.utils.f2.b(2131915236, 0);
        this.e = true;
        return;
    L29:
        if (r3 != IAnchorBacktrackService.State.SAVE_DRAFT) goto L32;
        com.bytedance.android.live.core.utils.f2.b(2131915237, 0);
        this.e = true;
        return;
    L32:
        if (r3 != IAnchorBacktrackService.State.BACKTRACK_DONE) goto L50;
        LiveAnchorBacktrackPreviewDialog r5 = new LiveAnchorBacktrackPreviewDialog(this.b.getContext(), this.a);
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L44;
        DialogLancet.handleBlockedDialogShow(r5);
    L38:
        this.e = true;
        return;
    L44:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41
    L37:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        goto L38
    }

    public final void b() {
        if (this.g != null) goto L5;
        ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).init();
        this.g = jc1.k.f(IPushStreamService.class).getRecordLiveStream(this.f);
    L5:
        com.bytedance.android.live.pushstream.d r2 = this.g;
        xs2.b.a().post(new zg1.n1(r2, this.i, false, 0, false, "more_function"));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.b.p.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.r;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r2) {
        if ((r2 instanceof pp1.b) == false) goto L8;
        if (this.b == null) goto L8;
        this.h = ((pp1.b) r2).a;
        return;
    L8:
        if ((r2 instanceof pp1.a) == false) goto L12;
        b();
        return;
    }

    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        KVData r2 = (KVData) r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        HashMap r7 = new HashMap();
        r7.put("is_anchor", "1");
        r7.put("is_landscape", "0");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_combined_record_button_click", r7, new Object[]{Room.class, am2.x.class});
        if (this.h == true) goto L6;
        com.bytedance.android.live.core.utils.f2.b(2131921607, 0);
        return;
    L6:
        com.bytedance.android.livesdk.sharedpref.e r8 = com.bytedance.android.livesdk.sharedpref.b.p;
        if (((Boolean) r8.getValue()).booleanValue() == false) goto L10;
        com.bytedance.android.livesdk.sharedpref.f.d(r8, Boolean.FALSE);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.a).b(ToolbarButton.MORE, new pp1.j(false));
    L10:
        if (this.d.getState() != IAnchorBacktrackService.State.IDLE) goto L12;
        FragmentActivity r9 = this.f;
        kh1.a r0 = kh1.a.a;
        List r1 = kh1.a.a((Room) this.a.get("data_room"));
        g2 r2 = this.j;
        int r3 = RecordEntranceDialog.h;
        RecordEntranceDialog.a.a(r9, r1, r2, true);
        this.a.put("cmd_live_toolbarmore_dialog_dismiss", new Object());
        return;
    L12:
        a();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.g2] */
    public ToolbarAnchorRecordBehavior(FragmentActivity r2, com.bytedance.android.live.pushstream.d r3) {
        this.e = true;
        this.h = true;
        this.i = new a(this);
        this.j = new g2(this);
        this.f = r2;
        this.g = r3;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r1, DataCenter r2) {
        this.a.removeObserver(this);
        this.e = false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r4, DataCenter r5) {
        this.b = r4;
        LiveCircleProgressView r6 = (LiveCircleProgressView) r4.findViewById(2131362568);
        this.c = r6;
        if (r6 == null) goto L5;
        r6.setProgressColor(-1291845633);
        this.c.setCircleWidth(com.bytedance.android.live.core.utils.s1.f(2.0f));
        this.c.setBgCircleWidth(com.bytedance.android.live.core.utils.s1.f(2.0f));
        this.c.setBgCircleColor(432325828);
        this.c.setMaxProgress(100);
    L5:
        this.a = r5;
        r5.observe("data_backtrack_state_changed", this);
        this.a.observe("data_backtrack_progress_changed", this);
        this.d = (IAnchorBacktrackService) this.a.get("data_backtrack_service", null);
        View r7 = this.b.findViewById(2131374718);
        ((ImageView) this.b.findViewById(2131362567)).setVisibility(8);
        r7.setBackgroundResource(2131251399);
        HashMap r8 = new HashMap();
        r8.put("is_anchor", "1");
        r8.put("is_landscape", "0");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_combined_record_button_show", r8, new Object[]{Room.class, am2.x.class});
    }
}
