package com.ss.android.lark.compose.chatsetting.remove_chatter;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.chatterselector.ChatterSelectorScreenKt;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class RemoveChatterScreenKt {
    public static final void b(final Function0 r63, Modifier r64, Composer r65, final int r66, final int r67) {
        Composer r4 = r65.startRestartGroup(373096000);
        if ((r67 & 1) == 0) goto L6;
        int r5 = r66 | 6;
    L13:
        int r7 = r67 & 2;
        if (r7 == 0) goto L17;
        r5 = r5 | 48;
    L23:
        final Modifier r8 = r64;
    L25:
        if ((r5 & 19) == 18) goto L27;
    L30:
        if (r7 == 0) goto L32;
        Modifier r30 = Modifier.Companion;
    L34:
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventStart(373096000, r5, -1, "com.ss.android.lark.compose.chatsetting.remove_chatter.RemoveChatterCancelText (RemoveChatterScreen.kt:128)");
    L36:
        final FocusManager r3 = (FocusManager) r4.consume(CompositionLocalsKt.getLocalFocusManager());
        r4.startReplaceGroup(-1633490746);
        if ((r5 & 14) != 4) goto L39;
        boolean r6 = true;
    L40:
        boolean r9 = r6 | r4.changed(r3);
        Object r10 = r4.rememberedValue();
        if (r9 == false) goto L43;
    L44:
        r10 = new RemoveChatterScreenKt$RemoveChatterCancelText$onClickWithFocusHandling$1$1(r3, r63);
        r4.updateRememberedValue(r10);
    L45:
        final Function0 r11 = (Function0) r10;
        r4.endReplaceGroup();
        Intrinsics.checkNotNullParameter(com.ss.android.lark.flow.chat.resources.b.a, "<this>");
        String r12 = b0.a((z) CommonMainString0.f.getValue(), r4);
        TextStyle r26 = new TextStyle(0, TextUnitKt.getSp(17), FontWeight.Companion.getNormal(), null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777209, null);
        MutableInteractionSource r18 = InteractionSourceKt.MutableInteractionSource();
        r4.startReplaceGroup(5004770);
        boolean r13 = r4.changed(r11);
        Object r14 = r4.rememberedValue();
        if (r13 == false) goto L48;
    L49:
        r14 = new RemoveChatterScreenKt$RemoveChatterCancelText$1$1(r11);
        r4.updateRememberedValue(r14);
    L50:
        r4.endReplaceGroup();
        Modifier r17 = r30;
        Composer r31 = r4;
        TextKt.Text-Nvy7gAk(r12, ClickableKt.clickable-O2vRcR0$default(r17, r18, null, false, null, null, (Function0) r14, 28, null), n.a(r4, 0).d.a, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, r26, r31, 0, 12582912, 131064);
        if (ComposerKt.isTraceInProgress() == false) goto L53;
        ComposerKt.traceEventEnd();
    L53:
        r8 = r30;
    L54:
        ScopeUpdateScope r15 = r31.endRestartGroup();
        if (r15 == null) goto L58;
        r15.updateScope(new RemoveChatterScreenKt$RemoveChatterCancelText$2(r63, r8, r66, r67));
        return;
    L58:
        return;
    L48:
        if (r14 != Composer.Companion.getEmpty()) goto L50;
    L43:
        if (r10 != Composer.Companion.getEmpty()) goto L45;
    L39:
        r6 = false;
        goto L40
    L32:
        r30 = r8;
        goto L34
    L27:
        if (r4.getSkipping() == false) goto L30;
        r4.skipToGroupEnd();
        r31 = r4;
        goto L54
    L17:
        if ((r66 & 48) != 0) goto L23;
        r8 = r64;
        if (r4.changed(r8) == false) goto L21;
        int r16 = 32;
    L22:
        r5 = r5 | r16;
        goto L25
    L21:
        r16 = 16;
        goto L22
    L6:
        if ((r66 & 6) == 0) goto L8;
        r5 = r66;
        goto L13
    L8:
        if (r4.changedInstance(r63) == false) goto L10;
        int r19 = 4;
    L11:
        r5 = r19 | r66;
        goto L13
    L10:
        r19 = 2;
        goto L11
    }

    public static final void a(final String r37, final d r38, final com.ss.android.lark.compose.chatsetting.common.platform.a r39, final com.ss.android.lark.compose.chatsetting.common.platform.b r40, Function0<Unit> r41, Composer r42, final int r43, final int r44) {
        Intrinsics.checkNotNullParameter(r37, "chatId");
        Intrinsics.checkNotNullParameter(r38, "rustClient");
        Intrinsics.checkNotNullParameter(r39, "childScreenHost");
        Intrinsics.checkNotNullParameter(r40, "platformEffects");
        Composer r10 = r42.startRestartGroup(1128617208);
        if ((r44 & 1) == 0) goto L6;
        int r1 = r43 | 6;
    L14:
        if ((r44 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r44 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L37:
        if ((r44 & 8) == 0) goto L40;
        r1 = r1 | 3072;
    L49:
        int r3 = r44 & 16;
        if (r3 == 0) goto L53;
        r1 = r1 | 24576;
    L59:
        Function0<Unit> r4 = r41;
    L60:
        int r6 = r1;
        if ((r6 & 9363) != 9362) goto L67;
        if (r10.getSkipping() == false) goto L67;
        r10.skipToGroupEnd();
        final Function0<Unit> r5 = r4;
        Composer r27 = r10;
    L157:
        ScopeUpdateScope r8 = r27.endRestartGroup();
        if (r8 == null) goto L163;
        r8.updateScope(new RemoveChatterScreenKt$RemoveChatterScreen$3(r37, r38, r39, r40, r5, r43, r44));
        return;
    L163:
        return;
    L67:
        if (r3 == 0) goto L69;
        Function0<Unit> r22 = null;
    L71:
        if (ComposerKt.isTraceInProgress() == false) goto L73;
        ComposerKt.traceEventStart(1128617208, r6, -1, "com.ss.android.lark.compose.chatsetting.remove_chatter.RemoveChatterScreen (RemoveChatterScreen.kt:47)");
    L73:
        r10.startReplaceGroup(-1633490746);
        if ((r6 & 14) != 4) goto L76;
        boolean r2 = true;
    L77:
        boolean r7 = r2 | r10.changedInstance(r38);
        Object r9 = r10.rememberedValue();
        if (r7 == false) goto L80;
    L81:
        r9 = new RemoveChatterScreenKt$RemoveChatterScreen$viewModel$1$1(r37, r38);
        r10.updateRememberedValue(r9);
    L82:
        Function1 r11 = (Function1) r9;
        r10.endReplaceGroup();
        HasDefaultViewModelProviderFactory r12 = LocalViewModelStoreOwner.INSTANCE.getCurrent(r10, 6);
        if (r12 == null) goto L162;
        KClass r17 = Reflection.getOrCreateKotlinClass(RemoveChatterViewModel.class);
        InitializerViewModelFactoryBuilder r13 = new InitializerViewModelFactoryBuilder();
        r13.addInitializer(Reflection.getOrCreateKotlinClass(RemoveChatterViewModel.class), r11);
        ViewModelProvider.Factory r14 = r13.build();
        if ((r12 instanceof HasDefaultViewModelProviderFactory) == false) goto L87;
        CreationExtras r15 = r12.getDefaultViewModelCreationExtras();
    L88:
        final RemoveChatterViewModel r16 = (RemoveChatterViewModel) ViewModelKt.viewModel(r17, r12, null, r14, r15, r10, 0, 0);
        Context r18 = d8b.b.a(r10);
        r10.startReplaceGroup(-2025576284);
        if (r22 != null) goto L94;
        r10.startReplaceGroup(1849434622);
        Object r19 = r10.rememberedValue();
        if (r19 != Composer.Companion.getEmpty()) goto L93;
        r19 = RemoveChatterScreenKt$RemoveChatterScreen$actualOnBack$1$1.INSTANCE;
        r10.updateRememberedValue(r19);
    L93:
        r10.endReplaceGroup();
        final Function0<Unit> r20 = (Function0) r19;
    L95:
        r10.endReplaceGroup();
        r10.startReplaceGroup(-1633490746);
        boolean r21 = r10.changed(r20);
        if ((r6 & 896) != 256) goto L98;
    L103:
        boolean r23 = true;
    L104:
        boolean r24 = r21 | r23;
        Object r25 = r10.rememberedValue();
        if (r24 == false) goto L107;
    L108:
        r25 = new RemoveChatterScreenKt$RemoveChatterScreen$onBackWithKeyboardHandling$1$1(r39, r20);
        r10.updateRememberedValue(r25);
    L109:
        Function0 r110 = (Function0) r25;
        r10.endReplaceGroup();
        final State r26 = SnapshotStateKt.collectAsState(r16.getLoading(), null, r10, 0, 1);
        com.ss.android.lark.flow.chat.resources.b r28 = com.ss.android.lark.flow.chat.resources.b.a;
        Intrinsics.checkNotNullParameter(r28, "<this>");
        String r0 = b0.a((z) CommonMainString0.i0.getValue(), r10);
        Intrinsics.checkNotNullParameter(r28, "<this>");
        String r29 = b0.a((z) CommonMainString0.h0.getValue(), r10);
        r10.startReplaceGroup(-1224400529);
        boolean r30 = r10.changedInstance(r16);
        int r31 = r6 & 7168;
        if (r31 != 2048) goto L112;
    L117:
        boolean r32 = true;
    L118:
        boolean r33 = ((((r32 | r30) | r10.changedInstance(r18)) | r10.changed(r0)) | r10.changed(r20)) | r10.changed(r29);
        Object r34 = r10.rememberedValue();
        if (r33 == false) goto L121;
    L124:
        Object r111 = null;
        RemoveChatterScreenKt$RemoveChatterScreen$1$1 r35 = new RemoveChatterScreenKt$RemoveChatterScreen$1$1(r16, r40, r18, r0, r20, r29, null);
        r10.updateRememberedValue(r35);
        r34 = r35;
    L125:
        r10.endReplaceGroup();
        EffectsKt.LaunchedEffect(r16, (Function2) r34, r10, 0);
        Modifier r36 = WindowInsetsPaddingKt.windowInsetsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, r111), n.a(r10, 0).c.e, null, 2, null), WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, r10, 6));
        MeasurePolicy r45 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        long r46 = ComposablesKt.getCurrentCompositeKeyHashCode(r10, 0);
        int r47 = (int) (r46 ^ (r46 >>> 32));
        CompositionLocalMap r48 = r10.getCurrentCompositionLocalMap();
        Modifier r49 = ComposedModifierKt.materializeModifier(r10, r36);
        ComposeUiNode.Companion r50 = ComposeUiNode.Companion;
        Function0 r51 = r50.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L128;
        ComposablesKt.invalidApplier();
    L128:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L131;
        r10.createNode(r51);
    L132:
        Composer r52 = Updater.constructor-impl(r10);
        Updater.set-impl(r52, r45, r50.getSetMeasurePolicy());
        Updater.set-impl(r52, r48, r50.getSetResolvedCompositionLocals());
        Function2 r53 = r50.getSetCompositeKeyHash();
        if (r52.getInserting() == false) goto L135;
    L136:
        r52.updateRememberedValue(Integer.valueOf(r47));
        r52.apply(Integer.valueOf(r47), r53);
    L137:
        Updater.set-impl(r52, r49, r50.getSetModifier());
        BoxScopeInstance r54 = BoxScopeInstance.INSTANCE;
        Intrinsics.checkNotNullParameter(r28, "<this>");
        String r55 = b0.a((z) CommonMainString0.w0.getValue(), r10);
        Intrinsics.checkNotNullParameter(r28, "<this>");
        final String r56 = b0.a((z) CommonMainString0.k0.getValue(), r10);
        Intrinsics.checkNotNullParameter(r28, "<this>");
        final String r57 = b0.a((z) CommonMainString0.y0.getValue(), r10);
        Set r58 = SetsKt.emptySet();
        Intrinsics.checkNotNullParameter(r28, "<this>");
        String r210 = b0.a((z) CommonMainString0.x0.getValue(), r10);
        String r211 = "chatter_selector#" + r37 + '#' + r55 + "#false#false#true";
        r10.startReplaceGroup(1849434622);
        Object r59 = r10.rememberedValue();
        Composer.Companion r60 = Composer.Companion;
        if (r59 != r60.getEmpty()) goto L140;
        r59 = RemoveChatterScreenKt$RemoveChatterScreen$2$1$1.INSTANCE;
        r10.updateRememberedValue(r59);
    L140:
        Function0 r112 = (Function0) r59;
        r10.endReplaceGroup();
        r10.startReplaceGroup(1849434622);
        Object r61 = r10.rememberedValue();
        if (r61 != r60.getEmpty()) goto L143;
        r61 = RemoveChatterScreenKt$RemoveChatterScreen$2$2$1.INSTANCE;
        r10.updateRememberedValue(r61);
    L143:
        Function1 r212 = (Function1) r61;
        r10.endReplaceGroup();
        r10.startReplaceGroup(-1633490746);
        boolean r62 = r10.changed(r57) | r10.changed(r56);
        Object r63 = r10.rememberedValue();
        if (r62 == false) goto L146;
    L147:
        r63 = new RemoveChatterScreenKt$RemoveChatterScreen$2$3$1(r57, r56);
        r10.updateRememberedValue(r63);
    L148:
        Function1 r213 = (Function1) r63;
        r10.endReplaceGroup();
        ComposableLambda r214 = ComposableSingletons$RemoveChatterScreenKt.a;
        r10.startReplaceGroup(-1633490746);
        boolean r64 = r10.changed(r26) | r10.changedInstance(r16);
        Object r65 = r10.rememberedValue();
        if (r64 == false) goto L151;
    L152:
        r65 = new RemoveChatterScreenKt$RemoveChatterScreen$2$4$1(r16, r26);
        r10.updateRememberedValue(r65);
    L153:
        r10.endReplaceGroup();
        int r66 = r6 << 3;
        r27 = r10;
        ChatterSelectorScreenKt.c(r55, r37, r38, r40, r58, null, r112, false, false, true, false, r212, r213, r214, r210, r211, r110, (Function1) r65, r27, ((r66 & 896) | ((r66 & 112) | 920346624)) | r31, 3126, 0);
        r27.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L156;
        ComposerKt.traceEventEnd();
    L156:
        r5 = r22;
        goto L157
    L151:
        if (r65 != r60.getEmpty()) goto L153;
    L146:
        if (r63 != r60.getEmpty()) goto L148;
    L135:
        if (Intrinsics.areEqual(r52.rememberedValue(), Integer.valueOf(r47)) == true) goto L137;
    L131:
        r10.useNode();
        goto L132
    L121:
        if (r34 == Composer.Companion.getEmpty()) goto L124;
        r111 = null;
        goto L125
    L112:
        if ((r6 & 4096) != 0) goto L114;
    L116:
        r32 = false;
        goto L118
    L114:
        if (r10.changedInstance(r40) == false) goto L116;
    L107:
        if (r25 != Composer.Companion.getEmpty()) goto L109;
    L98:
        if ((r6 & 512) != 0) goto L100;
    L102:
        r23 = false;
        goto L104
    L100:
        if (r10.changed(r39) == false) goto L102;
    L94:
        r20 = r22;
        goto L95
    L87:
        r15 = CreationExtras.Empty.INSTANCE;
        goto L88
    L162:
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    L80:
        if (r9 != Composer.Companion.getEmpty()) goto L82;
    L76:
        r2 = false;
        goto L77
    L69:
        r22 = r4;
        goto L71
    L53:
        if ((r43 & 24576) != 0) goto L59;
        r4 = r41;
        if (r10.changedInstance(r4) == false) goto L57;
        int r67 = 16384;
    L58:
        r1 = r1 | r67;
        goto L60
    L57:
        r67 = 8192;
        goto L58
    L40:
        if ((r43 & 3072) != 0) goto L49;
        if ((r43 & 4096) != 0) goto L44;
        boolean r68 = r10.changed(r40);
    L45:
        if (r68 == false) goto L47;
        int r69 = 2048;
    L48:
        r1 = r1 | r69;
        goto L49
    L47:
        r69 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L48
    L44:
        r68 = r10.changedInstance(r40);
        goto L45
    L27:
        if ((r43 & 384) != 0) goto L37;
        if ((r43 & 512) != 0) goto L31;
        boolean r70 = r10.changed(r39);
    L32:
        if (r70 == false) goto L34;
        int r71 = 256;
    L35:
        r1 = r1 | r71;
        goto L37
    L34:
        r71 = 128;
        goto L35
    L31:
        r70 = r10.changedInstance(r39);
        goto L32
    L17:
        if ((r43 & 48) != 0) goto L24;
        if (r10.changedInstance(r38) == false) goto L21;
        int r72 = 32;
    L22:
        r1 = r1 | r72;
        goto L24
    L21:
        r72 = 16;
        goto L22
    L6:
        if ((r43 & 6) == 0) goto L8;
        r1 = r43;
        goto L14
    L8:
        if (r10.changed(r37) == false) goto L10;
        int r73 = 4;
    L11:
        r1 = r73 | r43;
        goto L14
    L10:
        r73 = 2;
        goto L11
    }
}
