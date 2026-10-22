package com.larksuite.component.universe_design.udswitch.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
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
final class UDSwitchKt$UDSwitchWithLoading$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $checked;
    final /* synthetic */ a $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ boolean $loading;
    final /* synthetic */ c $loadingColors;
    final /* synthetic */ float $loadingRadius;
    final /* synthetic */ float $loadingStrokeWidth;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Boolean, Unit> $onLoadingStatusChange;

    /* JADX WARN: Multi-variable type inference failed */
    public UDSwitchKt$UDSwitchWithLoading$2(boolean r1, boolean r2, Function1<? super Boolean, Unit> r3, Modifier r4, boolean r5, a r6, c r7, float r8, float r9, int r10, int r11) {
        this.$checked = r1;
        this.$loading = r2;
        this.$onLoadingStatusChange = r3;
        this.$modifier = r4;
        this.$enabled = r5;
        this.$colors = r6;
        this.$loadingColors = r7;
        this.$loadingRadius = r8;
        this.$loadingStrokeWidth = r9;
        this.$$changed = r10;
        this.$$default = r11;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r25, int r26) {
        final boolean r12 = this.$checked;
        boolean r13 = this.$loading;
        final Function1<Boolean, Unit> r14 = this.$onLoadingStatusChange;
        Modifier r1 = this.$modifier;
        boolean r2 = this.$enabled;
        a r3 = this.$colors;
        c r4 = this.$loadingColors;
        float r5 = this.$loadingRadius;
        float r6 = this.$loadingStrokeWidth;
        int r15 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r11 = this.$$default;
        float r7 = UDSwitchKt.a;
        Intrinsics.checkNotNullParameter(r14, "onLoadingStatusChange");
        Composer r10 = r25.startRestartGroup(-859458075);
        if ((r11 & 1) == 0) goto L6;
        int r9 = r15 | 6;
    L14:
        if ((r11 & 2) == 0) goto L17;
        r9 = r9 | 48;
    L24:
        if ((r11 & 4) == 0) goto L27;
        r9 = r9 | 384;
    L33:
        int r8 = r11 & 8;
        if (r8 == 0) goto L37;
        r9 = r9 | 3072;
    L43:
        int r16 = r9;
    L44:
        int r17 = r11 & 16;
        if (r17 == 0) goto L48;
        r16 = r16 | 24576;
    L54:
        int r0 = r16;
    L56:
        if ((196608 & r15) != 0) goto L65;
        if ((r11 & 32) == 0) goto L60;
    L62:
        int r19 = 65536;
    L63:
        r0 = r0 | r19;
        goto L65
    L60:
        if (r10.changed(r3) == false) goto L62;
        r19 = 131072;
    L65:
        if ((1572864 & r15) == 0) goto L67;
    L73:
        int r20 = r11 & 128;
        int r110 = 12582912;
        if (r20 == 0) goto L77;
    L82:
        r0 = r0 | r110;
    L83:
        Modifier r111 = r1;
        int r21 = r11 & 256;
        int r112 = 100663296;
        if (r21 == 0) goto L87;
    L92:
        r0 = r0 | r112;
    L93:
        boolean r22 = r2;
        a r113 = r3;
        if ((r0 & 38347923) == 38347922) goto L96;
    L99:
        r10.startDefaults();
        if ((r15 & 1) != 0) goto L102;
    L111:
        if (r8 == 0) goto L113;
        r111 = Modifier.Companion;
    L113:
        if (r17 == 0) goto L115;
        boolean r23 = true;
    L117:
        if ((r11 & 32) == 0) goto L120;
        r0 = r0 & (-458753);
        r113 = b.a(r10);
    L120:
        if ((r11 & 64) == 0) goto L122;
        r4 = b.b(r10);
        r0 = r0 & (-3670017);
    L122:
        if (r20 == 0) goto L124;
        r5 = UDSwitchKt.h;
    L124:
        if (r21 == 0) goto L126;
        r6 = UDSwitchKt.i;
    L126:
        r22 = r23;
    L110:
        c r24 = r4;
        float r27 = r5;
        float r29 = r6;
        r10.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L130;
        ComposerKt.traceEventStart(-859458075, r0, -1, "com.larksuite.component.universe_design.udswitch.compose.UDSwitchWithLoading (UDSwitch.kt:75)");
    L130:
        r10.startReplaceGroup(-1633490746);
        if ((r0 & 896) != 256) goto L133;
        boolean r30 = true;
    L134:
        int r31 = r0 & 14;
        if (r31 != 4) goto L137;
        boolean r32 = true;
    L138:
        boolean r33 = r30 | r32;
        Object r34 = r10.rememberedValue();
        if (r33 == false) goto L141;
    L142:
        r34 = new UDSwitchKt$UDSwitchWithLoading$1$1(r14, r12);
        r10.updateRememberedValue(r34);
    L143:
        Function0 r35 = (Function0) r34;
        r10.endReplaceGroup();
        int r36 = ((((((r0 & 112) | r31) | (r0 & 7168)) | (57344 & r0)) | (458752 & r0)) | (3670016 & r0)) | (29360128 & r0);
        Modifier r37 = r111;
        boolean r38 = r22;
        a r39 = r113;
        UDSwitchKt.a(r12, r13, r35, r37, r38, r39, r24, r27, r29, r10, (r0 & 234881024) | r36);
        if (ComposerKt.isTraceInProgress() == false) goto L146;
        ComposerKt.traceEventEnd();
    L146:
        Modifier r40 = r111;
        a r41 = r113;
        boolean r42 = r22;
        c r43 = r24;
        float r44 = r27;
        float r114 = r29;
    L147:
        ScopeUpdateScope r45 = r10.endRestartGroup();
        if (r45 == null) goto L151;
        r45.updateScope(new UDSwitchKt$UDSwitchWithLoading$2(r12, r13, r14, r40, r42, r41, r43, r44, r114, r15, r11));
        return;
    L151:
        return;
    L141:
        if (r34 != Composer.Companion.getEmpty()) goto L143;
    L137:
        r32 = false;
        goto L138
    L133:
        r30 = false;
        goto L134
    L115:
        r23 = r22;
        goto L117
    L102:
        if (r10.getDefaultsInvalid() == true) goto L111;
        r10.skipToGroupEnd();
        if ((r11 & 32) == 0) goto L108;
        r0 = r0 & (-458753);
    L108:
        if ((r11 & 64) == 0) goto L110;
        r0 = r0 & (-3670017);
        goto L110
    L96:
        if (r10.getSkipping() == false) goto L99;
        r10.skipToGroupEnd();
        r43 = r4;
        r44 = r5;
        r40 = r111;
        r41 = r113;
        r114 = r6;
        r42 = r22;
        goto L147
    L87:
        if ((r15 & 100663296) != 0) goto L93;
        if (r10.changed(r6) == false) goto L91;
        r112 = 67108864;
        goto L92
    L91:
        r112 = 33554432;
        goto L92
    L77:
        if ((r15 & 12582912) != 0) goto L83;
        if (r10.changed(r5) == false) goto L81;
        r110 = 8388608;
        goto L82
    L81:
        r110 = 4194304;
        goto L82
    L67:
        if ((r11 & 64) == 0) goto L69;
    L71:
        int r46 = 524288;
    L72:
        r0 = r0 | r46;
        goto L73
    L69:
        if (r10.changed(r4) == false) goto L71;
        r46 = 1048576;
        goto L72
    L48:
        if ((r15 & 24576) != 0) goto L54;
        if (r10.changed(r2) == false) goto L52;
        int r47 = 16384;
    L53:
        r0 = r47 | r16;
        goto L56
    L52:
        r47 = 8192;
        goto L53
    L37:
        if ((r15 & 3072) != 0) goto L43;
        if (r10.changed(r1) == false) goto L41;
        int r48 = 2048;
    L42:
        r16 = r48 | r9;
        goto L44
    L41:
        r48 = 1024;
        goto L42
    L27:
        if ((r15 & 384) != 0) goto L33;
        if (r10.changedInstance(r14) == false) goto L31;
        int r49 = 256;
    L32:
        r9 = r9 | r49;
        goto L33
    L31:
        r49 = 128;
        goto L32
    L17:
        if ((r15 & 48) != 0) goto L24;
        if (r10.changed(r13) == false) goto L21;
        int r115 = 32;
    L22:
        r9 = r9 | r115;
        goto L24
    L21:
        r115 = 16;
        goto L22
    L6:
        if ((r15 & 6) == 0) goto L8;
        r9 = r15;
        goto L14
    L8:
        if (r10.changed(r12) == false) goto L10;
        int r50 = 4;
    L11:
        r9 = r50 | r15;
        goto L14
    L10:
        r50 = 2;
        goto L11
    }
}
