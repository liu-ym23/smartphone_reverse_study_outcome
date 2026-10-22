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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class UDNoticeKt$UDNotice$2 extends Lambda implements Function2<Composer, Integer, Unit> {
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
    final /* synthetic */ Function1<String, Unit> $onTextActionClick;
    final /* synthetic */ float $radius;
    final /* synthetic */ AnnotatedString $text;
    final /* synthetic */ a $textButton;
    final /* synthetic */ UDNoticeTextButtonPosition $textButtonPosition;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ UDNoticeType $type;

    /* JADX WARN: Multi-variable type inference failed */
    public UDNoticeKt$UDNotice$2(AnnotatedString r3, Modifier r4, UDNoticeType r5, ImageVector r6, boolean r7, ImageVector r8, String r9, Function0<Unit> r10, a r11, UDNoticeTextButtonPosition r12, UDNoticeGravity r13, float r14, boolean r15, b r16, TextStyle r17, Function1<? super String, Unit> r19, Painter r110, Painter r20, int r21, int r22, int r23) {
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
        this.$onTextActionClick = r19;
        this.$iconPainter = r110;
        this.$iconButtonPainter = r20;
        this.$$changed = r21;
        this.$$changed1 = r22;
        this.$$default = r23;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r54, int r55) {
        AnnotatedString r13 = this.$text;
        Modifier r1 = this.$modifier;
        UDNoticeType r2 = this.$type;
        ImageVector r3 = this.$icon;
        boolean r4 = this.$iconColorful;
        ImageVector r5 = this.$iconButton;
        String r6 = this.$iconButtonContentDescription;
        Function0<Unit> r7 = this.$onIconButtonClick;
        UDNoticeTextButtonPosition r8 = this.$textButtonPosition;
        UDNoticeGravity r9 = this.$gravity;
        float r10 = this.$radius;
        boolean r11 = this.$marquee;
        b r12 = this.$colors;
        TextStyle r14 = this.$textStyle;
        Function1<String, Unit> r15 = this.$onTextActionClick;
        Painter r16 = this.$iconPainter;
        Painter r17 = this.$iconButtonPainter;
        int r19 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r110 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed1);
        int r111 = this.$$default;
        float r21 = d.a;
        Intrinsics.checkNotNullParameter(r13, "text");
        Composer r0 = r54.startRestartGroup(482179311);
        int r22 = 2;
        if ((r111 & 1) == 0) goto L6;
        int r112 = r19 | 6;
    L13:
        int r24 = r111 & 2;
        int r25 = 16;
        if (r24 == 0) goto L17;
        r112 = r112 | 48;
    L23:
        int r27 = r111 & 4;
        int r29 = 128;
        if (r27 == 0) goto L26;
        r112 = r112 | 384;
        Modifier r31 = r1;
    L36:
        int r20 = r111 & 8;
        int r32 = 2048;
        if (r20 == 0) goto L39;
        r112 = r112 | 3072;
        UDNoticeType r56 = r2;
    L46:
        int r23 = r112;
    L47:
        int r113 = r111 & 16;
        int r34 = 16384;
        if (r113 == 0) goto L50;
        r23 = r23 | 24576;
        ImageVector r36 = r3;
    L57:
        int r26 = r111 & 32;
        if (r26 == 0) goto L61;
        r23 = r23 | 196608;
    L67:
        int r40 = r111 & 64;
        if (r40 == 0) goto L71;
        r23 = r23 | 1572864;
    L77:
        boolean r42 = r4;
        int r30 = r111 & 128;
        if (r30 == 0) goto L81;
        r23 = r23 | 12582912;
    L87:
        ImageVector r44 = r5;
        String r45 = r6;
        if ((r111 & 256) == 0) goto L91;
        r23 = r23 | 100663296;
    L97:
        int r33 = r111 & 512;
        if (r33 == 0) goto L101;
        r23 = r23 | 805306368;
    L110:
        int r35 = r111 & 1024;
        if (r35 == 0) goto L114;
        int r210 = r110 | 6;
        r7 = r7;
    L123:
        int r37 = r111 & 2048;
        if (r37 == 0) goto L127;
        r210 = r210 | 48;
    L132:
        int r38 = r210;
        int r39 = r111 & 4096;
        if (r39 == 0) goto L135;
        r38 = r38 | 384;
        float r211 = r10;
    L141:
        boolean r114 = r11;
    L142:
        boolean r212 = r114;
        if ((r110 & 3072) == 0) goto L145;
        b r115 = r12;
    L153:
        b r213 = r115;
        if ((r110 & 24576) == 0) goto L156;
        TextStyle r116 = r14;
    L164:
        int r117 = r111 & 32768;
        if (r117 == 0) goto L168;
        r38 = r38 | 196608;
    L174:
        Function1<String, Unit> r118 = r15;
    L175:
        int r119 = r111 & 65536;
        if (r119 == 0) goto L179;
        r38 = r38 | 1572864;
    L185:
        Painter r120 = r16;
    L186:
        int r121 = r111 & 131072;
        if (r121 == 0) goto L190;
        r38 = r38 | 12582912;
    L196:
        Painter r122 = r17;
    L197:
        Painter r310 = r122;
        if ((r23 & 306783379) == 306783378) goto L200;
    L205:
        r0.startDefaults();
        if ((r19 & 1) != 0) goto L208;
    L217:
        if (r24 == 0) goto L219;
        r31 = Modifier.Companion;
    L219:
        if (r27 == 0) goto L221;
        UDNoticeType r123 = UDNoticeType.Info;
    L222:
        if (r20 == 0) goto L225;
        r36 = null;
    L225:
        if (r113 == 0) goto L227;
        r42 = false;
    L227:
        if (r26 == 0) goto L229;
        r44 = null;
    L229:
        if (r40 == 0) goto L231;
        r45 = null;
    L231:
        if (r30 == 0) goto L233;
        r7 = null;
    L233:
        if (r33 == 0) goto L235;
        UDNoticeTextButtonPosition r41 = UDNoticeTextButtonPosition.Right;
    L236:
        if (r35 == 0) goto L238;
        UDNoticeGravity r43 = UDNoticeGravity.Left;
    L239:
        if (r37 == 0) goto L241;
        float r46 = Dp.constructor-impl(0);
    L242:
        if (r39 == 0) goto L244;
        boolean r124 = false;
    L246:
        if ((r111 & 8192) == 0) goto L248;
        b r47 = c.a(r123, r0, ((r23 >> 6) & 14) | 48);
        r38 = r38 & (-7169);
    L250:
        if ((r111 & 16384) == 0) goto L252;
        TextStyle r125 = i0.b(r0).d;
        r38 = (-57345) & r38;
    L253:
        if (r117 == 0) goto L255;
        r118 = null;
    L255:
        if (r119 == 0) goto L257;
        r120 = null;
    L257:
        if (r121 == 0) goto L259;
        r310 = null;
    L259:
        UDNoticeTextButtonPosition r311 = r41;
        UDNoticeGravity r312 = r43;
        float r313 = r46;
        UDNoticeType r314 = r123;
        boolean r315 = r124;
        TextStyle r316 = r125;
        Function1<String, Unit> r48 = r118;
        Painter r49 = r120;
        Painter r410 = r310;
        Modifier r317 = r31;
        b r126 = r47;
    L260:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L263;
        ComposerKt.traceEventStart(482179311, r23, r38, "com.larksuite.component.universe_design.notice.compose.UDNotice (UDNotice.kt:150)");
    L263:
        int r50 = r23 << 3;
        int r214 = (((((((r23 & 14) | (r23 & 112)) | ((r23 >> 3) & 896)) | ((r38 >> 9) & 7168)) | (458752 & r50)) | (r50 & 3670016)) | (29360128 & r38)) | ((r23 << 6) & 234881024);
        int r51 = r23 >> 21;
        int r52 = ((r51 & 112) | (r51 & 14)) | ((r23 >> 18) & 7168);
        int r53 = r38 << 12;
        int r318 = ((r52 | (57344 & r53)) | (458752 & r53)) | (r53 & 3670016);
        int r57 = r38 >> 12;
        b r59 = r126;
        d.a(r13, r317, r36, r49, r126.c, r42, r44, r410, r45, r126.d, r7, r126.e, r311, r312, r313, r315, r126.a, r126.b, r126.f, r316, r48, r0, r214, r318, (r57 & 14) | (r57 & 112));
        if (ComposerKt.isTraceInProgress() == false) goto L266;
        ComposerKt.traceEventEnd();
    L266:
        Modifier r60 = r317;
        UDNoticeType r61 = r314;
        UDNoticeTextButtonPosition r127 = r311;
        UDNoticeGravity r128 = r312;
        ImageVector r62 = r36;
        float r129 = r313;
        boolean r130 = r315;
        TextStyle r131 = r316;
        Function1<String, Unit> r132 = r48;
        Painter r133 = r49;
        boolean r63 = r42;
        Painter r134 = r410;
        ImageVector r64 = r44;
        String r65 = r45;
        Function0<Unit> r66 = r7;
        b r135 = r59;
    L267:
        ScopeUpdateScope r67 = r0.endRestartGroup();
        if (r67 == null) goto L271;
        r67.updateScope(new UDNoticeKt$UDNotice$2(r13, r60, r61, r62, r63, r64, r65, r66, null, r127, r128, r129, r130, r135, r131, r132, r133, r134, r19, r110, r111));
        return;
    L271:
        return;
    L252:
        r125 = r116;
        goto L253
    L248:
        r47 = r213;
        goto L250
    L244:
        r124 = r212;
        goto L246
    L241:
        r46 = r211;
        goto L242
    L238:
        r43 = r9;
        goto L239
    L235:
        r41 = r8;
        goto L236
    L221:
        r123 = r56;
        goto L222
    L208:
        if (r0.getDefaultsInvalid() == true) goto L217;
        r0.skipToGroupEnd();
        if ((r111 & 8192) == 0) goto L214;
        r38 = r38 & (-7169);
    L214:
        if ((r111 & 16384) == 0) goto L216;
        r38 = r38 & (-57345);
    L216:
        r314 = r56;
        r126 = r213;
        r315 = r212;
        r312 = r9;
        r311 = r8;
        r313 = r211;
        r316 = r116;
        r48 = r118;
        r49 = r120;
        r410 = r310;
        r317 = r31;
        goto L260
    L200:
        if ((4793491 & r38) != 4793490) goto L205;
        if (r0.getSkipping() == false) goto L205;
        r0.skipToGroupEnd();
        r61 = r56;
        r135 = r213;
        r130 = r212;
        r128 = r9;
        r127 = r8;
        r129 = r211;
        r131 = r116;
        r132 = r118;
        r133 = r120;
        r134 = r310;
        r60 = r31;
        r62 = r36;
        r63 = r42;
        r64 = r44;
        r65 = r45;
        r66 = r7;
        goto L267
    L190:
        if ((r110 & 12582912) != 0) goto L196;
        r122 = r17;
        if (r0.changedInstance(r122) == false) goto L194;
        int r136 = 8388608;
    L195:
        r38 = r38 | r136;
        goto L197
    L194:
        r136 = 4194304;
        goto L195
    L179:
        if ((r110 & 1572864) != 0) goto L185;
        r120 = r16;
        if (r0.changedInstance(r120) == false) goto L183;
        int r137 = 1048576;
    L184:
        r38 = r38 | r137;
        goto L186
    L183:
        r137 = 524288;
        goto L184
    L168:
        if ((r110 & 196608) != 0) goto L174;
        r118 = r15;
        if (r0.changedInstance(r118) == false) goto L172;
        int r138 = 131072;
    L173:
        r38 = r38 | r138;
        goto L175
    L172:
        r138 = 65536;
        goto L173
    L156:
        if ((r111 & 16384) != 0) goto L160;
        r116 = r14;
        if (r0.changed(r116) == true) goto L162;
    L161:
        r34 = 8192;
    L162:
        r38 = r38 | r34;
        goto L164
    L160:
        r116 = r14;
        goto L161
    L145:
        if ((r111 & 8192) != 0) goto L149;
        r115 = r12;
        if (r0.changed(r115) == true) goto L151;
    L150:
        r32 = 1024;
    L151:
        r38 = r38 | r32;
        goto L153
    L149:
        r115 = r12;
        goto L150
    L135:
        r211 = r10;
        if ((r110 & 384) != 0) goto L141;
        r114 = r11;
        if (r0.changed(r114) == false) goto L140;
        r29 = 256;
    L140:
        r38 = r38 | r29;
        goto L142
    L127:
        if ((r110 & 48) != 0) goto L132;
        if (r0.changed(r10) == false) goto L131;
        r25 = 32;
    L131:
        r210 = r210 | r25;
        goto L132
    L114:
        if ((r110 & 6) != 0) goto L122;
        if (r9 != null) goto L117;
        int r68 = -1;
    L119:
        if (r0.changed(r68) == false) goto L121;
        r22 = 4;
    L121:
        r210 = r110 | r22;
        goto L123
    L117:
        r68 = r9.ordinal();
        goto L119
    L122:
        r7 = r7;
        r210 = r110;
        goto L123
    L101:
        if ((r19 & 805306368) != 0) goto L110;
        if (r8 != null) goto L104;
        int r69 = -1;
    L106:
        if (r0.changed(r69) == false) goto L108;
        int r70 = 536870912;
    L109:
        r23 = r23 | r70;
        goto L110
    L108:
        r70 = 268435456;
        goto L109
    L104:
        r69 = r8.ordinal();
        goto L106
    L91:
        if ((r19 & 100663296) != 0) goto L97;
        if (r0.changed(null) == false) goto L95;
        int r71 = 67108864;
    L96:
        r23 = r23 | r71;
        goto L97
    L95:
        r71 = 33554432;
        goto L96
    L81:
        if ((r19 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r7) == false) goto L85;
        int r411 = 8388608;
    L86:
        r23 = r23 | r411;
        goto L87
    L85:
        r411 = 4194304;
        goto L86
    L71:
        if ((r19 & 1572864) != 0) goto L77;
        if (r0.changed(r6) == false) goto L75;
        int r412 = 1048576;
    L76:
        r23 = r23 | r412;
        goto L77
    L75:
        r412 = 524288;
        goto L76
    L61:
        if ((r19 & 196608) != 0) goto L67;
        if (r0.changed(r5) == false) goto L65;
        int r413 = 131072;
    L66:
        r23 = r23 | r413;
        goto L67
    L65:
        r413 = 65536;
        goto L66
    L50:
        r36 = r3;
        if ((r19 & 24576) != 0) goto L57;
        if (r0.changed(r4) == false) goto L55;
        int r72 = 16384;
    L56:
        r23 = r23 | r72;
        goto L57
    L55:
        r72 = 8192;
        goto L56
    L39:
        r56 = r2;
        if ((r19 & 3072) != 0) goto L46;
        if (r0.changed(r3) == false) goto L44;
        int r73 = 2048;
    L45:
        r23 = r73 | r112;
        goto L47
    L44:
        r73 = 1024;
        goto L45
    L26:
        r31 = r1;
        if ((r19 & 384) != 0) goto L36;
        if (r2 != null) goto L30;
        int r74 = -1;
    L32:
        if (r0.changed(r74) == false) goto L34;
        int r75 = 256;
    L35:
        r112 = r112 | r75;
        goto L36
    L34:
        r75 = 128;
        goto L35
    L30:
        r74 = r2.ordinal();
        goto L32
    L17:
        if ((r19 & 48) != 0) goto L23;
        if (r0.changed(r1) == false) goto L21;
        int r215 = 32;
    L22:
        r112 = r112 | r215;
        goto L23
    L21:
        r215 = 16;
        goto L22
    L6:
        if ((r19 & 6) == 0) goto L8;
        r112 = r19;
        goto L13
    L8:
        if (r0.changed(r13) == false) goto L10;
        int r139 = 4;
    L11:
        r112 = r139 | r19;
        goto L13
    L10:
        r139 = 2;
        goto L11
    }
}
