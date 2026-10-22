package a7;

import android.net.Uri;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.ttnet.org.chromium.net.impl.NetworkExceptionImpl;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements SsCall, IMetricsCollect, IRequestInfo, WeakHandler.IHandler {
    public static final HandlerThread F = null;
    public static final Class G = null;
    public static boolean H;
    public final CountDownLatch A;
    public final WeakHandler B;
    public final long C;
    public long D;
    public String E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RetrofitMetrics f60a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f61b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f62m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f63n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Request f64o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f65p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f66q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final w6.a f67r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f68s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f69t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f70u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f71v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile AtomicInteger f72w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CopyOnWriteArrayList f73x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile HttpURLConnection f74y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final CopyOnWriteArrayList f75z;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f76a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IOException f77b;

        public a(String r8, IOException r10) {
            this.f76a = r8;
            this.f77b = r10;
        }
    }

    static {
        F = new HandlerThread("Concurrent-Handler");
        H = false;
        int r8 = NetworkExceptionImpl.f6743a;     // Catch: ClassNotFoundException -> L5
        G = NetworkExceptionImpl.class;     // Catch: ClassNotFoundException -> L5
    L7:
        F.start();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public b(Request r11, List<String> r12, String r13) {
        this.f61b = 0;
        this.f63n = false;
        this.f67r = w6.a.E.a();
        this.f70u = new ArrayList();
        this.f71v = new Object();
        this.f72w = new AtomicInteger(0);
        this.f73x = new CopyOnWriteArrayList();
        this.f74y = null;
        this.f75z = new CopyOnWriteArrayList();
        this.A = new CountDownLatch(1);
        this.B = new WeakHandler(F.getLooper(), this);
        Logger.d("b", "Request url: " + r11.getUrl());
        this.f64o = r11;
        this.f60a = r11.getMetrics();
        String r8 = r11.getUrl();
        this.f65p = r8;
        Uri r10 = Uri.parse(r8);
        String r14 = r10.getScheme();
        String r15 = defpackage.a.f(r14, "://", r10.getHost());
        String r16 = r10.getQuery();
        Iterator<String> r17 = r12.iterator();
        int r18 = 0;
    L4:
        if (r17.hasNext() == false) goto L15;
        String r19 = this.f65p.replaceFirst(r15, defpackage.a.f(r14, "://", r17.next()));
        if (TextUtils.isEmpty(r16) == true) goto L14;
        if (r16.contains("concurrent=") == true) goto L10;
        r19 = r19 + "&concurrent=" + r18;
    L10:
        if (r18 <= 0) goto L14;
        if (r16.contains("is_retry=") == true) goto L14;
        r19 = defpackage.a.e(r19, "&is_retry=1");
    L14:
        r18 = r18 + 1;
        this.f70u.add(r19);
        goto L4
    L15:
        String r110 = UUID.randomUUID().toString();
        this.f68s = r110;
        this.f69t = r13;
        long r20 = f.c().f96c;
        this.C = r20;
        w6.e.d r111 = w6.e.f13020a;
        this.D = 30000;
        if ((r11.getExtraInfo() instanceof w6.b) == false) goto L18;
        ((w6.b) r11.getExtraInfo()).getClass();
    L18:
        this.D += 1000;
        Logger.d("b", "Request max wait time milliseconds: " + this.D + ", connect interval milliseconds: " + (r20 * 1000));
        RetrofitMetrics r112 = this.f60a;
        if (r112 == null) goto L21;
        r112.transactionId = r110;
        r112.isConcurrent = true;
        w6.a r113 = this.f67r;
        r113.f12992c = r112.appLevelRequestStart;
        r113.f12993d = r112.beforeAllInterceptors;
    L21:
        long r114 = System.currentTimeMillis();
        this.f66q = r114;
        w6.a r21 = this.f67r;
        r21.f12994e = r114;
        r21.f13009t = 0;
        if (this.f64o.isResponseStreaming() == false) goto L24;
        this.f67r.f13014y = true;
    L26:
        if ((r11.getExtraInfo() instanceof w6.b) == false) goto L34;
        this.f67r.f12991b = (T) r11.getExtraInfo();
        this.f67r.f12991b.getClass();
        return;
    L34:
        return;
    L24:
        this.f67r.f13014y = false;
        goto L26
    }

    public final void a() {
        Logger.d("b", "cleanupMessagesAndPendingConnections");
        this.B.removeCallbacksAndMessages(null);
        Object r8 = this.f71v;
        monitor-enter(r8);
        CopyOnWriteArrayList r10 = this.f73x;     // Catch: Throwable -> L17
        if (r10 != null) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L17
        return;
    L8:
        Iterator r11 = r10.iterator();     // Catch: Throwable -> L17
    L10:
        if (r11.hasNext() == false) goto L14;
        HttpURLConnection r12 = (HttpURLConnection) r11.next();     // Catch: Throwable -> L17
        if (r12 == null) goto L10;
        this.f75z.add(new a(r12.getURL().getHost(), new IOException("Connection disconnected because of winner connection has decided.")));     // Catch: Throwable -> L17
        r12.disconnect();     // Catch: Throwable -> L17
        this.f73x.remove(r12);     // Catch: Throwable -> L17
        goto L10
    L14:
        this.f73x = null;     // Catch: Throwable -> L17
        monitor-exit(r8);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public final void b() {
        v6.c.a r8 = v6.c.a.f12739n;
        androidx.activity.d r10 = new androidx.activity.d(this, 12);
        boolean r11 = this.f67r.f13014y;
        v6.a r12 = new v6.a(r8, 0, r10);
        if (v6.e.f12751c == null) goto L5;
    L14:
        v6.e r13 = v6.e.f12751c;
        monitor-enter(r13);
        v6.d.f12742p.a(r12);     // Catch: Throwable -> L20
        monitor-exit(r13);
        Message r14 = Message.obtain();
        r14.what = 0;
        r14.obj = this;
        long r15 = this.C * 1000;
        this.B.sendMessageDelayed(r14, r15);
        return;
    L20:
        th = move-exception;
        throw th;
    L5:
        monitor-enter(v6.e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (v6.e.f12751c != null) goto L9;
        v6.e.f12751c = new v6.e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(v6.e.class);     // Catch: Throwable -> L11
        goto L14
    }

    public final IOException c(Exception r10, String r11, HttpURLConnection r12) {
        if ((r10 instanceof IOException) == false) goto L11;
        if (r10.getMessage() == null) goto L11;
        if (r10.getMessage().startsWith("request canceled") == false) goto L11;
        return (IOException) r10;
    L11:
        if (TextUtils.isEmpty(r11) == false) goto L13;
        r11 = this.f65p;
    L13:
        i.p(r11, this.f66q, this.f67r, this.f62m, r10, r12, this.f60a);
        i.b(r10.getMessage());     // Catch: b7.c -> L17
        return new c(r10);
    L17:
        e = move-exception;
        return e;
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public final void cancel() {
        this.A.countDown();
        a();
        Object r8 = this.f71v;
        monitor-enter(r8);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (this.f74y == null) goto L30;
        this.f74y.disconnect();     // Catch: Throwable -> L27
        if (this.f64o.isResponseStreaming() == false) goto L30;
        if (this.f63n == true) goto L30;
        doCollect();     // Catch: Throwable -> L27
        w6.a r10 = this.f67r;     // Catch: Throwable -> L27
        r10.D = i.h(this.E);     // Catch: Throwable -> L27
        w6.a r11 = this.f67r;     // Catch: Throwable -> L27
        r11.f12997h = System.currentTimeMillis();     // Catch: Throwable -> L27
        w6.a r12 = this.f67r;     // Catch: Throwable -> L27
        T r13 = r12.f12991b;     // Catch: Throwable -> L27
        if (r13 != 0) goto L13;
    L14:
        long r14 = r12.f12997h;     // Catch: Throwable -> L27
        long r15 = this.f66q;     // Catch: Throwable -> L27
        w6.e.d(r14 - r15, r15, this.f64o.getUrl(), this.f62m, this.f67r);     // Catch: Throwable -> L27
    L16:
        if (j.f117a == null) goto L18;
    L29:
        j r16 = j.f117a;     // Catch: Throwable -> L27
        String r17 = this.f64o.getUrl();     // Catch: Throwable -> L27
        w6.a r18 = this.f67r;     // Catch: Throwable -> L27
        long r19 = r18.f13007r;     // Catch: Throwable -> L27
        long r20 = r18.f13008s;     // Catch: Throwable -> L27
        r16.a(r17, r18.D, r18.f13012w, r19, r20);     // Catch: Throwable -> L27
        goto L30
    L18:
        monitor-enter(j.class);     // Catch: Throwable -> L27
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L20:
        if (j.f117a != null) goto L22;
        j.f117a = new j();     // Catch: Throwable -> L24
    L22:
        monitor-exit(j.class);     // Catch: Throwable -> L24
    L13:
        if (r13.f13017b == false) goto L16;
    L30:
        monitor-exit(r8);     // Catch: Throwable -> L27
        this.f63n = true;
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public final void doCollect() {
        i.k(this.f74y, this.f67r, this.f60a);
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public final Response execute() {
        RetrofitMetrics r8 = this.f60a;
        if (r8 == null) goto L6;
        r8.callExecuteStartTime = System.currentTimeMillis();
    L6:
        if (this.f63n == true) goto L108;
        Logger.d("b", "Execute url: " + this.f65p);
        a7.a r10 = null;
        i.b(null);
        b();
        this.A.await(this.D, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L100 InterruptedException -> L102
        this.A.countDown();     // Catch: Throwable -> L100 InterruptedException -> L102
        Object r11 = this.f71v;     // Catch: Throwable -> L100 InterruptedException -> L102
        monitor-enter(r11);     // Catch: Throwable -> L100 InterruptedException -> L102
        boolean r12 = false;
        if (this.f74y == null) goto L13;
        CopyOnWriteArrayList r13 = this.f73x;     // Catch: Throwable -> L97
        if (r13 == null) goto L26;
        r13.remove(this.f74y);     // Catch: Throwable -> L97
    L26:
        monitor-exit(r11);     // Catch: Throwable -> L97
        a();
        Object r14 = this.f71v;
        monitor-enter(r14);
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L94
        Iterator r16 = this.f75z.iterator();     // Catch: Throwable -> L94
    L31:
        if (r16.hasNext() == false) goto L35;
        a r17 = (a) r16.next();     // Catch: Throwable -> L94
        r17.getClass();     // Catch: Throwable -> L94
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L94
        r18.put("domain", r17.f76a);     // Catch: JSONException -> L109 Throwable -> L94
        r18.put("exception", r17.f77b.getMessage());     // Catch: JSONException -> L109 Throwable -> L94
    L34:
        r15.add(r18);     // Catch: Throwable -> L94
        goto L31
    L35:
        this.f60a.connectionAttempts = r15;     // Catch: Throwable -> L94
        monitor-exit(r14);     // Catch: Throwable -> L94
        f.c().d(this.f69t, true);     // Catch: Throwable -> L79 Exception -> L81
        int r19 = this.f74y.getResponseCode();     // Catch: Throwable -> L79 Exception -> L81
        i.t(this.f74y, this.f67r, r19);     // Catch: Throwable -> L79 Exception -> L81
        w6.a r20 = this.f67r;     // Catch: Throwable -> L79 Exception -> L81
        if (r20.f13015z == false) goto L41;
        H = true;     // Catch: Throwable -> L79 Exception -> L81
    L41:
        r20.f12995f = System.currentTimeMillis();     // Catch: Throwable -> L79 Exception -> L81
        this.f67r.f12998i = -1;     // Catch: Throwable -> L79 Exception -> L81
        this.f62m = i.o(this.f74y, this.f67r);     // Catch: Throwable -> L79 Exception -> L81
        this.E = i.i("Content-Type", this.f74y);     // Catch: Throwable -> L79 Exception -> L81
        if (this.f64o.isResponseStreaming() == true) goto L44;
        int r21 = this.f64o.getMaxLength();     // Catch: Throwable -> L79 Exception -> L81
        this.f67r.D = i.h(this.E);     // Catch: Throwable -> L79 Exception -> L81
        TypedInput r22 = new TypedByteArray(this.E, i.r(this.f65p, r21, this.f74y, this.f66q, this.f67r, this.f62m, r19, this.f60a), new String[0]);     // Catch: Throwable -> L79 Exception -> L81
    L70:
        Response r23 = new Response(this.f65p, r19, this.f74y.getResponseMessage(), i.e(this.f74y, H), r22);     // Catch: Throwable -> L79 Exception -> L81
        r23.setExtraInfo(this.f67r);     // Catch: Throwable -> L79 Exception -> L81
        if (this.f64o.isResponseStreaming() == true) goto L78;
        HttpURLConnection r110 = this.f74y;
        if (r110 == null) goto L78;
        r110.disconnect();
    L78:
        return r23;
    L44:
        if (r19 >= 200) goto L46;
    L55:
        String r24 = this.f74y.getResponseMessage();     // Catch: Throwable -> L79 Exception -> L81
        int r25 = this.f64o.getMaxLength();     // Catch: Throwable -> L62
        InputStream r26 = this.f74y.getInputStream();     // Catch: Exception -> L59 Throwable -> L62
    L58:
        InputStream r27 = r26;
        this.f74y.getHeaderFields();     // Catch: Throwable -> L62
        i.q(false, r25, r27, this.E, this.f65p, this.f60a);     // Catch: Throwable -> L62
    L67:
        this.f74y.disconnect();     // Catch: Throwable -> L79 Exception -> L81
        throw new b7.b(r19, r24);     // Catch: Throwable -> L79 Exception -> L81
    L59:
        r26 = this.f74y.getErrorStream();     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L79 Exception -> L81
        StringBuilder r28 = new StringBuilder();     // Catch: Throwable -> L79 Exception -> L81
        r28.append("reason = ");     // Catch: Throwable -> L79 Exception -> L81
        if (r24 != null) goto L66;
        r24 = "";
    L66:
        r28.append(r24);     // Catch: Throwable -> L79 Exception -> L81
        r28.append("  exception = ");     // Catch: Throwable -> L79 Exception -> L81
        r28.append(th.getMessage());     // Catch: Throwable -> L79 Exception -> L81
        r24 = r28.toString();     // Catch: Throwable -> L79 Exception -> L81
        goto L67
    L46:
        if (r19 >= 300) goto L55;
        HttpURLConnection r29 = this.f74y;     // Catch: Throwable -> L79 Exception -> L81
        if (r29 != null) goto L51;
    L54:
        r22 = r10;
        goto L70
    L51:
        if (r29.getContentLength() != 0) goto L53;
        cancel();     // Catch: Throwable -> L79 Exception -> L81
        goto L54
    L53:
        r10 = new a7.a(this, r29);     // Catch: Throwable -> L79 Exception -> L81
    L81:
        e = move-exception;
    L84:
        th = th;
        r12 = true;
    L87:
        if (this.f64o.isResponseStreaming() == false) goto L89;
        if (r12 == true) goto L89;
    L93:
        throw th;
    L89:
        HttpURLConnection r111 = this.f74y;
        if (r111 == null) goto L93;
        r111.disconnect();
        goto L93
    L83:
        throw c(e, this.f65p, this.f74y);     // Catch: Throwable -> L84
    L79:
        th = th;
    L94:
        th = move-exception;
        throw th;
    L13:
        if (this.f63n == true) goto L15;
        f.c().d(this.f69t, false);     // Catch: Throwable -> L97
    L15:
        CopyOnWriteArrayList r30 = this.f75z;     // Catch: Throwable -> L97
        if (r30 == null) goto L22;
        if (r30.size() <= 0) goto L22;
        throw ((a) this.f75z.get(0)).f77b;     // Catch: Throwable -> L97
    L22:
        throw c(new IOException("All urls have been tried and timed out by max wait time."), this.f65p, this.f74y);     // Catch: Throwable -> L97
    L97:
        th = move-exception;
        throw th;     // Catch: Throwable -> L100 InterruptedException -> L102
    L102:
        e = move-exception;
        throw c(e, this.f65p, this.f74y);     // Catch: Throwable -> L100
    L100:
        th = move-exception;
        a();
        throw th;
    L108:
        throw new IOException("request canceled");
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public final Request getRequest() {
        return this.f64o;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public final Object getRequestInfo() {
        return this.f67r;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r8) {
        if (r8 == null) goto L23;
        Object r10 = r8.obj;
        if ((r10 instanceof b) == false) goto L24;
        int r11 = r8.what;     // Catch: Throwable -> L16
        if (r11 != 0) goto L9;
        ((b) r10).b();     // Catch: Throwable -> L16
    L19:
        return;
    L9:
        if (r11 != 1) goto L19;
        b r12 = (b) r10;     // Catch: Throwable -> L16
        WeakHandler r13 = r12.B;     // Catch: Throwable -> L16
        if (r13.obtainMessage(0) == null) goto L19;
        r13.removeMessages(0);     // Catch: Throwable -> L16
        r12.b();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L24:
        return;
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public final boolean setThrottleNetSpeed(long r8) {
        this.f61b = r8;
        if (this.f74y != null) goto L11;
    L10:
        return true;
    L11:
        Reflect.on(this.f74y).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r8)});     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }
}
