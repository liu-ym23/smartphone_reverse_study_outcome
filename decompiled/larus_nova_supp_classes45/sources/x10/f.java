package x10;

import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.opengame.openapi.OpenApiErrorInfo;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.io.IOException;
import java.net.SocketTimeoutException;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public f() {
    }

    static {
    }

    public static /* synthetic */ void c(PluginContext r1, int r2, OpenApiErrorInfo r3, int r4) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        b(r1, r2, r3, null, 0);
    }

    public static /* synthetic */ void e(PluginContext r1, int r2, OpenApiErrorInfo r3, int r4) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        d(r1, r2, r3, null, 0);
    }

    public static void b(PluginContext r7, int r8, OpenApiErrorInfo r9, Throwable r11, int r12) {
        Intrinsics.checkNotNullParameter(r7, "pluginContext");
        a(r7, GamePromoteDataContext.GAME_TYPE_MOBILE, r8, r9, r11, r12);
    }

    public static void d(PluginContext r7, int r8, OpenApiErrorInfo r9, Throwable r11, int r12) {
        Intrinsics.checkNotNullParameter(r7, "pluginContext");
        a(r7, "3", r8, r9, r11, r12);
    }

    public static void a(PluginContext r8, String r9, int r11, OpenApiErrorInfo r12, Throwable r13, int r14) {
        if (r12 == null) goto L5;
        int r1 = r12.getErrorCode();
    L6:
        String r2 = "";
        if (r13 != null) goto L9;
    L21:
        if (r12 == null) goto L24;
        String r15 = r12.getErrorMsg();
        if (r15 == null) goto L24;
    L25:
        Long r16 = Long.valueOf(r8.m.h);
        String r3 = r8.m.b(r8.o);
        String r17 = ((BootInfoService) r8.o(BootInfoService.class)).e();
        g r4 = u.l();
        Pair[] r5 = new Pair[9];
        if (r16 == null) goto L31;
        String r18 = String.valueOf(r16.longValue());
        if (r18 == null) goto L31;
        r2 = r18;
    L31:
        r5[0] = TuplesKt.to("game_id", r2);
        r5[1] = TuplesKt.to("game_name", r3);
        r5[2] = TuplesKt.to("game_category", r17);
        r5[3] = TuplesKt.to("user_id", k.n(IUserService.class).user().n());
        r5[4] = TuplesKt.to("pay_version", r9);
        r5[5] = TuplesKt.to("phase", String.valueOf(r11));
        r5[6] = TuplesKt.to(LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, String.valueOf(r1));
        r5[7] = TuplesKt.to(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r15);
        r5[8] = TuplesKt.to("server_error_code", String.valueOf(r14));
        r4.sendLog("livesdk_game_pay_diamonds", MapsKt.mapOf(r5), new Object[]{Room.class});
        return;
    L24:
        r15 = "";
        goto L25
    L9:
        if ((r13 instanceof CustomApiServerException) == false) goto L12;
        r15 = "custom api error";
    L20:
        if (r15 != null) goto L25;
    L12:
        if ((r13 instanceof SocketTimeoutException) == false) goto L14;
    L19:
        r15 = "network error";
        goto L20
    L14:
        if ((r13 instanceof NetworkErrorException) == true) goto L19;
        if ((r13 instanceof IOException) == true) goto L19;
        r15 = null;
        goto L20
    L5:
        r1 = 0;
        goto L6
    }
}
