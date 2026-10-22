package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MviBaseFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.MmSubtitleViewModel;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000 \u0081\u00012\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001:\u0002\u0081\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u001a\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020<2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010F\u001a\u00020DH\u0002J\b\u0010G\u001a\u00020DH\u0002J\u0018\u0010H\u001a\u00020#2\u0006\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00020<H\u0002J\b\u0010K\u001a\u00020#H\u0002J\u0010\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020NH\u0002J\u0018\u0010O\u001a\u00020D2\u0006\u0010J\u001a\u00020<2\u0006\u0010P\u001a\u00020#H\u0002J\b\u0010Q\u001a\u00020DH\u0002J\b\u0010R\u001a\u00020DH\u0002J\b\u0010S\u001a\u00020DH\u0002J\b\u0010T\u001a\u00020DH\u0002J\u0012\u0010U\u001a\u00020D2\b\b\u0002\u0010V\u001a\u00020#H\u0002J \u0010W\u001a\u0004\u0018\u00010X2\u0006\u0010Y\u001a\u00020Z2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\H\u0002J\u001a\u0010^\u001a\u0004\u0018\u00010X2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010_\u001a\u00020<H\u0002J\b\u0010`\u001a\u00020DH\u0002J\b\u0010a\u001a\u00020DH\u0002J\u0010\u0010b\u001a\u00020D2\u0006\u0010c\u001a\u00020\u001fH\u0002J\u0010\u0010d\u001a\u00020D2\u0006\u0010e\u001a\u00020fH\u0002J\u0010\u0010g\u001a\u00020D2\u0006\u0010e\u001a\u00020fH\u0002J\b\u0010h\u001a\u00020DH\u0002J\b\u0010i\u001a\u00020DH\u0002J\u0010\u0010j\u001a\u00020D2\u0006\u0010e\u001a\u00020fH\u0002J\u0010\u0010k\u001a\u00020D2\u0006\u0010e\u001a\u00020fH\u0002J\u001a\u0010l\u001a\u00020D2\u0006\u0010c\u001a\u00020\u001f2\b\b\u0002\u0010m\u001a\u00020#H\u0002J\u000e\u0010q\u001a\u00020#2\u0006\u0010r\u001a\u00020sJ&\u0010t\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010u2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020N0w2\u0006\u0010r\u001a\u00020sH\u0002J\f\u0010x\u001a\u00020\t*\u00020sH\u0002J\u0018\u0010y\u001a\u00020D2\u0006\u0010z\u001a\u00020!2\u0006\u0010{\u001a\u00020\tH\u0002J\u0010\u0010|\u001a\u00020!2\u0006\u0010}\u001a\u00020ZH\u0002J\b\u0010~\u001a\u00020DH\u0016J\b\u0010\u007f\u001a\u00020DH\u0002J\t\u0010\u0080\u0001\u001a\u00020DH\u0016R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u00058TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00106\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\r\u001a\u0004\b8\u00109R\u0018\u0010n\u001a\u00020!*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bo\u0010p¨\u0006\u0082\u0001"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleFragment;", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/mvi/MviBaseFragment;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/MmSubtitleVMState;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/MmSubtitleVMEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleUIEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/MmSubtitleViewModel;", "<init>", "()V", "logDetail", "", "getLogDetail", "()Ljava/lang/String;", "logDetail$delegate", "Lkotlin/Lazy;", "viewModel", "getViewModel", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/MmSubtitleViewModel;", "viewModel$delegate", "_subtitleView", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmSubtitleFragmentView;", "subtitleView", "getSubtitleView", "()Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmSubtitleFragmentView;", "subtitleAdapter", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleAdapter;", "layoutManager", "Lcom/larksuite/framework/ui/StableLinearLayoutManager;", "quotaCtaView", "Lcom/ss/android/lark/officesdk/minutes/ui/style/contract/IMmRecordingQuotaCtaView;", "lastTrackedCtaStateKey", "latestQuotaCtaEntity", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaEntity;", "initialSubtitlePaddingTop", "", "initialSubtitleClipToPadding", "", "currentQuotaCtaBlocksContent", "quotaCtaRenderState", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleQuotaCtaRenderState;", "isSubtitleDegraded", "()Z", "stackFromEndController", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleStackFromEndController;", "scrollHelper", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleScrollHelper;", "hasScrolledOnInitialized", "hasTrackedView", "hasTrackedFirstSubtitleOnScreen", "firstSubtitleOnScreenPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "actionPopup", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleActionPopup;", "selectedGroup", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleMarkGroup;", "mainViewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "getMainViewModel", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "mainViewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "subscribeData", "handleSubtitleLongClick", "anchorPosition", "anchorView", "isTranslationEnabled", "resolveMarkSpeakerName", "item", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmSubtitleItem;", "showActionPopup", "marked", "markSelectedGroup", "unmarkSelectedGroup", "copySelectedGroup", "dismissActionPopup", "clearSelectedGroup", "dismissPopup", "buildSelectedGroupRect", "Landroid/graphics/Rect;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "selectedSegIds", "", "", "buildSelectedRect", "child", "initQuotaCtaView", "subscribeQuotaCtaState", "applyQuotaCtaState", "entity", "bindQuotaCtaState", "state", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaUiState;", "applyContentVisibilityForQuotaCta", "applySubtitleContentVisibility", "restoreSubtitleTopPadding", "handleQuotaCtaClick", "handleQuotaCtaBenefitCenterClick", "trackQuotaCtaViewIfSelected", "forceTrack", "dp", "getDp", "(I)I", "goToSubtitle", "request", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteSubtitleNavigationRequest;", "findSubtitleJumpTarget", "Lkotlin/collections/IndexedValue;", "subtitles", "", "toLogText", "scrollToSubtitleTarget", "targetPosition", "requestText", "calculateSubtitleCenterOffset", "recyclerView", "onResume", "scheduleFirstSubtitleOnScreenTracking", "onDestroyView", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmSubtitleFragment extends MviBaseFragment<com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.a, Object, y, MmSubtitleViewModel> {
    public static final /* synthetic */ int E = 0;
    public ViewTreeObserver.OnPreDrawListener A;
    public c B;
    public r C;
    public final Lazy D;
    public final Lazy k;
    public final Lazy l;
    public mwb.i m;
    public MmSubtitleAdapter n;
    public StableLinearLayoutManager o;
    public String p;
    public com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c q;
    public int r;
    public boolean s;
    public boolean t;
    public t u;
    public w v;
    public MmSubtitleScrollHelper w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements e {
        public final /* synthetic */ MmSubtitleFragment a;

        @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.e
        public final void a() {
            MmSubtitleFragment r0 = this.a;
            r r2 = r0.C;
            if (r2 == null) goto L9;
            String r3 = r2.c;
            if (r3 == null) goto L9;
            if ((!StringsKt.isBlank(r3)) == false) goto L9;
        L10:
            if (r3 != null) goto L19;
        L17:
            r0.da0(true);
            return;
        L19:
            Object r4 = r0.requireContext().getSystemService("clipboard");     // Catch: SecurityException -> L13 SensitiveAPIException -> L15
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.content.ClipboardManager");     // Catch: SecurityException -> L13 SensitiveAPIException -> L15
            qf7.a.a.a((ClipboardManager) r4, ClipData.newPlainText("subtitle", r3), new Token("LARK-PSDA-OfficeSDK_MMSubtitle_copySelectedGroup"));     // Catch: SecurityException -> L13 SensitiveAPIException -> L15
            com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.d(2131893519);     // Catch: SecurityException -> L13 SensitiveAPIException -> L15
        L15:
            e = move-exception;
            int r5 = bwb.b.a;
            bwb.b.d(MmUiLogScene.SUBTITLE, "copySelectedGroup", "sensitive api exception: " + e.getMessage(), r0.U90());
        L13:
            e = move-exception;
            int r6 = bwb.b.a;
            bwb.b.d(MmUiLogScene.SUBTITLE, "copySelectedGroup", "security exception: " + e.getMessage(), r0.U90());
        L9:
            r3 = null;
            goto L10
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.e
        public final void b() {
            MmSubtitleFragment r0 = this.a;
            r r1 = r0.C;
            if (r1 == null) goto L7;
            r0.ga0().dispatchEvent(new y.d(r1.a));
            com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.d(2131894003);
            r0.da0(true);
            return;
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.e
        public final void c() {
            MmSubtitleFragment r1 = this.a;
            r r2 = r1.C;
            if (r2 == null) goto L7;
            MmSubtitleViewModel r3 = r1.ga0();
            int r5 = bwb.b.a;
            MmUiLogScene r6 = MmUiLogScene.SUBTITLE;
            bwb.b.g(r6, "toRequest", "markId=" + r2.a + ", contentLen=" + r2.d.length(), null, 8);
            StringBuilder r7 = new StringBuilder("contentMarkdown=");
            r7.append(r2.d);
            bwb.b.b(r6, "toRequest", r7.toString(), null, 8);
            r3.dispatchEvent(new y.b(new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.k(r2.a, r2.d, r2.e, r2.f)));
            r1.da0(true);
            return;
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.e
        public final void onDismiss() {
            MmSubtitleFragment r0 = this.a;
            int r1 = MmSubtitleFragment.E;
            r0.da0(false);
        }

        public b(MmSubtitleFragment r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.MmSubtitleFragment$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.MmSubtitleFragment$onResume$1", f = "MmSubtitleFragment.kt", i = {}, l = {737}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmSubtitleFragment this$0;

        public AnonymousClass1(MmSubtitleFragment r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L7
        L15:
            MmSubtitleFragment r10 = this.this$0;
            int r2 = MmSubtitleFragment.E;
            MmRecordingViewModel.trackPageView$default(r10.ea0(), "transcript_record_tab_view", null, 2, null);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r9);
            this.label = 1;     // Catch: Throwable -> L7
            if (DelayKt.delay(2000, this) != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            MmSubtitleFragment r3 = this.this$0;
            int r4 = MmSubtitleFragment.E;
            MmRecordingViewModel.trackPageView$default(r3.ea0(), "transcript_record_tab_view", null, 2, null);
            throw th;
        }
    }

    static {
    }

    public final String U90() {
        return (String) this.k.getValue();
    }

    public final void ca0() {
        if (this.t == false) goto L5;
    L9:
        fa0().b.setVisibility(8);
        fa0().d.setVisibility(8);
        ha0();
        return;
    L5:
        if (this.u.a == true) goto L9;
        fa0().b.setVisibility(0);
        ha0();
    }

    public final MmRecordingViewModel ea0() {
        return (MmRecordingViewModel) this.D.getValue();
    }

    public final mwb.i fa0() {
        mwb.i r0 = this.m;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Subtitle view is not created".toString());
    }

    public final MmSubtitleViewModel ga0() {
        return (MmSubtitleViewModel) this.l.getValue();
    }

    public MmSubtitleFragment() {
        this.k = LazyKt.lazy(new MmSubtitleFragment$logDetail$2(this));
        this.l = LazyKt.lazy(new MmSubtitleFragment$viewModel$2(this));
        this.p = "";
        this.s = true;
        this.u = new t(0);
        this.D = LazyKt.lazy(new MmSubtitleFragment$mainViewModel$2(this));
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MviBaseFragment
    public final /* bridge */ /* synthetic */ com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.a Z90() {
        return ga0();
    }

    public final void ha0() {
        fa0().b.setPadding(fa0().b.getPaddingLeft(), this.r, fa0().b.getPaddingRight(), fa0().b.getPaddingBottom());
        fa0().b.setClipToPadding(this.s);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onDestroyView() {
        super.onDestroyView();
        c r0 = this.B;
        if (r0 == null) goto L5;
        PopupWindow r1 = r0.h;
        PopupWindowLancet.handleDismissBeforeOrigin(r1);
        r1.dismiss();
    L5:
        this.B = null;
        this.C = null;
        MmSubtitleAdapter r2 = this.n;
        if (r2 == null) goto L8;
        r2.B2(SetsKt.emptySet());
    L8:
        ViewTreeObserver.OnPreDrawListener r3 = this.A;
        if (r3 != null) goto L11;
    L15:
        this.A = null;
        MmSubtitleAdapter r4 = this.n;
        if (r4 == null) goto L25;
        MmSubtitleScrollHelper r5 = this.w;
        if (r5 == null) goto L25;
        if (r5 == null) goto L27;
    L21:
        r4.unregisterAdapterDataObserver(r5.g);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        int r6 = bwb.b.a;
        bwb.b.d(MmUiLogScene.SUBTITLE, "onDestroyView", "unregisterAdapterDataObserver failed: " + e, U90());
        goto L25
    L27:
        Intrinsics.throwUninitializedPropertyAccessException("scrollHelper");     // Catch: Exception -> L23
        r5 = null;
    L25:
        this.m = null;
        return;
    L11:
        if (this.n == null) goto L15;
        if (fa0().b.getViewTreeObserver().isAlive() == false) goto L15;
        fa0().b.getViewTreeObserver().removeOnPreDrawListener(r3);
        goto L15
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onResume() {
        super.onResume();
        if (this.y == false) goto L5;
    L8:
        MmRecordingViewModel.trackPageView$default(ea0(), "transcript_record_tab_view", null, 2, null);
    L9:
        this.y = true;
        return;
    L5:
        if (ea0().hasTrackerToken() == true) goto L8;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass1(this, null), 3, null);
        goto L9
    }

    public final void da0(boolean r4) {
        if (this.C == null) goto L5;
        boolean r0 = true;
    L6:
        MmSubtitleAdapter r2 = null;
        this.C = null;
        if (r4 == false) goto L11;
        c r5 = this.B;
        if (r5 == null) goto L11;
        PopupWindow r6 = r5.h;
        PopupWindowLancet.handleDismissBeforeOrigin(r6);
        r6.dismiss();
    L11:
        if (r0 == false) goto L20;
        w r7 = this.v;
        if (r7 == null) goto L21;
        r7.e(false, "clearSubtitleActionPopup");
        MmSubtitleAdapter r8 = this.n;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("subtitleAdapter");
    L18:
        r2.B2(SetsKt.emptySet());
        return;
    L17:
        r2 = r8;
        goto L18
    L21:
        return;
    L20:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void ia0(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r4, boolean r5) {
        MmRecordingViewModel r0 = ea0();
        MmRecordingUITab r1 = MmRecordingUITab.SUBTITLE;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r2 = r0.resolveQuotaCtaTrackingState$officesdk_minutes_base_ui_release(r1, r4);
        if (Intrinsics.areEqual(r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.a.a) == false) goto L5;
    L17:
        this.p = "";
        return;
    L5:
        if (Intrinsics.areEqual(r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.b.a) == true) goto L17;
        int r3 = com.ss.android.lark.officesdk.minutes.ui.record.recording.base.f.a;
        if (com.ss.android.lark.officesdk.minutes.ui.record.recording.base.f.a(r1, ea0().getState().q, r2) == true) goto L10;
        return;
    L10:
        Intrinsics.checkNotNullParameter(r2, "state");
        String r6 = r2.toString();
        if (r5 == false) goto L13;
    L15:
        this.p = r6;
        ea0().trackQuotaCtaView(r1, r4);
        return;
    L13:
        if (Intrinsics.areEqual(r6, this.p) == false) goto L15;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        int r13 = uvb.b.a;
        uvb.a.b(r11, uvb.c.i);
        uvb.b.a(r11, 2131387643, uvb.c.j);
        uvb.b.a(r11, 2131363768, uvb.c.n);
        int r14 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUBTITLE, "onViewCreated", "viewModel=" + ga0(), U90());
        final MmRecordingViewModel r15 = (MmRecordingViewModel) new ViewModelProvider(com.ss.android.lark.officesdk.minutes.ui.record.recording.a.a(this)).get(MmRecordingViewModel.class);
        MmRecordingSession r0 = r15.getSession();
        if (r0 == null) goto L8;
        String r1 = r0.e();
        if (r1 == null) goto L8;
        String r2 = r1;
    L9:
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r3 = r15.getUserContext();
        String r4 = r15.getMeetingId();
        if (r4 != null) goto L12;
        String r5 = "";
    L13:
        this.n = new MmSubtitleAdapter(r2, r3, r5, r15.getUiLaunchMode(), getViewLifecycleOwner(), new C02621(this, r15), new AnonymousClass2(this));
        this.B = new c(requireContext(), new b(this));
        MmRecordingUILaunchMode r16 = ea0().getUiLaunchMode();
        AppCompatImageView r17 = fa0().e;
        com.ss.android.lark.officesdk.minutes.ui.style.e.a.getClass();
        r17.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.e.b(r16).getShape().v(requireContext()));
        this.o = new StableLinearLayoutManager(getContext());
        RecyclerView r18 = fa0().b;
        RecyclerView.LayoutManager r19 = this.o;
        if (r19 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        r19 = null;
    L16:
        r18.setLayoutManager(r19);
        RecyclerView r110 = fa0().b;
        MmSubtitleAdapter r111 = this.n;
        if (r111 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("subtitleAdapter");
        r111 = null;
    L19:
        r110.setAdapter(r111);
        fa0().b.setHasFixedSize(true);
        this.r = fa0().b.getPaddingTop();
        this.s = fa0().b.getClipToPadding();
        fa0().b.setItemAnimator(null);
        this.v = new w(fa0().b);
        StableLinearLayoutManager r112 = this.o;
        if (r112 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        r112 = null;
    L22:
        w r113 = this.v;
        if (r113 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("stackFromEndController");
        r113 = null;
    L25:
        r112.b = r113;
        ConstraintLayout r114 = fa0().a;
        if ((r114 instanceof ConstraintLayout) == false) goto L28;
        ConstraintLayout r115 = r114;
    L29:
        if (r115 == null) goto L32;
        com.ss.android.lark.officesdk.minutes.ui.style.e.b(ea0().getUiLaunchMode()).getQuotaCta().create(r115.getContext());
    L32:
        RecyclerView r6 = fa0().b;
        StableLinearLayoutManager r116 = this.o;
        if (r116 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        StableLinearLayoutManager r7 = null;
    L36:
        UDShadowLayout r8 = fa0().d;
        w r117 = this.v;
        if (r117 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("stackFromEndController");
        w r9 = null;
    L40:
        this.w = new MmSubtitleScrollHelper(r6, r7, r8, r9, new n(this));
        RecyclerView r118 = fa0().b;
        MmSubtitleScrollHelper r119 = this.w;
        if (r119 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("scrollHelper");
        r119 = null;
    L43:
        r118.addOnScrollListener(r119);
        MmSubtitleAdapter r120 = this.n;
        if (r120 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("subtitleAdapter");
        r120 = null;
    L46:
        MmSubtitleScrollHelper r121 = this.w;
        if (r121 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("scrollHelper");
        r121 = null;
    L49:
        r120.registerAdapterDataObserver(r121.g);
        aa0(MmSubtitleFragment$subscribeData$1.INSTANCE, new MmSubtitleFragment$subscribeData$2(this, null));
        aa0(MmSubtitleFragment$subscribeData$3.INSTANCE, new MmSubtitleFragment$subscribeData$4(this, null));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new MmSubtitleFragment$subscribeQuotaCtaState$1(this, null), 3, null);
        ea0().selectSubscribe(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), MmSubtitleFragment$subscribeQuotaCtaState$2.INSTANCE, new MmSubtitleFragment$subscribeQuotaCtaState$3(new Ref.BooleanRef(), this, null));
        return;
    L39:
        r9 = r117;
        goto L40
    L35:
        r7 = r116;
        goto L36
    L28:
        r115 = null;
        goto L29
    L12:
        r5 = r4;
    L8:
        r2 = "";
        goto L9
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        super.onCreateView(r2, r3, r4);
        MmRecordingUILaunchMode r5 = ea0().getUiLaunchMode();
        com.ss.android.lark.officesdk.minutes.ui.style.e.a.getClass();
        mwb.i r6 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r5).getLayout().j(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r2.getContext(), r5)), r3);
        this.m = r6;
        return r6.a;
    }
}
