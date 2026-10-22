package b0;

import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f500j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f501k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f502l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f503m;

    public a(boolean r10, long r11, String r12, boolean r13, long r14, String r15) {
        this.f492b = r10;
        this.f493c = r11;
        this.f494d = r12;
        this.f495e = r13;
        this.f497g = r14;
        this.f496f = r15;
    }

    public a(boolean r10, long r11, String r12, boolean r13, long r14, String r15, String r16) {
        this.f492b = r10;
        this.f493c = r11;
        this.f494d = r12;
        this.f495e = r13;
        this.f497g = r14;
        this.f496f = r15;
        this.f498h = r16;
    }

    public long a() {
        return this.f497g;
    }

    public long b() {
        return this.f491a;
    }

    public String c() {
        return this.f500j;
    }

    public String d() {
        return this.f496f;
    }

    public String e() {
        return this.f498h;
    }

    public String f() {
        return this.f502l;
    }

    public long g() {
        return this.f493c;
    }

    public String h() {
        return this.f494d;
    }

    public long i() {
        return this.f499i;
    }

    public boolean j() {
        return !this.f492b;
    }

    public boolean k() {
        return this.f492b;
    }

    public boolean l() {
        return this.f501k;
    }

    public boolean m() {
        return this.f495e;
    }

    public boolean n() {
        return this.f495e;
    }

    public void o(long r10) {
        this.f491a = r10;
    }

    public void p(boolean r10) {
        this.f501k = r10;
    }

    public void q(String r10) {
        this.f500j = r10;
    }

    public void r(String r10) {
        this.f496f = r10;
    }

    public void s(String r10) {
        this.f502l = r10;
    }

    public void t(boolean r10) {
        this.f495e = r10;
    }

    public String toString() {
        return "BatteryLogEntity{id=" + this.f491a + ", front=" + this.f492b + ", time=" + this.f493c + ", type='" + this.f494d + "', status=" + this.f495e + ", scene='" + this.f496f + "', accumulation=" + this.f497g + ", source='" + this.f498h + "', versionId=" + this.f499i + ", processName='" + this.f500j + "', mainProcess=" + this.f501k + ", startUuid='" + this.f502l + "', deleteFlag=" + this.f503m + '}';
    }

    public void u(long r10) {
        this.f499i = r10;
    }

    public JSONObject v() {
        JSONObject r10 = new JSONObject();
        r10.put(CpuReportEvent.VALUE_FRONT, this.f492b);
        r10.put(OaidModel.KEY_TIME, this.f493c);
        r10.put(WsConstants.KEY_CONNECTION_TYPE, this.f494d);
        r10.put("scene", this.f496f);
        r10.put("processName", this.f500j);
        return r10;
    }
}
