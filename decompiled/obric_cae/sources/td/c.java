package td;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends s5.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f12379o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f12380p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ String f12381q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ long f12382r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ long f12383s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final /* synthetic */ JSONObject f12384t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ Context f12385u;

    public c(Context r8, String r10, JSONObject r11) {
        this.f12379o = "event_v3";
        this.f12380p = r10;
        this.f12381q = null;
        this.f12382r = 0;
        this.f12383s = 0;
        this.f12384t = r11;
        this.f12385u = r8;
        super(0);
    }

    @Override // s5.c, java.lang.Runnable
    public final void run() {
        b r8 = new b();     // Catch: Throwable -> L22
        r8.f12373a = this.f12379o;     // Catch: Throwable -> L22
        r8.f12374b = this.f12380p;     // Catch: Throwable -> L22
        r8.f12375c = this.f12381q;     // Catch: Throwable -> L22
        r8.f12376d = this.f12382r;     // Catch: Throwable -> L22
        r8.f12377e = this.f12383s;     // Catch: Throwable -> L22
        JSONObject r10 = this.f12384t;     // Catch: Throwable -> L22
        if (r10 == null) goto L7;
        r8.f12378f = r10.toString();     // Catch: Throwable -> L22
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.d("PushLog", "category = " + r8.f12373a + " tag = " + r8.f12374b + " label = " + r8.f12375c + " value = " + r8.f12376d + " ext_value = " + this.f12383s + " ext_json = " + r8.f12378f);     // Catch: Throwable -> L22
    L9:
        Context r11 = this.f12385u;     // Catch: Throwable -> L22
        Object r12 = a.f12370b;     // Catch: Throwable -> L22
        monitor-enter(r12);     // Catch: Throwable -> L22
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L12:
        if (a.f12371c != null) goto L14;
        a.f12371c = new a(r11.getApplicationContext());     // Catch: Throwable -> L19
    L14:
        monitor-exit(r12);     // Catch: Throwable -> L19
        a r13 = a.f12371c;     // Catch: Throwable -> L22
        if (r13 == null) goto L28;
        r13.a(r8);     // Catch: Throwable -> L22
        return;
    L28:
        return;
    L22:
        th = move-exception;
        th.printStackTrace();
    }
}
