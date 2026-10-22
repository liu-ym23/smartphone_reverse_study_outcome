package com.ss.android.lark.compose.chatterselector;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.chat_member_list.ChatMemberListComponentsKt;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import java.util.List;
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
public final class FixedChatterSelectorScreenKt {
    public static final void a(final String r30, final List<String> r31, final com.lark.kmp.rustclient.api.d r32, Set<String> r33, boolean r34, String r35, String r36, Function0<Unit> r37, Function1<? super Set<String>, Unit> r38, Composer r39, final int r40, final int r41) {
        Intrinsics.checkNotNullParameter(r30, "title");
        Intrinsics.checkNotNullParameter(r31, "chatterIds");
        Intrinsics.checkNotNullParameter(r32, "rustClient");
        Composer r13 = r39.startRestartGroup(-1843502078);
        if ((r41 & 1) == 0) goto L6;
        int r4 = r40 | 6;
    L14:
        if ((r41 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        if ((r41 & 4) == 0) goto L27;
        r4 = r4 | 384;
    L33:
        int r5 = r41 & 8;
        if (r5 == 0) goto L37;
        r4 = r4 | 3072;
    L44:
        int r7 = r41 & 16;
        if (r7 == 0) goto L48;
        r4 = r4 | 24576;
    L54:
        boolean r9 = r34;
    L56:
        if ((196608 & r40) == 0) goto L58;
        String r10 = r35;
    L67:
        if ((1572864 & r40) != 0) goto L77;
        if ((r41 & 64) != 0) goto L74;
        if (r13.changed(r36) == false) goto L74;
        int r16 = 1048576;
    L75:
        r4 = r4 | r16;
    L74:
        r16 = 524288;
    L77:
        int r12 = r41 & 128;
        if (r12 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r3 = r41 & 256;
        if (r3 == 0) goto L90;
        r4 = r4 | 100663296;
        Function1<? super Set<String>, Unit> r11 = r38;
    L98:
        if ((r4 & 38347923) == 38347922) goto L100;
    L103:
        r13.startDefaults();
        if ((r40 & 1) != 0) goto L106;
    L115:
        if (r5 == 0) goto L117;
        Set<String> r6 = SetsKt.emptySet();
    L118:
        if (r7 == 0) goto L121;
        r9 = false;
    L121:
        if ((r41 & 32) == 0) goto L123;
        Intrinsics.checkNotNullParameter(com.ss.android.lark.flow.chat.resources.b.a, "<this>");
        String r8 = b0.a((z) CommonMainString0.l0.getValue(), r13);
        r4 = r4 & (-458753);
    L125:
        if ((r41 & 64) == 0) goto L127;
        String r14 = "fixed_chatter_selector#" + r30 + '#' + r9 + '#' + r31.hashCode();
        r4 = r4 & (-3670017);
    L129:
        if (r12 == 0) goto L134;
        r13.startReplaceGroup(1849434622);
        Object r15 = r13.rememberedValue();
        if (r15 != Composer.Companion.getEmpty()) goto L133;
        r15 = FixedChatterSelectorScreenKt$FixedChatterSelectorScreen$1$1.INSTANCE;
        r13.updateRememberedValue(r15);
    L133:
        Function0<Unit> r17 = (Function0) r15;
        r13.endReplaceGroup();
    L135:
        if (r3 == 0) goto L140;
        r13.startReplaceGroup(1849434622);
        Object r18 = r13.rememberedValue();
        if (r18 != Composer.Companion.getEmpty()) goto L139;
        r18 = FixedChatterSelectorScreenKt$FixedChatterSelectorScreen$2$1.INSTANCE;
        r13.updateRememberedValue(r18);
    L139:
        r13.endReplaceGroup();
        r11 = (Function1) r18;
    L140:
        final Set<String> r19 = r6;
        String r110 = r8;
        String r20 = r14;
        final boolean r21 = r9;
        int r22 = r4;
        Function1<? super Set<String>, Unit> r29 = r11;
        final Function0<Unit> r111 = r17;
        r13.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L143;
        ComposerKt.traceEventStart(-1843502078, r22, -1, "com.ss.android.lark.compose.chatterselector.FixedChatterSelectorScreen (FixedChatterSelectorScreen.kt:41)");
    L143:
        r13.startReplaceGroup(-1224400529);
        boolean r23 = (r13.changedInstance(r31) | r13.changedInstance(r32)) | r13.changedInstance(r19);
        if ((57344 & r22) != 16384) goto L146;
        boolean r24 = true;
    L147:
        boolean r25 = r23 | r24;
        Object r26 = r13.rememberedValue();
        if (r25 == false) goto L150;
    L151:
        r26 = new FixedChatterSelectorScreenKt$FixedChatterSelectorScreen$viewModel$1$1(r31, r32, r19, r21);
        r13.updateRememberedValue(r26);
    L152:
        Function1 r27 = (Function1) r26;
        r13.endReplaceGroup();
        int r28 = (r22 >> 15) & 112;
        HasDefaultViewModelProviderFactory r42 = LocalViewModelStoreOwner.INSTANCE.getCurrent(r13, 6);
        if (r42 == null) goto L200;
        KClass r112 = Reflection.getOrCreateKotlinClass(FixedChatterSelectorViewModel.class);
        InitializerViewModelFactoryBuilder r43 = new InitializerViewModelFactoryBuilder();
        r43.addInitializer(Reflection.getOrCreateKotlinClass(FixedChatterSelectorViewModel.class), r27);
        ViewModelProvider.Factory r44 = r43.build();
        if ((r42 instanceof HasDefaultViewModelProviderFactory) == false) goto L157;
        CreationExtras r45 = r42.getDefaultViewModelCreationExtras();
    L158:
        int r46 = r28 << 3;
        final FixedChatterSelectorViewModel r47 = (FixedChatterSelectorViewModel) ViewModelKt.viewModel(r112, r42, r20, r44, r45, r13, (r46 & 112) | (r46 & 896), 0);
        final State r113 = SnapshotStateKt.collectAsState(r47.getUiState(), null, r13, 0, 1);
        com.ss.android.lark.flow.chat.resources.b r48 = com.ss.android.lark.flow.chat.resources.b.a;
        String r114 = b0.a(com.ss.android.lark.flow.chat.resources.c.b(), r13);
        Modifier.Companion r49 = Modifier.Companion;
        Modifier r50 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(r49, 0.0f, 1, null), n.a(r13, 0).c.e, null, 2, null);
        MeasurePolicy r51 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r13, 0);
        long r52 = ComposablesKt.getCurrentCompositeKeyHashCode(r13, 0);
        int r53 = (int) (r52 ^ (r52 >>> 32));
        CompositionLocalMap r54 = r13.getCurrentCompositionLocalMap();
        Modifier r55 = ComposedModifierKt.materializeModifier(r13, r50);
        ComposeUiNode.Companion r115 = ComposeUiNode.Companion;
        Function0 r116 = r115.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L161;
        ComposablesKt.invalidApplier();
    L161:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L164;
        r13.createNode(r116);
    L165:
        Composer r117 = Updater.constructor-impl(r13);
        Updater.set-impl(r117, r51, r115.getSetMeasurePolicy());
        Updater.set-impl(r117, r54, r115.getSetResolvedCompositionLocals());
        Function2 r56 = r115.getSetCompositeKeyHash();
        if (r117.getInserting() == false) goto L168;
    L169:
        r117.updateRememberedValue(Integer.valueOf(r53));
        r117.apply(Integer.valueOf(r53), r56);
    L170:
        Updater.set-impl(r117, r55, r115.getSetModifier());
        ColumnScopeInstance r57 = ColumnScopeInstance.INSTANCE;
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(r49, Dp.constructor-impl(8)), r13, 6);
        ChatMemberListComponentsKt.b(r30, null, ComposableLambdaKt.rememberComposableLambda(-497108594, true, new FixedChatterSelectorScreenKt$FixedChatterSelectorScreen$3$1(r111), r13, 54), null, r13, (r22 & 14) | 384, 10);
        String r58 = ((b) r113.getValue()).a;
        r13.startReplaceGroup(5004770);
        boolean r59 = r13.changedInstance(r47);
        Object r60 = r13.rememberedValue();
        if (r59 == false) goto L173;
    L174:
        r60 = new FixedChatterSelectorScreenKt$FixedChatterSelectorScreen$3$2$1(r47);
        r13.updateRememberedValue(r60);
    L175:
        r13.endReplaceGroup();
        ChatMemberListComponentsKt.a(r58, (Function1) r60, r110, null, r13, (r22 >> 9) & 896, 8);
        Modifier r61 = ColumnScope.-CC.weight$default(r57, r49, 1.0f, false, 2, null);
        List<a> r62 = ((b) r113.getValue()).b;
        Set<String> r63 = ((b) r113.getValue()).c;
        r13.startReplaceGroup(5004770);
        boolean r64 = r13.changedInstance(r47);
        Object r65 = r13.rememberedValue();
        if (r64 == false) goto L178;
    L179:
        r65 = new FixedChatterSelectorScreenKt$FixedChatterSelectorScreen$3$3$1(r47);
        r13.updateRememberedValue(r65);
    L180:
        r13.endReplaceGroup();
        ChatterSelectorScreenKt.b(r62, r32, r63, (Function2) r65, r61, false, false, null, false, null, r13, ((r22 >> 3) & 112) | 1769472, 896);
        int r66 = ((b) r113.getValue()).c.size();
        r13.startReplaceGroup(-1633490746);
        if ((r22 & 234881024) != 67108864) goto L183;
        boolean r118 = true;
    L184:
        boolean r67 = r13.changed(r33) | r118;
        Object r68 = r13.rememberedValue();
        if (r67 == false) goto L187;
    L190:
        final Function1<? super Set<String>, Unit> r119 = r29;
        r68 = new FixedChatterSelectorScreenKt$FixedChatterSelectorScreen$3$4$1(r119, r113);
        r13.updateRememberedValue(r68);
    L191:
        r13.endReplaceGroup();
        ChatterSelectorScreenKt.a(r66, r114, (Function0) r68, null, false, false, r13, 0, 56);
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L194;
        ComposerKt.traceEventEnd();
    L194:
        final Function1<? super Set<String>, Unit> r69 = r119;
        final Set<String> r70 = r19;
        final String r71 = r110;
        final String r72 = r20;
        final Function0<Unit> r73 = r111;
        final boolean r74 = r21;
    L195:
        ScopeUpdateScope r120 = r13.endRestartGroup();
        if (r120 == null) goto L201;
        r120.updateScope(new FixedChatterSelectorScreenKt$FixedChatterSelectorScreen$4(r30, r31, r32, r70, r74, r71, r72, r73, r69, r40, r41));
        return;
    L201:
        return;
    L187:
        if (r68 == Composer.Companion.getEmpty()) goto L190;
        r119 = r29;
        goto L191
    L183:
        r118 = false;
        goto L184
    L178:
        if (r65 != Composer.Companion.getEmpty()) goto L180;
    L173:
        if (r60 != Composer.Companion.getEmpty()) goto L175;
    L168:
        if (Intrinsics.areEqual(r117.rememberedValue(), Integer.valueOf(r53)) == true) goto L170;
    L164:
        r13.useNode();
        goto L165
    L157:
        r45 = CreationExtras.Empty.INSTANCE;
        goto L158
    L200:
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    L150:
        if (r26 != Composer.Companion.getEmpty()) goto L152;
    L146:
        r24 = false;
        goto L147
    L134:
        r17 = r37;
        goto L135
    L127:
        r14 = r36;
        goto L129
    L123:
        r8 = r10;
        goto L125
    L117:
        r6 = r33;
        goto L118
    L106:
        if (r13.getDefaultsInvalid() == true) goto L115;
        r13.skipToGroupEnd();
        if ((r41 & 32) == 0) goto L112;
        r4 = r4 & (-458753);
    L112:
        if ((r41 & 64) == 0) goto L114;
        r4 = r4 & (-3670017);
    L114:
        r6 = r33;
        r14 = r36;
        r8 = r10;
        r17 = r37;
        goto L140
    L100:
        if (r13.getSkipping() == false) goto L103;
        r13.skipToGroupEnd();
        r70 = r33;
        r72 = r36;
        r73 = r37;
        r74 = r9;
        r71 = r10;
        r69 = r11;
        goto L195
    L90:
        r11 = r38;
        if ((r40 & 100663296) != 0) goto L98;
        if (r13.changedInstance(r11) == false) goto L95;
        int r121 = 67108864;
    L96:
        r4 = r4 | r121;
        goto L98
    L95:
        r121 = 33554432;
        goto L96
    L81:
        if ((r40 & 12582912) != 0) goto L87;
        if (r13.changedInstance(r37) == false) goto L85;
        int r122 = 8388608;
    L86:
        r4 = r4 | r122;
        goto L87
    L85:
        r122 = 4194304;
        goto L86
    L58:
        if ((r41 & 32) != 0) goto L62;
        r10 = r35;
        if (r13.changed(r10) == false) goto L63;
        int r123 = 131072;
    L64:
        r4 = r4 | r123;
    L63:
        r123 = 65536;
        goto L64
    L62:
        r10 = r35;
        goto L63
    L48:
        if ((r40 & 24576) != 0) goto L54;
        r9 = r34;
        if (r13.changed(r9) == false) goto L52;
        int r124 = 16384;
    L53:
        r4 = r4 | r124;
        goto L56
    L52:
        r124 = 8192;
        goto L53
    L37:
        if ((r40 & 3072) != 0) goto L44;
        if (r13.changedInstance(r33) == false) goto L41;
        int r75 = 2048;
    L42:
        r4 = r4 | r75;
        goto L44
    L41:
        r75 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L42
    L27:
        if ((r40 & 384) != 0) goto L33;
        if (r13.changedInstance(r32) == false) goto L31;
        int r76 = 256;
    L32:
        r4 = r4 | r76;
        goto L33
    L31:
        r76 = 128;
        goto L32
    L17:
        if ((r40 & 48) != 0) goto L24;
        if (r13.changedInstance(r31) == false) goto L21;
        int r77 = 32;
    L22:
        r4 = r4 | r77;
        goto L24
    L21:
        r77 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r4 = r40;
        goto L14
    L8:
        if (r13.changed(r30) == false) goto L10;
        int r78 = 4;
    L11:
        r4 = r78 | r40;
        goto L14
    L10:
        r78 = 2;
        goto L11
    }
}
