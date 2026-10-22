package com.larksuite.component.universe_design.emptystate.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.text.AnnotatedString;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class UDEmptyStateKt$UDEmptyState$11 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ b $colors;
    final /* synthetic */ String $description;
    final /* synthetic */ d $dimensions;
    final /* synthetic */ String $imageContentDescription;
    final /* synthetic */ float $imageSize;
    final /* synthetic */ ImageVector $imageVector;
    final /* synthetic */ a $linkAction;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ a $primaryAction;
    final /* synthetic */ a $secondaryAction;
    final /* synthetic */ String $title;

    public UDEmptyStateKt$UDEmptyState$11(ImageVector r1, String r2, String r3, Modifier r4, float r5, String r6, a r7, a r8, a r9, b r10, d r11, int r12, int r13, int r14) {
        this.$imageVector = r1;
        this.$title = r2;
        this.$description = r3;
        this.$modifier = r4;
        this.$imageSize = r5;
        this.$imageContentDescription = r6;
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

    public final void invoke(Composer r29, int r30) {
        ImageVector r15 = this.$imageVector;
        String r1 = this.$title;
        String r2 = this.$description;
        Modifier r3 = this.$modifier;
        float r4 = this.$imageSize;
        String r5 = this.$imageContentDescription;
        b r6 = this.$colors;
        d r7 = this.$dimensions;
        int r14 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r16 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed1);
        int r13 = this.$$default;
        Composer r12 = r29.startRestartGroup(1335276670);
        if ((r13 & 1) == 0) goto L6;
        int r9 = r14 | 6;
    L13:
        int r17 = r13 & 2;
        if (r17 == 0) goto L17;
        r9 = r9 | 48;
    L23:
        int r19 = r13 & 4;
        if (r19 == 0) goto L27;
        r9 = r9 | 384;
    L33:
        int r10 = r13 & 8;
        if (r10 == 0) goto L37;
        r9 = r9 | 3072;
    L43:
        int r8 = r9;
    L44:
        int r11 = r13 & 16;
        if (r11 == 0) goto L48;
        r8 = r8 | 24576;
    L54:
        int r110 = r13 & 32;
        int r20 = 196608;
        if (r110 == 0) goto L58;
    L63:
        r8 = r8 | r20;
    L65:
        if ((r13 & 64) == 0) goto L68;
        r8 = r8 | 1572864;
    L75:
        if ((r13 & 128) == 0) goto L78;
        r8 = r8 | 12582912;
    L85:
        if ((r13 & 256) == 0) goto L88;
        r8 = r8 | 100663296;
    L95:
        if ((805306368 & r14) != 0) goto L104;
        if ((r13 & 512) == 0) goto L99;
    L101:
        int r0 = 268435456;
    L102:
        r8 = r8 | r0;
        goto L104
    L99:
        if (r12.changed(r6) == false) goto L101;
        r0 = 536870912;
    L104:
        if ((r16 & 6) == 0) goto L106;
        int r21 = r16;
    L113:
        String r22 = r1;
        String r23 = r2;
        if ((r8 & 306783379) == 306783378) goto L116;
    L121:
        r12.startDefaults();
        if ((r14 & 1) != 0) goto L124;
    L133:
        if (r17 == 0) goto L135;
        String r24 = null;
    L136:
        if (r19 == 0) goto L138;
        r23 = null;
    L138:
        if (r10 == 0) goto L140;
        r3 = Modifier.Companion;
    L140:
        if (r11 == 0) goto L142;
        r4 = c.a;
    L142:
        if (r110 == 0) goto L145;
        r5 = null;
    L145:
        if ((r13 & 512) == 0) goto L148;
        r6 = c.a(r12);
        r8 = r8 & (-1879048193);
    L148:
        if ((r13 & 1024) == 0) goto L150;
        r21 = r21 & (-15);
        r7 = c.b(r12);
    L150:
        r22 = r24;
    L132:
        Modifier r111 = r3;
        float r112 = r4;
        b r25 = r6;
        d r26 = r7;
        String r113 = r23;
        String r27 = r5;
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L154;
        ComposerKt.traceEventStart(1335276670, r8, r21, "com.larksuite.component.universe_design.emptystate.compose.UDEmptyState (UDEmptyState.kt:184)");
    L154:
        if (r113 == null) goto L156;
        AnnotatedString r31 = new AnnotatedString(r113, null, 2, null);
    L157:
        int r32 = r8 >> 6;
        int r33 = ((((r8 & 14) | (r32 & 112)) | (r32 & 896)) | (r32 & 7168)) | ((r8 << 9) & 57344);
        int r34 = r8 << 6;
        int r114 = (r33 | (234881024 & r34)) | (r34 & 1879048192);
        int r35 = r8 >> 24;
        int r36 = (r21 << 6) & 896;
        String r37 = r22;
        UDEmptyStateKt.d(r15, r111, r112, r27, r37, r31, null, null, r25, r26, r12, r114, r36 | ((r35 & 112) | (r35 & 14)), 192);
        if (ComposerKt.isTraceInProgress() == false) goto L160;
        ComposerKt.traceEventEnd();
    L160:
        Modifier r38 = r111;
        float r39 = r112;
        String r40 = r27;
        String r41 = r22;
        b r115 = r25;
        d r116 = r26;
        String r42 = r113;
    L161:
        ScopeUpdateScope r117 = r12.endRestartGroup();
        if (r117 == null) goto L165;
        r117.updateScope(new UDEmptyStateKt$UDEmptyState$11(r15, r41, r42, r38, r39, r40, null, null, null, r115, r116, r14, r16, r13));
        return;
    L165:
        return;
    L156:
        r31 = null;
        goto L157
    L135:
        r24 = r22;
        goto L136
    L124:
        if (r12.getDefaultsInvalid() == true) goto L133;
        r12.skipToGroupEnd();
        if ((r13 & 512) == 0) goto L130;
        r8 = r8 & (-1879048193);
    L130:
        if ((r13 & 1024) == 0) goto L132;
        r21 = r21 & (-15);
        goto L132
    L116:
        if ((r21 & 3) != 2) goto L121;
        if (r12.getSkipping() == false) goto L121;
        r12.skipToGroupEnd();
        r115 = r6;
        r39 = r4;
        r116 = r7;
        r42 = r23;
        r40 = r5;
        r38 = r3;
        r41 = r22;
        goto L161
    L106:
        if ((r13 & 1024) == 0) goto L108;
    L110:
        int r43 = 2;
    L111:
        r21 = r16 | r43;
        goto L113
    L108:
        if (r12.changed(r7) == false) goto L110;
        r43 = 4;
        goto L111
    L88:
        if ((r14 & 100663296) != 0) goto L95;
        if (r12.changed(null) == false) goto L92;
        int r44 = 67108864;
    L93:
        r8 = r8 | r44;
        goto L95
    L92:
        r44 = 33554432;
        goto L93
    L78:
        if ((r14 & 12582912) != 0) goto L85;
        if (r12.changed(null) == false) goto L82;
        int r45 = 8388608;
    L83:
        r8 = r8 | r45;
        goto L85
    L82:
        r45 = 4194304;
        goto L83
    L68:
        if ((r14 & 1572864) != 0) goto L75;
        if (r12.changed(null) == false) goto L72;
        int r210 = 1048576;
    L73:
        r8 = r8 | r210;
        goto L75
    L72:
        r210 = 524288;
        goto L73
    L58:
        if ((r14 & 196608) != 0) goto L65;
        if (r12.changed(r5) == false) goto L62;
        r20 = 131072;
        goto L63
    L62:
        r20 = 65536;
        goto L63
    L48:
        if ((r14 & 24576) != 0) goto L54;
        if (r12.changed(r4) == false) goto L52;
        int r118 = 16384;
    L53:
        r8 = r8 | r118;
        goto L54
    L52:
        r118 = 8192;
        goto L53
    L37:
        if ((r14 & 3072) != 0) goto L43;
        if (r12.changed(r3) == false) goto L41;
        int r46 = 2048;
    L42:
        r8 = r46 | r9;
        goto L44
    L41:
        r46 = 1024;
        goto L42
    L27:
        if ((r14 & 384) != 0) goto L33;
        if (r12.changed(r2) == false) goto L31;
        int r119 = 256;
    L32:
        r9 = r9 | r119;
        goto L33
    L31:
        r119 = 128;
        goto L32
    L17:
        if ((r14 & 48) != 0) goto L23;
        if (r12.changed(r1) == false) goto L21;
        int r120 = 32;
    L22:
        r9 = r9 | r120;
        goto L23
    L21:
        r120 = 16;
        goto L22
    L6:
        if ((r14 & 6) == 0) goto L8;
        r9 = r14;
        goto L13
    L8:
        if (r12.changed(r15) == false) goto L10;
        int r47 = 4;
    L11:
        r9 = r47 | r14;
        goto L13
    L10:
        r47 = 2;
        goto L11
    }
}
