package jl0;

import am2.x;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void c(String r6) {
        Intrinsics.checkNotNullParameter(r6, "collectionId");
        g r0 = u.l();
        Map r7 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("highlights_group_id", r6)});
        x r4 = new x();
        r4.a = "live";
        r4.e = "show";
        r4.b = "live_detail";
        r0.h("sjb_highlights_video_play_finish", r7, new Object[]{r4, Room.class});
    }

    @JvmStatic
    public static final void a(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "collectionId");
        Intrinsics.checkNotNullParameter(r6, "enterFrom");
        g r0 = u.l();
        Map r7 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("highlights_group_id", r5), TuplesKt.to("enter_from", r6)});
        x r2 = new x();
        r2.a = "live";
        r2.e = "show";
        r2.b = "live_detail";
        r0.h("sjb_highlights_video_play", r7, new Object[]{r2, Room.class});
    }

    @JvmStatic
    public static final void b(String r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "collectionId");
        g r0 = u.l();
        Map r6 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("highlights_group_id", r4), TuplesKt.to("duration", String.valueOf(r5))});
        x r1 = new x();
        r1.a = "live";
        r1.e = "show";
        r1.b = "live_detail";
        r0.h("sjb_highlights_play_time", r6, new Object[]{r1, Room.class});
    }
}
