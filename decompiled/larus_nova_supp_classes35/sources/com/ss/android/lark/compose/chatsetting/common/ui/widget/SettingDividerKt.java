package com.ss.android.lark.compose.chatsetting.common.ui.widget;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.ss.android.lark.compose.foundation.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SettingDividerKt {
    public static final void a(final Modifier r11, final float r12, Composer r13, final int r14, final int r15) {
        Composer r16 = r13.startRestartGroup(1327219404);
        int r1 = r15 & 1;
        if (r1 == 0) goto L6;
        int r2 = r14 | 6;
    L13:
        int r3 = r15 & 2;
        if (r3 == 0) goto L17;
        r2 = r2 | 48;
    L24:
        if ((r2 & 19) == 18) goto L26;
    L29:
        if (r1 == 0) goto L31;
        r11 = Modifier.Companion;
    L31:
        if (r3 == 0) goto L34;
        r12 = Dp.constructor-impl(56);
    L34:
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventStart(1327219404, r2, -1, "com.ss.android.lark.compose.chatsetting.common.ui.widget.SettingDivider (SettingDivider.kt:22)");
    L36:
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(r11, r12, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null), Dp.constructor-impl((float) 0.5d)), n.a(r16, 0).d.f, null, 2, null), r16, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L39;
        ComposerKt.traceEventEnd();
    L39:
        ScopeUpdateScope r17 = r16.endRestartGroup();
        if (r17 == null) goto L43;
        r17.updateScope(new SettingDividerKt$SettingDivider$1(r11, r12, r14, r15));
        return;
    L43:
        return;
    L26:
        if (r16.getSkipping() == false) goto L29;
        r16.skipToGroupEnd();
        goto L39
    L17:
        if ((r14 & 48) != 0) goto L24;
        if (r16.changed(r12) == false) goto L21;
        int r4 = 32;
    L22:
        r2 = r2 | r4;
        goto L24
    L21:
        r4 = 16;
        goto L22
    L6:
        if ((r14 & 6) == 0) goto L8;
        r2 = r14;
        goto L13
    L8:
        if (r16.changed(r11) == false) goto L10;
        int r5 = 4;
    L11:
        r2 = r5 | r14;
        goto L13
    L10:
        r5 = 2;
        goto L11
    }
}
