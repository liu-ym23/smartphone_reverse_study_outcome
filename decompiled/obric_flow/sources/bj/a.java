package bj;

import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public String A;
    public String B;
    public String C;
    public int D;
    public JSONObject E;
    public int F;
    public boolean G;
    public final LinkedHashMap H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f934c;
    public String d;
    public final String e;
    public final long f;
    public Long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f936i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f937j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f938k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f939l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f940m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IDLXBridgeMethod.XBridgeThreadType f941n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f942o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f943p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f944q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f945r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f946t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f947u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f948v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f949w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f950x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f951y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f952z;

    public a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        this.f932a = r5;
        this.f933b = System.currentTimeMillis();
        this.f934c = UUID.randomUUID().toString();
        this.d = "";
        this.e = "default_bid";
        this.f = System.currentTimeMillis();
        this.f936i = System.currentTimeMillis();
        this.f937j = System.currentTimeMillis();
        this.f938k = -1000;
        this.f939l = "Get message before callback";
        this.f942o = "";
        this.f943p = "";
        this.f944q = 0;
        this.s = true;
        this.f946t = "private";
        this.f947u = -1;
        this.f948v = System.currentTimeMillis();
        this.f949w = System.currentTimeMillis();
        this.f951y = "";
        this.A = "";
        this.B = "";
        this.C = "";
        this.G = true;
        this.H = new LinkedHashMap();
    }

    public abstract JSONObject a();

    public abstract Object b();

    public abstract PlatformType c();

    public abstract String d();
}
