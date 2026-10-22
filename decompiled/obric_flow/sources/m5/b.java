package m5;

import com.bytedance.android.monitorV2.webview.k;
import org.json.JSONObject;
import x4.h;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f19993j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f19994k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final JSONObject f19995l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final JSONObject f19996m;

    public b() {
        this.f19994k = "web";
        this.f19995l = new JSONObject();
        this.f19996m = new JSONObject();
    }

    @Override // x4.h, sj.g
    public final void m(JSONObject r5) {
        super.m(r5);
        qo.a.t("js_dependency_version", "2.2.1", r5);
        qo.a.t("webview_type", this.f19994k, r5);
        qo.a.m(r5, this.f19995l);
        qo.a.m(r5, this.f19996m);
        JSONObject r10 = r5.optJSONObject("debug_context");
        if (r10 != null) goto L5;
        r10 = new JSONObject();
        qo.a.j(r10, "debug_context", r5);
    L5:
        qo.a.t("is_ttweb_enable", String.valueOf(k.d.v()), r10);
    }
}
