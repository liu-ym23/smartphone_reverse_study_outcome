package com.obric.aiagent.product.internal;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/aiagent/product/internal/ObricProductSdkImpl;", "Lcom/obric/aiagent/product/IObricProductSdk;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "loopJob", "Lkotlinx/coroutines/Job;", CommonConsts.APM_INNER_EVENT_COST_INIT, "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialize", "", "getInitialize", "()Z", "", "platformService", "Lcom/obric/aiagent/product/platform/api/IPlatformService;", "featureService", "Lcom/obric/aiagent/product/feature/api/IFeatureService;", "destroy", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricProductSdkImpl implements com.obric.aiagent.product.a {
    public static final a Companion = null;
    private static final String TAG = "ObricProductSdkImpl";
    private static final ObricProductSdkImpl instance = null;
    private final AtomicBoolean init;
    private bx loopJob;
    private final al scope;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/product/internal/ObricProductSdkImpl$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/obric/aiagent/product/internal/ObricProductSdkImpl;", "getInstance", "()Lcom/obric/aiagent/product/internal/ObricProductSdkImpl;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final ObricProductSdkImpl a() {
            return ObricProductSdkImpl.access$getInstance$cp();
        }
    }

    static {
        Companion = new a(null);
        instance = new ObricProductSdkImpl();
    }

    public ObricProductSdkImpl() {
        this.scope = am.a(ba.c().plus((CoroutineContext) ZeusTransformUtils.preCheckCast(cu.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin")));
        this.init = new AtomicBoolean(false);
    }

    public static final /* synthetic */ ObricProductSdkImpl access$getInstance$cp() {
        return instance;
    }

    public void destroy() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.init.get() == true) goto L6;
        d.f5954a.d(TAG, "product sdk is not init");     // Catch: Throwable -> L10
    L7:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        com.obric.aiagent.product.feature.a.a.f5975a.a().b();     // Catch: Throwable -> L10
        IPlatformService.Companion.get().destroy();     // Catch: Throwable -> L10
        this.init.set(false);     // Catch: Throwable -> L10
        goto L7
    }

    public com.obric.aiagent.product.feature.a.a featureService() {
        return com.obric.aiagent.product.feature.a.a.f5975a.a();
    }

    public final boolean getInitialize() {
        return this.init.get();
    }

    public void init() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.init.get() == false) goto L6;
        d.f5954a.d(TAG, "product sdk is already init");     // Catch: Throwable -> L10
    L7:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        com.obric.aiagent.product.feature.a.a.f5975a.a().a();     // Catch: Throwable -> L10
        IPlatformService.Companion.get().init();     // Catch: Throwable -> L10
        this.init.set(true);     // Catch: Throwable -> L10
        goto L7
    }

    public IPlatformService platformService() {
        return IPlatformService.Companion.get();
    }
}
