package bb;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.g;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import jb.i;
import jb.s;
import jb.w;
import nb.h;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static String f555n = "DownloadSingleResponseHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DownloadInfo f556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private w f558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h f559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private rb.a f560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private sb.d f563h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f564i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f565j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f566k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile boolean f567l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile ob.a f568m;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f569c;

        a(d r10) {
            this.f569c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a(this.f569c).a();
        }
    }

    class b implements ob.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f570a;

        b(d r10) {
            this.f570a = r10;
        }

        @Override // ob.b
        public void a(int r10) {
            if (lb.a.a() == false) goto L5;
            lb.a.g(d.b(), d.c(this.f570a).getId(), "OnDoThrottle", "real throttle speed=" + r10);
        L5:
            this.f570a.n(r10, 1);
        }
    }

    static {
    }

    public d(cb.h r10, h r11, long r12, long r13, sb.d r14) {
        this.f564i = true;
        this.f568m = null;
        DownloadInfo r15 = r10.f678c;
        this.f556a = r15;
        this.f557b = r10.f676a;
        this.f558c = r10.f688m;
        this.f560e = r10.f679d;
        this.f559d = r11;
        this.f561f = r12;
        this.f562g = r13;
        this.f563h = r14;
        if (r15.getIsDynamicThrottleEnable() == false) goto L6;
        g();
        return;
    }

    static /* synthetic */ h a(d r10) {
        return r10.f559d;
    }

    static /* synthetic */ String b() {
        return f555n;
    }

    static /* synthetic */ DownloadInfo c(d r10) {
        return r10.f556a;
    }

    private void e() {
        if (this.f559d != null) goto L5;
        return;
    L5:
        com.ss.android.socialbase.downloader.downloader.a.K0(new a(this), true);
    }

    private boolean f(byte[] r10, byte[] r11, int r12) {
        if (r10 != null) goto L5;
    L16:
        return true;
    L5:
        if (r10.length < r12) goto L16;
        if (r11 == null) goto L16;
        if (r11.length < r12) goto L16;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L16;
        if (r10[r13] != r11[r13]) goto L14;
        r13 = r13 + 1;
        goto L11
    L14:
        return false;
    }

    private void g() {
        if (this.f568m == null) goto L5;
        return;
    L5:
        this.f568m = new ob.a(new b(this));
    }

    private boolean j() {
        if (this.f565j == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f566k == true) goto L8;
        return false;
    }

    private byte[] l(int r10) {
        com.ss.android.socialbase.downloader.utils.b r11 = new com.ss.android.socialbase.downloader.utils.b(new FileInputStream(new File(this.f556a.getTempPath(), this.f556a.getTempName())));     // Catch: Throwable -> L12
        r11.a(this.f556a.getCurBytes(), 0);     // Catch: Throwable -> L10
        byte[] r12 = new byte[r10];     // Catch: Throwable -> L10
        if (r11.read(r12, 0, r10) == r10) goto L29;
    L25:
        r11.close();     // Catch: Throwable -> L22
    L17:
        return null;
    L29:
        r11.close();     // Catch: Throwable -> L23
    L7:
        return r12;
    L10:
        th = th;
    L27:
        th.printStackTrace();     // Catch: Throwable -> L18
        if (r11 == null) goto L17;
    L18:
        th = move-exception;
        if (r11 != null) goto L33;
    L21:
        throw th;
    L33:
        r11.close();     // Catch: Throwable -> L24
    L12:
        th = th;
        r11 = null;
        goto L27
    }

    private void o(int r10) {
        if (this.f568m != null) goto L5;
        return;
    L5:
        if (this.f568m.c() == true) goto L16;
        h r11 = this.f559d;
        if ((r11 instanceof nb.a) == false) goto L15;
        s r12 = ((nb.a) r11).f();
        if (r12 != null) goto L12;
        return;
    L12:
        this.f568m.d(r12.b(), r12.c(), r12.a(), r10);
        return;
    L15:
        return;
    }

    private void p() {
        this.f556a.updateRealDownloadTime(true);     // Catch: Exception -> L4
        this.f557b.b(this.f556a);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private InputStream q(InputStream r10) {
        if ((r10 instanceof ob.f) == false) goto L5;
        ob.f r11 = (ob.f) r10;
    L6:
        r11.a(this.f556a.getThrottleNetSpeed(), this.f556a.getThrottleSmoothness());
        return r11;
    L5:
        r11 = new ob.e(r10, (float) this.f560e.m("throttle_factor_min", 0.10000000149011612d), (float) this.f560e.m("throttle_factor_max", 0.699999988079071d));
        goto L6
    }

    public void d() {
        if (this.f566k == false) goto L5;
        return;
    L5:
        this.f566k = true;
        e();
    }

    public long h() {
        return this.f561f;
    }

    public void i() {
        String r10 = " isFirstRead:";
        String r11 = "Exception:";
        long r12 = g.p(this.f559d);
        if (r12 == 0) goto L270;
        long r13 = this.f561f;
        if (this.f556a.getVerifyCurBytes() <= 0) goto L7;
        int r14 = (int) (this.f556a.getVerifyCurBytes() - this.f556a.getCurBytes());
        byte[] r15 = l(r14);
    L8:
        h r16 = this.f559d;
        if ((r16 instanceof nb.a) == false) goto L11;
        nb.a r17 = (nb.a) r16;
    L321:
        DownloadInfo r18 = this.f556a;     // Catch: Throwable -> L170 BaseException -> L231
        com.ss.android.socialbase.downloader.model.h r19 = com.ss.android.socialbase.downloader.utils.c.k(r18, r18.getTempPath(), this.f556a.getTempName(), -1, true);     // Catch: Throwable -> L170 BaseException -> L231
        if (this.f556a.isFastDownload() == true) goto L23;
        long r110 = r13;
        r19.a(this.f561f - this.f556a.getStartOffset());     // Catch: Throwable -> L19 IOException -> L21 BaseException -> L158
    L295:
        InputStream r20 = this.f559d.b();     // Catch: Throwable -> L151 BaseException -> L158
    L289:
        this.f556a.updateRealStartDownloadTime();     // Catch: Throwable -> L146 BaseException -> L149
        boolean r21 = this.f556a.isIgnoreDataVerify();     // Catch: Throwable -> L146 BaseException -> L149
        if (this.f556a.getOpenLimitSpeed() == false) goto L33;
        if (r17 == null) goto L33;
        r17.m(ab.b.f131d);     // Catch: Throwable -> L30 BaseException -> L149
    L30:
        th = th;
    L148:
        int r22 = 0;
    L287:
        lb.a.h(f555n, this.f556a.getId(), "handleResponse", r11 + th.toString() + r10 + this.f564i);     // Catch: Throwable -> L229
        if (r17 == null) goto L176;
        r17 = r17;
        r17.l(th);     // Catch: Throwable -> L227
    L178:
        if (j() == false) goto L194;
        if (r22 > 0) goto L300;
    L181:
        if (r19 != null) goto L183;
    L185:
        this.f559d.a();
        g.b0(new Closeable[]{r20});
        g.b0(new Closeable[]{r19});
        if (r17 != null) goto L188;
        return;
    L188:
        if (TextUtils.isEmpty(r17.h()) == true) goto L331;
        this.f556a.setRequestLog(r17.h());
        if (this.f556a.isHandleRequest() == false) goto L332;
        this.f563h.l(r17.h());
        return;
    L332:
        return;
    L331:
        return;
    L183:
        if (this.f566k == true) goto L185;
        p();
        goto L185
    L300:
        this.f563h.j(r22);     // Catch: Throwable -> L272
        goto L181
    L194:
        if (lb.a.a() == false) goto L307;
        th.printStackTrace();     // Catch: Throwable -> L227
    L307:
        com.ss.android.socialbase.downloader.utils.c.T(th, "ResponseHandler");     // Catch: BaseException -> L224 Throwable -> L227
        if (r22 > 0) goto L283;
    L199:
        if (r19 != null) goto L201;
    L203:
        this.f559d.a();
        g.b0(new Closeable[]{r20});
        g.b0(new Closeable[]{r19});
        if (r17 == null) goto L212;
        if (TextUtils.isEmpty(r17.h()) == true) goto L212;
        this.f556a.setRequestLog(r17.h());
        if (this.f556a.isHandleRequest() == false) goto L212;
        sb.d r23 = this.f563h;
        String r24 = r17.h();
    L210:
        r23.l(r24);
    L212:
        if (this.f556a.isIgnoreDataVerify() == false) goto L214;
        return;
    L214:
        long r25 = this.f561f - r110;
        if (r25 < 0) goto L223;
        long r26 = this.f562g;
        if (r26 >= 0) goto L219;
        return;
    L219:
        if (r26 != r25) goto L222;
        return;
    L222:
        throw new BaseException(1051, String.format(Locale.US, "handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", new Object[]{Long.valueOf(r25), Long.valueOf(r12), Long.valueOf(this.f562g), Long.valueOf(this.f556a.getStartOffset()), Long.valueOf(this.f556a.getEndOffset()), Long.valueOf(this.f561f), Long.valueOf(r110)}));
    L223:
        return;
    L201:
        if (this.f566k == true) goto L203;
        p();
        goto L203
    L283:
        this.f563h.j(r22);     // Catch: Throwable -> L273
        goto L199
    L224:
        e = move-exception;
        com.ss.android.socialbase.downloader.utils.c.w(this.f559d, e);     // Catch: Throwable -> L227
        throw e;     // Catch: Throwable -> L227
    L227:
        th = th;
    L256:
        if (r22 > 0) goto L296;
    L258:
        if (r19 != null) goto L260;
    L262:
        this.f559d.a();
        g.b0(new Closeable[]{r20});
        g.b0(new Closeable[]{r19});
        if (r17 != null) goto L265;
        throw th;
    L265:
        if (TextUtils.isEmpty(r17.h()) == true) goto L339;
        this.f556a.setRequestLog(r17.h());
        if (this.f556a.isHandleRequest() == false) goto L340;
        this.f563h.l(r17.h());
        throw th;
    L340:
        throw th;
    L339:
        throw th;
    L260:
        if (this.f566k == true) goto L262;
        p();
        goto L262
    L296:
        this.f563h.j(r22);     // Catch: Throwable -> L274
        goto L258
    L176:
        r17 = r17;
    L229:
        th = th;
        r17 = r17;
    L33:
        if (this.f560e.o("use_default_throttle_speed", 1) != 1) goto L39;
        long r111 = this.f556a.getThrottleNetSpeed();     // Catch: Throwable -> L30 BaseException -> L149
        if (r111 != (-1)) goto L37;
    L38:
        this.f567l = true;     // Catch: Throwable -> L30 BaseException -> L149
        goto L39
    L37:
        if (r111 > 0) goto L38;
    L39:
        int r112 = com.ss.android.socialbase.downloader.downloader.a.V();     // Catch: Throwable -> L146 BaseException -> L149
        if (r17 != null) goto L42;
    L50:
        byte[] r113 = new byte[r112];     // Catch: Throwable -> L146 BaseException -> L149
        InputStream r114 = r20;
        int r27 = 0;
        long r28 = 0;
    L304:
        if (this.f567l == true) goto L298;
    L59:
        int r115 = r114.read(r113);     // Catch: Throwable -> L138 BaseException -> L144
        if (r115 == (-1)) goto L62;
        if (r21 == true) goto L79;
        r12 = r12;
        long r29 = this.f562g;     // Catch: Throwable -> L77 BaseException -> L144
        r10 = r10;
        r11 = r11;
        long r30 = this.f561f;     // Catch: Throwable -> L73 BaseException -> L75
    L69:
        if (r29 <= (r30 - r110)) goto L80;
        r17 = r17;
        if (r29 >= ((r30 - r110) + ((long) r115))) goto L317;
        r115 = (int) (r29 - (r30 - r110));
    L317:
    L135:
        e = e;
    L136:
        r10 = r10;
        r17 = r17;
    L137:
        r19 = r19;
        r11 = r11;
    L293:
        lb.a.h(f555n, this.f556a.getId(), "handleResponse", r11 + e.toString() + r10 + this.f564i);     // Catch: Throwable -> L254
        if (j() == false) goto L251;
        if (r27 > 0) goto L285;
    L238:
        if (r19 != null) goto L240;
    L242:
        this.f559d.a();
        g.b0(new Closeable[]{r114});
        g.b0(new Closeable[]{r19});
        if (r17 != null) goto L245;
        return;
    L245:
        if (TextUtils.isEmpty(r17.h()) == true) goto L336;
        this.f556a.setRequestLog(r17.h());
        if (this.f556a.isHandleRequest() == false) goto L337;
        this.f563h.l(r17.h());
        return;
    L337:
        return;
    L336:
        return;
    L240:
        if (this.f566k == true) goto L242;
        p();
        goto L242
    L285:
        this.f563h.j(r27);     // Catch: Throwable -> L276
        goto L238
    L251:
        if (lb.a.a() == false) goto L253;
        e.printStackTrace();     // Catch: Throwable -> L254
    L253:
        throw e;     // Catch: Throwable -> L254
    L254:
        th = th;
        r22 = r27;
        r20 = r114;
    L133:
        th = th;
    L141:
        r22 = r27;
    L142:
        r20 = r114;
    L143:
        r19 = r19;
        goto L287
    L82:
        if (this.f564i == false) goto L90;
        this.f564i = false;     // Catch: Throwable -> L133 BaseException -> L135
        this.f558c.f();     // Catch: Throwable -> L133 BaseException -> L135
        if (this.f556a.getVerifyCurBytes() <= 0) goto L90;
        if (f(r15, r113, r14) == true) goto L90;
        throw new BaseException(1051, "Fail to verify data");     // Catch: Throwable -> L133 BaseException -> L135
    L90:
        r19.write(r113, 0, r115);     // Catch: Throwable -> L133 BaseException -> L135
        this.f561f += (long) r115;     // Catch: Throwable -> L133 BaseException -> L135
        r22 = r27 + r115;
        if (this.f556a.isHandleRequest() == false) goto L95;
        this.f563h.i(r113, r115);     // Catch: Throwable -> L129 BaseException -> L131
    L95:
        long r31 = SystemClock.uptimeMillis();     // Catch: Throwable -> L129 BaseException -> L131
        if ((r31 - r28) <= 1000) goto L108;
        o(r22);     // Catch: Throwable -> L129 BaseException -> L131
        if (this.f563h.j(r22) == true) goto L311;
    L102:
        cb.g.n(this.f556a);     // Catch: Throwable -> L104 BaseException -> L106
        r28 = r31;
        r27 = 0;
    L109:
        if (r21 == true) goto L128;
        long r32 = this.f562g;     // Catch: Throwable -> L133 BaseException -> L135
        if (r32 < 0) goto L128;
        if (r32 > (this.f561f - r110)) goto L128;
    L115:
        if (r27 > 0) goto L291;
    L117:
        if (r19 != null) goto L119;
    L121:
        this.f559d.a();
        g.b0(new Closeable[]{r114});
        g.b0(new Closeable[]{r19});
        if (r17 == null) goto L212;
        if (TextUtils.isEmpty(r17.h()) == true) goto L212;
        this.f556a.setRequestLog(r17.h());
        if (this.f556a.isHandleRequest() == false) goto L212;
        r23 = this.f563h;
        r24 = r17.h();
        goto L210
    L119:
        if (this.f566k == true) goto L121;
        p();
        goto L121
    L291:
        this.f563h.j(r27);     // Catch: Throwable -> L275
    L128:
        r10 = r10;
        r12 = r12;
        r11 = r11;
        r17 = r17;
        goto L304
    L311:
        if (this.f566k == true) goto L102;
        p();     // Catch: Throwable -> L104 BaseException -> L106
        goto L102
    L106:
        e = e;
        r10 = r10;
        r17 = r17;
        r27 = 0;
    L104:
        th = th;
        r20 = r114;
        r22 = 0;
        goto L143
    L108:
        r27 = r22;
        goto L109
    L131:
        e = e;
        r27 = r22;
    L129:
        th = th;
    L80:
        r17 = r17;
    L75:
        e = e;
        r10 = r10;
    L73:
        th = th;
    L140:
        r17 = r17;
    L77:
        th = th;
        r10 = r10;
        r11 = r11;
        goto L140
    L79:
        r10 = r10;
        r11 = r11;
        r12 = r12;
        goto L80
    L62:
        r12 = r12;
        r17 = r17;
        goto L115
    L298:
        this.f567l = false;     // Catch: Throwable -> L57 BaseException -> L144
        r114 = q(r114);     // Catch: Throwable -> L57 BaseException -> L144
    L57:
        th = th;
        r10 = r10;
        r11 = r11;
        r12 = r12;
        r22 = r27;
        r20 = r114;
        r17 = r17;
    L144:
        e = e;
        r10 = r10;
        r114 = r114;
    L160:
        r11 = r11;
    L138:
        th = th;
        r10 = r10;
        r11 = r11;
        r12 = r12;
        goto L140
    L42:
        if (r17.j() == false) goto L44;
        r112 = ab.b.f133f;     // Catch: Throwable -> L30 BaseException -> L149
    L44:
        List<Pair<String, String>> r116 = r17.i();     // Catch: Throwable -> L30 BaseException -> L149
        if (r116 == null) goto L48;
        this.f556a.setHttpResponseHeader(r116.toString());     // Catch: Throwable -> L30 BaseException -> L149
    L48:
        if (this.f556a.isHandleRequest() == false) goto L50;
        this.f563h.g(r116);     // Catch: Throwable -> L30 BaseException -> L149
    L146:
        th = th;
    L149:
        e = e;
        r10 = " isFirstRead:";
        r114 = r20;
        r27 = 0;
    L151:
        th = th;
    L155:
        r17 = r17;
    L157:
        r22 = 0;
        r20 = null;
        goto L287
    L21:
        e = e;
    L163:
        r17 = r17;
    L168:
        e = e;
        r19 = r19;
        r17 = r17;
        r27 = 0;
    L233:
        r114 = null;
    L166:
        th = th;
        goto L157
    L165:
        throw new BaseException(1054, e);     // Catch: Throwable -> L166 BaseException -> L168
    L19:
        th = th;
        r10 = " isFirstRead:";
        r11 = "Exception:";
        r12 = r12;
        r17 = r17;
        goto L157
    L23:
        r110 = r13;
        goto L295
    L158:
        e = e;
        r10 = " isFirstRead:";
        r27 = 0;
        r114 = null;
    L161:
        e = e;
        r110 = r13;
    L153:
        th = th;
        r110 = r13;
        goto L155
    L231:
        e = e;
        r27 = 0;
        r19 = null;
    L170:
        th = th;
        r10 = " isFirstRead:";
        r11 = "Exception:";
        r12 = r12;
        r110 = r13;
        r17 = r17;
        r22 = 0;
        r20 = null;
        r19 = null;
        goto L287
    L11:
        r17 = null;
        goto L321
    L7:
        r14 = 0;
        r15 = null;
        goto L8
    L270:
        this.f559d.a();
        throw new DownloadRetryNeedlessException(PointerIconCompat.TYPE_WAIT, "the content-length is 0");
    }

    public void k() {
        if (this.f565j == false) goto L5;
        return;
    L5:
        this.f565j = true;
        e();
    }

    public void m(boolean r10) {
        this.f556a.setDynamicThrottleEnable(r10);
        if (r10 == false) goto L17;
        if (this.f568m != null) goto L15;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.f568m != null) goto L10;
        g();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L15:
        this.f568m.e();
        return;
    L17:
        if (this.f568m == null) goto L24;
        this.f568m.g();
        return;
    }

    public void n(long r10, int r11) {
        this.f556a.setThrottleNetSpeed(r10, r11);
        this.f567l = true;
    }
}
