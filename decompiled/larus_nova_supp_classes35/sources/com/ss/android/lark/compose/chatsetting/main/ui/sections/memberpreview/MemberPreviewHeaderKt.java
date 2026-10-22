package com.ss.android.lark.compose.chatsetting.main.ui.sections.memberpreview;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.lark.kmp.pb.basic.v1.Chat;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.chatsetting.common.ui.icon.ChatSettingIcons;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import com.ss.android.lark.flow.chat.resources.b;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MemberPreviewHeaderKt {
    public static final void a(Modifier r33, final int r34, final Chat.Type r35, boolean r36, Composer r37, final int r38, final int r39) {
        Intrinsics.checkNotNullParameter(r35, "chatType");
        Composer r1 = r37.startRestartGroup(-1599493645);
        int r4 = r39 & 1;
        if (r4 == 0) goto L6;
        int r8 = r38 | 6;
        Modifier r7 = r33;
    L14:
        if ((r39 & 2) == 0) goto L17;
        r8 = r8 | 48;
    L24:
        if ((r39 & 4) == 0) goto L27;
        r8 = r8 | 384;
    L33:
        int r9 = r39 & 8;
        if (r9 == 0) goto L37;
        r8 = r8 | 3072;
    L43:
        boolean r12 = r36;
    L45:
        if ((r8 & 1171) == 1170) goto L47;
    L50:
        if (r4 == 0) goto L52;
        Modifier r5 = Modifier.Companion;
    L54:
        if (r9 == 0) goto L56;
        boolean r32 = true;
    L58:
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventStart(-1599493645, r8, -1, "com.ss.android.lark.compose.chatsetting.main.ui.sections.memberpreview.MemberPreviewHeader (MemberPreviewHeader.kt:25)");
    L61:
        if (r35 == Chat.Type.P2P) goto L63;
        Modifier r0 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(r5, 0.0f, 1, null), Dp.constructor-impl(16), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, null);
        MeasurePolicy r6 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getCenterVertically(), r1, 48);
        long r10 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r11 = (int) (r10 ^ (r10 >>> 32));
        CompositionLocalMap r13 = r1.getCurrentCompositionLocalMap();
        Modifier r2 = ComposedModifierKt.materializeModifier(r1, r0);
        ComposeUiNode.Companion r14 = ComposeUiNode.Companion;
        Function0 r15 = r14.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L72;
        ComposablesKt.invalidApplier();
    L72:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L75;
        r1.createNode(r15);
    L76:
        Composer r16 = Updater.constructor-impl(r1);
        Updater.set-impl(r16, r6, r14.getSetMeasurePolicy());
        Updater.set-impl(r16, r13, r14.getSetResolvedCompositionLocals());
        Function2 r17 = r14.getSetCompositeKeyHash();
        if (r16.getInserting() == false) goto L79;
    L80:
        r16.updateRememberedValue(Integer.valueOf(r11));
        r16.apply(Integer.valueOf(r11), r17);
    L81:
        Updater.set-impl(r16, r2, r14.getSetModifier());
        RowScopeInstance r18 = RowScopeInstance.INSTANCE;
        Intrinsics.checkNotNullParameter(b.a, "<this>");
        String r19 = b0.a((z) CommonMainString0.Y.getValue(), r1);
        TextStyle r3 = n.b(r1).b;
        long r20 = n.a(r1, 0).d.a;
        Modifier.Companion r21 = Modifier.Companion;
        TextKt.Text-Nvy7gAk(r19, RowScope.-CC.weight$default(r18, r21, 1.0f, false, 2, null), r20, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, r3, r1, 0, 0, 131064);
        r1.startReplaceGroup(2070751429);
        if (r32 == false) goto L85;
        if (r34 <= 0) goto L85;
        TextKt.Text-Nvy7gAk(String.valueOf(r34), null, n.a(r1, 0).d.b, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, n.b(r1).c, r1, 0, 0, 131066);
    L85:
        r1.endReplaceGroup();
        IconKt.Icon-ww6aTOc((ImageVector) ChatSettingIcons.l.getValue(), null, SizeKt.size-3ABfNKs(r21, Dp.constructor-impl(24)), n.a(r1, 0).d.d, r1, 432, 0);
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L88;
        ComposerKt.traceEventEnd();
    L88:
        r12 = r32;
    L89:
        ScopeUpdateScope r22 = r1.endRestartGroup();
        if (r22 == null) goto L94;
        final Modifier r23 = r5;
        final boolean r24 = r12;
        r22.updateScope(new MemberPreviewHeaderKt$MemberPreviewHeader$3(r23, r34, r35, r24, r38, r39));
        return;
    L94:
        return;
    L79:
        if (Intrinsics.areEqual(r16.rememberedValue(), Integer.valueOf(r11)) == true) goto L81;
    L75:
        r1.useNode();
        goto L76
    L63:
        if (ComposerKt.isTraceInProgress() == false) goto L65;
        ComposerKt.traceEventEnd();
    L65:
        ScopeUpdateScope r25 = r1.endRestartGroup();
        if (r25 == null) goto L93;
        final Modifier r26 = r5;
        final boolean r27 = r32;
        r25.updateScope(new MemberPreviewHeaderKt$MemberPreviewHeader$1(r26, r34, r35, r27, r38, r39));
        return;
    L93:
        return;
    L56:
        r32 = r12;
        goto L58
    L52:
        r5 = r7;
        goto L54
    L47:
        if (r1.getSkipping() == false) goto L50;
        r1.skipToGroupEnd();
        r5 = r7;
        goto L89
    L37:
        if ((r38 & 3072) != 0) goto L43;
        r12 = r36;
        if (r1.changed(r12) == false) goto L41;
        int r110 = 2048;
    L42:
        r8 = r8 | r110;
        goto L45
    L41:
        r110 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L42
    L27:
        if ((r38 & 384) != 0) goto L33;
        if (r1.changed(r35.ordinal()) == false) goto L31;
        int r28 = 256;
    L32:
        r8 = r8 | r28;
        goto L33
    L31:
        r28 = 128;
        goto L32
    L17:
        if ((r38 & 48) != 0) goto L24;
        if (r1.changed(r34) == false) goto L21;
        int r29 = 32;
    L22:
        r8 = r8 | r29;
        goto L24
    L21:
        r29 = 16;
        goto L22
    L6:
        if ((r38 & 6) != 0) goto L12;
        r7 = r33;
        if (r1.changed(r7) == false) goto L10;
        int r30 = 4;
    L11:
        r8 = r30 | r38;
        goto L14
    L10:
        r30 = 2;
        goto L11
    L12:
        r7 = r33;
        r8 = r38;
        goto L14
    }
}
