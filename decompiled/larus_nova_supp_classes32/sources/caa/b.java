package caa;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements z9a.a {
    public final Lazy a;

    public static final class a {
    }

    /* JADX INFO: renamed from: caa.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0008b {
        public static final /* synthetic */ int[] a = null;

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
            a = r0;
        }
    }

    static {
    }

    public b() {
        this.a = LazyKt.lazy(new caa.a());
    }

    @Override // z9a.a
    public final void a(FeedbackType r6) {
        Intrinsics.checkNotNullParameter(r6, "feedbackType");
        if (((Vibrator) this.a.getValue()) != null) goto L6;
        ISysLogDepend.c.w("CommonVibrateFeedback", "vibrator is null");
        return;
    L6:
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 29) goto L9;
        ISysLogDepend.c.w("CommonVibrateFeedback", "api level is too low. " + r0);
        return;
    L9:
        switch(C0008b.a[r6.ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        VibrationEffect r1 = VibrationEffect.createPredefined(2);
    L19:
        if (r1 != null) goto L22;
        ISysLogDepend.c.w("CommonVibrateFeedback", "not found effect for " + r6.getTypeName());
        return;
    L22:
        Vibrator r7 = (Vibrator) this.a.getValue();
        if (r7 == null) goto L27;
        r7.vibrate(r1);
        return;
    L27:
        return;
    L13:
        r1 = VibrationEffect.createPredefined(0);
        goto L19
    L14:
        r1 = VibrationEffect.createPredefined(1);
        goto L19
    L15:
        r1 = VibrationEffect.createPredefined(1);
        goto L19
    L16:
        r1 = VibrationEffect.createPredefined(2);
        goto L19
    L17:
        r1 = VibrationEffect.createPredefined(5);
        goto L19
    L18:
        r1 = VibrationEffect.createPredefined(5);
        goto L19
    L11:
        throw new NoWhenBranchMatchedException();
    }
}
