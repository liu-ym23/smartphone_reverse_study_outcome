package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
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
import com.bytedance.crash.tracker.fragment.BuildConfig;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.databinding.FragmentAudioMemoryListBinding;
import com.obric.memorydata.memory.ui.settings.MemorySettingsViewModel;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.BaseFragment;
import com.obric.oui.orecyclerview.widget.ConcatAdapter;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0016J\u0018\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020!H\u0002J\b\u00103\u001a\u00020,H\u0002J\b\u00104\u001a\u00020,H\u0002J\b\u00105\u001a\u00020,H\u0002J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u000207H\u0002J\b\u00109\u001a\u00020,H\u0002J\n\u0010:\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010;\u001a\u00020,H\u0016J\b\u0010<\u001a\u00020,H\u0016J\b\u0010=\u001a\u00020,H\u0016J\b\u0010>\u001a\u00020,H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/AudioMemoryListFragment;", "Lcom/obric/memorydata/ui/BaseFragment;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/FragmentAudioMemoryListBinding;", "viewModel", "Lcom/obric/memorydata/memory/ui/list/AudioMemoryListViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/list/AudioMemoryListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "shareViewModel", "Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "getShareViewModel", "()Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "shareViewModel$delegate", "settingViewModel", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsViewModel;", "getSettingViewModel", "()Lcom/obric/memorydata/memory/ui/settings/MemorySettingsViewModel;", "settingViewModel$delegate", "memoryListAdapter", "Lcom/obric/memorydata/memory/ui/list/MemoryListAdapter;", "jumpTargetEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "viewPager", "Lcom/obric/oui/viewpager2/widget/ViewPager2;", "recyclerViewInterceptor", "Lcom/obric/memorydata/memory/ui/ConflictWithViewPage2Handler;", "currentDate", "Ljava/time/LocalDate;", "isFirstLoad", "", "needRefreshOnStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onStop", "scrollToItemIfNeeded", "entity", "isFirst", "setupRecyclerView", "setupCountObservation", "observeData", "pagingLifecycleSnapshot", "", "event", "showEmptyView", "parseDate", "onResume", "onPause", "onDestroy", "onDestroyView", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AudioMemoryListFragment extends BaseFragment {
    public static final a Companion = null;
    public static final String KEY_DAY = "day";
    public static final String KEY_MONTH = "month";
    public static final String KEY_YEAR = "year";
    private static final String TAG = "AudioMemoryListFragment";
    private FragmentAudioMemoryListBinding binding;
    private LocalDate currentDate;
    private boolean isFirstLoad;
    private AppEntity jumpTargetEntity;
    private MemoryListAdapter memoryListAdapter;
    private boolean needRefreshOnStart;
    private com.obric.memorydata.memory.ui.a recyclerViewInterceptor;
    private final Lazy settingViewModel$delegate;
    private final Lazy shareViewModel$delegate;
    private final Lazy viewModel$delegate;
    private ViewPager2 viewPager;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/AudioMemoryListFragment$Companion;", "", "<init>", "()V", "TAG", "", "KEY_YEAR", "KEY_MONTH", "KEY_DAY", "newInstance", "Lcom/obric/memorydata/memory/ui/list/AudioMemoryListFragment;", "date", "Ljava/time/LocalDate;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final AudioMemoryListFragment a(LocalDate r4) {
            Intrinsics.checkNotNullParameter(r4, "date");
            AudioMemoryListFragment r3 = new AudioMemoryListFragment();
            Bundle r0 = new Bundle();
            r0.putInt("year", r4.getYear());
            r0.putInt("month", r4.getMonthValue());
            r0.putInt("day", r4.getDayOfMonth());
            r3.setArguments(r0);
            return r3;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$1", f = "AudioMemoryListFragment.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AudioMemoryListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class C05611<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AudioMemoryListFragment f10978a;

            C05611(AudioMemoryListFragment r1) {
                this.f10978a = r1;
            }

            private static final void a(AudioMemoryListFragment r4, boolean r5) {
                MemoryListAdapter r0 = AudioMemoryListFragment.access$getMemoryListAdapter$p(r4);
                MemoryListAdapter r1 = null;
                if (r0 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r0 = null;
            L5:
                MemoryListAdapter r6 = AudioMemoryListFragment.access$getMemoryListAdapter$p(r4);
                if (r6 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
            L9:
                r0.a(0, r1.d(), new MemoryListAdapter.Companion.a("edit_mode", Boolean.valueOf(r5)));
                return;
            L8:
                r1 = r6;
                goto L9
            }

            public static /* synthetic */ void lambda$KOOA6MzsBzbLOw3BOrQFXm9fd5Q(AudioMemoryListFragment r0, boolean r1) {
                a(r0, r1);
            }

            public final Object a(final boolean r3, Continuation<? super Unit> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                com.obric.memorydata.memory.ui.a r6 = AudioMemoryListFragment.access$getRecyclerViewInterceptor$p(this.f10978a);
                if (r6 == null) goto L5;
                r6.a(!r3);
            L5:
                FragmentAudioMemoryListBinding r7 = AudioMemoryListFragment.access$getBinding$p(this.f10978a);
                if (r7 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r7 = null;
            L8:
                RecyclerView r8 = r7.rvMemoryList;
                final AudioMemoryListFragment r2 = this.f10978a;
                r8.post(new $$Lambda$AudioMemoryListFragment$observeData$1$1$KOOA6MzsBzbLOw3BOrQFXm9fd5Q(r2, r3));
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), r5);
            }
        }

        AnonymousClass1(AudioMemoryListFragment r3, Continuation<? super AnonymousClass1> r4) {
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
            kotlinx.coroutines.flow.ar<Boolean> r7 = AudioMemoryListFragment.access$getShareViewModel(this.this$0).getSelectionManager().b();
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05611(this.this$0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$2", f = "AudioMemoryListFragment.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AudioMemoryListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AudioMemoryListFragment f10979a;

            AnonymousClass1(AudioMemoryListFragment r1) {
                this.f10979a = r1;
            }

            private static final void a(AudioMemoryListFragment r5) {
                MemoryListAdapter r0 = AudioMemoryListFragment.access$getMemoryListAdapter$p(r5);
                if (r0 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r0 = null;
            L5:
                MemoryListAdapter r6 = AudioMemoryListFragment.access$getMemoryListAdapter$p(r5);
                if (r6 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r6 = null;
            L8:
                r0.a(0, r6.d(), new MemoryListAdapter.Companion.a("selection", null));
            }

            public static /* synthetic */ void lambda$X0DIc6S9EBqaYRgnX8PeFZG7JL8(AudioMemoryListFragment r0) {
                a(r0);
            }

            public final Object a(SelectionStateManager.SelectAllState r2, Continuation<? super Unit> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                FragmentAudioMemoryListBinding r5 = AudioMemoryListFragment.access$getBinding$p(this.f10979a);
                if (r5 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r5 = null;
            L5:
                RecyclerView r6 = r5.rvMemoryList;
                final AudioMemoryListFragment r1 = this.f10979a;
                r6.post(new $$Lambda$AudioMemoryListFragment$observeData$2$1$X0DIc6S9EBqaYRgnX8PeFZG7JL8(r1));
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return a((SelectionStateManager.SelectAllState) ZeusTransformUtils.preCheckCast(r3, SelectionStateManager.SelectAllState.class, "com.obric.memorydata.plugin"), r5);
            }
        }

        AnonymousClass2(AudioMemoryListFragment r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.ar<SelectionStateManager.SelectAllState> r7 = AudioMemoryListFragment.access$getShareViewModel(this.this$0).getSelectionManager().c();
            kotlinx.coroutines.flow.j<? super SelectionStateManager.SelectAllState> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$3", f = "AudioMemoryListFragment.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AudioMemoryListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$3$1", f = "AudioMemoryListFragment.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
            final /* synthetic */ kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> $flow;
            int label;
            final /* synthetic */ AudioMemoryListFragment this$0;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$3$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$3$1$1", f = "AudioMemoryListFragment.kt", i = {}, l = {BuildConfig.VERSION_CODE}, m = "invokeSuspend", n = {}, s = {})
            static final class C05621 extends SuspendLambda implements Function2<PagingData<com.obric.memorydata.memory.ui.data.a>, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ AudioMemoryListFragment this$0;

                C05621(AudioMemoryListFragment r3, Continuation<? super C05621> r4) {
                    Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    this.this$0 = r3;
                    super(2, r5);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                    Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    C05621 r0 = new C05621(this.this$0, r5);
                    r0.L$0 = r3;
                    return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(PagingData<com.obric.memorydata.memory.ui.data.a> r3, Continuation<? super Unit> r4) {
                    return ((C05621) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05621.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
                    IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AudioMemoryListFragment.TAG, AudioMemoryListFragment.access$pagingLifecycleSnapshot(this.this$0, "SUBMIT"), false, 4, null);
                    MemoryListAdapter r2 = AudioMemoryListFragment.access$getMemoryListAdapter$p(this.this$0);
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

            AnonymousClass1(AudioMemoryListFragment r3, kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r4, Continuation<? super AnonymousClass1> r5) {
                kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r6 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                this.$flow = r6;
                super(2, r7);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$flow, r5), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
                return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
                String r5 = AudioMemoryListFragment.access$pagingLifecycleSnapshot(this.this$0, "COLLECTOR_STOP");
                r4 = AudioMemoryListFragment.TAG;
                IRunLog.a.a(r3, AudioMemoryListFragment.TAG, r5, false, 4, null);
                AnonymousClass1 this = Unit.INSTANCE;
                return this;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                ResultKt.throwOnFailure(r12);
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AudioMemoryListFragment.TAG, AudioMemoryListFragment.access$pagingLifecycleSnapshot(this.this$0, "COLLECTOR_START"), false, 4, null);
                kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r13 = this.$flow;     // Catch: Throwable -> L7
                Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C05621(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                this.label = 1;     // Catch: Throwable -> L7
                if (kotlinx.coroutines.flow.k.a(r13, r2, r6) != r0) goto L15;
                return r0;
            L7:
                th = move-exception;
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r4), AudioMemoryListFragment.TAG, AudioMemoryListFragment.access$pagingLifecycleSnapshot(this.this$0, "COLLECTOR_STOP"), false, 4, null);
                throw th;
            }
        }

        AnonymousClass3(AudioMemoryListFragment r3, Continuation<? super AnonymousClass3> r4) {
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
            AudioMemoryListViewModel r10 = this.this$0.getViewModel();
            LocalDate r2 = AudioMemoryListFragment.access$getCurrentDate$p(this.this$0);
            if (r2 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            r2 = null;
        L11:
            kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r11 = r10.getMemoryList(r2);
            LifecycleOwner r3 = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(r3, "getViewLifecycleOwner(...)");
            kotlinx.coroutines.flow.i r12 = CachedPagingDataKt.cachedIn(r11, (kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r3), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"));
            LifecycleOwner r4 = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(r4, "getViewLifecycleOwner(...)");
            Lifecycle.State r5 = z.f11341a.a();
            Function2 r13 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r12, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r4, r5, r13, r6) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$4", f = "AudioMemoryListFragment.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AudioMemoryListFragment this$0;

        AnonymousClass4(AudioMemoryListFragment r3, Continuation<? super AnonymousClass4> r4) {
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
            MemoryListAdapter r7 = AudioMemoryListFragment.access$getMemoryListAdapter$p(this.this$0);
            if (r7 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
            r7 = null;
        L11:
            kotlinx.coroutines.flow.i<CombinedLoadStates> r8 = r7.e();
            final AudioMemoryListFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super CombinedLoadStates> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r8.collect(r2, r4) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$5", f = "AudioMemoryListFragment.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AudioMemoryListFragment this$0;

        AnonymousClass5(AudioMemoryListFragment r3, Continuation<? super AnonymousClass5> r4) {
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
            kotlinx.coroutines.flow.ar<Pair<MemoryTab, Pair<LocalDate, AppEntity>>> r7 = AudioMemoryListFragment.access$getShareViewModel(this.this$0).getTargetEntityFlow();
            final AudioMemoryListFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Pair<MemoryTab, Pair<LocalDate, AppEntity>>> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$6", f = "AudioMemoryListFragment.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AudioMemoryListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$6$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$6$1", f = "AudioMemoryListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            /* synthetic */ boolean Z$0;
            int label;
            final /* synthetic */ AudioMemoryListFragment this$0;

            AnonymousClass1(AudioMemoryListFragment r3, Continuation<? super AnonymousClass1> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
                r0.Z$0 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(Boolean r3, Continuation<? super Unit> r4) {
                return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            public final Object invoke(boolean r3, Continuation<? super Unit> r4) {
                Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(Boolean.valueOf(r3), r5), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r4);
                boolean r5 = this.Z$0;
                RunLog.INSTANCE.debug(AudioMemoryListFragment.TAG, MemoryTab.AUDIO + ", refresh=" + r5);
                if (r5 == false) goto L11;
                MemoryListAdapter r3 = AudioMemoryListFragment.access$getMemoryListAdapter$p(this.this$0);
                if (r3 != null) goto L9;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r3 = null;
            L9:
                r3.b();
            L11:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass6(AudioMemoryListFragment r3, Continuation<? super AnonymousClass6> r4) {
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(AudioMemoryListFragment.access$getShareViewModel(this.this$0).getMemoryCorrelationChangeFlow(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$observeData$7", f = "AudioMemoryListFragment.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass7 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AudioMemoryListFragment this$0;

        AnonymousClass7(AudioMemoryListFragment r3, Continuation<? super AnonymousClass7> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        private static final boolean invokeSuspend$lambda$0(com.obric.memorydata.memory.ui.settings.k r0) {
            return r0.d();
        }

        public static /* synthetic */ boolean lambda$m9hnqnpJY5Ri_8bj4ptbF6SXUH0(com.obric.memorydata.memory.ui.settings.k r0) {
            return invokeSuspend$lambda$0(r0);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i r7 = kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(AudioMemoryListFragment.access$getSettingViewModel(this.this$0).getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), $$Lambda$AudioMemoryListFragment$observeData$7$m9hnqnpJY5Ri_8bj4ptbF6SXUH0.INSTANCE);
            final AudioMemoryListFragment r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$setupCountObservation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListFragment$setupCountObservation$1", f = "AudioMemoryListFragment.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
    static final class C11511 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AudioMemoryListFragment this$0;

        C11511(AudioMemoryListFragment r3, Continuation<? super C11511> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11511(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11511) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11511.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            r2[0] = MemoryTab.AUDIO.getText();
            LocalDate r3 = AudioMemoryListFragment.access$getCurrentDate$p(this.this$0);
            LocalDate r4 = null;
            if (r3 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            r3 = null;
        L11:
            r2[1] = r3.toString();
            final String r13 = r12.a(r2);
            AuditoryRecordingRawDbDao r5 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao();
            LocalDate r6 = AudioMemoryListFragment.access$getCurrentDate$p(this.this$0);
            if (r6 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
            r6 = null;
        L14:
            long r7 = r6.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
            LocalDate r8 = AudioMemoryListFragment.access$getCurrentDate$p(this.this$0);
            if (r8 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("currentDate");
        L18:
            kotlinx.coroutines.flow.i<Integer> r9 = r5.getAllRecordingsCount(r7, r4.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
            final AudioMemoryListFragment r10 = this.this$0;
            kotlinx.coroutines.flow.j<? super Integer> r14 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05631(r10, r13), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
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

    public AudioMemoryListFragment() {
        this.viewModel$delegate = LazyKt.lazy(new $$Lambda$AudioMemoryListFragment$QWv9yZcO6ulU1kccCO8crp86m30(this));
        this.shareViewModel$delegate = LazyKt.lazy(new $$Lambda$AudioMemoryListFragment$M3LU_HN4o9KAC4Py8aznVt4z8ws(this));
        this.settingViewModel$delegate = LazyKt.lazy(new $$Lambda$AudioMemoryListFragment$gy3nFT_CZosHZzyrpHvRYzBM4ik(this));
        this.isFirstLoad = true;
    }

    public static final /* synthetic */ FragmentAudioMemoryListBinding access$getBinding$p(AudioMemoryListFragment r0) {
        return r0.binding;
    }

    public static final /* synthetic */ LocalDate access$getCurrentDate$p(AudioMemoryListFragment r0) {
        return r0.currentDate;
    }

    public static final /* synthetic */ AppEntity access$getJumpTargetEntity$p(AudioMemoryListFragment r0) {
        return r0.jumpTargetEntity;
    }

    public static final /* synthetic */ MemoryListAdapter access$getMemoryListAdapter$p(AudioMemoryListFragment r0) {
        return r0.memoryListAdapter;
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.a access$getRecyclerViewInterceptor$p(AudioMemoryListFragment r0) {
        return r0.recyclerViewInterceptor;
    }

    public static final /* synthetic */ MemorySettingsViewModel access$getSettingViewModel(AudioMemoryListFragment r0) {
        return r0.getSettingViewModel();
    }

    public static final /* synthetic */ MemoryListShareViewModel access$getShareViewModel(AudioMemoryListFragment r0) {
        return r0.getShareViewModel();
    }

    public static final /* synthetic */ boolean access$isFirstLoad$p(AudioMemoryListFragment r0) {
        return r0.isFirstLoad;
    }

    public static final /* synthetic */ String access$pagingLifecycleSnapshot(AudioMemoryListFragment r0, String r1) {
        return r0.pagingLifecycleSnapshot(r1);
    }

    public static final /* synthetic */ void access$scrollToItemIfNeeded(AudioMemoryListFragment r0, AppEntity r1, boolean r2) {
        r0.scrollToItemIfNeeded(r1, r2);
    }

    public static final /* synthetic */ void access$setFirstLoad$p(AudioMemoryListFragment r0, boolean r1) {
        r0.isFirstLoad = r1;
    }

    public static final /* synthetic */ void access$setJumpTargetEntity$p(AudioMemoryListFragment r0, AppEntity r1) {
        r0.jumpTargetEntity = r1;
    }

    public static final /* synthetic */ void access$showEmptyView(AudioMemoryListFragment r0) {
        r0.showEmptyView();
    }

    private final MemorySettingsViewModel getSettingViewModel() {
        return (MemorySettingsViewModel) ZeusTransformUtils.preCheckCast(this.settingViewModel$delegate.getValue(), MemorySettingsViewModel.class, "com.obric.memorydata.plugin");
    }

    private final MemoryListShareViewModel getShareViewModel() {
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(this.shareViewModel$delegate.getValue(), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ MemoryListShareViewModel lambda$M3LU_HN4o9KAC4Py8aznVt4z8ws(AudioMemoryListFragment r0) {
        return shareViewModel_delegate$lambda$1(r0);
    }

    public static /* synthetic */ AudioMemoryListViewModel lambda$QWv9yZcO6ulU1kccCO8crp86m30(AudioMemoryListFragment r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ MemorySettingsViewModel lambda$gy3nFT_CZosHZzyrpHvRYzBM4ik(AudioMemoryListFragment r0) {
        return settingViewModel_delegate$lambda$2(r0);
    }

    private final void observeData() {
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass7(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final String pagingLifecycleSnapshot(String r3) {
        StringBuilder r4 = new StringBuilder().append("[MEM][PagingLifecycle] ").append(r3).append(" page=AUDIO date=");
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
        FragmentAudioMemoryListBinding r2 = null;
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
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.C0539a.class) == true) goto L11;
    L13:
        boolean r7 = false;
    L14:
        if (r7 == true) goto L19;
        r5 = r5 + 1;
    L19:
        if (r5 < 0) goto L30;
        int r13 = r5 - 1;
        if (r13 >= 0) goto L23;
    L25:
        RunLog.INSTANCE.debug(TAG, MemoryTab.AUDIO + " scrollToItemIfNeeded, scrollToPosition " + r5);
        this.jumpTargetEntity = null;
        FragmentAudioMemoryListBinding r10 = this.binding;
        if (r10 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L29:
        r2.rvMemoryList.scrollToPosition(r5);
        return;
    L28:
        r2 = r10;
        goto L29
    L23:
        if (ZeusTransformUtils.instanceOf((com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r3.get(r13), com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"), com.obric.memorydata.memory.ui.data.a.d.class) == false) goto L25;
        r5 = r13;
        goto L25
    L30:
        if (r12 == false) goto L36;
        RunLog.INSTANCE.debug(TAG, MemoryTab.AUDIO + " scrollToItemIfNeeded, scrollToPosition start");
        FragmentAudioMemoryListBinding r14 = this.binding;
        if (r14 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L35:
        r2.rvMemoryList.scrollToPosition(0);
        return;
    L34:
        r2 = r14;
        goto L35
    L36:
        RunLog.INSTANCE.debug(TAG, MemoryTab.AUDIO + " scrollToItemIfNeeded, scrollToPosition end");
        FragmentAudioMemoryListBinding r15 = this.binding;
        if (r15 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L40:
        r2.rvMemoryList.scrollToPosition(r3.size() - 1);
        return;
    L39:
        r2 = r15;
        goto L40
    L11:
        if (Intrinsics.areEqual(r11.getId(), ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getEntityId()) == false) goto L13;
        r7 = true;
        goto L14
    L17:
        r5 = -1;
        goto L19
    }

    private static final MemorySettingsViewModel settingViewModel_delegate$lambda$2(AudioMemoryListFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (MemorySettingsViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(MemorySettingsViewModel.class), MemorySettingsViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void setupCountObservation() {
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C11511(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    private final void setupRecyclerView() {
        FragmentAudioMemoryListBinding r0 = this.binding;
        MemoryListAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        RecyclerView r2 = r0.rvMemoryList;
        LinearLayoutManager r3 = new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r3.b(true);
        r3.a(true);
        r2.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(r3, RecyclerView.h.class, "com.obric.memorydata.plugin"));
        r2.setClipToPadding(false);
        this.memoryListAdapter = new MemoryListAdapter(getShareViewModel().getSelectionManager(), null, true, 2, null);
        RecyclerView.Adapter[] r6 = new RecyclerView.Adapter[2];
        r6[0] = new ab();
        MemoryListAdapter r7 = this.memoryListAdapter;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
    L9:
        r6[1] = r1.a((com.obric.memorydata.ui.recyclerview.a) ZeusTransformUtils.preCheckCast(new i(), com.obric.memorydata.ui.recyclerview.a.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.ui.recyclerview.a) ZeusTransformUtils.preCheckCast(new i(), com.obric.memorydata.ui.recyclerview.a.class, "com.obric.memorydata.plugin"));
        r2.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(new ConcatAdapter(r6), RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r2);
        this.recyclerViewInterceptor = new com.obric.memorydata.memory.ui.a(r2, this.viewPager, false, false);
        com.obric.oui.orecyclerview.widget.h r12 = new com.obric.oui.orecyclerview.widget.h();
        r12.c(300);
        r12.b(100);
        r12.a(100);
        r12.d(0);
        r2.setItemAnimator((RecyclerView.e) ZeusTransformUtils.preCheckCast(r12, RecyclerView.e.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        r1 = r7;
        goto L9
    }

    private static final MemoryListShareViewModel shareViewModel_delegate$lambda$1(AudioMemoryListFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(MemoryListShareViewModel.class), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void showEmptyView() {
        FragmentAudioMemoryListBinding r0 = this.binding;
        FragmentAudioMemoryListBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.layoutEmpty.setVisibility(0);
        FragmentAudioMemoryListBinding r1 = this.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        r1.rvMemoryList.setVisibility(8);
        FragmentAudioMemoryListBinding r3 = this.binding;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L11:
        r3.listTimeLine.setVisibility(8);
        LocalDate r4 = LocalDate.now();
        boolean r5 = ((com.obric.memorydata.memory.ui.settings.k) ZeusTransformUtils.preCheckCast(getSettingViewModel().getState().c(), com.obric.memorydata.memory.ui.settings.k.class, "com.obric.memorydata.plugin")).d();
        LocalDate r6 = this.currentDate;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("currentDate");
        r6 = null;
    L15:
        if (r4.compareTo((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r6, ChronoLocalDate.class, "com.obric.memorydata.plugin")) >= 0) goto L27;
        FragmentAudioMemoryListBinding r7 = this.binding;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L19:
        r7.tvEmptyTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.audio_memory_general_no_data_title, TypedValues.Custom.S_STRING, "audio_memory_general_no_data_title")), CharSequence.class, "com.obric.memorydata.plugin"));
        FragmentAudioMemoryListBinding r8 = this.binding;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L22:
        r8.tvEmptyDescription.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.audio_memory_general_no_data_empty_description_in_the_feature, TypedValues.Custom.S_STRING, "audio_memory_general_no_data_empty_description_in_the_feature")), CharSequence.class, "com.obric.memorydata.plugin"));
        FragmentAudioMemoryListBinding r12 = this.binding;
        if (r12 != null) goto L25;
    L24:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L26:
        r2.tvEmptyDescription.setVisibility(0);
        return;
    L25:
        r2 = r12;
        goto L26
    L27:
        LocalDate r9 = this.currentDate;
        if (r9 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("currentDate");
        r9 = null;
    L31:
        if (Intrinsics.areEqual(r4, r9) == false) goto L46;
        FragmentAudioMemoryListBinding r10 = this.binding;
        if (r10 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L35:
        r10.tvEmptyTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.audio_memory_general_no_data_title, TypedValues.Custom.S_STRING, "audio_memory_general_no_data_title")), CharSequence.class, "com.obric.memorydata.plugin"));
        FragmentAudioMemoryListBinding r11 = this.binding;
        if (r5 == true) goto L40;
        if (r11 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L39:
        OTextView r13 = r11.tvEmptyDescription;
        int r14 = ZeusTransformUtils.mapRes(R.string.audio_memory_general_no_data_empty_description_in_the_feature, TypedValues.Custom.S_STRING, "audio_memory_general_no_data_empty_description_in_the_feature");
    L43:
        r13.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(r14), CharSequence.class, "com.obric.memorydata.plugin"));
        r12 = this.binding;
        if (r12 != null) goto L25;
    L40:
        if (r11 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L42:
        r13 = r11.tvEmptyDescription;
        r14 = ZeusTransformUtils.mapRes(R.string.memory_generation_queued_other, TypedValues.Custom.S_STRING, "memory_generation_queued_other");
        goto L43
    L46:
        FragmentAudioMemoryListBinding r15 = this.binding;
        if (r15 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L49:
        r15.tvEmptyTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.audio_memory_general_no_data_empty_title, TypedValues.Custom.S_STRING, "audio_memory_general_no_data_empty_title")), CharSequence.class, "com.obric.memorydata.plugin"));
        FragmentAudioMemoryListBinding r16 = this.binding;
        if (r16 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L52:
        r16.tvEmptyDescription.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        FragmentAudioMemoryListBinding r17 = this.binding;
        if (r17 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L56:
        r2.tvEmptyDescription.setVisibility(8);
        return;
    L55:
        r2 = r17;
        goto L56
    }

    private static final AudioMemoryListViewModel viewModel_delegate$lambda$0(AudioMemoryListFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (AudioMemoryListViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(AudioMemoryListViewModel.class), AudioMemoryListViewModel.class, "com.obric.memorydata.plugin");
    }

    public final AudioMemoryListViewModel getViewModel() {
        return (AudioMemoryListViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), AudioMemoryListViewModel.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        this.isFirstLoad = true;
        FragmentAudioMemoryListBinding r4 = FragmentAudioMemoryListBinding.inflate(r1, r2, false);
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        this.binding = r4;
        LocalDate r5 = parseDate();
        if (r5 == null) goto L10;
        this.currentDate = r5;
        FragmentAudioMemoryListBinding r0 = this.binding;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L7:
        ConstraintLayout r6 = r0.getRoot();
        Intrinsics.checkNotNullExpressionValue(r6, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin");
    L10:
        throw new IllegalArgumentException("AudioMemoryFragment must have date arguments");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getShareViewModel().getSelectionManager().j();
        SelectionStateManager.a r0 = SelectionStateManager.f11168a;
        String[] r1 = new String[2];
        r1[0] = MemoryTab.AUDIO.getText();
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
    public void onPause() {
        super.onPause();
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder();
        LocalDate r2 = this.currentDate;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentDate");
        r2 = null;
    L5:
        r0.debug(TAG, r1.append(r2).append(" onPause").toString());
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder();
        LocalDate r2 = this.currentDate;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentDate");
        r2 = null;
    L5:
        r0.debug(TAG, r1.append(r2).append(" onResume").toString());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.needRefreshOnStart == false) goto L9;
        MemoryListAdapter r0 = this.memoryListAdapter;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
        r0 = null;
    L7:
        r0.a();
        this.needRefreshOnStart = false;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.needRefreshOnStart = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L7;
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.memory_tab_container, OaidModel.KEY_ID, "memory_tab_container")), ViewGroup.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L7;
        ViewPager2 r8 = (ViewPager2) ZeusTransformUtils.preCheckCast(r7.findViewWithTag(MemoryTab.AUDIO.getText()), ViewPager2.class, "com.obric.memorydata.plugin");
    L8:
        this.viewPager = r8;
        setupRecyclerView();
        observeData();
        setupCountObservation();
        return;
    L7:
        r8 = null;
        goto L8
    }
}
