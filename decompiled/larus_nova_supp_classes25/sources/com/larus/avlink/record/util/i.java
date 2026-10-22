package com.larus.avlink.record.util;

import com.larus.avlink.n1;
import com.larus.common.apphost.AppHost;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i implements yk9.b {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Integer e;
    public final /* synthetic */ String f;
    public final /* synthetic */ s g;
    public final /* synthetic */ kotlinx.coroutines.i<RetryDecision> h;

    public final void onSuccess(String r34) {
        Intrinsics.checkNotNullParameter(r34, "onlineRecordingId");
        n1.d("LarkRecordMinutesManager", "GRecord lark retry success, recordingId=" + r34);
        long r14 = System.currentTimeMillis() - this.a;
        int r2 = a.a;
        a.i(true, this.b, this.c, this.d, this.e, this.f, r14, null, null, this.g);
        a.l(true, this.b, this.c, this.d, this.e, this.f, System.currentTimeMillis() - LarkRecordMinutesManager.E, null, null, null, null, null, this.g, 3968);
        LarkRecordMinutesManager.a.getClass();
        if (r34 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        n1.b("LarkRecordMinutesManager", "GRecord open recording page failed, recordingId is null or empty");
    L19:
        if (this.h.isActive() == false) goto L22;
        kotlinx.coroutines.i<RetryDecision> r1 = this.h;
        Result.Companion r4 = Result.Companion;
        r1.resumeWith(Result.constructor-impl(RetryDecision.SUCCESS));
        return;
    L22:
        return;
    L11:
        AppHost.Companion r5 = AppHost.a;
        if (r5.a().isAppBackground() == false) goto L17;
        n1.d("LarkRecordMinutesManager", "GRecord app in background, defer open recording page until foreground, recordingId=" + r34);
        f09.a.b r6 = LarkRecordMinutesManager.G;
        if (r6 == null) goto L16;
        r5.a().c(r6);
    L16:
        j r7 = new j(r34);
        LarkRecordMinutesManager.G = r7;
        r5.a().j(r7);
        goto L19
    L17:
        LarkRecordMinutesManager.A(r34);
        goto L19
    L5:
        if (r34.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final void onFail(int r21, String r22) {
        boolean r1 = yk9.f.a.contains(Integer.valueOf(r21));
        n1.b("LarkRecordMinutesManager", "GRecord lark retry failed, code=" + r21 + ", msg=" + r22 + ", terminal=" + r1);
        long r11 = System.currentTimeMillis() - this.a;
        int r2 = a.a;
        a.i(false, this.b, this.c, this.d, this.e, this.f, r11, String.valueOf(r21), r22, this.g);
        if (r1 == false) goto L6;
        a.l(false, this.b, this.c, this.d, this.e, this.f, System.currentTimeMillis() - LarkRecordMinutesManager.E, "sdk", "sdk_retry_create_failed", String.valueOf(r21), r22, null, this.g, 2048);
    L6:
        if (this.h.isActive() == false) goto L13;
        kotlinx.coroutines.i<RetryDecision> r3 = this.h;
        Result.Companion r4 = Result.Companion;
        if (r1 == false) goto L10;
        RetryDecision r5 = RetryDecision.TERMINAL;
    L11:
        r3.resumeWith(Result.constructor-impl(r5));
        return;
    L10:
        r5 = RetryDecision.RETRY;
        goto L11
    }

    public i(long r1, String r3, String r4, String r5, Integer r6, String r7, s r8, kotlinx.coroutines.j r9) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
