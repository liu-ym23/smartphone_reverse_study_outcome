package com.obric.aikernel.phx.compat;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import com.obric.aikernel.a;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class ParamsCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ParamsCompat f4752a = null;

    static {
        f4752a = new ParamsCompat();
    }

    private ParamsCompat() {
    }

    public static final /* synthetic */ Object a(ParamsCompat r10, String r11, AssetFileDescriptor r12, long r13, Continuation r14) {
        return r10.c(r11, r12, r13, r14);
    }

    public static final /* synthetic */ Object b(ParamsCompat r10, RequestParams r11, Continuation r12) {
        return r10.e(r11, r12);
    }

    private final Object c(String r10, AssetFileDescriptor r11, long r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof ParamsCompat$grantUri$1) == false) goto L7;
        ParamsCompat$grantUri$1 r14 = (ParamsCompat$grantUri$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r14.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        r12 = r14.J$0;
        r11 = (AssetFileDescriptor) r14.L$2;
        r10 = (String) r14.L$1;
        ParamsCompat r19 = (ParamsCompat) r14.L$0;
        ResultKt.throwOnFailure(r16);
    L17:
        a r20 = (a) r16;
        if (r20 != null) goto L27;
        AIKLog.INSTANCE.w("ParamsCompat", "grantUri get null binder!");
    L26:
        return Unit.INSTANCE;
    L27:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L21
        Bundle r22 = e8.a.C(new Bundle(), IdlKeys.Method_GrantUri, "ParamsCompat", "grantUri");     // Catch: Throwable -> L21
        r22.putString(IdlKeys.Args_GrantUri, r10);     // Catch: Throwable -> L21
        r22.putParcelable(IdlKeys.Args_GrantFd, r11);     // Catch: Throwable -> L21
        r22.putLong(IdlKeys.Args_Timeout, r12);     // Catch: Throwable -> L21
        Object r23 = Result.m32constructorimpl(r20.Z0(r22));     // Catch: Throwable -> L21
    L23:
        Result.m31boximpl(r23);
    L21:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r23 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        z7.a r25 = z7.a.f13802a;
        r14.L$0 = this;
        r14.L$1 = r10;
        r14.L$2 = r11;
        r14.J$0 = r12;
        r14.label = 1;
        r16 = r25.a(r14);
        if (r16 != r17) goto L17;
        return r17;
    L7:
        r14 = new ParamsCompat$grantUri$1(this, r13);
        goto L8
    }

    static /* synthetic */ Object d(ParamsCompat r10, String r11, AssetFileDescriptor r12, long r13, Continuation r14, int r15, Object r16) {
        if ((r15 & 4) == 0) goto L6;
        r13 = 3600000;
    L6:
        return r10.c(r11, r12, r13, r14);
    }

    private final Object e(RequestParams r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof ParamsCompat$onStartCompat$1) == false) goto L7;
        ParamsCompat$onStartCompat$1 r12 = (ParamsCompat$onStartCompat$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        ParamsCompat$onStartCompat$1 r14 = r12;
        Object r15 = r14.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r14.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L22:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        String r18 = r10.getBackend().getString("filePath");
        if (r18 == null) goto L22;
        AssetFileDescriptor r19 = (AssetFileDescriptor) r10.getBackend().getParcelable("fdAsset");
        if (r19 == null) goto L22;
        ParamsCompat r20 = f4752a;
        r14.label = 1;
        if (d(r20, r18, r19, 0, r14, 4, null) != r16) goto L22;
        return r16;
    L7:
        r12 = new ParamsCompat$onStartCompat$1(this, r11);
        goto L8
    }

    public final Object f(RequestParams r10, Continuation<? super Bundle> r11) {
        if ((r11 instanceof ParamsCompat$startCompat$1) == false) goto L7;
        ParamsCompat$startCompat$1 r12 = (ParamsCompat$startCompat$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        RequestParams r17 = (RequestParams) r12.L$0;
        ResultKt.throwOnFailure(r14);
        r10 = r17;
    L20:
        return r10.start();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (z7.a.f13802a.b() == false) goto L20;
        r12.L$0 = r10;
        r12.label = 1;
        if (e(r10, r12) != r15) goto L20;
        return r15;
    L7:
        r12 = new ParamsCompat$startCompat$1(this, r11);
        goto L8
    }
}
