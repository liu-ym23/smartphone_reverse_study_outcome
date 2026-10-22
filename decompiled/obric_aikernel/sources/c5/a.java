package c5;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.ttnet.d;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements u2.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f636c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ICronetAppProvider f637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f638b;

    private a() {
    }

    public static a d() {
        if (f636c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f636c != null) goto L9;
        f636c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f636c;
    }

    @Override // u2.a
    public String a() {
        d r10 = this.f638b;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.j().get("httpdns");
    }

    @Override // u2.a
    public String[] b() {
        Object r10 = this.f638b;
        if ((r10 instanceof com.bytedance.ttnet.a) == true) goto L5;
        return null;
    L5:
        return ((com.bytedance.ttnet.a) r10).a();
    }

    @Override // u2.a
    public String[] c() {
        Object r10 = this.f638b;
        if ((r10 instanceof com.bytedance.ttnet.a) == true) goto L5;
        return null;
    L5:
        return ((com.bytedance.ttnet.a) r10).b();
    }

    public void e(ICronetAppProvider r10) {
        this.f637a = r10;
    }

    public void f(d r10) {
        this.f638b = r10;
    }

    @Override // u2.a
    public List<String> getAbSdkVersion() {
        ICronetAppProvider r10 = this.f637a;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getAbSdkVersion();
    }

    @Override // u2.a
    public int getAid() {
        d r10 = this.f638b;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.getAppId();
    }

    @Override // u2.a
    public void sendAppMonitorEvent(String r10, String r11) {
        ICronetAppProvider r12 = this.f637a;
        if (r12 == null) goto L6;
        r12.sendAppMonitorEvent(r10, r11);
        return;
    }
}
