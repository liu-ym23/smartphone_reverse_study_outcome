package u3;

import com.bytedance.bdinstall.Api;
import java.util.HashMap;
import p3.c;
import q3.b;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile String f13121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static a f13122l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile String f13123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile String f13124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile String f13125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f13126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f13127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f13128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f13129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile String f13130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f13131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f13132j;

    static {
        f13122l = new a();
        new HashMap();
    }

    private a() {
        this.f13123a = "uploadCheck";
        this.f13124b = "uploadCheck";
        this.f13125c = null;
        this.f13126d = 0;
        this.f13127e = 0;
        this.f13128f = 0;
        this.f13129g = 0;
        this.f13130h = null;
        this.f13131i = System.currentTimeMillis();
        this.f13132j = 1;
        f13121k = b.e().j();
    }

    private void a(HashMap r10) {
        r10.put(Api.KEY_UUID, f13121k);
        r10.put("enter_from", this.f13124b);
        r10.put("state", this.f13123a);
        int r11 = this.f13132j;
        this.f13132j = r11 + 1;
        r10.put("number", Integer.valueOf(r11));
        if (this.f13125c == null) goto L6;
        r10.put("uploadUrl", this.f13125c);
        r10.put("uploadCount", Integer.valueOf(this.f13126d));
    L6:
        if (this.f13130h == null) goto L9;
        r10.put("partUploadId", this.f13130h);
    L9:
        if (this.f13129g <= 0) goto L12;
        r10.put("usedMemory", Long.valueOf(this.f13128f));
        r10.put("maxMemory", Long.valueOf(this.f13129g));
    L12:
        if (this.f13127e <= 0) goto L14;
        r10.put("after_hprof_compress_size", Long.valueOf(this.f13127e));
    L14:
        long r12 = System.currentTimeMillis();
        r10.put("cost", Long.valueOf(r12 - this.f13131i));
        this.f13131i = r12;
        d("memorywidget_heartbeat", r10);
    }

    public static a b() {
        return f13122l;
    }

    private void d(String r10, HashMap r11) {
        c.c((String) r11.get("state"), new Object[0]);
        com.bytedance.memory.model.a r12 = o3.a.j().k().getTeaReport();
        if (r12 == null) goto L6;
        r12.a(r10, r11);
        return;
    }

    public void c(String r10, HashMap<String, Object> r11) {
        this.f13123a = r10;
        a(new HashMap(r11));
    }

    protected Object clone() {
        throw new CloneNotSupportedException("cant clone ReportMgr");
    }

    public void e(String r10) {
        this.f13130h = r10;
    }

    public void f(String r10) {
        this.f13123a = r10;
        a(new HashMap());
    }

    public void g(String r10) {
        this.f13124b = r10;
    }

    public void h(long r10) {
        this.f13127e = r10;
    }

    public void i(String r10, int r11) {
        this.f13125c = r10;
        this.f13126d = r11;
    }

    public void j(String r10) {
        f13121k = r10;
    }
}
