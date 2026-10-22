package com.larksuite.component.universe_design.dialog.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
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
final class UDCheckBoxDialogKt$UDCheckBoxDialog$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ UDDialogActionOrientation $actionOrientation;
    final /* synthetic */ List<b> $actions;
    final /* synthetic */ boolean $cancelOnTouchOutside;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ boolean $checked;
    final /* synthetic */ String $hint;
    final /* synthetic */ String $message;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Boolean, Unit> $onCheckedChange;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ boolean $requireCheck;
    final /* synthetic */ String $title;
    final /* synthetic */ boolean $visible;

    /* JADX WARN: Multi-variable type inference failed */
    public UDCheckBoxDialogKt$UDCheckBoxDialog$2(boolean r3, Function0<Unit> r4, boolean r5, Function1<? super Boolean, Unit> r6, String r7, Modifier r8, String r9, String r10, boolean r11, List<b> r12, UDDialogActionOrientation r13, boolean r14, boolean r15, int r16, int r17, int r19) {
        this.$visible = r3;
        this.$onDismissRequest = r4;
        this.$checked = r5;
        this.$onCheckedChange = r6;
        this.$hint = r7;
        this.$modifier = r8;
        this.$title = r9;
        this.$message = r10;
        this.$requireCheck = r11;
        this.$actions = r12;
        this.$actionOrientation = r13;
        this.$cancelable = r14;
        this.$cancelOnTouchOutside = r15;
        this.$$changed = r16;
        this.$$changed1 = r17;
        this.$$default = r19;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r37, int r38) {
        boolean r14 = this.$visible;
        Function0<Unit> r15 = this.$onDismissRequest;
        final boolean r13 = this.$checked;
        final Function1<Boolean, Unit> r12 = this.$onCheckedChange;
        final String r11 = this.$hint;
        Modifier r1 = this.$modifier;
        String r2 = this.$title;
        String r3 = this.$message;
        boolean r4 = this.$requireCheck;
        List<b> r5 = this.$actions;
        UDDialogActionOrientation r6 = this.$actionOrientation;
        boolean r7 = this.$cancelable;
        boolean r8 = this.$cancelOnTouchOutside;
        int r9 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r10 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed1);
        int r16 = this.$$default;
        Intrinsics.checkNotNullParameter(r15, "onDismissRequest");
        Intrinsics.checkNotNullParameter(r12, "onCheckedChange");
        Intrinsics.checkNotNullParameter(r11, "hint");
        Composer r17 = r37.startRestartGroup(1132651578);
        int r19 = 2;
        if ((r16 & 1) == 0) goto L6;
        int r110 = r9 | 6;
    L13:
        int r22 = 16;
        if ((r16 & 2) == 0) goto L17;
        r110 = r110 | 48;
    L23:
        int r0 = r110;
        int r24 = 128;
        if ((r16 & 4) == 0) goto L27;
        r0 = r0 | 384;
    L34:
        if ((r16 & 8) == 0) goto L37;
        r0 = r0 | 3072;
    L44:
        if ((r16 & 16) == 0) goto L47;
        r0 = r0 | 24576;
    L53:
        int r111 = r16 & 32;
        int r112 = 196608;
        if (r111 == 0) goto L57;
    L62:
        r0 = r0 | r112;
    L63:
        int r113 = r16 & 64;
        int r26 = 1572864;
        if (r113 == 0) goto L67;
    L72:
        r0 = r0 | r26;
    L73:
        Modifier r27 = r1;
        int r20 = r16 & 128;
        int r29 = 12582912;
        if (r20 == 0) goto L77;
    L82:
        r0 = r0 | r29;
    L83:
        String r210 = r2;
        int r21 = r16 & 256;
        int r211 = 100663296;
        if (r21 == 0) goto L87;
    L92:
        r0 = r0 | r211;
    L93:
        int r23 = r16 & 512;
        if (r23 == 0) goto L97;
        r0 = r0 | 805306368;
    L103:
        boolean r31 = r4;
        int r25 = r16 & 1024;
        if (r25 == 0) goto L107;
        int r114 = r10 | 6;
        r5 = r5;
    L116:
        int r30 = r16 & 2048;
        if (r30 == 0) goto L120;
        r114 = r114 | 48;
    L125:
        boolean r115 = r7;
        int r32 = r114;
    L126:
        int r33 = r16 & 4096;
        if (r33 == 0) goto L129;
        r32 = r32 | 384;
        int r212 = r16;
    L135:
        boolean r34 = r8;
    L136:
        boolean r213 = r34;
        if ((r0 & 306783379) == 306783378) goto L139;
    L144:
        if (r111 == 0) goto L147;
        r27 = Modifier.Companion;
    L147:
        if (r113 == 0) goto L149;
        r210 = null;
    L149:
        if (r20 == 0) goto L151;
        final String r116 = null;
    L153:
        if (r21 == 0) goto L155;
        r31 = false;
    L155:
        if (r23 == 0) goto L157;
        List<b> r117 = CollectionsKt.emptyList();
    L158:
        if (r25 == 0) goto L160;
        r6 = UDDialogActionOrientation.Auto;
    L160:
        if (r30 == 0) goto L162;
        r115 = true;
    L162:
        if (r33 == 0) goto L165;
        r213 = true;
    L165:
        if (ComposerKt.isTraceInProgress() == false) goto L167;
        ComposerKt.traceEventStart(1132651578, r0, r32, "com.larksuite.component.universe_design.dialog.compose.UDCheckBoxDialog (UDCheckBoxDialog.kt:34)");
    L167:
        r17.startReplaceGroup(-1746271574);
        boolean r35 = r17.changed(r117);
        if ((r0 & 234881024) != 67108864) goto L170;
        boolean r36 = true;
    L171:
        boolean r39 = r35 | r36;
        if ((r0 & 896) != 256) goto L174;
        boolean r40 = true;
    L175:
        boolean r41 = r39 | r40;
        Object r42 = r17.rememberedValue();
        if (r41 == true) goto L179;
        Object r43 = r42;
        if (r42 == Composer.Companion.getEmpty()) goto L179;
    L196:
        r17.endReplaceGroup();
        ComposableLambda r118 = ComposableLambdaKt.rememberComposableLambda(1578632605, true, new UDCheckBoxDialogKt$UDCheckBoxDialog$1(r13, r12, r11, r116), r17, 54);
        int r44 = ((r0 & 14) | 805306368) | (r0 & 112);
        int r45 = r0 >> 9;
        int r46 = (r45 & 57344) | ((r44 | (r45 & 896)) | (r45 & 7168));
        int r47 = r32 << 18;
        Composer r214 = r17;
        List<b> r310 = r117;
        UDDialogKt.f(r14, r15, r27, r210, r116, (List) r43, r6, r115, r213, r118, r214, ((r46 | (3670016 & r47)) | (29360128 & r47)) | (r47 & 234881024), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L199;
        ComposerKt.traceEventEnd();
    L199:
        String r48 = r116;
        boolean r119 = r115;
        UDDialogActionOrientation r120 = r6;
        Modifier r49 = r27;
        String r50 = r210;
        boolean r121 = r31;
        List<b> r122 = r310;
    L200:
        ScopeUpdateScope r123 = r214.endRestartGroup();
        if (r123 == null) goto L208;
        r123.updateScope(new UDCheckBoxDialogKt$UDCheckBoxDialog$2(r14, r15, r13, r12, r11, r49, r50, r48, r121, r122, r120, r119, r213, r9, r10, r212));
        return;
    L208:
        return;
    L179:
        List<b> r51 = r117;
        ArrayList r52 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r51, 10));
        Iterator<T> r53 = r51.iterator();
    L181:
        if (r53.hasNext() == false) goto L195;
        b r54 = (b) r53.next();
        if (r31 == false) goto L194;
        UDDialogActionRole r55 = r54.c;
        if (r55 == UDDialogActionRole.Primary) goto L189;
        if (r55 != UDDialogActionRole.Danger) goto L194;
    L189:
        if (r54.d == false) goto L192;
        if (r13 == false) goto L192;
        boolean r56 = true;
    L193:
        r54 = b.a(r54, r56);
    L192:
        r56 = false;
    L194:
        r52.add(r54);
        goto L181
    L195:
        r17.updateRememberedValue(r52);
        r43 = r52;
        goto L196
    L174:
        r40 = false;
        goto L175
    L170:
        r36 = false;
        goto L171
    L157:
        r117 = r5;
        goto L158
    L151:
        r116 = r3;
        goto L153
    L139:
        if ((r32 & 147) != 146) goto L144;
        if (r17.getSkipping() == false) goto L144;
        r17.skipToGroupEnd();
        r214 = r17;
        r119 = r115;
        r49 = r27;
        r50 = r210;
        r48 = r3;
        r121 = r31;
        r122 = r5;
        r120 = r6;
        goto L200
    L129:
        r212 = r16;
        if ((r10 & 384) != 0) goto L135;
        r34 = r8;
        if (r17.changed(r34) == false) goto L134;
        r24 = 256;
    L134:
        r32 = r32 | r24;
        goto L136
    L120:
        if ((r10 & 48) != 0) goto L125;
        if (r17.changed(r7) == false) goto L124;
        r22 = 32;
    L124:
        r115 = r7;
        r32 = r114 | r22;
        goto L126
    L107:
        if ((r10 & 6) != 0) goto L115;
        if (r6 != null) goto L110;
        int r57 = -1;
    L112:
        if (r17.changed(r57) == false) goto L114;
        r19 = 4;
    L114:
        r114 = r10 | r19;
        goto L116
    L110:
        r57 = r6.ordinal();
        goto L112
    L115:
        r5 = r5;
        r114 = r10;
        goto L116
    L97:
        if ((r9 & 805306368) != 0) goto L103;
        if (r17.changedInstance(r5) == false) goto L101;
        int r311 = 536870912;
    L102:
        r0 = r0 | r311;
        goto L103
    L101:
        r311 = 268435456;
        goto L102
    L87:
        if ((r9 & 100663296) != 0) goto L93;
        if (r17.changed(r4) == false) goto L91;
        r211 = 67108864;
        goto L92
    L91:
        r211 = 33554432;
        goto L92
    L77:
        if ((r9 & 12582912) != 0) goto L83;
        if (r17.changed(r3) == false) goto L81;
        r29 = 8388608;
        goto L82
    L81:
        r29 = 4194304;
        goto L82
    L67:
        if ((r9 & 1572864) != 0) goto L73;
        if (r17.changed(r2) == false) goto L71;
        r26 = 1048576;
        goto L72
    L71:
        r26 = 524288;
        goto L72
    L57:
        if ((r9 & 196608) != 0) goto L63;
        if (r17.changed(r1) == false) goto L61;
        r112 = 131072;
        goto L62
    L61:
        r112 = 65536;
        goto L62
    L47:
        if ((r9 & 24576) != 0) goto L53;
        if (r17.changed(r11) == false) goto L51;
        int r124 = 16384;
    L52:
        r0 = r0 | r124;
        goto L53
    L51:
        r124 = 8192;
        goto L52
    L37:
        if ((r9 & 3072) != 0) goto L44;
        if (r17.changedInstance(r12) == false) goto L41;
        int r125 = 2048;
    L42:
        r0 = r0 | r125;
        goto L44
    L41:
        r125 = 1024;
        goto L42
    L27:
        if ((r9 & 384) != 0) goto L34;
        if (r17.changed(r13) == false) goto L31;
        int r126 = 256;
    L32:
        r0 = r0 | r126;
        goto L34
    L31:
        r126 = 128;
        goto L32
    L17:
        if ((r9 & 48) != 0) goto L23;
        if (r17.changedInstance(r15) == false) goto L21;
        int r215 = 32;
    L22:
        r110 = r110 | r215;
        goto L23
    L21:
        r215 = 16;
        goto L22
    L6:
        if ((r9 & 6) == 0) goto L8;
        r110 = r9;
        goto L13
    L8:
        if (r17.changed(r14) == false) goto L10;
        int r127 = 4;
    L11:
        r110 = r127 | r9;
        goto L13
    L10:
        r127 = 2;
        goto L11
    }
}
