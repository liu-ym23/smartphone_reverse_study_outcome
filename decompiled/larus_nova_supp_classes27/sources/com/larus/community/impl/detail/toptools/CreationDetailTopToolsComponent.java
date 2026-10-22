package com.larus.community.impl.detail.toptools;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.bmhome.utils.IVideoShareService;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.common.apphost.AppHost;
import com.larus.community.api.ICommunityService;
import com.larus.community.api.spi.ICommunityHostBehaviorProvider;
import com.larus.home.impl.sdk.b1;
import com.larus.im.bean.message.AICreationTaskDurationInfo;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.b3;
import com.larus.platform.api.creation.AiBeautifyUserContent;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.api.creation.VideoInfo;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z1;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.a5;
import hq9.v1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;
import tx9.e2;
import tx9.m0;
import tx9.o0;
import tx9.u3;
import tx9.x2;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001'\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001cB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010+\u001a\u0004\u0018\u00010\rH\u0002J\u000e\u0010,\u001a\u0004\u0018\u00010-*\u00020\rH\u0002J\u0010\u0010.\u001a\u0004\u0018\u00010**\u0004\u0018\u00010/H\u0002J\u000e\u00100\u001a\u0004\u0018\u000101*\u00020\rH\u0002J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0002J\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000206H\u0016J\b\u00108\u001a\u000206H\u0016J\b\u00109\u001a\u000206H\u0016J\b\u0010:\u001a\u000206H\u0002J\u0010\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u000206H\u0002J\f\u0010?\u001a\u000206*\u00020!H\u0002J\u0016\u0010@\u001a\u00020A*\u00020!2\b\b\u0002\u0010B\u001a\u000203H\u0002J\u0014\u0010C\u001a\u000206*\u00020!2\u0006\u0010D\u001a\u000203H\u0002J\b\u0010E\u001a\u000206H\u0002J\u0012\u0010F\u001a\u0002062\b\u0010G\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010H\u001a\u0002062\b\u0010G\u001a\u0004\u0018\u00010\rH\u0002J!\u0010I\u001a\u0002062\b\u0010J\u001a\u0004\u0018\u00010*2\b\u0010K\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u000206H\u0016J\b\u0010N\u001a\u00020=H\u0002J\b\u0010O\u001a\u000206H\u0002J\b\u0010P\u001a\u000206H\u0002J\b\u0010Q\u001a\u000206H\u0002J\b\u0010R\u001a\u000206H\u0002J\u0010\u0010S\u001a\u0002062\u0006\u0010T\u001a\u00020*H\u0016J\u0012\u0010U\u001a\u0002062\b\u0010J\u001a\u0004\u0018\u00010*H\u0002J\b\u0010V\u001a\u000206H\u0016J\u000e\u0010W\u001a\b\u0012\u0004\u0012\u00020Y0XH\u0016J\u0018\u0010Z\u001a\u0002062\u0006\u0010[\u001a\u00020-2\u0006\u0010\\\u001a\u00020\rH\u0002J\u0010\u0010b\u001a\u0002062\u0006\u0010\\\u001a\u00020\rH\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010]\u001a\u00020^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010\u0015\u001a\u0004\b_\u0010`¨\u0006d"}, d2 = {"Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsAbility;", "<init>", "()V", "viewModel", "Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsViewModel;", "getViewModel", "()Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "currentUserCreation", "Lcom/larus/platform/api/creation/UserCreation;", "getCurrentUserCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "creationDetailLoadingAbility", "Lcom/larus/community/impl/detail/loading/CreationDetailLoadingAbility;", "getCreationDetailLoadingAbility", "()Lcom/larus/community/impl/detail/loading/CreationDetailLoadingAbility;", "creationDetailLoadingAbility$delegate", "Lkotlin/Lazy;", "creationTrackParams", "Lcom/larus/community/impl/detail/model/CreationTrackParamsWrap;", "getCreationTrackParams", "()Lcom/larus/community/impl/detail/model/CreationTrackParamsWrap;", "creationDetailAbility", "Lcom/larus/community/impl/detail/CreationDetailFragmentAbility;", "getCreationDetailAbility", "()Lcom/larus/community/impl/detail/CreationDetailFragmentAbility;", "creationDetailAbility$delegate", "remoteUserCreation", "hostChromeRefreshView", "Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsView;", "hostChromeLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "leaveStartTime", "", "appBackGroundListener", "com/larus/community/impl/detail/toptools/CreationDetailTopToolsComponent$appBackGroundListener$1", "Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsComponent$appBackGroundListener$1;", "currentCreationTaskId", "", "currentDisplayUserCreation", "resolveImageInfo", "Lcom/larus/platform/api/ImageInfo;", "resolvedUrl", "Lcom/larus/platform/api/Image;", "resolveVideoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "shouldShowVideoCreationDialogOnShare", "", "shouldShowImageCreationDialogOnShare", "onCreate", "", "onDestroy", "onResume", "onPause", "prefetchToCreationBitmapCache", "onViewCreated", "view", "Landroid/view/View;", "initObserver", "applyHostChromeMode", "updateHostChromeMode", "Lcom/larus/community/api/spi/CommunityDetailChromePolicy;", "retryWhenPending", "bindHostChromeAdaptiveRefresh", "enabled", "unbindHostChromeAdaptiveRefresh", "updateHostOwnerMenu", "creation", "jumpAuthorPage", "mobCloseTemplateDetail", "leaveMethod", "duration", "(Ljava/lang/String;Ljava/lang/Long;)V", "onAttach", "buildMoreMenu", "showMoreMenu", "setCreationPrivacy", "deleteCreation", "publicRefImage", "doShareAction", "clickMethod", "reportLeaveEvent", "onStop", "getCreationRefImagePublicState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/community/impl/detail/toptools/CreationRefImagePublicState;", "saveBitmap", "imageInfo", "displayCreation", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "saveVideo", "CreationShareCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailTopToolsComponent extends BaseContentWidget implements com.larus.community.impl.detail.toptools.a {
    public static final /* synthetic */ int w = 0;
    public final com.larus.ui.arch.vm.internal.l m;
    public final Lazy n;
    public final Lazy o;
    public UserCreation p;
    public CreationDetailTopToolsView q;
    public final i r;
    public long s;
    public final b t;
    public String u;
    public final Lazy v;

    public static final class a implements com.larus.bmhome.share.panel.d {
        public final String a;

        public final boolean d(String r1, String r2, Boolean r3) {
            return true;
        }

        public final void f() {
        }

        public final void onDismiss() {
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "creationId");
            this.a = r2;
        }

        public final void e(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
        }

        public final boolean b(Context r22, DialogFragment r23, View r24, jr9.a r25) {
            Intrinsics.checkNotNullParameter(r25, "shareItemConfig");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L34
            if (Intrinsics.areEqual(r25.b(), "report") == false) goto L30;
            IAIChatService.Companion r1 = IAIChatService.a;     // Catch: Throwable -> L34
            String r5 = this.a;     // Catch: Throwable -> L32
            Intrinsics.checkNotNullParameter(r5, "entityId");     // Catch: Throwable -> L32
            TipOffDialogParams r15 = new TipOffDialogParams(8, r5, null, null, "", "", 0, null, null, null, null, null, null, null, null);     // Catch: Throwable -> L32
            r15.g = 0;     // Catch: Throwable -> L32
            Fragment r2 = r1.g8(r15);     // Catch: Throwable -> L32
            if (r23 == null) goto L20;
            FragmentManager r3 = r23.getParentFragmentManager();     // Catch: Throwable -> L32
            if (r3 == null) goto L20;
            if ((r2 instanceof Fragment) == false) goto L14;
            Fragment r4 = r2;
        L15:
            LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L32
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, null, r6);     // Catch: Throwable -> L32
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r4, r6) == true) goto L20;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41 Throwable -> L32
        L19:
            r2.show(r3, null);     // Catch: Throwable -> L32
            goto L20
        L14:
            r4 = null;
        L20:
            if (r23 == null) goto L49;
            r23.dismiss();     // Catch: Exception -> L23 Throwable -> L32
        L51:
            return true;
        L23:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L32
            Throwable r7 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L32
            if (r7 == null) goto L50;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L32
            return true;
        L50:
            return true;
        L49:
            return true;
        L30:
            Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
        L37:
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L40;
            FLogger.a.e("CreationDetailTopToolsComponent", "Save music video error state ", r9);
        L40:
            return false;
        L32:
            th = th;
        L36:
            Result.Companion r10 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
        L34:
            th = th;
            goto L36
        }
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ CreationDetailTopToolsComponent a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppForeground() {
        }

        public final void onAppBackground() {
            CreationDetailTopToolsComponent r0 = this.a;
            int r1 = CreationDetailTopToolsComponent.w;
            r0.j3("leave_app");
        }

        public b(CreationDetailTopToolsComponent r1) {
            this.a = r1;
        }
    }

    public static final class c implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public c(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class d implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public d(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class e implements Function0<ViewModelProvider.Factory> {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.detail.toptools.CreationDetailTopToolsComponent$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.detail.toptools.CreationDetailTopToolsComponent$onCreate$1", f = "CreationDetailTopToolsComponent.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ CreationDetailTopToolsComponent this$0;

        public AnonymousClass1(CreationDetailTopToolsComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            CreationDetailTopToolsComponent r2 = (CreationDetailTopToolsComponent) this.L$0;
            ResultKt.throwOnFailure(r7);
        L21:
            Message r8 = (Message) r7;
            if (r8 == null) goto L28;
            List r9 = ap8.a.a(r8);
            if (r9 == null) goto L28;
            AICreationTaskDurationInfo r10 = (AICreationTaskDurationInfo) CollectionsKt.firstOrNull(r9);
            if (r10 == null) goto L28;
            String r11 = r10.taskId;
        L30:
            r2.u = r11;
            return Unit.INSTANCE;
        L28:
            CreationDetailTopToolsComponent r12 = r2;
        L29:
            r2 = r12;
            r11 = null;
            goto L30
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            r12 = this.this$0;
            IChatRepoService r3 = RepoDispatcherDelegate.b.e();
            if (r3 == null) goto L29;
            CreationDetailTopToolsComponent r4 = this.this$0;
            int r5 = CreationDetailTopToolsComponent.w;
            UserCreation r6 = r4.p3();
            if (r6 == null) goto L16;
            CreationDynamicInfo r13 = r6.h;
            if (r13 == null) goto L16;
            String r14 = r13.d;
            if (r14 == null) goto L16;
        L17:
            this.L$0 = r12;
            this.label = 1;
            Object r15 = r3.E1(r14, this);
            if (r15 != r0) goto L20;
            return r0;
        L20:
            r2 = r12;
            r7 = r15;
        L16:
            r14 = "0";
            goto L17
        }
    }

    public final void H3() {
        j29.a r1 = m3();
        if (r1 == null) goto L7;
        zp9.g r2 = r1.a;
        if (r2 == null) goto L7;
        String r5 = r2.h;
    L8:
        j29.a r3 = m3();
        if (r3 == null) goto L13;
        zp9.g r4 = r3.a;
        if (r4 == null) goto L13;
        String r6 = r4.a;
    L14:
        UserCreation r7 = p3();
        if (r7 == null) goto L17;
        String r8 = r7.a;
    L18:
        String r9 = this.u;
        UserCreation r10 = p3();
        if (r10 == null) goto L24;
        CreationDynamicInfo r11 = r10.h;
        if (r11 == null) goto L24;
        String r12 = r11.d;
        if (r12 == null) goto L24;
    L25:
        String r13 = r12;
        UserCreation r14 = p3();
        if (r14 == null) goto L28;
        String r15 = zp9.d.d(r14);
    L29:
        UserCreation r16 = p3();
        if (r16 == null) goto L32;
        String r17 = zp9.d.c(r16);
    L33:
        j29.a r18 = m3();
        if (r18 == null) goto L38;
        zp9.g r20 = r18.a;
        if (r20 == null) goto L38;
        String r110 = r20.j;
    L39:
        UserCreation r21 = p3();
        if (r21 == null) goto L42;
        String r111 = r21.i;
    L43:
        UserCreation r22 = p3();
        if (r22 == null) goto L48;
        UserCreationTrackParams r23 = r22.n;
        if (r23 == null) goto L48;
        String r112 = r23.a;
    L49:
        UserCreation r24 = p3();
        if (r24 == null) goto L52;
        String r113 = r24.a;
    L53:
        e2.a.b(new o0(r6, r5, r8, r9, r13, r15, "1", "0", r110, r113, r112, r111, null, r17, null, null, null, null, 499713), null, 3);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailTopToolsComponent$setCreationPrivacy$1(this, 2, null), 3, null);
        return;
    L52:
        r113 = null;
    L48:
        r112 = null;
        goto L49
    L42:
        r111 = null;
    L38:
        r110 = null;
        goto L39
    L32:
        r17 = null;
        goto L33
    L28:
        r15 = null;
    L24:
        r12 = "";
        goto L25
    L17:
        r8 = null;
    L13:
        r6 = null;
    L7:
        r5 = null;
        goto L8
    }

    public final boolean Q3() {
        z2 r0 = z2.a;
        v1 r1 = r0.getCreationShareSettings().a();
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L27;
        v1 r3 = r0.getCreationShareSettings().a();
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        Integer r5 = null;
        if (r4 == false) goto L21;
        List r6 = CollectionsKt.listOf(new Integer[]{2, 5, 4, 3});
        UserCreation r7 = p3();
        if (r7 == null) goto L20;
        r5 = Integer.valueOf(r7.b);
    L20:
        boolean r8 = CollectionsKt.contains(r6, r5);
    L25:
        if (r8 == false) goto L27;
        return true;
    L21:
        List r9 = CollectionsKt.listOf(new Integer[]{5, 4, 3});
        UserCreation r10 = p3();
        if (r10 == null) goto L24;
        r5 = Integer.valueOf(r10.b);
    L24:
        r8 = CollectionsKt.contains(r9, r5);
        goto L25
    L12:
        if (r3.f() != true) goto L14;
        r4 = true;
    L27:
        return false;
    L5:
        if (r1.e() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void V3() {
        ArrayList r1 = new ArrayList();
        r1.add(new l0(2131899197, 2131899197, null, null, null, 2131103136, null, 2131240225, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        j29.a r0 = m3();
        ViewGroup.MarginLayoutParams r51 = null;
        if (r0 == null) goto L7;
        zp9.g r2 = r0.a;
        if (r2 == null) goto L7;
        String r3 = r2.h;
    L8:
        m0.c("already_public", "1", "creation_detail", r3);
        UserCreation r4 = p3();
        if (r4 == null) goto L17;
        UserCreationRefContent r5 = r4.o;
        if (r5 == null) goto L17;
        List r6 = r5.a();
        if (r6 == null) goto L17;
        boolean r7 = true;
        if ((!r6.isEmpty()) != true) goto L17;
    L18:
        if (r7 == true) goto L20;
    L36:
        r1.add(new l0(2131900631, 2131900631, null, null, null, 2131102650, null, 2131240158, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        View r8 = CreateMenu.f(new CreateMenu(getContext()), r1, 0, false, null, null, null, null, new k(this), 510);
        Balloon r9 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, F2(), r8, false, null, null, null, null, 124);
        ViewGroup.LayoutParams r10 = r8.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L39;
        r51 = (ViewGroup.MarginLayoutParams) r10;
    L39:
        ViewGroup.MarginLayoutParams r11 = r51;
        if (r11 == null) goto L44;
        r11.setMarginEnd((-i5.T()) + i5.h());
    L44:
        if (com.larus.utils.i.h(getContext()) == false) goto L46;
        r9.x(F2(), -F2().getMeasuredWidth(), -i5.Q());
        return;
    L46:
        r9.x(F2(), F2().getMeasuredWidth(), -i5.Q());
        return;
    L20:
        if (((CreationRefImagePublicState) z3().getRefImagePublicState().getValue()).isPublic() == true) goto L36;
        UserCreation r12 = p3();
        if (r12 == null) goto L26;
        AuthorInfo r13 = r12.g;
        if (r13 == null) goto L26;
        String r14 = r13.b;
    L28:
        if (Intrinsics.areEqual(r14, AccountService.a.getUserId()) == false) goto L36;
        r1.add(new l0(2131906517, 2131906517, null, null, null, 2131103136, null, 2131240217, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        j29.a r15 = m3();
        if (r15 == null) goto L34;
        zp9.g r16 = r15.a;
        if (r16 == null) goto L34;
        String r17 = r16.h;
    L35:
        m0.c("public_image_reference", "1", "creation_detail", r17);
    L34:
        r17 = null;
    L26:
        r14 = null;
    L17:
        r7 = false;
    L7:
        r3 = null;
        goto L8
    }

    public final void W3() {
        ConstraintLayout r0 = this.q;
        if (r0 == null) goto L5;
        r0.removeOnLayoutChangeListener(this.r);
    L5:
        ConstraintLayout r1 = this.q;
        if (r1 == null) goto L8;
        ViewCompat.setOnApplyWindowInsetsListener(r1, null);
    L8:
        this.q = null;
    }

    public final void onPause() {
        int r0 = e29.d.a;
        Intrinsics.checkNotNullParameter(this, "owner");
        ICommunityHostBehaviorProvider r1 = e29.d.c();
        if (r1 == null) goto L6;
        r1.s(this);
        return;
    }

    public final void onStop() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        AppHost.Companion r1 = AppHost.a;
        List r2 = CollectionsKt.reversed(r1.a().g());
        boolean r4 = false;
        if (r2.size() > 2) goto L5;
    L7:
        boolean r3 = false;
    L9:
        if (r2.size() <= 1) goto L14;
        if (Intrinsics.areEqual(ListProtector.get(r2, 1), r0) == false) goto L14;
        r4 = true;
    L14:
        if (Intrinsics.areEqual(r1.a().getCurrentActivity(), r0) == false) goto L17;
        return;
    L17:
        if (r3 == false) goto L19;
        j3("enter_new_page");
        return;
    L19:
        if (r4 == false) goto L21;
        j3("enter_new_page");
        return;
    L21:
        j3("leave_page");
        return;
    L5:
        if (Intrinsics.areEqual(ListProtector.get(r2, 2), r0) == false) goto L7;
        r3 = true;
        goto L9
    }

    public final CreationDetailTopToolsViewModel z3() {
        return (CreationDetailTopToolsViewModel) this.m.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.community.impl.detail.toptools.i] */
    public CreationDetailTopToolsComponent() {
        this.m = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CreationDetailTopToolsViewModel.class), Reflection.getOrCreateKotlinClass(CreationRefImagePublicState.class), new c(this), new d(this), e.a);
        this.n = LazyKt.lazy(new g(this));
        this.o = LazyKt.lazy(new h(this));
        this.r = new i(this);
        this.t = new b(this);
        this.v = LazyKt.lazy(new j(this));
    }

    @Override // com.larus.community.impl.detail.toptools.a
    public final i1<CreationRefImagePublicState> TZ() {
        return z3().getRefImagePublicState();
    }

    public final UserCreation h3() {
        UserCreation r0 = p3();
        String r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        AuthorInfo r2 = r0.g;
        if (r2 == null) goto L9;
        r1 = r2.b;
    L9:
        if (Intrinsics.areEqual(r1, AccountService.a.getUserId()) == false) goto L18;
        CreationNoWatermarkManager r3 = CreationNoWatermarkManager.a;
        if (r3.D() == false) goto L19;
        UserCreation r4 = r3.f0(r0, false);
        if (r4 != null) goto L17;
        return r0;
    L17:
        return r4;
    L19:
        return r0;
    L18:
        return r0;
    }

    public final j29.a m3() {
        return (j29.a) s1a.d.a(this).a(j29.a.class);
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        AppHost.a.a().j(this.t);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void onDestroy() {
        W3();
        int r0 = e29.d.a;
        Intrinsics.checkNotNullParameter(this, "owner");
        ICommunityHostBehaviorProvider r1 = e29.d.c();
        if (r1 == null) goto L5;
        r1.s(this);
    L5:
        AppHost.a.a().c(this.t);
    }

    public final void onResume() {
        this.s = SystemClock.elapsedRealtime();
        UserCreation r0 = this.p;
        if (r0 != null) goto L5;
        r0 = p3();
    L5:
        Z3(r0);
    }

    public final UserCreation p3() {
        j29.c r0 = (j29.c) s1a.d.a(this).a(j29.c.class);
        if (r0 == null) goto L7;
        UserCreation r1 = r0.a;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.p;
    }

    public final void y2() {
        z3().init(p3());
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.community.impl.detail.toptools.a.class);
    }

    public static ImageInfo C3(UserCreation r2) {
        int r0 = r2.b;
        if (r0 != 2) goto L5;
    L21:
        UserCreationContent r3 = r2.e;
        if (r3 == null) goto L26;
        UserCreationImage r4 = r3.a;
        if (r4 == null) goto L26;
        return r4.a;
    L26:
        return null;
    L5:
        if (r0 != 3) goto L7;
        UserCreationContent r5 = r2.e;
        if (r5 == null) goto L26;
        UserCreationUserAvatar r6 = r5.c;
        if (r6 == null) goto L26;
        return r6.a;
    L7:
        if (r0 != 4) goto L9;
        UserCreationContent r7 = r2.e;
        if (r7 == null) goto L26;
        AiBeautifyUserContent r8 = r7.d;
        if (r8 == null) goto L26;
        return r8.a;
    L9:
        if (r0 == 5) goto L21;
        goto L21
    }

    public static nr9.g D3(UserCreation r4) {
        UserCreationContent r0 = r4.e;
        String r1 = null;
        if (r0 == null) goto L27;
        VideoUserContent r2 = r0.e;
        if (r2 == null) goto L28;
        AuthorInfo r5 = r4.g;
        if (r5 == null) goto L9;
        String r6 = r5.b;
    L11:
        if (Intrinsics.areEqual(r6, AccountService.a.getUserId()) == true) goto L13;
    L15:
        boolean r7 = false;
    L16:
        if (r7 == false) goto L18;
        nr9.g r3 = os8.c.c(r2);
    L19:
        if (r7 == false) goto L26;
        CreationNoWatermarkManager r8 = CreationNoWatermarkManager.a;
        VideoInfo r9 = r2.a;
        if (r9 == null) goto L23;
        r1 = r9.a;
    L23:
        ImageInfo r10 = r2.b;
        r8.getClass();
        nr9.g r11 = r8.c0(r1, r3, CreationNoWatermarkManager.u0(r10));
        if (r11 == null) goto L26;
        return r11;
    L26:
        return r3;
    L18:
        r3 = os8.c.d(r2);
        goto L19
    L13:
        if (CreationNoWatermarkManager.a.D() == false) goto L15;
        r7 = true;
        goto L16
    L9:
        r6 = null;
        goto L11
    L28:
        return null;
    L27:
        return null;
    }

    public static String E3(Image r3) {
        if (r3 == null) goto L13;
        String r1 = r3.a;
        if (r1 == null) goto L13;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L13;
        return r1;
    L13:
        if (r3 == null) goto L21;
        String r4 = r3.b;
        if (r4 != null) goto L17;
        return null;
    L17:
        if ((!StringsKt.isBlank(r4)) == true) goto L19;
        return null;
    L19:
        return r4;
    L21:
        return null;
    }

    public final void B3(UserCreation r12) {
        String r0 = null;
        if (r12 == null) goto L7;
        AuthorInfo r1 = r12.g;
        if (r1 == null) goto L7;
        String r3 = r1.b;
    L8:
        int r2 = e29.d.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r4 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        String r5 = AccountService.a.getUserId();
        Intrinsics.checkNotNullParameter(r4, "fragment");
        ICommunityHostBehaviorProvider r6 = e29.d.c();
        if (r6 == null) goto L13;
        boolean r7 = r6.e(r4, r12, r5);
        boolean r8 = true;
        if (r7 != true) goto L13;
    L14:
        if (r8 == false) goto L16;
        return;
    L16:
        z1 r9 = z1.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r10 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if (r12 == null) goto L21;
        UserCreationTrackParams r13 = r12.n;
        if (r13 == null) goto L21;
        r0 = r13.a;
    L21:
        b3.a.b(r10, r3, null, r0, null, "click_profile", false, null, 212);
        return;
    L13:
        r8 = false;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.larus.community.impl.detail.toptools.a
    public final void Gc(String r105) {
        Intrinsics.checkNotNullParameter(r105, "clickMethod");
        UserCreation r1 = h3();
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L20;
        r2.D0();
        b1 r3 = b1.a;
        r3.c("creation_gallery_share_save");
        if (r1 == null) goto L9;
        ImageInfo r4 = C3(r1);
        if (r4 == null) goto L9;
        Image r5 = r4.a;
    L10:
        String r6 = E3(r5);
        if (r6 != null) goto L17;
        if (r1 == null) goto L16;
        nr9.g r7 = D3(r1);
        if (r7 == null) goto L16;
        r6 = r7.c;
    L16:
        r6 = null;
    L17:
        if (r6 != null) goto L19;
        r6 = "";
    L19:
        r3.d(r6);
    L9:
        r5 = null;
    L20:
        UserCreation r8 = p3();
        if (r8 == null) goto L23;
        String r9 = r8.a;
    L24:
        UserCreation r10 = p3();
        if (r10 == null) goto L27;
        String r11 = zp9.d.d(r10);
    L28:
        UserCreation r12 = p3();
        if (r12 == null) goto L31;
        String r13 = zp9.d.b(r12);
    L32:
        UserCreation r14 = p3();
        if (r14 == null) goto L37;
        AuthorInfo r15 = r14.g;
        if (r15 == null) goto L37;
        String r16 = r15.b;
    L38:
        UserCreation r17 = p3();
        if (r17 == null) goto L43;
        UserCreationTrackParams r18 = r17.n;
        if (r18 == null) goto L43;
        Integer r20 = r18.c;
    L44:
        UserCreation r21 = p3();
        if (r21 == null) goto L49;
        UserCreationTrackParams r22 = r21.n;
        if (r22 == null) goto L49;
        Integer r23 = r22.b;
    L50:
        UserCreation r24 = p3();
        if (r24 == null) goto L55;
        UserCreationTrackParams r25 = r24.n;
        if (r25 == null) goto L55;
        String r110 = r25.a;
    L56:
        j29.a r26 = m3();
        if (r26 == null) goto L61;
        zp9.g r27 = r26.a;
        if (r27 == null) goto L61;
        String r111 = r27.j;
    L62:
        UserCreation r28 = p3();
        if (r28 == null) goto L67;
        UserCreationTrackParams r30 = r28.n;
        if (r30 == null) goto L67;
        String r112 = r30.g;
    L68:
        UserCreation r31 = p3();
        if (r31 == null) goto L73;
        UserCreationTrackParams r32 = r31.n;
        if (r32 == null) goto L73;
        String r113 = r32.d;
    L74:
        UserCreation r33 = p3();
        if (r33 == null) goto L79;
        UserCreationTrackParams r34 = r33.n;
        if (r34 == null) goto L79;
        String r114 = r34.e;
    L80:
        UserCreation r35 = p3();
        if (r35 == null) goto L85;
        UserCreationTrackParams r36 = r35.n;
        if (r36 == null) goto L85;
        String r115 = r36.f;
    L86:
        UserCreation r37 = p3();
        if (r37 == null) goto L89;
        Long r38 = r37.f;
    L90:
        j29.a r116 = m3();
        if (r116 == null) goto L95;
        zp9.g r117 = r116.a;
        if (r117 == null) goto L95;
        String r118 = r117.h;
    L96:
        j29.a r119 = m3();
        if (r119 == null) goto L101;
        zp9.g r120 = r119.a;
        if (r120 == null) goto L101;
        String r121 = r120.a;
    L102:
        j29.a r122 = m3();
        if (r122 == null) goto L107;
        zp9.g r123 = r122.a;
        if (r123 == null) goto L107;
        String r210 = r123.d;
    L108:
        j29.a r124 = m3();
        if (r124 == null) goto L113;
        zp9.g r125 = r124.a;
        if (r125 == null) goto L113;
        String r211 = r125.f;
    L114:
        j29.a r126 = m3();
        if (r126 == null) goto L119;
        zp9.g r127 = r126.a;
        if (r127 == null) goto L119;
        Integer r212 = r127.e;
    L120:
        UserCreation r128 = p3();
        if (r128 == null) goto L123;
        String r213 = r128.i;
    L124:
        j29.a r129 = m3();
        if (r129 == null) goto L129;
        zp9.g r130 = r129.a;
        if (r130 == null) goto L129;
        String r214 = r130.i;
    L130:
        UserCreation r131 = p3();
        if (r131 == null) goto L133;
        String r215 = zp9.d.c(r131);
    L134:
        u3.e(r9, r11, r13, r16, r38, r20, r23, r105, r110, r111, r113, r115, r114, r112, r121, r118, r210, r211, null, r213, r212, r214, r215, 6553600);
        if (r1 != null) goto L138;
        return;
    L138:
        if (com.larus.utils.o0.d(r1.h()) == false) goto L142;
        ImageInfo r40 = C3(r1);
        if (r40 == null) goto L435;
        G3(r40, r1);
        return;
    L435:
        return;
    L142:
        boolean r41 = true;
        if (CollectionsKt.listOf(new Integer[]{7, 6, 9, 8, 10, 11, 12}).contains(Integer.valueOf(r1.b)) == false) goto L429;
        j29.a r42 = m3();
        if (r42 == null) goto L149;
        zp9.g r43 = r42.a;
        if (r43 == null) goto L149;
        String r310 = r43.h;
    L150:
        j29.a r44 = m3();
        if (r44 == null) goto L155;
        zp9.g r45 = r44.a;
        if (r45 == null) goto L155;
        String r311 = r45.a;
    L156:
        UserCreation r46 = p3();
        if (r46 != null) goto L159;
    L161:
        boolean r312 = false;
    L162:
        j29.a r47 = m3();
        if (r47 == null) goto L167;
        zp9.g r48 = r47.a;
        if (r48 == null) goto L167;
        String r313 = r48.f;
    L168:
        UserCreation r50 = p3();
        if (r50 == null) goto L171;
        Integer r410 = Integer.valueOf(r50.b);
    L172:
        UserCreation r51 = p3();
        if (r51 == null) goto L175;
        String r411 = r51.a;
    L176:
        UserCreation r52 = p3();
        if (r52 == null) goto L179;
        String r412 = zp9.d.d(r52);
    L180:
        UserCreation r53 = p3();
        if (r53 == null) goto L183;
        String r413 = zp9.d.b(r53);
    L184:
        UserCreation r54 = p3();
        if (r54 == null) goto L189;
        UserCreationTrackParams r55 = r54.n;
        if (r55 == null) goto L189;
        String r414 = r55.a;
    L190:
        j29.a r56 = m3();
        if (r56 == null) goto L195;
        zp9.g r57 = r56.a;
        if (r57 == null) goto L195;
        String r415 = r57.j;
    L196:
        j29.a r58 = m3();
        if (r58 == null) goto L201;
        zp9.g r60 = r58.a;
        if (r60 == null) goto L201;
        String r510 = r60.d;
    L202:
        UserCreation r61 = p3();
        if (r61 == null) goto L207;
        Long r62 = r61.f;
        if (r62 == null) goto L207;
        Integer r511 = Integer.valueOf((int) r62.longValue());
    L208:
        UserCreation r63 = p3();
        if (r63 == null) goto L213;
        UserCreationTrackParams r64 = r63.n;
        if (r64 == null) goto L213;
        Integer r512 = r64.b;
    L214:
        j29.a r65 = m3();
        if (r65 == null) goto L219;
        zp9.g r66 = r65.a;
        if (r66 == null) goto L219;
        String r314 = r66.c;
    L220:
        UserCreation r67 = p3();
        if (r67 == null) goto L225;
        AuthorInfo r68 = r67.g;
        if (r68 == null) goto L225;
        String r513 = r68.b;
    L226:
        j29.a r70 = m3();
        if (r70 == null) goto L231;
        zp9.g r71 = r70.a;
        if (r71 == null) goto L231;
        String r72 = r71.i;
    L232:
        UserCreation r73 = p3();
        if (r73 == null) goto L235;
        String r74 = r73.a;
    L236:
        com.larus.bmhome.share.panel.h r75 = new com.larus.bmhome.share.panel.h(null, null, r310, r311, r313, r314, null, null, null, r312, r410, r411, r412, r413, r414, null, null, r415, Boolean.FALSE, null, null, null, r512, r511, r513, r510, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r72, r74, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -253360249, -5121, 1023);
        UserCreation r132 = p3();
        if (r132 == null) goto L243;
        UserCreationContent r133 = r132.e;
        if (r133 == null) goto L243;
        VideoUserContent r134 = r133.e;
        if (r134 == null) goto L243;
        ImageInfo r135 = r134.b;
    L244:
        UserCreationContent r136 = r1.e;
        if (r136 == null) goto L247;
        VideoUserContent r137 = r136.e;
    L248:
        if (r137 == null) goto L250;
        ImageInfo r138 = r137.b;
    L251:
        FLogger r139 = FLogger.a;
        StringBuilder r76 = new StringBuilder("share video cover source, creationId=");
        r76.append(r1.a);
        r76.append(", resourceUri=");
        CreationNoWatermarkManager.a.getClass();
        r76.append(CreationNoWatermarkManager.u0(r135));
        r76.append(", originUrl=");
        if (r135 == null) goto L254;
        Image r140 = r135.c;
    L255:
        String r141 = E3(r140);
        if (r141 != null) goto L261;
        if (r135 == null) goto L259;
        Image r142 = r135.a;
    L260:
        r141 = E3(r142);
        goto L261
    L259:
        r142 = null;
    L261:
        r76.append(r141);
        r76.append(", selectedPreviewUrl=");
        if (r138 == null) goto L264;
        Image r143 = r138.c;
    L265:
        r76.append(E3(r143));
        r76.append(", selectedDownloadUrl=");
        if (r138 == null) goto L268;
        Image r144 = r138.a;
    L269:
        r76.append(E3(r144));
        r139.i("CreationDetailTopToolsComponent", r76.toString());
        nr9.g r77 = D3(r1);
        StringBuilder r145 = new StringBuilder("share video resource, creationId=");
        r145.append(r1.a);
        r145.append(", vid=");
        if (r77 == null) goto L272;
        String r146 = r77.a;
    L273:
        r145.append(r146);
        r145.append(", downloadUrl=");
        if (r77 == null) goto L276;
        String r147 = r77.c;
    L277:
        r145.append(r147);
        r145.append(", filehash=");
        if (r77 == null) goto L280;
        String r148 = r77.d;
    L281:
        r145.append(r148);
        r145.append(", coverUrl=");
        if (r77 == null) goto L286;
        nr9.f r149 = r77.g;
        if (r149 == null) goto L286;
        String r150 = r149.b;
    L287:
        r145.append(r150);
        r145.append(", coverSize=");
        if (r77 == null) goto L292;
        nr9.f r151 = r77.g;
        if (r151 == null) goto L292;
        Integer r152 = r151.e;
    L293:
        r145.append(r152);
        r145.append('x');
        if (r77 == null) goto L298;
        nr9.f r153 = r77.g;
        if (r153 == null) goto L298;
        Integer r154 = r153.d;
    L299:
        r145.append(r154);
        r139.i("CreationDetailTopToolsComponent", r145.toString());
        a5 r155 = z2.a.getCreationShareSettings().c();
        if (r155 != null) goto L302;
    L304:
        boolean r156 = false;
    L305:
        if (r156 == false) goto L313;
        List r78 = CollectionsKt.listOf(new Integer[]{6, 7, 10, 11, 12});
        UserCreation r80 = p3();
        if (r80 == null) goto L309;
        Integer r157 = Integer.valueOf(r80.b);
    L311:
        if (CollectionsKt.contains(r78, r157) == false) goto L313;
        boolean r81 = true;
    L314:
        if (r81 == false) goto L415;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r82 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getFragmentManager();
        if (r82 == null) goto L437;
        IVideoShareService r514 = (IVideoShareService) ServiceManager.get().getService(IVideoShareService.class);
        if (r514 == null) goto L331;
        View r515 = F2();
        LifecycleCoroutineScope r516 = LifecycleOwnerKt.getLifecycleScope(this);
        com.larus.common_ui.dialog.l0 r517 = (com.larus.common_ui.dialog.l0) this.v.getValue();
        CreationDynamicInfo r83 = r1.h;
        if (r83 == null) goto L325;
        String r84 = r83.d;
        if (r84 == null) goto L325;
        String r610 = r84;
    L326:
        ShareScene r611 = ShareScene.VIDEO_VIEWER;
        c4 r612 = new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383);
        String r85 = r1.a;
        if (r85 != null) goto L329;
        String r613 = "";
    L330:
        String r86 = null;
        com.larus.bmhome.share.panel.d r710 = IVideoShareService.a.a(r514, r515, r516, r517, r77, r610, r611, r75, r612, r613, IUgcAIGCService.a.B(r1, null), 768);
    L332:
        ICommunityService.Companion r87 = ICommunityService.a;
        if (r77 == null) goto L337;
        nr9.f r158 = r77.g;
        if (r158 == null) goto L337;
        String r159 = r158.b;
    L338:
        String r711 = String.valueOf(r159);
        if (r77 == null) goto L344;
        String r160 = r77.c;
        if (r160 == null) goto L344;
        String r712 = r160;
    L345:
        UserCreation r161 = p3();
        if (r161 == null) goto L350;
        AuthorInfo r162 = r161.g;
        if (r162 == null) goto L350;
        String r163 = r162.b;
    L352:
        if (Intrinsics.areEqual(r163, AccountService.a.getUserId()) == false) goto L379;
        UserCreation r164 = p3();
        if (r164 == null) goto L358;
        UserCreationRefContent r165 = r164.o;
        if (r165 == null) goto L358;
        boolean r166 = Intrinsics.areEqual(r165.b, Boolean.TRUE);
    L359:
        if (r166 == true) goto L379;
        UserCreation r167 = p3();
        if (r167 != null) goto L363;
    L365:
        r41 = false;
    L366:
        if (r41 == true) goto L379;
        UserCreation r88 = p3();
        if (r88 == null) goto L379;
        UserCreationRefContent r90 = r88.o;
        if (r90 == null) goto L379;
        List r91 = r90.a();
        if (r91 == null) goto L379;
        ImageInfo r92 = (ImageInfo) ListProtector.get(r91, 0);
        if (r92 == null) goto L379;
        Image r93 = r92.c;
        if (r93 == null) goto L379;
        String r713 = r93.a;
    L380:
        if (r77 == null) goto L384;
        Double r94 = r77.e;
        if (r94 == null) goto L384;
        int r810 = (int) r94.doubleValue();
    L385:
        if (r77 == null) goto L387;
        String r811 = r77.d;
    L388:
        ShareScene r812 = ShareScene.VIDEO_VIEWER;
        UserCreation r95 = p3();
        if (r95 == null) goto L391;
        String r714 = r95.a;
    L392:
        long r168 = -1;
        if (r77 == null) goto L399;
        nr9.f r96 = r77.g;
        if (r96 == null) goto L399;
        Integer r97 = r96.e;
        if (r97 == null) goto L399;
        long r813 = r97.intValue();
    L400:
        if (r77 == null) goto L406;
        nr9.f r98 = r77.g;
        if (r98 == null) goto L406;
        Integer r100 = r98.d;
        if (r100 == null) goto L406;
        r168 = r100.intValue();
    L406:
        long r814 = r168;
        UserCreation r101 = p3();
        if (r101 == null) goto L409;
        String r169 = r101.a;
    L410:
        sq9.i r102 = new sq9.i("share", r86, r169, 2);
        Map r815 = IUgcAIGCService.a.B(r1, r86);
        if (r77 == null) goto L413;
        String r910 = r77.a;
    L414:
        r87.Z0(r82, new sq9.j(r714, r711, r712, null, r713, r710, r75, r812, r813, r814, r102, r815, r810, r811, null, r910, null, 81920));
        Unit r103 = Unit.INSTANCE;
        return;
    L413:
        r910 = r86;
        goto L414
    L409:
        r169 = r86;
    L399:
        r813 = -1;
        goto L400
    L391:
        r714 = r86;
        goto L392
    L387:
        r811 = r86;
    L384:
        r810 = 0;
        goto L385
    L363:
        if (zp9.d.f(r167) != true) goto L365;
    L358:
        r166 = false;
    L379:
        r713 = r86;
    L350:
        r163 = r86;
    L344:
        r712 = "";
    L337:
        r159 = r86;
        goto L338
    L329:
        r613 = r85;
    L325:
        r610 = "";
        goto L326
    L331:
        r86 = null;
        r710 = null;
        goto L332
    L437:
        return;
    L415:
        IVideoShareService r518 = (IVideoShareService) ServiceManager.get().getService(IVideoShareService.class);
        if (r518 == null) goto L439;
        View r519 = F2();
        LifecycleCoroutineScope r520 = LifecycleOwnerKt.getLifecycleScope(this);
        com.larus.common_ui.dialog.l0 r521 = (com.larus.common_ui.dialog.l0) this.v.getValue();
        CreationDynamicInfo r104 = r1.h;
        if (r104 == null) goto L423;
        String r106 = r104.d;
        if (r106 == null) goto L423;
        String r614 = r106;
    L424:
        ShareScene r615 = ShareScene.VIDEO_VIEWER;
        c4 r616 = new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383);
        String r107 = r1.a;
        if (r107 != null) goto L427;
        String r617 = "";
    L428:
        IVideoShareService.a.b(r518, r519, r520, r521, r77, r614, r615, r75, r616, r617, IUgcAIGCService.a.B(r1, null), null, 2304);
        Unit r108 = Unit.INSTANCE;
        return;
    L427:
        r617 = r107;
    L423:
        r614 = "";
        goto L424
    L439:
        return;
    L309:
        r157 = null;
    L313:
        r81 = false;
        goto L314
    L302:
        if (r155.a() != true) goto L304;
        r156 = true;
    L298:
        r154 = null;
    L292:
        r152 = null;
    L286:
        r150 = null;
        goto L287
    L280:
        r148 = null;
        goto L281
    L276:
        r147 = null;
        goto L277
    L272:
        r146 = null;
        goto L273
    L268:
        r144 = null;
        goto L269
    L264:
        r143 = null;
        goto L265
    L254:
        r140 = null;
        goto L255
    L250:
        r138 = null;
        goto L251
    L247:
        r137 = null;
    L243:
        r135 = null;
        goto L244
    L235:
        r74 = null;
    L231:
        r72 = null;
    L225:
        r513 = null;
    L219:
        r314 = null;
    L213:
        r512 = null;
    L207:
        r511 = null;
    L201:
        r510 = null;
    L195:
        r415 = null;
    L189:
        r414 = null;
        goto L190
    L183:
        r413 = null;
        goto L184
    L179:
        r412 = null;
        goto L180
    L175:
        r411 = null;
        goto L176
    L171:
        r410 = null;
    L167:
        r313 = null;
        goto L168
    L159:
        if (r46.b != 3) goto L161;
        r312 = true;
    L155:
        r311 = null;
    L149:
        r310 = null;
        goto L150
    L429:
        FLogger r109 = FLogger.a;
        StringBuilder r170 = new StringBuilder("doShareAction: ");
        UserCreation r171 = p3();
        if (r171 == null) goto L432;
        Integer r172 = Integer.valueOf(r171.b);
    L433:
        r170.append(r172);
        r109.i("CreationDetailTopToolsComponent", r170.toString());
        return;
    L432:
        r172 = null;
        goto L433
    L133:
        r215 = null;
    L129:
        r214 = null;
        goto L130
    L123:
        r213 = null;
    L119:
        r212 = null;
    L113:
        r211 = null;
    L107:
        r210 = null;
    L101:
        r121 = null;
    L95:
        r118 = null;
        goto L96
    L89:
        r38 = null;
    L85:
        r115 = null;
    L79:
        r114 = null;
    L73:
        r113 = null;
    L67:
        r112 = null;
    L61:
        r111 = null;
    L55:
        r110 = null;
    L49:
        r23 = null;
    L43:
        r20 = null;
    L37:
        r16 = null;
        goto L38
    L31:
        r13 = null;
        goto L32
    L27:
        r11 = null;
        goto L28
    L23:
        r9 = null;
        goto L24
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y2(CreationDetailTopToolsView r2) {
        if (X3(r2, true).a == true) goto L8;
        if (this.q != r2) goto L12;
        W3();
        return;
    L12:
        return;
    L8:
        if (this.q == r2) goto L14;
        W3();
        this.q = r2;
        r2.addOnLayoutChangeListener(this.r);
        ViewCompat.setOnApplyWindowInsetsListener(r2, new l(this));
        ViewCompat.requestApplyInsets(r2);
        return;
    }

    public final void Z3(UserCreation r9) {
        int r0 = e29.d.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r3 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        String r5 = AccountService.a.getUserId();
        CreationDetailTopToolsComponent$updateHostOwnerMenu$1 r6 = new CreationDetailTopToolsComponent$updateHostOwnerMenu$1(this);
        CreationDetailTopToolsComponent$updateHostOwnerMenu$2 r7 = new CreationDetailTopToolsComponent$updateHostOwnerMenu$2(this);
        Intrinsics.checkNotNullParameter(this, "owner");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r6, "onSetPrivate");
        Intrinsics.checkNotNullParameter(r7, "onDelete");
        ICommunityHostBehaviorProvider r1 = e29.d.c();
        if (r1 == null) goto L6;
        r1.m(this, r3, r9, r5, r6, r7);
        return;
    }

    public final void j3(String r27) {
        if (this.s > 0) goto L5;
        return;
    L5:
        long r1 = SystemClock.elapsedRealtime() - this.s;
        this.s = 0;
        Long r24 = Long.valueOf(r1);
        j29.a r2 = m3();
        if (r2 == null) goto L10;
        zp9.g r3 = r2.a;
        if (r3 == null) goto L10;
        String r16 = r3.c;
    L11:
        j29.a r4 = m3();
        if (r4 == null) goto L16;
        zp9.g r5 = r4.a;
        if (r5 == null) goto L16;
        String r6 = r5.j;
    L17:
        UserCreation r7 = p3();
        if (r7 == null) goto L20;
        String r8 = r7.a;
    L21:
        UserCreation r9 = p3();
        if (r9 == null) goto L24;
        String r10 = zp9.d.d(r9);
    L25:
        UserCreation r11 = p3();
        if (r11 == null) goto L28;
        String r12 = zp9.d.b(r11);
    L29:
        UserCreation r13 = p3();
        if (r13 == null) goto L34;
        AuthorInfo r14 = r13.g;
        if (r14 == null) goto L34;
        String r15 = r14.b;
    L35:
        UserCreation r17 = p3();
        if (r17 == null) goto L40;
        UserCreationTrackParams r18 = r17.n;
        if (r18 == null) goto L40;
        Integer r110 = r18.b;
    L41:
        UserCreation r20 = p3();
        if (r20 == null) goto L46;
        Long r21 = r20.f;
        if (r21 == null) goto L46;
        Integer r111 = Integer.valueOf((int) r21.longValue());
    L47:
        j29.a r22 = m3();
        if (r22 == null) goto L52;
        zp9.g r23 = r22.a;
        if (r23 == null) goto L52;
        String r25 = r23.f;
    L53:
        j29.a r26 = m3();
        if (r26 == null) goto L58;
        zp9.g r28 = r26.a;
        if (r28 == null) goto L58;
        String r112 = r28.a;
    L59:
        j29.a r30 = m3();
        if (r30 == null) goto L64;
        zp9.g r31 = r30.a;
        if (r31 == null) goto L64;
        String r113 = r31.h;
    L65:
        j29.a r32 = m3();
        if (r32 == null) goto L70;
        zp9.g r33 = r32.a;
        if (r33 == null) goto L70;
        String r210 = r33.d;
    L71:
        UserCreation r34 = p3();
        if (r34 == null) goto L76;
        UserCreationTrackParams r35 = r34.n;
        if (r35 == null) goto L76;
        String r114 = r35.d;
    L77:
        UserCreation r36 = p3();
        if (r36 == null) goto L82;
        UserCreationTrackParams r37 = r36.n;
        if (r37 == null) goto L82;
        String r115 = r37.e;
    L83:
        UserCreation r38 = p3();
        if (r38 == null) goto L88;
        UserCreationTrackParams r40 = r38.n;
        if (r40 == null) goto L88;
        String r116 = r40.f;
    L89:
        UserCreation r41 = p3();
        if (r41 == null) goto L94;
        UserCreationTrackParams r42 = r41.n;
        if (r42 == null) goto L94;
        String r117 = r42.a;
    L95:
        j29.a r43 = m3();
        if (r43 == null) goto L100;
        zp9.g r44 = r43.a;
        if (r44 == null) goto L100;
        String r211 = r44.i;
    L101:
        x2.a(r6, r8, r10, r12, r15, null, r110, r117, r114, r116, r115, r16, r113, r112, r111, r25, r210, r27, r211, r24, 32);
        return;
    L100:
        r211 = null;
    L94:
        r117 = null;
    L88:
        r116 = null;
    L82:
        r115 = null;
    L76:
        r114 = null;
    L70:
        r210 = null;
    L64:
        r113 = null;
    L58:
        r112 = null;
    L52:
        r25 = null;
    L46:
        r111 = null;
    L40:
        r110 = null;
    L34:
        r15 = null;
        goto L35
    L28:
        r12 = null;
        goto L29
    L24:
        r10 = null;
        goto L25
    L20:
        r8 = null;
    L16:
        r6 = null;
    L10:
        r16 = null;
        goto L11
    }

    public final void onViewCreated(View r15) {
        Intrinsics.checkNotNullParameter(r15, "view");
        UserCreation r16 = p3();
        if (r16 == null) goto L14;
        Object r1 = F2();
        if ((r1 instanceof CreationDetailTopToolsView) == false) goto L7;
        CreationDetailTopToolsView r2 = (CreationDetailTopToolsView) r1;
    L8:
        if (r2 == null) goto L11;
        Y2(r2);
        r2.S5(r16);
        r2.R5(new com.larus.community.impl.detail.toptools.b(this), new com.larus.community.impl.detail.toptools.d(this), new com.larus.community.impl.detail.toptools.e(this), new f(this));
    L11:
        if (Q3() == false) goto L13;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailTopToolsComponent$prefetchToCreationBitmapCache$1(this, null), 3, null);
    L13:
        Z3(r16);
        return;
    L7:
        r2 = null;
        goto L8
    L14:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailTopToolsComponent$initObserver$1(this, null), 3, null);
    }

    public final void G3(ImageInfo r810, UserCreation r90) {
        String r2 = r90.a;
        String r3 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r4 = E3(r810.c);
        if (r4 != null) goto L10;
        r4 = E3(r810.a);
        if (r4 != null) goto L10;
        String r7 = "";
    L11:
        String r5 = E3(r810.a);
        if (r5 != null) goto L16;
        r5 = E3(r810.c);
        if (r5 != null) goto L16;
    L17:
        AuthorInfo r6 = r90.g;
        if (r6 == null) goto L20;
        String r8 = r6.b;
    L21:
        AccountService r9 = AccountService.a;
        if (Intrinsics.areEqual(r8, r9.getUserId()) == true) goto L24;
    L26:
        boolean r10 = false;
    L27:
        if (r10 == false) goto L29;
        String r11 = r3;
    L30:
        FLogger.a.i("CreationDetailTopToolsComponent", "share image resource, creationId=" + r2 + ", previewUrl=" + r7 + ", downloadUrl=" + r3 + ", rawImageUrl=" + r11);
        Context r12 = getContext();
        j29.a r13 = m3();
        if (r13 == null) goto L35;
        zp9.g r14 = r13.a;
        if (r14 == null) goto L35;
        String r16 = r14.h;
    L36:
        j29.a r15 = m3();
        if (r15 == null) goto L41;
        zp9.g r17 = r15.a;
        if (r17 == null) goto L41;
        String r18 = r17.a;
    L42:
        UserCreation r110 = p3();
        if (r110 != null) goto L45;
    L47:
        boolean r23 = false;
    L48:
        j29.a r111 = m3();
        if (r111 == null) goto L53;
        zp9.g r112 = r111.a;
        if (r112 == null) goto L53;
        String r113 = r112.f;
    L54:
        UserCreation r114 = p3();
        if (r114 == null) goto L57;
        Integer r24 = Integer.valueOf(r114.b);
    L58:
        UserCreation r115 = p3();
        if (r115 == null) goto L61;
        String r25 = r115.a;
    L62:
        UserCreation r116 = p3();
        if (r116 == null) goto L65;
        String r26 = zp9.d.d(r116);
    L66:
        UserCreation r117 = p3();
        if (r117 == null) goto L69;
        String r27 = zp9.d.b(r117);
    L70:
        UserCreation r118 = p3();
        if (r118 == null) goto L75;
        UserCreationTrackParams r119 = r118.n;
        if (r119 == null) goto L75;
        String r28 = r119.a;
    L76:
        j29.a r120 = m3();
        if (r120 == null) goto L81;
        zp9.g r121 = r120.a;
        if (r121 == null) goto L81;
        String r31 = r121.j;
    L82:
        j29.a r122 = m3();
        if (r122 == null) goto L87;
        zp9.g r123 = r122.a;
        if (r123 == null) goto L87;
        String r310 = r123.d;
    L88:
        UserCreation r124 = p3();
        if (r124 == null) goto L93;
        Long r125 = r124.f;
        if (r125 == null) goto L93;
        Integer r37 = Integer.valueOf((int) r125.longValue());
    L94:
        UserCreation r126 = p3();
        if (r126 == null) goto L99;
        UserCreationTrackParams r127 = r126.n;
        if (r127 == null) goto L99;
        Integer r36 = r127.b;
    L100:
        j29.a r128 = m3();
        if (r128 == null) goto L105;
        zp9.g r129 = r128.a;
        if (r129 == null) goto L105;
        String r130 = r129.c;
    L106:
        UserCreation r131 = p3();
        if (r131 == null) goto L111;
        AuthorInfo r132 = r131.g;
        if (r132 == null) goto L111;
        String r38 = r132.b;
    L112:
        j29.a r133 = m3();
        if (r133 == null) goto L117;
        zp9.g r134 = r133.a;
        if (r134 == null) goto L117;
        String r54 = r134.i;
    L118:
        UserCreation r135 = p3();
        if (r135 == null) goto L121;
        String r55 = r135.a;
    L122:
        com.larus.bmhome.share.panel.h r136 = new com.larus.bmhome.share.panel.h(null, null, r16, r18, r113, r130, null, null, null, r23, r24, r25, r26, r27, r28, null, null, r31, Boolean.FALSE, null, null, null, r36, r37, r38, r310, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r54, r55, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -253360249, -5121, 1023);
        if (Q3() == false) goto L206;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r20 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getFragmentManager();
        if (r20 == null) goto L236;
        ICommunityService.Companion r137 = ICommunityService.a;
        UserCreation r138 = p3();
        if (r138 == null) goto L131;
        AuthorInfo r139 = r138.g;
        if (r139 == null) goto L131;
        String r140 = r139.b;
    L133:
        if (Intrinsics.areEqual(r140, r9.getUserId()) == false) goto L160;
        UserCreation r21 = p3();
        if (r21 == null) goto L139;
        UserCreationRefContent r22 = r21.o;
        if (r22 == null) goto L139;
        boolean r30 = Intrinsics.areEqual(r22.b, Boolean.TRUE);
    L140:
        if (r30 == true) goto L160;
        UserCreation r32 = p3();
        if (r32 != null) goto L144;
    L146:
        boolean r33 = false;
    L147:
        if (r33 == true) goto L160;
        UserCreation r34 = p3();
        if (r34 == null) goto L160;
        UserCreationRefContent r35 = r34.o;
        if (r35 == null) goto L160;
        List r40 = r35.a();
        if (r40 == null) goto L160;
        ImageInfo r41 = (ImageInfo) ListProtector.get(r40, 0);
        if (r41 == null) goto L160;
        Image r42 = r41.c;
        if (r42 == null) goto L160;
        String r141 = r42.a;
    L161:
        ShareScene r142 = ShareScene.IMAGE_VIEWER_REPORT;
        UserCreation r43 = p3();
        if (r43 == null) goto L164;
        String r44 = r43.a;
    L165:
        Image r45 = r810.a;
        if (r45 == null) goto L169;
        String r143 = r44;
        long r46 = r45.c;
    L168:
        long r210 = r46;
    L173:
        if (r45 == null) goto L175;
        long r47 = r45.d;
    L178:
        long r211 = r47;
    L180:
        UserCreation r48 = p3();
        if (r48 == null) goto L183;
        String r50 = r48.a;
    L184:
        sq9.i r144 = new sq9.i("share", null, r50, 2);
        Map r145 = IUgcAIGCService.a.H(r90, null);
        Image r51 = r810.a;
        if (r51 == null) goto L188;
        String r52 = r51.e;
        if (r52 == null) goto L188;
    L204:
        String r212 = r52;
    L205:
        r137.Z0(r20, new sq9.j(r143, r7, r3, r11, r141, null, r136, r142, r210, r211, r144, r145, 0, null, null, null, r212, 61472));
        Unit r1 = Unit.INSTANCE;
        return;
    L188:
        Image r53 = r810.c;
        if (r53 == null) goto L191;
        r52 = r53.e;
    L192:
        if (r52 != null) goto L204;
        Image r56 = r810.b;
        if (r56 == null) goto L196;
        r52 = r56.e;
    L197:
        if (r52 != null) goto L204;
        Image r57 = r810.i;
        if (r57 == null) goto L201;
        r52 = r57.e;
    L202:
        if (r52 != null) goto L204;
        r212 = r810.e;
        goto L205
    L201:
        r52 = null;
        goto L202
    L196:
        r52 = null;
        goto L197
    L191:
        r52 = null;
        goto L192
    L183:
        r50 = null;
        goto L184
    L175:
        Image r58 = r810.c;
        if (r58 == null) goto L179;
        r47 = r58.d;
        goto L178
    L179:
        r211 = -1;
        goto L180
    L169:
        r143 = r44;
        Image r60 = r810.c;
        if (r60 == null) goto L172;
        r46 = r60.c;
        goto L168
    L172:
        r210 = -1;
        goto L173
    L164:
        r44 = null;
        goto L165
    L144:
        if (r32.b != 3) goto L146;
        r33 = true;
    L139:
        r30 = false;
    L160:
        r141 = null;
    L131:
        r140 = null;
        goto L133
    L236:
        return;
    L206:
        IFlowSdkDepend r61 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r61 == null) goto L213;
        r61.D0();
        b1 r62 = b1.a;
        Image r63 = r810.a;
        if (r63 == null) goto L211;
        String r64 = r63.a;
    L212:
        r62.d(String.valueOf(r64));
        Unit r65 = Unit.INSTANCE;
        goto L213
    L211:
        r64 = null;
    L213:
        IUgcAIGCService.Companion r66 = IUgcAIGCService.a;
        ShareScene r67 = ShareScene.IMAGE_VIEWER_REPORT;
        a r68 = new a(r2);
        Image r70 = r810.a;
        if (r70 == null) goto L217;
        String r71 = r70.e;
        if (r71 == null) goto L217;
    L233:
        String r146 = r71;
    L234:
        IUgcAIGCService.a.d(r66, r12, r3, r67, r68, r136, null, r90, r146, 352);
        Unit r72 = Unit.INSTANCE;
        return;
    L217:
        Image r73 = r810.c;
        if (r73 == null) goto L220;
        r71 = r73.e;
    L221:
        if (r71 != null) goto L233;
        Image r74 = r810.b;
        if (r74 == null) goto L225;
        r71 = r74.e;
    L226:
        if (r71 != null) goto L233;
        Image r75 = r810.i;
        if (r75 == null) goto L230;
        r71 = r75.e;
    L231:
        if (r71 != null) goto L233;
        r146 = r810.e;
        goto L234
    L230:
        r71 = null;
        goto L231
    L225:
        r71 = null;
        goto L226
    L220:
        r71 = null;
        goto L221
    L121:
        r55 = null;
    L117:
        r54 = null;
    L111:
        r38 = null;
    L105:
        r130 = null;
    L99:
        r36 = null;
    L93:
        r37 = null;
    L87:
        r310 = null;
    L81:
        r31 = null;
    L75:
        r28 = null;
        goto L76
    L69:
        r27 = null;
        goto L70
    L65:
        r26 = null;
        goto L66
    L61:
        r25 = null;
        goto L62
    L57:
        r24 = null;
    L53:
        r113 = null;
        goto L54
    L45:
        if (r110.b != 3) goto L47;
        r23 = true;
    L41:
        r18 = null;
    L35:
        r16 = null;
        goto L36
    L29:
        r11 = E3(r810.i);
        goto L30
    L24:
        if (CreationNoWatermarkManager.a.D() == false) goto L26;
        r10 = true;
        goto L27
    L20:
        r8 = null;
    L16:
        r3 = r5;
    L10:
        r7 = r4;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e29.a X3(final CreationDetailTopToolsView r21, boolean r22) {
        int r2 = e29.d.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        e29.a r3 = e29.d.b(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        boolean r4 = r3.a;
        boolean r5 = r3.b;
        int r6 = r3.c;
        int r7 = r3.d;
        int r8 = r3.e;
        r21.b = r4;
        r21.d = r6;
        if (r4 == false) goto L10;
        if (r5 == false) goto L10;
        e1.o(r21.a.b);
        SimpleDraweeView r9 = r21.a.e;
        ViewGroup.LayoutParams r17 = r9.getLayoutParams();
        if (r17 == null) goto L9;
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r17;
        r12.startToEnd = -1;
        r12.startToStart = 0;
        r12.setMarginStart(r21.getResources().getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786)));
        r9.setLayoutParams(r12);
    L41:
        AppCompatImageView r10 = r21.a.b;
        Integer r11 = Integer.valueOf(r7);
        if (r11.intValue() == 0) goto L44;
        boolean r13 = true;
    L45:
        if (r13 == true) goto L48;
        r11 = null;
    L48:
        if (r11 == null) goto L50;
        int r14 = r11.intValue();
    L51:
        r10.setImageResource(r14);
        r21.a.b.setContentDescription(r21.getContext().getString(2131898805));
        AppCompatImageView r15 = r21.a.d;
        Integer r16 = Integer.valueOf(r8);
        if (r16.intValue() == 0) goto L54;
        boolean r18 = true;
    L55:
        if (r18 == true) goto L58;
        r16 = null;
    L58:
        if (r16 == null) goto L60;
        int r20 = r16.intValue();
    L61:
        r15.setImageResource(r20);
        AppCompatImageView r23 = r21.a.c;
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
        if (r24 == null) goto L88;
        ConstraintLayout.LayoutParams r25 = (ConstraintLayout.LayoutParams) r24;
        r25.setMarginEnd(r21.getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462)));
        r23.setLayoutParams(r25);
        AppCompatImageView r26 = r21.a.d;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        if (r27 == null) goto L86;
        ConstraintLayout.LayoutParams r28 = (ConstraintLayout.LayoutParams) r27;
        Resources r30 = r21.getResources();
        if (r4 == false) goto L68;
        int r31 = 2130971390;
        int r32 = 2131167150;
    L69:
        int r33 = r30.getDimensionPixelSize(v19.c.b(r31, null, r32));
        ((ViewGroup.MarginLayoutParams) r28).width = r33;
        ((ViewGroup.MarginLayoutParams) r28).height = r33;
        r26.setLayoutParams(r28);
        AppCompatTextView r34 = r21.a.f;
        ViewGroup.LayoutParams r35 = r34.getLayoutParams();
        if (r35 == null) goto L84;
        ConstraintLayout.LayoutParams r36 = (ConstraintLayout.LayoutParams) r35;
        if (r4 == false) goto L74;
        r36.endToStart = -1;
        r36.endToEnd = 0;
        r36.setMarginEnd(r21.getResources().getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786)) + r6);
    L75:
        r34.setLayoutParams(r36);
        r21.T5();
        if (r22 == true) goto L78;
    L82:
        return r3;
    L78:
        if (r3.a == false) goto L82;
        if (r3.c != 0) goto L82;
        r21.post(new com.larus.community.impl.detail.toptools.c(this, r21));
        goto L82
    L74:
        r36.endToEnd = -1;
        r36.endToStart = 2131386080;
        r36.setMarginEnd(r21.getResources().getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786)));
        goto L75
    L84:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L68:
        r31 = 2130971490;
        r32 = 2131167350;
        goto L69
    L86:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L88:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L60:
        r20 = 2131242872;
        goto L61
    L54:
        r18 = false;
        goto L55
    L50:
        r14 = 2131241477;
        goto L51
    L44:
        r13 = false;
        goto L45
    L9:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L10:
        e1.x(r21.a.b);
        AppCompatImageView r37 = r21.a.b;
        ViewGroup.LayoutParams r38 = r37.getLayoutParams();
        if (r38 == null) goto L92;
        ConstraintLayout.LayoutParams r40 = (ConstraintLayout.LayoutParams) r38;
        if (r4 == false) goto L16;
        if (r5 == true) goto L16;
        boolean r110 = true;
    L17:
        Resources r111 = r21.getResources();
        if (r110 == false) goto L20;
        int r112 = v19.c.b(2130971435, null, 2131167240);
    L21:
        int r113 = r111.getDimensionPixelSize(r112);
        ((ViewGroup.MarginLayoutParams) r40).width = r113;
        ((ViewGroup.MarginLayoutParams) r40).height = r113;
        Resources r114 = r21.getResources();
        if (r110 == false) goto L24;
        int r115 = v19.c.b(2130971163, null, 2131166696);
    L25:
        r40.setMarginStart(r114.getDimensionPixelSize(r115));
        r40.bottomToBottom = 0;
        r37.setLayoutParams(r40);
        SimpleDraweeView r41 = r21.a.e;
        ViewGroup.LayoutParams r42 = r41.getLayoutParams();
        if (r42 == null) goto L90;
        ConstraintLayout.LayoutParams r43 = (ConstraintLayout.LayoutParams) r42;
        r43.startToStart = -1;
        r43.startToEnd = 2131363779;
        if (r4 == false) goto L31;
        if (r5 == true) goto L31;
        boolean r116 = true;
    L32:
        Resources r44 = r21.getResources();
        if (r116 == false) goto L35;
        int r117 = v19.c.b(2130971390, null, 2131167150);
    L36:
        int r45 = r44.getDimensionPixelSize(r117);
        ((ViewGroup.MarginLayoutParams) r43).width = r45;
        ((ViewGroup.MarginLayoutParams) r43).height = r45;
        Resources r46 = r21.getResources();
        if (r116 == false) goto L39;
        int r118 = v19.c.b(2130971163, null, 2131166696);
    L40:
        r43.setMarginStart(r46.getDimensionPixelSize(r118));
        r41.setLayoutParams(r43);
        goto L41
    L39:
        r118 = v19.c.b(2130971135, null, 2131166641);
        goto L40
    L35:
        r117 = v19.c.b(2130971435, null, 2131167240);
    L31:
        r116 = false;
        goto L32
    L90:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L24:
        r115 = v19.c.b(2130971546, null, 2131167462);
        goto L25
    L20:
        r112 = v19.c.b(2130971490, null, 2131167350);
    L16:
        r110 = false;
        goto L17
    L92:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }
}
