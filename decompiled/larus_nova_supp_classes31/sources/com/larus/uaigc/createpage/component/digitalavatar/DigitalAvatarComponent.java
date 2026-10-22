package com.larus.uaigc.createpage.component.digitalavatar;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.platform.service.z2;
import com.larus.uaigc.api.AIReplicaApi;
import com.larus.uaigc.createpage.v;
import com.larus.uaigc.impl.databinding.LarusLayoutDigitalAvatarCreateBtnBinding;
import com.larus.uaigc.service.ICreationAvatarService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import tx9.r0;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 b2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020<H\u0016J\u0010\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020@H\u0016J \u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u000eH\u0016J\u0012\u0010F\u001a\u00020<2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J4\u0010G\u001a\u00020<2$\u0010H\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010J\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0K\u0012\u0006\u0012\u0004\u0018\u00010L0IH\u0082@¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020<H\u0002J\u0016\u0010O\u001a\u00020<2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020<0QH\u0002J\u0018\u0010R\u001a\u00020<2\u0006\u0010S\u001a\u00020@2\u0006\u0010T\u001a\u00020\u000eH\u0002J\u000e\u0010U\u001a\u00020<H\u0082@¢\u0006\u0002\u0010VJ$\u0010W\u001a\u00020<2\u001a\u0010X\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010:H\u0002J,\u0010Y\u001a\u00020<2\u0006\u0010T\u001a\u00020\u000e2\u001a\u0010X\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010:H\u0002J\u0010\u0010Z\u001a\u00020<2\u0006\u0010T\u001a\u00020\u000eH\u0002J\u0010\u0010[\u001a\u00020<2\u0006\u0010T\u001a\u00020\u000eH\u0002J\b\u0010\\\u001a\u00020<H\u0002J\b\u0010]\u001a\u00020<H\u0002J\b\u0010^\u001a\u00020<H\u0002J\b\u0010_\u001a\u00020<H\u0002J\b\u0010`\u001a\u00020<H\u0002J\b\u0010a\u001a\u00020\bH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0016\u001a\u0004\b%\u0010&R(\u0010(\u001a\u000f\u0012\t\u0012\u00070*¢\u0006\u0002\b+\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0016\u001a\u0004\b,\u0010-R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00109\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/larus/uaigc/createpage/component/digitalavatar/DigitalAvatarComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/uaigc/bean/createpage/component/digitalavatar/IDigitalAvatarAbility;", "<init>", "()V", "_hasAvatar", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "hasAvatar", "Lkotlinx/coroutines/flow/StateFlow;", "getHasAvatar", "()Lkotlinx/coroutines/flow/StateFlow;", "avatarUrl", "", "delayShowGeneratingJob", "Lkotlinx/coroutines/Job;", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "createAvatarBtn", "Lcom/larus/uaigc/impl/databinding/LarusLayoutDigitalAvatarCreateBtnBinding;", "getCreateAvatarBtn", "()Lcom/larus/uaigc/impl/databinding/LarusLayoutDigitalAvatarCreateBtnBinding;", "createAvatarBtn$delegate", "createAvatarMaxUploadImgCnt", "", "instructionEditAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getInstructionEditAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "instructionEditAbility$delegate", "templateFeedAbility", "Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "getTemplateFeedAbility", "()Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "templateFeedAbility$delegate", "generatingToastViewStub", "Lcom/larus/common_ui/view/ViewStubManager;", "Lcom/larus/uaigc/impl/databinding/LarusLayoutAvatarGeneratingToastBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "getGeneratingToastViewStub", "()Lcom/larus/common_ui/view/ViewStubManager;", "generatingToastViewStub$delegate", "morePopupLastDismissTime", "", "morePopup", "Lcom/skydoves/balloon/Balloon;", "replicaCreateId", "pickImagesLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "titleView", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "trainQuotaInfo", "Lkotlin/Triple;", "onAttach", "", "onCreate", "onViewCreated", "view", "Landroid/view/View;", "onDigitalAvatarTemplateChoose", "templateInfo", "Lcom/larus/bmhome/avatar/api/DigitalAvatarTemplate;", "position", "enterFrom", "createDigitalAvatar", "getMainBotConversationInfo", "callback", "Lkotlin/Function2;", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initLauncher", "checkGalleryPermission", "doNext", "Lkotlin/Function0;", "openDigitalAvatarMenu", "hostView", "digitalAvatarId", "tryFetchTrainQuotaInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showQuotaRemindReGenDialog", "replicaTrainQuotaInfo", "showQuotaRemindDeleteDialog", "delDigitalAvatar", "realDeleteDigitalAvatar", "initWhiteTUrl", "initTitle", "initInputWidget", "initCreateAvatarBtn", "regenerateVideoAvatar", "shouldPropagateAICreationHostSource", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DigitalAvatarComponent extends BaseContentWidget implements oy9.a {
    public static final /* synthetic */ int C = 0;
    public NovaTitleBarEx A;
    public Triple<Integer, Integer, Integer> B;
    public final StateFlowImpl m;
    public final b1 n;
    public final StateFlowImpl o;
    public Job p;
    public final Lazy q;
    public final Lazy r;
    public final int s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public long w;
    public Balloon x;
    public String y;
    public ActivityResultLauncher<Intent> z;

    public static final class a {
    }

    static {
    }

    public final ny9.s B3() {
        return (ny9.s) this.q.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, oy9.a.class);
    }

    public DigitalAvatarComponent() {
        StateFlowImpl r0 = j1.a(Boolean.FALSE);
        this.m = r0;
        this.n = kotlinx.coroutines.flow.e.b(r0);
        DigitalAvatarInfoManager.a.getClass();
        this.o = DigitalAvatarInfoManager.b;
        this.q = LazyKt.lazy(new com.larus.uaigc.createpage.component.digitalavatar.a(this));
        this.r = LazyKt.lazy(new e(this));
        LaunchInfo r1 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r1 != null) goto L5;
    L8:
        int r2 = 10;
    L9:
        this.s = r2;
        this.t = LazyKt.lazy(new f(this));
        this.u = LazyKt.lazy(new g(this));
        this.v = LazyKt.lazy(new h(this));
        return;
    L5:
        if (r1.K() <= 0) goto L8;
        r2 = r1.K();
        goto L9
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        ny9.s r0 = B3();
        if (r0 == null) goto L5;
        z0 r1 = r0.f();
    L6:
        StateFlowImpl r2 = this.m;
        boolean r3 = false;
        if (r1 == null) goto L14;
        Integer r4 = r1.g;
        int r5 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        if (r4 == null) goto L14;
        if (r4.intValue() != r5) goto L14;
        boolean r6 = true;
    L15:
        r2.setValue(Boolean.valueOf(!r6));
        if (((Boolean) this.m.getValue()).booleanValue() == true) goto L27;
        ny9.s r7 = B3();
        if (r7 != null) goto L20;
    L22:
        if (r3 == false) goto L28;
        z3(null);
        v r8 = (v) s1a.d.a(this).getAbility(v.class);
        if (r8 == null) goto L29;
        r8.kB(true);
        return;
    L29:
        return;
    L28:
        return;
    L20:
        if (r7.D() != true) goto L22;
        r3 = true;
        goto L22
    L27:
        return;
    L14:
        r6 = false;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    @Override // oy9.a
    public final b1 Hc() {
        return this.n;
    }

    public final void onViewCreated(View r11) {
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.z = com.larus.ui.arch.component.internal.attach.a.b(this, this).registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new k(this));
        final NovaTitleBarEx r12 = F2().findViewById(2131388772);
        this.A = r12;
        ny9.s r0 = B3();
        if (r0 == null) goto L5;
        String r1 = r0.w();
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        NovaTitleBarEx.Y5(r12, r1, null, null, 6);
        e1.d(r12.getBinding().f, new j(this, r12));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DigitalAvatarComponent$initWhiteTUrl$1(this, null), 3, null);
        ConstraintLayout r13 = F2();
        if ((r13 instanceof ConstraintLayout) == false) goto L11;
        ConstraintLayout r14 = r13;
    L13:
        if (r14 == null) goto L19;
        r14.addView(((LarusLayoutDigitalAvatarCreateBtnBinding) this.r.getValue()).a);
        ConstraintSet r3 = new ConstraintSet();
        r3.clone(r14);
        r3.connect(2131363656, 4, 2131384813, 4);
        r3.connect(2131363656, 6, 2131384813, 6);
        r3.connect(2131363656, 7, 2131384813, 7);
        r3.applyTo(r14);
        RoundConstraintLayout r15 = ((LarusLayoutDigitalAvatarCreateBtnBinding) this.r.getValue()).a;
        ViewGroup.LayoutParams r2 = r15.getLayoutParams();
        if (r2 == null) goto L18;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r2;
        r4.bottomMargin = c7.b(12);
        r15.setLayoutParams(r4);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DigitalAvatarComponent$initCreateAvatarBtn$2(this, null), 3, null);
        e1.d(((LarusLayoutDigitalAvatarCreateBtnBinding) this.r.getValue()).a, new i(this));
        if (((Boolean) this.n.getValue()).booleanValue() == true) goto L43;
        sq9.u r16 = ICreationAvatarService.a.d();
        if (r16 != null) goto L24;
    L26:
        boolean r17 = false;
    L27:
        if (r17 == false) goto L43;
        ny9.s r18 = B3();
        if (r18 == null) goto L37;
        z0 r19 = r18.f();
        if (r19 == null) goto L37;
        com.larus.bmhome.actionbar.model.r r110 = r19.q;
        if (r110 == null) goto L37;
        com.larus.bmhome.actionbar.model.j1 r111 = r110.e;
        if (r111 == null) goto L37;
        String r112 = r111.h;
    L39:
        if (Intrinsics.areEqual(r112, "1") == false) goto L43;
        if (z2.a.l1() == true) goto L43;
        z3(null);
    L37:
        r112 = null;
        goto L39
    L24:
        if (r16.a() == true) goto L26;
        r17 = true;
    L43:
        View r113 = F2().findViewById(2131365537);
        if (r113 == null) goto L47;
        r113.setBackground(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ContextCompat.getColor(getContext(), v19.c.b(2130970529, getContext(), 2131102529)), ContextCompat.getColor(getContext(), v19.c.b(2130970529, getContext(), 2131102529)), ContextCompat.getColor(getContext(), 2131106535), ContextCompat.getColor(getContext(), 2131106535)}));
        return;
    L47:
        return;
    L11:
        r14 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void z3(ab8.a r7) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DigitalAvatarComponent$createDigitalAvatar$1(this, r7, null), 3, null);
    }

    public static void Y2(CommonDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, null);
    }

    public static final void m3(DigitalAvatarComponent r8, String r9) {
        r8.getClass();
        r0.f("replica", "confirm_delete_replica");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r8), null, null, new DigitalAvatarComponent$realDeleteDigitalAvatar$1(r8, r9, null), 3, null);
    }

    public static final Object p3(DigitalAvatarComponent r5, Continuation r6) {
        r5.getClass();
        if ((r6 instanceof DigitalAvatarComponent$tryFetchTrainQuotaInfo$1) == false) goto L7;
        DigitalAvatarComponent$tryFetchTrainQuotaInfo$1 r0 = (DigitalAvatarComponent$tryFetchTrainQuotaInfo$1) r6;
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
        FLogger.a.i("DigitalAvatarComponent", "fetch train quota success");
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
        r5.B = r17;
        return Unit.INSTANCE;
    L22:
        r12 = 0;
        goto L23
    L31:
        if ((r8 instanceof dm9.a.a) == false) goto L36;
        FLogger.a.i("DigitalAvatarComponent", "fetch train quota fail: " + ((dm9.a.a) r8).c);
        r17 = new Triple(Boxing.boxInt(0), Boxing.boxInt(0), Boxing.boxInt(0));
        goto L33
    L36:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        AIReplicaApi.Companion r18 = AIReplicaApi.a;
        DigitalAvatarComponent$tryFetchTrainQuotaInfo$result$1 r19 = new DigitalAvatarComponent$tryFetchTrainQuotaInfo$result$1(null);
        r0.label = 1;
        r18.getClass();
        r7 = AIReplicaApi.Companion.b(r19, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new DigitalAvatarComponent$tryFetchTrainQuotaInfo$1(r5, r6);
        goto L8
    }

    public static final Object h3(DigitalAvatarComponent r5, Function2 r6, Continuation r7) {
        r5.getClass();
        if ((r7 instanceof DigitalAvatarComponent$getMainBotConversationInfo$1) == false) goto L7;
        DigitalAvatarComponent$getMainBotConversationInfo$1 r0 = (DigitalAvatarComponent$getMainBotConversationInfo$1) r7;
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
        DigitalAvatarComponent$getMainBotConversationInfo$cvs$2 r3 = new DigitalAvatarComponent$getMainBotConversationInfo$cvs$2(null);
        r0.L$0 = r6;
        r0.label = 1;
        r8 = kotlinx.coroutines.flow.e.t(r12, r3, r0);
        if (r8 != r9) goto L24;
        return r9;
    L7:
        r0 = new DigitalAvatarComponent$getMainBotConversationInfo$1(r5, r7);
        goto L8
    }

    @Override // oy9.a
    public final void onDigitalAvatarTemplateChoose(ab8.a r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "templateInfo");
        Intrinsics.checkNotNullParameter("template_list", "enterFrom");
        if (((Boolean) this.n.getValue()).booleanValue() == false) goto L7;
        ys8.a r5 = (ys8.a) this.t.getValue();
        if (r5 == null) goto L9;
        r5.onDigitalAvatarTemplateChoose(r2, r3, "template_list");
        return;
    L9:
        return;
    L7:
        z3(r2);
    }
}
