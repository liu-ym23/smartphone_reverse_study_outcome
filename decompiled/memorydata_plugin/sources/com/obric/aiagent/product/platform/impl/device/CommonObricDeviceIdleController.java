package com.obric.aiagent.product.platform.impl.device;

import android.os.ObricDeviceIdleController;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/device/CommonObricDeviceIdleController;", "Lcom/obric/aiagent/product/platform/api/device/IObricDeviceIdleController;", "<init>", "()V", "addToTemporaryAllowList", "", "pkgList", "", "", LocationMonitorConst.TIMEOUT, "", InfoRequestQPSOptTraceLogger.REASON, "([Ljava/lang/String;JLjava/lang/String;)Z", "removeFromTemporaryAllowList", "([Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CommonObricDeviceIdleController implements IObricDeviceIdleController {
    public static final Companion Companion = null;
    public static final String TAG = "CommonObricDeviceIdleController";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/device/CommonObricDeviceIdleController$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CommonObricDeviceIdleController() {
    }

    @Override // com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController
    public boolean addToTemporaryAllowList(String[] r1, long r2, String r4) {
        Intrinsics.checkNotNullParameter(r1, "pkgList");
        Intrinsics.checkNotNullParameter(r4, InfoRequestQPSOptTraceLogger.REASON);
        return ObricDeviceIdleController.getInstance().addToTemporaryAllowList(r1, r2, r4);
    }

    @Override // com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController
    public boolean removeFromTemporaryAllowList(String[] r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "pkgList");
        Intrinsics.checkNotNullParameter(r2, InfoRequestQPSOptTraceLogger.REASON);
        return ObricDeviceIdleController.getInstance().removeFromTemporaryAllowList(r1, r2);
    }
}
