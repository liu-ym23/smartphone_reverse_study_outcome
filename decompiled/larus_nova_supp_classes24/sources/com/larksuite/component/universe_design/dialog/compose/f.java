package com.larksuite.component.universe_design.dialog.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.text.TextStyle;
import com.larksuite.component.universe_design.compose.foundation.i0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public static final void a(final ColumnScope r56, final String r57, final Function1 r59, final String r510, final int r60, final boolean r61, final int r62, Modifier r63, Composer r64, final int r65, final int r66) {
        Composer r3 = r64.startRestartGroup(1447726832);
        if ((r66 & 1) == 0) goto L6;
        int r1 = r65 | 48;
    L14:
        if ((r66 & 2) == 0) goto L17;
        r1 = r1 | 384;
    L25:
        if ((r66 & 4) == 0) goto L28;
        r1 = r1 | 3072;
    L35:
        if ((r66 & 8) == 0) goto L38;
        r1 = r1 | 24576;
    L45:
        if ((r66 & 16) == 0) goto L48;
        r1 = r1 | 196608;
    L55:
        if ((r66 & 32) == 0) goto L58;
        r1 = r1 | 1572864;
    L65:
        int r11 = r66 & 64;
        if (r11 == 0) goto L69;
        r1 = r1 | 12582912;
    L75:
        Modifier r12 = r63;
    L77:
        if ((4793489 & r1) == 4793488) goto L79;
    L82:
        if (r11 == 0) goto L84;
        Modifier r15 = Modifier.Companion;
    L86:
        if (ComposerKt.isTraceInProgress() == false) goto L88;
        ComposerKt.traceEventStart(1447726832, r1, -1, "com.larksuite.component.universe_design.dialog.compose.DialogTextField (UDInputDialog.kt:92)");
    L88:
        RoundedCornerShape r0 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(e.m);
        r3.startReplaceGroup(1849434622);
        Object r13 = r3.rememberedValue();
        Composer.Companion r14 = Composer.Companion;
        if (r13 != r14.getEmpty()) goto L91;
        r13 = new FocusRequester();
        r3.updateRememberedValue(r13);
    L91:
        FocusRequester r16 = (FocusRequester) r13;
        r3.endReplaceGroup();
        Boolean r17 = Boolean.valueOf(r61);
        r3.startReplaceGroup(-1633490746);
        boolean r21 = false;
        if ((458752 & r1) != 131072) goto L94;
        boolean r10 = true;
    L95:
        Object r19 = r3.rememberedValue();
        if (r10 == false) goto L98;
    L99:
        r19 = new UDInputDialogKt$DialogTextField$1$1(r61, r16, null);
        r3.updateRememberedValue(r19);
    L100:
        r3.endReplaceGroup();
        EffectsKt.LaunchedEffect(r17, (Function2) r19, r3, (r1 >> 15) & 14);
        Modifier r2 = PaddingKt.padding-VpY3zN4(FocusRequesterModifierKt.focusRequester(BorderKt.border(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.defaultMinSize-VpY3zN4$default(r15, 0.0f, e.n, 1, null), r0), i0.a(r3).d.h.c, null, 2, null), BorderStrokeKt.BorderStroke-cXLIe8U(e.l, i0.a(r3).d.g.c), r0), r16), e.o, e.p);
        TextStyle r24 = TextStyle.copy-p1EtxEg$default(i0.b(r3).c, i0.a(r3).b(), 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null);
        Modifier r27 = r15;
        KeyboardOptions r25 = new KeyboardOptions(0, null, r62, 0, null, null, null, 123, null);
        if (r60 != 1) goto L103;
        r21 = true;
    L103:
        int r110 = RangesKt.coerceAtLeast(r60, 1);
        ComposableLambda r111 = ComposableLambdaKt.rememberComposableLambda(-924930899, true, new UDInputDialogKt$DialogTextField$2(r57, r510), r3, 54);
        int r4 = r1 >> 3;
        Composer r20 = r3;
        boolean r8 = r21;
        BasicTextFieldKt.BasicTextField(r57, r59, r2, false, false, r24, r25, null, r8, r110, 0, null, null, null, null, r111, r20, (r4 & 14) | (r4 & 112), 196608, 31896);
        if (ComposerKt.isTraceInProgress() == false) goto L106;
        ComposerKt.traceEventEnd();
    L106:
        final Modifier r9 = r27;
    L107:
        ScopeUpdateScope r112 = r20.endRestartGroup();
        if (r112 == null) goto L111;
        r112.updateScope(new UDInputDialogKt$DialogTextField$3(r56, r57, r59, r510, r60, r61, r62, r9, r65, r66));
        return;
    L111:
        return;
    L98:
        if (r19 != r14.getEmpty()) goto L100;
    L94:
        r10 = false;
        goto L95
    L84:
        r15 = r12;
        goto L86
    L79:
        if (r3.getSkipping() == false) goto L82;
        r3.skipToGroupEnd();
        r20 = r3;
        r9 = r12;
        goto L107
    L69:
        if ((12582912 & r65) != 0) goto L75;
        r12 = r63;
        if (r3.changed(r12) == false) goto L73;
        int r113 = 8388608;
    L74:
        r1 = r1 | r113;
        goto L77
    L73:
        r113 = 4194304;
        goto L74
    L58:
        if ((r65 & 1572864) != 0) goto L65;
        if (r3.changed(r62) == false) goto L62;
        int r114 = 1048576;
    L63:
        r1 = r1 | r114;
        goto L65
    L62:
        r114 = 524288;
        goto L63
    L48:
        if ((r65 & 196608) != 0) goto L55;
        if (r3.changed(r61) == false) goto L52;
        int r22 = 131072;
    L53:
        r1 = r1 | r22;
        goto L55
    L52:
        r22 = 65536;
        goto L53
    L38:
        if ((r65 & 24576) != 0) goto L45;
        if (r3.changed(r60) == false) goto L42;
        int r23 = 16384;
    L43:
        r1 = r1 | r23;
        goto L45
    L42:
        r23 = 8192;
        goto L43
    L28:
        if ((r65 & 3072) != 0) goto L35;
        if (r3.changed(r510) == false) goto L32;
        int r26 = 2048;
    L33:
        r1 = r1 | r26;
        goto L35
    L32:
        r26 = 1024;
        goto L33
    L17:
        if ((r65 & 384) != 0) goto L25;
        if (r3.changedInstance(r59) == false) goto L21;
        int r29 = 256;
    L22:
        r1 = r1 | r29;
        goto L25
    L21:
        r29 = 128;
        goto L22
    L6:
        if ((r65 & 48) == 0) goto L8;
        r1 = r65;
        goto L14
    L8:
        if (r3.changed(r57) == false) goto L10;
        int r5 = 32;
    L11:
        r1 = r5 | r65;
        goto L14
    L10:
        r5 = 16;
        goto L11
    }
}
