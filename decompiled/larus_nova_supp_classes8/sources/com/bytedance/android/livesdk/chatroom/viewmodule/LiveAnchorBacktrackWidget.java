package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.backtrack.LiveAnchorBacktrackPreviewDialog;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveAnchorBacktrackWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public int a;
    public IAnchorBacktrackService b;
    public g1 c;

    public final String getSpm() {
        return "a100.a100.a182";
    }

    public final LiveMode getLiveMode() {
        return (LiveMode) ((Widget) this).dataCenter.get("DATA_LIVE_MODE", LiveMode.VIDEO);
    }

    public final String getRoomId() {
        return String.valueOf(((Widget) this).dataCenter.get("data_room_id", 0L));
    }

    public final String getUserId() {
        return String.valueOf(jc1.k.f(IUserService.class).user().n());
    }

    public final void xq() {
        if (this.a != 0) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.f.d().getClass();
        if (com.bytedance.android.livesdk.f.e() == false) goto L8;
        return;
    L8:
        int r0 = this.a;
        if (r0 != 1) goto L12;
    L17:
        this.a = 0;
        return;
    L12:
        if (r0 != 2) goto L15;
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.B(2131914646), 0);
        goto L17
    L15:
        if (r0 != 3) goto L17;
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.B(2131914648), 0);
        goto L17
    }

    public LiveAnchorBacktrackWidget() {
        this.a = 0;
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        com.bytedance.android.livesdk.f.d().a.removeObserver(this.c);
        ((Widget) this).dataCenter.removeObserver(this);
        this.b = null;
        Dialog r0 = com.bytedance.android.livesdk.f.d().c("ANCHOR_BACKTRACK");
        if (r0 == null) goto L6;
        wq(r0);
        return;
    }

    public static void wq(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void onChanged(Object r17) {
        KVData r1 = (KVData) r17;
        if (r1 != null) goto L6;
        return;
    L6:
        if ("data_backtrack_state_changed".equals(r1.getKey()) == false) goto L66;
        zf1.g r2 = (zf1.g) r1.getData();
        if (r2 == null) goto L79;
        IAnchorBacktrackService.State r3 = r2.a;
        IAnchorBacktrackService.State r4 = r2.b;
        int r5 = 0;
        this.a = 0;
        IAnchorBacktrackService.State r6 = IAnchorBacktrackService.State.IDLE;
        if (r3 == r6) goto L13;
    L15:
        IAnchorBacktrackService.State r15 = IAnchorBacktrackService.State.BACKTRACK_DOING;
        if (r3 == r15) goto L18;
    L32:
        if (r3 != r15) goto L35;
        if (r4 != r6) goto L35;
        com.bytedance.android.live.core.utils.f2.b(2131914653, r5);
        return;
    L35:
        IAnchorBacktrackService.State r7 = IAnchorBacktrackService.State.BACKTRACK_DONE;
        if (r3 == r7) goto L38;
    L40:
        IAnchorBacktrackService.State r8 = IAnchorBacktrackService.State.DOWNLOAD;
        if (r3 == r8) goto L43;
    L47:
        if (r3 != r8) goto L50;
        if (r4 != r7) goto L50;
        com.bytedance.android.live.core.utils.f2.b(2131914650, 0);
        zf1.d.b(false, this.b.getDuration(), getUserId(), getRoomId(), getLiveMode());
        return;
    L50:
        if (r3 == r7) goto L52;
    L54:
        IAnchorBacktrackService.State r9 = IAnchorBacktrackService.State.SAVE_DRAFT;
        if (r3 == r9) goto L57;
    L59:
        if (r3 != r9) goto L76;
        if (r4 != r7) goto L77;
        com.bytedance.android.live.core.utils.f2.b(2131914655, 0);
        zf1.d.c(false, this.b.getDuration(), getUserId(), getRoomId(), getLiveMode());
        return;
    L77:
        return;
    L76:
        return;
    L57:
        if (r4 != IAnchorBacktrackService.State.DONE) goto L59;
        com.bytedance.android.live.core.utils.f2.b(2131914656, 0);
        zf1.d.c(true, this.b.getDuration(), getUserId(), getRoomId(), getLiveMode());
        return;
    L52:
        if (r4 != IAnchorBacktrackService.State.SAVE_DRAFT) goto L54;
        this.a = 3;
        xq();
        return;
    L43:
        if (r4 != IAnchorBacktrackService.State.DONE) goto L47;
        com.bytedance.android.live.core.utils.f2.b(2131914651, 0);
        zf1.d.b(true, this.b.getDuration(), getUserId(), getRoomId(), getLiveMode());
        String r10 = r2.c;
        if (r10 == null) goto L71;
        getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new PolarisFileWrapper(r10))));
        return;
    L71:
        return;
    L38:
        if (r4 != IAnchorBacktrackService.State.DOWNLOAD) goto L40;
        this.a = 2;
        xq();
        return;
    L18:
        if (r4 == IAnchorBacktrackService.State.BACKTRACK_DONE) goto L20;
        r5 = 0;
        goto L32
    L20:
        if (com.bytedance.android.livesdk.f.d().c("ANCHOR_BACKTRACK") != null) goto L30;
        Dialog r11 = com.bytedance.android.livesdk.f.d().c("MORE");
        if (r11 == null) goto L25;
        wq(r11);
    L25:
        LiveAnchorBacktrackPreviewDialog r12 = new LiveAnchorBacktrackPreviewDialog(getContext(), ((Widget) this).dataCenter);
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L64;
        DialogLancet.handleBlockedDialogShow(r12);
        goto L30
    L64:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L63
    L29:
        DialogLancet.beforeDialogShow(r12);
        r12.show();
        DialogLancet.afterDialogShow(r12);
    L30:
        long r13 = this.b.getDuration();
        String r14 = getUserId();
        String r16 = getRoomId();
        LiveMode r18 = getLiveMode();
        HashMap r19 = new HashMap();
        r19.put("anchor_id", r14);
        r19.put("live_type", com.bytedance.android.livesdk.utils.j.a(r18));
        r19.put("room_id", r16);
        r19.put("_param_live_platform", "live");
        r19.put("event_belong", "live");
        r19.put("event_page", "live_take_detail");
        r19.put("duration", String.valueOf(r13));
        r19.put("local_time_ms", String.valueOf(System.currentTimeMillis()));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_back_record_over", r19, new Object[0]);
        return;
    L13:
        if (r4 != IAnchorBacktrackService.State.BACKTRACK_DOING) goto L15;
        this.a = 1;
        xq();
        String r20 = getUserId();
        String r21 = getRoomId();
        LiveMode r22 = getLiveMode();
        HashMap r23 = new HashMap();
        r23.put("anchor_id", r20);
        r23.put("live_type", com.bytedance.android.livesdk.utils.j.a(r22));
        r23.put("room_id", r21);
        r23.put("_param_live_platform", "live");
        r23.put("event_belong", "live");
        r23.put("event_page", "live_take_detail");
        r23.put("local_time_ms", String.valueOf(System.currentTimeMillis()));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_back_record_start", r23, new Object[0]);
        return;
    L79:
        return;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.android.livesdk.chatroom.viewmodule.g1] */
    public final void onInit(Object[] r1) {
        this.c = new g1(this);
    }

    public final void onLoad(Object[] r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.b = (IAnchorBacktrackService) ((Widget) this).dataCenter.get("data_backtrack_service", null);
        ((Widget) this).dataCenter.observeForever("data_backtrack_state_changed", this);
        com.bytedance.android.livesdk.f.d().a.observe(this, this.c);
    }
}
