package kotlinx.metadata.internal.protobuf;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f19154a = null;

    static {
        f19154a = new x(new byte[0]);
    }

    public static e b(Iterator r5, int r10) {
        if (r10 == 1) goto L7;
        int r11 = r10 >>> 1;
        return b(r5, r11).c(b(r5, r10 - r11));
    L7:
        return (e) r5.next();
    }

    public static x d(String r5) {
        return new x(r5.getBytes("UTF-8"));
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }

    public static d k() {
        return new d();
    }

    public final e c(e r10) {
        int r5 = size();
        int r11 = r10.size();
        if ((((long) r5) + ((long) r11)) >= 2147483647L) goto L35;
        int[] r12 = f0.f19163h;
        if ((this instanceof f0) == false) goto L7;
        f0 r13 = (f0) this;
    L9:
        if (r10.size() != 0) goto L12;
        return this;
    L12:
        if (size() == 0) goto L34;
        int r14 = size();
        int r15 = r10.size() + r14;
        if (r15 >= 128) goto L17;
        int r16 = size();
        int r17 = r10.size();
        byte[] r18 = new byte[r16 + r17];
        e(r18, 0, 0, r16);
        r10.e(r18, 0, r16, r17);
        return new x(r18);
    L17:
        if (r13 == null) goto L21;
        e r19 = r13.d;
        int r20 = r19.size();
        if ((r10.size() + r20) >= 128) goto L21;
        int r21 = r19.size();
        int r22 = r10.size();
        byte[] r23 = new byte[r21 + r22];
        r19.e(r23, 0, 0, r21);
        r10.e(r23, 0, r21, r22);
        x r24 = new x(r23);
        r10 = new f0(r13.f19165c, r24);
    L21:
        if (r13 == null) goto L27;
        e r25 = r13.f19165c;
        int r26 = r25.g();
        e r27 = r13.d;
        if (r26 <= r27.g()) goto L27;
        int r28 = r10.g();
        if (r13.f <= r28) goto L27;
        r10 = new f0(r25, new f0(r27, r10));
    L27:
        int r29 = Math.max(g(), r10.g()) + 1;
        if (r15 >= f0.f19163h[r29]) goto L39;
        jg.k r30 = new jg.k(10);
        r30.h(this);
        r30.h(r10);
        Stack r31 = (Stack) r30.f18339b;
        r10 = (e) r31.pop();
    L32:
        if (r31.isEmpty() == true) goto L34;
        r10 = new f0((e) r31.pop(), r10);
        goto L32
    L39:
        return new f0(this, r10);
    L34:
        return r10;
    L7:
        r13 = null;
        goto L9
    L35:
        StringBuilder r32 = new StringBuilder(53);
        r32.append("ByteString would be too long: ");
        r32.append(r5);
        r32.append("+");
        r32.append(r11);
        throw new IllegalArgumentException(r32.toString());
    }

    public final void e(byte[] r5, int r10, int r11, int r12) {
        if (r10 < 0) goto L22;
        if (r11 < 0) goto L20;
        if (r12 < 0) goto L18;
        int r13 = r10 + r12;
        if (r13 > size()) goto L16;
        int r14 = r11 + r12;
        if (r14 > r5.length) goto L14;
        if (r12 <= 0) goto L23;
        f(r5, r10, r11, r12);
        return;
    L23:
        return;
    L14:
        throw new IndexOutOfBoundsException(androidx.constraintlayout.motion.widget.a.i(34, "Target end offset < 0: ", r14));
    L16:
        throw new IndexOutOfBoundsException(androidx.constraintlayout.motion.widget.a.i(34, "Source end offset < 0: ", r13));
    L18:
        throw new IndexOutOfBoundsException(androidx.constraintlayout.motion.widget.a.i(23, "Length < 0: ", r12));
    L20:
        throw new IndexOutOfBoundsException(androidx.constraintlayout.motion.widget.a.i(30, "Target offset < 0: ", r11));
    L22:
        throw new IndexOutOfBoundsException(androidx.constraintlayout.motion.widget.a.i(30, "Source offset < 0: ", r10));
    }

    public abstract void f(byte[] r5, int r10, int r11, int r12);

    public abstract int g();

    public abstract boolean h();

    public abstract boolean i();

    public abstract f j();

    public abstract int l(int r5, int r10, int r11);

    public abstract int m(int r5, int r10, int r11);

    public abstract int n();

    public abstract String o();

    public final String p() {
        return o();
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }

    public abstract void q(OutputStream r5, int r10, int r11);

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }
}
