package e2;

import o2.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f7109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f7110b;

    public c(JSONObject r8, JSONObject r10) {
        this.f7109a = r8;
        this.f7110b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e r8 = new e("start", "", this.f7109a, null, this.f7110b);
        n2.a.i().d(r8);
    }
}
