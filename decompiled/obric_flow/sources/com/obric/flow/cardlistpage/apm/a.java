package com.obric.flow.cardlistpage.apm;

import android.os.Process;
import android.os.SystemClock;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.h;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f11443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f11444b;

    public a(Ref.BooleanRef r5, d r10) {
        this.f11443a = r5;
        this.f11444b = r10;
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r11, Continuation r12) {
        float r13 = ((Number) r11).floatValue();
        if (r13 > 0.0f) goto L5;
    L7:
        boolean r14 = false;
    L8:
        Ref.BooleanRef r5 = this.f11443a;
        d r10 = this.f11444b;
        if (r14 == true) goto L11;
    L17:
        if (r14 == false) goto L19;
    L29:
        r5.element = r14;
        return Unit.INSTANCE;
    L19:
        if (r5.element == false) goto L29;
        String r15 = "Transition ended, p=" + r13;
        Intrinsics.checkNotNullParameter("APM_PerformanceMonitor", "tag");
        Intrinsics.checkNotNullParameter(r15, "msg");
        org.koin.core.a r16 = su.a.f22013b;
        if (r16 == null) goto L28;
        ((ju.b) r16.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("APM_PerformanceMonitor", r15);
        if (r13 != 1.0f) goto L25;
        String r17 = "Panel_Open_Anim";
    L26:
        r10.f11448b.b(r17);
        r10.f11449c.c(r17);
        goto L29
    L25:
        r17 = "Panel_Close_Anim";
        goto L26
    L28:
        throw new IllegalStateException("KoinApplication has not been started");
    L11:
        if (r5.element == true) goto L17;
        String r18 = "Transition started, p=" + r13;
        Intrinsics.checkNotNullParameter("APM_PerformanceMonitor", "tag");
        Intrinsics.checkNotNullParameter(r18, "msg");
        org.koin.core.a r19 = su.a.f22013b;
        if (r19 == null) goto L16;
        ((ju.b) r19.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("APM_PerformanceMonitor", r18);
        r10.f11448b.a();
        com.lynx.animax.player.e r110 = r10.f11449c;
        r110.getClass();
        r110.f9665a = Process.getElapsedCpuTime();
        r110.f9666b = SystemClock.uptimeMillis();
        goto L29
    L16:
        throw new IllegalStateException("KoinApplication has not been started");
    L5:
        if (r13 >= 1.0f) goto L7;
        r14 = true;
        goto L8
    }
}
