package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.vibrate.AbsVibrateLongMethodIDL;
import com.lynx.jsbridge.LynxResourceModule;
import e2.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/VibrateLongMethod;", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateLongMethodIDL;", "<init>", "()V", "Landroid/os/Vibrator;", "vibrator", "", "triggerLongVibration", "(Landroid/os/Vibrator;)V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateLongMethodIDL$VibrateLongParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateLongMethodIDL$EmptyMessageModel;", "callback", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateLongMethodIDL$VibrateLongParamModel;Lo1/f;)V", "Companion", "e2/e", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VibrateLongMethod extends AbsVibrateLongMethodIDL {
    public static final e Companion = null;
    private static final long LONG_VIBRATE_DURATION_MS = 400;

    static {
        Companion = new e();
    }

    public VibrateLongMethod() {
    }

    private final void triggerLongVibration(Vibrator r5) {
        r5.vibrate(VibrationEffect.createOneShot(LONG_VIBRATE_DURATION_MS, -1));
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsVibrateLongMethodIDL.VibrateLongParamModel) r10, r11);
    }

    public void handle(n1.c r5, AbsVibrateLongMethodIDL.VibrateLongParamModel r10, f r11) {
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
        triggerLongVibration(r14);     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(AbsVibrateLongMethodIDL.EmptyMessageModel.class, "<this>");     // Catch: Throwable -> L18
        r11.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsVibrateLongMethodIDL.EmptyMessageModel.class), "");     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        String r15 = th.getMessage();
        if (r15 != null) goto L22;
        r15 = "unknown";
    L22:
        r11.a("vibrateLong failed: ".concat(r15));
        return;
    L11:
        r14 = null;
        goto L12
    }
}
