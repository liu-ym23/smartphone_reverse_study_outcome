package com.ss.android.lark.compose.chatsetting.main.ui.sections.p2p;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.chatsetting.common.platform.b;
import com.ss.android.lark.compose.chatsetting.common.ui.icon.ChatSettingIcons;
import com.ss.android.lark.compose.chatsetting.common.ui.widget.ChatterCellKt;
import com.ss.android.lark.compose.chatsetting.common.ui.widget.DashedCellKt;
import com.ss.android.lark.compose.chatsetting.main.viewmodel.P2PInfoViewModel;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class P2PInfoSectionKt {
    public static final void a(final String r22, final String r23, final d r24, final b r25, Composer r26, final int r27) {
        Intrinsics.checkNotNullParameter(r22, "p2pChatId");
        Intrinsics.checkNotNullParameter(r23, "p2pChatterId");
        Intrinsics.checkNotNullParameter(r24, "rustClient");
        Intrinsics.checkNotNullParameter(r25, "platformEffects");
        Composer r9 = r26.startRestartGroup(1819751752);
        if ((r27 & 6) == 0) goto L5;
        int r3 = r27;
    L11:
        if ((r27 & 48) != 0) goto L18;
        if (r9.changed(r23) == false) goto L15;
        int r5 = 32;
    L16:
        r3 = r3 | r5;
        goto L18
    L15:
        r5 = 16;
    L18:
        if ((r27 & 384) != 0) goto L25;
        if (r9.changedInstance(r24) == false) goto L22;
        int r6 = 256;
    L23:
        r3 = r3 | r6;
        goto L25
    L22:
        r6 = 128;
    L25:
        if ((r27 & 3072) != 0) goto L35;
        if ((r27 & 4096) != 0) goto L29;
        boolean r7 = r9.changed(r25);
    L30:
        if (r7 == false) goto L32;
        int r8 = 2048;
    L33:
        r3 = r3 | r8;
        goto L35
    L32:
        r8 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L33
    L29:
        r7 = r9.changedInstance(r25);
    L35:
        if ((r3 & 1171) != 1170) goto L41;
        if (r9.getSkipping() == false) goto L41;
        r9.skipToGroupEnd();
        Composer r10 = r9;
    L100:
        ScopeUpdateScope r11 = r10.endRestartGroup();
        if (r11 == null) goto L106;
        r11.updateScope(new P2PInfoSectionKt$P2PInfoSection$2(r22, r23, r24, r25, r27));
        return;
    L106:
        return;
    L41:
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventStart(1819751752, r3, -1, "com.ss.android.lark.compose.chatsetting.main.ui.sections.p2p.P2PInfoSection (P2PInfoSection.kt:30)");
    L43:
        final Context r0 = d8b.b.a(r9);
        r9.startReplaceGroup(-1224400529);
        if ((r3 & 14) != 4) goto L46;
        boolean r4 = true;
    L48:
        if ((r3 & 112) != 32) goto L50;
        boolean r12 = true;
    L51:
        boolean r13 = (r4 | r12) | r9.changedInstance(r24);
        if ((r3 & 7168) != 2048) goto L54;
    L59:
        boolean r14 = true;
    L60:
        boolean r15 = r13 | r14;
        Object r16 = r9.rememberedValue();
        if (r15 == false) goto L63;
    L64:
        r16 = new P2PInfoSectionKt$P2PInfoSection$viewModel$1$1(r22, r23, r24, r25);
        r9.updateRememberedValue(r16);
    L65:
        Function1 r17 = (Function1) r16;
        r9.endReplaceGroup();
        HasDefaultViewModelProviderFactory r18 = LocalViewModelStoreOwner.INSTANCE.getCurrent(r9, 6);
        if (r18 == null) goto L105;
        KClass r19 = Reflection.getOrCreateKotlinClass(P2PInfoViewModel.class);
        InitializerViewModelFactoryBuilder r110 = new InitializerViewModelFactoryBuilder();
        r110.addInitializer(Reflection.getOrCreateKotlinClass(P2PInfoViewModel.class), r17);
        ViewModelProvider.Factory r20 = r110.build();
        if ((r18 instanceof HasDefaultViewModelProviderFactory) == false) goto L70;
        CreationExtras r111 = r18.getDefaultViewModelCreationExtras();
    L71:
        final P2PInfoViewModel r112 = (P2PInfoViewModel) ViewModelKt.viewModel(r19, r18, null, r20, r111, r9, 0, 0);
        State r21 = SnapshotStateKt.collectAsState(r112.getP2pChatter(), null, r9, 0, 1);
        Modifier r28 = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.constructor-impl(16));
        MeasurePolicy r29 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12)), Alignment.Companion.getTop(), r9, 6);
        long r113 = ComposablesKt.getCurrentCompositeKeyHashCode(r9, 0);
        int r30 = (int) ((r113 >>> 32) ^ r113);
        CompositionLocalMap r114 = r9.getCurrentCompositionLocalMap();
        Modifier r31 = ComposedModifierKt.materializeModifier(r9, r28);
        ComposeUiNode.Companion r115 = ComposeUiNode.Companion;
        Function0 r32 = r115.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L74;
        ComposablesKt.invalidApplier();
    L74:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L77;
        r9.createNode(r32);
    L78:
        Composer r1 = Updater.constructor-impl(r9);
        Updater.set-impl(r1, r29, r115.getSetMeasurePolicy());
        Updater.set-impl(r1, r114, r115.getSetResolvedCompositionLocals());
        Function2 r33 = r115.getSetCompositeKeyHash();
        if (r1.getInserting() == false) goto L81;
    L82:
        r1.updateRememberedValue(Integer.valueOf(r30));
        r1.apply(Integer.valueOf(r30), r33);
    L83:
        Updater.set-impl(r1, r31, r115.getSetModifier());
        RowScopeInstance r2 = RowScopeInstance.INSTANCE;
        Chatter r34 = (Chatter) r21.getValue();
        r9.startReplaceGroup(-1921654567);
        if (r34 != null) goto L86;
        int r116 = 0;
    L92:
        r9.endReplaceGroup();
        ImageVector r117 = (ImageVector) ChatSettingIcons.i.getValue();
        Intrinsics.checkNotNullParameter(com.ss.android.lark.flow.chat.resources.b.a, "<this>");
        r10 = r9;
        String r35 = b0.a((z) CommonMainString0.r.getValue(), r10);
        long r36 = n.a(r10, r116).a.a;
        r10.startReplaceGroup(-1633490746);
        boolean r37 = r10.changedInstance(r112) | r10.changedInstance(r0);
        Object r38 = r10.rememberedValue();
        if (r37 == false) goto L95;
    L96:
        r38 = new P2PInfoSectionKt$P2PInfoSection$1$2$1(r112, r0);
        r10.updateRememberedValue(r38);
    L97:
        r10.endReplaceGroup();
        DashedCellKt.a(null, r117, r35, r36, (Function0) r38, r10, 0, 1);
        r10.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L100;
        ComposerKt.traceEventEnd();
        goto L100
    L95:
        if (r38 != Composer.Companion.getEmpty()) goto L97;
    L86:
        r9.startReplaceGroup(-1633490746);
        boolean r39 = r9.changedInstance(r112) | r9.changedInstance(r0);
        Object r40 = r9.rememberedValue();
        if (r39 == false) goto L89;
    L90:
        r40 = new P2PInfoSectionKt$P2PInfoSection$1$1$1$1(r112, r0);
        r9.updateRememberedValue(r40);
    L91:
        r9.endReplaceGroup();
        r116 = 0;
        ChatterCellKt.a(null, r34, r24, (Function1) r40, r9, r3 & 896, 1);
        goto L92
    L89:
        if (r40 != Composer.Companion.getEmpty()) goto L91;
    L81:
        if (Intrinsics.areEqual(r1.rememberedValue(), Integer.valueOf(r30)) == true) goto L83;
    L77:
        r9.useNode();
        goto L78
    L70:
        r111 = CreationExtras.Empty.INSTANCE;
        goto L71
    L105:
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    L63:
        if (r16 != Composer.Companion.getEmpty()) goto L65;
    L54:
        if ((r3 & 4096) != 0) goto L56;
    L58:
        r14 = false;
        goto L60
    L56:
        if (r9.changedInstance(r25) == false) goto L58;
    L50:
        r12 = false;
        goto L51
    L46:
        r4 = false;
        goto L48
    L5:
        if (r9.changed(r22) == false) goto L7;
        int r41 = 4;
    L8:
        r3 = r41 | r27;
        goto L11
    L7:
        r41 = 2;
        goto L8
    }
}
