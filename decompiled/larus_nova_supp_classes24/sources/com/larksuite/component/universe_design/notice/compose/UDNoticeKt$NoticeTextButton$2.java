package com.larksuite.component.universe_design.notice.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class UDNoticeKt$NoticeTextButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ a $action;
    final /* synthetic */ long $color;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ TextStyle $style;

    public UDNoticeKt$NoticeTextButton$2(a r1, long r2, TextStyle r4, float r5, int r6, int r7) {
        this.$color = r2;
        this.$style = r4;
        this.$minHeight = r5;
        this.$$changed = r6;
        this.$$default = r7;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r12, int r13) {
        long r2 = this.$color;
        TextStyle r4 = this.$style;
        float r5 = this.$minHeight;
        int r6 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r7 = this.$$default;
        float r14 = d.a;
        Composer r15 = r12.startRestartGroup(10029646);
        if ((r7 & 1) == 0) goto L6;
        int r0 = r6 | 6;
    L14:
        if ((r7 & 2) == 0) goto L17;
        r0 = r0 | 48;
    L24:
        if ((r7 & 4) == 0) goto L27;
        r0 = r0 | 384;
    L33:
        int r8 = r7 & 8;
        if (r8 == 0) goto L37;
        r0 = r0 | 3072;
    L44:
        if ((r0 & 1171) == 1170) goto L46;
    L52:
        if (r8 == 0) goto L55;
        Dp.constructor-impl(0);
    L55:
        if (ComposerKt.isTraceInProgress() == false) goto L57;
        ComposerKt.traceEventStart(10029646, r0, -1, "com.larksuite.component.universe_design.notice.compose.NoticeTextButton (UDNotice.kt:356)");
    L57:
        Modifier.Companion r16 = Modifier.Companion;
        Role.box-impl(Role.Companion.getButton-o7Vup1c());
        throw null;
    L46:
        if (r15.getSkipping() == false) goto L52;
        r15.skipToGroupEnd();
        ScopeUpdateScope r17 = r15.endRestartGroup();
        if (r17 == null) goto L59;
        r17.updateScope(new UDNoticeKt$NoticeTextButton$2(null, r2, r4, r5, r6, r7));
        return;
    L59:
        return;
    L37:
        if ((r6 & 3072) != 0) goto L44;
        if (r15.changed(r5) == false) goto L41;
        int r9 = 2048;
    L42:
        r0 = r0 | r9;
        goto L44
    L41:
        r9 = 1024;
        goto L42
    L27:
        if ((r6 & 384) != 0) goto L33;
        if (r15.changed(r4) == false) goto L31;
        int r10 = 256;
    L32:
        r0 = r0 | r10;
        goto L33
    L31:
        r10 = 128;
        goto L32
    L17:
        if ((r6 & 48) != 0) goto L24;
        if (r15.changed(r2) == false) goto L21;
        int r11 = 32;
    L22:
        r0 = r0 | r11;
        goto L24
    L21:
        r11 = 16;
        goto L22
    L6:
        if ((r6 & 6) == 0) goto L8;
        r0 = r6;
        goto L14
    L8:
        if (r15.changed(null) == false) goto L10;
        int r1 = 4;
    L11:
        r0 = r1 | r6;
        goto L14
    L10:
        r1 = 2;
        goto L11
    }
}
