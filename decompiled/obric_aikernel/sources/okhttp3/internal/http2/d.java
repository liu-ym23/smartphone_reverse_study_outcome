package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import mc.g;
import okio.e;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nHttp2Writer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Writer.kt\nokhttp3/internal/http2/Http2Writer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,317:1\n1#2:318\n*E\n"})
public final class d implements Closeable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Logger f11942l = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f11943c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f11944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final okio.d f11945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11946i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11947j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final okhttp3.internal.http2.a.b f11948k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
        f11942l = Logger.getLogger(mc.b.class.getName());
    }

    public d(e r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        this.f11943c = r10;
        this.f11944g = r11;
        okio.d r12 = new okio.d();
        this.f11945h = r12;
        this.f11946i = 16384;
        this.f11948k = new okhttp3.internal.http2.a.b(0, false, r12, 3, null);
    }

    private final void B(int r10, long r11) {
    L3:
        if (r11 <= 0) goto L9;
        long r12 = Math.min(this.f11946i, r11);
        r11 = r11 - r12;
        int r13 = (int) r12;
        if (r11 != 0) goto L7;
        int r14 = 4;
    L8:
        k(r10, r13, 9, r14);
        this.f11943c.x(this.f11945h, r12);
        goto L3
    L7:
        r14 = 0;
        goto L8
    }

    public final synchronized void A(int r10, long r11) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.f11947j == true) goto L18;
        if (r11 != 0) goto L8;
    L10:
        boolean r12 = false;
    L11:
        if (r12 == false) goto L16;
        k(r10, 4, 8, 0);     // Catch: Throwable -> L19
        this.f11943c.writeInt((int) r11);     // Catch: Throwable -> L19
        this.f11943c.flush();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L16:
        throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + r11).toString());     // Catch: Throwable -> L19
    L8:
        if (r11 > 2147483647L) goto L10;
        r12 = true;
        goto L11
    L18:
        throw new IOException("closed");     // Catch: Throwable -> L19
    }

    public final synchronized void a(g r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "peerSettings");     // Catch: Throwable -> L13
        if (this.f11947j == true) goto L12;
        this.f11946i = r10.e(this.f11946i);     // Catch: Throwable -> L13
        if (r10.b() == (-1)) goto L8;
        this.f11948k.e(r10.b());     // Catch: Throwable -> L13
    L8:
        k(0, 0, 4, 1);     // Catch: Throwable -> L13
        this.f11943c.flush();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L12:
        throw new IOException("closed");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void c() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f11947j == true) goto L16;
        if (this.f11944g == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        Logger r10 = f11942l;     // Catch: Throwable -> L17
        if (r10.isLoggable(Level.FINE) == false) goto L12;
        r10.fine(hc.e.t(">> CONNECTION " + mc.b.f11104b.hex(), new Object[0]));     // Catch: Throwable -> L17
    L12:
        this.f11943c.O(mc.b.f11104b);     // Catch: Throwable -> L17
        this.f11943c.flush();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L16:
        throw new IOException("closed");     // Catch: Throwable -> L17
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        this.f11947j = true;     // Catch: Throwable -> L7
        this.f11943c.close();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void f(boolean r10, int r11, okio.d r12, int r13) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f11947j == true) goto L9;
        i(r11, r10 ? 1 : 0, r12, r13);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IOException("closed");     // Catch: Throwable -> L10
    }

    public final synchronized void flush() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f11947j == true) goto L9;
        this.f11943c.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IOException("closed");     // Catch: Throwable -> L10
    }

    public final void i(int r10, int r11, okio.d r12, int r13) {
        k(r10, r13, 0, r11);
        if (r13 <= 0) goto L6;
        e r14 = this.f11943c;
        Intrinsics.checkNotNull(r12);
        r14.x(r12, r13);
        return;
    }

    public final void k(int r10, int r11, int r12, int r13) {
        Logger r14 = f11942l;
        if (r14.isLoggable(Level.FINE) == false) goto L5;
        r14.fine(mc.b.f11103a.c(false, r10, r11, r12, r13));
    L5:
        boolean r15 = true;
        if (r11 > this.f11946i) goto L8;
        boolean r16 = true;
    L9:
        if (r16 == false) goto L20;
        if ((Integer.MIN_VALUE & r10) == 0) goto L14;
        r15 = false;
    L14:
        if (r15 == false) goto L18;
        hc.e.a0(this.f11943c, r11);
        this.f11943c.writeByte(r12 & 255);
        this.f11943c.writeByte(r13 & 255);
        this.f11943c.writeInt(r10 & Integer.MAX_VALUE);
        return;
    L18:
        throw new IllegalArgumentException(("reserved bit set: " + r10).toString());
    L20:
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f11946i + ": " + r11).toString());
    L8:
        r16 = false;
        goto L9
    }

    public final synchronized void l(int r10, ErrorCode r11, byte[] r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, "errorCode");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r12, "debugData");     // Catch: Throwable -> L23
        if (this.f11947j == true) goto L22;
        boolean r13 = false;
        if (r11.getHttpCode() == (-1)) goto L8;
        boolean r14 = true;
    L9:
        if (r14 == false) goto L20;
        k(0, r12.length + 8, 7, 0);     // Catch: Throwable -> L23
        this.f11943c.writeInt(r10);     // Catch: Throwable -> L23
        this.f11943c.writeInt(r11.getHttpCode());     // Catch: Throwable -> L23
        if (r12.length != 0) goto L14;
        r13 = true;
    L14:
        if ((!r13) == false) goto L16;
        this.f11943c.write(r12);     // Catch: Throwable -> L23
    L16:
        this.f11943c.flush();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L20:
        throw new IllegalArgumentException("errorCode.httpCode == -1".toString());     // Catch: Throwable -> L23
    L8:
        r14 = false;
        goto L9
    L22:
        throw new IOException("closed");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized void o(boolean r10, int r11, List<mc.a> r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r12, "headerBlock");     // Catch: Throwable -> L18
        if (this.f11947j == true) goto L17;
        this.f11948k.g(r12);     // Catch: Throwable -> L18
        long r13 = this.f11945h.M();     // Catch: Throwable -> L18
        long r14 = Math.min(this.f11946i, r13);     // Catch: Throwable -> L18
        if (r13 != r14) goto L8;
        int r15 = 4;
    L9:
        if (r10 == false) goto L11;
        r15 = r15 | 1;     // Catch: Throwable -> L18
    L11:
        k(r11, (int) r14, 1, r15);     // Catch: Throwable -> L18
        this.f11943c.x(this.f11945h, r14);     // Catch: Throwable -> L18
        if (r13 <= r14) goto L14;
        B(r11, r13 - r14);     // Catch: Throwable -> L18
    L14:
        monitor-exit(this);
        return;
    L8:
        r15 = 0;
        goto L9
    L17:
        throw new IOException("closed");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public final int p() {
        return this.f11946i;
    }

    public final synchronized void r(boolean r10, int r11, int r12) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f11947j == true) goto L13;
        if (r10 == false) goto L8;
        int r13 = 1;
    L9:
        k(0, 8, 6, r13);     // Catch: Throwable -> L14
        this.f11943c.writeInt(r11);     // Catch: Throwable -> L14
        this.f11943c.writeInt(r12);     // Catch: Throwable -> L14
        this.f11943c.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L8:
        r13 = 0;
        goto L9
    L13:
        throw new IOException("closed");     // Catch: Throwable -> L14
    }

    public final synchronized void s(int r10, int r11, List<mc.a> r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r12, "requestHeaders");     // Catch: Throwable -> L16
        if (this.f11947j == true) goto L15;
        this.f11948k.g(r12);     // Catch: Throwable -> L16
        long r13 = this.f11945h.M();     // Catch: Throwable -> L16
        int r14 = (int) Math.min(((long) this.f11946i) - 4, r13);     // Catch: Throwable -> L16
        int r15 = r14 + 4;     // Catch: Throwable -> L16
        long r16 = r14;
        if (r13 != r16) goto L8;
        int r17 = 4;
    L9:
        k(r10, r15, 5, r17);     // Catch: Throwable -> L16
        this.f11943c.writeInt(r11 & Integer.MAX_VALUE);     // Catch: Throwable -> L16
        this.f11943c.x(this.f11945h, r16);     // Catch: Throwable -> L16
        if (r13 <= r16) goto L12;
        B(r10, r13 - r16);     // Catch: Throwable -> L16
    L12:
        monitor-exit(this);
        return;
    L8:
        r17 = 0;
        goto L9
    L15:
        throw new IOException("closed");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized void u(int r10, ErrorCode r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, "errorCode");     // Catch: Throwable -> L17
        if (this.f11947j == true) goto L16;
        if (r11.getHttpCode() == (-1)) goto L8;
        boolean r12 = true;
    L9:
        if (r12 == false) goto L14;
        k(r10, 4, 3, 0);     // Catch: Throwable -> L17
        this.f11943c.writeInt(r11.getHttpCode());     // Catch: Throwable -> L17
        this.f11943c.flush();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L14:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L17
    L8:
        r12 = false;
        goto L9
    L16:
        throw new IOException("closed");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized void v(g r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "settings");     // Catch: Throwable -> L23
        if (this.f11947j == true) goto L22;
        int r11 = 0;
        k(0, r10.i() * 6, 4, 0);     // Catch: Throwable -> L23
    L7:
        if (r11 >= 10) goto L18;
        if (r10.f(r11) == false) goto L17;
        if (r11 != 4) goto L12;
        int r12 = 3;
    L16:
        this.f11943c.writeShort(r12);     // Catch: Throwable -> L23
        this.f11943c.writeInt(r10.a(r11));     // Catch: Throwable -> L23
        goto L17
    L12:
        if (r11 == 7) goto L14;
        r12 = r11;
        goto L16
    L14:
        r12 = 4;
    L17:
        r11 = r11 + 1;     // Catch: Throwable -> L23
        goto L7
    L18:
        this.f11943c.flush();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L22:
        throw new IOException("closed");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }
}
