package com.bytedance.ai.bridge.method.router;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.method.login.LoginMethod;
import com.bytedance.ai.bridge.openApp.AbsOpenAppMethodIDL;
import com.bytedance.ai.model.p;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014JA\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001d\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010#\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b#\u0010$J-\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/OpenAppMethod;", "Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL;", "<init>", "()V", "Landroid/app/Activity;", "activity", "Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppRequestModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppResultModel;", "callback", "", "openAppInner", "(Landroid/app/Activity;Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppRequestModel;Lo1/f;)V", "Landroid/content/Context;", "context", "", "packageName", "", "isAppInstalled", "(Landroid/content/Context;Ljava/lang/String;)Z", "uriString", "targetPackage", "fallbackUrl", "openAppOrFallback", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lo1/f;)V", "openMarketOrFallback", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lo1/f;)V", "url", "failureMessage", "openBrowser", "(Landroid/app/Activity;Ljava/lang/String;Lo1/f;Ljava/lang/String;)V", "Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppStatus;", NotificationCompat.CATEGORY_STATUS, "message", "createResult", "(Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppStatus;Ljava/lang/String;)Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppResultModel;", "Ln1/c;", "bridgeContext", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppRequestModel;Lo1/f;)V", "Companion", "com/bytedance/ai/bridge/method/router/g", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOpenAppMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OpenAppMethod.kt\ncom/bytedance/ai/bridge/method/router/OpenAppMethod\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,197:1\n29#2:198\n29#2:199\n29#2:200\n*S KotlinDebug\n*F\n+ 1 OpenAppMethod.kt\ncom/bytedance/ai/bridge/method/router/OpenAppMethod\n*L\n94#1:198\n138#1:199\n173#1:200\n*E\n"})
public final class OpenAppMethod extends AbsOpenAppMethodIDL {
    public static final g Companion = null;
    public static final String TAG = "OpenAppMethod";

    static {
        Companion = new g();
    }

    public OpenAppMethod() {
    }

    public static /* synthetic */ void b(OpenAppMethod r5, Activity r10, AbsOpenAppMethodIDL.OpenAppRequestModel r11, o1.f r12) {
        handle$lambda$0(r5, r10, r11, r12);
    }

    private final AbsOpenAppMethodIDL.OpenAppResultModel createResult(AbsOpenAppMethodIDL.OpenAppStatus r5, String r10) {
        Intrinsics.checkNotNullParameter(AbsOpenAppMethodIDL.OpenAppResultModel.class, "<this>");
        AbsOpenAppMethodIDL.OpenAppResultModel r11 = (AbsOpenAppMethodIDL.OpenAppResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsOpenAppMethodIDL.OpenAppResultModel.class);
        r11.setStatus(r5);
        r11.setMessage(r10);
        return r11;
    }

    private static final void handle$lambda$0(OpenAppMethod r5, Activity r10, AbsOpenAppMethodIDL.OpenAppRequestModel r11, o1.f r12) {
        r5.openAppInner(r10, r11, r12);
    }

    private final boolean isAppInstalled(Context r5, String r10) {
        r5.getPackageManager().getPackageInfo(r10, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        return true;
    L6:
        e = move-exception;
        StringBuilder r11 = com.lynx.tasm.utils.e.b("App not installed: ", r10, ", error: ");
        r11.append(e.getMessage());
        String r12 = r11.toString();
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L10;
        r13.w(TAG, r12);
    L10:
        return false;
    }

    private final void openAppInner(Activity r10, AbsOpenAppMethodIDL.OpenAppRequestModel r11, o1.f r12) {
        String r5 = r11.getTargetPackage();
        if (r5 != null) goto L5;
    L13:
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L16;
        r13.w(TAG, "No target package provided, opening URI directly");
    L16:
        openAppOrFallback(r10, r11.getUri(), null, r11.getFallbackUrl(), r12);
        return;
    L5:
        if (StringsKt.isBlank(r5) == true) goto L13;
        if (isAppInstalled(r10, r5) == true) goto L11;
        openMarketOrFallback(r10, r5, r11.getFallbackUrl(), r12);
        return;
    L11:
        openAppOrFallback(r10, r11.getUri(), r5, r11.getFallbackUrl(), r12);
    }

    private final void openAppOrFallback(Activity r10, String r11, String r12, String r13, o1.f r14) {
        Intent r5 = new Intent("android.intent.action.VIEW", Uri.parse(r11));     // Catch: Exception -> L9 ActivityNotFoundException -> L11
        if (r12 != null) goto L6;
    L13:
        r5.addFlags(268435456);     // Catch: Exception -> L9 ActivityNotFoundException -> L11
        r5.addCategory("android.intent.category.DEFAULT");     // Catch: Exception -> L9 ActivityNotFoundException -> L11
        r10.startActivity(r5);     // Catch: Exception -> L9 ActivityNotFoundException -> L11
        r14.b(createResult(AbsOpenAppMethodIDL.OpenAppStatus.DEEP_LINK, "Deep link opened: " + r11), "");     // Catch: Exception -> L9 ActivityNotFoundException -> L11
        return;
    L6:
        if (StringsKt.isBlank(r12) == true) goto L13;
        r5.setPackage(r12);     // Catch: Exception -> L9 ActivityNotFoundException -> L11
    L11:
        e = move-exception;
        String r15 = androidx.room.jarjarred.org.antlr.runtime.a.r("No app found to open URI: ", r11, ", trying fallback...", TAG, "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L22;
        r16.w(TAG, r15, e);
    L22:
        if (r12 == null) goto L25;
        r14.a("App is installed but failed to open the deep link, error: " + e.getMessage());
        return;
    L25:
        if (r13 != null) goto L27;
    L30:
        r14.a("No app found to open URI and no fallback URL provided.");
        return;
    L27:
        if (StringsKt.isBlank(r13) == true) goto L30;
        openBrowser(r10, r13, r14, "No app found to open URI and failed to open fallback URL.");
        return;
    L9:
        e = move-exception;
        String r17 = com.lynx.tasm.behavior.utils.d.c("Failed to open URI: ", r11, TAG);
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L18;
        r18.e(TAG, r17, e);
    L18:
        StringBuilder r19 = com.lynx.tasm.utils.e.b("Failed to open URI: ", r11, ", error: ");
        r19.append(e.getMessage());
        r14.a(r19.toString());
    }

    private final void openBrowser(Activity r5, String r10, o1.f r11, String r12) {
        Intent r13 = new Intent("android.intent.action.VIEW", Uri.parse(r10));     // Catch: Exception -> L4
        r13.addFlags(268435456);     // Catch: Exception -> L4
        r13.addCategory("android.intent.category.DEFAULT");     // Catch: Exception -> L4
        r5.startActivity(r13);     // Catch: Exception -> L4
        r11.b(createResult(AbsOpenAppMethodIDL.OpenAppStatus.BROWSER, "Fallback web url opened"), "");     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        String r14 = com.lynx.tasm.behavior.utils.d.c("Browser fallback failed for url: ", r10, TAG);
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L8;
        r15.e(TAG, r14, e);
    L8:
        r11.a(r12);
    }

    private final void openMarketOrFallback(Activity r10, String r11, String r12, o1.f r13) {
        Intent r5 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + r11));     // Catch: ActivityNotFoundException -> L5
        r5.addFlags(268435456);     // Catch: ActivityNotFoundException -> L5
        r5.addCategory("android.intent.category.DEFAULT");     // Catch: ActivityNotFoundException -> L5
        r10.startActivity(r5);     // Catch: ActivityNotFoundException -> L5
        r13.b(createResult(AbsOpenAppMethodIDL.OpenAppStatus.MARKET, "Market opened for: " + r11), "");     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        String r14 = androidx.room.jarjarred.org.antlr.runtime.a.r("Market not found for ", r11, ", trying browser fallback...", TAG, "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L9;
        r15.w(TAG, r14, e);
    L9:
        if (r12 != null) goto L11;
    L14:
        r13.a("App not installed and market not found.");
        return;
    L11:
        if (StringsKt.isBlank(r12) == true) goto L14;
        openBrowser(r10, r12, r13, "Market not found and failed to open fallback URL.");
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsOpenAppMethodIDL.OpenAppRequestModel) r10, r11);
    }

    public void handle(n1.c r10, AbsOpenAppMethodIDL.OpenAppRequestModel r11, o1.f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        n1.a r13 = (n1.a) r10;
        m1.j r5 = (m1.j) r13.b(m1.j.class);
        Activity r14 = null;
        if (r5 == null) goto L5;
        String r15 = r5.a();
    L6:
        m1.j r16 = (m1.j) r13.b(m1.j.class);
        if (r16 == null) goto L9;
        String r17 = r16.b();
    L11:
        if (r17 != null) goto L13;
    L30:
        Intrinsics.checkNotNullParameter(LoginMethod.TAG, "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L33;
        r18.e(LoginMethod.TAG, "appletId is null or empty");
    L33:
        r12.a("Error: appletId is null or empty");
        return;
    L13:
        if (r17.length() == 0) goto L30;
        String r19 = com.lynx.tasm.utils.b.j("handle app: ", r15, ", applet: ", r17);
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L18;
        r20.i(TAG, r19);
    L18:
        t0.b r110 = p.f2294c;
        if (r110 == null) goto L21;
        r14 = r110.currentActivity();
    L21:
        if (r14 != null) goto L25;
        r12.a("Cannot find top activity");
        return;
    L25:
        if (StringsKt.isBlank(r11.getUri()) == false) goto L28;
        r12.a("Uri is empty");
        return;
    L28:
        r14.runOnUiThread(new f(0, this, r14, r11, r12));
        return;
    L9:
        r17 = null;
        goto L11
    L5:
        r15 = null;
        goto L6
    }
}
