package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.content.Context;
import androidx.annotation.Keep;
import cj.d;
import gj.a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ?\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0015\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0010H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostRouterDepend;", "", "Lcj/d;", "xBridgeContext", "", "Lgj/a;", "provideRouteOpenHandlerList", "(Lcj/d;)Ljava/util/List;", "provideRouteOpenExceptionHandler", "(Lcj/d;)Lgj/a;", "", "schema", "", "extraParams", "Landroid/content/Context;", "context", "", "openSchema", "(Lcj/d;Ljava/lang/String;Ljava/util/Map;Landroid/content/Context;)Z", "containerID", "animated", "closeView", "(Lcj/d;Ljava/lang/String;Z)Z", "assembleHandlerChain", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostRouterDepend {
    boolean closeView(d r5, String r10, boolean r11);

    boolean openSchema(d r5, String r10, Map<String, ? extends Object> r11, Context r12);

    a provideRouteOpenExceptionHandler(d r5);

    List<a> provideRouteOpenHandlerList(d r5);
}
