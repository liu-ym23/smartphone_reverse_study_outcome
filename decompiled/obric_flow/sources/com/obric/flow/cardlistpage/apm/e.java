package com.obric.flow.cardlistpage.apm;

import android.content.Context;
import android.view.Choreographer;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.coroutines.internal.c f11451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11452c;
    public final double[] d;
    public int e;
    public int f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f11453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f11454i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c7.e f11455j;

    public e(Context r5, kotlinx.coroutines.internal.c r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "scope");
        this.f11450a = r5;
        this.f11451b = r10;
        this.d = new double[600];
        this.f11453h = LazyKt.lazy(new FpsMonitor$refreshRate$2(this));
        this.f11454i = LazyKt.lazy(new FpsMonitor$targetFrameDurationMs$2(this));
        this.f11455j = new c7.e(this, 2);
    }

    public final void a() {
        if (this.f11452c == false) goto L5;
        return;
    L5:
        this.f11452c = true;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        Arrays.fill(this.d, 0.0d);
        Choreographer.getInstance().postFrameCallback(this.f11455j);
        Intrinsics.checkNotNullParameter("APM_FpsMonitor", "tag");
        Intrinsics.checkNotNullParameter("FPS Monitor Started (Choreographer)", "msg");
        org.koin.core.a r5 = su.a.f22013b;
        if (r5 == null) goto L10;
        ((ju.b) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("APM_FpsMonitor", "FPS Monitor Started (Choreographer)");
        return;
    L10:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    public final void b(String r15) {
        Intrinsics.checkNotNullParameter(r15, "scene");
        if (this.f11452c == true) goto L5;
        return;
    L5:
        this.f11452c = false;
        Choreographer.getInstance().removeFrameCallback(this.f11455j);
        int r5 = Math.min(this.e, 600);
        int r10 = this.f;
        int r11 = this.e;
        z r12 = Dispatchers.getDefault();
        FpsMonitor$stopAndReport$1 r13 = new FpsMonitor$stopAndReport$1(r5, this, r15, r10, r11, null);
        BuildersKt.launch$default(this.f11451b, r12, null, r13, 2, null);
    }
}
