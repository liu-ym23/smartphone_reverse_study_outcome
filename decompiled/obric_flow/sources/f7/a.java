package f7;

import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import com.ttnet.org.chromium.net.impl.NetworkExceptionImpl;
import com.ttnet.org.chromium.net.impl.QuicExceptionImpl;
import java.io.EOFException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okhttp3.internal.http.StatusLine;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f16881a = null;

    static {
        f16881a = new HashMap();
    }

    public static void a() {
        HashMap r5 = f16881a;
        if (r5.isEmpty() == false) goto L6;
        HashMap r10 = new HashMap();
        androidx.room.jarjarred.org.antlr.runtime.a.z(101, r10, " Bad Request", 102, " Connection timed out");
        androidx.room.jarjarred.org.antlr.runtime.a.z(103, r10, " Forbidden", 104, " Gateway Time-out");
        androidx.room.jarjarred.org.antlr.runtime.a.z(105, r10, " Internal Server Error", 106, " Not Found");
        androidx.room.jarjarred.org.antlr.runtime.a.z(107, r10, " Request Time-out", 108, " Request-URI Too Large");
        r5.put("HttpResponseException", r10);
        HashMap r11 = new HashMap();
        androidx.room.jarjarred.org.antlr.runtime.a.z(LynxErrorCode.LYNX_ERROR_CODE_RESOURCE, r11, "ERR_ABORTED", LynxErrorCode.LYNX_ERROR_CODE_COMPONENT_NOT_EXIST, "ERR_ADDRESS_UNREACHABLE");
        androidx.room.jarjarred.org.antlr.runtime.a.z(303, r11, "ERR_CERT_AUTHORITY_INVALID", 304, "ERR_CERT_COMMON_NAME_INVALID");
        androidx.room.jarjarred.org.antlr.runtime.a.z(305, r11, "ERR_CERT_DATE_INVALID", 306, "ERR_CONNECTION_ABORTED");
        androidx.room.jarjarred.org.antlr.runtime.a.z(StatusLine.HTTP_TEMP_REDIRECT, r11, "ERR_CONNECTION_CLOSED", StatusLine.HTTP_PERM_REDIRECT, "ERR_CONNECTION_REFUSED");
        androidx.room.jarjarred.org.antlr.runtime.a.z(309, r11, "ERR_CONNECTION_RESET", 310, "ERR_CONNECTION_TIMED_OUT");
        androidx.room.jarjarred.org.antlr.runtime.a.z(311, r11, "ERR_EMPTY_RESPONSE", 312, "ERR_HTTP2_PING_FAILED");
        androidx.room.jarjarred.org.antlr.runtime.a.z(313, r11, "ERR_INCOMPLETE_CHUNKED_ENCODING", 314, "ERR_INTERNET_DISCONNECTED");
        androidx.room.jarjarred.org.antlr.runtime.a.z(315, r11, "ERR_NAME_NOT_RESOLVED", 316, "ERR_NETWORK_ACCESS_DENIED");
        androidx.room.jarjarred.org.antlr.runtime.a.z(317, r11, "ERR_PROXY_CONNECTION_FAILED", 318, "ERR_SOCKET_NOT_CONNECTED");
        androidx.room.jarjarred.org.antlr.runtime.a.z(319, r11, "ERR_SSL_BAD_RECORD_MAC_ALERT", 320, "ERR_SSL_PROTOCOL_ERROR");
        androidx.room.jarjarred.org.antlr.runtime.a.z(321, r11, "ERR_TIMED_OUT", 322, "ERR_TTNET_APP_TIMED_OUT");
        androidx.room.jarjarred.org.antlr.runtime.a.z(323, r11, "ERR_TTNET_APP_UPLOAD_EXCEPTION", 324, "ERR_TUNNEL_CONNECTION_FAILED");
        r5.put(NetworkExceptionImpl.class.getSimpleName(), r11);
        HashMap r12 = new HashMap();
        r12.put("ERR_NETWORK_CHANGED", Integer.valueOf(LynxErrorCode.LYNX_ERROR_CODE_UPDATE));
        r5.put(QuicExceptionImpl.class.getSimpleName(), r12);
        HashMap r13 = new HashMap();
        r13.put(" Unexpected end of ZLIB input stream", Integer.valueOf(LynxErrorCode.LYNX_ERROR_CODE_CANVAS));
        r5.put("EOFException", r13);
        HashMap r14 = new HashMap();
        androidx.room.jarjarred.org.antlr.runtime.a.z(LynxErrorCode.LYNX_ERROR_EXCEPTION, r14, " unexpected end of stream on Connection", 602, " Unexpected request usage");
        r5.put("IOException", r14);
        HashMap r15 = new HashMap();
        r15.put("Cronet internal request fail", 701);
        r5.put("Exception", r15);
        HashMap r16 = new HashMap();
        androidx.room.jarjarred.org.antlr.runtime.a.z(801, r16, " Content received is less than Content-Length", 802, " expected bytes but received");
        r16.put(" unexpected end of stream", 803);
        r5.put("ProtocolException", r16);
        HashMap r17 = new HashMap();
        androidx.room.jarjarred.org.antlr.runtime.a.z(LynxErrorCode.LYNX_ERROR_CODE_MODULE_FUNC_NOT_EXIST, r17, " Connection closed by peer", LynxErrorCode.LYNX_ERROR_CODE_MODULE_FUNC_WRONG_ARG_NUM, " Read error");
        r17.put(" SSL handshake aborted", Integer.valueOf(LynxErrorCode.LYNX_ERROR_CODE_MODULE_FUNC_WRONG_ARG_TYPE));
        r5.put("SSLException", r17);
        HashMap r18 = new HashMap();
        androidx.room.jarjarred.org.antlr.runtime.a.z(1001, r18, " Connection closed by peer", PointerIconCompat.TYPE_HAND, " Handshake failed");
        r18.put(" SSL handshake aborted", Integer.valueOf(PointerIconCompat.TYPE_HELP));
        r5.put("SSLHandshakeException", r18);
        HashMap r19 = new HashMap();
        r19.put(" Hostname not verified", 1101);
        r5.put("SSLPeerUnverifiedException", r19);
        HashMap r20 = new HashMap();
        r20.put(" Read error", Integer.valueOf(LynxErrorCode.LYNX_ERROR_MAIN_FLOW));
        r5.put("SSLProtocolException", r20);
        return;
    }

    public static int b(Throwable r5) {
        int r10 = -1;
        if (r5 != null) goto L5;
        return -1;
    L5:
        a();
        String r11 = r5.getMessage();
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return -1;
    L8:
        int r12 = r11.indexOf(44);
        if (r12 <= 0) goto L11;
        r11 = r11.substring(0, r12);
    L11:
        Map r13 = (Map) f16881a.get(r5.getClass().getSimpleName());
        if (r13 != null) goto L14;
    L23:
        if (r10 < 0) goto L25;
        return r10;
    L25:
        if ((r5 instanceof HttpResponseException) == false) goto L28;
        return 199;
    L28:
        if ((r5 instanceof EOFException) == false) goto L31;
        return 599;
    L31:
        if ((r5 instanceof IOException) == false) goto L40;
        return 699;
    L40:
        return r10;
    L14:
        if (r13.isEmpty() == true) goto L23;
        Iterator r14 = r13.entrySet().iterator();
    L17:
        if (r14.hasNext() == false) goto L23;
        Map.Entry r15 = (Map.Entry) r14.next();
        if (r11.contains((CharSequence) r15.getKey()) == false) goto L17;
        Integer r16 = (Integer) r15.getValue();
        if (r16 == null) goto L23;
        r10 = r16.intValue();
        goto L23
    }

    public static void c(vj.a r5, JSONObject r10) {
        if (r10 == null) goto L9;
        if (r5 == null) goto L10;
        r10.put("requestHeader", r5.f21871r);     // Catch: Throwable -> L6
        r10.put("responseHeader", r5.s);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L10:
        return;
    }
}
