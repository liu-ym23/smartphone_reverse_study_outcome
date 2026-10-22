package u;

import android.os.Build;
import androidx.annotation.NonNull;
import com.bytedance.apm.core.IDynamicParams;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.impl.DefaultTTNetImpl;
import com.bytedance.apm.util.q;
import com.bytedance.apm6.foundation.UnSampleListener;
import com.bytedance.apm6.monitor.MonitorableInterceptor;
import com.bytedance.services.apm.api.IHttpService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;
import t4.h;
import t4.i;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private final d0.b A;
    private final d0.a B;
    private final d0.f C;
    private final ExecutorService D;
    private final t4.e E;
    private final String F;
    private final d0.g G;
    private final d0.e H;
    private final d0.c I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final d.a f13034J;
    private final h K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f13035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f13036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f13037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f13038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d0.d f13039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f13040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f13041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f13042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f13043i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f13044j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f13045k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f13046l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f13047m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f13048n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f13049o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f13050p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f13051q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f13052r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f13053s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f13054t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final JSONObject f13055u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final IDynamicParams f13056v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final IQueryParams f13057w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final IHttpService f13058x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Set<i> f13059y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final long f13060z;

    static /* synthetic */ class a {
    }

    public static final class b {
        d0.f A;
        d0.g B;
        d0.c C;
        IQueryParams D;
        ExecutorService E;
        d0.d F;
        t4.e G;
        e0.c H;
        UnSampleListener I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        h f13061J;
        String K;
        d0.e L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f13062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f13063b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f13064c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f13065d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f13066e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f13067f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f13068g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f13069h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f13070i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f13071j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f13072k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f13073l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f13074m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f13075n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f13076o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        List<String> f13077p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        List<String> f13078q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        List<String> f13079r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        List<String> f13080s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        JSONObject f13081t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        IDynamicParams f13082u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        IHttpService f13083v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        Set<i> f13084w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        long f13085x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        d0.b f13086y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        d0.a f13087z;

        class a implements t4.e {
            a(b r10) {
            }

            @Override // t4.e
            public byte[] encrypt(byte[] r10) {
                return g3.b.a(r10, r10.length);
            }
        }

        b() {
            this.f13066e = false;
            this.f13072k = true;
            this.f13077p = v.a.f13152a;
            this.f13078q = v.a.f13153b;
            this.f13079r = v.a.f13155d;
            this.f13080s = v.a.f13154c;
            this.f13081t = new JSONObject();
            this.f13084w = new HashSet();
            this.f13085x = 0;
            this.f13069h = 2500;
            this.G = new a(this);
            this.f13065d = g.f13115a;
            this.f13070i = g.f13116b;
            this.f13071j = g.f13117c;
        }

        public b a(int r10) {
            return l("aid", r10);
        }

        public b b(String r10) {
            return m("app_version", r10);
        }

        public b c(boolean r10) {
            if (r10 == true) goto L4;
        L6:
            boolean r11 = false;
        L7:
            this.f13074m = r11;
            return this;
        L4:
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r11 = true;
            goto L7
        }

        public b d(boolean r10) {
            if (r10 == true) goto L4;
        L6:
            boolean r11 = false;
        L7:
            this.f13065d = r11;
            return this;
        L4:
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r11 = true;
            goto L7
        }

        public c e() {
            q.a(this.f13081t.optString("aid"), "aid");
            q.c(this.f13082u, "dynamicParams");
            q.b(this.f13081t.optString("app_version"), "app_version");
            q.b(this.f13081t.optString("update_version_code"), "update_version_code");
            q.b(this.f13081t.optString("device_id"), "device_id");
            q.b(this.f13081t.optString("release_build"), "release_build");
            return new c(this, null);
        }

        public b f(String r10) {
            return m("channel", r10);
        }

        public b g(String r10) {
            return m("device_id", r10);
        }

        public b h(IDynamicParams r10) {
            this.f13082u = r10;
            return this;
        }

        public b i(boolean r10) {
            this.f13064c = r10;
            return this;
        }

        public b j(boolean r10) {
            this.f13072k = r10;
            return this;
        }

        public b k(boolean r10) {
            this.f13071j = r10;
            return this;
        }

        public b l(String r10, int r11) {
            this.f13081t.put(r10, r11);     // Catch: JSONException -> L4
        L3:
            return this;
        }

        public b m(String r10, String r11) {
            this.f13081t.put(r10, r11);     // Catch: JSONException -> L4
        L3:
            return this;
        }

        public b n(String r10) {
            return m("update_version_code", r10);
        }

        public b o(boolean r10) {
            if (r10 == false) goto L4;
            this.f13083v = new DefaultTTNetImpl();
        L4:
            return this;
        }

        public b p(i r10) {
            if (r10 != null) goto L4;
        L9:
            return this;
        L4:
            if (com.bytedance.apm.d.I() == false) goto L6;
        L8:
            this.f13084w.add(r10);
            goto L9
        L6:
            if (r10.isOnlyMainProcess() == false) goto L8;
            return this;
        }
    }

    private c(b r10) {
        this.f13055u = r10.f13081t;
        this.f13052r = r10.f13062a;
        this.f13053s = r10.f13063b;
        this.f13056v = r10.f13082u;
        this.f13035a = r10.f13077p;
        this.f13058x = r10.f13083v;
        this.f13041g = r10.f13072k;
        this.f13040f = r10.f13071j;
        this.f13043i = r10.f13065d;
        this.f13044j = r10.f13066e;
        this.f13045k = r10.f13067f;
        this.f13046l = r10.f13068g;
        this.f13047m = r10.f13069h;
        this.f13049o = r10.f13074m;
        this.f13050p = r10.f13075n;
        this.f13051q = r10.f13076o;
        this.f13059y = r10.f13084w;
        this.f13036b = r10.f13078q;
        this.f13037c = r10.f13079r;
        this.f13038d = r10.f13080s;
        this.f13060z = r10.f13085x;
        this.f13048n = r10.f13070i;
        this.f13042h = r10.f13073l;
        this.B = r10.f13087z;
        this.A = r10.f13086y;
        this.C = r10.A;
        this.D = r10.E;
        this.f13039e = r10.F;
        this.E = r10.G;
        this.f13054t = r10.f13064c;
        this.F = r10.K;
        this.G = r10.B;
        this.H = r10.L;
        this.f13057w = r10.D;
        this.I = r10.C;
        this.K = r10.f13061J;
        e0.a.h(r10.H);
        e0.a.j(r10.I);
    }

    /* synthetic */ c(b r10, a r11) {
        this(r10);
    }

    public static b a() {
        return new b();
    }

    public boolean A() {
        return this.f13044j;
    }

    public boolean B() {
        return this.f13053s;
    }

    public boolean C() {
        return this.f13052r;
    }

    public boolean D() {
        return this.f13046l;
    }

    public boolean E() {
        return this.f13051q;
    }

    public boolean F() {
        return this.f13049o;
    }

    public boolean G() {
        return this.f13043i;
    }

    public boolean H() {
        return this.f13045k;
    }

    public void I(List<String> r10) {
        this.f13036b = r10;
    }

    public void J(List<String> r10) {
        this.f13037c = r10;
    }

    public void K(List<String> r10) {
        this.f13035a = r10;
    }

    public String b() {
        return this.F;
    }

    public d0.a c() {
        return this.B;
    }

    public d0.b d() {
        return this.A;
    }

    public d0.c e() {
        return this.I;
    }

    public long f() {
        return this.f13047m;
    }

    public List<String> g() {
        return this.f13036b;
    }

    public long h() {
        return this.f13060z;
    }

    @NonNull
    public IDynamicParams i() {
        return this.f13056v;
    }

    public t4.e j() {
        return this.E;
    }

    public List<String> k() {
        return this.f13037c;
    }

    public ExecutorService l() {
        return this.D;
    }

    public JSONObject m() {
        return this.f13055u;
    }

    public IHttpService n() {
        return this.f13058x;
    }

    public MonitorableInterceptor o() {
        return this.f13034J;
    }

    public d0.d p() {
        return this.f13039e;
    }

    public boolean q() {
        return this.f13054t;
    }

    public d0.e r() {
        return this.H;
    }

    public IQueryParams s() {
        return this.f13057w;
    }

    public h t() {
        return this.K;
    }

    public String toString() {
        return "ApmStartConfig{mSlardarConfigUrls=" + this.f13035a + ", mDefaultLogReportUrls=" + this.f13036b + ", mExceptionLogReportUrls=" + this.f13037c + ", mTraceReportUrls=" + this.f13038d + ", mMemoryReachTopListener=" + this.f13039e + ", mWithExceptionTrafficDetect=" + this.f13040f + ", mEnableTrafficDetect=" + this.f13041g + ", mWithWebViewTrafficDetect=" + this.f13042h + ", mWithBlockDetect=" + this.f13043i + ", mEnableBlockOnlySampled=" + this.f13044j + ", mWithSeriousBlockDetect=" + this.f13045k + ", mBlockThresholdMs=" + this.f13047m + ", mWithTemperatureDetect=" + this.f13048n + ", mWithBatteryDetect=" + this.f13049o + ", mEnableBatteryLocalRecord=" + this.f13050p + ", mEnableTemperatureLocalRecord=" + this.f13051q + ", mForceUpdateSlardarSetting=" + this.f13052r + ", mEnableMultiProcessRequestSetting=" + this.f13053s + ", mNetMonitorWithDisconnected=" + this.f13054t + ", mHeader=" + this.f13055u + ", mDynamicParams=" + this.f13056v + ", mQueryParams=" + this.f13057w + ", mHttpService=" + this.f13058x + ", mWidgets=" + this.f13059y + ", mDelayNetRequestSeconds=" + this.f13060z + ", mApmStartListener=" + this.A + ", mApmLogListener=" + this.B + ", mStorageCheckListener=" + this.C + ", mExecutor=" + this.D + ", mEncryptor=" + this.E + ", mAlogFilesDir='" + this.F + "', mCallback=" + this.G + ", mNtpTimeService=" + this.H + '}';
    }

    public List<String> u() {
        return this.f13035a;
    }

    public d0.f v() {
        return this.C;
    }

    public List<String> w() {
        return this.f13038d;
    }

    public d0.g x() {
        return this.G;
    }

    public Set<i> y() {
        return this.f13059y;
    }

    public boolean z() {
        return this.f13050p;
    }
}
