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
final class UDSwitchKt$UDSwitch$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $checked;
    final /* synthetic */ a $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Boolean, Unit> $onCheckedChange;

    /* JADX WARN: Multi-variable type inference failed */
    public UDSwitchKt$UDSwitch$2(boolean r1, Function1<? super Boolean, Unit> r2, Modifier r3, boolean r4, a r5, int r6, int r7) {
        this.$checked = r1;
        this.$onCheckedChange = r2;
        this.$modifier = r3;
        this.$enabled = r4;
        this.$colors = r5;
        this.$$changed = r6;
        this.$$default = r7;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r22, int r23) {
        final boolean r12 = this.$checked;
        final Function1<Boolean, Unit> r13 = this.$onCheckedChange;
        Modifier r1 = this.$modifier;
        boolean r2 = this.$enabled;
        a r3 = this.$colors;
        int r14 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r15 = this.$$default;
        float r4 = UDSwitchKt.a;
        Intrinsics.checkNotNullParameter(r13, "onCheckedChange");
        Composer r11 = r22.startRestartGroup(1538424914);
        if ((r15 & 1) == 0) goto L6;
        int r6 = r14 | 6;
    L14:
        if ((r15 & 2) == 0) goto L17;
        r6 = r6 | 48;
    L23:
        int r8 = r15 & 4;
        if (r8 == 0) goto L27;
        r6 = r6 | 384;
    L33:
        int r10 = r15 & 8;
        if (r10 == 0) goto L37;
        r6 = r6 | 3072;
    L43:
        int r5 = r6;
    L45:
        if ((r14 & 24576) != 0) goto L54;
        if ((r15 & 16) == 0) goto L49;
    L51:
        int r7 = 8192;
    L52:
        r5 = r5 | r7;
        goto L54
    L49:
        if (r11.changed(r3) == false) goto L51;
        r7 = 16384;
    L54:
        if ((r5 & 9363) == 9362) goto L56;
    L59:
        r11.startDefaults();
        if ((r14 & 1) != 0) goto L62;
    L68:
        if (r8 == 0) goto L70;
        r1 = Modifier.Companion;
    L70:
        if (r10 == 0) goto L73;
        r2 = true;
    L73:
        if ((r15 & 16) != 0) goto L74;
    L67:
        Modifier r16 = r1;
        boolean r17 = r2;
        a r19 = r3;
        r11.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L79;
        ComposerKt.traceEventStart(1538424914, r5, -1, "com.larksuite.component.universe_design.udswitch.compose.UDSwitch (UDSwitch.kt:50)");
    L79:
        r11.startReplaceGroup(-1633490746);
        boolean r9 = false;
        if ((r5 & 112) != 32) goto L82;
        boolean r20 = true;
    L83:
        int r21 = r5 & 14;
        if (r21 != 4) goto L86;
        r9 = true;
    L86:
        boolean r24 = r20 | r9;
        Object r25 = r11.rememberedValue();
        if (r24 == false) goto L89;
    L90:
        r25 = new UDSwitchKt$UDSwitch$1$1(r13, r12);
        r11.updateRememberedValue(r25);
    L91:
        r11.endReplaceGroup();
        int r26 = 113246256 | r21;
        int r27 = r5 << 3;
        UDSwitchKt.a(r12, false, (Function0) r25, r16, r17, r19, b.b(r11), UDSwitchKt.h, UDSwitchKt.i, r11, ((r26 | (r27 & 7168)) | (57344 & r27)) | (r27 & 458752));
        if (ComposerKt.isTraceInProgress() == false) goto L94;
        ComposerKt.traceEventEnd();
    L94:
        Modifier r29 = r16;
        boolean r30 = r17;
        a r31 = r19;
    L95:
        ScopeUpdateScope r32 = r11.endRestartGroup();
        if (r32 == null) goto L99;
        r32.updateScope(new UDSwitchKt$UDSwitch$2(r12, r13, r29, r30, r31, r14, r15));
        return;
    L99:
        return;
    L89:
        if (r25 != Composer.Companion.getEmpty()) goto L91;
    L82:
        r20 = false;
        goto L83
    L74:
        r3 = b.a(r11);
    L75:
        r5 = r5 & (-57345);
        goto L67
    L62:
        if (r11.getDefaultsInvalid() == true) goto L68;
        r11.skipToGroupEnd();
        if ((r15 & 16) == 0) goto L67;
    L56:
        if (r11.getSkipping() == false) goto L59;
        r11.skipToGroupEnd();
        r29 = r1;
        r30 = r2;
        r31 = r3;
        goto L95
    L37:
        if ((r14 & 3072) != 0) goto L43;
        if (r11.changed(r2) == false) goto L41;
        int r33 = 2048;
    L42:
        r5 = r33 | r6;
        goto L45
    L41:
        r33 = 1024;
        goto L42
    L27:
        if ((r14 & 384) != 0) goto L33;
        if (r11.changed(r1) == false) goto L31;
        int r110 = 256;
    L32:
        r6 = r6 | r110;
        goto L33
    L31:
        r110 = 128;
        goto L32
    L17:
        if ((r14 & 48) != 0) goto L23;
        if (r11.changedInstance(r13) == false) goto L21;
        int r34 = 32;
    L22:
        r6 = r6 | r34;
        goto L23
    L21:
        r34 = 16;
        goto L22
    L6:
        if ((r14 & 6) == 0) goto L8;
        r6 = r14;
        goto L14
    L8:
        if (r11.changed(r12) == false) goto L10;
        int r35 = 4;
    L11:
        r6 = r35 | r14;
        goto L14
    L10:
        r35 = 2;
        goto L11
    }
}
