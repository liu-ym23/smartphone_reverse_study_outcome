package com.larksuite.component.universe_design.emptystate.compose;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.ClickableTextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import com.larksuite.component.universe_design.compose.foundation.i0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UDEmptyStateKt {
    public static final void a(final AnnotatedString r20, final TextStyle r21, final String r22, final Function1<? super String, Unit> r23, Composer r24, final int r25) {
        Composer r11 = r24.startRestartGroup(162035211);
        if ((r25 & 6) == 0) goto L5;
        int r1 = r25;
    L11:
        if ((r25 & 48) != 0) goto L18;
        if (r11.changed(r21) == false) goto L15;
        int r3 = 32;
    L16:
        r1 = r1 | r3;
        goto L18
    L15:
        r3 = 16;
    L18:
        if ((r25 & 384) != 0) goto L25;
        if (r11.changed(r22) == false) goto L22;
        int r4 = 256;
    L23:
        r1 = r1 | r4;
        goto L25
    L22:
        r4 = 128;
    L25:
        if ((r25 & 3072) != 0) goto L32;
        if (r11.changedInstance(r23) == false) goto L29;
        int r5 = 2048;
    L30:
        r1 = r1 | r5;
        goto L32
    L29:
        r5 = 1024;
    L32:
        if ((r1 & 1171) != 1170) goto L38;
        if (r11.getSkipping() == false) goto L38;
        r11.skipToGroupEnd();
    L71:
        ScopeUpdateScope r6 = r11.endRestartGroup();
        if (r6 == null) goto L76;
        r6.updateScope(new UDEmptyStateKt$EmptyDescription$3(r20, r21, r22, r23, r25));
        return;
    L76:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(162035211, r1, -1, "com.larksuite.component.universe_design.emptystate.compose.EmptyDescription (UDEmptyState.kt:321)");
    L40:
        r11.startReplaceGroup(1097020362);
        if (r23 != null) goto L49;
        BasicTextKt.BasicText-CL7eQgs(r20, null, r21, null, 0, false, 0, 0, null, null, null, r11, (r1 & 14) | ((r1 << 3) & 896), 0, 2042);
        r11.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L45;
        ComposerKt.traceEventEnd();
    L45:
        ScopeUpdateScope r7 = r11.endRestartGroup();
        if (r7 == null) goto L75;
        r7.updateScope(new UDEmptyStateKt$EmptyDescription$1(r20, r21, r22, r23, r25));
        return;
    L75:
        return;
    L49:
        r11.endReplaceGroup();
        r11.startReplaceGroup(-1746271574);
        int r0 = r1 & 14;
        boolean r10 = true;
        if (r0 != 4) goto L52;
        boolean r2 = true;
    L54:
        if ((r1 & 896) != 256) goto L56;
        boolean r8 = true;
    L57:
        boolean r9 = r2 | r8;
        if ((r1 & 7168) == 2048) goto L61;
        r10 = false;
    L61:
        boolean r12 = r9 | r10;
        Object r13 = r11.rememberedValue();
        if (r12 == false) goto L64;
    L67:
        r13 = new UDEmptyStateKt$EmptyDescription$2$1(r20, r22, r23);
        r11.updateRememberedValue(r13);
    L68:
        r11.endReplaceGroup();
        ClickableTextKt.ClickableText-4YKlhWE(r20, null, r21, false, 0, 0, null, (Function1) r13, r11, r0 | ((r1 << 3) & 896), 122);
        if (ComposerKt.isTraceInProgress() == false) goto L71;
        ComposerKt.traceEventEnd();
        goto L71
    L64:
        if (r13 != Composer.Companion.getEmpty()) goto L68;
    L56:
        r8 = false;
        goto L57
    L52:
        r2 = false;
        goto L54
    L5:
        if (r11.changed(r20) == false) goto L7;
        int r14 = 4;
    L8:
        r1 = r14 | r25;
        goto L11
    L7:
        r14 = 2;
        goto L8
    }

    public static final void b(final e r17, final float r19, final String r110, Modifier r20, Composer r21, final int r22, final int r23) {
        Composer r15 = r21.startRestartGroup(1391813021);
        if ((r23 & 1) == 0) goto L6;
        int r3 = r22 | 6;
    L14:
        if ((r23 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        if ((r23 & 4) == 0) goto L27;
        r3 = r3 | 384;
    L33:
        int r4 = r23 & 8;
        if (r4 == 0) goto L37;
        r3 = r3 | 3072;
    L43:
        Modifier r6 = r20;
    L45:
        if ((r3 & 1171) == 1170) goto L47;
    L50:
        if (r4 == 0) goto L52;
        Modifier r12 = Modifier.Companion;
    L54:
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventStart(1391813021, r3, -1, "com.larksuite.component.universe_design.emptystate.compose.EmptyImage (UDEmptyState.kt:289)");
    L56:
        Modifier r0 = SizeKt.requiredSize-3ABfNKs(r12, r19);
        r15.startReplaceGroup(1797491950);
        if (r110 == null) goto L68;
        Modifier.Companion r5 = Modifier.Companion;
        r15.startReplaceGroup(5004770);
        if ((r3 & 896) != 256) goto L61;
        boolean r7 = true;
    L62:
        Object r8 = r15.rememberedValue();
        if (r7 == false) goto L65;
    L66:
        r8 = new UDEmptyStateKt$EmptyImage$imageModifier$1$1(r110);
        r15.updateRememberedValue(r8);
    L67:
        r15.endReplaceGroup();
        Modifier r9 = SemanticsModifierKt.semantics$default(r5, false, (Function1) r8, 1, null);
    L69:
        r15.endReplaceGroup();
        Modifier r10 = r0.then(r9);
        if ((r17 instanceof e.a) == false) goto L73;
        r15.startReplaceGroup(1797500025);
        ImageKt.Image(((e.a) r17).a, r110, r10, null, ContentScale.Companion.getFit(), 0.0f, null, r15, ((r3 >> 3) & 112) | 24576, 104);
        r15.endReplaceGroup();
    L76:
        if (ComposerKt.isTraceInProgress() == false) goto L78;
        ComposerKt.traceEventEnd();
    L78:
        final Modifier r11 = r12;
    L79:
        ScopeUpdateScope r13 = r15.endRestartGroup();
        if (r13 == null) goto L85;
        r13.updateScope(new UDEmptyStateKt$EmptyImage$1(r17, r19, r110, r11, r22, r23));
        return;
    L85:
        return;
    L73:
        if ((r17 instanceof e.b) == false) goto L83;
        r15.startReplaceGroup(1797507489);
        ImageKt.Image(((e.b) r17).a, r110, r10, null, ContentScale.Companion.getFit(), 0.0f, null, r15, ((r3 >> 3) & 112) | 24576, 104);
        r15.endReplaceGroup();
        goto L76
    L83:
        r15.startReplaceGroup(1797498412);
        r15.endReplaceGroup();
        throw new NoWhenBranchMatchedException();
    L65:
        if (r8 != Composer.Companion.getEmpty()) goto L67;
    L61:
        r7 = false;
        goto L62
    L68:
        r9 = Modifier.Companion;
        goto L69
    L52:
        r12 = r6;
        goto L54
    L47:
        if (r15.getSkipping() == false) goto L50;
        r15.skipToGroupEnd();
        r11 = r6;
        goto L79
    L37:
        if ((r22 & 3072) != 0) goto L43;
        r6 = r20;
        if (r15.changed(r6) == false) goto L41;
        int r14 = 2048;
    L42:
        r3 = r3 | r14;
        goto L45
    L41:
        r14 = 1024;
        goto L42
    L27:
        if ((r22 & 384) != 0) goto L33;
        if (r15.changed(r110) == false) goto L31;
        int r16 = 256;
    L32:
        r3 = r3 | r16;
        goto L33
    L31:
        r16 = 128;
        goto L32
    L17:
        if ((r22 & 48) != 0) goto L24;
        if (r15.changed(r19) == false) goto L21;
        int r24 = 32;
    L22:
        r3 = r3 | r24;
        goto L24
    L21:
        r24 = 16;
        goto L22
    L6:
        if ((r22 & 6) == 0) goto L8;
        r3 = r22;
        goto L14
    L8:
        if (r15.changed(r17) == false) goto L10;
        int r25 = 4;
    L11:
        r3 = r25 | r22;
        goto L14
    L10:
        r25 = 2;
        goto L11
    }

    public static final void e(final Modifier r59, final e r60, final float r61, final String r62, final String r63, final AnnotatedString r64, final String r65, final Function1 r66, final b r67, final d r68, Composer r69, final int r70, final int r71) {
        Composer r10 = r69.startRestartGroup(-2019558011);
        if ((r70 & 6) == 0) goto L5;
        int r3 = r70;
    L11:
        if ((r70 & 48) == 0) goto L13;
    L17:
        int r16 = 128;
        if ((r70 & 384) != 0) goto L26;
        if (r10.changed(r61) == false) goto L22;
        int r19 = 256;
    L23:
        r3 = r3 | r19;
        goto L26
    L22:
        r19 = 128;
    L26:
        if ((r70 & 3072) != 0) goto L34;
        if (r10.changed(r62) == false) goto L30;
        int r110 = 2048;
    L31:
        r3 = r3 | r110;
        goto L34
    L30:
        r110 = 1024;
    L34:
        if ((r70 & 24576) != 0) goto L41;
        if (r10.changed(r63) == false) goto L38;
        int r7 = 16384;
    L39:
        r3 = r3 | r7;
        goto L41
    L38:
        r7 = 8192;
    L41:
        if ((196608 & r70) != 0) goto L48;
        if (r10.changed(r64) == false) goto L45;
        int r8 = 131072;
    L46:
        r3 = r3 | r8;
        goto L48
    L45:
        r8 = 65536;
    L48:
        if ((1572864 & r70) != 0) goto L56;
        if (r10.changed(r65) == false) goto L52;
        int r111 = 1048576;
    L53:
        r3 = r3 | r111;
        goto L56
    L52:
        r111 = 524288;
    L56:
        if ((r70 & 12582912) != 0) goto L63;
        if (r10.changedInstance(r66) == false) goto L60;
        int r112 = 8388608;
    L61:
        r3 = r3 | r112;
        goto L63
    L60:
        r112 = 4194304;
    L63:
        if ((r70 & 100663296) != 0) goto L70;
        if (r10.changed(null) == false) goto L67;
        int r113 = 67108864;
    L68:
        r3 = r3 | r113;
        goto L70
    L67:
        r113 = 33554432;
    L70:
        if ((r70 & 805306368) != 0) goto L77;
        if (r10.changed(null) == false) goto L74;
        int r114 = 536870912;
    L75:
        r3 = r3 | r114;
        goto L77
    L74:
        r114 = 268435456;
    L77:
        if ((r71 & 6) == 0) goto L79;
        int r115 = r71;
    L85:
        if ((r71 & 48) != 0) goto L92;
        if (r10.changed(r67) == false) goto L89;
        int r116 = 32;
    L90:
        r115 = r115 | r116;
        goto L92
    L89:
        r116 = 16;
    L92:
        if ((r71 & 384) == 0) goto L94;
    L97:
        int r5 = r115;
        if ((r3 & 306783379) != 306783378) goto L106;
        if ((r5 & 147) != 146) goto L106;
        if (r10.getSkipping() == false) goto L106;
        r10.skipToGroupEnd();
        Composer r9 = r10;
    L144:
        ScopeUpdateScope r15 = r9.endRestartGroup();
        if (r15 == null) goto L148;
        final a r11 = null;
        final a r12 = null;
        final a r13 = null;
        r15.updateScope(new UDEmptyStateKt$UDEmptyStateContent$2(r59, r60, r61, r62, r63, r64, r65, r66, r11, r12, r13, r67, r68, r70, r71));
        return;
    L148:
        return;
    L106:
        if (ComposerKt.isTraceInProgress() == false) goto L108;
        ComposerKt.traceEventStart(-2019558011, r3, r5, "com.larksuite.component.universe_design.emptystate.compose.UDEmptyStateContent (UDEmptyState.kt:215)");
    L108:
        Modifier r1 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxSize$default(r59, 0.0f, 1, null), r68.a, 0.0f, 2, null);
        Alignment.Horizontal r2 = Alignment.Companion.getCenterHorizontally();
        MeasurePolicy r4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getCenter(), r2, r10, 54);
        long r6 = ComposablesKt.getCurrentCompositeKeyHashCode(r10, 0);
        int r14 = (int) (r6 ^ (r6 >>> 32));
        CompositionLocalMap r17 = r10.getCurrentCompositionLocalMap();
        Modifier r20 = ComposedModifierKt.materializeModifier(r10, r1);
        ComposeUiNode.Companion r117 = ComposeUiNode.Companion;
        Function0 r21 = r117.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L111;
        ComposablesKt.invalidApplier();
    L111:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L114;
        r10.createNode(r21);
    L115:
        Composer r22 = Updater.constructor-impl(r10);
        Updater.set-impl(r22, r4, r117.getSetMeasurePolicy());
        Updater.set-impl(r22, r17, r117.getSetResolvedCompositionLocals());
        Function2 r23 = r117.getSetCompositeKeyHash();
        if (r22.getInserting() == false) goto L118;
    L119:
        r22.updateRememberedValue(Integer.valueOf(r14));
        r22.apply(Integer.valueOf(r14), r23);
    L120:
        Updater.set-impl(r22, r20, r117.getSetModifier());
        ColumnScopeInstance r24 = ColumnScopeInstance.INSTANCE;
        r10.startReplaceGroup(338656741);
        if (r60 == null) goto L123;
        Modifier r25 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, r68.b, 7, null);
        int r26 = r3 >> 3;
        int r27 = (r26 & 14) | (r26 & 112);
        boolean r29 = false;
        b(r60, r61, r62, r25, r10, (r26 & 896) | r27, 0);
    L124:
        r10.endReplaceGroup();
        r10.startReplaceGroup(338666010);
        if (r63 != null) goto L127;
    L130:
        boolean r30 = true;
    L131:
        if (r30 == true) goto L133;
        r9 = r10;
        BasicTextKt.BasicText-RWo7tUw(r63, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, r68.c, 7, null), TextStyle.merge-dA7vx0o$default(i0.b(r10).b, r67.a, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, TextAlign.Companion.getCenter-e0LSkKk(), 0, 0, null, null, 0, 0, null, null, 16744446, null), null, 0, false, 0, 0, null, null, r9, (r3 >> 12) & 14, 1016);
    L134:
        r9.endReplaceGroup();
        r9.startReplaceGroup(338677979);
        if (r64 != null) goto L137;
    L141:
        r9.endReplaceGroup();
        r9.startReplaceGroup(338692392);
        r9.endReplaceGroup();
        r9.startReplaceGroup(338719845);
        r9.endReplaceGroup();
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L144;
        ComposerKt.traceEventEnd();
        goto L144
    L137:
        if (r64.length() <= 0) goto L139;
        r29 = true;
    L139:
        if (r29 == false) goto L141;
        int r31 = r3 >> 12;
        Composer r32 = r9;
        a(r64, TextStyle.merge-dA7vx0o$default(i0.b(r9).d, r67.b, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, TextAlign.Companion.getCenter-e0LSkKk(), 0, 0, null, null, 0, 0, null, null, 16744446, null), r65, r66, r32, (((r3 >> 15) & 14) | (r31 & 896)) | (r31 & 7168));
        goto L141
    L133:
        r9 = r10;
        goto L134
    L127:
        if (r63.length() == 0) goto L130;
        r30 = false;
        goto L131
    L123:
        r29 = false;
        goto L124
    L118:
        if (Intrinsics.areEqual(r22.rememberedValue(), Integer.valueOf(r14)) == true) goto L120;
    L114:
        r10.useNode();
        goto L115
    L94:
        if (r10.changed(r68) == false) goto L96;
        r16 = 256;
    L96:
        r115 = r115 | r16;
        goto L97
    L79:
        if (r10.changed(null) == false) goto L81;
        int r118 = 4;
    L82:
        r115 = r71 | r118;
        goto L85
    L81:
        r118 = 2;
        goto L82
    L13:
        if (r10.changed(r60) == false) goto L15;
        int r33 = 32;
    L16:
        r3 = r3 | r33;
        goto L17
    L15:
        r33 = 16;
        goto L16
    L5:
        if (r10.changed(r59) == false) goto L7;
        int r34 = 4;
    L8:
        r3 = r34 | r70;
        goto L11
    L7:
        r34 = 2;
        goto L8
    }

    public static final void c(final Painter r30, Modifier r31, float r32, String r33, String r34, AnnotatedString r35, String r36, Function1 r37, b r38, d r39, Composer r40, final int r41, final int r42, final int r43) {
        Composer r2 = r40.startRestartGroup(-1289528575);
        if ((r43 & 1) == 0) goto L6;
        int r3 = r41 | 6;
    L13:
        int r6 = r43 & 2;
        if (r6 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r9 = r31;
    L24:
        int r10 = r43 & 4;
        if (r10 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r16 = r43 & 8;
        if (r16 == 0) goto L39;
        r3 = r3 | 3072;
    L46:
        int r19 = r43 & 16;
        if (r19 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        String r7 = r34;
    L57:
        int r20 = r43 & 32;
        if (r20 == 0) goto L60;
        r3 = r3 | 196608;
        AnnotatedString r8 = r35;
    L67:
        int r22 = r43 & 64;
        if (r22 == 0) goto L70;
        r3 = r3 | 1572864;
        String r11 = r36;
    L77:
        int r12 = r43 & 128;
        if (r12 == 0) goto L81;
        r3 = r3 | 12582912;
    L88:
        if ((r43 & 256) == 0) goto L91;
        r3 = r3 | 100663296;
    L98:
        if ((r43 & 512) == 0) goto L101;
        r3 = r3 | 805306368;
    L108:
        if ((r43 & 1024) == 0) goto L111;
        int r0 = r42 | 6;
    L119:
        if ((r42 & 48) != 0) goto L130;
        if ((r43 & 2048) != 0) goto L126;
        if (r2.changed(r38) == false) goto L126;
        int r110 = 32;
    L127:
        r0 = r0 | r110;
    L126:
        r110 = 16;
    L130:
        if ((r42 & 384) != 0) goto L141;
        if ((r43 & 4096) != 0) goto L137;
        if (r2.changed(r39) == false) goto L137;
        int r23 = 256;
    L138:
        r0 = r0 | r23;
    L137:
        r23 = 128;
    L141:
        if ((r3 & 306783379) == 306783378) goto L143;
    L148:
        r2.startDefaults();
        if ((r41 & 1) != 0) goto L151;
    L160:
        if (r6 == 0) goto L162;
        Modifier r4 = Modifier.Companion;
    L163:
        if (r10 == 0) goto L165;
        float r5 = c.a;
    L166:
        if (r16 == 0) goto L168;
        String r13 = null;
    L169:
        if (r19 == 0) goto L171;
        r7 = null;
    L171:
        if (r20 == 0) goto L173;
        r8 = null;
    L173:
        if (r22 == 0) goto L175;
        String r14 = "ud_empty_description_action";
    L176:
        if (r12 == 0) goto L178;
        Function1 r15 = null;
    L180:
        if ((r43 & 2048) == 0) goto L182;
        b r17 = c.a(r2);
        r0 = r0 & (-113);
    L184:
        if ((r43 & 4096) == 0) goto L186;
        d r111 = c.b(r2);
        r0 = r0 & (-897);
    L187:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L190;
        ComposerKt.traceEventStart(-1289528575, r3, r0, "com.larksuite.component.universe_design.emptystate.compose.UDEmptyState (UDEmptyState.kt:61)");
    L190:
        if (r30 == null) goto L192;
        e.a r112 = new e.a(r30);
    L193:
        Modifier r113 = r4;
        float r114 = r5;
        String r115 = r13;
        String r21 = r7;
        AnnotatedString r24 = r8;
        String r25 = r14;
        Function1 r26 = r15;
        b r27 = r17;
        d r29 = r111;
        e(r113, r112, r114, r115, r21, r24, r25, r26, r27, r29, r2, (((((((((r3 >> 3) & 14) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | (3670016 & r3)) | (29360128 & r3)) | (234881024 & r3)) | (r3 & 1879048192), ((r0 & 14) | (r0 & 112)) | (r0 & 896));
        if (ComposerKt.isTraceInProgress() == false) goto L196;
        ComposerKt.traceEventEnd();
    L196:
        final float r44 = r5;
        final String r45 = r7;
        final String r46 = r14;
        final d r116 = r111;
        final b r117 = r17;
    L197:
        final a r118 = null;
        final a r47 = null;
        final a r119 = null;
        ScopeUpdateScope r48 = r2.endRestartGroup();
        if (r48 == null) goto L201;
        final Modifier r49 = r4;
        final String r50 = r13;
        final AnnotatedString r51 = r8;
        final Function1 r52 = r15;
        r48.updateScope(new UDEmptyStateKt$UDEmptyState$2(r30, r49, r44, r50, r45, r51, r46, r52, r47, r118, r119, r117, r116, r41, r42, r43));
        return;
    L201:
        return;
    L192:
        r112 = null;
        goto L193
    L186:
        r111 = r39;
        goto L187
    L182:
        r17 = r38;
        goto L184
    L178:
        r15 = r37;
        goto L180
    L175:
        r14 = r11;
        goto L176
    L168:
        r13 = r33;
        goto L169
    L165:
        r5 = r32;
        goto L166
    L162:
        r4 = r9;
        goto L163
    L151:
        if (r2.getDefaultsInvalid() == true) goto L160;
        r2.skipToGroupEnd();
        if ((r43 & 2048) == 0) goto L157;
        r0 = r0 & (-113);
    L157:
        if ((r43 & 4096) == 0) goto L159;
        r0 = r0 & (-897);
    L159:
        r5 = r32;
        r13 = r33;
        r15 = r37;
        r111 = r39;
        r4 = r9;
        r14 = r11;
        r17 = r38;
        goto L187
    L143:
        if ((r0 & 147) != 146) goto L148;
        if (r2.getSkipping() == false) goto L148;
        r2.skipToGroupEnd();
        r44 = r32;
        r13 = r33;
        r15 = r37;
        r117 = r38;
        r116 = r39;
        r45 = r7;
        r4 = r9;
        r46 = r11;
        goto L197
    L111:
        if ((r42 & 6) == 0) goto L113;
        r0 = r42;
        goto L119
    L113:
        if (r2.changed(null) == false) goto L115;
        int r120 = 4;
    L116:
        r0 = r42 | r120;
        goto L119
    L115:
        r120 = 2;
        goto L116
    L101:
        if ((r41 & 805306368) != 0) goto L108;
        if (r2.changed(null) == false) goto L105;
        int r1 = 536870912;
    L106:
        r3 = r3 | r1;
        goto L108
    L105:
        r1 = 268435456;
        goto L106
    L91:
        if ((r41 & 100663296) != 0) goto L98;
        if (r2.changed(null) == false) goto L95;
        int r53 = 67108864;
    L96:
        r3 = r3 | r53;
        goto L98
    L95:
        r53 = 33554432;
        goto L96
    L81:
        if ((r41 & 12582912) != 0) goto L88;
        if (r2.changedInstance(r37) == false) goto L85;
        int r210 = 8388608;
    L86:
        r3 = r3 | r210;
        goto L88
    L85:
        r210 = 4194304;
        goto L86
    L70:
        r11 = r36;
        if ((r41 & 1572864) != 0) goto L77;
        if (r2.changed(r11) == false) goto L75;
        int r211 = 1048576;
    L76:
        r3 = r3 | r211;
        goto L77
    L75:
        r211 = 524288;
        goto L76
    L60:
        r8 = r35;
        if ((r41 & 196608) != 0) goto L67;
        if (r2.changed(r8) == false) goto L65;
        int r212 = 131072;
    L66:
        r3 = r3 | r212;
        goto L67
    L65:
        r212 = 65536;
        goto L66
    L50:
        if ((r41 & 24576) != 0) goto L56;
        r7 = r34;
        if (r2.changed(r7) == false) goto L54;
        int r213 = 16384;
    L55:
        r3 = r3 | r213;
        goto L57
    L54:
        r213 = 8192;
        goto L55
    L39:
        if ((r41 & 3072) != 0) goto L46;
        if (r2.changed(r33) == false) goto L43;
        int r121 = 2048;
    L44:
        r3 = r3 | r121;
        goto L46
    L43:
        r121 = 1024;
        goto L44
    L28:
        if ((r41 & 384) != 0) goto L35;
        if (r2.changed(r32) == false) goto L32;
        int r122 = 256;
    L33:
        r3 = r3 | r122;
        goto L35
    L32:
        r122 = 128;
        goto L33
    L17:
        if ((r41 & 48) != 0) goto L23;
        r9 = r31;
        if (r2.changed(r9) == false) goto L21;
        int r123 = 32;
    L22:
        r3 = r3 | r123;
        goto L24
    L21:
        r123 = 16;
        goto L22
    L6:
        if ((r41 & 6) == 0) goto L8;
        r3 = r41;
        goto L13
    L8:
        if (r2.changedInstance(r30) == false) goto L10;
        int r54 = 4;
    L11:
        r3 = r54 | r41;
        goto L13
    L10:
        r54 = 2;
        goto L11
    }

    public static final void d(final ImageVector r30, Modifier r31, float r32, String r33, String r34, AnnotatedString r35, String r36, Function1 r37, b r38, d r39, Composer r40, final int r41, final int r42, final int r43) {
        Composer r2 = r40.startRestartGroup(-648355538);
        if ((r43 & 1) == 0) goto L6;
        int r3 = r41 | 6;
    L13:
        int r6 = r43 & 2;
        if (r6 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r9 = r31;
    L24:
        int r10 = r43 & 4;
        if (r10 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r16 = r43 & 8;
        if (r16 == 0) goto L39;
        r3 = r3 | 3072;
    L46:
        int r19 = r43 & 16;
        if (r19 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        String r7 = r34;
    L57:
        int r20 = r43 & 32;
        if (r20 == 0) goto L60;
        r3 = r3 | 196608;
        AnnotatedString r8 = r35;
    L67:
        int r22 = r43 & 64;
        if (r22 == 0) goto L70;
        r3 = r3 | 1572864;
        String r11 = r36;
    L77:
        int r12 = r43 & 128;
        if (r12 == 0) goto L81;
        r3 = r3 | 12582912;
    L88:
        if ((r43 & 256) == 0) goto L91;
        r3 = r3 | 100663296;
    L98:
        if ((r43 & 512) == 0) goto L101;
        r3 = r3 | 805306368;
    L108:
        if ((r43 & 1024) == 0) goto L111;
        int r0 = r42 | 6;
    L119:
        if ((r42 & 48) != 0) goto L130;
        if ((r43 & 2048) != 0) goto L126;
        if (r2.changed(r38) == false) goto L126;
        int r110 = 32;
    L127:
        r0 = r0 | r110;
    L126:
        r110 = 16;
    L130:
        if ((r42 & 384) != 0) goto L141;
        if ((r43 & 4096) != 0) goto L137;
        if (r2.changed(r39) == false) goto L137;
        int r23 = 256;
    L138:
        r0 = r0 | r23;
    L137:
        r23 = 128;
    L141:
        if ((r3 & 306783379) == 306783378) goto L143;
    L148:
        r2.startDefaults();
        if ((r41 & 1) != 0) goto L151;
    L160:
        if (r6 == 0) goto L162;
        Modifier r4 = Modifier.Companion;
    L163:
        if (r10 == 0) goto L165;
        float r5 = c.a;
    L166:
        if (r16 == 0) goto L168;
        String r13 = null;
    L169:
        if (r19 == 0) goto L171;
        r7 = null;
    L171:
        if (r20 == 0) goto L173;
        r8 = null;
    L173:
        if (r22 == 0) goto L175;
        String r14 = "ud_empty_description_action";
    L176:
        if (r12 == 0) goto L178;
        Function1 r15 = null;
    L180:
        if ((r43 & 2048) == 0) goto L182;
        b r17 = c.a(r2);
        r0 = r0 & (-113);
    L184:
        if ((r43 & 4096) == 0) goto L186;
        d r111 = c.b(r2);
        r0 = r0 & (-897);
    L187:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L190;
        ComposerKt.traceEventStart(-648355538, r3, r0, "com.larksuite.component.universe_design.emptystate.compose.UDEmptyState (UDEmptyState.kt:94)");
    L190:
        if (r30 == null) goto L192;
        e.b r112 = new e.b(r30);
    L193:
        Modifier r113 = r4;
        float r114 = r5;
        String r115 = r13;
        String r21 = r7;
        AnnotatedString r24 = r8;
        String r25 = r14;
        Function1 r26 = r15;
        b r27 = r17;
        d r29 = r111;
        e(r113, r112, r114, r115, r21, r24, r25, r26, r27, r29, r2, (((((((((r3 >> 3) & 14) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | (3670016 & r3)) | (29360128 & r3)) | (234881024 & r3)) | (r3 & 1879048192), ((r0 & 14) | (r0 & 112)) | (r0 & 896));
        if (ComposerKt.isTraceInProgress() == false) goto L196;
        ComposerKt.traceEventEnd();
    L196:
        final float r44 = r5;
        final String r45 = r7;
        final String r46 = r14;
        final d r116 = r111;
        final b r117 = r17;
    L197:
        final a r118 = null;
        final a r47 = null;
        final a r119 = null;
        ScopeUpdateScope r48 = r2.endRestartGroup();
        if (r48 == null) goto L201;
        final Modifier r49 = r4;
        final String r50 = r13;
        final AnnotatedString r51 = r8;
        final Function1 r52 = r15;
        r48.updateScope(new UDEmptyStateKt$UDEmptyState$4(r30, r49, r44, r50, r45, r51, r46, r52, r47, r118, r119, r117, r116, r41, r42, r43));
        return;
    L201:
        return;
    L192:
        r112 = null;
        goto L193
    L186:
        r111 = r39;
        goto L187
    L182:
        r17 = r38;
        goto L184
    L178:
        r15 = r37;
        goto L180
    L175:
        r14 = r11;
        goto L176
    L168:
        r13 = r33;
        goto L169
    L165:
        r5 = r32;
        goto L166
    L162:
        r4 = r9;
        goto L163
    L151:
        if (r2.getDefaultsInvalid() == true) goto L160;
        r2.skipToGroupEnd();
        if ((r43 & 2048) == 0) goto L157;
        r0 = r0 & (-113);
    L157:
        if ((r43 & 4096) == 0) goto L159;
        r0 = r0 & (-897);
    L159:
        r5 = r32;
        r13 = r33;
        r15 = r37;
        r111 = r39;
        r4 = r9;
        r14 = r11;
        r17 = r38;
        goto L187
    L143:
        if ((r0 & 147) != 146) goto L148;
        if (r2.getSkipping() == false) goto L148;
        r2.skipToGroupEnd();
        r44 = r32;
        r13 = r33;
        r15 = r37;
        r117 = r38;
        r116 = r39;
        r45 = r7;
        r4 = r9;
        r46 = r11;
        goto L197
    L111:
        if ((r42 & 6) == 0) goto L113;
        r0 = r42;
        goto L119
    L113:
        if (r2.changed(null) == false) goto L115;
        int r120 = 4;
    L116:
        r0 = r42 | r120;
        goto L119
    L115:
        r120 = 2;
        goto L116
    L101:
        if ((r41 & 805306368) != 0) goto L108;
        if (r2.changed(null) == false) goto L105;
        int r1 = 536870912;
    L106:
        r3 = r3 | r1;
        goto L108
    L105:
        r1 = 268435456;
        goto L106
    L91:
        if ((r41 & 100663296) != 0) goto L98;
        if (r2.changed(null) == false) goto L95;
        int r53 = 67108864;
    L96:
        r3 = r3 | r53;
        goto L98
    L95:
        r53 = 33554432;
        goto L96
    L81:
        if ((r41 & 12582912) != 0) goto L88;
        if (r2.changedInstance(r37) == false) goto L85;
        int r210 = 8388608;
    L86:
        r3 = r3 | r210;
        goto L88
    L85:
        r210 = 4194304;
        goto L86
    L70:
        r11 = r36;
        if ((r41 & 1572864) != 0) goto L77;
        if (r2.changed(r11) == false) goto L75;
        int r211 = 1048576;
    L76:
        r3 = r3 | r211;
        goto L77
    L75:
        r211 = 524288;
        goto L76
    L60:
        r8 = r35;
        if ((r41 & 196608) != 0) goto L67;
        if (r2.changed(r8) == false) goto L65;
        int r212 = 131072;
    L66:
        r3 = r3 | r212;
        goto L67
    L65:
        r212 = 65536;
        goto L66
    L50:
        if ((r41 & 24576) != 0) goto L56;
        r7 = r34;
        if (r2.changed(r7) == false) goto L54;
        int r213 = 16384;
    L55:
        r3 = r3 | r213;
        goto L57
    L54:
        r213 = 8192;
        goto L55
    L39:
        if ((r41 & 3072) != 0) goto L46;
        if (r2.changed(r33) == false) goto L43;
        int r121 = 2048;
    L44:
        r3 = r3 | r121;
        goto L46
    L43:
        r121 = 1024;
        goto L44
    L28:
        if ((r41 & 384) != 0) goto L35;
        if (r2.changed(r32) == false) goto L32;
        int r122 = 256;
    L33:
        r3 = r3 | r122;
        goto L35
    L32:
        r122 = 128;
        goto L33
    L17:
        if ((r41 & 48) != 0) goto L23;
        r9 = r31;
        if (r2.changed(r9) == false) goto L21;
        int r123 = 32;
    L22:
        r3 = r3 | r123;
        goto L24
    L21:
        r123 = 16;
        goto L22
    L6:
        if ((r41 & 6) == 0) goto L8;
        r3 = r41;
        goto L13
    L8:
        if (r2.changed(r30) == false) goto L10;
        int r54 = 4;
    L11:
        r3 = r54 | r41;
        goto L13
    L10:
        r54 = 2;
        goto L11
    }
}
