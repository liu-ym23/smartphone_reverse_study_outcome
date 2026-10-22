package com.ss.android.lark.desktopmode.utils;

import android.content.Context;
import android.view.WindowManager;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.log.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DesktopUtil {
    public static int a = -1;
    public static final AtomicInteger b = null;
    public static final AtomicBoolean c = null;

    public @interface CaptionBarType {
        public static final int CAPTION_CLOSE = 7;
        public static final int CAPTION_DIVIDER = 4;
        public static final int CAPTION_MAX = 6;
        public static final int CAPTION_MORE = 3;
        public static final int CAPTION_PIN = 2;
        public static final int CAPTION_RETURN = 0;
        public static final int CAPTION_SMALL = 5;
        public static final int CAPTION_TITLE = 1;
    }

    static {
        b = new AtomicInteger(-1);
        c = new AtomicBoolean(false);
    }

    public static boolean a(Context r4) {
        if (b.get() == (-1)) goto L5;
    L21:
        return false;
    L5:
        if (a == (-1)) goto L22;
    L15:
        Log.e("DesktopUtil", "isDesktopMode:false desktop feature is not enabled");
        if (DevEnvUtil.isDebugMode(r4) == false) goto L19;
        Log.e("DesktopUtil", "desktop mode called by: %s" + android.util.Log.getStackTraceString(new Throwable()));
    L19:
        if (c.get() == false) goto L21;
        b.compareAndSet(-1, 0);
        goto L21
    L22:
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L8:
        if (((WindowManager) r4.getSystemService("window")).getDefaultDisplay().getDisplayId() != 0) goto L10;
        int r0 = 1;
    L11:
        a = r0;     // Catch: Exception -> L13
        goto L15
    L10:
        r0 = 2;
        goto L11
    }
}
