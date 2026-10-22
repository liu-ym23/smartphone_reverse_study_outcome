package v10;

import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.broadcastgame.opengame.network.t;
import com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends BaseOpenMethod<JSONObject> {
    public final String h;
    public final long i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            e r0 = this.a;
            JSONObject r1 = new JSONObject();
            Map<String, Integer> r5 = ((t) ((ExtraResponse) r4).data).inviteState;
            if (r5 == null) goto L5;
            r1.put("data", new JSONObject(r5));
        L5:
            Unit r6 = Unit.INSTANCE;
            r0.r(r1);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            e r0 = this.a;
            r0.o((Throwable) r2);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "inviteLiveUser";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r4, CallContext r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        String r6 = r4.optString("openIds", "[]");
        Lazy r7 = LiveOpenGameClient.d;
        j(((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).inviteLiveUser(this.h, this.i, r6).compose(new x10.d(this.d, "/webcast/openapi/linkmic/invite/", null)).subscribe(new a(this), new b(this)));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }

    public e(PluginContext r2, String r3, long r4, Queue<Long> r6) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "appId");
        super(r2, r6);
        this.h = r3;
        this.i = r4;
    }
}
