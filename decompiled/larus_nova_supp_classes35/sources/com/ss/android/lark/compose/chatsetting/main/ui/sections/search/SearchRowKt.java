package com.ss.android.lark.compose.chatsetting.main.ui.sections.search;

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
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SearchRowKt {
    public static final void a(final Modifier r12, Composer r13, final int r14) {
        Intrinsics.checkNotNullParameter(r12, "modifier");
        Composer r15 = r13.startRestartGroup(-1653924934);
        if ((r14 & 6) == 0) goto L5;
        int r1 = r14;
    L11:
        if ((r1 & 3) != 2) goto L17;
        if (r15.getSkipping() == false) goto L17;
        r15.skipToGroupEnd();
    L22:
        ScopeUpdateScope r16 = r15.endRestartGroup();
        if (r16 == null) goto L26;
        r16.updateScope(new SearchRowKt$SearchRow$1(r12, r14));
        return;
    L26:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-1653924934, r1, -1, "com.ss.android.lark.compose.chatsetting.main.ui.sections.search.SearchRow (SearchRow.kt:14)");
    L19:
        Intrinsics.checkNotNullParameter(b.a, "<this>");
        StandardSettingRowKt.a(r12, b0.a((z) CommonMainString0.J.getValue(), r15), new a((ImageVector) ChatSettingIcons.d.getValue(), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4284916735L)), Color.box-impl(ColorKt.Color(4278216447L))}), 0.0f, 0.0f, 0, 14, null)), BuildConfig.FLAVOR, false, r15, (r1 & 14) | 3072, 16);
        if (ComposerKt.isTraceInProgress() == false) goto L22;
        ComposerKt.traceEventEnd();
        goto L22
    L5:
        if (r15.changed(r12) == false) goto L7;
        int r2 = 4;
    L8:
        r1 = r2 | r14;
        goto L11
    L7:
        r2 = 2;
        goto L8
    }
}
