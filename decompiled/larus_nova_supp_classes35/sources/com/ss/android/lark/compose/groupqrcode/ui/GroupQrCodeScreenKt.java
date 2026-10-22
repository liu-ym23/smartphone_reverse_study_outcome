package com.ss.android.lark.compose.groupqrcode.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.RefreshKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.chat_member_list.ChatMemberListComponentsKt;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.compose.groupqrcode.viewmodel.GroupQrCodeViewModel;
import com.ss.android.lark.compose.groupqrcode.viewmodel.LoadState;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import com.ss.android.lark.flow.chat.resources.b;
import com.ss.android.lark.image.compose.common.ImageFormat;
import com.ss.android.lark.image.compose.common.avatar.AvatarImageComponentKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class GroupQrCodeScreenKt {
    public static final com.ss.android.lark.compose.groupqrcode.viewmodel.a d(State r0) {
        return (com.ss.android.lark.compose.groupqrcode.viewmodel.a) r0.getValue();
    }

    public static final void b(final String r18, final String r19, final int r20, final Function0 r21, Composer r22, final int r23) {
        Composer r4 = r22.startRestartGroup(720358737);
        if ((r23 & 6) == 0) goto L5;
        int r6 = r23;
    L11:
        if ((r23 & 48) != 0) goto L18;
        if (r4.changed(r19) == false) goto L15;
        int r7 = 32;
    L16:
        r6 = r6 | r7;
        goto L18
    L15:
        r7 = 16;
    L18:
        if ((r23 & 384) != 0) goto L25;
        if (r4.changed(r20) == false) goto L22;
        int r8 = 256;
    L23:
        r6 = r6 | r8;
        goto L25
    L22:
        r8 = 128;
    L25:
        if ((r23 & 3072) != 0) goto L32;
        if (r4.changedInstance(r21) == false) goto L29;
        int r9 = 2048;
    L30:
        r6 = r6 | r9;
        goto L32
    L29:
        r9 = ChameleonContainerUtils.MAX_URL_LENGTH;
    L32:
        if ((r6 & 1171) != 1170) goto L38;
        if (r4.getSkipping() == false) goto L38;
        r4.skipToGroupEnd();
    L43:
        ScopeUpdateScope r10 = r4.endRestartGroup();
        if (r10 == null) goto L47;
        r10.updateScope(new GroupQrCodeScreenKt$GroupAvatar$1(r18, r19, r20, r21, r23));
        return;
    L47:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(720358737, r6, -1, "com.ss.android.lark.compose.groupqrcode.ui.GroupAvatar (GroupQrCodeScreen.kt:318)");
    L40:
        float r11 = r20;
        AvatarImageComponentKt.a(new com.ss.android.lark.image.compose.common.avatar.a(r19, r18, Dp.constructor-impl(r11), ImageFormat.WEBP), ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(r11)), RoundedCornerShapeKt.getCircleShape()), null, r21, null, null, null, null, r4, (r6 & 7168) | 221568, 192);
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventEnd();
        goto L43
    L5:
        if (r4.changed(r18) == false) goto L7;
        int r12 = 4;
    L8:
        r6 = r12 | r23;
        goto L11
    L7:
        r12 = 2;
        goto L8
    }

    public static final void a(final GroupQrCodeViewModel r48, final a r49, final PaddingValues r50, final Function0<Unit> r51, Function6<? super String, ? super String, ? super Integer, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> r52, Composer r53, final int r54, final int r55) {
        Intrinsics.checkNotNullParameter(r48, "viewModel");
        Intrinsics.checkNotNullParameter(r49, "platformHost");
        Intrinsics.checkNotNullParameter(r50, "contentPadding");
        Intrinsics.checkNotNullParameter(r51, "onBack");
        Composer r10 = r53.startRestartGroup(938850650);
        if ((r55 & 1) == 0) goto L6;
        int r2 = r54 | 6;
    L14:
        if ((r55 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L27:
        if ((r55 & 4) == 0) goto L30;
        r2 = r2 | 384;
    L37:
        if ((r55 & 8) == 0) goto L40;
        r2 = r2 | 3072;
    L46:
        int r3 = r55 & 16;
        if (r3 == 0) goto L50;
        r2 = r2 | 24576;
    L56:
        Function6<? super String, ? super String, ? super Integer, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> r4 = r52;
    L57:
        int r7 = r2;
        if ((r7 & 9363) == 9362) goto L60;
    L63:
        if (r3 == 0) goto L65;
        Function6<? super String, ? super String, ? super Integer, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> r26 = ComposableSingletons$GroupQrCodeScreenKt.a;
    L67:
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventStart(938850650, r7, -1, "com.ss.android.lark.compose.groupqrcode.ui.GroupQrCodeScreen (GroupQrCodeScreen.kt:80)");
    L69:
        final State r0 = SnapshotStateKt.collectAsState(r48.getUiState(), null, r10, 0, 1);
        r10.startReplaceGroup(1849434622);
        Object r5 = r10.rememberedValue();
        Composer.Companion r16 = Composer.Companion;
        if (r5 != r16.getEmpty()) goto L72;
        r5 = SnapshotIntStateKt.mutableIntStateOf(0);
        r10.updateRememberedValue(r5);
    L72:
        final MutableIntState r6 = (MutableIntState) r5;
        r10.endReplaceGroup();
        String r8 = ((com.ss.android.lark.compose.groupqrcode.viewmodel.a) r0.getValue()).b;
        int r9 = r6.getIntValue();
        r10.startReplaceGroup(-1633490746);
        boolean r11 = r10.changed(r8) | r10.changed(r9);
        Object r12 = r10.rememberedValue();
        if (r11 == false) goto L75;
    L76:
        r12 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r10.updateRememberedValue(r12);
    L77:
        final MutableState r18 = (MutableState) r12;
        r10.endReplaceGroup();
        String r13 = ((com.ss.android.lark.compose.groupqrcode.viewmodel.a) r0.getValue()).b;
        int r14 = r6.getIntValue();
        r10.startReplaceGroup(-1633490746);
        boolean r15 = r10.changed(r13) | r10.changed(r14);
        Object r17 = r10.rememberedValue();
        if (r15 == false) goto L80;
    L81:
        r17 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r10.updateRememberedValue(r17);
    L82:
        final MutableState r19 = (MutableState) r17;
        r10.endReplaceGroup();
        String r20 = ((com.ss.android.lark.compose.groupqrcode.viewmodel.a) r0.getValue()).b;
        int r21 = r6.getIntValue();
        r10.startReplaceGroup(-1633490746);
        boolean r22 = r10.changed(r20) | r10.changed(r21);
        Object r23 = r10.rememberedValue();
        if (r22 == false) goto L85;
    L86:
        r23 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r10.updateRememberedValue(r23);
    L87:
        final MutableState r24 = (MutableState) r23;
        r10.endReplaceGroup();
        String r25 = ((com.ss.android.lark.compose.groupqrcode.viewmodel.a) r0.getValue()).b;
        int r27 = r6.getIntValue();
        r10.startReplaceGroup(-1633490746);
        boolean r28 = r10.changed(r25) | r10.changed(r27);
        Object r29 = r10.rememberedValue();
        if (r28 == false) goto L90;
    L91:
        r29 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r10.updateRememberedValue(r29);
    L92:
        final MutableState r210 = (MutableState) r29;
        r10.endReplaceGroup();
        Modifier r30 = Modifier.Companion;
        Modifier r31 = PaddingKt.padding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(r30, 0.0f, 1, null), n.a(r10, 0).c.b, null, 2, null), r50);
        Arrangement r32 = Arrangement.INSTANCE;
        Arrangement.Vertical r33 = r32.getTop();
        Alignment.Companion r211 = Alignment.Companion;
        MeasurePolicy r34 = ColumnKt.columnMeasurePolicy(r33, r211.getStart(), r10, 0);
        long r212 = ComposablesKt.getCurrentCompositeKeyHashCode(r10, 0);
        int r35 = (int) (r212 ^ (r212 >>> 32));
        CompositionLocalMap r36 = r10.getCurrentCompositionLocalMap();
        Modifier r37 = ComposedModifierKt.materializeModifier(r10, r31);
        ComposeUiNode.Companion r110 = ComposeUiNode.Companion;
        Function0 r111 = r110.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L95;
        ComposablesKt.invalidApplier();
    L95:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L98;
        r10.createNode(r111);
    L99:
        Composer r112 = Updater.constructor-impl(r10);
        Updater.set-impl(r112, r34, r110.getSetMeasurePolicy());
        Updater.set-impl(r112, r36, r110.getSetResolvedCompositionLocals());
        Function2 r38 = r110.getSetCompositeKeyHash();
        if (r112.getInserting() == false) goto L102;
    L103:
        r112.updateRememberedValue(Integer.valueOf(r35));
        r112.apply(Integer.valueOf(r35), r38);
    L104:
        Updater.set-impl(r112, r37, r110.getSetModifier());
        ColumnScopeInstance r113 = ColumnScopeInstance.INSTANCE;
        Modifier r39 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(r30, 0.0f, 1, null), Dp.constructor-impl(62));
        MeasurePolicy r114 = BoxKt.maybeCachedBoxMeasurePolicy(r211.getTopStart(), false);
        long r213 = ComposablesKt.getCurrentCompositeKeyHashCode(r10, 0);
        int r40 = (int) (r213 ^ (r213 >>> 32));
        CompositionLocalMap r41 = r10.getCurrentCompositionLocalMap();
        Modifier r42 = ComposedModifierKt.materializeModifier(r10, r39);
        Function0 r43 = r110.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L107;
        ComposablesKt.invalidApplier();
    L107:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L110;
        r10.createNode(r43);
    L111:
        Composer r44 = Updater.constructor-impl(r10);
        Updater.set-impl(r44, r114, r110.getSetMeasurePolicy());
        Updater.set-impl(r44, r41, r110.getSetResolvedCompositionLocals());
        Function2 r45 = r110.getSetCompositeKeyHash();
        if (r44.getInserting() == false) goto L114;
    L115:
        r44.updateRememberedValue(Integer.valueOf(r40));
        r44.apply(Integer.valueOf(r40), r45);
    L116:
        Updater.set-impl(r44, r42, r110.getSetModifier());
        BoxScopeInstance r115 = BoxScopeInstance.INSTANCE;
        ChatMemberListComponentsKt.c(Dp.constructor-impl(24), r51, PaddingKt.padding-qDBjuR0$default(r115.align(r30, r211.getCenterStart()), Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, null), r10, ((r7 >> 6) & 112) | 6, 0);
        r10.endNode();
        Modifier r46 = PaddingKt.padding-VpY3zN4$default(ColumnScope.-CC.weight$default(r113, SizeKt.fillMaxWidth$default(r30, 0.0f, 1, null), 1.0f, false, 2, null), Dp.constructor-impl(16), 0.0f, 2, null);
        MeasurePolicy r47 = BoxKt.maybeCachedBoxMeasurePolicy(r211.getTopCenter(), false);
        long r214 = ComposablesKt.getCurrentCompositeKeyHashCode(r10, 0);
        int r56 = (int) (r214 ^ (r214 >>> 32));
        CompositionLocalMap r57 = r10.getCurrentCompositionLocalMap();
        Modifier r58 = ComposedModifierKt.materializeModifier(r10, r46);
        Function0 r1 = r110.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L119;
        ComposablesKt.invalidApplier();
    L119:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L122;
        r10.createNode(r1);
    L123:
        Composer r59 = Updater.constructor-impl(r10);
        Updater.set-impl(r59, r47, r110.getSetMeasurePolicy());
        Updater.set-impl(r59, r57, r110.getSetResolvedCompositionLocals());
        Function2 r60 = r110.getSetCompositeKeyHash();
        if (r59.getInserting() == false) goto L126;
    L127:
        r59.updateRememberedValue(Integer.valueOf(r56));
        r59.apply(Integer.valueOf(r56), r60);
    L128:
        Updater.set-impl(r59, r58, r110.getSetModifier());
        if (((com.ss.android.lark.compose.groupqrcode.viewmodel.a) r0.getValue()).a != LoadState.LOADING) goto L132;
        r10.startReplaceGroup(-1410133493);
        ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(TestTagKt.testTag(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(r30, 0.0f, Dp.constructor-impl(200), 0.0f, 0.0f, 13, null), Dp.constructor-impl(40)), "group_qr_code_loading"), n.a(r10, 0).d.c, 0.0f, 0, 0, 0.0f, r10, 6, 60);
        r10.endReplaceGroup();
        Composer r61 = r10;
    L205:
        r61.endNode();
        r61.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L208;
        ComposerKt.traceEventEnd();
    L208:
        final Function6<? super String, ? super String, ? super Integer, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> r62 = r26;
    L209:
        ScopeUpdateScope r63 = r61.endRestartGroup();
        if (r63 == null) goto L213;
        r63.updateScope(new GroupQrCodeScreenKt$GroupQrCodeScreen$2(r48, r49, r50, r51, r62, r54, r55));
        return;
    L213:
        return;
    L132:
        if (((com.ss.android.lark.compose.groupqrcode.viewmodel.a) r0.getValue()).a != LoadState.ERROR) goto L134;
    L196:
        r61 = r10;
        r61.startReplaceGroup(-1409676739);
        r61.startReplaceGroup(1849434622);
        Object r64 = r61.rememberedValue();
        if (r64 != r16.getEmpty()) goto L199;
        r64 = InteractionSourceKt.MutableInteractionSource();
        r61.updateRememberedValue(r64);
    L199:
        MutableInteractionSource r65 = (MutableInteractionSource) r64;
        r61.endReplaceGroup();
        ImageVector r66 = RefreshKt.getRefresh(Icons.INSTANCE.getDefault());
        long r67 = n.a(r61, 0).d.c;
        Modifier r215 = TestTagKt.testTag(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(r30, 0.0f, Dp.constructor-impl(200), 0.0f, 0.0f, 13, null), Dp.constructor-impl(40)), "group_qr_code_retry");
        r61.startReplaceGroup(-1633490746);
        boolean r68 = r61.changedInstance(r48);
        Object r69 = r61.rememberedValue();
        if (r68 == false) goto L202;
    L203:
        r69 = new GroupQrCodeScreenKt$GroupQrCodeScreen$1$2$1$1(r48, r6);
        r61.updateRememberedValue(r69);
    L204:
        r61.endReplaceGroup();
        IconKt.Icon-ww6aTOc(r66, null, ClickableKt.clickable-O2vRcR0$default(r215, r65, null, false, null, null, (Function0) r69, 28, null), r67, r61, 48, 0);
        r61.endReplaceGroup();
        goto L205
    L202:
        if (r69 != r16.getEmpty()) goto L204;
    L134:
        if (((Throwable) r210.getValue()) != null) goto L196;
        if (((com.ss.android.lark.compose.groupqrcode.viewmodel.a) r0.getValue()).a != LoadState.SUCCESS) goto L194;
        r10.startReplaceGroup(-1408690133);
        Modifier r70 = SizeKt.fillMaxSize$default(r30, 0.0f, 1, null);
        MeasurePolicy r71 = BoxKt.maybeCachedBoxMeasurePolicy(r211.getTopStart(), false);
        long r216 = ComposablesKt.getCurrentCompositeKeyHashCode(r10, 0);
        int r72 = (int) (r216 ^ (r216 >>> 32));
        CompositionLocalMap r73 = r10.getCurrentCompositionLocalMap();
        Modifier r74 = ComposedModifierKt.materializeModifier(r10, r70);
        Function0 r75 = r110.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L141;
        ComposablesKt.invalidApplier();
    L141:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L144;
        r10.createNode(r75);
    L145:
        Composer r76 = Updater.constructor-impl(r10);
        Updater.set-impl(r76, r71, r110.getSetMeasurePolicy());
        Updater.set-impl(r76, r73, r110.getSetResolvedCompositionLocals());
        Function2 r77 = r110.getSetCompositeKeyHash();
        if (r76.getInserting() == false) goto L148;
    L149:
        r76.updateRememberedValue(Integer.valueOf(r72));
        r76.apply(Integer.valueOf(r72), r77);
    L150:
        Updater.set-impl(r76, r74, r110.getSetModifier());
        Modifier r78 = SizeKt.fillMaxSize$default(r30, 0.0f, 1, null);
        MeasurePolicy r79 = ColumnKt.columnMeasurePolicy(r32.getTop(), r211.getCenterHorizontally(), r10, 48);
        long r80 = ComposablesKt.getCurrentCompositeKeyHashCode(r10, 0);
        int r81 = (int) (r80 ^ (r80 >>> 32));
        CompositionLocalMap r82 = r10.getCurrentCompositionLocalMap();
        Modifier r83 = ComposedModifierKt.materializeModifier(r10, r78);
        Function0 r84 = r110.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L153;
        ComposablesKt.invalidApplier();
    L153:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L156;
        r10.createNode(r84);
    L157:
        Composer r85 = Updater.constructor-impl(r10);
        Updater.set-impl(r85, r79, r110.getSetMeasurePolicy());
        Updater.set-impl(r85, r82, r110.getSetResolvedCompositionLocals());
        Function2 r86 = r110.getSetCompositeKeyHash();
        if (r85.getInserting() == false) goto L160;
    L161:
        r85.updateRememberedValue(Integer.valueOf(r81));
        r85.apply(Integer.valueOf(r81), r86);
    L162:
        Updater.set-impl(r85, r83, r110.getSetModifier());
        Modifier r87 = PaddingKt.padding-qDBjuR0$default(ScrollKt.verticalScroll$default(ColumnScope.-CC.weight$default(r113, r30, 1.0f, false, 2, null), ScrollKt.rememberScrollState(0, r10, 0, 1), false, null, false, 14, null), 0.0f, Dp.constructor-impl(25), 0.0f, 0.0f, 13, null);
        MeasurePolicy r88 = ColumnKt.columnMeasurePolicy(r32.getTop(), r211.getCenterHorizontally(), r10, 48);
        long r89 = ComposablesKt.getCurrentCompositeKeyHashCode(r10, 0);
        int r90 = (int) (r89 ^ (r89 >>> 32));
        CompositionLocalMap r91 = r10.getCurrentCompositionLocalMap();
        Modifier r92 = ComposedModifierKt.materializeModifier(r10, r87);
        Function0 r93 = r110.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L165;
        ComposablesKt.invalidApplier();
    L165:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L168;
        r10.createNode(r93);
    L169:
        Composer r94 = Updater.constructor-impl(r10);
        Updater.set-impl(r94, r88, r110.getSetMeasurePolicy());
        Updater.set-impl(r94, r91, r110.getSetResolvedCompositionLocals());
        Function2 r95 = r110.getSetCompositeKeyHash();
        if (r94.getInserting() == false) goto L172;
    L173:
        r94.updateRememberedValue(Integer.valueOf(r90));
        r94.apply(Integer.valueOf(r90), r95);
    L174:
        Updater.set-impl(r94, r92, r110.getSetModifier());
        if (((Boolean) r18.getValue()).booleanValue() == true) goto L177;
    L181:
        Object r96 = null;
        int r97 = 1;
        float r98 = 0.0f;
        boolean r310 = false;
    L182:
        Modifier r99 = SizeKt.widthIn-VpY3zN4$default(SizeKt.fillMaxWidth$default(r30, r98, r97, r96), r98, Dp.constructor-impl(358), r97, r96);
        if (((Boolean) r18.getValue()).booleanValue() == false) goto L185;
        float r100 = 1.0f;
    L186:
        final Function6<? super String, ? super String, ? super Integer, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> r101 = r26;
        r61 = r10;
        r49.k(r310, TestTagKt.testTag(AlphaKt.alpha(r99, r100), "group_qr_code_card"), ComposableLambdaKt.rememberComposableLambda(1192978621, true, new GroupQrCodeScreenKt$GroupQrCodeScreen$1$2$2$1$1$1(r49, r19, r24, r18, r210, r101, r0, r6), r61, 54), r61, ((r7 << 6) & 7168) | 384);
        r61.endNode();
        r61.startReplaceGroup(-2083224136);
        if (((Boolean) r18.getValue()).booleanValue() == false) goto L189;
        Modifier r102 = r30;
        r49.l(TestTagKt.testTag(SizeKt.fillMaxWidth$default(r102, 0.0f, 1, null), "group_qr_code_share_panel"), r61, (r7 & 112) | 6);
    L190:
        r61.endReplaceGroup();
        r61.endNode();
        r61.startReplaceGroup(385228703);
        if (((Boolean) r18.getValue()).booleanValue() == true) goto L193;
        ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(TestTagKt.testTag(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(r115.align(r102, r211.getTopCenter()), 0.0f, Dp.constructor-impl(200), 0.0f, 0.0f, 13, null), Dp.constructor-impl(40)), "group_qr_code_loading"), n.a(r61, 0).d.c, 0.0f, 0, 0, 0.0f, r61, 0, 60);
    L193:
        r61.endReplaceGroup();
        r61.endNode();
        r61.endReplaceGroup();
        goto L205
    L189:
        r102 = r30;
        goto L190
    L185:
        r100 = 0.0f;
        goto L186
    L177:
        if (((Boolean) r19.getValue()).booleanValue() == false) goto L181;
        if (((Boolean) r24.getValue()).booleanValue() == false) goto L181;
        r96 = null;
        r97 = 1;
        r98 = 0.0f;
        r310 = true;
        goto L182
    L172:
        if (Intrinsics.areEqual(r94.rememberedValue(), Integer.valueOf(r90)) == true) goto L174;
    L168:
        r10.useNode();
        goto L169
    L160:
        if (Intrinsics.areEqual(r85.rememberedValue(), Integer.valueOf(r81)) == true) goto L162;
    L156:
        r10.useNode();
        goto L157
    L148:
        if (Intrinsics.areEqual(r76.rememberedValue(), Integer.valueOf(r72)) == true) goto L150;
    L144:
        r10.useNode();
        goto L145
    L194:
        r61 = r10;
        r61.startReplaceGroup(-1405616421);
        r61.endReplaceGroup();
        goto L205
    L126:
        if (Intrinsics.areEqual(r59.rememberedValue(), Integer.valueOf(r56)) == true) goto L128;
    L122:
        r10.useNode();
        goto L123
    L114:
        if (Intrinsics.areEqual(r44.rememberedValue(), Integer.valueOf(r40)) == true) goto L116;
    L110:
        r10.useNode();
        goto L111
    L102:
        if (Intrinsics.areEqual(r112.rememberedValue(), Integer.valueOf(r35)) == true) goto L104;
    L98:
        r10.useNode();
        goto L99
    L90:
        if (r29 != r16.getEmpty()) goto L92;
    L85:
        if (r23 != r16.getEmpty()) goto L87;
    L80:
        if (r17 != r16.getEmpty()) goto L82;
    L75:
        if (r12 != r16.getEmpty()) goto L77;
    L65:
        r26 = r4;
        goto L67
    L60:
        if (r10.getSkipping() == false) goto L63;
        r10.skipToGroupEnd();
        r62 = r4;
        r61 = r10;
        goto L209
    L50:
        if ((r54 & 24576) != 0) goto L56;
        r4 = r52;
        if (r10.changedInstance(r4) == false) goto L54;
        int r103 = 16384;
    L55:
        r2 = r2 | r103;
        goto L57
    L54:
        r103 = 8192;
        goto L55
    L40:
        if ((r54 & 3072) != 0) goto L46;
        if (r10.changedInstance(r51) == false) goto L44;
        int r104 = 2048;
    L45:
        r2 = r2 | r104;
        goto L46
    L44:
        r104 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L45
    L30:
        if ((r54 & 384) != 0) goto L37;
        if (r10.changed(r50) == false) goto L34;
        int r105 = 256;
    L35:
        r2 = r2 | r105;
        goto L37
    L34:
        r105 = 128;
        goto L35
    L17:
        if ((r54 & 48) != 0) goto L27;
        if ((r54 & 64) != 0) goto L21;
        boolean r106 = r10.changed(r49);
    L22:
        if (r106 == false) goto L24;
        int r107 = 32;
    L25:
        r2 = r2 | r107;
        goto L27
    L24:
        r107 = 16;
        goto L25
    L21:
        r106 = r10.changedInstance(r49);
        goto L22
    L6:
        if ((r54 & 6) == 0) goto L8;
        r2 = r54;
        goto L14
    L8:
        if (r10.changedInstance(r48) == false) goto L10;
        int r108 = 4;
    L11:
        r2 = r108 | r54;
        goto L14
    L10:
        r108 = 2;
        goto L11
    }

    public static final void c(final String r77, final String r78, final String r79, final String r80, final long r81, final String r83, final int r84, final a r85, final Function0 r86, final Function0 r87, final Function0 r88, final Function1 r89, final Function6 r90, Composer r91, final int r92, final int r93) {
        Composer r1 = r91.startRestartGroup(-1478577457);
        if ((r92 & 6) == 0) goto L5;
        int r7 = r92;
    L11:
        if ((r92 & 48) == 0) goto L13;
    L17:
        int r16 = 128;
        if ((r92 & 384) != 0) goto L26;
        if (r1.changed(r79) == false) goto L22;
        int r17 = 256;
    L23:
        r7 = r7 | r17;
        goto L26
    L22:
        r17 = 128;
    L26:
        if ((r92 & 3072) != 0) goto L34;
        if (r1.changed(r80) == false) goto L30;
        int r18 = 2048;
    L31:
        r7 = r7 | r18;
        goto L34
    L30:
        r18 = ChameleonContainerUtils.MAX_URL_LENGTH;
    L34:
        if ((r92 & 24576) != 0) goto L41;
        if (r1.changed(r81) == false) goto L38;
        int r13 = 16384;
    L39:
        r7 = r7 | r13;
        goto L41
    L38:
        r13 = 8192;
    L41:
        if ((196608 & r92) != 0) goto L49;
        if (r1.changed(r83) == false) goto L45;
        int r19 = 131072;
    L46:
        r7 = r7 | r19;
        goto L49
    L45:
        r19 = 65536;
    L49:
        if ((r92 & 1572864) != 0) goto L56;
        if (r1.changed(r84) == false) goto L53;
        int r110 = 1048576;
    L54:
        r7 = r7 | r110;
        goto L56
    L53:
        r110 = 524288;
    L56:
        if ((r92 & 12582912) != 0) goto L66;
        if ((r92 & 16777216) != 0) goto L60;
        boolean r111 = r1.changed(r85);
    L61:
        if (r111 == false) goto L63;
        int r112 = 8388608;
    L64:
        r7 = r7 | r112;
        goto L66
    L63:
        r112 = 4194304;
        goto L64
    L60:
        r111 = r1.changedInstance(r85);
    L66:
        if ((r92 & 100663296) != 0) goto L73;
        if (r1.changedInstance(r86) == false) goto L70;
        int r113 = 67108864;
    L71:
        r7 = r7 | r113;
        goto L73
    L70:
        r113 = 33554432;
    L73:
        if ((r92 & 805306368) != 0) goto L80;
        if (r1.changedInstance(r87) == false) goto L77;
        int r20 = 536870912;
    L78:
        r7 = r7 | r20;
        goto L80
    L77:
        r20 = 268435456;
    L80:
        if ((r93 & 6) == 0) goto L82;
        int r21 = r93;
    L88:
        if ((r93 & 48) != 0) goto L95;
        if (r1.changedInstance(r89) == false) goto L92;
        int r22 = 32;
    L93:
        r21 = r21 | r22;
        goto L95
    L92:
        r22 = 16;
    L95:
        if ((r93 & 384) != 0) goto L101;
        if (r1.changedInstance(r90) == false) goto L99;
        r16 = 256;
    L99:
        r21 = r21 | r16;
    L101:
        int r0 = r21;
        if ((r7 & 306783379) != 306783378) goto L110;
        if ((r0 & 147) != 146) goto L110;
        if (r1.getSkipping() == false) goto L110;
        r1.skipToGroupEnd();
    L175:
        ScopeUpdateScope r14 = r1.endRestartGroup();
        if (r14 == null) goto L179;
        r14.updateScope(new GroupQrCodeScreenKt$GroupQrCodeCard$2(r77, r78, r79, r80, r81, r83, r84, r85, r86, r87, r88, r89, r90, r92, r93));
        return;
    L179:
        return;
    L110:
        if (ComposerKt.isTraceInProgress() == false) goto L112;
        ComposerKt.traceEventStart(-1478577457, r7, r0, "com.ss.android.lark.compose.groupqrcode.ui.GroupQrCodeCard (GroupQrCodeScreen.kt:226)");
    L112:
        Modifier.Companion r2 = Modifier.Companion;
        float r4 = 16;
        float r15 = 32;
        Modifier r8 = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(r2, 0.0f, 1, null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r4))), n.a(r1, 0).c.a, null, 2, null), 0.0f, Dp.constructor-impl(r15), 0.0f, Dp.constructor-impl(r15), 5, null);
        Alignment.Companion r114 = Alignment.Companion;
        Alignment.Horizontal r115 = r114.getCenterHorizontally();
        Arrangement r116 = Arrangement.INSTANCE;
        MeasurePolicy r3 = ColumnKt.columnMeasurePolicy(r116.getTop(), r115, r1, 48);
        long r23 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r10 = (int) (r23 ^ (r23 >>> 32));
        CompositionLocalMap r9 = r1.getCurrentCompositionLocalMap();
        Modifier r11 = ComposedModifierKt.materializeModifier(r1, r8);
        ComposeUiNode.Companion r68 = ComposeUiNode.Companion;
        Function0 r117 = r68.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L115;
        ComposablesKt.invalidApplier();
    L115:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L118;
        r1.createNode(r117);
    L119:
        Composer r12 = Updater.constructor-impl(r1);
        Updater.set-impl(r12, r3, r68.getSetMeasurePolicy());
        Updater.set-impl(r12, r9, r68.getSetResolvedCompositionLocals());
        Function2 r5 = r68.getSetCompositeKeyHash();
        if (r12.getInserting() == false) goto L122;
    L123:
        r12.updateRememberedValue(Integer.valueOf(r10));
        r12.apply(Integer.valueOf(r10), r5);
    L124:
        Updater.set-impl(r12, r11, r68.getSetModifier());
        ColumnScopeInstance r6 = ColumnScopeInstance.INSTANCE;
        float r24 = 270;
        Modifier r25 = SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(r2, Dp.constructor-impl(r24)), Dp.constructor-impl(56));
        MeasurePolicy r118 = RowKt.rowMeasurePolicy(r116.getStart(), r114.getCenterVertically(), r1, 48);
        long r26 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r119 = (int) (r26 ^ (r26 >>> 32));
        CompositionLocalMap r120 = r1.getCurrentCompositionLocalMap();
        Modifier r27 = ComposedModifierKt.materializeModifier(r1, r25);
        Function0 r121 = r68.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L127;
        ComposablesKt.invalidApplier();
    L127:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L130;
        r1.createNode(r121);
    L131:
        Composer r28 = Updater.constructor-impl(r1);
        Updater.set-impl(r28, r118, r68.getSetMeasurePolicy());
        Updater.set-impl(r28, r120, r68.getSetResolvedCompositionLocals());
        Function2 r122 = r68.getSetCompositeKeyHash();
        if (r28.getInserting() == false) goto L134;
    L135:
        r28.updateRememberedValue(Integer.valueOf(r119));
        r28.apply(Integer.valueOf(r119), r122);
    L136:
        Updater.set-impl(r28, r27, r68.getSetModifier());
        RowScopeInstance r123 = RowScopeInstance.INSTANCE;
        int r69 = ((r7 & 14) | 384) | (r7 & 112);
        int r124 = r7 >> 15;
        int r71 = (r0 << 6) & 57344;
        int r72 = r7;
        r90.invoke(r77, r78, 56, r86, r1, Integer.valueOf((r69 | (r124 & 7168)) | r71));
        float r29 = 12;
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(r2, Dp.constructor-impl(r29)), r1, 6);
        Modifier r30 = RowScope.-CC.weight$default(r123, r2, 1.0f, false, 2, null);
        MeasurePolicy r31 = ColumnKt.columnMeasurePolicy(r116.getCenter(), r114.getStart(), r1, 6);
        long r125 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r126 = (int) (r125 ^ (r125 >>> 32));
        CompositionLocalMap r127 = r1.getCurrentCompositionLocalMap();
        Modifier r32 = ComposedModifierKt.materializeModifier(r1, r30);
        Function0 r128 = r68.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L139;
        ComposablesKt.invalidApplier();
    L139:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L142;
        r1.createNode(r128);
    L143:
        Composer r129 = Updater.constructor-impl(r1);
        Updater.set-impl(r129, r31, r68.getSetMeasurePolicy());
        Updater.set-impl(r129, r127, r68.getSetResolvedCompositionLocals());
        Function2 r33 = r68.getSetCompositeKeyHash();
        if (r129.getInserting() == false) goto L146;
    L147:
        r129.updateRememberedValue(Integer.valueOf(r126));
        r129.apply(Integer.valueOf(r126), r33);
    L148:
        Updater.set-impl(r129, r32, r68.getSetModifier());
        long r34 = n.a(r1, 0).d.a;
        long r210 = TextUnitKt.getSp(16);
        FontWeight r211 = FontWeight.Companion.getBold();
        TextOverflow.Companion r35 = TextOverflow.Companion;
        int r36 = r72 >> 6;
        TextKt.Text-Nvy7gAk(r79, null, r34, null, r210, null, r211, null, 0, null, null, 0, r35.getEllipsis-gIe3tQ8(), false, 1, 0, null, null, r1, (r36 & 14) | 1597440, 24960, 241578);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(r2, Dp.constructor-impl(2)), r1, 6);
        b r37 = b.a;
        Intrinsics.checkNotNullParameter(r37, "<this>");
        TextKt.Text-Nvy7gAk(StringsKt.replace$default(b0.a((z) CommonMainString0.T.getValue(), r1), "{name}", r80, false, 4, null), null, n.a(r1, 0).d.c, null, TextUnitKt.getSp(14), null, null, null, 0, null, null, 0, r35.getEllipsis-gIe3tQ8(), false, 1, 0, null, null, r1, 24576, 24960, 241642);
        r1.endNode();
        r1.endNode();
        Modifier r38 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(r2, 0.0f, Dp.constructor-impl(r4), 0.0f, 0.0f, 13, null), Dp.constructor-impl(r24));
        float r39 = 8;
        Modifier r40 = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(ClipKt.clip(r38, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r39))), n.a(r1, 0).b.a, null, 2, null), Dp.constructor-impl(r39));
        MeasurePolicy r41 = BoxKt.maybeCachedBoxMeasurePolicy(r114.getCenter(), false);
        long r130 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r42 = (int) (r130 ^ (r130 >>> 32));
        CompositionLocalMap r131 = r1.getCurrentCompositionLocalMap();
        Modifier r43 = ComposedModifierKt.materializeModifier(r1, r40);
        Function0 r132 = r68.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L151;
        ComposablesKt.invalidApplier();
    L151:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L154;
        r1.createNode(r132);
    L155:
        Composer r133 = Updater.constructor-impl(r1);
        Updater.set-impl(r133, r41, r68.getSetMeasurePolicy());
        Updater.set-impl(r133, r131, r68.getSetResolvedCompositionLocals());
        Function2 r44 = r68.getSetCompositeKeyHash();
        if (r133.getInserting() == false) goto L158;
    L159:
        r133.updateRememberedValue(Integer.valueOf(r42));
        r133.apply(Integer.valueOf(r42), r44);
    L160:
        Updater.set-impl(r133, r43, r68.getSetModifier());
        BoxScopeInstance r45 = BoxScopeInstance.INSTANCE;
        int r46 = r0 << 9;
        r85.j(r83, r84, ClipKt.clip(SizeKt.fillMaxSize$default(r2, 0.0f, 1, null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), r88, r89, r1, ((r46 & 57344) | (((r124 & 14) | (r124 & 112)) | (r46 & 7168))) | (458752 & r36));
        Modifier r47 = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(r2, Dp.constructor-impl(96)), RoundedCornerShapeKt.getCircleShape()), n.a(r1, 0).b.a, null, 2, null), Dp.constructor-impl(6));
        MeasurePolicy r48 = BoxKt.maybeCachedBoxMeasurePolicy(r114.getCenter(), false);
        long r49 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r50 = (int) (r49 ^ (r49 >>> 32));
        CompositionLocalMap r51 = r1.getCurrentCompositionLocalMap();
        Modifier r52 = ComposedModifierKt.materializeModifier(r1, r47);
        Function0 r53 = r68.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L163;
        ComposablesKt.invalidApplier();
    L163:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L166;
        r1.createNode(r53);
    L167:
        Composer r54 = Updater.constructor-impl(r1);
        Updater.set-impl(r54, r48, r68.getSetMeasurePolicy());
        Updater.set-impl(r54, r51, r68.getSetResolvedCompositionLocals());
        Function2 r55 = r68.getSetCompositeKeyHash();
        if (r54.getInserting() == false) goto L170;
    L171:
        r54.updateRememberedValue(Integer.valueOf(r50));
        r54.apply(Integer.valueOf(r50), r55);
    L172:
        Updater.set-impl(r54, r52, r68.getSetModifier());
        r90.invoke(r77, r78, 84, r87, r1, Integer.valueOf((r69 | ((r72 >> 18) & 7168)) | r71));
        r1.endNode();
        r1.endNode();
        Intrinsics.checkNotNullParameter(r37, "<this>");
        TextKt.Text-Nvy7gAk(StringsKt.replace$default(b0.a((z) CommonMainString0.V.getValue(), r1), "{brandName}", r85.i(), false, 4, null), PaddingKt.padding-qDBjuR0$default(r2, 0.0f, Dp.constructor-impl(28), 0.0f, 0.0f, 13, null), n.a(r1, 0).d.a, null, TextUnitKt.getSp(14), null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r1, 24624, 0, 262120);
        Intrinsics.checkNotNullParameter(r37, "<this>");
        TextKt.Text-Nvy7gAk(StringsKt.replace$default(b0.a((z) CommonMainString0.W.getValue(), r1), "{date}", r85.m(r81), false, 4, null), PaddingKt.padding-qDBjuR0$default(r2, 0.0f, Dp.constructor-impl(r29), 0.0f, 0.0f, 13, null), n.a(r1, 0).d.c, null, TextUnitKt.getSp(12), null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r1, 24624, 0, 262120);
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L175;
        ComposerKt.traceEventEnd();
        goto L175
    L170:
        if (Intrinsics.areEqual(r54.rememberedValue(), Integer.valueOf(r50)) == true) goto L172;
    L166:
        r1.useNode();
        goto L167
    L158:
        if (Intrinsics.areEqual(r133.rememberedValue(), Integer.valueOf(r42)) == true) goto L160;
    L154:
        r1.useNode();
        goto L155
    L146:
        if (Intrinsics.areEqual(r129.rememberedValue(), Integer.valueOf(r126)) == true) goto L148;
    L142:
        r1.useNode();
        goto L143
    L134:
        if (Intrinsics.areEqual(r28.rememberedValue(), Integer.valueOf(r119)) == true) goto L136;
    L130:
        r1.useNode();
        goto L131
    L122:
        if (Intrinsics.areEqual(r12.rememberedValue(), Integer.valueOf(r10)) == true) goto L124;
    L118:
        r1.useNode();
        goto L119
    L82:
        if (r1.changedInstance(r88) == false) goto L84;
        int r212 = 4;
    L85:
        r21 = r93 | r212;
        goto L88
    L84:
        r212 = 2;
        goto L85
    L13:
        if (r1.changed(r78) == false) goto L15;
        int r56 = 32;
    L16:
        r7 = r7 | r56;
        goto L17
    L15:
        r56 = 16;
        goto L16
    L5:
        if (r1.changed(r77) == false) goto L7;
        int r57 = 4;
    L8:
        r7 = r57 | r92;
        goto L11
    L7:
        r57 = 2;
        goto L8
    }
}
