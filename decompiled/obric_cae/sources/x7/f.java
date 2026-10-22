package x7;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.services.apm.api.IHttpService;
import com.obric.cae.cloud.CloudServiceConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f13609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f13610b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ m.a f13611m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ m f13612n;

    public f(m r8, Context r10, JSONObject r11, m.a r12) {
        this.f13612n = r8;
        this.f13609a = r10;
        this.f13610b = r11;
        this.f13611m = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m r8 = this.f13612n;
        Context r10 = this.f13609a;
        JSONObject r11 = this.f13610b;
        m.a r12 = this.f13611m;
        r8.getClass();
        if (r10 == null) goto L35;
        if (r11 == null) goto L35;
        r8.f13662y = true;
        r8.f13638a = r10.getApplicationContext();
        r8.f13639b = r11;
        r11.put(WsConstants.KEY_APP_ID, r8.C);     // Catch: Exception -> L39
        r8.f13639b.put("os", LocationInfoConst.SYSTEM);     // Catch: Exception -> L39
        r8.f13639b.put("device_platform", "android");     // Catch: Exception -> L39
        r8.f13639b.put(CloudServiceConstants.OCloud.HEADER_OS_VERSION, Build.VERSION.RELEASE);     // Catch: Exception -> L39
        r8.f13639b.put("os_api", Build.VERSION.SDK_INT);     // Catch: Exception -> L39
        r8.f13639b.put("device_model", Build.MODEL);     // Catch: Exception -> L39
        r8.f13639b.put(LocationMonitorConst.DEVICE_BRAND, Build.BRAND);     // Catch: Exception -> L39
        r8.f13639b.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Exception -> L39
        r8.f13639b.put("sdkmonitor_version", "2.0.35");     // Catch: Exception -> L39
        r8.f13639b.put("monitor_from", "sdk");     // Catch: Exception -> L39
        if (TextUtils.isEmpty(r8.f13639b.optString("package_name")) == false) goto L11;
        r8.f13639b.put("package_name", r10.getPackageName());     // Catch: Exception -> L39
    L11:
        if (TextUtils.isEmpty(r8.f13639b.optString("version_name")) == false) goto L13;
        PackageInfo r13 = r8.f13638a.getPackageManager().getPackageInfo(r8.f13638a.getPackageName(), 0);     // Catch: Exception -> L39
        r8.f13639b.put("version_name", r13.versionName);     // Catch: Exception -> L39
    L15:
        if (TextUtils.isEmpty(r8.f13639b.optString("version_code")) == false) goto L19;
        if (r13 != null) goto L18;
        r13 = r8.f13638a.getPackageManager().getPackageInfo(r8.f13638a.getPackageName(), 0);     // Catch: Exception -> L39
    L18:
        r8.f13639b.put("version_code", r13.versionCode);     // Catch: Exception -> L39
    L19:
        r8.f13656s = r12;     // Catch: Exception -> L39
        if (r12 != null) goto L22;
        r8.f13656s = new g();     // Catch: Exception -> L39
    L22:
        Map<String, String> r14 = r8.f13656s.getCommonParams();     // Catch: Exception -> L39
        r8.f13657t = r14;     // Catch: Exception -> L39
        if (r14 != null) goto L25;
        r8.f13657t = new HashMap();     // Catch: Exception -> L39
    L25:
        r8.D = TextUtils.equals(r8.f13657t.get("oversea"), "1");     // Catch: Exception -> L39
        r8.f13657t.put(WsConstants.KEY_APP_ID, r8.C);     // Catch: Exception -> L39
        r8.f13657t.put("device_id", r8.f13639b.optString("device_id"));     // Catch: Exception -> L39
        r8.f13657t.put("device_platform", "android");     // Catch: Exception -> L39
        r8.f13657t.put("package_name", r8.f13639b.optString("package_name"));     // Catch: Exception -> L39
        r8.f13657t.put("channel", r8.f13639b.optString("channel"));     // Catch: Exception -> L39
        r8.f13657t.put("app_version", r8.f13639b.optString("app_version"));     // Catch: Exception -> L39
        r8.f13657t.put("sdkmonitor_version", "2.0.35");     // Catch: Exception -> L39
        r8.f13657t.put("minor_version", "1");     // Catch: Exception -> L39
        String r15 = r8.C;     // Catch: Exception -> L39
        r7.c.f11537a.put(r15, r8);     // Catch: Exception -> L39
        String r16 = r8.C;     // Catch: Exception -> L39
        t7.d.f12298a.put(r16, r8);     // Catch: Exception -> L39
        i r17 = new i();     // Catch: Exception -> L39
        if (w7.c.f13041b == true) goto L29;
        w7.c.f13040a = r17;     // Catch: Exception -> L39
        w7.c.f13041b = true;     // Catch: Exception -> L39
    L29:
        q7.d r18 = new q7.d(r8.f13638a, r8.C);     // Catch: Exception -> L39
        r8.f13640c = r18;     // Catch: Exception -> L39
        u7.a r19 = u7.a.b.f12503a;     // Catch: Exception -> L39
        u7.d r20 = r19.f12499a;     // Catch: Exception -> L39
        r19.f12501c.add(r18);     // Catch: Throwable -> L38
        u7.a.RunnableC0172a r21 = r19.f12500b;     // Catch: Exception -> L39
        r20.d(r21);     // Catch: Throwable -> L38
        r20.e(Message.obtain(r20.f12514d, r21), 30000);     // Catch: Throwable -> L38
    L33:
        r8.f13649l = (IHttpService) e8.c.a(IHttpService.class);     // Catch: Exception -> L39
        r8.p();     // Catch: Exception -> L39
        goto L35
    L13:
        r13 = null;
    L35:
        if (this.f13612n.f13663z == false) goto L44;
        m r22 = this.f13612n;
        r22.B.b(r22);
        return;
    }
}
