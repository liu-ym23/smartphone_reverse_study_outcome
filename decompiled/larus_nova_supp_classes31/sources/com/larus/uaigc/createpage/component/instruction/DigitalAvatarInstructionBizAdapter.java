package com.larus.uaigc.createpage.component.instruction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.g3;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.larus.platform.service.z2;
import com.larus.trace.DigitalAvatarProcessType;
import com.larus.uaigc.api.AIReplicaApi;
import com.larus.uaigc.createpage.CreationHostUiPolicy;
import com.larus.uaigc.service.ICreationAvatarService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class DigitalAvatarInstructionBizAdapter extends vp8.g {
    public static final /* synthetic */ int s = 0;
    public final BaseContentWidget h;
    public final vp8.j i;
    public final String j;
    public ActivityResultLauncher<Intent> k;
    public final Lazy l;
    public String m;
    public Balloon n;
    public long o;
    public ViewGroup p;
    public final int q;
    public Triple<Integer, Integer, Integer> r;

    public static final class a {
    }

    static {
    }

    private final Context getContext() {
        return this.h.getContext();
    }

    public final void p() {
        ActivityResultLauncher<Intent> r0 = this.k;
        if (r0 == null) goto L6;
        r0.unregister();
        return;
    }

    public final void I() {
        this.m = fy9.a.a();
        String r1 = null;
        if ((getContext() instanceof ny9.h) == false) goto L5;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.h), null, null, new DigitalAvatarInstructionBizAdapter$regenerateVideoAvatar$1(this, null), 3, null);
        return;
    L5:
        com.bytedance.router.i r0 = SmartRouter.buildRoute(getContext(), "//flow/create_digital_avatar");
        int r2 = CreationHostUiPolicy.f;
        boolean r3 = CreationHostUiPolicy.a.a(((vp8.g) this).g.getArguments()).a;
        r0.c.putExtra("from_ai_creation_applet", r3);
        int r4 = DigitalAvatarProcessType.BOTH_IMAGE_AND_VIDEO.getId();
        r0.c.putExtra("digital_avatar_process_type", r4);
        r0.c.putExtra("skip_digital_avatar_onboarding", true);
        com.larus.bmhome.chat.component.cvs.y r5 = (com.larus.bmhome.chat.component.cvs.y) ((vp8.g) this).d.getValue();
        if (r5 == null) goto L10;
        wc9.e r6 = r5.h();
        if (r6 == null) goto L10;
        r1 = r6.a;
    L10:
        r0.c.putExtra("argConversationId", r1);
        Bundle r7 = new Bundle();
        r7.putString("previous_page", "chat");
        r7.putString("replica_create_id", this.m);
        r0.c.putExtras(r7);
        r0.d = 2130772400;
        r0.e = 2130772399;
        r0.d();
    }

    public final void d() {
        if ((getContext() instanceof ny9.h) == false) goto L5;
        this.k = ((vp8.g) this).g.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new b2(this));
        return;
    L5:
        this.k = ((vp8.g) this).g.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new c2(this));
    }

    public static void A(final DigitalAvatarInstructionBizAdapter r9) {
        if (ICreationAvatarService.a.S() == false) goto L7;
        t19.s.j(t19.s.a, r9.getContext(), r9.getContext().getString(2131908410), null, false, 28);
        Balloon r10 = r9.n;
        if (r10 == null) goto L25;
        r10.h();
        return;
    L25:
        return;
    L7:
        tx9.r0.f("chat", "reset_replica");
        if (z2.a.hasAvatarModelUpdate() == false) goto L10;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9.h), null, null, new DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$1$1(r9, null), 3, null);
    L21:
        Balloon r11 = r9.n;
        if (r11 == null) goto L27;
        r11.h();
        return;
    L27:
        return;
    L10:
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L17;
        r0.H();
        VideoPortraitConfig r1 = com.larus.home.impl.sdk.l1.a.a();
        if (r1 == null) goto L17;
        boolean r2 = true;
        if (r1.getEnableVideoAvatar() != true) goto L17;
    L18:
        if (r2 == false) goto L20;
        r9.I();
        goto L21
    L20:
        Function0 r3 = new j2(r9);
        r9.getClass();
        com.larus.platform.service.k2 r4 = com.larus.platform.service.k2.a;
        g3.a.a(((vp8.g) r9).g, null, true, null, false, new i2(r3), 26);
    L17:
        r2 = false;
        goto L18
    }

    public static final /* synthetic */ Context C(DigitalAvatarInstructionBizAdapter r0) {
        return r0.getContext();
    }

    public final boolean q(final com.larus.bmhome.actionbar.model.r r5) {
        Integer r0 = r5.a;
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L21;
        ViewGroup r2 = this.p;
        ConstraintLayout r3 = null;
        if (r2 == null) goto L13;
        ImageView r4 = (ImageView) r2.findViewById(2131374662);
    L14:
        if (r4 == null) goto L16;
        com.larus.utils.e1.x(r4);
    L16:
        ViewGroup r6 = this.p;
        if (r6 == null) goto L19;
        r3 = r6.findViewById(2131388849);
    L19:
        if (r3 == null) goto L21;
        com.larus.utils.e1.d(r3, new d2(this, r5));
        goto L21
    L13:
        r4 = null;
    L21:
        return false;
    L6:
        if (r0.intValue() != 11) goto L8;
        r1 = true;
        goto L9
    }

    public final void u(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        this.p = r2;
    }

    public static void B(CommonDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, null);
    }

    public static final void E(DigitalAvatarInstructionBizAdapter r6, String r7) {
        r6.getClass();
        tx9.r0.f("chat", "confirm_delete_replica");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r6.h), null, null, new DigitalAvatarInstructionBizAdapter$realDeleteDigitalAvatar$1(r6, r7, null), 3, null);
    }

    public static final void G(DigitalAvatarInstructionBizAdapter r11, Triple r12) {
        r11.getClass();
        if (r12 == null) goto L5;
        int r1 = ((Number) r12.getFirst()).intValue();
    L6:
        if (r12 == null) goto L8;
        int r13 = ((Number) r12.getSecond()).intValue();
    L9:
        CommonDialog.a r2 = new CommonDialog.a();
        AppHost.Companion r3 = AppHost.a;
        r2.i(r3.getApplication().getString(2131908848));
        r2.g(r3.getApplication().getString(2131907682) + r3.getApplication().getResources().getQuantityString(2131755212, r1, new Object[]{Integer.valueOf(r1)}) + r3.getApplication().getResources().getQuantityString(2131755213, r13, new Object[]{Integer.valueOf(r13)}));
        com.larus.common_ui.dialog.f0 r4 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r11.getContext(), 2131102625)), null, 5);
        Intrinsics.checkNotNullParameter(r4, "commonDialogTextStyleConfig");
        r2.D = r4;
        com.larus.common_ui.dialog.f0 r5 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r11.getContext(), v19.c.b(2130972082, r11.getContext(), 2131103146))), null, 5);
        Intrinsics.checkNotNullParameter(r5, "commonDialogTextStyleConfig");
        r2.E = r5;
        r2.h(ContextCompat.getColor(r11.getContext(), v19.c.b(2130972082, r11.getContext(), 2131103146)));
        CommonDialog.a.f(r2, new p2(r13, r11), r3.getApplication().getString(2131908847), false, 12);
        CommonDialog.a.e(r2, new q2(), r3.getApplication().getString(2131907680), 4);
        B(r2.a(), ((vp8.g) r11).g.getChildFragmentManager());
        return;
    L8:
        r13 = 0;
        goto L9
    L5:
        r1 = 0;
        goto L6
    }

    public static final Object H(DigitalAvatarInstructionBizAdapter r5, Continuation r6) {
        r5.getClass();
        if ((r6 instanceof DigitalAvatarInstructionBizAdapter$tryFetchTrainQuotaInfo$1) == false) goto L7;
        DigitalAvatarInstructionBizAdapter$tryFetchTrainQuotaInfo$1 r0 = (DigitalAvatarInstructionBizAdapter$tryFetchTrainQuotaInfo$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        int r4 = 1;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        dm9.a.b r8 = (dm9.a) r7;
        int r9 = 0;
        if ((r8 instanceof dm9.a.b) == false) goto L31;
        FLogger.a.i("DigitalAvatarInstructionBizAdapter", "fetch train quota success");
        dm9.a.b r10 = r8;
        com.larus.uaigc.api.b r11 = (com.larus.uaigc.api.b) r10.a.getData();
        if (r11 == null) goto L22;
        int r12 = r11.c();
    L23:
        Integer r13 = Boxing.boxInt(r12);
        com.larus.uaigc.api.b r14 = (com.larus.uaigc.api.b) r10.a.getData();
        if (r14 == null) goto L26;
        r9 = r14.a();
    L26:
        Integer r15 = Boxing.boxInt(r9);
        com.larus.uaigc.api.b r16 = (com.larus.uaigc.api.b) r10.a.getData();
        if (r16 == null) goto L29;
        r4 = r16.b();
    L29:
        Triple<Integer, Integer, Integer> r17 = new Triple(r13, r15, Boxing.boxInt(r4));
    L33:
        r5.r = r17;
        return Unit.INSTANCE;
    L22:
        r12 = 0;
        goto L23
    L31:
        if ((r8 instanceof dm9.a.a) == false) goto L36;
        FLogger.a.i("DigitalAvatarInstructionBizAdapter", "fetch train quota fail: " + ((dm9.a.a) r8).c);
        r17 = new Triple(Boxing.boxInt(0), Boxing.boxInt(0), Boxing.boxInt(0));
        goto L33
    L36:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        AIReplicaApi.Companion r18 = AIReplicaApi.a;
        DigitalAvatarInstructionBizAdapter$tryFetchTrainQuotaInfo$result$1 r19 = new DigitalAvatarInstructionBizAdapter$tryFetchTrainQuotaInfo$result$1(null);
        r0.label = 1;
        r18.getClass();
        r7 = AIReplicaApi.Companion.b(r19, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new DigitalAvatarInstructionBizAdapter$tryFetchTrainQuotaInfo$1(r5, r6);
        goto L8
    }

    public static void v(DigitalAvatarInstructionBizAdapter r8, ActivityResult r9) {
        tx9.d2 r0 = tx9.d2.a;
        int r1 = r9.getResultCode();
        r0.getClass();
        tx9.d2.c(r1, "digital_avatar_instruction");
        if (r9.getResultCode() != (-1)) goto L39;
        Intent r10 = r9.getData();
        if (r10 == null) goto L7;
        ArrayList r11 = r10.getParcelableArrayListExtra("result.uri.list");
    L8:
        if (r11 == null) goto L15;
        ArrayList r2 = new ArrayList();
        Iterator r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L16;
        Uri r3 = ((AlbumSelectItem) r12.next()).a;
        if (r3 == null) goto L11;
        r2.add(r3);
    L16:
        if (r2 != null) goto L18;
    L21:
        boolean r13 = true;
    L22:
        if (r13 == true) goto L41;
        va8.o r14 = (va8.o) r8.l.getValue();
        if (r14 == null) goto L27;
        r14.ra();
    L27:
        Object r15 = r8.getContext();
        if ((r15 instanceof ny9.h) == false) goto L30;
        ny9.h r16 = (ny9.h) r15;
    L31:
        if (r16 == null) goto L40;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r8.h), null, null, new DigitalAvatarInstructionBizAdapter$onAttach$1$1$1(r8, r2, null), 3, null);
        return;
    L40:
        return;
    L30:
        r16 = null;
        goto L31
    L41:
        return;
    L18:
        if (r2.isEmpty() == true) goto L21;
        r13 = false;
        goto L22
    L15:
        r2 = null;
        goto L16
    L7:
        r11 = null;
        goto L8
    }

    public static void y(DigitalAvatarInstructionBizAdapter r11, String r12) {
        if (ICreationAvatarService.a.S() == false) goto L7;
        t19.s.j(t19.s.a, r11.getContext(), r11.getContext().getString(2131908409), null, false, 28);
        Balloon r13 = r11.n;
        if (r13 == null) goto L21;
        r13.h();
        return;
    L21:
        return;
    L7:
        tx9.r0.f("chat", "delete_replica");
        ICoreInputAbility r0 = r11.c();
        if (r0 == null) goto L11;
        r0.qp(false);
    L11:
        if (z2.a.hasAvatarModelUpdate() == false) goto L13;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r11.h), null, null, new DigitalAvatarInstructionBizAdapter$openDigitalAvatarMenu$2$1(r11, r12, null), 3, null);
    L14:
        com.larus.bmhome.instruction.g r14 = (com.larus.bmhome.instruction.g) ((vp8.g) r11).b.getValue();
        if (r14 == null) goto L17;
        r14.A1();
    L17:
        Balloon r15 = r11.n;
        if (r15 == null) goto L23;
        r15.h();
        return;
    L23:
        return;
    L13:
        CommonDialog.a r1 = new CommonDialog.a();
        AppHost.Companion r3 = AppHost.a;
        r1.i(r3.getApplication().getString(2131907683));
        r1.g(r3.getApplication().getString(2131907682));
        com.larus.common_ui.dialog.f0 r4 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r11.getContext(), v19.c.b(2130972079, r11.getContext(), 2131103136))), null, 5);
        Intrinsics.checkNotNullParameter(r4, "commonDialogTextStyleConfig");
        r1.D = r4;
        com.larus.common_ui.dialog.f0 r5 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r11.getContext(), v19.c.b(2130972082, r11.getContext(), 2131103146))), null, 5);
        Intrinsics.checkNotNullParameter(r5, "commonDialogTextStyleConfig");
        r1.E = r5;
        r1.h(ContextCompat.getColor(r11.getContext(), v19.c.b(2130972082, r11.getContext(), 2131103146)));
        CommonDialog.a.f(r1, new k2(r11, r12), r3.getApplication().getString(2131907681), false, 12);
        CommonDialog.a.e(r1, new l2(), r3.getApplication().getString(2131907680), 4);
        B(r1.a(), ((vp8.g) r11).g.getChildFragmentManager());
        goto L14
    }

    public DigitalAvatarInstructionBizAdapter(BaseContentWidget r2, vp8.j r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "component");
        Intrinsics.checkNotNullParameter(r4, "enterMethod");
        super(r2);
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.l = LazyKt.lazy(new e2(this));
        LaunchInfo r5 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r5 != null) goto L5;
    L8:
        int r6 = 10;
    L9:
        this.q = r6;
        return;
    L5:
        if (r5.K() <= 0) goto L8;
        r6 = r5.K();
        goto L9
    }

    public static final Object D(DigitalAvatarInstructionBizAdapter r5, Function2 r6, Continuation r7) {
        r5.getClass();
        if ((r7 instanceof DigitalAvatarInstructionBizAdapter$getMainBotConversationInfo$1) == false) goto L7;
        DigitalAvatarInstructionBizAdapter$getMainBotConversationInfo$1 r0 = (DigitalAvatarInstructionBizAdapter$getMainBotConversationInfo$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r8);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L24:
        wc9.e r10 = (wc9.e) r8;
    L25:
        r0.L$0 = null;
        r0.label = 2;
        if (r6.invoke(r10, r0) != r9) goto L29;
        return r9;
    L16:
        ResultKt.throwOnFailure(r8);
        ILaunchCacheService r11 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r11 == null) goto L21;
        r10 = r11.b();
        if (r10 != null) goto L25;
    L21:
        Flow r12 = FlowLiveDataConversions.asFlow(AuthModelDelegate.b.y());
        DigitalAvatarInstructionBizAdapter$getMainBotConversationInfo$cvs$2 r3 = new DigitalAvatarInstructionBizAdapter$getMainBotConversationInfo$cvs$2(null);
        r0.L$0 = r6;
        r0.label = 1;
        r8 = kotlinx.coroutines.flow.e.t(r12, r3, r0);
        if (r8 != r9) goto L24;
        return r9;
    L7:
        r0 = new DigitalAvatarInstructionBizAdapter$getMainBotConversationInfo$1(r5, r7);
        goto L8
    }

    public static final void F(DigitalAvatarInstructionBizAdapter r10, String r11, Triple r12) {
        r10.getClass();
        if (r12 == null) goto L5;
        int r1 = ((Number) r12.getFirst()).intValue();
    L6:
        if (r12 == null) goto L8;
        int r13 = ((Number) r12.getSecond()).intValue();
    L9:
        CommonDialog.a r2 = new CommonDialog.a();
        AppHost.Companion r3 = AppHost.a;
        r2.i(r3.getApplication().getString(2131908849));
        r2.g(r3.getApplication().getString(2131907682) + r3.getApplication().getResources().getQuantityString(2131755212, r1, new Object[]{Integer.valueOf(r1)}) + r3.getApplication().getResources().getQuantityString(2131755213, r13, new Object[]{Integer.valueOf(r13)}));
        com.larus.common_ui.dialog.f0 r14 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r10.getContext(), 2131102625)), null, 5);
        Intrinsics.checkNotNullParameter(r14, "commonDialogTextStyleConfig");
        r2.D = r14;
        com.larus.common_ui.dialog.f0 r15 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r10.getContext(), v19.c.b(2130972082, r10.getContext(), 2131103146))), null, 5);
        Intrinsics.checkNotNullParameter(r15, "commonDialogTextStyleConfig");
        r2.E = r15;
        r2.h(ContextCompat.getColor(r10.getContext(), v19.c.b(2130972082, r10.getContext(), 2131103146)));
        CommonDialog.a.f(r2, new m2(r10, r11), r3.getApplication().getString(2131907681), false, 12);
        CommonDialog.a.e(r2, new n2(), r3.getApplication().getString(2131907680), 4);
        B(r2.a(), ((vp8.g) r10).g.getChildFragmentManager());
        return;
    L8:
        r13 = 0;
        goto L9
    L5:
        r1 = 0;
        goto L6
    }
}
