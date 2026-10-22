package c2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3250b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3251m;

    public b(String r8, JSONObject r10, JSONObject r11) {
        this.f3249a = r8;
        this.f3250b = r10;
        this.f3251m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r8 = new o2.c(this.f3249a, 0, this.f3250b, null, null, this.f3251m).c();
        if (r8 == null) goto L6;
        e.f("monitorDuration", r8.toString());
        return;
    }
}
