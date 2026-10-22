package okhttp3.internal.publicsuffix;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import cvc.c;
import hvc.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.BufferedSource;
import okio.Okio;
import okio.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class PublicSuffixDatabase {
    public static final byte[] e = null;
    public static final String[] f = null;
    public static final String[] g = null;
    public static final PublicSuffixDatabase h = null;
    public final AtomicBoolean a;
    public final CountDownLatch b;
    public byte[] c;
    public byte[] d;

    static {
        e = new byte[]{42};
        f = new String[0];
        g = new String[]{"*"};
        h = new PublicSuffixDatabase();
    }

    public final void c() throws IOException {
        InputStream r0 = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (r0 != null) goto L5;
        return;
    L5:
        BufferedSource r1 = Okio.buffer(new q(Okio.source(r0)));
        byte[] r2 = new byte[r1.readInt()];     // Catch: Throwable -> L16
        r1.readFully(r2);     // Catch: Throwable -> L16
        byte[] r3 = new byte[r1.readInt()];     // Catch: Throwable -> L16
        r1.readFully(r3);     // Catch: Throwable -> L16
        c.e(r1);
        monitor-enter(this);
        this.c = r2;     // Catch: Throwable -> L13
        this.d = r3;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        this.b.countDown();
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        c.e(r1);
        throw th;
    }

    public PublicSuffixDatabase() {
        this.a = new AtomicBoolean(false);
        this.b = new CountDownLatch(1);
    }

    public final String b(String r11) {
        if (r11 == null) goto L95;
        String[] r0 = IDN.toUnicode(r11).split("\\.");
        if (this.a.get() == false) goto L6;
    L99:
        this.b.await();     // Catch: InterruptedException -> L24
    L25:
        monitor-enter(this);
    L91:
        th = move-exception;
        throw th;
    L27:
        if (this.c == null) goto L90;
        monitor-exit(this);     // Catch: Throwable -> L91
        int r1 = r0.length;
        byte[][] r4 = new byte[r1][];
        int r5 = 0;
    L31:
        if (r5 >= r0.length) goto L33;
        r4[r5] = r0[r5].getBytes(c.j);
        r5 = r5 + 1;
        goto L31
    L33:
        int r6 = 0;
    L35:
        if (r6 >= r1) goto L40;
        String r7 = a(this.c, r4, r6);
        if (r7 != null) goto L41;
        r6 = r6 + 1;
    L41:
        if (r1 <= 1) goto L49;
        byte[][] r8 = (byte[][]) r4.clone();
        int r9 = 0;
    L44:
        if (r9 >= (r8.length - 1)) goto L49;
        r8[r9] = e;
        String r10 = a(this.c, r8, r9);
        if (r10 != null) goto L50;
        r9 = r9 + 1;
    L50:
        if (r10 == null) goto L58;
        int r12 = 0;
    L53:
        if (r12 >= (r1 - 1)) goto L58;
        String r13 = a(this.d, r4, r12);
        if (r13 != null) goto L59;
        r12 = r12 + 1;
    L59:
        if (r13 == null) goto L61;
        String[] r2 = "!".concat(r13).split("\\.");
    L75:
        if (r0.length != r2.length) goto L80;
        if (r2[0].charAt(0) == '!') goto L80;
        return null;
    L80:
        if (r2[0].charAt(0) != '!') goto L82;
        int r3 = r0.length;
        int r14 = r2.length;
    L83:
        int r15 = r3 - r14;
        StringBuilder r16 = new StringBuilder();
        String[] r17 = r11.split("\\.");
    L85:
        if (r15 >= r17.length) goto L87;
        r16.append(r17[r15]);
        r16.append('.');
        r15 = r15 + 1;
        goto L85
    L87:
        r16.deleteCharAt(r16.length() - 1);
        return r16.toString();
    L82:
        r3 = r0.length;
        r14 = r2.length + 1;
        goto L83
    L61:
        if (r7 != null) goto L64;
        if (r10 != null) goto L64;
        r2 = g;
    L64:
        if (r7 == null) goto L66;
        r2 = r7.split("\\.");
    L67:
        if (r10 == null) goto L69;
        String[] r18 = r10.split("\\.");
    L71:
        if (r2.length > r18.length) goto L75;
        r2 = r18;
        goto L75
    L69:
        r18 = f;
        goto L71
    L66:
        r2 = f;
    L58:
        r13 = null;
    L49:
        r10 = null;
        goto L50
    L40:
        r7 = null;
        goto L41
    L90:
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");     // Catch: Throwable -> L91
    L24:
        ThreadMethodProxy.currentThread().interrupt();
        goto L25
    L6:
        if (this.a.compareAndSet(false, true) == false) goto L99;
        boolean r19 = false;
    L97:
        c();     // Catch: Throwable -> L11 IOException -> L13 InterruptedIOException -> L17
    L9:
        if (r19 == false) goto L25;
    L16:
        ThreadMethodProxy.currentThread().interrupt();
    L11:
        th = move-exception;
        if (r19 == false) goto L21;
        ThreadMethodProxy.currentThread().interrupt();
    L21:
        throw th;
    L17:
        Thread.interrupted();     // Catch: Throwable -> L11
        r19 = true;
    L13:
        e = move-exception;
        g.a.m(5, "Failed to read public suffix list", e);     // Catch: Throwable -> L11
        if (r19 == false) goto L25;
    L95:
        throw new NullPointerException("domain == null");
    }

    public static String a(byte[] r17, byte[][] r18, int r19) {
        int r2 = r17.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L43;
        int r5 = (r4 + r2) / 2;
    L6:
        if (r5 <= (-1)) goto L10;
        if (r17[r5] == 10) goto L10;
        r5 = r5 - 1;
    L10:
        int r6 = r5 + 1;
        int r9 = 1;
    L11:
        int r10 = r6 + r9;
        if (r17[r10] == 10) goto L14;
        r9 = r9 + 1;
        goto L11
    L14:
        int r7 = r10 - r6;
        int r11 = r19;
        boolean r12 = false;
        int r13 = 0;
        int r14 = 0;
    L15:
        if (r12 == false) goto L17;
        int r15 = 46;
        boolean r16 = false;
    L18:
        int r20 = r15 - (r17[r6 + r14] & 255);
        if (r20 != 0) goto L28;
        r14 = r14 + 1;
        r13 = r13 + 1;
        if (r14 == r7) goto L28;
        if (r18[r11].length == r13) goto L27;
        r12 = r16;
        goto L15
    L27:
        if (r11 == (r18.length - 1)) goto L28;
        r11 = r11 + 1;
        r12 = true;
        r13 = -1;
    L28:
        if (r20 < 0) goto L37;
        if (r20 > 0) goto L39;
        int r8 = r7 - r14;
        int r21 = r18[r11].length - r13;
    L33:
        r11 = r11 + 1;
        if (r11 >= r18.length) goto L36;
        r21 = r21 + r18[r11].length;
        goto L33
    L36:
        if (r21 < r8) goto L37;
        if (r21 > r8) goto L39;
        return new String(r17, r6, r7, c.j);
    L39:
        r4 = r10 + 1;
    L37:
        r2 = r6 - 1;
        goto L3
    L17:
        r16 = r12;
        r15 = r18[r11][r13] & 255;
        goto L18
    L43:
        return null;
    }
}
