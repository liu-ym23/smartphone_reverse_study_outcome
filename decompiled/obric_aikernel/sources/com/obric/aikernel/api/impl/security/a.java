package com.obric.aikernel.api.impl.security;

import com.google.gson.d;
import com.google.gson.k;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4466a = null;

    static {
        f4466a = new a();
    }

    private a() {
    }

    public final String a(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return (String) r10;
    }

    public final boolean b(String r10) {
        boolean r11 = true;
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L10:
        if (r12 == false) goto L47;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L13
        AIKLog.INSTANCE.w("CertProvisionState", "checkProvisionState empty state");     // Catch: Throwable -> L13
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        return false;
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L15
    L47:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L28
        k r16 = (k) new d().k(r10, k.class);     // Catch: Throwable -> L28
        boolean r17 = r16.v("platform_param_provisioned").a();     // Catch: Throwable -> L28
        boolean r18 = r16.v("tls_cert_provisioned").a();     // Catch: Throwable -> L28
        boolean r19 = r16.v("dev_cert_provisioned").a();     // Catch: Throwable -> L28
        AIKLog.INSTANCE.d("CertProvisionState", "checkProvisionState plat:" + r17 + ", tls:" + r18 + ", provisioned:" + r19 + ", " + r16.s("status") + ':' + r16.s("version"));     // Catch: Throwable -> L19
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        if (r17 == false) goto L25;
        if (r18 == false) goto L25;
        if (r19 == false) goto L25;
    L26:
        Object r20 = Result.m32constructorimpl(Boolean.valueOf(r11));     // Catch: Throwable -> L28
    L30:
        Throwable r21 = Result.m35exceptionOrNullimpl(r20);
        if (r21 != null) goto L45;
    L36:
        Boolean r22 = Boolean.FALSE;
        if (Result.m38isFailureimpl(r20) == false) goto L40;
        r20 = r22;
    L40:
        return ((Boolean) r20).booleanValue();
    L45:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L34
        AIKLog.INSTANCE.e("CertProvisionState", "checkProvisionState failed: " + r21);     // Catch: Throwable -> L34
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
    L25:
        r11 = false;
        goto L26
    L19:
        th = move-exception;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L28
        Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r20 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L30
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r12 = false;
        goto L10
    }
}
