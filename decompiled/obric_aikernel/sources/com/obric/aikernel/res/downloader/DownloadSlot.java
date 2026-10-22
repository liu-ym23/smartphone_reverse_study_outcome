package com.obric.aikernel.res.downloader;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes2.dex */
public final class DownloadSlot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l0 f4913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f4914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f4915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private v1 f4916e;

    public interface a {
        DownloadTask a();

        Object b(Continuation<? super DownloadTask> r10);

        void c(DownloadTask r10);

        void d(DownloadTask r10);
    }

    public DownloadSlot(int r10, l0 r11, a r12, long r13) {
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r12, "callback");
        this.f4912a = r10;
        this.f4913b = r11;
        this.f4914c = r12;
        this.f4915d = r13;
    }

    public /* synthetic */ DownloadSlot(int r10, l0 r11, a r12, long r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r13 = 1000;
    L5:
        this(r10, r11, r12, r13);
    }

    public static final /* synthetic */ Object a(DownloadSlot r10, DownloadTask r11, Continuation r12) {
        return r10.d(r11, r12);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008d -> B:36:0x0090). Please report as a decompilation issue!!! */
    private final Object d(DownloadTask r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof DownloadSlot$runTask$1) == false) goto L7;
        DownloadSlot$runTask$1 r10 = (DownloadSlot$runTask$1) r15;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r16 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        Object r17 = null;
        if (r13 == 0) goto L26;
        if (r13 == 1) goto L23;
        if (r13 == 2) goto L20;
        if (r13 != 3) goto L19;
        DownloadTask r18 = (DownloadTask) r10.L$1;
        DownloadSlot r19 = (DownloadSlot) r10.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L16
    L48:
        Object r110 = Result.m32constructorimpl(Boxing.boxBoolean(((Boolean) r16).booleanValue()));     // Catch: Throwable -> L16
    L54:
        if (Result.m38isFailureimpl(r110) == true) goto L58;
        r17 = r110;
    L58:
        if (Intrinsics.areEqual(r17, Boxing.boxBoolean(false)) == true) goto L60;
        r19.f4914c.c(r18);     // Catch: Throwable -> L63
    L61:
        r18.F();
        return Unit.INSTANCE;
    L60:
        r19.f4914c.d(r18);     // Catch: Throwable -> L63
    L16:
        th = th;
    L70:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L63
        r110 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        r14 = r18;
        th = th;
    L66:
        r14.F();
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        r0 r111 = (r0) r10.L$2;
        r14 = (DownloadTask) r10.L$1;
        DownloadSlot r21 = (DownloadSlot) r10.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L65
    L36:
        DownloadTask r112 = r21.f4914c.a();     // Catch: Throwable -> L65
        if (r112 != null) goto L39;
    L41:
        boolean r22 = false;
    L42:
        if (r22 == false) goto L32;
        r14.L(false);     // Catch: Throwable -> L65
        com.obric.aikernel.runtime.utils.d.f5417a.i("DownloadController", "DownloadSlot: Slot" + r21.f4912a + ' ' + r14.v() + " yielded to " + r112.v() + " taskPrior=" + r14.w() + " pendingPrior=" + r112.w() + " taskSize=" + r14.u() + " pendingSize=" + r112.u() + ' ' + r14.o());     // Catch: Throwable -> L65
    L68:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L50
        r10.L$0 = r21;     // Catch: Throwable -> L50
        r10.L$1 = r14;     // Catch: Throwable -> L50
        r10.L$2 = null;     // Catch: Throwable -> L50
        r10.label = 3;     // Catch: Throwable -> L50
        r16 = r111.r(r10);     // Catch: Throwable -> L50
        if (r16 != r12) goto L47;
        return r12;
    L47:
        r18 = r14;
        r19 = r21;
    L50:
        th = th;
        r18 = r14;
        r19 = r21;
    L32:
        if (r111.isActive() == false) goto L68;
        long r23 = r21.f4915d;     // Catch: Throwable -> L65
        r10.L$0 = r21;     // Catch: Throwable -> L65
        r10.L$1 = r14;     // Catch: Throwable -> L65
        r10.L$2 = r111;     // Catch: Throwable -> L65
        r10.label = 2;     // Catch: Throwable -> L65
        if (DelayKt.b(r23, r10) != r12) goto L36;
        return r12;
    L39:
        if (g.a(r14, r112) != true) goto L41;
        r22 = true;
        goto L42
    L23:
        r14 = (DownloadTask) r10.L$1;
        DownloadSlot this = (DownloadSlot) r10.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L65
    L30:
        r21 = this;
        r111 = (r0) r16;     // Catch: Throwable -> L65
        goto L32
    L26:
        ResultKt.throwOnFailure(r16);
        r14.E();
        r10.L$0 = this;     // Catch: Throwable -> L65
        r10.L$1 = r14;     // Catch: Throwable -> L65
        r10.label = 1;     // Catch: Throwable -> L65
        r16 = r14.J(r10);     // Catch: Throwable -> L65
        if (r16 != r12) goto L30;
        return r12;
    L65:
        th = th;
    L7:
        r10 = new DownloadSlot$runTask$1(this, r15);
        goto L8
    }

    public final a b() {
        return this.f4914c;
    }

    public final int c() {
        return this.f4912a;
    }

    public final void e(boolean r10) {
    }

    public final void f() {
        v1 r10 = this.f4916e;
        if (r10 == null) goto L9;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("job");
        r10 = null;
    L7:
        if (r10.isActive() == false) goto L9;
        return;
    L9:
        this.f4916e = kotlinx.coroutines.h.d(this.f4913b, null, null, new DownloadSlot$start$2(this, null), 3, null);
    }
}
