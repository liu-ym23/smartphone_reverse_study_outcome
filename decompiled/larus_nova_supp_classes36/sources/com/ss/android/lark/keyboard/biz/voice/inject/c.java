package com.ss.android.lark.keyboard.biz.voice.inject;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.log.Log;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ int c;
    public final /* synthetic */ MonitorMessageSendCallback d;

    public c(a r1, Message r2, int r3, MonitorMessageSendCallback r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        a r1 = this.a;     // Catch: Throwable -> L8
        r1.c(this.b, this.c, this.d, r1.b.c());     // Catch: Throwable -> L8
        com.ss.android.lark.keyboard.b r2 = this.a.b.n();     // Catch: Throwable -> L8
        if (r2 == null) goto L10;
        k r3 = r2.e();     // Catch: Throwable -> L8
        if (r3 == null) goto L10;
        r3.a(q.a.a, r3.b());     // Catch: Throwable -> L8
    L10:
        this.a.getClass();     // Catch: Throwable -> L8
        this.a.getClass();
        a r0 = this.a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L19
        r0.i.getClass();     // Catch: Throwable -> L19
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L13:
        Result.constructor-impl(r5);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L8:
        th = move-exception;
        this.a.getClass();     // Catch: Throwable -> L22
        Log.e("ExternalPcmVoiceSession", "stopAndSend, sendAudioMsg failed: " + th.getMessage(), th);     // Catch: Throwable -> L22
        this.a.getClass();
        a r7 = this.a;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L19
        r7.i.getClass();     // Catch: Throwable -> L19
        r5 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L22:
        th = move-exception;
        this.a.getClass();
        a r9 = this.a;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L26
        r9.i.getClass();     // Catch: Throwable -> L26
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        throw th;
    L26:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
