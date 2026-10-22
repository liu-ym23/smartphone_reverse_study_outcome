package qa;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g0 extends m0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final byte[] f10443k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, String> f10444l;

    public g0(byte[] r8, HashMap r10) {
        this.f10443k = r8;
        this.f10444l = r10;
        this.f10805i = m0.a.f10810n;
        b(m0.c.f10822b);
    }

    @Override // qa.m0
    public final Map<String, String> a() {
        return null;
    }

    @Override // qa.m0
    public final String c() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    @Override // qa.m0
    public final Map<String, String> h() {
        return this.f10444l;
    }

    @Override // qa.m0
    public final byte[] i() {
        return this.f10443k;
    }
}
