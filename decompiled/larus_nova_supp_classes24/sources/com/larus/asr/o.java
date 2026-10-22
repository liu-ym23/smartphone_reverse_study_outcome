package com.larus.asr;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.asr.handsfree.AsrInputMode;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ ChatBottomSpeakerComponent a;
    public final /* synthetic */ FragmentActivity b;

    public /* synthetic */ o(ChatBottomSpeakerComponent r1, FragmentActivity r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatBottomSpeakerComponent r0 = this.a;
        FragmentActivity r1 = this.b;
        if (r0.L1 == AsrInputMode.HANDSFREE) goto L34;
        FLogger.a.i("ChatBottomSpeakerComponent", "[HF] onStop settled: skip, mode=" + r0.L1);
        return;
    L34:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl(Boolean.valueOf(AppHost.a.a().isAppBackground()));     // Catch: Throwable -> L7
    L9:
        Boolean r4 = Boolean.FALSE;
        if (Result.isFailure-impl(r3) == false) goto L12;
        r3 = r4;
    L12:
        boolean r5 = ((Boolean) r3).booleanValue();
        Object r6 = Result.constructor-impl(AppHost.a.a().getCurrentActivity());     // Catch: Throwable -> L15
    L17:
        String r7 = null;
        if (Result.isFailure-impl(r6) == false) goto L20;
        r6 = null;
    L20:
        Activity r8 = (Activity) r6;
        boolean r9 = r8 instanceof com.larus.bmhome.chat.d4;
        FLogger r10 = FLogger.a;
        StringBuilder r11 = new StringBuilder("[HF] onStop settled: appBackground=");
        r11.append(r5);
        r11.append(" top=");
        if (r8 == null) goto L23;
        String r12 = r8.getClass().getSimpleName();
    L24:
        r11.append(r12);
        r11.append(" topIsChat=");
        r11.append(r9);
        r11.append(" stop=");
        if (r1 == null) goto L27;
        r7 = r1.getClass().getSimpleName();
    L27:
        r11.append(r7);
        r10.i("ChatBottomSpeakerComponent", r11.toString());
        if (r5 == false) goto L30;
        r10.i("ChatBottomSpeakerComponent", "[HF] onStop settled: app background, keep handsfree recording");
        return;
    L30:
        r0.Q1 = true;
        r0.q4("chat_on_stop_foreground_backfill");
        return;
    L23:
        r12 = null;
    L15:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }
}
