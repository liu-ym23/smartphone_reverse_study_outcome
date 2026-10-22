package po0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.di.MiniAppAnchorModule_ProvideMiniAppAnchorServiceFactory;
import com.bytedance.android.live.openplatform.impl.miniappaudience.di.MiniAppAudienceModule_ProvideMiniAppAudienceServiceFactory;
import com.bytedance.android.live.openplatform.impl.minigameanchor.di.MiniGameAnchorModule_ProvideMiniGameAnchorServiceFactory;
import com.bytedance.android.live.openplatform.impl.minigameaudience.di.MiniGameAudienceModule_ProvideMiniGameAudienceServiceFactory;
import com.bytedance.android.live.openplatform.impl.openapi.di.OpenApiModule_ProvideOpenApiServiceFactory;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {

    /* JADX INFO: renamed from: po0.a$a, reason: collision with other inner class name */
    public static final class C0252a {
        public final b a;

        public C0252a(b r1) {
            this.a = r1;
        }
    }

    public static final class b implements e {
        public final b a;
        public Provider<so0.a> b;
        public Provider<yo0.b> c;
        public Provider<to0.a> d;
        public Provider<vo0.a> e;
        public Provider<wo0.a> f;

        public final C0252a a() {
            return new C0252a(this.a);
        }

        public b(qp0.a r1, jq0.a r2, ar0.a r3, hr0.a r4, or0.a r5) {
            this.a = this;
            this.b = DoubleCheck.provider(MiniAppAnchorModule_ProvideMiniAppAnchorServiceFactory.create(r1));
            this.c = DoubleCheck.provider(OpenApiModule_ProvideOpenApiServiceFactory.create(r5));
            this.d = DoubleCheck.provider(MiniAppAudienceModule_ProvideMiniAppAudienceServiceFactory.create(r2));
            this.e = DoubleCheck.provider(MiniGameAnchorModule_ProvideMiniGameAnchorServiceFactory.create(r3));
            this.f = DoubleCheck.provider(MiniGameAudienceModule_ProvideMiniGameAudienceServiceFactory.create(r4));
        }
    }

    public static b a() {
        return new b(new qp0.a(), new jq0.a(), new ar0.a(), new hr0.a(), new or0.a());
    }
}
