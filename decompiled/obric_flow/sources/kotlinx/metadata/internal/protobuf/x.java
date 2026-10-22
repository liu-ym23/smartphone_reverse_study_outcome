package kotlinx.metadata.internal.protobuf;

import java.io.OutputStream;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class x extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f19212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19213c;

    public x(byte[] r5) {
        this.f19213c = 0;
        this.f19212b = r5;
    }

    public final boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L9;
        return false;
    L9:
        if (size() == ((e) r5).size()) goto L12;
        return false;
    L12:
        if (size() != 0) goto L15;
        return true;
    L15:
        if ((r5 instanceof x) == false) goto L19;
        return r((x) r5, 0, size());
    L19:
        if ((r5 instanceof f0) == true) goto L21;
        String r10 = String.valueOf(r5.getClass());
        throw new IllegalArgumentException(ai.j0.q(new StringBuilder(r10.length() + 49), "Has a new type of ByteString been created? Found ", r10));
    L21:
        return r5.equals(this);
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public void f(byte[] r5, int r10, int r11, int r12) {
        System.arraycopy(this.f19212b, r10, r5, r11, r12);
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final int g() {
        return 0;
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final boolean h() {
        return true;
    }

    public final int hashCode() {
        int r5 = this.f19213c;
        if (r5 != 0) goto L8;
        int r10 = size();
        r5 = l(r10, 0, r10);
        if (r5 != 0) goto L7;
        r5 = 1;
    L7:
        this.f19213c = r5;
    L8:
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final boolean i() {
        byte[] r5 = this.f19212b;
        if (j0.c(r5, 0, r5.length) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new w(this);
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final f j() {
        f r5 = new f(this);
        r5.d(size());     // Catch: InvalidProtocolBufferException -> L5
        return r5;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final int l(int r5, int r10, int r11) {
        int r12 = r10;
    L4:
        if (r12 >= (r10 + r11)) goto L6;
        r5 = (r5 * 31) + this.f19212b[r12];
        r12 = r12 + 1;
        goto L4
    L6:
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final int m(int r10, int r11, int r12) {
        int r13 = r12 + r11;
        byte[] r14 = this.f19212b;
        if (r10 == 0) goto L58;
        if (r11 >= r13) goto L63;
        byte r5 = (byte) r10;
        if (r5 >= (-32)) goto L16;
        if (r5 < (-62)) goto L59;
        int r15 = r11 + 1;
        if (r14[r11] > (-65)) goto L59;
    L13:
        r11 = r15;
    L59:
        return -1;
    L16:
        if (r5 >= (-16)) goto L33;
        byte r16 = (byte) (~(r10 >> 8));
        if (r16 != 0) goto L23;
        int r17 = r11 + 1;
        byte r18 = r14[r11];
        if (r17 >= r13) goto L60;
        r11 = r17;
        r16 = r18;
        goto L23
    L60:
        return j0.a(r5, r18);
    L23:
        if (r16 > (-65)) goto L59;
        if (r5 != (-32)) goto L28;
        if (r16 < (-96)) goto L59;
    L28:
        if (r5 != (-19)) goto L30;
        if (r16 >= (-96)) goto L59;
    L30:
        r15 = r11 + 1;
        if (r14[r11] <= (-65)) goto L13;
    L33:
        byte r19 = (byte) (~(r10 >> 8));
        if (r19 != 0) goto L39;
        int r20 = r11 + 1;
        r19 = r14[r11];
        if (r20 >= r13) goto L61;
        byte r21 = 0;
    L40:
        if (r21 != 0) goto L50;
        int r22 = r20 + 1;
        byte r23 = r14[r20];
        if (r22 >= r13) goto L44;
        r21 = r23;
        r20 = r22;
        goto L50
    L44:
        if (r5 > (-12)) goto L59;
        if (r19 > (-65)) goto L59;
        if (r23 > (-65)) goto L59;
        return ((r19 << 8) ^ r5) ^ (r23 << 16);
    L50:
        if (r19 > (-65)) goto L59;
        int r24 = r19 + 112;
        if (((r24 + (r5 << 28)) >> 30) != 0) goto L59;
        if (r21 > (-65)) goto L59;
        r11 = r20 + 1;
        if (r14[r20] <= (-65)) goto L58;
    L61:
        return j0.a(r5, r19);
    L39:
        r21 = (byte) (r10 >> 16);
        r20 = r11;
        goto L40
    L63:
        return r10;
    L58:
        return j0.c(r14, r11, r13);
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final int n() {
        return this.f19213c;
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final String o() {
        byte[] r5 = this.f19212b;
        return new String(r5, 0, r5.length, "UTF-8");
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final void q(OutputStream r5, int r10, int r11) {
        r5.write(this.f19212b, r10, r11);
    }

    public final boolean r(x r5, int r10, int r11) {
        byte[] r12 = r5.f19212b;
        int r13 = r12.length;
        byte[] r14 = this.f19212b;
        if (r11 > r13) goto L16;
        int r15 = r10 + r11;
        int r16 = r12.length;
        byte[] r17 = r5.f19212b;
        if (r15 > r16) goto L14;
        int r18 = 0;
    L7:
        if (r18 >= r11) goto L12;
        if (r14[r18] != r17[r10]) goto L10;
        r18 = r18 + 1;
        r10 = r10 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    L14:
        int r19 = r17.length;
        StringBuilder r20 = new StringBuilder(59);
        r20.append("Ran off end of other: ");
        r20.append(r10);
        r20.append(", ");
        r20.append(r11);
        r20.append(", ");
        r20.append(r19);
        throw new IllegalArgumentException(r20.toString());
    L16:
        int r21 = r14.length;
        StringBuilder r22 = new StringBuilder(40);
        r22.append("Length too large: ");
        r22.append(r11);
        r22.append(r21);
        throw new IllegalArgumentException(r22.toString());
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public int size() {
        return this.f19212b.length;
    }
}
