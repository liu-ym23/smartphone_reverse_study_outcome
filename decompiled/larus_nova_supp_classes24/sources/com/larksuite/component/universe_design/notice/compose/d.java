package com.larksuite.component.universe_design.notice.compose;

import androidx.compose.foundation.BasicMarqueeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.ClickableTextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.larksuite.component.ui.toast.LKUIToast;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public static final float a = 0.0f;
    public static final float b = 0.0f;
    public static final float c = 0.0f;
    public static final float d = 0.0f;
    public static final float e = 0.0f;
    public static final float f = 0.0f;
    public static final float g = 0.0f;
    public static final float h = 0.0f;
    public static final float i = 0.0f;

    static {
        float r0 = 44;
        a = Dp.constructor-impl(r0);
        float r1 = 16;
        b = Dp.constructor-impl(r1);
        c = Dp.constructor-impl(r1);
        d = Dp.constructor-impl(r0);
        float r2 = 12;
        e = Dp.constructor-impl(r2);
        f = Dp.constructor-impl(r2);
        g = Dp.constructor-impl(14);
        h = Dp.constructor-impl(8);
        i = Dp.constructor-impl(r1);
        Dp.constructor-impl(4);
    }

    public static final void b(final ImageVector r22, final Painter r23, final long r24, final boolean r26, Composer r27, final int r29) {
        Composer r14 = r27.startRestartGroup(1632102512);
        if ((r29 & 6) == 0) goto L5;
        int r1 = r29;
    L11:
        if ((r29 & 48) != 0) goto L18;
        if (r14.changedInstance(r23) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r29 & 384) != 0) goto L25;
        if (r14.changed(r24) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r29 & 3072) != 0) goto L32;
        if (r14.changed(r26) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r1 & 1171) != 1170) goto L38;
        if (r14.getSkipping() == false) goto L38;
        r14.skipToGroupEnd();
    L53:
        ScopeUpdateScope r7 = r14.endRestartGroup();
        if (r7 == null) goto L57;
        r7.updateScope(new UDNoticeKt$NoticeIcon$1(r22, r23, r24, r26, r29));
        return;
    L57:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(1632102512, r1, -1, "com.larksuite.component.universe_design.notice.compose.NoticeIcon (UDNotice.kt:381)");
    L40:
        Modifier r5 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, g, 0.0f, 0.0f, 13, null), c);
        if (r26 == false) goto L43;
        ColorFilter r0 = null;
    L44:
        ColorFilter r6 = r0;
        if (r23 == null) goto L47;
        r14.startReplaceGroup(-1358508155);
        ImageKt.Image(r23, null, r5, null, null, 0.0f, r6, r14, ((r1 >> 3) & 14) | 432, 56);
        r14.endReplaceGroup();
    L51:
        if (ComposerKt.isTraceInProgress() == false) goto L53;
        ComposerKt.traceEventEnd();
        goto L53
    L47:
        if (r22 == null) goto L49;
        r14.startReplaceGroup(-1358312700);
        ImageKt.Image(r22, null, r5, null, null, 0.0f, r6, r14, (r1 & 14) | 432, 56);
        r14.endReplaceGroup();
        goto L51
    L49:
        r14.startReplaceGroup(-1358145486);
        r14.endReplaceGroup();
        goto L51
    L43:
        r0 = ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, r24, 0, 2, null);
        goto L44
    L5:
        if (r14.changed(r22) == false) goto L7;
        int r8 = 4;
    L8:
        r1 = r8 | r29;
        goto L11
    L7:
        r8 = 2;
        goto L8
    }

    public static final void c(final ImageVector r29, final Painter r210, final long r30, final String r32, final Function0 r33, Composer r34, final int r35) {
        Composer r15 = r34.startRestartGroup(-692062709);
        if ((r35 & 6) == 0) goto L5;
        int r1 = r35;
    L11:
        if ((r35 & 48) != 0) goto L18;
        if (r15.changedInstance(r210) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r35 & 384) != 0) goto L25;
        if (r15.changed(r30) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r35 & 3072) != 0) goto L32;
        if (r15.changed(r32) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r35 & 24576) == 0) goto L34;
    L38:
        int r5 = r1;
        if ((r5 & 9363) != 9362) goto L45;
        if (r15.getSkipping() == false) goto L45;
        r15.skipToGroupEnd();
    L91:
        ScopeUpdateScope r8 = r15.endRestartGroup();
        if (r8 == null) goto L95;
        r8.updateScope(new UDNoticeKt$NoticeIconButton$2(r29, r210, r30, r32, r33, r35));
        return;
    L95:
        return;
    L45:
        if (ComposerKt.isTraceInProgress() == false) goto L47;
        ComposerKt.traceEventStart(-692062709, r5, -1, "com.larksuite.component.universe_design.notice.compose.NoticeIconButton (UDNotice.kt:410)");
    L47:
        Modifier r6 = Modifier.Companion;
        float r0 = c;
        Modifier r7 = SizeKt.defaultMinSize-VpY3zN4$default(SizeKt.width-3ABfNKs(r6, r0), 0.0f, a, 1, null);
        MeasurePolicy r9 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        long r16 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r10 = (int) (r16 ^ (r16 >>> 32));
        CompositionLocalMap r11 = r15.getCurrentCompositionLocalMap();
        Modifier r12 = ComposedModifierKt.materializeModifier(r15, r7);
        ComposeUiNode.Companion r17 = ComposeUiNode.Companion;
        Function0 r13 = r17.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L50;
        ComposablesKt.invalidApplier();
    L50:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L53;
        r15.createNode(r13);
    L54:
        Composer r14 = Updater.constructor-impl(r15);
        Updater.set-impl(r14, r9, r17.getSetMeasurePolicy());
        Updater.set-impl(r14, r11, r17.getSetResolvedCompositionLocals());
        Function2 r19 = r17.getSetCompositeKeyHash();
        if (r14.getInserting() == false) goto L57;
    L58:
        r14.updateRememberedValue(Integer.valueOf(r10));
        r14.apply(Integer.valueOf(r10), r19);
    L59:
        Updater.set-impl(r14, r12, r17.getSetModifier());
        BoxScopeInstance r20 = BoxScopeInstance.INSTANCE;
        if (r210 == null) goto L62;
        r15.startReplaceGroup(1456793433);
        ColorFilter r21 = ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, r30, 0, 2, null);
        Modifier r110 = r6;
        ImageKt.Image(r210, null, SizeKt.size-3ABfNKs(r6, r0), null, null, 0.0f, r21, r15, ((r5 >> 3) & 14) | 432, 56);
        r15.endReplaceGroup();
        int r111 = r5;
    L66:
        Modifier r22 = SizeKt.requiredSize-3ABfNKs(r110, d);
        r15.startReplaceGroup(5004770);
        if ((r111 & 7168) != 2048) goto L69;
        boolean r23 = true;
    L70:
        Object r24 = r15.rememberedValue();
        if (r23 == false) goto L73;
    L74:
        r24 = new UDNoticeKt$NoticeIconButton$1$1$1(r32);
        r15.updateRememberedValue(r24);
    L75:
        r15.endReplaceGroup();
        Modifier r25 = SemanticsModifierKt.semantics$default(r22, false, (Function1) r24, 1, null);
        if (r33 == null) goto L78;
        boolean r26 = true;
    L79:
        Role r27 = Role.box-impl(Role.Companion.getButton-o7Vup1c());
        r15.startReplaceGroup(5004770);
        if ((57344 & r111) != 16384) goto L82;
        boolean r31 = true;
    L83:
        Object r36 = r15.rememberedValue();
        if (r31 == false) goto L86;
    L87:
        r36 = new UDNoticeKt$NoticeIconButton$1$2$1(r33);
        r15.updateRememberedValue(r36);
    L88:
        r15.endReplaceGroup();
        BoxKt.Box(ClickableKt.clickable-oSLSa3U$default(r25, r26, null, r27, null, (Function0) r36, 10, null), r15, 0);
        r15.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L91;
        ComposerKt.traceEventEnd();
        goto L91
    L86:
        if (r36 != Composer.Companion.getEmpty()) goto L88;
    L82:
        r31 = false;
        goto L83
    L78:
        r26 = false;
        goto L79
    L73:
        if (r24 != Composer.Companion.getEmpty()) goto L75;
    L69:
        r23 = false;
        goto L70
    L62:
        r110 = r6;
        if (r29 == null) goto L65;
        r15.startReplaceGroup(1457043448);
        ColorFilter r37 = ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, r30, 0, 2, null);
        r111 = r5;
        ImageKt.Image(r29, null, SizeKt.size-3ABfNKs(r110, r0), null, null, 0.0f, r37, r15, (r5 & 14) | 432, 56);
        r15.endReplaceGroup();
        goto L66
    L65:
        r111 = r5;
        r15.startReplaceGroup(1457263517);
        r15.endReplaceGroup();
        goto L66
    L57:
        if (Intrinsics.areEqual(r14.rememberedValue(), Integer.valueOf(r10)) == true) goto L59;
    L53:
        r15.useNode();
        goto L54
    L34:
        if (r15.changedInstance(r33) == false) goto L36;
        int r38 = 16384;
    L37:
        r1 = r1 | r38;
        goto L38
    L36:
        r38 = 8192;
        goto L37
    L5:
        if (r15.changed(r29) == false) goto L7;
        int r39 = 4;
    L8:
        r1 = r39 | r35;
        goto L11
    L7:
        r39 = 2;
        goto L8
    }

    public static final void d(final AnnotatedString r48, final long r49, final TextStyle r51, final int r52, final boolean r53, final Function1 r54, final Function1 r55, Modifier r56, Composer r57, final int r59, final int r510) {
        Composer r10 = r57.startRestartGroup(-1327779335);
        if ((r510 & 1) == 0) goto L6;
        int r1 = r59 | 6;
    L14:
        if ((r510 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r510 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r510 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        if ((r510 & 16) == 0) goto L47;
        r1 = r1 | 24576;
    L54:
        if ((r510 & 32) == 0) goto L57;
        r1 = r1 | 196608;
    L64:
        if ((r510 & 64) == 0) goto L67;
        r1 = r1 | 1572864;
    L73:
        int r3 = r510 & 128;
        if (r3 == 0) goto L76;
        r1 = r1 | 12582912;
        Modifier r4 = r56;
    L84:
        if ((r1 & 4793491) == 4793490) goto L86;
    L89:
        if (r3 == 0) goto L92;
        r4 = Modifier.Companion;
    L92:
        if (ComposerKt.isTraceInProgress() == false) goto L94;
        ComposerKt.traceEventStart(-1327779335, r1, -1, "com.larksuite.component.universe_design.notice.compose.NoticeText (UDNotice.kt:331)");
    L94:
        if (r53 == false) goto L96;
        Modifier r0 = BasicMarqueeKt.basicMarquee-1Mj1MLw$default(Modifier.Companion, 0, 0, 0, 0, null, 0.0f, 63, null);
    L97:
        Modifier r2 = r4.then(r0);
        TextStyle r5 = TextStyle.merge-dA7vx0o$default(r51, r49, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, r52, 0, 0, null, null, 0, 0, null, null, 16744446, null);
        if (r53 == false) goto L100;
        int r16 = 1;
    L101:
        int r17 = TextOverflow.Companion.getClip-gIe3tQ8();
        r10.startReplaceGroup(-1633490746);
        int r6 = r1 & 14;
        boolean r19 = false;
        Modifier r20 = r4;
        if (r6 != 4) goto L104;
        boolean r7 = true;
    L106:
        if ((r1 & 3670016) != 1048576) goto L108;
        r19 = true;
    L108:
        boolean r8 = r7 | r19;
        Object r9 = r10.rememberedValue();
        if (r8 == false) goto L111;
    L112:
        r9 = new UDNoticeKt$NoticeText$1$1(r48, r55);
        r10.updateRememberedValue(r9);
    L113:
        r10.endReplaceGroup();
        int r11 = r16;
        ClickableTextKt.ClickableText-4YKlhWE(r48, r2, r5, false, r17, r11, r54, (Function1) r9, r10, r6 | ((r1 << 3) & 3670016), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L116;
        ComposerKt.traceEventEnd();
    L116:
        final Modifier r12 = r20;
    L117:
        ScopeUpdateScope r13 = r10.endRestartGroup();
        if (r13 == null) goto L121;
        r13.updateScope(new UDNoticeKt$NoticeText$2(r48, r49, r51, r52, r53, r54, r55, r12, r59, r510));
        return;
    L121:
        return;
    L111:
        if (r9 != Composer.Companion.getEmpty()) goto L113;
    L104:
        r7 = false;
        goto L106
    L100:
        r16 = LKUIToast.DURATION_MAX;
        goto L101
    L96:
        r0 = Modifier.Companion;
        goto L97
    L86:
        if (r10.getSkipping() == false) goto L89;
        r10.skipToGroupEnd();
        r12 = r4;
        goto L117
    L76:
        r4 = r56;
        if ((r59 & 12582912) != 0) goto L84;
        if (r10.changed(r4) == false) goto L81;
        int r110 = 8388608;
    L82:
        r1 = r1 | r110;
        goto L84
    L81:
        r110 = 4194304;
        goto L82
    L67:
        if ((r59 & 1572864) != 0) goto L73;
        if (r10.changedInstance(r55) == false) goto L71;
        int r14 = 1048576;
    L72:
        r1 = r1 | r14;
        goto L73
    L71:
        r14 = 524288;
        goto L72
    L57:
        if ((r59 & 196608) != 0) goto L64;
        if (r10.changedInstance(r54) == false) goto L61;
        int r15 = 131072;
    L62:
        r1 = r1 | r15;
        goto L64
    L61:
        r15 = 65536;
        goto L62
    L47:
        if ((r59 & 24576) != 0) goto L54;
        if (r10.changed(r53) == false) goto L51;
        int r21 = 16384;
    L52:
        r1 = r1 | r21;
        goto L54
    L51:
        r21 = 8192;
        goto L52
    L37:
        if ((r59 & 3072) != 0) goto L44;
        if (r10.changed(r52) == false) goto L41;
        int r22 = 2048;
    L42:
        r1 = r1 | r22;
        goto L44
    L41:
        r22 = 1024;
        goto L42
    L27:
        if ((r59 & 384) != 0) goto L34;
        if (r10.changed(r51) == false) goto L31;
        int r23 = 256;
    L32:
        r1 = r1 | r23;
        goto L34
    L31:
        r23 = 128;
        goto L32
    L17:
        if ((r59 & 48) != 0) goto L24;
        if (r10.changed(r49) == false) goto L21;
        int r24 = 32;
    L22:
        r1 = r1 | r24;
        goto L24
    L21:
        r24 = 16;
        goto L22
    L6:
        if ((r59 & 6) == 0) goto L8;
        r1 = r59;
        goto L14
    L8:
        if (r10.changed(r48) == false) goto L10;
        int r25 = 4;
    L11:
        r1 = r25 | r59;
        goto L14
    L10:
        r25 = 2;
        goto L11
    }

    public static final void a(final AnnotatedString r60, final Modifier r61, final ImageVector r62, final Painter r63, final long r64, final boolean r66, final ImageVector r67, final Painter r68, final String r69, final long r70, final Function0 r72, final long r73, final UDNoticeTextButtonPosition r75, final UDNoticeGravity r76, final float r77, final boolean r79, final long r710, final long r81, final long r83, final TextStyle r85, final Function1 r86, Composer r87, final int r88, final int r89, final int r90) {
        Composer r9 = r87.startRestartGroup(-1016800292);
        if ((r88 & 6) == 0) goto L5;
        int r1 = r88;
    L11:
        if ((r88 & 48) != 0) goto L18;
        if (r9.changed(r61) == false) goto L15;
        int r4 = 32;
    L16:
        r1 = r1 | r4;
        goto L18
    L15:
        r4 = 16;
    L18:
        if ((r88 & 384) != 0) goto L25;
        if (r9.changed(r62) == false) goto L22;
        int r16 = 256;
    L23:
        r1 = r1 | r16;
        goto L25
    L22:
        r16 = 128;
    L25:
        int r17 = 1024;
        if ((r88 & 3072) != 0) goto L33;
        if (r9.changedInstance(r63) == false) goto L30;
        int r19 = 2048;
    L31:
        r1 = r1 | r19;
        goto L33
    L30:
        r19 = 1024;
    L33:
        int r110 = 8192;
        if ((r88 & 24576) == 0) goto L36;
    L40:
        int r23 = 131072;
        if ((r88 & 196608) != 0) goto L48;
        if (r9.changed(r66) == false) goto L45;
        int r25 = 131072;
    L46:
        r1 = r1 | r25;
        goto L48
    L45:
        r25 = 65536;
    L48:
        if ((r88 & 1572864) != 0) goto L55;
        if (r9.changed(r67) == false) goto L52;
        int r27 = 1048576;
    L53:
        r1 = r1 | r27;
        goto L55
    L52:
        r27 = 524288;
    L55:
        if ((r88 & 12582912) != 0) goto L62;
        if (r9.changedInstance(r68) == false) goto L59;
        int r29 = 8388608;
    L60:
        r1 = r1 | r29;
        goto L62
    L59:
        r29 = 4194304;
    L62:
        if ((r88 & 100663296) != 0) goto L69;
        if (r9.changed(r69) == false) goto L66;
        int r210 = 67108864;
    L67:
        r1 = r1 | r210;
        goto L69
    L66:
        r210 = 33554432;
    L69:
        if ((r88 & 805306368) != 0) goto L76;
        if (r9.changed(r70) == false) goto L73;
        int r31 = 536870912;
    L74:
        r1 = r1 | r31;
        goto L76
    L73:
        r31 = 268435456;
    L76:
        if ((r89 & 6) == 0) goto L78;
        int r32 = r89;
    L84:
        if ((r89 & 48) != 0) goto L91;
        if (r9.changed(null) == false) goto L88;
        int r33 = 32;
    L89:
        r32 = r32 | r33;
        goto L91
    L88:
        r33 = 16;
    L91:
        if ((r89 & 384) != 0) goto L99;
        if (r9.changed(r73) == false) goto L95;
        int r34 = 256;
    L96:
        r32 = r32 | r34;
        goto L99
    L95:
        r34 = 128;
    L99:
        if ((r89 & 3072) != 0) goto L105;
        if (r9.changed(r75.ordinal()) == false) goto L103;
        r17 = 2048;
    L103:
        r32 = r32 | r17;
    L105:
        if ((r89 & 24576) != 0) goto L111;
        if (r9.changed(r76.ordinal()) == false) goto L109;
        r110 = 16384;
    L109:
        r32 = r32 | r110;
    L111:
        if ((r89 & 196608) != 0) goto L119;
        if (r9.changed(r77) == true) goto L116;
        r23 = 65536;
    L116:
        r32 = r32 | r23;
    L119:
        if ((r89 & 1572864) != 0) goto L126;
        if (r9.changed(r79) == false) goto L123;
        int r111 = 1048576;
    L124:
        r32 = r32 | r111;
        goto L126
    L123:
        r111 = 524288;
    L126:
        if ((r89 & 12582912) != 0) goto L133;
        if (r9.changed(r710) == false) goto L130;
        int r112 = 8388608;
    L131:
        r32 = r32 | r112;
        goto L133
    L130:
        r112 = 4194304;
    L133:
        if ((r89 & 100663296) != 0) goto L140;
        if (r9.changed(r81) == false) goto L137;
        int r113 = 67108864;
    L138:
        r32 = r32 | r113;
        goto L140
    L137:
        r113 = 33554432;
    L140:
        if ((r89 & 805306368) == 0) goto L142;
    L146:
        int r0 = r32;
        if ((r90 & 6) == 0) goto L149;
        int r11 = r90;
    L155:
        if ((r90 & 48) != 0) goto L162;
        if (r9.changedInstance(r86) == false) goto L159;
        int r114 = 32;
    L160:
        r11 = r11 | r114;
        goto L162
    L159:
        r114 = 16;
    L162:
        if ((r1 & 306783379) != 306783378) goto L172;
        if ((306783379 & r0) != 306783378) goto L172;
        if ((r11 & 19) != 18) goto L172;
        if (r9.getSkipping() == false) goto L172;
        r9.skipToGroupEnd();
        Composer r8 = r9;
    L213:
        ScopeUpdateScope r15 = r8.endRestartGroup();
        if (r15 == null) goto L218;
        final a r14 = null;
        r15.updateScope(new UDNoticeKt$UDNoticeContent$2(r60, r61, r62, r63, r64, r66, r67, r68, r69, r70, r72, r14, r73, r75, r76, r77, r79, r710, r81, r83, r85, r86, r88, r89, r90));
        return;
    L218:
        return;
    L172:
        if (ComposerKt.isTraceInProgress() == false) goto L175;
        ComposerKt.traceEventStart(-1016800292, r1, r0, "com.larksuite.component.universe_design.notice.compose.UDNoticeContent (UDNotice.kt:222)");
    L175:
        if (r76 != UDNoticeGravity.Center) goto L177;
        int r2 = TextAlign.Companion.getCenter-e0LSkKk();
    L178:
        int r115 = r2;
        r9.startReplaceGroup(-1633490746);
        if ((r1 & 14) != 4) goto L181;
        boolean r3 = true;
    L183:
        if ((r0 & 1879048192) != 536870912) goto L185;
        boolean r5 = true;
    L186:
        boolean r6 = r5 | r3;
        Object r7 = r9.rememberedValue();
        if (r6 == false) goto L189;
    L190:
        List r10 = r60.getStringAnnotations(0, r60.length());
        if (r10.isEmpty() == false) goto L193;
        r7 = r60;
    L198:
        r9.updateRememberedValue(r7);
    L199:
        AnnotatedString r116 = (AnnotatedString) r7;
        r9.endReplaceGroup();
        if (r86 == null) goto L205;
        if ((!r60.getStringAnnotations(0, r60.length()).isEmpty()) == false) goto L205;
        boolean r12 = true;
    L206:
        if (r79 == false) goto L209;
        if (r12 == true) goto L209;
        boolean r117 = true;
    L210:
        r8 = r9;
        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxWidth$default(r61, 0.0f, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(1477363122, true, new UDNoticeKt$UDNoticeContent$1(null, r60, r75, r77, r710, r76, r62, r63, r64, r66, r116, r81, r85, r115, r117, r86, r73, r67, r68, r70, r69, r72), r8, 54), r8, 3072, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L213;
        ComposerKt.traceEventEnd();
    L209:
        r117 = false;
    L205:
        r12 = false;
        goto L206
    L193:
        AnnotatedString.Builder r13 = new AnnotatedString.Builder(0, 1, null);
        r13.append(r60);
        Iterator r20 = r10.iterator();
    L195:
        if (r20.hasNext() == false) goto L197;
        AnnotatedString.Range r21 = (AnnotatedString.Range) r20.next();
        r13.addStringAnnotation(r21.getTag(), (String) r21.getItem(), r21.getStart(), r21.getEnd());
        r13.addStyle(new SpanStyle(r83, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, 65534, null), r21.getStart(), r21.getEnd());
        r20 = r20;
        goto L195
    L197:
        r7 = r13.toAnnotatedString();
        goto L198
    L189:
        if (r7 != Composer.Companion.getEmpty()) goto L199;
    L185:
        r5 = false;
        goto L186
    L181:
        r3 = false;
        goto L183
    L177:
        r2 = TextAlign.Companion.getStart-e0LSkKk();
        goto L178
    L149:
        if (r9.changed(r85) == false) goto L151;
        int r118 = 4;
    L152:
        r11 = r90 | r118;
        goto L155
    L151:
        r118 = 2;
        goto L152
    L142:
        if (r9.changed(r83) == false) goto L144;
        int r119 = 536870912;
    L145:
        r32 = r32 | r119;
        goto L146
    L144:
        r119 = 268435456;
        goto L145
    L78:
        if (r9.changedInstance(r72) == false) goto L80;
        int r35 = 4;
    L81:
        r32 = r89 | r35;
        goto L84
    L80:
        r35 = 2;
        goto L81
    L36:
        if (r9.changed(r64) == false) goto L38;
        int r22 = 16384;
    L39:
        r1 = r1 | r22;
        goto L40
    L38:
        r22 = 8192;
        goto L39
    L5:
        if (r9.changed(r60) == false) goto L7;
        int r24 = 4;
    L8:
        r1 = r24 | r88;
        goto L11
    L7:
        r24 = 2;
        goto L8
    }
}
