package nc;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
public interface k {

    public static final class a {
        public static boolean a(k r10, SSLSocketFactory r11) {
            Intrinsics.checkNotNullParameter(r11, "sslSocketFactory");
            return false;
        }

        public static X509TrustManager b(k r10, SSLSocketFactory r11) {
            Intrinsics.checkNotNullParameter(r11, "sslSocketFactory");
            return null;
        }
    }

    boolean a(SSLSocket r10);

    String b(SSLSocket r10);

    X509TrustManager c(SSLSocketFactory r10);

    boolean d(SSLSocketFactory r10);

    void e(SSLSocket r10, String r11, List<? extends Protocol> r12);

    boolean isSupported();
}
