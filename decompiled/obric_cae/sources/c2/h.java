package c2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3282b;

    public h(JSONObject r8, String r10) {
        this.f3281a = r10;
        this.f3282b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r8 = new o2.b(this.f3282b, this.f3281a).c();
        if (r8 == null) goto L6;
        e.f("monitorCommonLog", r8.toString());
        return;
    }
}
