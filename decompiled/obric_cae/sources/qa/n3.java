package qa;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class n3 extends n4 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, String> f10859k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f10860l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f10861m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f10862n;

    public n3() {
        this.f10859k = null;
        this.f10860l = "";
        this.f10861m = null;
        this.f10862n = null;
    }

    @Override // qa.m0
    public final Map<String, String> a() {
        return this.f10859k;
    }

    @Override // qa.m0
    public final String c() {
        return this.f10860l;
    }

    @Override // qa.n4, qa.m0
    public final String e() {
        if (TextUtils.isEmpty(this.f10862n) == true) goto L7;
        return this.f10862n;
    L7:
        return super.e();
    }

    @Override // qa.m0
    public final Map<String, String> h() {
        return null;
    }

    @Override // qa.m0
    public final byte[] i() {
        return this.f10861m;
    }
}
