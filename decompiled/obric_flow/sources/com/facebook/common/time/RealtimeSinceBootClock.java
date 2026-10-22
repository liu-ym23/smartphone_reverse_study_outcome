package com.facebook.common.time;

import com.facebook.common.internal.DoNotStrip;

/* JADX INFO: loaded from: classes2.dex */
@DoNotStrip
public class RealtimeSinceBootClock implements MonotonicClock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RealtimeSinceBootClock f7692a = null;

    static {
        f7692a = new RealtimeSinceBootClock();
    }

    private RealtimeSinceBootClock() {
    }

    @DoNotStrip
    public static RealtimeSinceBootClock get() {
        return f7692a;
    }

    @Override // com.facebook.common.time.MonotonicClock
    public final long now() {
        return android.os.SystemClock.elapsedRealtime();
    }
}
