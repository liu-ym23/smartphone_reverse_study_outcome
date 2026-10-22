package com.ss.android.lark.compose.chatsetting.main.ui;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.FocusableKt;
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
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.lark.kmp.pb.basic.v1.Chat;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.chatsetting.common.ui.widget.SettingGroupContainerKt;
import com.ss.android.lark.compose.chatsetting.main.viewmodel.ChatSettingViewModel;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatSettingScreenKt {
    public static final com.ss.android.lark.compose.chatsetting.main.viewmodel.a c(State r0) {
        return (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r0.getValue();
    }

    public static final void a(final MutableTransitionState<Boolean> r35, final Function0<Unit> r36, final com.ss.android.lark.compose.chatsetting.common.platform.a r37, final Function3<? super Function0<Unit>, ? super Composer, ? super Integer, Unit> r38, Composer r39, final int r40) {
        Composer r14 = r39.startRestartGroup(1331091973);
        if ((r40 & 6) == 0) goto L5;
        int r1 = r40;
    L14:
        if ((r40 & 48) != 0) goto L21;
        if (r14.changedInstance(r36) == false) goto L18;
        int r3 = 32;
    L19:
        r1 = r1 | r3;
        goto L21
    L18:
        r3 = 16;
    L21:
        if ((r40 & 384) != 0) goto L31;
        if ((r40 & 512) != 0) goto L25;
        boolean r4 = r14.changed(r37);
    L26:
        if (r4 == false) goto L28;
        int r5 = 256;
    L29:
        r1 = r1 | r5;
        goto L31
    L28:
        r5 = 128;
        goto L29
    L25:
        r4 = r14.changedInstance(r37);
    L31:
        if ((r40 & 3072) != 0) goto L38;
        if (r14.changedInstance(r38) == false) goto L35;
        int r6 = 2048;
    L36:
        r1 = r1 | r6;
        goto L38
    L35:
        r6 = ChameleonContainerUtils.MAX_URL_LENGTH;
    L38:
        if ((r1 & 1171) != 1170) goto L44;
        if (r14.getSkipping() == false) goto L44;
        r14.skipToGroupEnd();
    L101:
        ScopeUpdateScope r7 = r14.endRestartGroup();
        if (r7 == null) goto L105;
        r7.updateScope(new ChatSettingScreenKt$AddMembersOverlay$3(r35, r36, r37, r38, r40));
        return;
    L105:
        return;
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(1331091973, r1, -1, "com.ss.android.lark.compose.chatsetting.main.ui.AddMembersOverlay (ChatSettingScreen.kt:309)");
    L46:
        r14.startReplaceGroup(1849434622);
        Object r8 = r14.rememberedValue();
        Composer.Companion r15 = Composer.Companion;
        if (r8 != r15.getEmpty()) goto L49;
        r8 = new FocusRequester();
        r14.updateRememberedValue(r8);
    L49:
        FocusRequester r9 = (FocusRequester) r8;
        r14.endReplaceGroup();
        Object r10 = r35.getTargetState();
        r14.startReplaceGroup(-1633490746);
        int r11 = r1 & 14;
        if (r11 != 4) goto L52;
    L57:
        boolean r2 = true;
    L58:
        Object r12 = r14.rememberedValue();
        if (r2 == false) goto L61;
    L62:
        r12 = new ChatSettingScreenKt$AddMembersOverlay$1$1(r35, r9, null);
        r14.updateRememberedValue(r12);
    L63:
        r14.endReplaceGroup();
        EffectsKt.LaunchedEffect(r10, (Function2) r12, r14, 0);
        Modifier.Companion r13 = Modifier.Companion;
        Modifier r16 = FocusableKt.focusable$default(FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxSize$default(r13, 0.0f, 1, null), r9), false, null, 3, null);
        if (((Boolean) r35.getCurrentState()).booleanValue() == false) goto L66;
    L69:
        boolean r17 = true;
    L70:
        Modifier r18 = r16.then(r37.a(r17, r36));
        Alignment.Companion r19 = Alignment.Companion;
        MeasurePolicy r20 = BoxKt.maybeCachedBoxMeasurePolicy(r19.getTopStart(), false);
        long r110 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r21 = (int) (r110 ^ (r110 >>> 32));
        CompositionLocalMap r22 = r14.getCurrentCompositionLocalMap();
        Modifier r23 = ComposedModifierKt.materializeModifier(r14, r18);
        ComposeUiNode.Companion r111 = ComposeUiNode.Companion;
        Function0 r24 = r111.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L73;
        ComposablesKt.invalidApplier();
    L73:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L76;
        r14.createNode(r24);
    L77:
        Composer r25 = Updater.constructor-impl(r14);
        Updater.set-impl(r25, r20, r111.getSetMeasurePolicy());
        Updater.set-impl(r25, r22, r111.getSetResolvedCompositionLocals());
        Function2 r26 = r111.getSetCompositeKeyHash();
        if (r25.getInserting() == false) goto L80;
    L81:
        r25.updateRememberedValue(Integer.valueOf(r21));
        r25.apply(Integer.valueOf(r21), r26);
    L82:
        Updater.set-impl(r25, r23, r111.getSetModifier());
        BoxScopeInstance r27 = BoxScopeInstance.INSTANCE;
        if (((Boolean) r35.getTargetState()).booleanValue() == false) goto L85;
        float r28 = 0.4f;
    L86:
        State r29 = AnimateAsStateKt.animateFloatAsState(r28, null, 0.0f, "add_members_scrim_alpha", null, r14, 3072, 22);
        Modifier r210 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(r13, 0.0f, 1, null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), ((Number) r29.getValue()).floatValue(), 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
        r14.startReplaceGroup(1849434622);
        Object r30 = r14.rememberedValue();
        if (r30 != r15.getEmpty()) goto L89;
        r30 = InteractionSourceKt.MutableInteractionSource();
        r14.updateRememberedValue(r30);
    L89:
        MutableInteractionSource r211 = (MutableInteractionSource) r30;
        r14.endReplaceGroup();
        r14.startReplaceGroup(1849434622);
        Object r31 = r14.rememberedValue();
        if (r31 != r15.getEmpty()) goto L92;
        r31 = ChatSettingScreenKt$AddMembersOverlay$2$2$1.INSTANCE;
        r14.updateRememberedValue(r31);
    L92:
        r14.endReplaceGroup();
        BoxKt.Box(ClickableKt.clickable-O2vRcR0$default(r210, r211, null, false, null, null, (Function0) r31, 28, null), r14, 0);
        r14.startReplaceGroup(1849434622);
        Object r32 = r14.rememberedValue();
        if (r32 != r15.getEmpty()) goto L95;
        r32 = ChatSettingScreenKt$AddMembersOverlay$2$3$1.INSTANCE;
        r14.updateRememberedValue(r32);
    L95:
        r14.endReplaceGroup();
        EnterTransition r33 = EnterExitTransitionKt.slideInVertically$default(null, (Function1) r32, 1, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
        r14.startReplaceGroup(1849434622);
        Object r34 = r14.rememberedValue();
        if (r34 != r15.getEmpty()) goto L98;
        r34 = ChatSettingScreenKt$AddMembersOverlay$2$4$1.INSTANCE;
        r14.updateRememberedValue(r34);
    L98:
        r14.endReplaceGroup();
        ExitTransition r41 = EnterExitTransitionKt.slideOutVertically$default(null, (Function1) r34, 1, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
        AnimatedVisibilityKt.AnimatedVisibility(r35, r27.align(r13, r19.getBottomCenter()), r33, r41, null, ComposableLambdaKt.rememberComposableLambda(622046823, true, new ChatSettingScreenKt$AddMembersOverlay$2$5(r38, r36), r14, 54), r14, (200064 | MutableTransitionState.$stable) | r11, 16);
        r14.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L101;
        ComposerKt.traceEventEnd();
        goto L101
    L85:
        r28 = 0.0f;
        goto L86
    L80:
        if (Intrinsics.areEqual(r25.rememberedValue(), Integer.valueOf(r21)) == true) goto L82;
    L76:
        r14.useNode();
        goto L77
    L66:
        if (((Boolean) r35.getTargetState()).booleanValue() == true) goto L69;
        r17 = false;
        goto L70
    L61:
        if (r12 != r15.getEmpty()) goto L63;
    L52:
        if ((r1 & 8) != 0) goto L54;
    L56:
        r2 = false;
        goto L58
    L54:
        if (r14.changedInstance(r35) == false) goto L56;
    L5:
        if ((r40 & 8) != 0) goto L7;
        boolean r42 = r14.changed(r35);
    L8:
        if (r42 == false) goto L10;
        int r43 = 4;
    L11:
        r1 = r43 | r40;
        goto L14
    L10:
        r43 = 2;
        goto L11
    L7:
        r42 = r14.changedInstance(r35);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v14 */
    public static final void b(final boolean r39, final String r40, final String r41, final d r42, final ChatSettingViewModel r43, final com.ss.android.lark.compose.chatsetting.common.platform.b r44, final com.ss.android.lark.compose.chatsetting.common.platform.a r45, final Function2<? super String, ? super String, Unit> r46, final PaddingValues r47, Function6<? super com.ss.android.lark.compose.foundation.widget.a, ? super com.ss.android.lark.compose.foundation.widget.a, ? super Function1<? super Boolean, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit> r48, Function3<? super Function0<Unit>, ? super Composer, ? super Integer, Unit> r49, Composer r50, final int r51, final int r52, final int r53) {
        Intrinsics.checkNotNullParameter(r40, "chatId");
        Intrinsics.checkNotNullParameter(r41, "userId");
        Intrinsics.checkNotNullParameter(r42, "rustClient");
        Intrinsics.checkNotNullParameter(r43, "viewModel");
        Intrinsics.checkNotNullParameter(r44, "platformEffects");
        Intrinsics.checkNotNullParameter(r45, "childScreenHost");
        Intrinsics.checkNotNullParameter(r46, "routerToQuit");
        Intrinsics.checkNotNullParameter(r47, "contentPadding");
        Composer r5 = r50.startRestartGroup(-1269365702);
        if ((r53 & 1) == 0) goto L6;
        int r1 = r51 | 6;
    L14:
        if ((r53 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r53 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r53 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        if ((r53 & 16) == 0) goto L47;
        r1 = r1 | 24576;
    L53:
        int r16 = 196608;
        if ((r53 & 32) == 0) goto L57;
    L65:
        r1 = r1 | r16;
    L67:
        if ((r53 & 64) == 0) goto L70;
        int r2 = 1572864;
    L78:
        r1 = r1 | r2;
    L80:
        if ((r53 & 128) == 0) goto L83;
        int r3 = 12582912;
    L88:
        r1 = r1 | r3;
    L90:
        if ((r53 & 256) == 0) goto L93;
        int r4 = 100663296;
    L98:
        r1 = r1 | r4;
    L99:
        int r6 = r53 & 512;
        if (r6 == 0) goto L103;
        r1 = r1 | 805306368;
    L109:
        int r7 = r53 & ChameleonContainerUtils.MAX_URL_LENGTH;
        if (r7 == 0) goto L113;
        int r18 = r52 | 6;
    L119:
        int r11 = r18;
    L122:
        if ((r1 & 306783379) == 306783378) goto L124;
    L129:
        if (r6 == 0) goto L131;
        Function6<? super com.ss.android.lark.compose.foundation.widget.a, ? super com.ss.android.lark.compose.foundation.widget.a, ? super Function1<? super Boolean, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit> r8 = ComposableSingletons$ChatSettingScreenKt.a;
    L133:
        if (r7 == 0) goto L135;
        Function3<? super Function0<Unit>, ? super Composer, ? super Integer, Unit> r23 = ComposableLambdaKt.rememberComposableLambda(-1973784019, true, new ChatSettingScreenKt$ChatSettingScreen$1(r40, r42, r45, r44), r5, 54);
    L137:
        if (ComposerKt.isTraceInProgress() == false) goto L139;
        ComposerKt.traceEventStart(-1269365702, r1, r11, "com.ss.android.lark.compose.chatsetting.main.ui.ChatSettingScreen (ChatSettingScreen.kt:106)");
    L139:
        final Context r9 = d8b.b.a(r5);
        int r54 = r11;
        final State r10 = SnapshotStateKt.collectAsState(r43.getUiState(), null, r5, 0, 1);
        Intrinsics.checkNotNullParameter(com.ss.android.lark.flow.chat.resources.b.a, "<this>");
        final String r24 = b0.a((z) CommonMainString0.Q1.getValue(), r5);
        r5.startReplaceGroup(1849434622);
        Object r12 = r5.rememberedValue();
        Composer.Companion r25 = Composer.Companion;
        if (r12 != r25.getEmpty()) goto L142;
        MutableState r13 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r5.updateRememberedValue(r13);
        r12 = r13;
    L142:
        final MutableState r14 = (MutableState) r12;
        r5.endReplaceGroup();
        r5.startReplaceGroup(1849434622);
        Object r15 = r5.rememberedValue();
        if (r15 != r25.getEmpty()) goto L145;
        r15 = new MutableTransitionState(Boolean.FALSE);
        r5.updateRememberedValue(r15);
    L145:
        MutableTransitionState r17 = (MutableTransitionState) r15;
        r5.endReplaceGroup();
        r5.startReplaceGroup(1849434622);
        Object r19 = r5.rememberedValue();
        if (r19 != r25.getEmpty()) goto L148;
        r19 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r5.updateRememberedValue(r19);
    L148:
        final MutableState r20 = (MutableState) r19;
        r5.endReplaceGroup();
        Boolean r21 = Boolean.valueOf(((Boolean) r14.getValue()).booleanValue());
        r5.startReplaceGroup(-1633490746);
        boolean r110 = r5.changedInstance(r17);
        Object r22 = r5.rememberedValue();
        if (r110 == false) goto L151;
    L152:
        r22 = new ChatSettingScreenKt$ChatSettingScreen$2$1(r17, r14, null);
        r5.updateRememberedValue(r22);
    L153:
        r5.endReplaceGroup();
        EffectsKt.LaunchedEffect(r21, (Function2) r22, r5, 0);
        Unit r26 = Unit.INSTANCE;
        r5.startReplaceGroup(-1633490746);
        boolean r27 = r5.changedInstance(r43) | r5.changedInstance(r9);
        Object r28 = r5.rememberedValue();
        if (r27 == false) goto L156;
    L159:
        r28 = new ChatSettingScreenKt$ChatSettingScreen$3$1(r43, r9, null);
        r5.updateRememberedValue(r28);
    L160:
        r5.endReplaceGroup();
        EffectsKt.LaunchedEffect(r26, (Function2) r28, r5, 6);
        Modifier.Companion r29 = Modifier.Companion;
        Modifier r30 = PaddingKt.padding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(r29, 0.0f, 1, null), n.a(r5, 0).c.f, null, 2, null), r47);
        Alignment.Companion r31 = Alignment.Companion;
        MeasurePolicy r111 = BoxKt.maybeCachedBoxMeasurePolicy(r31.getTopStart(), false);
        long r112 = ComposablesKt.getCurrentCompositeKeyHashCode(r5, 0);
        int r113 = (int) (r112 ^ (r112 >>> 32));
        CompositionLocalMap r114 = r5.getCurrentCompositionLocalMap();
        Modifier r32 = ComposedModifierKt.materializeModifier(r5, r30);
        ComposeUiNode.Companion r210 = ComposeUiNode.Companion;
        Function0 r33 = r210.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L163;
        ComposablesKt.invalidApplier();
    L163:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L166;
        r5.createNode(r33);
    L167:
        Composer r34 = Updater.constructor-impl(r5);
        Updater.set-impl(r34, r111, r210.getSetMeasurePolicy());
        Updater.set-impl(r34, r114, r210.getSetResolvedCompositionLocals());
        Function2 r115 = r210.getSetCompositeKeyHash();
        if (r34.getInserting() == false) goto L170;
    L171:
        r34.updateRememberedValue(Integer.valueOf(r113));
        r34.apply(Integer.valueOf(r113), r115);
    L172:
        Updater.set-impl(r34, r32, r210.getSetModifier());
        BoxScopeInstance r35 = BoxScopeInstance.INSTANCE;
        Modifier r116 = SizeKt.fillMaxSize$default(r29, 0.0f, 1, null);
        Arrangement r36 = Arrangement.INSTANCE;
        MeasurePolicy r37 = ColumnKt.columnMeasurePolicy(r36.getTop(), r31.getStart(), r5, 0);
        long r117 = ComposablesKt.getCurrentCompositeKeyHashCode(r5, 0);
        int r118 = (int) (r117 ^ (r117 >>> 32));
        CompositionLocalMap r119 = r5.getCurrentCompositionLocalMap();
        Modifier r120 = ComposedModifierKt.materializeModifier(r5, r116);
        Function0 r121 = r210.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L175;
        ComposablesKt.invalidApplier();
    L175:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L178;
        r5.createNode(r121);
    L179:
        Composer r122 = Updater.constructor-impl(r5);
        Updater.set-impl(r122, r37, r210.getSetMeasurePolicy());
        Updater.set-impl(r122, r119, r210.getSetResolvedCompositionLocals());
        Function2 r38 = r210.getSetCompositeKeyHash();
        if (r122.getInserting() == false) goto L182;
    L183:
        r122.updateRememberedValue(Integer.valueOf(r118));
        r122.apply(Integer.valueOf(r118), r38);
    L184:
        Updater.set-impl(r122, r120, r210.getSetModifier());
        ColumnScopeInstance r55 = ColumnScopeInstance.INSTANCE;
        r5.startReplaceGroup(-1633490746);
        boolean r123 = r5.changedInstance(r43) | r5.changedInstance(r9);
        Object r124 = r5.rememberedValue();
        if (r123 == false) goto L187;
    L188:
        r124 = new ChatSettingScreenKt$ChatSettingScreen$4$1$1$1(r43, r9);
        r5.updateRememberedValue(r124);
    L189:
        Function0 r125 = (Function0) r124;
        r5.endReplaceGroup();
        r5.startReplaceGroup(5004770);
        Object r126 = r5.rememberedValue();
        if (r126 != r25.getEmpty()) goto L192;
        r126 = new ChatSettingScreenKt$ChatSettingScreen$4$1$2$1(r20);
        r5.updateRememberedValue(r126);
    L192:
        r5.endReplaceGroup();
        ChatSettingTitleKt.a(r39, null, r125, (Function0) r126, r5, (r1 & 14) | 3072, 2);
        r5.startReplaceGroup(1483280340);
        if (((Boolean) r20.getValue()).booleanValue() == false) goto L203;
        r5.startReplaceGroup(5004770);
        Object r127 = r5.rememberedValue();
        if (r127 != r25.getEmpty()) goto L197;
        r127 = new ChatSettingScreenKt$ChatSettingScreen$4$1$3$1(r20);
        r5.updateRememberedValue(r127);
    L197:
        Function0 r128 = (Function0) r127;
        r5.endReplaceGroup();
        r5.startReplaceGroup(-1633490746);
        boolean r56 = r5.changedInstance(r43) | r5.changedInstance(r9);
        Object r129 = r5.rememberedValue();
        if (r56 == false) goto L200;
    L201:
        r129 = new ChatSettingScreenKt$ChatSettingScreen$4$1$4$1(r43, r9);
        r5.updateRememberedValue(r129);
    L202:
        r5.endReplaceGroup();
        MorePopupMenuKt.a(r128, (Function0) r129, r5, 6);
        goto L203
    L200:
        if (r129 != r25.getEmpty()) goto L202;
    L203:
        r5.endReplaceGroup();
        Modifier r57 = PaddingKt.padding-qDBjuR0$default(ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(ColumnScope.-CC.weight$default(r55, r29, 1.0f, false, 2, null), 0.0f, 1, null), ScrollKt.rememberScrollState(0, r5, 0, 1), false, null, false, 14, null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(32), 7, null);
        MeasurePolicy r58 = ColumnKt.columnMeasurePolicy(r36.getTop(), r31.getStart(), r5, 0);
        long r59 = ComposablesKt.getCurrentCompositeKeyHashCode(r5, 0);
        int r60 = (int) (r59 ^ (r59 >>> 32));
        CompositionLocalMap r61 = r5.getCurrentCompositionLocalMap();
        Modifier r62 = ComposedModifierKt.materializeModifier(r5, r57);
        Function0 r130 = r210.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L206;
        ComposablesKt.invalidApplier();
    L206:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L209;
        r5.createNode(r130);
    L210:
        Composer r131 = Updater.constructor-impl(r5);
        Updater.set-impl(r131, r58, r210.getSetMeasurePolicy());
        Updater.set-impl(r131, r61, r210.getSetResolvedCompositionLocals());
        Function2 r63 = r210.getSetCompositeKeyHash();
        if (r131.getInserting() == false) goto L213;
    L214:
        r131.updateRememberedValue(Integer.valueOf(r60));
        r131.apply(Integer.valueOf(r60), r63);
    L215:
        Updater.set-impl(r131, r62, r210.getSetModifier());
        r5.startReplaceGroup(575171901);
        com.ss.android.lark.compose.chatsetting.main.viewmodel.a r64 = (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r10.getValue();
        Intrinsics.checkNotNullParameter(r64, "<this>");
        Chat.Type r65 = r64.a;
        Chat.Type r132 = Chat.Type.GROUP;
        if (r65 != r132) goto L218;
        boolean r66 = true;
    L219:
        if (r66 == false) goto L221;
        ?? r133 = 1;
        final Context r410 = r9;
        Composer r134 = r5;
        Function6<? super com.ss.android.lark.compose.foundation.widget.a, ? super com.ss.android.lark.compose.foundation.widget.a, ? super Function1<? super Boolean, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit> r310 = r8;
        State r135 = r10;
        int r136 = 54;
        String r311 = "<this>";
        SettingGroupContainerKt.a(null, ComposableLambdaKt.rememberComposableLambda(-1505099363, true, new ChatSettingScreenKt$ChatSettingScreen$4$1$5$1(r41, r40, r42, r43, r410, r10, r44, r24, r14), r134, 54), r134, 48, 1);
    L222:
        r134.endReplaceGroup();
        r134.startReplaceGroup(575211111);
        com.ss.android.lark.compose.chatsetting.main.viewmodel.a r0 = (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r135.getValue();
        String r67 = r311;
        Intrinsics.checkNotNullParameter(r0, r67);
        if (r0.a == Chat.Type.P2P) goto L225;
    L230:
        boolean r68 = false;
    L231:
        if (r68 == false) goto L233;
        final com.ss.android.lark.compose.chatsetting.common.platform.b r69 = r44;
        final State r70 = r135;
        SettingGroupContainerKt.a(null, ComposableLambdaKt.rememberComposableLambda(742916692, r133, new ChatSettingScreenKt$ChatSettingScreen$4$1$5$2(r40, r42, r69, r70), r134, r136), r134, 48, r133);
    L234:
        r134.endReplaceGroup();
        r134.startReplaceGroup(575226092);
        com.ss.android.lark.compose.chatsetting.main.viewmodel.a r71 = (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r70.getValue();
        Intrinsics.checkNotNullParameter(r71, r67);
        if (r71.a != r132) goto L237;
        boolean r72 = true;
    L238:
        if (r72 == false) goto L240;
        final Context r73 = r410;
        int r74 = 48;
        Modifier r75 = null;
        SettingGroupContainerKt.a(null, ComposableLambdaKt.rememberComposableLambda(153982165, r133, new ChatSettingScreenKt$ChatSettingScreen$4$1$5$3(r43, r73, r70), r134, r136), r134, 48, r133);
    L241:
        r134.endReplaceGroup();
        SettingGroupContainerKt.a(r75, ComposableLambdaKt.rememberComposableLambda(-43432190, r133, new ChatSettingScreenKt$ChatSettingScreen$4$1$5$4(r43, r73), r134, r136), r134, r74, r133);
        r134.startReplaceGroup(575285562);
        if (com.ss.android.lark.compose.chatsetting.main.viewmodel.b.a((com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r70.getValue()) == false) goto L244;
        final Function6<? super com.ss.android.lark.compose.foundation.widget.a, ? super com.ss.android.lark.compose.foundation.widget.a, ? super Function1<? super Boolean, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit> r76 = r310;
        SettingGroupContainerKt.a(r75, ComposableLambdaKt.rememberComposableLambda(-434952362, r133, new ChatSettingScreenKt$ChatSettingScreen$4$1$5$5(r76, r43, r73, r70), r134, r136), r134, r74, r133);
    L245:
        r134.endReplaceGroup();
        SettingGroupContainerKt.a(r75, ComposableLambdaKt.rememberComposableLambda(950764153, r133, new ChatSettingScreenKt$ChatSettingScreen$4$1$5$6(r43, r73, r70), r134, r136), r134, r74, r133);
        r134.startReplaceGroup(575319481);
        com.ss.android.lark.compose.chatsetting.main.viewmodel.a r77 = (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r70.getValue();
        Intrinsics.checkNotNullParameter(r77, r67);
        if (((r77.r ? 1 : 0) ^ r133) == 0) goto L248;
        SettingGroupContainerKt.a(null, ComposableLambdaKt.rememberComposableLambda(-1023886889, r133, new ChatSettingScreenKt$ChatSettingScreen$4$1$5$7(r43, r73, r69), r134, r136), r134, 48, r133);
    L248:
        r134.endReplaceGroup();
        r134.startReplaceGroup(575331242);
        com.ss.android.lark.compose.chatsetting.main.viewmodel.a r78 = (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r70.getValue();
        Intrinsics.checkNotNullParameter(r78, r67);
        if (r78.a == r132) goto L251;
    L256:
        boolean r79 = false;
    L257:
        if (r79 == true) goto L265;
        com.ss.android.lark.compose.chatsetting.main.viewmodel.a r80 = (com.ss.android.lark.compose.chatsetting.main.viewmodel.a) r70.getValue();
        Intrinsics.checkNotNullParameter(r80, r67);
        if (r80.a == r132) goto L261;
    L263:
        boolean r81 = false;
    L264:
        if (r81 == true) goto L265;
    L266:
        r134.endReplaceGroup();
        r134.endNode();
        r134.endNode();
        r134.startReplaceGroup(-1744134341);
        if (((Boolean) r17.getCurrentState()).booleanValue() == false) goto L269;
    L270:
        r134.startReplaceGroup(5004770);
        Object r82 = r134.rememberedValue();
        if (r82 != r25.getEmpty()) goto L273;
        r82 = new ChatSettingScreenKt$ChatSettingScreen$4$2$1(r14);
        r134.updateRememberedValue(r82);
    L273:
        r134.endReplaceGroup();
        a(r17, (Function0) r82, r45, r23, r134, ((MutableTransitionState.$stable | 48) | ((r1 >> 12) & 896)) | ((r54 << 9) & 7168));
    L274:
        r134.endReplaceGroup();
        r134.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L277;
        ComposerKt.traceEventEnd();
    L277:
        Function6<? super com.ss.android.lark.compose.foundation.widget.a, ? super com.ss.android.lark.compose.foundation.widget.a, ? super Function1<? super Boolean, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit> r137 = r76;
    L278:
        ScopeUpdateScope r138 = r134.endRestartGroup();
        if (r138 == null) goto L282;
        final Function6<? super com.ss.android.lark.compose.foundation.widget.a, ? super com.ss.android.lark.compose.foundation.widget.a, ? super Function1<? super Boolean, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit> r139 = r137;
        final Function3<? super Function0<Unit>, ? super Composer, ? super Integer, Unit> r140 = r23;
        r138.updateScope(new ChatSettingScreenKt$ChatSettingScreen$5(r39, r40, r41, r42, r43, r44, r45, r46, r47, r139, r140, r51, r52, r53));
        return;
    L282:
        return;
    L269:
        if (((Boolean) r17.getTargetState()).booleanValue() == false) goto L274;
    L261:
        if (r80.f == false) goto L263;
        r81 = true;
    L265:
        SettingGroupContainerKt.a(null, ComposableLambdaKt.rememberComposableLambda(-1612821416, r133, new ChatSettingScreenKt$ChatSettingScreen$4$1$5$8(r43, r73, r44, r46, r70), r134, r136), r134, 48, r133);
        goto L266
    L251:
        if (r78.c.length() <= 0) goto L253;
        boolean r83 = true;
    L254:
        if (r83 == false) goto L256;
        r79 = true;
        goto L257
    L253:
        r83 = false;
        goto L254
    L244:
        r76 = r310;
        goto L245
    L240:
        r73 = r410;
        r74 = 48;
        r75 = null;
        goto L241
    L237:
        r72 = false;
        goto L238
    L233:
        r69 = r44;
        r70 = r135;
        goto L234
    L225:
        if (r0.d.length() <= 0) goto L227;
        boolean r84 = true;
    L228:
        if (r84 == false) goto L230;
        r68 = true;
        goto L231
    L227:
        r84 = false;
        goto L228
    L221:
        r310 = r8;
        r311 = "<this>";
        r135 = r10;
        r410 = r9;
        r134 = r5;
        r136 = 54;
        r133 = 1;
        goto L222
    L218:
        r66 = false;
        goto L219
    L213:
        if (Intrinsics.areEqual(r131.rememberedValue(), Integer.valueOf(r60)) == true) goto L215;
    L209:
        r5.useNode();
        goto L210
    L187:
        if (r124 != r25.getEmpty()) goto L189;
    L182:
        if (Intrinsics.areEqual(r122.rememberedValue(), Integer.valueOf(r118)) == true) goto L184;
    L178:
        r5.useNode();
        goto L179
    L170:
        if (Intrinsics.areEqual(r34.rememberedValue(), Integer.valueOf(r113)) == true) goto L172;
    L166:
        r5.useNode();
        goto L167
    L156:
        if (r28 != r25.getEmpty()) goto L160;
    L151:
        if (r22 != r25.getEmpty()) goto L153;
    L135:
        r23 = r49;
        goto L137
    L131:
        r8 = r48;
        goto L133
    L124:
        if ((r11 & 3) != 2) goto L129;
        if (r5.getSkipping() == false) goto L129;
        r5.skipToGroupEnd();
        r137 = r48;
        r23 = r49;
        r134 = r5;
        goto L278
    L113:
        if ((r52 & 6) == 0) goto L115;
        r11 = r52;
        goto L122
    L115:
        if (r5.changedInstance(r49) == false) goto L117;
        int r141 = 4;
    L118:
        r18 = r52 | r141;
        goto L119
    L117:
        r141 = 2;
        goto L118
    L103:
        if ((r51 & 805306368) != 0) goto L109;
        if (r5.changedInstance(r48) == false) goto L107;
        int r142 = 536870912;
    L108:
        r1 = r1 | r142;
        goto L109
    L107:
        r142 = 268435456;
        goto L108
    L93:
        if ((100663296 & r51) != 0) goto L99;
        if (r5.changed(r47) == false) goto L97;
        r4 = 67108864;
        goto L98
    L97:
        r4 = 33554432;
        goto L98
    L83:
        if ((12582912 & r51) != 0) goto L90;
        if (r5.changedInstance(r46) == false) goto L87;
        r3 = 8388608;
        goto L88
    L87:
        r3 = 4194304;
        goto L88
    L70:
        if ((1572864 & r51) != 0) goto L80;
        if ((2097152 & r51) != 0) goto L74;
        boolean r85 = r5.changed(r45);
    L75:
        if (r85 == false) goto L77;
        r2 = 1048576;
        goto L78
    L77:
        r2 = 524288;
        goto L78
    L74:
        r85 = r5.changedInstance(r45);
        goto L75
    L57:
        if ((r51 & 196608) != 0) goto L67;
        if ((262144 & r51) != 0) goto L61;
        boolean r86 = r5.changed(r44);
    L62:
        if (r86 == false) goto L64;
        r16 = 131072;
        goto L65
    L64:
        r16 = 65536;
        goto L65
    L61:
        r86 = r5.changedInstance(r44);
        goto L62
    L47:
        if ((r51 & 24576) != 0) goto L53;
        if (r5.changedInstance(r43) == false) goto L51;
        int r87 = 16384;
    L52:
        r1 = r1 | r87;
        goto L53
    L51:
        r87 = 8192;
        goto L52
    L37:
        if ((r51 & 3072) != 0) goto L44;
        if (r5.changedInstance(r42) == false) goto L41;
        int r88 = 2048;
    L42:
        r1 = r1 | r88;
        goto L44
    L41:
        r88 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L42
    L27:
        if ((r51 & 384) != 0) goto L34;
        if (r5.changed(r41) == false) goto L31;
        int r89 = 256;
    L32:
        r1 = r1 | r89;
        goto L34
    L31:
        r89 = 128;
        goto L32
    L17:
        if ((r51 & 48) != 0) goto L24;
        if (r5.changed(r40) == false) goto L21;
        int r143 = 32;
    L22:
        r1 = r1 | r143;
        goto L24
    L21:
        r143 = 16;
        goto L22
    L6:
        if ((r51 & 6) == 0) goto L8;
        r1 = r51;
        goto L14
    L8:
        if (r5.changed(r39) == false) goto L10;
        int r90 = 4;
    L11:
        r1 = r90 | r51;
        goto L14
    L10:
        r90 = 2;
        goto L11
    }
}
