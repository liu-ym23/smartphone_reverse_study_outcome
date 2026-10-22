package com.lark.kmp.rustclient.internal;

import com.bytedance.lark.sdk.InvokeResponse;
import com.lark.kmp.logger.LarkLogger;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.basic.v1.RequestPacket;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.c1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class CallRustInterceptor implements com.lark.kmp.rustclient.api.g {
    public final s a;
    public final com.lark.kmp.rustclient.api.f b;
    public final com.lark.kmp.rustclient.api.e c;

    public static final class a {
    }

    static {
    }

    @Override // com.lark.kmp.rustclient.api.g
    public final <Resp> Flow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> a(final com.lark.kmp.rustclient.api.h<Resp> r11) {
        Intrinsics.checkNotNullParameter(r11, "chain");
        final com.lark.kmp.rustclient.api.a<Resp> r0 = r11.c;
        buc.d r1 = jy7.b.a;
        long r2 = r1.d();
        if (r2 < 9223372036854775707L) goto L11;
    L4:
        long r3 = r1.c();
        if (r3 < 9223372036854775707L) goto L7;
        long r8 = 100;
    L9:
        if (r1.b(r3, r8) == false) goto L4;
        long r4 = 100;
    L12:
        LarkLogger r5 = LarkLogger.a;
        LarkLogger.a("CallRustInterceptor", "interceptEnqueue taskId = " + r4);
        final c1 r6 = new c1(new CallRustInterceptor$interceptEnqueue$1(this.a.e(r4), r0, r4, this, null));
        return new CallRustInterceptor$interceptEnqueue$$inlined$map$1(r6, r11, r0);
    L7:
        r8 = r3;
        goto L9
    L11:
        r4 = r2;
        goto L12
    }

    @Override // com.lark.kmp.rustclient.api.g
    public final <T> Object b(com.lark.kmp.rustclient.api.h<T> r19, Continuation<? super com.lark.kmp.rustclient.api.model.g<InvokeResponse, T>> r20) {
        com.lark.kmp.rustclient.api.a<T> r2 = r19.c;
        com.lark.kmp.rustclient.api.model.c<T> r4 = r2.a;
        int r3 = jy7.c.a;
        Long r7 = Long.valueOf(ThreadMethodProxy.currentThread().getId());
        com.lark.kmp.rustclient.api.model.j r5 = r19.c.b;
        boolean r6 = r5 instanceof com.lark.kmp.rustclient.api.model.l;
        if (r6 == false) goto L5;
        com.lark.kmp.rustclient.api.model.l r8 = (com.lark.kmp.rustclient.api.model.l) r5;
    L6:
        if (r8 == null) goto L9;
        String r9 = r8.a;
        if (r9 == null) goto L9;
    L10:
        if (r6 == false) goto L17;
        com.lark.kmp.rustclient.api.model.l r10 = (com.lark.kmp.rustclient.api.model.l) r5;
        Long r11 = r10.b;
        if (r11 != null) goto L16;
        r11 = r2.d;
        if (r11 != null) goto L16;
        Long r12 = this.c.a(r10.a);
    L18:
        Long r13 = r12;
    L19:
        LarkLogger r14 = LarkLogger.a;
        LarkLogger.a("CallRustInterceptor", "getUserContainerId = " + r13);
        RequestPacket r15 = d.a(new u(r4, r9, null, r7, r13, 4));
        com.lark.kmp.rustclient.a.a(r19.c.a, "sync invoke call sdk.");
        InvokeResponse r16 = this.b.a(new com.lark.kmp.rustclient.api.model.e(Command.WRAPPER_WITH_PACKET.getValue(), r15.encode(), r2.a.a(), r2.a.b, 0));
        if (r16.a != 0) goto L27;
        Pair r1 = com.lark.kmp.rustclient.api.model.i.c(r2.a.f, r16.c, r19.c.a.a(), r19.c.a.d);
        Object r17 = r1.component1();
        com.lark.kmp.rustclient.api.model.f r21 = (com.lark.kmp.rustclient.api.model.f) r1.component2();
        if (r17 == null) goto L26;
        return new com.lark.kmp.rustclient.api.model.k(r17, r16, r2.b);
    L26:
        return new com.lark.kmp.rustclient.api.model.b(r21, r16, r2.b);
    L27:
        return new com.lark.kmp.rustclient.api.model.b(com.lark.kmp.rustclient.api.model.i.b(r19.c.a.a(), r19.c.a.d, r16.c, null), r16, r2.b);
    L16:
        r13 = r11;
        goto L19
    L17:
        r12 = r2.d;
    L9:
        r9 = r2.c;
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    public CallRustInterceptor(s r2, com.lark.kmp.rustclient.api.f r3, com.lark.kmp.rustclient.api.e r4) {
        Intrinsics.checkNotNullParameter(r2, "dispatcher");
        Intrinsics.checkNotNullParameter(r3, "rustSDK");
        Intrinsics.checkNotNullParameter(r4, "containerHolder");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
