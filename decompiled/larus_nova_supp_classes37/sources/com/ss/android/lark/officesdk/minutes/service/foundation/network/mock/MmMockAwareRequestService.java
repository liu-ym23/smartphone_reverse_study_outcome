package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.squareup.wire.Message;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.MmNetRequestHandler;
import com.ss.android.lark.pb.improto.Command;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmMockAwareRequestService implements com.ss.android.lark.officesdk.minutes.service.foundation.network.b {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.network.b a;
    public final g b;

    public MmMockAwareRequestService(MmNetRequestHandler r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "real");
        Intrinsics.checkNotNullParameter(r3, "mockEngine");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.b
    public final <R> Object c(Class<R> r19, gvb.a r20, Continuation<? super Result<? extends R>> r21) {
        if ((r21 instanceof MmMockAwareRequestService$sendHttpRequest$1) == false) goto L7;
        MmMockAwareRequestService$sendHttpRequest$1 r2 = (MmMockAwareRequestService$sendHttpRequest$1) r21;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r1);
        return ((Result) r1).unbox-impl();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        gvb.a r6 = (gvb.a) r2.L$1;
        Class<R> r7 = (Class) r2.L$0;
        ResultKt.throwOnFailure(r1);
        gvb.a r14 = r6;
        Class<R> r8 = r7;
    L19:
        e r9 = (e) r1;
        if ((r9 instanceof e.a) == false) goto L24;
        return ((e.a) r9).a;
    L24:
        if (Intrinsics.areEqual(r9, e.b.a) == false) goto L30;
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r10 = this.a;
        r2.L$0 = null;
        r2.L$1 = null;
        r2.label = 2;
        Object r11 = r10.c(r8, r14, r2);
        if (r11 != r4) goto L31;
        return r4;
    L31:
        return r11;
    L30:
        throw new NoWhenBranchMatchedException();
    L16:
        ResultKt.throwOnFailure(r1);
        g r12 = this.b;
        r8 = r19;
        r2.L$0 = r8;
        r14 = r20;
        r2.L$1 = r14;
        r2.label = 1;
        r12.getClass();
        r1 = r12.b(new d("http", r20.getClass().getName(), new c(r20, r20.getPath(), r20.getMethod(), r20.a(), r20.f(), r20.c()), null, 8), r2);
        if (r1 != r4) goto L19;
        return r4;
    L7:
        r2 = new MmMockAwareRequestService$sendHttpRequest$1(this, r21);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.b
    public final <R> Object a(Command r12, Class<R> r13, Message<?, ?> r14, Continuation<? super Result<? extends R>> r15) {
        if ((r15 instanceof MmMockAwareRequestService$sendServerPbRequest$1) == false) goto L7;
        MmMockAwareRequestService$sendServerPbRequest$1 r0 = (MmMockAwareRequestService$sendServerPbRequest$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r16);
        return ((Result) r16).unbox-impl();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r14 = (Message) r0.L$2;
        r13 = (Class) r0.L$1;
        r12 = (Command) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L19:
        e r17 = (e) r16;
        if ((r17 instanceof e.a) == false) goto L24;
        return ((e.a) r17).a;
    L24:
        if (Intrinsics.areEqual(r17, e.b.a) == false) goto L30;
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r18 = this.a;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        Object r19 = r18.a(r12, r13, r14, r0);
        if (r19 != r2) goto L31;
        return r2;
    L31:
        return r19;
    L30:
        throw new NoWhenBranchMatchedException();
    L16:
        ResultKt.throwOnFailure(r16);
        g r110 = this.b;
        r0.L$0 = r12;
        r0.L$1 = r13;
        r0.L$2 = r14;
        r0.label = 1;
        r110.getClass();
        r16 = r110.b(new d("server_pb", r12.getName(), null, r14, 4), r0);
        if (r16 != r2) goto L19;
        return r2;
    L7:
        r0 = new MmMockAwareRequestService$sendServerPbRequest$1(this, r15);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.b
    public final <R> Object b(com.bytedance.lark.pb.basic.v1.Command r12, Class<R> r13, Message<?, ?> r14, Continuation<? super Result<? extends R>> r15) {
        if ((r15 instanceof MmMockAwareRequestService$sendPbRequest$1) == false) goto L7;
        MmMockAwareRequestService$sendPbRequest$1 r0 = (MmMockAwareRequestService$sendPbRequest$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r16);
        return ((Result) r16).unbox-impl();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r14 = (Message) r0.L$2;
        r13 = (Class) r0.L$1;
        r12 = (com.bytedance.lark.pb.basic.v1.Command) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L19:
        e r17 = (e) r16;
        if ((r17 instanceof e.a) == false) goto L24;
        return ((e.a) r17).a;
    L24:
        if (Intrinsics.areEqual(r17, e.b.a) == false) goto L30;
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r18 = this.a;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        Object r19 = r18.b(r12, r13, r14, r0);
        if (r19 != r2) goto L31;
        return r2;
    L31:
        return r19;
    L30:
        throw new NoWhenBranchMatchedException();
    L16:
        ResultKt.throwOnFailure(r16);
        g r110 = this.b;
        r0.L$0 = r12;
        r0.L$1 = r13;
        r0.L$2 = r14;
        r0.label = 1;
        r110.getClass();
        r16 = r110.b(new d("client_pb", r12.getName(), null, r14, 4), r0);
        if (r16 != r2) goto L19;
        return r2;
    L7:
        r0 = new MmMockAwareRequestService$sendPbRequest$1(this, r15);
        goto L8
    }
}
