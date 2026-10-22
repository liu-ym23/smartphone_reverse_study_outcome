package com.ss.android.lark.hobby;

import android.content.Context;
import android.os.Looper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {

    public static final class a {
        public static final d a = null;

        static {
            a = new d();
        }
    }

    public d() {
    }

    public static String c(Context r1) {
        return r1.getFilesDir().getAbsolutePath() + File.separator + "hobby_offline_res";
    }

    public static String d(String r2) {
        return "ka_" + r2;
    }

    public static String b(Context r3, String r4) {
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = new StringBuilder();
        r1.append(r3.getFilesDir().getAbsolutePath());
        String r5 = File.separator;
        r1.append(r5);
        r1.append("hobby_ka_res");
        r0.append(r1.toString());
        r0.append(r5);
        r0.append(r4);
        return r0.toString();
    }

    public final void a(Context r3, final String r4) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        final Context r5 = r3.getApplicationContext();
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new c(this, r5, r4));
        return;
    L6:
        File[] r6 = new PolarisFileWrapper(b(r3, d(r4))).listFiles();
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.length <= 1) goto L17;
        Arrays.sort(r6);
        int r7 = 0;
    L13:
        if (r7 > (r6.length - 2)) goto L18;
        Log.i("HobbyResManager", "clearExpiredKaTaskRes, path: " + r6[r7].getAbsolutePath());
        FileUtils.f(r6[r7]);
        r7 = r7 + 1;
        goto L13
    L18:
        return;
    }
}
