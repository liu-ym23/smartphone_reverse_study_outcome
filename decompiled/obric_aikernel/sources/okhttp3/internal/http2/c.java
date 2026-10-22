package okhttp3.internal.http2;

import androidx.core.internal.view.SupportMenu;
import hc.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import mc.g;
import okio.ByteString;
import okio.f;
import okio.f0;
import okio.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Closeable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f11930j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Logger f11931k = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f11932c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f11933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final b f11934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final okhttp3.internal.http2.a.C0261a f11935i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Logger a() {
            return c.a();
        }

        public final int b(int r10, int r11, int r12) {
            if ((r11 & 8) == 0) goto L5;
            r10 = r10 - 1;
        L5:
            if (r12 > r10) goto L9;
            return r10 - r12;
        L9:
            throw new IOException("PROTOCOL_ERROR padding " + r12 + " > remaining length " + r10);
        }
    }

    public static final class b implements f0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final f f11936c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f11937g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f11938h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f11939i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f11940j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f11941k;

        public b(f r10) {
            Intrinsics.checkNotNullParameter(r10, "source");
            this.f11936c = r10;
        }

        private final void c() {
            int r10 = this.f11939i;
            int r11 = e.K(this.f11936c);
            this.f11940j = r11;
            this.f11937g = r11;
            int r12 = e.d(this.f11936c.readByte(), 255);
            this.f11938h = e.d(this.f11936c.readByte(), 255);
            a r13 = c.f11930j;
            if (r13.a().isLoggable(Level.FINE) == false) goto L5;
            r13.a().fine(mc.b.f11103a.c(true, this.f11939i, this.f11937g, r12, this.f11938h));
        L5:
            int r14 = this.f11936c.readInt() & Integer.MAX_VALUE;
            this.f11939i = r14;
            if (r12 != 9) goto L12;
            if (r14 != r10) goto L10;
            return;
        L10:
            throw new IOException("TYPE_CONTINUATION streamId changed");
        L12:
            throw new IOException(r12 + " != TYPE_CONTINUATION");
        }

        @Override // okio.f0
        public long S(okio.d r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "sink");
        L3:
            int r12 = this.f11940j;
            if (r12 != 0) goto L9;
            this.f11936c.skip(this.f11941k);
            this.f11941k = 0;
            if ((this.f11938h & 4) != 0) goto L7;
            c();
            goto L3
        L7:
            return -1;
        L9:
            long r13 = this.f11936c.S(r10, Math.min(r11, r12));
            if (r13 != (-1)) goto L12;
            return -1;
        L12:
            this.f11940j -= (int) r13;
            return r13;
        }

        public final int a() {
            return this.f11940j;
        }

        @Override // okio.f0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public final void f(int r10) {
            this.f11938h = r10;
        }

        public final void i(int r10) {
            this.f11940j = r10;
        }

        public final void k(int r10) {
            this.f11937g = r10;
        }

        public final void l(int r10) {
            this.f11941k = r10;
        }

        public final void o(int r10) {
            this.f11939i = r10;
        }

        @Override // okio.f0
        public g0 timeout() {
            return this.f11936c.timeout();
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.http2.c$c, reason: collision with other inner class name */
    public interface InterfaceC0266c {
        void a();

        void b(boolean r10, g r11);

        void c(boolean r10, int r11, int r12, List<mc.a> r13);

        void d(int r10, long r11);

        void e(boolean r10, int r11, f r12, int r13);

        void f(boolean r10, int r11, int r12);

        void g(int r10, int r11, int r12, boolean r13);

        void h(int r10, ErrorCode r11);

        void i(int r10, int r11, List<mc.a> r12);

        void j(int r10, ErrorCode r11, ByteString r12);
    }

    static {
        f11930j = new a(null);
        Logger r10 = Logger.getLogger(mc.b.class.getName());
        Intrinsics.checkNotNullExpressionValue(r10, "getLogger(Http2::class.java.name)");
        f11931k = r10;
    }

    public c(f r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        this.f11932c = r10;
        this.f11933g = r11;
        b r12 = new b(r10);
        this.f11934h = r12;
        this.f11935i = new okhttp3.internal.http2.a.C0261a(r12, 4096, 0, 4, null);
    }

    private final void A(InterfaceC0266c r10, int r11, int r12, int r13) {
        if (r13 != 0) goto L51;
        if ((r12 & 1) == 0) goto L11;
        if (r11 != 0) goto L9;
        r10.a();
        return;
    L9:
        throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
    L11:
        if ((r11 % 6) != 0) goto L49;
        g r14 = new g();
        IntProgression r15 = RangesKt.step(RangesKt.until(0, r11), 6);
        int r16 = r15.getFirst();
        int r17 = r15.getLast();
        int r18 = r15.getStep();
        if (r18 <= 0) goto L15;
        if (r16 > r17) goto L15;
    L17:
        int r19 = e.e(this.f11932c.readShort(), SupportMenu.USER_MASK);
        int r20 = this.f11932c.readInt();
        if (r19 != 2) goto L20;
        if (r20 == 0) goto L43;
        if (r20 == 1) goto L43;
        throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
    L43:
        r14.h(r19, r20);
        if (r16 == r17) goto L46;
        r16 = r16 + r18;
    L46:
        r10.b(false, r14);
        return;
    L20:
        if (r19 == 3) goto L37;
        if (r19 != 4) goto L23;
        r19 = 7;
        if (r20 >= 0) goto L43;
        throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
    L23:
        if (r19 != 5) goto L43;
        if (r20 < 16384) goto L31;
        if (r20 <= 16777215) goto L43;
    L31:
        throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + r20);
    L37:
        r19 = 4;
    L15:
        if (r18 >= 0) goto L46;
        if (r17 > r16) goto L46;
    L49:
        throw new IOException("TYPE_SETTINGS length % 6 != 0: " + r11);
    L51:
        throw new IOException("TYPE_SETTINGS streamId != 0");
    }

    private final void B(InterfaceC0266c r10, int r11, int r12, int r13) {
        if (r11 != 4) goto L11;
        long r14 = e.f(this.f11932c.readInt(), 2147483647L);
        if (r14 == 0) goto L9;
        r10.d(r13, r14);
        return;
    L9:
        throw new IOException("windowSizeIncrement was 0");
    L11:
        throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + r11);
    }

    public static final /* synthetic */ Logger a() {
        return f11931k;
    }

    private final void i(InterfaceC0266c r10, int r11, int r12, int r13) {
        if (r13 == 0) goto L20;
        int r14 = 0;
        boolean r15 = true;
        if ((r12 & 1) == 0) goto L6;
        boolean r16 = true;
    L8:
        if ((r12 & 32) != 0) goto L11;
        r15 = false;
    L11:
        if (r15 == true) goto L18;
        if ((r12 & 8) == 0) goto L15;
        r14 = e.d(this.f11932c.readByte(), 255);
    L15:
        r10.e(r16, r13, this.f11932c, f11930j.b(r11, r12, r14));
        this.f11932c.skip(r14);
        return;
    L18:
        throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
    L6:
        r16 = false;
        goto L8
    L20:
        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
    }

    private final void k(InterfaceC0266c r10, int r11, int r12, int r13) {
        if (r11 < 8) goto L17;
        if (r13 != 0) goto L15;
        int r14 = this.f11932c.readInt();
        int r15 = this.f11932c.readInt();
        int r16 = r11 - 8;
        ErrorCode r17 = ErrorCode.Companion.a(r15);
        if (r17 == null) goto L13;
        ByteString r18 = ByteString.EMPTY;
        if (r16 <= 0) goto L10;
        r18 = this.f11932c.g(r16);
    L10:
        r10.j(r14, r17, r18);
        return;
    L13:
        throw new IOException("TYPE_GOAWAY unexpected error code: " + r15);
    L15:
        throw new IOException("TYPE_GOAWAY streamId != 0");
    L17:
        throw new IOException("TYPE_GOAWAY length < 8: " + r11);
    }

    private final List<mc.a> l(int r10, int r11, int r12, int r13) {
        this.f11934h.i(r10);
        b r14 = this.f11934h;
        r14.k(r14.a());
        this.f11934h.l(r11);
        this.f11934h.f(r12);
        this.f11934h.o(r13);
        this.f11935i.k();
        return this.f11935i.e();
    }

    private final void o(InterfaceC0266c r10, int r11, int r12, int r13) {
        if (r13 == 0) goto L16;
        int r14 = 0;
        if ((r12 & 1) == 0) goto L6;
        boolean r15 = true;
    L8:
        if ((r12 & 8) == 0) goto L11;
        r14 = e.d(this.f11932c.readByte(), 255);
    L11:
        if ((r12 & 32) == 0) goto L13;
        r(r10, r13);
        r11 = r11 - 5;
    L13:
        r10.c(r15, r13, -1, l(f11930j.b(r11, r12, r14), r14, r12, r13));
        return;
    L6:
        r15 = false;
        goto L8
    L16:
        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
    }

    private final void p(InterfaceC0266c r10, int r11, int r12, int r13) {
        if (r11 != 8) goto L14;
        if (r13 != 0) goto L12;
        int r14 = this.f11932c.readInt();
        int r15 = this.f11932c.readInt();
        boolean r16 = true;
        if ((r12 & 1) != 0) goto L9;
        r16 = false;
    L9:
        r10.f(r16, r14, r15);
        return;
    L12:
        throw new IOException("TYPE_PING streamId != 0");
    L14:
        throw new IOException("TYPE_PING length != 8: " + r11);
    }

    private final void r(InterfaceC0266c r10, int r11) {
        int r12 = this.f11932c.readInt();
        if ((Integer.MIN_VALUE & r12) == 0) goto L5;
        boolean r13 = true;
    L6:
        r10.g(r11, r12 & Integer.MAX_VALUE, e.d(this.f11932c.readByte(), 255) + 1, r13);
        return;
    L5:
        r13 = false;
        goto L6
    }

    private final void s(InterfaceC0266c r10, int r11, int r12, int r13) {
        if (r11 != 5) goto L10;
        if (r13 == 0) goto L8;
        r(r10, r13);
        return;
    L8:
        throw new IOException("TYPE_PRIORITY streamId == 0");
    L10:
        throw new IOException("TYPE_PRIORITY length: " + r11 + " != 5");
    }

    private final void u(InterfaceC0266c r10, int r11, int r12, int r13) {
        if (r13 == 0) goto L10;
        if ((r12 & 8) == 0) goto L6;
        int r14 = e.d(this.f11932c.readByte(), 255);
    L7:
        r10.i(r13, this.f11932c.readInt() & Integer.MAX_VALUE, l(f11930j.b(r11 - 4, r12, r14), r14, r12, r13));
        return;
    L6:
        r14 = 0;
        goto L7
    L10:
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    private final void v(InterfaceC0266c r10, int r11, int r12, int r13) {
        if (r11 != 4) goto L14;
        if (r13 == 0) goto L12;
        int r14 = this.f11932c.readInt();
        ErrorCode r15 = ErrorCode.Companion.a(r14);
        if (r15 == null) goto L10;
        r10.h(r13, r15);
        return;
    L10:
        throw new IOException("TYPE_RST_STREAM unexpected error code: " + r14);
    L12:
        throw new IOException("TYPE_RST_STREAM streamId == 0");
    L14:
        throw new IOException("TYPE_RST_STREAM length: " + r11 + " != 4");
    }

    public final boolean c(boolean r12, InterfaceC0266c r13) {
        Intrinsics.checkNotNullParameter(r13, "handler");
        this.f11932c.U(9);     // Catch: EOFException -> L30
        int r10 = e.K(this.f11932c);
        if (r10 > 16384) goto L29;
        int r11 = e.d(this.f11932c.readByte(), 255);
        int r14 = e.d(this.f11932c.readByte(), 255);
        int r15 = this.f11932c.readInt() & Integer.MAX_VALUE;
        Logger r16 = f11931k;
        if (r16.isLoggable(Level.FINE) == false) goto L9;
        r16.fine(mc.b.f11103a.c(true, r15, r10, r11, r14));
    L9:
        if (r12 == true) goto L11;
    L15:
        switch(r11) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            default: goto L16;
        };
    L16:
        this.f11932c.skip(r10);
        return true;
    L17:
        B(r13, r10, r14, r15);
        return true;
    L18:
        k(r13, r10, r14, r15);
        return true;
    L19:
        p(r13, r10, r14, r15);
        return true;
    L20:
        u(r13, r10, r14, r15);
        return true;
    L21:
        A(r13, r10, r14, r15);
        return true;
    L22:
        v(r13, r10, r14, r15);
        return true;
    L23:
        s(r13, r10, r14, r15);
        return true;
    L24:
        o(r13, r10, r14, r15);
        return true;
    L25:
        i(r13, r10, r14, r15);
        return true;
    L11:
        if (r11 == 4) goto L15;
        throw new IOException("Expected a SETTINGS frame but was " + mc.b.f11103a.b(r11));
    L29:
        throw new IOException("FRAME_SIZE_ERROR: " + r10);
    L30:
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f11932c.close();
    }

    public final void f(InterfaceC0266c r10) {
        Intrinsics.checkNotNullParameter(r10, "handler");
        if (this.f11933g == true) goto L5;
        f r11 = this.f11932c;
        ByteString r12 = mc.b.f11104b;
        ByteString r13 = r11.g(r12.size());
        Logger r14 = f11931k;
        if (r14.isLoggable(Level.FINE) == false) goto L13;
        r14.fine(e.t("<< CONNECTION " + r13.hex(), new Object[0]));
    L13:
        if (Intrinsics.areEqual(r12, r13) == false) goto L16;
        return;
    L16:
        throw new IOException("Expected a connection header but was " + r13.utf8());
    L5:
        if (c(true, r10) == false) goto L8;
        return;
    L8:
        throw new IOException("Required SETTINGS preface not received");
    }
}
