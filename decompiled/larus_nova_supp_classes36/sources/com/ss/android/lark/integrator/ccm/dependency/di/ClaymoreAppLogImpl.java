package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.applogbridge.AppLogProxy;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(xw4.a.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/integrator/ccm/dependency/di/ClaymoreAppLogImpl;", "Lcom/bytedance/ee/bear/contract/log/IAppLogDependency;", "<init>", "()V", "appLogDependency", "Lcom/ss/android/lark/integrator/ccm/dependency/di/AppLogDependencyImpl;", "sendEvent", "", "eventName", "", "paramsJSONObject", "Lorg/json/JSONObject;", "onCreate", "context", "Landroid/content/Context;", "onPause", "onResume", "getSessionId", "ccm-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ClaymoreAppLogImpl implements xw4.a {
    private final b appLogDependency;

    public String getSessionId() {
        this.appLogDependency.getClass();
        return AppLogProxy.getSessionId();
    }

    public ClaymoreAppLogImpl() {
        this.appLogDependency = new b();
    }

    public void onCreate(Context r1) {
        this.appLogDependency.getClass();
        com.ss.android.lark.statistics.b.c.getClass();
    }

    public void onPause(Context r1) {
        this.appLogDependency.getClass();
        com.ss.android.lark.statistics.b.c.getClass();
    }

    public void onResume(Context r1) {
        this.appLogDependency.getClass();
        com.ss.android.lark.statistics.b.c.getClass();
    }

    public void sendEvent(String r2, JSONObject r3) {
        this.appLogDependency.getClass();
        com.ss.android.lark.statistics.b.b(r2, r3);
    }
}
