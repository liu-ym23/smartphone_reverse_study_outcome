package com.obric.aiagent.product.platform.impl.vibratefeedback;

import android.app.Application;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.obric.aiagent.platform.a.a;
import com.obric.aiagent.platform.a.f;
import com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType;
import com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\rH\u0003R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/vibratefeedback/CommonVibrateFeedback;", "Lcom/obric/aiagent/product/platform/api/vibratefeedback/IVibrateFeedback;", "<init>", "()V", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "vibrator$delegate", "Lkotlin/Lazy;", "performVibratorSmtFeedback", "", "feedbackType", "Lcom/obric/aiagent/product/platform/api/vibratefeedback/FeedbackType;", "toVibrationEffect", "Landroid/os/VibrationEffect;", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CommonVibrateFeedback implements IVibrateFeedback {
    public static final Companion Companion = null;
    private static final String TAG = "CommonVibrateFeedback";
    private final Lazy vibrator$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/vibratefeedback/CommonVibrateFeedback$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[FeedbackType.values().length];
            r0[FeedbackType.WAKE_UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[FeedbackType.LONG_PRESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[FeedbackType.TICK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[FeedbackType.WARNING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[FeedbackType.CONFIRM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[FeedbackType.RIGID.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[FeedbackType.SOFT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CommonVibrateFeedback() {
        this.vibrator$delegate = LazyKt.lazy($$Lambda$CommonVibrateFeedback$C2pMKcnBgrjeFa2BP0DT5P_frc.INSTANCE);
    }

    private final Vibrator getVibrator() {
        return (Vibrator) ZeusTransformUtils.preCheckCast(this.vibrator$delegate.getValue(), Vibrator.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$C2pMKcnBgrjeFa2-BP0DT5P_frc, reason: not valid java name */
    public static /* synthetic */ Vibrator m179lambda$C2pMKcnBgrjeFa2BP0DT5P_frc() {
        return vibrator_delegate$lambda$0();
    }

    private final VibrationEffect toVibrationEffect(FeedbackType r3) {
        switch(WhenMappings.$EnumSwitchMapping$0[r3.ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L13;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L11:
        return VibrationEffect.createPredefined(0);
    L12:
        return VibrationEffect.createPredefined(1);
    L13:
        return VibrationEffect.createPredefined(2);
    L10:
        return VibrationEffect.createPredefined(5);
    }

    private static final Vibrator vibrator_delegate$lambda$0() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService("vibrator");
        if (ZeusTransformUtils.instanceOf(r0, Vibrator.class) == true) goto L7;
        return null;
    L7:
        return (Vibrator) ZeusTransformUtils.preCheckCast(r0, Vibrator.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback
    public void performVibratorSmtFeedback(FeedbackType r4) {
        Intrinsics.checkNotNullParameter(r4, "feedbackType");
        if (getVibrator() != null) goto L8;
        f.a r3 = f.f5958b;
        String r5 = "vibrator is null";
    L5:
        r3.c(TAG, r5);
        return;
    L8:
        if (Build.VERSION.SDK_INT < 29) goto L15;
        VibrationEffect r0 = toVibrationEffect(r4);
        if (r0 != null) goto L12;
        CommonVibrateFeedback r6 = (CommonVibrateFeedback) ZeusTransformUtils.preCheckCast(this, CommonVibrateFeedback.class, "com.obric.memorydata.plugin");
        r3 = f.f5958b;
        r5 = "not found effect for " + r4.getTypeName();
        goto L5
    L12:
        Vibrator r7 = getVibrator();
        if (r7 == null) goto L17;
        r7.vibrate(r0);
        return;
    L17:
        return;
    L15:
        f.f5958b.c(TAG, "api level is too low. " + Build.VERSION.SDK_INT);
    }

    @Override // com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback
    public void performVibratorSmtFeedback(String r1) {
        IVibrateFeedback.DefaultImpls.performVibratorSmtFeedback(this, r1);
    }
}
