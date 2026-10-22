package com.bytedance.ies.bullet.core.kit.bridge;

import androidx.annotation.Keep;
import com.bytedance.ies.bullet.service.base.m;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/IBridge3Registry;", "Lcom/bytedance/ies/bullet/service/base/m;", "", "methodName", "Lorg/json/JSONObject;", LynxResourceModule.PARAMS_KEY, "Lcom/bytedance/ies/bullet/core/kit/bridge/Callback;", "callBack", "", "handle", "(Ljava/lang/String;Lorg/json/JSONObject;Lcom/bytedance/ies/bullet/core/kit/bridge/Callback;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IBridge3Registry extends m {
    void handle(String r5, JSONObject r10, Callback r11);

    @Override // com.bytedance.ies.bullet.service.base.m
    /* synthetic */ void release();
}
