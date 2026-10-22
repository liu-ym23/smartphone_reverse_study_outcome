package com.bytedance.ai.bridge.method.widget;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.base.gson.e;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.widget.AbsCallMcpToolMethodIDL;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.contianer.m;
import com.google.gson.reflect.TypeToken;
import d3.a0;
import e3.d;
import f3.h;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import p4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/widget/CallMcpToolMethod;", "Lcom/bytedance/ai/bridge/widget/AbsCallMcpToolMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/widget/AbsCallMcpToolMethodIDL$CallMcpToolRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/widget/AbsCallMcpToolMethodIDL$CallMcpToolResultModel;", "getAppVersionTag", "", "packageName", "executeRequest", "request", "Lcom/bytedance/ai/bridge/remote/model/CallMcpToolRequest;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CallMcpToolMethod extends AbsCallMcpToolMethodIDL {
    public static final Type b = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/ai/bridge/method/widget/CallMcpToolMethod$Companion$TOOL_RESULT_TYPE$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<Map<String, ? extends Object>> {
        public a() {
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContainerType.values().length];
            r0[ContainerType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ContainerType.PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        b = new a().getType();
    }

    public CallMcpToolMethod() {
    }

    public static String b(String r12) {
        Object r1 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L63
        String r11 = IAISDKDebugService.a.b();     // Catch: Throwable -> L63
        boolean r13 = true;
        if (r11 != null) goto L6;
    L9:
        boolean r14 = true;
    L10:
        if (r14 == false) goto L12;
        g.a.i("AISDK_JSB_CallMcpToolMethod", "getAppVersionTag: preview debug config is empty");     // Catch: Throwable -> L63
    L60:
        String r15 = null;
    L61:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L63
    L65:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L69;
        g.a.e("AISDK_JSB_CallMcpToolMethod", "getAppVersionTag failed, packageName=" + r12 + ", message=" + r17.getMessage(), r17);
    L69:
        if (Result.isFailure-impl(r16) == true) goto L73;
        r1 = r16;
    L73:
        return (String) r1;
    L12:
        JSONObject r18 = new JSONObject(r11);     // Catch: Throwable -> L63
        JSONArray r19 = r18.optJSONArray("changes");     // Catch: Throwable -> L63
        if (r19 == null) goto L16;
        int r20 = r19.length();     // Catch: Throwable -> L63
    L17:
        int r21 = 0;
    L19:
        if (r21 >= r20) goto L38;
        if (r19 == null) goto L37;
        JSONObject r110 = r19.optJSONObject(r21);     // Catch: Throwable -> L63
        if (r110 == null) goto L37;
        if (Intrinsics.areEqual(r110.optString("app_key"), r12) == false) goto L37;
        if (r110.optBoolean("enabled") == false) goto L37;
        r15 = r110.optString("version_tag");     // Catch: Throwable -> L63
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L63
        if (r15.length() <= 0) goto L31;
        boolean r111 = true;
    L32:
        if (r111 == true) goto L35;
        r15 = null;
    L35:
        if (r15 == null) goto L37;
        g.a.i("AISDK_JSB_CallMcpToolMethod", "getAppVersionTag: source=changes, packageName=" + r12 + ", versionTag=" + r15);     // Catch: Throwable -> L63
        goto L61
    L31:
        r111 = false;
    L37:
        r21 = r21 + 1;     // Catch: Throwable -> L63
        goto L19
    L38:
        JSONArray r22 = r18.optJSONArray("scan_app");     // Catch: Throwable -> L63
        if (r22 == null) goto L41;
        int r23 = r22.length();     // Catch: Throwable -> L63
    L42:
        int r24 = 0;
    L43:
        if (r24 >= r23) goto L59;
        if (r22 == null) goto L58;
        JSONObject r25 = r22.optJSONObject(r24);     // Catch: Throwable -> L63
        if (r25 == null) goto L58;
        if (Intrinsics.areEqual(r25.optString("app_key"), r12) == false) goto L58;
        String r26 = r25.optString("version_tag");     // Catch: Throwable -> L63
        Intrinsics.checkNotNull(r26);     // Catch: Throwable -> L63
        if (r26.length() > 0) goto L54;
        r13 = false;
    L54:
        if (r13 == false) goto L56;
        r15 = r26;
    L57:
        g.a.i("AISDK_JSB_CallMcpToolMethod", "getAppVersionTag: source=scan_app, packageName=" + r12 + ", versionTag=" + r15);     // Catch: Throwable -> L63
        goto L61
    L56:
        r15 = null;
    L58:
        r24 = r24 + 1;     // Catch: Throwable -> L63
        goto L43
    L59:
        g.a.i("AISDK_JSB_CallMcpToolMethod", "getAppVersionTag: no matched version tag, packageName=" + r12);     // Catch: Throwable -> L63
        goto L60
    L41:
        r23 = 0;
        goto L42
    L16:
        r20 = 0;
        goto L17
    L6:
        if (r11.length() == 0) goto L9;
        r14 = false;
    L63:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L65
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r24, ParamModel r25, h r26) {
        AbsCallMcpToolMethodIDL.a r10 = (AbsCallMcpToolMethodIDL.a) r25;
        Intrinsics.checkNotNullParameter(r24, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r26, "callback");
        a0 r0 = r24.getContainerContext();
        if (r0 == null) goto L5;
        ContainerType r11 = r0.getContainerType();
    L6:
        g r1 = g.a;
        StringBuilder r12 = new StringBuilder("call start, toolName=");
        r12.append(r10.getToolName());
        r12.append(", toolArgsCount=");
        r12.append(r10.getToolArgs().size());
        r12.append(", containerType=");
        if (r11 == null) goto L9;
        String r13 = r11.getTypeName();
    L10:
        r12.append(r13);
        r1.i("AISDK_JSB_CallMcpToolMethod", r12.toString());
        boolean r14 = false;
        if (r10.getToolName().length() != 0) goto L13;
        boolean r15 = true;
    L15:
        if (r15 == false) goto L99;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.h;
        r16.append(r17.a);
        r16.append(", msg=toolName is empty");
        r1.e("AISDK_JSB_CallMcpToolMethod", r16.toString());
        h.a.a(r26, "toolName is empty", r17, null, 10);
        return;
    L99:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L19
        Lazy r19 = e.a;     // Catch: Throwable -> L19
        Object r20 = Result.constructor-impl(e.c(r10.getToolArgs()));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r20) == false) goto L24;
        r20 = null;
    L24:
        String r110 = (String) r20;
        if (r110 != null) goto L27;
    L30:
        boolean r21 = true;
    L31:
        if (r21 == false) goto L33;
        g r22 = g.a;
        StringBuilder r23 = new StringBuilder("call failed, errNo=");
        f3.a r27 = f3.a.h;
        r23.append(r27.a);
        r23.append(", msg=toolArgs is invalid");
        r22.e("AISDK_JSB_CallMcpToolMethod", r23.toString());
        h.a.a(r26, "toolArgs is invalid", r27, null, 10);
        return;
    L33:
        if (r11 != null) goto L35;
        int r28 = -1;
    L37:
        if (r28 != 1) goto L39;
        WidgetContainer r29 = (WidgetContainer) r24.d(WidgetContainer.class);
        if (r29 == null) goto L69;
        m r30 = r29.g;
    L70:
        if (r29 == null) goto L72;
        Widget r31 = r29.x();
    L73:
        if (r30 == null) goto L75;
        String r111 = r30.a();
    L76:
        if (r30 == null) goto L97;
        if (r31 == null) goto L97;
        if (r30.a.length() != 0) goto L81;
        boolean r112 = true;
    L82:
        if (r112 == true) goto L97;
        if (r30.b.length() != 0) goto L86;
        boolean r113 = true;
    L87:
        if (r113 == true) goto L97;
        if (r111 != null) goto L90;
    L91:
        r14 = true;
    L92:
        if (r14 == true) goto L97;
        if (r31.c <= 0) goto L97;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CallMcpToolMethod$executeRequest$1(new f(r10.getToolName(), r110, r111, r31.c, r30.a, r30.b, 1, r10.getSkipWidgetUpdate(), b(r30.a)), r26, null), 3, null);
        return;
    L90:
        if (r111.length() != 0) goto L92;
    L86:
        r113 = false;
        goto L87
    L81:
        r112 = false;
    L97:
        g r32 = g.a;
        StringBuilder r33 = new StringBuilder("call failed, errNo=");
        f3.a r34 = f3.a.f;
        r33.append(r34.a);
        r33.append(", msg=Widget context is invalid");
        r32.e("AISDK_JSB_CallMcpToolMethod", r33.toString());
        h.a.a(r26, "Widget context is invalid", r34, null, 10);
        return;
    L75:
        r111 = null;
        goto L76
    L72:
        r31 = null;
        goto L73
    L69:
        r30 = null;
        goto L70
    L39:
        if (r28 == 2) goto L41;
        g r35 = g.a;
        StringBuilder r36 = new StringBuilder("call failed, errNo=");
        f3.a r37 = f3.a.g;
        r36.append(r37.a);
        r36.append(", msg=callMcpTool is only available in Widget or Page container");
        r35.e("AISDK_JSB_CallMcpToolMethod", r36.toString());
        h.a.a(r26, "callMcpTool is only available in Widget or Page container", r37, null, 10);
        return;
    L41:
        a0 r38 = r24.getContainerContext();
        if (r38 == null) goto L44;
        String r39 = r38.getAppletId();
    L45:
        if (r39 == null) goto L52;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r40 = AppletAppManagerService.a(r39);
        if (r40 == null) goto L49;
        Applet r41 = r40.j();
    L50:
        if (r41 == null) goto L52;
    L56:
        if (r41 != null) goto L58;
    L65:
        g r42 = g.a;
        StringBuilder r43 = new StringBuilder("call failed, errNo=");
        f3.a r44 = f3.a.f;
        r43.append(r44.a);
        r43.append(", msg=Page context is invalid");
        r42.e("AISDK_JSB_CallMcpToolMethod", r43.toString());
        h.a.a(r26, "Page context is invalid", r44, null, 10);
        return;
    L58:
        if (r41.b.length() != 0) goto L60;
        r14 = true;
    L60:
        if (r14 == true) goto L65;
        if (r41.c <= 0) goto L65;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CallMcpToolMethod$executeRequest$1(new f(r10.getToolName(), r110, null, r41.c, r41.b, null, 2, r10.getSkipWidgetUpdate(), b(r41.b)), r26, null), 3, null);
        return;
    L49:
        r41 = null;
    L52:
        AppletRuntime r45 = (AppletRuntime) r24.d(AppletRuntime.class);
        if (r45 == null) goto L55;
        r41 = r45.h;
        goto L56
    L55:
        r41 = null;
        goto L56
    L44:
        r39 = null;
        goto L45
    L35:
        r28 = c.a[r11.ordinal()];
        goto L37
    L27:
        if (r110.length() == 0) goto L30;
        r21 = false;
    L19:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L13:
        r15 = false;
        goto L15
    L9:
        r13 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }
}
