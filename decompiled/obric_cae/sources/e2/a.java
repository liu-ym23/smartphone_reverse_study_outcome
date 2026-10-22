package e2;

import o2.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f7102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7103b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ JSONObject f7104m;

    public a(JSONObject r8, String r10, String r11) {
        this.f7102a = r10;
        this.f7103b = r11;
        this.f7104m = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n2.a.i().d(new f(this.f7102a, this.f7103b, this.f7104m));
    }
}
