package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.CombinedLoadStates;
import androidx.paging.ItemSnapshotList;
import androidx.paging.PagingData;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.constants.Constants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.dao.EpisodicMemoryDao;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.databinding.FragmentRecommendMemoryListBinding;
import com.obric.memorydata.memory.ui.settings.MemorySettingsViewModel;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.RecommendApi;
import com.obric.memorydata.ui.BaseFragment;
import com.obric.oui.orecyclerview.widget.ConcatAdapter;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00101\u001a\u0002022\u0006\u00103\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00104\u001a\u000202H\u0016J\b\u00105\u001a\u000202H\u0002J\b\u00106\u001a\u000202H\u0002J\u0010\u00107\u001a\u0002022\u0006\u00108\u001a\u000209H\u0002J\n\u0010:\u001a\u0004\u0018\u00010&H\u0002J\b\u0010;\u001a\u000202H\u0002J\b\u0010<\u001a\u000202H\u0002J\u0018\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020(H\u0002J\u000e\u0010@\u001a\u000202H\u0082@¢\u0006\u0002\u0010AJ\u000e\u0010B\u001a\u000202H\u0082@¢\u0006\u0002\u0010AJ\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020DH\u0002J\b\u0010F\u001a\u000202H\u0016J\b\u0010G\u001a\u000202H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/ScreenObservationFragment;", "Lcom/obric/memorydata/ui/BaseFragment;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/FragmentRecommendMemoryListBinding;", "viewModel", "Lcom/obric/memorydata/memory/ui/list/ScreenObservationViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/list/ScreenObservationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "shareViewModel", "Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "getShareViewModel", "()Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "shareViewModel$delegate", "tipsViewModel", "Lcom/obric/memorydata/memory/ui/list/ScreenObservationTipsViewModel;", "getTipsViewModel", "()Lcom/obric/memorydata/memory/ui/list/ScreenObservationTipsViewModel;", "tipsViewModel$delegate", "settingViewModel", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsViewModel;", "getSettingViewModel", "()Lcom/obric/memorydata/memory/ui/settings/MemorySettingsViewModel;", "settingViewModel$delegate", "memoryListAdapter", "Lcom/obric/memorydata/memory/ui/list/MemoryListAdapter;", "loadingTipsAdapter", "Lcom/obric/memorydata/memory/ui/list/MemoryLoadingTipsAdapter;", "viewPager", "Lcom/obric/oui/viewpager2/widget/ViewPager2;", "recyclerViewInterceptor", "Lcom/obric/memorydata/memory/ui/ConflictWithViewPage2Handler;", "jumpTargetEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "currentDate", "Ljava/time/LocalDate;", "isFirstLoad", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "setupRecyclerView", "applyTitleBarPadding", "setRecyclerViewTopPadding", "topPadding", "", "parseDate", "observeData", "setupItemCountObservation", "scrollToItemIfNeeded", "entity", "isFirst", "clearMemoryList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectMemoryList", "pagingLifecycleSnapshot", "", "event", "onDestroy", "onDestroyView", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenObservationFragment extends BaseFragment {
    public static final a Companion = null;
    public static final String KEY_DAY = "day";
    public static final String KEY_MONTH = "month";
    public static final String KEY_YEAR = "year";
    private static final String TAG = "ScreenObservationFragment";
    private FragmentRecommendMemoryListBinding binding;
    private LocalDate currentDate;
    private boolean isFirstLoad;
    private AppEntity jumpTargetEntity;
    private ab loadingTipsAdapter;
    private MemoryListAdapter memoryListAdapter;
    private com.obric.memorydata.memory.ui.a recyclerViewInterceptor;
    private final Lazy settingViewModel$delegate;
    private final Lazy shareViewModel$delegate;
    private final Lazy tipsViewModel$delegate;
    private final Lazy viewModel$delegate;
    private ViewPager2 viewPager;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/ScreenObservationFragment$Companion;", "", "<init>", "()V", "TAG", "", "KEY_YEAR", "KEY_MONTH", "KEY_DAY", "newInstance", "Lcom/obric/memorydata/memory/ui/list/ScreenObservationFragment;", "date", "Ljava/time/LocalDate;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final ScreenObservationFragment a(LocalDate r4) {
            Intrinsics.checkNotNullParameter(r4, "date");
            ScreenObservationFragment r3 = new ScreenObservationFragment();
            Bundle r0 = new Bundle();
            r0.putInt("year", r4.getYear());
            r0.putInt("month", r4.getMonthValue());
            r0.putInt("day", r4.getDayOfMonth());
            r3.setArguments(r0);
            return r3;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$collectMemoryList$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationFragment$collectMemoryList$2", f = "ScreenObservationFragment.kt", i = {}, l = {291}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> $flow;
        int label;
        final /* synthetic */ ScreenObservationFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$collectMemoryList$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationFragment$collectMemoryList$2$1", f = "ScreenObservationFragment.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<PagingData<com.obric.memorydata.memory.ui.data.a>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ScreenObservationFragment this$0;

            AnonymousClass1(ScreenObservationFragment r3, Continuation<? super AnonymousClass1> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(PagingData<com.obric.memorydata.memory.ui.data.a> r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(PagingData<com.obric.memorydata.memory.ui.data.a> r3, Continuation<? super Unit> r4) {
                return invoke2((PagingData) ZeusTransformUtils.preCheckCast(r3, PagingData.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r11) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r11);
            L15:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r11);
                PagingData r12 = (PagingData) ZeusTransformUtils.preCheckCast(this.L$0, PagingData.class, "com.obric.memorydata.plugin");
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ScreenObservationFragment.TAG, ScreenObservationFragment.access$pagingLifecycleSnapshot(this.this$0, "SUBMIT"), false, 4, null);
                MemoryListAdapter r2 = ScreenObservationFragment.access$getMemoryListAdapter$p(this.this$0);
                if (r2 != null) goto L11;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r2 = null;
            L11:
                Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                if (r2.a(r12, r3) != r0) goto L15;
                return r0;
            }
        }

        AnonymousClass2(ScreenObservationFragment r3, kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r4, Continuation<? super AnonymousClass2> r5) {
            kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r6 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$flow = r6;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$flow, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.Object, kotlin.Unit] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            String r4 = "com.obric.memorydata.plugin";
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L7
        L15:
            IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            String r5 = ScreenObservationFragment.access$pagingLifecycleSnapshot(this.this$0, "COLLECTOR_STOP");
            r4 = ScreenObservationFragment.TAG;
            IRunLog.a.a(r3, ScreenObservationFragment.TAG, r5, false, 4, null);
            AnonymousClass2 this = Unit.INSTANCE;
            return this;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r12);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ScreenObservationFragment.TAG, ScreenObservationFragment.access$pagingLifecycleSnapshot(this.this$0, "COLLECTOR_START"), false, 4, null);
            kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r13 = this.$flow;     // Catch: Throwable -> L7
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            if (kotlinx.coroutines.flow.k.a(r13, r2, r6) != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r4), ScreenObservationFragment.TAG, ScreenObservationFragment.access$pagingLifecycleSnapshot(this.this$0, "COLLECTOR_STOP"), false, 4, null);
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$1", f = "ScreenObservationFragment.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class C05881<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ScreenObservationFragment f11122a;

            C05881(ScreenObservationFragment r1) {
                this.f11122a = r1;
            }

            private static final void a(ScreenObservationFragment r4, boolean r5) {
                MemoryListAdapter r0 = ScreenObservationFragment.access$getMemoryListAdapter$p(r4);
                MemoryListAdapter r1 = null;
                if (r0 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r0 = null;
            L5:
                MemoryListAdapter r6 = ScreenObservationFragment.access$getMemoryListAdapter$p(r4);
                if (r6 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
            L9:
                r0.a(0, r1.d(), new MemoryListAdapter.Companion.a("edit_mode", Boolean.valueOf(r5)));
                return;
            L8:
                r1 = r6;
                goto L9
            }

            /* JADX INFO: renamed from: lambda$9XxdMGCEXrWP0o41-2ElFM4gfkw, reason: not valid java name */
            public static /* synthetic */ void m921lambda$9XxdMGCEXrWP0o412ElFM4gfkw(ScreenObservationFragment r0, boolean r1) {
                a(r0, r1);
            }

            public final Object a(final boolean r3, Continuation<? super Unit> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                com.obric.memorydata.memory.ui.a r6 = ScreenObservationFragment.access$getRecyclerViewInterceptor$p(this.f11122a);
                if (r6 == null) goto L5;
                r6.a(!r3);
            L5:
                FragmentRecommendMemoryListBinding r7 = ScreenObservationFragment.access$getBinding$p(this.f11122a);
                if (r7 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r7 = null;
            L8:
                RecyclerView r8 = r7.rvMemoryList;
                final ScreenObservationFragment r2 = this.f11122a;
                r8.post(new $$Lambda$ScreenObservationFragment$observeData$1$1$9XxdMGCEXrWP0o412ElFM4gfkw(r2, r3));
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), r5);
            }
        }

        AnonymousClass1(ScreenObservationFragment r3, Continuation<? super AnonymousClass1> r4) {
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
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.ar<Boolean> r7 = ScreenObservationFragment.access$getShareViewModel(this.this$0).getSelectionManager().b();
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05881(this.this$0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$2", f = "ScreenObservationFragment.kt", i = {}, l = {165}, m = "invokeSuspend", n = {}, s = {})
    static final class C11782 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ScreenObservationFragment f11123a;

            AnonymousClass1(ScreenObservationFragment r1) {
                this.f11123a = r1;
            }

            private static final void a(ScreenObservationFragment r5) {
                MemoryListAdapter r0 = ScreenObservationFragment.access$getMemoryListAdapter$p(r5);
                if (r0 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r0 = null;
            L5:
                MemoryListAdapter r6 = ScreenObservationFragment.access$getMemoryListAdapter$p(r5);
                if (r6 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r6 = null;
            L8:
                r0.a(0, r6.d(), new MemoryListAdapter.Companion.a("selection", null));
            }

            /* JADX INFO: renamed from: lambda$igo82VP9Lx4l8Q8aQ_dFAB-NycQ, reason: not valid java name */
            public static /* synthetic */ void m922lambda$igo82VP9Lx4l8Q8aQ_dFABNycQ(ScreenObservationFragment r0) {
                a(r0);
            }

            public final Object a(SelectionStateManager.SelectAllState r2, Continuation<? super Unit> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                FragmentRecommendMemoryListBinding r5 = ScreenObservationFragment.access$getBinding$p(this.f11123a);
                if (r5 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r5 = null;
            L5:
                RecyclerView r6 = r5.rvMemoryList;
                final ScreenObservationFragment r1 = this.f11123a;
                r6.post(new $$Lambda$ScreenObservationFragment$observeData$2$1$igo82VP9Lx4l8Q8aQ_dFABNycQ(r1));
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return a((SelectionStateManager.SelectAllState) ZeusTransformUtils.preCheckCast(r3, SelectionStateManager.SelectAllState.class, "com.obric.memorydata.plugin"), r5);
            }
        }

        C11782(ScreenObservationFragment r3, Continuation<? super C11782> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11782(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11782) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11782.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.ar<SelectionStateManager.SelectAllState> r7 = ScreenObservationFragment.access$getShareViewModel(this.this$0).getSelectionManager().c();
            kotlinx.coroutines.flow.j<? super SelectionStateManager.SelectAllState> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$3", f = "ScreenObservationFragment.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationFragment this$0;

        AnonymousClass3(ScreenObservationFragment r3, Continuation<? super AnonymousClass3> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
            ScreenObservationFragment r6 = this.this$0;
            Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (ScreenObservationFragment.access$collectMemoryList(r6, r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$4", f = "ScreenObservationFragment.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationFragment this$0;

        AnonymousClass4(ScreenObservationFragment r3, Continuation<? super AnonymousClass4> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            MemoryListAdapter r7 = ScreenObservationFragment.access$getMemoryListAdapter$p(this.this$0);
            if (r7 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
            r7 = null;
        L11:
            kotlinx.coroutines.flow.i<CombinedLoadStates> r8 = r7.e();
            final ScreenObservationFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super CombinedLoadStates> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r8.collect(r2, r4) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$5", f = "ScreenObservationFragment.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$5$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/memorydata/memory/ui/list/TipsData;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$5$1", f = "ScreenObservationFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<bl, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ScreenObservationFragment this$0;

            AnonymousClass1(ScreenObservationFragment r3, Continuation<? super AnonymousClass1> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(bl r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
                FragmentRecommendMemoryListBinding r0 = ScreenObservationFragment.access$getBinding$p(this.this$0);
                ab r1 = null;
                if (r0 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r0 = null;
            L7:
                ab r2 = ScreenObservationFragment.access$getLoadingTipsAdapter$p(this.this$0);
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

        AnonymousClass5(ScreenObservationFragment r3, Continuation<? super AnonymousClass5> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass5) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass5.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ScreenObservationFragment.access$getTipsViewModel(this.this$0).getPendingBuildObservationMemoryState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$6", f = "ScreenObservationFragment.kt", i = {}, l = {Constants.UPLOAD_DISASTER_DROP}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$6$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$6$1", f = "ScreenObservationFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ScreenObservationFragment this$0;

            AnonymousClass1(ScreenObservationFragment r3, Continuation<? super AnonymousClass1> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(Unit r3, Continuation<? super Unit> r4) {
                return invoke2((Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Unit r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L14;
                ResultKt.throwOnFailure(r5);
                Unit r6 = (Unit) ZeusTransformUtils.preCheckCast(this.L$0, Unit.class, "com.obric.memorydata.plugin");
                MemoryListAdapter r2 = null;
                if (Intrinsics.areEqual(MemoryListShareViewModel.getMixTab$default(ScreenObservationFragment.access$getShareViewModel(this.this$0), null, 1, null), MemoryTab.OBSERVATION.getText()) == false) goto L12;
                RunLog.INSTANCE.debug(ScreenObservationFragment.TAG, MemoryTab.OBSERVATION.getText() + ", refresh=" + r6);
                MemoryListAdapter r4 = ScreenObservationFragment.access$getMemoryListAdapter$p(this.this$0);
                if (r4 != null) goto L9;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
            L10:
                r2.b();
                goto L12
            L9:
                r2 = r4;
            L12:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass6(ScreenObservationFragment r3, Continuation<? super AnonymousClass6> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass6) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass6.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ScreenObservationFragment.access$getShareViewModel(this.this$0).getMemoryDeleteFlow(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$7", f = "ScreenObservationFragment.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass7 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationFragment this$0;

        AnonymousClass7(ScreenObservationFragment r3, Continuation<? super AnonymousClass7> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass7(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass7) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass7.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.ar<Pair<MemoryTab, Pair<LocalDate, AppEntity>>> r7 = ScreenObservationFragment.access$getShareViewModel(this.this$0).getTargetEntityFlow();
            final ScreenObservationFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Pair<MemoryTab, Pair<LocalDate, AppEntity>>> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationFragment$observeData$8", f = "ScreenObservationFragment.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass8 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationFragment this$0;

        AnonymousClass8(ScreenObservationFragment r3, Continuation<? super AnonymousClass8> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        private static final boolean invokeSuspend$lambda$0(com.obric.memorydata.memory.ui.settings.k r0) {
            return r0.c();
        }

        /* JADX INFO: renamed from: lambda$fyBlm-XCt7_pAxolPKMDSRmXPDU, reason: not valid java name */
        public static /* synthetic */ boolean m923lambda$fyBlmXCt7_pAxolPKMDSRmXPDU(com.obric.memorydata.memory.ui.settings.k r0) {
            return invokeSuspend$lambda$0(r0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass8(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass8) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass8.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i r7 = kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ScreenObservationFragment.access$getSettingViewModel(this.this$0).getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), $$Lambda$ScreenObservationFragment$observeData$8$fyBlmXCt7_pAxolPKMDSRmXPDU.INSTANCE);
            final ScreenObservationFragment r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationFragment$onResume$1", f = "ScreenObservationFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C11791 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationFragment this$0;

        C11791(ScreenObservationFragment r3, Continuation<? super C11791> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11791(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11791) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11791.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            ScreenObservationFragment.access$getTipsViewModel(this.this$0).setCellularEnable(RecommendApi.INSTANCE.getScreenObservationCellularEnabled());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$onResume$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationFragment$onResume$2", f = "ScreenObservationFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C11802 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationFragment this$0;

        C11802(ScreenObservationFragment r3, Continuation<? super C11802> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11802(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11802) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11802.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            ScreenObservationFragment.access$getTipsViewModel(this.this$0).tryRefreshBuildMemoryTips();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationFragment$setupItemCountObservation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationFragment$setupItemCountObservation$1", f = "ScreenObservationFragment.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
    static final class C11811 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationFragment this$0;

        C11811(ScreenObservationFragment r3, Continuation<? super C11811> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11811(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11811) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11811.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            SelectionStateManager.a r12 = SelectionStateManager.f11168a;
            String[] r2 = new String[2];
            r2[0] = MemoryTab.OBSERVATION.getText();
            LocalDate r3 = ScreenObservationFragment.access$getCurrentDate$p(this.this$0);
            LocalDate r4 = null;
            if (r3 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            r3 = null;
        L11:
            r2[1] = r3.toString();
            final String r13 = r12.a(r2);
            EpisodicMemoryDao r5 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao();
            LocalDate r6 = ScreenObservationFragment.access$getCurrentDate$p(this.this$0);
            if (r6 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            r6 = null;
        L14:
            long r7 = r6.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
            LocalDate r8 = ScreenObservationFragment.access$getCurrentDate$p(this.this$0);
            if (r8 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
        L18:
            kotlinx.coroutines.flow.i<Integer> r9 = r5.getAllObservationMemoryCount(r7, r4.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
            final ScreenObservationFragment r10 = this.this$0;
            kotlinx.coroutines.flow.j<? super Integer> r14 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05891(r13, r10), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r9.collect(r14, r15) != r0) goto L22;
            return r0;
        L17:
            r4 = r8;
            goto L18
        }
    }

    static {
        Companion = new a(null);
    }

    public ScreenObservationFragment() {
        this.viewModel$delegate = LazyKt.lazy(new $$Lambda$ScreenObservationFragment$EP5o255VZu5hpldMCvxUgNq_2FM(this));
        this.shareViewModel$delegate = LazyKt.lazy(new $$Lambda$ScreenObservationFragment$eGS0BcpLdGRDufXPrIjIwyBj2fk(this));
        this.tipsViewModel$delegate = LazyKt.lazy(new $$Lambda$ScreenObservationFragment$sxm0ar6DMDGUGeIkHdNwlsvUde8(this));
        this.settingViewModel$delegate = LazyKt.lazy(new $$Lambda$ScreenObservationFragment$Ky3qPAGXWDx0vLmTLK7qokKBORU(this));
        this.isFirstLoad = true;
    }

    public static final /* synthetic */ Object access$clearMemoryList(ScreenObservationFragment r2, Continuation r3) {
        return r2.clearMemoryList((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$collectMemoryList(ScreenObservationFragment r2, Continuation r3) {
        return r2.collectMemoryList((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ FragmentRecommendMemoryListBinding access$getBinding$p(ScreenObservationFragment r0) {
        return r0.binding;
    }

    public static final /* synthetic */ LocalDate access$getCurrentDate$p(ScreenObservationFragment r0) {
        return r0.currentDate;
    }

    public static final /* synthetic */ AppEntity access$getJumpTargetEntity$p(ScreenObservationFragment r0) {
        return r0.jumpTargetEntity;
    }

    public static final /* synthetic */ ab access$getLoadingTipsAdapter$p(ScreenObservationFragment r0) {
        return r0.loadingTipsAdapter;
    }

    public static final /* synthetic */ MemoryListAdapter access$getMemoryListAdapter$p(ScreenObservationFragment r0) {
        return r0.memoryListAdapter;
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.a access$getRecyclerViewInterceptor$p(ScreenObservationFragment r0) {
        return r0.recyclerViewInterceptor;
    }

    public static final /* synthetic */ MemorySettingsViewModel access$getSettingViewModel(ScreenObservationFragment r0) {
        return r0.getSettingViewModel();
    }

    public static final /* synthetic */ MemoryListShareViewModel access$getShareViewModel(ScreenObservationFragment r0) {
        return r0.getShareViewModel();
    }

    public static final /* synthetic */ ScreenObservationTipsViewModel access$getTipsViewModel(ScreenObservationFragment r0) {
        return r0.getTipsViewModel();
    }

    public static final /* synthetic */ ScreenObservationViewModel access$getViewModel(ScreenObservationFragment r0) {
        return r0.getViewModel();
    }

    public static final /* synthetic */ boolean access$isFirstLoad$p(ScreenObservationFragment r0) {
        return r0.isFirstLoad;
    }

    public static final /* synthetic */ String access$pagingLifecycleSnapshot(ScreenObservationFragment r0, String r1) {
        return r0.pagingLifecycleSnapshot(r1);
    }

    public static final /* synthetic */ void access$scrollToItemIfNeeded(ScreenObservationFragment r0, AppEntity r1, boolean r2) {
        r0.scrollToItemIfNeeded(r1, r2);
    }

    public static final /* synthetic */ void access$setFirstLoad$p(ScreenObservationFragment r0, boolean r1) {
        r0.isFirstLoad = r1;
    }

    public static final /* synthetic */ void access$setJumpTargetEntity$p(ScreenObservationFragment r0, AppEntity r1) {
        r0.jumpTargetEntity = r1;
    }

    private final void applyTitleBarPadding() {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        final View r1 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, OaidModel.KEY_ID, "title_bar_container"));
    L6:
        if (r1 != null) goto L8;
    L10:
        if (r1 == null) goto L14;
        r1.post(new $$Lambda$ScreenObservationFragment$SLyDP7vWWY2vaOYS7kzxQgGSYd8(this, r1));
        return;
    L14:
        return;
    L8:
        if (r1.getHeight() <= 0) goto L10;
        setRecyclerViewTopPadding(r1.getHeight());
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final void applyTitleBarPadding$lambda$7(ScreenObservationFragment r0, View r1) {
        r0.setRecyclerViewTopPadding(r1.getHeight());
    }

    private final Object clearMemoryList(Continuation<? super Unit> r3) {
        Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        getViewModel().clearData();
        MemoryListAdapter r2 = this.memoryListAdapter;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
        r2 = null;
    L5:
        Object r5 = r2.a(PagingData.Companion.empty(), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r5;
    L9:
        return Unit.INSTANCE;
    }

    private final Object collectMemoryList(Continuation<? super Unit> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        ScreenObservationViewModel r0 = getViewModel();
        LocalDate r2 = this.currentDate;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentDate");
        r2 = null;
    L5:
        kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r1 = r0.getMemoryListByDate(r2);
        LifecycleOwner r3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r3, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.flow.i r4 = CachedPagingDataKt.cachedIn(r1, (kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r3), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"));
        LifecycleOwner r5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r5, "getViewLifecycleOwner(...)");
        Object r6 = RepeatOnLifecycleKt.repeatOnLifecycle(r5, z.f11341a.a(), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r4, null), Function2.class, "com.obric.memorydata.plugin"), r8);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r6;
    L9:
        return Unit.INSTANCE;
    }

    private final MemorySettingsViewModel getSettingViewModel() {
        return (MemorySettingsViewModel) ZeusTransformUtils.preCheckCast(this.settingViewModel$delegate.getValue(), MemorySettingsViewModel.class, "com.obric.memorydata.plugin");
    }

    private final MemoryListShareViewModel getShareViewModel() {
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(this.shareViewModel$delegate.getValue(), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    private final ScreenObservationTipsViewModel getTipsViewModel() {
        return (ScreenObservationTipsViewModel) ZeusTransformUtils.preCheckCast(this.tipsViewModel$delegate.getValue(), ScreenObservationTipsViewModel.class, "com.obric.memorydata.plugin");
    }

    private final ScreenObservationViewModel getViewModel() {
        return (ScreenObservationViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), ScreenObservationViewModel.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ ScreenObservationViewModel lambda$EP5o255VZu5hpldMCvxUgNq_2FM(ScreenObservationFragment r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ MemorySettingsViewModel lambda$Ky3qPAGXWDx0vLmTLK7qokKBORU(ScreenObservationFragment r0) {
        return settingViewModel_delegate$lambda$3(r0);
    }

    public static /* synthetic */ void lambda$SLyDP7vWWY2vaOYS7kzxQgGSYd8(ScreenObservationFragment r0, View r1) {
        applyTitleBarPadding$lambda$7(r0, r1);
    }

    public static /* synthetic */ MemoryListShareViewModel lambda$eGS0BcpLdGRDufXPrIjIwyBj2fk(ScreenObservationFragment r0) {
        return shareViewModel_delegate$lambda$1(r0);
    }

    public static /* synthetic */ ScreenObservationTipsViewModel lambda$sxm0ar6DMDGUGeIkHdNwlsvUde8(ScreenObservationFragment r0) {
        return tipsViewModel_delegate$lambda$2(r0);
    }

    private final void observeData() {
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11782(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass7(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass8(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        setupItemCountObservation();
    }

    private final String pagingLifecycleSnapshot(String r3) {
        StringBuilder r4 = new StringBuilder().append("[MEM][PagingLifecycle] ").append(r3).append(" page=SCREEN date=");
        LocalDate r0 = this.currentDate;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentDate");
        r0 = null;
    L5:
        StringBuilder r5 = r4.append(r0).append(" fragmentState=").append(getLifecycle().getCurrentState()).append(" viewState=").append(getViewLifecycleOwner().getLifecycle().getCurrentState()).append(" pagerItem=");
        ViewPager2 r2 = this.viewPager;
        if (r2 == null) goto L8;
        int r6 = r2.getCurrentItem();
    L10:
        return r5.append(r6).toString();
    L8:
        r6 = -1;
        goto L10
    }

    private final LocalDate parseDate() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L10;
        int r1 = r0.getInt("year");
        Bundle r2 = getArguments();
        if (r2 == null) goto L10;
        int r3 = r2.getInt("month");
        Bundle r4 = getArguments();
        if (r4 == null) goto L10;
        return LocalDate.of(r1, r3, r4.getInt("day"));
    L10:
        return null;
    }

    private final void scrollToItemIfNeeded(AppEntity r11, boolean r12) {
        this.isFirstLoad = false;
        MemoryListAdapter r1 = this.memoryListAdapter;
        FragmentRecommendMemoryListBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
        r1 = null;
    L5:
        ItemSnapshotList<com.obric.memorydata.memory.ui.data.a> r3 = r1.c();
        Iterator r4 = ((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")).iterator();
        int r5 = 0;
    L7:
        if (r4.hasNext() == false) goto L17;
        com.obric.memorydata.memory.ui.data.a r6 = (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.i.class) == true) goto L11;
    L13:
        boolean r7 = false;
    L14:
        if (r7 == true) goto L19;
        r5 = r5 + 1;
    L19:
        if (r5 < 0) goto L25;
        RunLog.INSTANCE.debug(TAG, MemoryTab.OBSERVATION.getText() + " scrollToItemIfNeeded, scrollToPosition " + r5);
        this.jumpTargetEntity = null;
        int r13 = RangesKt.coerceIn(r5 + 1, 0, r3.size() - 1);
        FragmentRecommendMemoryListBinding r10 = this.binding;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L24:
        r2.rvMemoryList.scrollToPosition(r13);
        return;
    L23:
        r2 = r10;
        goto L24
    L25:
        if (r12 == false) goto L31;
        RunLog.INSTANCE.debug(TAG, MemoryTab.OBSERVATION.getText() + " scrollToItemIfNeeded, scrollToPosition start");
        FragmentRecommendMemoryListBinding r14 = this.binding;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L30:
        r2.rvMemoryList.scrollToPosition(0);
        return;
    L29:
        r2 = r14;
        goto L30
    L31:
        RunLog.INSTANCE.debug(TAG, MemoryTab.OBSERVATION.getText() + " scrollToItemIfNeeded, scrollToPosition end");
        FragmentRecommendMemoryListBinding r15 = this.binding;
        if (r15 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L35:
        r2.rvMemoryList.scrollToPosition(r3.size() - 1);
        return;
    L34:
        r2 = r15;
        goto L35
    L11:
        if (Intrinsics.areEqual(r11.getId(), ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getEntityId()) == false) goto L13;
        r7 = true;
        goto L14
    L17:
        r5 = -1;
        goto L19
    }

    private final void setRecyclerViewTopPadding(int r6) {
        FragmentRecommendMemoryListBinding r0 = this.binding;
        FragmentRecommendMemoryListBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        RecyclerView r2 = r0.rvMemoryList;
        FragmentRecommendMemoryListBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        int r4 = r3.rvMemoryList.getPaddingLeft();
        FragmentRecommendMemoryListBinding r5 = this.binding;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L11:
        int r7 = r5.rvMemoryList.getPaddingRight();
        FragmentRecommendMemoryListBinding r8 = this.binding;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r2.setPadding(r4, r6, r7, r1.rvMemoryList.getPaddingBottom());
        return;
    L14:
        r1 = r8;
        goto L15
    }

    private static final MemorySettingsViewModel settingViewModel_delegate$lambda$3(ScreenObservationFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (MemorySettingsViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(MemorySettingsViewModel.class), MemorySettingsViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void setupItemCountObservation() {
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C11811(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    private final void setupRecyclerView() {
        FragmentRecommendMemoryListBinding r0 = this.binding;
        MemoryListAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        RecyclerView r2 = r0.rvMemoryList;
        r2.setClipToPadding(false);
        LinearLayoutManager r3 = new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r3.b(true);
        r3.a(true);
        r2.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(r3, RecyclerView.h.class, "com.obric.memorydata.plugin"));
        this.loadingTipsAdapter = new ab();
        this.memoryListAdapter = new MemoryListAdapter(getShareViewModel().getSelectionManager(), null, true, 2, null);
        RecyclerView.Adapter[] r6 = new RecyclerView.Adapter[2];
        ab r7 = this.loadingTipsAdapter;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadingTipsAdapter");
        r7 = null;
    L8:
        r6[0] = r7;
        MemoryListAdapter r8 = this.memoryListAdapter;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
    L12:
        r6[1] = r1.a((com.obric.memorydata.ui.recyclerview.a) ZeusTransformUtils.preCheckCast(new i(), com.obric.memorydata.ui.recyclerview.a.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.ui.recyclerview.a) ZeusTransformUtils.preCheckCast(new i(), com.obric.memorydata.ui.recyclerview.a.class, "com.obric.memorydata.plugin"));
        r2.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(new ConcatAdapter(r6), RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r2);
        this.recyclerViewInterceptor = new com.obric.memorydata.memory.ui.a(r2, this.viewPager, false, false);
        com.obric.oui.orecyclerview.widget.h r4 = new com.obric.oui.orecyclerview.widget.h();
        r4.c(300);
        r4.b(100);
        r4.a(100);
        r4.d(0);
        r2.setItemAnimator((RecyclerView.e) ZeusTransformUtils.preCheckCast(r4, RecyclerView.e.class, "com.obric.memorydata.plugin"));
        applyTitleBarPadding();
        return;
    L11:
        r1 = r8;
        goto L12
    }

    private static final MemoryListShareViewModel shareViewModel_delegate$lambda$1(ScreenObservationFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(MemoryListShareViewModel.class), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    private static final ScreenObservationTipsViewModel tipsViewModel_delegate$lambda$2(ScreenObservationFragment r3) {
        return (ScreenObservationTipsViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r3, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(ScreenObservationTipsViewModel.class), ScreenObservationTipsViewModel.class, "com.obric.memorydata.plugin");
    }

    private static final ScreenObservationViewModel viewModel_delegate$lambda$0(ScreenObservationFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (ScreenObservationViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(ScreenObservationViewModel.class), ScreenObservationViewModel.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        this.isFirstLoad = true;
        FragmentRecommendMemoryListBinding r11 = FragmentRecommendMemoryListBinding.inflate(r8, r9, false);
        Intrinsics.checkNotNullExpressionValue(r11, "inflate(...)");
        this.binding = r11;
        LocalDate r12 = parseDate();
        if (r12 == null) goto L15;
        this.currentDate = r12;
        ScreenObservationTipsViewModel r0 = getTipsViewModel();
        LocalDate r13 = this.currentDate;
        FragmentRecommendMemoryListBinding r14 = null;
        if (r13 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("currentDate");
        LocalDate r1 = null;
    L8:
        ScreenObservationTipsViewModel.init$memory_obricRelease$default(r0, r1, ((com.obric.memorydata.memory.ui.settings.k) ZeusTransformUtils.preCheckCast(getSettingViewModel().getState().c(), com.obric.memorydata.memory.ui.settings.k.class, "com.obric.memorydata.plugin")).c(), null, 4, null);
        FragmentRecommendMemoryListBinding r7 = this.binding;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        ConstraintLayout r15 = r14.getRoot();
        Intrinsics.checkNotNullExpressionValue(r15, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin");
    L11:
        r14 = r7;
        goto L12
    L7:
        r1 = r13;
        goto L8
    L15:
        throw new IllegalArgumentException("ScreenObservationFragment must have date arguments");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getShareViewModel().getSelectionManager().j();
        SelectionStateManager.a r0 = SelectionStateManager.f11168a;
        String[] r1 = new String[2];
        r1[0] = MemoryTab.OBSERVATION.getText();
        LocalDate r2 = this.currentDate;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentDate");
        r2 = null;
    L5:
        r1[1] = r2.toString();
        String r3 = r0.a(r1);
        getShareViewModel().getSelectionManager().b(r3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.obric.memorydata.memory.ui.a r0 = this.recyclerViewInterceptor;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.recyclerViewInterceptor = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C11791(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C11802(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L7;
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.memory_tab_container, OaidModel.KEY_ID, "memory_tab_container")), ViewGroup.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L7;
        ViewPager2 r8 = (ViewPager2) ZeusTransformUtils.preCheckCast(r7.findViewWithTag(MemoryTab.OBSERVATION.getText()), ViewPager2.class, "com.obric.memorydata.plugin");
    L8:
        this.viewPager = r8;
        setupRecyclerView();
        observeData();
        return;
    L7:
        r8 = null;
        goto L8
    }
}
