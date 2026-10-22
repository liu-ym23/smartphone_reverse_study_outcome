package c2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3247b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3248m;

    public a(int r8, String r10, JSONObject r11) {
        this.f3246a = r10;
        this.f3247b = r8;
        this.f3248m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r8 = new o2.c(this.f3246a, this.f3247b, null, null, null, this.f3248m).c();
        if (r8 == null) goto L6;
        e.f("monitorStatusRate", r8.toString());
        return;
    }
}
