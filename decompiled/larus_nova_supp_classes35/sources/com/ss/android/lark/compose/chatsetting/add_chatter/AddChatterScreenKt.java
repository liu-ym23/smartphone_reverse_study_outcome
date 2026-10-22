package com.ss.android.lark.compose.chatsetting.add_chatter;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.chat_member_list.ChatMemberListComponentsKt;
import com.ss.android.lark.compose.chatterselector.ChatterSelectorScreenKt;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class AddChatterScreenKt {
    public static final void a(final String r34, final d r35, final com.ss.android.lark.compose.chatsetting.common.platform.a r36, final com.ss.android.lark.compose.chatsetting.common.platform.b r37, Function0<Unit> r38, boolean r39, Composer r40, final int r41, final int r42) {
        Intrinsics.checkNotNullParameter(r34, "chatId");
        Intrinsics.checkNotNullParameter(r35, "rustClient");
        Intrinsics.checkNotNullParameter(r36, "childScreenHost");
        Intrinsics.checkNotNullParameter(r37, "platformEffects");
        Composer r3 = r40.startRestartGroup(-1302721259);
        if ((r42 & 1) == 0) goto L6;
        int r1 = r41 | 6;
    L14:
        if ((r42 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r42 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L37:
        if ((r42 & 8) == 0) goto L40;
        r1 = r1 | 3072;
    L49:
        int r10 = r42 & 16;
        if (r10 == 0) goto L53;
        r1 = r1 | 24576;
    L59:
        Function0<Unit> r11 = r38;
    L60:
        int r12 = r42 & 32;
        if (r12 == 0) goto L64;
        r1 = r1 | 196608;
    L70:
        boolean r13 = r39;
    L72:
        if ((r1 & 74899) != 74898) goto L78;
        if (r3.getSkipping() == false) goto L78;
        r3.skipToGroupEnd();
        Composer r0 = r3;
        final Function0<Unit> r5 = r11;
        final boolean r6 = r13;
    L201:
        ScopeUpdateScope r9 = r0.endRestartGroup();
        if (r9 == null) goto L207;
        r9.updateScope(new AddChatterScreenKt$AddChatterScreen$3(r34, r35, r36, r37, r5, r6, r41, r42));
        return;
    L207:
        return;
    L78:
        if (r10 == 0) goto L80;
        Function0<Unit> r21 = null;
    L82:
        if (r12 == 0) goto L84;
        boolean r22 = true;
    L86:
        if (ComposerKt.isTraceInProgress() == false) goto L88;
        ComposerKt.traceEventStart(-1302721259, r1, -1, "com.ss.android.lark.compose.chatsetting.add_chatter.AddChatterScreen (AddChatterScreen.kt:48)");
    L88:
        r3.startReplaceGroup(-1633490746);
        int r14 = r1 & 14;
        if (r14 != 4) goto L91;
        boolean r15 = true;
    L92:
        boolean r16 = r15 | r3.changedInstance(r35);
        Object r17 = r3.rememberedValue();
        if (r16 == false) goto L95;
    L96:
        r17 = new AddChatterScreenKt$AddChatterScreen$viewModel$1$1(r34, r35);
        r3.updateRememberedValue(r17);
    L97:
        Function1 r18 = (Function1) r17;
        r3.endReplaceGroup();
        HasDefaultViewModelProviderFactory r19 = LocalViewModelStoreOwner.INSTANCE.getCurrent(r3, 6);
        if (r19 == null) goto L206;
        KClass r110 = Reflection.getOrCreateKotlinClass(AddMemberViewModel.class);
        InitializerViewModelFactoryBuilder r111 = new InitializerViewModelFactoryBuilder();
        r111.addInitializer(Reflection.getOrCreateKotlinClass(AddMemberViewModel.class), r18);
        ViewModelProvider.Factory r112 = r111.build();
        if ((r19 instanceof HasDefaultViewModelProviderFactory) == false) goto L102;
        CreationExtras r113 = r19.getDefaultViewModelCreationExtras();
    L103:
        final AddMemberViewModel r114 = (AddMemberViewModel) ViewModelKt.viewModel(r110, r19, null, r112, r113, r3, 0, 0);
        final Context r115 = d8b.b.a(r3);
        r3.startReplaceGroup(-2079631486);
        if (r21 != null) goto L111;
        r3.startReplaceGroup(5004770);
        boolean r20 = r3.changedInstance(r115);
        Object r116 = r3.rememberedValue();
        if (r20 == false) goto L108;
    L109:
        r116 = new AddChatterScreenKt$AddChatterScreen$actualOnBack$1$1(r115);
        r3.updateRememberedValue(r116);
    L110:
        r3.endReplaceGroup();
        final Function0<Unit> r117 = (Function0) r116;
    L112:
        r3.endReplaceGroup();
        FocusManager r118 = (FocusManager) r3.consume(CompositionLocalsKt.getLocalFocusManager());
        r3.startReplaceGroup(-1633490746);
        boolean r2 = r3.changed(r117);
        int r119 = r1 & 896;
        if (r119 != 256) goto L115;
    L120:
        boolean r23 = true;
    L121:
        boolean r4 = r2 | r23;
        Object r24 = r3.rememberedValue();
        if (r4 == false) goto L124;
    L125:
        r24 = new AddChatterScreenKt$AddChatterScreen$onBackWithKeyboardHandling$1$1(r36, r117);
        r3.updateRememberedValue(r24);
    L126:
        final Function0 r7 = (Function0) r24;
        r3.endReplaceGroup();
        r3.startReplaceGroup(1849434622);
        Object r25 = r3.rememberedValue();
        Composer.Companion r26 = Composer.Companion;
        if (r25 != r26.getEmpty()) goto L130;
        r25 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r3.updateRememberedValue(r25);
    L130:
        final MutableState r27 = (MutableState) r25;
        r3.endReplaceGroup();
        com.ss.android.lark.flow.chat.resources.b r8 = com.ss.android.lark.flow.chat.resources.b.a;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        String r120 = b0.a((z) CommonMainString0.C.getValue(), r3);
        Intrinsics.checkNotNullParameter(r8, "<this>");
        String r28 = b0.a((z) CommonMainString0.B.getValue(), r3);
        r3.startReplaceGroup(-1224400529);
        boolean r121 = r3.changedInstance(r114);
        if ((r1 & 7168) != 2048) goto L133;
    L138:
        boolean r29 = true;
    L139:
        boolean r30 = (((r121 | r29) | r3.changedInstance(r115)) | r3.changed(r120)) | r3.changedInstance(r118);
        if (r119 != 256) goto L142;
    L147:
        boolean r31 = true;
    L148:
        boolean r32 = ((r30 | r31) | r3.changed(r117)) | r3.changed(r28);
        Object r33 = r3.rememberedValue();
        if (r32 == false) goto L151;
    L154:
        FocusManager r310 = r118;
        r33 = new AddChatterScreenKt$AddChatterScreen$1$1(r114, r27, r37, r115, r120, r310, r36, r117, r28, null);
        r3.updateRememberedValue(r33);
    L155:
        r3.endReplaceGroup();
        EffectsKt.LaunchedEffect(r114, (Function2) r33, r3, 0);
        r3.startReplaceGroup(1849434622);
        Object r43 = r3.rememberedValue();
        if (r43 != r26.getEmpty()) goto L158;
        Object r44 = null;
        r43 = SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
        r3.updateRememberedValue(r43);
    L159:
        final MutableState r45 = (MutableState) r43;
        r3.endReplaceGroup();
        Modifier r122 = Modifier.Companion;
        Modifier r46 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(r122, 0.0f, 1, r44), n.a(r3, 0).c.e, null, 2, null);
        r3.startReplaceGroup(-2079573357);
        if (r22 == false) goto L162;
        Modifier r123 = WindowInsetsPaddingKt.windowInsetsPadding(r122, WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, r3, 6));
    L163:
        r3.endReplaceGroup();
        Modifier r47 = r46.then(r123);
        MeasurePolicy r124 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r3, 0);
        long r125 = ComposablesKt.getCurrentCompositeKeyHashCode(r3, 0);
        int r126 = (int) ((r125 >>> 32) ^ r125);
        CompositionLocalMap r127 = r3.getCurrentCompositionLocalMap();
        Modifier r48 = ComposedModifierKt.materializeModifier(r3, r47);
        ComposeUiNode.Companion r128 = ComposeUiNode.Companion;
        Function0 r49 = r128.getConstructor();
        if ((r3.getApplier() instanceof Applier) == true) goto L166;
        ComposablesKt.invalidApplier();
    L166:
        r3.startReusableNode();
        if (r3.getInserting() == false) goto L169;
        r3.createNode(r49);
    L170:
        Composer r50 = Updater.constructor-impl(r3);
        Updater.set-impl(r50, r124, r128.getSetMeasurePolicy());
        Updater.set-impl(r50, r127, r128.getSetResolvedCompositionLocals());
        Function2 r129 = r128.getSetCompositeKeyHash();
        if (r50.getInserting() == false) goto L173;
    L174:
        r50.updateRememberedValue(Integer.valueOf(r126));
        r50.apply(Integer.valueOf(r126), r129);
    L175:
        Updater.set-impl(r50, r48, r128.getSetModifier());
        ColumnScopeInstance r51 = ColumnScopeInstance.INSTANCE;
        Intrinsics.checkNotNullParameter(r8, r9);
        ChatMemberListComponentsKt.b(b0.a((z) CommonMainString0.E.getValue(), r3), null, ComposableLambdaKt.rememberComposableLambda(-1529662199, true, new AddChatterScreenKt$AddChatterScreen$2$1(r7), r3, 54), null, r3, 384, 10);
        Modifier r52 = ColumnScope.-CC.weight$default(r51, r122, 1.0f, false, 2, null);
        r3.startReplaceGroup(5004770);
        Object r53 = r3.rememberedValue();
        if (r53 != r26.getEmpty()) goto L178;
        r53 = new AddChatterScreenKt$AddChatterScreen$2$2$1(r45);
        r3.updateRememberedValue(r53);
    L178:
        r3.endReplaceGroup();
        Intrinsics.checkNotNullParameter(r8, r9);
        int r130 = r1;
        r36.b(r34, r52, (Function1) r53, b0.a((z) CommonMainString0.A0.getValue(), r3), r3, ((r1 << 6) & 57344) | (r14 | 384));
        Intrinsics.checkNotNullParameter(r8, r9);
        String r54 = b0.a((z) CommonMainString0.F.getValue(), r3);
        int r131 = ((List) r45.getValue()).size();
        r3.startReplaceGroup(514605635);
        if ((!((List) r45.getValue()).isEmpty()) == false) goto L181;
        String r55 = StringsKt.replace$default(r54, "{num}", String.valueOf(((List) r45.getValue()).size()), false, 4, null);
    L182:
        String r56 = r55;
        r3.endReplaceGroup();
        r3.startReplaceGroup(-1224400529);
        final FocusManager r57 = r310;
        boolean r58 = r3.changedInstance(r114) | r3.changedInstance(r57);
        if (r119 == 256) goto L191;
        if ((r130 & 512) != 0) goto L187;
    L189:
        boolean r132 = false;
    L192:
        boolean r59 = r58 | r132;
        Object r60 = r3.rememberedValue();
        if (r59 == false) goto L195;
    L196:
        Function0<Unit> r61 = new AddChatterScreenKt$AddChatterScreen$2$3$1(r114, r57, r36, r27, r45);
        r3.updateRememberedValue(r61);
        r60 = r61;
    L197:
        r3.endReplaceGroup();
        r0 = r3;
        ChatterSelectorScreenKt.a(r131, r56, (Function0) r60, null, false, true, r3, 221184, 8);
        r0.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L200;
        ComposerKt.traceEventEnd();
    L200:
        r5 = r21;
        r6 = r22;
        goto L201
    L195:
        if (r60 != r26.getEmpty()) goto L197;
    L187:
        if (r3.changedInstance(r36) == false) goto L189;
    L191:
        r132 = true;
        goto L192
    L181:
        Intrinsics.checkNotNullParameter(r8, "<this>");
        r55 = b0.a((z) CommonMainString0.j0.getValue(), r3);
        goto L182
    L173:
        if (Intrinsics.areEqual(r50.rememberedValue(), Integer.valueOf(r126)) == true) goto L175;
    L169:
        r3.useNode();
        goto L170
    L162:
        r123 = r122;
        goto L163
    L158:
        r44 = null;
        goto L159
    L151:
        if (r33 == r26.getEmpty()) goto L154;
        r310 = r118;
        goto L155
    L142:
        if ((r1 & 512) != 0) goto L144;
    L146:
        r31 = false;
        goto L148
    L144:
        if (r3.changedInstance(r36) == false) goto L146;
    L133:
        if ((r1 & 4096) != 0) goto L135;
    L137:
        r29 = false;
        goto L139
    L135:
        if (r3.changedInstance(r37) == false) goto L137;
    L124:
        if (r24 != Composer.Companion.getEmpty()) goto L126;
    L115:
        if ((r1 & 512) != 0) goto L117;
    L119:
        r23 = false;
        goto L121
    L117:
        if (r3.changed(r36) == false) goto L119;
    L108:
        if (r116 != Composer.Companion.getEmpty()) goto L110;
    L111:
        r117 = r21;
        goto L112
    L102:
        r113 = CreationExtras.Empty.INSTANCE;
        goto L103
    L206:
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    L95:
        if (r17 != Composer.Companion.getEmpty()) goto L97;
    L91:
        r15 = false;
        goto L92
    L84:
        r22 = r13;
        goto L86
    L80:
        r21 = r11;
        goto L82
    L64:
        if ((196608 & r41) != 0) goto L70;
        r13 = r39;
        if (r3.changed(r13) == false) goto L68;
        int r133 = 131072;
    L69:
        r1 = r1 | r133;
        goto L72
    L68:
        r133 = 65536;
        goto L69
    L53:
        if ((r41 & 24576) != 0) goto L59;
        r11 = r38;
        if (r3.changedInstance(r11) == false) goto L57;
        int r134 = 16384;
    L58:
        r1 = r1 | r134;
        goto L60
    L57:
        r134 = 8192;
        goto L58
    L40:
        if ((r41 & 3072) != 0) goto L49;
        if ((r41 & 4096) != 0) goto L44;
        boolean r135 = r3.changed(r37);
    L45:
        if (r135 == false) goto L47;
        int r136 = 2048;
    L48:
        r1 = r1 | r136;
        goto L49
    L47:
        r136 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L48
    L44:
        r135 = r3.changedInstance(r37);
        goto L45
    L27:
        if ((r41 & 384) != 0) goto L37;
        if ((r41 & 512) != 0) goto L31;
        boolean r137 = r3.changed(r36);
    L32:
        if (r137 == false) goto L34;
        int r138 = 256;
    L35:
        r1 = r1 | r138;
        goto L37
    L34:
        r138 = 128;
        goto L35
    L31:
        r137 = r3.changedInstance(r36);
        goto L32
    L17:
        if ((r41 & 48) != 0) goto L24;
        if (r3.changedInstance(r35) == false) goto L21;
        int r139 = 32;
    L22:
        r1 = r1 | r139;
        goto L24
    L21:
        r139 = 16;
        goto L22
    L6:
        if ((r41 & 6) == 0) goto L8;
        r1 = r41;
        goto L14
    L8:
        if (r3.changed(r34) == false) goto L10;
        int r62 = 4;
    L11:
        r1 = r62 | r41;
        goto L14
    L10:
        r62 = 2;
        goto L11
    }
}
