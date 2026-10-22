package com.ss.android.lark.compose.chatsetting.main.ui.sections.groupinfo;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.ss.android.lark.compose.chatsetting.common.ui.icon.ChatSettingIcons;
import com.ss.android.lark.compose.chatsetting.common.ui.widget.StandardSettingRowKt;
import com.ss.android.lark.compose.chatsetting.common.ui.widget.a;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import com.ss.android.lark.flow.chat.resources.b;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class GroupInfoRowKt {
    public static final void a(final Modifier r12, final String r13, Composer r14, final int r15) {
        Intrinsics.checkNotNullParameter(r12, "modifier");
        Intrinsics.checkNotNullParameter(r13, "chatName");
        Composer r16 = r14.startRestartGroup(1714733512);
        if ((r15 & 6) == 0) goto L5;
        int r1 = r15;
    L11:
        if ((r15 & 48) != 0) goto L18;
        if (r16.changed(r13) == false) goto L15;
        int r3 = 32;
    L16:
        r1 = r1 | r3;
        goto L18
    L15:
        r3 = 16;
    L18:
        if ((r1 & 19) != 18) goto L24;
        if (r16.getSkipping() == false) goto L24;
        r16.skipToGroupEnd();
    L29:
        ScopeUpdateScope r17 = r16.endRestartGroup();
        if (r17 == null) goto L33;
        r17.updateScope(new GroupInfoRowKt$GroupInfoRow$1(r12, r13, r15));
        return;
    L33:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(1714733512, r1, -1, "com.ss.android.lark.compose.chatsetting.main.ui.sections.groupinfo.GroupInfoRow (GroupInfoRow.kt:14)");
    L26:
        Intrinsics.checkNotNullParameter(b.a, "<this>");
        StandardSettingRowKt.a(r12, b0.a((z) CommonMainString0.n0.getValue(), r16), new a((ImageVector) ChatSettingIcons.a.getValue(), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4284916735L)), Color.box-impl(ColorKt.Color(4278216447L))}), 0.0f, 0.0f, 0, 14, null)), r13, false, r16, (r1 & 14) | ((r1 << 6) & 7168), 16);
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventEnd();
        goto L29
    L5:
        if (r16.changed(r12) == false) goto L7;
        int r2 = 4;
    L8:
        r1 = r2 | r15;
        goto L11
    L7:
        r2 = 2;
        goto L8
    }
}
