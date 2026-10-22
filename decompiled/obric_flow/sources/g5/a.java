package g5;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends t4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f17032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17033c;
    public int d;
    public long e;
    public long f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f17035i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f17036j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f17037k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f17038l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f17039m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f17040n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f17041o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f17042p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f17043q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f17044r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public x4.d f17045t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Map f17046u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Map f17047v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f17048w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f17049x;

    @Override // sj.g
    public final void m(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        qo.a.j(Float.valueOf(this.f17032b), "effective_percentage", r5);
        qo.a.e(this.f17033c, "view_height", r5);
        qo.a.e(this.d, "view_width", r5);
        qo.a.e(this.f17041o, "view_alpha", r5);
        qo.a.e(this.f17042p, "element_count", r5);
        qo.a.k("collect_time", this.f, r5);
        qo.a.k("calculate_time", this.g, r5);
        qo.a.k("cost_time", this.e, r5);
        qo.a.e(this.f17034h, "detect_type", r5);
        qo.a.k("enter_page_time", this.f17035i, r5);
        qo.a.k("detect_start_time", this.f17036j, r5);
        float r10 = this.f17040n;
        if (r10 <= 0) goto L5;
        qo.a.j(Float.valueOf(r10), "max_blank_rect_radio", r5);
    L5:
        JSONObject r11 = new JSONObject();
        int r12 = this.f17037k;
        if (r12 == 0) goto L8;
        qo.a.e(r12, "http_rtt_ms", r11);
    L8:
        int r13 = this.f17038l;
        if (r13 == 0) goto L11;
        qo.a.e(r13, "transport_rtt_ms", r11);
    L11:
        int r14 = this.f17039m;
        if (r14 < 0) goto L14;
        qo.a.e(r14, "load_state", r11);
    L14:
        Unit r15 = Unit.INSTANCE;
        qo.a.j(r11, "assist_info", r5);
        qo.a.t("bitmap", this.f17043q, r5);
        qo.a.e(this.f17044r, "bitmap_width", r5);
        qo.a.e(this.s, "bitmap_height", r5);
        x4.d r16 = this.f17045t;
        if (r16 == null) goto L17;
        r16.m(r5);
    L17:
        Map r17 = this.f17046u;
        if (r17 == null) goto L20;
        qo.a.j(new JSONObject(r17), "elements", r5);
    L20:
        Map r18 = this.f17047v;
        if (r18 == null) goto L23;
        qo.a.j(new JSONObject(r18), "valid_elements", r5);
    L23:
        qo.a.j(Boolean.valueOf(this.f17048w), "has_valid_element", r5);
    }
}
