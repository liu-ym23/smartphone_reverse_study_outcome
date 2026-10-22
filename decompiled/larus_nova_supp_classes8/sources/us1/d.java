package us1;

import com.bytedance.android.livesdk.config.cj1;
import com.bytedance.android.livesdk.config.xi1;
import com.bytedance.android.livesdk.utils.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public static boolean a() {
        float r1 = z0.b(false);
        if (r1 > 0.0f) goto L5;
        return true;
    L5:
        if (r1 >= xi1.a.getValue().floatValue()) goto L9;
        return false;
    L9:
        return true;
    }

    public static boolean b(boolean r0, boolean r1) {
        if (r0 == false) goto L4;
        return r1;
    L4:
        if (r1 == true) goto L6;
    L8:
        return false;
    L6:
        if (cj1.a.getValue().intValue() != 2) goto L8;
        return true;
    }
}
