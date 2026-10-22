package com.obric.aikernel.service.foreground;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class DelayedForegroundServiceRunState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f5445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f5446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function0<Unit> f5447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0<Unit> f5448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function1<Throwable, Unit> f5449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f5451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f5452h;

    /* JADX WARN: Multi-variable type inference failed */
    public DelayedForegroundServiceRunState(long r10, e r11, Function0<Unit> r12, Function0<Unit> r13, Function1<? super Throwable, Unit> r14) {
        Intrinsics.checkNotNullParameter(r11, "scheduler");
        Intrinsics.checkNotNullParameter(r12, "dispatchStart");
        Intrinsics.checkNotNullParameter(r13, "dispatchStop");
        Intrinsics.checkNotNullParameter(r14, "onDispatchFailure");
        this.f5445a = r10;
        this.f5446b = r11;
        this.f5447c = r12;
        this.f5448d = r13;
        this.f5449e = r14;
    }

    public /* synthetic */ DelayedForegroundServiceRunState(long r10, e r11, Function0 r12, Function0 r13, Function1 r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L5;
        r10 = 300000;
    L5:
        long r17 = r10;
        if ((r15 & 2) == 0) goto L8;
        r11 = CoroutineForegroundServiceStopScheduler.f5443a;
    L8:
        e r18 = r11;
        if ((r15 & 16) == 0) goto L11;
        r14 = AnonymousClass1.INSTANCE;
    L11:
        this(r17, r18, r12, r13, r14);
    }

    public static final /* synthetic */ void a(DelayedForegroundServiceRunState r10) {
        r10.c();
    }

    private final void c() {
        monitor-enter(this);
        this.f5452h = null;     // Catch: Throwable -> L14
        boolean r10 = false;
        if (this.f5450f == 0) goto L7;
    L10:
        monitor-exit(this);
        if (r10 == false) goto L19;
        e(this.f5448d);
        return;
    L19:
        return;
    L7:
        if (this.f5451g == false) goto L10;
        this.f5451g = false;     // Catch: Throwable -> L14
        r10 = true;
    L14:
        th = move-exception;
        throw th;
    }

    private final void e(Function0<Unit> r10) {
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L4
        Object r12 = Result.m32constructorimpl(r10.invoke());     // Catch: Throwable -> L4
    L6:
        Function1<Throwable, Unit> r13 = this.f5449e;
        Throwable r14 = Result.m35exceptionOrNullimpl(r12);
        if (r14 == null) goto L12;
        r13.invoke(r14);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final void b() {
        monitor-enter(this);
        boolean r10 = true;
        this.f5450f++;     // Catch: Throwable -> L15
        a r11 = this.f5452h;     // Catch: Throwable -> L15
        if (r11 == null) goto L6;
        r11.cancel();     // Catch: Throwable -> L15
    L6:
        this.f5452h = null;     // Catch: Throwable -> L15
        if (this.f5451g == true) goto L10;
        this.f5451g = true;     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);
        if (r10 == false) goto L20;
        e(this.f5447c);
        return;
    L20:
        return;
    L10:
        r10 = false;
    L15:
        th = move-exception;
        throw th;
    }

    public final void d() {
        monitor-enter(this);
        int r10 = this.f5450f;     // Catch: Throwable -> L29
        boolean r11 = true;
        if (r10 > 0) goto L6;
    L5:
        r11 = false;
    L12:
        monitor-exit(this);
        if (r11 == true) goto L15;
        return;
    L15:
        a r12 = this.f5446b.a(this.f5445a, new DelayedForegroundServiceRunState$release$stop$1(this));
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L18:
        if (this.f5450f == 0) goto L20;
    L22:
        r12.cancel();     // Catch: Throwable -> L26
    L23:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L20:
        if (this.f5451g == false) goto L22;
        this.f5452h = r12;     // Catch: Throwable -> L26
        goto L23
    L6:
        int r14 = r10 - 1;     // Catch: Throwable -> L29
        this.f5450f = r14;     // Catch: Throwable -> L29
        if (r14 != 0) goto L5;
        if (this.f5451g == false) goto L5;
        if (this.f5452h != null) goto L5;
    L29:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean f() {
        monitor-enter(this);
        boolean r10 = this.f5451g;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }
}
