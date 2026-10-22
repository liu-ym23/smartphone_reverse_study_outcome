package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSMonitorOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FPSMonitorOnScrollListener extends RecyclerView.OnScrollListener {
    public static final ConcurrentLinkedQueue e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f11897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11899c;
    public a d;

    static {
        e = new ConcurrentLinkedQueue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        super.onScrollStateChanged(r10, r11);
        if (r11 != 0) goto L5;
        a r12 = this.d;
        if (r12 != null) goto L23;
    L26:
        this.f11898b = 0;
        this.f11899c = 0;
        this.f11897a = -1;
        a r13 = this.d;
        if (r13 == null) goto L31;
        e.add(r13);
        this.d = null;
        throw null;
    L31:
        throw null;
    L23:
        if (this.f11897a <= 0) goto L25;
        r12.f20158b = SystemClock.elapsedRealtime() - this.f11897a;
    L25:
        r12.g = this.f11898b;
        r12.f20160h = this.f11899c;
        r12.e = r10.computeHorizontalScrollOffset();
        r12.f = r10.computeVerticalScrollOffset();
        goto L26
    L5:
        if (r11 == 1) goto L8;
        return;
    L8:
        if (this.f11897a < 0) goto L10;
        throw null;
    L10:
        if (this.d != null) goto L15;
        a r14 = (a) a.f20156n.acquire();
        if (r14 != null) goto L14;
        r14 = new a();
        r14.f20157a = 0.0d;
        r14.f20158b = 0;
        r14.f20159c = 0;
        r14.d = 0;
        r14.e = 0;
        r14.f = 0;
        r14.g = 0;
        r14.f20160h = 0;
        r14.f20161i = 0.0d;
        r14.f20162j = 0;
        r14.f20163k = 0;
        r14.f20164l = 0;
        r14.f20165m = 0;
    L14:
        this.d = r14;
    L15:
        a r15 = this.d;
        if (r15 == null) goto L18;
        r15.f20159c = r10.computeHorizontalScrollOffset();
        r15.d = r10.computeVerticalScrollOffset();
    L18:
        this.f11897a = SystemClock.elapsedRealtime();
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        super.onScrolled(r5, r10, r11);
        int r12 = this.f11898b;
        this.f11898b = Math.abs(r10) + r12;
        int r13 = this.f11899c;
        this.f11899c = Math.abs(r11) + r13;
    }
}
