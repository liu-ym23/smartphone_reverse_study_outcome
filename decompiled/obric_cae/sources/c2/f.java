package c2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3278b;

    public f(String r8, JSONObject r10) {
        this.f3277a = r8;
        this.f3278b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r8 = new o2.d(this.f3277a, this.f3278b).c();
        if (r8 == null) goto L6;
        e.f("monitorExceptionLog", r8.toString());
        return;
    }
}
