package n2;

import c2.k;
import m2.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a extends m2.a<c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f9427c;

    public a() {
    }

    public static a i() {
        if (f9427c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9427c != null) goto L9;
        f9427c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f9427c;
    }

    @Override // m2.a
    public final void e(c r8) {
        JSONObject r10 = r8.c();
        boolean r11 = r8.b(r10);
        if (k.d() == true) goto L15;
    L9:
        if (r11 == false) goto L11;
    L13:
        m2.a.h(r8.e(), r8.a(), r10, r11, false);
        return;
    L11:
        if (r8.d() == true) goto L13;
        return;
    L15:
        v2.a.b(new Object[]{"logType: " + r8.e() + ", subType: " + r8.a() + "data: " + r10, " ,sample: " + r11});     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }
}
