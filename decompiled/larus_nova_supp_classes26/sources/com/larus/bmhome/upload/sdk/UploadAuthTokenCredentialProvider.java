package com.larus.bmhome.upload.sdk;

import com.larus.bmhome.upload.sdk.api.model.AuthMode;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import mr9.j;
import mr9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class UploadAuthTokenCredentialProvider implements hs8.f {
    public UploadAuthTokenCredentialProvider() {
    }

    @Override // hs8.f
    public final boolean b(AuthMode r2) {
        Intrinsics.checkNotNullParameter(r2, "authMode");
        if (r2 != AuthMode.UploadAuthToken) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // hs8.f
    public final Object a(is8.g r22, is8.a r23, Continuation<? super hs8.e> r24) {
        is8.g r0 = r22;
        if ((r24 instanceof UploadAuthTokenCredentialProvider$fetch$1) == false) goto L7;
        UploadAuthTokenCredentialProvider$fetch$1 r3 = (UploadAuthTokenCredentialProvider$fetch$1) r24;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r1 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L20;
        if (r6 != 1) goto L19;
        j r7 = (j) r3.L$2;
        is8.a r8 = (is8.a) r3.L$1;
        r0 = (is8.g) r3.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L14 ResourceUploadError -> L16
        is8.a r13 = r8;
    L58:
        r7.h = (m) r1;     // Catch: Throwable -> L31 ResourceUploadError -> L33
        ms8.b.c(ms8.b.a, r7, "prepare_upload", "success", null, MapsKt.mapOf(TuplesKt.to("auth_mode", r13.a.name())), 8);     // Catch: Throwable -> L31 ResourceUploadError -> L33
        FLogger.a.i("ResourceUploadSdk", "[fetchUploadAuthToken] identifier=" + r0.c.f + ", scene=" + r7.b + ", dataType=" + r7.c);     // Catch: Throwable -> L31 ResourceUploadError -> L33
        return new hs8.e(r13.a, MapsKt.mapOf(TuplesKt.to("credential_source", "upload_auth_token")));
    L33:
        e = e;
    L50:
        ms8.b r2 = ms8.b.a;
        Map r9 = MapsKt.mapOf(TuplesKt.to("auth_mode", r13.a.name()));
        r2.getClass();
        ms8.b.b(r7, "prepare_upload", "fail", e, r9);
        throw e;
    L31:
        th = th;
    L42:
        String r10 = th.getMessage();
        if (r10 != null) goto L45;
        r10 = "";
    L45:
        ResourceUploadError r11 = new ResourceUploadError("upload_get_auth_token_error", r10);
        ms8.b r12 = ms8.b.a;
        Map r14 = MapsKt.mapOf(TuplesKt.to("auth_mode", r13.a.name()));
        r12.getClass();
        ms8.b.b(r7, "prepare_upload", "fail", r11, r14);
        throw r11;
    L16:
        e = e;
        r13 = r8;
    L14:
        th = th;
        r13 = r8;
        goto L42
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r1);
        ConcurrentHashMap<String, j> r15 = g.a;
        Intrinsics.checkNotNullParameter(r0, "request");
        String r16 = r0.c.f;
        Intrinsics.checkNotNullParameter(r16, "identifier");
        j r17 = g.a.get(r16);
        if (r17 == null) goto L53;
        ms8.b.a.getClass();
        ms8.b.i(r17, "prepare_upload");
        int r18 = h.a;     // Catch: Throwable -> L39 ResourceUploadError -> L47
        String r19 = r17.b;     // Catch: Throwable -> L39 ResourceUploadError -> L47
        String r110 = r17.c.getType();     // Catch: Throwable -> L39 ResourceUploadError -> L47
        r3.L$0 = r0;     // Catch: Throwable -> L39 ResourceUploadError -> L47
        r13 = r23;
        r3.L$1 = r13;     // Catch: Throwable -> L35 ResourceUploadError -> L37
        r3.L$2 = r17;     // Catch: Throwable -> L35 ResourceUploadError -> L37
        r3.label = 1;     // Catch: Throwable -> L35 ResourceUploadError -> L37
        Object r20 = h.a(r19, r110, r3);     // Catch: Throwable -> L35 ResourceUploadError -> L37
        if (r20 != r5) goto L28;
        return r5;
    L28:
        r7 = r17;
        r1 = r20;
        goto L58
    L37:
        e = e;
    L49:
        r7 = r17;
    L35:
        th = th;
    L41:
        r7 = r17;
        goto L42
    L47:
        e = e;
        r13 = r23;
    L39:
        th = th;
        r13 = r23;
        goto L41
    L53:
        throw new ResourceUploadError("upload_get_auth_token_error", "origin param missing");
    L7:
        r3 = new UploadAuthTokenCredentialProvider$fetch$1(this, r24);
        goto L8
    }
}
