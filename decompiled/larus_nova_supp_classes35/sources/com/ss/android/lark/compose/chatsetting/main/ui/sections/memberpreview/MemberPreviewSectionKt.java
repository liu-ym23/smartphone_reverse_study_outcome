package com.ss.android.lark.compose.chatsetting.main.ui.sections.memberpreview;

import android.content.Context;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import com.ss.android.lark.compose.chatsetting.main.viewmodel.GroupMembersViewModel;
import com.ss.android.lark.compose.chatsetting.main.viewmodel.c;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MemberPreviewSectionKt {
    public static final void a(final String r33, final String r34, final d r35, final Function0<Unit> r36, final b r37, Composer r38, final int r39) {
        Intrinsics.checkNotNullParameter(r33, "userId");
        Intrinsics.checkNotNullParameter(r34, "chatId");
        Intrinsics.checkNotNullParameter(r35, "rustClient");
        Intrinsics.checkNotNullParameter(r36, "onAddClick");
        Intrinsics.checkNotNullParameter(r37, "platformEffects");
        Composer r12 = r38.startRestartGroup(812326356);
        if ((r39 & 6) == 0) goto L5;
        int r4 = r39;
    L11:
        if ((r39 & 48) != 0) goto L18;
        if (r12.changed(r34) == false) goto L15;
        int r6 = 32;
    L16:
        r4 = r4 | r6;
        goto L18
    L15:
        r6 = 16;
    L18:
        if ((r39 & 384) != 0) goto L25;
        if (r12.changedInstance(r35) == false) goto L22;
        int r7 = 256;
    L23:
        r4 = r4 | r7;
        goto L25
    L22:
        r7 = 128;
    L25:
        if ((r39 & 3072) != 0) goto L32;
        if (r12.changedInstance(r36) == false) goto L29;
        int r8 = 2048;
    L30:
        r4 = r4 | r8;
        goto L32
    L29:
        r8 = ChameleonContainerUtils.MAX_URL_LENGTH;
    L32:
        if ((r39 & 24576) == 0) goto L34;
    L41:
        int r9 = r4;
        if ((r9 & 9363) != 9362) goto L48;
        if (r12.getSkipping() == false) goto L48;
        r12.skipToGroupEnd();
        Composer r16 = r12;
    L144:
        ScopeUpdateScope r10 = r16.endRestartGroup();
        if (r10 == null) goto L150;
        r10.updateScope(new MemberPreviewSectionKt$MemberPreviewSection$3(r33, r34, r35, r36, r37, r39));
        return;
    L150:
        return;
    L48:
        if (ComposerKt.isTraceInProgress() == false) goto L50;
        ComposerKt.traceEventStart(812326356, r9, -1, "com.ss.android.lark.compose.chatsetting.main.ui.sections.memberpreview.MemberPreviewSection (MemberPreviewSection.kt:27)");
    L50:
        r12.startReplaceGroup(-1224400529);
        if ((r9 & 14) != 4) goto L53;
        boolean r3 = true;
    L55:
        if ((r9 & 112) != 32) goto L57;
        boolean r5 = true;
    L58:
        boolean r11 = (r3 | r5) | r12.changedInstance(r35);
        int r13 = r9 & 57344;
        if (r13 != 16384) goto L61;
    L66:
        boolean r14 = true;
    L67:
        boolean r15 = r11 | r14;
        Object r17 = r12.rememberedValue();
        if (r15 == false) goto L70;
    L71:
        r17 = new MemberPreviewSectionKt$MemberPreviewSection$viewModel$1$1(r33, r34, r35, r37);
        r12.updateRememberedValue(r17);
    L72:
        Function1 r18 = (Function1) r17;
        r12.endReplaceGroup();
        HasDefaultViewModelProviderFactory r19 = LocalViewModelStoreOwner.INSTANCE.getCurrent(r12, 6);
        if (r19 == null) goto L149;
        KClass r110 = Reflection.getOrCreateKotlinClass(GroupMembersViewModel.class);
        InitializerViewModelFactoryBuilder r20 = new InitializerViewModelFactoryBuilder();
        r20.addInitializer(Reflection.getOrCreateKotlinClass(GroupMembersViewModel.class), r18);
        ViewModelProvider.Factory r21 = r20.build();
        if ((r19 instanceof HasDefaultViewModelProviderFactory) == false) goto L77;
        CreationExtras r22 = r19.getDefaultViewModelCreationExtras();
    L78:
        final GroupMembersViewModel r111 = (GroupMembersViewModel) ViewModelKt.viewModel(r110, r19, null, r21, r22, r12, 0, 0);
        final Context r112 = d8b.b.a(r12);
        State r23 = SnapshotStateKt.collectAsState(r111.getUiState(), null, r12, 0, 1);
        Modifier r25 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
        r12.startReplaceGroup(-1746271574);
        boolean r24 = r12.changedInstance(r111) | r12.changedInstance(r112);
        if (r13 != 16384) goto L81;
    L86:
        boolean r26 = true;
    L87:
        boolean r27 = r24 | r26;
        Object r28 = r12.rememberedValue();
        if (r27 == false) goto L90;
    L91:
        r28 = new MemberPreviewSectionKt$MemberPreviewSection$1$1(r111, r112, r37);
        r12.updateRememberedValue(r28);
    L92:
        r12.endReplaceGroup();
        Modifier r29 = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(r25, false, null, null, null, (Function0) r28, 15, null), 0.0f, Dp.constructor-impl(12), 1, null);
        MeasurePolicy r30 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r12, 0);
        long r210 = ComposablesKt.getCurrentCompositeKeyHashCode(r12, 0);
        int r31 = (int) (r210 ^ (r210 >>> 32));
        CompositionLocalMap r32 = r12.getCurrentCompositionLocalMap();
        Modifier r40 = ComposedModifierKt.materializeModifier(r12, r29);
        ComposeUiNode.Companion r41 = ComposeUiNode.Companion;
        Function0 r42 = r41.getConstructor();
        if ((r12.getApplier() instanceof Applier) == true) goto L95;
        ComposablesKt.invalidApplier();
    L95:
        r12.startReusableNode();
        if (r12.getInserting() == false) goto L98;
        r12.createNode(r42);
    L99:
        Composer r1 = Updater.constructor-impl(r12);
        Updater.set-impl(r1, r30, r41.getSetMeasurePolicy());
        Updater.set-impl(r1, r32, r41.getSetResolvedCompositionLocals());
        Function2 r43 = r41.getSetCompositeKeyHash();
        if (r1.getInserting() == false) goto L102;
    L103:
        r1.updateRememberedValue(Integer.valueOf(r31));
        r1.apply(Integer.valueOf(r31), r43);
    L104:
        Updater.set-impl(r1, r40, r41.getSetModifier());
        ColumnScopeInstance r2 = ColumnScopeInstance.INSTANCE;
        MemberPreviewHeaderKt.a(null, ((c) r23.getValue()).e, ((c) r23.getValue()).b, ((c) r23.getValue()).f, r12, 0, 1);
        List<Chatter> r44 = ((c) r23.getValue()).a;
        c r45 = (c) r23.getValue();
        Intrinsics.checkNotNullParameter(r45, "<this>");
        if (r45.c == false) goto L107;
    L110:
        boolean r46 = true;
        if (r45.e <= 1) goto L113;
        boolean r47 = true;
    L114:
        r12.startReplaceGroup(-1746271574);
        boolean r48 = r12.changedInstance(r111) | r12.changedInstance(r112);
        if (r13 != 16384) goto L117;
    L122:
        boolean r113 = true;
    L123:
        boolean r49 = r48 | r113;
        Object r114 = r12.rememberedValue();
        if (r49 == false) goto L126;
    L127:
        r114 = new MemberPreviewSectionKt$MemberPreviewSection$2$1$1(r111, r112, r37);
        r12.updateRememberedValue(r114);
    L128:
        Function1 r50 = (Function1) r114;
        r12.endReplaceGroup();
        r12.startReplaceGroup(-1746271574);
        boolean r51 = r12.changedInstance(r111) | r12.changedInstance(r112);
        if (r13 != 16384) goto L131;
    L136:
        boolean r52 = r51 | r46;
        Object r53 = r12.rememberedValue();
        if (r52 == false) goto L139;
    L140:
        r53 = new MemberPreviewSectionKt$MemberPreviewSection$2$2$1(r111, r112, r37);
        r12.updateRememberedValue(r53);
    L141:
        r12.endReplaceGroup();
        r16 = r12;
        MemberPreviewGridKt.a(null, r44, true, r47, r35, r50, r36, (Function0) r53, r12, (((r9 << 6) & 57344) | 384) | ((r9 << 9) & 3670016), 1);
        r16.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L144;
        ComposerKt.traceEventEnd();
        goto L144
    L139:
        if (r53 != Composer.Companion.getEmpty()) goto L141;
    L131:
        if ((r9 & 32768) != 0) goto L133;
    L135:
        r46 = false;
        goto L136
    L133:
        if (r12.changedInstance(r37) == false) goto L135;
    L126:
        if (r114 != Composer.Companion.getEmpty()) goto L128;
    L117:
        if ((r9 & 32768) != 0) goto L119;
    L121:
        r113 = false;
        goto L123
    L119:
        if (r12.changedInstance(r37) == false) goto L121;
    L113:
        r47 = false;
        goto L114
    L107:
        if (r45.d == true) goto L110;
        r46 = true;
        goto L113
    L102:
        if (Intrinsics.areEqual(r1.rememberedValue(), Integer.valueOf(r31)) == true) goto L104;
    L98:
        r12.useNode();
        goto L99
    L90:
        if (r28 != Composer.Companion.getEmpty()) goto L92;
    L81:
        if ((r9 & 32768) != 0) goto L83;
    L85:
        r26 = false;
        goto L87
    L83:
        if (r12.changedInstance(r37) == false) goto L85;
    L77:
        r22 = CreationExtras.Empty.INSTANCE;
        goto L78
    L149:
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    L70:
        if (r17 != Composer.Companion.getEmpty()) goto L72;
    L61:
        if ((r9 & 32768) != 0) goto L63;
    L65:
        r14 = false;
        goto L67
    L63:
        if (r12.changedInstance(r37) == false) goto L65;
    L57:
        r5 = false;
        goto L58
    L53:
        r3 = false;
        goto L55
    L34:
        if ((r39 & 32768) != 0) goto L36;
        boolean r54 = r12.changed(r37);
    L37:
        if (r54 == false) goto L39;
        int r55 = 16384;
    L40:
        r4 = r4 | r55;
        goto L41
    L39:
        r55 = 8192;
        goto L40
    L36:
        r54 = r12.changedInstance(r37);
        goto L37
    L5:
        if (r12.changed(r33) == false) goto L7;
        int r56 = 4;
    L8:
        r4 = r56 | r39;
        goto L11
    L7:
        r56 = 2;
        goto L8
    }
}
