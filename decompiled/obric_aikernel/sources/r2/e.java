package r2;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
class e extends b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private HttpURLConnection f12619p;

    public e(n4.c r10) {
        super(r10);
        this.f12619p = null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected int B(IOException r10) {
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r10.getClass().getName()) == true) goto L10;
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r10.getClass().getName()) == true) goto L10;
        return -1;
    L10:
        return i.l(this.f12619p);
    }

    @Override // s4.c
    public void a(Throwable r10, boolean r11) {
        X(this.f12619p, r10, r11);
    }

    @Override // r2.b
    HttpURLConnection a0() {
        return this.f12619p;
    }

    @Override // com.bytedance.retrofit2.m
    public void b() {
        com.bytedance.frameworks.baselib.network.http.impl.a.A(this.f1631g, this);
    }

    @Override // r2.b, n4.e
    public boolean c(long r10) {
        super.c(r10);
        HttpURLConnection r11 = this.f12619p;
        if (r11 != null) goto L11;
    L10:
        return true;
    L11:
        Reflect.on(r11).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r10)});     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    @Override // n4.e
    public void cancel() {
        W(this.f12619p);
    }

    @Override // r2.b
    void j0(HttpURLConnection r10) {
        this.f12619p = r10;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected IOException s(Exception r10) {
        if ("com.ttnet.org.chromium.net.urlconnection.TTRequestCanceledException".equals(r10.getClass().getName()) == false) goto L5;
        b();
        int r11 = i.l(this.f12619p);
    L7:
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r10.getClass().getName()) == false) goto L9;
    L10:
        r11 = i.l(this.f12619p);
    L12:
        return new CronetIOException(r10, this.f1631g, r11);
    L9:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r10.getClass().getName()) == false) goto L12;
    L5:
        r11 = 0;
        goto L7
    }
}
