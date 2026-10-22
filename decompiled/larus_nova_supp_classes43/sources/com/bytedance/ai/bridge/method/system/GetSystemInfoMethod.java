package com.bytedance.ai.bridge.method.system;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.ai.bridge.system.systemInfo.AbsGetSystemInfoMethodIDL;
import com.bytedance.ai.utils.g;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import f2.k;
import f3.h;
import f4.e;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010\u001fJ\u0017\u0010 \u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010!J\u0015\u0010\"\u001a\u0004\u0018\u00010\u0018*\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010\u001fJ\f\u0010#\u001a\u00020\u0018*\u00020\u0018H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006%"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/GetSystemInfoMethod;", "Lcom/bytedance/ai/bridge/system/systemInfo/AbsGetSystemInfoMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/system/systemInfo/AbsGetSystemInfoMethodIDL$GetSystemInfoResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/systemInfo/AbsGetSystemInfoMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "systemLanguage", "", "appAbi", "systemString", "benchmarkLevel", "", "deviceOrientation", "context", "Landroid/content/Context;", "parseOverallScore", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "(Ljava/lang/Object;)Ljava/lang/Double;", "parseOverallScoreString", "(Ljava/lang/String;)Ljava/lang/Double;", "asDoubleOrNull", "normalizedBenchmarkLevel", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetSystemInfoMethod extends AbsGetSystemInfoMethodIDL {
    public static final /* synthetic */ int c = 0;
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public static String b() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        String r0 = Build.CPU_ABI;
        if (r0 != null) goto L27;
        return null;
    L27:
        if ((!StringsKt.isBlank(r0)) == true) goto L29;
        return null;
    L29:
        return r0;
    L5:
        if (Process.is64Bit() == false) goto L7;
        String[] r1 = Build.SUPPORTED_64_BIT_ABIS;
    L8:
        Intrinsics.checkNotNull(r1);
        int r10 = r1.length;
        int r11 = 0;
        int r12 = 0;
    L9:
        if (r12 >= r10) goto L14;
        String r13 = r1[r12];
        Intrinsics.checkNotNull(r13);
        if ((!StringsKt.isBlank(r13)) == true) goto L15;
        r12 = r12 + 1;
    L15:
        if (r13 == null) goto L17;
        return r13;
    L17:
        String[] r14 = Build.SUPPORTED_ABIS;
        int r15 = r14.length;
    L18:
        if (r11 >= r15) goto L34;
        String r16 = r14[r11];
        Intrinsics.checkNotNull(r16);
        if ((!StringsKt.isBlank(r16)) == true) goto L23;
        r11 = r11 + 1;
        goto L18
    L23:
        return r16;
    L34:
        return null;
    L14:
        r13 = null;
        goto L15
    L7:
        r1 = Build.SUPPORTED_32_BIT_ABIS;
        goto L8
    }

    public static double d() {
        int r0 = com.bytedance.ai.utils.b.a;
        Object r1 = ((LinkedHashMap) com.bytedance.ai.utils.b.a(CollectionsKt.listOf("flow_device_model_score"))).get("flow_device_model_score");
        if ((r1 instanceof Map) == false) goto L6;
        Double r10 = c(((Map) r1).get("overall_score"));
    L26:
        if (r10 == null) goto L37;
        double r11 = r10.doubleValue();
        if (r11 != (-1.0d)) goto L30;
        boolean r12 = true;
    L31:
        if (r12 == false) goto L34;
        return -1.0d;
    L34:
        return r11 * 3.0d;
    L30:
        r12 = false;
        goto L31
    L37:
        return -1.0d;
    L6:
        if ((r1 instanceof JSONObject) == false) goto L9;
        r10 = c(((JSONObject) r1).opt("overall_score"));
        goto L26
    L9:
        if ((r1 instanceof JsonObject) == false) goto L12;
        r10 = c(((JsonObject) r1).get("overall_score"));
        goto L26
    L12:
        if ((r1 instanceof String) == false) goto L24;
        String r13 = (String) r1;
        Double r14 = StringsKt.toDoubleOrNull(r13);
        if (r14 == null) goto L35;
        r10 = r14;
        goto L26
    L35:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L17
        Object r16 = Result.constructor-impl(c(new JSONObject(r13).opt("overall_score")));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r16) == false) goto L22;
        r16 = null;
    L22:
        r10 = (Double) r16;
    L17:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L24:
        r10 = c(r1);
        goto L26
    }

    public static String g() {
        String r0 = Build.VERSION.RELEASE;
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (r0.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return "Android";
    L12:
        return "Android ".concat(r0);
    L8:
        r1 = false;
        goto L9
    }

    public GetSystemInfoMethod() {
        this.b = true;
    }

    public static String f() {
        Locale r0 = Locale.getDefault();
        String r1 = r0.getLanguage();
        String r10 = r0.getCountry();
        Intrinsics.checkNotNull(r10);
        if (r10.length() <= 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L10;
        Intrinsics.checkNotNull(r1);
        return r1;
    L10:
        return r1 + '_' + r10;
    L5:
        r11 = false;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static Double c(Object r10) {
        if ((r10 instanceof Number) == false) goto L6;
        return Double.valueOf(((Number) r10).doubleValue());
    L6:
        if ((r10 instanceof String) == true) goto L24;
        Object r1 = null;
        if ((r10 instanceof JsonPrimitive) == false) goto L20;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Object r11 = Result.constructor-impl(Double.valueOf(((JsonPrimitive) r10).getAsDouble()));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r11) == true) goto L25;
        r1 = r11;
    L25:
        return (Double) r1;
    L12:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L20:
        return null;
    L24:
        return StringsKt.toDoubleOrNull((String) r10);
    }

    public static String e(Context r10) {
        int r0 = r10.getResources().getConfiguration().orientation;
        if (r0 != 1) goto L5;
    L9:
        return "portrait";
    L5:
        if (r0 == 2) goto L8;
        Resources r11 = r10.getResources();
        DisplayMetrics r12 = WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics());
        if (r12.widthPixels <= r12.heightPixels) goto L9;
    L8:
        return "landscape";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final com.bytedance.ai.bridge.core.a handleSync(e3.d r13, ParamModel r14) {
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetSystemInfoMethodIDL.a) r14, "params");
        g r15 = g.a;
        r15.i("AISDK_JSB_GetSystemInfo", "handleSync called");
        IHostContextDepend r0 = r4.a.a;
        int r10 = c.a;
        View r11 = r13.getEngineView();
        String r12 = null;
        if (r11 == null) goto L5;
        Context r16 = r11.getContext();
    L6:
        c.C0037c r17 = c.d(r16);
        if (r17 != null) goto L9;
        StringBuilder r18 = new StringBuilder("handleSync failed, errNo=");
        f3.a r19 = f3.a.f;
        r18.append(r19.a);
        r18.append(", msg=context not provided in host");
        r15.e("AISDK_JSB_GetSystemInfo", r18.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "context not provided in host", null, r19, 21);
    L9:
        View r110 = r13.getEngineView();
        if (r110 == null) goto L12;
        Context r111 = r110.getContext();
    L13:
        Intrinsics.checkNotNullParameter(AbsGetSystemInfoMethodIDL.b.class, "<this>");
        AbsGetSystemInfoMethodIDL.b r20 = (AbsGetSystemInfoMethodIDL.b) k3.c.a(AbsGetSystemInfoMethodIDL.b.class);
        String r21 = Build.BRAND;
        String r22 = "";
        if (r21 != null) goto L16;
        r21 = "";
    L16:
        r20.setBrand(r21);
        String r23 = Build.MODEL;
        if (r23 == null) goto L20;
        r22 = r23;
    L20:
        r20.setModel(r22);
        r20.setPixelRatio(r17.a);
        r20.setScreenWidth(r17.b);
        r20.setScreenHeight(r17.c);
        r20.setWindowWidth(r17.d);
        r20.setWindowHeight(r17.e);
        r20.setStatusBarHeight(r17.f);
        r20.setLanguage(f());
        if (r0 == null) goto L23;
        String r1 = r0.getVersionName();
    L24:
        r20.setVersion(r1);
        r20.setSystem(g());
        r20.setPlatform("android");
        r20.setSDKVersion("0.3.0");
        r20.setTheme(t2.a.a(r111));
        r20.setBenchmarkLevel(Double.valueOf(d()));
        c.b r24 = r17.g;
        r20.setSafeArea(new AbsGetSystemInfoMethodIDL.SystemInfoSafeArea(r24.a, r24.b, r24.c, r24.d, r24.e, r24.f));
        r20.setEnableDebug(Boolean.valueOf(k.b));
        if (r111 == null) goto L27;
        r12 = e(r111);
    L27:
        r20.setDeviceOrientation(r12);
        r20.setAbi(b());
        r15.i("AISDK_JSB_GetSystemInfo", "handleSync success");
        return new com.bytedance.ai.bridge.core.a.c(r20);
    L23:
        r1 = null;
        goto L24
    L12:
        r111 = null;
        goto L13
    L5:
        r16 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(final e3.d r10, ParamModel r11, final h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetSystemInfoMethodIDL.a) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g.a.i("AISDK_JSB_GetSystemInfo", "handle called");
        int r13 = c.a;
        View r14 = r10.getEngineView();
        if (r14 == null) goto L5;
        Context r15 = r14.getContext();
    L6:
        c.c(r15, new e(r12, r10, this));
        return;
    L5:
        r15 = null;
        goto L6
    }
}
