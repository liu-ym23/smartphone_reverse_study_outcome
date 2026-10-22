package com.obric.memorydata.memory.ui.list.contextawareness;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.CombinedLoadStates;
import androidx.paging.LoadState;
import androidx.paging.PagingData;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.memory.databinding.FragmentRecommendMemoryListBinding;
import com.obric.memorydata.memory.ui.list.MemoryContainerTab;
import com.obric.memorydata.memory.ui.list.MemoryListAdapter;
import com.obric.memorydata.memory.ui.list.MemoryListItemViewHolder;
import com.obric.memorydata.memory.ui.list.MemoryListShareViewModel;
import com.obric.memorydata.memory.ui.list.ObservationBuildMemoryTipsScope;
import com.obric.memorydata.memory.ui.list.ScreenObservationTipsViewModel;
import com.obric.memorydata.memory.ui.list.SelectionStateManager;
import com.obric.memorydata.memory.ui.list.ab;
import com.obric.memorydata.memory.ui.list.am;
import com.obric.memorydata.memory.ui.list.bl;
import com.obric.memorydata.memory.ui.list.z;
import com.obric.memorydata.memory.ui.settings.MemorySettingsViewModel;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.RecommendApi;
import com.obric.memorydata.ui.BaseFragment;
import com.obric.oui.orecyclerview.widget.ConcatAdapter;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u0000 V2\u00020\u0001:\u0001VB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u001a\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u0002032\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010=\u001a\u00020;H\u0016J\b\u0010>\u001a\u00020;H\u0002J\b\u0010?\u001a\u00020;H\u0002J\b\u0010@\u001a\u00020;H\u0002J\b\u0010A\u001a\u00020;H\u0002J\b\u0010B\u001a\u00020;H\u0002J\b\u0010C\u001a\u00020;H\u0002J\b\u0010D\u001a\u00020;H\u0002J\u0010\u0010E\u001a\u00020;2\u0006\u0010F\u001a\u00020\u0017H\u0002J\u0010\u0010G\u001a\u00020;2\u0006\u0010F\u001a\u00020\u0017H\u0002J\u0010\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020;2\u0006\u0010L\u001a\u00020\u0019H\u0002J\u0010\u0010M\u001a\u00020;2\u0006\u0010N\u001a\u00020OH\u0002J\b\u0010P\u001a\u00020;H\u0002J\n\u0010Q\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010R\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\u001cH\u0002J\b\u0010T\u001a\u00020;H\u0016J\b\u0010U\u001a\u00020;H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\"\u001a\u0004\b/\u00100¨\u0006W"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineListFragment;", "Lcom/obric/memorydata/ui/BaseFragment;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/FragmentRecommendMemoryListBinding;", "memoryListAdapter", "Lcom/obric/memorydata/memory/ui/list/MemoryListAdapter;", "loadingTipsAdapter", "Lcom/obric/memorydata/memory/ui/list/MemoryLoadingTipsAdapter;", "loadingHeaderAdapter", "Lcom/obric/memorydata/memory/ui/list/LoadingStateAdapter;", "concatAdapter", "Lcom/obric/oui/orecyclerview/widget/ConcatAdapter;", "currentDate", "Ljava/time/LocalDate;", "viewPager", "Lcom/obric/oui/viewpager2/widget/ViewPager2;", "recyclerViewInterceptor", "Lcom/obric/memorydata/memory/ui/ConflictWithViewPage2Handler;", "activeTarget", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessResolvedTarget;", "latestLoadStates", "Landroidx/paging/CombinedLoadStates;", "previousTotalCount", "", "Ljava/lang/Integer;", "hasCompletedFirstResume", "", "viewModel", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "shareViewModel", "Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "getShareViewModel", "()Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "shareViewModel$delegate", "tipsViewModel", "Lcom/obric/memorydata/memory/ui/list/ScreenObservationTipsViewModel;", "getTipsViewModel", "()Lcom/obric/memorydata/memory/ui/list/ScreenObservationTipsViewModel;", "tipsViewModel$delegate", "settingsViewModel", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsViewModel;", "getSettingsViewModel", "()Lcom/obric/memorydata/memory/ui/settings/MemorySettingsViewModel;", "settingsViewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "setupRecyclerView", "observeTimeline", "observeBuildMemoryTips", "observeSelection", "observeTotalCount", "observeRefreshEvents", "observeResolvedTarget", "renderLoadState", "loadStates", "advanceTargetSearch", "findTargetIndex", TypedValues.AttributesType.S_TARGET, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineTarget;", "scrollToMemoryItem", "memoryItemIndex", "completeTargetSearch", "requestId", "", "showTargetSearchFailed", "parseDate", "isAnyObservationSourceEnabled", "screenObservationEnabled", "onDestroyView", "onDestroy", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextAwarenessTimelineListFragment extends BaseFragment {
    public static final a Companion = null;
    private static final String KEY_DAY = "day";
    private static final String KEY_MONTH = "month";
    private static final String KEY_YEAR = "year";
    private h activeTarget;
    private FragmentRecommendMemoryListBinding binding;
    private ConcatAdapter concatAdapter;
    private LocalDate currentDate;
    private boolean hasCompletedFirstResume;
    private CombinedLoadStates latestLoadStates;
    private com.obric.memorydata.memory.ui.list.i loadingHeaderAdapter;
    private ab loadingTipsAdapter;
    private MemoryListAdapter memoryListAdapter;
    private Integer previousTotalCount;
    private com.obric.memorydata.memory.ui.a recyclerViewInterceptor;
    private final Lazy settingsViewModel$delegate;
    private final Lazy shareViewModel$delegate;
    private final Lazy tipsViewModel$delegate;
    private final Lazy viewModel$delegate;
    private ViewPager2 viewPager;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineListFragment$Companion;", "", "<init>", "()V", "KEY_YEAR", "", "KEY_MONTH", "KEY_DAY", "newInstance", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineListFragment;", "date", "Ljava/time/LocalDate;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final ContextAwarenessTimelineListFragment a(LocalDate r4) {
            Intrinsics.checkNotNullParameter(r4, "date");
            ContextAwarenessTimelineListFragment r3 = new ContextAwarenessTimelineListFragment();
            Bundle r0 = new Bundle();
            r0.putInt("year", r4.getYear());
            r0.putInt("month", r4.getMonthValue());
            r0.putInt("day", r4.getDayOfMonth());
            r3.setArguments(r0);
            return r3;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11254a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f11255b = null;

        static {
            int[] r0 = new int[ContextAwarenessTargetSearchAction.values().length];
            r0[ContextAwarenessTargetSearchAction.WAIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[ContextAwarenessTargetSearchAction.SCROLL_TO_TARGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L37:
            r0[ContextAwarenessTargetSearchAction.LOAD_NEXT_PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L29:
            r0[ContextAwarenessTargetSearchAction.LOAD_PREVIOUS_PAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L31:
            r0[ContextAwarenessTargetSearchAction.COMPLETE_NOT_FOUND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L23:
            r0[ContextAwarenessTargetSearchAction.COMPLETE_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L10:
            f11254a = r0;
            int[] r1 = new int[ContextAwarenessTimelineSource.values().length];
            r1[ContextAwarenessTimelineSource.SCREEN_CONTENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L33:
            r1[ContextAwarenessTimelineSource.AMBIENT_AUDIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L13:
            f11255b = r1;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeBuildMemoryTips$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeBuildMemoryTips$1", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeBuildMemoryTips$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "tips", "Lcom/obric/memorydata/memory/ui/list/TipsData;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeBuildMemoryTips$1$1", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C06001 extends SuspendLambda implements Function2<bl, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

            C06001(ContextAwarenessTimelineListFragment r3, Continuation<? super C06001> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                C06001 r0 = new C06001(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(bl r3, Continuation<? super Unit> r4) {
                return ((C06001) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C06001.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(bl r3, Continuation<? super Unit> r4) {
                return invoke2((bl) ZeusTransformUtils.preCheckCast(r3, bl.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L14;
                ResultKt.throwOnFailure(r3);
                bl r4 = (bl) ZeusTransformUtils.preCheckCast(this.L$0, bl.class, "com.obric.memorydata.plugin");
                FragmentRecommendMemoryListBinding r0 = ContextAwarenessTimelineListFragment.access$getBinding$p(this.this$0);
                ab r1 = null;
                if (r0 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r0 = null;
            L7:
                ab r2 = ContextAwarenessTimelineListFragment.access$getLoadingTipsAdapter$p(this.this$0);
                if (r2 != null) goto L10;
                Intrinsics.throwUninitializedPropertyAccessException("loadingTipsAdapter");
            L11:
                am.a(r0, r4, r1);
                return Unit.INSTANCE;
            L10:
                r1 = r2;
                goto L11
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(ContextAwarenessTimelineListFragment r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineListFragment.access$getTipsViewModel(this.this$0).getPendingBuildObservationMemoryState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C06001(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeBuildMemoryTips$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeBuildMemoryTips$2", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeBuildMemoryTips$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeBuildMemoryTips$2$2", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C06012 extends SuspendLambda implements Function2<com.obric.memorydata.memory.ui.settings.k, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

            C06012(ContextAwarenessTimelineListFragment r3, Continuation<? super C06012> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                C06012 r0 = new C06012(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(com.obric.memorydata.memory.ui.settings.k r3, Continuation<? super Unit> r4) {
                return ((C06012) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C06012.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(com.obric.memorydata.memory.ui.settings.k r3, Continuation<? super Unit> r4) {
                return invoke2((com.obric.memorydata.memory.ui.settings.k) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.settings.k.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                com.obric.memorydata.memory.ui.settings.k r4 = (com.obric.memorydata.memory.ui.settings.k) ZeusTransformUtils.preCheckCast(this.L$0, com.obric.memorydata.memory.ui.settings.k.class, "com.obric.memorydata.plugin");
                ContextAwarenessTimelineListFragment.access$getTipsViewModel(this.this$0).setObservationMemoryEnabled(ContextAwarenessTimelineListFragment.access$isAnyObservationSourceEnabled(this.this$0, r4.c()));
                ContextAwarenessTimelineListFragment.access$getTipsViewModel(this.this$0).tryRefreshBuildMemoryTips();
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass2(ContextAwarenessTimelineListFragment r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        private static final boolean invokeSuspend$lambda$0(com.obric.memorydata.memory.ui.settings.k r0) {
            return r0.c();
        }

        public static /* synthetic */ boolean lambda$sNsqPRqJiSTNUz_HHfjVOydKzx4(com.obric.memorydata.memory.ui.settings.k r0) {
            return invokeSuspend$lambda$0(r0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
            kotlinx.coroutines.flow.i r8 = kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineListFragment.access$getSettingsViewModel(this.this$0).getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), $$Lambda$ContextAwarenessTimelineListFragment$observeBuildMemoryTips$2$sNsqPRqJiSTNUz_HHfjVOydKzx4.INSTANCE);
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C06012(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeRefreshEvents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeRefreshEvents$1", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {253}, m = "invokeSuspend", n = {}, s = {})
    static final class C11991 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeRefreshEvents$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeRefreshEvents$1$1", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C06021 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

            C06021(ContextAwarenessTimelineListFragment r3, Continuation<? super C06021> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C06021(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(Unit r3, Continuation<? super Unit> r4) {
                return invoke2((Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Unit r3, Continuation<? super Unit> r4) {
                return ((C06021) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C06021.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r2);
                if (Intrinsics.areEqual(ContextAwarenessTimelineListFragment.access$getShareViewModel(this.this$0).getSelectBottomTab().c(), MemoryContainerTab.CONTEXT_AWARENESS.getText()) == false) goto L11;
                MemoryListAdapter r3 = ContextAwarenessTimelineListFragment.access$getMemoryListAdapter$p(this.this$0);
                if (r3 != null) goto L9;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r3 = null;
            L9:
                r3.b();
                ContextAwarenessTimelineListFragment.access$getViewModel(this.this$0).refreshCalendar();
            L11:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C11991(ContextAwarenessTimelineListFragment r3, Continuation<? super C11991> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11991(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11991) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11991.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineListFragment.access$getShareViewModel(this.this$0).getMemoryDeleteFlow(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C06021(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeResolvedTarget$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeResolvedTarget$1", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {267}, m = "invokeSuspend", n = {}, s = {})
    static final class C12001 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeResolvedTarget$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "resolvedTarget", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessResolvedTarget;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeResolvedTarget$1$1", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C06031 extends SuspendLambda implements Function2<h, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

            C06031(ContextAwarenessTimelineListFragment r3, Continuation<? super C06031> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                C06031 r0 = new C06031(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(h r3, Continuation<? super Unit> r4) {
                return ((C06031) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C06031.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(h r3, Continuation<? super Unit> r4) {
                return invoke2((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L19;
                ResultKt.throwOnFailure(r5);
                h r6 = (h) ZeusTransformUtils.preCheckCast(this.L$0, h.class, "com.obric.memorydata.plugin");
                ContextAwarenessTimelineListFragment r0 = this.this$0;
                if (r6 == null) goto L12;
                LocalDate r2 = r6.b();
                LocalDate r3 = ContextAwarenessTimelineListFragment.access$getCurrentDate$p(r0);
                if (r3 != null) goto L10;
                Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                r3 = null;
            L10:
                if (Intrinsics.areEqual(r2, r3) == false) goto L12;
            L13:
                ContextAwarenessTimelineListFragment.access$setActiveTarget$p(r0, r6);
                CombinedLoadStates r7 = ContextAwarenessTimelineListFragment.access$getLatestLoadStates$p(this.this$0);
                if (r7 == null) goto L17;
                ContextAwarenessTimelineListFragment.access$advanceTargetSearch(this.this$0, r7);
            L17:
                return Unit.INSTANCE;
            L12:
                r6 = null;
                goto L13
            L19:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C12001(ContextAwarenessTimelineListFragment r3, Continuation<? super C12001> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12001(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12001) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12001.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineListFragment.access$getViewModel(this.this$0).getResolvedTarget(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C06031(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeSelection$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeSelection$1", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
    static final class C12011 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeSelection$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isEditMode", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeSelection$1$1", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C06041 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            /* synthetic */ boolean Z$0;
            int label;
            final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

            C06041(ContextAwarenessTimelineListFragment r3, Continuation<? super C06041> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            private static final Unit invokeSuspend$lambda$0(ContextAwarenessTimelineListFragment r4, boolean r5) {
                MemoryListAdapter r0 = ContextAwarenessTimelineListFragment.access$getMemoryListAdapter$p(r4);
                MemoryListAdapter r1 = null;
                if (r0 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r0 = null;
            L5:
                MemoryListAdapter r6 = ContextAwarenessTimelineListFragment.access$getMemoryListAdapter$p(r4);
                if (r6 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
            L9:
                r0.a(0, r1.d(), new MemoryListAdapter.Companion.a("edit_mode", Boolean.valueOf(r5)));
                return Unit.INSTANCE;
            L8:
                r1 = r6;
                goto L9
            }

            public static /* synthetic */ Unit lambda$OTdgkgJSmr7KCC1PTd_149O2eHY(ContextAwarenessTimelineListFragment r0, boolean r1) {
                return invokeSuspend$lambda$0(r0, r1);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                C06041 r0 = new C06041(this.this$0, r5);
                r0.Z$0 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(Boolean r3, Continuation<? super Unit> r4) {
                return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            public final Object invoke(boolean r3, Continuation<? super Unit> r4) {
                Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return ((C06041) ZeusTransformUtils.preCheckCast(create(Boolean.valueOf(r3), r5), C06041.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r5);
                final boolean r6 = this.Z$0;
                com.obric.memorydata.memory.ui.a r0 = ContextAwarenessTimelineListFragment.access$getRecyclerViewInterceptor$p(this.this$0);
                if (r0 == null) goto L7;
                r0.a(!r6);
            L7:
                ContextAwarenessTimelineListFragment r1 = this.this$0;
                FragmentRecommendMemoryListBinding r2 = ContextAwarenessTimelineListFragment.access$getBinding$p(r1);
                if (r2 != null) goto L10;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r2 = null;
            L10:
                RecyclerView r3 = r2.rvMemoryList;
                Intrinsics.checkNotNullExpressionValue(r3, "rvMemoryList");
                View r4 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");
                final ContextAwarenessTimelineListFragment r7 = this.this$0;
                ContextAwarenessTimelineListFragment.access$safeViewPost(r1, r4, new $$Lambda$ContextAwarenessTimelineListFragment$observeSelection$1$1$OTdgkgJSmr7KCC1PTd_149O2eHY(r7, r6));
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C12011(ContextAwarenessTimelineListFragment r3, Continuation<? super C12011> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12011(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12011) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12011.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineListFragment.access$getShareViewModel(this.this$0).getSelectionManager().b(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C06041(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeSelection$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeSelection$2", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
    static final class C12022 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeSelection$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager$SelectAllState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeSelection$2$1", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<SelectionStateManager.SelectAllState, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

            AnonymousClass1(ContextAwarenessTimelineListFragment r3, Continuation<? super AnonymousClass1> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            private static final Unit invokeSuspend$lambda$0(ContextAwarenessTimelineListFragment r5) {
                MemoryListAdapter r0 = ContextAwarenessTimelineListFragment.access$getMemoryListAdapter$p(r5);
                if (r0 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r0 = null;
            L5:
                MemoryListAdapter r6 = ContextAwarenessTimelineListFragment.access$getMemoryListAdapter$p(r5);
                if (r6 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r6 = null;
            L8:
                r0.a(0, r6.d(), new MemoryListAdapter.Companion.a("selection", null));
                return Unit.INSTANCE;
            }

            public static /* synthetic */ Unit lambda$Ozkwj5WxY1YUT6_4QgC6eMZUs38(ContextAwarenessTimelineListFragment r0) {
                return invokeSuspend$lambda$0(r0);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(SelectionStateManager.SelectAllState r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(SelectionStateManager.SelectAllState r3, Continuation<? super Unit> r4) {
                return invoke2((SelectionStateManager.SelectAllState) ZeusTransformUtils.preCheckCast(r3, SelectionStateManager.SelectAllState.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r4);
                ContextAwarenessTimelineListFragment r5 = this.this$0;
                FragmentRecommendMemoryListBinding r0 = ContextAwarenessTimelineListFragment.access$getBinding$p(r5);
                if (r0 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r0 = null;
            L7:
                RecyclerView r1 = r0.rvMemoryList;
                Intrinsics.checkNotNullExpressionValue(r1, "rvMemoryList");
                View r2 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
                final ContextAwarenessTimelineListFragment r3 = this.this$0;
                ContextAwarenessTimelineListFragment.access$safeViewPost(r5, r2, new $$Lambda$ContextAwarenessTimelineListFragment$observeSelection$2$1$Ozkwj5WxY1YUT6_4QgC6eMZUs38(r3));
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C12022(ContextAwarenessTimelineListFragment r3, Continuation<? super C12022> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12022(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12022) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12022.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineListFragment.access$getShareViewModel(this.this$0).getSelectionManager().c(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeTimeline$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeTimeline$1", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
    static final class C12031 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeTimeline$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeTimeline$1$1", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
        static final class C06051 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> $flow;
            int label;
            final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeTimeline$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            /* synthetic */ class C06061 extends FunctionReferenceImpl implements SuspendFunction, Function2<PagingData<com.obric.memorydata.memory.ui.data.a>, Continuation<? super Unit>, Object> {
                C06061(Object r8) {
                    super(2, r8, MemoryListAdapter.class, "submitData", "submitData(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(PagingData<com.obric.memorydata.memory.ui.data.a> r3, Continuation<? super Unit> r4) {
                    Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    return ((MemoryListAdapter) ZeusTransformUtils.preCheckCast(this.receiver, MemoryListAdapter.class, "com.obric.memorydata.plugin")).a(r3, r5);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Object invoke(PagingData<com.obric.memorydata.memory.ui.data.a> r3, Continuation<? super Unit> r4) {
                    return invoke2((PagingData) ZeusTransformUtils.preCheckCast(r3, PagingData.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                }
            }

            C06051(kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r3, ContextAwarenessTimelineListFragment r4, Continuation<? super C06051> r5) {
                kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r6 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.$flow = r6;
                this.this$0 = r4;
                super(2, r7);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C06051(this.$flow, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((C06051) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C06051.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r6);
            L15:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r7 = this.$flow;
                MemoryListAdapter r3 = ContextAwarenessTimelineListFragment.access$getMemoryListAdapter$p(this.this$0);
                if (r3 != null) goto L11;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r3 = null;
            L11:
                Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C06061(r3), Function2.class, "com.obric.memorydata.plugin");
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                if (kotlinx.coroutines.flow.k.a(r7, r2, r4) != r0) goto L15;
                return r0;
            }
        }

        C12031(ContextAwarenessTimelineListFragment r3, Continuation<? super C12031> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12031(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12031) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12031.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            ContextAwarenessTimelineViewModel r10 = ContextAwarenessTimelineListFragment.access$getViewModel(this.this$0);
            LocalDate r2 = ContextAwarenessTimelineListFragment.access$getCurrentDate$p(this.this$0);
            if (r2 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            r2 = null;
        L11:
            kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r11 = r10.timeline(r2);
            LifecycleOwner r3 = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(r3, "getViewLifecycleOwner(...)");
            kotlinx.coroutines.flow.i r12 = CachedPagingDataKt.cachedIn(r11, (al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r3), al.class, "com.obric.memorydata.plugin"));
            LifecycleOwner r4 = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(r4, "getViewLifecycleOwner(...)");
            Lifecycle.State r5 = z.f11341a.a();
            Function2 r13 = (Function2) ZeusTransformUtils.preCheckCast(new C06051(r12, this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r4, r5, r13, r6) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeTimeline$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeTimeline$2", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
    static final class C12042 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeTimeline$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements SuspendFunction, Function2<CombinedLoadStates, Continuation<? super Unit>, Object> {
            AnonymousClass1(Object r8) {
                super(2, r8, ContextAwarenessTimelineListFragment.class, "renderLoadState", "renderLoadState(Landroidx/paging/CombinedLoadStates;)V", 4);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CombinedLoadStates r3, Continuation<? super Unit> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return C12042.access$invokeSuspend$renderLoadState((ContextAwarenessTimelineListFragment) ZeusTransformUtils.preCheckCast(this.receiver, ContextAwarenessTimelineListFragment.class, "com.obric.memorydata.plugin"), r3, r5);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(CombinedLoadStates r3, Continuation<? super Unit> r4) {
                return invoke2((CombinedLoadStates) ZeusTransformUtils.preCheckCast(r3, CombinedLoadStates.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }
        }

        C12042(ContextAwarenessTimelineListFragment r3, Continuation<? super C12042> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        public static final /* synthetic */ Object access$invokeSuspend$renderLoadState(ContextAwarenessTimelineListFragment r2, CombinedLoadStates r3, Continuation r4) {
            return invokeSuspend$renderLoadState(r2, r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        private static final /* synthetic */ Object invokeSuspend$renderLoadState(ContextAwarenessTimelineListFragment r2, CombinedLoadStates r3, Continuation r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            ContextAwarenessTimelineListFragment.access$renderLoadState(r2, r3);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12042(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12042) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12042.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            MemoryListAdapter r7 = ContextAwarenessTimelineListFragment.access$getMemoryListAdapter$p(this.this$0);
            if (r7 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
            r7 = null;
        L11:
            kotlinx.coroutines.flow.i<CombinedLoadStates> r8 = r7.e();
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeTotalCount$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeTotalCount$1", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {})
    static final class C12051 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeTotalCount$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "totalCount", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$observeTotalCount$1$1", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C06071 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
            /* synthetic */ int I$0;
            int label;
            final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

            C06071(ContextAwarenessTimelineListFragment r3, Continuation<? super C06071> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                C06071 r0 = new C06071(this.this$0, r5);
                r0.I$0 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue();
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            public final Object invoke(int r3, Continuation<? super Unit> r4) {
                Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return ((C06071) ZeusTransformUtils.preCheckCast(create(Integer.valueOf(r3), r5), C06071.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(Integer r3, Continuation<? super Unit> r4) {
                return invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r6) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L17;
                ResultKt.throwOnFailure(r6);
                int r7 = this.I$0;
                SelectionStateManager.a r0 = SelectionStateManager.f11168a;
                String[] r1 = new String[2];
                r1[0] = MemoryContainerTab.CONTEXT_AWARENESS.getText();
                LocalDate r3 = ContextAwarenessTimelineListFragment.access$getCurrentDate$p(this.this$0);
                MemoryListAdapter r4 = null;
                if (r3 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("currentDate");
                r3 = null;
            L7:
                r1[1] = r3.toString();
                ContextAwarenessTimelineListFragment.access$getShareViewModel(this.this$0).getSelectionManager().a(r0.a(r1), r7);
                Integer r2 = ContextAwarenessTimelineListFragment.access$getPreviousTotalCount$p(this.this$0);
                ContextAwarenessTimelineListFragment.access$setPreviousTotalCount$p(this.this$0, Boxing.boxInt(r7));
                if (r2 == null) goto L15;
                MemoryListAdapter r8 = ContextAwarenessTimelineListFragment.access$getMemoryListAdapter$p(this.this$0);
                if (r8 != null) goto L12;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
            L13:
                r4.b();
                ContextAwarenessTimelineListFragment.access$getViewModel(this.this$0).refreshCalendar();
                goto L15
            L12:
                r4 = r8;
            L15:
                return Unit.INSTANCE;
            L17:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C12051(ContextAwarenessTimelineListFragment r3, Continuation<? super C12051> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12051(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12051) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12051.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ContextAwarenessTimelineViewModel r7 = ContextAwarenessTimelineListFragment.access$getViewModel(this.this$0);
            LocalDate r2 = ContextAwarenessTimelineListFragment.access$getCurrentDate$p(this.this$0);
            if (r2 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            r2 = null;
        L11:
            kotlinx.coroutines.flow.i<Integer> r8 = r7.observeTotalCount(r2);
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new C06071(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r3, r4) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineListFragment$onResume$1", f = "ContextAwarenessTimelineListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C12061 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineListFragment this$0;

        C12061(ContextAwarenessTimelineListFragment r3, Continuation<? super C12061> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12061(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12061) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12061.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            ContextAwarenessTimelineListFragment.access$getTipsViewModel(this.this$0).setCellularEnable(RecommendApi.INSTANCE.getScreenObservationCellularEnabled());
            ContextAwarenessTimelineListFragment.access$getTipsViewModel(this.this$0).tryRefreshBuildMemoryTips();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public ContextAwarenessTimelineListFragment() {
        this.viewModel$delegate = LazyKt.lazy(new $$Lambda$ContextAwarenessTimelineListFragment$ezLaiOsNQ5eF4A7TACZqwLnto(this));
        this.shareViewModel$delegate = LazyKt.lazy(new $$Lambda$ContextAwarenessTimelineListFragment$ZCfDuKt6ohBTaFIt7N2KnShcPw(this));
        this.tipsViewModel$delegate = LazyKt.lazy(new $$Lambda$ContextAwarenessTimelineListFragment$C1V5BoofZ7MBie5wIMG3mxLopo(this));
        this.settingsViewModel$delegate = LazyKt.lazy(new $$Lambda$ContextAwarenessTimelineListFragment$z72pw8VYaYcr8sFARkKZMydgJe0(this));
    }

    public static final /* synthetic */ void access$advanceTargetSearch(ContextAwarenessTimelineListFragment r0, CombinedLoadStates r1) {
        r0.advanceTargetSearch(r1);
    }

    public static final /* synthetic */ FragmentRecommendMemoryListBinding access$getBinding$p(ContextAwarenessTimelineListFragment r0) {
        return r0.binding;
    }

    public static final /* synthetic */ LocalDate access$getCurrentDate$p(ContextAwarenessTimelineListFragment r0) {
        return r0.currentDate;
    }

    public static final /* synthetic */ CombinedLoadStates access$getLatestLoadStates$p(ContextAwarenessTimelineListFragment r0) {
        return r0.latestLoadStates;
    }

    public static final /* synthetic */ ab access$getLoadingTipsAdapter$p(ContextAwarenessTimelineListFragment r0) {
        return r0.loadingTipsAdapter;
    }

    public static final /* synthetic */ MemoryListAdapter access$getMemoryListAdapter$p(ContextAwarenessTimelineListFragment r0) {
        return r0.memoryListAdapter;
    }

    public static final /* synthetic */ Integer access$getPreviousTotalCount$p(ContextAwarenessTimelineListFragment r0) {
        return r0.previousTotalCount;
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.a access$getRecyclerViewInterceptor$p(ContextAwarenessTimelineListFragment r0) {
        return r0.recyclerViewInterceptor;
    }

    public static final /* synthetic */ MemorySettingsViewModel access$getSettingsViewModel(ContextAwarenessTimelineListFragment r0) {
        return r0.getSettingsViewModel();
    }

    public static final /* synthetic */ MemoryListShareViewModel access$getShareViewModel(ContextAwarenessTimelineListFragment r0) {
        return r0.getShareViewModel();
    }

    public static final /* synthetic */ ScreenObservationTipsViewModel access$getTipsViewModel(ContextAwarenessTimelineListFragment r0) {
        return r0.getTipsViewModel();
    }

    public static final /* synthetic */ ContextAwarenessTimelineViewModel access$getViewModel(ContextAwarenessTimelineListFragment r0) {
        return r0.getViewModel();
    }

    public static final /* synthetic */ boolean access$isAnyObservationSourceEnabled(ContextAwarenessTimelineListFragment r0, boolean r1) {
        return r0.isAnyObservationSourceEnabled(r1);
    }

    public static final /* synthetic */ void access$renderLoadState(ContextAwarenessTimelineListFragment r0, CombinedLoadStates r1) {
        r0.renderLoadState(r1);
    }

    public static final /* synthetic */ void access$safeViewPost(ContextAwarenessTimelineListFragment r2, View r3, Function0 r4) {
        r2.safeViewPost(r3, (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$setActiveTarget$p(ContextAwarenessTimelineListFragment r0, h r1) {
        r0.activeTarget = r1;
    }

    public static final /* synthetic */ void access$setPreviousTotalCount$p(ContextAwarenessTimelineListFragment r0, Integer r1) {
        r0.previousTotalCount = r1;
    }

    private final void advanceTargetSearch(CombinedLoadStates r10) {
        h r0 = this.activeTarget;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = findTargetIndex(r0.a().b());
        o r2 = o.f11282a;
        MemoryListAdapter r3 = this.memoryListAdapter;
        ConcatAdapter r8 = null;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
        r3 = null;
    L9:
        switch(b.f11254a[r2.a(r1, r3.d(), ZeusTransformUtils.instanceOf(r10.getRefresh(), LoadState.NotLoading.class), r10.getAppend(), r10.getPrepend()).ordinal()]) {
            case 1: goto L25;
            case 2: goto L22;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L23;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        showTargetSearchFailed();
        goto L23
    L13:
        scrollToMemoryItem(0);
        return;
    L14:
        FragmentRecommendMemoryListBinding r11 = this.binding;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L17:
        RecyclerView r12 = r11.rvMemoryList;
        ConcatAdapter r9 = this.concatAdapter;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
    L21:
        r12.scrollToPosition(RangesKt.coerceAtLeast(r8.d() - 1, 0));
        return;
    L20:
        r8 = r9;
        goto L21
    L22:
        scrollToMemoryItem(r1);
    L23:
        completeTargetSearch(r0.c());
        return;
    L25:
        return;
    L11:
        throw new NoWhenBranchMatchedException();
    }

    private final void completeTargetSearch(long r5) {
        h r0 = this.activeTarget;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == true) goto L9;
        return;
    L9:
        this.activeTarget = null;
        getViewModel().clearResolvedTarget(Long.valueOf(r5));
        getShareViewModel().completeContextAwarenessTarget$memory_obricRelease(r5);
        return;
    L5:
        if (r0.c() != r5) goto L7;
        r1 = true;
        goto L7
    }

    private final int findTargetIndex(v r8) {
        MemoryListAdapter r7 = this.memoryListAdapter;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
        r7 = null;
    L5:
        Iterator r9 = ((List) ZeusTransformUtils.preCheckCast(r7.c(), List.class, "com.obric.memorydata.plugin")).iterator();
        int r2 = 0;
    L7:
        if (r9.hasNext() == false) goto L28;
        com.obric.memorydata.memory.ui.data.a r3 = (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
        int r4 = b.f11255b[r8.a().ordinal()];
        boolean r5 = true;
        if (r4 == 1) goto L20;
        if (r4 != 2) goto L18;
        if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.memory.ui.data.a.C0539a.class) == true) goto L15;
    L24:
        r5 = false;
    L25:
        if (r5 == true) goto L33;
        r2 = r2 + 1;
        goto L7
    L33:
        return r2;
    L15:
        if (Intrinsics.areEqual(((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getEntityId(), r8.b()) == false) goto L24;
    L18:
        throw new NoWhenBranchMatchedException();
    L20:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L24;
        if (Intrinsics.areEqual(((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getEntityId(), r8.b()) == false) goto L24;
    L28:
        return -1;
    }

    private final MemorySettingsViewModel getSettingsViewModel() {
        return (MemorySettingsViewModel) ZeusTransformUtils.preCheckCast(this.settingsViewModel$delegate.getValue(), MemorySettingsViewModel.class, "com.obric.memorydata.plugin");
    }

    private final MemoryListShareViewModel getShareViewModel() {
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(this.shareViewModel$delegate.getValue(), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    private final ScreenObservationTipsViewModel getTipsViewModel() {
        return (ScreenObservationTipsViewModel) ZeusTransformUtils.preCheckCast(this.tipsViewModel$delegate.getValue(), ScreenObservationTipsViewModel.class, "com.obric.memorydata.plugin");
    }

    private final ContextAwarenessTimelineViewModel getViewModel() {
        return (ContextAwarenessTimelineViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), ContextAwarenessTimelineViewModel.class, "com.obric.memorydata.plugin");
    }

    private final boolean isAnyObservationSourceEnabled(boolean r2) {
        return ObservationBuildMemoryTipsScope.CONTEXT_AWARENESS.isAnySourceEnabled(r2, com.obric.memorydata.memory.glasses.a.f10137a.a());
    }

    /* JADX INFO: renamed from: lambda$C1V-5BoofZ7MBie5wIMG3mxLopo, reason: not valid java name */
    public static /* synthetic */ ScreenObservationTipsViewModel m939lambda$C1V5BoofZ7MBie5wIMG3mxLopo(ContextAwarenessTimelineListFragment r0) {
        return tipsViewModel_delegate$lambda$2(r0);
    }

    /* JADX INFO: renamed from: lambda$ZCfDuKt6ohB-TaFIt7N2KnShcPw, reason: not valid java name */
    public static /* synthetic */ MemoryListShareViewModel m940lambda$ZCfDuKt6ohBTaFIt7N2KnShcPw(ContextAwarenessTimelineListFragment r0) {
        return shareViewModel_delegate$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$ezLaiOsNQ5eF4A7TACZq-wLn-to, reason: not valid java name */
    public static /* synthetic */ ContextAwarenessTimelineViewModel m941lambda$ezLaiOsNQ5eF4A7TACZqwLnto(ContextAwarenessTimelineListFragment r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ MemorySettingsViewModel lambda$z72pw8VYaYcr8sFARkKZMydgJe0(ContextAwarenessTimelineListFragment r0) {
        return settingsViewModel_delegate$lambda$3(r0);
    }

    private final void observeBuildMemoryTips() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        LifecycleOwner r1 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r1, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r1), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void observeRefreshEvents() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11991(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void observeResolvedTarget() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C12001(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void observeSelection() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C12011(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        LifecycleOwner r1 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r1, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r1), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C12022(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void observeTimeline() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C12031(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        LifecycleOwner r1 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r1, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r1), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C12042(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void observeTotalCount() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C12051(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final LocalDate parseDate() {
        Bundle r5 = getArguments();
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.containsKey("year") == true) goto L8;
        return null;
    L8:
        if (r5.containsKey("month") == true) goto L10;
        return null;
    L10:
        if (r5.containsKey("day") == false) goto L19;
        return LocalDate.of(r5.getInt("year"), r5.getInt("month"), r5.getInt("day"));
    L20:
        return null;
    L19:
        return null;
    }

    private final void renderLoadState(CombinedLoadStates r8) {
        this.latestLoadStates = r8;
        LoadState r0 = r8.getRefresh();
        if (ZeusTransformUtils.instanceOf(r0, LoadState.Loading.class) == true) goto L50;
        int r2 = 8;
        FragmentRecommendMemoryListBinding r5 = null;
        if (ZeusTransformUtils.instanceOf(r0, LoadState.NotLoading.class) == false) goto L36;
        MemoryListAdapter r1 = this.memoryListAdapter;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
        r1 = null;
    L10:
        if (r1.d() <= 0) goto L12;
        boolean r3 = true;
    L13:
        FragmentRecommendMemoryListBinding r4 = this.binding;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L16:
        LinearLayout r6 = r4.layoutEmpty;
        if (r3 == false) goto L19;
        int r7 = 8;
    L20:
        r6.setVisibility(r7);
        FragmentRecommendMemoryListBinding r9 = this.binding;
        if (r9 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L23:
        RecyclerView r10 = r9.rvMemoryList;
        if (r3 == false) goto L26;
        int r11 = 0;
    L27:
        r10.setVisibility(r11);
        FragmentRecommendMemoryListBinding r12 = this.binding;
        if (r12 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L31:
        View r13 = r5.listTimeLine;
        if (r3 == false) goto L34;
        r2 = 0;
    L34:
        r13.setVisibility(r2);
        goto L50
    L30:
        r5 = r12;
        goto L31
    L26:
        r11 = 8;
        goto L27
    L19:
        r7 = 0;
        goto L20
    L12:
        r3 = false;
        goto L13
    L36:
        if (ZeusTransformUtils.instanceOf(r0, LoadState.Error.class) == false) goto L49;
        FragmentRecommendMemoryListBinding r14 = this.binding;
        if (r14 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L40:
        r14.layoutEmpty.setVisibility(0);
        FragmentRecommendMemoryListBinding r15 = this.binding;
        if (r15 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L43:
        r15.rvMemoryList.setVisibility(8);
        FragmentRecommendMemoryListBinding r16 = this.binding;
        if (r16 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L47:
        r5.listTimeLine.setVisibility(8);
        goto L50
    L46:
        r5 = r16;
        goto L47
    L49:
        throw new NoWhenBranchMatchedException();
    L50:
        advanceTargetSearch(r8);
    }

    private final void scrollToMemoryItem(int r5) {
        ab r0 = this.loadingTipsAdapter;
        ConcatAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingTipsAdapter");
        r0 = null;
    L5:
        int r2 = r0.d();
        com.obric.memorydata.memory.ui.list.i r3 = this.loadingHeaderAdapter;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadingHeaderAdapter");
        r3 = null;
    L8:
        int r4 = (r2 + r3.d()) + r5;
        ConcatAdapter r6 = this.concatAdapter;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        r6 = null;
    L12:
        if (r6.d() <= 0) goto L22;
        FragmentRecommendMemoryListBinding r7 = this.binding;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L16:
        RecyclerView r8 = r7.rvMemoryList;
        ConcatAdapter r9 = this.concatAdapter;
        if (r9 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
    L20:
        r8.scrollToPosition(RangesKt.coerceIn(r4, 0, r1.d() - 1));
        return;
    L19:
        r1 = r9;
        goto L20
    }

    private static final MemorySettingsViewModel settingsViewModel_delegate$lambda$3(ContextAwarenessTimelineListFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (MemorySettingsViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(MemorySettingsViewModel.class), MemorySettingsViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void setupRecyclerView() {
        this.loadingTipsAdapter = new ab();
        this.loadingHeaderAdapter = new com.obric.memorydata.memory.ui.list.i();
        com.obric.memorydata.memory.ui.list.i r0 = new com.obric.memorydata.memory.ui.list.i();
        this.memoryListAdapter = new MemoryListAdapter(getShareViewModel().getSelectionManager(), MemoryListItemViewHolder.Companion.ItemRelatedPage.CONTEXT_AWARENESS_PAGE, true);
        RecyclerView.Adapter[] r2 = new RecyclerView.Adapter[2];
        ab r3 = this.loadingTipsAdapter;
        ConcatAdapter r5 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingTipsAdapter");
        r3 = null;
    L5:
        r2[0] = r3;
        MemoryListAdapter r4 = this.memoryListAdapter;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
        r4 = null;
    L8:
        com.obric.memorydata.memory.ui.list.i r7 = this.loadingHeaderAdapter;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadingHeaderAdapter");
        r7 = null;
    L11:
        r2[1] = r4.a((com.obric.memorydata.ui.recyclerview.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.ui.recyclerview.a.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.ui.recyclerview.a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.ui.recyclerview.a.class, "com.obric.memorydata.plugin"));
        this.concatAdapter = new ConcatAdapter(r2);
        FragmentRecommendMemoryListBinding r1 = this.binding;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L14:
        RecyclerView r6 = r1.rvMemoryList;
        r6.setClipToPadding(false);
        LinearLayoutManager r8 = new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r8.b(true);
        r8.a(true);
        r6.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(r8, RecyclerView.h.class, "com.obric.memorydata.plugin"));
        ConcatAdapter r9 = this.concatAdapter;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
    L18:
        r6.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r5, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r6);
        this.recyclerViewInterceptor = new com.obric.memorydata.memory.ui.a(r6, this.viewPager, false, false);
        com.obric.oui.orecyclerview.widget.h r10 = new com.obric.oui.orecyclerview.widget.h();
        r10.c(300);
        r10.b(100);
        r10.a(100);
        r10.d(0);
        r6.setItemAnimator((RecyclerView.e) ZeusTransformUtils.preCheckCast(r10, RecyclerView.e.class, "com.obric.memorydata.plugin"));
        return;
    L17:
        r5 = r9;
        goto L18
    }

    private static final MemoryListShareViewModel shareViewModel_delegate$lambda$1(ContextAwarenessTimelineListFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(MemoryListShareViewModel.class), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void showTargetSearchFailed() {
        FragmentActivity r7 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L6;
        com.obric.oui.toast.a.C0786a r1 = com.obric.oui.toast.a.f14807a;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(r7, Context.class, "com.obric.memorydata.plugin");
        String r3 = r7.getString(ZeusTransformUtils.mapRes(R.string.context_awareness_timeline_target_search_failed, TypedValues.Custom.S_STRING, "context_awareness_timeline_target_search_failed"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r1, r2, r3, 0, 4, null);
        return;
    }

    private static final ScreenObservationTipsViewModel tipsViewModel_delegate$lambda$2(ContextAwarenessTimelineListFragment r3) {
        return (ScreenObservationTipsViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r3, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(ScreenObservationTipsViewModel.class), ScreenObservationTipsViewModel.class, "com.obric.memorydata.plugin");
    }

    private static final ContextAwarenessTimelineViewModel viewModel_delegate$lambda$0(ContextAwarenessTimelineListFragment r3) {
        Fragment r4 = r3.requireParentFragment();
        Intrinsics.checkNotNullExpressionValue(r4, "requireParentFragment(...)");
        return (ContextAwarenessTimelineViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(ContextAwarenessTimelineViewModel.class), ContextAwarenessTimelineViewModel.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        LocalDate r7 = parseDate();
        if (r7 == null) goto L14;
        this.currentDate = r7;
        FragmentRecommendMemoryListBinding r8 = FragmentRecommendMemoryListBinding.inflate(r4, r5, false);
        Intrinsics.checkNotNullExpressionValue(r8, "inflate(...)");
        this.binding = r8;
        ScreenObservationTipsViewModel r9 = getTipsViewModel();
        LocalDate r10 = this.currentDate;
        FragmentRecommendMemoryListBinding r11 = null;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("currentDate");
        r10 = null;
    L7:
        r9.init$memory_obricRelease(r10, isAnyObservationSourceEnabled(((com.obric.memorydata.memory.ui.settings.k) ZeusTransformUtils.preCheckCast(getSettingsViewModel().getState().c(), com.obric.memorydata.memory.ui.settings.k.class, "com.obric.memorydata.plugin")).c()), ObservationBuildMemoryTipsScope.CONTEXT_AWARENESS);
        FragmentRecommendMemoryListBinding r3 = this.binding;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L11:
        ConstraintLayout r12 = r11.getRoot();
        Intrinsics.checkNotNullExpressionValue(r12, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin");
    L10:
        r11 = r3;
        goto L11
    L14:
        throw new IllegalArgumentException("ContextAwarenessTimelineListFragment requires a date".toString());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.currentDate == null) goto L8;
        SelectionStateManager r0 = getShareViewModel().getSelectionManager();
        SelectionStateManager.a r1 = SelectionStateManager.f11168a;
        String[] r2 = new String[2];
        r2[0] = MemoryContainerTab.CONTEXT_AWARENESS.getText();
        LocalDate r4 = this.currentDate;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("currentDate");
        r4 = null;
    L7:
        r2[1] = r4.toString();
        r0.b(r1.a(r2));
    L8:
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        com.obric.memorydata.memory.ui.a r0 = this.recyclerViewInterceptor;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.recyclerViewInterceptor = null;
        FragmentRecommendMemoryListBinding r1 = this.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        r1.rvMemoryList.setAdapter(null);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        MemoryListAdapter r1 = null;
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C12061(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        if (this.hasCompletedFirstResume == false) goto L9;
        MemoryListAdapter r2 = this.memoryListAdapter;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
    L8:
        r1.b();
        goto L9
    L7:
        r1 = r2;
    L9:
        this.hasCompletedFirstResume = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        Fragment r5 = getParentFragment();
        if (r5 == null) goto L7;
        View r6 = r5.getView();
        if (r6 == null) goto L7;
        ViewPager2 r7 = (ViewPager2) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.memory_list_container, OaidModel.KEY_ID, "memory_list_container")), ViewPager2.class, "com.obric.memorydata.plugin");
    L8:
        this.viewPager = r7;
        setupRecyclerView();
        observeTimeline();
        observeBuildMemoryTips();
        observeSelection();
        observeTotalCount();
        observeRefreshEvents();
        observeResolvedTarget();
        return;
    L7:
        r7 = null;
        goto L8
    }
}
