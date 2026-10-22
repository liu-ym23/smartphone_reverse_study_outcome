package qm;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f21527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21529c;
    public final int d;

    public d(ByteBuffer r5, int r10, int r11) {
        this.f21527a = r5;
        this.f21528b = r10;
        this.f21529c = r11;
        if (r5 == null) goto L9;
        r5.order(ByteOrder.nativeOrder());
        if (r10 != (-1)) goto L7;
        r5.position(2);
        this.f21528b = r5.getShort(r5.position());
    L7:
        this.d = b(this.f21528b);
        return;
    }

    public abstract int b(int r5);

    public final String c(int r5) {
        ByteBuffer r10 = this.f21527a;
        int r11 = r10.getInt(r5) + this.d;
        int r12 = r10.getInt(r11);
        byte[] r13 = new byte[r12];
        r10.position(r11 + 4);
        r10.get(r13, 0, r12);
        return new String(r13, Charset.defaultCharset());
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L15:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L15;
        d r10 = (d) r5;
        if (this.f21528b != r10.f21528b) goto L15;
        if (Objects.equals(this.f21527a, r10.f21527a) == false) goto L15;
        return true;
    }

    public final int hashCode() {
        ByteBuffer r5 = this.f21527a;
        r5.rewind();
        return r5.hashCode();
    }
}
