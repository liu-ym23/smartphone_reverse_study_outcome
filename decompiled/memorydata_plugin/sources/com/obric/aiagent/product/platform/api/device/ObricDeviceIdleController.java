package com.obric.aiagent.product.platform.api.device;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.a.a;
import com.obric.aiagent.product.platform.impl.device.AssistantDeviceIdleControllerImpl;
import com.obric.aiagent.product.platform.impl.device.CommonObricDeviceIdleController;
import com.ss.android.ugc.aweme.framework.services.f;
import com.ss.android.ugc.aweme.framework.services.g;
import com.ss.android.ugc.aweme.framework.services.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/aiagent/product/platform/api/device/ObricDeviceIdleController;", "", "<init>", "()V", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricDeviceIdleController {
    public static final Companion Companion = null;
    private static final String TAG = "ObricDeviceIdleController";
    private static IObricDeviceIdleController instance;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/aiagent/product/platform/api/device/ObricDeviceIdleController$Companion;", "Lcom/obric/aiagent/product/platform/api/device/IObricDeviceIdleController;", "<init>", "()V", "TAG", "", "instance", "addToTemporaryAllowList", "", "pkgList", "", LocationMonitorConst.TIMEOUT, "", InfoRequestQPSOptTraceLogger.REASON, "([Ljava/lang/String;JLjava/lang/String;)Z", "removeFromTemporaryAllowList", "([Ljava/lang/String;Ljava/lang/String;)Z", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements IObricDeviceIdleController {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @Override // com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController
        public boolean addToTemporaryAllowList(String[] r1, long r2, String r4) {
            Intrinsics.checkNotNullParameter(r1, "pkgList");
            Intrinsics.checkNotNullParameter(r4, InfoRequestQPSOptTraceLogger.REASON);
            IObricDeviceIdleController r0 = ObricDeviceIdleController.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.addToTemporaryAllowList(r1, r2, r4);
        }

        @Override // com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController
        public boolean removeFromTemporaryAllowList(String[] r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "pkgList");
            Intrinsics.checkNotNullParameter(r2, InfoRequestQPSOptTraceLogger.REASON);
            IObricDeviceIdleController r0 = ObricDeviceIdleController.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.removeFromTemporaryAllowList(r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    L9:
        th = move-exception;
        d.f5954a.b(TAG, "bind DeviceIdleController failed", th);
    L11:
        instance = (IObricDeviceIdleController) ZeusTransformUtils.preCheckCast(f.a().a(IObricDeviceIdleController.class, false), IObricDeviceIdleController.class, "com.obric.memorydata.plugin");
        d.f5954a.b(TAG, "ObricDeviceIdleController instance: " + instance);
        return;
    L4:
        if (a.f5964a.a() == false) goto L7;
        f r2 = f.a();     // Catch: Throwable -> L9
        Class<IObricDeviceIdleController> r3 = IObricDeviceIdleController.class;
        g r4 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$ObricDeviceIdleController$k9EntNZI9Kt1wQ6yrowX_vrSpNw.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L6:
        r2.a(r3, r4);     // Catch: Throwable -> L9
        goto L11
    L7:
        r2 = f.a();     // Catch: Throwable -> L9
        r3 = IObricDeviceIdleController.class;
        r4 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$ObricDeviceIdleController$GAYVmQOczDjWroWh2x8wddNje10.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        goto L6
    }

    public ObricDeviceIdleController() {
    }

    private static final Object _init_$lambda$0() {
        return new AssistantDeviceIdleControllerImpl();
    }

    private static final Object _init_$lambda$1() {
        return new CommonObricDeviceIdleController();
    }

    public static final /* synthetic */ IObricDeviceIdleController access$getInstance$cp() {
        return instance;
    }

    public static /* synthetic */ Object lambda$GAYVmQOczDjWroWh2x8wddNje10() {
        return _init_$lambda$1();
    }

    public static /* synthetic */ Object lambda$k9EntNZI9Kt1wQ6yrowX_vrSpNw() {
        return _init_$lambda$0();
    }
}
