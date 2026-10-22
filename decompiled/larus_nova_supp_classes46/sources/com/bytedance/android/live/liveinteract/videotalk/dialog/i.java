package com.bytedance.android.live.liveinteract.videotalk.dialog;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.camera.b a;
    public final /* synthetic */ n b;
    public final /* synthetic */ ILinkPlayerInfoBridge c;
    public final /* synthetic */ Integer d;

    public i(com.bytedance.android.live.liveinteract.plantform.camera.b r1, n r2, ILinkPlayerInfoBridge r3, Integer r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(n r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        com.bytedance.android.live.liveinteract.plantform.camera.b r8 = this.a;
        ILinkPlayerInfoBridge r0 = this.c;
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.getInteractId();
        if (r2 == null) goto L6;
    L8:
        if (r8.d(r2) == this.b.o) goto L11;
        f2.b(2131918053, 0);
        a(this.b);
        return;
    L11:
        HashMap r9 = new HashMap();
        r9.put("live_type", "video_live");
        List r3 = null;
        TalkRoomLogUtils.B0(r9, null, null, 6);
        com.bytedance.live.datacontext.j r4 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r4 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r4.getValue();
        if (r5 == null) goto L18;
        if (r5.t() == null) goto L18;
        TalkRoomLogUtils.B0(r9, this.d, null, 4);
    L18:
        com.bytedance.live.datacontext.j r6 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r6 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r10 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r6.getValue();
        if (r10 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r11 = r10.t();
        if (r11 == null) goto L31;
        List r12 = r11.b;
        if (r12 == null) goto L31;
        if (r12.contains(1) == false) goto L29;
        r3 = r12;
    L29:
        if (r3 == null) goto L31;
        r9.put("play_type", "video_friend");
    L31:
        ILinkPlayerInfoBridge r13 = this.c;
        if (r13 == null) goto L37;
        IBaseUser r14 = r13.getUser();
        if (r14 == null) goto L37;
        String r15 = r14.getIdString();
        if (r15 == null) goto L37;
    L38:
        r9.put("to_user_id", r15);
        com.bytedance.android.live.liveinteract.plantform.camera.b r16 = this.a;
        ILinkPlayerInfoBridge r17 = this.c;
        if (r17 == null) goto L42;
        String r18 = r17.getInteractId();
        if (r18 == null) goto L42;
    L44:
        if (r16.d(r18) == false) goto L46;
        String r19 = "on";
    L47:
        r9.put("button_type", r19);
        ILinkPlayerInfoBridge r20 = this.c;
        if (r20 == null) goto L53;
        IBaseUser r21 = r20.getUser();
        if (r21 == null) goto L53;
        String r22 = r21.getIdString();
        if (r22 == null) goto L53;
    L54:
        TalkRoomLogUtils.g1(r9, r22);
        j0.l().sendLog("livesdk_anchor_audience_connection_user_camera_open_click", r9, new Object[]{IRoom.class});
        a(this.b);
        com.bytedance.android.live.liveinteract.plantform.camera.b r23 = this.a;
        ILinkPlayerInfoBridge r24 = this.c;
        if (r24 == null) goto L60;
        IBaseUser r25 = r24.getUser();
        if (r25 == null) goto L60;
        String r26 = r25.getIdString();
        if (r26 == null) goto L60;
    L61:
        com.bytedance.android.live.liveinteract.plantform.camera.b r27 = this.a;
        ILinkPlayerInfoBridge r28 = this.c;
        if (r28 == null) goto L67;
        String r29 = r28.getInteractId();
        if (r29 == null) goto L67;
        r1 = r29;
    L67:
        r23.b(r26, !r27.d(r1));
        return;
    L60:
        r26 = "";
    L53:
        r22 = "";
        goto L54
    L46:
        r19 = "off";
    L42:
        r18 = "";
    L37:
        r15 = "";
    L6:
        r2 = "";
        goto L8
    }
}
