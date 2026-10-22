package b6;

import com.qualcomm.qti.qesdk.QesdkUtils;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jf.f f3105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f3106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f3109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3111i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final jf.d f3112j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final jf.d f3113k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final byte[] f3114l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final jf.d.c f3115m;

    public interface a {
    }

    public f(boolean r8, jf.f r10, c r11, long r12) {
        this.f3112j = new jf.d();
        this.f3113k = new jf.d();
        if (r10 == null) goto L18;
        if (r11 == null) goto L16;
        this.f3104b = r8;
        this.f3105c = r10;
        this.f3106d = r11;
        this.f3103a = r12;
        jf.d.c r13 = null;
        if (r8 == false) goto L8;
        byte[] r14 = null;
    L9:
        this.f3114l = r14;
        if (r8 == true) goto L13;
        r13 = new jf.d.c();
    L13:
        this.f3115m = r13;
        return;
    L8:
        r14 = new byte[4];
        goto L9
    L16:
        throw new NullPointerException("frameCallback == null");
    L18:
        throw new NullPointerException("source == null");
    }

    public final void a() {
        long r8 = this.f3109g;
        if (r8 <= 0) goto L7;
        this.f3105c.d(this.f3112j, r8);
        if (this.f3104b == true) goto L7;
        this.f3112j.v(this.f3115m);
        this.f3115m.a(0);
        e.b(this.f3115m, this.f3114l);
        this.f3115m.close();
    L7:
        int r10 = this.f3108f;
        if (r10 != 9) goto L25;
        a r11 = this.f3106d;
        jf.g r12 = this.f3112j.x();
        c r13 = (c) r11;
        monitor-enter(r13);
    L21:
        th = move-exception;
        throw th;
    L12:
        if (r13.f3094s == false) goto L14;
    L19:
        monitor-exit(r13);
        return;
    L14:
        if (r13.f3090o == true) goto L16;
    L18:
        r13.f3081f.add(r12);     // Catch: Throwable -> L21
        r13.h();     // Catch: Throwable -> L21
        goto L19
    L16:
        if (r13.f3082g.isEmpty() == false) goto L18;
    L25:
        if (r10 != 10) goto L38;
        a r14 = this.f3106d;
        this.f3112j.x();
        c r15 = (c) r14;
        monitor-enter(r15);
        r15.f3096u = false;     // Catch: Throwable -> L34
        android.support.v4.media.a r16 = r15.f3076a;     // Catch: Throwable -> L34
        if (r16 == null) goto L32;
        r16.v(r15);     // Catch: Throwable -> L34
    L32:
        monitor-exit(r15);
        return;
    L34:
        th = move-exception;
        throw th;
    L38:
        if (r10 != 8) goto L54;
        jf.d r17 = this.f3112j;
        long r18 = r17.f8830b;
        if (r18 == 1) goto L52;
        if (r18 == 0) goto L48;
        short r19 = r17.readShort();
        String r20 = this.f3112j.A();
        String r21 = e.a(r19);
        if (r21 != null) goto L47;
    L49:
        ((c) this.f3106d).g(r19, r20);
        this.f3107e = true;
        return;
    L47:
        throw new ProtocolException(r21);
    L48:
        r20 = "";
        r19 = 1005;
        goto L49
    L52:
        throw new ProtocolException("Malformed close payload length of 1.");
    L54:
        throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f3108f));
    }

    public final void b() {
        if (this.f3107e == true) goto L73;
        jf.f r8 = this.f3105c;
        long r10 = r8.timeout().h();
        r8.timeout().b();
        int r11 = r8.readByte() & 255;
        r8.timeout().g(r10, TimeUnit.NANOSECONDS);
        this.f3108f = r11 & 15;
        boolean r12 = true;
        if ((r11 & 128) == 0) goto L9;
        boolean r13 = true;
    L10:
        this.f3110h = r13;
        if ((r11 & 8) == 0) goto L13;
        boolean r14 = true;
    L14:
        this.f3111i = r14;
        if (r14 == false) goto L21;
        if (r13 == true) goto L21;
        throw new ProtocolException("Control frames must be final.");
    L21:
        if ((r11 & 64) == 0) goto L23;
        boolean r15 = true;
    L25:
        if ((r11 & 32) == 0) goto L27;
        boolean r16 = true;
    L29:
        if ((r11 & 16) == 0) goto L31;
        boolean r17 = true;
    L32:
        if (r15 == true) goto L68;
        if (r16 == true) goto L68;
        if (r17 == true) goto L68;
        int r18 = r8.readByte() & 255;
        if ((r18 & 128) != 0) goto L39;
        r12 = false;
    L39:
        boolean r19 = this.f3104b;
        if (r12 == r19) goto L42;
        long r20 = r18 & QesdkUtils.LIMITS.INT_8_UPPER;
        this.f3109g = r20;
        if (r20 != 126) goto L51;
        this.f3109g = ((long) r8.readShort()) & 65535;
    L58:
        if (this.f3111i == true) goto L60;
    L64:
        if (r12 == false) goto L76;
        r8.readFully(this.f3114l);
        return;
    L76:
        return;
    L60:
        if (this.f3109g <= 125) goto L64;
        throw new ProtocolException("Control frame must be less than 125B.");
    L51:
        if (r20 != 127) goto L58;
        long r21 = r8.readLong();
        this.f3109g = r21;
        if (r21 >= 0) goto L58;
        throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f3109g) + " > 0x7FFFFFFFFFFFFFFF");
    L42:
        if (r19 == false) goto L44;
        String r22 = "Server-sent frames must not be masked.";
    L46:
        throw new ProtocolException(r22);
    L44:
        r22 = "Client-sent frames must be masked.";
    L68:
        throw new ProtocolException("Reserved flags are unsupported.");
    L31:
        r17 = false;
        goto L32
    L27:
        r16 = false;
        goto L29
    L23:
        r15 = false;
        goto L25
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
    L69:
        th = move-exception;
        r8.timeout().g(r10, TimeUnit.NANOSECONDS);
        throw th;
    L73:
        throw new IOException("closed");
    }
}
