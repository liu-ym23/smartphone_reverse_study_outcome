package com.byted.cast.sdk.log;

import android.text.TextUtils;
import com.byted.cast.common.api.ILogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class Logger {
    private static String TAG = "BYTELINK";
    private int LOG_LEVEL;
    private ILogger mLogger;
    private String mMirrorId;

    private static int transNativeLogLevelToJava(int r1) {
        if (r1 == (-1)) goto L19;
        if (r1 != 0) goto L6;
        return 6;
    L6:
        if (r1 != 1) goto L8;
        return 5;
    L8:
        if (r1 != 3) goto L10;
        return 3;
    L10:
        if (r1 == 4) goto L12;
        return 4;
    L12:
        return 2;
    L19:
        return 7;
    }

    public Logger(String r10) {
        this.LOG_LEVEL = 4;
        this.mMirrorId = r10;
    }

    private String prefix(String r10) {
        String r0 = this.mMirrorId + ":";
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return r0;
    L5:
        return r0 + r10 + ":";
    }

    public void setLogLevel(int r1) {
        this.LOG_LEVEL = r1;
    }

    public void setLogger(ILogger r1) {
        this.mLogger = r1;
    }

    public void d(String r10, String r11) {
        if (this.LOG_LEVEL <= 3) goto L5;
        return;
    L5:
        String r12 = prefix(r10) + r11;
        ILogger r13 = this.mLogger;
        if (r13 == null) goto L9;
        r13.onDebug(TAG, r12);
        return;
    }

    public void e(String r10, String r11) {
        if (this.LOG_LEVEL <= 6) goto L5;
        return;
    L5:
        String r12 = prefix(r10) + r11;
        ILogger r13 = this.mLogger;
        if (r13 == null) goto L9;
        r13.onError(TAG, r12);
        return;
    }

    public void i(String r10, String r11) {
        if (this.LOG_LEVEL <= 4) goto L5;
        return;
    L5:
        String r12 = prefix(r10) + r11;
        ILogger r13 = this.mLogger;
        if (r13 == null) goto L9;
        r13.onInfo(TAG, r12);
        return;
    }

    public void v(String r10, String r11) {
        if (this.LOG_LEVEL <= 2) goto L5;
        return;
    L5:
        String r12 = prefix(r10) + r11;
        ILogger r13 = this.mLogger;
        if (r13 == null) goto L9;
        r13.onVerbose(TAG, r12);
        return;
    }

    public void w(String r10, String r11) {
        if (this.LOG_LEVEL <= 5) goto L5;
        return;
    L5:
        String r12 = prefix(r10) + r11;
        ILogger r13 = this.mLogger;
        if (r13 == null) goto L9;
        r13.onWarn(TAG, r12);
        return;
    }

    public static void logger(String r0, int r1, String r10, String r11) {
        Logger r12 = LoggerManager.getLogger(r0);
        switch(transNativeLogLevelToJava(r1)) {
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L9;
            default: goto L15;
        };
    L5:
        r12.e(r10, r11);
        return;
    L6:
        r12.w(r10, r11);
        return;
    L7:
        r12.i(r10, r11);
        return;
    L8:
        r12.d(r10, r11);
        return;
    L9:
        r12.v(r10, r11);
        return;
    }
}
