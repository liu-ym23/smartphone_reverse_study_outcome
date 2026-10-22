package t7;

import android.content.Context;
import android.text.TextUtils;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import w7.f;
import x7.m;
import x7.n;

/* JADX INFO: loaded from: classes.dex */
public final class a implements t7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f12283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f12284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f12287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f12289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f12290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f12291i;

    /* JADX INFO: renamed from: t7.a$a, reason: collision with other inner class name */
    public class C0162a extends w7.a.AbstractC0188a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f12293b;

        public C0162a(a r8, String r10) {
            this.f12293b = r8;
            this.f12292a = r10;
        }

        public final List<String> a() {
            ConcurrentHashMap<String, r7.b> r8 = r7.c.f11537a;
            String r10 = this.f12292a;
            if (TextUtils.isEmpty(r10) == true) goto L7;
            ConcurrentHashMap<String, r7.b> r11 = r7.c.f11537a;
            if (r11.get(r10) == null) goto L7;
            return r11.get(r10).f();
        L7:
            return null;
        }

        public final int b() {
            ConcurrentHashMap<String, r7.b> r8 = r7.c.f11537a;
            String r10 = this.f12292a;
            if (TextUtils.isEmpty(r10) == true) goto L7;
            ConcurrentHashMap<String, r7.b> r11 = r7.c.f11537a;
            if (r11.get(r10) == null) goto L7;
            return r11.get(r10).g();
        L7:
            return 4;
        }

        public final String c() {
            a r8 = this.f12293b;
            if (TextUtils.isEmpty(r8.f12291i) == true) goto L11;
            List<String> r10 = a();
            if (r10 != null) goto L7;
            return null;
        L7:
            if (r10.size() > 0) goto L14;
            return null;
        L14:
            return "https://" + r8.f12291i + new URL(r10.get(0)).getPath();
        L18:
            return null;
        L11:
            return null;
        }

        public final long d() {
            ConcurrentHashMap<String, r7.b> r8 = r7.c.f11537a;
            String r10 = this.f12292a;
            if (TextUtils.isEmpty(r10) == true) goto L7;
            ConcurrentHashMap<String, r7.b> r11 = r7.c.f11537a;
            if (r11.get(r10) == null) goto L7;
            int r12 = r11.get(r10).i() * 1000;
        L9:
            return r12;
        L7:
            r12 = BWDLInnerConstant.DATA_LINK_TOUT;
            goto L9
        }
    }

    public class b implements w7.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f12295b;

        public b(a r8, String r10) {
            this.f12295b = r8;
            this.f12294a = r10;
        }
    }

    public class c extends w7.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f12296g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ a f12297h;

        public c(a r8, Context r10, C0162a r11, b r12, String r13) {
            this.f12297h = r8;
            this.f12296g = r13;
            super(r10, r11, r12);
        }

        @Override // w7.a
        public final boolean a(String r11, byte[] r12) {
            String r8 = this.f12296g;
            ConcurrentHashMap<String, t7.c> r10 = d.f12298a;
            if (r10.get(r8) == null) goto L63;
            a3.a r13 = r10.get(this.f12296g).d(r11, r12);
            a r14 = this.f12297h;
            r14.f12291i = null;
            if (r13 == null) goto L50;
            int r15 = r13.f51a;
            if (r15 <= 0) goto L50;
            r14.f12285c = false;
            if (r15 != 200) goto L45;
            JSONObject r16 = (JSONObject) r13.f52b;
            if (r16 == null) goto L45;
            if ("success".equals(r16.opt("message")) == false) goto L21;
            a r17 = this.f12297h;
            q7.b r18 = n.b(r17.f12287e).f13641d;
            r18.f10179h = true;
            r18.f10182k = 0;
            n.b(r17.f12287e).f13640c.f10196e = false;
            r17.f12286d = 0;
            r17.f12284b = 0;
            r17.f12288f = 0;
            r17.f12289g = 0;
            r17.f12290h = 0;
            String r19 = ((JSONObject) r13.f52b).optString("redirect");
            long r20 = ((JSONObject) r13.f52b).optLong("delay");
            if (TextUtils.isEmpty(r19) == true) goto L18;
            this.f12297h.f12291i = r19;
        L18:
            if (r20 <= 0) goto L20;
            a r110 = this.f12297h;
            r110.f12290h = r20 * 1000;
            m r111 = n.b(r110.f12287e);
            long r21 = r110.f12290h;
            q7.b r112 = r111.f13641d;
            r112.f10179h = false;
            r112.f10181j = System.currentTimeMillis();
            r112.f10182k = r21;
        L20:
            return true;
        L21:
            boolean r113 = "drop data".equals(((JSONObject) r13.f52b).opt("message"));
            boolean r22 = "drop all data".equals(((JSONObject) r13.f52b).opt("message"));
            String r23 = ((JSONObject) r13.f52b).optString("redirect");
            long r24 = ((JSONObject) r13.f52b).optLong("delay");
            if (TextUtils.isEmpty(r23) == true) goto L25;
            this.f12297h.f12291i = r23;
        L25:
            if (r24 <= 0) goto L27;
            a r114 = this.f12297h;
            r114.f12290h = r24 * 1000;
            m r25 = n.b(r114.f12287e);
            long r26 = r114.f12290h;
            q7.b r115 = r25.f13641d;
            r115.f10179h = false;
            r115.f10181j = System.currentTimeMillis();
            r115.f10182k = r26;
        L27:
            a r116 = this.f12297h;
            if (r113 == false) goto L30;
            r116.b();
            n.b(r116.f12287e).f13640c.f10196e = true;
        L31:
            if (r22 == false) goto L43;
            a r117 = this.f12297h;
            r117.b();
            n.b(r117.f12287e).f13640c.f10196e = true;
            m r118 = n.b(r117.f12287e);
            r118.getClass();
            q7.d r119 = r118.f13640c;     // Catch: Throwable -> L64
            LinkedList<s7.a> r27 = r119.f10193b;     // Catch: Throwable -> L64
            monitor-enter(r27);     // Catch: Throwable -> L64
            r119.f10193b.clear();     // Catch: Throwable -> L39
            monitor-exit(r27);     // Catch: Throwable -> L39
            r118.f13641d.b(2147483647L);     // Catch: Throwable -> L64
            goto L42
        L39:
            th = move-exception;
            throw th;     // Catch: Throwable -> L64
        L42:
            m r120 = n.b(r117.f12287e);
            r120.f13641d.f10180i = true;
            r120.f13660w = true;
        L43:
            return false;
        L30:
            n.b(r116.f12287e).f13640c.f10196e = false;
        L45:
            if (500 > r15) goto L63;
            if (r15 > 600) goto L63;
            r14.b();
            return false;
        L50:
            int r121 = r14.f12288f;
            if (r121 != 0) goto L53;
            long r28 = 30000;
        L62:
            r14.f12289g = r28;
            r14.f12288f++;
            m r122 = n.b(r14.f12287e);
            long r29 = r14.f12289g;
            q7.b r123 = r122.f13641d;
            r123.f10179h = false;
            r123.f10181j = System.currentTimeMillis();
            r123.f10182k = r29;
            this.f12297h.f12285c = true;
            goto L63
        L53:
            if (r121 != 1) goto L56;
            r28 = 60000;
            goto L62
        L56:
            if (r121 != 2) goto L59;
            r28 = 120000;
            goto L62
        L59:
            if (r121 != 3) goto L61;
            r28 = 240000;
            goto L62
        L61:
            r28 = 300000;
        L63:
            return false;
        }
    }

    public a(Context r8, String r10) {
        this.f12287e = r10;
        C0162a r11 = new C0162a(this, r10);
        b r12 = new b(this, r10);
        this.f12283a = new c(this, r8.getApplicationContext(), r11, r12, r10);
    }

    @Override // t7.b
    public final boolean a(String r8) {
        c r10 = this.f12283a;
        r10.getClass();
        if (r8 != null) goto L41;
    L9:
        byte[] r11 = null;
    L10:
        w7.d r12 = r10.f13031c;
        String r13 = r10.f13029a;
        boolean r14 = false;
        if (r12.f13045c.get() == true) goto L40;
        if (r11 == null) goto L40;
        if (r11.length <= 0) goto L40;
        if (((w7.a) r12.f13043a.get(r13)) == null) goto L40;
        LinkedList<w7.b> r15 = r12.f13046d;
        monitor-enter(r15);
    L37:
        th = move-exception;
        throw th;
    L22:
        if (r12.f13045c.get() == false) goto L25;
    L32:
        monitor-exit(r15);     // Catch: Throwable -> L37
        goto L40
    L25:
        if (r12.f13046d.size() < 2000) goto L27;
        r12.f13046d.poll();     // Catch: Throwable -> L37
    L27:
        boolean r16 = r12.f13046d.add(new w7.b(r13, r11));     // Catch: Throwable -> L37
        f r17 = r12.f13044b;     // Catch: Throwable -> L37
        Object r18 = r17.f13051b;     // Catch: Throwable -> L37
        monitor-enter(r18);     // Catch: Throwable -> L37
        r17.f13051b.notify();     // Catch: Throwable -> L34
        monitor-exit(r18);     // Catch: Throwable -> L34
        r14 = r16;
        goto L32
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L40:
        return r14;
    L41:
    L8:
        r11 = r8.getBytes();
        goto L10
    L5:
        if (r8.length() <= 0) goto L9;
        r11 = r8.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L8
        goto L10
    }

    public final void b() {
        int r8 = this.f12286d;
        if (r8 != 0) goto L5;
        long r10 = 300000;
    L8:
        this.f12284b = r10;
        this.f12286d++;
        m r11 = n.b(this.f12287e);
        long r12 = this.f12284b;
        q7.b r13 = r11.f13641d;
        r13.f10179h = false;
        r13.f10181j = System.currentTimeMillis();
        r13.f10182k = r12;
        return;
    L5:
        if (r8 != 1) goto L7;
        r10 = 900000;
        goto L8
    L7:
        r10 = 1800000;
        goto L8
    }
}
