package org.chromium;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.NetworkException;
import com.ttnet.org.chromium.net.impl.NetworkExceptionImpl;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public class Utils {
    public Utils() {
    }

    public static CronetException createCronetException(int r10, int r11, String r12) {
        return new NetworkExceptionImpl("Exception in CronetUrlRequest: " + r12, mapUrlRequestErrorToApiErrorCode(r10), r11);
    }

    public static List getAllInterfaces(Class r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList();
    L6:
        if (r10 == null) goto L21;
        Class<?>[] r12 = r10.getInterfaces();
        int r13 = 0;
    L9:
        if (r13 >= r12.length) goto L20;
        if (r11.contains(r12[r13]) == true) goto L13;
        r11.add(r12[r13]);
    L13:
        Iterator r14 = getAllInterfaces(r12[r13]).iterator();
    L15:
        if (r14.hasNext() == false) goto L19;
        Class r15 = (Class) r14.next();
        if (r11.contains(r15) == true) goto L15;
        r11.add(r15);
        goto L15
    L19:
        r13 = r13 + 1;
        goto L9
    L20:
        r10 = r10.getSuperclass();
        goto L6
    L21:
        return r11;
    }

    public static int mapUrlRequestErrorToApiErrorCode(int r10) {
        switch(r10) {
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L22;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L10;
            case 10: goto L8;
            case 11: goto L6;
            default: goto L4;
        };
    L6:
        return 11;
    L8:
        return 10;
    L10:
        return 9;
    L12:
        return 8;
    L14:
        return 7;
    L16:
        return 6;
    L18:
        return 5;
    L20:
        return 4;
    L22:
        return 3;
    L24:
        return 2;
    L26:
        return 1;
    L4:
        if (CronetDependManager.inst().loggerDebug() == false) goto L28;
        CronetDependManager.inst().loggerD(CommonConsts.LOG_REPORT_TYPE_DEFAULT, "Unknown error code: " + r10);
        return r10;
    L28:
        return r10;
    }

    public static IOException tryConvertCronetException(CronetException r10) {
        if ((r10 instanceof NetworkException) == true) goto L6;
        return r10;
    L6:
        switch(((NetworkException) r10).getErrorCode()) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L17;
        };
    L8:
        IOException r11 = new NoRouteToHostException(r10.getMessage());
    L16:
        return r11;
    L9:
        r11 = new SocketException("reset by peer " + r10.getMessage());
        goto L16
    L10:
        r11 = new ConnectTimeoutException(r10.getMessage());
        goto L16
    L11:
        r11 = new ConnectException(r10.getMessage());
        goto L16
    L12:
        r11 = new SocketTimeoutException(r10.getMessage());
        goto L16
    L13:
        r11 = new ConnectException(r10.getMessage());
        goto L16
    L14:
        r11 = new UnknownHostException(r10.getMessage());
        goto L16
    L17:
        return r10;
    }
}
