package a7;

import com.bytedance.geckox.utils.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements la.a {
    public static volatile boolean f = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f144c;
    public final Serializable d;
    public final Object e;

    public c(long r10, File r12) {
        this.f143b = r10;
        this.e = r12;
        this.d = new AtomicBoolean(false);
        boolean r5 = r12.getParentFile().mkdirs();
        RandomAccessFile r11 = new RandomAccessFile(r12, "rw");     // Catch: Exception -> L5
        r11.setLength(r10);     // Catch: Exception -> L5
        this.f144c = r11;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        boolean r13 = ((File) this.e).getParentFile().exists();
        if ((e instanceof FileNotFoundException) == false) goto L14;
        boolean r14 = ((File) this.e).getParentFile().mkdirs();
        boolean r15 = ((File) this.e).getParentFile().exists();
        RandomAccessFile r16 = new RandomAccessFile((File) this.e, "rw");     // Catch: Exception -> L11
        r16.setLength(this.f143b);     // Catch: Exception -> L11
        this.f144c = r16;     // Catch: Exception -> L11
        return;
    L11:
        d.c((RandomAccessFile) this.f144c);
        throw new IOException("create raf swap failed[2 dir mk:" + r14 + ",dir exist:+" + r15 + ", dir mk:" + r5 + ",dir exist:+" + r13 + "]! path: " + ((File) this.e).getAbsolutePath() + " caused by: " + e.getMessage(), e);
    L14:
        throw new IOException("create raf swap failed[1 dir mk:" + r5 + ",dir exist:+" + r13 + "]! path: " + ((File) this.e).getAbsolutePath() + " caused by: " + e.getMessage(), e);
    }

    @Override // la.a
    public synchronized long a(long r5) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (((AtomicBoolean) this.d).get() == true) goto L22;
        int r10 = (int) r5;     // Catch: Throwable -> L10
        if (r10 != r5) goto L20;
        RandomAccessFile r11 = (RandomAccessFile) this.f144c;     // Catch: Throwable -> L10
        if (r11 != null) goto L12;
        Intrinsics.throwNpe();     // Catch: Throwable -> L10
    L12:
        int r12 = r11.skipBytes(r10);     // Catch: Throwable -> L10
        RandomAccessFile r13 = (RandomAccessFile) this.f144c;     // Catch: Throwable -> L10
        if (r13 != null) goto L15;
        Intrinsics.throwNpe();     // Catch: Throwable -> L10
    L15:
        this.f142a = r13.getFilePointer();     // Catch: Throwable -> L10
        long r14 = r12;
        monitor-exit(this);
        return r14;
    L20:
        throw new IOException("too large:" + r5);     // Catch: Throwable -> L10
    L22:
        throw new IOException("released!");     // Catch: Throwable -> L10
    }

    @Override // la.a
    public File b() {
        return (File) this.e;
    }

    @Override // la.a
    public long c() {
        if (((AtomicBoolean) this.d).get() == true) goto L7;
        return this.f142a;
    L7:
        throw new IOException("released!");
    }

    @Override // la.a
    public void d() {
        if (((AtomicBoolean) this.d).get() == true) goto L6;
        return;
    L6:
        throw new IOException("released!");
    }

    @Override // la.a
    public void e() {
        release();
        ((File) this.e).delete();
    }

    public boolean f() {
        return "start_trace".equals((String) this.d);
    }

    @Override // la.a
    /* JADX INFO: renamed from: finish */
    public void mo119finish() {
    }

    @Override // la.a
    public void g(long r5) {
        if (((AtomicBoolean) this.d).get() == true) goto L16;
        long r10 = 0;
        if (r5 >= 0) goto L7;
    L6:
        r5 = r10;
    L10:
        this.f142a = r5;
        RandomAccessFile r11 = (RandomAccessFile) this.f144c;
        if (r11 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        r11.seek(this.f142a);
        return;
    L7:
        r10 = this.f143b;
        if (r5 <= r10) goto L10;
    L16:
        throw new IOException("released!");
    }

    @Override // la.a
    public long length() {
        return this.f143b;
    }

    @Override // la.a
    public void release() {
        if (((AtomicBoolean) this.d).getAndSet(true) == false) goto L5;
        return;
    L5:
        d.c((RandomAccessFile) this.f144c);
    }

    @Override // la.a
    public void write(int r5) {
        write(new byte[]{(byte) r5}, 0, 1);
    }

    @Override // la.a
    public int b(byte[] r5) {
        return c(r5, 0, r5.length);
    }

    @Override // la.a
    public void write(byte[] r5) {
        write(r5, 0, r5.length);
    }

    @Override // la.a
    public int c(byte[] r10, int r11, int r12) {
        if (((AtomicBoolean) this.d).get() == true) goto L39;
        if (r12 < 1) goto L36;
        if (r11 >= 0) goto L8;
        return 0;
    L8:
        if (r11 < r10.length) goto L11;
        return 0;
    L11:
        if ((r11 + r12) <= r10.length) goto L13;
        r12 = r10.length - r11;
    L13:
        monitor-enter(this);
        long r5 = this.f142a;     // Catch: Throwable -> L25
        long r13 = this.f143b;     // Catch: Throwable -> L25
        if (r5 != r13) goto L20;
        monitor-exit(this);
        return -1;
    L20:
        if ((((long) r12) + r5) <= r13) goto L22;
        r12 = (int) (r13 - r5);
    L22:
        RandomAccessFile r14 = (RandomAccessFile) this.f144c;     // Catch: Throwable -> L25
        if (r14 != null) goto L27;
        Intrinsics.throwNpe();     // Catch: Throwable -> L25
    L27:
        int r15 = r14.read(r10, r11, r12);     // Catch: Throwable -> L25
        if (r15 != (-1)) goto L31;
        monitor-exit(this);
        return -1;
    L31:
        this.f142a += (long) r15;     // Catch: Throwable -> L25
        monitor-exit(this);
        return r15;
    L25:
        th = move-exception;
        throw th;
    L36:
        return 0;
    L39:
        throw new IOException("released!");
    }

    @Override // la.a
    public int write(byte[] r10, int r11, int r12) {
        if (((AtomicBoolean) this.d).get() == true) goto L37;
        if (r10.length != 0) goto L7;
    L35:
        return 0;
    L7:
        if (r12 < 1) goto L35;
        if (r11 < 0) goto L35;
        if (r11 >= r10.length) goto L35;
        if ((r11 + r12) <= r10.length) goto L16;
        r12 = r10.length - r11;
    L16:
        monitor-enter(this);
        long r5 = this.f142a;     // Catch: Throwable -> L28
        long r13 = this.f143b;     // Catch: Throwable -> L28
        if (r5 != r13) goto L23;
        monitor-exit(this);
        return 0;
    L23:
        if ((((long) r12) + r5) <= r13) goto L25;
        r12 = (int) (r13 - r5);
    L25:
        RandomAccessFile r14 = (RandomAccessFile) this.f144c;     // Catch: Throwable -> L28
        if (r14 != null) goto L30;
        Intrinsics.throwNpe();     // Catch: Throwable -> L28
    L30:
        r14.write(r10, r11, r12);     // Catch: Throwable -> L28
        this.f142a += (long) r12;     // Catch: Throwable -> L28
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(this);
        return r12;
    L28:
        th = move-exception;
        throw th;
    L37:
        throw new IOException("released!");
    }

    @Override // la.a
    public int a() {
        byte[] r5 = new byte[1];
        if (c(r5, 0, 1) != 0) goto L7;
        return -1;
    L7:
        return r5[0];
    }

    public c() {
        this.f144c = new ConcurrentHashMap(4);
        this.d = "start_trace";
        this.e = "launch_stats";
    }
}
