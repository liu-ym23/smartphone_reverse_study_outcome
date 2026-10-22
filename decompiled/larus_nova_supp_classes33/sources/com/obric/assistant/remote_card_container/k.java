package com.obric.assistant.remote_card_container;

import android.os.IBinder;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k implements IBinder.DeathRecipient {
    public final /* synthetic */ IBinder a;
    public final /* synthetic */ Ref.ObjectRef<yca.d.a> b;

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        IBinder r1 = this.a;
        Ref.ObjectRef<yca.d.a> r2 = this.b;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L19
        FLogger.a.i("RemoteCardImpl", "binderDied, will dismiss menu");     // Catch: Throwable -> L19
        if (r1 == null) goto L25;
        r1.unlinkToDeath(this, 0);     // Catch: Throwable -> L19
    L25:
        yca.d.a r4 = (yca.d.a) r2.element;     // Catch: Throwable -> L12
        if (r4 == null) goto L9;
        r4.dismiss();     // Catch: Throwable -> L12
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L12
    L14:
        Throwable r7 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L19
        if (r7 == null) goto L17;
        FLogger.a.w("RemoteCardImpl", "dismiss menu failed", r7);     // Catch: Throwable -> L19
    L17:
        Object r8 = Result.constructor-impl(Result.box-impl(r6));     // Catch: Throwable -> L19
    L21:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L29;
        FLogger.a.w("RemoteCardImpl", "linkToDeath failed", r9);
        return;
    L29:
        return;
    L9:
        r5 = null;
    L12:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L19
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    public k(IBinder r1, Ref.ObjectRef<yca.d.a> r2) {
        this.a = r1;
        this.b = r2;
    }
}
