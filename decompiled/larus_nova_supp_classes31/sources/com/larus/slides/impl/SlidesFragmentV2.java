package com.larus.slides.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.OfficeBaseFragment;
import com.larus.office.permission.DocPermissionFullData;
import com.larus.slides.biz.impl.databinding.LarusLayoutSlidesDetailFragmentBinding;
import com.larus.slides.impl.view.SlidesLoadLayout;
import com.larus.slides.sdk.api.ISlidesSdkServiceV2;
import com.larus.slides.sdk.api.orientation.OrientationMode;
import com.larus.slides.sdk.api.orientation.OrientationOption;
import com.larus.slides.sdk.api.orientation.SetOrientationModel;
import com.larus.slides.sdk.api.orientation.SlidesClickFrom;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u001a\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$H\u0014J\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0006H\u0016J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010,\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010.\u001a\u00020\u0006H\u0016J\b\u0010/\u001a\u00020\u0006H\u0016J\u0018\u00100\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u00101J:\u00102\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u00010(2\b\u00104\u001a\u0004\u0018\u00010(2\b\u00105\u001a\u0004\u0018\u00010(2\b\u00106\u001a\u0004\u0018\u00010(2\b\u00107\u001a\u0004\u0018\u00010(H\u0014J\u0016\u00108\u001a\u00020\r2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\r0:H\u0016J\n\u0010;\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010<\u001a\u00020$H\u0014J\b\u0010=\u001a\u00020>H\u0016J\n\u0010?\u001a\u0004\u0018\u00010\u0012H\u0016R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/larus/slides/impl/SlidesFragmentV2;", "Lcom/larus/slides/impl/SlidesFragment;", "Lcom/larus/office/base/component/permission/NoPermissionPageHost;", "<init>", "()V", "lastAppBarHeight", "", "Ljava/lang/Integer;", "permissionAbility", "Lcom/larus/office/base/component/permission/IOfficePermissionChangeAbility;", "officeInputParam", "Lcom/larus/office/OfficeInputParam;", "attachComponent", "", "initPermissionAbility", "initChameleonFragment", "Landroidx/fragment/app/Fragment;", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "adapterSourceTitleBarContainerBeforeInjectToOfficeSDKLayout", "onObtainTitleBar", "Landroid/view/ViewGroup;", "onReadyInitTitleBar", "titleBar", "lastTitleBarBehavior", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "setOrientationMode", "orientationModel", "Lcom/larus/slides/sdk/api/orientation/SetOrientationModel;", "adapterTitleBarOnOrientationMode", "isLandscape", "", "toggleTitleBar", "states", "getToken", "", "getSupportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getOfficeContainerFragment", "setOfficeContainerFragment", "fragment", "getNoPermissionContainerId", "getOfficeContainerId", "createOfficeFragment", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onArtifactInfoUpdated", "artifactMetaId", "artifactVersionId", "conversationId", "messageId", "botId", "runWhenAdded", "action", "Lkotlin/Function0;", "getPermissionAbility", "canEdit", "getNoPermissionBundleData", "Lcom/larus/office/base/component/permission/NoPermissionBundleData;", "getHostContext", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesFragmentV2 extends SlidesFragment implements com.larus.office.base.component.permission.c {
    public static final /* synthetic */ int S = 0;
    public Integer P;
    public com.larus.office.base.component.permission.a Q;
    public OfficeInputParam R;

    public static final class a {
    }

    static {
    }

    public final int C3() {
        return 2131369315;
    }

    public final int J7() {
        return 2131386903;
    }

    @Override // ax9.e
    public final void d4(int r1) {
    }

    public final com.larus.office.base.component.permission.b X2() {
        com.larus.office.base.component.permission.a r0 = this.Q;
        if (r0 != null) goto L5;
        r0 = (com.larus.office.base.component.permission.a) s1a.a.g(this).getAbility(com.larus.office.base.component.permission.a.class);
    L5:
        ArrayList r1 = null;
        if (r0 == null) goto L13;
        DocPermissionFullData r2 = r0.C4();
        if (r2 == null) goto L13;
        fo9.f r3 = r2.getOwner();
        if (r3 == null) goto L13;
        String r4 = r3.a;
        if (r4 == null) goto L13;
    L30:
        String r6 = r4;
        String r5 = this.j;
        Bundle r7 = getArguments();
        if (r7 == null) goto L33;
        String r9 = r7.getString("enter_method");
    L34:
        Bundle r8 = getArguments();
        if (r8 == null) goto L37;
        String r10 = r8.getString("key_apply_permission_message_id");
    L38:
        Bundle r11 = getArguments();
        if (r11 == null) goto L41;
        String r12 = r11.getString("key_apply_permission_conversation_id");
    L42:
        Bundle r13 = getArguments();
        if (r13 == null) goto L46;
        r1 = com.larus.office.base.preview.a.a(r13, "key_doc_list_to_apply_permission");
    L46:
        return new com.larus.office.base.component.permission.b(r5, null, r6, 30, r9, r10, r12, r1);
    L41:
        r12 = null;
        goto L42
    L37:
        r10 = null;
        goto L38
    L33:
        r9 = null;
    L13:
        if (r0 == null) goto L19;
        DocPermissionFullData r14 = r0.C4();
        if (r14 == null) goto L19;
        fo9.f r15 = r14.getOwner();
        if (r15 == null) goto L19;
        r4 = r15.b;
    L20:
        if (r4 != null) goto L30;
        if (r0 == null) goto L27;
        DocPermissionFullData r16 = r0.C4();
        if (r16 == null) goto L27;
        fo9.f r17 = r16.getOwner();
        if (r17 == null) goto L27;
        r4 = r17.c;
    L28:
        if (r4 != null) goto L30;
        r4 = "";
    L27:
        r4 = null;
    L19:
        r4 = null;
        goto L20
    }

    @Override // com.larus.slides.impl.SlidesFragment
    public final boolean canEdit() {
        com.larus.office.base.component.permission.a r0 = this.Q;
        if (r0 != null) goto L5;
        r0 = (com.larus.office.base.component.permission.a) s1a.a.g(this).getAbility(com.larus.office.base.component.permission.a.class);
    L5:
        if (r0 != null) goto L9;
        return true;
    L9:
        return r0.canEdit();
    }

    @Override // com.larus.slides.impl.SlidesFragment
    public final ViewGroup ta0() {
        ViewBinding r0 = ((OfficeBaseFragment) this).e;
        LarusLayoutSlidesDetailFragmentBinding r1 = (LarusLayoutSlidesDetailFragmentBinding) r0;
        if (r1 == null) goto L20;
        SlidesLoadLayout r2 = r1.g;
        if (r2 == null) goto L20;
        LarusLayoutSlidesDetailFragmentBinding r3 = (LarusLayoutSlidesDetailFragmentBinding) r0;
        if (r3 == null) goto L11;
        SlidesLoadLayout r4 = r3.g;
        if (r4 == null) goto L11;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
    L13:
        if ((r5 instanceof ConstraintLayout.LayoutParams) == false) goto L15;
        ConstraintLayout.LayoutParams r6 = (ConstraintLayout.LayoutParams) r5;
    L16:
        if (r6 == null) goto L18;
        ((ViewGroup.MarginLayoutParams) r6).topMargin = i5.k0();
    L19:
        r2.setLayoutParams(r6);
        goto L20
    L18:
        r6 = null;
        goto L19
    L15:
        r6 = null;
    L11:
        r5 = null;
    L20:
        LarusLayoutSlidesDetailFragmentBinding r7 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r7 == null) goto L26;
        ConstraintLayout r8 = r7.a;
        if (r8 != null) goto L25;
        return null;
    L25:
        return (ViewGroup) r8.findViewById(2131386911);
    L26:
        return null;
    }

    @Override // com.larus.slides.impl.SlidesFragment
    public final void ua0() {
        ma0(this.E);
    }

    public final Context getHostContext() {
        return getContext();
    }

    public final FragmentManager y1() {
        return getChildFragmentManager();
    }

    public SlidesFragmentV2() {
    }

    public final Fragment d5() {
        return this.I;
    }

    public final String getToken() {
        return this.j;
    }

    @Override // com.larus.slides.impl.SlidesFragment, ax9.e
    public final void K60(SetOrientationModel r7) {
        super.K60(r7);
        if (r7 == null) goto L6;
        String r0 = r7.getOrientation();
        if (r0 == null) goto L6;
    L7:
        OrientationMode r1 = OrientationMode.LANDSCAPE;
        if (Intrinsics.areEqual(r0, r1.getMode()) == false) goto L12;
        vm9.d r2 = com.larus.office.base.service.m.b();
        if (r2 == null) goto L15;
        r2.onCustomHeaderPaddingChanged(i5.d0(), i5.d0());
    L15:
        Integer r3 = null;
        if (r7 == null) goto L20;
        OrientationOption r4 = r7.getOption();
        if (r4 == null) goto L20;
        String r5 = r4.getClickFrom();
    L22:
        if (Intrinsics.areEqual(r5, SlidesClickFrom.PRESENTATION.getClickFrom()) == false) goto L58;
        LarusLayoutSlidesDetailFragmentBinding r6 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r6 == null) goto L28;
        ConstraintLayout r8 = r6.a;
        if (r8 == null) goto L28;
        AppBarLayout r9 = r8.findViewById(2131369266);
    L29:
        if (r9 == null) goto L31;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
    L33:
        if ((r10 instanceof CoordinatorLayout.LayoutParams) == false) goto L35;
        CoordinatorLayout.LayoutParams r11 = (CoordinatorLayout.LayoutParams) r10;
    L37:
        if (Intrinsics.areEqual(r7.getSrcOrientation(), r1.getMode()) == true) goto L48;
        if (r11 == null) goto L44;
        Integer r12 = this.P;
        if (r12 == null) goto L42;
        int r13 = r12.intValue();
    L43:
        ((ViewGroup.MarginLayoutParams) r11).height = r13;
        goto L44
    L42:
        r13 = -2;
    L44:
        if (r9 == null) goto L46;
        r9.setLayoutParams(r11);
    L46:
        ma0(this.E);
        FLogger.a.d("SlidesFragmentV2", "setOrientationMode adapter to enable nested scroll");
        return;
    L48:
        if (this.P != null) goto L52;
        if (r11 == null) goto L51;
        r3 = Integer.valueOf(((ViewGroup.MarginLayoutParams) r11).height);
    L51:
        this.P = r3;
    L52:
        if (r11 == null) goto L54;
        ((ViewGroup.MarginLayoutParams) r11).height = 0;
    L54:
        if (r9 == null) goto L56;
        r9.setLayoutParams(r11);
    L56:
        FLogger.a.d("SlidesFragmentV2", "setOrientationMode disable nested scroll");
        return;
    L35:
        r11 = null;
        goto L37
    L31:
        r10 = null;
    L28:
        r9 = null;
        goto L29
    L58:
        return;
    L20:
        r5 = null;
        goto L22
    L12:
        vm9.d r14 = com.larus.office.base.service.m.b();
        if (r14 == null) goto L15;
        r14.onCustomHeaderPaddingChanged(0, 0);
    L6:
        r0 = OrientationMode.PORTRAIT.getMode();
        goto L7
    }

    public final Fragment aa0(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        FLogger.a.i("SlidesFragmentV2", "Init SlidesFragmentV2");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SlidesFragmentV2$initChameleonFragment$1(r8, this, r0, null), 3, null);
        return (Fragment) r0.element;
    }

    public final void d7(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (isAdded() == false) goto L6;
        r2.invoke();
        return;
    }

    @Override // com.larus.slides.impl.SlidesFragment
    public final void ma0(boolean r2) {
        if (r2 == false) goto L6;
        vm9.d r3 = com.larus.office.base.service.m.b();
        if (r3 == null) goto L10;
        r3.changeNavigationNestedScrollState(true);
        return;
    L10:
        return;
    L6:
        vm9.d r4 = com.larus.office.base.service.m.b();
        if (r4 == null) goto L12;
        r4.changeNavigationNestedScrollState(false);
        return;
    }

    public final void x5(Fragment r1) {
        this.I = r1;
    }

    public final Object V3(Context r7, Continuation<? super Fragment> r8) {
        OfficeInputParam r1 = new OfficeInputParam();
        Bundle r9 = getArguments();
        String r0 = "";
        if (r9 == null) goto L6;
        String r10 = r9.getString("resource_id");
        if (r10 == null) goto L6;
    L7:
        r1.setResourceId(r10);
        Bundle r11 = getArguments();
        if (r11 == null) goto L11;
        String r12 = r11.getString("slides_token");
        if (r12 == null) goto L11;
    L12:
        r1.setSlidesToken(r12);
        r1.setResourceType(9);
        Bundle r13 = getArguments();
        int r2 = -1;
        if (r13 == null) goto L15;
        r2 = r13.getInt("resource_version", -1);
    L15:
        r1.setResourceVersion(r2);
        Bundle r14 = getArguments();
        if (r14 == null) goto L19;
        String r15 = r14.getString("conversation_id");
        if (r15 == null) goto L19;
    L20:
        r1.setConversationId(r15);
        Bundle r16 = getArguments();
        if (r16 == null) goto L24;
        String r17 = r16.getString("artifact_meta_id");
        if (r17 == null) goto L24;
    L25:
        r1.setArtifactMetaId(r17);
        Bundle r18 = getArguments();
        if (r18 == null) goto L29;
        String r19 = r18.getString("artifact_version_id");
        if (r19 == null) goto L29;
    L30:
        r1.setArtifactVersionId(r19);
        Bundle r20 = getArguments();
        if (r20 == null) goto L34;
        String r21 = r20.getString("enter_method");
        if (r21 == null) goto L34;
    L35:
        r1.setEnterMethod(r21);
        Bundle r22 = getArguments();
        if (r22 == null) goto L38;
        String r23 = r22.getString("doc_title");
    L39:
        r1.setDocTitle(r23);
        Bundle r24 = getArguments();
        if (r24 == null) goto L42;
        long r3 = r24.getLong("click_timestamp");
    L43:
        r1.setClickTimestamp(r3);
        r1.setBeginLoadTimestamp(System.currentTimeMillis());
        Bundle r25 = getArguments();
        boolean r4 = false;
        if (r25 == null) goto L46;
        boolean r26 = r25.getBoolean("has_report_finish_event");
    L47:
        r1.setHasReportFinishEvent(r26);
        Bundle r27 = getArguments();
        if (r27 != null) goto L50;
    L52:
        boolean r28 = false;
    L53:
        r1.setColdStart(r28);
        r1.setObjType(Boxing.boxInt(30));
        Bundle r29 = getArguments();
        if (r29 == null) goto L57;
        String r30 = r29.getString("is_general_agent");
        if (r30 == null) goto L57;
    L58:
        r1.setGeneralAgent(r30);
        Bundle r31 = getArguments();
        if (r31 == null) goto L64;
        String r32 = r31.getString("chat_id");
        if (r32 == null) goto L64;
        r0 = r32;
    L64:
        r1.setAgentChatId(r0);
        Bundle r33 = getArguments();
        if (r33 == null) goto L67;
        String r34 = r33.getString("message_id");
    L68:
        r1.setMessageId(r34);
        Bundle r35 = getArguments();
        if (r35 == null) goto L71;
        String r36 = r35.getString("bot_id");
    L72:
        r1.setBotId(r36);
        Bundle r37 = getArguments();
        if (r37 == null) goto L75;
        String r38 = r37.getString("aippt_task_id");
    L76:
        r1.setAiPPTTaskId(r38);
        Bundle r39 = getArguments();
        if (r39 != null) goto L79;
    L81:
        boolean r40 = false;
    L82:
        r1.setDocPreloaded(r40);
        Bundle r41 = getArguments();
        if (r41 == null) goto L85;
        String r42 = r41.getString("key_source_url_for_params");
    L86:
        r1.setSourceUrlForParams(r42);
        Bundle r43 = getArguments();
        if (r43 != null) goto L89;
    L91:
        r1.setOpenChatWithNewLocalConv(r4);
        this.R = r1;
        ISlidesSdkServiceV2 r5 = (ISlidesSdkServiceV2) ServiceManager.get().getService(ISlidesSdkServiceV2.class);
        if (r5 == null) goto L98;
        Object r44 = r5.s(r1, this.Q, null, null, r8);
        if (r44 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L97;
        return r44;
    L97:
        return (Fragment) r44;
    L98:
        return null;
    L89:
        if (r43.getBoolean("open_chat_with_new_local_conv", false) != true) goto L91;
        r4 = true;
        goto L91
    L85:
        r42 = null;
        goto L86
    L79:
        if (r39.getBoolean("key_office_preloaded", false) != true) goto L81;
        r40 = true;
        goto L82
    L75:
        r38 = null;
        goto L76
    L71:
        r36 = null;
        goto L72
    L67:
        r34 = null;
    L57:
        r30 = "";
        goto L58
    L50:
        if (r27.getBoolean("is_cold_start") != true) goto L52;
        r28 = true;
        goto L53
    L46:
        r26 = false;
        goto L47
    L42:
        r3 = System.currentTimeMillis();
        goto L43
    L38:
        r23 = null;
    L34:
        r21 = "";
    L29:
        r19 = "";
    L24:
        r17 = "";
    L19:
        r15 = "";
    L11:
        r12 = "";
    L6:
        r10 = "";
        goto L7
    }

    @Override // com.larus.slides.impl.SlidesFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        LarusLayoutSlidesDetailFragmentBinding r4 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        ConstraintLayout.LayoutParams r5 = null;
        if (r4 == null) goto L7;
        FrameLayout r6 = r4.l;
        if (r6 == null) goto L7;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
    L9:
        if ((r7 instanceof ConstraintLayout.LayoutParams) == false) goto L11;
        r5 = (ConstraintLayout.LayoutParams) r7;
    L11:
        if (r5 == null) goto L13;
        ((ViewGroup.MarginLayoutParams) r5).height = 0;
    L13:
        if (r5 == null) goto L15;
        r5.matchConstraintDefaultHeight = 2;
    L15:
        if (r5 == null) goto L17;
        r5.matchConstraintPercentHeight = 0.0f;
    L17:
        LarusLayoutSlidesDetailFragmentBinding r8 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r8 == null) goto L22;
        FrameLayout r9 = r8.l;
        if (r9 == null) goto L22;
        r9.setLayoutParams(r5);
    L22:
        LarusLayoutSlidesDetailFragmentBinding r10 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r10 == null) goto L28;
        FrameLayout r11 = r10.l;
        if (r11 == null) goto L29;
        r11.requestLayout();
        return;
    L29:
        return;
    L28:
        return;
    L7:
        r7 = null;
        goto L9
    }

    @Override // com.larus.slides.impl.SlidesFragment
    public final void sa0(String r2, String r3, String r4, String r5, String r6) {
        if (r2 == null) goto L6;
        OfficeInputParam r0 = this.R;
        if (r0 == null) goto L6;
        r0.setArtifactMetaId(r2);
    L6:
        if (r3 == null) goto L10;
        OfficeInputParam r7 = this.R;
        if (r7 == null) goto L10;
        r7.setArtifactVersionId(r3);
    L10:
        if (r4 == null) goto L14;
        OfficeInputParam r8 = this.R;
        if (r8 == null) goto L14;
        r8.setConversationId(r4);
    L14:
        if (r5 == null) goto L18;
        OfficeInputParam r9 = this.R;
        if (r9 == null) goto L18;
        r9.setMessageId(r5);
    L18:
        if (r6 == null) goto L23;
        OfficeInputParam r10 = this.R;
        if (r10 == null) goto L24;
        r10.setBotId(r6);
        return;
    L24:
        return;
    }
}
