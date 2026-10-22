package com.larksuite.component.universe_design.checkbox.compose;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
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
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import com.larksuite.component.universe_design.compose.foundation.g0;
import com.larksuite.component.universe_design.compose.foundation.h0;
import com.larksuite.component.universe_design.compose.foundation.i0;
import com.larksuite.component.universe_design.compose.foundation.o;
import com.larksuite.component.universe_design.compose.foundation.r;
import com.larksuite.component.universe_design.icon.compose.d;
import com.larksuite.component.universe_design.icon.compose.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UDCheckBoxKt {
    public static final float a = 0.0f;
    public static final float b = 0.0f;
    public static final float c = 0.0f;
    public static final float d = 0.0f;

    static {
        a = Dp.constructor-impl(48);
        b = Dp.constructor-impl(20);
        c = Dp.constructor-impl(18);
        d = Dp.constructor-impl((float) 1.5d);
    }

    public static final void c(DrawScope r19, long r110) {
        float r3 = r19.toPx-0680j_4(d);
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r19, r110, (Size.getMinDimension-impl(r19.getSize-NH-jbRc()) - r3) / 2.0f, 0, 0.0f, new Stroke(r3, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
    }

    public static final void a(final boolean r22, final UDCheckBoxType r23, final boolean r24, final a r25, final float r26, final Modifier r27, Composer r29, final int r210) {
        Composer r15 = r29.startRestartGroup(-55187422);
        if ((r210 & 6) == 0) goto L5;
        int r8 = r210;
    L11:
        if ((r210 & 48) != 0) goto L18;
        if (r15.changed(r23.ordinal()) == false) goto L15;
        int r10 = 32;
    L16:
        r8 = r8 | r10;
        goto L18
    L15:
        r10 = 16;
    L18:
        if ((r210 & 384) != 0) goto L25;
        if (r15.changed(r24) == false) goto L22;
        int r11 = 256;
    L23:
        r8 = r8 | r11;
        goto L25
    L22:
        r11 = 128;
    L25:
        if ((r210 & 3072) != 0) goto L32;
        if (r15.changed(r25) == false) goto L29;
        int r12 = 2048;
    L30:
        r8 = r8 | r12;
        goto L32
    L29:
        r12 = 1024;
    L32:
        if ((r210 & 24576) != 0) goto L39;
        if (r15.changed(r26) == false) goto L36;
        int r13 = 16384;
    L37:
        r8 = r8 | r13;
        goto L39
    L36:
        r13 = 8192;
    L39:
        if ((196608 & r210) != 0) goto L46;
        if (r15.changed(r27) == false) goto L43;
        int r14 = 131072;
    L44:
        r8 = r8 | r14;
        goto L46
    L43:
        r14 = 65536;
    L46:
        if ((74899 & r8) != 74898) goto L52;
        if (r15.getSkipping() == false) goto L52;
        r15.skipToGroupEnd();
        r15 = r15;
    L98:
        ScopeUpdateScope r9 = r15.endRestartGroup();
        if (r9 == null) goto L102;
        r9.updateScope(new UDCheckBoxKt$CheckboxVisual$2(r22, r23, r24, r25, r26, r27, r210));
        return;
    L102:
        return;
    L52:
        if (ComposerKt.isTraceInProgress() == false) goto L55;
        ComposerKt.traceEventStart(-55187422, r8, -1, "com.larksuite.component.universe_design.checkbox.compose.CheckboxVisual (UDCheckBox.kt:92)");
    L55:
        if (r23 != UDCheckBoxType.CheckBox) goto L61;
        if (r22 == false) goto L61;
        if (r24 == false) goto L60;
        r15.startReplaceGroup(-1495494257);
        d r0 = d.a;
        Painter r1 = g.b(r15, 0);
        r15.endReplaceGroup();
    L62:
        MeasurePolicy r16 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        long r17 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r19 = (int) (r17 ^ (r17 >>> 32));
        CompositionLocalMap r20 = r15.getCurrentCompositionLocalMap();
        Modifier r110 = ComposedModifierKt.materializeModifier(r15, r27);
        ComposeUiNode.Companion r111 = ComposeUiNode.Companion;
        Function0 r112 = r111.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L65;
        ComposablesKt.invalidApplier();
    L65:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L68;
        r15.createNode(r112);
    L69:
        Composer r113 = Updater.constructor-impl(r15);
        Updater.set-impl(r113, r16, r111.getSetMeasurePolicy());
        Updater.set-impl(r113, r20, r111.getSetResolvedCompositionLocals());
        Function2 r21 = r111.getSetCompositeKeyHash();
        if (r113.getInserting() == false) goto L72;
    L73:
        r113.updateRememberedValue(Integer.valueOf(r19));
        r113.apply(Integer.valueOf(r19), r21);
    L74:
        Updater.set-impl(r113, r110, r111.getSetModifier());
        BoxScopeInstance r30 = BoxScopeInstance.INSTANCE;
        Modifier.Companion r31 = Modifier.Companion;
        Modifier r114 = SizeKt.requiredSize-3ABfNKs(r31, r26);
        r15.startReplaceGroup(-1746271574);
        boolean r115 = true;
        if ((r8 & 112) != 32) goto L77;
        boolean r116 = true;
    L79:
        if ((r8 & 7168) != 2048) goto L81;
        boolean r117 = true;
    L82:
        boolean r118 = r116 | r117;
        if ((r8 & 14) == 4) goto L86;
        r115 = false;
    L86:
        boolean r32 = r118 | r115;
        Object r119 = r15.rememberedValue();
        if (r32 == false) goto L89;
    L90:
        r119 = new UDCheckBoxKt$CheckboxVisual$1$1$1(r23, r25, r22);
        r15.updateRememberedValue(r119);
    L91:
        r15.endReplaceGroup();
        CanvasKt.Canvas(r114, (Function1) r119, r15, 0);
        r15.startReplaceGroup(1408582231);
        if (r1 == null) goto L95;
        ColorFilter r120 = ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, r25.c, 0, 2, null);
        Modifier r121 = SizeKt.requiredSize-3ABfNKs(r31, Dp.constructor-impl(0.9f * r26));
        ImageKt.Image(r1, null, r121, null, null, 0.0f, r120, r15, 48, 56);
    L95:
        r15.endReplaceGroup();
        r15.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventEnd();
        goto L98
    L89:
        if (r119 != Composer.Companion.getEmpty()) goto L91;
    L81:
        r117 = false;
        goto L82
    L77:
        r116 = false;
        goto L79
    L72:
        if (Intrinsics.areEqual(r113.rememberedValue(), Integer.valueOf(r19)) == true) goto L74;
    L68:
        r15.useNode();
        goto L69
    L60:
        r15.startReplaceGroup(-1495492761);
        d r2 = d.a;
        r1 = g.a(r15, 0);
        r15.endReplaceGroup();
    L61:
        r15.startReplaceGroup(884271387);
        r15.endReplaceGroup();
        r1 = null;
        goto L62
    L5:
        if (r15.changed(r22) == false) goto L7;
        int r33 = 4;
    L8:
        r8 = r33 | r210;
        goto L11
    L7:
        r33 = 2;
        goto L8
    }

    public static final void b(final boolean r52, final Function1<? super Boolean, Unit> r53, Modifier r54, boolean r55, UDCheckBoxType r56, UDCheckBoxSize r57, boolean r59, b r510, Composer r60, final int r61, final int r62) {
        Intrinsics.checkNotNullParameter(r53, "onCheckedChange");
        Composer r12 = r60.startRestartGroup(1539745352);
        if ((r62 & 1) == 0) goto L6;
        int r1 = r61 | 6;
    L14:
        if ((r62 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r62 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        Modifier r4 = r54;
    L34:
        int r5 = r62 & 8;
        if (r5 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        boolean r6 = r55;
    L45:
        int r7 = r62 & 16;
        if (r7 == 0) goto L49;
        r1 = r1 | 24576;
    L58:
        int r14 = r62 & 32;
        int r15 = 196608;
        if (r14 == 0) goto L62;
    L70:
        r1 = r1 | r15;
    L71:
        int r16 = r62 & 64;
        if (r16 == 0) goto L74;
        r1 = r1 | 1572864;
        boolean r3 = r59;
    L82:
        if ((r61 & 12582912) != 0) goto L93;
        if ((r62 & 128) != 0) goto L89;
        if (r12.changed(r510) == false) goto L89;
        int r19 = 8388608;
    L90:
        r1 = r1 | r19;
    L89:
        r19 = 4194304;
    L93:
        if ((r1 & 4793491) == 4793490) goto L95;
    L98:
        r12.startDefaults();
        boolean r110 = true;
        if ((r61 & 1) != 0) goto L101;
    L107:
        if (r2 == 0) goto L109;
        Modifier r0 = Modifier.Companion;
    L110:
        if (r5 == 0) goto L112;
        r6 = true;
    L112:
        if (r7 == 0) goto L114;
        UDCheckBoxType r8 = UDCheckBoxType.CheckBox;
    L115:
        if (r14 == 0) goto L117;
        UDCheckBoxSize r9 = UDCheckBoxSize.Normal;
    L118:
        if (r16 == 0) goto L121;
        r3 = false;
    L121:
        if ((r62 & 128) == 0) goto L129;
        int r10 = c.a;
        r12.startReplaceGroup(586237592);
        Color.Companion r11 = Color.Companion;
        long r21 = r11.getUnspecified-0d7_KjU();
        long r23 = r11.getUnspecified-0d7_KjU();
        long r25 = r11.getUnspecified-0d7_KjU();
        if (ComposerKt.isTraceInProgress() == false) goto L125;
        ComposerKt.traceEventStart(586237592, 3072, -1, "com.larksuite.component.universe_design.checkbox.compose.UDCheckBoxDefaults.colors (UDCheckBox.kt:184)");
    L125:
        g0 r13 = i0.a(r12);
        h0 r17 = r13.d;
        r r111 = r17.a;
        long r112 = r111.c;
        long r20 = r111.a;
        o r113 = r13.a.d;
        long r22 = r113.g;
        int r49 = r1;
        long r24 = r113.d;
        Composer r51 = r12;
        b r26 = new b(r21, r23, r25, r112, r20, r22, r24, r17.h.c, r113.h, r22, r22, r24, r13.a(), r13.a.d.g);
        if (ComposerKt.isTraceInProgress() == false) goto L128;
        ComposerKt.traceEventEnd();
    L128:
        r51.endReplaceGroup();
        r1 = r49 & (-29360129);
    L130:
        UDCheckBoxType r114 = r8;
        boolean r115 = r3;
        UDCheckBoxSize r116 = r9;
        boolean r117 = r6;
        b r118 = r26;
        Modifier r27 = r0;
    L131:
        r51.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L134;
        ComposerKt.traceEventStart(1539745352, r1, -1, "com.larksuite.component.universe_design.checkbox.compose.UDCheckBox (UDCheckBox.kt:49)");
    L134:
        Composer r119 = r51;
        r119.startReplaceGroup(1849434622);
        Object r29 = r119.rememberedValue();
        if (r29 != Composer.Companion.getEmpty()) goto L137;
        r29 = InteractionSourceKt.MutableInteractionSource();
        r119.updateRememberedValue(r29);
    L137:
        MutableInteractionSource r30 = (MutableInteractionSource) r29;
        r119.endReplaceGroup();
        UDCheckBoxType r31 = UDCheckBoxType.Radio;
        Role.Companion r32 = Role.Companion;
        if (r114 != r31) goto L140;
        int r33 = r32.getRadioButton-o7Vup1c();
    L141:
        UDCheckBoxType r34 = UDCheckBoxType.CheckMark;
        if (r114 != r34) goto L144;
    L147:
        float r35 = b;
    L148:
        r118.getClass();
        Intrinsics.checkNotNullParameter(r114, "type");
        if (r114 == r34) goto L151;
        Color r36 = Color.box-impl(r118.a);
        long r37 = r36.unbox-impl();
        Color.Companion r120 = Color.Companion;
        if (Color.equals-impl0(r37, r120.getUnspecified-0d7_KjU()) == true) goto L162;
        if (r117 == false) goto L162;
        boolean r38 = true;
    L163:
        if (r38 == false) goto L165;
        Color r39 = r36;
    L166:
        Color r40 = Color.box-impl(r118.b);
        if (Color.equals-impl0(r40.unbox-impl(), r120.getUnspecified-0d7_KjU()) == true) goto L170;
        if (r52 == true) goto L170;
        boolean r41 = true;
    L171:
        if (r41 == false) goto L173;
        Color r42 = r40;
    L174:
        Color r43 = Color.box-impl(r118.c);
        boolean r210 = r115;
        if (Color.equals-impl0(r43.unbox-impl(), r120.getUnspecified-0d7_KjU()) == true) goto L178;
        if (r52 == true) goto L178;
    L179:
        if (r110 == false) goto L181;
        Color r44 = r43;
    L182:
        if (r114 != r31) goto L184;
        long r45 = r118.k;
    L186:
        if (r39 == null) goto L190;
        if (r52 == false) goto L190;
        long r121 = r39.unbox-impl();
    L189:
        long r211 = r121;
        if (r52 == false) goto L204;
        r45 = r120.getTransparent-0d7_KjU();
    L203:
        long r212 = r45;
        if (r52 == true) goto L211;
        if (r210 == true) goto L211;
    L213:
        long r46 = r118.g;
    L214:
        a r47 = new a(r211, r212, r46);
    L215:
        boolean r511 = r117;
        Modifier r48 = ToggleableKt.toggleable-O2vRcR0(SizeKt.requiredSize-3ABfNKs(r27, a), r52, r30, null, r511, Role.box-impl(r33), r53);
        MeasurePolicy r50 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        long r63 = ComposablesKt.getCurrentCompositeKeyHashCode(r119, 0);
        int r64 = (int) (r63 ^ (r63 >>> 32));
        CompositionLocalMap r65 = r119.getCurrentCompositionLocalMap();
        Modifier r66 = ComposedModifierKt.materializeModifier(r119, r48);
        ComposeUiNode.Companion r67 = ComposeUiNode.Companion;
        Function0 r68 = r67.getConstructor();
        if ((r119.getApplier() instanceof Applier) == true) goto L218;
        ComposablesKt.invalidApplier();
    L218:
        r119.startReusableNode();
        if (r119.getInserting() == false) goto L221;
        r119.createNode(r68);
    L222:
        Composer r69 = Updater.constructor-impl(r119);
        Updater.set-impl(r69, r50, r67.getSetMeasurePolicy());
        Updater.set-impl(r69, r65, r67.getSetResolvedCompositionLocals());
        Function2 r70 = r67.getSetCompositeKeyHash();
        if (r69.getInserting() == false) goto L225;
    L226:
        r69.updateRememberedValue(Integer.valueOf(r64));
        r69.apply(Integer.valueOf(r64), r70);
    L227:
        Updater.set-impl(r69, r66, r67.getSetModifier());
        BoxScopeInstance r71 = BoxScopeInstance.INSTANCE;
        float r72 = r35;
        Modifier r73 = SizeKt.requiredSize-3ABfNKs(Modifier.Companion, r72);
        int r74 = ((r1 & 14) | ((r1 >> 9) & 112)) | ((r1 >> 12) & 896);
        a(r52, r114, r210, r47, r72, r73, r119, r74);
        r119.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L230;
        ComposerKt.traceEventEnd();
    L230:
        final Modifier r75 = r27;
        final boolean r76 = r117;
        final UDCheckBoxType r77 = r114;
        final UDCheckBoxSize r79 = r116;
        final boolean r80 = r210;
    L231:
        ScopeUpdateScope r122 = r119.endRestartGroup();
        if (r122 == null) goto L235;
        final b r81 = r118;
        r122.updateScope(new UDCheckBoxKt$UDCheckBox$2(r52, r53, r75, r76, r77, r79, r80, r81, r61, r62));
        return;
    L235:
        return;
    L225:
        if (Intrinsics.areEqual(r69.rememberedValue(), Integer.valueOf(r64)) == true) goto L227;
    L221:
        r119.useNode();
    L211:
        if (r117 == false) goto L213;
        r46 = r118.e;
        goto L214
    L204:
        if (r44 == null) goto L207;
        if (r117 == false) goto L207;
        r45 = r44.unbox-impl();
    L207:
        if (r117 == false) goto L203;
        r45 = r118.i;
    L190:
        if (r52 == false) goto L193;
        if (r117 == false) goto L193;
        r121 = r118.d;
    L193:
        if (r52 == false) goto L195;
        r121 = r118.f;
        goto L189
    L195:
        if (r42 == null) goto L198;
        if (r117 == false) goto L198;
        r121 = r42.unbox-impl();
    L198:
        if (r117 == false) goto L200;
        r121 = r118.h;
        goto L189
    L200:
        r121 = r118.l;
        goto L189
    L184:
        r45 = r118.j;
        goto L186
    L181:
        r44 = null;
    L178:
        r110 = false;
        goto L179
    L173:
        r42 = null;
    L170:
        r41 = false;
        goto L171
    L165:
        r39 = null;
    L162:
        r38 = false;
        goto L163
    L151:
        if (r52 == false) goto L154;
        if (r117 == false) goto L154;
        long r82 = r118.m;
    L157:
        Color.Companion r83 = Color.Companion;
        long r512 = r82;
        r47 = new a(r512, r83.getTransparent-0d7_KjU(), r83.getTransparent-0d7_KjU());
        r210 = r115;
    L154:
        if (r52 == false) goto L156;
        r82 = r118.n;
        goto L157
    L156:
        r82 = Color.Companion.getTransparent-0d7_KjU();
        goto L157
    L144:
        if (r116 == UDCheckBoxSize.Normal) goto L147;
        r35 = c;
        goto L148
    L140:
        r33 = r32.getCheckbox-o7Vup1c();
        goto L141
    L129:
        r51 = r12;
        r26 = r510;
        goto L130
    L117:
        r9 = r57;
        goto L118
    L114:
        r8 = r56;
        goto L115
    L109:
        r0 = r4;
        goto L110
    L101:
        if (r12.getDefaultsInvalid() == true) goto L107;
        r12.skipToGroupEnd();
        if ((r62 & 128) == 0) goto L106;
        r1 = r1 & (-29360129);
    L106:
        r114 = r56;
        r118 = r510;
        r115 = r3;
        r27 = r4;
        r117 = r6;
        r51 = r12;
        r116 = r57;
        goto L131
    L95:
        if (r12.getSkipping() == false) goto L98;
        r12.skipToGroupEnd();
        r77 = r56;
        r118 = r510;
        r80 = r3;
        r75 = r4;
        r76 = r6;
        r119 = r12;
        r79 = r57;
        goto L231
    L74:
        r3 = r59;
        if ((r61 & 1572864) != 0) goto L82;
        if (r12.changed(r3) == false) goto L79;
        int r123 = 1048576;
    L80:
        r1 = r1 | r123;
        goto L82
    L79:
        r123 = 524288;
        goto L80
    L62:
        if ((196608 & r61) != 0) goto L71;
        if (r57 != null) goto L65;
        int r124 = -1;
    L67:
        if (r12.changed(r124) == false) goto L69;
        r15 = 131072;
        goto L70
    L69:
        r15 = 65536;
        goto L70
    L65:
        r124 = r57.ordinal();
        goto L67
    L49:
        if ((r61 & 24576) != 0) goto L58;
        if (r56 != null) goto L52;
        int r125 = -1;
    L54:
        if (r12.changed(r125) == false) goto L56;
        int r126 = 16384;
    L57:
        r1 = r1 | r126;
        goto L58
    L56:
        r126 = 8192;
        goto L57
    L52:
        r125 = r56.ordinal();
        goto L54
    L38:
        if ((r61 & 3072) != 0) goto L44;
        r6 = r55;
        if (r12.changed(r6) == false) goto L42;
        int r84 = 2048;
    L43:
        r1 = r1 | r84;
        goto L45
    L42:
        r84 = 1024;
        goto L43
    L27:
        if ((r61 & 384) != 0) goto L33;
        r4 = r54;
        if (r12.changed(r4) == false) goto L31;
        int r85 = 256;
    L32:
        r1 = r1 | r85;
        goto L34
    L31:
        r85 = 128;
        goto L32
    L17:
        if ((r61 & 48) != 0) goto L23;
        if (r12.changedInstance(r53) == false) goto L21;
        int r86 = 32;
    L22:
        r1 = r1 | r86;
        goto L23
    L21:
        r86 = 16;
        goto L22
    L6:
        if ((r61 & 6) == 0) goto L8;
        r1 = r61;
        goto L14
    L8:
        if (r12.changed(r52) == false) goto L10;
        int r87 = 4;
    L11:
        r1 = r87 | r61;
        goto L14
    L10:
        r87 = 2;
        goto L11
    }
}
