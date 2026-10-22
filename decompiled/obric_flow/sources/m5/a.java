package m5;

import com.bytedance.android.monitorV2.webview.k;
import org.json.JSONObject;
import x4.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f19981j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f19982k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f19983l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f19984m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f19985n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f19986o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f19987p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f19988q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f19989r;
    public String s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f19990t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f19991u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f19992v;

    public a() {
        this.f19981j = null;
        this.f19982k = null;
        this.f19983l = null;
        this.f19984m = null;
        this.f19985n = null;
        this.f19986o = null;
        this.f19987p = null;
        this.f19988q = null;
        this.f19989r = null;
        this.s = null;
        this.f19990t = null;
        this.f19991u = null;
        this.f19992v = null;
    }

    @Override // x4.h, sj.g
    public final void m(JSONObject r5) {
        super.m(r5);
        String r10 = this.f19982k;
        if (r10 == null) goto L5;
        qo.a.t("engine_type", r10, r5);
    L5:
        String r11 = this.f19981j;
        if (r11 == null) goto L8;
        qo.a.t("event_type", r11, r5);
    L8:
        String r12 = this.f19983l;
        if (r12 == null) goto L11;
        qo.a.t("format_url", r12, r5);
    L11:
        String r13 = this.f19984m;
        if (r13 == null) goto L14;
        qo.a.t("full_url", r13, r5);
    L14:
        String r14 = this.f19986o;
        if (r14 == null) goto L17;
        qo.a.t("parent_url", r14, r5);
    L17:
        String r15 = this.f19985n;
        if (r15 == null) goto L20;
        qo.a.t("root_url", r15, r5);
    L20:
        String r16 = this.f19987p;
        if (r16 == null) goto L23;
        qo.a.t("biz", r16, r5);
    L23:
        String r17 = this.f19988q;
        if (r17 == null) goto L26;
        qo.a.t("res_format_src", r17, r5);
    L26:
        String r18 = this.f19989r;
        if (r18 == null) goto L29;
        qo.a.t("res_full_src", r18, r5);
    L29:
        String r19 = this.s;
        if (r19 == null) goto L32;
        qo.a.t("res_from", r19, r5);
    L32:
        Integer r20 = this.f19990t;
        if (r20 == null) goto L35;
        qo.a.j(r20, "res_size", r5);
    L35:
        String r21 = this.f19991u;
        if (r21 == null) goto L38;
        qo.a.t("res_type", r21, r5);
    L38:
        String r22 = this.f19992v;
        if (r22 == null) goto L41;
        qo.a.t("request_method", r22, r5);
    L41:
        JSONObject r23 = r5.optJSONObject("debug_context");
        if (r23 != null) goto L44;
        r23 = new JSONObject();
        qo.a.j(r23, "debug_context", r5);
    L44:
        qo.a.t("is_ttweb_enable", String.valueOf(k.d.v()), r23);
    }
}
