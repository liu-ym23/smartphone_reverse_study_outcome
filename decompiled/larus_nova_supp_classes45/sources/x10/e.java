package x10;

import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public e() {
    }

    static {
    }

    public static void a(PluginContext r4, int r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "pluginContext");
        Pair[] r0 = new Pair[8];
        r0[0] = TuplesKt.to("game_id", String.valueOf(r4.m.h));
        r0[1] = TuplesKt.to("game_name", r4.m.b(r4.o));
        r0[2] = TuplesKt.to("game_category", ((BootInfoService) r4.o(BootInfoService.class)).e());
        r0[3] = TuplesKt.to("user_id", k.n(IUserService.class).user().n());
        r0[4] = TuplesKt.to(LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, String.valueOf(r5));
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r0[5] = TuplesKt.to(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r6);
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r0[6] = TuplesKt.to("path", r7);
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        r0[7] = TuplesKt.to("query", r8);
        Map r9 = MapsKt.mapOf(r0);
        u.l().sendLog("livesdk_game_net_monitor", r9, new Object[]{Room.class});
    }
}
