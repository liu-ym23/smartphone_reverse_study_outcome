package com.ss.android.lark.compose.chatterselector;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.DrawScope;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatterSelectorScreenKt {
    public static final void d(final boolean r16, Modifier r17, Composer r18, final int r19, final int r20) {
        Composer r10 = r18.startRestartGroup(1010349060);
        if ((r20 & 1) == 0) goto L6;
        int r1 = r19 | 6;
    L13:
        int r3 = r20 & 2;
        if (r3 == 0) goto L17;
        r1 = r1 | 48;
    L23:
        Modifier r4 = r17;
    L25:
        if ((r1 & 19) == 18) goto L27;
    L30:
        if (r3 == 0) goto L32;
        final Modifier r11 = Modifier.Companion;
    L34:
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventStart(1010349060, r1, -1, "com.ss.android.lark.compose.chatterselector.ChatterSelectedIndicator (ChatterSelectorScreen.kt:237)");
    L37:
        if (r16 == false) goto L39;
        r10.startReplaceGroup(282843406);
        long r5 = n.a(r10, 0).a.a;
    L40:
        r10.endReplaceGroup();
        final long r6 = n.a(r10, 0).b.a;
        r10.startReplaceGroup(1849434622);
        Object r0 = r10.rememberedValue();
        Composer.Companion r13 = Composer.Companion;
        if (r0 != r13.getEmpty()) goto L43;
        r0 = new c();
        r10.updateRememberedValue(r0);
    L43:
        final c r14 = (c) r0;
        r10.endReplaceGroup();
        Modifier r15 = SizeKt.size-3ABfNKs(r11, Dp.constructor-impl(r14.a));
        r10.startReplaceGroup(-1224400529);
        if ((r1 & 14) != 4) goto L46;
        boolean r2 = true;
    L47:
        boolean r7 = (r2 | r10.changed(r5)) | r10.changed(r6);
        Object r8 = r10.rememberedValue();
        if (r7 == false) goto L50;
    L51:
        final long r9 = r5;
        Function1<DrawScope, Unit> r110 = new ChatterSelectorScreenKt$ChatterSelectedIndicator$1$1(r16, r9, r6, r14);
        r10.updateRememberedValue(r110);
        r8 = r110;
    L52:
        r10.endReplaceGroup();
        CanvasKt.Canvas(r15, (Function1) r8, r10, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L55;
        ComposerKt.traceEventEnd();
    L55:
        ScopeUpdateScope r12 = r10.endRestartGroup();
        if (r12 == null) goto L59;
        r12.updateScope(new ChatterSelectorScreenKt$ChatterSelectedIndicator$2(r16, r11, r19, r20));
        return;
    L59:
        return;
    L50:
        if (r8 != r13.getEmpty()) goto L52;
    L46:
        r2 = false;
        goto L47
    L39:
        r10.startReplaceGroup(282844878);
        r5 = n.a(r10, 0).d.d;
        goto L40
    L32:
        r11 = r4;
        goto L34
    L27:
        if (r10.getSkipping() == false) goto L30;
        r10.skipToGroupEnd();
        r11 = r4;
        goto L55
    L17:
        if ((r19 & 48) != 0) goto L23;
        r4 = r17;
        if (r10.changed(r4) == false) goto L21;
        int r21 = 32;
    L22:
        r1 = r1 | r21;
        goto L25
    L21:
        r21 = 16;
        goto L22
    L6:
        if ((r19 & 6) == 0) goto L8;
        r1 = r19;
        goto L13
    L8:
        if (r10.changed(r16) == false) goto L10;
        int r22 = 4;
    L11:
        r1 = r22 | r19;
        goto L13
    L10:
        r22 = 2;
        goto L11
    }

    public static final void a(final int r30, final String r31, final Function0<Unit> r32, Modifier r33, boolean r34, boolean r35, Composer r36, final int r37, final int r38) {
        Intrinsics.checkNotNullParameter(r31, "confirmText");
        Intrinsics.checkNotNullParameter(r32, "onConfirm");
        Composer r14 = r36.startRestartGroup(683108423);
        if ((r38 & 1) == 0) goto L6;
        int r4 = r37 | 6;
    L14:
        if ((r38 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        if ((r38 & 4) == 0) goto L27;
        r4 = r4 | 384;
    L33:
        int r5 = r38 & 8;
        if (r5 == 0) goto L37;
        r4 = r4 | 3072;
    L43:
        Modifier r8 = r33;
    L44:
        int r9 = r38 & 16;
        if (r9 == 0) goto L48;
        r4 = r4 | 24576;
    L54:
        boolean r10 = r34;
    L55:
        int r11 = r38 & 32;
        if (r11 == 0) goto L59;
        r4 = r4 | 196608;
    L65:
        boolean r12 = r35;
    L67:
        if ((74899 & r4) == 74898) goto L69;
    L72:
        if (r5 == 0) goto L74;
        Modifier r13 = Modifier.Companion;
    L76:
        if (r9 == 0) goto L78;
        boolean r28 = false;
    L80:
        if (r11 == 0) goto L82;
        boolean r29 = true;
    L84:
        if (ComposerKt.isTraceInProgress() == false) goto L86;
        ComposerKt.traceEventStart(683108423, r4, -1, "com.ss.android.lark.compose.chatterselector.ChatterSelectorBottomBar (ChatterSelectorScreen.kt:279)");
    L86:
        float r7 = 16;
        Modifier r15 = PaddingKt.padding-VpY3zN4(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(r13, 0.0f, 1, null), WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeDrawing(WindowInsets.Companion, r14, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM())), Dp.constructor-impl(r7), Dp.constructor-impl(8));
        MeasurePolicy r16 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        long r17 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r18 = (int) (r17 ^ (r17 >>> 32));
        CompositionLocalMap r19 = r14.getCurrentCompositionLocalMap();
        Modifier r20 = ComposedModifierKt.materializeModifier(r14, r15);
        ComposeUiNode.Companion r110 = ComposeUiNode.Companion;
        Function0 r3 = r110.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L89;
        ComposablesKt.invalidApplier();
    L89:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L92;
        r14.createNode(r3);
    L93:
        Composer r6 = Updater.constructor-impl(r14);
        Updater.set-impl(r6, r16, r110.getSetMeasurePolicy());
        Updater.set-impl(r6, r19, r110.getSetResolvedCompositionLocals());
        Function2 r21 = r110.getSetCompositeKeyHash();
        if (r6.getInserting() == false) goto L96;
    L97:
        r6.updateRememberedValue(Integer.valueOf(r18));
        r6.apply(Integer.valueOf(r18), r21);
    L98:
        Updater.set-impl(r6, r20, r110.getSetModifier());
        BoxScopeInstance r22 = BoxScopeInstance.INSTANCE;
        if (r28 == true) goto L103;
        if (r30 > 0) goto L103;
        boolean r23 = false;
    L104:
        if (r23 == false) goto L107;
        if (r29 == false) goto L107;
        boolean r24 = true;
    L108:
        boolean r25 = r24;
        Modifier r0 = r13;
        Composer r1 = r14;
        ButtonKt.Button(r32, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.constructor-impl(56)), r25, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r7)), ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(n.a(r14, 0).a.a, n.a(r14, 0).b.a, n.a(r14, 0).a.c, n.a(r14, 0).b.a, r14, ButtonDefaults.$stable << 12, 0), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(86109757, true, new ChatterSelectorScreenKt$ChatterSelectorBottomBar$1$1(r31), r14, 54), r14, ((r4 >> 6) & 14) | 805306416, 480);
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L111;
        ComposerKt.traceEventEnd();
    L111:
        final Modifier r26 = r0;
        final boolean r27 = r28;
        final boolean r39 = r29;
    L112:
        ScopeUpdateScope r40 = r1.endRestartGroup();
        if (r40 == null) goto L116;
        r40.updateScope(new ChatterSelectorScreenKt$ChatterSelectorBottomBar$2(r30, r31, r32, r26, r27, r39, r37, r38));
        return;
    L116:
        return;
    L107:
        r24 = false;
    L103:
        r23 = true;
        goto L104
    L96:
        if (Intrinsics.areEqual(r6.rememberedValue(), Integer.valueOf(r18)) == true) goto L98;
    L92:
        r14.useNode();
        goto L93
    L82:
        r29 = r12;
        goto L84
    L78:
        r28 = r10;
        goto L80
    L74:
        r13 = r8;
        goto L76
    L69:
        if (r14.getSkipping() == false) goto L72;
        r14.skipToGroupEnd();
        r26 = r8;
        r27 = r10;
        r39 = r12;
        r1 = r14;
        goto L112
    L59:
        if ((196608 & r37) != 0) goto L65;
        r12 = r35;
        if (r14.changed(r12) == false) goto L63;
        int r111 = 131072;
    L64:
        r4 = r4 | r111;
        goto L67
    L63:
        r111 = 65536;
        goto L64
    L48:
        if ((r37 & 24576) != 0) goto L54;
        r10 = r34;
        if (r14.changed(r10) == false) goto L52;
        int r112 = 16384;
    L53:
        r4 = r4 | r112;
        goto L55
    L52:
        r112 = 8192;
        goto L53
    L37:
        if ((r37 & 3072) != 0) goto L43;
        r8 = r33;
        if (r14.changed(r8) == false) goto L41;
        int r41 = 2048;
    L42:
        r4 = r4 | r41;
        goto L44
    L41:
        r41 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L42
    L27:
        if ((r37 & 384) != 0) goto L33;
        if (r14.changedInstance(r32) == false) goto L31;
        int r42 = 256;
    L32:
        r4 = r4 | r42;
        goto L33
    L31:
        r42 = 128;
        goto L32
    L17:
        if ((r37 & 48) != 0) goto L24;
        if (r14.changed(r31) == false) goto L21;
        int r43 = 32;
    L22:
        r4 = r4 | r43;
        goto L24
    L21:
        r43 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r4 = r37;
        goto L14
    L8:
        if (r14.changed(r30) == false) goto L10;
        int r44 = 4;
    L11:
        r4 = r44 | r37;
        goto L14
    L10:
        r44 = 2;
        goto L11
    }

    public static final void b(final List<a> r24, final com.lark.kmp.rustclient.api.d r25, final Set<String> r26, final Function2<? super String, ? super Boolean, Unit> r27, Modifier r28, boolean r29, boolean r30, Function0<Unit> r31, boolean r32, Set<String> r33, Composer r34, final int r35, final int r36) {
        Intrinsics.checkNotNullParameter(r24, "chatters");
        Intrinsics.checkNotNullParameter(r25, "rustClient");
        Intrinsics.checkNotNullParameter(r26, "selectedIds");
        Intrinsics.checkNotNullParameter(r27, "onToggleSelected");
        Composer r9 = r34.startRestartGroup(303230995);
        if ((r36 & 1) == 0) goto L6;
        int r1 = r35 | 6;
    L14:
        if ((r36 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r36 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r36 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        int r2 = r36 & 16;
        if (r2 == 0) goto L47;
        r1 = r1 | 24576;
    L54:
        int r5 = r36 & 32;
        if (r5 == 0) goto L58;
        r1 = r1 | 196608;
    L65:
        int r7 = r36 & 64;
        if (r7 == 0) goto L69;
        r1 = r1 | 1572864;
    L76:
        int r3 = r36 & 128;
        if (r3 == 0) goto L80;
        r1 = r1 | 12582912;
    L86:
        int r0 = r36 & 256;
        if (r0 == 0) goto L90;
        r1 = r1 | 100663296;
    L96:
        int r4 = r36 & 512;
        if (r4 == 0) goto L100;
        r1 = r1 | 805306368;
    L107:
        if ((r1 & 306783379) == 306783378) goto L109;
    L112:
        if (r2 == 0) goto L114;
        Modifier r19 = Modifier.Companion;
    L115:
        boolean r6 = false;
        if (r5 == 0) goto L118;
        boolean r20 = false;
    L119:
        if (r7 == 0) goto L121;
        boolean r21 = false;
    L122:
        if (r3 == 0) goto L127;
        r9.startReplaceGroup(1849434622);
        Object r8 = r9.rememberedValue();
        if (r8 != Composer.Companion.getEmpty()) goto L126;
        r8 = ChatterSelectorScreenKt$ChatterSelectorList$1$1.INSTANCE;
        r9.updateRememberedValue(r8);
    L126:
        r9.endReplaceGroup();
        Function0<Unit> r22 = (Function0) r8;
    L128:
        if (r0 == 0) goto L130;
        final boolean r10 = false;
    L131:
        if (r4 == 0) goto L133;
        final Set<String> r11 = SetsKt.emptySet();
    L135:
        if (ComposerKt.isTraceInProgress() == false) goto L137;
        ComposerKt.traceEventStart(303230995, r1, -1, "com.ss.android.lark.compose.chatterselector.ChatterSelectorList (ChatterSelectorScreen.kt:198)");
    L137:
        r9.startReplaceGroup(-1224400529);
        if ((234881024 & r1) != 67108864) goto L140;
        boolean r12 = true;
    L141:
        boolean r13 = (r12 | r9.changedInstance(r11)) | r9.changedInstance(r26);
        if ((r1 & 7168) != 2048) goto L144;
        r6 = true;
    L144:
        boolean r14 = r13 | r6;
        Object r15 = r9.rememberedValue();
        if (r14 == false) goto L147;
    L148:
        r15 = new ChatterSelectorScreenKt$ChatterSelectorList$2$1(r10, r11, r26, r27);
        r9.updateRememberedValue(r15);
    L149:
        Function1 r16 = (Function1) r15;
        r9.endReplaceGroup();
        ComposableLambda r17 = ComposableLambdaKt.rememberComposableLambda(1552444401, true, new ChatterSelectorScreenKt$ChatterSelectorList$3(r10, r11, r26), r9, 54);
        int r18 = ((r1 & 14) | 12582912) | (r1 & 112);
        int r23 = r1 >> 6;
        int r110 = (((r18 | (r23 & 896)) | (r23 & 7168)) | (57344 & r23)) | (r23 & 458752);
        Set<String> r111 = r11;
        boolean r112 = r10;
        ChatMemberListComponentsKt.g(r24, r25, r19, r20, r21, r22, r16, r17, r9, r110);
        if (ComposerKt.isTraceInProgress() == false) goto L152;
        ComposerKt.traceEventEnd();
    L152:
        final boolean r37 = r112;
        final Modifier r38 = r19;
        final boolean r39 = r20;
        final boolean r40 = r21;
        final Function0<Unit> r41 = r22;
    L153:
        ScopeUpdateScope r42 = r9.endRestartGroup();
        if (r42 == null) goto L157;
        final Set<String> r113 = r111;
        r42.updateScope(new ChatterSelectorScreenKt$ChatterSelectorList$4(r24, r25, r26, r27, r38, r39, r40, r41, r37, r113, r35, r36));
        return;
    L157:
        return;
    L147:
        if (r15 != Composer.Companion.getEmpty()) goto L149;
    L140:
        r12 = false;
        goto L141
    L133:
        r11 = r33;
        goto L135
    L130:
        r10 = r32;
        goto L131
    L127:
        r22 = r31;
        goto L128
    L121:
        r21 = r30;
        goto L122
    L118:
        r20 = r29;
        goto L119
    L114:
        r19 = r28;
        goto L115
    L109:
        if (r9.getSkipping() == false) goto L112;
        r9.skipToGroupEnd();
        r38 = r28;
        r39 = r29;
        r40 = r30;
        r41 = r31;
        r111 = r33;
        r37 = r32;
        goto L153
    L100:
        if ((r35 & 805306368) != 0) goto L107;
        if (r9.changedInstance(r33) == false) goto L104;
        int r114 = 536870912;
    L105:
        r1 = r1 | r114;
        goto L107
    L104:
        r114 = 268435456;
        goto L105
    L90:
        if ((r35 & 100663296) != 0) goto L96;
        if (r9.changed(r32) == false) goto L94;
        int r115 = 67108864;
    L95:
        r1 = r1 | r115;
        goto L96
    L94:
        r115 = 33554432;
        goto L95
    L80:
        if ((r35 & 12582912) != 0) goto L86;
        if (r9.changedInstance(r31) == false) goto L84;
        int r116 = 8388608;
    L85:
        r1 = r1 | r116;
        goto L86
    L84:
        r116 = 4194304;
        goto L85
    L69:
        if ((1572864 & r35) != 0) goto L76;
        if (r9.changed(r30) == false) goto L73;
        int r117 = 1048576;
    L74:
        r1 = r1 | r117;
        goto L76
    L73:
        r117 = 524288;
        goto L74
    L58:
        if ((196608 & r35) != 0) goto L65;
        if (r9.changed(r29) == false) goto L62;
        int r43 = 131072;
    L63:
        r1 = r1 | r43;
        goto L65
    L62:
        r43 = 65536;
        goto L63
    L47:
        if ((r35 & 24576) != 0) goto L54;
        if (r9.changed(r28) == false) goto L51;
        int r44 = 16384;
    L52:
        r1 = r1 | r44;
        goto L54
    L51:
        r44 = 8192;
        goto L52
    L37:
        if ((r35 & 3072) != 0) goto L43;
        if (r9.changedInstance(r27) == false) goto L41;
        int r45 = 2048;
    L42:
        r1 = r1 | r45;
        goto L43
    L41:
        r45 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L42
    L27:
        if ((r35 & 384) != 0) goto L34;
        if (r9.changedInstance(r26) == false) goto L31;
        int r46 = 256;
    L32:
        r1 = r1 | r46;
        goto L34
    L31:
        r46 = 128;
        goto L32
    L17:
        if ((r35 & 48) != 0) goto L24;
        if (r9.changedInstance(r25) == false) goto L21;
        int r47 = 32;
    L22:
        r1 = r1 | r47;
        goto L24
    L21:
        r47 = 16;
        goto L22
    L6:
        if ((r35 & 6) == 0) goto L8;
        r1 = r35;
        goto L14
    L8:
        if (r9.changedInstance(r24) == false) goto L10;
        int r48 = 4;
    L11:
        r1 = r48 | r35;
        goto L14
    L10:
        r48 = 2;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(final String r35, final String r36, final com.lark.kmp.rustclient.api.d r37, final com.ss.android.lark.compose.chatsetting.common.platform.b r38, Set<String> r39, Integer r40, Function0<Unit> r41, boolean r42, boolean r43, boolean r44, boolean r45, Function1<? super Set<String>, Boolean> r46, Function1<? super Set<String>, String> r47, Function4<? super Dp, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> r48, String r49, String r50, Function0<Unit> r51, Function1<? super Set<String>, Unit> r52, Composer r53, final int r54, final int r55, final int r56) {
        Intrinsics.checkNotNullParameter(r35, "title");
        Intrinsics.checkNotNullParameter(r36, "chatId");
        Intrinsics.checkNotNullParameter(r37, "rustClient");
        Intrinsics.checkNotNullParameter(r38, "platformEffects");
        Composer r0 = r53.startRestartGroup(2136385400);
        if ((r56 & 1) == 0) goto L6;
        int r5 = r54 | 6;
    L14:
        if ((r56 & 2) == 0) goto L17;
        r5 = r5 | 48;
    L24:
        if ((r56 & 4) == 0) goto L27;
        r5 = r5 | 384;
    L34:
        if ((r56 & 8) == 0) goto L37;
        r5 = r5 | 3072;
    L46:
        int r8 = r56 & 16;
        int r16 = 16384;
        if (r8 == 0) goto L50;
        r5 = r5 | 24576;
    L57:
        int r18 = r56 & 32;
        if (r18 == 0) goto L61;
        r5 = r5 | 196608;
    L67:
        int r21 = r56 & 64;
        if (r21 == 0) goto L71;
        r5 = r5 | 1572864;
    L77:
        int r6 = r56 & 128;
        if (r6 == 0) goto L81;
        r5 = r5 | 12582912;
    L87:
        int r9 = r56 & 256;
        if (r9 == 0) goto L91;
        r5 = r5 | 100663296;
    L97:
        int r7 = r56 & 512;
        if (r7 == 0) goto L101;
        r5 = r5 | 805306368;
    L107:
        int r10 = r56 & ChameleonContainerUtils.MAX_URL_LENGTH;
        if (r10 == 0) goto L111;
        int r17 = r55 | 6;
    L118:
        int r11 = r56 & 2048;
        if (r11 == 0) goto L122;
        r17 = r17 | 48;
    L129:
        if ((r55 & 384) != 0) goto L139;
        if ((r56 & 4096) != 0) goto L136;
        if (r0.changedInstance(r47) == false) goto L136;
        int r20 = 256;
    L137:
        r17 = r17 | r20;
    L136:
        r20 = 128;
    L139:
        int r12 = r17;
        int r4 = r56 & 8192;
        if (r4 == 0) goto L143;
        r12 = r12 | 3072;
    L151:
        if ((r55 & 24576) != 0) goto L162;
        if ((r56 & 16384) != 0) goto L158;
        if (r0.changed(r49) == false) goto L158;
    L159:
        r12 = r12 | r16;
    L158:
        r16 = 8192;
    L162:
        if ((r55 & 196608) != 0) goto L171;
        if ((r56 & 32768) == 0) goto L166;
    L168:
        int r19 = 65536;
    L169:
        r12 = r12 | r19;
        goto L171
    L166:
        if (r0.changed(r50) == false) goto L168;
        r19 = 131072;
    L171:
        int r110 = r56 & 65536;
        if (r110 == 0) goto L175;
        r12 = r12 | 1572864;
    L181:
        int r111 = r56 & 131072;
        if (r111 == 0) goto L185;
        r12 = r12 | 12582912;
    L192:
        if ((r5 & 306783379) == 306783378) goto L194;
    L199:
        r0.startDefaults();
        if ((r54 & 1) != 0) goto L202;
    L214:
        if (r8 == 0) goto L216;
        Set<String> r3 = SetsKt.emptySet();
    L217:
        if (r18 == 0) goto L219;
        Integer r13 = null;
    L221:
        if (r21 == 0) goto L226;
        r0.startReplaceGroup(1849434622);
        Object r14 = r0.rememberedValue();
        if (r14 != Composer.Companion.getEmpty()) goto L225;
        r14 = ChatterSelectorScreenKt$ChatterSelectorScreen$1$1.INSTANCE;
        r0.updateRememberedValue(r14);
    L225:
        Function0<Unit> r15 = (Function0) r14;
        r0.endReplaceGroup();
    L227:
        if (r6 == 0) goto L229;
        boolean r22 = false;
    L230:
        if (r9 == 0) goto L232;
        boolean r23 = false;
    L233:
        if (r7 == 0) goto L235;
        boolean r24 = false;
    L236:
        if (r10 == 0) goto L238;
        boolean r112 = false;
    L239:
        if (r11 == 0) goto L244;
        r0.startReplaceGroup(1849434622);
        Object r113 = r0.rememberedValue();
        if (r113 != Composer.Companion.getEmpty()) goto L243;
        r113 = ChatterSelectorScreenKt$ChatterSelectorScreen$2$1.INSTANCE;
        r0.updateRememberedValue(r113);
    L243:
        Function1<? super Set<String>, Boolean> r114 = (Function1) r113;
        r0.endReplaceGroup();
    L246:
        if ((r56 & 4096) == 0) goto L248;
        com.ss.android.lark.flow.chat.resources.b r115 = com.ss.android.lark.flow.chat.resources.b.a;
        final String r116 = b0.a(com.ss.android.lark.flow.chat.resources.c.b(), r0);
        Function1<? super Set<String>, String> r25 = new ChatterSelectorScreenKt$constantConfirmText$1(r116);
        r12 = r12 & (-897);
    L249:
        if (r4 == 0) goto L251;
        Function4<? super Dp, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> r26 = null;
    L253:
        if ((r56 & 16384) == 0) goto L255;
        Intrinsics.checkNotNullParameter(com.ss.android.lark.flow.chat.resources.b.a, "<this>");
        String r27 = b0.a((z) CommonMainString0.l0.getValue(), r0);
        r12 = r12 & (-57345);
    L257:
        if ((32768 & r56) == 0) goto L259;
        String r28 = "chatter_selector#" + r36 + '#' + r35 + '#' + r22 + '#' + r23 + '#' + r24;
        r12 = r12 & (-458753);
    L260:
        if (r110 == 0) goto L265;
        r0.startReplaceGroup(1849434622);
        Object r117 = r0.rememberedValue();
        if (r117 != Composer.Companion.getEmpty()) goto L264;
        r117 = ChatterSelectorScreenKt$ChatterSelectorScreen$3$1.INSTANCE;
        r0.updateRememberedValue(r117);
    L264:
        Function0<Unit> r1 = (Function0) r117;
        r0.endReplaceGroup();
    L266:
        if (r111 == 0) goto L271;
        r0.startReplaceGroup(1849434622);
        Object r118 = r0.rememberedValue();
        if (r118 != Composer.Companion.getEmpty()) goto L270;
        r118 = ChatterSelectorScreenKt$ChatterSelectorScreen$4$1.INSTANCE;
        r0.updateRememberedValue(r118);
    L270:
        Function1<? super Set<String>, Unit> r119 = (Function1) r118;
        r0.endReplaceGroup();
    L272:
        final Function0<Unit> r2 = r1;
        final String r120 = r28;
        int r121 = r12;
        Function1<? super Set<String>, Unit> r122 = r119;
        Set<String> r29 = r3;
        Function0<Unit> r30 = r15;
        String r123 = r27;
        Function4<? super Dp, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> r124 = r26;
        Function1<? super Set<String>, String> r31 = r25;
    L273:
        r0.endDefaults();
        boolean r57 = r112;
        if (ComposerKt.isTraceInProgress() == false) goto L277;
        ComposerKt.traceEventStart(2136385400, r5, r121, "com.ss.android.lark.compose.chatterselector.ChatterSelectorScreen (ChatterSelectorScreen.kt:105)");
    L277:
        r0.startReplaceGroup(-1224400529);
        if ((r5 & 112) != 32) goto L280;
        boolean r125 = true;
    L281:
        boolean r126 = r125 | r0.changedInstance(r37);
        Function1<? super Set<String>, Unit> r210 = r122;
        if ((r5 & 7168) == 2048) goto L291;
        if ((r5 & 4096) == 0) goto L289;
        if (r0.changedInstance(r38) == true) goto L291;
    L289:
        boolean r127 = false;
    L292:
        boolean r128 = (r126 | r127) | r0.changedInstance(r29);
        if ((458752 & r5) != 131072) goto L295;
        boolean r129 = true;
    L296:
        boolean r130 = r128 | r129;
        if ((3670016 & r5) != 1048576) goto L299;
        boolean r131 = true;
    L300:
        boolean r132 = r130 | r131;
        if ((29360128 & r5) != 8388608) goto L303;
        boolean r133 = true;
    L304:
        boolean r134 = r132 | r133;
        Object r135 = r0.rememberedValue();
        if (r134 == false) goto L307;
    L308:
        final Set<String> r410 = r29;
        final Integer r411 = r13;
        final Function0<Unit> r412 = r30;
        final boolean r413 = r22;
        r135 = new ChatterSelectorScreenKt$ChatterSelectorScreen$viewModel$1$1(r36, r37, r38, r410, r411, r412, r413);
        r0.updateRememberedValue(r135);
    L309:
        Function1 r136 = (Function1) r135;
        r0.endReplaceGroup();
        int r137 = (r121 >> 12) & 112;
        Set<String> r211 = r29;
        HasDefaultViewModelProviderFactory r138 = LocalViewModelStoreOwner.INSTANCE.getCurrent(r0, 6);
        if (r138 == null) goto L397;
        KClass r212 = Reflection.getOrCreateKotlinClass(ChatterSelectorViewModel.class);
        InitializerViewModelFactoryBuilder r32 = new InitializerViewModelFactoryBuilder();
        Function0<Unit> r213 = r30;
        r32.addInitializer(Reflection.getOrCreateKotlinClass(ChatterSelectorViewModel.class), r136);
        ViewModelProvider.Factory r33 = r32.build();
        if ((r138 instanceof HasDefaultViewModelProviderFactory) == false) goto L314;
        CreationExtras r34 = r138.getDefaultViewModelCreationExtras();
    L315:
        int r139 = r137 << 3;
        String r414 = r120;
        CreationExtras r415 = r34;
        final ChatterSelectorViewModel r58 = (ChatterSelectorViewModel) ViewModelKt.viewModel(r212, r138, r414, r33, r415, r0, (r139 & 896) | (r139 & 112), 0);
        State r59 = SnapshotStateKt.collectAsState(r58.getUiState(), null, r0, 0, 1);
        List<a> r140 = ((b) r59.getValue()).b;
        r0.startReplaceGroup(5004770);
        boolean r141 = r0.changed(r140);
        Object r142 = r0.rememberedValue();
        if (r141 == false) goto L318;
    L319:
        r142 = SequencesKt.toSet(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(((b) r59.getValue()).b), ChatterSelectorScreenKt$ChatterSelectorScreen$ownerIds$1$1.INSTANCE), ChatterSelectorScreenKt$ChatterSelectorScreen$ownerIds$1$2.INSTANCE));
        r0.updateRememberedValue(r142);
    L320:
        Set r143 = (Set) r142;
        r0.endReplaceGroup();
        List<a> r144 = ((b) r59.getValue()).b;
        r0.startReplaceGroup(-1746271574);
        boolean r145 = r0.changed(r144);
        boolean r214 = r22;
        if ((234881024 & r5) != 67108864) goto L323;
        boolean r60 = true;
    L324:
        boolean r61 = (r60 | r145) | r0.changed(r143);
        Object r146 = r0.rememberedValue();
        if (r61 == true) goto L328;
        Object r147 = r146;
        if (r146 == Composer.Companion.getEmpty()) goto L328;
    L338:
        List r62 = (List) r147;
        r0.endReplaceGroup();
        Set<String> r148 = ((b) r59.getValue()).c;
        r0.startReplaceGroup(-1746271574);
        boolean r149 = r0.changed(r148);
        Integer r215 = r13;
        if ((1879048192 & r5) != 536870912) goto L341;
        boolean r63 = true;
    L342:
        boolean r64 = (r63 | r149) | r0.changed(r143);
        Object r150 = r0.rememberedValue();
        if (r64 == false) goto L345;
    L346:
        if (r24 == true) goto L348;
        Set<String> r65 = ((b) r59.getValue()).c;
    L349:
        r150 = r65;
        r0.updateRememberedValue(r150);
    L350:
        final Set r151 = (Set) r150;
        r0.endReplaceGroup();
        Modifier.Companion r66 = Modifier.Companion;
        Function1<? super Set<String>, String> r216 = r31;
        boolean r217 = r23;
        Modifier r67 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(r66, 0.0f, 1, null), n.a(r0, 0).c.e, null, 2, null);
        MeasurePolicy r68 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r0, 0);
        long r218 = ComposablesKt.getCurrentCompositeKeyHashCode(r0, 0);
        final Function4<? super Dp, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> r152 = r124;
        int r153 = (int) (r218 ^ (r218 >>> 32));
        CompositionLocalMap r154 = r0.getCurrentCompositionLocalMap();
        Modifier r69 = ComposedModifierKt.materializeModifier(r0, r67);
        ComposeUiNode.Companion r155 = ComposeUiNode.Companion;
        Function0 r156 = r155.getConstructor();
        boolean r219 = r24;
        if ((r0.getApplier() instanceof Applier) == true) goto L353;
        ComposablesKt.invalidApplier();
    L353:
        r0.startReusableNode();
        if (r0.getInserting() == false) goto L356;
        r0.createNode(r156);
    L357:
        Composer r70 = Updater.constructor-impl(r0);
        Updater.set-impl(r70, r68, r155.getSetMeasurePolicy());
        Updater.set-impl(r70, r154, r155.getSetResolvedCompositionLocals());
        Function2 r71 = r155.getSetCompositeKeyHash();
        if (r70.getInserting() == false) goto L360;
    L361:
        r70.updateRememberedValue(Integer.valueOf(r153));
        r70.apply(Integer.valueOf(r153), r71);
    L362:
        Updater.set-impl(r70, r69, r155.getSetModifier());
        ColumnScopeInstance r72 = ColumnScopeInstance.INSTANCE;
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(r66, Dp.constructor-impl(8)), r0, 6);
        boolean r157 = true;
        ChatMemberListComponentsKt.b(r35, null, ComposableLambdaKt.rememberComposableLambda(-650472596, true, new ChatterSelectorScreenKt$ChatterSelectorScreen$5$1(r152, r2), r0, 54), null, r0, (r5 & 14) | 384, 10);
        String r73 = ((b) r59.getValue()).a;
        r0.startReplaceGroup(5004770);
        boolean r158 = r0.changedInstance(r58);
        Object r159 = r0.rememberedValue();
        if (r158 == false) goto L365;
    L366:
        r159 = new ChatterSelectorScreenKt$ChatterSelectorScreen$5$2$1(r58);
        r0.updateRememberedValue(r159);
    L367:
        r0.endReplaceGroup();
        ChatMemberListComponentsKt.a(r73, (Function1) r159, r123, null, r0, (r121 >> 6) & 896, 8);
        Modifier r74 = ColumnScope.-CC.weight$default(r72, r66, 1.0f, false, 2, null);
        boolean r75 = ((b) r59.getValue()).e;
        boolean r76 = ((b) r59.getValue()).f;
        r0.startReplaceGroup(5004770);
        boolean r77 = r0.changedInstance(r58);
        Object r160 = r0.rememberedValue();
        if (r77 == false) goto L370;
    L371:
        r160 = new ChatterSelectorScreenKt$ChatterSelectorScreen$5$3$1(r58);
        r0.updateRememberedValue(r160);
    L372:
        Function2 r78 = (Function2) r160;
        r0.endReplaceGroup();
        r0.startReplaceGroup(5004770);
        boolean r161 = r0.changedInstance(r58);
        Object r162 = r0.rememberedValue();
        if (r161 == false) goto L375;
    L376:
        r162 = new ChatterSelectorScreenKt$ChatterSelectorScreen$5$4$1(r58);
        r0.updateRememberedValue(r162);
    L377:
        r0.endReplaceGroup();
        int r79 = r5 >> 3;
        b(r62, r37, r151, r78, r74, r75, r76, (Function0) r162, r219, r143, r0, (r79 & 234881024) | (r79 & 112), 0);
        int r80 = r151.size();
        String r81 = (String) r216.invoke(r151);
        r0.startReplaceGroup(-1633490746);
        if ((29360128 & r121) == 8388608) goto L381;
        r157 = false;
    L381:
        boolean r82 = r0.changedInstance(r151) | r157;
        Object r83 = r0.rememberedValue();
        if (r82 == false) goto L384;
    L387:
        final Function1<? super Set<String>, Unit> r84 = r210;
        r83 = new ChatterSelectorScreenKt$ChatterSelectorScreen$5$5$1(r84, r151);
        r0.updateRememberedValue(r83);
    L388:
        r0.endReplaceGroup();
        Function1<? super Set<String>, Boolean> r85 = r114;
        a(r80, r81, (Function0) r83, null, r57, ((Boolean) r85.invoke(r151)).booleanValue(), r0, (r121 << 12) & 57344, 8);
        r0.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L391;
        ComposerKt.traceEventEnd();
    L391:
        final boolean r163 = r57;
        final Function0<Unit> r164 = r2;
        final Function1<? super Set<String>, String> r165 = r216;
        final Function1<? super Set<String>, Unit> r166 = r84;
        final Function1<? super Set<String>, Boolean> r167 = r85;
        final String r168 = r123;
        final Set<String> r86 = r211;
        final boolean r87 = r214;
        final Integer r88 = r215;
        final Function0<Unit> r89 = r213;
        final boolean r169 = r219;
        final Function4<? super Dp, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> r170 = r152;
        final boolean r90 = r217;
    L392:
        ScopeUpdateScope r91 = r0.endRestartGroup();
        if (r91 == null) goto L401;
        r91.updateScope(new ChatterSelectorScreenKt$ChatterSelectorScreen$6(r35, r36, r37, r38, r86, r88, r89, r87, r90, r169, r163, r167, r165, r170, r168, r120, r164, r166, r54, r55, r56));
        return;
    L401:
        return;
    L384:
        if (r83 == Composer.Companion.getEmpty()) goto L387;
        r84 = r210;
        goto L388
    L375:
        if (r162 != Composer.Companion.getEmpty()) goto L377;
    L370:
        if (r160 != Composer.Companion.getEmpty()) goto L372;
    L365:
        if (r159 != Composer.Companion.getEmpty()) goto L367;
    L360:
        if (Intrinsics.areEqual(r70.rememberedValue(), Integer.valueOf(r153)) == true) goto L362;
    L356:
        r0.useNode();
        goto L357
    L348:
        r65 = SetsKt.minus(((b) r59.getValue()).c, r143);
        goto L349
    L345:
        if (r150 != Composer.Companion.getEmpty()) goto L350;
    L341:
        r63 = false;
    L328:
        if (r23 == true) goto L330;
        ArrayList r171 = ((b) r59.getValue()).b;
    L337:
        r0.updateRememberedValue(r171);
        r147 = r171;
        goto L338
    L330:
        List<a> r92 = ((b) r59.getValue()).b;
        r171 = new ArrayList();
        Iterator r93 = r92.iterator();
    L332:
        if (r93.hasNext() == false) goto L337;
        Object r172 = r93.next();
        Iterator r310 = r93;
        if (r143.contains(((a) r172).a) == true) goto L336;
        r171.add(r172);
    L336:
        r93 = r310;
        goto L332
    L323:
        r60 = false;
        goto L324
    L318:
        if (r142 != Composer.Companion.getEmpty()) goto L320;
    L314:
        r34 = CreationExtras.Empty.INSTANCE;
        goto L315
    L397:
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    L307:
        if (r135 != Composer.Companion.getEmpty()) goto L309;
    L303:
        r133 = false;
        goto L304
    L299:
        r131 = false;
        goto L300
    L295:
        r129 = false;
    L291:
        r127 = true;
        goto L292
    L280:
        r125 = false;
        goto L281
    L271:
        r119 = r52;
        goto L272
    L265:
        r1 = r51;
        goto L266
    L259:
        r28 = r50;
        goto L260
    L255:
        r27 = r49;
        goto L257
    L251:
        r26 = r48;
        goto L253
    L248:
        r25 = r47;
        goto L249
    L244:
        r114 = r46;
        goto L246
    L238:
        r112 = r45;
        goto L239
    L235:
        r24 = r44;
        goto L236
    L232:
        r23 = r43;
        goto L233
    L229:
        r22 = r42;
        goto L230
    L226:
        r15 = r41;
        goto L227
    L219:
        r13 = r40;
        goto L221
    L216:
        r3 = r39;
        goto L217
    L202:
        if (r0.getDefaultsInvalid() == true) goto L214;
        r0.skipToGroupEnd();
        if ((r56 & 4096) == 0) goto L208;
        r12 = r12 & (-897);
    L208:
        if ((r56 & 16384) == 0) goto L211;
        r12 = r12 & (-57345);
    L211:
        if ((32768 & r56) == 0) goto L213;
        r12 = r12 & (-458753);
    L213:
        r29 = r39;
        r13 = r40;
        r30 = r41;
        r22 = r42;
        r23 = r43;
        r24 = r44;
        r112 = r45;
        r114 = r46;
        r31 = r47;
        r123 = r49;
        r120 = r50;
        r2 = r51;
        r122 = r52;
        r121 = r12;
        r124 = r48;
        goto L273
    L194:
        if ((4793491 & r12) != 4793490) goto L199;
        if (r0.getSkipping() == false) goto L199;
        r0.skipToGroupEnd();
        r86 = r39;
        r88 = r40;
        r89 = r41;
        r87 = r42;
        r90 = r43;
        r169 = r44;
        r163 = r45;
        r167 = r46;
        r165 = r47;
        r170 = r48;
        r168 = r49;
        r120 = r50;
        r164 = r51;
        r166 = r52;
        goto L392
    L185:
        if ((r55 & 12582912) != 0) goto L192;
        if (r0.changedInstance(r52) == false) goto L189;
        int r173 = 8388608;
    L190:
        r12 = r12 | r173;
        goto L192
    L189:
        r173 = 4194304;
        goto L190
    L175:
        if ((r55 & 1572864) != 0) goto L181;
        if (r0.changedInstance(r51) == false) goto L179;
        int r174 = 1048576;
    L180:
        r12 = r12 | r174;
        goto L181
    L179:
        r174 = 524288;
        goto L180
    L143:
        if ((r55 & 3072) != 0) goto L151;
        if (r0.changedInstance(r48) == false) goto L147;
        int r175 = 2048;
    L148:
        r12 = r12 | r175;
        goto L151
    L147:
        r175 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L148
    L122:
        if ((r55 & 48) != 0) goto L129;
        if (r0.changedInstance(r46) == false) goto L126;
        int r176 = 32;
    L127:
        r17 = r17 | r176;
        goto L129
    L126:
        r176 = 16;
        goto L127
    L111:
        if ((r55 & 6) == 0) goto L113;
        r17 = r55;
        goto L118
    L113:
        if (r0.changed(r45) == false) goto L115;
        int r177 = 4;
    L116:
        r17 = r55 | r177;
        goto L118
    L115:
        r177 = 2;
        goto L116
    L101:
        if ((r54 & 805306368) != 0) goto L107;
        if (r0.changed(r44) == false) goto L105;
        int r220 = 536870912;
    L106:
        r5 = r5 | r220;
        goto L107
    L105:
        r220 = 268435456;
        goto L106
    L91:
        if ((r54 & 100663296) != 0) goto L97;
        if (r0.changed(r43) == false) goto L95;
        int r221 = 67108864;
    L96:
        r5 = r5 | r221;
        goto L97
    L95:
        r221 = 33554432;
        goto L96
    L81:
        if ((r54 & 12582912) != 0) goto L87;
        if (r0.changed(r42) == false) goto L85;
        int r222 = 8388608;
    L86:
        r5 = r5 | r222;
        goto L87
    L85:
        r222 = 4194304;
        goto L86
    L71:
        if ((r54 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r41) == false) goto L75;
        int r223 = 1048576;
    L76:
        r5 = r5 | r223;
        goto L77
    L75:
        r223 = 524288;
        goto L76
    L61:
        if ((r54 & 196608) != 0) goto L67;
        if (r0.changed(r40) == false) goto L65;
        int r224 = 131072;
    L66:
        r5 = r5 | r224;
        goto L67
    L65:
        r224 = 65536;
        goto L66
    L50:
        if ((r54 & 24576) != 0) goto L57;
        if (r0.changedInstance(r39) == false) goto L54;
        int r178 = 16384;
    L55:
        r5 = r5 | r178;
        goto L57
    L54:
        r178 = 8192;
        goto L55
    L37:
        if ((r54 & 3072) != 0) goto L46;
        if ((r54 & 4096) != 0) goto L41;
        boolean r94 = r0.changed(r38);
    L42:
        if (r94 == false) goto L44;
        int r95 = 2048;
    L45:
        r5 = r5 | r95;
        goto L46
    L44:
        r95 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L45
    L41:
        r94 = r0.changedInstance(r38);
        goto L42
    L27:
        if ((r54 & 384) != 0) goto L34;
        if (r0.changedInstance(r37) == false) goto L31;
        int r96 = 256;
    L32:
        r5 = r5 | r96;
        goto L34
    L31:
        r96 = 128;
        goto L32
    L17:
        if ((r54 & 48) != 0) goto L24;
        if (r0.changed(r36) == false) goto L21;
        int r97 = 32;
    L22:
        r5 = r5 | r97;
        goto L24
    L21:
        r97 = 16;
        goto L22
    L6:
        if ((r54 & 6) == 0) goto L8;
        r5 = r54;
        goto L14
    L8:
        if (r0.changed(r35) == false) goto L10;
        int r98 = 4;
    L11:
        r5 = r98 | r54;
        goto L14
    L10:
        r98 = 2;
        goto L11
    }
}
