package f22;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static int b() {
        Intrinsics.checkNotNullParameter("broadcast_long_press_tip_show_times", "key");
        return ((Number) new e("broadcast_long_press_tip_show_times" + k.n(IUserService.class).user().n(), 0).getValue()).intValue();
    }

    static {
    }

    public static boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return ((Boolean) new e(r2 + k.n(IUserService.class).user().n(), Boolean.FALSE).getValue()).booleanValue();
    }

    public static void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        String r3 = r2 + k.n(IUserService.class).user().n();
        Boolean r1 = Boolean.TRUE;
        f.d(new e(r3, r1), r1);
    }

    public static void d(int r3) {
        Intrinsics.checkNotNullParameter("broadcast_long_press_tip_show_times", "key");
        f.d(new e("broadcast_long_press_tip_show_times" + k.n(IUserService.class).user().n(), Integer.valueOf(r3)), Integer.valueOf(r3));
    }
}
