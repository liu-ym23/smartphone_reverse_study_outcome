package ga2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        ALogger.i("PSSelectedAiAgent", r1);
    }

    public static void b(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        ALogger.i("PSSelectedMessage", "list message batch clear. clear num: " + r2 + ", reason: " + r3);
    }

    public static void c(long r2, int r4, int r5) {
        l.a("chosen_screen_message_refresh_rate", "refresh_interval: " + r2 + ", refresh_quantity: " + r4 + ", scroll_speed: " + r5);
    }
}
