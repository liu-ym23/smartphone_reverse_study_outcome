package v4;

import c4.d;
import com.bytedance.apm.util.i;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements u4.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile b f13181j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13182c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f13183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private JSONObject f13184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private JSONObject f13185i;

    private b() {
        this.f13183g = true;
    }

    public static b a() {
        if (f13181j != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13181j != null) goto L9;
        f13181j = new b();     // Catch: Throwable -> L11
        ((IConfigManager) d.a(IConfigManager.class)).registerConfigListener(f13181j);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f13181j;
    }

    public int b(boolean r10, String r11) {
        int r12 = 0;
        if (this.f13183g == true) goto L6;
        return 0;
    L6:
        if (r10 == false) goto L12;
        JSONObject r13 = this.f13185i;
        if (r13 != null) goto L10;
    L11:
        r12 = 16;
        goto L12
    L10:
        if (r13.optDouble(r11, -1.0d) > 0.0d) goto L11;
    L12:
        JSONObject r14 = this.f13184h;
        if (r14 != null) goto L15;
        return r12;
    L15:
        if (r14.optDouble(r11, -1.0d) > 0.0d) goto L17;
        return r12;
    L17:
        return r12 | 1;
    }

    @Override // u4.a
    public void onReady() {
    }

    @Override // u4.a
    public void onRefresh(JSONObject r10, boolean r11) {
        this.f13183g = i.e(r10, "tracing", "enable_open", true);
        if (this.f13182c == true) goto L6;
        this.f13184h = i.g(r10, "tracing", "allow_service_list");
        this.f13185i = i.g(r10, "tracing", "allow_error_list");
        this.f13182c = true;
        return;
    }
}
