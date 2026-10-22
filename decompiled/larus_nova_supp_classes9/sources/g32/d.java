package g32;

import am2.x;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeDimension;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        j0.l().sendLog("livesdk_live_interactivity_degrade_recieve_request", MapsKt.mapOf(new Pair[]{TuplesKt.to("degrade_scene", "VALUE_ANIMATOR_FALLBACK"), TuplesKt.to("degrade_level", DegradeSceneLevel.Default.NONE.logName()), TuplesKt.to("degrade_dimension", DegradeDimension.ROOM.name()), TuplesKt.to("trigger_source", r4)}), new Object[0]);
    }

    public static void a(e32.a r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "degradeRequest");
        Intrinsics.checkNotNullParameter(r4, "extraInfo");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("degrade_scene", r3.a.name());
        r0.put("degrade_level", r3.b.logName());
        if (r3.c != DegradeDimension.ROOM) goto L5;
        String r1 = "0";
    L6:
        r0.put("degrade_dimension", r1);
        if (r3.a != DegradeScene.PERFORMANCE_FRAME) goto L9;
        r0.putAll(r4);
    L9:
        j0.l().sendLog("livesdk_live_interactivity_degrade_recieve_request", r0, new Object[]{IRoom.class, x.class});
        return;
    L5:
        r1 = "1";
        goto L6
    }
}
