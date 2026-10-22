package com.larksuite.component.universe_design.emptystate.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.AnnotatedString;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class UDEmptyStateKt$UDEmptyState$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ b $colors;
    final /* synthetic */ AnnotatedString $description;
    final /* synthetic */ String $descriptionActionTag;
    final /* synthetic */ d $dimensions;
    final /* synthetic */ float $imageSize;
    final /* synthetic */ a $linkAction;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<String, Unit> $onDescriptionActionClick;
    final /* synthetic */ a $primaryAction;
    final /* synthetic */ a $secondaryAction;
    final /* synthetic */ String $title;

    /* JADX WARN: Multi-variable type inference failed */
    public UDEmptyStateKt$UDEmptyState$5(Modifier r1, float r2, String r3, AnnotatedString r4, String r5, Function1<? super String, Unit> r6, a r7, a r8, a r9, b r10, d r11, int r12, int r13, int r14) {
        this.$modifier = r1;
        this.$imageSize = r2;
        this.$title = r3;
        this.$description = r4;
        this.$descriptionActionTag = r5;
        this.$onDescriptionActionClick = r6;
        this.$colors = r10;
        this.$dimensions = r11;
        this.$$changed = r12;
        this.$$changed1 = r13;
        this.$$default = r14;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r39, int r40) {
        Modifier r1 = this.$modifier;
        float r2 = this.$imageSize;
        String r3 = this.$title;
        AnnotatedString r4 = this.$description;
        String r5 = this.$descriptionActionTag;
        Function1<String, Unit> r6 = this.$onDescriptionActionClick;
        b r7 = this.$colors;
        d r8 = this.$dimensions;
        int r9 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r23 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed1);
        int r15 = this.$$default;
        Composer r11 = r39.startRestartGroup(2023833143);
        int r12 = r15 & 1;
        if (r12 == 0) goto L6;
        int r16 = r9 | 6;
    L13:
        int r17 = r15 & 2;
        if (r17 == 0) goto L17;
        r16 = r16 | 48;
    L23:
        int r13 = r16;
        int r19 = r15 & 4;
        if (r19 == 0) goto L27;
        r13 = r13 | 384;
    L33:
        int r10 = r13;
    L34:
        int r14 = r15 & 8;
        if (r14 == 0) goto L38;
        r10 = r10 | 3072;
    L44:
        int r110 = r15 & 16;
        if (r110 == 0) goto L48;
        r10 = r10 | 24576;
    L54:
        int r0 = r10;
    L55:
        int r111 = r15 & 32;
        int r112 = 196608;
        if (r111 == 0) goto L59;
    L64:
        r0 = r0 | r112;
    L66:
        if ((r15 & 64) == 0) goto L69;
        r0 = r0 | 1572864;
    L76:
        if ((r15 & 128) == 0) goto L79;
        r0 = r0 | 12582912;
    L86:
        if ((r15 & 256) == 0) goto L89;
        r0 = r0 | 100663296;
    L97:
        if ((r9 & 805306368) != 0) goto L106;
        if ((r15 & 512) == 0) goto L101;
    L103:
        int r20 = 268435456;
    L104:
        r0 = r0 | r20;
        goto L106
    L101:
        if (r11.changed(r7) == false) goto L103;
        r20 = 536870912;
    L106:
        if ((r23 & 6) == 0) goto L108;
        int r21 = r23;
    L115:
        float r22 = r2;
        String r24 = r3;
        if ((r0 & 306783379) == 306783378) goto L118;
    L123:
        r11.startDefaults();
        if ((r9 & 1) != 0) goto L126;
    L136:
        if (r12 == 0) goto L138;
        Modifier r25 = Modifier.Companion;
    L139:
        if (r17 == 0) goto L141;
        r22 = c.a;
    L141:
        if (r19 == 0) goto L143;
        r24 = null;
    L143:
        if (r14 == 0) goto L145;
        r4 = null;
    L145:
        if (r110 == 0) goto L147;
        r5 = "ud_empty_description_action";
    L147:
        if (r111 == 0) goto L150;
        r6 = null;
    L150:
        if ((r15 & 512) == 0) goto L153;
        r7 = c.a(r11);
        r0 = r0 & (-1879048193);
    L153:
        if ((r15 & 1024) != 0) goto L154;
    L135:
        String r26 = r24;
        r11.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L158;
        ComposerKt.traceEventStart(2023833143, r0, r21, "com.larksuite.component.universe_design.emptystate.compose.UDEmptyState (UDEmptyState.kt:125)");
    L158:
        int r113 = r0 << 3;
        int r114 = (r113 & 112) | 6;
        int r115 = (r113 & 896) | r114;
        int r116 = r0 << 6;
        int r35 = (((((r115 | (57344 & r116)) | (458752 & r116)) | (3670016 & r116)) | (29360128 & r116)) | (234881024 & r116)) | (r116 & 1879048192);
        int r27 = r0 >> 24;
        int r117 = r27 & 14;
        Modifier r29 = r25;
        float r210 = r22;
        AnnotatedString r211 = r4;
        String r30 = r5;
        Function1<String, Unit> r31 = r6;
        b r32 = r7;
        d r33 = r8;
        UDEmptyStateKt.c(null, r29, r210, null, r26, r211, r30, r31, r32, r33, r11, r35, ((r27 & 112) | r117) | ((r21 << 6) & 896), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L161;
        ComposerKt.traceEventEnd();
    L161:
        String r118 = r26;
        AnnotatedString r119 = r4;
        Function1<String, Unit> r120 = r6;
        b r212 = r7;
        d r213 = r8;
        float r121 = r22;
    L162:
        ScopeUpdateScope r34 = r11.endRestartGroup();
        if (r34 == null) goto L166;
        r34.updateScope(new UDEmptyStateKt$UDEmptyState$5(r25, r121, r118, r119, r5, r120, null, null, null, r212, r213, r9, r23, r15));
        return;
    L166:
        return;
    L154:
        r21 = r21 & (-15);
        r8 = c.b(r11);
        goto L135
    L138:
        r25 = r1;
        goto L139
    L126:
        if (r11.getDefaultsInvalid() == true) goto L136;
        r11.skipToGroupEnd();
        if ((r15 & 512) == 0) goto L132;
        r0 = r0 & (-1879048193);
    L132:
        if ((r15 & 1024) == 0) goto L134;
        r21 = r21 & (-15);
    L134:
        r25 = r1;
        goto L135
    L118:
        if ((r21 & 3) != 2) goto L123;
        if (r11.getSkipping() == false) goto L123;
        r11.skipToGroupEnd();
        r119 = r4;
        r120 = r6;
        r25 = r1;
        r118 = r24;
        r121 = r22;
        r212 = r7;
        r213 = r8;
        goto L162
    L108:
        if ((r15 & 1024) == 0) goto L110;
    L112:
        int r36 = 2;
    L113:
        r21 = r23 | r36;
        goto L115
    L110:
        if (r11.changed(r8) == false) goto L112;
        r36 = 4;
        goto L113
    L89:
        if ((r9 & 100663296) != 0) goto L97;
        if (r11.changed(null) == false) goto L93;
        int r122 = 67108864;
    L94:
        r0 = r0 | r122;
        goto L97
    L93:
        r122 = 33554432;
        goto L94
    L79:
        if ((r9 & 12582912) != 0) goto L86;
        if (r11.changed(null) == false) goto L83;
        int r37 = 8388608;
    L84:
        r0 = r0 | r37;
        goto L86
    L83:
        r37 = 4194304;
        goto L84
    L69:
        if ((r9 & 1572864) != 0) goto L76;
        if (r11.changed(null) == false) goto L73;
        int r123 = 1048576;
    L74:
        r0 = r0 | r123;
        goto L76
    L73:
        r123 = 524288;
        goto L74
    L59:
        if ((r9 & 196608) != 0) goto L66;
        if (r11.changedInstance(r6) == false) goto L63;
        r112 = 131072;
        goto L64
    L63:
        r112 = 65536;
        goto L64
    L48:
        if ((r9 & 24576) != 0) goto L54;
        if (r11.changed(r5) == false) goto L52;
        int r38 = 16384;
    L53:
        r0 = r38 | r10;
        goto L55
    L52:
        r38 = 8192;
        goto L53
    L38:
        if ((r9 & 3072) != 0) goto L44;
        if (r11.changed(r4) == false) goto L42;
        int r124 = 2048;
    L43:
        r10 = r10 | r124;
        goto L44
    L42:
        r124 = 1024;
        goto L43
    L27:
        if ((r9 & 384) != 0) goto L33;
        if (r11.changed(r3) == false) goto L31;
        int r125 = 256;
    L32:
        r10 = r125 | r13;
        goto L34
    L31:
        r125 = 128;
        goto L32
    L17:
        if ((r9 & 48) != 0) goto L23;
        if (r11.changed(r2) == false) goto L21;
        int r126 = 32;
    L22:
        r16 = r16 | r126;
        goto L23
    L21:
        r126 = 16;
        goto L22
    L6:
        if ((r9 & 6) == 0) goto L8;
        r16 = r9;
        goto L13
    L8:
        if (r11.changed(r1) == false) goto L10;
        int r127 = 4;
    L11:
        r16 = r127 | r9;
        goto L13
    L10:
        r127 = 2;
        goto L11
    }
}
