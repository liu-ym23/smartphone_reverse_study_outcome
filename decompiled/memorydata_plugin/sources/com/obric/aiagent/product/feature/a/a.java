package com.obric.aiagent.product.feature.a;

import com.bytedance.apm6.util.constant.CommonConsts;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH&J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\tH&J\b\u0010\u000f\u001a\u00020\u0006H&J\b\u0010\u0010\u001a\u00020\u0006H&J\b\u0010\u0011\u001a\u00020\u0006H&¨\u0006\u0013"}, d2 = {"Lcom/obric/aiagent/product/feature/api/IFeatureService;", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "destroy", "isObricFeatureEnable", "", "isFeatureEnable", "featureKey", "", "getFeatureState", "getFeatureStateList", "", "getObricProductName", "appVariant", "isObricOs", "isEmulatorOs", "isGlobalEffectStopLayerEffective", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0244a f5975a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.product.feature.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/feature/api/IFeatureService$Companion;", "", "<init>", "()V", "get", "Lcom/obric/aiagent/product/feature/api/IFeatureService;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0244a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C0244a f5976a = null;

        static {
            f5976a = new C0244a();
        }

        private C0244a() {
        }

        public final a a() {
            return com.obric.aiagent.product.feature.b.a.f5977b.a();
        }
    }

    static {
        f5975a = C0244a.f5976a;
    }

    void a();

    boolean a(String r1);

    String b(String r1);

    void b();

    String c();

    List<String> c(String r1);

    String d();

    boolean e();

    boolean f();
}
