package com.ss.android.lark.profile_office.userprofile;

import android.content.Context;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.ScaffoldKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileResponse;
import com.bytedance.lark.pb.contact.v2.I18nVal;
import com.larksuite.framework.utils.ICUUtils;
import com.ss.android.lark.compose.foundation.dialog.FlowAlertDialogKt;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.profile.dto.ProfileFinishResult;
import com.ss.android.lark.profile_office.userprofile.dialog.ApplyFriendDialogKt;
import com.ss.android.lark.profile_office.userprofile.dialog.EditAliasDialogKt;
import com.ss.android.lark.profile_office.userprofile.dialog.ReportPopupKt;
import com.ss.android.lark.profile_office.userprofile.section.ActionSectionKt;
import com.ss.android.lark.profile_office.userprofile.section.CtaSectionKt;
import com.ss.android.lark.profile_office.userprofile.section.DoubaoSectionKt;
import com.ss.android.lark.profile_office.userprofile.section.FriendshipSectionKt;
import com.ss.android.lark.profile_office.userprofile.section.HeaderSectionKt;
import com.ss.android.lark.profile_office.userprofile.section.InfoSectionKt;
import com.ss.android.lark.profile_office.userprofile.section.WorkInfoSectionKt;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeProfileScreenKt {
    public static final OfficeProfileState d(State r0) {
        return (OfficeProfileState) r0.getValue();
    }

    public static final void c(final OfficeProfileState r31, Function1<? super Integer, Unit> r32, final Function1<? super k, Unit> r33, Composer r34, final int r35, final int r36) {
        Intrinsics.checkNotNullParameter(r31, "state");
        Intrinsics.checkNotNullParameter(r33, "onIntent");
        Composer r14 = r34.startRestartGroup(1988734605);
        if ((r36 & 1) == 0) goto L6;
        int r3 = r35 | 6;
    L13:
        int r4 = r36 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Function1<? super Integer, Unit> r6 = r32;
    L25:
        if ((r36 & 4) == 0) goto L28;
        r3 = r3 | 384;
    L34:
        int r12 = r3;
        if ((r12 & 147) != 146) goto L41;
        if (r14.getSkipping() == false) goto L41;
        r14.skipToGroupEnd();
        final Function1<? super Integer, Unit> r2 = r6;
        Composer r13 = r14;
    L90:
        ScopeUpdateScope r7 = r13.endRestartGroup();
        if (r7 == null) goto L94;
        r7.updateScope(new OfficeProfileScreenKt$ProfileContent$3(r31, r2, r33, r35, r36));
        return;
    L94:
        return;
    L41:
        if (r4 == 0) goto L43;
        Function1<? super Integer, Unit> r11 = null;
    L45:
        if (ComposerKt.isTraceInProgress() == false) goto L47;
        ComposerKt.traceEventStart(1988734605, r12, -1, "com.ss.android.lark.profile_office.userprofile.ProfileContent (OfficeProfileScreen.kt:349)");
    L47:
        ScrollState r8 = ScrollKt.rememberScrollState(0, r14, 0, 1);
        State r9 = SnapshotStateKt.rememberUpdatedState(r11, r14, (r12 >> 3) & 14);
        r14.startReplaceGroup(-1633490746);
        boolean r10 = r14.changed(r8) | r14.changed(r9);
        Object r15 = r14.rememberedValue();
        if (r10 == false) goto L50;
    L51:
        r15 = new OfficeProfileScreenKt$ProfileContent$1$1(r8, r9, null);
        r14.updateRememberedValue(r15);
    L52:
        r14.endReplaceGroup();
        EffectsKt.LaunchedEffect(r8, (Function2) r15, r14, 0);
        Modifier.Companion r16 = Modifier.Companion;
        Modifier r5 = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(r16, 0.0f, 1, null), r8, false, null, false, 14, null);
        MeasurePolicy r17 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r14, 0);
        long r18 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r19 = (int) (r18 ^ (r18 >>> 32));
        CompositionLocalMap r20 = r14.getCurrentCompositionLocalMap();
        Modifier r21 = ComposedModifierKt.materializeModifier(r14, r5);
        ComposeUiNode.Companion r22 = ComposeUiNode.Companion;
        Function0 r23 = r22.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L55;
        ComposablesKt.invalidApplier();
    L55:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L58;
        r14.createNode(r23);
    L59:
        Composer r24 = Updater.constructor-impl(r14);
        Updater.set-impl(r24, r17, r22.getSetMeasurePolicy());
        Updater.set-impl(r24, r20, r22.getSetResolvedCompositionLocals());
        Function2 r25 = r22.getSetCompositeKeyHash();
        if (r24.getInserting() == false) goto L62;
    L63:
        r24.updateRememberedValue(Integer.valueOf(r19));
        r24.apply(Integer.valueOf(r19), r25);
    L64:
        Updater.set-impl(r24, r21, r22.getSetModifier());
        ColumnScopeInstance r26 = ColumnScopeInstance.INSTANCE;
        boolean r27 = r31.q(l.j.b);
        boolean r28 = r31.q(l.o.b);
        boolean r29 = r31.q(l.i.b);
        boolean r30 = r31.q(l.m.b);
        String r37 = r31.l();
        String r38 = r31.k();
        String r39 = r31.m();
        String r110 = r31.b();
        String r111 = r31.g();
        Long r112 = r31.f();
        RecogniseSpansResult r113 = r31.l;
        String r210 = r31.f.b();
        String r211 = r31.j();
        boolean r212 = r31.s();
        boolean r213 = r31.p();
        boolean r214 = r31.n();
        boolean r40 = r31.m;
        q1c.b<GetDoubaoProfileResponse> r41 = r31.a;
        if (r41 == null) goto L71;
        GetDoubaoProfileResponse r42 = r41.a();
        if (r42 == null) goto L71;
        GetDoubaoProfileResponse.UserInfo r43 = r42.user_info;
        if (r43 == null) goto L71;
        String r215 = r43.contact_application_reason;
    L72:
        q1c.b<GetDoubaoProfileResponse> r44 = r31.a;
        if (r44 == null) goto L81;
        GetDoubaoProfileResponse r45 = r44.a();
        if (r45 == null) goto L81;
        GetDoubaoProfileResponse.UserInfo r46 = r45.user_info;
        if (r46 == null) goto L81;
        I18nVal r47 = r46.contact_application_source_text;
        if (r47 == null) goto L81;
        String r216 = w1c.a.a(r47);
    L82:
        Function1<? super Integer, Unit> r310 = r11;
        HeaderSectionKt.a(r27, r28, r29, r30, r37, r38, r39, r110, r111, r112, r113, r210, r211, r212, r213, r214, r40, r215, r216, r33, r14, 0, (r12 << 21) & 1879048192);
        r13 = r14;
        r13.startReplaceGroup(-1273299686);
        if (r31.q(l.k.b) == false) goto L85;
        r13.startReplaceGroup(-1273292184);
        FriendshipSectionKt.a(r31.n(), r31.d(), r31.i, r33, r13, (r12 << 3) & 7168);
        r13.endReplaceGroup();
        Function1<? super k, Unit> r0 = r33;
    L86:
        WorkInfoSectionKt.a(r31.q(l.g.b), r31.q(l.C0120l.b), r31.q(l.c.b), r31.h, r31.i(), r31.h(), r31.c(), r31.j, r33, r13, (r0 << 18) & 234881024);
        DoubaoSectionKt.a(r31.q(l.h.b), r31.g, r0, r13, r0 & 896);
        InfoSectionKt.a(r31.q(l.a.b), r31.q(l.n.b), r31.b(), r31.u(), r31.d, r33, r13, (r0 << 9) & 458752);
        ActionSectionKt.a(r31.q(l.b.b), r31.q(l.f.b), r31.k, r33, r13, (r12 << 3) & 7168);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(r16, Dp.constructor-impl(16)), r13, 6);
        r13.endReplaceGroup();
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventEnd();
    L89:
        r2 = r310;
        goto L90
    L85:
        r13.startReplaceGroup(-1273011603);
        r0 = r33;
        CtaSectionKt.a(r31.q(l.e.b), r31.e(), r0, r13, r12 & 896);
        r13.endReplaceGroup();
    L81:
        r216 = null;
    L71:
        r215 = null;
        goto L72
    L62:
        if (Intrinsics.areEqual(r24.rememberedValue(), Integer.valueOf(r19)) == true) goto L64;
    L58:
        r14.useNode();
        goto L59
    L50:
        if (r15 != Composer.Companion.getEmpty()) goto L52;
    L43:
        r11 = r6;
        goto L45
    L28:
        if ((r35 & 384) != 0) goto L34;
        if (r14.changedInstance(r33) == false) goto L32;
        int r48 = 256;
    L33:
        r3 = r3 | r48;
        goto L34
    L32:
        r48 = 128;
        goto L33
    L17:
        if ((r35 & 48) != 0) goto L23;
        r6 = r32;
        if (r14.changedInstance(r6) == false) goto L21;
        int r49 = 32;
    L22:
        r3 = r3 | r49;
        goto L25
    L21:
        r49 = 16;
        goto L22
    L6:
        if ((r35 & 6) == 0) goto L8;
        r3 = r35;
        goto L13
    L8:
        if (r14.changed(r31) == false) goto L10;
        int r50 = 4;
    L11:
        r3 = r50 | r35;
        goto L13
    L10:
        r50 = 2;
        goto L11
    }

    public static final void a(final OfficeProfileState r27, final boolean r28, final boolean r29, Function1<? super Integer, Unit> r30, final Function1<? super k, Unit> r31, final Function0<Unit> r32, Composer r33, final int r34, final int r35) {
        Intrinsics.checkNotNullParameter(r27, "state");
        Intrinsics.checkNotNullParameter(r31, "onIntent");
        Intrinsics.checkNotNullParameter(r32, "onBack");
        Composer r15 = r33.startRestartGroup(-495681926);
        if ((r35 & 1) == 0) goto L6;
        int r1 = r34 | 6;
    L14:
        if ((r35 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r35 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r2 = r35 & 8;
        if (r2 == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        final Function1<? super Integer, Unit> r4 = r30;
    L45:
        if ((r35 & 16) == 0) goto L48;
        r1 = r1 | 24576;
    L55:
        if ((r35 & 32) == 0) goto L58;
        r1 = r1 | 196608;
    L65:
        if ((74899 & r1) != 74898) goto L71;
        if (r15.getSkipping() == false) goto L71;
        r15.skipToGroupEnd();
        Composer r0 = r15;
    L98:
        ScopeUpdateScope r12 = r0.endRestartGroup();
        if (r12 == null) goto L102;
        r12.updateScope(new OfficeProfileScreenKt$OfficeProfileScaffold$2(r27, r28, r29, r4, r31, r32, r34, r35));
        return;
    L102:
        return;
    L71:
        if (r2 == 0) goto L73;
        Function1<? super Integer, Unit> r13 = null;
    L75:
        if (ComposerKt.isTraceInProgress() == false) goto L77;
        ComposerKt.traceEventStart(-495681926, r1, -1, "com.ss.android.lark.profile_office.userprofile.OfficeProfileScaffold (OfficeProfileScreen.kt:248)");
    L77:
        r15.startReplaceGroup(1849434622);
        Object r3 = r15.rememberedValue();
        if (r3 != Composer.Companion.getEmpty()) goto L80;
        r3 = InteractionSourceKt.MutableInteractionSource();
        r15.updateRememberedValue(r3);
    L80:
        final MutableInteractionSource r5 = (MutableInteractionSource) r3;
        r15.endReplaceGroup();
        Modifier.Companion r6 = Modifier.Companion;
        Modifier r7 = SizeKt.fillMaxSize$default(r6, 0.0f, 1, null);
        MeasurePolicy r8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        long r16 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        final Function1<? super Integer, Unit> r22 = r13;
        int r9 = (int) (r16 ^ (r16 >>> 32));
        CompositionLocalMap r10 = r15.getCurrentCompositionLocalMap();
        Modifier r11 = ComposedModifierKt.materializeModifier(r15, r7);
        ComposeUiNode.Companion r14 = ComposeUiNode.Companion;
        Function0 r17 = r14.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L83;
        ComposablesKt.invalidApplier();
    L83:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L86;
        r15.createNode(r17);
    L87:
        Composer r18 = Updater.constructor-impl(r15);
        Updater.set-impl(r18, r8, r14.getSetMeasurePolicy());
        Updater.set-impl(r18, r10, r14.getSetResolvedCompositionLocals());
        Function2 r19 = r14.getSetCompositeKeyHash();
        if (r18.getInserting() == false) goto L90;
    L91:
        r18.updateRememberedValue(Integer.valueOf(r9));
        r18.apply(Integer.valueOf(r9), r19);
    L92:
        Updater.set-impl(r18, r11, r14.getSetModifier());
        BoxScopeInstance r20 = BoxScopeInstance.INSTANCE;
        Modifier r21 = BackgroundKt.background-bw27NRU$default(r6, n.a(r15, 0).c.b, null, 2, null);
        if (r28 == false) goto L95;
        r21 = WindowInsetsPadding_androidKt.statusBarsPadding(r21);
    L95:
        long r110 = Color.Companion.getTransparent-0d7_KjU();
        final boolean r23 = false;
        r4 = r22;
        r0 = r15;
        ScaffoldKt.Scaffold-TvnljyQ(r21, ComposableLambdaKt.rememberComposableLambda(1296867824, true, new OfficeProfileScreenKt$OfficeProfileScaffold$1$2(r29, r5, r32, r23, r27, r31), r15, 54), null, null, null, 0, r110, 0, null, ComposableLambdaKt.rememberComposableLambda(-697650107, true, new OfficeProfileScreenKt$OfficeProfileScaffold$1$3(r27, r22, r31), r15, 54), r0, 806879280, 444);
        r0.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventEnd();
        goto L98
    L90:
        if (Intrinsics.areEqual(r18.rememberedValue(), Integer.valueOf(r9)) == true) goto L92;
    L86:
        r15.useNode();
        goto L87
    L73:
        r13 = r4;
        goto L75
    L58:
        if ((r34 & 196608) != 0) goto L65;
        if (r15.changedInstance(r32) == false) goto L62;
        int r24 = 131072;
    L63:
        r1 = r1 | r24;
        goto L65
    L62:
        r24 = 65536;
        goto L63
    L48:
        if ((r34 & 24576) != 0) goto L55;
        if (r15.changedInstance(r31) == false) goto L52;
        int r25 = 16384;
    L53:
        r1 = r1 | r25;
        goto L55
    L52:
        r25 = 8192;
        goto L53
    L37:
        if ((r34 & 3072) != 0) goto L43;
        r4 = r30;
        if (r15.changedInstance(r4) == false) goto L41;
        int r26 = 2048;
    L42:
        r1 = r1 | r26;
        goto L45
    L41:
        r26 = 1024;
        goto L42
    L27:
        if ((r34 & 384) != 0) goto L33;
        if (r15.changed(r29) == false) goto L31;
        int r36 = 256;
    L32:
        r1 = r1 | r36;
        goto L33
    L31:
        r36 = 128;
        goto L32
    L17:
        if ((r34 & 48) != 0) goto L24;
        if (r15.changed(r28) == false) goto L21;
        int r37 = 32;
    L22:
        r1 = r1 | r37;
        goto L24
    L21:
        r37 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r1 = r34;
        goto L14
    L8:
        if (r15.changed(r27) == false) goto L10;
        int r38 = 4;
    L11:
        r1 = r38 | r34;
        goto L14
    L10:
        r38 = 2;
        goto L11
    }

    public static final void b(final String r32, final String r33, final ContactSource r34, boolean r35, boolean r36, Function1<? super Integer, Unit> r37, final Function2<? super ProfileFinishResult, ? super Boolean, Unit> r38, Composer r39, final int r40, final int r41) {
        Intrinsics.checkNotNullParameter(r38, "onBack");
        Composer r7 = r39.startRestartGroup(1679029334);
        if ((r41 & 1) == 0) goto L6;
        int r1 = r40 | 6;
    L14:
        if ((r41 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r41 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r3 = r41 & 8;
        if (r3 == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        boolean r11 = r35;
    L44:
        int r12 = r41 & 16;
        if (r12 == 0) goto L48;
        r1 = r1 | 24576;
    L54:
        boolean r13 = r36;
    L55:
        int r14 = r41 & 32;
        if (r14 == 0) goto L59;
        r1 = r1 | 196608;
    L65:
        Function1<? super Integer, Unit> r15 = r37;
    L67:
        if ((r41 & 64) == 0) goto L70;
        r1 = r1 | 1572864;
    L77:
        if ((r1 & 599187) != 599186) goto L83;
        if (r7.getSkipping() == false) goto L83;
        r7.skipToGroupEnd();
        Composer r9 = r7;
        final boolean r4 = r11;
        final boolean r5 = r13;
        final Function1<? super Integer, Unit> r6 = r15;
    L243:
        ScopeUpdateScope r10 = r9.endRestartGroup();
        if (r10 == null) goto L249;
        r10.updateScope(new OfficeProfileScreenKt$OfficeProfileScreen$5(r32, r33, r34, r4, r5, r6, r38, r40, r41));
        return;
    L249:
        return;
    L83:
        if (r3 == 0) goto L85;
        boolean r28 = true;
    L86:
        if (r12 == 0) goto L88;
        boolean r29 = true;
    L90:
        if (r14 == 0) goto L92;
        Function1<? super Integer, Unit> r30 = null;
    L94:
        if (ComposerKt.isTraceInProgress() == false) goto L96;
        ComposerKt.traceEventStart(1679029334, r1, -1, "com.ss.android.lark.profile_office.userprofile.OfficeProfileScreen (OfficeProfileScreen.kt:71)");
    L96:
        Context r2 = (Context) r7.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        HasDefaultViewModelProviderFactory r16 = LocalViewModelStoreOwner.INSTANCE.getCurrent(r7, 6);
        if (r16 == null) goto L248;
        if ((r16 instanceof HasDefaultViewModelProviderFactory) == false) goto L101;
        CreationExtras r0 = r16.getDefaultViewModelCreationExtras();
    L102:
        final OfficeProfileViewModel r17 = (OfficeProfileViewModel) ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(OfficeProfileViewModel.class), r16, null, null, r0, r7, 0, 0);
        OfficeProfileState r18 = (OfficeProfileState) SnapshotStateKt.collectAsState(r17.getState(), null, r7, 0, 1).getValue();
        State r19 = SnapshotStateKt.rememberUpdatedState(r18, r7, 0);
        d r110 = (d) SnapshotStateKt.collectAsState(r17.getDialogState(), null, r7, 0, 1).getValue();
        r7.startReplaceGroup(5004770);
        boolean r111 = r7.changed(r2);
        Object r8 = r7.rememberedValue();
        if (r111 == false) goto L105;
    L106:
        r8 = new g(r2);
        r7.updateRememberedValue(r8);
    L107:
        g r20 = (g) r8;
        r7.endReplaceGroup();
        r7.startReplaceGroup(5004770);
        boolean r21 = r7.changed(r17);
        Object r22 = r7.rememberedValue();
        if (r21 == false) goto L110;
    L111:
        r22 = new OfficeProfileScreenKt$OfficeProfileScreen$onIntent$1$1(r17);
        r7.updateRememberedValue(r22);
    L112:
        Function1 r23 = (Function1) r22;
        r7.endReplaceGroup();
        r7.startReplaceGroup(-1633490746);
        boolean r24 = r7.changed(r17);
        if ((r1 & 3670016) != 1048576) goto L115;
        boolean r25 = true;
    L116:
        boolean r26 = r24 | r25;
        Object r27 = r7.rememberedValue();
        if (r26 == false) goto L119;
    L120:
        r27 = new OfficeProfileScreenKt$OfficeProfileScreen$backWithResult$1$1(r38, r17);
        r7.updateRememberedValue(r27);
    L121:
        final Function1 r112 = (Function1) r27;
        r7.endReplaceGroup();
        r7.startReplaceGroup(-1224400529);
        boolean r31 = r7.changedInstance(r17);
        int r42 = r1 & 14;
        if (r42 != 4) goto L124;
        boolean r43 = true;
    L125:
        boolean r44 = r31 | r43;
        int r45 = r1 & 112;
        if (r45 != 32) goto L128;
        boolean r210 = true;
    L129:
        boolean r46 = (r44 | r210) | r7.changedInstance(r34);
        Object r47 = r7.rememberedValue();
        if (r46 == false) goto L132;
    L135:
        char r113 = ' ';
        OfficeProfileScreenKt$OfficeProfileScreen$1$1 r48 = new OfficeProfileScreenKt$OfficeProfileScreen$1$1(r17, r32, r33, r34, null);
        r7.updateRememberedValue(r48);
        r47 = r48;
    L136:
        r7.endReplaceGroup();
        EffectsKt.LaunchedEffect(r32, r33, r34, (Function2) r47, r7, (r42 | r45) | (r1 & 896));
        r7.startReplaceGroup(-1224400529);
        boolean r49 = ((((r7.changedInstance(r17) | r7.changedInstance(r2)) | r7.changed(r112)) | r7.changedInstance(r18)) | r7.changed(r19)) | r7.changedInstance(r34);
        Object r50 = r7.rememberedValue();
        if (r49 == false) goto L139;
    L142:
        Composer r114 = r7;
        OfficeProfileScreenKt$OfficeProfileScreen$2$1 r51 = new OfficeProfileScreenKt$OfficeProfileScreen$2$1(r17, r2, r112, r20, r34, r19, null);
        r114.updateRememberedValue(r51);
        r50 = r51;
    L143:
        r114.endReplaceGroup();
        EffectsKt.LaunchedEffect(r17, (Function2) r50, r114, 0);
        r114.startReplaceGroup(5004770);
        boolean r52 = r114.changed(r112);
        Object r53 = r114.rememberedValue();
        if (r52 == false) goto L146;
    L147:
        r53 = new OfficeProfileScreenKt$OfficeProfileScreen$3$1(r112);
        r114.updateRememberedValue(r53);
    L148:
        r114.endReplaceGroup();
        boolean r54 = true;
        BackHandlerKt.BackHandler(false, (Function0) r53, r114, 0, 1);
        Modifier r55 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
        MeasurePolicy r56 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        long r57 = ComposablesKt.getCurrentCompositeKeyHashCode(r114, 0);
        int r58 = (int) (r57 ^ (r57 >>> r113));
        CompositionLocalMap r59 = r114.getCurrentCompositionLocalMap();
        Modifier r60 = ComposedModifierKt.materializeModifier(r114, r55);
        ComposeUiNode.Companion r61 = ComposeUiNode.Companion;
        Function0 r62 = r61.getConstructor();
        if ((r114.getApplier() instanceof Applier) == true) goto L151;
        ComposablesKt.invalidApplier();
    L151:
        r114.startReusableNode();
        if (r114.getInserting() == false) goto L154;
        r114.createNode(r62);
    L155:
        Composer r63 = Updater.constructor-impl(r114);
        Updater.set-impl(r63, r56, r61.getSetMeasurePolicy());
        Updater.set-impl(r63, r59, r61.getSetResolvedCompositionLocals());
        Function2 r64 = r61.getSetCompositeKeyHash();
        if (r63.getInserting() == false) goto L158;
    L159:
        r63.updateRememberedValue(Integer.valueOf(r58));
        r63.apply(Integer.valueOf(r58), r64);
    L160:
        Updater.set-impl(r63, r60, r61.getSetModifier());
        BoxScopeInstance r65 = BoxScopeInstance.INSTANCE;
        r114.startReplaceGroup(5004770);
        boolean r66 = r114.changed(r112);
        Object r67 = r114.rememberedValue();
        if (r66 == false) goto L163;
    L164:
        r67 = new OfficeProfileScreenKt$OfficeProfileScreen$4$1$1(r112);
        r114.updateRememberedValue(r67);
    L165:
        r114.endReplaceGroup();
        int r68 = r1 >> 6;
        r9 = r114;
        a(r18, r28, r29, r30, r23, (Function0) r67, r9, ((r68 & 112) | (r68 & 896)) | (r68 & 7168), 0);
        r9.startReplaceGroup(2001267896);
        if (r110.a == false) goto L178;
        String r69 = r18.b();
        boolean r70 = r110.b;
        r9.startReplaceGroup(5004770);
        final Function1 r115 = r23;
        boolean r71 = r9.changed(r115);
        Object r72 = r9.rememberedValue();
        if (r71 == false) goto L170;
    L171:
        r72 = new OfficeProfileScreenKt$OfficeProfileScreen$4$2$1(r115);
        r9.updateRememberedValue(r72);
    L172:
        Function1 r73 = (Function1) r72;
        r9.endReplaceGroup();
        r9.startReplaceGroup(5004770);
        boolean r74 = r9.changed(r115);
        Object r116 = r9.rememberedValue();
        if (r74 == false) goto L175;
    L176:
        r116 = new OfficeProfileScreenKt$OfficeProfileScreen$4$3$1(r115);
        r9.updateRememberedValue(r116);
    L177:
        r9.endReplaceGroup();
        EditAliasDialogKt.a(r69, r70, r73, (Function0) r116, r9, 0);
    L179:
        r9.endReplaceGroup();
        r9.startReplaceGroup(2001282722);
        if (r5.c == false) goto L198;
        boolean r117 = r5.d;
        String r75 = StringResources_androidKt.stringResource(2131892428, r9, 0);
        xzb.a r76 = (xzb.a) ApiUtils.getApi(xzb.a.class);
        if (r76 == null) goto L184;
        String r77 = r76.getUserName();
    L185:
        if (r77 != null) goto L187;
        r77 = "";
    L187:
        String r118 = UIHelper.mustacheFormat(r75, "username", r77);
        String r78 = r18.b();
        r9.startReplaceGroup(5004770);
        boolean r79 = r9.changed(r115);
        Object r80 = r9.rememberedValue();
        if (r79 == false) goto L190;
    L191:
        r80 = new OfficeProfileScreenKt$OfficeProfileScreen$4$4$1(r115);
        r9.updateRememberedValue(r80);
    L192:
        Function2 r81 = (Function2) r80;
        r9.endReplaceGroup();
        r9.startReplaceGroup(5004770);
        boolean r82 = r9.changed(r115);
        Object r83 = r9.rememberedValue();
        if (r82 == false) goto L195;
    L196:
        r83 = new OfficeProfileScreenKt$OfficeProfileScreen$4$5$1(r115);
        r9.updateRememberedValue(r83);
    L197:
        Function0 r84 = (Function0) r83;
        r9.endReplaceGroup();
        int r85 = 6;
        ApplyFriendDialogKt.a(r117, r118, r78, r81, r84, r9, 0, 0);
    L199:
        r9.endReplaceGroup();
        r9.startReplaceGroup(2001307168);
        if (r5.f == false) goto L218;
        String r86 = StringResources_androidKt.stringResource(2131890041, r9, 0);
        ICUUtils.FormatArgsBuilder r87 = new ICUUtils.FormatArgsBuilder();
        String r88 = r18.b();
        if (r88.length() == 0) goto L205;
        r54 = false;
    L205:
        if (r54 == false) goto L207;
        r88 = r18.m();
    L207:
        r87.b(AppbrandHostConstants.Schema_Meta.NAME, r88);
        String r119 = ICUUtils.icuFormat(r86, r87.a);
        String r120 = StringResources_androidKt.stringResource(2131890040, r9, 0);
        String r121 = StringResources_androidKt.stringResource(2131890048, r9, 0);
        String r122 = StringResources_androidKt.stringResource(2131889964, r9, 0);
        long r89 = n.a(r9, 0).e.a;
        r9.startReplaceGroup(5004770);
        boolean r90 = r9.changed(r115);
        Object r91 = r9.rememberedValue();
        if (r90 == false) goto L210;
    L211:
        r91 = new OfficeProfileScreenKt$OfficeProfileScreen$4$7$1(r115);
        r9.updateRememberedValue(r91);
    L212:
        Function0 r123 = (Function0) r91;
        r9.endReplaceGroup();
        r9.startReplaceGroup(5004770);
        boolean r92 = r9.changed(r115);
        Object r93 = r9.rememberedValue();
        if (r92 == false) goto L215;
    L216:
        r93 = new OfficeProfileScreenKt$OfficeProfileScreen$4$8$1(r115);
        r9.updateRememberedValue(r93);
    L217:
        r9.endReplaceGroup();
        FlowAlertDialogKt.a(r119, r120, r121, r122, r89, 0, r123, null, (Function0) r93, false, false, r9, 805306368, 6, 160);
        goto L218
    L215:
        if (r93 != Composer.Companion.getEmpty()) goto L217;
    L210:
        if (r91 != Composer.Companion.getEmpty()) goto L212;
    L218:
        r9.endReplaceGroup();
        r9.startReplaceGroup(2001342859);
        if (r5.g == false) goto L226;
        String r124 = StringResources_androidKt.stringResource(2131890039, r9, 0);
        String r125 = StringResources_androidKt.stringResource(2131890038, r9, 0);
        String r126 = StringResources_androidKt.stringResource(2131889965, r9, 0);
        r9.startReplaceGroup(5004770);
        boolean r94 = r9.changed(r115);
        Object r95 = r9.rememberedValue();
        if (r94 == false) goto L223;
    L224:
        r95 = new OfficeProfileScreenKt$OfficeProfileScreen$4$9$1(r115);
        r9.updateRememberedValue(r95);
    L225:
        r9.endReplaceGroup();
        FlowAlertDialogKt.a(r124, r125, r126, null, 0, 0, null, null, (Function0) r95, false, false, r9, 0, 6, 760);
        goto L226
    L223:
        if (r95 != Composer.Companion.getEmpty()) goto L225;
    L226:
        r9.endReplaceGroup();
        r9.startReplaceGroup(2001359854);
        if (r110.e == false) goto L239;
        float r96 = Dp.constructor-impl(44);
        r9.startReplaceGroup(5004770);
        boolean r97 = r9.changed(r115);
        Object r98 = r9.rememberedValue();
        if (r97 == false) goto L231;
    L232:
        r98 = new OfficeProfileScreenKt$OfficeProfileScreen$4$10$1(r115);
        r9.updateRememberedValue(r98);
    L233:
        Function0 r99 = (Function0) r98;
        r9.endReplaceGroup();
        r9.startReplaceGroup(5004770);
        boolean r100 = r9.changed(r115);
        Object r101 = r9.rememberedValue();
        if (r100 == false) goto L236;
    L237:
        r101 = new OfficeProfileScreenKt$OfficeProfileScreen$4$11$1(r115);
        r9.updateRememberedValue(r101);
    L238:
        r9.endReplaceGroup();
        ReportPopupKt.a(r96, r99, (Function0) r101, r9, r85);
        goto L239
    L236:
        if (r101 != Composer.Companion.getEmpty()) goto L238;
    L231:
        if (r98 != Composer.Companion.getEmpty()) goto L233;
    L239:
        r9.endReplaceGroup();
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L242;
        ComposerKt.traceEventEnd();
    L242:
        r4 = r28;
        r5 = r29;
        r6 = r30;
        goto L243
    L195:
        if (r83 != Composer.Companion.getEmpty()) goto L197;
    L190:
        if (r80 != Composer.Companion.getEmpty()) goto L192;
    L184:
        r77 = null;
        goto L185
    L198:
        r85 = 6;
        goto L199
    L175:
        if (r116 != Composer.Companion.getEmpty()) goto L177;
    L170:
        if (r72 != Composer.Companion.getEmpty()) goto L172;
    L178:
        r115 = r23;
        goto L179
    L163:
        if (r67 != Composer.Companion.getEmpty()) goto L165;
    L158:
        if (Intrinsics.areEqual(r63.rememberedValue(), Integer.valueOf(r58)) == true) goto L160;
    L154:
        r114.useNode();
        goto L155
    L146:
        if (r53 != Composer.Companion.getEmpty()) goto L148;
    L139:
        if (r50 == Composer.Companion.getEmpty()) goto L142;
        r114 = r7;
        goto L143
    L132:
        if (r47 == Composer.Companion.getEmpty()) goto L135;
        r113 = ' ';
        goto L136
    L128:
        r210 = false;
        goto L129
    L124:
        r43 = false;
        goto L125
    L119:
        if (r27 != Composer.Companion.getEmpty()) goto L121;
    L115:
        r25 = false;
        goto L116
    L110:
        if (r22 != Composer.Companion.getEmpty()) goto L112;
    L105:
        if (r8 != Composer.Companion.getEmpty()) goto L107;
    L101:
        r0 = CreationExtras.Empty.INSTANCE;
        goto L102
    L248:
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    L92:
        r30 = r15;
        goto L94
    L88:
        r29 = r13;
        goto L90
    L85:
        r28 = r11;
        goto L86
    L70:
        if ((r40 & 1572864) != 0) goto L77;
        if (r7.changedInstance(r38) == false) goto L74;
        int r127 = 1048576;
    L75:
        r1 = r1 | r127;
        goto L77
    L74:
        r127 = 524288;
        goto L75
    L59:
        if ((196608 & r40) != 0) goto L65;
        r15 = r37;
        if (r7.changedInstance(r15) == false) goto L63;
        int r128 = 131072;
    L64:
        r1 = r1 | r128;
        goto L67
    L63:
        r128 = 65536;
        goto L64
    L48:
        if ((r40 & 24576) != 0) goto L54;
        r13 = r36;
        if (r7.changed(r13) == false) goto L52;
        int r129 = 16384;
    L53:
        r1 = r1 | r129;
        goto L55
    L52:
        r129 = 8192;
        goto L53
    L37:
        if ((r40 & 3072) != 0) goto L43;
        r11 = r35;
        if (r7.changed(r11) == false) goto L41;
        int r130 = 2048;
    L42:
        r1 = r1 | r130;
        goto L44
    L41:
        r130 = 1024;
        goto L42
    L27:
        if ((r40 & 384) != 0) goto L33;
        if (r7.changedInstance(r34) == false) goto L31;
        int r102 = 256;
    L32:
        r1 = r1 | r102;
        goto L33
    L31:
        r102 = 128;
        goto L32
    L17:
        if ((r40 & 48) != 0) goto L24;
        if (r7.changed(r33) == false) goto L21;
        int r103 = 32;
    L22:
        r1 = r1 | r103;
        goto L24
    L21:
        r103 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r1 = r40;
        goto L14
    L8:
        if (r7.changed(r32) == false) goto L10;
        int r104 = 4;
    L11:
        r1 = r104 | r40;
        goto L14
    L10:
        r104 = 2;
        goto L11
    }
}
