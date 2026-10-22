package com.obric.aiagent.product.platform.api.device;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0002\u0010\nJ#\u0010\u000b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/aiagent/product/platform/api/device/IObricDeviceIdleController;", "", "addToTemporaryAllowList", "", "pkgList", "", "", LocationMonitorConst.TIMEOUT, "", InfoRequestQPSOptTraceLogger.REASON, "([Ljava/lang/String;JLjava/lang/String;)Z", "removeFromTemporaryAllowList", "([Ljava/lang/String;Ljava/lang/String;)Z", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IObricDeviceIdleController {
    boolean addToTemporaryAllowList(String[] r1, long r2, String r4);

    boolean removeFromTemporaryAllowList(String[] r1, String r2);
}
