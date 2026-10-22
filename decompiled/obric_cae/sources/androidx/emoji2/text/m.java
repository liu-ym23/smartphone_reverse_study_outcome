package androidx.emoji2.text;

import com.qualcomm.qti.qesdk.QesdkUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f1795a;

        public a(ByteBuffer r8) {
            this.f1795a = r8;
            r8.order(ByteOrder.BIG_ENDIAN);
        }

        public final long a() {
            return ((long) this.f1795a.getInt()) & QesdkUtils.LIMITS.UINT_32_UPPER;
        }

        public final void b(int r8) {
            ByteBuffer r10 = this.f1795a;
            r10.position(r10.position() + r8);
        }
    }

    public static p0.b a(MappedByteBuffer r13) {
        ByteBuffer r14 = r13.duplicate();
        a r8 = new a(r14);
        r8.b(4);
        int r10 = r14.getShort() & 65535;
        if (r10 > 100) goto L28;
        r8.b(6);
        int r11 = 0;
        int r12 = 0;
    L5:
        ByteBuffer r15 = r8.f1795a;
        if (r12 >= r10) goto L11;
        int r16 = r15.getInt();
        r8.b(4);
        long r17 = r8.a();
        r8.b(4);
        if (1835365473 == r16) goto L13;
        r12 = r12 + 1;
    L13:
        if (r17 == (-1)) goto L26;
        r8.b((int) (r17 - ((long) r14.position())));
        r8.b(12);
        long r18 = r8.a();
    L16:
        if (r11 >= r18) goto L26;
        int r19 = r15.getInt();
        long r20 = r8.a();
        r8.a();
        if (1164798569 == r19) goto L23;
        if (1701669481 == r19) goto L23;
        r11 = r11 + 1;
    L23:
        r14.position((int) (r20 + r17));
        p0.b r21 = new p0.b();
        r14.order(ByteOrder.LITTLE_ENDIAN);
        int r22 = r14.position() + r14.getInt(r14.position());
        r21.f9913b = r14;
        r21.f9912a = r22;
        int r23 = r22 - r14.getInt(r22);
        r21.f9914c = r23;
        r21.f9915d = r21.f9913b.getShort(r23);
        return r21;
    L26:
        throw new IOException("Cannot read metadata.");
    L11:
        r17 = -1;
        goto L13
    L28:
        throw new IOException("Cannot read metadata.");
    }
}
