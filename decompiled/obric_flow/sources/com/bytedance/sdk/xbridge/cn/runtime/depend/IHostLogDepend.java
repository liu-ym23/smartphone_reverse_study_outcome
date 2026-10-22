package com.bytedance.sdk.xbridge.cn.runtime.depend;

import androidx.annotation.Keep;
import cj.d;
import com.lynx.jsbridge.LynxResourceModule;
import hj.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J/\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\f\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0014\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostLogDepend;", "", "", "eventName", "", "map", "", "onEventV3Map", "(Ljava/lang/String;Ljava/util/Map;)V", LynxResourceModule.PARAMS_KEY, "", "isApi", "putCommonParams", "(Ljava/util/Map;Z)V", "Lcj/d;", "bridgeContext", "name", "Lhj/c;", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IReportADLogResultCallback;", "callback", "handleReportADLog", "(Lcj/d;Ljava/lang/String;Lhj/c;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IReportADLogResultCallback;)V", "reportJSBError", "(Lcj/d;Ljava/util/Map;)Lkotlin/Unit;", "reportJSBFetchError", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostLogDepend {
    void handleReportADLog(d r5, String r10, c r11, IReportADLogResultCallback r12);

    void onEventV3Map(String r5, Map<String, String> r10);

    void putCommonParams(Map<String, String> r5, boolean r10);

    Unit reportJSBError(d r5, Map<String, ? extends Object> r10);

    Unit reportJSBFetchError(d r5, Map<String, ? extends Object> r10);
}
