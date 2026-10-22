package u2b;

import android.content.Context;
import com.larksuite.framework.utils.DeviceUtils;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j {
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public static final int j = 0;
    public static final int k = 0;
    public static final int l = 0;
    public static final int m = 0;
    public static final int n = 0;
    public static final int o = 0;
    public static final int p = 0;
    public static final int q = 0;
    public static final int r = 0;
    public static final int s = 0;

    static {
        a = UIHelper.dp2px(56.0f);
        b = 20;
        c = UIHelper.dp2px(5.0f);
        d = UIHelper.dp2px(16.0f);
        UIHelper.dp2px(6.0f);
        e = UIHelper.dp2px(12.0f);
        f = UIHelper.dp2px(15.0f);
        g = UIHelper.dp2px(16.0f);
        h = UIHelper.dp2px(16.0f);
        i = UIHelper.dp2px(48.0f);
        j = UIHelper.dp2px(36.0f);
        k = UIHelper.dp2px(6.0f);
        l = UIHelper.dp2px(16.0f);
        m = UIHelper.dp2px(12.0f);
        n = UIHelper.dp2px(16.0f);
        o = UIHelper.dp2px(36.0f);
        p = UIHelper.dp2px(24.0f);
        q = UIHelper.dp2px(24.0f);
        r = UIHelper.dp2px(21.0f);
        s = UIHelper.dp2px(2.0f);
    }

    @JvmStatic
    public static final int a(Context r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r0 = zz7.b.g(r3, 32);
        int r1 = UIHelper.dp2px(32.0f);
        int r2 = a + (r0 - r1);
        return (((n(r3, r4) - r2) - d) - zz7.b.g(r3, b)) - c;
    }

    @JvmStatic
    public static final int b(Context r1, Integer r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return (n(r1, r2) - (g * 2)) - s;
    }

    @JvmStatic
    public static final int d(Context r1, Integer r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return (a(r1, r2) - (e * 2)) - s;
    }

    @JvmStatic
    public static final int f(Context r1, Integer r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return n(r1, r2) - (l * 2);
    }

    @JvmStatic
    public static final int k(Context r1, Integer r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return ((n(r1, r2) - (g * 2)) - h) - s;
    }

    @JvmStatic
    public static final int l(Context r1, Integer r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return ((n(r1, r2) - (h * 2)) - i) - s;
    }

    public static int n(Context r2, Integer r3) {
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.fold.support") == false) goto L5;
        if (r3 == null) goto L13;
        if (r3.intValue() <= 0) goto L13;
        return r3.intValue();
    L13:
        return DeviceUtils.getScreenWidth(r2);
    L5:
        return DeviceUtils.getScreenWidth(r2);
    }

    public static int c(Context r3, Integer r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r0 = zz7.b.g(r3, 32);
        int r1 = UIHelper.dp2px(32.0f);
        int r2 = a + (r0 - r1);
        int r6 = ((n(r3, r4) - r2) - d) - (e * 2);
        if (r5 == false) goto L5;
        int r7 = f * 2;
    L7:
        return ((r6 - r7) - zz7.b.g(r3, b)) - c;
    L5:
        r7 = 0;
        goto L7
    }

    public static int g(Context r2, boolean r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        int r0 = j + k;
        int r5 = n(r2, r4) - (g * 2);
        if (r3 == false) goto L5;
        int r6 = p;
    L6:
        int r7 = (r5 - r6) - r0;
        int r8 = r2.getResources().getDimensionPixelSize(2131166578);
        if (r8 <= 0) goto L11;
        r7 = Math.min(r8, r7);
    L11:
        return r7 - (m * 2);
    L5:
        r6 = 0;
        goto L6
    }

    public static int h(Context r1, boolean r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        int r4 = n(r1, r3) - (g * 2);
        if (r2 == false) goto L5;
        int r5 = p;
    L6:
        int r6 = r4 - r5;
        int r7 = r1.getResources().getDimensionPixelSize(2131166578);
        if (r7 <= 0) goto L11;
        r6 = Math.min(r7, r6);
    L11:
        return r6 - (m * 2);
    L5:
        r5 = 0;
        goto L6
    }

    @JvmStatic
    public static final int m(Context r1, boolean r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r2 == false) goto L5;
        int r4 = n(r1, r3) - (g * 2);
        int r5 = h;
    L7:
        return r4 - r5;
    L5:
        r4 = n(r1, r3);
        r5 = g * 2;
        goto L7
    }

    @JvmStatic
    public static final int e(Context r1, Integer r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        int r5 = ((n(r1, r2) - (g * 2)) - (f * 2)) - s;
        int r6 = 0;
        if (r3 == true) goto L5;
    L7:
        int r7 = 0;
    L8:
        int r8 = r5 - r7;
        if (r4 == false) goto L12;
        r6 = q;
    L12:
        return r8 - r6;
    L5:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.thread.read_receipt") == false) goto L7;
        r7 = r;
        goto L8
    }

    @JvmStatic
    public static final int i(Context r1, boolean r2, Integer r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        int r5 = (n(r1, r3) - (g * 2)) - s;
        if (r2 == false) goto L5;
        int r6 = p;
    L6:
        int r7 = (r5 - r6) - UIHelper.dp2px(20.0f);
        if (r4 == true) goto L9;
    L11:
        int r8 = 0;
    L13:
        return r7 - r8;
    L9:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.thread.read_receipt") == false) goto L11;
        r8 = r;
        goto L13
    L5:
        r6 = h;
        goto L6
    }

    @JvmStatic
    public static final int j(Context r1, boolean r2, Integer r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        int r5 = (((n(r1, r3) - (g * 2)) - j) - k) - s;
        if (r2 == false) goto L5;
        int r6 = p;
    L6:
        int r7 = r5 - r6;
        if (r4 == true) goto L9;
    L11:
        int r8 = 0;
    L13:
        return r7 - r8;
    L9:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.thread.read_receipt") == false) goto L11;
        r8 = r;
        goto L13
    L5:
        r6 = h;
        goto L6
    }
}
