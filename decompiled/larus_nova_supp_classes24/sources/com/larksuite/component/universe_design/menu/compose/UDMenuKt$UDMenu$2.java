package com.larksuite.component.universe_design.menu.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.larksuite.component.universe_design.menu.PositionAlign;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class UDMenuKt$UDMenu$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ PositionAlign $align;
    final /* synthetic */ a $colors;
    final /* synthetic */ Set<Integer> $dividerPositions;
    final /* synthetic */ boolean $enableEllipsize;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ UDMenuGravity $gravity;
    final /* synthetic */ List<c> $menuItems;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $offset;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ boolean $outsideTouchable;

    public UDMenuKt$UDMenu$2(boolean r1, Function0<Unit> r2, List<c> r3, Modifier r4, UDMenuGravity r5, PositionAlign r6, float r7, boolean r8, boolean r9, Set<Integer> r10, a r11, int r12, int r13, int r14) {
        this.$expanded = r1;
        this.$onDismissRequest = r2;
        this.$menuItems = r3;
        this.$modifier = r4;
        this.$gravity = r5;
        this.$align = r6;
        this.$offset = r7;
        this.$outsideTouchable = r8;
        this.$enableEllipsize = r9;
        this.$dividerPositions = r10;
        this.$colors = r11;
        this.$$changed = r12;
        this.$$changed1 = r13;
        this.$$default = r14;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r30, int r31) {
        boolean r12 = this.$expanded;
        final Function0<Unit> r13 = this.$onDismissRequest;
        final List<c> r14 = this.$menuItems;
        Modifier r1 = this.$modifier;
        UDMenuGravity r2 = this.$gravity;
        PositionAlign r3 = this.$align;
        float r4 = this.$offset;
        boolean r5 = this.$outsideTouchable;
        boolean r6 = this.$enableEllipsize;
        Set<Integer> r7 = this.$dividerPositions;
        a r8 = this.$colors;
        int r15 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r16 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed1);
        int r11 = this.$$default;
        Intrinsics.checkNotNullParameter(r13, "onDismissRequest");
        Intrinsics.checkNotNullParameter(r14, "menuItems");
        Composer r10 = r30.startRestartGroup(1197731968);
        int r19 = 4;
        if ((r11 & 1) == 0) goto L6;
        int r17 = r15 | 6;
    L14:
        if ((r11 & 2) == 0) goto L17;
        r17 = r17 | 48;
    L23:
        int r9 = r17;
        if ((r11 & 4) == 0) goto L27;
        r9 = r9 | 384;
    L33:
        int r0 = r11 & 8;
        if (r0 == 0) goto L36;
        r9 = r9 | 3072;
        boolean r110 = r12;
    L43:
        int r111 = r11 & 16;
        if (r111 == 0) goto L46;
        r9 = r9 | 24576;
        Modifier r21 = r1;
    L56:
        int r20 = r11 & 32;
        if (r20 == 0) goto L60;
        r9 = r9 | 196608;
    L69:
        r2 = r2;
        int r22 = r9;
    L70:
        int r23 = r11 & 64;
        int r24 = 1572864;
        if (r23 == 0) goto L74;
    L79:
        r22 = r22 | r24;
    L80:
        PositionAlign r25 = r3;
        int r26 = r11 & 128;
        if (r26 == 0) goto L84;
        r22 = r22 | 12582912;
    L90:
        float r27 = r4;
        int r29 = r11 & 256;
        int r210 = 100663296;
        if (r29 == 0) goto L94;
    L99:
        r22 = r22 | r210;
    L100:
        boolean r211 = r5;
        int r32 = r11 & 512;
        int r212 = 805306368;
        if (r32 == 0) goto L104;
    L109:
        r22 = r22 | r212;
    L111:
        if ((r16 & 6) == 0) goto L113;
        int r33 = r16;
    L120:
        Set<Integer> r213 = r7;
        a r112 = r8;
        if ((r22 & 306783379) == 306783378) goto L123;
    L128:
        r10.startDefaults();
        if ((r15 & 1) != 0) goto L131;
    L137:
        if (r0 == 0) goto L139;
        Modifier r34 = Modifier.Companion;
    L140:
        if (r111 == 0) goto L142;
        r2 = UDMenuGravity.Bottom;
    L142:
        if (r20 == 0) goto L144;
        PositionAlign r35 = PositionAlign.CENTER;
    L145:
        if (r23 == 0) goto L147;
        float r36 = b.c;
    L148:
        if (r26 == 0) goto L150;
        r211 = true;
    L150:
        if (r29 == 0) goto L152;
        boolean r37 = false;
    L153:
        if (r32 == 0) goto L155;
        Set<Integer> r38 = SetsKt.emptySet();
    L157:
        if ((r11 & 1024) == 0) goto L159;
        a r39 = b.a(r10);
        r33 = r33 & (-15);
    L160:
        r25 = r35;
        r6 = r37;
        r213 = r38;
        r27 = r36;
        r112 = r39;
    L161:
        r10.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L164;
        ComposerKt.traceEventStart(1197731968, r22, r33, "com.larksuite.component.universe_design.menu.compose.UDMenu (UDMenu.kt:153)");
    L164:
        int r40 = r22;
        final boolean r41 = r6;
        final Set<Integer> r42 = r213;
        final a r43 = r112;
        ComposableLambda r44 = ComposableLambdaKt.rememberComposableLambda(-1322622196, true, new UDMenuKt$UDMenu$1(r14, r41, r42, r43, r13), r10, 54);
        int r45 = ((r40 & 14) | 12582912) | (r40 & 112);
        int r46 = r40 >> 3;
        int r113 = ((((r45 | (r46 & 896)) | (r46 & 7168)) | (57344 & r46)) | (458752 & r46)) | (r46 & 3670016);
        UDMenuKt.e(r110, r13, r34, r2, r25, r27, r211, r44, r10, r113, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L167;
        ComposerKt.traceEventEnd();
    L167:
        Modifier r47 = r34;
        a r114 = r112;
        PositionAlign r48 = r25;
        UDMenuGravity r49 = r2;
        float r50 = r27;
        boolean r51 = r211;
        boolean r115 = r6;
        Set<Integer> r116 = r213;
    L168:
        ScopeUpdateScope r52 = r10.endRestartGroup();
        if (r52 == null) goto L172;
        r52.updateScope(new UDMenuKt$UDMenu$2(r110, r13, r14, r47, r49, r48, r50, r51, r115, r116, r114, r15, r16, r11));
        return;
    L172:
        return;
    L159:
        r39 = r112;
        goto L160
    L155:
        r38 = r213;
        goto L157
    L152:
        r37 = r6;
        goto L153
    L147:
        r36 = r27;
        goto L148
    L144:
        r35 = r25;
        goto L145
    L139:
        r34 = r21;
        goto L140
    L131:
        if (r10.getDefaultsInvalid() == true) goto L137;
        r10.skipToGroupEnd();
        if ((r11 & 1024) == 0) goto L136;
        r33 = r33 & (-15);
    L136:
        r34 = r21;
        goto L161
    L123:
        if ((r33 & 3) != 2) goto L128;
        if (r10.getSkipping() == false) goto L128;
        r10.skipToGroupEnd();
        r114 = r112;
        r48 = r25;
        r47 = r21;
        r49 = r2;
        r50 = r27;
        r51 = r211;
        r116 = r213;
        r115 = r6;
        goto L168
    L113:
        if ((r11 & 1024) == 0) goto L115;
    L117:
        r19 = 2;
    L118:
        r33 = r16 | r19;
        goto L120
    L115:
        if (r10.changed(r8) == false) goto L117;
    L104:
        if ((r15 & 805306368) != 0) goto L111;
        if (r10.changedInstance(r7) == false) goto L108;
        r212 = 536870912;
        goto L109
    L108:
        r212 = 268435456;
        goto L109
    L94:
        if ((r15 & 100663296) != 0) goto L100;
        if (r10.changed(r6) == false) goto L98;
        r210 = 67108864;
        goto L99
    L98:
        r210 = 33554432;
        goto L99
    L84:
        if ((r15 & 12582912) != 0) goto L90;
        if (r10.changed(r5) == false) goto L88;
        int r214 = 8388608;
    L89:
        r22 = r22 | r214;
        goto L90
    L88:
        r214 = 4194304;
        goto L89
    L74:
        if ((r15 & 1572864) != 0) goto L80;
        if (r10.changed(r4) == false) goto L78;
        r24 = 1048576;
        goto L79
    L78:
        r24 = 524288;
        goto L79
    L60:
        if ((r15 & 196608) != 0) goto L69;
        if (r3 != null) goto L63;
        int r53 = -1;
    L65:
        if (r10.changed(r53) == false) goto L67;
        int r54 = 131072;
    L68:
        r22 = r54 | r9;
        goto L70
    L67:
        r54 = 65536;
        goto L68
    L63:
        r53 = r3.ordinal();
        goto L65
    L46:
        r21 = r1;
        if ((r15 & 24576) != 0) goto L56;
        if (r2 != null) goto L50;
        int r55 = -1;
    L52:
        if (r10.changed(r55) == false) goto L54;
        int r56 = 16384;
    L55:
        r9 = r9 | r56;
        goto L56
    L54:
        r56 = 8192;
        goto L55
    L50:
        r55 = r2.ordinal();
        goto L52
    L36:
        r110 = r12;
        if ((r15 & 3072) != 0) goto L43;
        if (r10.changed(r1) == false) goto L41;
        int r117 = 2048;
    L42:
        r9 = r9 | r117;
        goto L43
    L41:
        r117 = 1024;
        goto L42
    L27:
        if ((r15 & 384) != 0) goto L33;
        if (r10.changedInstance(r14) == false) goto L31;
        int r57 = 256;
    L32:
        r9 = r9 | r57;
        goto L33
    L31:
        r57 = 128;
        goto L32
    L17:
        if ((r15 & 48) != 0) goto L23;
        if (r10.changedInstance(r13) == false) goto L21;
        int r215 = 32;
    L22:
        r17 = r17 | r215;
        goto L23
    L21:
        r215 = 16;
        goto L22
    L6:
        if ((r15 & 6) == 0) goto L8;
        r17 = r15;
        goto L14
    L8:
        if (r10.changed(r12) == false) goto L10;
        int r118 = 4;
    L11:
        r17 = r118 | r15;
        goto L14
    L10:
        r118 = 2;
        goto L11
    }
}
