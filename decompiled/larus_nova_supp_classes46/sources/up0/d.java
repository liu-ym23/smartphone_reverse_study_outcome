package up0;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.AnchorOpenApi;
import io.reactivex.functions.Consumer;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends yo0.a {
    public final String f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ yo0.a.b a;

        public a(yo0.a.b r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
            this.a.c(null);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ yo0.a.b a;

        public b(yo0.a.b r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            yo0.a.b r0 = this.a;
            r0.a((Throwable) r2);
        }
    }

    @Override // yo0.a
    public final String b() {
        return this.f;
    }

    @Override // yo0.a
    public void call(JSONObject r4, yo0.a.b r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Lazy r6 = LiveOpenPlatformClient.c;
        a(((AnchorOpenApi) LiveOpenPlatformClient.a.b().a(AnchorOpenApi.class)).unsubscribeAudienceFollowAction(this.d, this.b.getRoomId()).subscribe(new a(r5), new b(r5)));
    }

    public d(OpenPlatformContext r2, Queue<Long> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r3, "callHistory");
        Intrinsics.checkNotNullParameter(r4, "appId");
        super(r2, r3, r4);
        this.f = "unsubscribeAudiencesFollowAction";
    }
}
