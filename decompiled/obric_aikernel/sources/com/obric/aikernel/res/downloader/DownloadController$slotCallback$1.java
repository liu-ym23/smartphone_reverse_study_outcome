package com.obric.aikernel.res.downloader;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class DownloadController$slotCallback$1 implements DownloadSlot.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DownloadTask f4910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DownloadController f4911b;

    DownloadController$slotCallback$1(DownloadController r10) {
        this.f4911b = r10;
    }

    private final DownloadTask f() {
        DownloadController r10 = this.f4911b;
        monitor-enter(r10);
        DownloadTask r11 = (DownloadTask) CollectionsKt.firstOrNull(DownloadController.d(r10));     // Catch: Throwable -> L7
        monitor-exit(r10);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aikernel.res.downloader.DownloadSlot.a
    public DownloadTask a() {
        return f();
    }

    @Override // com.obric.aikernel.res.downloader.DownloadSlot.a
    public Object b(Continuation<? super DownloadTask> r10) {
        if ((r10 instanceof DownloadController$slotCallback$1$pickTask$1) == false) goto L7;
        DownloadController$slotCallback$1$pickTask$1 r11 = (DownloadController$slotCallback$1$pickTask$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        int r16 = 0;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        DownloadController$slotCallback$1 this = (DownloadController$slotCallback$1) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L21:
        DownloadTask r17 = (DownloadTask) r13;
        if (r17 == null) goto L28;
        int r18 = r17.w();
        DownloadTask r19 = this.f4910a;
        if (r19 == null) goto L26;
        r16 = r19.w();
    L26:
        if (r18 <= r16) goto L30;
        this.f4910a = r17;
        return r17;
    L30:
        return r17;
    L28:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        com.obric.aikernel.runtime.utils.d.f5417a.d("DownloadController", "pickTask: remain count: " + DownloadController.d(this.f4911b).size());
        DownloadController r20 = this.f4911b;
        DownloadTask r21 = this.f4910a;
        if (r21 == null) goto L17;
        int r22 = r21.w();
    L18:
        r11.L$0 = this;
        r11.label = 1;
        r13 = DownloadController.h(r20, r22, r11);
        if (r13 != r14) goto L21;
        return r14;
    L17:
        r22 = 0;
    L7:
        r11 = new DownloadController$slotCallback$1$pickTask$1(this, r10);
        goto L8
    }

    @Override // com.obric.aikernel.res.downloader.DownloadSlot.a
    public void c(DownloadTask r10) {
        Intrinsics.checkNotNullParameter(r10, "task");
        com.obric.aikernel.runtime.utils.d r11 = com.obric.aikernel.runtime.utils.d.f5417a;
        r11.d("DownloadController", "onTaskFinished " + r10.v());
        if (Intrinsics.areEqual(this.f4910a, r10) == false) goto L5;
        this.f4910a = null;
    L5:
        DownloadController r12 = this.f4911b;
        monitor-enter(r12);
        DownloadController.i(r12, r10);     // Catch: Throwable -> L23
        monitor-exit(r12);
        if (r10.D() == false) goto L12;
    L14:
        DownloadController r13 = this.f4911b;
        monitor-enter(r13);
        DownloadController.k(r13, DownloadController.e(r13));     // Catch: Throwable -> L20
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r13);
        DownloadController.j(this.f4911b);
        return;
    L20:
        th = move-exception;
        throw th;
    L12:
        if (DownloadController.C(this.f4911b, "", r10.v(), null, 4, null) == true) goto L14;
        r11.l("DownloadController", "onTaskFinished: removeTask " + r10.v() + " failed!");
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aikernel.res.downloader.DownloadSlot.a
    public void d(DownloadTask r10) {
        Intrinsics.checkNotNullParameter(r10, "task");
        com.obric.aikernel.runtime.utils.d.f5417a.d("DownloadController", "reorderTask " + r10.v());
        DownloadController r11 = this.f4911b;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(this.f4910a, r10) == false) goto L7;
        this.f4910a = null;     // Catch: Throwable -> L11
    L7:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r11);
        DownloadController.g(this.f4911b, r10);
        DownloadController.j(this.f4911b);
    }

    public final DownloadTask e() {
        return this.f4910a;
    }

    public final void g(DownloadTask r10) {
        this.f4910a = r10;
    }
}
