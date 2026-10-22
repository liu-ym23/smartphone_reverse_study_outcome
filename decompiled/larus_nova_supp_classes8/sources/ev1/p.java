package ev1;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p extends SettingKey<fv1.d> {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
        super("live_online_user_ui_opt", "在线人数榜框架优化", new fv1.d(), new fv1.d());
    }

    @JvmStatic
    public static final int a(DataCenter r1) {
        p r0 = a;
        r0.getClass();
        if (d(r1) == true) goto L7;
        return 0;
    L7:
        return ((fv1.d) r0.getValue()).a();
    }

    @JvmStatic
    public static final boolean b(DataCenter r1) {
        p r0 = a;
        r0.getClass();
        if (d(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (((fv1.d) r0.getValue()).b() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean c(DataCenter r3) {
        a.getClass();
        if (d(r3) == false) goto L14;
        int r4 = a(r3);
        if (r4 != 1) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 != true) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (r4 == 2) goto L10;
        r5 = false;
        goto L11
    L14:
        return false;
    }

    public static boolean d(DataCenter r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (a0.d(r3, false) == false) goto L7;
        return false;
    L7:
        if (a0.l(r3, true) == true) goto L9;
        return false;
    L9:
        if (a0.c(r3) == true) goto L15;
        return true;
    L15:
        return false;
    }

    @JvmStatic
    public static final boolean e(DataCenter r1) {
        a.getClass();
        if (d(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (a(r1) != 1) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean f(DataCenter r1) {
        a.getClass();
        if (d(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (a(r1) != 2) goto L7;
        return true;
    }
}
