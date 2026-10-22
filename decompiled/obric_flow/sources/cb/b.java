package cb;

import com.bytedance.gkfs.d;
import com.lynx.tasm.base.h;
import com.lynx.tasm.p;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f1170b;

    public b(a r5) {
        this.f1170b = r5;
    }

    @Override // java.io.InputStream
    public final synchronized int available() {
        monitor-enter(this);
        int r5 = this.f1170b.f1168c - this.f1169a;
        monitor-exit(this);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final synchronized int read() {
        monitor-enter(this);
        int r5 = this.f1169a;     // Catch: Throwable -> L11
        a r10 = this.f1170b;     // Catch: Throwable -> L11
        int r11 = r10.f1168c;     // Catch: Throwable -> L11
        if (r5 >= r11) goto L15;
        this.f1169a = r5 + 1;     // Catch: Throwable -> L11
        if (r5 >= r11) goto L13;
        int r12 = r5 / 4096;     // Catch: Throwable -> L11
        byte[] r13 = (byte[]) r10.f1167b.get(r12);     // Catch: Throwable -> L11
        int r14 = r13[r5 - (r12 * 4096)] & UByte.MAX_VALUE;
        monitor-exit(this);
        return r14;
    L13:
        StringBuilder r15 = p.d(r5, "index ", " is larger than array size ");     // Catch: Throwable -> L11
        r15.append(r10.f1168c);     // Catch: Throwable -> L11
        throw new IndexOutOfBoundsException(r15.toString());     // Catch: Throwable -> L11
    L15:
        monitor-exit(this);
        return -1;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final synchronized int read(byte[] r12, int r13, int r14) {
        monitor-enter(this);
        r12.getClass();     // Catch: Throwable -> L25
        if (r13 < 0) goto L35;
        if (r14 < 0) goto L35;
        if (r14 > (r12.length - r13)) goto L35;
        if (r14 != 0) goto L13;
        monitor-exit(this);
        return 0;
    L13:
        int r5 = available();     // Catch: Throwable -> L25
        if (r5 > 0) goto L18;
        monitor-exit(this);
        return -1;
    L18:
        int r15 = Math.min(r14, r5);     // Catch: Throwable -> L25
        a r10 = this.f1170b;     // Catch: Throwable -> L25
        int r11 = this.f1169a;     // Catch: Throwable -> L25
        int r16 = r11 + r15;     // Catch: Throwable -> L25
        r10.getClass();     // Catch: Throwable -> L25
        if (r16 > r10.f1168c) goto L32;
        int r17 = r11 / 4096;     // Catch: Throwable -> L25
        int r18 = r16 - r11;     // Catch: Throwable -> L25
        int r19 = r10.f1167b.size();     // Catch: Throwable -> L25
        int r20 = 0;
    L21:
        if (r17 >= r19) goto L27;
        if (r20 >= r18) goto L27;
        int r21 = (r11 + r20) % 4096;     // Catch: Throwable -> L25
        int r22 = Math.min(((byte[]) r10.f1167b.get(r17)).length - r21, r18 - r20);     // Catch: Throwable -> L25
        System.arraycopy(r10.f1167b.get(r17), r21, r12, r13 + r20, r22);     // Catch: Throwable -> L25
        r20 = r20 + r22;     // Catch: Throwable -> L25
        r17 = r17 + 1;     // Catch: Throwable -> L25
    L27:
        if (r20 == r18) goto L29;
        d.f(r10.f1166a, "SegmentalByteArray", h.b(r18, r20, "except copy ", " bytes but only copied "), 0, 28);     // Catch: Throwable -> L25
    L29:
        this.f1169a += r15;     // Catch: Throwable -> L25
        monitor-exit(this);
        return r15;
    L32:
        StringBuilder r110 = p.d(r16, "endIndex ", " larger than array size ");     // Catch: Throwable -> L25
        r110.append(r10.f1168c);     // Catch: Throwable -> L25
        throw new IndexOutOfBoundsException(r110.toString());     // Catch: Throwable -> L25
    L35:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }
}
