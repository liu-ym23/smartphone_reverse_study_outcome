package com.ss.android.lark.lynxkit.xbridge.depend;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostLogDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IReportADLogResultCallback;
import com.bytedance.ies.xbridge.utils.d;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import g66.c;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s56.e;
import sva.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000fH\u0016J$\u0010\u0010\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J2\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/depend/XHostLogDependImpl;", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostLogDepend;", "<init>", "()V", "appLogProxy", "Lcom/ss/android/lark/applogbridgeapi/IAppLogProxy;", "getAppLogProxy", "()Lcom/ss/android/lark/applogbridgeapi/IAppLogProxy;", "appLogProxy$delegate", "Lkotlin/Lazy;", "onEventV3Map", "", "eventName", "", "map", "", "putCommonParams", "params", "isApi", "", "handleReportADLog", "contextProviderFactory", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "name", "Lcom/bytedance/ies/xbridge/base/runtime/model/XReportADLogParams;", "callback", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IReportADLogResultCallback;", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class XHostLogDependImpl implements IHostLogDepend {
    private final Lazy appLogProxy$delegate;

    public d getLogService() {
        return null;
    }

    public void handleReportADLog(c r1, String r2, e r3, IReportADLogResultCallback r4, XBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "type");
    }

    private final a getAppLogProxy() {
        return (a) this.appLogProxy$delegate.getValue();
    }

    public XHostLogDependImpl() {
        this.appLogProxy$delegate = LazyKt.lazy(XHostLogDependImpl$appLogProxy$2.INSTANCE);
    }

    public void onEventV3Map(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        a r0 = getAppLogProxy();
        if (r4 != null) goto L5;
        r4 = MapsKt.emptyMap();
    L5:
        r0.onEventV3(r3, new JSONObject(r4));
    }

    public void putCommonParams(Map<String, String> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        getAppLogProxy().putCommonParams(r2, r3);
    }

    public Unit reportJSBError(c r1, Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        return null;
    }

    public Unit reportJSBFetchError(c r1, Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        return null;
    }
}
