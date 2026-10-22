package com.larksuite.component.universe_design.dialog.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.KeyboardType;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class UDInputDialogKt$UDInputDialog$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ UDDialogActionOrientation $actionOrientation;
    final /* synthetic */ List<b> $actions;
    final /* synthetic */ boolean $cancelOnTouchOutside;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ String $hint;
    final /* synthetic */ int $keyboardType;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ String $message;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ Function1<String, Unit> $onTextChange;
    final /* synthetic */ boolean $requestFocus;
    final /* synthetic */ boolean $requireInput;
    final /* synthetic */ String $text;
    final /* synthetic */ String $title;
    final /* synthetic */ boolean $visible;

    /* JADX WARN: Multi-variable type inference failed */
    public UDInputDialogKt$UDInputDialog$2(boolean r3, Function0<Unit> r4, String r5, Function1<? super String, Unit> r6, Modifier r7, String r8, String r9, String r10, int r11, boolean r12, boolean r13, int r14, List<b> r15, UDDialogActionOrientation r16, boolean r17, boolean r19, int r110, int r20, int r21) {
        this.$visible = r3;
        this.$onDismissRequest = r4;
        this.$text = r5;
        this.$onTextChange = r6;
        this.$modifier = r7;
        this.$title = r8;
        this.$message = r9;
        this.$hint = r10;
        this.$maxLines = r11;
        this.$requireInput = r12;
        this.$requestFocus = r13;
        this.$keyboardType = r14;
        this.$actions = r15;
        this.$actionOrientation = r16;
        this.$cancelable = r17;
        this.$cancelOnTouchOutside = r19;
        this.$$changed = r110;
        this.$$changed1 = r20;
        this.$$default = r21;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r46, int r47) {
        boolean r15 = this.$visible;
        Function0<Unit> r14 = this.$onDismissRequest;
        String r13 = this.$text;
        Function1<String, Unit> r12 = this.$onTextChange;
        Modifier r1 = this.$modifier;
        String r2 = this.$title;
        String r3 = this.$message;
        String r4 = this.$hint;
        int r5 = this.$maxLines;
        boolean r6 = this.$requireInput;
        boolean r7 = this.$requestFocus;
        int r8 = this.$keyboardType;
        List<b> r9 = this.$actions;
        UDDialogActionOrientation r10 = this.$actionOrientation;
        boolean r11 = this.$cancelable;
        boolean r16 = this.$cancelOnTouchOutside;
        UDDialogActionOrientation r19 = r10;
        int r17 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r110 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed1);
        int r20 = this.$$default;
        Intrinsics.checkNotNullParameter(r14, "onDismissRequest");
        Intrinsics.checkNotNullParameter(r13, "text");
        Intrinsics.checkNotNullParameter(r12, "onTextChange");
        Composer r21 = r46.startRestartGroup(-633759129);
        int r22 = 2;
        if ((r20 & 1) == 0) goto L6;
        int r23 = r17 | 6;
    L13:
        int r25 = 16;
        if ((r20 & 2) == 0) goto L17;
        r23 = r23 | 48;
    L23:
        int r0 = r23;
        int r27 = 128;
        if ((r20 & 4) == 0) goto L27;
        r0 = r0 | 384;
    L33:
        int r24 = 2048;
        if ((r20 & 8) == 0) goto L37;
        r0 = r0 | 3072;
    L43:
        int r111 = r20 & 16;
        int r30 = 16384;
        if (r111 == 0) goto L46;
        r0 = r0 | 24576;
        boolean r32 = r15;
    L53:
        int r112 = r20 & 32;
        int r33 = 65536;
        if (r112 == 0) goto L57;
        r0 = r0 | 196608;
    L63:
        int r36 = r20 & 64;
        int r37 = 1572864;
        if (r36 == 0) goto L67;
    L72:
        r0 = r0 | r37;
    L73:
        Modifier r38 = r1;
        int r26 = r20 & 128;
        int r39 = 12582912;
        if (r26 == 0) goto L77;
    L82:
        r0 = r0 | r39;
    L83:
        String r310 = r2;
        int r29 = r20 & 256;
        int r311 = 100663296;
        if (r29 == 0) goto L87;
    L92:
        r0 = r0 | r311;
    L93:
        String r312 = r3;
        int r31 = r20 & 512;
        String r40 = r4;
        int r41 = 805306368;
        if (r31 == 0) goto L97;
    L102:
        r0 = r0 | r41;
    L103:
        int r34 = r20 & 1024;
        if (r34 == 0) goto L107;
        int r210 = r110 | 6;
    L113:
        int r211 = r5;
        int r35 = r20 & 2048;
        if (r35 == 0) goto L117;
        r210 = r210 | 48;
    L122:
        int r212 = r8;
        int r42 = r210;
    L123:
        boolean r213 = r7;
        int r43 = r20 & 4096;
        if (r43 == 0) goto L126;
        r42 = r42 | 384;
        int r214 = r17;
    L132:
        List<b> r113 = r9;
    L133:
        List<b> r114 = r113;
        int r115 = r20 & 8192;
        if (r115 == 0) goto L136;
        r42 = r42 | 3072;
        Function1<String, Unit> r215 = r12;
    L146:
        int r116 = r20 & 16384;
        if (r116 == 0) goto L149;
        r42 = r42 | 24576;
        String r216 = r13;
    L156:
        boolean r117 = r11;
    L157:
        int r118 = r20 & 32768;
        if (r118 == 0) goto L161;
        r42 = r42 | 196608;
    L166:
        boolean r44 = r16;
    L167:
        boolean r217 = r44;
        if ((r0 & 306783379) == 306783378) goto L170;
    L175:
        if (r111 == 0) goto L178;
        r38 = Modifier.Companion;
    L178:
        if (r112 == 0) goto L180;
        r310 = null;
    L180:
        if (r36 == 0) goto L182;
        r312 = null;
    L182:
        if (r26 == 0) goto L184;
        r40 = null;
    L184:
        if (r29 == 0) goto L187;
        r211 = 1;
    L187:
        if (r31 == 0) goto L189;
        r6 = false;
    L189:
        if (r34 == 0) goto L191;
        r213 = false;
    L191:
        if (r35 == 0) goto L193;
        r212 = KeyboardType.Companion.getText-PjHm6EE();
    L193:
        if (r43 == 0) goto L195;
        List<b> r119 = CollectionsKt.emptyList();
    L196:
        if (r115 == 0) goto L198;
        r19 = UDDialogActionOrientation.Auto;
    L198:
        if (r116 == 0) goto L200;
        boolean r120 = true;
    L201:
        if (r118 == 0) goto L204;
        r217 = true;
    L204:
        if (ComposerKt.isTraceInProgress() == false) goto L206;
        ComposerKt.traceEventStart(-633759129, r0, r42, "com.larksuite.component.universe_design.dialog.compose.UDInputDialog (UDInputDialog.kt:43)");
    L206:
        r21.startReplaceGroup(-1746271574);
        boolean r45 = r21.changed(r119);
        if ((r0 & 1879048192) != 536870912) goto L209;
        boolean r48 = true;
    L210:
        boolean r49 = r45 | r48;
        if ((r0 & 896) != 256) goto L213;
        boolean r50 = true;
    L214:
        boolean r51 = r49 | r50;
        Object r52 = r21.rememberedValue();
        if (r51 == true) goto L218;
        Object r53 = r52;
        if (r52 == Composer.Companion.getEmpty()) goto L218;
    L239:
        List r121 = (List) r53;
        r21.endReplaceGroup();
        final String r54 = r216;
        final Function1<String, Unit> r55 = r215;
        final String r56 = r40;
        final int r57 = r211;
        int r122 = r42;
        final boolean r59 = r213;
        final int r60 = r212;
        int r61 = (r0 & 14) | (r0 & 112);
        int r62 = r0 >> 6;
        int r63 = (r62 & 57344) | ((r61 | (r62 & 896)) | (r62 & 7168));
        int r64 = r122 << 9;
        Composer r123 = r21;
        List<b> r313 = r119;
        UDDialogKt.g(r32, r14, r38, r310, r312, r121, r19, r120, r217, r213, ComposableLambdaKt.rememberComposableLambda(-1793555236, true, new UDInputDialogKt$UDInputDialog$1(r54, r55, r56, r57, r59, r60), r21, 54), r123, (((r63 | (3670016 & r64)) | (29360128 & r64)) | (r64 & 234881024)) | ((r122 << 27) & 1879048192), 6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L242;
        ComposerKt.traceEventEnd();
    L242:
        UDDialogActionOrientation r124 = r19;
        int r125 = r212;
        boolean r126 = r213;
        int r127 = r211;
        List<b> r128 = r313;
        Modifier r65 = r38;
        String r66 = r310;
        String r67 = r312;
        String r68 = r40;
        boolean r129 = r6;
    L243:
        ScopeUpdateScope r69 = r123.endRestartGroup();
        if (r69 == null) goto L251;
        r69.updateScope(new UDInputDialogKt$UDInputDialog$2(r32, r14, r216, r215, r65, r66, r67, r68, r127, r129, r126, r125, r128, r124, r120, r217, r214, r110, r20));
        return;
    L251:
        return;
    L218:
        List<b> r70 = r119;
        ArrayList r71 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r70, 10));
        Iterator<T> r72 = r70.iterator();
    L220:
        if (r72.hasNext() == false) goto L238;
        b r73 = (b) r72.next();
        if (r6 == false) goto L237;
        UDDialogActionRole r74 = r73.c;
        if (r74 == UDDialogActionRole.Primary) goto L228;
        if (r74 != UDDialogActionRole.Danger) goto L237;
    L228:
        if (r73.d == true) goto L230;
    L235:
        boolean r75 = false;
    L236:
        r73 = b.a(r73, r75);
        goto L237
    L230:
        if (r216.length() <= 0) goto L232;
        boolean r76 = true;
    L233:
        if (r76 == false) goto L235;
        r75 = true;
        goto L236
    L232:
        r76 = false;
    L237:
        r71.add(r73);
        goto L220
    L238:
        r21.updateRememberedValue(r71);
        r53 = r71;
        goto L239
    L213:
        r50 = false;
        goto L214
    L209:
        r48 = false;
        goto L210
    L200:
        r120 = r117;
        goto L201
    L195:
        r119 = r114;
        goto L196
    L170:
        if ((74899 & r42) != 74898) goto L175;
        if (r21.getSkipping() == false) goto L175;
        r21.skipToGroupEnd();
        r123 = r21;
        r124 = r19;
        r128 = r114;
        r126 = r213;
        r127 = r211;
        r65 = r38;
        r66 = r310;
        r67 = r312;
        r68 = r40;
        r129 = r6;
        r120 = r117;
        r125 = r212;
        goto L243
    L161:
        if ((r110 & 196608) != 0) goto L166;
        r44 = r16;
        if (r21.changed(r44) == false) goto L165;
        r33 = 131072;
    L165:
        r42 = r42 | r33;
        goto L167
    L149:
        r216 = r13;
        if ((r110 & 24576) != 0) goto L156;
        r117 = r11;
        if (r21.changed(r117) == true) goto L155;
        r30 = 8192;
    L155:
        r42 = r42 | r30;
        goto L157
    L136:
        r215 = r12;
        if ((r110 & 3072) != 0) goto L146;
        if (r19 != null) goto L140;
        int r130 = -1;
    L142:
        if (r21.changed(r130) == true) goto L145;
        r24 = 1024;
    L145:
        r42 = r42 | r24;
        goto L146
    L140:
        r130 = r19.ordinal();
        goto L142
    L126:
        r214 = r17;
        if ((r110 & 384) != 0) goto L132;
        r113 = r9;
        if (r21.changedInstance(r113) == false) goto L131;
        r27 = 256;
    L131:
        r42 = r42 | r27;
        goto L133
    L117:
        if ((r110 & 48) != 0) goto L122;
        if (r21.changed(r8) == false) goto L121;
        r25 = 32;
    L121:
        r212 = r8;
        r42 = r210 | r25;
        goto L123
    L107:
        if ((r110 & 6) == 0) goto L109;
        r210 = r110;
        goto L113
    L109:
        if (r21.changed(r7) == false) goto L111;
        r22 = 4;
    L111:
        r210 = r110 | r22;
        goto L113
    L97:
        if ((r17 & 805306368) != 0) goto L103;
        if (r21.changed(r6) == false) goto L101;
        r41 = 536870912;
        goto L102
    L101:
        r41 = 268435456;
        goto L102
    L87:
        if ((r17 & 100663296) != 0) goto L93;
        if (r21.changed(r5) == false) goto L91;
        r311 = 67108864;
        goto L92
    L91:
        r311 = 33554432;
        goto L92
    L77:
        if ((r17 & 12582912) != 0) goto L83;
        if (r21.changed(r4) == false) goto L81;
        r39 = 8388608;
        goto L82
    L81:
        r39 = 4194304;
        goto L82
    L67:
        if ((r17 & 1572864) != 0) goto L73;
        if (r21.changed(r3) == false) goto L71;
        r37 = 1048576;
        goto L72
    L71:
        r37 = 524288;
        goto L72
    L57:
        if ((r17 & 196608) != 0) goto L63;
        if (r21.changed(r2) == false) goto L61;
        int r314 = 131072;
    L62:
        r0 = r0 | r314;
        goto L63
    L61:
        r314 = 65536;
        goto L62
    L46:
        r32 = r15;
        if ((r17 & 24576) != 0) goto L53;
        if (r21.changed(r1) == false) goto L51;
        int r131 = 16384;
    L52:
        r0 = r0 | r131;
        goto L53
    L51:
        r131 = 8192;
        goto L52
    L37:
        if ((r17 & 3072) != 0) goto L43;
        if (r21.changedInstance(r12) == false) goto L41;
        int r132 = 2048;
    L42:
        r0 = r0 | r132;
        goto L43
    L41:
        r132 = 1024;
        goto L42
    L27:
        if ((r17 & 384) != 0) goto L33;
        if (r21.changed(r13) == false) goto L31;
        int r133 = 256;
    L32:
        r0 = r0 | r133;
        goto L33
    L31:
        r133 = 128;
        goto L32
    L17:
        if ((r17 & 48) != 0) goto L23;
        if (r21.changedInstance(r14) == false) goto L21;
        int r218 = 32;
    L22:
        r23 = r23 | r218;
        goto L23
    L21:
        r218 = 16;
        goto L22
    L6:
        if ((r17 & 6) == 0) goto L8;
        r23 = r17;
        goto L13
    L8:
        if (r21.changed(r15) == false) goto L10;
        int r219 = 4;
    L11:
        r23 = r219 | r17;
        goto L13
    L10:
        r219 = 2;
        goto L11
    }
}
