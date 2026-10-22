package com.suite.lark.platform.component.cta.model;

import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.image.api.Target;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.i;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class StuckSpotRequestExecutor {
    public final Lazy a;

    public StuckSpotRequestExecutor() {
        this.a = LazyKt.lazy(StuckSpotRequestExecutor$larkHttp$2.INSTANCE);
    }

    public static final ErrorResult b(StuckSpotRequestExecutor r1, Throwable r2) {
        r1.getClass();
        if ((r2 instanceof ErrorResult) == false) goto L6;
        return (ErrorResult) r2;
    L6:
        if ((r2 instanceof Exception) == false) goto L8;
        Exception r3 = (Exception) r2;
    L9:
        if (r3 != null) goto L11;
        r3 = new Exception(r2);
    L11:
        String r4 = r2.getMessage();
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        return new ErrorResult(r4, r3);
    L8:
        r3 = null;
        goto L9
    }

    public static final void a(StuckSpotRequestExecutor r0, i r1, com.larksuite.rucket.job.base.b r2) {
        r0.getClass();
        if (r1.isActive() == false) goto L6;
        r1.resumeWith(Result.constructor-impl(r2));
        return;
    }

    public final Object c(String r5, String r6, Map<String, String> r7, String r8, Continuation<? super com.larksuite.rucket.job.base.b<goc.b>> r9) {
        if ((r9 instanceof StuckSpotRequestExecutor$executeWithSdkSender$1) == false) goto L7;
        StuckSpotRequestExecutor$executeWithSdkSender$1 r0 = (StuckSpotRequestExecutor$executeWithSdkSender$1) r9;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d r11 = (d) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L18:
        com.larksuite.rucket.job.base.b.c r12 = (com.larksuite.rucket.job.base.b) r10;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "<this>");
        if ((r12 instanceof com.larksuite.rucket.job.base.b.c) == false) goto L22;
        return d.a(new String(((SendHttpResponse) r12.b).body.toByteArray(), Charsets.UTF_8));
    L22:
        if ((r12 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L25;
        return r12;
    L25:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        HashMap r13 = new HashMap(r7);
        r13.put(HttpHeaders.HEAD_KEY_COOKIE, "session=" + r5);
        SendHttpRequest.Builder r14 = new SendHttpRequest.Builder().url(r6).headers(r13).method(SendHttpRequest.Method.POST);
        ByteString.Companion.getClass();
        SendHttpRequest r15 = r14.body(ByteString.a.b(r8)).build();
        d r16 = d.a;
        b r17 = (b) b38.b.a.create(b.class);
        Intrinsics.checkNotNull(r15);
        RucketJob<SendHttpResponse> r18 = r17.fetchStuckSpot(r15);
        r0.L$0 = r16;
        r0.label = 1;
        r10 = r18.awaitGet(r0);
        if (r10 != r2) goto L17;
        return r2;
    L17:
        r11 = r16;
    L7:
        r0 = new StuckSpotRequestExecutor$executeWithSdkSender$1(this, r9);
        goto L8
    }
}
