package com.bytedance.ies.xbridge.base.runtime.depend;

import androidx.annotation.Keep;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.lynx.jsbridge.LynxResourceModule;
import ge.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import ne.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J/\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\f\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ9\u0010\u0016\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostLogDepend;", "", "", "eventName", "", "map", "", "onEventV3Map", "(Ljava/lang/String;Ljava/util/Map;)V", LynxResourceModule.PARAMS_KEY, "", "isApi", "putCommonParams", "(Ljava/util/Map;Z)V", "Lke/a;", "contextProviderFactory", "name", "Lge/c;", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IReportADLogResultCallback;", "callback", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "type", "handleReportADLog", "(Lke/a;Ljava/lang/String;Lge/c;Lcom/bytedance/ies/xbridge/base/runtime/depend/IReportADLogResultCallback;Lcom/bytedance/ies/xbridge/XBridgePlatformType;)V", "reportJSBError", "(Lke/a;Ljava/util/Map;)Lkotlin/Unit;", "reportJSBFetchError", "Lne/a;", "getLogService", "()Lne/a;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostLogDepend {
    a getLogService();

    void handleReportADLog(ke.a r5, String r10, c r11, IReportADLogResultCallback r12, XBridgePlatformType r13);

    void onEventV3Map(String r5, Map<String, String> r10);

    void putCommonParams(Map<String, String> r5, boolean r10);

    Unit reportJSBError(ke.a r5, Map<String, ? extends Object> r10);

    Unit reportJSBFetchError(ke.a r5, Map<String, ? extends Object> r10);
}
