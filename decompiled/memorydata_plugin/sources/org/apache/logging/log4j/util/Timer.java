package org.apache.logging.log4j.util;

import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes6.dex */
public class Timer implements Serializable, q {
    private static long NANO_PER_HOUR = 0;
    private static long NANO_PER_MINUTE = 0;
    private static long NANO_PER_SECOND = 1000000000;
    private static final long serialVersionUID = 9175191792439630013L;
    private long elapsedTime;
    private final int iterations;
    private final String name;
    private ThreadLocal<Long> startTime;
    private Status status;

    /* JADX INFO: renamed from: org.apache.logging.log4j.util.Timer$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17918a = null;

        static {
            int[] r0 = new int[Status.values().length];
            f17918a = r0;
            r0[Status.Started.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f17918a[Status.Paused.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f17918a[Status.Stopped.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status Paused = null;
        public static final Status Started = null;
        public static final Status Stopped = null;

        static {
            Status r0 = new Status("Started", 0);
            Started = r0;
            Status r1 = new Status("Stopped", 1);
            Stopped = r1;
            Status r3 = new Status("Paused", 2);
            Paused = r3;
            $VALUES = new Status[]{r0, r1, r3};
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        public static Status valueOf(String r2) {
            return (Status) ZeusTransformUtils.preCheckCast(Enum.valueOf(Status.class, r2), Status.class, "com.obric.memorydata.plugin");
        }

        public static Status[] values() {
            return (Status[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Status[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        long r0 = 1000000000 * 60;
        NANO_PER_MINUTE = r0;
        NANO_PER_HOUR = r0 * 60;
    }

    public Timer(String r2) {
        this(r2, 0);
    }

    public Timer(String r2, int r3) {
        this.startTime = new AnonymousClass1(this);
        this.name = r2;
        this.status = Status.Stopped;
        if (r3 > 0) goto L6;
        r3 = 0;
    L6:
        this.iterations = r3;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, Timer.class) == true) goto L8;
        return false;
    L8:
        Timer r10 = (Timer) ZeusTransformUtils.preCheckCast(r9, Timer.class, "com.obric.memorydata.plugin");
        if (this.elapsedTime == r10.elapsedTime) goto L12;
        return false;
    L12:
        if (this.startTime == r10.startTime) goto L14;
        return false;
    L14:
        String r0 = this.name;
        if (r0 == null) goto L20;
        if (r0.equals(r10.name) == false) goto L21;
    L22:
        Status r8 = this.status;
        if (r8 == null) goto L28;
        if (r8.equals(r10.status) == false) goto L29;
    L30:
        return true;
    L29:
        return false;
    L28:
        if (r10.status == null) goto L30;
    L21:
        return false;
    L20:
        if (r10.name == null) goto L22;
        goto L21
    }

    @Override // org.apache.logging.log4j.util.q
    public void formatTo(StringBuilder r19) {
        r19.append("Timer ").append(this.name);
        int r2 = AnonymousClass2.f17918a[this.status.ordinal()];
        if (r2 != 1) goto L5;
        String r0 = " started";
    L29:
        r19.append(r0);
        return;
    L5:
        if (r2 != 2) goto L7;
        r0 = " paused";
        goto L29
    L7:
        if (r2 == 3) goto L9;
        r19.append(' ').append(this.status);
        return;
    L9:
        long r3 = this.elapsedTime;
        long r4 = NANO_PER_HOUR;
        long r6 = r3 / r4;
        long r5 = r3 % r4;
        long r7 = NANO_PER_MINUTE;
        long r8 = r5 / r7;
        long r9 = r5 % r7;
        long r10 = NANO_PER_SECOND;
        long r11 = r9 / r10;
        long r12 = r9 % r10;
        String r14 = "";
        if (r6 <= 0) goto L12;
        String r13 = "" + r6 + " hours ";
    L14:
        if (r8 > 0) goto L16;
        if (r6 > 0) goto L16;
    L17:
        r19.append(" stopped. Elapsed time: ").append((r13 + new DecimalFormat("#0").format(r11) + '.') + new DecimalFormat("000000000").format(r12) + " seconds");
        int r15 = this.iterations;
        if (r15 <= 0) goto L32;
        long r16 = this.elapsedTime / ((long) r15);
        long r17 = NANO_PER_HOUR;
        long r18 = r16 / r17;
        long r110 = r16 % r17;
        long r20 = NANO_PER_MINUTE;
        long r1 = r110 / r20;
        long r111 = r110 % r20;
        long r21 = NANO_PER_SECOND;
        long r22 = r111 / r21;
        long r112 = r111 % r21;
        if (r18 <= 0) goto L23;
        r14 = "" + r18 + " hours ";
    L23:
        if (r1 > 0) goto L25;
        if (r18 > 0) goto L25;
    L26:
        r19.append(" Average per iteration: ").append((r14 + new DecimalFormat("#0").format(r22) + '.') + new DecimalFormat("000000000").format(r112) + " seconds");
        return;
    L25:
        r14 = r14 + r1 + " minutes ";
        goto L26
    L32:
        return;
    L16:
        r13 = r13 + r8 + " minutes ";
        goto L17
    L12:
        r13 = "";
        goto L14
    }

    public long getElapsedNanoTime() {
        return this.elapsedTime;
    }

    public long getElapsedTime() {
        return this.elapsedTime / TimeUtils.NANOSECONDS_PER_MILLISECOND;
    }

    public String getName() {
        return this.name;
    }

    public Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 29;
        Status r4 = this.status;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = r3 + r1;
        long r6 = ((Long) ZeusTransformUtils.preCheckCast(this.startTime.get(), Long.class, "com.obric.memorydata.plugin")).longValue();
        int r7 = ((r5 * 29) + ((int) (r6 ^ (r6 >>> 32)))) * 29;
        long r8 = this.elapsedTime;
        return r7 + ((int) (r8 ^ (r8 >>> 32)));
    L5:
        r2 = 0;
        goto L6
    }

    public synchronized void pause() {
        monitor-enter(this);
        this.elapsedTime += System.nanoTime() - ((Long) ZeusTransformUtils.preCheckCast(this.startTime.get(), Long.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L6
        this.startTime.set(0L);     // Catch: Throwable -> L6
        this.status = Status.Paused;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void resume() {
        monitor-enter(this);
        this.startTime.set(Long.valueOf(System.nanoTime()));     // Catch: Throwable -> L6
        this.status = Status.Started;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void start() {
        monitor-enter(this);
        this.startTime.set(Long.valueOf(System.nanoTime()));     // Catch: Throwable -> L6
        this.elapsedTime = 0;     // Catch: Throwable -> L6
        this.status = Status.Started;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void startOrResume() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.status != Status.Stopped) goto L6;
        start();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        resume();     // Catch: Throwable -> L9
        goto L7
    }

    public synchronized String stop() {
        monitor-enter(this);
        this.elapsedTime += System.nanoTime() - ((Long) ZeusTransformUtils.preCheckCast(this.startTime.get(), Long.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L6
        this.startTime.set(0L);     // Catch: Throwable -> L6
        this.status = Status.Stopped;     // Catch: Throwable -> L6
        String r0 = toString();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        formatTo(r0);
        return r0.toString();
    }
}
