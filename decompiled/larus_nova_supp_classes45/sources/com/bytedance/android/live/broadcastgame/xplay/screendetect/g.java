package com.bytedance.android.live.broadcastgame.xplay.screendetect;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g extends Handler {
    public final /* synthetic */ XplayAudienceScreenDetector a;

    @Override // android.os.Handler
    public final void handleMessage(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (r4.what != 2) goto L16;
        this.a.b("receive msg, start detect");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L7
        XplayAudienceScreenDetector.h(this.a, this);     // Catch: Throwable -> L7
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        final Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L12;
        XplayAudienceScreenDetector r1 = this.a;
        r1.getClass();
        a.d(r1, "ttlive_xplay_audience_screen_detect", a.a(r1, new XplayAudienceScreenDetector$reportDetectFailed$1(r7)));
    L12:
        sendEmptyMessageDelayed(2, this.a.i().a());
        return;
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public g(XplayAudienceScreenDetector r1, Looper r2) {
        this.a = r1;
        super(r2);
    }

    @Override // android.os.Handler
    public final boolean sendMessageAtTime(Message r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (r2.getCallback() == null) goto L7;
        r2.getCallback().run();
        return true;
    L7:
        return super.sendMessageAtTime(r2, r3);
    }
}
