package u3;

import android.app.Application;
import android.content.SharedPreferences;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import v4.i;
import x4.j;
import x4.v;
import x4.w;

/* JADX INFO: loaded from: classes.dex */
public final class f implements w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<String> f12450e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r3.c f12451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile SharedPreferences f12452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile JSONObject f12453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f12454d;

    static {
        f12450e = Collections.singletonList("CustomHeaderAdapter");
    }

    public f(r3.c r8, v r10) {
        this.f12451a = r8;
        this.f12454d = r10;
    }

    public final JSONObject a() {
        if (this.f12453c != null) goto L14;
        SharedPreferences r8 = b();     // Catch: Throwable -> L11
        if (r8 == null) goto L15;
        String r10 = r8.getString("header_custom_info", null);     // Catch: Throwable -> L11
        if (i.h(r10) == false) goto L9;
        this.f12453c = new JSONObject(r10);     // Catch: Throwable -> L11
        goto L15
    L9:
        this.f12453c = new JSONObject();     // Catch: Throwable -> L11
    L15:
    L11:
        th = move-exception;
        this.f12451a.H.i(f12450e, "getCustomInfo failed", th, new Object[0]);
    L14:
        return this.f12453c;
    }

    public final SharedPreferences b() {
        if (this.f12452b != null) goto L8;
        if (this.f12451a.f11402j == null) goto L8;
        this.f12452b = this.f12451a.f11402j.getSharedPreferences(r3.b.b(this.f12451a, "header_custom"), 0);
    L8:
        return this.f12452b;
    }

    public final void c(JSONObject r8) {
        this.f12453c = r8;
        SharedPreferences r10 = b();
        if (r10 == null) goto L5;
        r10.edit().putString("header_custom_info", r8.toString()).apply();
    L5:
        v r11 = this.f12454d;
        Application r12 = this.f12451a.f11402j;
        j r13 = (j) r11;
        r13.getClass();
        HashMap r14 = new HashMap();
        r14.put("custom", r8);
        ((i5.b) r13.f13457g.b(new Object[]{r12})).b(r14);
    }
}
