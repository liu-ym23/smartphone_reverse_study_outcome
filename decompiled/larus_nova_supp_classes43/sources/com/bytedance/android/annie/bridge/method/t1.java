package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.RequestResultModel;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.annie.service.network.AnnieNetworkError;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t1 implements u1.c {
    public final /* synthetic */ s1 a;

    public t1(s1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.annie.bridge.method.u1.c
    public final void a(RequestResultModel r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        this.a.finishWithResult(r10);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        b8.a r11 = b8.a.a;
        b8.a.a(new b8.b("RequestMethod", LogLevel.ERROR, e, null, 8), true);
    }

    @Override // com.bytedance.android.annie.bridge.method.u1.c
    public final void onFail(Throwable r13) {
        Intrinsics.checkNotNullParameter(r13, "throwable");
        s1 r0 = this.a;     // Catch: Exception -> L22
        RequestResultModel r1 = new RequestResultModel();     // Catch: Exception -> L22
        s1 r10 = this.a;     // Catch: Exception -> L22
        r1.b(RequestResultModel.Code.Failed);     // Catch: Exception -> L22
        String r11 = r13.getMessage();     // Catch: Exception -> L22
        r10.getClass();     // Catch: Exception -> L22
        int r12 = 0;
        int r14 = 0;     // Catch: Exception -> L22
        Number r15 = r14;
        if (r11 != null) goto L25;
    L14:
        r1.a(r15);     // Catch: Exception -> L22
        if ((r13 instanceof AnnieNetworkError) == false) goto L17;
        AnnieNetworkError r16 = (AnnieNetworkError) r13;     // Catch: Exception -> L22
    L18:
        if (r16 == null) goto L20;
        r12 = r16.getStatusCode();     // Catch: Exception -> L22
    L20:
        r1.d(Integer.valueOf(r12));     // Catch: Exception -> L22
        r1.e(r13.getMessage());     // Catch: Exception -> L22
        r0.finishWithResult(r1);     // Catch: Exception -> L22
        return;
    L17:
        r16 = null;
        goto L18
    L25:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L8
        int r18 = StringsKt.lastIndexOf$default(r11, "InternalErrorCode=", 0, false, 6, null);     // Catch: Throwable -> L8
        int r19 = StringsKt.indexOf$default(r11, ',', r18, false, 4, null);     // Catch: Throwable -> L8
        r15 = Integer.valueOf(CastIntegerProtector.parseInt(r11.substring(r18 + 18, r19)));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Exception -> L22
        Object r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L22
        if (Result.isFailure-impl(r21) == false) goto L12;
        Object r110 = r14;
    L13:
        r15 = (Number) r110;     // Catch: Exception -> L22
        goto L14
    L12:
        r110 = r21;
    L22:
        e = move-exception;
        b8.a r111 = b8.a.a;
        b8.a.a(new b8.b("RequestMethod", LogLevel.ERROR, e, null, 8), true);
    }
}
