package com.obric.cae.cloud.ttnet;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.h;
import com.bytedance.frameworks.baselib.network.http.exception.ClientProtocolException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NoHttpResponseException;
import com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static int a(Throwable r12, String[] r13) {
        int r4 = 1;
        if (r12 != null) goto L5;
        return 1;
    L5:
        if (r13 != null) goto L8;
        r13 = new String[1];
    L8:
        if (ZeusTransformUtils.instanceOf(r12, HttpResponseException.class) == false) goto L11;
        r4 = ((HttpResponseException) ZeusTransformUtils.preCheckCast(r12, HttpResponseException.class, "com.obric.memorydata.plugin")).getStatusCode();
    L145:
        if (r4 != 2) goto L72;
        String r14 = r12.getMessage();     // Catch: Exception -> L144
        if (Logger.debug() == false) goto L60;
        Logger.d("ConvertIOException", "SC_CONNECT_TIMEOUT " + r14);     // Catch: Exception -> L144
    L60:
        Matcher r15 = Pattern.compile("Connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})):(\\d+) +timed out").matcher(r14);     // Catch: Exception -> L144
        if (r15.matches() == false) goto L69;
        if (r15.group(3) == null) goto L66;
        r13[0] = r15.group(3);     // Catch: Exception -> L144
        goto L69
    L66:
        if (r15.group(4) == null) goto L69;
        r13[0] = r15.group(4);     // Catch: Exception -> L144
    L69:
        if (Logger.debug() == false) goto L146;
        StringBuilder r16 = new StringBuilder("SC_CONNECT_TIMEOUT ip ").append(r13[0]);     // Catch: Exception -> L144
    L71:
        Logger.d("ConvertIOException", r16.toString());     // Catch: Exception -> L144
        return r4;
    L146:
        return r4;
    L72:
        if (r4 != 8) goto L112;
        Throwable r17 = r12.getCause();     // Catch: Exception -> L144
        if (r17 != null) goto L76;
        return r4;
    L76:
        if (ZeusTransformUtils.instanceOf(r17, ConnectException.class) == false) goto L149;
        String r18 = r17.getMessage();     // Catch: Exception -> L144
        if (Logger.debug() == false) goto L80;
        Logger.d("ConvertIOException", "SC_CONNECT_EXCEPTION " + r18);     // Catch: Exception -> L144
    L80:
        Matcher r19 = Pattern.compile("failed to connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})) \\(port \\d+\\)( +after \\d+ms)?: +\\w+ failed: (E[A-Z]+) .*").matcher(r18);     // Catch: Exception -> L144
        String r1 = null;
        if (r19.matches() == false) goto L110;
        if (r19.group(3) == null) goto L86;
        r13[0] = r19.group(3);     // Catch: Exception -> L144
    L88:
        r1 = r19.group(7);     // Catch: Exception -> L144
        if (r1 == null) goto L110;
        if ("ECONNRESET".equals(r1) == false) goto L95;
        int r110 = 12;
    L93:
        r4 = r110;
        goto L110
    L95:
        if ("ECONNREFUSED".equals(r1) == false) goto L98;
        r110 = 13;
        goto L93
    L98:
        if ("EHOSTUNREACH".equals(r1) == false) goto L101;
        r110 = 14;
        goto L93
    L101:
        if ("ENETUNREACH".equals(r1) == false) goto L104;
        r110 = 15;
        goto L93
    L104:
        if ("EADDRNOTAVAIL".equals(r1) == false) goto L107;
        r110 = 16;
        goto L93
    L107:
        if ("EADDRINUSE".equals(r1) == false) goto L110;
        r110 = 17;
        goto L93
    L86:
        if (r19.group(4) == null) goto L88;
        r13[0] = r19.group(4);     // Catch: Exception -> L144
    L110:
        if (Logger.debug() == false) goto L150;
        r16 = new StringBuilder("SC_CONNECT_EXCEPTION ip ").append(r13[0]).append(" ").append(r1);     // Catch: Exception -> L144
        goto L71
    L150:
        return r4;
    L149:
        return r4;
    L112:
        if (r4 != 4) goto L151;
        String r111 = r12.getMessage();     // Catch: Exception -> L144
        if (r111.indexOf(" EIO (I/O error)") <= 0) goto L117;
        return 37;
    L117:
        if (ZeusTransformUtils.instanceOf(r12, FileNotFoundException.class) == false) goto L120;
    L142:
        return 33;
    L120:
        if (r111.indexOf(" ENOENT ") > 0) goto L142;
        if (r111.indexOf("No such file or directory") > 0) goto L142;
        if (r111.indexOf(" ENOSPC ") <= 0) goto L127;
    L141:
        return 32;
    L127:
        if (r111.indexOf("No space left on device") > 0) goto L141;
        if (r111.indexOf(" EDQUOT ") <= 0) goto L133;
        return 34;
    L133:
        if (r111.indexOf(" EROFS ") <= 0) goto L136;
        return 35;
    L136:
        if (r111.indexOf(" EACCES ") <= 0) goto L139;
        return 36;
    L139:
        if (r111.indexOf("ERR_TTNET_REQUEST_TIMED_OUT") <= 0) goto L156;
        return 38;
    L156:
        return r4;
    L151:
        return r4;
    L159:
        return r4;
    L11:
        if (ZeusTransformUtils.instanceOf(r12, DownloadFileTooLargeException.class) == false) goto L14;
        r4 = 20;
        goto L145
    L14:
        if (ZeusTransformUtils.instanceOf(r12, ConnectTimeoutException.class) == false) goto L17;
    L22:
        r4 = 2;
        goto L145
    L17:
        if (ZeusTransformUtils.instanceOf(r12, SocketTimeoutException.class) == false) goto L25;
        if (h.a(r12.getMessage()) == false) goto L21;
    L23:
        r4 = 3;
        goto L145
    L21:
        if (r12.getMessage().contains("connect timed out") == false) goto L23;
    L25:
        if (ZeusTransformUtils.instanceOf(r12, BindException.class) == false) goto L28;
        r4 = 7;
        goto L145
    L28:
        if (ZeusTransformUtils.instanceOf(r12, ConnectException.class) == false) goto L31;
        r4 = 8;
        goto L145
    L31:
        if (ZeusTransformUtils.instanceOf(r12, NoRouteToHostException.class) == false) goto L34;
        r4 = 9;
        goto L145
    L34:
        if (ZeusTransformUtils.instanceOf(r12, PortUnreachableException.class) == false) goto L37;
        r4 = 10;
        goto L145
    L37:
        if (ZeusTransformUtils.instanceOf(r12, SocketException.class) == false) goto L44;
        r4 = 5;
        String r5 = r12.getMessage();
        if (r5 == null) goto L145;
        if (r5.indexOf("reset by peer") < 0) goto L145;
        r4 = 6;
        goto L145
    L44:
        if (ZeusTransformUtils.instanceOf(r12, UnknownHostException.class) == false) goto L47;
        r4 = 11;
        goto L145
    L47:
        if (ZeusTransformUtils.instanceOf(r12, NoHttpResponseException.class) == false) goto L50;
        r4 = 18;
        goto L145
    L50:
        if (ZeusTransformUtils.instanceOf(r12, ClientProtocolException.class) == false) goto L53;
        r4 = 19;
        goto L145
    L53:
        if (ZeusTransformUtils.instanceOf(r12, IOException.class) == false) goto L145;
        r4 = 4;
        goto L145
    }
}
