package k6;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import c4.d;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.f;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.services.apm.api.IMonitorLogManager;
import com.bytedance.services.slardar.config.IConfigManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import t4.l;

/* JADX INFO: loaded from: classes2.dex */
public class b extends f implements u4.b, m6.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f10127c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private l6.a f10128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f10130i;

    class a implements Runnable {
        a(b r10) {
        }

        @Override // java.lang.Runnable
        public void run() {
            k6.a.k().e();
        }
    }

    /* JADX INFO: renamed from: k6.b$b, reason: collision with other inner class name */
    class RunnableC0218b implements Runnable {
        RunnableC0218b(b r10) {
        }

        @Override // java.lang.Runnable
        public void run() {
            k6.a.k().e();
        }
    }

    public b() {
        this.f10129h = false;
        this.f10130i = Arrays.asList(new String[]{CommonConsts.TIMER_TYPE, CommonConsts.COUNT_TYPE, SlardarSettingsConstants.PERF_KEY_DISK, SlardarSettingsConstants.PERF_KEY_MEMORY, "cpu", "fps", "traffic", CommonConsts.APM_INNER_EVENT_COST_START, "page_load", "image_monitor", "api_all", "api_error", LogTypeName.MONITOR_LOG_TYPE_COMMON_LOG, "service_monitor", LogTypeName.MONITOR_LOG_TYPE_PERFORMANCE, LogTypeName.MONITOR_LOG_TYPE_UI_ACTION});
    }

    @Override // m6.f
    public void a(String r10, String r11) {
        ((IMonitorLogManager) d.a(IMonitorLogManager.class)).deleteLegacyLogByIds(r10, r11);
    }

    @Override // m6.f
    public String[] b(JSONObject r10) {
        JSONArray r11 = r10.optJSONArray("upload_type");
        int r12 = 0;
        if (r11 != null) goto L9;
        String[] r13 = new String[this.f10130i.size()];
    L6:
        if (r12 >= this.f10130i.size()) goto L8;
        r13[r12] = this.f10130i.get(r12);
        r12 = r12 + 1;
        goto L6
    L8:
        return r13;
    L9:
        String[] r14 = new String[r11.length()];
    L11:
        if (r12 >= r11.length()) goto L13;
        r14[r12] = r11.optString(r12);
        r12 = r12 + 1;
        goto L11
    L13:
        return r14;
    }

    @Override // m6.f
    public void c(long r10, long r11, String r12, t4.f r13) {
        ((IMonitorLogManager) d.a(IMonitorLogManager.class)).getLegacyLog(r10 * 1000, r11 * 1000, r12, r13);
    }

    @Override // com.bytedance.apm.f
    public void destroy() {
        super.destroy();
        l6.a r10 = this.f10128g;     // Catch: Exception -> L7
        if (r10 == null) goto L10;
        this.f10127c.unregisterReceiver(r10);     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    @Override // com.bytedance.apm.f
    public String getTag() {
        return b.class.getSimpleName();
    }

    @Override // com.bytedance.apm.f, t4.i
    public void init(Context r10) {
        super.init(r10);
        this.f10127c = r10;
        k6.a.r(r10);
        ((IConfigManager) d.a(IConfigManager.class)).registerResponseConfigListener(this);
        k6.a.x(this);
        ActivityLifeObserver.getInstance().register(this);
        registerConfigService();
    }

    @Override // com.bytedance.apm.f, t4.i
    public boolean isOnlyMainProcess() {
        return true;
    }

    @Override // t4.i
    public void notifyParams(l r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (com.bytedance.common.utility.collection.a.a(r10.a()) == false) goto L11;
        return;
    L11:
        URL r11 = new URL(r10.a().get(0));     // Catch: MalformedURLException -> L8
        x6.a.f13564a = String.format("%s://%s/%s", new Object[]{r11.getProtocol(), r11.getHost(), "monitor/collect/c/cloudcontrol/file"});     // Catch: MalformedURLException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.apm.f, t4.d
    public void onBackground(Activity r10) {
        super.onBackground(r10);
        if (getServiceSwitch("close_cloud_request") == false) goto L5;
        return;
    L5:
        if (com.bytedance.apm.d.I() == false) goto L9;
        q0.b.f().j(new RunnableC0218b(this), 2000);
        return;
    }

    @Override // com.bytedance.apm.f, u4.a
    public void onReady() {
        super.onReady();
        if (this.f10129h == false) goto L5;
        return;
    L5:
        this.f10129h = true;
        if (getServiceSwitch("close_cloud_request") == false) goto L8;
        return;
    L8:
        if (com.bytedance.apm.d.I() == false) goto L12;
        this.f10128g = new l6.a();
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f10127c.registerReceiver(this.f10128g, r10);
        q0.b.f().i(new a(this));
        return;
    }

    @Override // u4.b
    public void onResponse(JSONObject r10) {
        if (k6.a.s() == true) goto L10;
        JSONArray r11 = r10.optJSONArray("cloud_commands");
        if (r11 == null) goto L12;
        int r12 = 0;
    L8:
        if (r12 >= r11.length()) goto L13;
        String r13 = r11.optString(r12);
        k6.a.k().p(r13);
        r12 = r12 + 1;
        goto L8
    L13:
        return;
    L12:
        return;
    }

    @Override // com.bytedance.apm.f, t4.i
    public void start() {
        super.start();
    }

    @Override // com.bytedance.apm.f
    public void stop() {
        super.stop();
    }
}
