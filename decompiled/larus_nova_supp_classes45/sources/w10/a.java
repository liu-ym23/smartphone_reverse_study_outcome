package w10;

import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.broadcastgame.opengame.network.e;
import com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import x10.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends BaseOpenMethod<JSONObject> {
    public final String h;
    public final long i;

    /* JADX INFO: renamed from: w10.a$a, reason: collision with other inner class name */
    public static final class C0288a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            JSONObject r0 = new JSONObject();
            String r5 = ((e) ((ExtraResponse) r4).data).orderId;
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            r0.put("orderId", r5);
            int r6 = q.a;
            q.f("CreatePropUsageOrderMethod", new Object[]{"on request success, data=" + r0});
            this.a.r(r0);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            int r0 = q.a;
            q.e("CreatePropUsageOrderMethod", new Object[]{"on request fail, error=" + r5});
            this.a.o(r5);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "createPropUsageOrder";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r14, CallContext r15) {
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r15, "context");
        int r16 = q.a;
        q.f("CreatePropUsageOrderMethod", new Object[]{"on call, params=" + r14});
        long r1 = 0;
        long r9 = CastLongProtector.parseLong(r14.optString("propId", "0"));     // Catch: Throwable -> L5
    L11:
        r1 = CastLongProtector.parseLong(r14.optString("num", "0"));     // Catch: Throwable -> L10
    L8:
        Lazy r17 = LiveOpenGameClient.d;
        j(((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).createPropUsageOrder(this.h, this.i, r9, r1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).compose(new d(this.d, "/webcast/openapi/game_prop/usage_order/create/", null)).subscribe(new b(this), new c(this)));
        return;
    L5:
        r9 = 0;
        goto L11
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }

    public a(PluginContext r2, String r3, long r4, Queue<Long> r6) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "appId");
        super(r2, r6);
        this.h = r3;
        this.i = r4;
    }
}
