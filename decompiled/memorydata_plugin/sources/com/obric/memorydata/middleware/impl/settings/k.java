package com.obric.memorydata.middleware.impl.settings;

import android.content.Context;
import android.util.Log;
import com.bytedance.applog.AppLog;
import com.bytedance.bdinstall.Level;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.crash.Ensure;
import com.bytedance.rpc.service.GeneralService;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.controller.NetworkController;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/SettingsRequestServiceImpl;", "Lcom/bytedance/news/common/settings/api/RequestService;", "<init>", "()V", Ext.KEY_REQUEST, "Lcom/bytedance/news/common/settings/api/Response;", "getBaseUrl", "", "isApiSuccess", "", "o", "Lorg/json/JSONObject;", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k implements com.bytedance.news.common.settings.api.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11868a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f11869b = null;
    private static final String c = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/SettingsRequestServiceImpl$Companion;", "", "<init>", "()V", "TAG", "", "SETTINGS_RELATIVE_URL", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11868a = new a(null);
        f11869b = "Mem_Settings";
        c = "/service/settings/v3/";
    }

    public k() {
    }

    private final String b() {
        return "https://is.snssdk.com";
    }

    @Override // com.bytedance.news.common.settings.api.b
    public com.bytedance.news.common.settings.api.c a() {
        com.bytedance.news.common.settings.api.c r0 = new com.bytedance.news.common.settings.api.c();
        if (NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L5;
    L26:
        Log.i(f11869b, "settings request network unavailable or screen off");
        return r0;
    L5:
        if (NetworkController.INSTANCE.isNetworkPolicySatisfied() == false) goto L26;
        String r4 = AppLog.addNetCommonParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), b() + c, true, Level.L1);     // Catch: Exception -> L10
        RunLog.INSTANCE.debug(f11869b, "settings url " + r4);     // Catch: Exception -> L10
        Object r5 = GeneralService.get(r4, null, String.class);     // Catch: Exception -> L10
        Intrinsics.checkNotNullExpressionValue(r5, "get(...)");     // Catch: Exception -> L10
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
    L12:
        RunLog.INSTANCE.debug(f11869b, "settings:  " + r6);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L18;
        return r0;
    L18:
        JSONObject r8 = new JSONObject(r6);
        if (a(r8) == true) goto L30;
        return r0;
    L30:
        JSONObject r12 = r8.optJSONObject("data");     // Catch: Exception -> L23
        r0.f2921b = new com.bytedance.news.common.settings.api.e(r12.optJSONObject("settings"), null);     // Catch: Exception -> L23
        r0.c = r12.optJSONObject("vid_info");     // Catch: Exception -> L23
        r0.d = r12.optString("ctx_infos");     // Catch: Exception -> L23
        r0.f2920a = true;     // Catch: Exception -> L23
    L25:
        return r0;
    L23:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), f11869b, "settings parse data error : " + e, null, 4, null);
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "settings parse data error responseJson:" + r8);
        goto L25
    L15:
        r7 = false;
    L10:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), f11869b, "settings request error : " + e, null, 4, null);
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), e.getMessage());
        r6 = "";
        goto L12
    }

    public final boolean a(JSONObject r1) {
        if (r1 == null) goto L4;
        String r0 = r1.optString("message");
    L6:
        return Intrinsics.areEqual("success", r0);
    L4:
        r0 = null;
        goto L6
    }
}
