package com.bytedance.ai.debugscene;

import android.os.Handler;
import android.os.Looper;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.debug.AIDebugCommand;
import com.bytedance.ai.infra.thread_pool.AISdkCoroutineUtil;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q1 {
    public static final Handler c = null;
    public final AppletDebugTool a;
    public p1 b;

    public static final class a {
    }

    public static final class b {
        public final JSONObject a;

        public b(JSONObject r1) {
            this.a = r1;
        }

        public final String a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "key");
            JSONObject r0 = this.a;
            if (r0 != null) goto L5;
        L10:
            return null;
        L5:
            if (r0.isNull(r10) == true) goto L10;
            Object r11 = this.a.opt(r10);
            if (r11 == null) goto L10;
            return r11.toString();
        }
    }

    static {
        c = new Handler(Looper.getMainLooper());
    }

    public final void d() {
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        r0.i("AppletDebugRouterMessageDispatcher", "METHOD_CONNECTED");
        this.a.getClass();
        h1.a.getClass();
        r0.i("AppletDebugTool", "received Applet_Connected from devtools");
        h1.f = true;
        h1.g();
    }

    public q1(AppletDebugTool r10) {
        Intrinsics.checkNotNullParameter(r10, "debugTool");
        this.a = r10;
    }

    public static JSONObject c(JSONObject r12) {
        com.bytedance.ai.resource.security.e r0 = com.bytedance.ai.resource.security.e.a;
        String r13 = r12.optString("params");
        r0.getClass();
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_MSG);
        com.bytedance.ai.resource.security.j.a.getClass();
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_MSG);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.constructor-impl(new JSONObject(r13));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r11) == false) goto L10;
        r11 = null;
    L10:
        JSONObject r14 = (JSONObject) r11;
        boolean r15 = false;
        if (r14 != null) goto L13;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "failed to parse debug response. message: " + r13);
    L34:
        return new JSONObject().put("success", r15);
    L13:
        String r16 = r14.optString(com.bytedance.android.ec.core.event.a.KEY_REQUEST_ID);
        com.bytedance.ai.utils.g r17 = com.bytedance.ai.utils.g.a;
        r17.d("AIPackageManager", "handleDebugDekResponse: requestId=" + r16);
        Intrinsics.checkNotNull(r16);
        if (StringsKt.isBlank(r16) == false) goto L16;
        r17.e("AIPackageManager", "requestId is null");
        goto L34
    L16:
        com.bytedance.ai.resource.security.j.b r18 = com.bytedance.ai.resource.security.j.b.remove(r16);
        if (r18 != null) goto L19;
        r17.e("AIPackageManager", "requestId is Not existed");
        goto L34
    L19:
        Job r19 = r18.f;
        if (r19 == null) goto L23;
        Job.DefaultImpls.cancel$default(r19, null, 1, null);
    L23:
        if (r14.optBoolean("success", false) == true) goto L37;
        r18.e.invoke(new IllegalStateException(r14.optString(com.bytedance.android.ec.core.event.a.KEY_MSG, "debug DEK decrypt failed")));
    L32:
        r15 = true;
        goto L34
    L37:
        byte[] r1 = com.bytedance.ai.resource.security.j.b(r18.c, r14);     // Catch: Throwable -> L27
        com.bytedance.ai.resource.security.h r20 = com.bytedance.ai.resource.security.h.a;     // Catch: Throwable -> L27
        String r21 = r18.a;     // Catch: Throwable -> L27
        long r110 = r18.b;     // Catch: Throwable -> L27
        r20.getClass();     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r21, "packageName");     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r1, "dek32");     // Catch: Throwable -> L27
        com.bytedance.ai.resource.security.h.h.put(r21 + '_' + r110, Arrays.copyOf(r1, r1.length));     // Catch: Throwable -> L27
        r17.i("AIPackageManager", "debug DEK derived and stored in memory. package=" + r18.a + " version=" + r18.b);     // Catch: Throwable -> L27
        r18.d.invoke();     // Catch: Throwable -> L27
        Object r22 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r23 = Result.exceptionOrNull-impl(r22);
        if (r23 == null) goto L32;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "failed to decrypt: " + r23);
        r18.e.invoke(r23);
    L27:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final JSONObject b(b r10) {
        String r1 = r10.a("appletName");
        String r11 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r12 = r10.a("toolName");
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        String r13 = r10.a("toolData");
        if (r13 == null) goto L12;
        r11 = r13;
    L12:
        com.bytedance.ai.utils.g.a.i("AppletDebugRouterMessageDispatcher", "METHOD_CALL_TOOL. appId:" + r1 + ", toolName:" + r12 + ", toolData:" + r11);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r1, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r12, "toolName");
        Intrinsics.checkNotNullParameter(r11, "toolData");
        int r14 = AISdkCoroutineUtil.a;
        AISdkCoroutineUtil.a(new AppletDebugTool$callAppletTool$1(r1, r12, r11, null));
        return new JSONObject().put("success", true).put("appletName", r1).put("toolName", r12);
    }

    public final JSONObject e(JSONObject r10) {
        boolean r1 = false;
        if (r10 == null) goto L5;
        r1 = r10.optBoolean("enable", false);
    L5:
        com.bytedance.ai.utils.g.a.i("AppletDebugRouterMessageDispatcher", "METHOD_SET_DEBUG_TAG. enable:" + r1);
        this.a.g(r1);
        return new JSONObject().put("success", true).put("enable", r1);
    }

    public final JSONObject g(b r10) {
        String r1 = r10.a("appletName");
        String r11 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r12 = r10.a("widgetName");
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        String r13 = r10.a("widgetData");
        if (r13 != null) goto L11;
        r13 = "";
    L11:
        String r14 = r10.a("botId");
        if (r14 == null) goto L15;
        r11 = r14;
    L15:
        this.a.getClass();
        AppletDebugTool.j(r1, r12, r13, r11);
        com.bytedance.ai.utils.g.a.i("AppletDebugRouterMessageDispatcher", "METHOD_OPEN_WIDGET. appletName:" + r1 + ", widgetName:" + r12 + ", widgetData:" + r13);
        return new JSONObject().put("success", true).put("appletName", r1).put("widgetName", r12).put("botId", r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.bytedance.ai.debugscene.o1] */
    public final void a(b r10, final int r11) {
        String r1 = r10.a("appletName");
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        AIDebugCommand r12 = new AIDebugCommand(AIDebugCommand.Source.DEVTOOL_ADB_BROADCAST, MapsKt.mapOf(new Pair[]{TuplesKt.to("appletName", r10.a("appletName")), TuplesKt.to("appletHost", r10.a("appletHost")), TuplesKt.to("appletType", r10.a("appletType")), TuplesKt.to("isSigned", r10.a("isSigned")), TuplesKt.to("signPublicKeyVersion", r10.a("signPublicKeyVersion")), TuplesKt.to("isEncrypted", r10.a("isEncrypted")), TuplesKt.to("versionTag", r10.a("versionTag")), TuplesKt.to("defaultDebugTagState", r10.a("defaultDebugTagState"))}));
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L8
        Object r14 = Result.constructor-impl(new m1(this.a).a(r12, new o1(this, r11)));     // Catch: Throwable -> L8
    L10:
        Throwable r0 = Result.exceptionOrNull-impl(r14);
        if (r0 != null) goto L20;
        com.bytedance.ai.debug.b r15 = (com.bytedance.ai.debug.b) r14;
        if (r15.b == true) goto L26;
        com.bytedance.ai.utils.g.a.w("AppletDebugRouterMessageDispatcher", "Applet_AppReload dispatch failed, message:" + r15.c);
        String r16 = r15.c;
        if (r16 != null) goto L17;
        r16 = "failed to install debug package";
    L17:
        h(r1, false, r16, r11);
        return;
    L26:
        return;
    L20:
        if ((r0 instanceof NoClassDefFoundError) == false) goto L23;
        com.bytedance.ai.utils.g.a.w("AppletDebugRouterMessageDispatcher", "ignore Applet_AppReload because AppletDebugCommandDispatcher is unavailable");
        return;
    L23:
        throw r0;
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final JSONObject f(b r17, boolean r18) {
        String r11 = r17.a("appletName");
        String r10 = r17.a("appletPageName");
        if (r10 != null) goto L5;
        String r13 = "";
    L6:
        String r12 = r17.a("appletPageUrl");
        if (r12 != null) goto L11;
        r12 = r17.a(com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r12 != null) goto L11;
        String r15 = r13;
    L12:
        String r14 = r17.a("appletPageData");
        if (r14 != null) goto L15;
        String r16 = "";
    L16:
        String r19 = r17.a("appletPageSettings");
        if (r19 == null) goto L20;
        this.a.getClass();
        JavaOnlyMap r20 = AppletDebugTool.f(r19);
        if (r20 == null) goto L20;
    L21:
        JavaOnlyMap r21 = r20;
        String r1 = r17.a("mode");
        if (r1 != null) goto L24;
        r1 = "full";
    L24:
        String r22 = r1;
        com.bytedance.ai.utils.g.a.i("AppletDebugRouterMessageDispatcher", "METHOD_OPEN_PAGE. appletName:" + r11);
        this.a.i(r11, r13, r15, r16, r21, r22, r18);
        return new JSONObject().put("success", true).put("appletName", r11).put("appletPageName", r13).put("appletPageUrl", r15).put("pageUrlOnly", r18);
    L20:
        r20 = new JavaOnlyMap();
        goto L21
    L15:
        r16 = r14;
    L11:
        r15 = r12;
        goto L12
    L5:
        r13 = r10;
        goto L6
    }

    public final void i(String r10, JSONObject r11, int r12) {
        AppletDebugTool r0 = this.a;
        String r13 = r11.toString();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "type");
        h1.a.getClass();
        h1.m(r10, r13, r12);
    }

    public final void h(String r10, boolean r11, String r12, int r13) {
        i("Applet_InstallResult", new JSONObject().put("packageName", r10).put("success", r11).put(com.bytedance.android.ec.core.event.a.KEY_MSG, r12), r13);
    }
}
