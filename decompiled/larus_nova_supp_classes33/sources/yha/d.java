package yha;

import android.content.res.Resources;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.impl.performance.WindowAnimationBoostCoordinator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public final e a;
    public fja.d b;

    public static final class a {
    }

    static {
    }

    public final void b() {
        FLogger.a.i("ChatWindowAnimations", "stopAllAnimations");
        fja.d r0 = this.b;
        if (r0 == null) goto L5;
        int r1 = fja.d.d;
        r0.a(false);
    L5:
        this.b = null;
    }

    public d(e r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
        this.a = r2;
    }

    public static void a(final d r18, final int r19, boolean r20, Function0 r21, int r22) {
        if ((r22 & 2) == 0) goto L5;
        final boolean r2 = false;
    L7:
        if ((r22 & 4) == 0) goto L9;
        final Function0 r4 = null;
    L10:
        final int r5 = r18.a.G1();
        FLogger.a.i("ChatWindowAnimations", "startHeightAnimation: initialPosition = " + r5 + ", finalPosition = " + r19);
        fja.d r6 = r18.b;
        if (r6 == null) goto L13;
        int r7 = fja.d.d;
        r6.a(false);
    L13:
        Resources r8 = Resources.getSystem();
        int r9 = WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).heightPixels;
        int r10 = r9 - r18.a.G1();
        int r11 = yha.a.a;
        float r12 = r10 / r9;
        float r13 = 1.0f - Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH.getBounce();
        float r14 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_1.getDuration() / 1000.0f;
        Pair r15 = new Pair(Float.valueOf(r13), Float.valueOf((float) Math.pow(6.283185307179586d / ((double) (r14 + (((Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3.getDuration() / 1000.0f) - r14) * ((r12 - 0.3f) / 0.3f)))), 2.0d)));
        float r16 = ((Number) r15.component1()).floatValue();
        float r17 = ((Number) r15.component2()).floatValue();
        IAssistantChatWindow r23 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r23 == null) goto L16;
        r23.applyWindowAnimationBoost("window_height_animation", WindowAnimationBoostCoordinator.DEFAULT_WINDOW_ANIMATION_DURATION_MS);
    L16:
        final Ref.ObjectRef r24 = new Ref.ObjectRef();
        com.obric.common.oea.foundation.animation.builder.d.a r110 = new com.obric.common.oea.foundation.animation.builder.d.a();
        com.obric.common.oea.foundation.animation.spec.spring.d r111 = new com.obric.common.oea.foundation.animation.spec.spring.d(r16, r17, 0);
        r111.b = 1.0f;
        Unit r3 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r111, "spec");
        r110.c = new dja.a.C0052a("valueAnimationPlaceholder", Integer.valueOf(r5), Integer.valueOf(r19), Reflection.getOrCreateKotlinClass(Integer.TYPE), r111, null);
        Function3<? super String, Object, Object, Unit> r25 = new b(r18, r5, r19, r2);
        Intrinsics.checkNotNullParameter(r25, "callback");
        r110.d = r25;
        Function2<? super Boolean, ? super Throwable, Unit> r26 = new c(r4, r18, r24);
        Intrinsics.checkNotNullParameter(r26, "callback");
        r110.e = r26;
        fja.d r1 = r110.a().a();
        r24.element = r1;
        r18.b = r1;
        return;
    L9:
        r4 = r21;
        goto L10
    L5:
        r2 = r20;
        goto L7
    }
}
