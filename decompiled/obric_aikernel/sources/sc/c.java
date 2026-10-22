package sc;

import android.text.TextUtils;
import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static int a(IOException r10, int r11) {
        if (r10 != null) goto L21;
        return r11;
    L21:
        int r12 = b(r10.getMessage(), r11);     // Catch: Throwable -> L18
        if (r12 == r11) goto L19;
        return r12;
    L19:
        Throwable r13 = r10.getCause();     // Catch: Throwable -> L15
        if (r13 != null) goto L10;
        return r12;
    L10:
        String r14 = r13.getMessage();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r14) == false) goto L13;
        return r12;
    L13:
        return b(r14, r11);
    L15:
        r11 = r12;
    L17:
        return r11;
    }

    private static int b(String r10, int r11) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r11;
    L6:
        if (r10.contains("ECONNRESET") == false) goto L8;
    L39:
        return -101;
    L8:
        if (r10.contains("Connection reset") == true) goto L39;
        if (r10.contains("reset by peer") == true) goto L39;
        if (r10.contains("ECONNREFUSED") == false) goto L16;
        return NetError.ERR_CONNECTION_REFUSED;
    L16:
        if (r10.contains("CONNECTION_ABORTED") == false) goto L18;
    L38:
        return NetError.ERR_CONNECTION_ABORTED;
    L18:
        if (r10.contains("connection abort") == true) goto L38;
        if (r10.contains("ENETDOWN") == false) goto L23;
    L37:
        return NetError.ERR_INTERNET_DISCONNECTED;
    L23:
        if (r10.contains("Network is unreachable") == true) goto L37;
        if (r10.contains("EHOSTUNREACH") == false) goto L28;
    L36:
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L28:
        if (r10.contains("ENETUNREACH") == true) goto L36;
        if (r10.contains("EADDRNOTAVAIL") == false) goto L34;
        return NetError.ERR_ADDRESS_INVALID;
    L34:
        if (r10.contains("EADDRINUSE") == false) goto L43;
        return NetError.ERR_ADDRESS_IN_USE;
    L43:
        return r11;
    }

    public static int c(IOException r10) {
        if ((r10 instanceof SSLHandshakeException) == false) goto L6;
        return NetError.ERR_SSL_HANDSHAKE_NOT_COMPLETED;
    L6:
        if ((r10 instanceof SSLKeyException) == false) goto L9;
        return NetError.ERR_SSL_BAD_PEER_PUBLIC_KEY;
    L9:
        if ((r10 instanceof SSLProtocolException) == false) goto L12;
        return NetError.ERR_SSL_PROTOCOL_ERROR;
    L12:
        if ((r10 instanceof SSLPeerUnverifiedException) == false) goto L15;
        return NetError.ERR_SSL_DECRYPT_ERROR_ALERT;
    L15:
        if ((r10 instanceof UnknownHostException) == false) goto L18;
        return NetError.ERR_NAME_NOT_RESOLVED;
    L18:
        if ((r10 instanceof ConnectException) == false) goto L22;
        int r11 = NetError.ERR_CONNECTION_FAILED;
    L67:
        return a(r10, r11);
    L22:
        if ((r10 instanceof PortUnreachableException) == false) goto L25;
        return NetError.ERR_ADDRESS_INVALID;
    L25:
        if ((r10 instanceof NoRouteToHostException) == false) goto L28;
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L28:
        if ((r10 instanceof BindException) == false) goto L31;
        return NetError.ERR_ADDRESS_IN_USE;
    L31:
        if ((r10 instanceof SocketException) == false) goto L34;
        r11 = -15;
        goto L67
    L34:
        if ((r10 instanceof MalformedURLException) == false) goto L37;
        return NetError.ERR_INVALID_URL;
    L37:
        if ((r10 instanceof SocketTimeoutException) == false) goto L40;
        return NetError.ERR_CONNECTION_TIMED_OUT;
    L40:
        if ((r10 instanceof ProtocolException) == false) goto L43;
        return -901;
    L43:
        if ((r10 instanceof HttpRetryException) == false) goto L51;
        String r12 = r10.getMessage();
        if (TextUtils.isEmpty(r12) == true) goto L75;
        if (r12.contains("Too many follow-up requests") == false) goto L75;
        return NetError.ERR_TOO_MANY_REDIRECTS;
    L75:
        return NetError.ERR_TTNET_UNSUPPORTED_REDIRECT;
    L51:
        if ((r10 instanceof UnknownServiceException) == false) goto L53;
        return -902;
    L53:
        if (r10 == null) goto L58;
        if ("Canceled#Reason=-199".equals(r10.getMessage()) == false) goto L58;
        return d.f12809b;
    L58:
        if (d(r10) == true) goto L78;
        return -1;
    L78:
        return d.f12808a;
    }

    public static boolean d(IOException r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if ("Canceled#Reason=-192".equals(r10.getMessage()) == false) goto L9;
        return true;
    L9:
        if ((r10 instanceof InterruptedIOException) == false) goto L17;
        Throwable r11 = r10.getCause();
        if (r11 == null) goto L17;
        if (TextUtils.isEmpty(r11.getMessage()) == true) goto L17;
        if ("Canceled#Reason=-192".equals(r11.getMessage()) == false) goto L17;
        return true;
    L17:
        return false;
    }
}
