package up0;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.openapi.OpenApiErrorInfo;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.AnchorOpenApi;
import io.reactivex.functions.Consumer;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends yo0.a {
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

    /* JADX INFO: renamed from: up0.b$b, reason: collision with other inner class name */
    public static final class C0283b<T> implements Consumer {
        public final /* synthetic */ yo0.a.b a;

        public C0283b(yo0.a.b r1) {
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
    public void call(JSONObject r5, yo0.a.b r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        JSONObject r7 = r5.optJSONObject("data");
        if (r7 == null) goto L5;
        JSONArray r8 = r7.optJSONArray("keyWordList");
    L6:
        if (r8 != null) goto L8;
    L12:
        yo0.a.b.b(r6, OpenApiErrorInfo.INCORRECT_PARAMS);
        return;
    L8:
        if (r8.length() == 0) goto L12;
        Lazy r0 = LiveOpenPlatformClient.c;
        a(((AnchorOpenApi) LiveOpenPlatformClient.a.b().a(AnchorOpenApi.class)).subscribeSpecifiedContentComment(this.d, this.b.getRoomId(), r8.toString()).subscribe(new a(r6), new C0283b(r6)));
        return;
    L5:
        r8 = null;
        goto L6
    }

    public b(OpenPlatformContext r2, Queue<Long> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r3, "callHistory");
        Intrinsics.checkNotNullParameter(r4, "appId");
        super(r2, r3, r4);
        this.f = "subscribeSpecifiedContentComment";
    }
}
