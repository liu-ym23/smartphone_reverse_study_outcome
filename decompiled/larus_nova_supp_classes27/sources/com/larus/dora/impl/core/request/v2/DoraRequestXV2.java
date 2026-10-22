package com.larus.dora.impl.core.request.v2;

import android.os.SystemClock;
import com.larus.dora.impl.frameassembler.DoraAggregateFrameAssembler;
import com.larus.dora.impl.frameassembler.DoraIncompleteReason;
import com.larus.dora.impl.frameassembler.h;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import vj4.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraRequestXV2 {
    public static final DoraRequestXV2 a = null;
    public static final AtomicInteger b = null;

    public static final class a implements d {
        public final /* synthetic */ int a;
        public final /* synthetic */ DoraAggregateFrameAssembler b;

        public a(int r1, DoraAggregateFrameAssembler r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(long r14, int r16, int r17, int r18, int r110, byte[] r20, long r21, byte[] r23) {
            Intrinsics.checkNotNullParameter(r20, "data");
            Intrinsics.checkNotNullParameter(r23, "extra");
            if (r14 != this.a) goto L6;
            this.b.a(r14, r16, r17, r18, r110, r20, r21, r23);
            return;
        }
    }

    public static final class b implements Function1<Throwable, Unit> {
        public final /* synthetic */ DoraAggregateFrameAssembler a;
        public final /* synthetic */ Ref.ObjectRef<d> b;
        public final /* synthetic */ int c;
        public final /* synthetic */ vj4.c d;
        public final /* synthetic */ long e;

        public b(DoraAggregateFrameAssembler r1, Ref.ObjectRef<d> r2, int r3, vj4.c r4, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final Object invoke(Object r7) {
            Throwable r8 = (Throwable) r7;
            DoraRequestXV2.b(this.c, this.d, this.e, true, "invokeOnCancellation");
            this.a.shutdown();
            vj4.b.a.a.c((d) this.b.element);
            return Unit.INSTANCE;
        }
    }

    public static final class c implements com.larus.dora.impl.frameassembler.b {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ Ref.ObjectRef<d> b;
        public final /* synthetic */ i<com.larus.dora.impl.core.request.v2.a> c;
        public final /* synthetic */ int d;
        public final /* synthetic */ vj4.c e;
        public final /* synthetic */ long f;

        public final void a(h r7, byte[] r8) {
            Intrinsics.checkNotNullParameter(r7, "context");
            Intrinsics.checkNotNullParameter(r8, "payload");
            DoraRequestXV2.b(this.d, this.e, this.f, false, "onCompleted");
            if (this.a.compareAndSet(false, true) == false) goto L6;
            vj4.b.a.a.c((d) this.b.element);
            i<com.larus.dora.impl.core.request.v2.a> r9 = this.c;
            Result.Companion r0 = Result.Companion;
            r9.resumeWith(Result.constructor-impl(new com.larus.dora.impl.core.request.v2.a.b(r8)));
            return;
        }

        public final void b(h r8, DoraIncompleteReason r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            Intrinsics.checkNotNullParameter(r9, "reason");
            DoraRequestXV2.b(this.d, this.e, this.f, true, "onIncomplete, reason: " + r9);
            if (this.a.compareAndSet(false, true) == false) goto L6;
            vj4.b.a.a.c((d) this.b.element);
            i<com.larus.dora.impl.core.request.v2.a> r10 = this.c;
            Result.Companion r0 = Result.Companion;
            r10.resumeWith(Result.constructor-impl(new com.larus.dora.impl.core.request.v2.a.C0030a(new RuntimeException("onIncomplete, reason: " + r9))));
            return;
        }

        public final void c(h r7, Throwable r8) {
            Intrinsics.checkNotNullParameter(r7, "context");
            Intrinsics.checkNotNullParameter(r8, "error");
            DoraRequestXV2.b(this.d, this.e, this.f, true, "onError, error: " + r8);
            if (this.a.compareAndSet(false, true) == false) goto L6;
            vj4.b.a.a.c((d) this.b.element);
            i<com.larus.dora.impl.core.request.v2.a> r9 = this.c;
            Result.Companion r0 = Result.Companion;
            r9.resumeWith(Result.constructor-impl(new com.larus.dora.impl.core.request.v2.a.C0030a(r8)));
            return;
        }

        public c(AtomicBoolean r1, Ref.ObjectRef r2, j r3, int r4, vj4.c r5, long r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public DoraRequestXV2() {
    }

    static {
        a = new DoraRequestXV2();
        b = new AtomicInteger(0);
    }

    public final Object a(vj4.c r12, long r13, Continuation<? super com.larus.dora.impl.core.request.v2.a> r15) {
        if ((r15 instanceof DoraRequestXV2$requestV2$1) == false) goto L7;
        DoraRequestXV2$requestV2$1 r0 = (DoraRequestXV2$requestV2$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L17:
        com.larus.dora.impl.core.request.v2.a r17 = (com.larus.dora.impl.core.request.v2.a) r16;
        if (r17 == null) goto L20;
        return r17;
    L20:
        return new com.larus.dora.impl.core.request.v2.a.C0030a(new RuntimeException("requestV2 timeout"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        DoraRequestXV2$requestV2$$inlined$suspendCoroutineWithTimeoutOrNull$1 r18 = new DoraRequestXV2$requestV2$$inlined$suspendCoroutineWithTimeoutOrNull$1(null, b.incrementAndGet(), r12, new AtomicBoolean(false), SystemClock.elapsedRealtime());
        r0.label = 1;
        r16 = TimeoutKt.c(r13, r18, r0);
        if (r16 != r2) goto L17;
        return r2;
    L7:
        r0 = new DoraRequestXV2$requestV2$1(this, r15);
        goto L8
    }

    public static final void b(int r4, vj4.c r5, long r6, boolean r8, String r9) {
        if (r8 == false) goto L5;
        g49.d.e("DoraRequestXV2", "id: " + r4 + ", " + r5 + ", " + r9 + ", cost: " + (SystemClock.elapsedRealtime() - r6));
        return;
    L5:
        g49.d.d("DoraRequestXV2", "id: " + r4 + ", " + r5 + ", " + r9 + ", cost: " + (SystemClock.elapsedRealtime() - r6));
    }
}
