package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.vibrate.AbsVibrateShortMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import f2.k;
import f3.h;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/VibrateShortMethod;", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$VibrateShortParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$EmptyMessageModel;", "triggerShortVibration", "vibrator", "Landroid/os/Vibrator;", "type", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$VibrateType;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VibrateShortMethod extends AbsVibrateShortMethodIDL {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AbsVibrateShortMethodIDL.VibrateType.values().length];
            r0[AbsVibrateShortMethodIDL.VibrateType.HEAVY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AbsVibrateShortMethodIDL.VibrateType.MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AbsVibrateShortMethodIDL.VibrateType.LIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public VibrateShortMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, h r12) {
        AbsVibrateShortMethodIDL.b r13 = (AbsVibrateShortMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call start, type=");
        r1.append(r13.getType());
        r1.append(", appletId=");
        a0 r14 = r10.getContainerContext();
        if (r14 == null) goto L5;
        String r15 = r14.getAppletId();
    L6:
        r1.append(r15);
        r0.i("AISDK_JSB_VibrateShortMethod", r1.toString());
        Activity r16 = r10.getOwnerActivity();
        if (r16 != null) goto L10;
        r16 = k.b();
    L10:
        if (r16 != null) goto L12;
        StringBuilder r17 = new StringBuilder("call failed, errNo=");
        f3.a r18 = f3.a.f;
        r17.append(r18.a);
        r17.append(", msg=context is null");
        r0.e("AISDK_JSB_VibrateShortMethod", r17.toString());
        h.a.a(r12, "context is null", r18, null, 10);
        return;
    L12:
        Object r19 = r16.getSystemService("vibrator");
        if ((r19 instanceof Vibrator) == false) goto L15;
        Vibrator r110 = (Vibrator) r19;
    L16:
        if (r110 != null) goto L18;
    L50:
        StringBuilder r111 = new StringBuilder("call failed, errNo=");
        f3.a r112 = f3.a.g;
        r111.append(r112.a);
        r111.append(", msg=vibrate is not supported");
        r0.e("AISDK_JSB_VibrateShortMethod", r111.toString());
        h.a.a(r12, "vibrate is not supported", r112, null, 10);
        return;
    L18:
        if (r110.hasVibrator() == false) goto L50;
        AbsVibrateShortMethodIDL.VibrateType r113 = r13.getType();     // Catch: Throwable -> L41
        if (Build.VERSION.SDK_INT < 26) goto L38;
        int r114 = b.a[r113.ordinal()];     // Catch: Throwable -> L41
        if (r114 != 1) goto L25;
        int r115 = 255;
    L34:
        if (r110.hasAmplitudeControl() == false) goto L36;
        VibrationEffect r116 = VibrationEffect.createOneShot(15, r115);     // Catch: Throwable -> L41
    L37:
        r110.vibrate(r116);     // Catch: Throwable -> L41
    L39:
        r0.i("AISDK_JSB_VibrateShortMethod", "call success");     // Catch: Throwable -> L41
        Intrinsics.checkNotNullParameter(AbsVibrateShortMethodIDL.a.class, "<this>");     // Catch: Throwable -> L41
        r12.b((ResultModel) k3.c.a(AbsVibrateShortMethodIDL.a.class), "");     // Catch: Throwable -> L41
        return;
    L36:
        r116 = VibrationEffect.createOneShot(15, -1);     // Catch: Throwable -> L41
        goto L37
    L25:
        if (r114 != 2) goto L27;
        r115 = 180;
        goto L34
    L27:
        if (r114 != 3) goto L30;
        r115 = 100;
        goto L34
    L30:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L41
    L38:
        r110.vibrate(15);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        g r117 = g.a;
        StringBuilder r20 = new StringBuilder("call failed, errNo=");
        f3.a r21 = f3.a.f;
        r20.append(r21.a);
        r20.append(", msg=vibrateShort failed: ");
        String r22 = th.getMessage();
        String r23 = "unknown";
        if (r22 != null) goto L45;
        r22 = "unknown";
    L45:
        r20.append(r22);
        r117.e("AISDK_JSB_VibrateShortMethod", r20.toString());
        String r118 = th.getMessage();
        if (r118 == null) goto L49;
        r23 = r118;
    L49:
        h.a.a(r12, "vibrateShort failed: ".concat(r23), r21, null, 10);
        return;
    L15:
        r110 = null;
        goto L16
    L5:
        r15 = null;
        goto L6
    }
}
