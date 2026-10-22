package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.vibrate.AbsVibrateLongMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import f2.k;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/VibrateLongMethod;", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateLongMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateLongMethodIDL$VibrateLongParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateLongMethodIDL$EmptyMessageModel;", "triggerLongVibration", "vibrator", "Landroid/os/Vibrator;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VibrateLongMethod extends AbsVibrateLongMethodIDL {

    public static final class a {
    }

    static {
    }

    public VibrateLongMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsVibrateLongMethodIDL.b) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r13 = g.a;
        StringBuilder r0 = new StringBuilder("call start, appletId=");
        a0 r1 = r10.getContainerContext();
        if (r1 == null) goto L5;
        String r14 = r1.getAppletId();
    L6:
        r0.append(r14);
        r13.i("AISDK_JSB_VibrateLongMethod", r0.toString());
        Activity r15 = r10.getOwnerActivity();
        if (r15 != null) goto L10;
        r15 = k.b();
    L10:
        if (r15 != null) goto L12;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.f;
        r16.append(r17.a);
        r16.append(", msg=context is null");
        r13.e("AISDK_JSB_VibrateLongMethod", r16.toString());
        h.a.a(r12, "context is null", r17, null, 10);
        return;
    L12:
        Object r18 = r15.getSystemService("vibrator");
        if ((r18 instanceof Vibrator) == false) goto L15;
        Vibrator r19 = (Vibrator) r18;
    L16:
        if (r19 != null) goto L18;
    L31:
        StringBuilder r20 = new StringBuilder("call failed, errNo=");
        f3.a r21 = f3.a.g;
        r20.append(r21.a);
        r20.append(", msg=vibrate is not supported");
        r13.e("AISDK_JSB_VibrateLongMethod", r20.toString());
        h.a.a(r12, "vibrate is not supported", r21, null, 10);
        return;
    L18:
        if (r19.hasVibrator() == false) goto L31;
    L26:
        th = move-exception;
        String r110 = th.getMessage();
        if (r110 != null) goto L30;
        r110 = "unknown";
    L30:
        String r111 = "vibrateLong failed: ".concat(r110);
        g r22 = g.a;
        StringBuilder r23 = new StringBuilder("call failed, errNo=");
        f3.a r24 = f3.a.f;
        r23.append(r24.a);
        r23.append(", msg=");
        r23.append(r111);
        r22.e("AISDK_JSB_VibrateLongMethod", r23.toString(), th);
        h.a.a(r12, r111, r24, null, 10);
        return;
    L21:
        if (Build.VERSION.SDK_INT < 26) goto L23;
        r19.vibrate(VibrationEffect.createOneShot(400, -1));     // Catch: Throwable -> L26
    L24:
        r13.i("AISDK_JSB_VibrateLongMethod", "call success");     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(AbsVibrateLongMethodIDL.a.class, "<this>");     // Catch: Throwable -> L26
        r12.b((ResultModel) k3.c.a(AbsVibrateLongMethodIDL.a.class), "");     // Catch: Throwable -> L26
        return;
    L23:
        r19.vibrate(400);     // Catch: Throwable -> L26
        goto L24
    L15:
        r19 = null;
        goto L16
    L5:
        r14 = null;
        goto L6
    }
}
