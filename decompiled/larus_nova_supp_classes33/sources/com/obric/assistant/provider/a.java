package com.obric.assistant.provider;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindow$DefaultImpls;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ IAssistantChatWindow a;
    public final /* synthetic */ String b;

    public /* synthetic */ a(CameraAutoSendProvider r1, IAssistantChatWindow r2, String r3) {
        this.a = r2;
        this.b = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAssistantChatWindow r0 = this.a;
        String r13 = this.b;
        int r1 = CameraAutoSendProvider.a;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        r0.interruptMovingBackground();     // Catch: Throwable -> L5
        Boolean r3 = Boolean.FALSE;     // Catch: Throwable -> L5
        Bundle r4 = new Bundle();     // Catch: Throwable -> L5
        r4.putString("camera_auto_send_request_id", r13);     // Catch: Throwable -> L5
        r4.putBoolean("arg_launch_half_screen", true);     // Catch: Throwable -> L5
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L5
        IAssistantChatWindow$DefaultImpls.openChatWindow$default(r0, "camera_auto_send", false, r3, r4, false, false, null, null, true, false, 512, null);     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L13;
        FLogger.a.e("CameraAutoSendProvider", "openChatWindow failed", r7);
        final ica.a r8 = ica.b.b(r13);
        t0.a(new e(r8));
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
