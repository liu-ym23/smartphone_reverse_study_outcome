package com.bytedance.ies.xbridge.base.runtime.depend;

import android.content.Context;
import androidx.annotation.Keep;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import java.util.List;
import java.util.Map;
import ke.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJG\u0010\u0013\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u0018\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0017\u001a\u00020\u0012H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostRouterDepend;", "", "Lke/a;", "contextProviderFactory", "", "Lfe/a;", "provideRouteOpenHandlerList", "(Lke/a;)Ljava/util/List;", "provideRouteOpenExceptionHandler", "(Lke/a;)Lfe/a;", "", "schema", "", "extraParams", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "platformType", "Landroid/content/Context;", "context", "", "openSchema", "(Lke/a;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/ies/xbridge/XBridgePlatformType;Landroid/content/Context;)Z", "type", "containerID", "animated", "closeView", "(Lke/a;Lcom/bytedance/ies/xbridge/XBridgePlatformType;Ljava/lang/String;Z)Z", "assembleHandlerChain", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostRouterDepend {
    boolean closeView(a r5, XBridgePlatformType r10, String r11, boolean r12);

    boolean openSchema(a r5, String r10, Map<String, ? extends Object> r11, XBridgePlatformType r12, Context r13);

    fe.a provideRouteOpenExceptionHandler(a r5);

    List<fe.a> provideRouteOpenHandlerList(a r5);
}
