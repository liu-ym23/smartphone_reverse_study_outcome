package c2;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3280b;

    public g(String r8, JSONObject r10) {
        this.f3279a = r8;
        this.f3280b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r8 = h3.a.f7903a;
        String r10 = this.f3279a;
        if (TextUtils.isEmpty(r10) == true) goto L5;
        j3.b r11 = new j3.b(r10, this.f3280b);
        h3.a.f7904b.a(r11);
        if (t2.b.G() == false) goto L10;
        q3.a.a("APM-CommonEvent", "Cached CommonLog: " + r11);
    L10:
        h3.a.a();
        return;
    L5:
        if (t2.b.G() == false) goto L12;
        q3.a.a("APM-CommonEvent", "logType must be not empty");
        return;
    }
}
