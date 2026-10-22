package e72;

import com.bytedance.common.utility.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends PthreadAsyncTask<String[], Void, Void> {
    public static final String h = null;

    static {
        h = a.class.getSimpleName();
    }

    public a() {
    }

    public final Object doInBackground(Object[] r6) {
        String[][] r7 = (String[][]) r6;
        if (r7 != null) goto L5;
        return null;
    L5:
        if (r7.length >= 1) goto L7;
        return null;
    L7:
        if (r7[0].length < 1) goto L26;
        int r1 = 0;
    L10:
        String[] r2 = r7[0];
        if (r1 >= r2.length) goto L27;
        if (r2[r1] == null) goto L18;
        if (new PolarisFileWrapper(r7[0][r1]).delete() == true) goto L18;
        Logger.e(h, "Delete file failed, file path is " + r7[0]);
    L18:
        r1 = r1 + 1;
        goto L10
    L27:
        return null;
    L26:
        return null;
    }
}
