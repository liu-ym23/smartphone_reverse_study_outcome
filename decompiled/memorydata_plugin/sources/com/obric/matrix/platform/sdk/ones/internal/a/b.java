package com.obric.matrix.platform.sdk.ones.internal.a;

import android.content.Context;
import android.util.Log;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.g;
import com.obric.matrix.platform.sdk.ones.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0010H\u0002J\u0006\u0010\u001e\u001a\u00020\u001aJ\u0016\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"J&\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/monitor/SdkMonitorManager;", "", "()V", "KEY_APP_VERSION", "", "KEY_CHANNEL", "KEY_DEVICE_ID", "KEY_HOST_ID", "KEY_OVERSEA", "KEY_SDK_NAME", "KEY_SDK_VERSION", "KEY_SDK_VERSION_CODE", "TAG", "VALUE_IS_NOT_OVERSEA", "VALUE_IS_OVERSEA", "isInit", "", "sdkName", "getChannel", "getConfigUrl", "getReportUrl", "getSdkAid", "getSdkVersionCode", "", "getSdkVersionName", "initSDKMonitor", "", "context", "Landroid/content/Context;", "isOverSea", "reportSdkInitSuccess", "sdkMonitorEvent", "eventName", EventBody.KEY_CATEGORY, "Lorg/json/JSONObject;", EventBody.KEY_METRIC, "logExtr", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8106a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f8107b;
    private static String c;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/platform/sdk/ones/internal/monitor/SdkMonitorManager$initSDKMonitor$1", "Lcom/bytedance/framwork/core/sdkmonitor/SDKMonitor$IGetExtendParams;", "getCommonParams", "", "", "getSessionId", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements SDKMonitor.c {
        a() {
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.c
        public Map<String, String> getCommonParams() {
            if (b.a(b.f8106a) == false) goto L5;
            String r4 = "1";
        L6:
            Pair[] r0 = new Pair[2];
            com.obric.matrix.platform.sdk.ones.a r2 = com.obric.matrix.platform.sdk.ones.b.f8082a.b();
            if (r2 == null) goto L10;
            String r3 = r2.a();
            if (r3 == null) goto L10;
        L11:
            r0[0] = TuplesKt.to("host_aid", r3);
            r0[1] = TuplesKt.to("oversea", r4);
            return MapsKt.mutableMapOf(r0);
        L10:
            r3 = "";
            goto L11
        L5:
            r4 = "0";
            goto L6
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.c
        public String getSessionId() {
            return null;
        }
    }

    static {
        f8106a = new b();
        c = "ones_sdk";
    }

    private b() {
    }

    private final String a() {
        f();
        return "568500";
    }

    public static final /* synthetic */ boolean a(b r0) {
        return r0.f();
    }

    private final String b() {
        if (f() == false) goto L5;
        return "https://mon.isnssdk.com/monitor/appmonitor/v2/settings";
    L5:
        return "https://mon.snssdk.com/monitor/appmonitor/v2/settings";
    }

    private final String c() {
        if (f() == false) goto L5;
        return "https://mon.isnssdk.com/monitor/collect/";
    L5:
        return "https://mon.snssdk.com/monitor/collect/";
    }

    private final int d() {
        return BuildConfig.SDK_VERSION_CODE;
    }

    private final String e() {
        return BuildConfig.SDK_VERSION_NAME;
    }

    private final boolean f() {
        com.obric.matrix.platform.sdk.ones.a r0 = com.obric.matrix.platform.sdk.ones.b.f8082a.b();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.d();
    }

    private final String g() {
        return "release";
    }

    public final void a(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        g.a(a(), CollectionsKt.listOf(b()));
        g.b(a(), CollectionsKt.listOf(c()));
        String r3 = null;
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("SdkMonitorManager", "sdk aid " + a() + " , config url " + b() + " \n , reporturl " + c(), null, 4, null);
        JSONObject r0 = new JSONObject();
        com.obric.matrix.platform.sdk.ones.a r5 = com.obric.matrix.platform.sdk.ones.b.f8082a.b();
        if (r5 == null) goto L5;
        String r6 = r5.c();
    L6:
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("SdkMonitorManager", "device_id = " + r6, null, 4, null);
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L9;
    L12:
        boolean r8 = true;
    L13:
        if (r8 == false) goto L16;
        f8107b = false;
        return;
    L16:
        r0.put("device_id", r6);
        r0.put("sdk_version", e());
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("SdkMonitorManager", "sdk version = " + e(), null, 4, null);
        com.obric.matrix.platform.sdk.ones.a r2 = com.obric.matrix.platform.sdk.ones.b.f8082a.b();
        if (r2 == null) goto L19;
        String r4 = r2.a();
    L20:
        r0.put("host_aid", r4);
        com.obric.matrix.platform.sdk.ones.a r9 = com.obric.matrix.platform.sdk.ones.b.f8082a.b();
        if (r9 == null) goto L23;
        r3 = r9.b();
    L23:
        r0.put("app_version", r3);
        r0.put("channel", g());
        g.a(r11, a(), r0, (SDKMonitor.c) ZeusTransformUtils.preCheckCast(new a(), SDKMonitor.c.class, "com.obric.memorydata.plugin"));
        f8107b = true;
        return;
    L19:
        r4 = null;
        goto L20
    L9:
        if (r7.length() == 0) goto L12;
        r8 = false;
        goto L13
    L5:
        r6 = null;
        goto L6
    }

    public final void a(String r8, JSONObject r9, JSONObject r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r8, "eventName");
        Intrinsics.checkNotNullParameter(r9, EventBody.KEY_CATEGORY);
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_METRIC);
        Intrinsics.checkNotNullParameter(r11, "logExtr");
    L24:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("SdkMonitorManager", "event report exception " + Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);
        return;
    L4:
        if (f8107b == true) goto L22;
        com.obric.matrix.platform.sdk.ones.a r4 = com.obric.matrix.platform.sdk.ones.b.f8082a.b();     // Catch: Exception -> L24
        if (r4 == null) goto L8;
        String r5 = r4.c();     // Catch: Exception -> L24
    L9:
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("SdkMonitorManager", "on event device_id = " + r5, null, 4, null);     // Catch: Exception -> L24
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L24
        if (r6 != null) goto L12;
    L15:
        boolean r7 = true;
    L16:
        if (r7 == false) goto L19;
        f8107b = false;     // Catch: Exception -> L24
        return;
    L19:
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.matrix.platform.sdk.ones.b.f8082a.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L24
        if (r12 == null) goto L22;
        f8106a.a(r12);     // Catch: Exception -> L24
        goto L22
    L12:
        if (r6.length() == 0) goto L15;
        r7 = false;
        goto L16
    L8:
        r5 = null;
    L22:
        r9.put(Api.KEY_SDK_VERSION_CODE, d());     // Catch: Exception -> L24
        r9.put("sdk_name", c);     // Catch: Exception -> L24
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("SdkMonitorManager", "event " + r8 + ", category: " + r9 + ", metric " + r10 + ", logExtr " + r11, null, 4, null);     // Catch: Exception -> L24
        g.a(a()).monitorEvent(r8, r9, r10, r11);     // Catch: Exception -> L24
    }
}
