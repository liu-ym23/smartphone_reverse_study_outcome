package p1;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9931a = null;

    static {
        String r8 = androidx.work.m.f("NetworkStateTracker");
        he.i.e(r8, "tagWithPrefix(\"NetworkStateTracker\")");
        f9931a = r8;
    }

    public static final n1.b a(ConnectivityManager r8) {
        he.i.f(r8, "<this>");
        NetworkInfo r10 = r8.getActiveNetworkInfo();
        boolean r11 = true;
        if (r10 != null) goto L5;
    L7:
        boolean r12 = false;
    L23:
        NetworkCapabilities r13 = s1.j.a(r8, s1.k.a(r8));     // Catch: SecurityException -> L12
        if (r13 == null) goto L14;
        boolean r14 = s1.j.b(r13, 16);     // Catch: SecurityException -> L12
    L15:
        boolean r15 = e0.a.a(r8);
        if (r10 != null) goto L18;
    L20:
        r11 = false;
    L22:
        return new n1.b(r12, r14, r15, r11);
    L18:
        if (r10.isRoaming() == true) goto L20;
    L14:
        r14 = false;
    L12:
        e = move-exception;
        androidx.work.m.d().c(f9931a, "Unable to validate active network", e);
        goto L14
    L5:
        if (r10.isConnected() == false) goto L7;
        r12 = true;
        goto L23
    }
}
