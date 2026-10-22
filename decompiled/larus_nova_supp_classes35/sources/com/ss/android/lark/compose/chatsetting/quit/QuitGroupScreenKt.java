package com.ss.android.lark.compose.chatsetting.quit;

import android.content.Context;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.chatsetting.common.ui.widget.SettingGroupContainerKt;
import com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageScreenKt;
import com.ss.android.lark.compose.foundation.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class QuitGroupScreenKt {
    public static final void a(final PaddingValues r37, final d r38, final com.ss.android.lark.compose.chatsetting.common.platform.a r39, final com.ss.android.lark.compose.chatsetting.common.platform.b r40, final String r41, final String r42, final String r43, final String r44, final Function0<Unit> r45, Composer r46, final int r47) {
        Intrinsics.checkNotNullParameter(r37, "innerPadding");
        Intrinsics.checkNotNullParameter(r38, "rustClient");
        Intrinsics.checkNotNullParameter(r39, "childScreenHost");
        Intrinsics.checkNotNullParameter(r40, "platformEffects");
        Intrinsics.checkNotNullParameter(r41, "chatId");
        Intrinsics.checkNotNullParameter(r42, "currentUserId");
        Intrinsics.checkNotNullParameter(r43, "chatName");
        Intrinsics.checkNotNullParameter(r44, "avatarKey");
        Intrinsics.checkNotNullParameter(r45, "onBackClick");
        Composer r7 = r46.startRestartGroup(1202702001);
        if ((r47 & 6) == 0) goto L5;
        int r3 = r47;
    L11:
        if ((r47 & 48) != 0) goto L18;
        if (r7.changedInstance(r38) == false) goto L15;
        int r5 = 32;
    L16:
        r3 = r3 | r5;
        goto L18
    L15:
        r5 = 16;
    L18:
        if ((r47 & 384) != 0) goto L28;
        if ((r47 & 512) != 0) goto L22;
        boolean r6 = r7.changed(r39);
    L23:
        if (r6 == false) goto L25;
        int r8 = 256;
    L26:
        r3 = r3 | r8;
        goto L28
    L25:
        r8 = 128;
        goto L26
    L22:
        r6 = r7.changedInstance(r39);
    L28:
        if ((r47 & 3072) != 0) goto L38;
        if ((r47 & 4096) != 0) goto L32;
        boolean r9 = r7.changed(r40);
    L33:
        if (r9 == false) goto L35;
        int r10 = 2048;
    L36:
        r3 = r3 | r10;
        goto L38
    L35:
        r10 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L36
    L32:
        r9 = r7.changedInstance(r40);
    L38:
        if ((r47 & 24576) != 0) goto L45;
        if (r7.changed(r41) == false) goto L42;
        int r11 = 16384;
    L43:
        r3 = r3 | r11;
        goto L45
    L42:
        r11 = 8192;
    L45:
        if ((196608 & r47) != 0) goto L52;
        if (r7.changed(r42) == false) goto L49;
        int r12 = 131072;
    L50:
        r3 = r3 | r12;
        goto L52
    L49:
        r12 = 65536;
    L52:
        if ((1572864 & r47) != 0) goto L59;
        if (r7.changed(r43) == false) goto L56;
        int r13 = 1048576;
    L57:
        r3 = r3 | r13;
        goto L59
    L56:
        r13 = 524288;
    L59:
        if ((r47 & 12582912) != 0) goto L66;
        if (r7.changed(r44) == false) goto L63;
        int r17 = 8388608;
    L64:
        r3 = r3 | r17;
        goto L66
    L63:
        r17 = 4194304;
    L66:
        if ((r47 & 100663296) != 0) goto L73;
        if (r7.changedInstance(r45) == false) goto L70;
        int r18 = 67108864;
    L71:
        r3 = r3 | r18;
        goto L73
    L70:
        r18 = 33554432;
    L73:
        if ((r3 & 38347923) != 38347922) goto L79;
        if (r7.getSkipping() == false) goto L79;
        r7.skipToGroupEnd();
        Composer r1 = r7;
    L178:
        ScopeUpdateScope r14 = r1.endRestartGroup();
        if (r14 == null) goto L184;
        r14.updateScope(new QuitGroupScreenKt$QuitGroupScreen$4(r37, r38, r39, r40, r41, r42, r43, r44, r45, r47));
        return;
    L184:
        return;
    L79:
        if (ComposerKt.isTraceInProgress() == false) goto L81;
        ComposerKt.traceEventStart(1202702001, r3, -1, "com.ss.android.lark.compose.chatsetting.quit.QuitGroupScreen (QuitGroupScreen.kt:62)");
    L81:
        r7.startReplaceGroup(-1224400529);
        if ((r3 & 57344) != 16384) goto L84;
        boolean r4 = true;
    L86:
        if ((458752 & r3) != 131072) goto L88;
        boolean r2 = true;
    L89:
        boolean r15 = (r2 | r4) | r7.changedInstance(r38);
        if ((r3 & 7168) != 2048) goto L92;
    L97:
        boolean r16 = true;
    L98:
        boolean r19 = r15 | r16;
        Object r20 = r7.rememberedValue();
        if (r19 == false) goto L101;
    L102:
        r20 = new QuitGroupScreenKt$QuitGroupScreen$viewModel$1$1(r41, r42, r38, r40);
        r7.updateRememberedValue(r20);
    L103:
        Function1 r21 = (Function1) r20;
        r7.endReplaceGroup();
        HasDefaultViewModelProviderFactory r22 = LocalViewModelStoreOwner.INSTANCE.getCurrent(r7, 6);
        if (r22 == null) goto L183;
        KClass r110 = Reflection.getOrCreateKotlinClass(QuitGroupViewModel.class);
        InitializerViewModelFactoryBuilder r23 = new InitializerViewModelFactoryBuilder();
        r23.addInitializer(Reflection.getOrCreateKotlinClass(QuitGroupViewModel.class), r21);
        ViewModelProvider.Factory r111 = r23.build();
        if ((r22 instanceof HasDefaultViewModelProviderFactory) == false) goto L108;
        CreationExtras r24 = r22.getDefaultViewModelCreationExtras();
    L109:
        final QuitGroupViewModel r25 = (QuitGroupViewModel) ViewModelKt.viewModel(r110, r22, null, r111, r24, r7, 0, 0);
        final Context r26 = d8b.b.a(r7);
        r7.startReplaceGroup(1849434622);
        Object r27 = r7.rememberedValue();
        Composer.Companion r28 = Composer.Companion;
        if (r27 != r28.getEmpty()) goto L112;
        r27 = new MutableTransitionState(Boolean.FALSE);
        r7.updateRememberedValue(r27);
    L112:
        final MutableTransitionState r0 = (MutableTransitionState) r27;
        r7.endReplaceGroup();
        Modifier.Companion r29 = Modifier.Companion;
        Modifier r30 = PaddingKt.padding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(r29, 0.0f, 1, null), n.a(r7, 0).c.f, null, 2, null), r37);
        Alignment.Companion r112 = Alignment.Companion;
        Alignment.Horizontal r113 = r112.getCenterHorizontally();
        Arrangement r114 = Arrangement.INSTANCE;
        MeasurePolicy r31 = ColumnKt.columnMeasurePolicy(r114.getTop(), r113, r7, 48);
        long r115 = ComposablesKt.getCurrentCompositeKeyHashCode(r7, 0);
        int r116 = (int) (r115 ^ (r115 >>> 32));
        CompositionLocalMap r117 = r7.getCurrentCompositionLocalMap();
        Modifier r32 = ComposedModifierKt.materializeModifier(r7, r30);
        ComposeUiNode.Companion r118 = ComposeUiNode.Companion;
        Function0 r119 = r118.getConstructor();
        if ((r7.getApplier() instanceof Applier) == true) goto L115;
        ComposablesKt.invalidApplier();
    L115:
        r7.startReusableNode();
        if (r7.getInserting() == false) goto L118;
        r7.createNode(r119);
    L119:
        Composer r33 = Updater.constructor-impl(r7);
        Updater.set-impl(r33, r31, r118.getSetMeasurePolicy());
        Updater.set-impl(r33, r117, r118.getSetResolvedCompositionLocals());
        Function2 r34 = r118.getSetCompositeKeyHash();
        if (r33.getInserting() == false) goto L122;
    L123:
        r33.updateRememberedValue(Integer.valueOf(r116));
        r33.apply(Integer.valueOf(r116), r34);
    L124:
        Updater.set-impl(r33, r32, r118.getSetModifier());
        ColumnScopeInstance r35 = ColumnScopeInstance.INSTANCE;
        QuitGroupTitleKt.a(r45, r7, (r3 >> 24) & 14);
        float r36 = 16;
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(r29, Dp.constructor-impl(r36)), r7, 6);
        Modifier r48 = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(r29, 0.0f, 1, null), ScrollKt.rememberScrollState(0, r7, 0, 1), false, null, false, 14, null);
        MeasurePolicy r49 = ColumnKt.columnMeasurePolicy(r114.getTop(), r112.getCenterHorizontally(), r7, 48);
        long r120 = ComposablesKt.getCurrentCompositeKeyHashCode(r7, 0);
        int r121 = (int) (r120 ^ (r120 >>> 32));
        CompositionLocalMap r122 = r7.getCurrentCompositionLocalMap();
        Modifier r50 = ComposedModifierKt.materializeModifier(r7, r48);
        Function0 r123 = r118.getConstructor();
        if ((r7.getApplier() instanceof Applier) == true) goto L127;
        ComposablesKt.invalidApplier();
    L127:
        r7.startReusableNode();
        if (r7.getInserting() == false) goto L130;
        r7.createNode(r123);
    L131:
        Composer r51 = Updater.constructor-impl(r7);
        Updater.set-impl(r51, r49, r118.getSetMeasurePolicy());
        Updater.set-impl(r51, r122, r118.getSetResolvedCompositionLocals());
        Function2 r52 = r118.getSetCompositeKeyHash();
        if (r51.getInserting() == false) goto L134;
    L135:
        r51.updateRememberedValue(Integer.valueOf(r121));
        r51.apply(Integer.valueOf(r121), r52);
    L136:
        Updater.set-impl(r51, r50, r118.getSetModifier());
        SettingGroupContainerKt.a(null, ComposableLambdaKt.rememberComposableLambda(-334703501, true, new QuitGroupScreenKt$QuitGroupScreen$1$1$1(r44, r41, r43), r7, 54), r7, 48, 1);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(r29, Dp.constructor-impl(30)), r7, 6);
        Modifier r53 = PaddingKt.padding-VpY3zN4$default(SizeKt.wrapContentWidth$default(r29, null, false, 3, null), Dp.constructor-impl(r36), 0.0f, 2, null);
        MeasurePolicy r54 = RowKt.rowMeasurePolicy(r114.getStart(), r112.getTop(), r7, 0);
        long r124 = ComposablesKt.getCurrentCompositeKeyHashCode(r7, 0);
        int r55 = (int) ((r124 >>> 32) ^ r124);
        CompositionLocalMap r56 = r7.getCurrentCompositionLocalMap();
        Modifier r57 = ComposedModifierKt.materializeModifier(r7, r53);
        Function0 r125 = r118.getConstructor();
        if ((r7.getApplier() instanceof Applier) == true) goto L139;
        ComposablesKt.invalidApplier();
    L139:
        r7.startReusableNode();
        if (r7.getInserting() == false) goto L142;
        r7.createNode(r125);
    L143:
        Composer r126 = Updater.constructor-impl(r7);
        Updater.set-impl(r126, r54, r118.getSetMeasurePolicy());
        Updater.set-impl(r126, r56, r118.getSetResolvedCompositionLocals());
        Function2 r58 = r118.getSetCompositeKeyHash();
        if (r126.getInserting() == false) goto L146;
    L147:
        r126.updateRememberedValue(Integer.valueOf(r55));
        r126.apply(Integer.valueOf(r55), r58);
    L148:
        Updater.set-impl(r126, r57, r118.getSetModifier());
        RowScopeInstance r59 = RowScopeInstance.INSTANCE;
        r7.startReplaceGroup(-1633490746);
        boolean r60 = r7.changedInstance(r25) | r7.changedInstance(r26);
        Object r61 = r7.rememberedValue();
        if (r60 == false) goto L151;
    L152:
        r61 = new QuitGroupScreenKt$QuitGroupScreen$1$1$2$1$1(r25, r26);
        r7.updateRememberedValue(r61);
    L153:
        Function0 r62 = (Function0) r61;
        r7.endReplaceGroup();
        float r63 = 127;
        float r127 = 42;
        Modifier r64 = SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(r29, Dp.constructor-impl(r63)), Dp.constructor-impl(r127));
        float r128 = 8;
        RoundedCornerShape r129 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r128));
        ButtonDefaults r310 = ButtonDefaults.INSTANCE;
        Color.Companion r311 = Color.Companion;
        long r130 = r311.getTransparent-0d7_KjU();
        long r131 = n.a(r7, 0).d.a;
        int r65 = ButtonDefaults.$stable << 12;
        int r312 = r3;
        float r66 = 0;
        ButtonKt.Button(r62, r64, false, r129, r310.buttonColors-ro_MJ88(r130, r131, 0, 0, r7, r65 | 6, 12), null, BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl(1), n.a(r7, 0).d.d), PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(r66)), null, ComposableSingletons$QuitGroupScreenKt.a, r7, 817889328, 292);
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(r29, Dp.constructor-impl(24)), r7, 6);
        r7.startReplaceGroup(5004770);
        boolean r67 = r7.changedInstance(r0);
        Object r132 = r7.rememberedValue();
        if (r67 == false) goto L156;
    L157:
        r132 = new QuitGroupScreenKt$QuitGroupScreen$1$1$2$2$1(r0);
        r7.updateRememberedValue(r132);
    L158:
        r7.endReplaceGroup();
        ButtonKt.Button((Function0) r132, SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(r29, Dp.constructor-impl(r63)), Dp.constructor-impl(r127)), false, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r128)), r310.buttonColors-ro_MJ88(n.a(r7, 0).a.a, r311.getWhite-0d7_KjU(), 0, 0, r7, r65 | 48, 12), null, null, PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(r66)), null, ComposableSingletons$QuitGroupScreenKt.b, r7, 817889328, 356);
        r7.endNode();
        r7.endNode();
        r7.endNode();
        if (((Boolean) r0.getCurrentState()).booleanValue() == false) goto L161;
    L164:
        r7.startReplaceGroup(5004770);
        boolean r68 = r7.changedInstance(r0);
        Object r69 = r7.rememberedValue();
        if (r68 == false) goto L167;
    L168:
        r69 = new QuitGroupScreenKt$QuitGroupScreen$2$1(r0);
        r7.updateRememberedValue(r69);
    L169:
        Function0 r70 = (Function0) r69;
        r7.endReplaceGroup();
        r7.startReplaceGroup(-1633490746);
        boolean r71 = r7.changedInstance(r25) | r7.changedInstance(r26);
        Object r72 = r7.rememberedValue();
        if (r71 == false) goto L172;
    L173:
        r72 = new QuitGroupScreenKt$QuitGroupScreen$3$1(r25, r26);
        r7.updateRememberedValue(r72);
    L174:
        r7.endReplaceGroup();
        int r73 = r312 << 3;
        int r133 = ((((MutableTransitionState.$stable | 12582912) | ((r312 >> 9) & 112)) | (r73 & 896)) | (r73 & 7168)) | (r73 & 57344);
        r1 = r7;
        GroupManageScreenKt.c(r0, r41, r38, r39, r40, r70, (Function1) r72, "transfer_owner", r1, r133);
    L176:
        if (ComposerKt.isTraceInProgress() == false) goto L178;
        ComposerKt.traceEventEnd();
        goto L178
    L172:
        if (r72 != r28.getEmpty()) goto L174;
    L167:
        if (r69 != r28.getEmpty()) goto L169;
    L161:
        if (((Boolean) r0.getTargetState()).booleanValue() == true) goto L164;
        r1 = r7;
        goto L176
    L156:
        if (r132 != r28.getEmpty()) goto L158;
    L151:
        if (r61 != r28.getEmpty()) goto L153;
    L146:
        if (Intrinsics.areEqual(r126.rememberedValue(), Integer.valueOf(r55)) == true) goto L148;
    L142:
        r7.useNode();
        goto L143
    L134:
        if (Intrinsics.areEqual(r51.rememberedValue(), Integer.valueOf(r121)) == true) goto L136;
    L130:
        r7.useNode();
        goto L131
    L122:
        if (Intrinsics.areEqual(r33.rememberedValue(), Integer.valueOf(r116)) == true) goto L124;
    L118:
        r7.useNode();
        goto L119
    L108:
        r24 = CreationExtras.Empty.INSTANCE;
        goto L109
    L183:
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    L101:
        if (r20 != Composer.Companion.getEmpty()) goto L103;
    L92:
        if ((r3 & 4096) != 0) goto L94;
    L96:
        r16 = false;
        goto L98
    L94:
        if (r7.changedInstance(r40) == false) goto L96;
    L88:
        r2 = false;
        goto L89
    L84:
        r4 = false;
        goto L86
    L5:
        if (r7.changed(r37) == false) goto L7;
        int r74 = 4;
    L8:
        r3 = r74 | r47;
        goto L11
    L7:
        r74 = 2;
        goto L8
    }
}
