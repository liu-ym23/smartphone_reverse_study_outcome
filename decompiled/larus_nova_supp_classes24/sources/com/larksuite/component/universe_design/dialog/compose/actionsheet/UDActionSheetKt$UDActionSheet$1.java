package com.larksuite.component.universe_design.dialog.compose.actionsheet;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.larksuite.component.universe_design.dialog.compose.UDListPanelDialogKt;
import com.larksuite.component.universe_design.dialog.compose.b;
import com.larksuite.component.universe_design.dialog.compose.d;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class UDActionSheetKt$UDActionSheet$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ b $cancelAction;
    final /* synthetic */ boolean $cancelOnTouchOutside;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ boolean $hideable;
    final /* synthetic */ List<d> $items;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ Dp $peekHeight;
    final /* synthetic */ String $title;
    final /* synthetic */ boolean $visible;

    public UDActionSheetKt$UDActionSheet$1(boolean r1, Function0<Unit> r2, List<d> r3, Modifier r4, String r5, b r6, boolean r7, Dp r8, boolean r9, boolean r10, int r11, int r12) {
        this.$visible = r1;
        this.$onDismissRequest = r2;
        this.$items = r3;
        this.$modifier = r4;
        this.$title = r5;
        this.$cancelAction = r6;
        this.$hideable = r7;
        this.$peekHeight = r8;
        this.$cancelable = r9;
        this.$cancelOnTouchOutside = r10;
        this.$$changed = r11;
        this.$$default = r12;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r30, int r31) {
        boolean r15 = this.$visible;
        Function0<Unit> r14 = this.$onDismissRequest;
        List<d> r13 = this.$items;
        Modifier r1 = this.$modifier;
        String r2 = this.$title;
        b r3 = this.$cancelAction;
        boolean r4 = this.$hideable;
        Dp r5 = this.$peekHeight;
        boolean r6 = this.$cancelable;
        boolean r7 = this.$cancelOnTouchOutside;
        int r12 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r11 = this.$$default;
        Intrinsics.checkNotNullParameter(r14, "onDismissRequest");
        Intrinsics.checkNotNullParameter(r13, "items");
        Composer r10 = r30.startRestartGroup(335670728);
        if ((r11 & 1) == 0) goto L6;
        int r16 = r12 | 6;
    L14:
        if ((r11 & 2) == 0) goto L17;
        r16 = r16 | 48;
    L23:
        int r9 = r16;
        if ((r11 & 4) == 0) goto L27;
        r9 = r9 | 384;
    L33:
        int r8 = r11 & 8;
        if (r8 == 0) goto L37;
        r9 = r9 | 3072;
    L43:
        int r0 = r9;
    L44:
        int r17 = r11 & 16;
        if (r17 == 0) goto L47;
        r0 = r0 | 24576;
        Modifier r19 = r1;
    L54:
        int r20 = r11 & 32;
        int r110 = 196608;
        if (r20 == 0) goto L58;
    L63:
        r0 = r0 | r110;
    L64:
        int r111 = r11 & 64;
        if (r111 == 0) goto L68;
        r0 = r0 | 1572864;
    L74:
        String r21 = r2;
        int r22 = r11 & 128;
        int r23 = 12582912;
        if (r22 == 0) goto L78;
    L76:
        r0 = r0 | r23;
    L83:
        b r24 = r3;
        int r25 = r11 & 256;
        int r26 = 100663296;
        if (r25 == 0) goto L87;
    L85:
        r0 = r0 | r26;
    L92:
        boolean r27 = r4;
        int r29 = r11 & 512;
        int r210 = 805306368;
        if (r29 == 0) goto L96;
    L94:
        r0 = r0 | r210;
    L101:
        Dp r211 = r5;
        boolean r212 = r6;
        if ((r0 & 306783379) == 306783378) goto L104;
    L107:
        if (r8 == 0) goto L110;
        r19 = Modifier.Companion;
    L110:
        if (r17 == 0) goto L112;
        r21 = null;
    L112:
        if (r20 == 0) goto L115;
        r24 = null;
    L115:
        if (r111 == 0) goto L117;
        r27 = false;
    L117:
        if (r22 == 0) goto L119;
        r211 = null;
    L119:
        if (r25 == 0) goto L121;
        r212 = true;
    L121:
        if (r29 == 0) goto L123;
        boolean r112 = true;
    L125:
        if (ComposerKt.isTraceInProgress() == false) goto L127;
        ComposerKt.traceEventStart(335670728, r0, -1, "com.larksuite.component.universe_design.dialog.compose.actionsheet.UDActionSheet (UDActionSheet.kt:22)");
    L127:
        int r32 = r0 >> 3;
        Modifier r33 = r19;
        String r34 = r21;
        b r35 = r24;
        boolean r36 = r212;
        boolean r37 = r112;
        Composer r213 = r10;
        boolean r113 = r27;
        Dp r114 = r211;
        UDListPanelDialogKt.d(r15, r14, r13, r33, r34, r35, Dp.constructor-impl(0), r36, r37, r113, r114, r213, (((((((((r0 & 14) | 1572864) | (r0 & 112)) | (r0 & 896)) | (r0 & 7168)) | (57344 & r0)) | (458752 & r0)) | (29360128 & r32)) | (r32 & 234881024)) | ((r0 << 9) & 1879048192), (r0 >> 21) & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L130;
        ComposerKt.traceEventEnd();
    L130:
        Modifier r38 = r19;
        boolean r115 = r112;
        String r39 = r21;
        b r40 = r24;
        boolean r41 = r27;
        boolean r116 = r212;
        Dp r42 = r211;
    L131:
        ScopeUpdateScope r117 = r213.endRestartGroup();
        if (r117 == null) goto L135;
        r117.updateScope(new UDActionSheetKt$UDActionSheet$1(r15, r14, r13, r38, r39, r40, r41, r42, r116, r115, r12, r11));
        return;
    L135:
        return;
    L123:
        r112 = r7;
        goto L125
    L104:
        if (r10.getSkipping() == false) goto L107;
        r10.skipToGroupEnd();
        r213 = r10;
        r38 = r19;
        r39 = r21;
        r41 = r27;
        r116 = r212;
        r42 = r211;
        r115 = r7;
        r40 = r24;
        goto L131
    L96:
        if ((r12 & 805306368) != 0) goto L101;
        if (r10.changed(r7) == false) goto L100;
        r210 = 536870912;
        goto L94
    L100:
        r210 = 268435456;
        goto L94
    L87:
        if ((r12 & 100663296) != 0) goto L92;
        if (r10.changed(r6) == false) goto L91;
        r26 = 67108864;
        goto L85
    L91:
        r26 = 33554432;
        goto L85
    L78:
        if ((r12 & 12582912) != 0) goto L83;
        if (r10.changed(r5) == false) goto L82;
        r23 = 8388608;
        goto L76
    L82:
        r23 = 4194304;
        goto L76
    L68:
        if ((r12 & 1572864) != 0) goto L74;
        if (r10.changed(r4) == false) goto L72;
        int r214 = 1048576;
    L73:
        r0 = r0 | r214;
        goto L74
    L72:
        r214 = 524288;
        goto L73
    L58:
        if ((r12 & 196608) != 0) goto L64;
        if (r10.changed(r3) == false) goto L62;
        r110 = 131072;
        goto L63
    L62:
        r110 = 65536;
        goto L63
    L47:
        r19 = r1;
        if ((r12 & 24576) != 0) goto L54;
        if (r10.changed(r2) == false) goto L52;
        int r43 = 16384;
    L53:
        r0 = r0 | r43;
        goto L54
    L52:
        r43 = 8192;
        goto L53
    L37:
        if ((r12 & 3072) != 0) goto L43;
        if (r10.changed(r1) == false) goto L41;
        int r44 = 2048;
    L42:
        r0 = r44 | r9;
        goto L44
    L41:
        r44 = 1024;
        goto L42
    L27:
        if ((r12 & 384) != 0) goto L33;
        if (r10.changedInstance(r13) == false) goto L31;
        int r45 = 256;
    L32:
        r9 = r9 | r45;
        goto L33
    L31:
        r45 = 128;
        goto L32
    L17:
        if ((r12 & 48) != 0) goto L23;
        if (r10.changedInstance(r14) == false) goto L21;
        int r118 = 32;
    L22:
        r16 = r16 | r118;
        goto L23
    L21:
        r118 = 16;
        goto L22
    L6:
        if ((r12 & 6) == 0) goto L8;
        r16 = r12;
        goto L14
    L8:
        if (r10.changed(r15) == false) goto L10;
        int r119 = 4;
    L11:
        r16 = r119 | r12;
        goto L14
    L10:
        r119 = 2;
        goto L11
    }
}
