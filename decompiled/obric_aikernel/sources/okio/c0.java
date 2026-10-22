package okio;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f12192a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f12193b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b0 f12194c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f12195d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicReference<b0>[] f12196e = null;

    static {
        f12192a = new c0();
        f12193b = 65536;
        int r10 = 0;
        f12194c = new b0(new byte[0], 0, 0, false, false);
        int r11 = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f12195d = r11;
        AtomicReference<b0>[] r12 = new AtomicReference[r11];
    L3:
        if (r10 >= r11) goto L5;
        r12[r10] = new AtomicReference();
        r10 = r10 + 1;
        goto L3
    L5:
        f12196e = r12;
    }

    private c0() {
    }

    private final AtomicReference<b0> a() {
        int r10 = (int) (Thread.currentThread().getId() & (((long) f12195d) - 1));
        return f12196e[r10];
    }

    @JvmStatic
    public static final void b(b0 r10) {
        Intrinsics.checkNotNullParameter(r10, "segment");
        if (r10.f12177f == null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L25;
        if (r10.f12175d == false) goto L12;
        return;
    L12:
        AtomicReference<b0> r12 = f12192a.a();
        b0 r13 = f12194c;
        b0 r14 = r12.getAndSet(r13);
        if (r14 != r13) goto L15;
        return;
    L15:
        if (r14 == null) goto L17;
        int r15 = r14.f12174c;
    L19:
        if (r15 < f12193b) goto L22;
        r12.set(r14);
        return;
    L22:
        r10.f12177f = r14;
        r10.f12173b = 0;
        r10.f12174c = r15 + 8192;
        r12.set(r10);
        return;
    L17:
        r15 = 0;
        goto L19
    L25:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r10.f12178g != null) goto L7;
        r11 = true;
        goto L8
    }

    @JvmStatic
    public static final b0 c() {
        AtomicReference<b0> r10 = f12192a.a();
        b0 r11 = f12194c;
        b0 r12 = r10.getAndSet(r11);
        if (r12 != r11) goto L7;
        return new b0();
    L7:
        if (r12 != null) goto L10;
        r10.set(null);
        return new b0();
    L10:
        r10.set(r12.f12177f);
        r12.f12177f = null;
        r12.f12174c = 0;
        return r12;
    }
}
