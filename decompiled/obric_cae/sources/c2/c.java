package c2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3253b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3254m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3255n;

    public c(String r8, int r10, JSONObject r11, JSONObject r12) {
        this.f3252a = r8;
        this.f3253b = r10;
        this.f3254m = r11;
        this.f3255n = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r8 = new o2.c(this.f3252a, this.f3253b, this.f3254m, null, null, this.f3255n).c();
        if (r8 == null) goto L6;
        e.f("monitorStatusAndDuration", r8.toString());
        return;
    }
}
