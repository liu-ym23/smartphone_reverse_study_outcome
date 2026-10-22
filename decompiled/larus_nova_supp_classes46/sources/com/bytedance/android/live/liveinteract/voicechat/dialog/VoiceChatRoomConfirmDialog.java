package com.bytedance.android.live.liveinteract.voicechat.dialog;

import am2.x;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.e6;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.KtvConflictScene;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/dialog/VoiceChatRoomConfirmDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VoiceChatRoomConfirmDialog extends CommonBottomDialog {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ VoiceChatRoomConfirmDialog a;

        public a(VoiceChatRoomConfirmDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            VoiceChatRoomConfirmDialog.M0(this.a, "radio");
            if (this.a.isViewValid() == false) goto L24;
            IInteractService r5 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r5 == null) goto L7;
            r5.initAndTurnOnVoiceChatRoom();
        L7:
            CommonBottomDialog r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r1 == null) goto L21;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L10:
            if (Looper.myLooper() == r0.getLooper()) goto L12;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ VoiceChatRoomConfirmDialog a;

        public b(VoiceChatRoomConfirmDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            VoiceChatRoomConfirmDialog.M0(this.a, "ktv");
            j0.l().sendLog("anchor_ktv_open", null, new Object[]{IRoom.class, x.class});
            if (jc1.k.n(IKtvService.class).requestConflictCheck(KtvConflictScene.SCENE_KTV) == true) goto L6;
            return;
        L6:
            if (this.a.isViewValid() == false) goto L27;
            IInteractService r5 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r5 == null) goto L10;
            r5.initAndTurnOnKTV();
        L10:
            CommonBottomDialog r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L13;
        L15:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L18 Exception -> L20
        L24:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L18:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
            if (r1 == null) goto L24;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
            goto L24
        L13:
            if (Looper.myLooper() == r0.getLooper()) goto L15;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ VoiceChatRoomConfirmDialog a;

        public c(VoiceChatRoomConfirmDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            VoiceChatRoomConfirmDialog.M0(this.a, "ktv");
            j0.l().sendLog("anchor_ktv_open", null, new Object[]{IRoom.class, x.class});
            if (jc1.k.n(IKtvService.class).requestConflictCheck(KtvConflictScene.SCENE_KTV) == true) goto L6;
            return;
        L6:
            if (this.a.isViewValid() == false) goto L27;
            IInteractService r5 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r5 == null) goto L10;
            r5.initAndTurnOnChorusKTV();
        L10:
            CommonBottomDialog r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L13;
        L15:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L18 Exception -> L20
        L24:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L18:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
            if (r1 == null) goto L24;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
            goto L24
        L13:
            if (Looper.myLooper() == r0.getLooper()) goto L15;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        }
    }

    public final int getLayoutId() {
        return 2131567949;
    }

    public VoiceChatRoomConfirmDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        boolean r7 = true;
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        View r0 = findViewById(2131365585);
        if (r0 == null) goto L5;
        r0.setOnClickListener(new a(this));
    L5:
        View r1 = findViewById(2131377041);
        if (r1 == null) goto L8;
        r1.setOnClickListener(new b(this));
    L8:
        ConstraintLayout r2 = findViewById(2131376895);
        if (r2 == null) goto L44;
        Integer r3 = (Integer) e6.a.getValue();
        int r4 = 0;
        if (r3 != null) goto L14;
    L29:
        if (r3 != null) goto L32;
    L34:
        if (r3 != null) goto L37;
    L39:
        r7 = false;
    L40:
        if (r7 == true) goto L43;
        r4 = 8;
    L43:
        r2.setVisibility(r4);
        goto L44
    L37:
        if (r3.intValue() != 2) goto L39;
    L32:
        if (r3.intValue() != 1) goto L34;
    L14:
        if (r3.intValue() != 0) goto L29;
        com.bytedance.android.livesdk.chatroom.o r5 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r5 == null) goto L26;
        com.bytedance.live.datacontext.m r8 = r5.getRoom();
        if (r8 == null) goto L26;
        IRoom r9 = (IRoom) r8.getValue();
        if (r9 == null) goto L26;
        Map r10 = r9.getAnchorABMap();
        if (r10 == null) goto L26;
        String r11 = (String) r10.get("real_time_chorus");
        if (r11 == null) goto L26;
        int r12 = CastIntegerProtector.parseInt(r11);
    L27:
        if (r12 <= 0) goto L39;
    L26:
        r12 = 0;
    L44:
        ConstraintLayout r13 = findViewById(2131376895);
        if (r13 == null) goto L48;
        r13.setOnClickListener(new c(this));
        return;
    }

    public static final void M0(VoiceChatRoomConfirmDialog r3, String r4) {
        r3.getClass();
        HashMap r5 = new HashMap();
        r5.put("room_type", "radio");
        r5.put("live_type", "voice_live");
        r5.put("function_type", r4);
        j0 r6 = j0.l();
        x r1 = new x();
        r1.b = "live_detail";
        r1.a = "live";
        r1.e = "click";
        r6.sendLog("anchor_audience_connection_open", r5, new Object[]{r1, IRoom.class});
    }
}
