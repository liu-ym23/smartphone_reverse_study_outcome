package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ AdjustGuestPositionDialog a;

    public a(AdjustGuestPositionDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.AdjustGuestPositionDialog, java.lang.Object] */
    public final void accept(Object r10) {
        com.bytedance.android.live.network.response.e r11 = (com.bytedance.android.live.network.response.e) r10;
        if (r11 == null) goto L5;
        com.bytedance.android.livesdk.multilink.base.model.d r1 = (com.bytedance.android.livesdk.multilink.base.model.d) r11.data;
    L6:
        if (r1 != null) goto L8;
    L41:
        ?? r12 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r12);
        if (r0 != null) goto L44;
    L46:
        DialogLancet.beforeDialogDismiss(r12);
        r12.dismiss();     // Catch: Throwable -> L49 Exception -> L51
    L55:
        DialogLancet.afterDialogDismiss(r12);
        return;
    L51:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L49
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L49
        if (r2 == null) goto L55;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r12);
        throw th;
    L44:
        if (Looper.myLooper() == r0.getLooper()) goto L46;
        r0.post(DialogLancet.createDismissRunnable(r12));
        return;
    L8:
        if (d.a() == false) goto L33;
        int r3 = AdjustGuestPositionDialog.v;
        ALogger.i("AdjustGuestPositionDialog", "调整麦位成功，主播端处理SEI数据");
        IRoom r4 = this.a.j;
        if (r4 != null) goto L12;
    L23:
        rj0.k.m2.getClass();
        rj0.k r5 = rj0.k.a.a();
        if (r5 == null) goto L28;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r6 = r5.getLinkUserInfoCenter();
        if (r6 == null) goto L28;
        r6.S4(((com.bytedance.android.livesdk.multilink.base.model.d) r11.data).getLinkedUsers(), ((com.bytedance.android.livesdk.multilink.base.model.d) r11.data).getClientUiInfo(), ((com.bytedance.android.livesdk.multilink.base.model.d) r11.data).getVersion(), "adjustPosition");
    L28:
        com.bytedance.android.live.liveinteract.plantform.base.a.g0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.a r13 = com.bytedance.android.live.liveinteract.plantform.base.a.C0047a.a();
        if (r13 == null) goto L33;
        hg6.g r14 = r13.R1();
        if (r14 == null) goto L33;
        r14.f();
        goto L33
    L12:
        if (r4.isLiveTypeAudio() != true) goto L23;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r7 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r7 == null) goto L18;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r8 = r7.getLinkUserInfoCenter();
        if (r8 == null) goto L18;
        r8.S4(((com.bytedance.android.livesdk.multilink.base.model.d) r11.data).getLinkedUsers(), ((com.bytedance.android.livesdk.multilink.base.model.d) r11.data).getClientUiInfo(), ((com.bytedance.android.livesdk.multilink.base.model.d) r11.data).getVersion(), "adjustPosition");
    L18:
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r15 = IVoiceChatAdminService.a.a();
        if (r15 == null) goto L33;
        hg6.g r16 = r15.rtcManger();
        if (r16 == null) goto L33;
        r16.f();
    L33:
        int r17 = f.a;
        AdjustGuestPositionDialog r18 = this.a;
        int r9 = r18.f;
        int r19 = r18.o;
        HashMap r20 = new HashMap();
        TalkRoomLogUtils.B0(r20, Integer.valueOf(je0.d.f()), null, 4);
        r20.put("seat_num", String.valueOf(r9));
        r20.put("to_seat_num", String.valueOf(r19));
        r20.put("is_guest", "1");
        Integer r110 = je0.d.h();
        if (r110 != null) goto L37;
    L39:
        String r111 = "classic";
    L40:
        r20.put("play_layout", r111);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_seat_order_submit_success", r20, new Object[]{IRoom.class, am2.x.class});
        goto L41
    L37:
        if (r110.intValue() != 28) goto L39;
        r111 = "avatar";
        goto L40
    L5:
        r1 = null;
        goto L6
    }
}
