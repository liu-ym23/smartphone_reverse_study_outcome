package com.bytedance.ies.xbridge.base.runtime.depend;

import androidx.annotation.Keep;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.List;
import ke.a;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J?\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostFrameworkDepend;", "", "Lke/a;", "contextProviderFactory", "", "getContainerID", "(Lke/a;)Ljava/lang/String;", "actionType", "", "eventName", "Lorg/json/JSONObject;", LynxResourceModule.PARAMS_KEY, "", "addObserverEvent", "(Lke/a;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostFrameworkDepend {
    void addObserverEvent(a r5, String r10, List<String> r11, List<? extends JSONObject> r12);

    String getContainerID(a r5);
}
