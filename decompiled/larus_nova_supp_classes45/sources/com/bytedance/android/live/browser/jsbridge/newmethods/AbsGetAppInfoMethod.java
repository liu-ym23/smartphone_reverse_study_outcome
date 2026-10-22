package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.newmethods.GetAppInfoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0014R\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/AbsGetAppInfoMethod;", "Lcom/google/gson/JsonObject;", "P", "Lcom/bytedance/android/live/browser/jsbridge/newmethods/GetAppInfoResultModel;", "R", "Lcom/bytedance/ies/web/jsbridge2/f;", "Lcom/bytedance/ies/web/jsbridge2/PermissionGroup;", "getPermissionGroup", "", "onTerminate", "", "methodName", "Ljava/lang/String;", "getMethodName", "()Ljava/lang/String;", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsGetAppInfoMethod<P extends JsonObject, R extends GetAppInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    private final String methodName;

    public void onTerminate() {
    }

    public AbsGetAppInfoMethod() {
        this.methodName = "getAppInfo";
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
