package com.larksuite.component.universe_design.dialog.compose.actionpanel;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import com.larksuite.component.universe_design.dialog.compose.UDListPanelDialogKt;
import com.larksuite.component.universe_design.dialog.compose.b;
import com.larksuite.component.universe_design.dialog.compose.d;
import com.larksuite.component.universe_design.dialog.compose.e;
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
final class UDActionPanelKt$UDActionPanel$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ b $cancelAction;
    final /* synthetic */ boolean $cancelOnTouchOutside;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ List<d> $items;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ String $title;
    final /* synthetic */ boolean $visible;

    public UDActionPanelKt$UDActionPanel$1(boolean r1, Function0<Unit> r2, List<d> r3, Modifier r4, String r5, b r6, boolean r7, boolean r8, int r9, int r10) {
        this.$visible = r1;
        this.$onDismissRequest = r2;
        this.$items = r3;
        this.$modifier = r4;
        this.$title = r5;
        this.$cancelAction = r6;
        this.$cancelable = r7;
        this.$cancelOnTouchOutside = r8;
        this.$$changed = r9;
        this.$$default = r10;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r29, int r210) {
        boolean r15 = this.$visible;
        Function0<Unit> r14 = this.$onDismissRequest;
        List<d> r13 = this.$items;
        Modifier r1 = this.$modifier;
        String r2 = this.$title;
        b r3 = this.$cancelAction;
        boolean r4 = this.$cancelable;
        boolean r5 = this.$cancelOnTouchOutside;
        int r12 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r11 = this.$$default;
        Intrinsics.checkNotNullParameter(r14, "onDismissRequest");
        Intrinsics.checkNotNullParameter(r13, "items");
        Composer r10 = r29.startRestartGroup(2009441867);
        if ((r11 & 1) == 0) goto L6;
        int r8 = r12 | 6;
    L14:
        if ((r11 & 2) == 0) goto L17;
        r8 = r8 | 48;
    L24:
        if ((r11 & 4) == 0) goto L27;
        r8 = r8 | 384;
    L33:
        int r9 = r11 & 8;
        if (r9 == 0) goto L37;
        r8 = r8 | 3072;
    L43:
        int r7 = r8;
    L44:
        int r16 = r11 & 16;
        if (r16 == 0) goto L48;
        r7 = r7 | 24576;
    L54:
        int r6 = r7;
    L55:
        int r17 = r11 & 32;
        int r19 = 196608;
        if (r17 == 0) goto L59;
    L64:
        r6 = r6 | r19;
    L65:
        int r110 = r11 & 64;
        if (r110 == 0) goto L69;
        r6 = r6 | 1572864;
    L75:
        int r0 = r11 & 128;
        int r111 = 12582912;
        if (r0 == 0) goto L79;
    L77:
        r6 = r6 | r111;
    L84:
        Modifier r20 = r1;
        String r112 = r2;
        if ((r6 & 4793491) == 4793490) goto L87;
    L90:
        if (r9 == 0) goto L93;
        r20 = Modifier.Companion;
    L93:
        if (r16 == 0) goto L95;
        r112 = null;
    L95:
        if (r17 == 0) goto L97;
        b r21 = null;
    L98:
        if (r110 == 0) goto L100;
        boolean r113 = true;
    L101:
        if (r0 == 0) goto L103;
        boolean r22 = true;
    L105:
        if (ComposerKt.isTraceInProgress() == false) goto L107;
        ComposerKt.traceEventStart(2009441867, r6, -1, "com.larksuite.component.universe_design.dialog.compose.actionpanel.UDActionPanel (UDActionPanel.kt:19)");
    L107:
        int r23 = ((((((r6 & 14) | 1572864) | (r6 & 112)) | (r6 & 896)) | (r6 & 7168)) | (57344 & r6)) | (458752 & r6);
        int r24 = r6 << 3;
        Composer r25 = r10;
        UDListPanelDialogKt.d(r15, r14, r13, r20, r112, r21, e.r, r113, r22, false, null, r25, (r23 | (29360128 & r24)) | (r24 & 234881024), 0, 1536);
        if (ComposerKt.isTraceInProgress() == false) goto L110;
        ComposerKt.traceEventEnd();
    L110:
        boolean r26 = r22;
        boolean r27 = r113;
        String r30 = r112;
        Modifier r31 = r20;
        b r32 = r21;
    L111:
        ScopeUpdateScope r33 = r25.endRestartGroup();
        if (r33 == null) goto L115;
        r33.updateScope(new UDActionPanelKt$UDActionPanel$1(r15, r14, r13, r31, r30, r32, r27, r26, r12, r11));
        return;
    L115:
        return;
    L103:
        r22 = r5;
        goto L105
    L100:
        r113 = r4;
        goto L101
    L97:
        r21 = r3;
        goto L98
    L87:
        if (r10.getSkipping() == false) goto L90;
        r10.skipToGroupEnd();
        r32 = r3;
        r27 = r4;
        r26 = r5;
        r25 = r10;
        r30 = r112;
        r31 = r20;
        goto L111
    L79:
        if ((r12 & 12582912) != 0) goto L84;
        if (r10.changed(r5) == false) goto L83;
        r111 = 8388608;
        goto L77
    L83:
        r111 = 4194304;
        goto L77
    L69:
        if ((r12 & 1572864) != 0) goto L75;
        if (r10.changed(r4) == false) goto L73;
        int r114 = 1048576;
    L74:
        r6 = r6 | r114;
        goto L75
    L73:
        r114 = 524288;
        goto L74
    L59:
        if ((r12 & 196608) != 0) goto L65;
        if (r10.changed(r3) == false) goto L63;
        r19 = 131072;
        goto L64
    L63:
        r19 = 65536;
        goto L64
    L48:
        if ((r12 & 24576) != 0) goto L54;
        if (r10.changed(r2) == false) goto L52;
        int r34 = 16384;
    L53:
        r6 = r34 | r7;
        goto L55
    L52:
        r34 = 8192;
        goto L53
    L37:
        if ((r12 & 3072) != 0) goto L43;
        if (r10.changed(r1) == false) goto L41;
        int r35 = 2048;
    L42:
        r7 = r35 | r8;
        goto L44
    L41:
        r35 = 1024;
        goto L42
    L27:
        if ((r12 & 384) != 0) goto L33;
        if (r10.changedInstance(r13) == false) goto L31;
        int r36 = 256;
    L32:
        r8 = r8 | r36;
        goto L33
    L31:
        r36 = 128;
        goto L32
    L17:
        if ((r12 & 48) != 0) goto L24;
        if (r10.changedInstance(r14) == false) goto L21;
        int r37 = 32;
    L22:
        r8 = r8 | r37;
        goto L24
    L21:
        r37 = 16;
        goto L22
    L6:
        if ((r12 & 6) == 0) goto L8;
        r8 = r12;
        goto L14
    L8:
        if (r10.changed(r15) == false) goto L10;
        int r38 = 4;
    L11:
        r8 = r38 | r12;
        goto L14
    L10:
        r38 = 2;
        goto L11
    }
}
