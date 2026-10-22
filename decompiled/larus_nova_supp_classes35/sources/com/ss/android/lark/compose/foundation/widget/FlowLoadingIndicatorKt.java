package com.ss.android.lark.compose.foundation.widget;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FlowLoadingIndicatorKt {
    public static final void a(Modifier r24, float r25, long r26, Composer r28, final int r29, final int r30) {
        Composer r1 = r28.startRestartGroup(169393235);
        int r2 = r30 & 1;
        if (r2 == 0) goto L6;
        int r6 = r29 | 6;
        Modifier r4 = r24;
    L13:
        int r7 = r30 & 2;
        if (r7 == 0) goto L17;
        r6 = r6 | 48;
    L23:
        float r8 = r25;
    L24:
        int r9 = r30 & 4;
        if (r9 == 0) goto L28;
        r6 = r6 | 384;
    L34:
        final long r10 = r26;
    L35:
        int r15 = r6;
        if ((r15 & 147) == 146) goto L38;
    L41:
        if (r2 == 0) goto L43;
        Modifier r3 = Modifier.Companion;
    L44:
        if (r7 == 0) goto L46;
        float r5 = Dp.constructor-impl(20);
    L47:
        if (r9 == 0) goto L49;
        long r12 = Color.Companion.getWhite-0d7_KjU();
    L51:
        if (ComposerKt.isTraceInProgress() == false) goto L53;
        ComposerKt.traceEventStart(169393235, r15, -1, "com.ss.android.lark.compose.foundation.widget.FlowLoadingIndicator (FlowLoadingIndicator.kt:31)");
    L53:
        long r22 = r12;
        final int r0 = (int) ((Number) InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition(null, r1, 0, 1), 0.0f, 8, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(1000, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0, 4, null), null, r1, (InfiniteTransition.$stable | 48) | (InfiniteRepeatableSpec.$stable << 9), 8).getValue()).floatValue();
        Modifier r11 = SizeKt.size-3ABfNKs(r3, r5);
        r1.startReplaceGroup(-1746271574);
        boolean r13 = r1.changed(r0);
        if ((r15 & 896) != 256) goto L56;
        boolean r14 = true;
    L57:
        boolean r16 = r13 | r14;
        Object r17 = r1.rememberedValue();
        if (r16 == false) goto L60;
    L63:
        r10 = r22;
        final int r18 = 8;
        r17 = new FlowLoadingIndicatorKt$FlowLoadingIndicator$1$1(r18, r0, r10);
        r1.updateRememberedValue(r17);
    L64:
        r1.endReplaceGroup();
        CanvasKt.Canvas(r11, (Function1) r17, r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L67;
        ComposerKt.traceEventEnd();
    L67:
        ScopeUpdateScope r19 = r1.endRestartGroup();
        if (r19 == null) goto L71;
        final Modifier r20 = r3;
        final float r21 = r5;
        final long r23 = r10;
        r19.updateScope(new FlowLoadingIndicatorKt$FlowLoadingIndicator$2(r20, r21, r23, r29, r30));
        return;
    L71:
        return;
    L60:
        if (r17 == Composer.Companion.getEmpty()) goto L63;
        r10 = r22;
        goto L64
    L56:
        r14 = false;
        goto L57
    L49:
        r12 = r10;
        goto L51
    L46:
        r5 = r8;
        goto L47
    L43:
        r3 = r4;
        goto L44
    L38:
        if (r1.getSkipping() == false) goto L41;
        r1.skipToGroupEnd();
        r3 = r4;
        r5 = r8;
        goto L67
    L28:
        if ((r29 & 384) != 0) goto L34;
        r10 = r26;
        if (r1.changed(r10) == false) goto L32;
        int r110 = 256;
    L33:
        r6 = r6 | r110;
        goto L35
    L32:
        r110 = 128;
        goto L33
    L17:
        if ((r29 & 48) != 0) goto L23;
        r8 = r25;
        if (r1.changed(r8) == false) goto L21;
        int r27 = 32;
    L22:
        r6 = r6 | r27;
        goto L24
    L21:
        r27 = 16;
        goto L22
    L6:
        if ((r29 & 6) != 0) goto L12;
        r4 = r24;
        if (r1.changed(r4) == false) goto L10;
        int r31 = 4;
    L11:
        r6 = r31 | r29;
        goto L13
    L10:
        r31 = 2;
        goto L11
    L12:
        r4 = r24;
        r6 = r29;
        goto L13
    }
}
