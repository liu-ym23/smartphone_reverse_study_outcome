package com.obric.aee.impl;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EngineBridge.c f4346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f4347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f4348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Bundle f4349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SafeBundle f4350e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final y6.b f4351f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f4352g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Function1<Bundle, Unit> f4353h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Continuation<Unit> f4354i;

    /* JADX WARN: Multi-variable type inference failed */
    public g(EngineBridge.c r10, Bundle r11, Bundle r12, Bundle r13, SafeBundle r14, y6.b r15, long r16, Function1<? super Bundle, Unit> r17, Continuation<? super Unit> r18) {
        Intrinsics.checkNotNullParameter(r11, "args");
        Intrinsics.checkNotNullParameter(r12, "ret");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r18, "cb");
        this.f4346a = r10;
        this.f4347b = r11;
        this.f4348c = r12;
        this.f4349d = r13;
        this.f4350e = r14;
        this.f4351f = r15;
        this.f4352g = r16;
        this.f4353h = r17;
        this.f4354i = r18;
        if (r10 == null) goto L8;
        AtomicLong r19 = r10.c();
        if (r19 == null) goto L9;
        r19.set(SystemClock.elapsedRealtime());
        return;
    L9:
        return;
    }

    public final Bundle a() {
        return this.f4347b;
    }

    public final Continuation<Unit> b() {
        return this.f4354i;
    }

    public final Bundle c() {
        return this.f4349d;
    }

    public final SafeBundle d() {
        return this.f4350e;
    }

    public final Bundle e() {
        return this.f4348c;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof g) == true) goto L8;
        return false;
    L8:
        g r11 = (g) r10;
        if (Intrinsics.areEqual(this.f4346a, r11.f4346a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f4347b, r11.f4347b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f4348c, r11.f4348c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f4349d, r11.f4349d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f4350e, r11.f4350e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f4351f, r11.f4351f) == true) goto L27;
        return false;
    L27:
        if (this.f4352g == r11.f4352g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f4353h, r11.f4353h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f4354i, r11.f4354i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final EngineBridge.c f() {
        return this.f4346a;
    }

    public final long g() {
        return this.f4352g;
    }

    public final Function1<Bundle, Unit> h() {
        return this.f4353h;
    }

    public int hashCode() {
        EngineBridge.c r10 = this.f4346a;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = ((((((r12 * 31) + this.f4347b.hashCode()) * 31) + this.f4348c.hashCode()) * 31) + this.f4349d.hashCode()) * 31;
        SafeBundle r14 = this.f4350e;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        y6.b r17 = this.f4351f;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (((r16 + r18) * 31) + Long.hashCode(this.f4352g)) * 31;
        Function1<Bundle, Unit> r20 = this.f4353h;
        if (r20 == null) goto L19;
        r11 = r20.hashCode();
    L19:
        return ((r19 + r11) * 31) + this.f4354i.hashCode();
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "SessionInfo(serv=" + this.f4346a + ", args=" + this.f4347b + ", ret=" + this.f4348c + ", context=" + this.f4349d + ", extra=" + this.f4350e + ", pack=" + this.f4351f + ", startTime=" + this.f4352g + ", streamingCallback=" + this.f4353h + ", cb=" + this.f4354i + ')';
    }
}
