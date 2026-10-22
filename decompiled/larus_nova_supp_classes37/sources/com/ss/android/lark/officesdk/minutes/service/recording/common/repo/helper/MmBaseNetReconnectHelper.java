package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class MmBaseNetReconnectHelper {
    public final i1<Boolean> a;
    public final CoroutineScope b;
    public long c;
    public boolean d;
    public Job e;
    public Job f;

    public abstract Object b(Continuation<? super Unit> r1);

    public abstract long c();

    public abstract long d();

    public abstract String e();

    public abstract void f();

    public final void g() {
        this.d = ((Boolean) this.a.getValue()).booleanValue();
        lvb.a.e(e(), "start, isNetAvailable: " + this.d);
        Job r0 = this.e;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.e = BuildersKt.launch$default(this.b, null, null, new MmBaseNetReconnectHelper$start$1(this, null), 3, null);
    }

    public MmBaseNetReconnectHelper(b1 r2, CoroutineScope r3) {
        Intrinsics.checkNotNullParameter(r2, "networkAvailableFlow");
        Intrinsics.checkNotNullParameter(r3, "scope");
        this.a = r2;
        this.b = r3;
        this.c = System.currentTimeMillis();
    }

    public static final Object a(MmBaseNetReconnectHelper r9, Continuation r10) {
        r9.getClass();
        if ((r10 instanceof MmBaseNetReconnectHelper$performFetch$1) == false) goto L7;
        MmBaseNetReconnectHelper$performFetch$1 r0 = (MmBaseNetReconnectHelper$performFetch$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r11);
    L28:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
    L22:
        if (r9.d == true) goto L24;
        lvb.a.e(r9.e(), "performFetch, wait over but net unavailable");
        return Unit.INSTANCE;
    L24:
        lvb.a.e(r9.e(), "performFetch, executing");
        r9.c = System.currentTimeMillis();
        r0.label = 2;
        if (r9.b(r0) != r2) goto L28;
        return r2;
    L16:
        ResultKt.throwOnFailure(r11);
        long r5 = System.currentTimeMillis() - r9.c;
        if (r5 >= r9.d()) goto L24;
        long r7 = r9.d() - r5;
        lvb.a.e(r9.e(), "performFetch, throttling, wait for " + r7 + " ms");
        r0.label = 1;
        if (DelayKt.delay(r7, r0) != r2) goto L22;
        return r2;
    L7:
        r0 = new MmBaseNetReconnectHelper$performFetch$1(r9, r10);
        goto L8
    }
}
