package com.ss.android.lark.compose.chat_member_list;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatMembersListScreenKt {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(ChatMembersListScreenKt$MoreHorizIcon$2.INSTANCE);
    }

    public static final void c(final float r25, final float r26, final ImageVector r27, final List<c> r28, Composer r29, final int r30) {
        Intrinsics.checkNotNullParameter(r27, "icon");
        Intrinsics.checkNotNullParameter(r28, "items");
        Composer r14 = r29.startRestartGroup(-727197502);
        if ((r30 & 6) == 0) goto L5;
        int r3 = r30;
    L11:
        if ((r30 & 48) != 0) goto L18;
        if (r14.changed(r26) == false) goto L15;
        int r5 = 32;
    L16:
        r3 = r3 | r5;
        goto L18
    L15:
        r5 = 16;
    L18:
        if ((r30 & 384) != 0) goto L25;
        if (r14.changed(r27) == false) goto L22;
        int r6 = 256;
    L23:
        r3 = r3 | r6;
        goto L25
    L22:
        r6 = 128;
    L25:
        if ((r30 & 3072) != 0) goto L32;
        if (r14.changedInstance(r28) == false) goto L29;
        int r7 = 2048;
    L30:
        r3 = r3 | r7;
        goto L32
    L29:
        r7 = ChameleonContainerUtils.MAX_URL_LENGTH;
    L32:
        if ((r3 & 1171) != 1170) goto L38;
        if (r14.getSkipping() == false) goto L38;
        r14.skipToGroupEnd();
    L62:
        ScopeUpdateScope r8 = r14.endRestartGroup();
        if (r8 == null) goto L66;
        r8.updateScope(new ChatMembersListScreenKt$ChatMembersTopBarMoreMenuAction$5(r25, r26, r27, r28, r30));
        return;
    L66:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(-727197502, r3, -1, "com.ss.android.lark.compose.chat_member_list.ChatMembersTopBarMoreMenuAction (ChatMembersListScreen.kt:268)");
    L40:
        r14.startReplaceGroup(1849434622);
        Object r9 = r14.rememberedValue();
        Composer.Companion r15 = Composer.Companion;
        if (r9 != r15.getEmpty()) goto L43;
        r9 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r14.updateRememberedValue(r9);
    L43:
        final MutableState r10 = (MutableState) r9;
        r14.endReplaceGroup();
        r14.startReplaceGroup(1849434622);
        Object r4 = r14.rememberedValue();
        if (r4 != r15.getEmpty()) goto L46;
        r4 = InteractionSourceKt.MutableInteractionSource();
        r14.updateRememberedValue(r4);
    L46:
        MutableInteractionSource r17 = (MutableInteractionSource) r4;
        r14.endReplaceGroup();
        long r11 = n.a(r14, 0).d.a;
        Modifier r16 = TestTagKt.testTag(SizeKt.size-3ABfNKs(Modifier.Companion, r25), "chat_members_top_bar_more");
        r14.startReplaceGroup(5004770);
        Object r12 = r14.rememberedValue();
        if (r12 != r15.getEmpty()) goto L49;
        r12 = new ChatMembersListScreenKt$ChatMembersTopBarMoreMenuAction$1$1(r10);
        r14.updateRememberedValue(r12);
    L49:
        r14.endReplaceGroup();
        IconKt.Icon-ww6aTOc(r27, null, ClickableKt.clickable-O2vRcR0$default(r16, r17, null, false, null, null, (Function0) r12, 28, null), r11, r14, ((r3 >> 6) & 14) | 48, 0);
        if (((Boolean) r10.getValue()).booleanValue() == false) goto L60;
        r14.startReplaceGroup(1849434622);
        Object r0 = r14.rememberedValue();
        if (r0 != r15.getEmpty()) goto L54;
        r0 = b.a;
        r14.updateRememberedValue(r0);
    L54:
        b r13 = (b) r0;
        r14.endReplaceGroup();
        r14.startReplaceGroup(5004770);
        Object r1 = r14.rememberedValue();
        if (r1 != r15.getEmpty()) goto L57;
        final MutableState r18 = r10;
        r1 = new ChatMembersListScreenKt$ChatMembersTopBarMoreMenuAction$3$1(r18);
        r14.updateRememberedValue(r1);
    L58:
        r14.endReplaceGroup();
        AndroidPopup_androidKt.Popup(r13, (Function0) r1, new PopupProperties(true, true, true, false, 8, null), ComposableLambdaKt.rememberComposableLambda(2020379625, true, new ChatMembersListScreenKt$ChatMembersTopBarMoreMenuAction$4(r26, r28, r18), r14, 54), r14, 3510, 0);
        goto L60
    L57:
        r18 = r10;
    L60:
        if (ComposerKt.isTraceInProgress() == false) goto L62;
        ComposerKt.traceEventEnd();
        goto L62
    L5:
        if (r14.changed(r25) == false) goto L7;
        int r19 = 4;
    L8:
        r3 = r19 | r30;
        goto L11
    L7:
        r19 = 2;
        goto L8
    }

    public static final void a(final List<com.ss.android.lark.compose.chatterselector.a> r20, final com.lark.kmp.rustclient.api.d r21, Modifier r22, boolean r23, boolean r24, Function0<Unit> r25, Function1<? super com.ss.android.lark.compose.chatterselector.a, Unit> r26, Composer r27, final int r28, final int r29) {
        Intrinsics.checkNotNullParameter(r20, "chatters");
        Intrinsics.checkNotNullParameter(r21, "rustClient");
        Composer r13 = r27.startRestartGroup(512385660);
        if ((r29 & 1) == 0) goto L6;
        int r1 = r28 | 6;
    L14:
        if ((r29 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r29 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r4 = r29 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        boolean r5 = r23;
    L45:
        int r6 = r29 & 16;
        if (r6 == 0) goto L49;
        r1 = r1 | 24576;
    L55:
        boolean r7 = r24;
    L56:
        int r8 = r29 & 32;
        if (r8 == 0) goto L60;
        r1 = r1 | 196608;
    L66:
        Function0<Unit> r9 = r25;
    L67:
        int r14 = r29 & 64;
        if (r14 == 0) goto L71;
        r1 = r1 | 1572864;
    L77:
        Function1<? super com.ss.android.lark.compose.chatterselector.a, Unit> r15 = r26;
    L79:
        if ((r1 & 599187) == 599186) goto L81;
    L84:
        if (r2 == 0) goto L86;
        Modifier r16 = Modifier.Companion;
    L88:
        if (r4 == 0) goto L90;
        boolean r17 = false;
    L91:
        if (r6 == 0) goto L93;
        boolean r18 = false;
    L94:
        if (r8 == 0) goto L99;
        r13.startReplaceGroup(1849434622);
        Object r0 = r13.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L98;
        r0 = ChatMembersListScreenKt$ChatMembersList$1$1.INSTANCE;
        r13.updateRememberedValue(r0);
    L98:
        r13.endReplaceGroup();
        Function0<Unit> r19 = (Function0) r0;
    L100:
        if (r14 == 0) goto L103;
        r15 = null;
    L103:
        if (ComposerKt.isTraceInProgress() == false) goto L105;
        ComposerKt.traceEventStart(512385660, r1, -1, "com.ss.android.lark.compose.chat_member_list.ChatMembersList (ChatMembersListScreen.kt:243)");
    L105:
        Modifier r3 = r16;
        boolean r10 = r17;
        boolean r11 = r18;
        Function0<Unit> r12 = r19;
        Function1<? super com.ss.android.lark.compose.chatterselector.a, Unit> r30 = r15;
        ChatMemberListComponentsKt.g(r20, r21, r3, r10, r11, r12, r30, ComposableSingletons$ChatMembersListScreenKt.a, r13, (((((((r1 & 14) | 12582912) | (r1 & 112)) | (r1 & 896)) | (r1 & 7168)) | (57344 & r1)) | (458752 & r1)) | (r1 & 3670016));
        if (ComposerKt.isTraceInProgress() == false) goto L108;
        ComposerKt.traceEventEnd();
    L108:
        final Function1<? super com.ss.android.lark.compose.chatterselector.a, Unit> r31 = r15;
        final Modifier r32 = r16;
        final boolean r33 = r17;
        final boolean r34 = r18;
        final Function0<Unit> r35 = r19;
    L109:
        ScopeUpdateScope r110 = r13.endRestartGroup();
        if (r110 == null) goto L113;
        r110.updateScope(new ChatMembersListScreenKt$ChatMembersList$2(r20, r21, r32, r33, r34, r35, r31, r28, r29));
        return;
    L113:
        return;
    L99:
        r19 = r9;
        goto L100
    L93:
        r18 = r7;
        goto L94
    L90:
        r17 = r5;
        goto L91
    L86:
        r16 = r22;
        goto L88
    L81:
        if (r13.getSkipping() == false) goto L84;
        r13.skipToGroupEnd();
        r32 = r22;
        r33 = r5;
        r34 = r7;
        r35 = r9;
        r31 = r15;
        goto L109
    L71:
        if ((1572864 & r28) != 0) goto L77;
        r15 = r26;
        if (r13.changedInstance(r15) == false) goto L75;
        int r111 = 1048576;
    L76:
        r1 = r1 | r111;
        goto L79
    L75:
        r111 = 524288;
        goto L76
    L60:
        if ((196608 & r28) != 0) goto L66;
        r9 = r25;
        if (r13.changedInstance(r9) == false) goto L64;
        int r112 = 131072;
    L65:
        r1 = r1 | r112;
        goto L67
    L64:
        r112 = 65536;
        goto L65
    L49:
        if ((r28 & 24576) != 0) goto L55;
        r7 = r24;
        if (r13.changed(r7) == false) goto L53;
        int r36 = 16384;
    L54:
        r1 = r1 | r36;
        goto L56
    L53:
        r36 = 8192;
        goto L54
    L38:
        if ((r28 & 3072) != 0) goto L44;
        r5 = r23;
        if (r13.changed(r5) == false) goto L42;
        int r37 = 2048;
    L43:
        r1 = r1 | r37;
        goto L45
    L42:
        r37 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L43
    L27:
        if ((r28 & 384) != 0) goto L34;
        if (r13.changed(r22) == false) goto L31;
        int r38 = 256;
    L32:
        r1 = r1 | r38;
        goto L34
    L31:
        r38 = 128;
        goto L32
    L17:
        if ((r28 & 48) != 0) goto L23;
        if (r13.changedInstance(r21) == false) goto L21;
        int r39 = 32;
    L22:
        r1 = r1 | r39;
        goto L23
    L21:
        r39 = 16;
        goto L22
    L6:
        if ((r28 & 6) == 0) goto L8;
        r1 = r28;
        goto L14
    L8:
        if (r13.changedInstance(r20) == false) goto L10;
        int r40 = 4;
    L11:
        r1 = r40 | r28;
        goto L14
    L10:
        r40 = 2;
        goto L11
    }

    public static final void b(String r31, Function3<? super Integer, ? super Composer, ? super Integer, String> r32, final String r33, final com.lark.kmp.rustclient.api.d r34, final com.ss.android.lark.compose.chatsetting.common.platform.b r35, final com.ss.android.lark.compose.chatsetting.common.platform.a r36, final String r37, final Function0<Unit> r38, Composer r39, final int r40, final int r41) {
        Intrinsics.checkNotNullParameter(r33, "chatId");
        Intrinsics.checkNotNullParameter(r34, "rustClient");
        Intrinsics.checkNotNullParameter(r35, "platformEffects");
        Intrinsics.checkNotNullParameter(r36, "childScreenHost");
        Intrinsics.checkNotNullParameter(r37, "userId");
        Intrinsics.checkNotNullParameter(r38, "onBack");
        Composer r11 = r39.startRestartGroup(-157342268);
        if ((r40 & 6) == 0) goto L5;
        String r5 = r31;
        int r6 = r40;
    L14:
        if ((r40 & 48) == 0) goto L16;
        Function3<? super Integer, ? super Composer, ? super Integer, String> r7 = r32;
    L25:
        if ((r41 & 4) == 0) goto L28;
        r6 = r6 | 384;
    L35:
        if ((r41 & 8) == 0) goto L38;
        r6 = r6 | 3072;
    L45:
        if ((r41 & 16) == 0) goto L48;
        r6 = r6 | 24576;
    L58:
        if ((r41 & 32) == 0) goto L61;
        r6 = r6 | 196608;
    L71:
        if ((r41 & 64) == 0) goto L74;
        r6 = r6 | 1572864;
    L81:
        if ((r41 & 128) == 0) goto L84;
        r6 = r6 | 12582912;
    L91:
        if ((4793491 & r6) == 4793490) goto L93;
    L96:
        r11.startDefaults();
        if ((r40 & 1) == 0) goto L108;
        if (r11.getDefaultsInvalid() == true) goto L108;
        r11.skipToGroupEnd();
        if ((r41 & 1) == 0) goto L105;
        r6 = r6 & (-15);
    L105:
        if ((r41 & 2) != 0) goto L113;
    L114:
        String r27 = r5;
        Function3<? super Integer, ? super Composer, ? super Integer, String> r8 = r7;
        int r9 = r6;
        r11.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventStart(-157342268, r9, -1, "com.ss.android.lark.compose.chat_member_list.ChatMembersListScreen (ChatMembersListScreen.kt:90)");
    L117:
        r11.startReplaceGroup(-1224400529);
        int r10 = r9 & 896;
        if (r10 != 256) goto L120;
        boolean r19 = true;
    L121:
        boolean r110 = r19 | r11.changedInstance(r34);
        if ((r9 & 57344) != 16384) goto L124;
    L129:
        boolean r4 = true;
    L130:
        boolean r12 = r110 | r4;
        if ((3670016 & r9) != 1048576) goto L133;
        boolean r13 = true;
    L134:
        boolean r14 = r12 | r13;
        Object r15 = r11.rememberedValue();
        if (r14 == false) goto L137;
    L138:
        r15 = new ChatMembersListScreenKt$ChatMembersListScreen$viewModel$1$1(r33, r34, r35, r37);
        r11.updateRememberedValue(r15);
    L139:
        Function1 r16 = (Function1) r15;
        r11.endReplaceGroup();
        HasDefaultViewModelProviderFactory r17 = LocalViewModelStoreOwner.INSTANCE.getCurrent(r11, 6);
        if (r17 == null) goto L215;
        KClass r18 = Reflection.getOrCreateKotlinClass(ChatMembersViewModel.class);
        InitializerViewModelFactoryBuilder r111 = new InitializerViewModelFactoryBuilder();
        r111.addInitializer(Reflection.getOrCreateKotlinClass(ChatMembersViewModel.class), r16);
        ViewModelProvider.Factory r112 = r111.build();
        if ((r17 instanceof HasDefaultViewModelProviderFactory) == false) goto L144;
        CreationExtras r1 = r17.getDefaultViewModelCreationExtras();
    L145:
        final ChatMembersViewModel r2 = (ChatMembersViewModel) ViewModelKt.viewModel(r18, r17, null, r112, r1, r11, 0, 0);
        final State r20 = SnapshotStateKt.collectAsState(r2.getMembersUiState(), null, r11, 0, 1);
        final Context r113 = d8b.b.a(r11);
        final FocusManager r21 = (FocusManager) r11.consume(CompositionLocalsKt.getLocalFocusManager());
        r11.startReplaceGroup(-1746271574);
        if ((29360128 & r9) != 8388608) goto L148;
        boolean r22 = true;
    L149:
        boolean r23 = r22 | r11.changed(r21);
        if ((458752 & r9) != 131072) goto L152;
    L157:
        boolean r114 = true;
    L158:
        boolean r24 = r23 | r114;
        Object r115 = r11.rememberedValue();
        if (r24 == false) goto L161;
    L162:
        r115 = new ChatMembersListScreenKt$ChatMembersListScreen$onBackWithKeyboardHandling$1$1(r21, r36, r38);
        r11.updateRememberedValue(r115);
    L163:
        final Function0 r116 = (Function0) r115;
        r11.endReplaceGroup();
        r11.startReplaceGroup(-882024405);
        if (((d) r20.getValue()).i == true) goto L166;
    L168:
        String r117 = r27;
    L169:
        r11.endReplaceGroup();
        Modifier.Companion r25 = Modifier.Companion;
        Modifier r0 = WindowInsetsPaddingKt.windowInsetsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(r25, 0.0f, 1, null), n.a(r11, 0).c.e, null, 2, null), WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, r11, 6));
        MeasurePolicy r26 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r11, 0);
        long r118 = ComposablesKt.getCurrentCompositeKeyHashCode(r11, 0);
        int r3 = (int) (r118 ^ (r118 >>> 32));
        CompositionLocalMap r28 = r11.getCurrentCompositionLocalMap();
        Modifier r29 = ComposedModifierKt.materializeModifier(r11, r0);
        ComposeUiNode.Companion r30 = ComposeUiNode.Companion;
        Function0 r42 = r30.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L172;
        ComposablesKt.invalidApplier();
    L172:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L175;
        r11.createNode(r42);
    L176:
        Composer r43 = Updater.constructor-impl(r11);
        Updater.set-impl(r43, r26, r30.getSetMeasurePolicy());
        Updater.set-impl(r43, r28, r30.getSetResolvedCompositionLocals());
        Function2 r44 = r30.getSetCompositeKeyHash();
        if (r43.getInserting() == false) goto L179;
    L180:
        r43.updateRememberedValue(Integer.valueOf(r3));
        r43.apply(Integer.valueOf(r3), r44);
    L181:
        Updater.set-impl(r43, r29, r30.getSetModifier());
        ColumnScopeInstance r45 = ColumnScopeInstance.INSTANCE;
        com.ss.android.lark.flow.chat.resources.b r46 = com.ss.android.lark.flow.chat.resources.b.a;
        Intrinsics.checkNotNullParameter(r46, "<this>");
        final String r47 = b0.a((z) CommonMainString0.X.getValue(), r11);
        ComposableLambda r210 = ComposableLambdaKt.rememberComposableLambda(1434382928, true, new ChatMembersListScreenKt$ChatMembersListScreen$2$1(r116), r11, 54);
        if (((d) r20.getValue()).g == false) goto L184;
        r11.startReplaceGroup(503512101);
        Function4 r48 = ComposableLambdaKt.rememberComposableLambda(-2035520702, true, new ChatMembersListScreenKt$ChatMembersListScreen$2$2(r35, r113, r2, r20), r11, 54);
        r11.endReplaceGroup();
        Function4 r49 = r48;
        final State r211 = r20;
    L185:
        Composer r119 = r11;
        ChatMemberListComponentsKt.b(r117, null, r210, r49, r11, 384, 2);
        String r50 = ((d) r211.getValue()).a;
        r119.startReplaceGroup(5004770);
        boolean r51 = r119.changedInstance(r2);
        Object r52 = r119.rememberedValue();
        if (r51 == false) goto L188;
    L189:
        r52 = new ChatMembersListScreenKt$ChatMembersListScreen$2$4$1(r2);
        r119.updateRememberedValue(r52);
    L190:
        r119.endReplaceGroup();
        Intrinsics.checkNotNullParameter(r46, "<this>");
        ChatMemberListComponentsKt.a(r50, (Function1) r52, b0.a((z) CommonMainString0.l0.getValue(), r119), null, r119, 0, 8);
        Modifier r53 = ColumnScope.-CC.weight$default(r45, r25, 1.0f, false, 2, null);
        List<com.ss.android.lark.compose.chatterselector.a> r54 = ((d) r211.getValue()).b;
        boolean r55 = ((d) r211.getValue()).d;
        boolean r56 = ((d) r211.getValue()).e;
        r119.startReplaceGroup(5004770);
        boolean r57 = r119.changedInstance(r2);
        Object r58 = r119.rememberedValue();
        if (r57 == false) goto L193;
    L194:
        r58 = new ChatMembersListScreenKt$ChatMembersListScreen$2$5$1(r2);
        r119.updateRememberedValue(r58);
    L195:
        Function0 r59 = (Function0) r58;
        r119.endReplaceGroup();
        r119.startReplaceGroup(-1633490746);
        boolean r60 = r119.changedInstance(r113);
        if (r10 != 256) goto L198;
        boolean r61 = true;
    L199:
        boolean r62 = r60 | r61;
        Object r63 = r119.rememberedValue();
        if (r62 == false) goto L202;
    L205:
        r63 = new ChatMembersListScreenKt$ChatMembersListScreen$2$6$1(r113, r33);
        r119.updateRememberedValue(r63);
    L206:
        r119.endReplaceGroup();
        a(r54, r34, r53, r55, r56, r59, (Function1) r63, r119, (r9 >> 6) & 112, 0);
        r119.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L209;
        ComposerKt.traceEventEnd();
    L209:
        final String r64 = r27;
        final Function3<? super Integer, ? super Composer, ? super Integer, String> r65 = r8;
    L210:
        ScopeUpdateScope r120 = r119.endRestartGroup();
        if (r120 == null) goto L216;
        r120.updateScope(new ChatMembersListScreenKt$ChatMembersListScreen$3(r64, r65, r33, r34, r35, r36, r37, r38, r40, r41));
        return;
    L216:
        return;
    L202:
        if (r63 != Composer.Companion.getEmpty()) goto L206;
    L198:
        r61 = false;
        goto L199
    L193:
        if (r58 != Composer.Companion.getEmpty()) goto L195;
    L188:
        if (r52 != Composer.Companion.getEmpty()) goto L190;
    L184:
        r11.startReplaceGroup(505706777);
        r211 = r20;
        Function4 r66 = ComposableLambdaKt.rememberComposableLambda(1324076299, true, new ChatMembersListScreenKt$ChatMembersListScreen$2$3(r211, r35, r113, r2, r47), r11, 54);
        r11.endReplaceGroup();
        r49 = r66;
        goto L185
    L179:
        if (Intrinsics.areEqual(r43.rememberedValue(), Integer.valueOf(r3)) == true) goto L181;
    L175:
        r11.useNode();
        goto L176
    L166:
        if (((d) r20.getValue()).h <= 0) goto L168;
        r117 = (String) r8.invoke(Integer.valueOf(((d) r20.getValue()).h), r11, Integer.valueOf(r9 & 112));
        goto L169
    L161:
        if (r115 != Composer.Companion.getEmpty()) goto L163;
    L152:
        if ((r9 & 262144) != 0) goto L154;
    L156:
        r114 = false;
        goto L158
    L154:
        if (r11.changed(r36) == false) goto L156;
    L148:
        r22 = false;
        goto L149
    L144:
        r1 = CreationExtras.Empty.INSTANCE;
        goto L145
    L215:
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    L137:
        if (r15 != Composer.Companion.getEmpty()) goto L139;
    L133:
        r13 = false;
        goto L134
    L124:
        if ((r9 & 32768) != 0) goto L126;
    L128:
        r4 = false;
        goto L130
    L126:
        if (r11.changedInstance(r35) == false) goto L128;
    L120:
        r19 = false;
    L113:
        r6 = r6 & (-113);
    L108:
        if ((r41 & 1) == 0) goto L111;
        Intrinsics.checkNotNullParameter(com.ss.android.lark.flow.chat.resources.b.a, "<this>");
        r5 = b0.a((z) CommonMainString0.Y.getValue(), r11);
        r6 = r6 & (-15);
    L111:
        if ((r41 & 2) == 0) goto L114;
        r7 = ChatMembersListScreenKt$ChatMembersListScreen$1.INSTANCE;
        goto L113
    L93:
        if (r11.getSkipping() == false) goto L96;
        r11.skipToGroupEnd();
        r64 = r5;
        r65 = r7;
        r119 = r11;
        goto L210
    L84:
        if ((r40 & 12582912) != 0) goto L91;
        if (r11.changedInstance(r38) == false) goto L88;
        int r67 = 8388608;
    L89:
        r6 = r6 | r67;
        goto L91
    L88:
        r67 = 4194304;
        goto L89
    L74:
        if ((r40 & 1572864) != 0) goto L81;
        if (r11.changed(r37) == false) goto L78;
        int r68 = 1048576;
    L79:
        r6 = r6 | r68;
        goto L81
    L78:
        r68 = 524288;
        goto L79
    L61:
        if ((r40 & 196608) != 0) goto L71;
        if ((r40 & 262144) != 0) goto L65;
        boolean r69 = r11.changed(r36);
    L66:
        if (r69 == false) goto L68;
        int r70 = 131072;
    L69:
        r6 = r6 | r70;
        goto L71
    L68:
        r70 = 65536;
        goto L69
    L65:
        r69 = r11.changedInstance(r36);
        goto L66
    L48:
        if ((r40 & 24576) != 0) goto L58;
        if ((r40 & 32768) != 0) goto L52;
        boolean r71 = r11.changed(r35);
    L53:
        if (r71 == false) goto L55;
        int r72 = 16384;
    L56:
        r6 = r6 | r72;
        goto L58
    L55:
        r72 = 8192;
        goto L56
    L52:
        r71 = r11.changedInstance(r35);
        goto L53
    L38:
        if ((r40 & 3072) != 0) goto L45;
        if (r11.changedInstance(r34) == false) goto L42;
        int r73 = 2048;
    L43:
        r6 = r6 | r73;
        goto L45
    L42:
        r73 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L43
    L28:
        if ((r40 & 384) != 0) goto L35;
        if (r11.changed(r33) == false) goto L32;
        int r74 = 256;
    L33:
        r6 = r6 | r74;
        goto L35
    L32:
        r74 = 128;
        goto L33
    L16:
        if ((r41 & 2) != 0) goto L20;
        r7 = r32;
        if (r11.changedInstance(r7) == false) goto L21;
        int r75 = 32;
    L22:
        r6 = r6 | r75;
    L21:
        r75 = 16;
        goto L22
    L20:
        r7 = r32;
        goto L21
    L5:
        if ((r41 & 1) != 0) goto L9;
        r5 = r31;
        if (r11.changed(r5) == false) goto L10;
        int r76 = 4;
    L11:
        r6 = r76 | r40;
    L10:
        r76 = 2;
        goto L11
    L9:
        r5 = r31;
        goto L10
    }
}
