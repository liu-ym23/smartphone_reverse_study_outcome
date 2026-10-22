package a6;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import we.a0;

/* JADX INFO: loaded from: classes.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f55a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f56b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f57c;

    public b(Context r8) {
        this.f56b = 0;
        this.f55a = r8;
    }

    public final long a(a0 r14) {
        if (this.f57c < 4) goto L50;
    L14:
        long r8 = -1;
    L16:
        if (r8 == (-1)) goto L18;
        this.f57c++;
    L18:
        if (r8 == (-1)) goto L56;
        if (r14 == null) goto L44;
    L41:
        e = move-exception;
        e.printStackTrace();
        goto L44
    L22:
        if (r14.r() == true) goto L44;
        int r13 = r14.f13116m;     // Catch: Exception -> L41
        if (r13 != 414) goto L26;
    L29:
        String r15 = r14.n("Handshake-Options");     // Catch: Exception -> L41
        if (r15 == null) goto L44;
        String[] r16 = r15.split(";");     // Catch: Exception -> L41
        int r17 = r16.length;     // Catch: Exception -> L41
        int r10 = 0;
    L32:
        if (r10 >= r17) goto L44;
        String r11 = r16[r10];     // Catch: Exception -> L41
        if (TextUtils.isEmpty(r11) == true) goto L40;
        String[] r12 = r11.split("=");     // Catch: Exception -> L41
        if ("reconnect-interval".equals(r12[0]) == false) goto L40;
        String r18 = r12[1];     // Catch: Exception -> L41
        Logger.d("WsChannelSdk_ok", "override retry interval");     // Catch: Exception -> L41
        r8 = 1000 * Long.parseLong(r18);     // Catch: NumberFormatException -> L45 Exception -> L41
        Logger.d("WsChannelSdk_ok", "read response hand shake option : reconnect-interval:" + r8 + " ms");     // Catch: NumberFormatException -> L45 Exception -> L41
    L40:
        r10 = r10 + 1;
        goto L32
    L26:
        if (r13 == 511) goto L29;
        if (r13 == 512) goto L29;
    L44:
        return r8;
    L56:
        return -1;
    L50:
        NetworkInfo r19 = ((ConnectivityManager) this.f55a.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L46
        if (r19 == null) goto L10;
        if (r19.isAvailable() == false) goto L10;
        boolean r20 = true;
    L11:
        if (r20 == false) goto L14;
        int r21 = this.f56b + 1;
        this.f56b = r21;
        r8 = (long) (((Math.random() * 10.0d) * 1000.0d) + Math.min(((long) (1 << r21)) * 5000, 120000));
    L10:
        r20 = false;
        goto L11
    }

    public final String toString() {
        return android.aimedia.a.f(new StringBuilder("RetryTimesPolicy{mMaxRetryTime=4, mCurrRetryTime="), this.f57c, '}');
    }
}
