package nu;

import java.io.Closeable;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f20321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f20323c;
    public long d;
    public byte[] e;
    public int f;
    public int g;

    public g() {
        this.d = -1;
        this.f = -1;
        this.g = -1;
    }

    public final void b(long r16) {
        j r5 = this.f20321a;
        if (r5 == null) goto L33;
        if (this.f20322b == false) goto L31;
        long r10 = r5.f20328b;
        long r11 = 0;
        if (r16 <= r10) goto L9;
        if (r16 <= r10) goto L28;
        long r12 = r16 - r10;
        int r13 = 1;
        boolean r14 = true;
    L23:
        if (r12 <= r11) goto L28;
        y r15 = r5.P(r13);
        int r17 = (int) Math.min(r12, 8192 - r15.f20354c);
        int r18 = r15.f20354c + r17;
        r15.f20354c = r18;
        r12 = r12 - ((long) r17);
        if (r14 == false) goto L27;
        this.f20323c = r15;
        this.d = r10;
        this.e = r15.f20352a;
        this.f = r18 - r17;
        this.g = r18;
        r14 = false;
    L27:
        r13 = 1;
        r11 = 0;
    L28:
        r5.f20328b = r16;
        return;
    L9:
        if (r16 < 0) goto L19;
        long r19 = r10 - r16;
    L12:
        if (r19 <= 0) goto L17;
        y r20 = r5.f20327a;
        Intrinsics.checkNotNull(r20);
        y r21 = r20.g;
        Intrinsics.checkNotNull(r21);
        int r22 = r21.f20354c;
        long r110 = r22 - r21.f20353b;
        if (r110 > r19) goto L16;
        r5.f20327a = r21.a();
        z.a(r21);
        r19 = r19 - r110;
        goto L12
    L16:
        r21.f20354c = r22 - ((int) r19);
    L17:
        this.f20323c = null;
        this.d = r16;
        this.e = null;
        this.f = -1;
        this.g = -1;
        goto L28
    L19:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r16, "newSize < 0: ").toString());
    L31:
        throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
    L33:
        throw new IllegalStateException("not attached to a buffer");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f20321a == null) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L10;
        this.f20321a = null;
        this.f20323c = null;
        this.d = -1;
        this.e = null;
        this.f = -1;
        this.g = -1;
        return;
    L10:
        throw new IllegalStateException("not attached to a buffer");
    L5:
        r5 = false;
        goto L6
    }

    public final int d(long r14) {
        j r5 = this.f20321a;
        if (r5 == null) goto L43;
        if (r14 < (-1)) goto L40;
        long r10 = r5.f20328b;
        if (r14 > r10) goto L40;
        if (r14 == (-1)) goto L38;
        if (r14 == r10) goto L38;
        y r11 = r5.f20327a;
        y r12 = this.f20323c;
        long r13 = 0;
        if (r12 == null) goto L18;
        long r15 = this.d;
        int r16 = this.f;
        Intrinsics.checkNotNull(r12);
        long r17 = r15 - ((long) (r16 - r12.f20353b));
        if (r17 <= r14) goto L17;
        y r18 = r11;
        r11 = this.f20323c;
        r10 = r17;
    L20:
        if ((r10 - r14) <= (r14 - r13)) goto L25;
    L21:
        Intrinsics.checkNotNull(r18);
        long r19 = ((long) (r18.f20354c - r18.f20353b)) + r13;
        if (r14 < r19) goto L29;
        r18 = r18.f;
        r13 = r19;
    L29:
        if (this.f20322b == false) goto L36;
        Intrinsics.checkNotNull(r18);
        if (r18.d == false) goto L36;
        byte[] r20 = r18.f20352a;
        y r21 = new y(Arrays.copyOf(r20, r20.length), r18.f20353b, r18.f20354c, false, true);
        if (r5.f20327a != r18) goto L35;
        r5.f20327a = r21;
    L35:
        r18.b(r21);
        y r22 = r21.g;
        Intrinsics.checkNotNull(r22);
        r22.a();
        r18 = r21;
    L36:
        this.f20323c = r18;
        this.d = r14;
        Intrinsics.checkNotNull(r18);
        this.e = r18.f20352a;
        int r23 = r18.f20353b + ((int) (r14 - r13));
        this.f = r23;
        int r110 = r18.f20354c;
        this.g = r110;
        return r110 - r23;
    L25:
        if (r10 <= r14) goto L27;
        Intrinsics.checkNotNull(r11);
        r11 = r11.g;
        Intrinsics.checkNotNull(r11);
        r10 = r10 - ((long) (r11.f20354c - r11.f20353b));
        goto L25
    L27:
        r18 = r11;
        r13 = r10;
        goto L29
    L17:
        r18 = this.f20323c;
        r13 = r17;
        goto L20
    L18:
        r18 = r11;
    L38:
        this.f20323c = null;
        this.d = r14;
        this.e = null;
        this.f = -1;
        this.g = -1;
        return -1;
    L40:
        StringCompanionObject r24 = StringCompanionObject.INSTANCE;
        throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(r14), Long.valueOf(r5.f20328b)}, 2)));
    L43:
        throw new IllegalStateException("not attached to a buffer");
    }
}
