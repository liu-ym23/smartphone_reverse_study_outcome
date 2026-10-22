package x1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.crash.anr.AnrManager;
import okhttp3.z;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f13481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13482b;

    a(Context r10) {
        this.f13482b = 0;
        this.f13481a = r10;
    }

    private static boolean d(Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r11 == null) goto L12;
        if (r11.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    @Override // x1.b
    public long a() {
        return (long) ((Math.random() * 4500.0d) + 500.0d);
    }

    @Override // x1.b
    public long b(z r10) {
        long r11 = c();
        if (r11 != (-1)) goto L5;
        return -1;
    L5:
        if (r10 != null) goto L30;
    L28:
        return r11;
    L30:
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L7:
        if (r10.B() == true) goto L28;
        int r12 = r10.k();     // Catch: Exception -> L26
        if (r12 != 414) goto L11;
    L14:
        String r13 = r10.p("Handshake-Options");     // Catch: Exception -> L26
        if (r13 == null) goto L28;
        String[] r14 = r13.split(";");     // Catch: Exception -> L26
        int r15 = r14.length;     // Catch: Exception -> L26
        int r16 = 0;
    L17:
        if (r16 >= r15) goto L28;
        String r17 = r14[r16];     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r17) == true) goto L25;
        String[] r18 = r17.split("=");     // Catch: Exception -> L26
        if ("reconnect-interval".equals(r18[0]) == false) goto L25;
        String r19 = r18[1];     // Catch: Exception -> L26
        Logger.d("WsChannelSdk_ok", "override retry interval");     // Catch: Exception -> L26
        r11 = Long.parseLong(r19) * 1000;     // Catch: NumberFormatException -> L29 Exception -> L26
        Logger.d("WsChannelSdk_ok", "read response hand shake option : reconnect-interval:" + r11 + " ms");     // Catch: NumberFormatException -> L29 Exception -> L26
    L25:
        r16 = r16 + 1;
        goto L17
    L11:
        if (r12 == 511) goto L14;
        if (r12 != 512) goto L28;
        goto L14
    }

    public long c() {
        if (d(this.f13481a) == true) goto L6;
        return -1;
    L6:
        int r10 = this.f13482b + 1;
        this.f13482b = r10;
        return (long) (Math.min(((long) (1 << r10)) * 5000, AnrManager.ANR_MIN_INTERVAL) + ((Math.random() * 10.0d) * 1000.0d));
    }

    @Override // x1.b
    public void reset() {
        this.f13482b = 0;
    }
}
