package com.larksuite.component.universe_design.button.compose;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.ContextCompat;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UDButtonKt {
    public static final float a = 0.0f;
    public static final float b = 0.0f;
    public static final float c = 0.0f;
    public static final float d = 0.0f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UDButtonSize.values().length];
            r0[UDButtonSize.Column.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[UDButtonSize.Big.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[UDButtonSize.Middle.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[UDButtonSize.Small.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[UDButtonSize.Custom.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
        float r0 = Dp.constructor-impl(6);
        float r1 = 2;
        float r2 = Dp.constructor-impl(r1);
        a = r2;
        b = Dp.constructor-impl(4);
        c = Dp.constructor-impl(Dp.constructor-impl(r0 + r2) * r1);
        d = Dp.constructor-impl(44);
    }

    public static final long d(Context r2, int r3, boolean r4, boolean r5) {
        ColorStateList r0 = ContextCompat.getColorStateList(r2, r3);
        if (r0 == null) goto L5;
        int r6 = r0.getDefaultColor();
    L6:
        if (r0 != null) goto L9;
        r0 = ColorStateList.valueOf(r6);
    L9:
        if (r4 == true) goto L11;
        int[] r7 = {-16842910};
    L15:
        return ColorKt.Color(r0.getColorForState(r7, r6));
    L11:
        if (r5 == false) goto L13;
        r7 = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        goto L15
    L13:
        r7 = new int[]{R.attr.state_enabled};
        goto L15
    L5:
        r6 = ContextCompat.getColor(r2, r3);
        goto L6
    }

    public static final void c(final long r16, Modifier r19, Composer r110, final int r20, final int r21) {
        Composer r12 = r110.startRestartGroup(-2141888003);
        if ((r21 & 1) == 0) goto L6;
        int r1 = r20 | 6;
    L13:
        int r2 = r21 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L23:
        final Modifier r3 = r19;
    L25:
        if ((r1 & 19) == 18) goto L27;
    L30:
        if (r2 == 0) goto L32;
        Modifier r15 = Modifier.Companion;
    L34:
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventStart(-2141888003, r1, -1, "com.larksuite.component.universe_design.button.compose.UDButtonLoadingIndicator (UDButton.kt:361)");
    L36:
        ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(SizeKt.size-3ABfNKs(r15, c), r16, a, 0, 0, 0.0f, r12, ((r1 << 3) & 112) | 384, 56);
        if (ComposerKt.isTraceInProgress() == false) goto L39;
        ComposerKt.traceEventEnd();
    L39:
        r3 = r15;
    L40:
        ScopeUpdateScope r6 = r12.endRestartGroup();
        if (r6 == null) goto L44;
        r6.updateScope(new UDButtonKt$UDButtonLoadingIndicator$1(r16, r3, r20, r21));
        return;
    L44:
        return;
    L32:
        r15 = r3;
        goto L34
    L27:
        if (r12.getSkipping() == false) goto L30;
        r12.skipToGroupEnd();
        goto L40
    L17:
        if ((r20 & 48) != 0) goto L23;
        r3 = r19;
        if (r12.changed(r3) == false) goto L21;
        int r4 = 32;
    L22:
        r1 = r1 | r4;
        goto L25
    L21:
        r4 = 16;
        goto L22
    L6:
        if ((r20 & 6) == 0) goto L8;
        r1 = r20;
        goto L13
    L8:
        if (r12.changed(r16) == false) goto L10;
        int r5 = 4;
    L11:
        r1 = r20 | r5;
        goto L13
    L10:
        r5 = 2;
        goto L11
    }

    public static final void b(final String r44, final TextStyle r45, final long r46, final long r48, final UDButtonLoadingPlacement r50, Composer r51, final int r52) {
        Composer r2 = r51.startRestartGroup(-701547350);
        if ((r52 & 6) == 0) goto L5;
        int r3 = r52;
    L11:
        if ((r52 & 48) != 0) goto L19;
        if (r2.changed(r45) == false) goto L15;
        int r12 = 32;
    L16:
        r3 = r3 | r12;
        goto L19
    L15:
        r12 = 16;
    L19:
        if ((r52 & 384) != 0) goto L26;
        if (r2.changed(r46) == false) goto L23;
        int r13 = 256;
    L24:
        r3 = r3 | r13;
        goto L26
    L23:
        r13 = 128;
    L26:
        if ((r52 & 3072) != 0) goto L33;
        if (r2.changed(r48) == false) goto L30;
        int r14 = 2048;
    L31:
        r3 = r3 | r14;
        goto L33
    L30:
        r14 = 1024;
    L33:
        if ((r52 & 24576) != 0) goto L40;
        if (r2.changed(r50.ordinal()) == false) goto L37;
        int r15 = 16384;
    L38:
        r3 = r3 | r15;
        goto L40
    L37:
        r15 = 8192;
    L40:
        if ((r3 & 9363) != 9362) goto L46;
        if (r2.getSkipping() == false) goto L46;
        r2.skipToGroupEnd();
    L91:
        ScopeUpdateScope r9 = r2.endRestartGroup();
        if (r9 == null) goto L96;
        r9.updateScope(new UDButtonKt$InlineLoadingText$6(r44, r45, r46, r48, r50, r52));
        return;
    L96:
        return;
    L46:
        if (ComposerKt.isTraceInProgress() == false) goto L48;
        ComposerKt.traceEventStart(-701547350, r3, -1, "com.larksuite.component.universe_design.button.compose.InlineLoadingText (UDButton.kt:285)");
    L48:
        r2.startReplaceGroup(-1633490746);
        int r0 = r3 & 14;
        if (r0 != 4) goto L51;
        boolean r16 = true;
    L53:
        if ((r3 & 112) != 32) goto L55;
        boolean r4 = true;
    L56:
        boolean r5 = r16 | r4;
        Object r11 = r2.rememberedValue();
        if (r5 == false) goto L59;
    L60:
        r11 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r2.updateRememberedValue(r11);
    L61:
        final MutableState r17 = (MutableState) r11;
        r2.endReplaceGroup();
        r2.startReplaceGroup(122871544);
        if (((Boolean) r17.getValue()).booleanValue() == false) goto L79;
        Modifier.Companion r6 = Modifier.Companion;
        r2.startReplaceGroup(5004770);
        if (r0 != 4) goto L66;
        boolean r19 = true;
    L67:
        Object r1 = r2.rememberedValue();
        if (r19 == false) goto L70;
    L71:
        r1 = new UDButtonKt$InlineLoadingText$1$1(r44);
        r2.updateRememberedValue(r1);
    L72:
        r2.endReplaceGroup();
        Modifier r7 = SemanticsModifierKt.clearAndSetSemantics(r6, (Function1) r1);
        int r8 = TextOverflow.Companion.getClip-gIe3tQ8();
        BasicTextKt.BasicText-RWo7tUw("...", r7, TextStyle.merge-dA7vx0o$default(r45, r46, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, TextAlign.Companion.getCenter-e0LSkKk(), 0, 0, null, null, 0, 0, null, null, 16744446, null), null, r8, false, 1, 0, null, null, r2, 1597446, 936);
        r2.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L75;
        ComposerKt.traceEventEnd();
    L75:
        ScopeUpdateScope r10 = r2.endRestartGroup();
        if (r10 == null) goto L95;
        r10.updateScope(new UDButtonKt$InlineLoadingText$2(r44, r45, r46, r48, r50, r52));
        return;
    L95:
        return;
    L70:
        if (r1 != Composer.Companion.getEmpty()) goto L72;
    L66:
        r19 = false;
        goto L67
    L79:
        r2.endReplaceGroup();
        Density r20 = (Density) r2.consume(CompositionLocalsKt.getLocalDensity());
        float r21 = c;
        long r110 = r20.toSp-0xMU5do(Dp.constructor-impl(b + r21));
        long r111 = r20.toSp-0xMU5do(r21);
        AnnotatedString.Builder r22 = new AnnotatedString.Builder(0, 1, null);
        if (r50 != UDButtonLoadingPlacement.TextStart) goto L82;
        InlineTextContentKt.appendInlineContent(r22, "ud_button_loading", " ");
        r22.append(r44);
    L83:
        AnnotatedString r23 = r22.toAnnotatedString();
        int r24 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
        Map r25 = MapsKt.mapOf(TuplesKt.to("ud_button_loading", new InlineTextContent(new Placeholder(r110, r111, PlaceholderVerticalAlign.Companion.getCenter-J6kI3mc(), null), ComposableLambdaKt.rememberComposableLambda(1451109095, true, new UDButtonKt$InlineLoadingText$4(r50, r48), r2, 54))));
        TextStyle r26 = TextStyle.merge-dA7vx0o$default(r45, r46, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, TextAlign.Companion.getCenter-e0LSkKk(), 0, 0, null, null, 0, 0, null, null, 16744446, null);
        r2.startReplaceGroup(5004770);
        boolean r112 = r2.changed(r17);
        Object r113 = r2.rememberedValue();
        if (r112 == false) goto L86;
    L87:
        r113 = new UDButtonKt$InlineLoadingText$5$1(r17);
        r2.updateRememberedValue(r113);
    L88:
        r2.endReplaceGroup();
        BasicTextKt.BasicText-CL7eQgs(r23, null, r26, (Function1) r113, r24, false, 1, 0, r25, null, null, r2, 1597440, 0, 1698);
        if (ComposerKt.isTraceInProgress() == false) goto L91;
        ComposerKt.traceEventEnd();
        goto L91
    L86:
        if (r113 != Composer.Companion.getEmpty()) goto L88;
    L82:
        r22.append(r44);
        InlineTextContentKt.appendInlineContent(r22, "ud_button_loading", " ");
        goto L83
    L59:
        if (r11 != Composer.Companion.getEmpty()) goto L61;
    L55:
        r4 = false;
        goto L56
    L51:
        r16 = false;
        goto L53
    L5:
        if (r2.changed(r44) == false) goto L7;
        int r27 = 4;
    L8:
        r3 = r27 | r52;
        goto L11
    L7:
        r27 = 2;
        goto L8
    }

    public static final void a(final String r44, final TextStyle r45, final long r46, final boolean r48, final UDButtonLoadingPlacement r49, final long r50, final UDButtonIconPlacement r52, final Function3<? super Color, ? super Composer, ? super Integer, Unit> r53, Composer r54, final int r55) {
        Composer r1 = r54.startRestartGroup(278257570);
        if ((r55 & 6) == 0) goto L5;
        int r4 = r55;
    L11:
        if ((r55 & 48) != 0) goto L19;
        if (r1.changed(r45) == false) goto L15;
        int r8 = 32;
    L16:
        r4 = r4 | r8;
        goto L19
    L15:
        r8 = 16;
    L19:
        if ((r55 & 384) != 0) goto L26;
        if (r1.changed(r46) == false) goto L23;
        int r9 = 256;
    L24:
        r4 = r4 | r9;
        goto L26
    L23:
        r9 = 128;
    L26:
        if ((r55 & 3072) != 0) goto L33;
        if (r1.changed(r48) == false) goto L30;
        int r10 = 2048;
    L31:
        r4 = r4 | r10;
        goto L33
    L30:
        r10 = 1024;
    L33:
        if ((r55 & 24576) != 0) goto L40;
        if (r1.changed(r49.ordinal()) == false) goto L37;
        int r11 = 16384;
    L38:
        r4 = r4 | r11;
        goto L40
    L37:
        r11 = 8192;
    L40:
        if ((196608 & r55) != 0) goto L47;
        if (r1.changed(r50) == false) goto L44;
        int r12 = 131072;
    L45:
        r4 = r4 | r12;
        goto L47
    L44:
        r12 = 65536;
    L47:
        if ((1572864 & r55) != 0) goto L54;
        if (r1.changed(r52.ordinal()) == false) goto L51;
        int r13 = 1048576;
    L52:
        r4 = r4 | r13;
        goto L54
    L51:
        r13 = 524288;
    L54:
        if ((12582912 & r55) != 0) goto L61;
        if (r1.changedInstance(r53) == false) goto L58;
        int r14 = 8388608;
    L59:
        r4 = r4 | r14;
        goto L61
    L58:
        r14 = 4194304;
    L61:
        if ((4793491 & r4) != 4793490) goto L67;
        if (r1.getSkipping() == false) goto L67;
        r1.skipToGroupEnd();
    L128:
        ScopeUpdateScope r15 = r1.endRestartGroup();
        if (r15 == null) goto L135;
        r15.updateScope(new UDButtonKt$ButtonContent$5(r44, r45, r46, r48, r49, r50, r52, r53, r55));
        return;
    L135:
        return;
    L67:
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventStart(278257570, r4, -1, "com.larksuite.component.universe_design.button.compose.ButtonContent (UDButton.kt:234)");
    L69:
        r1.startReplaceGroup(1117561971);
        if (r48 == false) goto L81;
        if (r49 != UDButtonLoadingPlacement.Center) goto L81;
        c(r50, null, r1, (r4 >> 15) & 14, 2);
        r1.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L76;
        ComposerKt.traceEventEnd();
    L76:
        ScopeUpdateScope r16 = r1.endRestartGroup();
        if (r16 == null) goto L132;
        r16.updateScope(new UDButtonKt$ButtonContent$1(r44, r45, r46, r48, r49, r50, r52, r53, r55));
        return;
    L132:
        return;
    L81:
        r1.endReplaceGroup();
        r1.startReplaceGroup(1117566888);
        if (r48 == false) goto L90;
        b(r44, r45, r46, r50, r49, r1, ((((r4 & 14) | (r4 & 112)) | (r4 & 896)) | ((r4 >> 6) & 7168)) | (57344 & r4));
        r1.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L86;
        ComposerKt.traceEventEnd();
    L86:
        ScopeUpdateScope r17 = r1.endRestartGroup();
        if (r17 == null) goto L133;
        r17.updateScope(new UDButtonKt$ButtonContent$2(r44, r45, r46, r48, r49, r50, r52, r53, r55));
        return;
    L133:
        return;
    L90:
        r1.endReplaceGroup();
        r1.startReplaceGroup(1117575298);
        if (r48 == true) goto L102;
        if (r53 == null) goto L102;
        if (r52 != UDButtonIconPlacement.Center) goto L102;
        r53.invoke(Color.box-impl(r46), r1, Integer.valueOf(((r4 >> 6) & 14) | ((r4 >> 18) & 112)));
        r1.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventEnd();
    L98:
        ScopeUpdateScope r19 = r1.endRestartGroup();
        if (r19 == null) goto L134;
        r19.updateScope(new UDButtonKt$ButtonContent$3(r44, r45, r46, r48, r49, r50, r52, r53, r55));
        return;
    L134:
        return;
    L102:
        r1.endReplaceGroup();
        Arrangement.HorizontalOrVertical r0 = Arrangement.INSTANCE.getCenter();
        Alignment.Vertical r3 = Alignment.Companion.getCenterVertically();
        Modifier.Companion r110 = Modifier.Companion;
        MeasurePolicy r2 = RowKt.rowMeasurePolicy(r0, r3, r1, 54);
        long r111 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r5 = (int) (r111 ^ (r111 >>> 32));
        CompositionLocalMap r7 = r1.getCurrentCompositionLocalMap();
        Modifier r112 = ComposedModifierKt.materializeModifier(r1, r110);
        ComposeUiNode.Companion r113 = ComposeUiNode.Companion;
        Function0 r114 = r113.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L105;
        ComposablesKt.invalidApplier();
    L105:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L108;
        r1.createNode(r114);
    L109:
        Composer r6 = Updater.constructor-impl(r1);
        Updater.set-impl(r6, r2, r113.getSetMeasurePolicy());
        Updater.set-impl(r6, r7, r113.getSetResolvedCompositionLocals());
        Function2 r20 = r113.getSetCompositeKeyHash();
        if (r6.getInserting() == false) goto L112;
    L113:
        r6.updateRememberedValue(Integer.valueOf(r5));
        r6.apply(Integer.valueOf(r5), r20);
    L114:
        Updater.set-impl(r6, r112, r113.getSetModifier());
        RowScopeInstance r21 = RowScopeInstance.INSTANCE;
        r1.startReplaceGroup(1253762589);
        if (r53 != null) goto L117;
    L119:
        r1.endReplaceGroup();
        BasicTextKt.BasicText-RWo7tUw(r44, null, TextStyle.merge-dA7vx0o$default(r45, r46, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, TextAlign.Companion.getCenter-e0LSkKk(), 0, 0, null, null, 0, 0, null, null, 16744446, null), null, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, null, null, r1, (r4 & 14) | 1597440, 938);
        r1.startReplaceGroup(1253776295);
        if (r48 == true) goto L125;
        if (r53 == null) goto L125;
        if (r52 != UDButtonIconPlacement.End) goto L125;
        SpacerKt.Spacer(SizeKt.size-3ABfNKs(r110, Dp.constructor-impl(4)), r1, 6);
        r53.invoke(Color.box-impl(r46), r1, Integer.valueOf(((r4 >> 6) & 14) | ((r4 >> 18) & 112)));
    L125:
        r1.endReplaceGroup();
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L128;
        ComposerKt.traceEventEnd();
        goto L128
    L117:
        if (r52 != UDButtonIconPlacement.Start) goto L119;
        r53.invoke(Color.box-impl(r46), r1, Integer.valueOf(((r4 >> 6) & 14) | ((r4 >> 18) & 112)));
        SpacerKt.Spacer(SizeKt.size-3ABfNKs(r110, Dp.constructor-impl(4)), r1, 6);
        goto L119
    L112:
        if (Intrinsics.areEqual(r6.rememberedValue(), Integer.valueOf(r5)) == true) goto L114;
    L108:
        r1.useNode();
        goto L109
    L5:
        if (r1.changed(r44) == false) goto L7;
        int r22 = 4;
    L8:
        r4 = r22 | r55;
        goto L11
    L7:
        r22 = 2;
        goto L8
    }
}
