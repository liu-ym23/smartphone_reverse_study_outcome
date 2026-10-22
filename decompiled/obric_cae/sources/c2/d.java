package c2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3257b;

    public d(String r8, JSONObject r10) {
        this.f3256a = r8;
        this.f3257b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n2.a.i().d(new o2.d(this.f3256a, this.f3257b));
    }
}
