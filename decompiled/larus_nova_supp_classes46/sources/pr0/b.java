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
public final class b extends yo0.a {
    public final String f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ yo0.a.b a;

        public a(yo0.a.b r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r5) {
            com.bytedance.android.live.openplatform.impl.openapi.api.response.c.a r6 = ((com.bytedance.android.live.openplatform.impl.openapi.api.response.c) ((ExtraResponse) r5).data).a();
            JSONObject r0 = new JSONObject();
            String r1 = null;
            if (r6 == null) goto L5;
            String r2 = r6.a();
        L6:
            r0.put("openUID", r2);
            if (r6 == null) goto L9;
            String r3 = r6.c();
        L10:
            r0.put("secAvatarURL", r3);
            if (r6 == null) goto L13;
            String r4 = r6.d();
        L14:
            r0.put("secNickname", r4);
            if (r6 == null) goto L17;
            r1 = r6.b();
        L17:
            r0.put("role", r1);
            yo0.a.b r7 = this.a;
            JSONObject r8 = new JSONObject();
            r8.put("userInfo", r0);
            Unit r9 = Unit.INSTANCE;
            r7.c(r8);
            return;
        L13:
            r4 = null;
            goto L14
        L9:
            r3 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: pr0.b$b, reason: collision with other inner class name */
    public static final class C0254b<T> implements Consumer {
        public final /* synthetic */ yo0.a.b a;

        public C0254b(yo0.a.b r1) {
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
        a(((OpenPlatformApi) LiveOpenPlatformClient.a.b().a(OpenPlatformApi.class)).getCurrentUserInfo(this.d, this.b.getRoomId()).subscribe(new a(r5), new C0254b(r5)));
    }

    public b(OpenPlatformContext r2, Queue<Long> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r3, "callHistory");
        Intrinsics.checkNotNullParameter(r4, "appId");
        super(r2, r3, r4);
        this.f = "getUserInfo";
    }
}
