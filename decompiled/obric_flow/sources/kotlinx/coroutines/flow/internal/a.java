package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c[] f18859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18861c;
    public y d;

    public final c c() {
        monitor-enter(this);
        c[] r5 = this.f18859a;     // Catch: Throwable -> L6
        if (r5 != null) goto L9;
        r5 = f();     // Catch: Throwable -> L6
        this.f18859a = r5;     // Catch: Throwable -> L6
    L11:
        int r10 = this.f18861c;     // Catch: Throwable -> L6
    L12:
        c r11 = r5[r10];     // Catch: Throwable -> L6
        if (r11 != null) goto L15;
        r11 = e();     // Catch: Throwable -> L6
        r5[r10] = r11;     // Catch: Throwable -> L6
    L15:
        r10 = r10 + 1;     // Catch: Throwable -> L6
        if (r10 < r5.length) goto L18;
        r10 = 0;
    L18:
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L6
        if (r11.a(this) == false) goto L12;
        this.f18861c = r10;     // Catch: Throwable -> L6
        this.f18860b++;     // Catch: Throwable -> L6
        y r12 = this.d;     // Catch: Throwable -> L6
        monitor-exit(this);
        if (r12 == null) goto L24;
        r12.v(1);
    L24:
        return r11;
    L9:
        if (this.f18860b < r5.length) goto L11;
        Object[] r13 = Arrays.copyOf(r5, r5.length * 2);     // Catch: Throwable -> L6
        this.f18859a = (c[]) r13;     // Catch: Throwable -> L6
        r5 = (c[]) r13;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public abstract c e();

    public abstract c[] f();

    public final void g(c r10) {
        monitor-enter(this);
        int r5 = this.f18860b - 1;     // Catch: Throwable -> L6
        this.f18860b = r5;     // Catch: Throwable -> L6
        y r11 = this.d;     // Catch: Throwable -> L6
        int r12 = 0;
        if (r5 != 0) goto L8;
        this.f18861c = 0;     // Catch: Throwable -> L6
    L8:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L6
        Continuation[] r13 = r10.b(this);     // Catch: Throwable -> L6
        monitor-exit(this);
        int r14 = r13.length;
    L11:
        if (r12 >= r14) goto L16;
        Continuation r15 = r13[r12];
        if (r15 == null) goto L15;
        Result.Companion r16 = Result.Companion;
        r15.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));
    L15:
        r12 = r12 + 1;
        goto L11
    L16:
        if (r11 == null) goto L26;
        r11.v(-1);
        return;
    L26:
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final y h() {
        monitor-enter(this);
        y r5 = this.d;     // Catch: Throwable -> L7
        if (r5 != null) goto L9;
        int r10 = this.f18860b;     // Catch: Throwable -> L7
        r5 = new y(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);     // Catch: Throwable -> L7
        r5.a(Integer.valueOf(r10));     // Catch: Throwable -> L7
        this.d = r5;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }
}
