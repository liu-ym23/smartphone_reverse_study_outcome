package e2;

import o2.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f7105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f7106b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ JSONObject f7107m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ JSONObject f7108n;

    public b(String r8, JSONObject r10, JSONObject r11, JSONObject r12) {
        this.f7105a = r8;
        this.f7106b = r10;
        this.f7107m = r11;
        this.f7108n = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e r8 = new e(this.f7105a, "", this.f7106b, this.f7107m, this.f7108n);
        n2.a.i().d(r8);
    }
}
