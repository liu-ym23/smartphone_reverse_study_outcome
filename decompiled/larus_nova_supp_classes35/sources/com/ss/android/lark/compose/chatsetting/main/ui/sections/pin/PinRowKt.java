package com.ss.android.lark.compose.chatsetting.main.ui.sections.pin;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.ss.android.lark.compose.chatsetting.common.ui.icon.ChatSettingIcons;
import com.ss.android.lark.compose.chatsetting.common.ui.widget.SwitchSettingRowKt;
import com.ss.android.lark.compose.foundation.widget.a;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import com.ss.android.lark.flow.chat.resources.b;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PinRowKt {
    public static final void a(Modifier r21, final a r22, final Function1<? super Boolean, Unit> r23, Composer r24, final int r25, final int r26) {
        Intrinsics.checkNotNullParameter(r22, "switchState");
        Intrinsics.checkNotNullParameter(r23, "onCheckedChange");
        Composer r12 = r24.startRestartGroup(119932069);
        int r1 = r26 & 1;
        if (r1 == 0) goto L6;
        int r4 = r25 | 6;
        Modifier r3 = r21;
    L14:
        if ((r26 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        if ((r26 & 4) == 0) goto L27;
        r4 = r4 | 384;
    L34:
        if ((r4 & 147) == 146) goto L36;
    L39:
        if (r1 == 0) goto L41;
        Modifier r13 = Modifier.Companion;
    L43:
        if (ComposerKt.isTraceInProgress() == false) goto L45;
        ComposerKt.traceEventStart(119932069, r4, -1, "com.ss.android.lark.compose.chatsetting.main.ui.sections.pin.PinRow (PinRow.kt:19)");
    L45:
        Intrinsics.checkNotNullParameter(b.a, "<this>");
        Modifier r5 = r13;
        SwitchSettingRowKt.a(b0.a((z) CommonMainString0.t0.getValue(), r12), r22, r23, r5, new com.ss.android.lark.compose.chatsetting.common.ui.widget.a((ImageVector) ChatSettingIcons.f.getValue(), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4288577791L)), Color.box-impl(ColorKt.Color(4284493311L))}), 0.0f, 0.0f, 0, 14, null)), false, r12, ((r4 & 112) | (r4 & 896)) | ((r4 << 9) & 7168), 32);
        if (ComposerKt.isTraceInProgress() == false) goto L48;
        ComposerKt.traceEventEnd();
    L48:
        final Modifier r2 = r13;
    L49:
        ScopeUpdateScope r6 = r12.endRestartGroup();
        if (r6 == null) goto L53;
        r6.updateScope(new PinRowKt$PinRow$1(r2, r22, r23, r25, r26));
        return;
    L53:
        return;
    L41:
        r13 = r3;
        goto L43
    L36:
        if (r12.getSkipping() == false) goto L39;
        r12.skipToGroupEnd();
        r2 = r3;
        goto L49
    L27:
        if ((r25 & 384) != 0) goto L34;
        if (r12.changedInstance(r23) == false) goto L31;
        int r7 = 256;
    L32:
        r4 = r4 | r7;
        goto L34
    L31:
        r7 = 128;
        goto L32
    L17:
        if ((r25 & 48) != 0) goto L24;
        if (r12.changed(r22) == false) goto L21;
        int r8 = 32;
    L22:
        r4 = r4 | r8;
        goto L24
    L21:
        r8 = 16;
        goto L22
    L6:
        if ((r25 & 6) != 0) goto L12;
        r3 = r21;
        if (r12.changed(r3) == false) goto L10;
        int r9 = 4;
    L11:
        r4 = r9 | r25;
        goto L14
    L10:
        r9 = 2;
        goto L11
    L12:
        r3 = r21;
        r4 = r25;
        goto L14
    }
}
