package com.obric.memorydata.memory.ui.detail;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ImageViewerLaunchGate;", "", "minLaunchIntervalMs", "", "<init>", "(J)V", "lastLaunchAtMs", "Ljava/lang/Long;", "tryAcquire", "", "nowMs", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10862a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10863b;
    private Long c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ImageViewerLaunchGate$Companion;", "", "<init>", "()V", "DEFAULT_MIN_LAUNCH_INTERVAL_MS", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10862a = new a(null);
    }

    public l() {
        this(0, 1, null);
    }

    public l(long r1) {
        this.f10863b = r1;
    }

    public /* synthetic */ l(long r1, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = 500;
    L5:
        this(r1);
    }

    public final synchronized boolean a(long r9) {
        monitor-enter(this);
        Long r0 = this.c;     // Catch: Throwable -> L18
        if (r0 == null) goto L15;
        long r2 = this.f10863b;     // Catch: Throwable -> L18
        long r4 = r9 - r0.longValue();
        if (0 <= r4) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L15;
        monitor-exit(this);
        return false;
    L9:
        if (r4 >= r2) goto L11;
        r1 = true;
    L15:
        this.c = Long.valueOf(r9);     // Catch: Throwable -> L18
        monitor-exit(this);
        return true;
    L18:
        th = move-exception;
        throw th;
    }
}
