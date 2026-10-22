package com.ss.android.lark.compose.chatsetting.update_manager;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
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
import com.ss.android.lark.flow.chat.resources.c;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Set;
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
public final class UpdateManagerScreenKt {
    public static final void a(final String r47, final d r48, final com.ss.android.lark.compose.chatsetting.common.platform.a r49, final com.ss.android.lark.compose.chatsetting.common.platform.b r50, Function0<Unit> r51, Function0<Unit> r52, String r53, Composer r54, final int r55, final int r56) {
        Intrinsics.checkNotNullParameter(r47, "chatId");
        Intrinsics.checkNotNullParameter(r48, "rustClient");
        Intrinsics.checkNotNullParameter(r49, "childScreenHost");
        Intrinsics.checkNotNullParameter(r50, "platformEffects");
        Composer r10 = r54.startRestartGroup(-1088802216);
        if ((r56 & 1) == 0) goto L6;
        int r1 = r55 | 6;
    L14:
        if ((r56 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r56 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L37:
        if ((r56 & 8) == 0) goto L40;
        r1 = r1 | 3072;
    L49:
        int r3 = r56 & 16;
        if (r3 == 0) goto L53;
        r1 = r1 | 24576;
    L59:
        Function0<Unit> r4 = r51;
    L60:
        int r5 = r56 & 32;
        if (r5 == 0) goto L63;
        r1 = r1 | 196608;
        final Function0<Unit> r6 = r52;
    L70:
        int r16 = r56 & 64;
        if (r16 == 0) goto L73;
        r1 = r1 | 1572864;
        final String r7 = r53;
    L81:
        if ((r1 & 599187) == 599186) goto L83;
    L86:
        if (r3 == 0) goto L88;
        Function0<Unit> r42 = null;
    L89:
        if (r5 == 0) goto L91;
        Function0<Unit> r43 = null;
    L92:
        if (r16 == 0) goto L94;
        String r8 = BuildConfig.FLAVOR;
    L96:
        if (ComposerKt.isTraceInProgress() == false) goto L99;
        ComposerKt.traceEventStart(-1088802216, r1, -1, "com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerScreen (UpdateManagerScreen.kt:43)");
    L99:
        if (r8.length() != 0) goto L101;
        boolean r0 = true;
    L103:
        if (r0 == false) goto L105;
        String r2 = "update_manager_vm#" + r47;
    L106:
        String r9 = r2;
        r10.startReplaceGroup(-1633490746);
        if ((r1 & 14) != 4) goto L109;
        boolean r11 = true;
    L110:
        boolean r12 = r11 | r10.changedInstance(r48);
        Object r13 = r10.rememberedValue();
        if (r12 == false) goto L113;
    L114:
        r13 = new UpdateManagerScreenKt$UpdateManagerScreen$viewModel$1$1(r47, r48);
        r10.updateRememberedValue(r13);
    L115:
        Function1 r14 = (Function1) r13;
        r10.endReplaceGroup();
        HasDefaultViewModelProviderFactory r15 = LocalViewModelStoreOwner.INSTANCE.getCurrent(r10, 6);
        if (r15 == null) goto L229;
        KClass r17 = Reflection.getOrCreateKotlinClass(UpdateManagerViewModel.class);
        InitializerViewModelFactoryBuilder r18 = new InitializerViewModelFactoryBuilder();
        r18.addInitializer(Reflection.getOrCreateKotlinClass(UpdateManagerViewModel.class), r14);
        ViewModelProvider.Factory r19 = r18.build();
        if ((r15 instanceof HasDefaultViewModelProviderFactory) == false) goto L120;
        CreationExtras r20 = r15.getDefaultViewModelCreationExtras();
    L121:
        int r21 = r1;
        final String r57 = r8;
        final UpdateManagerViewModel r22 = (UpdateManagerViewModel) ViewModelKt.viewModel(r17, r15, r9, r19, r20, r10, 0, 0);
        r10.startReplaceGroup(1633111876);
        if (r42 != null) goto L127;
        r10.startReplaceGroup(1849434622);
        Object r23 = r10.rememberedValue();
        if (r23 != Composer.Companion.getEmpty()) goto L126;
        r23 = UpdateManagerScreenKt$UpdateManagerScreen$actualOnBack$1$1.INSTANCE;
        r10.updateRememberedValue(r23);
    L126:
        r10.endReplaceGroup();
        final Function0<Unit> r24 = (Function0) r23;
    L128:
        r10.endReplaceGroup();
        Context r25 = d8b.b.a(r10);
        r10.startReplaceGroup(-1633490746);
        boolean r26 = r10.changed(r24);
        if ((r21 & 896) != 256) goto L131;
    L136:
        boolean r27 = true;
    L137:
        boolean r28 = r26 | r27;
        Object r29 = r10.rememberedValue();
        if (r28 == false) goto L140;
    L141:
        r29 = new UpdateManagerScreenKt$UpdateManagerScreen$onBackWithKeyboardHandling$1$1(r49, r24);
        r10.updateRememberedValue(r29);
    L142:
        Function0 r110 = (Function0) r29;
        r10.endReplaceGroup();
        final State r30 = SnapshotStateKt.collectAsState(r22.getLoading(), null, r10, 0, 1);
        State r111 = SnapshotStateKt.collectAsState(r22.getAdminLoaded(), null, r10, 0, 1);
        final State r31 = SnapshotStateKt.collectAsState(r22.getCurrentAdminIds(), null, r10, 0, 1);
        com.ss.android.lark.flow.chat.resources.b r32 = com.ss.android.lark.flow.chat.resources.b.a;
        Intrinsics.checkNotNullParameter(r32, "<this>");
        String r33 = b0.a((z) CommonMainString0.C0.getValue(), r10);
        Intrinsics.checkNotNullParameter(r32, "<this>");
        String r34 = b0.a((z) CommonMainString0.B0.getValue(), r10);
        r10.startReplaceGroup(-1224400529);
        boolean r35 = r10.changedInstance(r22);
        if ((r21 & 458752) != 131072) goto L145;
        boolean r36 = true;
    L146:
        boolean r37 = r36 | r35;
        int r38 = r21 & 7168;
        if (r38 != 2048) goto L149;
    L154:
        boolean r39 = true;
    L155:
        boolean r40 = ((((r37 | r39) | r10.changedInstance(r25)) | r10.changed(r33)) | r10.changed(r24)) | r10.changed(r34);
        Object r41 = r10.rememberedValue();
        if (r40 == false) goto L158;
    L161:
        final Context r210 = r25;
        UpdateManagerScreenKt$UpdateManagerScreen$1$1 r44 = new UpdateManagerScreenKt$UpdateManagerScreen$1$1(r22, r43, r50, r25, r33, r24, r34, null);
        r10.updateRememberedValue(r44);
        r41 = r44;
    L162:
        r10.endReplaceGroup();
        boolean r45 = false;
        EffectsKt.LaunchedEffect(r22, (Function2) r41, r10, 0);
        r10.startReplaceGroup(1633158975);
        if (((Boolean) r111.getValue()).booleanValue() == true) goto L183;
        Modifier r46 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), n.a(r10, 0).c.e, null, 2, null);
        MeasurePolicy r58 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        long r59 = ComposablesKt.getCurrentCompositeKeyHashCode(r10, 0);
        int r60 = (int) (r59 ^ (r59 >>> 32));
        CompositionLocalMap r61 = r10.getCurrentCompositionLocalMap();
        Modifier r62 = ComposedModifierKt.materializeModifier(r10, r46);
        ComposeUiNode.Companion r63 = ComposeUiNode.Companion;
        Function0 r64 = r63.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L167;
        ComposablesKt.invalidApplier();
    L167:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L170;
        r10.createNode(r64);
    L171:
        Composer r65 = Updater.constructor-impl(r10);
        Updater.set-impl(r65, r58, r63.getSetMeasurePolicy());
        Updater.set-impl(r65, r61, r63.getSetResolvedCompositionLocals());
        Function2 r66 = r63.getSetCompositeKeyHash();
        if (r65.getInserting() == false) goto L174;
    L175:
        r65.updateRememberedValue(Integer.valueOf(r60));
        r65.apply(Integer.valueOf(r60), r66);
    L176:
        Updater.set-impl(r65, r62, r63.getSetModifier());
        BoxScopeInstance r67 = BoxScopeInstance.INSTANCE;
        Intrinsics.checkNotNullParameter(r32, "<this>");
        TextKt.Text-Nvy7gAk(b0.a((z) CommonMainString0.x2.getValue(), r10), null, n.a(r10, 0).d.b, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r10, 0, 0, 262138);
        r10.endNode();
        r10.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L179;
        ComposerKt.traceEventEnd();
    L179:
        ScopeUpdateScope r112 = r10.endRestartGroup();
        if (r112 == null) goto L230;
        final Function0<Unit> r68 = r42;
        final Function0<Unit> r69 = r43;
        r112.updateScope(new UpdateManagerScreenKt$UpdateManagerScreen$3(r47, r48, r49, r50, r68, r69, r57, r55, r56));
        return;
    L230:
        return;
    L174:
        if (Intrinsics.areEqual(r65.rememberedValue(), Integer.valueOf(r60)) == true) goto L176;
    L170:
        r10.useNode();
        goto L171
    L183:
        r10.endReplaceGroup();
        final String r70 = b0.a(c.b(), r10);
        Intrinsics.checkNotNullParameter(r54, "<this>");
        final String r71 = b0.a((z) CommonMainString0.N.getValue(), r10);
        Intrinsics.checkNotNullParameter(r54, "<this>");
        String r72 = b0.a((z) CommonMainString0.F0.getValue(), r10);
        Set r73 = (Set) r53.getValue();
        if (r57.length() != 0) goto L186;
        boolean r74 = true;
    L188:
        if (r74 == false) goto L190;
        StringBuilder r75 = new StringBuilder("update_manager#");
        r75.append(r47);
        String r76 = r75.toString();
        String r77 = r57;
    L191:
        String r113 = r76;
        Intrinsics.checkNotNullParameter(r54, "<this>");
        String r211 = b0.a((z) CommonMainString0.H.getValue(), r10);
        r10.startReplaceGroup(-1746271574);
        if (r38 != 2048) goto L194;
    L199:
        r45 = true;
    L200:
        boolean r78 = r45 | r10.changedInstance(r210);
        Object r114 = r10.rememberedValue();
        if (r78 == false) goto L203;
    L204:
        final String r79 = "最多选择 10 个群管理员";
        r114 = new UpdateManagerScreenKt$UpdateManagerScreen$4$1(r50, r210, r79);
        r10.updateRememberedValue(r114);
    L205:
        Function0 r115 = (Function0) r114;
        r10.endReplaceGroup();
        r10.startReplaceGroup(5004770);
        boolean r80 = r10.changed(r31);
        Object r116 = r10.rememberedValue();
        if (r80 == false) goto L208;
    L209:
        r116 = new UpdateManagerScreenKt$UpdateManagerScreen$5$1(r31);
        r10.updateRememberedValue(r116);
    L210:
        Function1 r117 = (Function1) r116;
        r10.endReplaceGroup();
        r10.startReplaceGroup(-1633490746);
        boolean r81 = r10.changed(r71) | r10.changed(r70);
        Object r82 = r10.rememberedValue();
        if (r81 == false) goto L213;
    L214:
        r82 = new UpdateManagerScreenKt$UpdateManagerScreen$6$1(r71, r70);
        r10.updateRememberedValue(r82);
    L215:
        Function1 r212 = (Function1) r82;
        r10.endReplaceGroup();
        r10.startReplaceGroup(-1633490746);
        boolean r83 = r10.changed(r30) | r10.changedInstance(r22);
        Object r84 = r10.rememberedValue();
        if (r83 == false) goto L218;
    L219:
        r84 = new UpdateManagerScreenKt$UpdateManagerScreen$7$1(r22, r30);
        r10.updateRememberedValue(r84);
    L220:
        r10.endReplaceGroup();
        int r85 = r21 << 3;
        String r213 = r77;
        Composer r214 = r10;
        ChatterSelectorScreenKt.c(r72, r47, r48, r50, r73, 10, r115, false, true, false, true, r117, r212, null, r211, r113, r110, (Function1) r84, r214, ((r85 & 896) | ((r85 & 112) | 918749184)) | r38, 3078, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L223;
        ComposerKt.traceEventEnd();
    L223:
        r7 = r213;
        final Function0<Unit> r86 = r42;
        r6 = r43;
    L224:
        ScopeUpdateScope r118 = r214.endRestartGroup();
        if (r118 == null) goto L231;
        r118.updateScope(new UpdateManagerScreenKt$UpdateManagerScreen$8(r47, r48, r49, r50, r86, r6, r7, r55, r56));
        return;
    L231:
        return;
    L218:
        if (r84 != Composer.Companion.getEmpty()) goto L220;
    L213:
        if (r82 != Composer.Companion.getEmpty()) goto L215;
    L208:
        if (r116 != Composer.Companion.getEmpty()) goto L210;
    L203:
        if (r114 != Composer.Companion.getEmpty()) goto L205;
    L194:
        if ((r21 & 4096) == 0) goto L200;
        if (r10.changedInstance(r50) == false) goto L200;
    L190:
        r75 = new StringBuilder("update_manager#");
        r75.append(r47);
        r75.append('#');
        r77 = r57;
        r75.append(r77);
        r76 = r75.toString();
        goto L191
    L186:
        r74 = false;
        goto L188
    L158:
        if (r41 == Composer.Companion.getEmpty()) goto L161;
        r210 = r25;
        goto L162
    L149:
        if ((r21 & 4096) != 0) goto L151;
    L153:
        r39 = false;
        goto L155
    L151:
        if (r10.changedInstance(r50) == false) goto L153;
    L145:
        r36 = false;
        goto L146
    L140:
        if (r29 != Composer.Companion.getEmpty()) goto L142;
    L131:
        if ((r21 & 512) != 0) goto L133;
    L135:
        r27 = false;
        goto L137
    L133:
        if (r10.changed(r49) == false) goto L135;
    L127:
        r24 = r42;
        goto L128
    L120:
        r20 = CreationExtras.Empty.INSTANCE;
        goto L121
    L229:
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    L113:
        if (r13 != Composer.Companion.getEmpty()) goto L115;
    L109:
        r11 = false;
        goto L110
    L105:
        r2 = "update_manager_vm#" + r47 + '#' + r8;
        goto L106
    L101:
        r0 = false;
        goto L103
    L94:
        r8 = r7;
        goto L96
    L91:
        r43 = r6;
        goto L92
    L88:
        r42 = r4;
        goto L89
    L83:
        if (r10.getSkipping() == false) goto L86;
        r10.skipToGroupEnd();
        r86 = r4;
        r214 = r10;
        goto L224
    L73:
        r7 = r53;
        if ((r55 & 1572864) != 0) goto L81;
        if (r10.changed(r7) == false) goto L78;
        int r119 = 1048576;
    L79:
        r1 = r1 | r119;
        goto L81
    L78:
        r119 = 524288;
        goto L79
    L63:
        r6 = r52;
        if ((r55 & 196608) != 0) goto L70;
        if (r10.changedInstance(r6) == false) goto L68;
        int r120 = 131072;
    L69:
        r1 = r1 | r120;
        goto L70
    L68:
        r120 = 65536;
        goto L69
    L53:
        if ((r55 & 24576) != 0) goto L59;
        r4 = r51;
        if (r10.changedInstance(r4) == false) goto L57;
        int r87 = 16384;
    L58:
        r1 = r1 | r87;
        goto L60
    L57:
        r87 = 8192;
        goto L58
    L40:
        if ((r55 & 3072) != 0) goto L49;
        if ((r55 & 4096) != 0) goto L44;
        boolean r88 = r10.changed(r50);
    L45:
        if (r88 == false) goto L47;
        int r89 = 2048;
    L48:
        r1 = r1 | r89;
        goto L49
    L47:
        r89 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L48
    L44:
        r88 = r10.changedInstance(r50);
        goto L45
    L27:
        if ((r55 & 384) != 0) goto L37;
        if ((r55 & 512) != 0) goto L31;
        boolean r90 = r10.changed(r49);
    L32:
        if (r90 == false) goto L34;
        int r91 = 256;
    L35:
        r1 = r1 | r91;
        goto L37
    L34:
        r91 = 128;
        goto L35
    L31:
        r90 = r10.changedInstance(r49);
        goto L32
    L17:
        if ((r55 & 48) != 0) goto L24;
        if (r10.changedInstance(r48) == false) goto L21;
        int r92 = 32;
    L22:
        r1 = r1 | r92;
        goto L24
    L21:
        r92 = 16;
        goto L22
    L6:
        if ((r55 & 6) == 0) goto L8;
        r1 = r55;
        goto L14
    L8:
        if (r10.changed(r47) == false) goto L10;
        int r93 = 4;
    L11:
        r1 = r93 | r55;
        goto L14
    L10:
        r93 = 2;
        goto L11
    }
}
