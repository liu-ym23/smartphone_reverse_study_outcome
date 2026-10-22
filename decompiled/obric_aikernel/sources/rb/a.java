package rb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import qb.k;
import qb.l;
import qb.t;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final LruCache<Integer, a> f12703e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final a f12704f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static JSONObject f12705g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static JSONObject f12706h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Boolean f12707i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f12708j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static a f12709k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f12710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f12711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Boolean f12712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12713d;

    static {
        f12703e = new LruCache(16, 16);
        f12704f = new a(null);
        e();
    }

    private a(JSONObject r10) {
        this.f12710a = r10;
        JSONObject r11 = null;
        Boolean r12 = null;
        r12 = null;
        r12 = null;
        if (r10 != null) goto L5;
    L17:
        Boolean r13 = null;
    L18:
        this.f12711b = r11;
        this.f12712c = r13;
        return;
    L5:
        if (f("bugfix") == true) goto L17;
        JSONObject r14 = r10.optJSONObject("bugfix");
        if (r14 != null) goto L9;
    L16:
        Boolean r15 = r12;
        r11 = r14;
        r13 = r15;
        goto L18
    L9:
        if (r14.has(DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE) == false) goto L16;
        if (f(DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE) == true) goto L16;
        boolean r16 = false;
        if (r14.optInt(DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE, 0) != 1) goto L15;
        r16 = true;
    L15:
        r12 = Boolean.valueOf(r16);
        goto L16
    }

    public static void a(int r10, JSONObject r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11 != d()) goto L6;
        return;
    L6:
        if (f12708j == true) goto L37;
        LruCache<Integer, a> r12 = f12703e;
        monitor-enter(r12);
        a r13 = f12709k;     // Catch: Throwable -> L27
        if (r13 != null) goto L13;
    L15:
        r13 = null;
        Iterator<a> r14 = r12.values().iterator();     // Catch: Throwable -> L27
    L17:
        if (r14.hasNext() == false) goto L21;
        a r15 = r14.next();     // Catch: Throwable -> L27
        if (r15.f12710a != r11) goto L17;
        r15.f12713d = r10;     // Catch: Throwable -> L27
        r13 = r15;
    L21:
        if (r13 != null) goto L23;
        r13 = new a(r11);     // Catch: Throwable -> L27
        r13.f12713d = r10;     // Catch: Throwable -> L27
    L23:
        f12709k = r13;     // Catch: Throwable -> L27
    L24:
        f12703e.put(Integer.valueOf(r10), r13);     // Catch: Throwable -> L27
        monitor-exit(r12);     // Catch: Throwable -> L27
        return;
    L13:
        if (r13.f12710a != r11) goto L15;
        r13.f12713d = r10;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    private static a b(int r10) {
        if (f12708j == false) goto L7;
        return f12704f;
    L7:
        if (((l) k.a(l.class)).getAppContext() == null) goto L13;
        DownloadInfo r11 = ((t) k.a(t.class)).a(r10);
        if (r11 == null) goto L13;
        return c(r11);
    L13:
        return f12704f;
    }

    private static a c(DownloadInfo r10) {
        if (f12708j == true) goto L5;
        String r11 = r10.getDownloadSettingString();     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r11) == true) goto L13;
        return new a(new JSONObject(r11));
    L13:
        return f12704f;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L13
    L5:
        return f12704f;
    }

    @NonNull
    public static JSONObject d() {
        return ((l) k.a(l.class)).g();
    }

    public static void e() {
        JSONObject r10 = ((l) k.a(l.class)).g();
        boolean r11 = false;
        if (r10.optInt("disable_task_setting", 0) != 1) goto L5;
        boolean r12 = true;
    L6:
        f12708j = r12;
        f12705g = r10.optJSONObject("disabled_task_keys");
        JSONObject r13 = r10.optJSONObject("bugfix");
        Boolean r14 = null;
        if (r13 != null) goto L9;
    L14:
        f12706h = r13;
        f12707i = r14;
        if (lb.a.a() == false) goto L18;
        lb.a.b("DownloadSetting", CommonConsts.APM_INNER_EVENT_COST_INIT, "SettingUpdate:" + r10.toString());
        return;
    L18:
        return;
    L9:
        if (r13.has(DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE) == false) goto L14;
        if (r13.optInt(DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE, 0) != 1) goto L13;
        r11 = true;
    L13:
        r14 = Boolean.valueOf(r11);
        goto L14
    L5:
        r12 = false;
        goto L6
    }

    public static boolean f(String r10) {
        JSONObject r11 = f12705g;
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.optInt(r10, 0) != 1) goto L7;
        return true;
    }

    @NonNull
    public static a g(int r10) {
        return h(r10, null);
    }

    private static a h(int r10, DownloadInfo r11) {
        a r12 = f12709k;
        if (r12 != null) goto L5;
    L7:
        LruCache<Integer, a> r13 = f12703e;
        monitor-enter(r13);
        a r14 = r13.get(Integer.valueOf(r10));     // Catch: Throwable -> L25
        monitor-exit(r13);     // Catch: Throwable -> L25
        if (r14 != null) goto L23;
        if (r11 != null) goto L14;
        a r15 = b(r10);
    L15:
        r14 = r15;
        monitor-enter(r13);
        r13.put(Integer.valueOf(r10), r14);     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L14:
        r15 = c(r11);
    L23:
        r14.f12713d = r10;
        f12709k = r14;
        return r14;
    L25:
        th = move-exception;
        throw th;
    L5:
        if (r12.f12713d != r10) goto L7;
        return r12;
    }

    @NonNull
    public static a i(DownloadInfo r10) {
        if (r10 != null) goto L6;
        return f12704f;
    L6:
        return h(r10.getId(), r10);
    }

    @NonNull
    public static a j() {
        return f12704f;
    }

    public static void v(int r10) {
        a r11 = f12709k;
        if (r11 != null) goto L5;
    L7:
        LruCache<Integer, a> r12 = f12703e;
        monitor-enter(r12);
        r12.remove(Integer.valueOf(r10));     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r11.f12713d != r10) goto L7;
        f12709k = null;
        goto L7
    }

    public boolean k(String r10) {
        return l(r10, false);
    }

    public boolean l(String r10, boolean r11) {
        if (this.f12711b != null) goto L5;
    L16:
        JSONObject r12 = f12706h;
        if (r12 != null) goto L19;
    L28:
        return r11;
    L19:
        if (r12.has(r10) == true) goto L21;
        Boolean r13 = f12707i;
        if (r13 == null) goto L28;
        return r13.booleanValue();
    L21:
        if (f12706h.optInt(r10, r11 ? 1 : 0) == 1) goto L23;
        return false;
    L23:
        return true;
    L5:
        if (f(r10) == true) goto L16;
        if (this.f12711b.has(r10) == true) goto L9;
        Boolean r14 = this.f12712c;
        if (r14 == null) goto L16;
        return r14.booleanValue();
    L9:
        if (this.f12711b.optInt(r10, r11 ? 1 : 0) == 1) goto L11;
        return false;
    L11:
        return true;
    }

    public double m(String r10, double r11) {
        JSONObject r12 = this.f12710a;
        if (r12 != null) goto L5;
    L11:
        JSONObject r13 = d();
    L10:
        return r13.optDouble(r10, r11);
    L5:
        if (r12.has(r10) == false) goto L11;
        if (f(r10) == true) goto L11;
        r13 = this.f12710a;
        goto L10
    }

    public int n(String r10) {
        return o(r10, 0);
    }

    public int o(String r10, int r11) {
        JSONObject r12 = this.f12710a;
        if (r12 != null) goto L5;
    L11:
        JSONObject r13 = d();
    L10:
        return r13.optInt(r10, r11);
    L5:
        if (r12.has(r10) == false) goto L11;
        if (f(r10) == true) goto L11;
        r13 = this.f12710a;
        goto L10
    }

    public JSONArray p(String r10) {
        JSONObject r11 = this.f12710a;
        if (r11 != null) goto L5;
    L11:
        JSONObject r12 = d();
    L10:
        return r12.optJSONArray(r10);
    L5:
        if (r11.has(r10) == false) goto L11;
        if (f(r10) == true) goto L11;
        r12 = this.f12710a;
        goto L10
    }

    public JSONObject q(String r10) {
        JSONObject r11 = this.f12710a;
        if (r11 != null) goto L5;
    L11:
        JSONObject r12 = d();
    L10:
        return r12.optJSONObject(r10);
    L5:
        if (r11.has(r10) == false) goto L11;
        if (f(r10) == true) goto L11;
        r12 = this.f12710a;
        goto L10
    }

    public long r(String r10) {
        return s(r10, 0);
    }

    public long s(String r10, long r11) {
        JSONObject r12 = this.f12710a;
        if (r12 != null) goto L5;
    L11:
        JSONObject r13 = d();
    L10:
        return r13.optLong(r10, r11);
    L5:
        if (r12.has(r10) == false) goto L11;
        if (f(r10) == true) goto L11;
        r13 = this.f12710a;
        goto L10
    }

    public String t(String r10) {
        return u(r10, "");
    }

    public String toString() {
        return "DownloadSetting{mTaskSetting=" + this.f12710a + ", mBugFixSetting=" + this.f12711b + ", mBugFixDefault=" + this.f12712c + ", mDownloadId=" + this.f12713d + ", globalSetting=" + d() + '}';
    }

    public String u(String r10, String r11) {
        JSONObject r12 = this.f12710a;
        if (r12 != null) goto L5;
    L11:
        JSONObject r13 = d();
    L10:
        return r13.optString(r10, r11);
    L5:
        if (r12.has(r10) == false) goto L11;
        if (f(r10) == true) goto L11;
        r13 = this.f12710a;
        goto L10
    }
}
