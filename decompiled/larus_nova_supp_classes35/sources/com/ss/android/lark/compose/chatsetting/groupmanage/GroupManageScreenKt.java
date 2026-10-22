package com.ss.android.lark.compose.chatsetting.groupmanage;

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
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.lark.kmp.pb.basic.v1.Chat;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.chatsetting.common.ui.icon.ChatSettingIcons;
import com.ss.android.lark.compose.chatsetting.common.ui.widget.SettingGroupContainerKt;
import com.ss.android.lark.compose.foundation.dialog.FlowAlertDialogKt;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class GroupManageScreenKt {
    public static final void b(final String r28, final Function0<Unit> r29, Modifier r30, Composer r31, final int r32, final int r33) {
        Intrinsics.checkNotNullParameter(r28, "title");
        Intrinsics.checkNotNullParameter(r29, "onBack");
        Composer r13 = r31.startRestartGroup(1353174217);
        if ((r33 & 1) == 0) goto L6;
        int r2 = r32 | 6;
    L14:
        if ((r33 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L23:
        int r3 = r33 & 4;
        if (r3 == 0) goto L27;
        r2 = r2 | 384;
    L33:
        Modifier r4 = r30;
    L34:
        int r12 = r2;
        if ((r12 & 147) == 146) goto L37;
    L40:
        if (r3 == 0) goto L42;
        Modifier r11 = Modifier.Companion;
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(1353174217, r12, -1, "com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageTitleBar (GroupManageScreen.kt:454)");
    L46:
        Modifier r1 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(r11, 0.0f, 1, null), Dp.constructor-impl(62));
        Alignment.Companion r16 = Alignment.Companion;
        MeasurePolicy r5 = BoxKt.maybeCachedBoxMeasurePolicy(r16.getTopStart(), false);
        long r6 = ComposablesKt.getCurrentCompositeKeyHashCode(r13, 0);
        int r7 = (int) (r6 ^ (r6 >>> 32));
        CompositionLocalMap r8 = r13.getCurrentCompositionLocalMap();
        Modifier r9 = ComposedModifierKt.materializeModifier(r13, r1);
        ComposeUiNode.Companion r17 = ComposeUiNode.Companion;
        Function0 r10 = r17.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L49;
        ComposablesKt.invalidApplier();
    L49:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L52;
        r13.createNode(r10);
    L53:
        Composer r14 = Updater.constructor-impl(r13);
        Updater.set-impl(r14, r5, r17.getSetMeasurePolicy());
        Updater.set-impl(r14, r8, r17.getSetResolvedCompositionLocals());
        Function2 r15 = r17.getSetCompositeKeyHash();
        if (r14.getInserting() == false) goto L56;
    L57:
        r14.updateRememberedValue(Integer.valueOf(r7));
        r14.apply(Integer.valueOf(r7), r15);
    L58:
        Updater.set-impl(r14, r9, r17.getSetModifier());
        BoxScopeInstance r18 = BoxScopeInstance.INSTANCE;
        Modifier.Companion r19 = Modifier.Companion;
        Modifier r20 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(r18.align(r19, r16.getCenterStart()), Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, null), Dp.constructor-impl(44));
        r13.startReplaceGroup(1849434622);
        Object r21 = r13.rememberedValue();
        if (r21 != Composer.Companion.getEmpty()) goto L61;
        r21 = InteractionSourceKt.MutableInteractionSource();
        r13.updateRememberedValue(r21);
    L61:
        r13.endReplaceGroup();
        Modifier r22 = ClickableKt.clickable-O2vRcR0$default(r20, (MutableInteractionSource) r21, null, false, null, null, r29, 28, null);
        MeasurePolicy r23 = BoxKt.maybeCachedBoxMeasurePolicy(r16.getCenter(), false);
        long r24 = ComposablesKt.getCurrentCompositeKeyHashCode(r13, 0);
        int r25 = (int) (r24 ^ (r24 >>> 32));
        CompositionLocalMap r26 = r13.getCurrentCompositionLocalMap();
        Modifier r27 = ComposedModifierKt.materializeModifier(r13, r22);
        Function0 r34 = r17.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L64;
        ComposablesKt.invalidApplier();
    L64:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L67;
        r13.createNode(r34);
    L68:
        Composer r35 = Updater.constructor-impl(r13);
        Updater.set-impl(r35, r23, r17.getSetMeasurePolicy());
        Updater.set-impl(r35, r26, r17.getSetResolvedCompositionLocals());
        Function2 r36 = r17.getSetCompositeKeyHash();
        if (r35.getInserting() == false) goto L71;
    L72:
        r35.updateRememberedValue(Integer.valueOf(r25));
        r35.apply(Integer.valueOf(r25), r36);
    L73:
        Updater.set-impl(r35, r27, r17.getSetModifier());
        IconKt.Icon-ww6aTOc((ImageVector) ChatSettingIcons.m.getValue(), "Back", null, n.a(r13, 0).d.a, r13, 48, 4);
        r13.endNode();
        TextStyle r37 = n.b(r13).a;
        Modifier r210 = r11;
        Composer r211 = r13;
        TextKt.Text-Nvy7gAk(r28, r18.align(r19, r16.getCenter()), n.a(r13, 0).d.a, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, r37, r211, r12 & 14, 0, 131064);
        r211.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L76;
        ComposerKt.traceEventEnd();
    L76:
        final Modifier r38 = r210;
    L77:
        ScopeUpdateScope r39 = r211.endRestartGroup();
        if (r39 == null) goto L81;
        r39.updateScope(new GroupManageScreenKt$GroupManageTitleBar$2(r28, r29, r38, r32, r33));
        return;
    L81:
        return;
    L71:
        if (Intrinsics.areEqual(r35.rememberedValue(), Integer.valueOf(r25)) == true) goto L73;
    L67:
        r13.useNode();
        goto L68
    L56:
        if (Intrinsics.areEqual(r14.rememberedValue(), Integer.valueOf(r7)) == true) goto L58;
    L52:
        r13.useNode();
        goto L53
    L42:
        r11 = r4;
        goto L44
    L37:
        if (r13.getSkipping() == false) goto L40;
        r13.skipToGroupEnd();
        r38 = r4;
        r211 = r13;
        goto L77
    L27:
        if ((r32 & 384) != 0) goto L33;
        r4 = r30;
        if (r13.changed(r4) == false) goto L31;
        int r40 = 256;
    L32:
        r2 = r2 | r40;
        goto L34
    L31:
        r40 = 128;
        goto L32
    L17:
        if ((r32 & 48) != 0) goto L23;
        if (r13.changedInstance(r29) == false) goto L21;
        int r41 = 32;
    L22:
        r2 = r2 | r41;
        goto L23
    L21:
        r41 = 16;
        goto L22
    L6:
        if ((r32 & 6) == 0) goto L8;
        r2 = r32;
        goto L14
    L8:
        if (r13.changed(r28) == false) goto L10;
        int r42 = 4;
    L11:
        r2 = r42 | r32;
        goto L14
    L10:
        r42 = 2;
        goto L11
    }

    public static final void d(final MutableTransitionState<Boolean> r35, final Function0<Unit> r36, final com.ss.android.lark.compose.chatsetting.common.platform.a r37, final Function2<? super Composer, ? super Integer, Unit> r38, Composer r39, final int r40) {
        Composer r14 = r39.startRestartGroup(1124425349);
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
        r7.updateScope(new GroupManageScreenKt$UpdateManagerOverlay$3(r35, r36, r37, r38, r40));
        return;
    L105:
        return;
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(1124425349, r1, -1, "com.ss.android.lark.compose.chatsetting.groupmanage.UpdateManagerOverlay (GroupManageScreen.kt:295)");
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
        r12 = new GroupManageScreenKt$UpdateManagerOverlay$1$1(r35, r9, null);
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
        State r29 = AnimateAsStateKt.animateFloatAsState(r28, null, 0.0f, "update_manager_scrim_alpha", null, r14, 3072, 22);
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
        r31 = GroupManageScreenKt$UpdateManagerOverlay$2$2$1.INSTANCE;
        r14.updateRememberedValue(r31);
    L92:
        r14.endReplaceGroup();
        BoxKt.Box(ClickableKt.clickable-O2vRcR0$default(r210, r211, null, false, null, null, (Function0) r31, 28, null), r14, 0);
        r14.startReplaceGroup(1849434622);
        Object r32 = r14.rememberedValue();
        if (r32 != r15.getEmpty()) goto L95;
        r32 = GroupManageScreenKt$UpdateManagerOverlay$2$3$1.INSTANCE;
        r14.updateRememberedValue(r32);
    L95:
        r14.endReplaceGroup();
        EnterTransition r33 = EnterExitTransitionKt.slideInVertically$default(null, (Function1) r32, 1, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
        r14.startReplaceGroup(1849434622);
        Object r34 = r14.rememberedValue();
        if (r34 != r15.getEmpty()) goto L98;
        r34 = GroupManageScreenKt$UpdateManagerOverlay$2$4$1.INSTANCE;
        r14.updateRememberedValue(r34);
    L98:
        r14.endReplaceGroup();
        ExitTransition r41 = EnterExitTransitionKt.slideOutVertically$default(null, (Function1) r34, 1, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
        AnimatedVisibilityKt.AnimatedVisibility(r35, r27.align(r13, r19.getBottomCenter()), r33, r41, null, ComposableLambdaKt.rememberComposableLambda(-14338077, true, new GroupManageScreenKt$UpdateManagerOverlay$2$5(r38), r14, 54), r14, (200064 | MutableTransitionState.$stable) | r11, 16);
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

    public static final void a(final String r49, final d r50, final String r51, final com.ss.android.lark.compose.chatsetting.common.platform.a r52, final com.ss.android.lark.compose.chatsetting.common.platform.b r53, Function0<Unit> r54, Function0<Unit> r55, Composer r56, final int r57, final int r58) {
        Intrinsics.checkNotNullParameter(r49, "chatId");
        Intrinsics.checkNotNullParameter(r50, "rustClient");
        Intrinsics.checkNotNullParameter(r51, "currentUserId");
        Intrinsics.checkNotNullParameter(r52, "childScreenHost");
        Intrinsics.checkNotNullParameter(r53, "platformEffects");
        Composer r9 = r56.startRestartGroup(-33615161);
        if ((r58 & 1) == 0) goto L6;
        int r1 = r57 | 6;
    L14:
        if ((r58 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r58 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r58 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L47:
        if ((r58 & 16) == 0) goto L50;
        r1 = r1 | 24576;
    L59:
        int r3 = r58 & 32;
        if (r3 == 0) goto L63;
        r1 = r1 | 196608;
    L69:
        Function0<Unit> r5 = r54;
    L71:
        if ((r57 & 1572864) != 0) goto L79;
        Function0<Unit> r6 = r55;
        if ((r58 & 64) == 0) goto L75;
    L77:
        int r18 = 524288;
    L78:
        r1 = r1 | r18;
    L81:
        if ((r1 & 599187) == 599186) goto L83;
    L86:
        r9.startDefaults();
        if ((r57 & 1) != 0) goto L89;
    L96:
        if (r3 == 0) goto L101;
        r9.startReplaceGroup(1849434622);
        Object r4 = r9.rememberedValue();
        if (r4 != Composer.Companion.getEmpty()) goto L100;
        r4 = GroupManageScreenKt$GroupManageScreen$1$1.INSTANCE;
        r9.updateRememberedValue(r4);
    L100:
        Function0<Unit> r7 = (Function0) r4;
        r9.endReplaceGroup();
    L103:
        if ((r58 & 64) == 0) goto L105;
        int r8 = r1 & (-3670017);
        Function0<Unit> r10 = r7;
        Function0<Unit> r11 = r10;
    L106:
        r9.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L109;
        ComposerKt.traceEventStart(-33615161, r8, -1, "com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageScreen (GroupManageScreen.kt:91)");
    L109:
        r9.startReplaceGroup(-1224400529);
        if ((r8 & 14) != 4) goto L112;
        boolean r2 = true;
    L114:
        if ((r8 & 896) != 256) goto L116;
        boolean r0 = true;
    L117:
        boolean r12 = (r0 | r2) | r9.changedInstance(r50);
        int r13 = r8 & 57344;
        if (r13 != 16384) goto L120;
    L125:
        boolean r19 = true;
    L126:
        boolean r14 = r12 | r19;
        Object r15 = r9.rememberedValue();
        if (r14 == false) goto L129;
    L130:
        r15 = new GroupManageScreenKt$GroupManageScreen$viewModel$1$1(r49, r51, r50, r53);
        r9.updateRememberedValue(r15);
    L131:
        Function1 r16 = (Function1) r15;
        r9.endReplaceGroup();
        Function0<Unit> r59 = r11;
        HasDefaultViewModelProviderFactory r17 = LocalViewModelStoreOwner.INSTANCE.getCurrent(r9, 6);
        if (r17 == null) goto L301;
        KClass r21 = Reflection.getOrCreateKotlinClass(GroupManageViewModel.class);
        InitializerViewModelFactoryBuilder r20 = new InitializerViewModelFactoryBuilder();
        r20.addInitializer(Reflection.getOrCreateKotlinClass(GroupManageViewModel.class), r16);
        ViewModelProvider.Factory r22 = r20.build();
        if ((r17 instanceof HasDefaultViewModelProviderFactory) == false) goto L136;
        CreationExtras r23 = r17.getDefaultViewModelCreationExtras();
    L137:
        int r39 = r8;
        Function0<Unit> r41 = r10;
        final GroupManageViewModel r24 = (GroupManageViewModel) ViewModelKt.viewModel(r21, r17, null, r22, r23, r9, 0, 0);
        Unit r25 = Unit.INSTANCE;
        r9.startReplaceGroup(-1633490746);
        boolean r26 = r9.changedInstance(r24);
        if ((458752 & r39) != 131072) goto L140;
        boolean r27 = true;
    L141:
        boolean r28 = r26 | r27;
        Object r29 = r9.rememberedValue();
        if (r28 == false) goto L144;
    L145:
        r29 = new GroupManageScreenKt$GroupManageScreen$2$1(r24, r59, null);
        r9.updateRememberedValue(r29);
    L146:
        r9.endReplaceGroup();
        EffectsKt.LaunchedEffect(r25, (Function2) r29, r9, 6);
        r9.startReplaceGroup(1849434622);
        Object r30 = r9.rememberedValue();
        Composer.Companion r37 = Composer.Companion;
        if (r30 != r37.getEmpty()) goto L149;
        int r31 = 2;
        r30 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r9.updateRememberedValue(r30);
    L150:
        final MutableState r32 = (MutableState) r30;
        r9.endReplaceGroup();
        r9.startReplaceGroup(1849434622);
        Object r33 = r9.rememberedValue();
        if (r33 != r37.getEmpty()) goto L153;
        r33 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, r31, null);
        r9.updateRememberedValue(r33);
    L153:
        final MutableState r34 = (MutableState) r33;
        r9.endReplaceGroup();
        r9.startReplaceGroup(1849434622);
        Object r35 = r9.rememberedValue();
        if (r35 != r37.getEmpty()) goto L156;
        r35 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, r31, null);
        r9.updateRememberedValue(r35);
    L156:
        final MutableState r110 = (MutableState) r35;
        r9.endReplaceGroup();
        r9.startReplaceGroup(1849434622);
        Object r36 = r9.rememberedValue();
        if (r36 != r37.getEmpty()) goto L159;
        r36 = new MutableTransitionState(Boolean.FALSE);
        r9.updateRememberedValue(r36);
    L159:
        MutableTransitionState r38 = (MutableTransitionState) r36;
        r9.endReplaceGroup();
        r9.startReplaceGroup(1849434622);
        Object r40 = r9.rememberedValue();
        if (r40 != r37.getEmpty()) goto L162;
        MutableState r42 = SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        r9.updateRememberedValue(r42);
        r40 = r42;
    L162:
        MutableState r43 = (MutableState) r40;
        r9.endReplaceGroup();
        Boolean r44 = Boolean.valueOf(((Boolean) r32.getValue()).booleanValue());
        r9.startReplaceGroup(-1746271574);
        boolean r45 = r9.changedInstance(r38);
        Object r46 = r9.rememberedValue();
        if (r45 == false) goto L165;
    L168:
        r46 = new GroupManageScreenKt$GroupManageScreen$3$1(r38, r32, r43, null);
        r9.updateRememberedValue(r46);
    L169:
        r9.endReplaceGroup();
        EffectsKt.LaunchedEffect(r44, (Function2) r46, r9, 0);
        r9.startReplaceGroup(1849434622);
        Object r47 = r9.rememberedValue();
        if (r47 != r37.getEmpty()) goto L172;
        r47 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r9.updateRememberedValue(r47);
    L172:
        MutableState r48 = (MutableState) r47;
        r9.endReplaceGroup();
        r9.startReplaceGroup(1849434622);
        Object r60 = r9.rememberedValue();
        if (r60 != r37.getEmpty()) goto L175;
        r60 = new MutableTransitionState(Boolean.FALSE);
        r9.updateRememberedValue(r60);
    L175:
        MutableTransitionState r61 = (MutableTransitionState) r60;
        r9.endReplaceGroup();
        r9.startReplaceGroup(1849434622);
        Object r62 = r9.rememberedValue();
        if (r62 != r37.getEmpty()) goto L179;
        r62 = SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        r9.updateRememberedValue(r62);
    L179:
        final MutableState r63 = (MutableState) r62;
        r9.endReplaceGroup();
        Boolean r64 = Boolean.valueOf(((Boolean) r48.getValue()).booleanValue());
        r9.startReplaceGroup(-1746271574);
        boolean r65 = r9.changedInstance(r61);
        Object r66 = r9.rememberedValue();
        if (r65 == false) goto L182;
    L185:
        r66 = new GroupManageScreenKt$GroupManageScreen$4$1(r61, r48, r63, null);
        r9.updateRememberedValue(r66);
    L186:
        r9.endReplaceGroup();
        EffectsKt.LaunchedEffect(r64, (Function2) r66, r9, 0);
        Modifier.Companion r67 = Modifier.Companion;
        Modifier r68 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(r67, 0.0f, 1, null), n.a(r9, 0).c.f, null, 2, null);
        Alignment.Companion r69 = Alignment.Companion;
        MeasurePolicy r70 = BoxKt.maybeCachedBoxMeasurePolicy(r69.getTopStart(), false);
        long r210 = ComposablesKt.getCurrentCompositeKeyHashCode(r9, 0);
        int r71 = (int) (r210 ^ (r210 >>> 32));
        CompositionLocalMap r72 = r9.getCurrentCompositionLocalMap();
        Modifier r73 = ComposedModifierKt.materializeModifier(r9, r68);
        ComposeUiNode.Companion r211 = ComposeUiNode.Companion;
        Function0 r74 = r211.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L189;
        ComposablesKt.invalidApplier();
    L189:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L192;
        r9.createNode(r74);
    L193:
        Composer r75 = Updater.constructor-impl(r9);
        Updater.set-impl(r75, r70, r211.getSetMeasurePolicy());
        Updater.set-impl(r75, r72, r211.getSetResolvedCompositionLocals());
        Function2 r76 = r211.getSetCompositeKeyHash();
        if (r75.getInserting() == false) goto L196;
    L197:
        r75.updateRememberedValue(Integer.valueOf(r71));
        r75.apply(Integer.valueOf(r71), r76);
    L198:
        Updater.set-impl(r75, r73, r211.getSetModifier());
        BoxScopeInstance r77 = BoxScopeInstance.INSTANCE;
        final Context r78 = d8b.b.a(r9);
        if (r24.isOwner() == false) goto L213;
        Chat r79 = r24.getChat();
        if (r79 == null) goto L210;
        Integer r80 = r79.getUser_count();
        if (r80 == null) goto L210;
        if (r80.intValue() > 1) goto L207;
        boolean r81 = true;
    L208:
        if (r81 != true) goto L210;
        boolean r82 = true;
    L211:
        if (r82 == false) goto L213;
        boolean r212 = true;
    L214:
        Modifier r83 = SizeKt.fillMaxSize$default(r67, 0.0f, 1, null);
        MeasurePolicy r84 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), r69.getStart(), r9, 0);
        long r213 = ComposablesKt.getCurrentCompositeKeyHashCode(r9, 0);
        int r85 = (int) (r213 ^ (r213 >>> 32));
        CompositionLocalMap r86 = r9.getCurrentCompositionLocalMap();
        Modifier r87 = ComposedModifierKt.materializeModifier(r9, r83);
        Function0 r88 = r211.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L217;
        ComposablesKt.invalidApplier();
    L217:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L220;
        r9.createNode(r88);
    L221:
        Composer r89 = Updater.constructor-impl(r9);
        Updater.set-impl(r89, r84, r211.getSetMeasurePolicy());
        Updater.set-impl(r89, r86, r211.getSetResolvedCompositionLocals());
        Function2 r90 = r211.getSetCompositeKeyHash();
        if (r89.getInserting() == false) goto L224;
    L225:
        r89.updateRememberedValue(Integer.valueOf(r85));
        r89.apply(Integer.valueOf(r85), r90);
    L226:
        Updater.set-impl(r89, r87, r211.getSetModifier());
        ColumnScopeInstance r91 = ColumnScopeInstance.INSTANCE;
        com.ss.android.lark.flow.chat.resources.b r92 = com.ss.android.lark.flow.chat.resources.b.a;
        Intrinsics.checkNotNullParameter(r92, "<this>");
        boolean r410 = false;
        b(b0.a((z) CommonMainString0.Z.getValue(), r9), r59, WindowInsetsPaddingKt.windowInsetsPadding(r67, WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, r9, 6)), r9, (r39 >> 12) & 112, 0);
        final boolean r93 = r212;
        SettingGroupContainerKt.a(null, ComposableLambdaKt.rememberComposableLambda(-2055734091, true, new GroupManageScreenKt$GroupManageScreen$5$1$1(r24, r78, r93, r34, r32), r9, 54), r9, 48, 1);
        r9.startReplaceGroup(1358366390);
        if (r24.isOwner() == false) goto L229;
        final Context r510 = r78;
        final MutableState r310 = r48;
        int r411 = r13;
        final boolean r94 = r212;
        SettingGroupContainerKt.a(null, ComposableLambdaKt.rememberComposableLambda(1188920762, true, new GroupManageScreenKt$GroupManageScreen$5$1$2(r24, r510, r50, r94, r110, r310), r9, 54), r9, 48, 1);
    L230:
        r9.endReplaceGroup();
        r9.endNode();
        r9.startReplaceGroup(-1997083591);
        if (((Boolean) r34.getValue()).booleanValue() == false) goto L240;
        com.ss.android.lark.flow.chat.resources.b r95 = r92;
        Intrinsics.checkNotNullParameter(r95, "<this>");
        String r111 = b0.a((z) CommonMainString0.b0.getValue(), r9);
        Intrinsics.checkNotNullParameter(r95, "<this>");
        String r112 = b0.a((z) CommonMainString0.g.getValue(), r9);
        r9.startReplaceGroup(5004770);
        Object r96 = r9.rememberedValue();
        if (r96 != r37.getEmpty()) goto L235;
        final MutableState r97 = r34;
        r96 = new GroupManageScreenKt$GroupManageScreen$5$2$1(r97);
        r9.updateRememberedValue(r96);
    L236:
        Function0 r214 = (Function0) r96;
        r9.endReplaceGroup();
        r9.startReplaceGroup(5004770);
        Object r98 = r9.rememberedValue();
        if (r98 != r37.getEmpty()) goto L239;
        r98 = new GroupManageScreenKt$GroupManageScreen$5$3$1(r97);
        r9.updateRememberedValue(r98);
    L239:
        r9.endReplaceGroup();
        FlowAlertDialogKt.a(r111, "群内已无其他成员，无法转让", r112, null, 0, 0, r214, null, (Function0) r98, true, true, r9, 907542576, 6, 184);
    L241:
        r9.endReplaceGroup();
        r9.startReplaceGroup(-1997062045);
        if (((Boolean) r110.getValue()).booleanValue() == false) goto L250;
        Intrinsics.checkNotNullParameter(r95, "<this>");
        String r113 = b0.a((z) CommonMainString0.F0.getValue(), r9);
        Intrinsics.checkNotNullParameter(r95, "<this>");
        String r114 = b0.a((z) CommonMainString0.g.getValue(), r9);
        r9.startReplaceGroup(5004770);
        Object r99 = r9.rememberedValue();
        if (r99 != r37.getEmpty()) goto L246;
        r99 = new GroupManageScreenKt$GroupManageScreen$5$4$1(r110);
        r9.updateRememberedValue(r99);
    L246:
        Function0 r215 = (Function0) r99;
        r9.endReplaceGroup();
        r9.startReplaceGroup(5004770);
        Object r100 = r9.rememberedValue();
        if (r100 != r37.getEmpty()) goto L249;
        r100 = new GroupManageScreenKt$GroupManageScreen$5$5$1(r110);
        r9.updateRememberedValue(r100);
    L249:
        r9.endReplaceGroup();
        FlowAlertDialogKt.a(r113, "群内已无其他成员，无法设置群管理员", r114, null, 0, 0, r215, null, (Function0) r100, true, true, r9, 907542576, 6, 184);
    L250:
        r9.endReplaceGroup();
        r9.startReplaceGroup(-1997040241);
        if (((Boolean) r38.getCurrentState()).booleanValue() == false) goto L253;
    L256:
        Intrinsics.checkNotNullParameter(r95, "<this>");
        final String r101 = b0.a((z) CommonMainString0.s0.getValue(), r9);
        Intrinsics.checkNotNullParameter(r95, "<this>");
        final String r102 = b0.a((z) CommonMainString0.r0.getValue(), r9);
        r9.startReplaceGroup(5004770);
        Object r103 = r9.rememberedValue();
        if (r103 != r37.getEmpty()) goto L259;
        r103 = new GroupManageScreenKt$GroupManageScreen$5$6$1(r32);
        r9.updateRememberedValue(r103);
    L259:
        Function0 r104 = (Function0) r103;
        r9.endReplaceGroup();
        r9.startReplaceGroup(-1224400529);
        final Context r105 = r510;
        boolean r106 = r9.changedInstance(r24) | r9.changedInstance(r105);
        int r115 = r411;
        int r116 = r39;
        if (r115 != 16384) goto L262;
    L267:
        boolean r107 = true;
    L268:
        boolean r108 = (r106 | r107) | r9.changed(r101);
        final Function0<Unit> r109 = r41;
        if (((3670016 & r116) ^ 1572864) <= 1048576) goto L273;
        if (r9.changed(r109) == false) goto L273;
    L274:
        r410 = true;
    L275:
        boolean r117 = (r108 | r410) | r9.changed(r102);
        Object r118 = r9.rememberedValue();
        if (r117 == false) goto L278;
    L281:
        Function1<String, Unit> r119 = new GroupManageScreenKt$GroupManageScreen$5$7$1(r24, r105, r53, r101, r109, r102);
        r9.updateRememberedValue(r119);
        r118 = r119;
    L282:
        r9.endReplaceGroup();
        int r120 = r116 << 3;
        c(r38, r49, r50, r52, r53, r104, (Function1) r118, String.valueOf(((Number) r43.getValue()).intValue()), r9, r115 | ((((MutableTransitionState.$stable | 196608) | (r120 & 112)) | (r120 & 896)) | (r116 & 7168)));
    L283:
        r9.endReplaceGroup();
        Composer r121 = r9;
        r121.startReplaceGroup(-1996989837);
        if (((Boolean) r61.getCurrentState()).booleanValue() == false) goto L286;
    L287:
        r121.startReplaceGroup(5004770);
        Object r122 = r121.rememberedValue();
        if (r122 != r37.getEmpty()) goto L290;
        final MutableState r123 = r310;
        r122 = new GroupManageScreenKt$GroupManageScreen$5$8$1(r123);
        r121.updateRememberedValue(r122);
    L291:
        r121.endReplaceGroup();
        d(r61, (Function0) r122, r52, ComposableLambdaKt.rememberComposableLambda(1366935249, true, new GroupManageScreenKt$GroupManageScreen$5$9(r49, r50, r52, r53, r24, r63, r123), r121, 54), r121, (MutableTransitionState.$stable | 3120) | ((r116 >> 3) & 896));
    L292:
        r121.endReplaceGroup();
        r121.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L295;
        ComposerKt.traceEventEnd();
    L295:
        final Function0<Unit> r124 = r109;
        final Function0<Unit> r125 = r59;
    L296:
        ScopeUpdateScope r126 = r121.endRestartGroup();
        if (r126 == null) goto L302;
        r126.updateScope(new GroupManageScreenKt$GroupManageScreen$6(r49, r50, r51, r52, r53, r125, r124, r57, r58));
        return;
    L302:
        return;
    L290:
        r123 = r310;
        goto L291
    L286:
        if (((Boolean) r61.getTargetState()).booleanValue() == false) goto L292;
    L278:
        if (r118 != r37.getEmpty()) goto L282;
    L273:
        if ((r116 & 1572864) != 1048576) goto L275;
    L262:
        if ((r116 & 32768) != 0) goto L264;
    L266:
        r107 = false;
        goto L268
    L264:
        if (r9.changedInstance(r53) == false) goto L266;
    L253:
        if (((Boolean) r38.getTargetState()).booleanValue() == true) goto L256;
        r109 = r41;
        r116 = r39;
        goto L283
    L235:
        r97 = r34;
        goto L236
    L240:
        r95 = r92;
        goto L241
    L229:
        r510 = r78;
        r411 = r13;
        r310 = r48;
        goto L230
    L224:
        if (Intrinsics.areEqual(r89.rememberedValue(), Integer.valueOf(r85)) == true) goto L226;
    L220:
        r9.useNode();
        goto L221
    L207:
        r81 = false;
    L210:
        r82 = false;
    L213:
        r212 = false;
        goto L214
    L196:
        if (Intrinsics.areEqual(r75.rememberedValue(), Integer.valueOf(r71)) == true) goto L198;
    L192:
        r9.useNode();
        goto L193
    L182:
        if (r66 != r37.getEmpty()) goto L186;
    L165:
        if (r46 != r37.getEmpty()) goto L169;
    L149:
        r31 = 2;
        goto L150
    L144:
        if (r29 != Composer.Companion.getEmpty()) goto L146;
    L140:
        r27 = false;
        goto L141
    L136:
        r23 = CreationExtras.Empty.INSTANCE;
        goto L137
    L301:
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    L129:
        if (r15 != Composer.Companion.getEmpty()) goto L131;
    L120:
        if ((r8 & 32768) != 0) goto L122;
    L124:
        r19 = false;
        goto L126
    L122:
        if (r9.changedInstance(r53) == false) goto L124;
    L116:
        r0 = false;
        goto L117
    L112:
        r2 = false;
        goto L114
    L105:
        r11 = r7;
    L95:
        r10 = r6;
        r8 = r1;
        goto L106
    L101:
        r7 = r5;
        goto L103
    L89:
        if (r9.getDefaultsInvalid() == true) goto L96;
        r9.skipToGroupEnd();
        if ((r58 & 64) == 0) goto L94;
        r1 = r1 & (-3670017);
    L94:
        r11 = r5;
        goto L95
    L83:
        if (r9.getSkipping() == false) goto L86;
        r9.skipToGroupEnd();
        r124 = r6;
        r121 = r9;
        r125 = r5;
        goto L296
    L75:
        if (r9.changedInstance(r6) == false) goto L77;
        r18 = 1048576;
        goto L78
    L79:
        r6 = r55;
        goto L81
    L63:
        if ((r57 & 196608) != 0) goto L69;
        r5 = r54;
        if (r9.changedInstance(r5) == false) goto L67;
        int r127 = 131072;
    L68:
        r1 = r1 | r127;
        goto L71
    L67:
        r127 = 65536;
        goto L68
    L50:
        if ((r57 & 24576) != 0) goto L59;
        if ((r57 & 32768) != 0) goto L54;
        boolean r128 = r9.changed(r53);
    L55:
        if (r128 == false) goto L57;
        int r129 = 16384;
    L58:
        r1 = r1 | r129;
        goto L59
    L57:
        r129 = 8192;
        goto L58
    L54:
        r128 = r9.changedInstance(r53);
        goto L55
    L37:
        if ((r57 & 3072) != 0) goto L47;
        if ((r57 & 4096) != 0) goto L41;
        boolean r130 = r9.changed(r52);
    L42:
        if (r130 == false) goto L44;
        int r131 = 2048;
    L45:
        r1 = r1 | r131;
        goto L47
    L44:
        r131 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L45
    L41:
        r130 = r9.changedInstance(r52);
        goto L42
    L27:
        if ((r57 & 384) != 0) goto L34;
        if (r9.changed(r51) == false) goto L31;
        int r132 = 256;
    L32:
        r1 = r1 | r132;
        goto L34
    L31:
        r132 = 128;
        goto L32
    L17:
        if ((r57 & 48) != 0) goto L24;
        if (r9.changedInstance(r50) == false) goto L21;
        int r133 = 32;
    L22:
        r1 = r1 | r133;
        goto L24
    L21:
        r133 = 16;
        goto L22
    L6:
        if ((r57 & 6) == 0) goto L8;
        r1 = r57;
        goto L14
    L8:
        if (r9.changed(r49) == false) goto L10;
        int r134 = 4;
    L11:
        r1 = r134 | r57;
        goto L14
    L10:
        r134 = 2;
        goto L11
    }

    public static final void c(final MutableTransitionState<Boolean> r34, final String r35, final d r36, final com.ss.android.lark.compose.chatsetting.common.platform.a r37, final com.ss.android.lark.compose.chatsetting.common.platform.b r38, final Function0<Unit> r39, final Function1<? super String, Unit> r40, final String r41, Composer r42, final int r43) {
        Intrinsics.checkNotNullParameter(r34, "visibleState");
        Intrinsics.checkNotNullParameter(r35, "chatId");
        Intrinsics.checkNotNullParameter(r36, "rustClient");
        Intrinsics.checkNotNullParameter(r37, "childScreenHost");
        Intrinsics.checkNotNullParameter(r38, "platformEffects");
        Intrinsics.checkNotNullParameter(r39, "onDismiss");
        Intrinsics.checkNotNullParameter(r40, "onTransferOwner");
        Intrinsics.checkNotNullParameter(r41, "instanceKey");
        Composer r6 = r42.startRestartGroup(-1004599276);
        if ((r43 & 6) == 0) goto L5;
        int r1 = r43;
    L14:
        if ((r43 & 48) != 0) goto L21;
        if (r6.changed(r35) == false) goto L18;
        int r3 = 32;
    L19:
        r1 = r1 | r3;
        goto L21
    L18:
        r3 = 16;
    L21:
        if ((r43 & 384) != 0) goto L28;
        if (r6.changedInstance(r36) == false) goto L25;
        int r4 = 256;
    L26:
        r1 = r1 | r4;
        goto L28
    L25:
        r4 = 128;
    L28:
        if ((r43 & 3072) != 0) goto L38;
        if ((r43 & 4096) != 0) goto L32;
        boolean r5 = r6.changed(r37);
    L33:
        if (r5 == false) goto L35;
        int r7 = 2048;
    L36:
        r1 = r1 | r7;
        goto L38
    L35:
        r7 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L36
    L32:
        r5 = r6.changedInstance(r37);
    L38:
        if ((r43 & 24576) != 0) goto L48;
        if ((32768 & r43) != 0) goto L42;
        boolean r8 = r6.changed(r38);
    L43:
        if (r8 == false) goto L45;
        int r9 = 16384;
    L46:
        r1 = r1 | r9;
        goto L48
    L45:
        r9 = 8192;
        goto L46
    L42:
        r8 = r6.changedInstance(r38);
    L48:
        if ((196608 & r43) != 0) goto L55;
        if (r6.changedInstance(r39) == false) goto L52;
        int r10 = 131072;
    L53:
        r1 = r1 | r10;
        goto L55
    L52:
        r10 = 65536;
    L55:
        if ((1572864 & r43) != 0) goto L62;
        if (r6.changedInstance(r40) == false) goto L59;
        int r11 = 1048576;
    L60:
        r1 = r1 | r11;
        goto L62
    L59:
        r11 = 524288;
    L62:
        if ((12582912 & r43) != 0) goto L69;
        if (r6.changed(r41) == false) goto L66;
        int r12 = 8388608;
    L67:
        r1 = r1 | r12;
        goto L69
    L66:
        r12 = 4194304;
    L69:
        if ((4793491 & r1) != 4793490) goto L75;
        if (r6.getSkipping() == false) goto L75;
        r6.skipToGroupEnd();
        Composer r13 = r6;
    L150:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L154;
        r14.updateScope(new GroupManageScreenKt$TransferOwnerOverlay$3(r34, r35, r36, r37, r38, r39, r40, r41, r43));
        return;
    L154:
        return;
    L75:
        if (ComposerKt.isTraceInProgress() == false) goto L77;
        ComposerKt.traceEventStart(-1004599276, r1, -1, "com.ss.android.lark.compose.chatsetting.groupmanage.TransferOwnerOverlay (GroupManageScreen.kt:360)");
    L77:
        r6.startReplaceGroup(1849434622);
        Object r15 = r6.rememberedValue();
        Composer.Companion r16 = Composer.Companion;
        if (r15 != r16.getEmpty()) goto L80;
        r15 = new FocusRequester();
        r6.updateRememberedValue(r15);
    L80:
        FocusRequester r17 = (FocusRequester) r15;
        r6.endReplaceGroup();
        Object r0 = r34.getTargetState();
        r6.startReplaceGroup(-1633490746);
        int r18 = r1 & 14;
        if (r18 != 4) goto L83;
    L88:
        boolean r2 = true;
    L89:
        Object r19 = r6.rememberedValue();
        if (r2 == false) goto L92;
    L93:
        r19 = new GroupManageScreenKt$TransferOwnerOverlay$1$1(r34, r17, null);
        r6.updateRememberedValue(r19);
    L94:
        r6.endReplaceGroup();
        EffectsKt.LaunchedEffect(r0, (Function2) r19, r6, 0);
        r6.startReplaceGroup(-1633490746);
        if ((458752 & r1) != 131072) goto L97;
        boolean r20 = true;
    L99:
        if ((r1 & 7168) != 2048) goto L101;
    L106:
        boolean r21 = true;
    L107:
        boolean r22 = r20 | r21;
        Object r23 = r6.rememberedValue();
        if (r22 == false) goto L110;
    L111:
        r23 = new GroupManageScreenKt$TransferOwnerOverlay$onBackWithKeyboardHandling$1$1(r37, r39);
        r6.updateRememberedValue(r23);
    L112:
        final Function0 r24 = (Function0) r23;
        r6.endReplaceGroup();
        Modifier.Companion r25 = Modifier.Companion;
        Modifier r26 = FocusableKt.focusable$default(FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxSize$default(r25, 0.0f, 1, null), r17), false, null, 3, null);
        if (((Boolean) r34.getCurrentState()).booleanValue() == false) goto L115;
    L118:
        boolean r27 = true;
    L119:
        Modifier r28 = r26.then(r37.a(r27, r39));
        Alignment.Companion r29 = Alignment.Companion;
        MeasurePolicy r30 = BoxKt.maybeCachedBoxMeasurePolicy(r29.getTopStart(), false);
        long r110 = ComposablesKt.getCurrentCompositeKeyHashCode(r6, 0);
        int r31 = (int) (r110 ^ (r110 >>> 32));
        CompositionLocalMap r32 = r6.getCurrentCompositionLocalMap();
        Modifier r33 = ComposedModifierKt.materializeModifier(r6, r28);
        ComposeUiNode.Companion r111 = ComposeUiNode.Companion;
        Function0 r44 = r111.getConstructor();
        if ((r6.getApplier() instanceof Applier) == true) goto L122;
        ComposablesKt.invalidApplier();
    L122:
        r6.startReusableNode();
        if (r6.getInserting() == false) goto L125;
        r6.createNode(r44);
    L126:
        Composer r45 = Updater.constructor-impl(r6);
        Updater.set-impl(r45, r30, r111.getSetMeasurePolicy());
        Updater.set-impl(r45, r32, r111.getSetResolvedCompositionLocals());
        Function2 r46 = r111.getSetCompositeKeyHash();
        if (r45.getInserting() == false) goto L129;
    L130:
        r45.updateRememberedValue(Integer.valueOf(r31));
        r45.apply(Integer.valueOf(r31), r46);
    L131:
        Updater.set-impl(r45, r33, r111.getSetModifier());
        BoxScopeInstance r47 = BoxScopeInstance.INSTANCE;
        if (((Boolean) r34.getTargetState()).booleanValue() == false) goto L134;
        float r112 = 0.4f;
    L135:
        State r48 = AnimateAsStateKt.animateFloatAsState(r112, null, 0.0f, "transfer_owner_scrim_alpha", null, r6, 3072, 22);
        Modifier r210 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(r25, 0.0f, 1, null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), ((Number) r48.getValue()).floatValue(), 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
        r6.startReplaceGroup(1849434622);
        Object r49 = r6.rememberedValue();
        if (r49 != r16.getEmpty()) goto L138;
        r49 = InteractionSourceKt.MutableInteractionSource();
        r6.updateRememberedValue(r49);
    L138:
        MutableInteractionSource r211 = (MutableInteractionSource) r49;
        r6.endReplaceGroup();
        r6.startReplaceGroup(1849434622);
        Object r50 = r6.rememberedValue();
        if (r50 != r16.getEmpty()) goto L141;
        r50 = GroupManageScreenKt$TransferOwnerOverlay$2$2$1.INSTANCE;
        r6.updateRememberedValue(r50);
    L141:
        r6.endReplaceGroup();
        BoxKt.Box(ClickableKt.clickable-O2vRcR0$default(r210, r211, null, false, null, null, (Function0) r50, 28, null), r6, 0);
        r6.startReplaceGroup(1849434622);
        Object r51 = r6.rememberedValue();
        if (r51 != r16.getEmpty()) goto L144;
        r51 = GroupManageScreenKt$TransferOwnerOverlay$2$3$1.INSTANCE;
        r6.updateRememberedValue(r51);
    L144:
        r6.endReplaceGroup();
        EnterTransition r52 = EnterExitTransitionKt.slideInVertically$default(null, (Function1) r51, 1, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
        r6.startReplaceGroup(1849434622);
        Object r53 = r6.rememberedValue();
        if (r53 != r16.getEmpty()) goto L147;
        r53 = GroupManageScreenKt$TransferOwnerOverlay$2$4$1.INSTANCE;
        r6.updateRememberedValue(r53);
    L147:
        r6.endReplaceGroup();
        ExitTransition r113 = EnterExitTransitionKt.slideOutVertically$default(null, (Function1) r53, 1, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
        r13 = r6;
        AnimatedVisibilityKt.AnimatedVisibility(r34, r47.align(r25, r29.getBottomCenter()), r52, r113, null, ComposableLambdaKt.rememberComposableLambda(1119895542, true, new GroupManageScreenKt$TransferOwnerOverlay$2$5(r35, r41, r36, r38, r24, r40), r6, 54), r6, (200064 | MutableTransitionState.$stable) | r18, 16);
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L150;
        ComposerKt.traceEventEnd();
        goto L150
    L134:
        r112 = 0.0f;
        goto L135
    L129:
        if (Intrinsics.areEqual(r45.rememberedValue(), Integer.valueOf(r31)) == true) goto L131;
    L125:
        r6.useNode();
        goto L126
    L115:
        if (((Boolean) r34.getTargetState()).booleanValue() == true) goto L118;
        r27 = false;
        goto L119
    L110:
        if (r23 != r16.getEmpty()) goto L112;
    L101:
        if ((r1 & 4096) != 0) goto L103;
    L105:
        r21 = false;
        goto L107
    L103:
        if (r6.changed(r37) == false) goto L105;
    L97:
        r20 = false;
        goto L99
    L92:
        if (r19 != r16.getEmpty()) goto L94;
    L83:
        if ((r1 & 8) != 0) goto L85;
    L87:
        r2 = false;
        goto L89
    L85:
        if (r6.changedInstance(r34) == false) goto L87;
    L5:
        if ((r43 & 8) != 0) goto L7;
        boolean r54 = r6.changed(r34);
    L8:
        if (r54 == false) goto L10;
        int r55 = 4;
    L11:
        r1 = r55 | r43;
        goto L14
    L10:
        r55 = 2;
        goto L11
    L7:
        r54 = r6.changedInstance(r34);
        goto L8
    }

    public static final void e(Modifier r62, final String r63, final String r64, final List r65, Function1 r66, final d r67, Function0 r68, Composer r69, final int r70, final int r71) {
        Composer r1 = r69.startRestartGroup(-1830015342);
        int r2 = r71 & 1;
        if (r2 == 0) goto L6;
        int r7 = r70 | 6;
        Modifier r5 = r62;
    L14:
        if ((r71 & 2) == 0) goto L17;
        r7 = r7 | 48;
    L25:
        if ((r71 & 4) == 0) goto L28;
        r7 = r7 | 384;
    L35:
        if ((r71 & 8) == 0) goto L38;
        r7 = r7 | 3072;
    L44:
        int r12 = r71 & 16;
        if (r12 == 0) goto L48;
        r7 = r7 | 24576;
    L54:
        Function1 r13 = r66;
    L56:
        if ((r71 & 32) == 0) goto L59;
        r7 = r7 | 196608;
    L65:
        int r15 = r71 & 64;
        if (r15 == 0) goto L68;
        r7 = r7 | 1572864;
        Function0 r3 = r68;
    L76:
        if ((r7 & 599187) == 599186) goto L78;
    L81:
        if (r2 == 0) goto L83;
        Modifier r4 = Modifier.Companion;
    L85:
        if (r12 == 0) goto L90;
        r1.startReplaceGroup(1849434622);
        Object r10 = r1.rememberedValue();
        if (r10 != Composer.Companion.getEmpty()) goto L89;
        r10 = GroupManageScreenKt$GroupManageMembersItem$1$1.INSTANCE;
        r1.updateRememberedValue(r10);
    L89:
        r1.endReplaceGroup();
        r13 = (Function1) r10;
    L90:
        if (r15 == 0) goto L96;
        r1.startReplaceGroup(1849434622);
        Object r6 = r1.rememberedValue();
        if (r6 != Composer.Companion.getEmpty()) goto L94;
        r6 = GroupManageScreenKt$GroupManageMembersItem$2$1.INSTANCE;
        r1.updateRememberedValue(r6);
    L94:
        r3 = (Function0) r6;
        r1.endReplaceGroup();
    L96:
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventStart(-1830015342, r7, -1, "com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageMembersItem (GroupManageScreen.kt:498)");
    L98:
        float r11 = 12;
        Modifier r14 = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(SizeKt.fillMaxWidth$default(r4, 0.0f, 1, null), false, null, null, null, r3, 15, null), 0.0f, Dp.constructor-impl(r11), 1, null);
        Arrangement r16 = Arrangement.INSTANCE;
        Arrangement.Vertical r0 = r16.getTop();
        Alignment.Companion r18 = Alignment.Companion;
        MeasurePolicy r8 = ColumnKt.columnMeasurePolicy(r0, r18.getStart(), r1, 0);
        long r19 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r17 = (int) (r19 ^ (r19 >>> 32));
        CompositionLocalMap r110 = r1.getCurrentCompositionLocalMap();
        Modifier r111 = ComposedModifierKt.materializeModifier(r1, r14);
        ComposeUiNode.Companion r112 = ComposeUiNode.Companion;
        Function0 r9 = r112.getConstructor();
        Modifier r61 = r4;
        if ((r1.getApplier() instanceof Applier) == true) goto L101;
        ComposablesKt.invalidApplier();
    L101:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L104;
        r1.createNode(r9);
    L105:
        Composer r20 = Updater.constructor-impl(r1);
        Updater.set-impl(r20, r8, r112.getSetMeasurePolicy());
        Updater.set-impl(r20, r110, r112.getSetResolvedCompositionLocals());
        Function2 r21 = r112.getSetCompositeKeyHash();
        if (r20.getInserting() == false) goto L108;
    L109:
        r20.updateRememberedValue(Integer.valueOf(r17));
        r20.apply(Integer.valueOf(r17), r21);
    L110:
        Updater.set-impl(r20, r111, r112.getSetModifier());
        ColumnScopeInstance r22 = ColumnScopeInstance.INSTANCE;
        Modifier.Companion r23 = Modifier.Companion;
        float r113 = 16;
        Function0 r610 = r3;
        Modifier r114 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(r23, 0.0f, 1, null), Dp.constructor-impl(r113), 0.0f, 2, null);
        MeasurePolicy r24 = RowKt.rowMeasurePolicy(r16.getStart(), r18.getCenterVertically(), r1, 48);
        long r115 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r25 = (int) (r115 ^ (r115 >>> 32));
        CompositionLocalMap r26 = r1.getCurrentCompositionLocalMap();
        Modifier r116 = ComposedModifierKt.materializeModifier(r1, r114);
        Function0 r117 = r112.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L113;
        ComposablesKt.invalidApplier();
    L113:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L116;
        r1.createNode(r117);
    L117:
        Composer r27 = Updater.constructor-impl(r1);
        Updater.set-impl(r27, r24, r112.getSetMeasurePolicy());
        Updater.set-impl(r27, r26, r112.getSetResolvedCompositionLocals());
        Function2 r28 = r112.getSetCompositeKeyHash();
        if (r27.getInserting() == false) goto L120;
    L121:
        r27.updateRememberedValue(Integer.valueOf(r25));
        r27.apply(Integer.valueOf(r25), r28);
    L122:
        Updater.set-impl(r27, r116, r112.getSetModifier());
        RowScopeInstance r29 = RowScopeInstance.INSTANCE;
        TextStyle r30 = n.b(r1).b;
        final Function1 r31 = r13;
        TextKt.Text-Nvy7gAk(r63, RowScope.-CC.weight$default(r29, r23, 1.0f, false, 2, null), n.a(r1, 0).d.a, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, r30, r1, (r7 >> 3) & 14, 0, 131064);
        TextKt.Text-Nvy7gAk(r64, null, n.a(r1, 0).d.b, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, n.b(r1).c, r1, (r7 >> 6) & 14, 0, 131066);
        IconKt.Icon-ww6aTOc((ImageVector) ChatSettingIcons.l.getValue(), null, SizeKt.size-3ABfNKs(r23, Dp.constructor-impl(24)), n.a(r1, 0).d.d, r1, 432, 0);
        r1.endNode();
        r1.startReplaceGroup(-2109338283);
        if ((!r65.isEmpty()) == false) goto L126;
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(r23, Dp.constructor-impl(r11)), r1, 6);
        BoxWithConstraintsKt.BoxWithConstraints(PaddingKt.padding-VpY3zN4$default(r23, Dp.constructor-impl(r113), 0.0f, 2, null), null, false, ComposableLambdaKt.rememberComposableLambda(945889977, true, new GroupManageScreenKt$GroupManageMembersItem$3$2(r65, r67, r31), r1, 54), r1, 3078, 6);
    L126:
        r1.endReplaceGroup();
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L129;
        ComposerKt.traceEventEnd();
    L129:
        Function0 r32 = r610;
        final Function1 r33 = r31;
    L130:
        ScopeUpdateScope r118 = r1.endRestartGroup();
        if (r118 == null) goto L134;
        final Modifier r34 = r61;
        final Function0 r35 = r32;
        r118.updateScope(new GroupManageScreenKt$GroupManageMembersItem$4(r34, r63, r64, r65, r33, r67, r35, r70, r71));
        return;
    L134:
        return;
    L120:
        if (Intrinsics.areEqual(r27.rememberedValue(), Integer.valueOf(r25)) == true) goto L122;
    L116:
        r1.useNode();
        goto L117
    L108:
        if (Intrinsics.areEqual(r20.rememberedValue(), Integer.valueOf(r17)) == true) goto L110;
    L104:
        r1.useNode();
        goto L105
    L83:
        r4 = r5;
        goto L85
    L78:
        if (r1.getSkipping() == false) goto L81;
        r1.skipToGroupEnd();
        r32 = r3;
        r61 = r5;
        r33 = r13;
        goto L130
    L68:
        r3 = r68;
        if ((r70 & 1572864) != 0) goto L76;
        if (r1.changedInstance(r3) == false) goto L73;
        int r119 = 1048576;
    L74:
        r7 = r7 | r119;
        goto L76
    L73:
        r119 = 524288;
        goto L74
    L59:
        if ((r70 & 196608) != 0) goto L65;
        if (r1.changedInstance(r67) == false) goto L63;
        int r120 = 131072;
    L64:
        r7 = r7 | r120;
        goto L65
    L63:
        r120 = 65536;
        goto L64
    L48:
        if ((r70 & 24576) != 0) goto L54;
        r13 = r66;
        if (r1.changedInstance(r13) == false) goto L52;
        int r121 = 16384;
    L53:
        r7 = r7 | r121;
        goto L56
    L52:
        r121 = 8192;
        goto L53
    L38:
        if ((r70 & 3072) != 0) goto L44;
        if (r1.changedInstance(r65) == false) goto L42;
        int r122 = 2048;
    L43:
        r7 = r7 | r122;
        goto L44
    L42:
        r122 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L43
    L28:
        if ((r70 & 384) != 0) goto L35;
        if (r1.changed(r64) == false) goto L32;
        int r123 = 256;
    L33:
        r7 = r7 | r123;
        goto L35
    L32:
        r123 = 128;
        goto L33
    L17:
        if ((r70 & 48) != 0) goto L25;
        if (r1.changed(r63) == false) goto L21;
        int r124 = 32;
    L22:
        r7 = r7 | r124;
        goto L25
    L21:
        r124 = 16;
        goto L22
    L6:
        if ((r70 & 6) != 0) goto L12;
        r5 = r62;
        if (r1.changed(r5) == false) goto L10;
        int r36 = 4;
    L11:
        r7 = r36 | r70;
        goto L14
    L10:
        r36 = 2;
        goto L11
    L12:
        r5 = r62;
        r7 = r70;
        goto L14
    }
}
