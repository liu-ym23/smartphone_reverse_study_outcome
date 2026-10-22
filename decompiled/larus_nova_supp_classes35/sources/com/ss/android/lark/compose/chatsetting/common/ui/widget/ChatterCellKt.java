package com.ss.android.lark.compose.chatsetting.common.ui.widget;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.compose.util.e;
import com.ss.android.lark.image.compose.common.ImageFormat;
import com.ss.android.lark.image.compose.common.avatar.AvatarImageComponentKt;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatterCellKt {
    public static final void a(Modifier r33, final Chatter r34, final d r35, final Function1<? super Chatter, Unit> r36, Composer r37, final int r38, final int r39) {
        Intrinsics.checkNotNullParameter(r34, "member");
        Intrinsics.checkNotNullParameter(r35, "rustClient");
        Intrinsics.checkNotNullParameter(r36, "onAvatarClick");
        Composer r1 = r37.startRestartGroup(744141430);
        int r6 = r39 & 1;
        if (r6 == 0) goto L6;
        int r8 = r38 | 6;
        Modifier r7 = r33;
    L14:
        if ((r39 & 2) == 0) goto L17;
        r8 = r8 | 48;
    L24:
        if ((r39 & 8) == 0) goto L27;
        r8 = r8 | 3072;
    L34:
        if ((r8 & 1043) == 1042) goto L36;
    L39:
        if (r6 == 0) goto L41;
        Modifier r15 = Modifier.Companion;
    L43:
        if (ComposerKt.isTraceInProgress() == false) goto L45;
        ComposerKt.traceEventStart(744141430, r8, -1, "com.ss.android.lark.compose.chatsetting.common.ui.widget.ChatterCell (ChatterCell.kt:34)");
    L45:
        Alignment.Horizontal r0 = Alignment.Companion.getCenterHorizontally();
        float r9 = 56;
        Modifier r10 = SizeKt.width-3ABfNKs(r15, Dp.constructor-impl(r9));
        MeasurePolicy r2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), r0, r1, 48);
        long r12 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r11 = (int) ((r12 >>> 32) ^ r12);
        CompositionLocalMap r13 = r1.getCurrentCompositionLocalMap();
        Modifier r14 = ComposedModifierKt.materializeModifier(r1, r10);
        ComposeUiNode.Companion r16 = ComposeUiNode.Companion;
        Function0 r17 = r16.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L48;
        ComposablesKt.invalidApplier();
    L48:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L51;
        r1.createNode(r17);
    L52:
        Composer r18 = Updater.constructor-impl(r1);
        Updater.set-impl(r18, r2, r16.getSetMeasurePolicy());
        Updater.set-impl(r18, r13, r16.getSetResolvedCompositionLocals());
        Function2 r3 = r16.getSetCompositeKeyHash();
        if (r18.getInserting() == false) goto L55;
    L56:
        r18.updateRememberedValue(Integer.valueOf(r11));
        r18.apply(Integer.valueOf(r11), r3);
    L57:
        Updater.set-impl(r18, r14, r16.getSetModifier());
        ColumnScopeInstance r4 = ColumnScopeInstance.INSTANCE;
        String r19 = r34.getAvatar_key();
        if (r19 != null) goto L60;
        r19 = BuildConfig.FLAVOR;
    L60:
        com.ss.android.lark.image.compose.common.avatar.a r5 = new com.ss.android.lark.image.compose.common.avatar.a(r19, r34.getId(), Dp.constructor-impl(r9), ImageFormat.PNG);
        Modifier.Companion r110 = Modifier.Companion;
        Modifier r20 = ClipKt.clip(SizeKt.size-3ABfNKs(r110, Dp.constructor-impl(r9)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(28)));
        String r21 = r34.getId();
        Intrinsics.checkNotNullParameter(r21, "chatterId");
        Modifier r22 = TestTagKt.testTag(r20, "chat_setting_chatter_avatar_" + r21);
        r1.startReplaceGroup(-1633490746);
        if ((r8 & 7168) != 2048) goto L63;
        boolean r23 = true;
    L64:
        boolean r24 = r23 | r1.changedInstance(r34);
        Object r25 = r1.rememberedValue();
        if (r24 == false) goto L67;
    L68:
        r25 = new ChatterCellKt$ChatterCell$1$1$1(r36, r34);
        r1.updateRememberedValue(r25);
    L69:
        r1.endReplaceGroup();
        Modifier r32 = r15;
        AvatarImageComponentKt.a(r5, e.a(r22, (Function0) r25, r1, 0), null, null, null, null, null, null, r1, 224640, 192);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(r110, Dp.constructor-impl(6)), r1, 6);
        String r26 = r34.getAlias();
        String r27 = r34.getName();
        r1.startReplaceGroup(-1633490746);
        boolean r28 = r1.changed(r26) | r1.changed(r27);
        Object r29 = r1.rememberedValue();
        if (r28 == false) goto L72;
    L73:
        String r30 = r34.getAlias();
        if (r30 != null) goto L76;
    L83:
        r30 = r34.getName();
    L84:
        r29 = r30;
        r1.updateRememberedValue(r29);
    L85:
        r1.endReplaceGroup();
        TextKt.Text-Nvy7gAk((String) r29, null, n.a(r1, 0).d.b, null, 0, null, null, null, 0, null, null, 0, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, null, n.b(r1).d, r1, 0, 24960, 110586);
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L88;
        ComposerKt.traceEventEnd();
    L88:
        ScopeUpdateScope r31 = r1.endRestartGroup();
        if (r31 == null) goto L92;
        final Modifier r40 = r32;
        r31.updateScope(new ChatterCellKt$ChatterCell$2(r40, r34, r35, r36, r38, r39));
        return;
    L92:
        return;
    L76:
        if (r30.length() <= 0) goto L78;
        boolean r111 = true;
    L79:
        if (r111 == true) goto L82;
        r30 = null;
    L82:
        if (r30 != null) goto L84;
    L78:
        r111 = false;
        goto L79
    L72:
        if (r29 != Composer.Companion.getEmpty()) goto L85;
    L67:
        if (r25 != Composer.Companion.getEmpty()) goto L69;
    L63:
        r23 = false;
        goto L64
    L55:
        if (Intrinsics.areEqual(r18.rememberedValue(), Integer.valueOf(r11)) == true) goto L57;
    L51:
        r1.useNode();
        goto L52
    L41:
        r15 = r7;
        goto L43
    L36:
        if (r1.getSkipping() == false) goto L39;
        r1.skipToGroupEnd();
        r32 = r7;
        goto L88
    L27:
        if ((r38 & 3072) != 0) goto L34;
        if (r1.changedInstance(r36) == false) goto L31;
        int r41 = 2048;
    L32:
        r8 = r8 | r41;
        goto L34
    L31:
        r41 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L32
    L17:
        if ((r38 & 48) != 0) goto L24;
        if (r1.changedInstance(r34) == false) goto L21;
        int r42 = 32;
    L22:
        r8 = r8 | r42;
        goto L24
    L21:
        r42 = 16;
        goto L22
    L6:
        if ((r38 & 6) != 0) goto L12;
        r7 = r33;
        if (r1.changed(r7) == false) goto L10;
        int r43 = 4;
    L11:
        r8 = r43 | r38;
        goto L14
    L10:
        r43 = 2;
        goto L11
    L12:
        r7 = r33;
        r8 = r38;
        goto L14
    }
}
