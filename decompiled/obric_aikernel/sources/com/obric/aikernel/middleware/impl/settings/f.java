package com.obric.aikernel.middleware.impl.settings;

import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import s7.i;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d6.c("enable_inr")
    private final boolean f4606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @d6.c("inr_timemills")
    private final long f4607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @d6.c("update_interval")
    private final long f4608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @d6.c("clean_interval")
    private final long f4609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @d6.c("clean_total_gb")
    private final int f4610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @d6.c("subprocess_idle_interval")
    private final long f4611g;

    public f() {
        this.f4606b = true;
        Duration.Companion r10 = Duration.Companion;
        DurationUnit r11 = DurationUnit.MINUTES;
        long r12 = DurationKt.toDuration(30, r11);
        DurationUnit r13 = DurationUnit.MILLISECONDS;
        this.f4607c = Duration.m1430toLongimpl(r12, r13);
        this.f4608d = Duration.m1430toLongimpl(DurationKt.toDuration(30, r11), r13);
        this.f4609e = Duration.m1430toLongimpl(DurationKt.toDuration(3, DurationUnit.DAYS), r13);
        this.f4610f = 10;
        this.f4611g = i.f12731a.a();
    }

    @Override // s7.i
    public int a() {
        return this.f4610f;
    }

    @Override // s7.i
    public long b() {
        return this.f4611g;
    }

    @Override // s7.i
    public long c() {
        return this.f4607c;
    }

    @Override // s7.i
    public long d() {
        return this.f4608d;
    }

    @Override // s7.i
    public boolean e() {
        return this.f4606b;
    }

    @Override // s7.i
    public long f() {
        return this.f4609e;
    }

    public f g() {
        return new f();
    }
}
