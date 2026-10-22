package com.bytedance.android.live.saas.middleware.applog;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.saas.IAppLogExtend;
import com.bytedance.android.live.saas.OaidChangedCallback;
import com.bytedance.bdinstall.Level;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.c0;
import com.ss.android.common.lib.AppLogNewUtils;
import f06.b;
import f06.c;
import f06.d;
import java.util.Iterator;
import java.util.Map;
import jta.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kta.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J&\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00042\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\"\u001a\u00020\u00062\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/applog/AppLogImp;", "Lcom/bytedance/android/live/saas/IAppLogExtend;", "()V", "mOaid", "", "ObserveOaidChanged", "", "callback", "Lcom/bytedance/android/live/saas/OaidChangedCallback;", "addCommonParams", "url", "isApi", "", "addCustomHeader", "k", "v", "buildJsonObject", "Lorg/json/JSONObject;", "map", "", "getAbSdkVersion", "getCurrentSessionId", "getDid", "getInstallId", "getOaid", "context", "Landroid/content/Context;", "isTob", "log", "eventName", "params", "observeIdChanged", "Lcom/bytedance/android/live/saas/middleware/applog/IdChangedCallback;", "onEventV3", "putCommonParams", "tryWaitDeviceInit", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class AppLogImp implements IAppLogExtend {
    private String mOaid;

    @Override // com.bytedance.android.live.saas.IAppLogExtend
    public void ObserveOaidChanged(OaidChangedCallback r1) {
    }

    @Override // com.bytedance.android.live.saas.middleware.applog.IAppLog
    public String getAbSdkVersion() {
        return "unknown";
    }

    @Override // com.bytedance.android.live.saas.middleware.applog.IAppLog
    public boolean isTob() {
        return false;
    }

    @Override // com.bytedance.android.live.saas.middleware.applog.IAppLog
    public void tryWaitDeviceInit() {
        boolean r0 = AppLog.L;
        g.j.v(g.c);
    }

    public AppLogImp() {
        this.mOaid = "";
    }

    @Override // com.bytedance.android.live.saas.middleware.applog.IAppLog
    public String getCurrentSessionId() {
        return AppLog.getCurrentSessionId();
    }

    @Override // com.bytedance.android.live.saas.middleware.applog.IAppLog
    public String getDid() {
        return g.d();
    }

    @Override // com.bytedance.android.live.saas.middleware.applog.IAppLog
    public String getInstallId() {
        return AppLog.r();
    }

    private final JSONObject buildJsonObject(Map<String, String> r5) {
        JSONObject r0 = new JSONObject();
        if (r5 != null) goto L5;
    L14:
        return r0;
    L5:
        if (r5.isEmpty() == true) goto L14;
        Iterator<String> r1 = r5.keySet().iterator();     // Catch: Exception -> L12
    L9:
        if (r1.hasNext() == false) goto L14;
        String r2 = r1.next();     // Catch: Exception -> L12
        r0.put(r2, r5.get(r2));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    private static String com_bytedance_android_live_saas_middleware_applog_AppLogImp_com_ss_android_deviceregister_base_Oaid_getOaidId(n r13) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        b r10 = new b();
        d r12 = r8.b(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", r13, r9, "java.lang.String", r10);
        if (r12.a == false) goto L6;
        r8.a(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", r13, r9, null, r10, false);
        return (String) r12.b;
    L6:
        String r14 = r13.b();
        r8.a(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", r13, r9, r14, r10, true);
        return r14;
    }

    @Override // com.bytedance.android.live.saas.IAppLogExtend
    public String getOaid(Context r2) {
        if (StringsKt.isBlank(this.mOaid) == false) goto L6;
        return com_bytedance_android_live_saas_middleware_applog_AppLogImp_com_ss_android_deviceregister_base_Oaid_getOaidId(n.c(r2));
    L6:
        return this.mOaid;
    }

    @Override // com.bytedance.android.live.saas.middleware.applog.IAppLog
    public void observeIdChanged(final IdChangedCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        g.b(new AnonymousClass1(r2));
    }

    @Override // com.bytedance.android.live.saas.middleware.applog.IAppLog
    public String addCommonParams(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "url");
        boolean r0 = AppLog.L;
        return c0.b(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.applog.IAppLog
    public void addCustomHeader(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "k");
        Bundle r0 = new Bundle();
        r0.putString(r2, r3);
        AppLog.g0.d(r0);
    }

    @Override // com.bytedance.android.live.saas.middleware.applog.IAppLog
    public void log(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        AppLogNewUtils.onEventV3(r2, buildJsonObject(r3));
    }

    @Override // com.bytedance.android.live.saas.middleware.applog.IAppLog
    public void onEventV3(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        AppLogNewUtils.onEventV3(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.applog.IAppLog
    public void putCommonParams(Map<String, String> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        eta.b r0 = c0.a;
        c0.g(r2, r3, Level.L0);
    }
}
