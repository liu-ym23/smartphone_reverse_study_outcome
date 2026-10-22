package com.obric.memorydata.middleware.impl.ttnet;

import com.bytedance.common.utility.h;
import com.bytedance.frameworks.baselib.network.http.exception.ClientProtocolException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NoHttpResponseException;
import com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException;
import com.obric.memorydata.middleware.api.log.RunLog;
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

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static int a(Throwable r9, String[] r10) {
        int r0 = 1;
        if (r9 != null) goto L5;
        return 1;
    L5:
        if (r10 != null) goto L8;
        r10 = new String[1];
    L8:
        if (ZeusTransformUtils.instanceOf(r9, HttpResponseException.class) == false) goto L11;
        r0 = ((HttpResponseException) ZeusTransformUtils.preCheckCast(r9, HttpResponseException.class, "com.obric.memorydata.plugin")).getStatusCode();
    L134:
        if (r0 != 2) goto L67;
        String r11 = r9.getMessage();     // Catch: Exception -> L133
        RunLog.INSTANCE.debug("ConvertIOException", "SC_CONNECT_TIMEOUT " + r11);     // Catch: Exception -> L133
        Matcher r12 = Pattern.compile("Connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})):(\\d+) +timed out").matcher(r11);     // Catch: Exception -> L133
        if (r12.matches() == true) goto L60;
    L65:
        RunLog r13 = RunLog.INSTANCE;     // Catch: Exception -> L133
        StringBuilder r14 = new StringBuilder().append("SC_CONNECT_TIMEOUT ip ").append(r10[0]);     // Catch: Exception -> L133
    L66:
        r13.debug("ConvertIOException", r14.toString());     // Catch: Exception -> L133
        return r0;
    L60:
        if (r12.group(3) == null) goto L63;
        r10[0] = r12.group(3);     // Catch: Exception -> L133
        goto L65
    L63:
        if (r12.group(4) == null) goto L65;
        r10[0] = r12.group(4);     // Catch: Exception -> L133
        goto L65
    L67:
        if (r0 != 8) goto L101;
        Throwable r15 = r9.getCause();     // Catch: Exception -> L133
        if (r15 != null) goto L71;
        return r0;
    L71:
        if (ZeusTransformUtils.instanceOf(r15, ConnectException.class) == false) goto L136;
        String r16 = r15.getMessage();     // Catch: Exception -> L133
        RunLog.INSTANCE.debug("ConvertIOException", "SC_CONNECT_EXCEPTION " + r16);     // Catch: Exception -> L133
        Matcher r17 = Pattern.compile("failed to connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})) \\(port \\d+\\)( +after \\d+ms)?: +\\w+ failed: (E[A-Z]+) .*").matcher(r16);     // Catch: Exception -> L133
        String r3 = null;
        if (r17.matches() == true) goto L75;
    L100:
        r13 = RunLog.INSTANCE;     // Catch: Exception -> L133
        r14 = new StringBuilder().append("SC_CONNECT_EXCEPTION ip ").append(r10[0]).append(" ").append(r3);     // Catch: Exception -> L133
        goto L66
    L75:
        if (r17.group(3) == null) goto L78;
        r10[0] = r17.group(3);     // Catch: Exception -> L133
    L80:
        r3 = r17.group(7);     // Catch: Exception -> L133
        if (r3 == null) goto L100;
        if ("ECONNRESET".equals(r3) == false) goto L86;
        r0 = 12;
        goto L100
    L86:
        if ("ECONNREFUSED".equals(r3) == false) goto L89;
        r0 = 13;
        goto L100
    L89:
        if ("EHOSTUNREACH".equals(r3) == false) goto L92;
        r0 = 14;
        goto L100
    L92:
        if ("ENETUNREACH".equals(r3) == false) goto L95;
        r0 = 15;
        goto L100
    L95:
        if ("EADDRNOTAVAIL".equals(r3) == false) goto L98;
        r0 = 16;
        goto L100
    L98:
        if ("EADDRINUSE".equals(r3) == false) goto L100;
        r0 = 17;
        goto L100
    L78:
        if (r17.group(4) == null) goto L80;
        r10[0] = r17.group(4);     // Catch: Exception -> L133
        goto L80
    L136:
        return r0;
    L101:
        if (r0 != 4) goto L137;
        String r18 = r9.getMessage();     // Catch: Exception -> L133
        if (r18.indexOf(" EIO (I/O error)") <= 0) goto L107;
        int r19 = 37;
    L138:
        return r19;
    L107:
        if (ZeusTransformUtils.instanceOf(r9, FileNotFoundException.class) == false) goto L110;
    L139:
        return 33;
    L110:
        if (r18.indexOf(" ENOENT ") > 0) goto L139;
        if (r18.indexOf("No such file or directory") > 0) goto L139;
        if (r18.indexOf(" ENOSPC ") <= 0) goto L117;
    L131:
        r19 = 32;
        goto L138
    L117:
        if (r18.indexOf("No space left on device") > 0) goto L131;
        if (r18.indexOf(" EDQUOT ") <= 0) goto L123;
        r19 = 34;
        goto L138
    L123:
        if (r18.indexOf(" EROFS ") <= 0) goto L126;
        r19 = 35;
        goto L138
    L126:
        if (r18.indexOf(" EACCES ") <= 0) goto L129;
        r19 = 36;
        goto L138
    L129:
        if (r18.indexOf("ERR_TTNET_REQUEST_TIMED_OUT") <= 0) goto L140;
        r19 = 38;
        goto L138
    L140:
        return r0;
    L137:
        return r0;
    L141:
        return r0;
    L11:
        if (ZeusTransformUtils.instanceOf(r9, DownloadFileTooLargeException.class) == false) goto L14;
        r0 = 20;
        goto L134
    L14:
        if (ZeusTransformUtils.instanceOf(r9, ConnectTimeoutException.class) == false) goto L17;
    L15:
        r0 = 2;
        goto L134
    L17:
        if (ZeusTransformUtils.instanceOf(r9, SocketTimeoutException.class) == false) goto L25;
        if (h.a(r9.getMessage()) == false) goto L21;
    L23:
        r0 = 3;
        goto L134
    L21:
        if (r9.getMessage().contains("connect timed out") == false) goto L23;
    L25:
        if (ZeusTransformUtils.instanceOf(r9, BindException.class) == false) goto L28;
        r0 = 7;
        goto L134
    L28:
        if (ZeusTransformUtils.instanceOf(r9, ConnectException.class) == false) goto L31;
        r0 = 8;
        goto L134
    L31:
        if (ZeusTransformUtils.instanceOf(r9, NoRouteToHostException.class) == false) goto L34;
        r0 = 9;
        goto L134
    L34:
        if (ZeusTransformUtils.instanceOf(r9, PortUnreachableException.class) == false) goto L37;
        r0 = 10;
        goto L134
    L37:
        if (ZeusTransformUtils.instanceOf(r9, SocketException.class) == false) goto L44;
        r0 = 5;
        String r1 = r9.getMessage();
        if (r1 == null) goto L134;
        if (r1.indexOf("reset by peer") < 0) goto L134;
        r0 = 6;
        goto L134
    L44:
        if (ZeusTransformUtils.instanceOf(r9, UnknownHostException.class) == false) goto L47;
        r0 = 11;
        goto L134
    L47:
        if (ZeusTransformUtils.instanceOf(r9, NoHttpResponseException.class) == false) goto L50;
        r0 = 18;
        goto L134
    L50:
        if (ZeusTransformUtils.instanceOf(r9, ClientProtocolException.class) == false) goto L53;
        r0 = 19;
        goto L134
    L53:
        if (ZeusTransformUtils.instanceOf(r9, IOException.class) == false) goto L134;
        r0 = 4;
        goto L134
    }
}
