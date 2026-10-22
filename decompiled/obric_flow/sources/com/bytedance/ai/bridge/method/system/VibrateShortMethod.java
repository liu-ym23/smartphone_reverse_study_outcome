package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.vibrate.AbsVibrateShortMethodIDL;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import e2.f;
import e2.g;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/VibrateShortMethod;", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL;", "<init>", "()V", "Landroid/os/Vibrator;", "vibrator", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$VibrateType;", "type", "", "triggerShortVibration", "(Landroid/os/Vibrator;Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$VibrateType;)V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$VibrateShortParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$EmptyMessageModel;", "callback", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$VibrateShortParamModel;Lo1/f;)V", "Companion", "e2/f", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VibrateShortMethod extends AbsVibrateShortMethodIDL {
    public static final f Companion = null;
    private static final long SHORT_VIBRATE_DURATION_MS = 15;

    static {
        Companion = new f();
    }

    public VibrateShortMethod() {
    }

    private final void triggerShortVibration(Vibrator r5, AbsVibrateShortMethodIDL.VibrateType r10) {
        int r11 = g.f16750a[r10.ordinal()];
        if (r11 != 1) goto L5;
        int r12 = 255;
    L14:
        if (r5.hasAmplitudeControl() == false) goto L16;
        VibrationEffect r13 = VibrationEffect.createOneShot(SHORT_VIBRATE_DURATION_MS, r12);
    L17:
        r5.vibrate(r13);
        return;
    L16:
        r13 = VibrationEffect.createOneShot(SHORT_VIBRATE_DURATION_MS, -1);
        goto L17
    L5:
        if (r11 != 2) goto L7;
        r12 = 180;
        goto L14
    L7:
        if (r11 != 3) goto L10;
        r12 = 100;
        goto L14
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsVibrateShortMethodIDL.VibrateShortParamModel) r10, r11);
    }

    public void handle(n1.c r5, AbsVibrateShortMethodIDL.VibrateShortParamModel r10, o1.f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        Activity r12 = ((n1.a) r5).d();
        if (r12 != null) goto L5;
        r12 = s0.c.b();
    L5:
        if (r12 != null) goto L8;
        r11.a("context is null");
        return;
    L8:
        Object r13 = r12.getSystemService("vibrator");
        if ((r13 instanceof Vibrator) == false) goto L11;
        Vibrator r14 = (Vibrator) r13;
    L12:
        if (r14 != null) goto L14;
    L24:
        r11.a("vibrate is not supported");
        return;
    L14:
        if (r14.hasVibrator() == false) goto L24;
        triggerShortVibration(r14, r10.getType());     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(AbsVibrateShortMethodIDL.EmptyMessageModel.class, "<this>");     // Catch: Throwable -> L18
        r11.b((ResultModel) e.c(AbsVibrateShortMethodIDL.EmptyMessageModel.class), "");     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        String r15 = th.getMessage();
        if (r15 != null) goto L22;
        r15 = "unknown";
    L22:
        r11.a("vibrateShort failed: ".concat(r15));
        return;
    L11:
        r14 = null;
        goto L12
    }
}
