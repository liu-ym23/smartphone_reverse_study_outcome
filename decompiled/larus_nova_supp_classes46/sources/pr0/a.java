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
public final class a extends yo0.a {
    public final String f;

    /* JADX INFO: renamed from: pr0.a$a, reason: collision with other inner class name */
    public static final class C0253a<T> implements Consumer {
        public final /* synthetic */ yo0.a.b a;

        public C0253a(yo0.a.b r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r4) {
            ExtraResponse r5 = (ExtraResponse) r4;
            JSONObject r0 = new JSONObject();
            com.bytedance.android.live.openplatform.impl.openapi.api.response.b.a r1 = ((com.bytedance.android.live.openplatform.impl.openapi.api.response.b) r5.data).a();
            if (r1 == null) goto L5;
            String r2 = r1.b();
        L6:
            r0.put("roomID", r2);
            com.bytedance.android.live.openplatform.impl.openapi.api.response.b.a r6 = ((com.bytedance.android.live.openplatform.impl.openapi.api.response.b) r5.data).a();
            if (r6 == null) goto L11;
            Long r7 = r6.a();
            if (r7 == null) goto L11;
            int r8 = (int) r7.longValue();
        L12:
            r0.put("liveDuration", r8);
            yo0.a.b r9 = this.a;
            JSONObject r3 = new JSONObject();
            r3.put("roomInfo", r0);
            Unit r10 = Unit.INSTANCE;
            r9.c(r3);
            return;
        L11:
            r8 = 0;
            goto L12
        L5:
            r2 = null;
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
        a(((OpenPlatformApi) LiveOpenPlatformClient.a.b().a(OpenPlatformApi.class)).getRoomInfo(this.d, this.b.getRoomId()).subscribe(new C0253a(r5), new b(r5)));
    }

    public a(OpenPlatformContext r2, Queue<Long> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r3, "callHistory");
        Intrinsics.checkNotNullParameter(r4, "appId");
        super(r2, r3, r4);
        this.f = "getRoomInfo";
    }
}
