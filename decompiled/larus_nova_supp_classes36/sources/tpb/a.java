package tpb;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.larkconfig.userconfig.api.ExternalSearchConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {

    @JSONField(name = "maxMemberCount")
    private int a;

    @JSONField(name = "maxRecallTime")
    private long b;

    @JSONField(name = "vcHeartBeatCycle")
    private int c;

    @JSONField(name = "vcHeartBeatExpire")
    private int d;

    @JSONField(name = "domain")
    private String e;

    @JSONField(name = "docsDomains")
    private List<String> f;

    @JSONField(name = "createDocsUrl")
    private String g;

    @JSONField(name = "addresses")
    private Map<String, String> h;

    @JSONField(name = "customerServiceUrl")
    private String i;

    @JSONField(name = "onCallChat")
    private boolean j;

    @JSONField(name = "androidAppStores")
    private List<String> k;

    @JSONField(name = "guideToRateDelayHours")
    private int l;

    @JSONField(name = "isAutoTranslateEnable")
    private boolean m;

    @JSONField(name = "isRedPacketEnable")
    private boolean n;

    @JSONField(name = "secretChatEnable")
    private boolean o;

    @JSONField(name = "recallGroupChatterValidLimit")
    private int p;

    @JSONField(name = "externalSearches")
    private List<ExternalSearchConfig> q;

    @JSONField(name = "notificationBannerRefreshTime")
    private long r;

    @JSONField(name = "createExternalChatMaxMemberCount")
    private int s;

    @JSONField(name = "urlRegex")
    private Map<Integer, String> t;

    @JSONField(name = "cryptoChatState")
    private int u;

    @JSONField(name = "urgent_num")
    private List<String> v;

    @JSONField(name = "urgent_num_update_time")
    private Long w;

    @JSONField(name = "residency")
    private String x;

    @JSONField(name = "is_show_residency")
    private boolean y;

    @JSONField(name = "residency_help_url")
    private String z;

    public final List<String> a() {
        List<String> r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new ArrayList();
    }

    public a() {
        this.j = false;
        this.l = -1;
        this.m = false;
        this.n = false;
        this.p = -1;
        this.r = 0;
        this.s = 0;
        this.t = new HashMap();
        this.u = 3;
    }

    public final Map<Integer, String> b() {
        return this.t;
    }

    public final boolean c() {
        return this.m;
    }

    public final void A(Map<Integer, String> r1) {
        this.t = r1;
    }

    public final void B(int r1) {
        this.c = r1;
    }

    public final void C(int r1) {
        this.d = r1;
    }

    public final void d(Map<String, String> r1) {
        this.h = r1;
    }

    public final void e(List<String> r1) {
        this.k = r1;
    }

    public final void f(boolean r1) {
        this.m = r1;
    }

    public final void g(int r1) {
        this.a = r1;
    }

    public final void h(String r1) {
        this.g = r1;
    }

    public final void i(int r1) {
        this.s = r1;
    }

    public final void j(int r1) {
        this.u = r1;
    }

    public final void k(String r1) {
        this.i = r1;
    }

    public final void l(List<String> r1) {
        this.f = r1;
    }

    public final void m(String r1) {
        this.e = r1;
    }

    public final void n(List<ExternalSearchConfig> r1) {
        this.q = r1;
    }

    public final void o(int r1) {
        this.l = r1;
    }

    public final void p(long r1) {
        this.b = r1;
    }

    public final void q(long r1) {
        this.r = r1;
    }

    public final void r(boolean r1) {
        this.j = r1;
    }

    public final void s(int r1) {
        this.p = r1;
    }

    public final void t(boolean r1) {
        this.n = r1;
    }

    public final void u(String r1) {
        this.x = r1;
    }

    public final void v(String r1) {
        this.z = r1;
    }

    public final void w(boolean r1) {
        this.o = r1;
    }

    public final void x(boolean r1) {
        this.y = r1;
    }

    public final void y(List<String> r1) {
        this.v = r1;
    }

    public final void z(Long r1) {
        this.w = r1;
    }
}
