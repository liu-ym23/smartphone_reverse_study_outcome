package v10;

import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.broadcastgame.opengame.network.f0;
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
public final class b extends BaseOpenMethod<JSONObject> {
    public final String h;
    public final long i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            b r0 = this.a;
            JSONObject r1 = new JSONObject();
            Map<String, Integer> r5 = ((f0) ((ExtraResponse) r4).data).disableState;
            if (r5 == null) goto L5;
            r1.put("data", new JSONObject(r5));
        L5:
            Unit r6 = Unit.INSTANCE;
            r0.r(r1);
        }
    }

    /* JADX INFO: renamed from: v10.b$b, reason: collision with other inner class name */
    public static final class C0286b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0286b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            b r0 = this.a;
            r0.o((Throwable) r2);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "disableLiveMic";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r8, CallContext r9) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "context");
        String r5 = r8.optString("openIds", "[]");
        Lazy r11 = LiveOpenGameClient.d;
        j(((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).operateUserMicrophone(this.h, this.i, r5, 2).compose(new x10.d(this.d, "/webcast/openapi/linkmic/microphone/disable/", "disable")).subscribe(new a(this), new C0286b(this)));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }

    public b(PluginContext r2, String r3, long r4, Queue<Long> r6) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "appId");
        super(r2, r6);
        this.h = r3;
        this.i = r4;
    }
}
