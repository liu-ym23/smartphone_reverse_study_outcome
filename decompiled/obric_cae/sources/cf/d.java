package cf;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.qualcomm.qti.qesdk.QesdkUtils;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c[] f3467a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<jf.g, Integer> f3468b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f3469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jf.r f3470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3472d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c[] f3473e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3474f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3475g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3476h;

        public a(n.a r8) {
            this.f3469a = new ArrayList();
            this.f3473e = new c[8];
            this.f3474f = 7;
            this.f3475g = 0;
            this.f3476h = 0;
            this.f3471c = 4096;
            this.f3472d = 4096;
            Logger r10 = jf.p.f8861a;
            this.f3470b = new jf.r(r8);
        }

        public final int a(int r8) {
            int r10 = 0;
            if (r8 <= 0) goto L10;
            int r11 = this.f3473e.length;
        L5:
            r11 = r11 - 1;
            int r12 = this.f3474f;
            if (r11 < r12) goto L9;
            if (r8 <= 0) goto L9;
            int r13 = this.f3473e[r11].f3466c;
            r8 = r8 - r13;
            this.f3476h -= r13;
            this.f3475g--;
            r10 = r10 + 1;
        L9:
            c[] r14 = this.f3473e;
            System.arraycopy(r14, r12 + 1, r14, (r12 + 1) + r10, this.f3475g);
            this.f3474f += r10;
        L10:
            return r10;
        }

        public final jf.g b(int r8) {
            if (r8 >= 0) goto L5;
        L7:
            boolean r10 = false;
        L8:
            if (r10 == false) goto L10;
            c r11 = d.f3467a[r8];
        L16:
            return r11.f3464a;
        L10:
            int r12 = (this.f3474f + 1) + (r8 - d.f3467a.length);
            if (r12 < 0) goto L18;
            c[] r13 = this.f3473e;
            if (r12 >= r13.length) goto L18;
            r11 = r13[r12];
        L18:
            throw new IOException("Header index too large " + (r8 + 1));
        L5:
            if (r8 > (d.f3467a.length - 1)) goto L7;
            r10 = true;
            goto L8
        }

        public final void c(c r8) {
            this.f3469a.add(r8);
            int r10 = this.f3472d;
            int r11 = r8.f3466c;
            if (r11 <= r10) goto L6;
            Arrays.fill(this.f3473e, null);
            this.f3474f = this.f3473e.length - 1;
            this.f3475g = 0;
            this.f3476h = 0;
            return;
        L6:
            a((this.f3476h + r11) - r10);
            int r12 = this.f3475g + 1;
            c[] r13 = this.f3473e;
            if (r12 <= r13.length) goto L9;
            c[] r14 = new c[r13.length * 2];
            System.arraycopy(r13, 0, r14, r13.length, r13.length);
            this.f3474f = this.f3473e.length - 1;
            this.f3473e = r14;
        L9:
            int r15 = this.f3474f;
            this.f3474f = r15 - 1;
            this.f3473e[r15] = r8;
            this.f3475g++;
            this.f3476h += r11;
        }

        public final jf.g d() {
            jf.r r8 = this.f3470b;
            int r10 = r8.readByte() & 255;
            int r11 = 0;
            if ((r10 & 128) != 128) goto L5;
            boolean r12 = true;
        L6:
            int r13 = e(r10, QesdkUtils.LIMITS.INT_8_UPPER);
            if (r12 == false) goto L29;
            q r14 = q.f3596d;
            long r15 = r13;
            r8.L(r15);
            byte[] r16 = r8.f8866a.w(r15);
            r14.getClass();
            ByteArrayOutputStream r17 = new ByteArrayOutputStream();
            q.a r18 = r14.f3597a;
            q.a r19 = r18;
            int r20 = 0;
            int r21 = 0;
        L10:
            if (r11 >= r16.length) goto L19;
            r20 = (r20 << 8) | (r16[r11] & 255);
            r21 = r21 + 8;
        L13:
            if (r21 < 8) goto L18;
            int r22 = r21 - 8;
            r19 = r19.f3598a[(r20 >>> r22) & 255];
            if (r19.f3598a == null) goto L16;
            r21 = r22;
            goto L13
        L16:
            r17.write(r19.f3599b);
            r21 = r21 - r19.f3600c;
            r19 = r18;
            goto L13
        L18:
            r11 = r11 + 1;
        L19:
            if (r21 <= 0) goto L27;
            q.a r23 = r19.f3598a[(r20 << (8 - r21)) & 255];
            if (r23.f3598a != null) goto L27;
            int r24 = r23.f3600c;
            if (r24 > r21) goto L27;
            r17.write(r23.f3599b);
            r21 = r21 - r24;
            r19 = r18;
        L27:
            return jf.g.g(r17.toByteArray());
        L29:
            return r8.Q(r13);
        L5:
            r12 = false;
            goto L6
        }

        public final int e(int r8, int r10) {
            int r11 = r8 & r10;
            if (r11 >= r10) goto L5;
            return r11;
        L5:
            int r12 = 0;
        L6:
            int r13 = this.f3470b.readByte() & 255;
            if ((r13 & 128) == 0) goto L10;
            r10 = r10 + ((r13 & QesdkUtils.LIMITS.INT_8_UPPER) << r12);
            r12 = r12 + 7;
            goto L6
        L10:
            return r10 + (r13 << r12);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jf.d f3477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3479c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3480d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c[] f3481e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3482f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3483g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3484h;

        public b(jf.d r8) {
            this.f3478b = Integer.MAX_VALUE;
            this.f3481e = new c[8];
            this.f3482f = 7;
            this.f3483g = 0;
            this.f3484h = 0;
            this.f3480d = 4096;
            this.f3477a = r8;
        }

        public final void a(int r8) {
            if (r8 <= 0) goto L12;
            int r10 = this.f3481e.length - 1;
            int r11 = 0;
        L4:
            int r12 = this.f3482f;
            if (r10 < r12) goto L8;
            if (r8 <= 0) goto L8;
            int r13 = this.f3481e[r10].f3466c;
            r8 = r8 - r13;
            this.f3484h -= r13;
            this.f3483g--;
            r11 = r11 + 1;
            r10 = r10 - 1;
        L8:
            c[] r14 = this.f3481e;
            int r15 = r12 + 1;
            System.arraycopy(r14, r15, r14, r15 + r11, this.f3483g);
            c[] r16 = this.f3481e;
            int r17 = this.f3482f + 1;
            Arrays.fill(r16, r17, r17 + r11, null);
            this.f3482f += r11;
            return;
        }

        public final void b(c r8) {
            int r10 = this.f3480d;
            int r11 = r8.f3466c;
            if (r11 <= r10) goto L6;
            Arrays.fill(this.f3481e, null);
            this.f3482f = this.f3481e.length - 1;
            this.f3483g = 0;
            this.f3484h = 0;
            return;
        L6:
            a((this.f3484h + r11) - r10);
            int r12 = this.f3483g + 1;
            c[] r13 = this.f3481e;
            if (r12 <= r13.length) goto L9;
            c[] r14 = new c[r13.length * 2];
            System.arraycopy(r13, 0, r14, r13.length, r13.length);
            this.f3482f = this.f3481e.length - 1;
            this.f3481e = r14;
        L9:
            int r15 = this.f3482f;
            this.f3482f = r15 - 1;
            this.f3481e[r15] = r8;
            this.f3483g++;
            this.f3484h += r11;
        }

        public final void c(jf.g r11) {
            q.f3596d.getClass();
            long r8 = 0;
            int r10 = 0;
            long r12 = 0;
            int r13 = 0;
        L4:
            if (r13 >= r11.l()) goto L7;
            r12 = r12 + ((long) q.f3595c[r11.e(r13) & 255]);
            r13 = r13 + 1;
            goto L4
        L7:
            if (((int) ((r12 + 7) >> 3)) >= r11.l()) goto L19;
            jf.d r14 = new jf.d();
            q.f3596d.getClass();
            int r15 = 0;
        L10:
            if (r10 >= r11.l()) goto L16;
            int r16 = r11.e(r10) & 255;
            int r17 = q.f3594b[r16];
            byte r18 = q.f3595c[r16];
            r8 = (r8 << r18) | ((long) r17);
            r15 = r15 + r18;
        L13:
            if (r15 < 8) goto L15;
            r15 = r15 - 8;
            r14.G((int) (r8 >> r15));
            goto L13
        L15:
            r10 = r10 + 1;
            goto L10
        L16:
            if (r15 <= 0) goto L18;
            r14.G((int) ((r8 << (8 - r15)) | ((long) (255 >>> r15))));
        L18:
            r11 = r14.x();
            e(r11.f8842a.length, QesdkUtils.LIMITS.INT_8_UPPER, 128);
        L20:
            this.f3477a.E(r11);
            return;
        L19:
            e(r11.l(), QesdkUtils.LIMITS.INT_8_UPPER, 0);
            goto L20
        }

        public final void d(ArrayList r13) {
            if (this.f3479c == false) goto L8;
            int r8 = this.f3478b;
            if (r8 >= this.f3480d) goto L7;
            e(r8, 31, 32);
        L7:
            this.f3479c = false;
            this.f3478b = Integer.MAX_VALUE;
            e(this.f3480d, 31, 32);
        L8:
            int r10 = r13.size();
            int r11 = 0;
        L9:
            if (r11 >= r10) goto L49;
            c r12 = (c) r13.get(r11);
            jf.g r14 = r12.f3464a.n();
            Integer r15 = d.f3468b.get(r14);
            jf.g r16 = r12.f3465b;
            if (r15 == null) goto L23;
            int r17 = r15.intValue() + 1;
            if (r17 > 1) goto L15;
        L22:
            int r18 = -1;
        L25:
            if (r18 != (-1)) goto L36;
            int r19 = this.f3482f + 1;
            int r20 = this.f3481e.length;
        L27:
            if (r19 >= r20) goto L36;
            if (xe.c.m(this.f3481e[r19].f3464a, r14) == false) goto L35;
            if (xe.c.m(this.f3481e[r19].f3465b, r16) == true) goto L32;
            if (r17 != (-1)) goto L35;
            r17 = (r19 - this.f3482f) + d.f3467a.length;
            goto L35
        L32:
            r18 = d.f3467a.length + (r19 - this.f3482f);
        L35:
            r19 = r19 + 1;
        L36:
            if (r18 == (-1)) goto L39;
            e(r18, QesdkUtils.LIMITS.INT_8_UPPER, 128);
        L48:
            r11 = r11 + 1;
            goto L9
        L39:
            if (r17 != (-1)) goto L41;
            this.f3477a.G(64);
            c(r14);
        L47:
            c(r16);
            b(r12);
            goto L48
        L41:
            jf.g r21 = c.f3458d;
            r14.getClass();
            if (r14.i(r21, r21.f8842a.length) == true) goto L44;
        L46:
            e(r17, 63, 64);
            goto L47
        L44:
            if (c.f3463i.equals(r14) == true) goto L46;
            e(r17, 15, 0);
            c(r16);
            goto L48
        L15:
            if (r17 >= 8) goto L22;
            c[] r22 = d.f3467a;
            if (xe.c.m(r22[r17 - 1].f3465b, r16) == false) goto L20;
        L24:
            r18 = r17;
            goto L25
        L20:
            if (xe.c.m(r22[r17].f3465b, r16) == false) goto L22;
            r18 = r17 + 1;
            goto L25
        L23:
            r17 = -1;
            goto L24
        }

        public final void e(int r8, int r10, int r11) {
            jf.d r12 = this.f3477a;
            if (r8 >= r10) goto L6;
            r12.G(r8 | r11);
            return;
        L6:
            r12.G(r11 | r10);
            int r13 = r8 - r10;
        L8:
            if (r13 < 128) goto L10;
            r12.G(128 | (r13 & QesdkUtils.LIMITS.INT_8_UPPER));
            r13 = r13 >>> 7;
            goto L8
        L10:
            r12.G(r13);
        }
    }

    static {
        c r8 = new c("", c.f3463i);
        jf.g r10 = c.f3460f;
        c r11 = new c(HttpMethodContrants.GET, r10);
        c r12 = new c(HttpMethodContrants.POST, r10);
        jf.g r13 = c.f3461g;
        c r14 = new c("/", r13);
        c r15 = new c("/index.html", r13);
        jf.g r16 = c.f3462h;
        c r17 = new c("http", r16);
        c r18 = new c(LocationInfoConst.HTTPS, r16);
        jf.g r19 = c.f3459e;
        c[] r20 = {r8, r11, r12, r14, r15, r17, r18, new c(BDLocationException.SUCCESS, r19), new c("204", r19), new c("206", r19), new c("304", r19), new c("400", r19), new c("404", r19), new c("500", r19), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c(URLDispatch.KEY_ETAG, ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c(LocationMonitorConst.LOCATION, ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        f3467a = r20;
        LinkedHashMap r21 = new LinkedHashMap(r20.length);
        int r22 = 0;
    L4:
        if (r22 >= r20.length) goto L9;
        if (r21.containsKey(r20[r22].f3464a) == true) goto L8;
        r21.put(r20[r22].f3464a, Integer.valueOf(r22));
    L8:
        r22 = r22 + 1;
        goto L4
    L9:
        f3468b = Collections.unmodifiableMap(r21);
    }

    public static void a(jf.g r8) {
        int r10 = r8.l();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L12;
        byte r12 = r8.e(r11);
        if (r12 < 65) goto L11;
        if (r12 > 90) goto L11;
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + r8.p());
    L11:
        r11 = r11 + 1;
        goto L3
    }
}
