package pr0;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.openapi.api.OpenPlatformApi;
import io.reactivex.functions.Consumer;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends yo0.a {
    public final String f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ yo0.a.b a;

        public a(yo0.a.b r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r4) {
            yo0.a.b r0 = this.a;
            JSONObject r1 = new JSONObject();
            com.bytedance.android.live.openplatform.impl.openapi.api.response.a.C0183a r5 = ((com.bytedance.android.live.openplatform.impl.openapi.api.response.a) ((ExtraResponse) r4).data).a();
            if (r5 == null) goto L5;
            Boolean r6 = Boolean.valueOf(r5.a());
        L6:
            r1.put("isFollowing", r6);
            Unit r7 = Unit.INSTANCE;
            r0.c(r1);
            return;
        L5:
            r6 = null;
            goto L6
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
        a(((OpenPlatformApi) LiveOpenPlatformClient.a.b().a(OpenPlatformApi.class)).isFollowAnchor(this.d, this.b.getRoomId()).subscribe(new a(r5), new b(r5)));
    }

    public c(OpenPlatformContext r2, Queue<Long> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r3, "callHistory");
        Intrinsics.checkNotNullParameter(r4, "appId");
        super(r2, r3, r4);
        this.f = "isFollowingAnchor";
    }
}
