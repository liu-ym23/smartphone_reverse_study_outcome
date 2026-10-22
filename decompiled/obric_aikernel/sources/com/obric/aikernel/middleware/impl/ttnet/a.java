package com.obric.aikernel.middleware.impl.ttnet;

import com.bytedance.common.utility.g;
import com.bytedance.frameworks.baselib.network.http.exception.ClientProtocolException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NoHttpResponseException;
import com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException;
import com.obric.aikernel.middleware.api.log.AIKLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static int a(Throwable r10, String[] r11) {
        int r12 = 1;
        if (r10 != null) goto L5;
        return 1;
    L5:
        if (r11 != null) goto L8;
        r11 = new String[1];
    L8:
        if ((r10 instanceof HttpResponseException) == false) goto L11;
        r12 = ((HttpResponseException) r10).getStatusCode();
    L133:
        if (r12 != 2) goto L66;
        String r13 = r10.getMessage();     // Catch: Exception -> L132
        AIKLog r14 = AIKLog.INSTANCE;     // Catch: Exception -> L132
        r14.d("ConvertIOException", "SC_CONNECT_TIMEOUT " + r13);     // Catch: Exception -> L132
        Matcher r15 = Pattern.compile("Connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})):(\\d+) +timed out").matcher(r13);     // Catch: Exception -> L132
        if (r15.matches() == true) goto L60;
    L65:
        r14.d("ConvertIOException", "SC_CONNECT_TIMEOUT ip " + r11[0]);     // Catch: Exception -> L132
        return r12;
    L60:
        if (r15.group(3) == null) goto L63;
        r11[0] = r15.group(3);     // Catch: Exception -> L132
        goto L65
    L63:
        if (r15.group(4) == null) goto L65;
        r11[0] = r15.group(4);     // Catch: Exception -> L132
        goto L65
    L66:
        if (r12 != 8) goto L100;
        Throwable r16 = r10.getCause();     // Catch: Exception -> L132
        if (r16 != null) goto L70;
        return r12;
    L70:
        if ((r16 instanceof ConnectException) == false) goto L135;
        String r17 = r16.getMessage();     // Catch: Exception -> L132
        AIKLog r18 = AIKLog.INSTANCE;     // Catch: Exception -> L132
        r18.d("ConvertIOException", "SC_CONNECT_EXCEPTION " + r17);     // Catch: Exception -> L132
        Matcher r19 = Pattern.compile("failed to connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})) \\(port \\d+\\)( +after \\d+ms)?: +\\w+ failed: (E[A-Z]+) .*").matcher(r17);     // Catch: Exception -> L132
        String r20 = null;
        if (r19.matches() == true) goto L74;
    L99:
        r18.d("ConvertIOException", "SC_CONNECT_EXCEPTION ip " + r11[0] + " " + r20);     // Catch: Exception -> L132
        return r12;
    L74:
        if (r19.group(3) == null) goto L77;
        r11[0] = r19.group(3);     // Catch: Exception -> L132
    L79:
        r20 = r19.group(7);     // Catch: Exception -> L132
        if (r20 == null) goto L99;
        if ("ECONNRESET".equals(r20) == false) goto L85;
        r12 = 12;
        goto L99
    L85:
        if ("ECONNREFUSED".equals(r20) == false) goto L88;
        r12 = 13;
        goto L99
    L88:
        if ("EHOSTUNREACH".equals(r20) == false) goto L91;
        r12 = 14;
        goto L99
    L91:
        if ("ENETUNREACH".equals(r20) == false) goto L94;
        r12 = 15;
        goto L99
    L94:
        if ("EADDRNOTAVAIL".equals(r20) == false) goto L97;
        r12 = 16;
        goto L99
    L97:
        if ("EADDRINUSE".equals(r20) == false) goto L99;
        r12 = 17;
        goto L99
    L77:
        if (r19.group(4) == null) goto L79;
        r11[0] = r19.group(4);     // Catch: Exception -> L132
        goto L79
    L135:
        return r12;
    L100:
        if (r12 != 4) goto L137;
        String r110 = r10.getMessage();     // Catch: Exception -> L132
        if (r110.indexOf(" EIO (I/O error)") <= 0) goto L106;
        int r21 = 37;
    L138:
        return r21;
    L106:
        if ((r10 instanceof FileNotFoundException) == false) goto L109;
    L139:
        return 33;
    L109:
        if (r110.indexOf(" ENOENT ") > 0) goto L139;
        if (r110.indexOf("No such file or directory") > 0) goto L139;
        if (r110.indexOf(" ENOSPC ") <= 0) goto L116;
    L130:
        r21 = 32;
        goto L138
    L116:
        if (r110.indexOf("No space left on device") > 0) goto L130;
        if (r110.indexOf(" EDQUOT ") <= 0) goto L122;
        r21 = 34;
        goto L138
    L122:
        if (r110.indexOf(" EROFS ") <= 0) goto L125;
        r21 = 35;
        goto L138
    L125:
        if (r110.indexOf(" EACCES ") <= 0) goto L128;
        r21 = 36;
        goto L138
    L128:
        if (r110.indexOf("ERR_TTNET_REQUEST_TIMED_OUT") <= 0) goto L140;
        r21 = 38;
        goto L138
    L140:
        return r12;
    L137:
        return r12;
    L141:
        return r12;
    L11:
        if ((r10 instanceof DownloadFileTooLargeException) == false) goto L14;
        r12 = 20;
        goto L133
    L14:
        if ((r10 instanceof ConnectTimeoutException) == false) goto L17;
    L15:
        r12 = 2;
        goto L133
    L17:
        if ((r10 instanceof SocketTimeoutException) == false) goto L25;
        if (g.b(r10.getMessage()) == false) goto L21;
    L23:
        r12 = 3;
        goto L133
    L21:
        if (r10.getMessage().contains("connect timed out") == false) goto L23;
    L25:
        if ((r10 instanceof BindException) == false) goto L28;
        r12 = 7;
        goto L133
    L28:
        if ((r10 instanceof ConnectException) == false) goto L31;
        r12 = 8;
        goto L133
    L31:
        if ((r10 instanceof NoRouteToHostException) == false) goto L34;
        r12 = 9;
        goto L133
    L34:
        if ((r10 instanceof PortUnreachableException) == false) goto L37;
        r12 = 10;
        goto L133
    L37:
        if ((r10 instanceof SocketException) == false) goto L44;
        r12 = 5;
        String r22 = r10.getMessage();
        if (r22 == null) goto L133;
        if (r22.indexOf("reset by peer") < 0) goto L133;
        r12 = 6;
        goto L133
    L44:
        if ((r10 instanceof UnknownHostException) == false) goto L47;
        r12 = 11;
        goto L133
    L47:
        if ((r10 instanceof NoHttpResponseException) == false) goto L50;
        r12 = 18;
        goto L133
    L50:
        if ((r10 instanceof ClientProtocolException) == false) goto L53;
        r12 = 19;
        goto L133
    L53:
        if ((r10 instanceof IOException) == false) goto L133;
        r12 = 4;
        goto L133
    }
}
