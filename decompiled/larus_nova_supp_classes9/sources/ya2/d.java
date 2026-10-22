package ya2;

import com.bytedance.android.livesdk.config.fd0;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static int a;

    @JvmStatic
    public static final int a() {
        if (a != 0) goto L9;
        fd0 r0 = fd0.a;
        int r2 = 50;
        if (((Number) r0.getValue()).intValue() <= 50) goto L7;
        r2 = ((Integer) r0.getValue()).intValue();
    L7:
        a = r2;
    L9:
        return a;
    }

    static {
    }
}
