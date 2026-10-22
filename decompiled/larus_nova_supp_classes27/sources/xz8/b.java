package xz8;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.larus.common.apphost.AppHost;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static int a(Throwable r3) {
            if ((r3 instanceof ConnectTimeoutException) == false) goto L6;
            int r4 = -13;
        L25:
            if (r4 == (-15)) goto L29;
            if (r4 == (-14)) goto L29;
            return r4;
        L29:
            if (b(AppHost.a.getApplication()) == true) goto L32;
            return -12;
        L32:
            return r4;
        L6:
            if ((r3 instanceof SocketTimeoutException) == false) goto L9;
            r4 = -14;
            goto L25
        L9:
            if ((r3 instanceof SocketException) == false) goto L12;
            r3.toString();
        L17:
            r4 = -15;
            goto L25
        L12:
            if ((r3 instanceof SSLPeerUnverifiedException) == false) goto L15;
            r3.toString();
        L20:
            r4 = -21;
            goto L25
        L15:
            if ((r3 instanceof IOException) == false) goto L19;
            r3.toString();
            goto L17
        L19:
            if ((r3 instanceof SSLHandshakeException) == true) goto L20;
            if ((r3 instanceof UnknownHostException) == false) goto L24;
            r4 = -16;
            goto L25
        L24:
            r3.toString();
            r4 = -1;
            goto L25
        }

        public static boolean b(Context r2) {
            if (r2 != null) goto L12;
            return false;
        L12:
            Object r3 = r2.getSystemService("connectivity");     // Catch: Exception -> L11
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L11
            NetworkInfo r4 = ((ConnectivityManager) r3).getActiveNetworkInfo();     // Catch: Exception -> L11
            if (r4 == null) goto L14;
            if (r4.isConnected() == false) goto L15;
            return true;
        L15:
            return false;
        L14:
            return false;
        L16:
            return false;
        }
    }

    static {
    }
}
