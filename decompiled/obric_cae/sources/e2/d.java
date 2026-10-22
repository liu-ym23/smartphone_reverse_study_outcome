package e2;

import o2.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f7111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f7112b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f7113m;

    public d(long r8, String r10, String r11) {
        this.f7111a = r10;
        this.f7112b = r8;
        this.f7113m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L4
        r8.put(this.f7111a, this.f7112b);     // Catch: Exception -> L4
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L4
        r10.put("scene", this.f7113m);     // Catch: Exception -> L4
        e r11 = new e("page_load", "page_load", r8, r10, null);     // Catch: Exception -> L4
        n2.a.i().d(r11);     // Catch: Exception -> L4
        return;
    }
}
