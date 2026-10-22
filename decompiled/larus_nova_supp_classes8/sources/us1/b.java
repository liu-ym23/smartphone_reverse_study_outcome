package us1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.config.od1;
import com.bytedance.android.livesdk.config.ph0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        float r1 = z0.b(true);
        if (r1 <= 0) goto L7;
        if (r1 >= od1.a.getValue().floatValue()) goto L7;
    L12:
        return false;
    L7:
        if (ph0.a.getValue().booleanValue() == false) goto L12;
        if (c() == true) goto L12;
        return true;
    }

    public static String b() {
        if (ph0.a.getValue().booleanValue() == true) goto L7;
        return s1.B(2131921451);
    L7:
        return s1.B(2131917647);
    }

    public static boolean c() {
        if (PadConfigUtils.c() == false) goto L5;
    L10:
        return true;
    L5:
        if (PadConfigUtils.c() == true) goto L10;
        if (FoldScreenUtils.f() == true) goto L10;
        return false;
    }

    static {
    }
}
