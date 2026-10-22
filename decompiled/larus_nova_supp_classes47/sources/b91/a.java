package b91;

import am2.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Map r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        j0.l().sendLog("livesdk_rd_live_user_rank_click_enter", r4, new Object[]{new x(), IRoom.class});
    }
}
