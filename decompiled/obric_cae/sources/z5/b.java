package z5;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import we.a0;
import we.r;
import we.v;
import we.w;
import we.x;
import we.y;

/* JADX INFO: loaded from: classes.dex */
public final class b implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f14225b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f5.a f14226m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public v f14227n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14228o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public y f14229p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f14230q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ConcurrentHashMap f14231r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final WeakHandler f14232s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final e f14233t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public f f14234u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b6.c f14235v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f14236w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f6.a f14237x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final f6.b f14238y;

    public class a implements f6.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f14239a;

        public a(b r8) {
            this.f14239a = r8;
        }
    }

    /* JADX INFO: renamed from: z5.b$b, reason: collision with other inner class name */
    public class C0203b implements f6.b.InterfaceC0072b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f14240a;

        public C0203b(b r8) {
            this.f14240a = r8;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a6.a f14241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f6.a f14242b;

        public c(Context r8) {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f14243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<String> f14244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a6.a f14245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f6.a f14246d;

        public d(Context r8, a6.a r10, f6.a r11) {
            this.f14243a = r8;
            this.f14244b = null;
            this.f14245c = r10;
            this.f14246d = r11;
        }

        public static /* synthetic */ List a(d r8) {
            return r8.f14244b;
        }

        public static /* synthetic */ void b(d r8, List r10) {
            r8.f14244b = r10;
        }

        public static /* synthetic */ a6.a c(d r8) {
            return r8.f14245c;
        }

        public final String toString() {
            return "Config{mHeartBeatPolicy=" + this.f14246d + ", mContext=" + this.f14243a + ", wsUrls=" + this.f14244b + ", mOkHttpClient=null, mRetryPolicy=" + this.f14245c + '}';
        }
    }

    public class e extends android.support.v4.media.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f14247c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f14248a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f14249b;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ String f14250m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ b6.d f14251n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final /* synthetic */ Pair f14252o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final /* synthetic */ e f14253p;

            public a(e r8, String r10, int r11, String r12, b6.d r13, Pair r14) {
                this.f14253p = r8;
                this.f14248a = r10;
                this.f14249b = r11;
                this.f14250m = r12;
                this.f14251n = r13;
                this.f14252o = r14;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Logger.d("WsChannelSdk_ok", "----------onFailure--------");
                e r8 = this.f14253p;
                f r10 = b.f(r8.f14247c);
                b r11 = r8.f14247c;
                int r12 = this.f14249b;
                if (r10 == null) goto L6;
                ((n) b.f(r11)).b(r12, this.f14248a, this.f14250m);
            L6:
                if (b.g(r11) == false) goto L10;
                b.h(r11);
                b.j(r11, b.i(r11).b());
                return;
            L10:
                if (b.a(r11) == this.f14251n) goto L14;
                Logger.d("WsChannelSdk_ok", "socket已过期");
                return;
            L14:
                if (e.z(r8, r12) == false) goto L16;
                ((h6.b) b.c(r11)).c();
                Pair r13 = this.f14252o;
                b.k(r11, ((Long) r13.second).longValue(), (String) r13.first, false);
                return;
            L16:
                b.d(r11, 2);
                b.l(r11);
            }
        }

        public e(b r8) {
            this.f14247c = r8;
        }

        public static boolean z(e r8, int r10) {
            r8.getClass();
            if (r10 > 0) goto L5;
        L14:
            return true;
        L5:
            if (r10 == 414) goto L14;
            if (r10 == 511) goto L14;
            if (r10 == 512) goto L14;
            if (r10 == 513) goto L14;
            return false;
        }

        @Override // android.support.v4.media.a
        public final void l(b6.c r10, int r11, String r12) {
            b r8 = this.f14247c;
            r8.getClass();
            if (r10 == null) goto L9;
            y r13 = r10.f3077b;
            if (r13 == null) goto L9;
            r r14 = r13.f13337a;
            if (r14 == null) goto L9;
            String r15 = r14.f13249i;
        L10:
            r8.s(new l(this, r10, r15, r11, r12));
            return;
        L9:
            r15 = "";
            goto L10
        }

        @Override // android.support.v4.media.a
        public final void m() {
            k r8 = new k(this);
            this.f14247c.s(r8);
        }

        @Override // android.support.v4.media.a
        public final void o(b6.d r11, Throwable r12, a0 r13) {
            b r8 = this.f14247c;
            r8.getClass();
            String r10 = "";
            if (r11 == null) goto L9;
            y r14 = ((b6.c) r11).f3077b;
            if (r14 == null) goto L9;
            r r15 = r14.f13337a;
            if (r15 == null) goto L9;
            String r16 = r15.f13249i;
        L10:
            if (r13 != null) goto L78;
        L14:
            int r17 = -1;
        L15:
            int r18 = r17;
            if (r18 != 0) goto L19;
            r10 = "成功";
        L64:
            if (r5.f.b(r10) == true) goto L66;
            String r19 = r10;
        L71:
            Pair r20 = r8.f14226m.a(r13);
            if (r13 != null) goto L80;
        L74:
            r8.s(new a(this, r16, r18, r19, r11, r20));
            return;
        L80:
            r13.close();     // Catch: Throwable -> L76
            goto L74
        L66:
            if (r5.f.b(r12.getMessage()) == false) goto L68;
            String r110 = Log.getStackTraceString(r12);
        L69:
            r19 = r110;
            goto L71
        L68:
            r110 = r12.getMessage();
            goto L69
        L19:
            if (r18 != 404) goto L22;
            r10 = "uri不存在";
            goto L64
        L22:
            if (r18 != 409) goto L25;
            r10 = "fpid没有注册";
            goto L64
        L25:
            if (r18 != 410) goto L28;
            r10 = "非法的设备id";
            goto L64
        L28:
            if (r18 != 411) goto L31;
            r10 = "appid还没有注册";
            goto L64
        L31:
            if (r18 != 412) goto L34;
            r10 = "websocket子协议不支持";
            goto L64
        L34:
            if (r18 != 413) goto L37;
            r10 = "该设备已经建立连接";
            goto L64
        L37:
            if (r18 != 414) goto L40;
            r10 = "服务器不能接受更多连接，可重试";
            goto L64
        L40:
            if (r18 != 415) goto L43;
            r10 = "设备被限时禁止连接";
            goto L64
        L43:
            if (r18 != 416) goto L46;
            r10 = "参数不正确";
            goto L64
        L46:
            if (r18 != 417) goto L49;
            r10 = "鉴权失败";
            goto L64
        L49:
            if (r18 != 510) goto L52;
            r10 = "服务器内部错误";
            goto L64
        L52:
            if (r18 != 511) goto L55;
            r10 = "服务器忙，可稍后重试";
            goto L64
        L55:
            if (r18 != 512) goto L58;
            r10 = "服务器正在关机";
            goto L64
        L58:
            if (r18 != 513) goto L61;
            r10 = "auth服务异常";
            goto L64
        L61:
            if (r18 != 514) goto L64;
            r10 = "auth服务返回失败";
            goto L64
        L78:
            r17 = Integer.parseInt(r13.n("Handshake-Status"));     // Catch: Throwable -> L77
        L9:
            r16 = "";
            goto L10
        }

        @Override // android.support.v4.media.a
        public final void s(String r8) {
            j r10 = new j(this, r8);
            this.f14247c.s(r10);
        }

        @Override // android.support.v4.media.a
        public final void t(jf.g r8) {
            i r10 = new i(this, r8);
            this.f14247c.s(r10);
        }

        @Override // android.support.v4.media.a
        public final void u(b6.c r8, a0 r10) {
            h r11 = new h(this, r8, r10);
            this.f14247c.s(r11);
        }

        @Override // android.support.v4.media.a
        public final void v(b6.c r8) {
            m r10 = new m(this, r8);
            this.f14247c.s(r10);
        }
    }

    public interface f {
    }

    public b(d r8) {
        this.f14228o = 3;
        this.f14231r = new ConcurrentHashMap();
        WeakHandler r10 = new WeakHandler(Looper.myLooper(), this);
        this.f14232s = r10;
        this.f14233t = new e(this);
        this.f14225b = r8;
        this.f14224a = r8.f14243a;
        this.f14227n = null;
        f6.a r11 = r8.f14246d;
        this.f14237x = r11;
        if (r11 != null) goto L5;
        new h6.a();
        this.f14237x = new h6.b(new h6.a.C0084a());
    L5:
        this.f14237x.a(new a(this), r10);
        this.f14238y = new f6.b(new C0203b(this), r10);
    }

    public static /* synthetic */ b6.c a(b r8) {
        return r8.f14235v;
    }

    public static /* synthetic */ void b(b r8) {
        r8.f14235v = null;
    }

    public static /* synthetic */ f6.a c(b r8) {
        return r8.f14237x;
    }

    public static /* synthetic */ void d(b r8, int r10) {
        r8.t(r10);
    }

    public static void e(b r8) {
        f5.a r10 = r8.f14226m;
        if (r10 == null) goto L5;
        r10.c();
    L5:
        r8.f14232s.removeMessages(1);
    }

    public static /* synthetic */ f f(b r8) {
        return r8.f14234u;
    }

    public static /* synthetic */ boolean g(b r8) {
        return r8.f14236w;
    }

    public static /* synthetic */ void h(b r8) {
        r8.f14236w = false;
    }

    public static /* synthetic */ f5.a i(b r8) {
        return r8.f14226m;
    }

    public static /* synthetic */ void j(b r8, String r10) {
        r8.u(r10);
    }

    public static /* synthetic */ void k(b r8, long r10, String r11, boolean r12) {
        r8.v(r10, r11, r12);
    }

    public static void l(b r8) {
        f5.a r10 = r8.f14226m;
        if (r10 == null) goto L6;
        r10.c();
        return;
    }

    public static /* synthetic */ f6.b m(b r8) {
        return r8.f14238y;
    }

    public static void n(b r8) {
        y r10 = r8.f14229p;
        if (r10 == null) goto L7;
        f r11 = r8.f14234u;
        if (r11 == null) goto L7;
        n r12 = (n) r11;
        r12.b(3, r10.f13337a.f13249i, "心跳超时");
    L7:
        Pair r13 = r8.f14226m.a(null);
        WeakHandler r14 = r8.f14232s;
        r14.removeMessages(2);
        r14.removeMessages(1);
        r14.removeMessages(3);
        r14.removeMessages(5);
        f5.a r15 = r8.f14226m;
        if (r15 == null) goto L10;
        r15.c();
    L10:
        r14.removeMessages(1);
        r8.p();
        b6.c r16 = r8.f14235v;
        if (r16 == null) goto L14;
        r16.f3076a = null;
        r16.c(1000, "normal close");     // Catch: Throwable -> L16
    L14:
        r8.v(0, (String) r13.first, true);
    }

    public static /* synthetic */ boolean o(b r8) {
        return r8.f14230q;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r8 = r10.what;
        WeakHandler r11 = this.f14232s;
        boolean r12 = false;
        if (r8 != 1) goto L17;
        monitor-enter(this);
        int r13 = this.f14228o;     // Catch: Throwable -> L14
        monitor-exit(this);
        if (r13 != 4) goto L11;
        r12 = true;
    L11:
        if (r12 == false) goto L13;
        return;
    L13:
        r11.removeMessages(1);
        r11.removeMessages(2);
        String r14 = (String) r10.obj;
    L45:
        u(r14);
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        d r15 = this.f14225b;
        if (r8 != 2) goto L25;
        r11.removeMessages(2);     // Catch: Throwable -> L22
        r11.removeMessages(1);     // Catch: Throwable -> L22
        d.b(r15, (List) r10.obj);     // Catch: Throwable -> L22
        this.f14230q = false;     // Catch: Throwable -> L22
        f5.a r16 = new f5.a(d.a(r15), d.c(r15));     // Catch: Throwable -> L22
        this.f14226m = r16;     // Catch: Throwable -> L22
        r16.c();     // Catch: Throwable -> L22
        this.f14232s.removeMessages(1);     // Catch: Throwable -> L22
        String r17 = this.f14226m.b();     // Catch: Throwable -> L22
    L20:
        u(r17);     // Catch: Throwable -> L22
        return;
    L25:
        if (r8 != 3) goto L52;
        r11.removeMessages(2);
        r11.removeMessages(1);
        monitor-enter(this);
        int r18 = this.f14228o;     // Catch: Throwable -> L48
        monitor-exit(this);
        if (r18 != 4) goto L32;
        r12 = true;
    L32:
        if (r12 == false) goto L34;
        return;
    L34:
        f5.a r19 = this.f14226m;
        if (r19 == null) goto L37;
        r19.c();
    L37:
        this.f14232s.removeMessages(1);
        if (j6.c.b(this.f14224a) == true) goto L40;
        Logger.d("WsChannelSdk_ok", "网络变化，但网络不通，不尝试重连");
        return;
    L40:
        if (p() == false) goto L46;
        f5.a r20 = this.f14226m;
        if (r20 != null) goto L44;
        return;
    L44:
        r14 = r20.b();
        goto L45
    L46:
        this.f14236w = true;
        return;
    L48:
        th = move-exception;
        throw th;
    L52:
        if (r8 != 5) goto L59;
        if (((Boolean) r10.obj).booleanValue() == false) goto L56;
        g6.a r21 = g6.a.f7692a;
    L57:
        this.f14238y.c(r21);
        this.f14237x.getClass();
        return;
    L56:
        r21 = g6.a.f7693b;
        goto L57
    L59:
        if (r8 != 7) goto L76;
        r11.removeMessages(2);     // Catch: Throwable -> L22
        r11.removeMessages(1);     // Catch: Throwable -> L22
        d.b(r15, (List) r10.obj);     // Catch: Throwable -> L22
        this.f14230q = false;     // Catch: Throwable -> L22
        f5.a r22 = new f5.a(d.a(r15), d.c(r15));     // Catch: Throwable -> L22
        this.f14226m = r22;     // Catch: Throwable -> L22
        r22.c();     // Catch: Throwable -> L22
        this.f14232s.removeMessages(1);     // Catch: Throwable -> L22
        if (p() == false) goto L63;
        r17 = this.f14226m.b();     // Catch: Throwable -> L22
        goto L20
    L63:
        this.f14236w = true;     // Catch: Throwable -> L22
        return;
    L76:
        return;
    L22:
        th = move-exception;
        th.printStackTrace();
    }

    public final boolean p() {
        monitor-enter(this);
        int r8 = this.f14228o;     // Catch: Throwable -> L23
        monitor-exit(this);
        if (r8 != 3) goto L8;
        return true;
    L8:
        if (r8 != 2) goto L10;
        return true;
    L10:
        if (r8 == 5) goto L31;
        ((h6.b) this.f14237x).c();
        b6.c r10 = this.f14235v;
        if (r10 == null) goto L30;
        WeakHandler r11 = this.f14232s;
        r11.sendMessageDelayed(r11.obtainMessage(6, r10), 1000);
        if (r8 != 4) goto L18;
        this.f14235v.c(1000, "normal close");
        t(6);
        return false;
    L18:
        this.f14235v.a();
        t(3);
        if (r8 == 1) goto L22;
        return true;
    L22:
        return false;
    L30:
        return true;
    L31:
        return true;
    L23:
        th = move-exception;
        throw th;
    }

    public final void q(String r15) {
        if (this.f14227n != null) goto L5;
        v.b r8 = new v.b();
        r8.a(Collections.singletonList(w.f13320m));
        this.f14227n = new v(r8);
    L5:
        ConcurrentHashMap r10 = this.f14231r;
        boolean r11 = TextUtils.isEmpty(r15);
        Context r12 = this.f14224a;
        String r13 = "";
        if (r11 == true) goto L68;
        if (r10 == null) goto L68;
        String r14 = String.valueOf(r10.get(WsConstants.KEY_FPID)) + String.valueOf(r10.get(WsConstants.KEY_APP_KEY)) + String.valueOf(r10.get("device_id")) + WsConstants.SALT;
        int r16 = 0;
        if (TextUtils.isEmpty(r14) == false) goto L93;
    L22:
        String r17 = "";
    L23:
        String r18 = r17.toLowerCase();
        Uri.Builder r19 = Uri.parse(r15).buildUpon();
        Iterator r20 = r10.entrySet().iterator();
    L25:
        if (r20.hasNext() == false) goto L43;
        Map.Entry r21 = (Map.Entry) r20.next();
        if (r21 == null) goto L25;
        if (TextUtils.isEmpty((CharSequence) r21.getKey()) == true) goto L25;
        if (r21.getValue() != null) goto L34;
        String r110 = "";
    L35:
        String r22 = (String) r21.getKey();
        if (r5.f.a(WsConstants.KEY_APP_KEY, r22) == true) goto L25;
        if (r5.f.a(r22, WsConstants.KEY_EXTRA) == true) goto L25;
        if (r5.f.a("app_version", r22) == false) goto L42;
        r22 = "version_code";
    L42:
        r19.appendQueryParameter(r22, r110);
        goto L25
    L34:
        r110 = r21.getValue().toString();
        goto L35
    L43:
        String r23 = (String) r10.get(WsConstants.KEY_EXTRA);
        if (r5.f.b(r23) == true) goto L53;
        String[] r24 = r23.split("&");
        int r25 = r24.length;
        int r26 = 0;
    L46:
        if (r26 >= r25) goto L53;
        String r27 = r24[r26];
        if (TextUtils.isEmpty(r27) == true) goto L52;
        String[] r28 = r27.split("=");
        if (r28.length != 2) goto L52;
        r19.appendQueryParameter(r28[0], r28[1]);
    L52:
        r26 = r26 + 1;
    L53:
        r19.appendQueryParameter("access_key", r18);
        j6.c.a r29 = j6.c.a(r12);
        if (r29 != j6.c.a.f8719a) goto L57;
    L66:
        r19.appendQueryParameter("ne", String.valueOf(r16));
        r13 = r19.build().toString();
        goto L68
    L57:
        if (r29 != j6.c.a.f8723o) goto L60;
        r16 = 1;
        goto L66
    L60:
        if (r29 != j6.c.a.f8721m) goto L63;
        r16 = 2;
        goto L66
    L63:
        if (r29 != j6.c.a.f8722n) goto L65;
        r16 = 3;
        goto L66
    L65:
        r16 = 4;
        goto L66
    L93:
        byte[] r30 = MessageDigest.getInstance("MD5").digest(r14.getBytes());     // Catch: NoSuchAlgorithmException -> L20
        StringBuilder r31 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L20
        int r32 = r30.length;     // Catch: NoSuchAlgorithmException -> L20
        int r111 = 0;
    L13:
        if (r111 >= r32) goto L18;
        String r112 = Integer.toHexString(r30[r111] & 255);     // Catch: NoSuchAlgorithmException -> L20
        if (r112.length() != 1) goto L17;
        r112 = "0" + r112;     // Catch: NoSuchAlgorithmException -> L20
    L17:
        r31.append(r112);     // Catch: NoSuchAlgorithmException -> L20
        r111 = r111 + 1;     // Catch: NoSuchAlgorithmException -> L20
        goto L13
    L18:
        r17 = r31.toString();     // Catch: NoSuchAlgorithmException -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
    L68:
        if (r5.f.b(r13) == false) goto L71;
        Logger.e("WsChannelSdk_ok", "url is empty,cancel connect");
        return;
    L71:
        b6.c r113 = this.f14235v;
        if (r113 == null) goto L75;
        r113.f3076a = null;
        r113.c(1000, "normal close");     // Catch: Throwable -> L90
    L75:
        Logger.d("WsChannelSdk_ok", "尝试打开长连接:" + r13);
        y r114 = this.f14229p;
        if (r114 != null) goto L78;
    L79:
        y.a r115 = new y.a();
        r115.f13347d.a("Sec-Websocket-Protocol", "pbbp");
        r115.e(r13);
        this.f14229p = r115.a();
    L80:
        t(1);
        b6.c r116 = new b6.c(this.f14229p, com.bytedance.common.wschannel.a.a(r12).f3869a.b(WsConstants.KEY_IO_LIMIT, WsConstants.DEFAULT_IO_LIMIT), this.f14233t, new Random());
        this.f14235v = r116;
        v r33 = this.f14227n;
        y r34 = r116.f3077b;
        r34.getClass();
        y.a r35 = new y.a(r34);
        r35.f13347d.d("Upgrade", "websocket");
        r35.f13347d.d("Connection", "Upgrade");
        r35.f13347d.d("Sec-WebSocket-Key", r116.f3079d);
        r35.f13347d.d("Sec-WebSocket-Version", "13");
        y r36 = r35.a();
        xe.a.f13878a.getClass();
        x r37 = x.f(r33, r36, true);
        r116.f3084i = r37;
        r37.c(new b6.b(r116, r36));
        this.f14238y.f7332c = this.f14235v;
        f r117 = this.f14234u;
        if (r117 == null) goto L115;
        IWsChannelClient r118 = ((n) r117).f14277a;
        if (r118 == null) goto L116;
        JSONObject r119 = new JSONObject();
        r119.put("type", 1);     // Catch: Exception -> L87
        r119.put("state", 1);     // Catch: Exception -> L87
        r119.put(WsConstants.KEY_CONNECTION_URL, r13);     // Catch: Exception -> L87
        r119.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L87
        r118.onConnection(r119);     // Catch: Exception -> L87
        return;
    L87:
        e = move-exception;
        e.printStackTrace();
        return;
    L116:
        return;
    L115:
        return;
    L78:
        if (r13.equals(r114.f13337a.f13249i) == true) goto L80;
        goto L79
    }

    public final void r(String r8, String r10, int r11, boolean r12) {
        t(2);
        f5.a r13 = this.f14226m;
        if (r13 == null) goto L5;
        r13.c();
    L5:
        f r14 = this.f14234u;
        if (r14 == null) goto L10;
        if (r12 == false) goto L11;
        ((n) r14).b(r11, r8, r10);
        return;
    L11:
        return;
    }

    public final void s(Runnable r8) {
        this.f14232s.post(r8);
    }

    public final synchronized void t(int r8) {
        monitor-enter(this);
        this.f14228o = r8;     // Catch: Throwable -> L25
        String r10 = "";
        if (r8 != 1) goto L8;
        r10 = "连接中";
    L22:
        Logger.d("WsChannelSdk_ok", "目前状态:".concat(r10));     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L8:
        if (r8 != 2) goto L11;
        r10 = "连接失败";
        goto L22
    L11:
        if (r8 != 3) goto L14;
        r10 = "连接关闭";
        goto L22
    L14:
        if (r8 != 4) goto L17;
        r10 = "已连接";
        goto L22
    L17:
        if (r8 != 5) goto L20;
        r10 = "重试中";
        goto L22
    L20:
        if (r8 != 6) goto L22;
        r10 = "半关闭状态";
    L25:
        th = move-exception;
        throw th;
    }

    public final void u(String r8) {
        if (j6.c.b(this.f14224a) == true) goto L6;
        r(r8, "网络错误", 1, true);
        return;
    L6:
        monitor-enter(this);
        int r10 = this.f14228o;     // Catch: Throwable -> L19
        monitor-exit(this);
        if (r10 == 4) goto L26;
        if (r10 == 1) goto L27;
        q(r8);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        if (this.f14234u == null) goto L28;
        f r11 = this.f14234u;
        n r12 = (n) r11;
        r12.b(4, r8, Log.getStackTraceString(th));
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final void v(long r8, String r10, boolean r11) {
        WeakHandler r12 = this.f14232s;
        r12.removeMessages(1);
        if (j6.c.b(this.f14224a) == true) goto L7;
        r(r10, "网络错误", 1, r11);
        Logger.d("WsChannelSdk_ok", "网路不连通，取消重试");
        return;
    L7:
        if (this.f14230q == false) goto L11;
        Logger.d("WsChannelSdk_ok", "手动关闭");
        return;
    L11:
        if (r8 != (-1)) goto L13;
    L16:
        Logger.d("WsChannelSdk_ok", "retry finished ---> interval: " + r8 + " , url :" + r10);
        Logger.d("WsChannelSdk_ok", "这一轮重试结束，等待下一轮重试");
        Bundle r13 = new Bundle();
        r13.putString(BdimCategoryConstants.INTENT_KEY_METHOD, "tryReconnect");
        r13.putLong("interval", r8);
        r(r10, "重试失败", 2, r11);
        r10 = this.f14226m.b();
    L17:
        StringBuilder r14 = new StringBuilder("下一次重试时间: ");
        r14.append(DateFormat.getDateTimeInstance().format(new Date(System.currentTimeMillis() + r8)));
        Logger.d("WsChannelSdk_ok", r14.toString());
        Message r15 = new Message();
        r15.what = 1;
        r15.obj = r10;
        r12.sendMessageDelayed(r15, r8);
        return;
    L13:
        if (r5.f.b(r10) == true) goto L16;
        t(5);
        goto L17
    }
}
