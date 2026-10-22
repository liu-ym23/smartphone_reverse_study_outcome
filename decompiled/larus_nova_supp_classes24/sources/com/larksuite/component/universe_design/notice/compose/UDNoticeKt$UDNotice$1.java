package com.larksuite.component.universe_design.notice.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.larksuite.component.universe_design.compose.foundation.i0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class UDNoticeKt$UDNotice$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ b $colors;
    final /* synthetic */ UDNoticeGravity $gravity;
    final /* synthetic */ ImageVector $icon;
    final /* synthetic */ ImageVector $iconButton;
    final /* synthetic */ String $iconButtonContentDescription;
    final /* synthetic */ Painter $iconButtonPainter;
    final /* synthetic */ boolean $iconColorful;
    final /* synthetic */ Painter $iconPainter;
    final /* synthetic */ boolean $marquee;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onIconButtonClick;
    final /* synthetic */ float $radius;
    final /* synthetic */ String $text;
    final /* synthetic */ a $textButton;
    final /* synthetic */ UDNoticeTextButtonPosition $textButtonPosition;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ UDNoticeType $type;

    public UDNoticeKt$UDNotice$1(String r3, Modifier r4, UDNoticeType r5, ImageVector r6, boolean r7, ImageVector r8, String r9, Function0<Unit> r10, a r11, UDNoticeTextButtonPosition r12, UDNoticeGravity r13, float r14, boolean r15, b r16, TextStyle r17, Painter r19, Painter r110, int r20, int r21, int r22) {
        this.$text = r3;
        this.$modifier = r4;
        this.$type = r5;
        this.$icon = r6;
        this.$iconColorful = r7;
        this.$iconButton = r8;
        this.$iconButtonContentDescription = r9;
        this.$onIconButtonClick = r10;
        this.$textButtonPosition = r12;
        this.$gravity = r13;
        this.$radius = r14;
        this.$marquee = r15;
        this.$colors = r16;
        this.$textStyle = r17;
        this.$iconPainter = r19;
        this.$iconButtonPainter = r110;
        this.$$changed = r20;
        this.$$changed1 = r21;
        this.$$default = r22;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r57, int r59) {
        String r2 = this.$text;
        Modifier r1 = this.$modifier;
        UDNoticeType r3 = this.$type;
        ImageVector r4 = this.$icon;
        boolean r5 = this.$iconColorful;
        ImageVector r6 = this.$iconButton;
        String r7 = this.$iconButtonContentDescription;
        Function0<Unit> r8 = this.$onIconButtonClick;
        UDNoticeTextButtonPosition r9 = this.$textButtonPosition;
        UDNoticeGravity r10 = this.$gravity;
        float r11 = this.$radius;
        boolean r12 = this.$marquee;
        b r13 = this.$colors;
        TextStyle r14 = this.$textStyle;
        Painter r15 = this.$iconPainter;
        Painter r16 = this.$iconButtonPainter;
        int r17 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r19 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed1);
        int r110 = this.$$default;
        float r20 = d.a;
        Intrinsics.checkNotNullParameter(r2, "text");
        Composer r0 = r57.startRestartGroup(233192618);
        int r22 = 4;
        if ((r110 & 1) == 0) goto L6;
        int r111 = r17 | 6;
    L13:
        int r23 = r110 & 2;
        int r24 = 16;
        if (r23 == 0) goto L17;
        r111 = r111 | 48;
    L23:
        int r26 = r110 & 4;
        int r27 = 128;
        if (r26 == 0) goto L27;
        r111 = r111 | 384;
    L36:
        int r112 = r110 & 8;
        int r30 = 2048;
        if (r112 == 0) goto L39;
        r111 = r111 | 3072;
        Modifier r32 = r1;
    L46:
        int r21 = r111;
    L47:
        int r113 = r110 & 16;
        int r33 = 16384;
        if (r113 == 0) goto L50;
        r21 = r21 | 24576;
        UDNoticeType r35 = r3;
    L57:
        int r25 = r110 & 32;
        if (r25 == 0) goto L61;
        r21 = r21 | 196608;
    L67:
        int r38 = r110 & 64;
        if (r38 == 0) goto L71;
        r21 = r21 | 1572864;
    L77:
        ImageVector r40 = r4;
        int r29 = r110 & 128;
        int r41 = 12582912;
        if (r29 == 0) goto L81;
    L86:
        r21 = r21 | r41;
    L87:
        boolean r42 = r5;
        ImageVector r43 = r6;
        if ((r110 & 256) == 0) goto L91;
        r21 = r21 | 100663296;
    L97:
        int r31 = r110 & 512;
        if (r31 == 0) goto L101;
        r21 = r21 | 805306368;
    L110:
        int r34 = r110 & 1024;
        if (r34 == 0) goto L114;
        int r210 = r19 | 6;
        r7 = r7;
    L124:
        int r36 = r110 & 2048;
        if (r36 == 0) goto L128;
        r210 = r210 | 48;
    L133:
        float r211 = r11;
        int r37 = r210;
    L134:
        int r39 = r110 & 4096;
        if (r39 == 0) goto L137;
        r37 = r37 | 384;
        UDNoticeGravity r212 = r10;
    L143:
        boolean r114 = r12;
    L144:
        boolean r213 = r114;
        if ((r19 & 3072) == 0) goto L147;
        b r115 = r13;
    L155:
        b r116 = r115;
        if ((r19 & 24576) == 0) goto L158;
        TextStyle r117 = r14;
    L166:
        int r118 = r110 & 32768;
        if (r118 == 0) goto L170;
        r37 = r37 | 196608;
    L176:
        Painter r119 = r15;
    L177:
        int r120 = r110 & 65536;
        if (r120 == 0) goto L181;
        r37 = r37 | 1572864;
    L187:
        Painter r121 = r16;
    L188:
        Painter r214 = r121;
        if ((r21 & 306783379) == 306783378) goto L191;
    L196:
        r0.startDefaults();
        if ((r17 & 1) != 0) goto L199;
    L208:
        if (r23 == 0) goto L210;
        r32 = Modifier.Companion;
    L210:
        if (r26 == 0) goto L212;
        UDNoticeType r122 = UDNoticeType.Info;
    L213:
        if (r112 == 0) goto L216;
        r40 = null;
    L216:
        if (r113 == 0) goto L218;
        r42 = false;
    L218:
        if (r25 == 0) goto L220;
        r43 = null;
    L220:
        if (r38 == 0) goto L222;
        r7 = null;
    L222:
        if (r29 == 0) goto L224;
        r8 = null;
    L224:
        if (r31 == 0) goto L226;
        UDNoticeTextButtonPosition r44 = UDNoticeTextButtonPosition.Right;
    L227:
        if (r34 == 0) goto L229;
        UDNoticeGravity r45 = UDNoticeGravity.Left;
    L230:
        if (r36 == 0) goto L232;
        r211 = Dp.constructor-impl(0);
    L232:
        if (r39 == 0) goto L234;
        boolean r123 = false;
    L236:
        if ((r110 & 8192) == 0) goto L239;
        r37 = r37 & (-7169);
        r116 = c.a(r122, r0, ((r21 >> 6) & 14) | 48);
    L239:
        if ((r110 & 16384) == 0) goto L241;
        TextStyle r124 = i0.b(r0).d;
        r37 = (-57345) & r37;
    L242:
        if (r118 == 0) goto L244;
        r119 = null;
    L244:
        if (r120 == 0) goto L246;
        r214 = null;
    L246:
        UDNoticeTextButtonPosition r125 = r44;
        UDNoticeType r126 = r122;
        r213 = r123;
        TextStyle r127 = r124;
        b r128 = r116;
        float r129 = r211;
        Painter r130 = r119;
        Function0<Unit> r46 = r8;
        Painter r52 = r214;
        Modifier r47 = r32;
        boolean r48 = r42;
        ImageVector r49 = r43;
        String r50 = r7;
        UDNoticeGravity r131 = r45;
        ImageVector r51 = r40;
    L247:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L251;
        ComposerKt.traceEventStart(233192618, r21, r37, "com.larksuite.component.universe_design.notice.compose.UDNotice (UDNotice.kt:103)");
    L251:
        Composer r510 = r0;
        float r511 = r129;
        int r132 = r21 << 3;
        int r410 = ((((((r21 & 112) | ((r21 >> 3) & 896)) | ((r37 >> 6) & 7168)) | (458752 & r132)) | (r132 & 3670016)) | (29360128 & (r37 << 3))) | ((r21 << 6) & 234881024);
        int r53 = r21 >> 21;
        int r54 = ((r53 & 112) | (r53 & 14)) | ((r21 >> 18) & 7168);
        int r55 = r37 << 12;
        d.a(new AnnotatedString(r2, null, 2, null), r47, r51, r130, r128.c, r48, r49, r52, r50, r128.d, r46, r128.e, r125, r131, r511, r213, r128.a, r128.b, r128.f, r127, null, r510, r410, ((r54 | (57344 & r55)) | (458752 & r55)) | (r55 & 3670016), ((r37 >> 12) & 14) | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L254;
        ComposerKt.traceEventEnd();
    L254:
        float r133 = r511;
        String r56 = r50;
        b r134 = r128;
        boolean r135 = r213;
        ImageVector r60 = r49;
        boolean r61 = r48;
        ImageVector r62 = r51;
        UDNoticeType r63 = r126;
        TextStyle r136 = r127;
        Painter r137 = r52;
    L255:
        ScopeUpdateScope r64 = r510.endRestartGroup();
        if (r64 == null) goto L259;
        r64.updateScope(new UDNoticeKt$UDNotice$1(r2, r47, r63, r62, r61, r60, r56, r46, null, r125, r131, r133, r135, r134, r136, r130, r137, r17, r19, r110));
        return;
    L259:
        return;
    L241:
        r124 = r117;
        goto L242
    L234:
        r123 = r213;
        goto L236
    L229:
        r45 = r212;
        goto L230
    L226:
        r44 = r9;
        goto L227
    L212:
        r122 = r35;
        goto L213
    L199:
        if (r0.getDefaultsInvalid() == true) goto L208;
        r0.skipToGroupEnd();
        if ((r110 & 8192) == 0) goto L205;
        r37 = r37 & (-7169);
    L205:
        if ((r110 & 16384) == 0) goto L207;
        r37 = r37 & (-57345);
    L207:
        r128 = r116;
        r129 = r211;
        r125 = r9;
        r131 = r212;
        r127 = r117;
        r130 = r119;
        r46 = r8;
        r52 = r214;
        r47 = r32;
        r126 = r35;
        r51 = r40;
        r48 = r42;
        r49 = r43;
        r50 = r7;
        goto L247
    L191:
        if ((599187 & r37) != 599186) goto L196;
        if (r0.getSkipping() == false) goto L196;
        r0.skipToGroupEnd();
        r510 = r0;
        r17 = r17;
        r134 = r116;
        r135 = r213;
        r133 = r211;
        r125 = r9;
        r131 = r212;
        r136 = r117;
        r130 = r119;
        r46 = r8;
        r137 = r214;
        r47 = r32;
        r63 = r35;
        r62 = r40;
        r61 = r42;
        r60 = r43;
        r56 = r7;
        goto L255
    L181:
        if ((r19 & 1572864) != 0) goto L187;
        r121 = r16;
        if (r0.changedInstance(r121) == false) goto L185;
        int r138 = 1048576;
    L186:
        r37 = r37 | r138;
        goto L188
    L185:
        r138 = 524288;
        goto L186
    L170:
        if ((r19 & 196608) != 0) goto L176;
        r119 = r15;
        if (r0.changedInstance(r119) == false) goto L174;
        int r139 = 131072;
    L175:
        r37 = r37 | r139;
        goto L177
    L174:
        r139 = 65536;
        goto L175
    L158:
        if ((r110 & 16384) != 0) goto L162;
        r117 = r14;
        if (r0.changed(r117) == true) goto L164;
    L163:
        r33 = 8192;
    L164:
        r37 = r37 | r33;
        goto L166
    L162:
        r117 = r14;
        goto L163
    L147:
        if ((r110 & 8192) != 0) goto L151;
        r115 = r13;
        if (r0.changed(r115) == true) goto L153;
    L152:
        r30 = 1024;
    L153:
        r37 = r37 | r30;
        goto L155
    L151:
        r115 = r13;
        goto L152
    L137:
        r212 = r10;
        if ((r19 & 384) != 0) goto L143;
        r114 = r12;
        if (r0.changed(r114) == false) goto L142;
        r27 = 256;
    L142:
        r37 = r37 | r27;
        goto L144
    L128:
        if ((r19 & 48) != 0) goto L133;
        if (r0.changed(r11) == false) goto L132;
        r24 = 32;
    L132:
        r211 = r11;
        r37 = r210 | r24;
        goto L134
    L114:
        if ((r19 & 6) != 0) goto L123;
        if (r10 != null) goto L117;
        int r65 = -1;
    L119:
        if (r0.changed(r65) == true) goto L122;
        r22 = 2;
    L122:
        r210 = r19 | r22;
        goto L124
    L117:
        r65 = r10.ordinal();
        goto L119
    L123:
        r7 = r7;
        r210 = r19;
        goto L124
    L101:
        if ((r17 & 805306368) != 0) goto L110;
        if (r9 != null) goto L104;
        int r66 = -1;
    L106:
        if (r0.changed(r66) == false) goto L108;
        int r67 = 536870912;
    L109:
        r21 = r21 | r67;
        goto L110
    L108:
        r67 = 268435456;
        goto L109
    L104:
        r66 = r9.ordinal();
        goto L106
    L91:
        if ((r17 & 100663296) != 0) goto L97;
        if (r0.changed(null) == false) goto L95;
        int r68 = 67108864;
    L96:
        r21 = r21 | r68;
        goto L97
    L95:
        r68 = 33554432;
        goto L96
    L81:
        if ((r17 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r8) == false) goto L85;
        r41 = 8388608;
        goto L86
    L85:
        r41 = 4194304;
        goto L86
    L71:
        if ((r17 & 1572864) != 0) goto L77;
        if (r0.changed(r7) == false) goto L75;
        int r411 = 1048576;
    L76:
        r21 = r21 | r411;
        goto L77
    L75:
        r411 = 524288;
        goto L76
    L61:
        if ((r17 & 196608) != 0) goto L67;
        if (r0.changed(r6) == false) goto L65;
        int r310 = 131072;
    L66:
        r21 = r21 | r310;
        goto L67
    L65:
        r310 = 65536;
        goto L66
    L50:
        r35 = r3;
        if ((r17 & 24576) != 0) goto L57;
        if (r0.changed(r5) == false) goto L55;
        int r69 = 16384;
    L56:
        r21 = r21 | r69;
        goto L57
    L55:
        r69 = 8192;
        goto L56
    L39:
        r32 = r1;
        if ((r17 & 3072) != 0) goto L46;
        if (r0.changed(r4) == false) goto L44;
        int r70 = 2048;
    L45:
        r21 = r70 | r111;
        goto L47
    L44:
        r70 = 1024;
        goto L45
    L27:
        if ((r17 & 384) != 0) goto L36;
        if (r3 != null) goto L30;
        int r140 = -1;
    L32:
        if (r0.changed(r140) == false) goto L34;
        int r141 = 256;
    L35:
        r111 = r111 | r141;
        goto L36
    L34:
        r141 = 128;
        goto L35
    L30:
        r140 = r3.ordinal();
        goto L32
    L17:
        if ((r17 & 48) != 0) goto L23;
        if (r0.changed(r1) == false) goto L21;
        int r215 = 32;
    L22:
        r111 = r111 | r215;
        goto L23
    L21:
        r215 = 16;
        goto L22
    L6:
        if ((r17 & 6) == 0) goto L8;
        r111 = r17;
        goto L13
    L8:
        if (r0.changed(r2) == false) goto L10;
        int r142 = 4;
    L11:
        r111 = r142 | r17;
        goto L13
    L10:
        r142 = 2;
        goto L11
    }
}
