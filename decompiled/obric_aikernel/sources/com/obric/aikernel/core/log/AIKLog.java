package com.obric.aikernel.core.log;

import android.util.Log;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class AIKLog implements ILog {
    public static final AIKLog INSTANCE = null;
    private static final boolean NEED_PREFIX = true;
    private static final String TAG_PREFIX = "AIK_Client_";
    private static ILog logInst;

    static {
        INSTANCE = new AIKLog();
    }

    private AIKLog() {
    }

    private final String logTag(String r10) {
        return TAG_PREFIX + r10;
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void d(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        ILog r12 = logInst;
        String r13 = logTag(r10);
        if (r12 == null) goto L5;
        r12.d(r13, r11);
        return;
    L5:
        Log.d(r13, r11);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void e(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        ILog r12 = logInst;
        String r13 = logTag(r10);
        if (r12 == null) goto L5;
        r12.e(r13, r11);
        return;
    L5:
        Log.e(r13, r11);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void e(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r12, "t");
        ILog r13 = logInst;
        String r14 = logTag(r10);
        if (r13 == null) goto L5;
        r13.e(r14, r11, r12);
        return;
    L5:
        Log.e(r14, r11, r12);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void i(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        ILog r12 = logInst;
        String r13 = logTag(r10);
        if (r12 == null) goto L5;
        r12.i(r13, r11);
        return;
    L5:
        Log.i(r13, r11);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public boolean isDebug() {
        return true;
    }

    public final void registerLog(ILog r10) {
        Intrinsics.checkNotNullParameter(r10, "inst");
        logInst = r10;
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void v(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        ILog r12 = logInst;
        String r13 = logTag(r10);
        if (r12 == null) goto L5;
        r12.v(r13, r11);
        return;
    L5:
        Log.v(r13, r11);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void w(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        ILog r12 = logInst;
        String r13 = logTag(r10);
        if (r12 == null) goto L5;
        r12.w(r13, r11);
        return;
    L5:
        Log.w(r13, r11);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void w(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r12, "t");
        ILog r13 = logInst;
        String r14 = logTag(r10);
        if (r13 == null) goto L5;
        r13.w(r14, r11, r12);
        return;
    L5:
        Log.w(r14, r11, r12);
    }
}
