package com.lark.kmp.rustclient.internal;

import com.bytedance.lark.sdk.InvokeResponse;
import com.lark.kmp.logger.LarkLogger;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.basic.v1.ResponseMeta;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class VerifyDataInterceptor implements com.lark.kmp.rustclient.api.g {
    public final r a;

    public VerifyDataInterceptor(r r2) {
        Intrinsics.checkNotNullParameter(r2, "definition");
        this.a = r2;
    }

    @Override // com.lark.kmp.rustclient.api.g
    public final <Resp> Flow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> a(final com.lark.kmp.rustclient.api.h<Resp> r3) {
        Intrinsics.checkNotNullParameter(r3, "chain");
        final Flow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> r0 = r3.b(r3.c);
        return new VerifyDataInterceptor$interceptEnqueue$$inlined$filter$1(r0, r3, this);
    }

    @Override // com.lark.kmp.rustclient.api.g
    public final <T> Object b(com.lark.kmp.rustclient.api.h<T> r19, Continuation<? super com.lark.kmp.rustclient.api.model.g<InvokeResponse, T>> r20) {
        com.lark.kmp.rustclient.api.h<T> r0 = r19;
        if ((r20 instanceof VerifyDataInterceptor$intercept$1) == false) goto L7;
        VerifyDataInterceptor$intercept$1 r3 = (VerifyDataInterceptor$intercept$1) r20;
        int r4 = r3.label;
        if ((r4 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r3.label = r4 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        r0 = (com.lark.kmp.rustclient.api.h) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L17:
        Object r17 = r2;
        com.lark.kmp.rustclient.api.h<T> r7 = r0;
        com.lark.kmp.rustclient.api.model.g r8 = (com.lark.kmp.rustclient.api.model.g) r17;
        com.lark.kmp.rustclient.api.a<T> r9 = r7.c;
        r r10 = this.a;
        if ((r9.b instanceof com.lark.kmp.rustclient.api.model.l) == false) goto L52;
        InvokeResponse r11 = (InvokeResponse) r8.a;
        if (r11 == null) goto L23;
        byte[] r12 = r11.b;
    L24:
        if (r12 == null) goto L52;
        if (r9.a.a() == Command.MAKE_USER_ONLINE) goto L52;
        if ((r8 instanceof com.lark.kmp.rustclient.api.model.b) == true) goto L52;
        String r13 = ((com.lark.kmp.rustclient.api.model.l) r9.b).a;
        ResponseMeta r14 = ResponseMeta.ADAPTER.e(((InvokeResponse) r8.a).b);     // Catch: Throwable -> L47 Exception -> L49
        String r15 = String.valueOf(r14.getUser_id());     // Catch: Throwable -> L47 Exception -> L49
        Boolean r16 = r14.getVerify_user_id();     // Catch: Throwable -> L47 Exception -> L49
        if (r16 == null) goto L36;
        boolean r110 = r16.booleanValue();     // Catch: Throwable -> L47 Exception -> L49
    L38:
        if (Intrinsics.areEqual(r13, r15) == false) goto L40;
    L51:
        r10.b();
        goto L52
    L40:
        if (f0.a(r15) == false) goto L42;
        if (r110 == true) goto L42;
    L43:
        if (f0.a(r15) == true) goto L51;
        if (r110 == false) goto L51;
    L46:
        r10.b();
        boolean r21 = false;
    L56:
        if (r21 == false) goto L58;
        return r8;
    L58:
        return new com.lark.kmp.rustclient.api.model.b(com.lark.kmp.rustclient.api.model.i.b(r7.c.a.a(), r7.c.a.d, null, new RuntimeException("User Verify Failed.")), r8.a, r7.c.b);
    L42:
        LarkLogger r111 = LarkLogger.a;     // Catch: Throwable -> L47 Exception -> L49
        LarkLogger.e("logInvokeVerify verifyInvoke Failed: requestUserId = " + r13 + ", command = " + r9.a.a() + ", contextId = " + r9.a.b + ", sdkUserId=" + r15 + ", needVerify=" + r110);     // Catch: Throwable -> L47 Exception -> L49
        goto L43
    L36:
        r110 = false;
    L47:
        th = move-exception;
        r10.b();
        throw th;
    L49:
        e = move-exception;
        LarkLogger r22 = LarkLogger.a;     // Catch: Throwable -> L47
        LarkLogger.e("logInvokeMetaParse verifyInvoke Failed: command = " + r9.a.a() + ", contextId = " + r9.a.b + ", error occurs: " + e.getMessage());     // Catch: Throwable -> L47
        goto L46
    L23:
        r12 = null;
    L52:
        r21 = true;
        goto L56
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        com.lark.kmp.rustclient.api.a<T> r23 = r0.c;
        r3.L$0 = r0;
        r3.label = 1;
        r2 = r0.a(r23, r3);
        if (r2 != r5) goto L17;
        return r5;
    L7:
        r3 = new VerifyDataInterceptor$intercept$1(this, r20);
        goto L8
    }
}
