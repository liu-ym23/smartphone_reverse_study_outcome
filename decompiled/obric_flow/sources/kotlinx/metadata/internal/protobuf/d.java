package kotlinx.metadata.internal.protobuf;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends OutputStream {
    public static final byte[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f19149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19150c;
    public byte[] d;
    public int e;

    static {
        f = new byte[0];
    }

    public d() {
        this.f19148a = 128;
        this.f19149b = new ArrayList();
        this.d = new byte[128];
    }

    public final void b(int r5) {
        this.f19149b.add(new x(this.d));
        int r10 = this.f19150c + this.d.length;
        this.f19150c = r10;
        int r11 = Math.max(r5, r10 >>> 1);
        this.d = new byte[Math.max(this.f19148a, r11)];
        this.e = 0;
    }

    public final void d() {
        int r5 = this.e;
        byte[] r10 = this.d;
        int r11 = r10.length;
        ArrayList r12 = this.f19149b;
        if (r5 >= r11) goto L6;
        if (r5 <= 0) goto L7;
        byte[] r13 = new byte[r5];
        System.arraycopy(r10, 0, r13, 0, Math.min(r10.length, r5));
        r12.add(new x(r13));
    L7:
        this.f19150c += this.e;
        this.e = 0;
        return;
    L6:
        r12.add(new x(this.d));
        this.d = f;
        goto L7
    }

    public final synchronized e e() {
        monitor-enter(this);
        d();     // Catch: Throwable -> L16
        ArrayList r5 = this.f19149b;     // Catch: Throwable -> L16
        if (r5 != null) goto L11;
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L16
        Iterator r11 = r5.iterator();     // Catch: Throwable -> L16
    L7:
        if (r11.hasNext() == false) goto L9;
        r10.add((e) r11.next());     // Catch: Throwable -> L16
        goto L7
    L9:
        r5 = r10;
    L11:
        if (r5.isEmpty() == false) goto L13;
        e r12 = e.f19154a;     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return r12;
    L13:
        r12 = e.b(r5.iterator(), r5.size());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final String toString() {
        String r5 = Integer.toHexString(System.identityHashCode(this));
        monitor-enter(this);
        int r10 = this.f19150c + this.e;
        monitor-exit(this);
        return String.format("<ByteString.Output@%s size=%d>", new Object[]{r5, Integer.valueOf(r10)});
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int r5) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.e != this.d.length) goto L8;
        b(1);     // Catch: Throwable -> L6
    L8:
        byte[] r10 = this.d;     // Catch: Throwable -> L6
        int r11 = this.e;     // Catch: Throwable -> L6
        this.e = r11 + 1;     // Catch: Throwable -> L6
        r10[r11] = (byte) r5;     // Catch: Throwable -> L6
        monitor-exit(this);
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] r5, int r10, int r11) {
        monitor-enter(this);
        byte[] r12 = this.d;     // Catch: Throwable -> L6
        int r13 = r12.length;     // Catch: Throwable -> L6
        int r14 = this.e;     // Catch: Throwable -> L6
        if (r11 > (r13 - r14)) goto L8;
        System.arraycopy(r5, r10, r12, r14, r11);     // Catch: Throwable -> L6
        this.e += r11;     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);
        return;
    L8:
        int r15 = r12.length - r14;     // Catch: Throwable -> L6
        System.arraycopy(r5, r10, r12, r14, r15);     // Catch: Throwable -> L6
        int r16 = r11 - r15;     // Catch: Throwable -> L6
        b(r16);     // Catch: Throwable -> L6
        System.arraycopy(r5, r10 + r15, this.d, 0, r16);     // Catch: Throwable -> L6
        this.e = r16;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
