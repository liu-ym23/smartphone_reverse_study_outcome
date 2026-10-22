package gb;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DownloadInfo f9077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f9081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, a> f9083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f9084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f9085i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9086j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f9087k;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f9089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f9090c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f9091d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f9092e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f9093f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f9094g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f9095h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f9096i;

        public a(i r10) {
        }

        static /* synthetic */ boolean a(a r10) {
            return r10.f9088a;
        }

        static /* synthetic */ boolean b(a r10, boolean r11) {
            r10.f9088a = r11;
            return r11;
        }

        static /* synthetic */ long c(a r10) {
            return r10.f9096i;
        }

        static /* synthetic */ long d(a r10, long r11) {
            r10.f9096i = r11;
            return r11;
        }

        static /* synthetic */ int e(a r10) {
            return r10.f9095h;
        }

        static /* synthetic */ int f(a r10) {
            int r11 = r10.f9095h + 1;
            r10.f9095h = r11;
            return r11;
        }

        static /* synthetic */ int g(a r10) {
            int r11 = r10.f9095h - 1;
            r10.f9095h = r11;
            return r11;
        }

        static /* synthetic */ int h(a r10) {
            return r10.f9093f;
        }

        static /* synthetic */ int i(a r10, int r11) {
            r10.f9093f = r11;
            return r11;
        }

        static /* synthetic */ int j(a r10) {
            return r10.f9094g;
        }

        static /* synthetic */ int k(a r10, int r11) {
            r10.f9094g = r11;
            return r11;
        }

        static /* synthetic */ int l(a r10) {
            return r10.f9089b;
        }

        static /* synthetic */ int m(a r10, int r11) {
            r10.f9089b = r11;
            return r11;
        }

        static /* synthetic */ String n(a r10) {
            return r10.f9090c;
        }

        static /* synthetic */ String o(a r10, String r11) {
            r10.f9090c = r11;
            return r11;
        }

        static /* synthetic */ long p(a r10) {
            return r10.f9092e;
        }

        static /* synthetic */ long q(a r10, long r11) {
            r10.f9092e = r11;
            return r11;
        }

        static /* synthetic */ long r(a r10) {
            return r10.f9091d;
        }

        static /* synthetic */ long s(a r10, long r11) {
            r10.f9091d = r11;
            return r11;
        }
    }

    public i(DownloadInfo r10, int r11) {
        this.f9083g = new LinkedHashMap();
        this.f9086j = 0;
        this.f9087k = 0;
        this.f9077a = r10;
        r10.setPcdnStats(null);
        this.f9082f = r11;
    }

    private void b(long r10, boolean r11, long r12) {
        if (r11 == false) goto L8;
        int r13 = this.f9087k - 1;
        this.f9087k = r13;
        this.f9078b += r12;
        this.f9080d += r10 - this.f9084h;
        if (r13 != 0) goto L7;
        this.f9084h = 0;
        return;
    L7:
        this.f9084h = r10;
        return;
    L8:
        int r14 = this.f9086j - 1;
        this.f9086j = r14;
        this.f9079c += r12;
        this.f9081e += r10 - this.f9085i;
        if (r14 != 0) goto L11;
        this.f9085i = 0;
        return;
    L11:
        this.f9085i = r10;
    }

    private void c(boolean r10) {
        if (r10 == false) goto L9;
        if (this.f9084h > 0) goto L7;
        this.f9084h = System.currentTimeMillis();
    L7:
        this.f9087k++;
        return;
    L9:
        if (this.f9085i > 0) goto L11;
        this.f9085i = System.currentTimeMillis();
    L11:
        this.f9086j++;
    }

    private void d(long r10, String r11, nb.h r12, Throwable r13, boolean r14, long r15) {
        a r16 = this.f9083g.get(r11);
        if (a.h(r16) != 0) goto L16;
        if (r12 == null) goto L16;
        if ((r12 instanceof nb.a) == false) goto L16;
        nb.a r17 = (nb.a) r12;
        if (r17.j() == true) goto L15;
        a.i(r16, 4);
        String r18 = r17.h();
        if (TextUtils.isEmpty(r18) == true) goto L16;
        JSONObject r19 = new JSONObject(r18);     // Catch: Throwable -> L13
        a.i(r16, r19.optJSONObject("response").optInt("connection_info"));     // Catch: Throwable -> L13
        a.k(r16, r19.optJSONObject("timing").optJSONObject("detailed_duration").optInt(ICronetClient.KEY_TTFB));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L15:
        a.i(r16, 1);
    L16:
        if (r13 == null) goto L23;
        if (r14 == true) goto L23;
        if ((r13 instanceof BaseException) == false) goto L21;
        int r20 = ((BaseException) r13).getErrorCode();
    L22:
        a.m(r16, r20);
        a.o(r16, r13.toString());
    L28:
        a.g(r16);
        a.q(r16, a.p(r16) + (r10 - a.c(r16)));
        if (a.e(r16) != 0) goto L31;
        r10 = 0;
    L31:
        a.d(r16, r10);
        a.s(r16, a.r(r16) + r15);
        this.f9083g.put(r11, r16);
        return;
    L21:
        r20 = 1000;
    L23:
        if (r12 == null) goto L28;
        a.m(r16, r12.c());     // Catch: Throwable -> L26
        a.o(r16, "");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }

    private void f(String r10, boolean r11) {
        a r12 = this.f9083g.get(r10);
        if (r12 != null) goto L6;
        r12 = new a(this);
        a.b(r12, r11);
    L6:
        if (a.c(r12) > 0) goto L8;
        a.d(r12, System.currentTimeMillis());
    L8:
        a.f(r12);
        this.f9083g.put(r10, r12);
    }

    public void a(String r15, long r16, boolean r18, boolean r19, nb.h r20, bb.d r21, Throwable r22) {
        monitor-enter(this);
        long r10 = 0;
        if (r21 != null) goto L12;
    L6:
        long r11 = r10;
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L9
        d(r12, r15, r20, r22, r19, r11);     // Catch: Throwable -> L9
        b(r12, r18, r11);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        r10 = r21.h() - r16;     // Catch: Throwable -> L9
        goto L6
    }

    public void e(String r10, boolean r11) {
        monitor-enter(this);
        f(r10, r11);     // Catch: Throwable -> L6
        c(r11);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void g() {
        monitor-enter(this);
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L9
        r10.put("bus_id", this.f9077a.getMonitorScene());     // Catch: Throwable -> L9
        r10.put("pcdn_size", this.f9078b);     // Catch: Throwable -> L9
        r10.put("pcdn_dur", this.f9080d);     // Catch: Throwable -> L9
        r10.put("cdn_size", this.f9079c);     // Catch: Throwable -> L9
        r10.put("cdn_dur", this.f9081e);     // Catch: Throwable -> L9
        r10.put("retry_times_max", this.f9082f);     // Catch: Throwable -> L9
        JSONArray r11 = new JSONArray();     // Catch: Throwable -> L9
        Iterator<Map.Entry<String, a>> r12 = this.f9083g.entrySet().iterator();     // Catch: Throwable -> L9
    L5:
        if (r12.hasNext() == false) goto L7;
        Map.Entry<String, a> r13 = r12.next();     // Catch: Throwable -> L9
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L9
        r14.put("url", r13.getKey());     // Catch: Throwable -> L9
        a r15 = r13.getValue();     // Catch: Throwable -> L9
        r14.put("is_pcdn", a.a(r15));     // Catch: Throwable -> L9
        r14.put("code", a.l(r15));     // Catch: Throwable -> L9
        r14.put("size", a.r(r15));     // Catch: Throwable -> L9
        r14.put("duration", a.p(r15));     // Catch: Throwable -> L9
        r14.put("protocol", a.h(r15));     // Catch: Throwable -> L9
        r14.put(ICronetClient.KEY_TTFB, a.j(r15));     // Catch: Throwable -> L9
        r14.put(NotificationCompat.CATEGORY_ERROR, a.n(r15));     // Catch: Throwable -> L9
        r11.put(r14);     // Catch: Throwable -> L9
        goto L5
    L7:
        r10.put("urls", r11);     // Catch: Throwable -> L9
        this.f9077a.setPcdnStats(r10);     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
