package com.ss.android.lark.compose.chatsetting.main.ui.sections.doubao;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.chatsetting.common.ui.icon.ChatSettingIcons;
import com.ss.android.lark.compose.chatsetting.common.ui.widget.SettingDividerKt;
import com.ss.android.lark.compose.chatsetting.common.ui.widget.SwitchSettingRowKt;
import com.ss.android.lark.compose.foundation.widget.a;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DoubaoSettingsSectionKt {
    public static final void a(final a r32, final a r33, final Function1<? super Boolean, Unit> r34, final Function1<? super Boolean, Unit> r35, String r36, Function2<? super String, ? super String, String> r37, Composer r38, final int r39, final int r40) {
        Intrinsics.checkNotNullParameter(r32, "useDoubaoInChatState");
        Intrinsics.checkNotNullParameter(r33, "doubaoProactiveReplyState");
        Intrinsics.checkNotNullParameter(r34, "onUseDoubaoInChatChange");
        Intrinsics.checkNotNullParameter(r35, "onDoubaoProactiveReplyChange");
        Composer r14 = r38.startRestartGroup(-350298000);
        if ((r40 & 1) == 0) goto L6;
        int r1 = r39 | 6;
    L14:
        if ((r40 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r40 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r40 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        int r2 = r40 & 16;
        if (r2 == 0) goto L47;
        r1 = r1 | 24576;
    L53:
        String r4 = r36;
    L54:
        int r5 = r40 & 32;
        if (r5 == 0) goto L58;
        r1 = r1 | 196608;
    L64:
        final Function2<? super String, ? super String, String> r6 = r37;
    L65:
        int r8 = r1;
        if ((74899 & r8) != 74898) goto L72;
        if (r14.getSkipping() == false) goto L72;
        r14.skipToGroupEnd();
        final String r7 = r4;
    L99:
        ScopeUpdateScope r15 = r14.endRestartGroup();
        if (r15 == null) goto L103;
        r15.updateScope(new DoubaoSettingsSectionKt$DoubaoSettingsSection$2(r32, r33, r34, r35, r7, r6, r39, r40));
        return;
    L103:
        return;
    L72:
        if (r2 == 0) goto L74;
        String r16 = null;
    L75:
        if (r5 == 0) goto L81;
        r14.startReplaceGroup(1849434622);
        Object r3 = r14.rememberedValue();
        if (r3 != Composer.Companion.getEmpty()) goto L79;
        r3 = DoubaoSettingsSectionKt$DoubaoSettingsSection$1$1.INSTANCE;
        r14.updateRememberedValue(r3);
    L79:
        r14.endReplaceGroup();
        r6 = (Function2) ((KFunction) r3);
    L81:
        if (ComposerKt.isTraceInProgress() == false) goto L83;
        ComposerKt.traceEventStart(-350298000, r8, -1, "com.ss.android.lark.compose.chatsetting.main.ui.sections.doubao.DoubaoSettingsSection (DoubaoSettingsSection.kt:25)");
    L83:
        r14.startReplaceGroup(5004770);
        if ((57344 & r8) != 16384) goto L86;
        boolean r0 = true;
    L87:
        Object r9 = r14.rememberedValue();
        if (r0 == false) goto L90;
    L91:
        if (r16 != null) goto L93;
        r9 = ((itb.a) LarkContext.spiByDwarf(itb.a.class)).i();
    L94:
        r14.updateRememberedValue(r9);
    L95:
        String r10 = (String) r9;
        r14.endReplaceGroup();
        String r11 = (String) r6.invoke(StringResources_androidKt.stringResource(2131889958, r14, 0), r10);
        Lazy r12 = ChatSettingIcons.a;
        ImageVector r13 = (ImageVector) ChatSettingIcons.t.getValue();
        Brush.Companion r25 = Brush.Companion;
        Function2<? super String, ? super String, String> r30 = r6;
        SwitchSettingRowKt.a(r11, r32, r34, null, new com.ss.android.lark.compose.chatsetting.common.ui.widget.a(r13, Brush.Companion.verticalGradient-8A-3gB4$default(r25, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4282427903L)), Color.box-impl(ColorKt.Color(4278216959L))}), 0.0f, 0.0f, 0, 14, null)), false, r14, ((r8 << 3) & 112) | (r8 & 896), 40);
        SettingDividerKt.a(null, 0.0f, r14, 0, 3);
        SwitchSettingRowKt.a((String) r30.invoke(StringResources_androidKt.stringResource(2131889959, r14, 0), r10), r33, r35, null, new com.ss.android.lark.compose.chatsetting.common.ui.widget.a((ImageVector) ChatSettingIcons.u.getValue(), Brush.Companion.verticalGradient-8A-3gB4$default(r25, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4282427903L)), Color.box-impl(ColorKt.Color(4278216959L))}), 0.0f, 0.0f, 0, 14, null)), r32.a, r14, (r8 & 112) | ((r8 >> 3) & 896), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventEnd();
    L98:
        r7 = r16;
        r6 = r30;
        goto L99
    L93:
        r9 = r16;
        goto L94
    L90:
        if (r9 != Composer.Companion.getEmpty()) goto L95;
    L86:
        r0 = false;
        goto L87
    L74:
        r16 = r4;
        goto L75
    L58:
        if ((196608 & r39) != 0) goto L64;
        r6 = r37;
        if (r14.changedInstance(r6) == false) goto L62;
        int r17 = 131072;
    L63:
        r1 = r1 | r17;
        goto L65
    L62:
        r17 = 65536;
        goto L63
    L47:
        if ((r39 & 24576) != 0) goto L53;
        r4 = r36;
        if (r14.changed(r4) == false) goto L51;
        int r18 = 16384;
    L52:
        r1 = r1 | r18;
        goto L54
    L51:
        r18 = 8192;
        goto L52
    L37:
        if ((r39 & 3072) != 0) goto L43;
        if (r14.changedInstance(r35) == false) goto L41;
        int r19 = 2048;
    L42:
        r1 = r1 | r19;
        goto L43
    L41:
        r19 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L42
    L27:
        if ((r39 & 384) != 0) goto L34;
        if (r14.changedInstance(r34) == false) goto L31;
        int r20 = 256;
    L32:
        r1 = r1 | r20;
        goto L34
    L31:
        r20 = 128;
        goto L32
    L17:
        if ((r39 & 48) != 0) goto L24;
        if (r14.changed(r33) == false) goto L21;
        int r21 = 32;
    L22:
        r1 = r1 | r21;
        goto L24
    L21:
        r21 = 16;
        goto L22
    L6:
        if ((r39 & 6) == 0) goto L8;
        r1 = r39;
        goto L14
    L8:
        if (r14.changed(r32) == false) goto L10;
        int r22 = 4;
    L11:
        r1 = r22 | r39;
        goto L14
    L10:
        r22 = 2;
        goto L11
    }
}
