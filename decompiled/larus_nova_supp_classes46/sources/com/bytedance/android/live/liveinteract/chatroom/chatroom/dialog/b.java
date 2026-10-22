package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ AdjustGuestPositionDialog a;

    public b(AdjustGuestPositionDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r8v3, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.AdjustGuestPositionDialog, java.lang.Object] */
    public final void accept(Object r8) {
        CustomApiServerException r9 = (Throwable) r8;
        Intrinsics.checkNotNullParameter(r9, "error");
        if (com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r9) != 4004339) goto L13;
        int r0 = f.a;
        int r1 = this.a.f;
        Intrinsics.checkNotNullParameter("end", "failReason");
        HashMap r2 = new HashMap();
        TalkRoomLogUtils.B0(r2, Integer.valueOf(je0.d.f()), null, 4);
        r2.put("seat_num", String.valueOf(r1));
        r2.put("fail_reason", "end");
        Integer r3 = je0.d.h();
        if (r3 != null) goto L8;
    L10:
        String r4 = "classic";
    L11:
        r2.put("play_layout", r4);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_seat_order_submit_fail", r2, new Object[]{IRoom.class, am2.x.class});
        goto L13
    L8:
        if (r3.intValue() != 28) goto L10;
        r4 = "avatar";
    L13:
        if ((r9 instanceof CustomApiServerException) == false) goto L18;
        CustomApiServerException r10 = r9;
        if (TextUtils.isEmpty(r10.getPrompt()) == true) goto L17;
        f2.c(r10.getPrompt(), 0);
    L17:
        int r5 = AdjustGuestPositionDialog.v;
        ALogger.e("AdjustGuestPositionDialog", String.valueOf(r10.getErrorCode()));
    L19:
        ?? r11 = this.a;
        Handler r6 = DialogLancet.resolveDialogHandler(r11);
        if (r6 != null) goto L22;
    L24:
        DialogLancet.beforeDialogDismiss(r11);
        r11.dismiss();     // Catch: Throwable -> L27 Exception -> L29
    L33:
        DialogLancet.afterDialogDismiss(r11);
        return;
    L29:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L27
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L27
        if (r7 == null) goto L33;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r11);
        throw th;
    L22:
        if (Looper.myLooper() == r6.getLooper()) goto L24;
        r6.post(DialogLancet.createDismissRunnable(r11));
        return;
    L18:
        int r12 = AdjustGuestPositionDialog.v;
        ALogger.e("AdjustGuestPositionDialog", r9.getMessage());
        goto L19
    }
}
