package com.obric.cae.cloud.ttnet;

import b7.b;
import com.bytedance.common.utility.Logger;
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
import r5.f;

/* JADX INFO: loaded from: classes.dex */
public final class ConvertIOException {
    public static final int SC_BIND_EXCEPTION = 7;
    public static final int SC_CLIENT_PROTOCOL_EXCEPTION = 19;
    public static final int SC_CONNECT_EXCEPTION = 8;
    public static final int SC_CONNECT_TIMEOUT = 2;
    public static final int SC_EACCES = 36;
    public static final int SC_EADDRINUSE = 17;
    public static final int SC_EADDRNOTAVAIL = 16;
    public static final int SC_ECONNREFUSED = 13;
    public static final int SC_ECONNRESET = 12;
    public static final int SC_EDQUOT = 34;
    public static final int SC_EHOSTUNREACH = 14;
    public static final int SC_EIO = 37;
    public static final int SC_ENETUNREACH = 15;
    public static final int SC_ENOENT = 33;
    public static final int SC_EROFS = 35;
    public static final int SC_FILE_TOO_LARGE = 20;
    public static final int SC_IO_EXCEPTION = 4;
    public static final int SC_NO_HTTP_RESPONSE = 18;
    public static final int SC_NO_REOUTE_TO_HOST = 9;
    public static final int SC_NO_SPACE = 32;
    public static final int SC_PORT_UNREACHABLE = 10;
    public static final int SC_RESET_BY_PEER = 6;
    public static final int SC_SOCKET_EXCEPTION = 5;
    public static final int SC_SOCKET_TIMEOUT = 3;
    public static final int SC_TTNET_TIME_OUT = 38;
    public static final int SC_UNKNOWN = 1;
    public static final int SC_UNKNOWN_HOST = 11;
    public static final String TAG = "ConvertIOException";

    private ConvertIOException() {
    }

    public static int ConvertIOExceptionToStatus(Throwable r12, String[] r13) {
        int r8 = 1;
        if (r12 != null) goto L5;
        return 1;
    L5:
        if (r13 != null) goto L7;
        r13 = new String[1];
    L7:
        boolean r10 = r12 instanceof b;
        if (r10 == false) goto L11;
        r8 = ((b) r12).f3131a;
    L143:
        if (r8 != 2) goto L69;
        String r14 = r12.getMessage();     // Catch: Exception -> L142
        if (Logger.debug() == false) goto L57;
        Logger.d(TAG, "SC_CONNECT_TIMEOUT " + r14);     // Catch: Exception -> L142
    L57:
        Matcher r15 = Pattern.compile("Connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})):(\\d+) +timed out").matcher(r14);     // Catch: Exception -> L142
        if (r15.matches() == false) goto L66;
        if (r15.group(3) == null) goto L63;
        r13[0] = r15.group(3);     // Catch: Exception -> L142
        goto L66
    L63:
        if (r15.group(4) == null) goto L66;
        r13[0] = r15.group(4);     // Catch: Exception -> L142
    L66:
        if (Logger.debug() == false) goto L141;
        String r16 = "SC_CONNECT_TIMEOUT ip " + r13[0];     // Catch: Exception -> L142
    L68:
        Logger.d(TAG, r16);     // Catch: Exception -> L142
        return r8;
    L141:
        return r8;
    L69:
        if (r8 != 8) goto L110;
        Throwable r17 = r12.getCause();     // Catch: Exception -> L142
        if (r17 != null) goto L73;
        return r8;
    L73:
        if ((r17 instanceof ConnectException) == false) goto L146;
        String r18 = r17.getMessage();     // Catch: Exception -> L142
        if (Logger.debug() == false) goto L77;
        Logger.d(TAG, "SC_CONNECT_EXCEPTION " + r18);     // Catch: Exception -> L142
    L77:
        Matcher r19 = Pattern.compile("failed to connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})) \\(port \\d+\\)( +after \\d+ms)?: +\\w+ failed: (E[A-Z]+) .*").matcher(r18);     // Catch: Exception -> L142
        if (r19.matches() == true) goto L80;
        String r110 = null;
    L108:
        if (Logger.debug() == false) goto L147;
        r16 = "SC_CONNECT_EXCEPTION ip " + r13[0] + " " + r110;     // Catch: Exception -> L142
        goto L68
    L147:
        return r8;
    L80:
        if (r19.group(3) == null) goto L83;
        r13[0] = r19.group(3);     // Catch: Exception -> L142
    L85:
        r110 = r19.group(7);     // Catch: Exception -> L142
        if (r110 == null) goto L108;
        if ("ECONNRESET".equals(r110) == false) goto L92;
        int r11 = 12;
    L90:
        r8 = r11;
        goto L108
    L92:
        if ("ECONNREFUSED".equals(r110) == false) goto L95;
        r11 = 13;
        goto L90
    L95:
        if ("EHOSTUNREACH".equals(r110) == false) goto L98;
        r11 = 14;
        goto L90
    L98:
        if ("ENETUNREACH".equals(r110) == false) goto L101;
        r11 = 15;
        goto L90
    L101:
        if ("EADDRNOTAVAIL".equals(r110) == false) goto L104;
        r11 = 16;
        goto L90
    L104:
        if ("EADDRINUSE".equals(r110) == false) goto L108;
        r11 = 17;
        goto L90
    L83:
        if (r19.group(4) == null) goto L85;
        r13[0] = r19.group(4);     // Catch: Exception -> L142
        goto L85
    L146:
        return r8;
    L110:
        if (r8 != 4) goto L148;
        String r111 = r12.getMessage();     // Catch: Exception -> L142
        if (r111.indexOf(" EIO (I/O error)") <= 0) goto L116;
        int r112 = 37;
    L149:
        return r112;
    L116:
        if ((r12 instanceof FileNotFoundException) == false) goto L119;
    L150:
        return 33;
    L119:
        if (r111.indexOf(" ENOENT ") > 0) goto L150;
        if (r111.indexOf("No such file or directory") > 0) goto L150;
        if (r111.indexOf(" ENOSPC ") <= 0) goto L126;
    L140:
        r112 = 32;
        goto L149
    L126:
        if (r111.indexOf("No space left on device") > 0) goto L140;
        if (r111.indexOf(" EDQUOT ") <= 0) goto L132;
        r112 = 34;
        goto L149
    L132:
        if (r111.indexOf(" EROFS ") <= 0) goto L135;
        r112 = 35;
        goto L149
    L135:
        if (r111.indexOf(" EACCES ") <= 0) goto L138;
        r112 = 36;
        goto L149
    L138:
        if (r111.indexOf("ERR_TTNET_REQUEST_TIMED_OUT") <= 0) goto L151;
        r112 = 38;
        goto L149
    L151:
        return r8;
    L148:
        return r8;
    L152:
        return r8;
    L11:
        if ((r12 instanceof l7.b) == false) goto L14;
        r8 = 20;
        goto L143
    L14:
        if ((r12 instanceof ConnectTimeoutException) == false) goto L17;
    L15:
        r8 = 2;
        goto L143
    L17:
        if ((r12 instanceof SocketTimeoutException) == false) goto L25;
        if (f.b(r12.getMessage()) == false) goto L21;
    L23:
        r8 = 3;
        goto L143
    L21:
        if (r12.getMessage().contains("connect timed out") == false) goto L23;
    L25:
        if ((r12 instanceof BindException) == false) goto L28;
        r8 = 7;
        goto L143
    L28:
        if ((r12 instanceof ConnectException) == false) goto L31;
        r8 = 8;
        goto L143
    L31:
        if ((r12 instanceof NoRouteToHostException) == false) goto L34;
        r8 = 9;
        goto L143
    L34:
        if ((r12 instanceof PortUnreachableException) == false) goto L37;
        r8 = 10;
        goto L143
    L37:
        if ((r12 instanceof SocketException) == false) goto L45;
        String r20 = r12.getMessage();
        if (r20 != null) goto L41;
    L43:
        r8 = 5;
        goto L143
    L41:
        if (r20.indexOf("reset by peer") < 0) goto L43;
        r8 = 6;
        goto L143
    L45:
        if ((r12 instanceof UnknownHostException) == false) goto L47;
        r8 = 11;
        goto L143
    L47:
        if (r10 == false) goto L50;
        r8 = 19;
        goto L143
    L50:
        if ((r12 instanceof IOException) == false) goto L143;
        r8 = 4;
        goto L143
    }
}
