package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.utils.g;
import d3.a0;
import f2.k;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/GetScreenBrightnessMethod;", "Lcom/bytedance/ai/bridge/method/system/AbsGetScreenBrightnessMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/system/AbsGetScreenBrightnessMethodIDL$EmptyMessageModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/system/AbsGetScreenBrightnessMethodIDL$GetScreenBrightnessResultModel;", "getScreenBrightness", "", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "Landroid/app/Activity;", "context", "Landroid/content/Context;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetScreenBrightnessMethod extends AbsGetScreenBrightnessMethodIDL {

    public static final class a {
    }

    static {
    }

    public GetScreenBrightnessMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r15, ParamModel r16, h r17) {
        Intrinsics.checkNotNullParameter(r15, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetScreenBrightnessMethodIDL.a) r16, "params");
        Intrinsics.checkNotNullParameter(r17, "callback");
        g r0 = g.a;
        StringBuilder r10 = new StringBuilder("call start, appletId=");
        a0 r11 = r15.getContainerContext();
        if (r11 == null) goto L5;
        String r12 = r11.getAppletId();
    L6:
        r10.append(r12);
        r0.i("AISDK_JSB_GetScreenBrightnessMethod", r10.toString());
        Activity r13 = r15.getOwnerActivity();
        if (r13 != null) goto L9;
        r13 = k.b();
    L9:
        if (r13 == null) goto L11;
        Context r14 = r13;
    L16:
        if (r14 != null) goto L18;
        StringBuilder r18 = new StringBuilder("call failed, errNo=");
        f3.a r19 = f3.a.f;
        r18.append(r19.a);
        r18.append(", msg=context is null");
        r0.e("AISDK_JSB_GetScreenBrightnessMethod", r18.toString());
        h.a.a(r17, "context is null", r19, null, 10);
        return;
    L18:
        if (r13 != null) goto L41;
    L26:
        float r20 = -1.0f;
    L28:
        if (r20 >= 0.0f) goto L30;
    L33:
        double r21 = ((double) Settings.System.getInt(r14.getContentResolver(), "screen_brightness")) / 255.0d;     // Catch: Exception -> L24
    L34:
        double r22 = RangesKt.coerceIn(r21, 0.0d, 1.0d);     // Catch: Exception -> L24
        r0.i("AISDK_JSB_GetScreenBrightnessMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsGetScreenBrightnessMethodIDL.b.class, "<this>");
        BaseModel r1 = k3.c.a(AbsGetScreenBrightnessMethodIDL.b.class);
        ((AbsGetScreenBrightnessMethodIDL.b) r1).setValue(Double.valueOf(r22));
        r17.b((ResultModel) r1, "");
        return;
    L24:
        e = move-exception;
        String r23 = e.getMessage();
        if (r23 != null) goto L39;
        r23 = "unknown";
    L39:
        String r24 = "get screen brightness error: ".concat(r23);
        g r25 = g.a;
        StringBuilder r26 = new StringBuilder("call failed, errNo=");
        f3.a r27 = f3.a.f;
        r26.append(r27.a);
        r26.append(", msg=");
        r26.append(r24);
        r25.e("AISDK_JSB_GetScreenBrightnessMethod", r26.toString(), e);
        h.a.a(r17, r24, r27, null, 10);
        return;
    L30:
        if (r20 > 1.0f) goto L33;
        r21 = r20;
        goto L34
    L41:
        Window r28 = r13.getWindow();     // Catch: Exception -> L24
        if (r28 == null) goto L26;
        WindowManager.LayoutParams r29 = r28.getAttributes();     // Catch: Exception -> L24
        if (r29 == null) goto L26;
        r20 = r29.screenBrightness;     // Catch: Exception -> L24
        goto L28
    L11:
        View r30 = r15.getEngineView();
        if (r30 == null) goto L14;
        r14 = r30.getContext();
        goto L16
    L14:
        r14 = null;
        goto L16
    L5:
        r12 = null;
        goto L6
    }
}
