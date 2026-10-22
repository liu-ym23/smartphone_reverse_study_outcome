package com.ss.android.lark.forwardv3;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements y.a {
    public final /* synthetic */ ExternalForwardSendHelper.MixedSendAggregator a;
    public final /* synthetic */ ExternalForwardSendHelper.Lane b;

    @Override // com.ss.android.lark.forwardv3.y.a
    public final void a(ErrorResult r2) {
        Intrinsics.checkNotNullParameter(r2, "err");
    }

    @Override // com.ss.android.lark.forwardv3.y.a
    public final void onError(ErrorResult r8) {
        Intrinsics.checkNotNullParameter(r8, "err");
        ExternalForwardSendHelper.MixedSendAggregator r0 = this.a;
        ExternalForwardSendHelper.Lane r1 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "lane");
        Intrinsics.checkNotNullParameter(r8, "err");
        Object r3 = r0.e;
        monitor-enter(r3);
        int r4 = ExternalForwardSendHelper.MixedSendAggregator.a.a[r1.ordinal()];     // Catch: Throwable -> L17
        if (r4 != 1) goto L7;
        r0.i = r8;     // Catch: Throwable -> L17
    L12:
        r0.f--;     // Catch: Throwable -> L17
        Log.w("NewForward", "mixed external forward lane error: lane=" + r1 + ", remaining=" + r0.f + ", errorCode=" + r8.getErrorCode());     // Catch: Throwable -> L17
        Function0<Unit> r9 = r0.a();     // Catch: Throwable -> L17
        monitor-exit(r3);
        if (r9 == null) goto L21;
        r9.invoke();
        return;
    L21:
        return;
    L7:
        if (r4 != 2) goto L10;
        r0.j = r8;     // Catch: Throwable -> L17
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public b(ExternalForwardSendHelper.MixedSendAggregator r1, ExternalForwardSendHelper.Lane r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.ss.android.lark.forwardv3.y.a
    public final void b(rib.d r5, List<? extends SearchBaseInfo> r6) {
        Intrinsics.checkNotNullParameter(r6, "_items");
        ExternalForwardSendHelper.MixedSendAggregator r7 = this.a;
        ExternalForwardSendHelper.Lane r0 = this.b;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "lane");
        Object r1 = r7.e;
        monitor-enter(r1);
        r7.h = true;     // Catch: Throwable -> L18
        int r2 = ExternalForwardSendHelper.MixedSendAggregator.a.a[r0.ordinal()];     // Catch: Throwable -> L18
        if (r2 != 1) goto L8;
        r7.k = r5;     // Catch: Throwable -> L18
    L13:
        r7.f--;     // Catch: Throwable -> L18
        Function0<Unit> r8 = r7.a();     // Catch: Throwable -> L18
        monitor-exit(r1);
        if (r8 == null) goto L22;
        r8.invoke();
        return;
    L22:
        return;
    L8:
        if (r2 != 2) goto L11;
        r7.l = r5;     // Catch: Throwable -> L18
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }
}
