package com.bytedance.sdk.xbridge.cn.runtime.depend;

import androidx.annotation.Keep;
import cj.d;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "No need to inject", replaceWith = @ReplaceWith(expression = "this depend is no need to inject", imports = {}))
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J?\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostFrameworkDepend;", "", "Lcj/d;", "bridgeContext", "", "actionType", "", "eventName", "Lorg/json/JSONObject;", LynxResourceModule.PARAMS_KEY, "", "addObserverEvent", "(Lcj/d;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostFrameworkDepend {
    void addObserverEvent(d r5, String r10, List<String> r11, List<? extends JSONObject> r12);
}
