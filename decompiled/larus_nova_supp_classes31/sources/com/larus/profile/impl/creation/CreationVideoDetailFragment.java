package com.larus.profile.impl.creation;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.databinding.LarusCreationVideoDetailFragmentLayoutBinding;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.video.fragment.BaseVideoDetailFragment;
import com.larus.bmhome.video.save_share.VideoGenerateShareHelper;
import com.larus.bmhome.video.view.CreationVideoDetailPlayControlView;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.fragment.CommonSlideFragment;
import com.larus.common_ui.fragment.helper.EditPanelType;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.widget.CommonAuthorInfoLayout;
import com.larus.community.api.ICommunityService;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.TplTagType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import v19.l5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001sBc\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016B\t\b\u0016¢\u0006\u0004\b\u0015\u0010\u0017J\b\u0010,\u001a\u00020'H\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\rH\u0016J\b\u00100\u001a\u00020\tH\u0016J$\u00101\u001a\f02R\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\rH\u0016J\u001a\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0006\u0010?\u001a\u00020\rJ\b\u0010@\u001a\u00020'H\u0016J\u0012\u0010A\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010B\u001a\u00020\rH\u0016J\u0010\u0010C\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010D\u001a\u0004\u0018\u00010<2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010Y\u001a\u00020<H\u0002J\b\u0010Z\u001a\u00020\rH\u0016J\b\u0010[\u001a\u00020\rH\u0002J\b\u0010\\\u001a\u00020\rH\u0002J\b\u0010]\u001a\u00020\u0005H\u0002J\b\u0010^\u001a\u00020\rH\u0002J\b\u0010_\u001a\u00020\rH\u0002J\u0010\u0010`\u001a\u00020\r2\u0006\u0010a\u001a\u00020\u0005H\u0002J\b\u0010b\u001a\u00020\rH\u0002J\b\u0010c\u001a\u00020\rH\u0016J*\u0010d\u001a\u00020\r2\b\u0010e\u001a\u0004\u0018\u00010\t2\u0006\u0010f\u001a\u00020\t2\u0006\u0010g\u001a\u00020\t2\u0006\u0010h\u001a\u00020iH\u0002J(\u0010j\u001a\u00020\r2\u0006\u0010k\u001a\u00020l2\u0006\u0010f\u001a\u00020\t2\u0006\u0010g\u001a\u00020\t2\u0006\u0010h\u001a\u00020iH\u0002J\b\u0010m\u001a\u00020\rH\u0016J\b\u0010n\u001a\u00020\rH\u0016J\u0010\u0010o\u001a\u00020\r2\u0006\u0010p\u001a\u00020\u0005H\u0016J\n\u0010q\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010r\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010S\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010+\u001a\u0004\bT\u0010UR\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Lcom/larus/profile/impl/creation/CreationVideoDetailFragment;", "Lcom/larus/bmhome/video/fragment/BaseVideoDetailFragment;", "Lcom/larus/bmhome/databinding/LarusCreationVideoDetailFragmentLayoutBinding;", "Lcom/larus/platform/api/creation/ICreationListener;", "type", "", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "visitId", "", "creationMode", "callback", "Lkotlin/Function0;", "", "creationPagerInitParams", "Lcom/larus/profile/api/model/CreationPagerInitParams;", "position", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "eventParam", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "<init>", "(ILcom/larus/platform/api/creation/UserCreation;Ljava/lang/String;ILkotlin/jvm/functions/Function0;Lcom/larus/profile/api/model/CreationPagerInitParams;ILcom/larus/platform/model/video/VideoPlayData;Lcom/larus/bmhome/utils/VideoDetailEventParams;)V", "()V", "getType", "()I", "getVisitId", "()Ljava/lang/String;", "getCreationMode", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "getCreationPagerInitParams", "()Lcom/larus/profile/api/model/CreationPagerInitParams;", "setCreationPagerInitParams", "(Lcom/larus/profile/api/model/CreationPagerInitParams;)V", "getPosition", "hasExtendVideoAbility", "", "getHasExtendVideoAbility", "()Z", "hasExtendVideoAbility$delegate", "Lkotlin/Lazy;", "showEditPanel", "editPanelType", "Lcom/larus/common_ui/fragment/helper/EditPanelType;", "dismissFragment", "tag", "initViews", "Lcom/larus/bmhome/video/fragment/BaseVideoDetailFragment$InitViewsResult;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "onShareClick", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "isVideoMute", "onCreate", "onDestroy", "onPublishSuccess", "onCreateView", "downloadView", "Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "countTextView", "Landroid/widget/TextView;", "desTextVew", "authorTextVew", "creationOperatorContainer", "Lcom/larus/bmhome/view/CreationOperateContainerView;", "creationTemplateComponent", "Lcom/larus/profile/impl/creation/CreationTemplateComponent;", "publishContainer", "privateButtonContainer", "bottomToolsContainer", "titleBar", "moreMenu", "getMoreMenu", "()Landroid/view/View;", "moreMenu$delegate", "creationOperatorComponent", "Lcom/larus/profile/impl/creation/CreationOperatorComponent;", "buildMoreMenu", "onScroll", "dismissExtraView", "showExtraView", "getInitCreationButtonStatus", "downloadCreation", "initButtonClickListener", "updateButtonStatus", TplTagType.STYLE, "setPrivateButtonBackground", "onMoreClick", "updateInfo", "uid", "des", "authorName", "count", "", "updateInfoByConfig", "bottomInfoConfig", "Lcom/larus/profile/api/model/BottomInfoConfig;", "onUserDragStarted", "onUserDragStopped", "onDoCreationAction", "action", "currentDisplayVideoPlayData", "onSelected", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationVideoDetailFragment extends BaseVideoDetailFragment<LarusCreationVideoDetailFragmentLayoutBinding> implements zp9.r {
    public static final /* synthetic */ int Q = 0;
    public final int A;
    public final Function0<Unit> B;
    public final gs9.d C;
    public final Lazy D;
    public CommonDownLoadLayout E;
    public TextView F;
    public TextView G;
    public TextView H;
    public CreationOperateContainerView I;
    public u1 J;
    public ViewGroup K;
    public ViewGroup L;
    public ViewGroup M;
    public ConstraintLayout N;
    public final Lazy O;
    public CreationOperatorComponent P;
    public final int x;
    public final UserCreation y;
    public final String z;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ ConstraintLayout a;

        public b(ConstraintLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setAlpha(0.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setAlpha(0.0f);
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ ConstraintLayout a;

        public c(ConstraintLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setAlpha(1.0f);
        }
    }

    static {
    }

    public final boolean Z90() {
        return false;
    }

    public CreationVideoDetailFragment() {
        this(new UserCreation(null, 0, null, null, 131071), "", 0, null, null, null, new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383));
        U90();     // Catch: IllegalStateException -> L5
        return;
    L5:
        FLogger.a.e("CreationVideoDetailFragment", "fallback by dismiss failed");
    }

    public final void VT() {
        LarusCreationVideoDetailFragmentLayoutBinding r0 = ((BaseVideoDetailFragment) this).p;
        if (r0 == null) goto L7;
        ConstraintLayout r1 = r0.a;
        if (r1 == null) goto L7;
        ViewExtKt.d(r1);
    L7:
        CreationGroupFragment r2 = getParentFragment();
        if ((r2 instanceof CreationGroupFragment) == false) goto L10;
        CreationGroupFragment r3 = r2;
    L11:
        if (r3 == null) goto L14;
        r3.ca0();
        return;
    L14:
        return;
    L10:
        r3 = null;
        goto L11
    }

    public final void aa0() {
        LarusCreationVideoDetailFragmentLayoutBinding r0 = ((BaseVideoDetailFragment) this).p;
        if (r0 == null) goto L8;
        ConstraintLayout r1 = r0.c;
        if (r1 == null) goto L9;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r1, "alpha", new float[]{1.0f, 0.0f});
        r2.setInterpolator(new l5());
        r2.setDuration(200);
        r2.addListener(new b(r1));
        r2.start();
        return;
    L9:
        return;
    }

    public final void ba0() {
        LarusCreationVideoDetailFragmentLayoutBinding r0 = ((BaseVideoDetailFragment) this).p;
        if (r0 == null) goto L8;
        ConstraintLayout r1 = r0.c;
        if (r1 == null) goto L9;
        r1.setAlpha(0.0f);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r1, "alpha", new float[]{0.0f, 1.0f});
        r2.setInterpolator(new l5());
        r2.setDuration(200);
        r2.setStartDelay(100);
        r2.addListener(new c(r1));
        r2.start();
        return;
    L9:
        return;
    }

    public final void d70() {
        LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(this);
        c4 r1 = ((BaseVideoDetailFragment) this).f;
        wc9.e r5 = r1.e;
        BotModel r6 = r1.d;
        String r7 = r1.c;
        ChatControlTrace r2 = ChatControlTrace.b;
        r2.getClass();
        String r9 = r2.h(ChatControlTrace.y);
        String r10 = ((BaseVideoDetailFragment) this).f.a;
        UserCreation r4 = this.y;
        CreationDynamicInfo r8 = r4.h;
        String r79 = "";
        if (r8 == null) goto L8;
        String r11 = r8.d;
        if (r11 == null) goto L8;
        String r12 = r11;
    L9:
        com.larus.bmhome.share.panel.h r80 = new com.larus.bmhome.share.panel.h(r5, r6, r7, "video_detail", r9, r10, r12, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r4.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -252, -4097, 1023);
        IFlowSdkDepend r13 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r13 == null) goto L18;
        r13.D0();
        com.larus.home.impl.sdk.b1 r14 = com.larus.home.impl.sdk.b1.a;
        r14.c("profile_private_share_save");
        nr9.g r15 = ea0();
        if (r15 == null) goto L14;
        String r16 = r15.c;
    L15:
        if (r16 != null) goto L17;
        r16 = "";
    L17:
        r14.d(r16);
        goto L18
    L14:
        r16 = null;
    L18:
        VideoGenerateShareHelper r17 = VideoGenerateShareHelper.a;
        LarusCreationVideoDetailFragmentLayoutBinding r18 = ((BaseVideoDetailFragment) this).p;
        if (r18 == null) goto L31;
        ConstraintLayout r19 = r18.a;
        if (r19 == null) goto L32;
        com.larus.common_ui.dialog.l0 r20 = (com.larus.common_ui.dialog.l0) ((BaseVideoDetailFragment) this).o.getValue();
        nr9.g r21 = ea0();
        UserCreation r22 = this.y;
        CreationDynamicInfo r23 = r22.h;
        if (r23 == null) goto L29;
        String r24 = r23.d;
        if (r24 == null) goto L29;
        r79 = r24;
    L29:
        String r25 = r79;
        VideoGenerateShareHelper.j(r17, r19, r3, r20, r21, r25, ShareScene.VIDEO_VIEWER, r80, ((BaseVideoDetailFragment) this).f, 8, r22.a, IUgcAIGCService.a.B(r22, null), null, 4352);
        return;
    L32:
        return;
    L31:
        return;
    L8:
        r12 = "";
        goto L9
    }

    public final boolean dc() {
        return com.larus.platform.service.z2.a.getCreationExtendVideoConfig().b();
    }

    public final nr9.g ea0() {
        UserCreation r0 = this.y;
        String r1 = this.z;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        nr9.g r3 = i2.b(r0, r2);
        if (r3 == null) goto L12;
        return r3;
    L12:
        return ((BaseVideoDetailFragment) this).e;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void o1() {
        ConstraintLayout r9 = this.N;
        if (r9 == null) goto L21;
        Balloon r0 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r9, (View) this.O.getValue(), false, null, null, null, null, 124);
        ViewGroup.LayoutParams r1 = ((View) this.O.getValue()).getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
    L8:
        if (r2 == null) goto L11;
        r2.setMarginEnd((-i5.Q()) + i5.r0());
    L11:
        Context r3 = getContext();
        if (r3 == null) goto L16;
        boolean r4 = true;
        if (com.larus.utils.i.h(r3) != true) goto L16;
    L17:
        if (r4 == false) goto L19;
        r0.x(r9, -r9.getMeasuredWidth(), -i5.Q());
        return;
    L19:
        r0.x(r9, r9.getMeasuredWidth(), -i5.Q());
        return;
    L16:
        r4 = false;
        goto L17
    L7:
        r2 = null;
        goto L8
    }

    public final void onDestroy() {
        ICommunityService.a.c1(this);
        super.onDestroy();
    }

    public final String tag() {
        StringBuilder r0 = new StringBuilder("CreationVideoDetailFragment");
        nr9.g r1 = ((BaseVideoDetailFragment) this).e;
        if (r1 == null) goto L5;
        String r2 = r1.a;
    L6:
        r0.append(r2);
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final void u() {
        ((BaseVideoDetailFragment) this).t = "slide";
        if (((Boolean) this.D.getValue()).booleanValue() == false) goto L10;
        hy9.d r2 = IUgcAIGCService.a.j();
        Context r1 = getContext();
        if (r1 == null) goto L7;
        String r3 = r1.getString(2131905605);
    L8:
        String r4 = r3;
        ChatControlTrace r5 = ChatControlTrace.b;
        r5.getClass();
        hy9.d.a.b(r2, r4, null, null, "video_detail", "single_function", null, null, null, null, r5.bb(ChatControlTrace.y), null, null, null, null, null, null, null, null, 1048038);
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final EditPanelType SQ() {
        if (dc() == false) goto L7;
        return EditPanelType.VIDEO;
    L7:
        return EditPanelType.NONE;
    }

    public final void U90() {
        CreationGroupFragment r0 = getParentFragment();
        if ((r0 instanceof CreationGroupFragment) == false) goto L5;
        CreationGroupFragment r1 = r0;
    L6:
        if (r1 == null) goto L9;
        CommonSlideFragment.S90(r1);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final ShareScene da0() {
        return ShareScene.VIDEO_VIEWER;
    }

    public final int getType() {
        return this.x;
    }

    public final void FU(int r29) {
        if (r29 != 6) goto L17;
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L18;
        nr9.g r4 = ea0();
        if (r4 == null) goto L19;
        hy9.d r5 = IUgcAIGCService.a.j();
        Context r1 = getContext();
        String r2 = null;
        if (r1 == null) goto L11;
        String r6 = r1.getString(2131905605);
    L12:
        ChatControlTrace r7 = ChatControlTrace.b;
        r7.getClass();
        hy9.d.a.a(r5, r6, null, null, "video_detail", "single_function", null, null, null, null, r7.bb(ChatControlTrace.y), null, null, null, null, null, null, null, null, null, null, null, 4193766);
        IAIChatUgcAIGCService.Companion r8 = IAIChatUgcAIGCService.a;
        UserCreation r9 = this.y;
        CreationDynamicInfo r10 = r9.h;
        if (r10 == null) goto L15;
        r2 = r10.d;
    L15:
        IAIChatUgcAIGCService.a.c(r8, r3, r4, r2, r9.k(), this.y.o(), null, true, null, MapsKt.mapOf(TuplesKt.to("enter_method", "ai_edit_video_detail")));
        return;
    L11:
        r6 = null;
        goto L12
    L19:
        return;
    L18:
        return;
    }

    @Override // zp9.r
    public final void X0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "creationId");
    }

    @Override // zp9.r
    public final void bZ(UserCreation r4) {
        Intrinsics.checkNotNullParameter(r4, "userCreation");
        String r0 = r4.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r0, this.y.a) == false) goto L11;
        FLogger.a.d("CreationVideoDetailFragment", "onPublishSuccess, creationId: " + r4.a);
        CreationOperatorComponent r5 = this.P;
        if (r5 == null) goto L12;
        r5.f(2);
        return;
    L12:
        return;
    }

    public final void onCreate(Bundle r1) {
        super/*com.larus.trace.tracknode.TraceFragment*/.onCreate(r1);
        ICommunityService.a.e1(this);
    }

    @Override // zp9.r
    public final void yE(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public final BaseVideoDetailFragment<LarusCreationVideoDetailFragmentLayoutBinding>.b Y90(LayoutInflater r18, ViewGroup r19) {
        Intrinsics.checkNotNullParameter(r18, "inflater");
        ConstraintLayout r0 = r18.inflate(2131562007, r19, false);
        int r1 = 2131363578;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r0, 2131363578);
        if (r5 == null) goto L35;
        r1 = 2131363806;
        if (((ImageView) ViewBindings.findChildViewById(r0, 2131363806)) == null) goto L35;
        r1 = 2131364161;
        if (((ImageView) ViewBindings.findChildViewById(r0, 2131364161)) == null) goto L35;
        r1 = 2131364437;
        if (ViewBindings.findChildViewById(r0, 2131364437) == null) goto L35;
        r1 = 2131364472;
        ConstraintLayout r6 = ViewBindings.findChildViewById(r0, 2131364472);
        if (r6 == null) goto L35;
        r1 = 2131364544;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131364544);
        if (r7 == null) goto L35;
        r1 = 2131368005;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r0, 2131368005);
        if (r8 == null) goto L35;
        r1 = 2131368277;
        CreationOperateContainerView r9 = ViewBindings.findChildViewById(r0, 2131368277);
        if (r9 == null) goto L35;
        r1 = 2131370179;
        CommonDownLoadLayout r10 = ViewBindings.findChildViewById(r0, 2131370179);
        if (r10 == null) goto L35;
        r1 = 2131374162;
        View r11 = ViewBindings.findChildViewById(r0, 2131374162);
        if (r11 == null) goto L35;
        r1 = 2131383382;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r0, 2131383382);
        if (r12 == null) goto L35;
        r1 = 2131384472;
        RelativeLayout r2 = (RelativeLayout) ViewBindings.findChildViewById(r0, 2131384472);
        if (r2 == null) goto L35;
        r1 = 2131388807;
        ConstraintLayout r14 = ViewBindings.findChildViewById(r0, 2131388807);
        if (r14 == null) goto L35;
        r1 = 2131392346;
        CreationVideoDetailPlayControlView r15 = ViewBindings.findChildViewById(r0, 2131392346);
        if (r15 == null) goto L35;
        r1 = 2131392404;
        VideoPlayView r13 = ViewBindings.findChildViewById(r0, 2131392404);
        if (r13 == null) goto L35;
        LarusCreationVideoDetailFragmentLayoutBinding r3 = new LarusCreationVideoDetailFragmentLayoutBinding(r0, r5, r6, r7, r8, r9, r10, r11, r12, r2, r14, r15, r13);
        r13.setParentSlideDirection(3);
        Unit r4 = Unit.INSTANCE;
        return new BaseVideoDetailFragment.b(r3, r13, r2, r15);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super.onViewCreated(r13, r14);
        ViewGroup r15 = this.M;
        if (r15 == null) goto L5;
        com.larus.utils.i0.a.getClass();
        int r5 = com.larus.utils.i0.e() + i5.h();
        int r6 = r15.getPaddingStart();
        int r7 = r15.getPaddingTop();
        int r8 = r15.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r15.getClass().getSimpleName() + ",source:,start:" + r6 + ",top:" + r7 + ",end:" + r8 + ",bottom:" + r5);
        r15.setPaddingRelative(r6, r7, r8, r5);
    L5:
        VideoPlayView r16 = ((BaseVideoDetailFragment) this).q;
        if (r16 == null) goto L8;
        com.larus.utils.i0.a.getClass();
        int r9 = ((((com.larus.utils.i0.e() + i5.h()) + i5.c0()) + i5.h()) - com.larus.utils.i0.g()) / 2;
        int r10 = r16.getPaddingStart();
        int r11 = r16.getPaddingTop();
        int r12 = r16.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r16.getClass().getSimpleName() + ",source:,start:" + r10 + ",top:" + r11 + ",end:" + r12 + ",bottom:" + r9);
        r16.setPaddingRelative(r10, r11, r12, r9);
    L8:
        ConstraintLayout r17 = this.N;
        if (r17 == null) goto L12;
        com.larus.utils.i0.a.getClass();
        int r18 = com.larus.utils.i0.g();
        int r19 = r17.getPaddingStart();
        int r20 = r17.getPaddingEnd();
        int r21 = r17.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r17.getClass().getSimpleName() + ",source:,start:" + r19 + ",top:" + r18 + ",end:" + r20 + ",bottom:" + r21);
        r17.setPaddingRelative(r19, r18, r20, r21);
        return;
    }

    public final View onCreateView(LayoutInflater r24, ViewGroup r25, Bundle r26) {
        Intrinsics.checkNotNullParameter(r24, "inflater");
        View r1 = super.onCreateView(r24, r25, r26);
        LarusCreationVideoDetailFragmentLayoutBinding r2 = ((BaseVideoDetailFragment) this).p;
        Integer r3 = null;
        if (r2 == null) goto L5;
        TextView r4 = r2.e;
    L6:
        this.F = r4;
        if (r2 == null) goto L9;
        TextView r5 = r2.i;
    L10:
        this.G = r5;
        if (r2 == null) goto L13;
        TextView r6 = r2.b;
    L14:
        this.H = r6;
        if (r2 == null) goto L17;
        CommonDownLoadLayout r7 = r2.g;
    L18:
        this.E = r7;
        if (r2 == null) goto L21;
        CreationOperateContainerView r8 = r2.f;
    L22:
        this.I = r8;
        if (r2 == null) goto L27;
        CreationOperateContainerView r9 = r2.f;
        if (r9 == null) goto L27;
        ViewGroup r10 = (ViewGroup) r9.findViewById(2131383028);
    L28:
        this.L = r10;
        LarusCreationVideoDetailFragmentLayoutBinding r11 = ((BaseVideoDetailFragment) this).p;
        if (r11 == null) goto L33;
        CreationOperateContainerView r12 = r11.f;
        if (r12 == null) goto L33;
        ViewGroup r13 = (ViewGroup) r12.findViewById(2131383424);
    L34:
        this.K = r13;
        LarusCreationVideoDetailFragmentLayoutBinding r14 = ((BaseVideoDetailFragment) this).p;
        if (r14 == null) goto L37;
        FrameLayout r15 = r14.d;
    L38:
        this.M = r15;
        if (r15 == null) goto L41;
        com.larus.utils.i0.a.getClass();
        int r16 = com.larus.utils.i0.e() + i5.h();
        int r17 = r15.getPaddingStart();
        int r18 = r15.getPaddingTop();
        int r19 = r15.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r15.getClass().getSimpleName() + ",source:,start:" + r17 + ",top:" + r18 + ",end:" + r19 + ",bottom:" + r16);
        r15.setPaddingRelative(r17, r18, r19, r16);
    L41:
        LarusCreationVideoDetailFragmentLayoutBinding r20 = ((BaseVideoDetailFragment) this).p;
        if (r20 == null) goto L44;
        ConstraintLayout r21 = r20.j;
    L45:
        this.N = r21;
        if (r21 == null) goto L48;
        r21.setBackgroundResource(R.color.transparent);
    L48:
        UserCreation r22 = this.y;
        String r23 = "";
        if (r22 == null) goto L51;
        String r27 = r22.d();
    L52:
        UserCreation r28 = this.y;
        if (r28 == null) goto L58;
        AuthorInfo r29 = r28.g;
        if (r29 == null) goto L58;
        String r30 = r29.a;
        if (r30 == null) goto L58;
    L59:
        if (r28 == null) goto L63;
        Long r31 = r28.f;
        if (r31 == null) goto L63;
        long r32 = r31.longValue();
    L64:
        gs9.d r33 = this.C;
        int r110 = 0;
        if (r33 == null) goto L104;
        gs9.a r34 = r33.b;
        if (r34 == null) goto L104;
        FLogger.a.i("CreationVideoDetailFragment", "bottomInfoConfig:" + r34);
        TextView r111 = this.G;
        if (r111 == null) goto L71;
        r111.setVisibility(0);
    L71:
        TextView r112 = this.G;
        if (r112 == null) goto L75;
        r112.setText(r27);
    L75:
        if (r34.a == false) goto L82;
        TextView r35 = this.H;
        if (r35 == null) goto L79;
        r35.setText("@".concat(r30));
    L79:
        TextView r36 = this.H;
        if (r36 == null) goto L85;
        r36.setVisibility(0);
    L85:
        StringBuilder r37 = new StringBuilder();
        TextView r38 = this.H;
        if (r38 != null) goto L88;
    L90:
        boolean r39 = false;
    L91:
        if (r39 == false) goto L93;
        r23 = " · ";
    L93:
        r37.append(r23);
        int r40 = CommonAuthorInfoLayout.c;
        r37.append(CommonAuthorInfoLayout.a.a(getContext(), r32));
        String r41 = r37.toString();
        if (r34.b == false) goto L101;
        TextView r42 = this.F;
        if (r42 == null) goto L98;
        r42.setVisibility(0);
    L98:
        TextView r43 = this.F;
        if (r43 == null) goto L104;
        r43.setText(r41);
        goto L104
    L101:
        TextView r44 = this.F;
        if (r44 == null) goto L104;
        r44.setVisibility(8);
        goto L104
    L88:
        if (r38.getVisibility() != 0) goto L90;
        r39 = true;
        goto L91
    L82:
        TextView r45 = this.H;
        if (r45 == null) goto L85;
        r45.setVisibility(8);
    L104:
        nr9.g r46 = ea0();
        if (r46 == null) goto L109;
        CommonDownLoadLayout r47 = this.E;
        if (r47 == null) goto L109;
        r47.S5(LifecycleOwnerKt.getLifecycleScope(this), new com.larus.bmhome.bigimg.download.d.c(r46));
    L109:
        com.larus.utils.e1.d(this.E, new a2(this));
        Context r48 = getContext();
        if (r48 != null) goto L112;
        r48 = AppHost.a.getApplication();
    L112:
        Context r113 = r48;
        ViewGroup r114 = this.L;
        CreationOperateContainerView r115 = this.I;
        UserCreation r49 = this.y;
        LifecycleCoroutineScope r116 = LifecycleOwnerKt.getLifecycleScope(this);
        int r50 = this.A;
        j2 r51 = getParentFragment();
        Intrinsics.checkNotNull(r51, "null cannot be cast to non-null type com.larus.profile.impl.creation.ICreationDelegateInterface");
        this.P = new CreationOperatorComponent(r113, null, r114, r115, r49, r116, r51, Integer.valueOf(r50), this.C, true, 1024);
        Context r52 = getContext();
        if (r52 != null) goto L115;
        r52 = AppHost.a.getApplication();
    L115:
        Context r117 = r52;
        UserCreation r118 = this.y;
        LifecycleCoroutineScope r119 = LifecycleOwnerKt.getLifecycleScope(this);
        gs9.d r53 = this.C;
        if (r53 == null) goto L118;
        boolean r120 = r53.e;
    L119:
        if (r53 == null) goto L121;
        boolean r121 = r53.d;
    L122:
        if (r53 == null) goto L124;
        gs9.b r122 = r53.f;
    L125:
        this.J = new u1(r117, null, r119, r118, r121, r120, r122);
        if (com.larus.utils.o0.d(this.z) == false) goto L130;
        CommonDownLoadLayout r54 = this.E;
        if (r54 == null) goto L130;
        com.larus.utils.e1.o(r54);
    L130:
        ViewGroup r55 = this.L;
        if (r55 == null) goto L133;
        com.larus.utils.e1.d(r55, new f2(this));
    L133:
        ViewGroup r56 = this.K;
        if (r56 == null) goto L136;
        com.larus.utils.e1.d(r56, new g2(this));
    L136:
        VideoPlayView r57 = ((BaseVideoDetailFragment) this).q;
        if (r57 == null) goto L140;
        r57.setOnLongClickListener(new h2(this));
    L140:
        if (com.larus.utils.o0.d(this.z) == false) goto L142;
        int r58 = 4;
    L158:
        if (getContext() == null) goto L162;
        CommonDownLoadLayout r59 = this.E;
        if (r59 == null) goto L162;
        r59.setBackgroundResource(2131238692);
    L162:
        u1 r60 = this.J;
        if (r60 == null) goto L165;
        r60.e(r58);
    L165:
        CreationOperatorComponent r61 = this.P;
        if (r61 == null) goto L168;
        r61.f(r58);
    L168:
        return r1;
    L142:
        UserCreation r62 = this.y;
        if (r62 == null) goto L146;
        r3 = r62.d;
    L146:
        if (r3 != null) goto L149;
    L151:
        if (r3 != null) goto L154;
    L156:
        r58 = r110;
        goto L158
    L154:
        if (r3.intValue() != 1) goto L156;
        r110 = 2;
        goto L156
    L149:
        if (r3.intValue() != 2) goto L151;
        r110 = 3;
        goto L156
    L124:
        r122 = null;
        goto L125
    L121:
        r121 = false;
        goto L122
    L118:
        r120 = false;
    L63:
        r32 = 0;
    L58:
        r30 = "";
        goto L59
    L51:
        r27 = "";
        goto L52
    L44:
        r21 = null;
        goto L45
    L37:
        r15 = null;
    L33:
        r13 = null;
    L27:
        r10 = null;
        goto L28
    L21:
        r8 = null;
        goto L22
    L17:
        r7 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // zp9.r
    public final void i20(UserCreation r1, long r2, long r4, String r6) {
        zp9.r.a.a(r1, r6);
    }

    public CreationVideoDetailFragment(UserCreation r8, String r9, int r10, Function0 r11, gs9.d r12, nr9.g r13, c4 r14) {
        Intrinsics.checkNotNullParameter(r8, "userCreation");
        Intrinsics.checkNotNullParameter(r14, "eventParam");
        com.larus.platform.service.z2 r0 = com.larus.platform.service.z2.a;
        super(r13, r14, r0.j1(), r0.Q3(), 16);
        this.x = 1;
        this.y = r8;
        this.z = r9;
        this.A = r10;
        this.B = r11;
        this.C = r12;
        this.D = LazyKt.lazy(new y1());
        this.O = LazyKt.lazy(new z1(this));
    }
}
