package com.obric.aiagent.product;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.internal.ObricProductSdkImpl;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/product/IObricProductSdk;", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "destroy", "platformService", "Lcom/obric/aiagent/product/platform/api/IPlatformService;", "featureService", "Lcom/obric/aiagent/product/feature/api/IFeatureService;", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0243a f5962a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.product.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/IObricProductSdk$Companion;", "", "<init>", "()V", "get", "Lcom/obric/aiagent/product/internal/ObricProductSdkImpl;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0243a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C0243a f5963a = null;

        static {
            f5963a = new C0243a();
        }

        private C0243a() {
        }

        public final ObricProductSdkImpl a() {
            return ObricProductSdkImpl.Companion.a();
        }
    }

    static {
        f5962a = C0243a.f5963a;
    }
}
