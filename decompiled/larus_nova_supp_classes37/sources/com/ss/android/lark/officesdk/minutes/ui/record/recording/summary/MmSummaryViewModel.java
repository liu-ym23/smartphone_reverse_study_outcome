package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.View;
import android.webkit.WebViewClient;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmAISummaryLayoutData;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryStatus;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryViewType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web.MmSummaryWebHelper;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.f;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Message;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001HB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001aH\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001aH\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001aH\u0002J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001aH\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001aH\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001aH\u0002J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001aH\u0002J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020\u001fH\u0002J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u000200H\u0002J(\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020\fH\u0002J\u0010\u00107\u001a\u00020\u001f2\u0006\u0010/\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\fH\u0002J\u0018\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0016H\u0002J\u0018\u0010?\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020\u0016H\u0002J\b\u0010B\u001a\u00020\u001fH\u0002J\b\u0010C\u001a\u00020\u001fH\u0002J\u0010\u0010D\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\fH\u0002J\u0010\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020\u0016H\u0002J\u0010\u0010G\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u0004H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006I"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryViewModel;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/MviViewModel;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryVMState;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryVMEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryUIEvent;", "mainViewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;)V", "getMainViewModel", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "logDetail", "", "getLogDetail", "()Ljava/lang/String;", "logDetail$delegate", "Lkotlin/Lazy;", "webRetryJob", "Lkotlinx/coroutines/Job;", "latestQuotaCtaEntity", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaEntity;", "lastNotifiedFishBoneWebVisible", "", "Ljava/lang/Boolean;", "lastTrackedCtaStateKey", "summaryRepo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmRecordingSummaryRepo;", "getSummaryRepo", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmRecordingSummaryRepo;", "defaultState", "subscribeRepoData", "", "subscribeFishBoneConfig", "repo", "subscribeSummaryContent", "subscribeSummaryStatus", "subscribeViewTypeSwitchEnable", "subscribeViewType", "subscribeWebReadyState", "subscribeWebLoadingState", "subscribeWebLoadFailedState", "handleWebLoadFailed", "scheduleWebRetry", "retryCount", "", "subscribeQuotaCtaData", "prepareFishBoneWebView", "event", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryUIEvent$OnFishBoneWebViewCreated;", "sendBindFishBoneWebView", "webView", "Landroid/view/View;", "showThemeTransition", "retryOnAttachFailure", "source", "handleFishBoneWebViewAttachFailed", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryUIEvent$OnFishBoneWebViewAttachFailed;", "loadFishBoneUrl", "url", "sendFishBoneWebScrollResult", "requestId", "", "canScroll", "notifyFishBoneWebVisibility", "visible", "forceNotify", "handleQuotaCtaActionClick", "handleQuotaCtaBenefitCenterClick", "openWebPage", "trackQuotaCtaViewIfSelected", "forceTrack", "dispatchEvent", "Factory", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmSummaryViewModel extends MviViewModel<e, d, b> {
    private Boolean lastNotifiedFishBoneWebVisible;
    private String lastTrackedCtaStateKey;
    private com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c latestQuotaCtaEntity;
    private final Lazy logDetail$delegate;
    private final MmRecordingViewModel mainViewModel;
    private Job webRetryJob;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "mainViewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Factory implements ViewModelProvider.Factory {
        public final MmRecordingViewModel a;

        public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public Factory(MmRecordingViewModel r2) {
            Intrinsics.checkNotNullParameter(r2, "mainViewModel");
            this.a = r2;
        }

        public final <T extends ViewModel> T create(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "modelClass");
            if (r2.isAssignableFrom(MmSummaryViewModel.class) == false) goto L7;
            return new MmSummaryViewModel(this.a);
        L7:
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$openWebPage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$openWebPage$1", f = "MmSummaryViewModel.kt", i = {}, l = {346}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ MmSummaryViewModel this$0;

        public C02641(MmSummaryViewModel r1, String r2, Continuation<? super C02641> r3) {
            this.this$0 = r1;
            this.$url = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02641(this.this$0, this.$url, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MmSummaryViewModel r6 = this.this$0;
            d.c r2 = new d.c(this.$url);
            this.label = 1;
            if (r6.sendVMEvent(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$scheduleWebRetry$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$scheduleWebRetry$1", f = "MmSummaryViewModel.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMs;
        final /* synthetic */ int $retryCount;
        int label;
        final /* synthetic */ MmSummaryViewModel this$0;

        public C02651(long r1, MmSummaryViewModel r3, int r4, Continuation<? super C02651> r5) {
            this.$delayMs = r1;
            this.this$0 = r3;
            this.$retryCount = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C02651(this.$delayMs, this.this$0, this.$retryCount, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            e r7 = this.this$0.getState();
            if (r7.i == false) goto L28;
            if (r7.h == true) goto L28;
            if (r7.j != this.$retryCount) goto L28;
            int r8 = bwb.b.a;
            bwb.b.f(MmUiLogScene.SUMMARY, "scheduleWebRetry", "execute retry. count=" + this.$retryCount, MmSummaryViewModel.access$getLogDetail(this.this$0));
            this.this$0.setState(C00651.INSTANCE);
            MmRecordingSummaryRepo r9 = MmSummaryViewModel.access$getSummaryRepo(this.this$0);
            if (r9 == null) goto L22;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.a r10 = r9.l();
            if (r10 == null) goto L22;
            MmSummaryWebHelper r11 = r10.C();
        L23:
            if (r11 == null) goto L28;
            lvb.a.e(r11.d, "[reload]");
            r11.g = false;
            r11.h = false;
            OfficeWebView r12 = r11.e;
            if (r12 == null) goto L28;
            r12.reload();
        L22:
            r11 = null;
        L28:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            long r3 = this.$delayMs;
            this.label = 1;
            if (DelayKt.delay(r3, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$sendBindFishBoneWebView$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$sendBindFishBoneWebView$1", f = "MmSummaryViewModel.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $retryOnAttachFailure;
        final /* synthetic */ boolean $showThemeTransition;
        final /* synthetic */ String $source;
        final /* synthetic */ View $webView;
        int label;
        final /* synthetic */ MmSummaryViewModel this$0;

        public C02661(MmSummaryViewModel r1, View r2, boolean r3, boolean r4, String r5, Continuation<? super C02661> r6) {
            this.this$0 = r1;
            this.$webView = r2;
            this.$showThemeTransition = r3;
            this.$retryOnAttachFailure = r4;
            this.$source = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C02661(this.this$0, this.$webView, this.$showThemeTransition, this.$retryOnAttachFailure, this.$source, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            MmSummaryViewModel r9 = this.this$0;
            d.a r2 = new d.a(this.$webView, this.$showThemeTransition, this.$retryOnAttachFailure, this.$source);
            this.label = 1;
            if (r9.sendVMEvent(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$sendFishBoneWebScrollResult$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$sendFishBoneWebScrollResult$1", f = "MmSummaryViewModel.kt", i = {}, l = {300}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $canScroll;
        final /* synthetic */ long $requestId;
        int label;
        final /* synthetic */ MmSummaryViewModel this$0;

        public C02671(MmSummaryViewModel r1, long r2, boolean r4, Continuation<? super C02671> r5) {
            this.this$0 = r1;
            this.$requestId = r2;
            this.$canScroll = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C02671(this.this$0, this.$requestId, this.$canScroll, r8);
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
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            MmSummaryViewModel r8 = this.this$0;
            d.b r2 = new d.b(this.$requestId, this.$canScroll);
            this.label = 1;
            if (r8.sendVMEvent(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeFishBoneConfig$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", "", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeFishBoneConfig$2", f = "MmSummaryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Pair<? extends Boolean, ? extends String>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmSummaryViewModel this$0;

        public AnonymousClass2(MmSummaryViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Pair) r1, (Continuation) r2);
        }

        public final Object invoke(Pair<Boolean, String> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r6);
            Pair r7 = (Pair) this.L$0;
            final boolean r0 = ((Boolean) r7.component1()).booleanValue();
            final String r8 = (String) r7.component2();
            int r1 = bwb.b.a;
            MmUiLogScene r2 = MmUiLogScene.SUMMARY;
            StringBuilder r3 = new StringBuilder("isFishBoneEnable=");
            r3.append(r0);
            r3.append(", hasUrl=");
            if (r8.length() <= 0) goto L7;
            boolean r4 = true;
        L8:
            r3.append(r4);
            bwb.b.f(r2, "subscribeFishBoneConfig", r3.toString(), MmSummaryViewModel.access$getLogDetail(this.this$0));
            this.this$0.setState(new AnonymousClass1(r0, r8));
            if (r0 == false) goto L12;
            MmSummaryViewModel.access$loadFishBoneUrl(this.this$0, r8);
        L12:
            return Unit.INSTANCE;
        L7:
            r4 = false;
            goto L8
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeQuotaCtaData$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaUiState;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeQuotaCtaData$2", f = "MmSummaryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02692 extends SuspendLambda implements Function2<h, Continuation<? super Unit>, Object> {
        final /* synthetic */ i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c> $quotaCtaFlow;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmSummaryViewModel this$0;

        public C02692(MmSummaryViewModel r1, i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c> r2, Continuation<? super C02692> r3) {
            this.this$0 = r1;
            this.$quotaCtaFlow = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C02692 r0 = new C02692(this.this$0, this.$quotaCtaFlow, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(h r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((h) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            final h r4 = (h) this.L$0;
            MmSummaryViewModel.access$setLatestQuotaCtaEntity$p(this.this$0, (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c) this.$quotaCtaFlow.getValue());
            this.this$0.setState(new AnonymousClass1(r4));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeRepoData$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "degraded", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeRepoData$2", f = "MmSummaryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02712 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ MmSummaryViewModel this$0;

        public C02712(MmSummaryViewModel r1, Continuation<? super C02712> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02712 r0 = new C02712(this.this$0, r4);
            r0.Z$0 = ((Boolean) r3).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            final boolean r4 = this.Z$0;
            this.this$0.setState(new AnonymousClass1(r4));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeSummaryContent$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmRecordingAISummary;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeSummaryContent$2", f = "MmSummaryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02732 extends SuspendLambda implements Function2<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmSummaryViewModel this$0;

        public C02732(MmSummaryViewModel r1, Continuation<? super C02732> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02732 r0 = new C02732(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r3);
            final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b r4 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b) this.L$0;
            if (r4 == null) goto L7;
            this.this$0.setState(new AnonymousClass1(r4));
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeSummaryStatus$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSummaryStatus;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeSummaryStatus$2", f = "MmSummaryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02752 extends SuspendLambda implements Function2<MmSummaryStatus, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmSummaryViewModel this$0;

        public C02752(MmSummaryViewModel r1, Continuation<? super C02752> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02752 r0 = new C02752(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(MmSummaryStatus r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((MmSummaryStatus) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            final MmSummaryStatus r6 = (MmSummaryStatus) this.L$0;
            int r0 = bwb.b.a;
            bwb.b.f(MmUiLogScene.SUMMARY, "subscribeRepoData", "textSummaryStatus=" + r6, MmSummaryViewModel.access$getLogDetail(this.this$0));
            this.this$0.setState(new AnonymousClass1(r6));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeSummaryStatus$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSummaryStatus;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeSummaryStatus$4", f = "MmSummaryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<MmSummaryStatus, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmSummaryViewModel this$0;

        public AnonymousClass4(MmSummaryViewModel r1, Continuation<? super AnonymousClass4> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass4 r0 = new AnonymousClass4(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(MmSummaryStatus r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((MmSummaryStatus) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            final MmSummaryStatus r6 = (MmSummaryStatus) this.L$0;
            int r0 = bwb.b.a;
            bwb.b.f(MmUiLogScene.SUMMARY, "subscribeRepoData", "fishBoneSummaryStatus=" + r6, MmSummaryViewModel.access$getLogDetail(this.this$0));
            this.this$0.setState(new AnonymousClass1(r6));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeViewType$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSummaryViewType;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeViewType$2", f = "MmSummaryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02772 extends SuspendLambda implements Function2<MmSummaryViewType, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmSummaryViewModel this$0;

        public C02772(MmSummaryViewModel r1, Continuation<? super C02772> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02772 r0 = new C02772(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(MmSummaryViewType r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((MmSummaryViewType) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            final MmSummaryViewType r4 = (MmSummaryViewType) this.L$0;
            this.this$0.setState(new AnonymousClass1(r4));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeViewTypeSwitchEnable$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeViewTypeSwitchEnable$2", f = "MmSummaryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02792 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ MmSummaryViewModel this$0;

        public C02792(MmSummaryViewModel r1, Continuation<? super C02792> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02792 r0 = new C02792(this.this$0, r4);
            r0.Z$0 = ((Boolean) r3).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            final boolean r6 = this.Z$0;
            int r0 = bwb.b.a;
            bwb.b.f(MmUiLogScene.SUMMARY, "subscribeRepoData", "isViewTypeSwitchEnable=" + r6, MmSummaryViewModel.access$getLogDetail(this.this$0));
            this.this$0.setState(new AnonymousClass1(r6));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeWebLoadFailedState$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "failed", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeWebLoadFailedState$2", f = "MmSummaryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02812 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ MmSummaryViewModel this$0;

        public C02812(MmSummaryViewModel r1, Continuation<? super C02812> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02812 r0 = new C02812(this.this$0, r4);
            r0.Z$0 = ((Boolean) r3).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r5);
            final boolean r6 = this.Z$0;
            int r0 = bwb.b.a;
            bwb.b.f(MmUiLogScene.SUMMARY, "subscribeWebLoadFailedState", "isWebLoadFailed=" + r6, MmSummaryViewModel.access$getLogDetail(this.this$0));
            if (r6 == true) goto L7;
        L9:
            this.this$0.setState(new C00662(r6));
        L11:
            return Unit.INSTANCE;
        L7:
            if (this.this$0.getState().h == false) goto L9;
            this.this$0.setState(AnonymousClass1.INSTANCE);
            MmSummaryViewModel.access$handleWebLoadFailed(this.this$0);
            goto L11
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeWebLoadingState$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "loading", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeWebLoadingState$2", f = "MmSummaryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02832 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ MmSummaryViewModel this$0;

        public C02832(MmSummaryViewModel r1, Continuation<? super C02832> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02832 r0 = new C02832(this.this$0, r4);
            r0.Z$0 = ((Boolean) r3).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            final boolean r6 = this.Z$0;
            int r0 = bwb.b.a;
            bwb.b.f(MmUiLogScene.SUMMARY, "subscribeWebLoadingState", "isWebLoading=" + r6, MmSummaryViewModel.access$getLogDetail(this.this$0));
            this.this$0.setState(new AnonymousClass1(r6));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeWebReadyState$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "ready", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryViewModel$subscribeWebReadyState$2", f = "MmSummaryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02852 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ MmSummaryViewModel this$0;

        public C02852(MmSummaryViewModel r1, Continuation<? super C02852> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02852 r0 = new C02852(this.this$0, r4);
            r0.Z$0 = ((Boolean) r3).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r5);
            boolean r6 = this.Z$0;
            int r0 = bwb.b.a;
            bwb.b.f(MmUiLogScene.SUMMARY, "subscribeWebReadyState", "isWebReady=" + r6, MmSummaryViewModel.access$getLogDetail(this.this$0));
            if (r6 == false) goto L10;
            Job r7 = MmSummaryViewModel.access$getWebRetryJob$p(this.this$0);
            if (r7 == null) goto L9;
            Job.DefaultImpls.cancel$default(r7, null, 1, null);
        L9:
            this.this$0.setState(AnonymousClass1.INSTANCE);
        L12:
            return Unit.INSTANCE;
        L10:
            this.this$0.setState(C00672.INSTANCE);
            goto L12
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final String getLogDetail() {
        return (String) this.logDetail$delegate.getValue();
    }

    private final MmRecordingSummaryRepo getSummaryRepo() {
        return this.mainViewModel.getSummaryRepo();
    }

    private final void handleQuotaCtaActionClick() {
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r0 = this.latestQuotaCtaEntity;
        if (r0 != null) goto L5;
        return;
    L5:
        h r1 = r0.b;
        if ((r1 instanceof h.d) == false) goto L8;
        h.d r2 = (h.d) r1;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        String r3 = r2.b.getBillUrl(r2.a, "minutes_recording_notes_page");
        if (StringsKt.isBlank(r3) == false) goto L14;
        return;
    L14:
        this.mainViewModel.trackQuotaCtaClick(MmRecordingUITab.SUMMARY, r0);
        openWebPage(r3);
        return;
    L8:
        r2 = null;
        goto L9
    }

    private final void handleQuotaCtaBenefitCenterClick() {
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r0 = this.latestQuotaCtaEntity;
        if (r0 == null) goto L19;
        h r1 = r0.b;
        if (r1 != null) goto L8;
        return;
    L8:
        if ((r1 instanceof h.d) == false) goto L11;
        h.d r2 = (h.d) r1;
        String r3 = r2.b.getBenefitCenterUrl(r2.a);
    L14:
        if (StringsKt.isBlank(r3) == false) goto L17;
        int r4 = bwb.b.a;
        bwb.b.h(MmUiLogScene.SUMMARY, "quotaCtaBenefitCenter", "benefitCenterUrl is empty", getLogDetail());
        return;
    L17:
        openWebPage(r3);
        return;
    L11:
        if ((r1 instanceof h.c) == false) goto L20;
        h.c r5 = (h.c) r1;
        r3 = r5.b.getBenefitCenterUrl(r5.a);
        goto L14
    L20:
        return;
    }

    private final void subscribeQuotaCtaData() {
        MmRecordingQuotaCtaRepo r0 = this.mainViewModel.getQuotaCtaRepo();
        if (r0 == null) goto L11;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.a r1 = r0.l();
        if (r1 == null) goto L12;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c> r2 = r1.b();
        if (r2 == null) goto L13;
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r2, getViewModelScope(), C02681.INSTANCE, null, new C02692(this, r2, null), 12);
        return;
    L13:
        return;
    L12:
        return;
    }

    private final void handleWebLoadFailed() {
        e r0 = getState();
        if (r0.b == true) goto L5;
        return;
    L5:
        int r1 = r0.j;
        if (r1 >= r0.k) goto L8;
        final int r2 = r1 + 1;
        setState(new C02631(r2));
        scheduleWebRetry(r2);
        int r3 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "handleWebLoadFailed", "schedule auto retry, count=" + r2, getLogDetail());
        return;
    L8:
        int r4 = bwb.b.a;
        bwb.b.h(MmUiLogScene.SUMMARY, "handleWebLoadFailed", "max retry reached", getLogDetail());
    }

    private final void subscribeRepoData() {
        MmRecordingSummaryRepo r0 = getSummaryRepo();
        if (r0 != null) goto L6;
        int r1 = bwb.b.a;
        bwb.b.d(MmUiLogScene.SUMMARY, "subscribeRepoData", "summaryRepo is null", getLogDetail());
        return;
    L6:
        subscribeFishBoneConfig(r0);
        subscribeSummaryContent(r0);
        subscribeSummaryStatus(r0);
        subscribeViewTypeSwitchEnable(r0);
        subscribeViewType(r0);
        subscribeWebReadyState(r0);
        subscribeWebLoadingState(r0);
        subscribeWebLoadFailedState(r0);
        MmRecordingSubtitleRepo r2 = this.mainViewModel.getSubtitleRepo();
        if (r2 == null) goto L14;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.a r3 = r2.l();
        if (r3 == null) goto L15;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.d> r4 = r3.b();
        if (r4 == null) goto L16;
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r4, getViewModelScope(), C02701.INSTANCE, null, new C02712(this, null), 12);
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public e defaultState() {
        MmRecordingSummaryRepo r0 = getSummaryRepo();
        if (r0 != null) goto L6;
        int r1 = bwb.b.a;
        bwb.b.d(MmUiLogScene.SUMMARY, "defaultState", "summaryRepo is null", getLogDetail());
        return new e(false, false, null, null, false, false, 16383);
    L6:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.c r2 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.c) r0.l().b().getValue();
        boolean r3 = r2.b;
        boolean r4 = r2.c;
        MmSummaryViewType r5 = r2.d;
        String r6 = r2.g;
        boolean r7 = r2.l;
        return new e(r4, r3, r5, r6, r2.k, r7, 15448);
    }

    public final MmRecordingViewModel getMainViewModel() {
        return this.mainViewModel;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public /* bridge */ /* synthetic */ l defaultState() {
        return defaultState();
    }

    public MmSummaryViewModel(MmRecordingViewModel r4) {
        Intrinsics.checkNotNullParameter(r4, "mainViewModel");
        this.mainViewModel = r4;
        this.logDetail$delegate = LazyKt.lazy(new MmSummaryViewModel$logDetail$2(this));
        this.lastTrackedCtaStateKey = "";
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "init", "mainViewModel=" + r4, getLogDetail());
        subscribeRepoData();
        subscribeQuotaCtaData();
    }

    public static final /* synthetic */ String access$getLogDetail(MmSummaryViewModel r0) {
        return r0.getLogDetail();
    }

    public static final /* synthetic */ MmRecordingSummaryRepo access$getSummaryRepo(MmSummaryViewModel r0) {
        return r0.getSummaryRepo();
    }

    public static final /* synthetic */ Job access$getWebRetryJob$p(MmSummaryViewModel r0) {
        return r0.webRetryJob;
    }

    public static final /* synthetic */ void access$handleWebLoadFailed(MmSummaryViewModel r0) {
        r0.handleWebLoadFailed();
    }

    private final void handleFishBoneWebViewAttachFailed(b.f r9) {
        MmRecordingSummaryRepo r0 = getSummaryRepo();
        if (r0 == null) goto L52;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.a r1 = r0.l();
        if (r1 == null) goto L53;
        MmSummaryWebHelper r2 = r1.C();
        if (r2 == null) goto L55;
        String r3 = "attach_failed_" + r9.c;
        Throwable r4 = r9.d;
        Intrinsics.checkNotNullParameter(r3, "from");
        lvb.a.b(r2.d, "[abandonWebView] from=" + r3 + ", error=" + r4);
        OfficeWebView r5 = r2.e;
        if (r5 != null) goto L50;
    L17:
        if (r5 != null) goto L48;
    L46:
        MutableContextWrapper r6 = r2.f;     // Catch: RuntimeException -> L26
        if (r6 == null) goto L28;
        r6.setBaseContext(LarkContext.getApplication());     // Catch: RuntimeException -> L26
    L28:
        r2.e = null;
        r2.f = null;
        r2.k = null;
        boolean r7 = false;
        r2.g = false;
        r2.h = false;
        r2.l = null;
        r2.m = false;
        if (r9.b == true) goto L31;
        return;
    L31:
        Context r8 = r9.getContext();
        if (r8 != null) goto L34;
        return;
    L34:
        String r10 = getState().f;
        if (r10.length() != 0) goto L37;
        boolean r11 = true;
    L38:
        if (r11 == false) goto L40;
        r10 = r2.i;
    L40:
        sendBindFishBoneWebView(r2.c(r8), false, false, "recreate_" + r9.c);
        if (r10.length() <= 0) goto L43;
        r7 = true;
    L43:
        if (r7 == false) goto L54;
        r2.d(r10);
        return;
    L54:
        return;
    L37:
        r11 = false;
    L26:
        e = move-exception;
        lvb.a.b(r2.d, "[abandonWebView] detach context failed, from=" + r3 + ", error=" + e);
        goto L28
    L48:
        r5.setWebViewClient(new WebViewClient());     // Catch: RuntimeException -> L20
    L20:
        e = move-exception;
        lvb.a.b(r2.d, "[abandonWebView] reset webViewClient failed, from=" + r3 + ", error=" + e);
        goto L46
    L50:
        xwb.a r12 = r5.getBridge();     // Catch: RuntimeException -> L15
        if (r12 == null) goto L17;
        ((ConcurrentHashMap) r12.b.a).clear();     // Catch: RuntimeException -> L15
    L15:
        e = move-exception;
        lvb.a.b(r2.d, "[abandonWebView] clear bridge handlers failed, from=" + r3 + ", error=" + e);
        goto L17
    L55:
        return;
    L53:
        return;
    }

    private final void loadFishBoneUrl(String r7) {
        boolean r1 = false;
        if (r7.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        MmRecordingSummaryRepo r2 = getSummaryRepo();
        if (r2 != null) goto L12;
        return;
    L12:
        if (((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.c) r2.l().b().getValue()).b == true) goto L14;
        return;
    L14:
        MmSummaryWebHelper r3 = r2.l().C();
        if (r3 != null) goto L17;
        return;
    L17:
        Intrinsics.checkNotNullParameter(r7, "url");
        if (r3.e == null) goto L31;
        String r4 = r3.i;
        boolean r5 = r3.h;
        Intrinsics.checkNotNullParameter(r7, "requestedUrl");
        Intrinsics.checkNotNullParameter(r4, "currentUrl");
        if (r7.length() <= 0) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == true) goto L25;
    L28:
        boolean r8 = false;
    L29:
        if (r8 == false) goto L31;
        r1 = true;
        goto L31
    L25:
        if (Intrinsics.areEqual(r7, r4) == false) goto L27;
        if (r5 == false) goto L28;
    L27:
        r8 = true;
        goto L29
    L22:
        r6 = false;
    L31:
        if (r1 == true) goto L34;
        int r9 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "loadFishBoneUrl", "skip inactive or duplicate url", getLogDetail());
        return;
    L34:
        r3.d(r7);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void openWebPage(String r7) {
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02641(this, r7, null), 3, null);
    }

    private final void prepareFishBoneWebView(b.g r8) {
        MmRecordingSummaryRepo r0 = getSummaryRepo();
        if (r0 != null) goto L5;
        return;
    L5:
        MmSummaryWebHelper r1 = r0.l().C();
        boolean r2 = false;
        if (r1 == null) goto L21;
        OfficeWebView r3 = r1.e;
        if (r3 == null) goto L15;
        boolean r4 = r8.b;
        Boolean r5 = r1.l;
        if (r5 != null) goto L12;
    L14:
        sendBindFishBoneWebView(r3, r2, true, "reuse");
    L16:
        r0.l().R0(r8.getContext(), "OnFishBoneWebViewCreated");
        MmAISummaryLayoutData r9 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.c) r0.l().b().getValue()).h;
        if (r9 == null) goto L19;
        r1.f(r9);
    L19:
        loadFishBoneUrl(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.c) r0.l().b().getValue()).g);
        return;
    L12:
        if (r5.booleanValue() == r4) goto L14;
        r2 = true;
        goto L14
    L15:
        sendBindFishBoneWebView(r1.c(r8.getContext()), false, false, "create_missing");
        goto L16
    L21:
        MmSummaryWebHelper r6 = r0.l().h0(r8.getContext());
        if (r6 != null) goto L24;
        return;
    L24:
        sendBindFishBoneWebView(r6.c(r8.getContext()), false, false, "create");
        loadFishBoneUrl(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.c) r0.l().b().getValue()).g);
    }

    private final void scheduleWebRetry(int r14) {
        Job r0 = this.webRetryJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.webRetryJob = BuildersKt.launch$default(getViewModelScope(), null, null, new C02651(((long) (1 << (r14 - 1))) * 1000, this, r14, null), 3, null);
    }

    private final void subscribeFishBoneConfig(MmRecordingSummaryRepo r3) {
        final i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.c> r4 = r3.l().b();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.n(new MmSummaryViewModel$subscribeFishBoneConfig$$inlined$map$1(r4)), new AnonymousClass2(this, null)), getViewModelScope());
    }

    private final void subscribeSummaryContent(MmRecordingSummaryRepo r7) {
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r7.l().b(), getViewModelScope(), C02721.INSTANCE, null, new C02732(this, null), 12);
    }

    private final void subscribeSummaryStatus(MmRecordingSummaryRepo r11) {
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r11.l().b(), getViewModelScope(), C02741.INSTANCE, null, new C02752(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r11.l().b(), getViewModelScope(), AnonymousClass3.INSTANCE, null, new AnonymousClass4(this, null), 12);
    }

    private final void subscribeViewType(MmRecordingSummaryRepo r7) {
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r7.l().b(), getViewModelScope(), C02761.INSTANCE, null, new C02772(this, null), 12);
    }

    private final void subscribeViewTypeSwitchEnable(MmRecordingSummaryRepo r7) {
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r7.l().b(), getViewModelScope(), C02781.INSTANCE, null, new C02792(this, null), 12);
    }

    private final void subscribeWebLoadFailedState(MmRecordingSummaryRepo r7) {
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r7.l().b(), getViewModelScope(), C02801.INSTANCE, null, new C02812(this, null), 12);
    }

    private final void subscribeWebLoadingState(MmRecordingSummaryRepo r7) {
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r7.l().b(), getViewModelScope(), C02821.INSTANCE, null, new C02832(this, null), 12);
    }

    private final void subscribeWebReadyState(MmRecordingSummaryRepo r7) {
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r7.l().b(), getViewModelScope(), C02841.INSTANCE, null, new C02852(this, null), 12);
    }

    private final void trackQuotaCtaViewIfSelected(boolean r5) {
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r0 = this.latestQuotaCtaEntity;
        if (r0 != null) goto L5;
        return;
    L5:
        MmRecordingViewModel r1 = this.mainViewModel;
        MmRecordingUITab r2 = MmRecordingUITab.SUMMARY;
        h r3 = r1.resolveQuotaCtaTrackingState$officesdk_minutes_base_ui_release(r2, r0);
        if (Intrinsics.areEqual(r3, h.a.a) == false) goto L8;
    L20:
        this.lastTrackedCtaStateKey = "";
        return;
    L8:
        if (Intrinsics.areEqual(r3, h.b.a) == true) goto L20;
        int r4 = f.a;
        if (f.a(r2, this.mainViewModel.getState().q, r3) == true) goto L13;
        return;
    L13:
        Intrinsics.checkNotNullParameter(r3, "state");
        String r6 = r3.toString();
        if (r5 == false) goto L16;
    L18:
        this.lastTrackedCtaStateKey = r6;
        this.mainViewModel.trackQuotaCtaView(r2, r0);
        return;
    L16:
        if (Intrinsics.areEqual(r6, this.lastTrackedCtaStateKey) == false) goto L18;
    }

    public void dispatchEvent(final b r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        int r0 = bwb.b.a;
        MmUiLogScene r1 = MmUiLogScene.SUMMARY;
        bwb.b.f(r1, "dispatchEvent", String.valueOf(r6), getLogDetail());
        if ((r6 instanceof b.n) == false) goto L10;
        MmRecordingSummaryRepo r7 = getSummaryRepo();
        if (r7 == null) goto L102;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.a r8 = r7.l();
        if (r8 == null) goto L103;
        r8.x("OnViewCreated");
        return;
    L103:
        return;
    L102:
        return;
    L10:
        if ((r6 instanceof b.m) == false) goto L20;
        if (getState().b == true) goto L14;
        return;
    L14:
        MmRecordingSummaryRepo r2 = getSummaryRepo();
        if (r2 == null) goto L105;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.a r3 = r2.l();
        if (r3 == null) goto L106;
        r3.p(((b.m) r6).a);
        return;
    L106:
        return;
    L105:
        return;
    L20:
        if ((r6 instanceof b.i) == false) goto L23;
        bwb.b.f(r1, "dispatchEvent", "event:" + r6, getLogDetail());
        return;
    L23:
        if ((r6 instanceof b.g) == false) goto L26;
        prepareFishBoneWebView((b.g) r6);
        return;
    L26:
        if ((r6 instanceof b.f) == false) goto L29;
        handleFishBoneWebViewAttachFailed((b.f) r6);
        return;
    L29:
        if ((r6 instanceof b.c) == false) goto L35;
        MmRecordingSummaryRepo r4 = getSummaryRepo();
        if (r4 == null) goto L111;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.a r5 = r4.l();
        if (r5 == null) goto L112;
        b.c r9 = (b.c) r6;
        r5.R0(r9.getContext(), r9.b);
        return;
    L112:
        return;
    L111:
        return;
    L35:
        MmSummaryWebHelper r10 = null;
        if ((r6 instanceof b.d) == false) goto L44;
        MmRecordingSummaryRepo r11 = getSummaryRepo();
        if (r11 == null) goto L42;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.a r12 = r11.l();
        if (r12 == null) goto L42;
        r12.P(((b.d) r6).a);
    L42:
        this.lastNotifiedFishBoneWebVisible = null;
        return;
    L44:
        if ((r6 instanceof b.h) == false) goto L47;
        b.h r13 = (b.h) r6;
        notifyFishBoneWebVisibility(r13.a, r13.b);
        return;
    L47:
        if ((r6 instanceof b.e) == false) goto L57;
        MmRecordingSummaryRepo r14 = getSummaryRepo();
        if (r14 == null) goto L53;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.a r15 = r14.l();
        if (r15 == null) goto L53;
        r10 = r15.C();
    L53:
        if (r10 != null) goto L55;
        sendFishBoneWebScrollResult(((b.e) r6).a, false);
        return;
    L55:
        b.e r16 = (b.e) r6;
        r10.a(r16.b, r16.c, r16.d, new AnonymousClass1(this, r6));
        return;
    L57:
        if ((r6 instanceof b.C0068b) == false) goto L79;
        MmRecordingSummaryRepo r17 = getSummaryRepo();
        if (r17 == null) goto L118;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.a r18 = r17.l();
        if (r18 == null) goto L119;
        MmSummaryWebHelper r19 = r18.C();
        if (r19 == null) goto L120;
        boolean r20 = ((b.C0068b) r6).a;
        MutableContextWrapper r21 = r19.f;
        if (r21 == null) goto L130;
        int r22 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.b.a;
        int r23 = UIUtils.getColor(r21, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.b.a((MmRecordingUILaunchMode) r19.c.invoke()));
        lvb.a.e(r19.d, "[notifyTheme] isDarkMode=" + r20);
        r19.l = Boolean.valueOf(r20);
        OfficeWebView r24 = r19.e;
        if (r24 == null) goto L70;
        r24.setBackgroundColor(r23);
    L70:
        int r25 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web.b.a;
        OfficeWebView r26 = r19.e;
        if (r26 != null) goto L73;
        lvb.a.b("MmSummaryNativeToJSHelper", "[notifyTheme] webView is null");
        return;
    L73:
        r26.l(r20);
        Message r27 = new Message();
        r27.setCallbackID("common.changeTheme");
        JSONObject r28 = new JSONObject();
        if (r20 == false) goto L76;
        String r29 = "dark";
    L77:
        r28.put("theme", r29);
        r27.setData(r28.toString());
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web.b.a(r26, r27);
        return;
    L76:
        r29 = "light";
        goto L77
    L130:
        return;
    L120:
        return;
    L119:
        return;
    L118:
        return;
    L79:
        if ((r6 instanceof b.a) == false) goto L91;
        MmRecordingSummaryRepo r30 = getSummaryRepo();
        if (r30 == null) goto L123;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.a r31 = r30.l();
        if (r31 == null) goto L124;
        MmSummaryWebHelper r32 = r31.C();
        if (r32 != null) goto L87;
        return;
    L87:
        if (((b.a) r6).a == false) goto L89;
        r32.n.a();
        return;
    L89:
        com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e r33 = r32.n;
        lvb.a.e(r33.b, "[onPause]");
        r33.e = true;
        return;
    L124:
        return;
    L123:
        return;
    L91:
        if (Intrinsics.areEqual(r6, b.j.a) == false) goto L94;
        handleQuotaCtaActionClick();
        return;
    L94:
        if (Intrinsics.areEqual(r6, b.k.a) == false) goto L97;
        handleQuotaCtaBenefitCenterClick();
        return;
    L97:
        if ((r6 instanceof b.l) == false) goto L101;
        trackQuotaCtaViewIfSelected(((b.l) r6).a);
        return;
    L101:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public /* bridge */ /* synthetic */ void dispatchEvent(j r1) {
        dispatchEvent((b) r1);
    }

    public static final /* synthetic */ void access$loadFishBoneUrl(MmSummaryViewModel r0, String r1) {
        r0.loadFishBoneUrl(r1);
    }

    public static final /* synthetic */ void access$setLatestQuotaCtaEntity$p(MmSummaryViewModel r0, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r1) {
        r0.latestQuotaCtaEntity = r1;
    }

    private final void notifyFishBoneWebVisibility(boolean r4, boolean r5) {
        MmRecordingSummaryRepo r0 = getSummaryRepo();
        if (r0 == null) goto L19;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.a r1 = r0.l();
        if (r1 == null) goto L20;
        MmSummaryWebHelper r2 = r1.C();
        if (r2 == null) goto L23;
        OfficeWebView r3 = r2.e;
        if (r3 != null) goto L13;
        return;
    L13:
        if (r2.g == false) goto L21;
        if (r5 == false) goto L16;
    L17:
        int r6 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web.b.a;
        Message r7 = new Message();
        r7.setCallbackID("common.visibilityChange");
        JSONObject r8 = new JSONObject();
        r8.put("visible", r4);
        r7.setData(r8.toString());
        lvb.a.e("MmSummaryNativeToJSHelper", "[notifyWebViewVisible] visible=" + r4);
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web.b.a(r3, r7);
        this.lastNotifiedFishBoneWebVisible = Boolean.valueOf(r4);
        return;
    L16:
        if (Intrinsics.areEqual(this.lastNotifiedFishBoneWebVisible, Boolean.valueOf(r4)) == false) goto L17;
        return;
    L21:
        return;
    L23:
        return;
    L20:
        return;
    }

    private final void sendFishBoneWebScrollResult(long r11, boolean r13) {
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02671(this, r11, r13, null), 3, null);
    }

    public static final /* synthetic */ void access$sendFishBoneWebScrollResult(MmSummaryViewModel r0, long r1, boolean r3) {
        r0.sendFishBoneWebScrollResult(r1, r3);
    }

    private final void sendBindFishBoneWebView(View r12, boolean r13, boolean r14, String r15) {
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02661(this, r12, r13, r14, r15, null), 3, null);
    }
}
