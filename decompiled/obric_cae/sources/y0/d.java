package y0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;
import com.obric.oui.window.permission.WebViewActivity;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f13904a;

    public static final void a(StringBuilder r8, int r10) {
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        r8.append("?");
        if (r11 >= (r10 - 1)) goto L7;
        r8.append(",");
    L7:
        r11 = r11 + 1;
        goto L3
    }

    public static void b(int r8, int r10) {
        if (r8 < 0) goto L6;
        if (r8 >= r10) goto L6;
        return;
    L6:
        throw new IndexOutOfBoundsException("index: " + r8 + ", size: " + r10);
    }

    public static void c(int r8, int r10) {
        if (r8 < 0) goto L6;
        if (r8 > r10) goto L6;
        return;
    L6:
        throw new IndexOutOfBoundsException("index: " + r8 + ", size: " + r10);
    }

    public static final boolean d(WebViewActivity r8) {
        Object r10 = r8.getSystemService("connectivity");
        if (r10 == null) goto L19;
        ConnectivityManager r11 = (ConnectivityManager) r10;
        Network r12 = r11.getActiveNetwork();
        if (r12 == null) goto L20;
        NetworkCapabilities r13 = r11.getNetworkCapabilities(r12);
        if (r13 != null) goto L9;
        return false;
    L9:
        if (r13.hasTransport(1) == true) goto L17;
        if (r13.hasTransport(0) == true) goto L17;
        if (r13.hasTransport(3) == true) goto L17;
        return false;
    L17:
        return true;
    L20:
        return false;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public static void e(String r8) {
        Log.d("librarian", r8);
    }

    public static void f(String r8) {
        Log.w("librarian", r8);
    }
}
