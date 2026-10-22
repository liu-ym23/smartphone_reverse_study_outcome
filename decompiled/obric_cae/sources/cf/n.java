package cf;

import com.qualcomm.qti.qesdk.QesdkUtils;
import com.sdk.bwdl.StateMachine.BWDLDataStructure;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jf.w;
import jf.x;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements Closeable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Logger f3554o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jf.f f3555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f3556b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f3557m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d.a f3558n;

    public static final class a implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jf.f f3559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3560b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public byte f3561m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f3562n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f3563o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public short f3564p;

        public a(jf.f r8) {
            this.f3559a = r8;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // jf.w
        public final x timeout() {
            return this.f3559a.timeout();
        }

        @Override // jf.w
        public final long u(jf.d r10, long r11) {
        L2:
            int r8 = this.f3563o;
            jf.f r12 = this.f3559a;
            if (r8 != 0) goto L18;
            r12.skip(this.f3564p);
            this.f3564p = 0;
            if ((this.f3561m & 4) != 0) goto L6;
            int r13 = this.f3562n;
            int r14 = n.r(r12);
            this.f3563o = r14;
            this.f3560b = r14;
            byte r15 = (byte) (r12.readByte() & 255);
            this.f3561m = (byte) (r12.readByte() & 255);
            Logger r16 = n.f3554o;
            if (r16.isLoggable(Level.FINE) == false) goto L10;
            r16.fine(e.a(true, this.f3562n, this.f3560b, r15, this.f3561m));
        L10:
            int r17 = r12.readInt() & Integer.MAX_VALUE;
            this.f3562n = r17;
            if (r15 != 9) goto L16;
            if (r17 == r13) goto L2;
            e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        L16:
            e.b("%s != TYPE_CONTINUATION", new Object[]{Byte.valueOf(r15)});
            throw null;
        L6:
            return -1;
        L18:
            long r18 = r12.u(r10, Math.min(r11, r8));
            if (r18 != (-1)) goto L21;
            return -1;
        L21:
            this.f3563o = (int) (((long) this.f3563o) - r18);
            return r18;
        }
    }

    public interface b {
    }

    static {
        f3554o = Logger.getLogger(e.class.getName());
    }

    public n(jf.f r8, boolean r10) {
        this.f3555a = r8;
        this.f3557m = r10;
        a r11 = new a(r8);
        this.f3556b = r11;
        this.f3558n = new d.a(r11);
    }

    public static int a(int r8, byte r10, short r11) {
        if ((r10 & 8) == 0) goto L5;
        r8 = r8 - 1;
    L5:
        if (r11 <= r8) goto L7;
        e.b("PROTOCOL_ERROR padding %s > remaining length %s", new Object[]{Short.valueOf(r11), Integer.valueOf(r8)});
        throw null;
    L7:
        return (short) (r8 - r11);
    }

    public static int r(jf.f r8) {
        int r10 = ((r8.readByte() & 255) << 16) | ((r8.readByte() & 255) << 8);
        return (r8.readByte() & 255) | r10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f3555a.close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean i(boolean r13, b r14) {
        short r8 = 0;
        int r10 = 0;
        boolean r11 = false;
        int r12 = 0;
        short r15 = 0;
        this.f3555a.L(9);     // Catch: IOException -> L241
        int r16 = r(this.f3555a);
        if (r16 >= 0) goto L7;
    L239:
        e.b("FRAME_SIZE_ERROR: %s", new Object[]{Integer.valueOf(r16)});
        throw null;
    L7:
        if (r16 > 16384) goto L239;
        byte r17 = (byte) (this.f3555a.readByte() & 255);
        if (r13 == false) goto L14;
        if (r17 == 4) goto L14;
        e.b("Expected a SETTINGS frame but was %s", new Object[]{Byte.valueOf(r17)});
        throw null;
    L14:
        byte r18 = (byte) (this.f3555a.readByte() & 255);
        int r19 = this.f3555a.readInt() & Integer.MAX_VALUE;
        Logger r20 = f3554o;
        if (r20.isLoggable(Level.FINE) == false) goto L18;
        r20.fine(e.a(true, r19, r16, r17, r18));
    L18:
        switch(r17) {
            case 0: goto L211;
            case 1: goto L197;
            case 2: goto L190;
            case 3: goto L160;
            case 4: goto L120;
            case 5: goto L99;
            case 6: goto L89;
            case 7: goto L46;
            case 8: goto L20;
            default: goto L19;
        };
    L19:
        this.f3555a.skip(r16);
    L238:
        return true;
    L20:
        if (r16 != 4) goto L44;
        long r110 = ((long) this.f3555a.readInt()) & 2147483647L;
        if (r110 == 0) goto L42;
        g.h r111 = (g.h) r14;
        if (r19 != 0) goto L33;
        g r21 = r111.f3535m;
        monitor-enter(r21);
        g r112 = r111.f3535m;     // Catch: Throwable -> L30
        r112.B += r110;     // Catch: Throwable -> L30
        r112.notifyAll();     // Catch: Throwable -> L30
        monitor-exit(r21);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    L33:
        o r113 = r111.f3535m.z(r19);
        if (r113 == null) goto L238;
        monitor-enter(r113);
        r113.c(r110);     // Catch: Throwable -> L39
        monitor-exit(r113);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    L42:
        e.b("windowSizeIncrement was 0", new Object[]{Long.valueOf(r110)});
        throw null;
    L44:
        e.b("TYPE_WINDOW_UPDATE length !=4: %s", new Object[]{Integer.valueOf(r16)});
        throw null;
    L46:
        if (r16 < 8) goto L87;
        if (r19 != 0) goto L85;
        int r114 = this.f3555a.readInt();
        int r22 = this.f3555a.readInt();
        int r23 = r16 - 8;
        cf.b[] r24 = cf.b.values();
        int r25 = r24.length;
        int r26 = 0;
    L49:
        if (r26 >= r25) goto L54;
        cf.b r27 = r24[r26];
        if (r27.f3457a == r22) goto L55;
        r26 = r26 + 1;
    L55:
        if (r27 == null) goto L83;
        jf.g r28 = jf.g.f8841o;
        if (r23 <= 0) goto L59;
        r28 = this.f3555a.Q(r23);
    L59:
        g.h r115 = (g.h) r14;
        r115.getClass();
        r28.l();
        g r116 = r115.f3535m;
        monitor-enter(r116);
        o[] r29 = (o[]) r115.f3535m.f3501m.values().toArray(new o[r115.f3535m.f3501m.size()]);     // Catch: Throwable -> L80
        r115.f3535m.f3505q = true;     // Catch: Throwable -> L80
        monitor-exit(r116);     // Catch: Throwable -> L80
        int r117 = r29.length;
    L64:
        if (r10 >= r117) goto L238;
        o r30 = r29[r10];
        if (r30.f3567c <= r114) goto L79;
        if (r30.i() == false) goto L79;
        cf.b r31 = cf.b.f3454p;
        monitor-enter(r30);
    L76:
        th = move-exception;
        throw th;
    L72:
        if (r30.f3575k != null) goto L74;
        r30.f3575k = r31;     // Catch: Throwable -> L76
        r30.notifyAll();     // Catch: Throwable -> L76
    L74:
        monitor-exit(r30);
        r115.f3535m.E(r30.f3567c);
    L79:
        r10 = r10 + 1;
    L80:
        th = move-exception;
        throw th;
    L83:
        e.b("TYPE_GOAWAY unexpected error code: %d", new Object[]{Integer.valueOf(r22)});
        throw null;
    L54:
        r27 = null;
        goto L55
    L85:
        e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        throw null;
    L87:
        e.b("TYPE_GOAWAY length < 8: %s", new Object[]{Integer.valueOf(r16)});
        throw null;
    L89:
        if (r16 != 8) goto L97;
        if (r19 != 0) goto L95;
        jf.f r118 = this.f3555a;
        int r32 = r118.readInt();
        int r119 = r118.readInt();
        if ((r18 & 1) == 0) goto L94;
        r11 = true;
    L94:
        ((g.h) r14).d(r32, r119, r11);
        goto L238
    L95:
        e.b("TYPE_PING streamId != 0", new Object[0]);
        throw null;
    L97:
        e.b("TYPE_PING length != 8: %s", new Object[]{Integer.valueOf(r16)});
        throw null;
    L99:
        if (r19 != 0) goto L101;
        e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        throw null;
    L101:
        if ((r18 & 8) == 0) goto L103;
        short r33 = (short) (this.f3555a.readByte() & 255);
    L104:
        int r34 = this.f3555a.readInt() & Integer.MAX_VALUE;
        ArrayList r120 = n(a(r16 - 4, r18, r33), r33, r18, r19);
        g r121 = ((g.h) r14).f3535m;
        monitor-enter(r121);
    L115:
        th = move-exception;
        throw th;
    L107:
        if (r121.H.contains(Integer.valueOf(r34)) == false) goto L111;
        r121.K(r34, cf.b.f3451m);     // Catch: Throwable -> L115
        monitor-exit(r121);     // Catch: Throwable -> L115
    L247:
        goto L238
    L111:
        r121.H.add(Integer.valueOf(r34));     // Catch: Throwable -> L115
        monitor-exit(r121);     // Catch: Throwable -> L115
        r121.B(new h(r121, new Object[]{r121.f3502n, Integer.valueOf(r34)}, r34, r120));     // Catch: RejectedExecutionException -> L242
    L103:
        r33 = 0;
        goto L104
    L120:
        if (r19 == 0) goto L122;
        e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        throw null;
    L122:
        if ((r18 & 1) == 0) goto L128;
        if (r16 != 0) goto L125;
        r14.getClass();
        goto L238
    L125:
        e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        throw null;
    L128:
        if ((r16 % 6) != 0) goto L156;
        p.f r122 = new p.f();
        int r35 = 0;
    L130:
        if (r35 >= r16) goto L155;
        jf.f r36 = this.f3555a;
        int r37 = r36.readShort() & 65535;
        int r38 = r36.readInt();
        if (r37 != 2) goto L134;
        if (r38 == 0) goto L154;
        if (r38 == 1) goto L154;
        e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
        throw null;
    L154:
        r122.e(r37, r38);
        r35 = r35 + 6;
        goto L130
    L134:
        if (r37 == 3) goto L148;
        if (r37 == 4) goto L144;
        if (r37 != 5) goto L154;
        if (r38 < 16384) goto L142;
        if (r38 <= 16777215) goto L154;
    L142:
        e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[]{Integer.valueOf(r38)});
        throw null;
    L144:
        if (r38 < 0) goto L146;
        r37 = 7;
        goto L154
    L146:
        e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
        throw null;
    L148:
        r37 = 4;
        goto L154
    L155:
        ((g.h) r14).e(r122);
        goto L238
    L156:
        e.b("TYPE_SETTINGS length %% 6 != 0: %s", new Object[]{Integer.valueOf(r16)});
        throw null;
    L160:
        if (r16 != 4) goto L188;
        if (r19 == 0) goto L186;
        int r123 = this.f3555a.readInt();
        cf.b[] r124 = cf.b.values();
        int r39 = r124.length;
    L163:
        if (r12 >= r39) goto L168;
        cf.b r40 = r124[r12];
        if (r40.f3457a == r123) goto L169;
        r12 = r12 + 1;
    L169:
        if (r40 == null) goto L184;
        g r125 = ((g.h) r14).f3535m;
        r125.getClass();
        if (g.D(r19) == false) goto L173;
        r125.B(new k(r125, new Object[]{r125.f3502n, Integer.valueOf(r19)}, r19, r40));
        goto L238
    L173:
        o r126 = r125.E(r19);
        if (r126 == null) goto L238;
        monitor-enter(r126);
    L181:
        th = move-exception;
        throw th;
    L177:
        if (r126.f3575k != null) goto L179;
        r126.f3575k = r40;     // Catch: Throwable -> L181
        r126.notifyAll();     // Catch: Throwable -> L181
    L179:
        monitor-exit(r126);
        goto L238
    L184:
        e.b("TYPE_RST_STREAM unexpected error code: %d", new Object[]{Integer.valueOf(r123)});
        throw null;
    L168:
        r40 = null;
        goto L169
    L186:
        e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        throw null;
    L188:
        e.b("TYPE_RST_STREAM length: %d != 4", new Object[]{Integer.valueOf(r16)});
        throw null;
    L190:
        if (r16 != 5) goto L195;
        if (r19 == 0) goto L193;
        jf.f r127 = this.f3555a;
        r127.readInt();
        r127.readByte();
        r14.getClass();
        goto L238
    L193:
        e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        throw null;
    L195:
        e.b("TYPE_PRIORITY length: %d != 5", new Object[]{Integer.valueOf(r16)});
        throw null;
    L197:
        if (r19 != 0) goto L199;
        e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    L199:
        if ((r18 & 1) == 0) goto L201;
        boolean r41 = true;
    L203:
        if ((r18 & 8) == 0) goto L206;
        r15 = (short) (this.f3555a.readByte() & 255);
    L206:
        if ((r18 & BWDLDataStructure.DataLinkParamStructure.BT_SPP) == 0) goto L208;
        jf.f r42 = this.f3555a;
        r42.readInt();
        r42.readByte();
        r14.getClass();
        r16 = r16 - 5;
    L208:
        ((g.h) r14).c(r41, r19, n(a(r16, r18, r15), r15, r18, r19));
        goto L238
    L201:
        r41 = false;
        goto L203
    L211:
        if (r19 != 0) goto L213;
        e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        throw null;
    L213:
        if ((r18 & 1) == 0) goto L215;
        boolean r43 = true;
    L217:
        if ((r18 & BWDLDataStructure.DataLinkParamStructure.BT_SPP) == 0) goto L219;
        Object[] r44 = true;
    L220:
        if (r44 == true) goto L234;
        boolean r45 = r18 & 8;
        jf.f r128 = this.f3555a;
        if (r45 == 0) goto L224;
        r8 = (short) (r128.readByte() & 255);
    L224:
        int r129 = a(r16, r18, r8);
        g r130 = ((g.h) r14).f3535m;
        r130.getClass();
        if (g.D(r19) == false) goto L227;
        r130.A(r19, r129, r128, r43);
    L233:
        r128.skip(r8);
        goto L238
    L227:
        o r46 = r130.z(r19);
        if (r46 != null) goto L230;
        r130.K(r19, cf.b.f3451m);
        long r47 = r129;
        r130.I(r47);
        r128.skip(r47);
        goto L233
    L230:
        r46.f3571g.a(r128, r129);
        if (r43 == false) goto L233;
        r46.k();
        goto L233
    L234:
        e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        throw null;
    L219:
        r44 = false;
        goto L220
    L215:
        r43 = false;
    L241:
        return false;
    }

    public final void k(b r8) {
        if (this.f3557m == true) goto L5;
        jf.g r10 = e.f3485a;
        jf.g r11 = this.f3555a.Q(r10.f8842a.length);
        Level r12 = Level.FINE;
        Logger r13 = f3554o;
        if (r13.isLoggable(r12) == false) goto L13;
        r13.fine(xe.c.n("<< CONNECTION %s", new Object[]{r11.f()}));
    L13:
        if (r10.equals(r11) == false) goto L15;
        return;
    L15:
        e.b("Expected a connection header but was %s", new Object[]{r11.p()});
        throw null;
    L5:
        if (i(true, r8) == true) goto L17;
        e.b("Required SETTINGS preface not received", new Object[0]);
        throw null;
    }

    public final ArrayList n(int r8, short r10, byte r11, int r12) {
        a r13 = this.f3556b;
        r13.f3563o = r8;
        r13.f3560b = r8;
        r13.f3564p = r10;
        r13.f3561m = r11;
        r13.f3562n = r12;
    L3:
        d.a r14 = this.f3558n;
        jf.r r15 = r14.f3470b;
        boolean r16 = r15.U();
        ArrayList r17 = r14.f3469a;
        if (r16 == true) goto L51;
        int r18 = r15.readByte() & 255;
        if (r18 == 128) goto L50;
        boolean r19 = false;
        if ((r18 & 128) == 128) goto L9;
        if (r18 == 64) goto L26;
        if ((r18 & 64) == 64) goto L29;
        if ((r18 & 32) == 32) goto L32;
        if (r18 == 16) goto L48;
        if (r18 == 0) goto L48;
        r17.add(new c(r14.b(r14.e(r18, 15) - 1), r14.d()));
    L48:
        jf.g r20 = r14.d();
        d.a(r20);
        r17.add(new c(r20, r14.d()));
        goto L3
    L32:
        int r21 = r14.e(r18, 31);
        r14.f3472d = r21;
        if (r21 < 0) goto L42;
        if (r21 > r14.f3471c) goto L42;
        int r22 = r14.f3476h;
        if (r21 >= r22) goto L3;
        if (r21 == 0) goto L39;
        r14.a(r22 - r21);
        goto L3
    L39:
        Arrays.fill(r14.f3473e, null);
        r14.f3474f = r14.f3473e.length - 1;
        r14.f3475g = 0;
        r14.f3476h = 0;
    L42:
        throw new IOException("Invalid dynamic table size update " + r14.f3472d);
    L29:
        r14.c(new c(r14.b(r14.e(r18, 63) - 1), r14.d()));
        goto L3
    L26:
        jf.g r23 = r14.d();
        d.a(r23);
        r14.c(new c(r23, r14.d()));
        goto L3
    L9:
        int r24 = r14.e(r18, QesdkUtils.LIMITS.INT_8_UPPER) - 1;
        if (r24 >= 0) goto L12;
    L14:
        if (r19 == false) goto L16;
        c r25 = d.f3467a[r24];
    L21:
        r17.add(r25);
        goto L3
    L16:
        int r26 = (r14.f3474f + 1) + (r24 - d.f3467a.length);
        if (r26 < 0) goto L23;
        c[] r27 = r14.f3473e;
        if (r26 >= r27.length) goto L23;
        r25 = r27[r26];
    L23:
        throw new IOException("Header index too large " + (r24 + 1));
    L12:
        if (r24 > (d.f3467a.length - 1)) goto L14;
        r19 = true;
        goto L14
    L50:
        throw new IOException("index == 0");
    L51:
        ArrayList r28 = new ArrayList(r17);
        r17.clear();
        return r28;
    }
}
