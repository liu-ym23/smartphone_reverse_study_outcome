package com.bytedance.ai.bridge.method.router;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.openApp.AbsOpenAppMethodIDL;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.mt.protector.impl.UriProtector;
import d3.a0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J&\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J:\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J0\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J.\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010!\u001a\u00020\u0006H\u0002J\u001a\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010&\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(H\u0002R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006*"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/OpenAppMethod;", "Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL;", "<init>", "()V", "altNames", "", "", "getAltNames", "()Ljava/util/List;", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppResultModel;", "openAppInner", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "Landroid/app/Activity;", "isAppInstalled", "", "context", "Landroid/content/Context;", "packageName", "openAppOrFallback", "uriString", "targetPackage", "fallbackUrl", "openMarketOrFallback", "openBrowser", com.bytedance.android.ec.core.event.a.KEY_URL, "failureMessage", "createResult", com.bytedance.android.ec.core.event.a.KEY_STATUS, "Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppStatus;", com.bytedance.android.ec.core.event.a.KEY_MSG, "startActivityIfResolvable", "intent", "Landroid/content/Intent;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenAppMethod extends AbsOpenAppMethodIDL {
    public final List<String> b;

    public static final class a {
    }

    static {
    }

    public OpenAppMethod() {
        this.b = CollectionsKt.listOf("doubao.openApp");
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final List<String> getAltNames() {
        return this.b;
    }

    public static void d(Activity r10, Intent r11) {
        ComponentName r0 = r11.resolveActivity(r10.getPackageManager());
        if (r0 == null) goto L7;
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_OpenAppMethod", "Resolved activity before launch, package=" + r0.getPackageName());
        r10.startActivity(r11);
        return;
    L7:
        throw new ActivityNotFoundException("No activity found to handle openApp intent");
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r12, ParamModel r13, f3.h r14) {
        AbsOpenAppMethodIDL.a r15 = (AbsOpenAppMethodIDL.a) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        a0 r0 = r12.getContainerContext();
        if (r0 == null) goto L5;
        String r1 = r0.getAppId();
    L6:
        a0 r16 = r12.getContainerContext();
        if (r16 == null) goto L9;
        String r17 = r16.getAppletId();
    L10:
        com.bytedance.ai.utils.g r10 = com.bytedance.ai.utils.g.a;
        StringBuilder r11 = new StringBuilder("call start, app=");
        r11.append(r1);
        r11.append(", appletId=");
        r11.append(r17);
        r11.append(", hasTargetPackage=");
        String r18 = r15.getTargetPackage();
        boolean r19 = false;
        if (r18 != null) goto L13;
    L16:
        boolean r20 = true;
    L17:
        r11.append(!r20);
        r10.i("AISDK_JSB_OpenAppMethod", r11.toString());
        if (r17 != null) goto L20;
    L23:
        boolean r110 = true;
    L25:
        if (r110 == false) goto L27;
        StringBuilder r111 = new StringBuilder("call failed, errNo=");
        f3.a r112 = f3.a.f;
        r111.append(r112.a);
        r111.append(", msg=appletId is null or empty");
        r10.e("AISDK_JSB_OpenAppMethod", r111.toString());
        f3.h.a.a(r14, "Error: appletId is null or empty", r112, null, 10);
        return;
    L27:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r113 = AppletRuntimeManager.d;
        if (r113 == null) goto L30;
        Activity r114 = r113.currentActivity();
    L31:
        if (r114 != null) goto L34;
        StringBuilder r115 = new StringBuilder("call failed, errNo=");
        f3.a r116 = f3.a.f;
        r115.append(r116.a);
        r115.append(", msg=Cannot find top activity");
        r10.e("AISDK_JSB_OpenAppMethod", r115.toString());
        f3.h.a.a(r14, "Cannot find top activity", r116, null, 10);
        return;
    L34:
        if (StringsKt.isBlank(r15.getUri()) == false) goto L36;
        StringBuilder r117 = new StringBuilder("call failed, errNo=");
        f3.a r118 = f3.a.h;
        r117.append(r118.a);
        r117.append(", msg=Uri is empty");
        r10.e("AISDK_JSB_OpenAppMethod", r117.toString());
        f3.h.a.a(r14, "Uri is empty", r118, null, 10);
        return;
    L36:
        String r21 = r15.getTargetPackage();
        if (r21 != null) goto L39;
    L42:
        boolean r22 = true;
    L43:
        if (r22 == false) goto L66;
        r10.w("AISDK_JSB_OpenAppMethod", "No target package provided, opening URI directly");
        b(r114, r15.getUri(), null, r15.getFallbackUrl(), r14);
        return;
    L66:
        r114.getPackageManager().getPackageInfo(r21, 0);     // Catch: PackageManager.NameNotFoundException -> L46
        boolean r23 = true;
    L48:
        if (r23 == true) goto L61;
        String r119 = r15.getFallbackUrl();
        Intent r24 = new Intent("android.intent.action.VIEW", UriProtector.parse("market://details?id=" + r21));     // Catch: ActivityNotFoundException -> L52
        r24.addFlags(268435456);     // Catch: ActivityNotFoundException -> L52
        r24.addCategory("android.intent.category.DEFAULT");     // Catch: ActivityNotFoundException -> L52
        d(r114, r24);     // Catch: ActivityNotFoundException -> L52
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_OpenAppMethod", "call success, status=MARKET");     // Catch: ActivityNotFoundException -> L52
        AbsOpenAppMethodIDL.OpenAppStatus r25 = AbsOpenAppMethodIDL.OpenAppStatus.MARKET;     // Catch: ActivityNotFoundException -> L52
        Intrinsics.checkNotNullParameter(AbsOpenAppMethodIDL.b.class, "<this>");     // Catch: ActivityNotFoundException -> L52
        AbsOpenAppMethodIDL.b r26 = (AbsOpenAppMethodIDL.b) k3.c.a(AbsOpenAppMethodIDL.b.class);     // Catch: ActivityNotFoundException -> L52
        r26.setStatus(r25);     // Catch: ActivityNotFoundException -> L52
        r26.setMessage("Market opened for: " + r21);     // Catch: ActivityNotFoundException -> L52
        r14.b(r26, "");     // Catch: ActivityNotFoundException -> L52
        return;
    L52:
        e = move-exception;
        com.bytedance.ai.utils.g r27 = com.bytedance.ai.utils.g.a;
        r27.w("AISDK_JSB_OpenAppMethod", "Market not found for " + r21 + ", trying browser fallback...", e);
        if (r119 != null) goto L56;
    L57:
        r19 = true;
    L58:
        if (r19 == true) goto L60;
        c(r114, r119, r14, "Market not found and failed to open fallback URL.");
        return;
    L60:
        StringBuilder r120 = new StringBuilder("call failed, errNo=");
        f3.a r121 = f3.a.g;
        r120.append(r121.a);
        r120.append(", msg=App not installed and market not found.");
        r27.e("AISDK_JSB_OpenAppMethod", r120.toString());
        f3.h.a.a(r14, "App not installed and market not found.", r121, null, 10);
        return;
    L56:
        if (StringsKt.isBlank(r119) == false) goto L58;
    L61:
        b(r114, r15.getUri(), r21, r15.getFallbackUrl(), r14);
        return;
    L46:
        e = move-exception;
        com.bytedance.ai.utils.g.a.w("AISDK_JSB_OpenAppMethod", "App not installed: " + r21 + ", error: " + e.getMessage());
        r23 = false;
        goto L48
    L39:
        if (StringsKt.isBlank(r21) == true) goto L42;
        r22 = false;
        goto L43
    L30:
        r114 = null;
        goto L31
    L20:
        if (r17.length() == 0) goto L23;
        r110 = false;
        goto L25
    L13:
        if (StringsKt.isBlank(r18) == true) goto L16;
        r20 = false;
        goto L17
    L9:
        r17 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static void c(Activity r10, String r11, f3.h r12, String r13) {
        Intent r1 = new Intent("android.intent.action.VIEW", UriProtector.parse(r11));     // Catch: Exception -> L5
        r1.addFlags(268435456);     // Catch: Exception -> L5
        r1.addCategory("android.intent.category.DEFAULT");     // Catch: Exception -> L5
        d(r10, r1);     // Catch: Exception -> L5
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_OpenAppMethod", "call success, status=BROWSER");     // Catch: Exception -> L5
        AbsOpenAppMethodIDL.OpenAppStatus r14 = AbsOpenAppMethodIDL.OpenAppStatus.BROWSER;     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(AbsOpenAppMethodIDL.b.class, "<this>");     // Catch: Exception -> L5
        AbsOpenAppMethodIDL.b r15 = (AbsOpenAppMethodIDL.b) k3.c.a(AbsOpenAppMethodIDL.b.class);     // Catch: Exception -> L5
        r15.setStatus(r14);     // Catch: Exception -> L5
        r15.setMessage("Fallback web url opened");     // Catch: Exception -> L5
        r12.b(r15, "");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.ai.utils.g r16 = com.bytedance.ai.utils.g.a;
        StringBuilder r17 = new StringBuilder("call failed, errNo=");
        f3.a r18 = f3.a.f;
        r17.append(r18.a);
        r17.append(", msg=");
        r17.append(r13);
        r16.e("AISDK_JSB_OpenAppMethod", r17.toString(), e);
        f3.h.a.a(r12, r13, r18, null, 10);
    }

    public static void b(Activity r11, String r12, String r13, String r14, f3.h r15) {
        boolean r10 = true;
        Intent r16 = new Intent("android.intent.action.VIEW", UriProtector.parse(r12));     // Catch: Exception -> L14 ActivityNotFoundException -> L16
        if (r13 != null) goto L6;
    L9:
        boolean r17 = true;
    L10:
        if (r17 == true) goto L12;
        r16.setPackage(r13);     // Catch: Exception -> L14 ActivityNotFoundException -> L16
    L12:
        r16.addFlags(268435456);     // Catch: Exception -> L14 ActivityNotFoundException -> L16
        r16.addCategory("android.intent.category.DEFAULT");     // Catch: Exception -> L14 ActivityNotFoundException -> L16
        d(r11, r16);     // Catch: Exception -> L14 ActivityNotFoundException -> L16
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_OpenAppMethod", "call success, status=DEEP_LINK");     // Catch: Exception -> L14 ActivityNotFoundException -> L16
        AbsOpenAppMethodIDL.OpenAppStatus r18 = AbsOpenAppMethodIDL.OpenAppStatus.DEEP_LINK;     // Catch: Exception -> L14 ActivityNotFoundException -> L16
        Intrinsics.checkNotNullParameter(AbsOpenAppMethodIDL.b.class, "<this>");     // Catch: Exception -> L14 ActivityNotFoundException -> L16
        AbsOpenAppMethodIDL.b r19 = (AbsOpenAppMethodIDL.b) k3.c.a(AbsOpenAppMethodIDL.b.class);     // Catch: Exception -> L14 ActivityNotFoundException -> L16
        r19.setStatus(r18);     // Catch: Exception -> L14 ActivityNotFoundException -> L16
        r19.setMessage("Deep link opened: " + r12);     // Catch: Exception -> L14 ActivityNotFoundException -> L16
        r15.b(r19, "");     // Catch: Exception -> L14 ActivityNotFoundException -> L16
    L34:
        return;
    L6:
        if (StringsKt.isBlank(r13) == true) goto L9;
        r17 = false;
    L16:
        e = move-exception;
        com.bytedance.ai.utils.g r20 = com.bytedance.ai.utils.g.a;
        r20.w("AISDK_JSB_OpenAppMethod", "No app found to open URI: " + r12 + ", trying fallback...", e);
        if (r13 == null) goto L21;
        String r110 = "App is installed but failed to open the deep link, error: " + e.getMessage();
        StringBuilder r111 = new StringBuilder("call failed, errNo=");
        f3.a r112 = f3.a.g;
        r111.append(r112.a);
        r111.append(", msg=");
        r111.append(r110);
        r20.e("AISDK_JSB_OpenAppMethod", r111.toString());
        f3.h.a.a(r15, r110, r112, null, 10);
        return;
    L21:
        if (r14 != null) goto L23;
    L26:
        if (r10 == true) goto L28;
        c(r11, r14, r15, "No app found to open URI and failed to open fallback URL.");
        return;
    L28:
        StringBuilder r113 = new StringBuilder("call failed, errNo=");
        f3.a r114 = f3.a.g;
        r113.append(r114.a);
        r113.append(", msg=No app found to open URI and no fallback URL provided.");
        r20.e("AISDK_JSB_OpenAppMethod", r113.toString());
        f3.h.a.a(r15, "No app found to open URI and no fallback URL provided.", r114, null, 10);
        return;
    L23:
        if (StringsKt.isBlank(r14) == true) goto L26;
        r10 = false;
    L14:
        e = move-exception;
        String r115 = "Failed to open URI: " + r12 + ", error: " + e.getMessage();
        com.bytedance.ai.utils.g r116 = com.bytedance.ai.utils.g.a;
        StringBuilder r117 = new StringBuilder("call failed, errNo=");
        f3.a r1 = f3.a.f;
        r117.append(r1.a);
        r117.append(", msg=");
        r117.append(r115);
        r116.e("AISDK_JSB_OpenAppMethod", r117.toString(), e);
        f3.h.a.a(r15, r115, r1, null, 10);
    }
}
