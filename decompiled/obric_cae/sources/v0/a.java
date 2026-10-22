package v0;

import com.bytedance.bdlocation.scan.wifi.WifiInfoManager;
import com.obric.cae.libs.softap.CaeSoftApManager;
import com.obric.cae.libs.softap.CaeSoftApRequestCallback;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f12670b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f12671m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f12672n;

    public /* synthetic */ a(Object r8, int r10, int r11, Object r12) {
        this.f12669a = r11;
        this.f12672n = r8;
        this.f12670b = r10;
        this.f12671m = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f12669a;
        Object r10 = this.f12671m;
        int r11 = this.f12670b;
        Object r12 = this.f12672n;
        switch(r8) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L11;
        };
    L5:
        WifiInfoManager.b((WifiInfoManager.WifiInfoCallback) r12, r11, (String) r10);
        return;
    L7:
        ((androidx.profileinstaller.c.InterfaceC0019c) r12).b(r11, r10);
        return;
    L9:
        ((androidx.profileinstaller.b) r12).f2218c.b(r11, r10);
        return;
    L11:
        CaeSoftApManager.a((CaeSoftApRequestCallback) r12, r11, (String) r10);
    }
}
