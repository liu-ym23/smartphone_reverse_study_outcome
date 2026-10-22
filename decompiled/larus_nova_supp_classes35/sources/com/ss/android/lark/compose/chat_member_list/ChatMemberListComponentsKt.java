package com.ss.android.lark.compose.chat_member_list;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.SearchKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.chatsetting.common.ui.icon.ChatSettingIcons;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import com.ss.android.lark.image.compose.common.ImageFormat;
import com.ss.android.lark.image.compose.common.avatar.AvatarImageComponentKt;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatMemberListComponentsKt {
    public static final void e(final com.ss.android.lark.compose.chatterselector.d r47, Modifier r48, Composer r49, final int r50, final int r51) {
        Composer r6 = r49.startRestartGroup(-1185460754);
        if ((r51 & 1) == 0) goto L6;
        int r4 = r50 | 6;
    L13:
        int r5 = r51 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        Modifier r7 = r48;
    L25:
        if ((r4 & 19) == 18) goto L27;
    L30:
        if (r5 == 0) goto L32;
        final Modifier r14 = Modifier.Companion;
    L34:
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventStart(-1185460754, r4, -1, "com.ss.android.lark.compose.chat_member_list.ChatterNameTag (ChatMemberListComponents.kt:251)");
    L36:
        String r8 = r47.a;
        if (r8 == null) goto L39;
        TextStyle r25 = TextStyle.copy-p1EtxEg$default(n.b(r6).d, 0, TextUnitKt.getSp(11), null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777213, null);
        long r12 = n.a(r6, 0).a.a;
        int r20 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
        Modifier r9 = PaddingKt.padding-qDBjuR0$default(r14, Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, null);
        float r10 = 6;
        Modifier r3 = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(ClipKt.clip(r9, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r10))), n.a(r6, 0).a.c, null, 2, null), Dp.constructor-impl(r10), Dp.constructor-impl((float) 3.5d));
        Integer r11 = r47.c;
        if (r11 == null) goto L48;
        Modifier r13 = SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(r11.intValue()), 1, null);
    L49:
        Modifier r15 = r3.then(r13);
        final Modifier r16 = r14;
        Composer r32 = r6;
        TextKt.Text-Nvy7gAk(r8, r15, r12, null, 0, null, null, null, 0, null, null, 0, r20, false, 1, 0, null, r25, r32, 0, 24960, 110584);
        if (ComposerKt.isTraceInProgress() == false) goto L52;
        ComposerKt.traceEventEnd();
    L52:
        ScopeUpdateScope r17 = r32.endRestartGroup();
        if (r17 == null) goto L57;
        r17.updateScope(new ChatMemberListComponentsKt$ChatterNameTag$1(r47, r16, r50, r51));
        return;
    L57:
        return;
    L48:
        r13 = Modifier.Companion;
        goto L49
    L39:
        if (ComposerKt.isTraceInProgress() == false) goto L41;
        ComposerKt.traceEventEnd();
    L41:
        ScopeUpdateScope r18 = r6.endRestartGroup();
        if (r18 == null) goto L56;
        r18.updateScope(new ChatMemberListComponentsKt$ChatterNameTag$text$1(r47, r14, r50, r51));
        return;
    L56:
        return;
    L32:
        r14 = r7;
        goto L34
    L27:
        if (r6.getSkipping() == false) goto L30;
        r6.skipToGroupEnd();
        r32 = r6;
        r16 = r7;
        goto L52
    L17:
        if ((r50 & 48) != 0) goto L23;
        r7 = r48;
        if (r6.changed(r7) == false) goto L21;
        int r19 = 32;
    L22:
        r4 = r4 | r19;
        goto L25
    L21:
        r19 = 16;
        goto L22
    L6:
        if ((r50 & 6) == 0) goto L8;
        r4 = r50;
        goto L13
    L8:
        if (r6.changed(r47) == false) goto L10;
        int r21 = 4;
    L11:
        r4 = r21 | r50;
        goto L13
    L10:
        r21 = 2;
        goto L11
    }

    public static final void c(final float r23, final Function0<Unit> r24, Modifier r25, Composer r26, final int r27, final int r28) {
        Intrinsics.checkNotNullParameter(r24, "onClick");
        Composer r3 = r26.startRestartGroup(2107169955);
        if ((r28 & 1) == 0) goto L6;
        int r5 = r27 | 6;
    L14:
        if ((r28 & 2) == 0) goto L17;
        r5 = r5 | 48;
    L23:
        int r6 = r28 & 4;
        if (r6 == 0) goto L27;
        r5 = r5 | 384;
    L33:
        Modifier r8 = r25;
    L35:
        if ((r5 & 147) == 146) goto L37;
    L40:
        if (r6 == 0) goto L42;
        Modifier r13 = Modifier.Companion;
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(2107169955, r5, -1, "com.ss.android.lark.compose.chat_member_list.ChatMembersTopBarBackAction (ChatMemberListComponents.kt:428)");
    L46:
        final FocusManager r0 = (FocusManager) r3.consume(CompositionLocalsKt.getLocalFocusManager());
        r3.startReplaceGroup(-1633490746);
        if ((r5 & 112) != 32) goto L49;
        boolean r7 = true;
    L50:
        boolean r9 = r7 | r3.changed(r0);
        Object r10 = r3.rememberedValue();
        if (r9 == false) goto L53;
    L54:
        r10 = new ChatMemberListComponentsKt$ChatMembersTopBarBackAction$onClickWithFocusHandling$1$1(r0, r24);
        r3.updateRememberedValue(r10);
    L55:
        Function0 r20 = (Function0) r10;
        r3.endReplaceGroup();
        Modifier r14 = TestTagKt.testTag(SizeKt.size-3ABfNKs(r13, Dp.constructor-impl(44)), "chat_members_top_bar_back");
        r3.startReplaceGroup(1849434622);
        Object r1 = r3.rememberedValue();
        if (r1 != Composer.Companion.getEmpty()) goto L58;
        r1 = InteractionSourceKt.MutableInteractionSource();
        r3.updateRememberedValue(r1);
    L58:
        r3.endReplaceGroup();
        Modifier r2 = ClickableKt.clickable-O2vRcR0$default(r14, (MutableInteractionSource) r1, null, false, null, null, r20, 28, null);
        MeasurePolicy r11 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        long r12 = ComposablesKt.getCurrentCompositeKeyHashCode(r3, 0);
        int r15 = (int) (r12 ^ (r12 >>> 32));
        CompositionLocalMap r16 = r3.getCurrentCompositionLocalMap();
        Modifier r4 = ComposedModifierKt.materializeModifier(r3, r2);
        ComposeUiNode.Companion r17 = ComposeUiNode.Companion;
        Function0 r18 = r17.getConstructor();
        if ((r3.getApplier() instanceof Applier) == true) goto L61;
        ComposablesKt.invalidApplier();
    L61:
        r3.startReusableNode();
        if (r3.getInserting() == false) goto L64;
        r3.createNode(r18);
    L65:
        Composer r19 = Updater.constructor-impl(r3);
        Updater.set-impl(r19, r11, r17.getSetMeasurePolicy());
        Updater.set-impl(r19, r16, r17.getSetResolvedCompositionLocals());
        Function2 r21 = r17.getSetCompositeKeyHash();
        if (r19.getInserting() == false) goto L68;
    L69:
        r19.updateRememberedValue(Integer.valueOf(r15));
        r19.apply(Integer.valueOf(r15), r21);
    L70:
        Updater.set-impl(r19, r4, r17.getSetModifier());
        BoxScopeInstance r22 = BoxScopeInstance.INSTANCE;
        IconKt.Icon-ww6aTOc((ImageVector) ChatSettingIcons.m.getValue(), null, SizeKt.size-3ABfNKs(Modifier.Companion, r23), n.a(r3, 0).d.a, r3, 48, 0);
        r3.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L73;
        ComposerKt.traceEventEnd();
    L73:
        ScopeUpdateScope r29 = r3.endRestartGroup();
        if (r29 == null) goto L77;
        final Modifier r30 = r13;
        r29.updateScope(new ChatMemberListComponentsKt$ChatMembersTopBarBackAction$3(r23, r24, r30, r27, r28));
        return;
    L77:
        return;
    L68:
        if (Intrinsics.areEqual(r19.rememberedValue(), Integer.valueOf(r15)) == true) goto L70;
    L64:
        r3.useNode();
        goto L65
    L53:
        if (r10 != Composer.Companion.getEmpty()) goto L55;
    L49:
        r7 = false;
        goto L50
    L42:
        r13 = r8;
        goto L44
    L37:
        if (r3.getSkipping() == false) goto L40;
        r3.skipToGroupEnd();
        r13 = r8;
        goto L73
    L27:
        if ((r27 & 384) != 0) goto L33;
        r8 = r25;
        if (r3.changed(r8) == false) goto L31;
        int r31 = 256;
    L32:
        r5 = r5 | r31;
        goto L35
    L31:
        r31 = 128;
        goto L32
    L17:
        if ((r27 & 48) != 0) goto L23;
        if (r3.changedInstance(r24) == false) goto L21;
        int r32 = 32;
    L22:
        r5 = r5 | r32;
        goto L23
    L21:
        r32 = 16;
        goto L22
    L6:
        if ((r27 & 6) == 0) goto L8;
        r5 = r27;
        goto L14
    L8:
        if (r3.changed(r23) == false) goto L10;
        int r33 = 4;
    L11:
        r5 = r33 | r27;
        goto L14
    L10:
        r33 = 2;
        goto L11
    }

    public static final void a(final String r64, final Function1<? super String, Unit> r65, final String r66, Modifier r67, Composer r68, final int r69, final int r70) {
        Intrinsics.checkNotNullParameter(r64, "query");
        Intrinsics.checkNotNullParameter(r65, "onQueryChange");
        Intrinsics.checkNotNullParameter(r66, "placeholder");
        Composer r15 = r68.startRestartGroup(-1634228160);
        if ((r70 & 1) == 0) goto L6;
        int r4 = r69 | 6;
    L14:
        if ((r70 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        if ((r70 & 4) == 0) goto L27;
        r4 = r4 | 384;
    L33:
        int r6 = r70 & 8;
        if (r6 == 0) goto L37;
        r4 = r4 | 3072;
    L43:
        Modifier r8 = r67;
    L44:
        int r14 = r4;
        if ((r14 & 1171) == 1170) goto L47;
    L50:
        if (r6 == 0) goto L52;
        Modifier r11 = Modifier.Companion;
    L54:
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventStart(-1634228160, r14, -1, "com.ss.android.lark.compose.chat_member_list.ChatMembersSearchBar (ChatMemberListComponents.kt:317)");
    L56:
        float r7 = 12;
        Modifier r5 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(r11, 0.0f, 1, null), Dp.constructor-impl(r7), Dp.constructor-impl(6));
        Alignment.Companion r16 = Alignment.Companion;
        MeasurePolicy r9 = BoxKt.maybeCachedBoxMeasurePolicy(r16.getTopStart(), false);
        long r17 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r13 = (int) (r17 ^ (r17 >>> 32));
        CompositionLocalMap r12 = r15.getCurrentCompositionLocalMap();
        Modifier r10 = ComposedModifierKt.materializeModifier(r15, r5);
        ComposeUiNode.Companion r18 = ComposeUiNode.Companion;
        Function0 r3 = r18.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L59;
        ComposablesKt.invalidApplier();
    L59:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L62;
        r15.createNode(r3);
    L63:
        Composer r19 = Updater.constructor-impl(r15);
        Updater.set-impl(r19, r9, r18.getSetMeasurePolicy());
        Updater.set-impl(r19, r12, r18.getSetResolvedCompositionLocals());
        Function2 r20 = r18.getSetCompositeKeyHash();
        if (r19.getInserting() == false) goto L66;
    L67:
        r19.updateRememberedValue(Integer.valueOf(r13));
        r19.apply(Integer.valueOf(r13), r20);
    L68:
        Updater.set-impl(r19, r10, r18.getSetModifier());
        BoxScopeInstance r21 = BoxScopeInstance.INSTANCE;
        Modifier.Companion r22 = Modifier.Companion;
        Modifier r23 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(r22, 0.0f, 1, null), Dp.constructor-impl(48)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16))), n.a(r15, 0).c.d, null, 2, null), Dp.constructor-impl(r7), 0.0f, 2, null);
        MeasurePolicy r24 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), r16.getCenterVertically(), r15, 48);
        long r25 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r26 = (int) (r25 ^ (r25 >>> 32));
        CompositionLocalMap r27 = r15.getCurrentCompositionLocalMap();
        Modifier r28 = ComposedModifierKt.materializeModifier(r15, r23);
        Function0 r29 = r18.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L71;
        ComposablesKt.invalidApplier();
    L71:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L74;
        r15.createNode(r29);
    L75:
        Composer r30 = Updater.constructor-impl(r15);
        Updater.set-impl(r30, r24, r18.getSetMeasurePolicy());
        Updater.set-impl(r30, r27, r18.getSetResolvedCompositionLocals());
        Function2 r31 = r18.getSetCompositeKeyHash();
        if (r30.getInserting() == false) goto L78;
    L79:
        r30.updateRememberedValue(Integer.valueOf(r26));
        r30.apply(Integer.valueOf(r26), r31);
    L80:
        Updater.set-impl(r30, r28, r18.getSetModifier());
        RowScopeInstance r210 = RowScopeInstance.INSTANCE;
        float r32 = 18;
        Modifier r211 = r11;
        IconKt.Icon-ww6aTOc(SearchKt.getSearch(Icons.INSTANCE.getDefault()), null, SizeKt.size-3ABfNKs(r22, Dp.constructor-impl(r32)), n.a(r15, 0).d.c, r15, 432, 0);
        float r110 = 8;
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(r22, Dp.constructor-impl(r110)), r15, 6);
        Modifier r33 = RowScope.-CC.weight$default(r210, r22, 1.0f, false, 2, null);
        MeasurePolicy r34 = BoxKt.maybeCachedBoxMeasurePolicy(r16.getTopStart(), false);
        long r35 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r36 = (int) (r35 ^ (r35 >>> 32));
        CompositionLocalMap r37 = r15.getCurrentCompositionLocalMap();
        Modifier r38 = ComposedModifierKt.materializeModifier(r15, r33);
        Function0 r39 = r18.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L83;
        ComposablesKt.invalidApplier();
    L83:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L86;
        r15.createNode(r39);
    L87:
        Composer r40 = Updater.constructor-impl(r15);
        Updater.set-impl(r40, r34, r18.getSetMeasurePolicy());
        Updater.set-impl(r40, r37, r18.getSetResolvedCompositionLocals());
        Function2 r41 = r18.getSetCompositeKeyHash();
        if (r40.getInserting() == false) goto L90;
    L91:
        r40.updateRememberedValue(Integer.valueOf(r36));
        r40.apply(Integer.valueOf(r36), r41);
    L92:
        Updater.set-impl(r40, r38, r18.getSetModifier());
        SolidColor r42 = new SolidColor(n.a(r15, 0).a.a, null);
        boolean r212 = true;
        int r43 = r14 & 112;
        BasicTextFieldKt.BasicTextField(r64, r65, SizeKt.fillMaxWidth$default(r22, 0.0f, 1, null), false, false, TextStyle.copy-p1EtxEg$default(n.b(r15).c, n.a(r15, 0).d.a, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null), null, null, true, 0, 0, null, null, null, r42, null, r15, ((r14 & 14) | 100663680) | r43, 0, 48856);
        r15.startReplaceGroup(-94365894);
        if (r64.length() != 0) goto L95;
        boolean r111 = true;
    L96:
        if (r111 == false) goto L98;
        Composer r610 = r15;
        TextKt.Text-Nvy7gAk(r66, null, n.a(r15, 0).d.c, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, n.b(r15).c, r610, (r14 >> 6) & 14, 0, 131066);
    L99:
        r610.endReplaceGroup();
        r610.endNode();
        Composer r1 = r610;
        r1.startReplaceGroup(-601750344);
        if (r64.length() <= 0) goto L102;
        boolean r112 = true;
    L103:
        if (r112 == false) goto L117;
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(r22, Dp.constructor-impl(r110)), r1, 6);
        ImageVector r44 = (ImageVector) ChatSettingIcons.q.getValue();
        long r45 = n.a(r1, 0).d.c;
        Modifier r46 = SizeKt.size-3ABfNKs(r22, Dp.constructor-impl(r32));
        r1.startReplaceGroup(5004770);
        if (r43 == 32) goto L108;
        r212 = false;
    L108:
        Object r0 = r1.rememberedValue();
        if (r212 == false) goto L111;
    L114:
        r0 = new ChatMemberListComponentsKt$ChatMembersSearchBar$1$1$2$1(r65);
        r1.updateRememberedValue(r0);
    L115:
        r1.endReplaceGroup();
        IconKt.Icon-ww6aTOc(r44, null, ClickableKt.clickable-oSLSa3U$default(r46, false, null, null, null, (Function0) r0, 15, null), r45, r1, 48, 0);
        goto L117
    L111:
        if (r0 != Composer.Companion.getEmpty()) goto L115;
    L117:
        r1.endReplaceGroup();
        r1.endNode();
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventEnd();
    L120:
        final Modifier r47 = r211;
    L121:
        ScopeUpdateScope r48 = r1.endRestartGroup();
        if (r48 == null) goto L125;
        r48.updateScope(new ChatMemberListComponentsKt$ChatMembersSearchBar$2(r64, r65, r66, r47, r69, r70));
        return;
    L125:
        return;
    L102:
        r112 = false;
        goto L103
    L98:
        r610 = r15;
        goto L99
    L95:
        r111 = false;
        goto L96
    L90:
        if (Intrinsics.areEqual(r40.rememberedValue(), Integer.valueOf(r36)) == true) goto L92;
    L86:
        r15.useNode();
        goto L87
    L78:
        if (Intrinsics.areEqual(r30.rememberedValue(), Integer.valueOf(r26)) == true) goto L80;
    L74:
        r15.useNode();
        goto L75
    L66:
        if (Intrinsics.areEqual(r19.rememberedValue(), Integer.valueOf(r13)) == true) goto L68;
    L62:
        r15.useNode();
        goto L63
    L52:
        r11 = r8;
        goto L54
    L47:
        if (r15.getSkipping() == false) goto L50;
        r15.skipToGroupEnd();
        r47 = r8;
        r1 = r15;
        goto L121
    L37:
        if ((r69 & 3072) != 0) goto L43;
        r8 = r67;
        if (r15.changed(r8) == false) goto L41;
        int r49 = 2048;
    L42:
        r4 = r4 | r49;
        goto L44
    L41:
        r49 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L42
    L27:
        if ((r69 & 384) != 0) goto L33;
        if (r15.changed(r66) == false) goto L31;
        int r50 = 256;
    L32:
        r4 = r4 | r50;
        goto L33
    L31:
        r50 = 128;
        goto L32
    L17:
        if ((r69 & 48) != 0) goto L24;
        if (r15.changedInstance(r65) == false) goto L21;
        int r51 = 32;
    L22:
        r4 = r4 | r51;
        goto L24
    L21:
        r51 = 16;
        goto L22
    L6:
        if ((r69 & 6) == 0) goto L8;
        r4 = r69;
        goto L14
    L8:
        if (r15.changed(r64) == false) goto L10;
        int r52 = 4;
    L11:
        r4 = r52 | r69;
        goto L14
    L10:
        r52 = 2;
        goto L11
    }

    public static final void b(final String r8, Modifier r9, final Function3<? super Dp, ? super Composer, ? super Integer, Unit> r10, final Function4<? super Dp, ? super Dp, ? super Composer, ? super Integer, Unit> r11, Composer r12, final int r13, final int r14) {
        Intrinsics.checkNotNullParameter(r8, "title");
        Composer r15 = r12.startRestartGroup(-588316296);
        if ((r14 & 1) == 0) goto L6;
        int r1 = r13 | 6;
    L13:
        int r2 = r14 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r3 = r14 & 4;
        if (r3 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r4 = r14 & 8;
        if (r4 == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        if ((r1 & 1171) == 1170) goto L46;
    L50:
        if (r2 == 0) goto L53;
        r9 = Modifier.Companion;
    L53:
        if (r3 == 0) goto L55;
        r10 = null;
    L55:
        if (r4 == 0) goto L58;
        r11 = null;
    L58:
        if (ComposerKt.isTraceInProgress() == false) goto L60;
        ComposerKt.traceEventStart(-588316296, r1, -1, "com.ss.android.lark.compose.chat_member_list.ChatMembersTopBar (ChatMemberListComponents.kt:379)");
    L60:
        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(r9, 0.0f, 1, null), Dp.constructor-impl(62)), Alignment.Companion.getCenter(), false, ComposableLambdaKt.rememberComposableLambda(-1642164126, true, new ChatMemberListComponentsKt$ChatMembersTopBar$1(r10, r8, r11), r15, 54), r15, 3120, 4);
        if (ComposerKt.isTraceInProgress() == true) goto L62;
    L49:
        final Modifier r5 = r9;
        final Function3<? super Dp, ? super Composer, ? super Integer, Unit> r6 = r10;
        final Function4<? super Dp, ? super Dp, ? super Composer, ? super Integer, Unit> r7 = r11;
        ScopeUpdateScope r16 = r15.endRestartGroup();
        if (r16 == null) goto L67;
        r16.updateScope(new ChatMemberListComponentsKt$ChatMembersTopBar$2(r8, r5, r6, r7, r13, r14));
        return;
    L67:
        return;
    L62:
        ComposerKt.traceEventEnd();
        goto L49
    L46:
        if (r15.getSkipping() == false) goto L50;
        r15.skipToGroupEnd();
        goto L49
    L37:
        if ((r13 & 3072) != 0) goto L44;
        if (r15.changedInstance(r11) == false) goto L41;
        int r17 = 2048;
    L42:
        r1 = r1 | r17;
        goto L44
    L41:
        r17 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L42
    L27:
        if ((r13 & 384) != 0) goto L33;
        if (r15.changedInstance(r10) == false) goto L31;
        int r18 = 256;
    L32:
        r1 = r1 | r18;
        goto L33
    L31:
        r18 = 128;
        goto L32
    L17:
        if ((r13 & 48) != 0) goto L23;
        if (r15.changed(r9) == false) goto L21;
        int r19 = 32;
    L22:
        r1 = r1 | r19;
        goto L23
    L21:
        r19 = 16;
        goto L22
    L6:
        if ((r13 & 6) == 0) goto L8;
        r1 = r13;
        goto L13
    L8:
        if (r15.changed(r8) == false) goto L10;
        int r20 = 4;
    L11:
        r1 = r20 | r13;
        goto L13
    L10:
        r20 = 2;
        goto L11
    }

    public static final void d(final com.lark.kmp.rustclient.api.d r17, final String r18, final String r19, Modifier r20, Composer r21, final int r22, final int r23) {
        Composer r1 = r21.startRestartGroup(-2096955979);
        if ((r23 & 2) == 0) goto L6;
        int r4 = r22 | 48;
    L14:
        if ((r23 & 4) == 0) goto L17;
        r4 = r4 | 384;
    L23:
        int r6 = r23 & 8;
        if (r6 == 0) goto L27;
        r4 = r4 | 3072;
    L33:
        Modifier r7 = r20;
    L35:
        if ((r4 & 1169) == 1168) goto L37;
    L40:
        if (r6 == 0) goto L42;
        Modifier r15 = Modifier.Companion;
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(-2096955979, r4, -1, "com.ss.android.lark.compose.chat_member_list.ChatterAvatar (ChatMemberListComponents.kt:283)");
    L46:
        r1.startReplaceGroup(-835028731);
        if (StringsKt.isBlank(r18) == false) goto L49;
    L58:
        final Modifier r5 = r15;
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(r5, RoundedCornerShapeKt.getCircleShape()), n.a(r1, 0).f.a, null, 2, null), r1, 0);
        r1.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventEnd();
    L61:
        ScopeUpdateScope r8 = r1.endRestartGroup();
        if (r8 == null) goto L66;
        r8.updateScope(new ChatMemberListComponentsKt$ChatterAvatar$1(r17, r18, r19, r5, r22, r23));
        return;
    L66:
        return;
    L49:
        if (StringsKt.isBlank(r19) == true) goto L58;
        r1.endReplaceGroup();
        final Modifier r9 = r15;
        AvatarImageComponentKt.a(new com.ss.android.lark.image.compose.common.avatar.a(r18, r19, Dp.constructor-impl(44), ImageFormat.PNG), ClipKt.clip(r15, RoundedCornerShapeKt.getCircleShape()), null, null, null, null, null, null, r1, 224640, 192);
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventEnd();
    L54:
        ScopeUpdateScope r10 = r1.endRestartGroup();
        if (r10 == null) goto L65;
        r10.updateScope(new ChatMemberListComponentsKt$ChatterAvatar$2(r17, r18, r19, r9, r22, r23));
        return;
    L65:
        return;
    L42:
        r15 = r7;
        goto L44
    L37:
        if (r1.getSkipping() == false) goto L40;
        r1.skipToGroupEnd();
        r9 = r7;
        goto L54
    L27:
        if ((r22 & 3072) != 0) goto L33;
        r7 = r20;
        if (r1.changed(r7) == false) goto L31;
        int r11 = 2048;
    L32:
        r4 = r4 | r11;
        goto L35
    L31:
        r11 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L32
    L17:
        if ((r22 & 384) != 0) goto L23;
        if (r1.changed(r19) == false) goto L21;
        int r12 = 256;
    L22:
        r4 = r4 | r12;
        goto L23
    L21:
        r12 = 128;
        goto L22
    L6:
        if ((r22 & 48) == 0) goto L8;
        r4 = r22;
        goto L14
    L8:
        if (r1.changed(r18) == false) goto L10;
        int r13 = 32;
    L11:
        r4 = r13 | r22;
        goto L14
    L10:
        r13 = 16;
        goto L11
    }

    public static final void f(final String r35, final com.ss.android.lark.compose.chatterselector.d r36, final a r37, Modifier r38, Composer r39, final int r40, final int r41) {
        Composer r1 = r39.startRestartGroup(-298548920);
        if ((r41 & 1) == 0) goto L6;
        int r6 = r40 | 6;
    L14:
        if ((r41 & 2) == 0) goto L17;
        r6 = r6 | 48;
    L24:
        if ((r41 & 4) == 0) goto L27;
        r6 = r6 | 384;
    L33:
        int r7 = r41 & 8;
        if (r7 == 0) goto L37;
        r6 = r6 | 3072;
    L43:
        Modifier r9 = r38;
    L45:
        if ((r6 & 1171) == 1170) goto L47;
    L50:
        if (r7 == 0) goto L52;
        Modifier r14 = Modifier.Companion;
    L54:
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventStart(-298548920, r6, -1, "com.ss.android.lark.compose.chat_member_list.ChatterNameWithTag (ChatMemberListComponents.kt:180)");
    L56:
        r1.startReplaceGroup(1849434622);
        Object r0 = r1.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L59;
        r0 = ChatMemberListComponentsKt$ChatterNameWithTag$1$1.a;
        r1.updateRememberedValue(r0);
    L59:
        MeasurePolicy r2 = (MeasurePolicy) r0;
        r1.endReplaceGroup();
        int r32 = r6 >> 6;
        long r10 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r8 = (int) ((r10 >>> 32) ^ r10);
        CompositionLocalMap r11 = r1.getCurrentCompositionLocalMap();
        Modifier r12 = ComposedModifierKt.materializeModifier(r1, r14);
        ComposeUiNode.Companion r13 = ComposeUiNode.Companion;
        Function0 r15 = r13.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L62;
        ComposablesKt.invalidApplier();
    L62:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L65;
        r1.createNode(r15);
    L66:
        Composer r16 = Updater.constructor-impl(r1);
        Updater.set-impl(r16, r2, r13.getSetMeasurePolicy());
        Updater.set-impl(r16, r11, r13.getSetResolvedCompositionLocals());
        Function2 r3 = r13.getSetCompositeKeyHash();
        if (r16.getInserting() == false) goto L69;
    L70:
        r16.updateRememberedValue(Integer.valueOf(r8));
        r16.apply(Integer.valueOf(r8), r3);
    L71:
        Updater.set-impl(r16, r12, r13.getSetModifier());
        TextStyle r4 = n.b(r1).b;
        long r17 = n.a(r1, 0).d.a;
        int r22 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
        Modifier.Companion r5 = Modifier.Companion;
        Modifier r33 = r14;
        int r34 = r6;
        TextKt.Text-Nvy7gAk(r35, LayoutIdKt.layoutId(r5, IPortraitService.NAME), r17, null, 0, null, null, null, 0, null, null, 0, r22, false, 1, 0, null, r4, r1, (r6 & 14) | 48, 24960, 110584);
        ChatMemberStatusTag_androidKt.a(r37, LayoutIdKt.layoutId(r5, "statusTag"), r1, (r32 & 14) | 48, 0);
        r1.startReplaceGroup(1717855099);
        if (r36 == null) goto L74;
        e(r36, LayoutIdKt.layoutId(r5, "tag"), r1, ((r34 >> 3) & 14) | 48, 0);
    L74:
        r1.endReplaceGroup();
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L77;
        ComposerKt.traceEventEnd();
    L77:
        r9 = r33;
    L78:
        ScopeUpdateScope r18 = r1.endRestartGroup();
        if (r18 == null) goto L82;
        final Modifier r19 = r9;
        r18.updateScope(new ChatMemberListComponentsKt$ChatterNameWithTag$3(r35, r36, r37, r19, r40, r41));
        return;
    L82:
        return;
    L69:
        if (Intrinsics.areEqual(r16.rememberedValue(), Integer.valueOf(r8)) == true) goto L71;
    L65:
        r1.useNode();
        goto L66
    L52:
        r14 = r9;
        goto L54
    L47:
        if (r1.getSkipping() == false) goto L50;
        r1.skipToGroupEnd();
        goto L78
    L37:
        if ((r40 & 3072) != 0) goto L43;
        r9 = r38;
        if (r1.changed(r9) == false) goto L41;
        int r110 = 2048;
    L42:
        r6 = r6 | r110;
        goto L45
    L41:
        r110 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L42
    L27:
        if ((r40 & 384) != 0) goto L33;
        if (r1.changed(r37) == false) goto L31;
        int r20 = 256;
    L32:
        r6 = r6 | r20;
        goto L33
    L31:
        r20 = 128;
        goto L32
    L17:
        if ((r40 & 48) != 0) goto L24;
        if (r1.changed(r36) == false) goto L21;
        int r21 = 32;
    L22:
        r6 = r6 | r21;
        goto L24
    L21:
        r21 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r6 = r40;
        goto L14
    L8:
        if (r1.changed(r35) == false) goto L10;
        int r23 = 4;
    L11:
        r6 = r23 | r40;
        goto L14
    L10:
        r23 = 2;
        goto L11
    }

    public static final void h(final com.ss.android.lark.compose.chatterselector.a r36, final com.lark.kmp.rustclient.api.d r37, Function0 r38, Function2 r39, Modifier r40, Composer r41, final int r42, final int r43) {
        Composer r2 = r41.startRestartGroup(-307540206);
        if ((r43 & 1) == 0) goto L6;
        int r3 = r42 | 6;
    L14:
        if ((r43 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r8 = r43 & 4;
        if (r8 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Function0 r9 = r38;
    L35:
        int r10 = r43 & 8;
        if (r10 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function2 r11 = r39;
    L46:
        int r12 = r43 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        Modifier r13 = r40;
    L58:
        if ((r3 & 9363) != 9362) goto L64;
        if (r2.getSkipping() == false) goto L64;
        r2.skipToGroupEnd();
        final Function0 r4 = r9;
        final Function2 r5 = r11;
        final Modifier r6 = r13;
    L109:
        ScopeUpdateScope r14 = r2.endRestartGroup();
        if (r14 == null) goto L113;
        r14.updateScope(new ChatMemberListComponentsKt$ChatterRow$2(r36, r37, r4, r5, r6, r42, r43));
        return;
    L113:
        return;
    L64:
        if (r8 == 0) goto L66;
        Function0 r33 = null;
    L67:
        if (r10 == 0) goto L69;
        r11 = ComposableSingletons$ChatMemberListComponentsKt.a;
    L69:
        if (r12 == 0) goto L72;
        r13 = Modifier.Companion;
    L72:
        if (ComposerKt.isTraceInProgress() == false) goto L74;
        ComposerKt.traceEventStart(-307540206, r3, -1, "com.ss.android.lark.compose.chat_member_list.ChatterRow (ChatMemberListComponents.kt:133)");
    L74:
        Intrinsics.checkNotNullParameter(com.ss.android.lark.flow.chat.resources.b.a, "<this>");
        String r0 = b0.a((z) CommonMainString0.q0.getValue(), r2);
        Modifier r15 = SizeKt.fillMaxWidth$default(r13, 0.0f, 1, null);
        Modifier r16 = Modifier.Companion;
        if (r33 == null) goto L77;
        Modifier r17 = ClickableKt.clickable-oSLSa3U$default(r16, false, null, null, null, r33, 15, null);
    L78:
        Modifier r7 = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(r15.then(r17), Dp.constructor-impl(64)), Dp.constructor-impl(16), 0.0f, 2, null);
        Alignment.Companion r21 = Alignment.Companion;
        Alignment.Vertical r18 = r21.getCenterVertically();
        Arrangement r22 = Arrangement.INSTANCE;
        MeasurePolicy r19 = RowKt.rowMeasurePolicy(r22.getStart(), r18, r2, 48);
        long r110 = ComposablesKt.getCurrentCompositeKeyHashCode(r2, 0);
        Modifier r20 = r13;
        int r111 = (int) (r110 ^ (r110 >>> 32));
        CompositionLocalMap r112 = r2.getCurrentCompositionLocalMap();
        Modifier r23 = ComposedModifierKt.materializeModifier(r2, r7);
        ComposeUiNode.Companion r24 = ComposeUiNode.Companion;
        Function0 r113 = r24.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L81;
        ComposablesKt.invalidApplier();
    L81:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L84;
        r2.createNode(r113);
    L85:
        Composer r114 = Updater.constructor-impl(r2);
        Updater.set-impl(r114, r19, r24.getSetMeasurePolicy());
        Updater.set-impl(r114, r112, r24.getSetResolvedCompositionLocals());
        Function2 r25 = r24.getSetCompositeKeyHash();
        if (r114.getInserting() == false) goto L88;
    L89:
        r114.updateRememberedValue(Integer.valueOf(r111));
        r114.apply(Integer.valueOf(r111), r25);
    L90:
        Updater.set-impl(r114, r23, r24.getSetModifier());
        RowScopeInstance r115 = RowScopeInstance.INSTANCE;
        Function2 r34 = r11;
        d(r37, r36.d, r36.a, SizeKt.size-3ABfNKs(r16, Dp.constructor-impl(44)), r2, ((r3 >> 3) & 14) | 3072, 0);
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(r16, Dp.constructor-impl(12)), r2, 6);
        Modifier r26 = RowScope.-CC.weight$default(r115, r16, 1.0f, false, 2, null);
        MeasurePolicy r27 = ColumnKt.columnMeasurePolicy(r22.getTop(), r21.getStart(), r2, 0);
        long r28 = ComposablesKt.getCurrentCompositeKeyHashCode(r2, 0);
        int r116 = (int) (r28 ^ (r28 >>> 32));
        CompositionLocalMap r29 = r2.getCurrentCompositionLocalMap();
        Modifier r30 = ComposedModifierKt.materializeModifier(r2, r26);
        Function0 r117 = r24.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L93;
        ComposablesKt.invalidApplier();
    L93:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L96;
        r2.createNode(r117);
    L97:
        Composer r118 = Updater.constructor-impl(r2);
        Updater.set-impl(r118, r27, r24.getSetMeasurePolicy());
        Updater.set-impl(r118, r29, r24.getSetResolvedCompositionLocals());
        Function2 r31 = r24.getSetCompositeKeyHash();
        if (r118.getInserting() == false) goto L100;
    L101:
        r118.updateRememberedValue(Integer.valueOf(r116));
        r118.apply(Integer.valueOf(r116), r31);
    L102:
        Updater.set-impl(r118, r30, r24.getSetModifier());
        ColumnScopeInstance r32 = ColumnScopeInstance.INSTANCE;
        f(r36.b, (com.ss.android.lark.compose.chatterselector.d) CollectionsKt.firstOrNull(r36.e), r36.f, SizeKt.fillMaxWidth$default(r16, 0.0f, 1, null), r2, 3072, 0);
        r2.startReplaceGroup(261859658);
        if ((true ^ StringsKt.isBlank(r36.c)) == false) goto L105;
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(r16, Dp.constructor-impl(2)), r2, 6);
        TextKt.Text-Nvy7gAk(StringsKt.replace$default(r0, "{nickname}", r36.c, false, 4, null), null, n.a(r2, 0).d.b, null, 0, null, null, null, 0, null, null, 0, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, null, n.b(r2).c, r2, 0, 24960, 110586);
    L105:
        r2.endReplaceGroup();
        r2.endNode();
        r34.invoke(r2, Integer.valueOf((r3 >> 9) & 14));
        r2.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L108;
        ComposerKt.traceEventEnd();
    L108:
        r5 = r34;
        r4 = r33;
        r6 = r20;
        goto L109
    L100:
        if (Intrinsics.areEqual(r118.rememberedValue(), Integer.valueOf(r116)) == true) goto L102;
    L96:
        r2.useNode();
        goto L97
    L88:
        if (Intrinsics.areEqual(r114.rememberedValue(), Integer.valueOf(r111)) == true) goto L90;
    L84:
        r2.useNode();
        goto L85
    L77:
        r17 = r16;
        goto L78
    L66:
        r33 = r9;
        goto L67
    L50:
        if ((r42 & 24576) != 0) goto L56;
        r13 = r40;
        if (r2.changed(r13) == false) goto L54;
        int r119 = 16384;
    L55:
        r3 = r3 | r119;
        goto L58
    L54:
        r119 = 8192;
        goto L55
    L39:
        if ((r42 & 3072) != 0) goto L45;
        r11 = r39;
        if (r2.changedInstance(r11) == false) goto L43;
        int r120 = 2048;
    L44:
        r3 = r3 | r120;
        goto L46
    L43:
        r120 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L44
    L28:
        if ((r42 & 384) != 0) goto L34;
        r9 = r38;
        if (r2.changedInstance(r9) == false) goto L32;
        int r121 = 256;
    L33:
        r3 = r3 | r121;
        goto L35
    L32:
        r121 = 128;
        goto L33
    L17:
        if ((r42 & 48) != 0) goto L24;
        if (r2.changedInstance(r37) == false) goto L21;
        int r35 = 32;
    L22:
        r3 = r3 | r35;
        goto L24
    L21:
        r35 = 16;
        goto L22
    L6:
        if ((r42 & 6) == 0) goto L8;
        r3 = r42;
        goto L14
    L8:
        if (r2.changedInstance(r36) == false) goto L10;
        int r44 = 4;
    L11:
        r3 = r44 | r42;
        goto L14
    L10:
        r44 = 2;
        goto L11
    }

    public static final void g(final List<com.ss.android.lark.compose.chatterselector.a> r27, final com.lark.kmp.rustclient.api.d r28, final Modifier r29, final boolean r30, final boolean r31, final Function0<Unit> r32, final Function1<? super com.ss.android.lark.compose.chatterselector.a, Unit> r33, final Function3<? super com.ss.android.lark.compose.chatterselector.a, ? super Composer, ? super Integer, Unit> r34, Composer r35, final int r36) {
        Intrinsics.checkNotNullParameter(r27, "chatters");
        Intrinsics.checkNotNullParameter(r28, "rustClient");
        Intrinsics.checkNotNullParameter(r29, "modifier");
        Intrinsics.checkNotNullParameter(r32, "onLoadMore");
        Intrinsics.checkNotNullParameter(r34, "trailing");
        Composer r15 = r35.startRestartGroup(-1235722675);
        if ((r36 & 6) == 0) goto L5;
        int r4 = r36;
    L11:
        if ((r36 & 48) != 0) goto L18;
        if (r15.changedInstance(r28) == false) goto L15;
        int r5 = 32;
    L16:
        r4 = r4 | r5;
        goto L18
    L15:
        r5 = 16;
    L18:
        if ((r36 & 384) != 0) goto L25;
        if (r15.changed(r29) == false) goto L22;
        int r6 = 256;
    L23:
        r4 = r4 | r6;
        goto L25
    L22:
        r6 = 128;
    L25:
        if ((r36 & 3072) != 0) goto L32;
        if (r15.changed(r30) == false) goto L29;
        int r7 = 2048;
    L30:
        r4 = r4 | r7;
        goto L32
    L29:
        r7 = ChameleonContainerUtils.MAX_URL_LENGTH;
    L32:
        if ((r36 & 24576) != 0) goto L40;
        if (r15.changed(r31) == false) goto L36;
        int r16 = 16384;
    L37:
        r4 = r4 | r16;
        goto L40
    L36:
        r16 = 8192;
    L40:
        if ((r36 & 196608) != 0) goto L47;
        if (r15.changedInstance(r32) == false) goto L44;
        int r17 = 131072;
    L45:
        r4 = r4 | r17;
        goto L47
    L44:
        r17 = 65536;
    L47:
        if ((r36 & 1572864) != 0) goto L54;
        if (r15.changedInstance(r33) == false) goto L51;
        int r18 = 1048576;
    L52:
        r4 = r4 | r18;
        goto L54
    L51:
        r18 = 524288;
    L54:
        if ((r36 & 12582912) != 0) goto L61;
        if (r15.changedInstance(r34) == false) goto L58;
        int r19 = 8388608;
    L59:
        r4 = r4 | r19;
        goto L61
    L58:
        r19 = 4194304;
    L61:
        if ((r4 & 4793491) != 4793490) goto L67;
        if (r15.getSkipping() == false) goto L67;
        r15.skipToGroupEnd();
        Composer r0 = r15;
    L121:
        ScopeUpdateScope r10 = r0.endRestartGroup();
        if (r10 == null) goto L125;
        r10.updateScope(new ChatMemberListComponentsKt$ChatterPagingList$4(r27, r28, r29, r30, r31, r32, r33, r34, r36));
        return;
    L125:
        return;
    L67:
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventStart(-1235722675, r4, -1, "com.ss.android.lark.compose.chat_member_list.ChatterPagingList (ChatMemberListComponents.kt:72)");
    L69:
        LazyListState r14 = LazyListStateKt.rememberLazyListState(0, 0, r15, 0, 3);
        FocusManager r9 = (FocusManager) r15.consume(CompositionLocalsKt.getLocalFocusManager());
        r15.startReplaceGroup(-1633490746);
        boolean r8 = r15.changed(r14) | r15.changedInstance(r9);
        Object r11 = r15.rememberedValue();
        if (r8 == false) goto L72;
    L73:
        r11 = new ChatMemberListComponentsKt$ChatterPagingList$1$1(r14, r9, null);
        r15.updateRememberedValue(r11);
    L74:
        r15.endReplaceGroup();
        EffectsKt.LaunchedEffect(r14, (Function2) r11, r15, 0);
        Boolean r23 = Boolean.valueOf(r31);
        Boolean r24 = Boolean.valueOf(r30);
        r15.startReplaceGroup(-1224400529);
        boolean r12 = r15.changed(r14);
        if ((57344 & r4) != 16384) goto L77;
        boolean r13 = true;
    L78:
        boolean r20 = r12 | r13;
        if ((r4 & 7168) != 2048) goto L81;
        boolean r21 = true;
    L82:
        boolean r22 = r20 | r21;
        if ((458752 & r4) != 131072) goto L85;
        boolean r25 = true;
    L86:
        boolean r26 = r22 | r25;
        Object r37 = r15.rememberedValue();
        if (r26 == false) goto L89;
    L92:
        ChatMemberListComponentsKt$ChatterPagingList$2$1 r38 = new ChatMemberListComponentsKt$ChatterPagingList$2$1(r14, r31, r30, r32, null);
        r15.updateRememberedValue(r38);
        r37 = r38;
    L93:
        r15.endReplaceGroup();
        EffectsKt.LaunchedEffect(r14, r23, r24, (Function2) r37, r15, ((r4 >> 9) & 112) | ((r4 >> 3) & 896));
        Modifier r39 = SizeKt.fillMaxWidth$default(r29, 0.0f, 1, null);
        MeasurePolicy r40 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r15, 0);
        long r41 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r42 = (int) (r41 ^ (r41 >>> 32));
        CompositionLocalMap r43 = r15.getCurrentCompositionLocalMap();
        Modifier r44 = ComposedModifierKt.materializeModifier(r15, r39);
        ComposeUiNode.Companion r45 = ComposeUiNode.Companion;
        Function0 r46 = r45.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L96;
        ComposablesKt.invalidApplier();
    L96:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L99;
        r15.createNode(r46);
    L100:
        Composer r47 = Updater.constructor-impl(r15);
        Updater.set-impl(r47, r40, r45.getSetMeasurePolicy());
        Updater.set-impl(r47, r43, r45.getSetResolvedCompositionLocals());
        Function2 r48 = r45.getSetCompositeKeyHash();
        if (r47.getInserting() == false) goto L103;
    L104:
        r47.updateRememberedValue(Integer.valueOf(r42));
        r47.apply(Integer.valueOf(r42), r48);
    L105:
        Updater.set-impl(r47, r44, r45.getSetModifier());
        ColumnScopeInstance r49 = ColumnScopeInstance.INSTANCE;
        Modifier r1 = ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)));
        r15.startReplaceGroup(-1224400529);
        boolean r50 = r15.changedInstance(r27) | r15.changedInstance(r28);
        if ((r4 & 3670016) != 1048576) goto L108;
        boolean r51 = true;
    L109:
        boolean r52 = r51 | r50;
        if ((r4 & 29360128) != 8388608) goto L112;
        boolean r210 = true;
    L113:
        boolean r53 = r52 | r210;
        Object r54 = r15.rememberedValue();
        if (r53 == false) goto L116;
    L117:
        r54 = new ChatMemberListComponentsKt$ChatterPagingList$3$1$1(r27, r28, r33, r34);
        r15.updateRememberedValue(r54);
    L118:
        r15.endReplaceGroup();
        r0 = r15;
        LazyDslKt.LazyColumn(r1, r14, null, false, null, null, null, false, null, (Function1) r54, r0, 0, 508);
        r0.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L121;
        ComposerKt.traceEventEnd();
        goto L121
    L116:
        if (r54 != Composer.Companion.getEmpty()) goto L118;
    L112:
        r210 = false;
        goto L113
    L108:
        r51 = false;
        goto L109
    L103:
        if (Intrinsics.areEqual(r47.rememberedValue(), Integer.valueOf(r42)) == true) goto L105;
    L99:
        r15.useNode();
        goto L100
    L89:
        if (r37 != Composer.Companion.getEmpty()) goto L93;
    L85:
        r25 = false;
        goto L86
    L81:
        r21 = false;
        goto L82
    L77:
        r13 = false;
        goto L78
    L72:
        if (r11 != Composer.Companion.getEmpty()) goto L74;
    L5:
        if (r15.changedInstance(r27) == false) goto L7;
        int r55 = 4;
    L8:
        r4 = r55 | r36;
        goto L11
    L7:
        r55 = 2;
        goto L8
    }
}
