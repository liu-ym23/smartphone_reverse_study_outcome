package org.ehcache.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.ehcache.Status;

/* JADX INFO: loaded from: classes7.dex */
abstract enum InternalStatus extends Enum<InternalStatus> {
    private static final /* synthetic */ InternalStatus[] $VALUES = null;
    public static final InternalStatus AVAILABLE = null;
    public static final InternalStatus MAINTENANCE = null;
    public static final InternalStatus UNINITIALIZED = null;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InternalStatus f18000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InternalStatus f18001b;
        private final Thread c;
        private volatile InternalStatus d;

        private a(InternalStatus r1, InternalStatus r2) {
            this.f18000a = r1;
            this.c = Thread.currentThread();
            Objects.requireNonNull(r2);
            this.f18001b = r2;
        }

        /* synthetic */ a(InternalStatus r1, InternalStatus r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public InternalStatus a() {
            if (this.d == null) goto L7;
            return this.d;
        L7:
            if (this.c == Thread.currentThread()) goto L9;
            monitor-enter(this);
            boolean r0 = false;
        L35:
        L25:
            th = move-exception;
            throw th;
        L27:
            th = move-exception;
            if (r0 == false) goto L30;
            Thread.currentThread().interrupt();     // Catch: Throwable -> L25
        L30:
            throw th;     // Catch: Throwable -> L25
        L16:
            if (this.d != null) goto L20;
            wait();     // Catch: InterruptedException -> L19 Throwable -> L27
        L19:
            r0 = true;
            goto L35
        L20:
            if (r0 == false) goto L22;
            Thread.currentThread().interrupt();     // Catch: Throwable -> L25
        L22:
            InternalStatus r1 = this.d;     // Catch: Throwable -> L25
            monitor-exit(this);     // Catch: Throwable -> L25
            return r1;
        L9:
            if (this.f18001b.compareTo(d()) <= 0) goto L12;
            return this.f18001b;
        L12:
            return d();
        }

        public synchronized void b() {
            monitor-enter(this);
            this.d = this.f18001b;     // Catch: Throwable -> L6
            notifyAll();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void c() {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.f18001b.compareTo(d()) <= 0) goto L6;
            InternalStatus r0 = d();     // Catch: Throwable -> L10
        L7:
            this.d = r0;     // Catch: Throwable -> L10
            notifyAll();     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L6:
            r0 = this.f18001b;     // Catch: Throwable -> L10
            goto L7
        }

        public InternalStatus d() {
            return this.f18000a;
        }

        public InternalStatus e() {
            return this.f18001b;
        }

        public boolean f() {
            if (this.d == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        final String r1 = "UNINITIALIZED";
        final int r2 = 0;
        InternalStatus r0 = new AnonymousClass1(r1, r2);
        UNINITIALIZED = r0;
        final String r3 = "MAINTENANCE";
        final int r4 = 1;
        InternalStatus r5 = new AnonymousClass2(r3, r4);
        MAINTENANCE = r5;
        final String r6 = "AVAILABLE";
        final int r7 = 2;
        InternalStatus r8 = new AnonymousClass3(r6, r7);
        AVAILABLE = r8;
        $VALUES = new InternalStatus[]{r0, r5, r8};
    }

    private InternalStatus(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ InternalStatus(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static a initial() {
        a r0 = MAINTENANCE.close();
        r0.b();
        return r0;
    }

    public static InternalStatus valueOf(String r2) {
        return (InternalStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(InternalStatus.class, r2), InternalStatus.class, "com.obric.memorydata.plugin");
    }

    public static InternalStatus[] values() {
        return (InternalStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), InternalStatus[].class, "com.obric.memorydata.plugin");
    }

    public a close() {
        throw new IllegalStateException("Close not supported from " + name());
    }

    public a init() {
        throw new IllegalStateException("Init not supported from " + name());
    }

    public a maintenance() {
        throw new IllegalStateException("Maintenance not supported from " + name());
    }

    public abstract Status toPublicStatus();
}
