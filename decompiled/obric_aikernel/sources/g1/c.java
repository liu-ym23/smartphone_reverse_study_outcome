package g1;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.AppInfo;
import f1.e;
import f1.m;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import o1.j;
import o1.l;
import o1.n;
import o1.p;
import org.json.JSONException;
import org.json.JSONObject;
import w0.d;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List<String> f8931g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f8932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f8933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f8934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile JSONObject f8935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SharedPreferences f8936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bytedance.applog.c f8937f;

    class a implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f8938a;

        a(c r10) {
            this.f8938a = r10;
        }

        @Override // f1.e.b
        public Object a() {
            JSONObject r10 = new JSONObject();
            j.b(c.a(this.f8938a), r10);
            r10.put("appId", c.b(this.f8938a).getAppId());     // Catch: Throwable -> L5
        L4:
            return r10;
        }
    }

    static {
        f8931g = Collections.singletonList("DeviceManager");
    }

    public c(com.bytedance.applog.c r10, b r11, d r12) {
        this.f8937f = r10;
        this.f8934c = r11;
        this.f8932a = r12;
        this.f8936e = r11.z();
        this.f8935d = new JSONObject();
    }

    static /* synthetic */ JSONObject a(c r10) {
        return r10.f8935d;
    }

    static /* synthetic */ com.bytedance.applog.c b(c r10) {
        return r10.f8937f;
    }

    @NonNull
    private JSONObject d() {
        return p.d(this.f8935d);
    }

    private void m(JSONObject r10) {
        boolean r11 = l.a();
        if (r11 == false) goto L6;
        String r12 = "Harmony";
    L18:
        r10.put(WsConstants.KEY_PLATFORM, r12);     // Catch: JSONException -> L9
    L11:
        if (r11 == true) goto L20;
        return;
    L20:
        r10.put("harmony_os_api", SystemPropertiesWithCache.get("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L15
        r10.put("harmony_os_version", SystemPropertiesWithCache.get("hw_sc.build.platform.version"));     // Catch: Throwable -> L15
        r10.put("harmony_release_type", SystemPropertiesWithCache.get("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        this.f8937f.P().o(f8931g, "loadHarmonyInfo failed", new Object[]{th});
        return;
    L9:
        e = move-exception;
        this.f8937f.P().o(f8931g, "loadHarmonyInfo failed", new Object[]{e});
        goto L11
    L6:
        r12 = "Android";
        goto L18
    }

    public String c() {
        return this.f8934c.f();
    }

    @Nullable
    public JSONObject e() {
        return d();
    }

    public long f() {
        return this.f8936e.getLong("version_code", 0);
    L5:
        long r10 = this.f8936e.getInt("version_code", 0);
        this.f8936e.edit().putLong("version_code", r10).apply();
        return r10;
    }

    public String g() {
        if (this.f8933b == true) goto L9;
        b r10 = this.f8934c;
        if (r10 != null) goto L8;
        return "";
    L8:
        return r10.B();
    L9:
        return this.f8935d.optString(Api.KEY_USER_UNIQUE_ID, "");
    }

    public long h() {
        InstallOptions r10 = this.f8932a.getInstallOptions();
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.getVersionCode();
    }

    public String i() {
        InstallOptions r10 = this.f8932a.getInstallOptions();
        if (r10 != null) goto L5;
        return "";
    L5:
        return r10.getVersion();
    }

    public boolean j() {
        if (this.f8933b == true) goto L5;
    L7:
        return false;
    L5:
        if (k() == false) goto L7;
        return true;
    }

    public boolean k() {
        return l(this.f8935d);
    }

    public boolean l(JSONObject r10) {
        if (r10 == null) goto L10;
        String r11 = r10.optString("device_id", "");
        String r12 = r10.optString("install_id", "");
        if (p.a(r11) == true) goto L7;
        return false;
    L7:
        if (p.a(r12) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public void n(JSONObject r10) {
        this.f8937f.P().o(f8931g, "updateHeader: {}", new Object[]{r10});
        JSONObject r11 = new JSONObject();
        String r12 = this.f8937f.m();
        monitor-enter(this);
        p.c(r11, this.f8935d);     // Catch: Throwable -> L26
        Iterator<String> r13 = r10.keys();     // Catch: Throwable -> L26
    L6:
        if (r13.hasNext() == false) goto L33;
        String r14 = r13.next();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r14) == true) goto L6;
        r11.put(r14, r10.opt(r14));     // Catch: JSONException -> L12 Throwable -> L26
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
        goto L6
    L33:
        r11.put("sdk_version", 506081190);     // Catch: Throwable -> L20
        r11.put(Api.KEY_SDK_VERSION_CODE, n.f11388b);     // Catch: Throwable -> L20
        r11.put(AppInfo.KEY_NPTH_VERSION_NAME, "5.6.8-bugfix.11");     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r12) == true) goto L18;
        r11.put("ab_sdk_version", r12);     // Catch: Throwable -> L20
    L18:
        m(r11);     // Catch: Throwable -> L20
    L22:
        this.f8935d = r11;     // Catch: Throwable -> L26
        this.f8933b = true;     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        SharedPreferences.Editor r15 = this.f8936e.edit();
        r15.putLong("version_code", this.f8935d.optLong("version_code", 0));
        r15.putString("channel", this.f8935d.optString("channel", ""));
        r15.apply();
        m.d("set_header", new a(this));
        return;
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }
}
