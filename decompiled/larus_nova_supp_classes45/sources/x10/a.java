package x10;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: x10.a$a, reason: collision with other inner class name */
    public static final class C0290a {
        public final Map<String, String> a;

        /* JADX INFO: renamed from: x10.a$a$a, reason: collision with other inner class name */
        public static final class C0291a {
            public final HashMap<String, String> a;

            public C0291a(String r3) {
                Intrinsics.checkNotNullParameter(r3, "actionType");
                HashMap<String, String> r0 = new HashMap();
                this.a = r0;
                r0.put("action_type", r3);
            }

            public final void a(String r3) {
                this.a.put("param1", r3);
            }
        }

        public final void a() {
            int r0 = a.a;
            Intrinsics.checkNotNullParameter(this, "event");
            Map<String, String> r1 = this.a;
            IUserService r2 = k.f(IUserService.class);
            if (r2 == null) goto L7;
            com.bytedance.android.livesdk.user.f r3 = r2.user();
            if (r3 == null) goto L7;
            String r4 = r3.n();
        L8:
            ((HashMap) r1).put("user_id", r4);
            u.l().sendLog("livesdk_game_common_event", this.a, new Object[]{Room.class});
            return;
        L7:
            r4 = null;
            goto L8
        }

        public C0290a(C0291a r2) {
            Intrinsics.checkNotNullParameter(r2, "builder");
            this.a = r2.a;
        }
    }

    static {
    }

    public static C0290a.C0291a a(PluginContext r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        Intrinsics.checkNotNullParameter(r4, "actionType");
        C0290a.C0291a r0 = new C0290a.C0291a(r4);
        String r5 = r3.m.b(r3.o);
        r0.a.put("game_name", r5);
        String r6 = r3.m.i;
        r0.a.put(OpenPlatformBaseDebugger.APP_ID, r6);
        String r7 = String.valueOf(r3.m.h);
        r0.a.put("game_id", r7);
        if (r3.o == false) goto L5;
        String r8 = "0";
    L6:
        r0.a.put("is_from_audience", r8);
        return r0;
    L5:
        r8 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        goto L6
    }
}
