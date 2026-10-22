package bs1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(DataCenter r5, b r6) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "param");
        r5.put("data_live_quick_shot_path", r6);
        r.m().logQuickShotFinish(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_time", String.valueOf(r6.d)), TuplesKt.to("download_duration", String.valueOf(System.currentTimeMillis() - r6.d)), TuplesKt.to("is_success", "1")}));
    }

    public static void a(long r3, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "failReason");
        r.m().logQuickShotFinish(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_time", String.valueOf(r3)), TuplesKt.to("is_success", "0"), TuplesKt.to("error_code", String.valueOf(r5)), TuplesKt.to("error_msg", r6)}));
    }
}
