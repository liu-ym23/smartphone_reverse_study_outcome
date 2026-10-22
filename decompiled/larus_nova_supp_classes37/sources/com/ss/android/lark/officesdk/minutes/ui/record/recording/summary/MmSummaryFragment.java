package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.f;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryStatus;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryViewType;
import com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MviBaseFragment;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmRecordingNavLayout;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmSummaryLoadingTextView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmViewPagerGestureArbiterLayout;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.g;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.h;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;
import mwb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000Å\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001;\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010=\u001a\u0002032\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J$\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u001a\u0010E\u001a\u0002032\u0006\u0010F\u001a\u00020*2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010G\u001a\u000203H\u0002J\b\u0010H\u001a\u000203H\u0002J\b\u0010I\u001a\u000203H\u0002J\b\u0010J\u001a\u000203H\u0002J%\u0010K\u001a\b\u0012\u0004\u0012\u0002030L2\u0006\u0010M\u001a\u00020*2\u0006\u0010N\u001a\u00020\tH\u0002¢\u0006\u0004\bO\u0010PJ\u0010\u0010Q\u001a\u0002032\u0006\u0010N\u001a\u00020\tH\u0002J\u0010\u0010R\u001a\u0002032\u0006\u0010N\u001a\u00020\tH\u0002J\u001a\u0010S\u001a\u0002032\u0006\u0010N\u001a\u00020\t2\b\b\u0002\u0010T\u001a\u00020\u001aH\u0002J\b\u0010U\u001a\u000203H\u0002J\b\u0010V\u001a\u000203H\u0002J\b\u0010W\u001a\u00020\u001aH\u0002J\b\u0010X\u001a\u000203H\u0002J\u0010\u0010Y\u001a\u0002032\u0006\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u000203H\u0016J\b\u0010]\u001a\u000203H\u0002J\b\u0010^\u001a\u000203H\u0002J\b\u0010_\u001a\u000203H\u0002J\b\u0010`\u001a\u000203H\u0002J\b\u0010a\u001a\u000203H\u0002J\b\u0010b\u001a\u000203H\u0002J\b\u0010c\u001a\u000203H\u0002J\u0010\u0010d\u001a\u0002032\u0006\u0010e\u001a\u00020fH\u0002J\u0010\u0010g\u001a\u0002032\u0006\u0010e\u001a\u00020fH\u0002J\b\u0010h\u001a\u000203H\u0002J\b\u0010i\u001a\u000203H\u0002J\b\u0010j\u001a\u000203H\u0002J\u0010\u0010k\u001a\u0002032\u0006\u0010e\u001a\u00020fH\u0002J\u0010\u0010l\u001a\u0002032\u0006\u0010e\u001a\u00020fH\u0002J\u0018\u0010p\u001a\u0002032\u0006\u0010q\u001a\u00020\u001a2\u0006\u0010r\u001a\u00020\tH\u0002J\u0010\u0010s\u001a\u0002032\u0006\u0010t\u001a\u00020!H\u0002J\b\u0010u\u001a\u000203H\u0002J\b\u0010v\u001a\u000203H\u0002J\b\u0010w\u001a\u000203H\u0002J\b\u0010x\u001a\u000203H\u0002J\u0010\u0010y\u001a\u0002032\u0006\u0010N\u001a\u00020\tH\u0002J\u0010\u0010z\u001a\u0002032\u0006\u0010N\u001a\u00020\tH\u0002J\u0010\u0010{\u001a\u0002032\u0006\u0010N\u001a\u00020\tH\u0002J\b\u0010|\u001a\u00020\u001aH\u0002J\u0010\u0010}\u001a\u0002032\u0006\u0010N\u001a\u00020\tH\u0002J\b\u0010~\u001a\u000203H\u0016J\b\u0010\u007f\u001a\u000203H\u0016J'\u0010\u0080\u0001\u001a\u0002032\u0006\u0010N\u001a\u00020\t2\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u001a2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u001aH\u0002J\t\u0010\u0083\u0001\u001a\u000203H\u0016J\u0011\u0010\u0084\u0001\u001a\u0002032\u0006\u0010N\u001a\u00020\tH\u0002J\u0013\u0010\u0085\u0001\u001a\u0002032\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0016J\u0012\u0010\u0088\u0001\u001a\u0002032\u0007\u0010\u0089\u0001\u001a\u00020\u001aH\u0014J\u0012\u0010\u008a\u0001\u001a\u0002032\u0007\u0010\u0089\u0001\u001a\u00020\u001aH\u0002R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u00058TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R&\u00100\u001a\u001a\u0012\u0004\u0012\u00020\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002030201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R \u00107\u001a\u0014\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020308X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0004\n\u0002\u0010<R\u0018\u0010m\u001a\u000209*\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bn\u0010o¨\u0006\u008b\u0001"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryFragment;", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/mvi/MviBaseFragment;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryVMState;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryVMEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryUIEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryViewModel;", "<init>", "()V", "logDetail", "", "getLogDetail", "()Ljava/lang/String;", "logDetail$delegate", "Lkotlin/Lazy;", "viewModel", "getViewModel", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryViewModel;", "viewModel$delegate", "_summaryView", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmSummaryFragmentView;", "summaryView", "getSummaryView", "()Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmSummaryFragmentView;", "textSelectionHelper", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/textselection/MmTextSelectionHelper;", "isAtBottom", "", "lastContentTimestamp", "", "hasPendingNewContent", "userScrollTracker", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryUserScrollTracker;", "lastTrackedViewType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSummaryViewType;", "viewPagerGestureArbiter", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmViewPagerGestureArbiterLayout;", "navLayout", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmRecordingNavLayout;", "markdownParseJob", "Lkotlinx/coroutines/Job;", "themeTransitionOverlayJob", "themeTransitionOverlay", "Landroid/view/View;", "quotaCtaView", "Lcom/ss/android/lark/officesdk/minutes/ui/style/contract/IMmRecordingQuotaCtaView;", "currentQuotaCtaBlocksContent", "fishBoneWebView", "nextFishBoneScrollRequestId", "pendingFishBoneScrollCallbacks", "", "Lkotlin/Function1;", "", "isSubtitleDegraded", "isSummaryContentBlocked", "()Z", "navLayoutScrollListener", "Lkotlin/Function2;", "", "pagingConflictChild", "com/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryFragment$pagingConflictChild$1", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryFragment$pagingConflictChild$1;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "initQuotaCtaView", "initFishBoneWebView", "subscribeViewModelEvents", "addWebViewSafely", "Lkotlin/Result;", "webView", "from", "addWebViewSafely-gIAlu-s", "(Landroid/view/View;Ljava/lang/String;)Ljava/lang/Object;", "showThemeTransitionOverlay", "removeThemeTransitionOverlay", "updateFishBoneWebVisibility", "forceNotify", "initTextSelection", "initListener", "isSummaryScrollTrackingEnabled", "subscribeData", "onAttach", "context", "Landroid/content/Context;", "onDetach", "subscribeRichContent", "subscribeViewTypeSwitchVisibility", "subscribeSummaryStatus", "subscribeWebReady", "subscribeCurrentTab", "subscribeContentGenerated", "subscribeQuotaCtaState", "applyQuotaCtaState", "state", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaUiState;", "applySummaryContentVisibilityForQuotaCta", "applySummaryContentVisibility", "hideSummaryContentForQuotaCta", "restoreSummaryContentAfterQuotaCta", "handleQuotaCtaClick", "handleQuotaCtaBenefitCenterClick", "dp", "getDp", "(I)I", "refreshBubbleVisibility", "showNewContentBubble", "source", "updateViewType", "viewType", "showTextLoading", "showTextContent", "showFishBoneLoading", "showFishBoneContent", "pauseAnimations", "resumeAnimationsIfNeeded", "resumeAnimations", "isScrollAtBottom", "scrollToBottom", "onPause", "onResume", "trackSummaryViewEvent", "isContentGenerated", "skipDuplicateCheck", "onDestroyView", "removeFishBoneWebContainerChildrenSafely", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDarkModeChanged", "isDarkMode", "applyFishBoneTheme", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmSummaryFragment extends MviBaseFragment<e, d, com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.b, MmSummaryViewModel> {
    public static final /* synthetic */ int F = 0;
    public long A;
    public final Map<Long, Function1<Boolean, Unit>> B;
    public boolean C;
    public final Function2<Integer, Integer, Unit> D;
    public final a E;
    public final Lazy k;
    public final Lazy l;
    public l m;
    public awb.c n;
    public boolean o;
    public long p;
    public boolean q;
    public final c r;
    public MmSummaryViewType s;
    public MmViewPagerGestureArbiterLayout t;
    public MmRecordingNavLayout u;
    public Job v;
    public Job w;
    public View x;
    public boolean y;
    public View z;

    public static final class a implements MmViewPagerGestureArbiterLayout.a {
        public final /* synthetic */ MmSummaryFragment a;

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmViewPagerGestureArbiterLayout.a
        public final boolean isActive() {
            MmRecordingUITab r0 = this.a.ha0().getMainViewModel().getState().q;
            e r1 = this.a.ha0().getState();
            if (this.a.isResumed() == true) goto L5;
        L11:
            return false;
        L5:
            if (r0.isInSummary() == false) goto L11;
            if (r1.c.isFishBone() == false) goto L11;
            if (this.a.ja0() == true) goto L11;
            return true;
        }

        public a(MmSummaryFragment r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmViewPagerGestureArbiterLayout.a
        public final void a(MmViewPagerGestureArbiterLayout.ScrollDirection r7, int r8, int r9, Function1<? super Boolean, Unit> r10) {
            Intrinsics.checkNotNullParameter(r7, "direction");
            Intrinsics.checkNotNullParameter(r10, "callback");
            if (this.a.z != null) goto L6;
            int r0 = bwb.b.a;
            bwb.b.h(MmUiLogScene.SUMMARY, "pagingConflictChild.canScroll", "webView is null, direction=" + r7 + ", x=" + r8 + ", y=" + r9, this.a.U90());
            r10.invoke(Boolean.FALSE);
            return;
        L6:
            MmViewPagerGestureArbiterLayout.ScrollDirection r1 = MmViewPagerGestureArbiterLayout.ScrollDirection.Left;
            if (r7 != r1) goto L9;
            String r11 = MmViewPagerGestureArbiterLayout.ScrollDirection.Right.getRawValue();
        L10:
            String r3 = r11;
            int r4 = UIHelper.px2dp(r8);
            int r5 = UIHelper.px2dp(r9);
            MmSummaryFragment r12 = this.a;
            long r2 = r12.A + 1;
            r12.A = r2;
            this.a.B.put(Long.valueOf(r2), r10);
            this.a.ha0().dispatchEvent(new com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.b.e(r2, r3, r4, r5));
            return;
        L9:
            r11 = r1.getRawValue();
            goto L10
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MmSummaryFragment a;
        public final /* synthetic */ String b;

        public final void a() {
            MmSummaryFragment r0 = this.a;
            l r1 = r0.m;
            if (r1 == null) goto L10;
            String r2 = this.b;
            r1.c.fullScroll(130);
            boolean r3 = MmSummaryFragment.da0(r0);
            int r4 = bwb.b.a;
            bwb.b.f(MmUiLogScene.SUMMARY, "scrollToBottom", "from=" + r2 + ", isScrollAtBottom=" + r3, r0.U90());
            if (r3 == true) goto L7;
            r1.c.postDelayed(this, 50);
            return;
        L7:
            c r5 = r0.r;
            int r6 = r5.c;
            if (r6 <= 0) goto L15;
            r5.c = r6 - 1;
            return;
        L15:
            return;
        L10:
            c r7 = r0.r;
            int r8 = r7.c;
            if (r8 <= 0) goto L17;
            r7.c = r8 - 1;
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(MmSummaryFragment r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final String U90() {
        return (String) this.k.getValue();
    }

    public final l ga0() {
        l r0 = this.m;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Summary view is not created".toString());
    }

    public final MmSummaryViewModel ha0() {
        return (MmSummaryViewModel) this.l.getValue();
    }

    public final boolean ja0() {
        if (this.y == false) goto L5;
    L8:
        return true;
    L5:
        if (this.C == true) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onDestroyView() {
        c r0 = this.r;
        r0.c = 0;
        r0.d = false;
        r0.b.removeCallbacks(r0.e);
        Job r1 = this.v;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        this.v = null;
        MmRecordingNavLayout r2 = this.u;
        if (r2 == null) goto L8;
        Function2<Integer, Integer, Unit> r4 = this.D;
        Intrinsics.checkNotNullParameter(r4, "listener");
        r2.t.remove(r4);
    L8:
        this.u = null;
        MmViewPagerGestureArbiterLayout r3 = this.t;
        if (r3 == null) goto L11;
        int r5 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "clearPagingConflictChild", "tag=" + r3.e, null, 8);
        r3.e = "unset";
        r3.d = null;
        r3.b(false, "clearPagingConflictChild");
        r3.a();
    L11:
        this.t = null;
        Iterator r6 = CollectionsKt.toList(((LinkedHashMap) this.B).values()).iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        ((Function1) r6.next()).invoke(Boolean.FALSE);
        goto L13
    L15:
        ((LinkedHashMap) this.B).clear();
        Job r7 = this.w;
        if (r7 == null) goto L18;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L18:
        this.w = null;
        ma0("onDestroyView");
        ga0().k.removeAllViews();     // Catch: RuntimeException -> L21
    L23:
        this.z = null;
        ha0().dispatchEvent(new com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.b.d("onDestroyView"));
        awb.c r8 = this.n;
        if (r8 == null) goto L26;
        r8.c.removeCallbacks(r8.f);
        r8.a.setTextIsSelectable(false);
        r8.a.setCustomSelectionActionModeCallback(null);
        r8.c.removeCallbacks(r8.f);
    L26:
        this.n = null;
        super.onDestroyView();
        this.m = null;
        return;
    L21:
        e = move-exception;
        int r9 = bwb.b.a;
        bwb.b.d(MmUiLogScene.SUMMARY, "removeFishBoneWebContainerChildrenSafely", "removeAllViews failed, from=onDestroyView, error=" + e.getClass().getSimpleName() + ": " + e.getMessage(), U90());
        ha0().dispatchEvent(new com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.b.f(null, false, "remove_all_views_failed_onDestroyView", e));
        goto L23
    }

    public MmSummaryFragment() {
        this.k = LazyKt.lazy(new MmSummaryFragment$logDetail$2(this));
        this.l = LazyKt.lazy(new MmSummaryFragment$viewModel$2(this));
        this.o = true;
        this.r = new c(new MmSummaryFragment$userScrollTracker$1(this));
        this.B = new LinkedHashMap();
        this.D = new MmSummaryFragment$navLayoutScrollListener$1(this);
        this.E = new a(this);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MviBaseFragment
    public final /* bridge */ /* synthetic */ com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.a Z90() {
        return ha0();
    }

    public final void ia0() {
        ga0().b.setVisibility(8);
        ga0().j.setVisibility(8);
        ga0().l.setVisibility(8);
        ga0().f.setVisibility(8);
        ta0("quota_cta_block", false);
        ka0("quota_cta_block");
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onDetach() {
        ha0().dispatchEvent(new com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.b.d("onDetach"));
        super.onDetach();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onPause() {
        super.onPause();
        ha0().dispatchEvent(new com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.b.a(false));
        ta0("onPause", false);
        ka0("app_background");
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onResume() {
        super.onResume();
        ha0().dispatchEvent(new com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.b.a(true));
        ta0("onResume", false);
        oa0("app_foreground");
        sa0(this, "onResume", false, true, 2);
    }

    public final void qa0() {
        if (ja0() == false) goto L6;
        ia0();
        return;
    L6:
        l r0 = ga0();
        r0.h.setVisibility(8);
        r0.j.setVisibility(8);
        r0.b.setVisibility(0);
        r0.c.setVisibility(0);
        r0.e.setVisibility(0);
        na0("show_text_content");
    }

    public final void ra0() {
        if (ja0() == false) goto L6;
        ia0();
        return;
    L6:
        l r0 = ga0();
        r0.h.setVisibility(0);
        r0.b.setVisibility(0);
        r0.c.setVisibility(8);
        r0.j.setVisibility(8);
        r0.e.setVisibility(8);
        ka0("show_text_loading");
    }

    public static final boolean da0(MmSummaryFragment r3) {
        l r4 = r3.m;
        if (r4 == null) goto L9;
        NestedScrollView r5 = r4.c;
        if (r5 == null) goto L9;
        int r1 = r5.getChildAt(0).getHeight();
        if ((r5.getHeight() + r5.getScrollY()) >= r1) goto L9;
        return false;
    L9:
        return true;
    }

    public static final boolean ea0(MmSummaryFragment r1) {
        if (r1.ha0().getMainViewModel().getState().q.isInSummary() == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.ha0().getState().c.isMarkdown() == false) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void X90(boolean r2) {
        if (ha0().getState().b == true) goto L5;
        return;
    L5:
        fa0(r2);
    }

    public final void fa0(boolean r5) {
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "applyFishBoneTheme", "isDarkMode=" + r5, U90());
        ha0().dispatchEvent(new com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.b.C0068b(r5));
    }

    public final void ka0(String r4) {
        if (ga0().e.R5() == false) goto L6;
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "pauseAnimations", "from=" + r4 + ", stopSuccess", U90());
        return;
    }

    public final void ma0(String r5) {
        View r0 = this.x;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L8;
        ViewGroup r2 = (ViewGroup) r1;
    L9:
        if (r2 == null) goto L11;
        r2.removeView(r0);
    L11:
        this.x = null;
        int r3 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "removeThemeTransitionOverlay", "from=".concat(r5), U90());
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void na0(String r7) {
        MmSummaryLoadingTextView r0 = ga0().e;
        int r1 = MmSummaryLoadingTextView.h;
        if (r0.e == false) goto L5;
        boolean r2 = false;
    L9:
        if (r2 == false) goto L12;
        int r3 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "resumeAnimations", "from=" + r7 + ", startAnimSuccess", U90());
        return;
    L12:
        return;
    L5:
        int r4 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "startAutoLoop", "startAutoLoop, interval: 4000, sweepAnimation: " + r0.c, null, 8);
        r0.R5();
        r0.e = true;
        r0.f = 4000;
        r0.d = new com.ss.android.lark.officesdk.minutes.ui.foundation.widget.e(r0);
        TranslateAnimation r5 = r0.c;
        if (r5 == null) goto L8;
        r0.b.startAnimation(r5);
    L8:
        r2 = true;
        goto L9
    }

    public final void oa0(String r3) {
        e r0 = ha0().getState();
        if (r0.c.isFishBone() == false) goto L6;
        return;
    L6:
        if (r0.d != MmSummaryStatus.HasContent) goto L9;
        na0(r3);
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onAttach(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.onAttach(r3);
        ha0().dispatchEvent(new com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.b.c(r3));
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        if (ha0().getState().b == true) goto L5;
        return;
    L5:
        V90(true);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.h = Boolean.valueOf(W90());
    }

    public final void pa0(String r4) {
        c r0 = this.r;
        r0.c++;
        r0.b.removeCallbacks(r0.e);
        r0.d = false;
        b r1 = new b(this, r4);
        l r5 = this.m;
        if (r5 == null) goto L7;
        NestedScrollView r6 = r5.c;
        if (r6 == null) goto L7;
        r6.postDelayed(r1, 20);
        return;
    L7:
        c r7 = this.r;
        int r2 = r7.c;
        if (r2 <= 0) goto L12;
        r7.c = r2 - 1;
        return;
    }

    public final void ua0(MmSummaryViewType r7) {
        if (ja0() == false) goto L6;
        ia0();
        return;
    L6:
        com.ss.android.lark.officesdk.minutes.ui.style.e r0 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r1 = ha0().getMainViewModel().getUiLaunchMode();
        r0.getClass();
        h r2 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r1);
        com.ss.android.lark.officesdk.minutes.ui.style.contract.e r3 = r2.getDrawable();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.d r4 = r2.getColor();
        g r5 = r2.getShape();
        if (r7.isFishBone() == false) goto L9;
        ga0().j.setVisibility(0);
        ga0().b.setVisibility(8);
        ta0("switch_to_fishbone", false);
        ka0("switch_to_fishbone");
        ga0().o.setBackground(null);
        ga0().n.setBackground(r5.l(requireContext()));
        int r8 = wvb.b.a;
        wvb.b.a(ga0().n, r3.c(), r4.m());
        wvb.b.a(ga0().o, r3.e(), r4.h());
    L20:
        if (isResumed() == false) goto L23;
        sa0(this, "viewType_changed", false, false, 6);
        return;
    L23:
        return;
    L9:
        ga0().j.setVisibility(8);
        ga0().b.setVisibility(0);
        ta0("switch_to_markdown", false);
        if (ha0().getState().d.hasContent() == false) goto L12;
        qa0();
    L13:
        ga0().n.setBackground(null);
        ga0().o.setBackground(r5.l(requireContext()));
        int r9 = wvb.b.a;
        wvb.b.a(ga0().n, r3.c(), r4.h());
        wvb.b.a(ga0().o, r3.e(), r4.m());
        if (this.q == false) goto L20;
        this.q = false;
        if (this.o == false) goto L18;
        pa0("switch_to_text");
        goto L20
    L18:
        la0(true, "switch_to_text");
        goto L20
    L12:
        ra0();
        goto L13
    }

    public static final void ca0(MmSummaryFragment r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r3) {
        boolean r0 = r2.C;
        r2.y = f.a(r3);
        if (r2.ja0() == false) goto L5;
        r2.ia0();
    L10:
        r2.ha0().dispatchEvent(new com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.b.l(false));
        return;
    L5:
        r2.ua0(r2.ha0().getState().c);
        UDShadowLayout r4 = r2.ga0().l;
        if (r2.ha0().getState().a == false) goto L8;
        int r1 = 0;
    L9:
        r4.setVisibility(r1);
        r2.ta0("quota_cta_restore", false);
        r2.la0(false, "quota_cta_restore");
        goto L10
    L8:
        r1 = 8;
        goto L9
    }

    public final void la0(boolean r7, String r8) {
        int r1 = 8;
        if (ja0() == false) goto L7;
        ga0().f.setVisibility(8);
        return;
    L7:
        if (r7 == true) goto L9;
    L13:
        boolean r2 = false;
    L14:
        int r3 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "refreshBubbleVisibility", "source=" + r8 + ", shouldShow=" + r2 + ", showNewContentBubble=" + r7 + ", isAtBottom=" + this.o, U90());
        UDShadowLayout r9 = ga0().f;
        if (r2 == false) goto L17;
        r1 = 0;
    L17:
        r9.setVisibility(r1);
        return;
    L9:
        if (ha0().getState().c.isMarkdown() == false) goto L13;
        if (this.o == true) goto L13;
        r2 = true;
        goto L14
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        int r7 = uvb.b.a;
        uvb.a.b(r5, uvb.c.o);
        ha0().selectSubscribeVMEvent(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), new MmSummaryFragment$subscribeViewModelEvents$1(this, null));
        com.ss.android.lark.officesdk.minutes.ui.style.e r8 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r9 = ha0().getMainViewModel().getUiLaunchMode();
        r8.getClass();
        g r10 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r9).getShape();
        ga0().g.setBackground(r10.v(ga0().g.getContext()));
        ga0().m.setBackground(r10.j(ga0().m.getContext()));
        ga0().d.setOnCopyClickedListener(new MmSummaryFragment$initView$1(this));
        Fragment r11 = getParentFragment();
        if (r11 == null) goto L7;
        View r12 = r11.getView();
        if (r12 == null) goto L7;
        MmViewPagerGestureArbiterLayout r13 = (MmViewPagerGestureArbiterLayout) r12.findViewById(2131380200);
    L8:
        this.t = r13;
        Fragment r14 = getParentFragment();
        if (r14 == null) goto L13;
        View r15 = r14.getView();
        if (r15 == null) goto L13;
        MmRecordingNavLayout r16 = (MmRecordingNavLayout) r15.findViewById(2131380186);
    L14:
        this.u = r16;
        if (r16 == null) goto L17;
        Function2<Integer, Integer, Unit> r17 = this.D;
        Intrinsics.checkNotNullParameter(r17, "listener");
        r16.t.add(r17);
    L17:
        MmViewPagerGestureArbiterLayout r18 = this.t;
        if (r18 == null) goto L20;
        a r19 = this.E;
        Intrinsics.checkNotNullParameter("summary_fishbone_web", "tag");
        r18.e = "summary_fishbone_web";
        r18.d = r19;
        int r20 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "bindPagingConflictChild", "tag=summary_fishbone_web, child=" + r19, null, 8);
    L20:
        int r21 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "initView", "bind viewPagerGestureArbiter=" + this.t + ", navLayout=" + this.u, U90());
        Context r22 = getContext();
        if (r22 == null) goto L24;
        ha0().dispatchEvent(new com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.b.g(r22, W90()));
    L24:
        View r23 = ga0().a;
        if ((r23 instanceof FrameLayout) == false) goto L27;
        FrameLayout r24 = (FrameLayout) r23;
    L28:
        if (r24 == null) goto L31;
        com.ss.android.lark.officesdk.minutes.ui.style.e.b(ha0().getMainViewModel().getUiLaunchMode()).getQuotaCta().create(r24.getContext());
    L31:
        ta0("initView", false);
        if (ha0().getState().b == false) goto L34;
        fa0(W90());
    L34:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(ga0().n, new MmSummaryFragment$initListener$1(this));
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(ga0().o, new MmSummaryFragment$initListener$2(this));
        if (Build.VERSION.SDK_INT < 23) goto L37;
        ga0().c.setOnScrollChangeListener(new com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.a(this));
    L37:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(ga0().g, new MmSummaryFragment$initListener$4(this));
        this.n = new awb.c(ga0().d, new awb.d(true, new MmSummaryFragment$initTextSelection$config$1(this), 4));
        aa0(MmSummaryFragment$subscribeData$1.INSTANCE, new MmSummaryFragment$subscribeData$2(this, null));
        ba0(MmSummaryFragment$subscribeRichContent$1.INSTANCE, MmSummaryFragment$subscribeRichContent$2.INSTANCE, new MmSummaryFragment$subscribeRichContent$3(this, null));
        aa0(MmSummaryFragment$subscribeViewTypeSwitchVisibility$1.INSTANCE, new MmSummaryFragment$subscribeViewTypeSwitchVisibility$2(this, null));
        aa0(MmSummaryFragment$subscribeSummaryStatus$1.INSTANCE, new MmSummaryFragment$subscribeSummaryStatus$2(this, null));
        ba0(MmSummaryFragment$subscribeSummaryStatus$3.INSTANCE, MmSummaryFragment$subscribeSummaryStatus$4.INSTANCE, new MmSummaryFragment$subscribeSummaryStatus$5(new Ref.ObjectRef(), this, null));
        ba0(MmSummaryFragment$subscribeSummaryStatus$6.INSTANCE, MmSummaryFragment$subscribeSummaryStatus$7.INSTANCE, new MmSummaryFragment$subscribeSummaryStatus$8(new Ref.ObjectRef(), this, null));
        ha0().getMainViewModel().selectSubscribe(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), MmSummaryFragment$subscribeCurrentTab$1.INSTANCE, new MmSummaryFragment$subscribeCurrentTab$2(new Ref.BooleanRef(), this, null));
        aa0(MmSummaryFragment$subscribeContentGenerated$1.INSTANCE, new MmSummaryFragment$subscribeContentGenerated$2(new Ref.BooleanRef(), this, null));
        aa0(MmSummaryFragment$subscribeContentGenerated$3.INSTANCE, new MmSummaryFragment$subscribeContentGenerated$4(new Ref.BooleanRef(), this, null));
        aa0(MmSummaryFragment$subscribeQuotaCtaState$1.INSTANCE, new MmSummaryFragment$subscribeQuotaCtaState$2(this, null));
        aa0(MmSummaryFragment$subscribeWebReady$1.INSTANCE, new MmSummaryFragment$subscribeWebReady$2(this, null));
        ha0().dispatchEvent(com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.b.n.a);
        return;
    L27:
        r24 = null;
    L13:
        r16 = null;
    L7:
        r13 = null;
        goto L8
    }

    public final void ta0(String r10, boolean r11) {
        MmRecordingUITab r0 = ha0().getMainViewModel().getState().q;
        boolean r2 = true;
        int r3 = 0;
        if (isResumed() == true) goto L5;
    L9:
        boolean r1 = false;
    L10:
        View r4 = this.z;
        if (r4 != null) goto L14;
        int r12 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "updateFishBoneWebVisibility", "webView is null, from=" + r10, U90());
        return;
    L14:
        if (r1 == true) goto L16;
    L18:
        r2 = false;
    L20:
        if (ja0() == true) goto L22;
    L24:
        if (r2 == true) goto L28;
        r3 = 4;
    L28:
        if (r4.getVisibility() == r3) goto L30;
        int r5 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "updateFishBoneWebVisibility", "from=" + r10 + ", isVisibleToUser=" + r1 + ", targetVisible=" + r2 + ", visibility=" + r3, U90());
        r4.setVisibility(r3);
    L30:
        ha0().dispatchEvent(new com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.b.h(r2, r11));
        return;
    L22:
        if (r4.getVisibility() == 4) goto L24;
        int r6 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "updateFishBoneWebVisibility", "quota CTA blocks content, from=" + r10, U90());
        r4.setVisibility(4);
        goto L24
    L16:
        if (ja0() == true) goto L18;
    L5:
        if (r0.isInSummary() == false) goto L9;
        if (ha0().getState().c.isFishBone() == false) goto L9;
        r1 = true;
        goto L10
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        super.onCreateView(r2, r3, r4);
        MmRecordingUILaunchMode r5 = ha0().getMainViewModel().getUiLaunchMode();
        com.ss.android.lark.officesdk.minutes.ui.style.e.a.getClass();
        l r6 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r5).getLayout().x(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r2.getContext(), r5)), r3);
        this.m = r6;
        return r6.a;
    }

    public static void sa0(MmSummaryFragment r4, String r5, boolean r6, boolean r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r6 = false;
    L6:
        if ((r8 & 4) == 0) goto L8;
        r7 = false;
    L8:
        e r9 = r4.ha0().getState();
        MmSummaryViewType r0 = r9.c;
        if (r7 == true) goto L14;
        if (r6 == true) goto L14;
        if (r4.s != r0) goto L14;
        int r10 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "trackSummaryViewEvent", "from=" + r5 + ", skip duplicate viewType=" + r0, r4.U90());
        return;
    L14:
        r4.s = r0;
        if (r0.isFishBone() == false) goto L17;
        boolean r11 = r9.e.hasContent();
    L18:
        if (r6 == true) goto L21;
        if (r11 == true) goto L21;
        String r12 = "false";
    L23:
        int r13 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "trackSummaryViewEvent", "from=" + r5 + ", viewType=" + r0 + ", hasContent=" + r11, r4.U90());
        if (r0.isFishBone() == false) goto L26;
        r4.ha0().getMainViewModel().trackPageView("realtime_summary_new_vision_tab_view", MapsKt.mapOf(TuplesKt.to("is_content_generated", r12)));
        return;
    L26:
        r4.ha0().getMainViewModel().trackPageView("realtime_summary_tab_view", MapsKt.mapOf(TuplesKt.to("is_content_generated", r12)));
        return;
    L21:
        r12 = "true";
        goto L23
    L17:
        r11 = r9.d.hasContent();
        goto L18
    }
}
