package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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
import androidx.paging.ItemSnapshotList;
import androidx.paging.PagingData;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.memory.databinding.FragmentMemoryListBinding;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.BaseFragment;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
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
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u001a\u00105\u001a\u0002062\u0006\u00107\u001a\u00020.2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00108\u001a\u000206H\u0016J\b\u00109\u001a\u000206H\u0016J\u0010\u0010:\u001a\u0002062\u0006\u0010;\u001a\u00020<H\u0016J\u0018\u0010=\u001a\u0002062\u0006\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020+H\u0002J\u0010\u0010@\u001a\u0002062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010A\u001a\u0002062\u0006\u0010B\u001a\u00020\u0012H\u0002J\b\u0010C\u001a\u000206H\u0002J\u0015\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020\u0012H\u0000¢\u0006\u0002\bFJ\u0010\u0010G\u001a\u0002062\u0006\u0010H\u001a\u00020)H\u0002J\u0012\u0010I\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u00010.H\u0002J\b\u0010J\u001a\u00020)H\u0002J\b\u0010K\u001a\u000206H\u0002J\b\u0010L\u001a\u000206H\u0016J\b\u0010M\u001a\u000206H\u0016J\b\u0010N\u001a\u00020\u0012H\u0002J\u0010\u0010O\u001a\u00020)2\u0006\u0010P\u001a\u00020)H\u0002J\u0010\u0010Q\u001a\u00020+2\u0006\u0010>\u001a\u00020#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListFragment;", "Lcom/obric/memorydata/ui/BaseFragment;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/FragmentMemoryListBinding;", "viewModel", "Lcom/obric/memorydata/memory/ui/list/MemoryListViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/list/MemoryListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "shareViewModel", "Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "getShareViewModel", "()Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "shareViewModel$delegate", MemoryListFragment.ARG_POSITION, "", "getPosition", "()I", "position$delegate", "memoryTab", "Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "getMemoryTab", "()Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "memoryTab$delegate", "sourceFilter", "Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "getSourceFilter", "()Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "sourceFilter$delegate", "memoryListAdapter", "Lcom/obric/memorydata/memory/ui/list/MemoryListAdapter;", "jumpTargetEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "viewPager", "Lcom/obric/oui/viewpager2/widget/ViewPager2;", "recyclerViewInterceptor", "Lcom/obric/memorydata/memory/ui/ConflictWithViewPage2Handler;", "theme", "", "needRefreshOnStart", "", "appliedTopPadding", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onStop", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "scrollToItemIfNeeded", "entity", "isFirst", "scrollToTargetPosition", "applyTopPaddingOnce", "rvTop", "setupRecyclerView", "applyRecyclerViewTopPadding", "topPadding", "applyRecyclerViewTopPadding$memory_obricRelease", "dumpBottomOverlapDiag", InfoRequestQPSOptTraceLogger.REASON, "viewDiag", "recyclerSnapshot", "observeData", "onDestroy", "onDestroyView", "getTopContentInset", "pagingLifecycleSnapshot", "event", "shouldHandleTargetEntity", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryListFragment extends BaseFragment {
    private static final String ARG_POSITION = "position";
    private static final String ARG_SOURCE_FILTER = "source_filter";
    public static final a Companion = null;
    private static final String DIAG_PREFIX = "[OTabDiag][List]";
    private static final String TAG = "MemoryListFragment";
    private int appliedTopPadding;
    private FragmentMemoryListBinding binding;
    private AppEntity jumpTargetEntity;
    private MemoryListAdapter memoryListAdapter;
    private final Lazy memoryTab$delegate;
    private boolean needRefreshOnStart;
    private final Lazy position$delegate;
    private com.obric.memorydata.memory.ui.a recyclerViewInterceptor;
    private final Lazy shareViewModel$delegate;
    private final Lazy sourceFilter$delegate;
    private String theme;
    private final Lazy viewModel$delegate;
    private ViewPager2 viewPager;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListFragment$Companion;", "", "<init>", "()V", "TAG", "", "DIAG_PREFIX", "ARG_POSITION", "ARG_SOURCE_FILTER", "newInstance", "Lcom/obric/memorydata/memory/ui/list/MemoryListFragment;", MemoryListFragment.ARG_POSITION, "", "sourceFilter", "Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final MemoryListFragment a(int r3, MemorySourceFilter r4) {
            MemoryListFragment r2 = new MemoryListFragment();
            Bundle r0 = new Bundle();
            r0.putInt(MemoryListFragment.ARG_POSITION, r3);
            if (r4 == null) goto L5;
            r0.putParcelable(MemoryListFragment.ARG_SOURCE_FILTER, (Parcelable) ZeusTransformUtils.preCheckCast(r4, Parcelable.class, "com.obric.memorydata.plugin"));
        L5:
            r2.setArguments(r0);
            return r2;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$1", f = "MemoryListFragment.kt", i = {}, l = {277}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class C05721<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MemoryListFragment f11048a;

            C05721(MemoryListFragment r1) {
                this.f11048a = r1;
            }

            private static final void a(MemoryListFragment r4, boolean r5) {
                MemoryListAdapter r0 = MemoryListFragment.access$getMemoryListAdapter$p(r4);
                MemoryListAdapter r1 = null;
                if (r0 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r0 = null;
            L5:
                MemoryListAdapter r6 = MemoryListFragment.access$getMemoryListAdapter$p(r4);
                if (r6 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
            L9:
                r0.a(0, r1.d(), new MemoryListAdapter.Companion.a("edit_mode", Boolean.valueOf(r5)));
                return;
            L8:
                r1 = r6;
                goto L9
            }

            public static /* synthetic */ void lambda$XxSjDWvG_ZWphfUzS_WqdPc_azQ(MemoryListFragment r0, boolean r1) {
                a(r0, r1);
            }

            public final Object a(final boolean r3, Continuation<? super Unit> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                com.obric.memorydata.memory.ui.a r6 = MemoryListFragment.access$getRecyclerViewInterceptor$p(this.f11048a);
                if (r6 == null) goto L5;
                r6.a(!r3);
            L5:
                FragmentMemoryListBinding r7 = MemoryListFragment.access$getBinding$p(this.f11048a);
                if (r7 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r7 = null;
            L8:
                RecyclerView r8 = r7.rvMemoryList;
                final MemoryListFragment r2 = this.f11048a;
                r8.post(new $$Lambda$MemoryListFragment$observeData$1$1$XxSjDWvG_ZWphfUzS_WqdPc_azQ(r2, r3));
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), r5);
            }
        }

        AnonymousClass1(MemoryListFragment r3, Continuation<? super AnonymousClass1> r4) {
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
            kotlinx.coroutines.flow.ar<Boolean> r7 = MemoryListFragment.access$getShareViewModel(this.this$0).getSelectionManager().b();
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05721(this.this$0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$2", f = "MemoryListFragment.kt", i = {}, l = {289}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MemoryListFragment f11049a;

            AnonymousClass1(MemoryListFragment r1) {
                this.f11049a = r1;
            }

            private static final void a(MemoryListFragment r5) {
                MemoryListAdapter r0 = MemoryListFragment.access$getMemoryListAdapter$p(r5);
                if (r0 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r0 = null;
            L5:
                MemoryListAdapter r6 = MemoryListFragment.access$getMemoryListAdapter$p(r5);
                if (r6 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r6 = null;
            L8:
                r0.a(0, r6.d(), new MemoryListAdapter.Companion.a("selection", null));
            }

            public static /* synthetic */ void lambda$hFBIdt6HPer4Gf71wJZeKV38ouk(MemoryListFragment r0) {
                a(r0);
            }

            public final Object a(SelectionStateManager.SelectAllState r2, Continuation<? super Unit> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                FragmentMemoryListBinding r5 = MemoryListFragment.access$getBinding$p(this.f11049a);
                if (r5 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r5 = null;
            L5:
                RecyclerView r6 = r5.rvMemoryList;
                final MemoryListFragment r1 = this.f11049a;
                r6.post(new $$Lambda$MemoryListFragment$observeData$2$1$hFBIdt6HPer4Gf71wJZeKV38ouk(r1));
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return a((SelectionStateManager.SelectAllState) ZeusTransformUtils.preCheckCast(r3, SelectionStateManager.SelectAllState.class, "com.obric.memorydata.plugin"), r5);
            }
        }

        AnonymousClass2(MemoryListFragment r3, Continuation<? super AnonymousClass2> r4) {
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
            kotlinx.coroutines.flow.ar<SelectionStateManager.SelectAllState> r7 = MemoryListFragment.access$getShareViewModel(this.this$0).getSelectionManager().c();
            kotlinx.coroutines.flow.j<? super SelectionStateManager.SelectAllState> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$3", f = "MemoryListFragment.kt", i = {}, l = {305}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$3$1", f = "MemoryListFragment.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
            final /* synthetic */ kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> $flow;
            int label;
            final /* synthetic */ MemoryListFragment this$0;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$3$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$3$1$1", f = "MemoryListFragment.kt", i = {}, l = {310}, m = "invokeSuspend", n = {}, s = {})
            static final class C05731 extends SuspendLambda implements Function2<PagingData<com.obric.memorydata.memory.ui.data.a>, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ MemoryListFragment this$0;

                C05731(MemoryListFragment r3, Continuation<? super C05731> r4) {
                    Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    this.this$0 = r3;
                    super(2, r5);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                    Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    C05731 r0 = new C05731(this.this$0, r5);
                    r0.L$0 = r3;
                    return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(PagingData<com.obric.memorydata.memory.ui.data.a> r3, Continuation<? super Unit> r4) {
                    return ((C05731) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05731.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
                    IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryListFragment.TAG, MemoryListFragment.access$pagingLifecycleSnapshot(this.this$0, "SUBMIT"), false, 4, null);
                    MemoryListAdapter r2 = MemoryListFragment.access$getMemoryListAdapter$p(this.this$0);
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

            AnonymousClass1(MemoryListFragment r3, kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r4, Continuation<? super AnonymousClass1> r5) {
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
                String r5 = MemoryListFragment.access$pagingLifecycleSnapshot(this.this$0, "COLLECTOR_STOP");
                r4 = MemoryListFragment.TAG;
                IRunLog.a.a(r3, MemoryListFragment.TAG, r5, false, 4, null);
                AnonymousClass1 this = Unit.INSTANCE;
                return this;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                ResultKt.throwOnFailure(r12);
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryListFragment.TAG, MemoryListFragment.access$pagingLifecycleSnapshot(this.this$0, "COLLECTOR_START"), false, 4, null);
                kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r13 = this.$flow;     // Catch: Throwable -> L7
                Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C05731(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                this.label = 1;     // Catch: Throwable -> L7
                if (kotlinx.coroutines.flow.k.a(r13, r2, r6) != r0) goto L15;
                return r0;
            L7:
                th = move-exception;
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r4), MemoryListFragment.TAG, MemoryListFragment.access$pagingLifecycleSnapshot(this.this$0, "COLLECTOR_STOP"), false, 4, null);
                throw th;
            }
        }

        AnonymousClass3(MemoryListFragment r3, Continuation<? super AnonymousClass3> r4) {
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
        L20:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            MemoryListViewModel r10 = this.this$0.getViewModel();
            MemoryTab r2 = MemoryListFragment.access$getMemoryTab(this.this$0);
            MemorySourceFilter r3 = MemoryListFragment.access$getSourceFilter(this.this$0);
            if (r3 == null) goto L11;
            String r4 = r3.getSourcePackageName();
        L12:
            MemorySourceFilter r5 = MemoryListFragment.access$getSourceFilter(this.this$0);
            if (r5 == null) goto L15;
            Integer r6 = r5.getSourceProductType();
        L16:
            kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r11 = r10.getMemoryList(r2, r4, r6);
            LifecycleOwner r7 = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(r7, "getViewLifecycleOwner(...)");
            kotlinx.coroutines.flow.i r12 = CachedPagingDataKt.cachedIn(r11, (kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r7), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"));
            LifecycleOwner r8 = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(r8, "getViewLifecycleOwner(...)");
            Lifecycle.State r13 = z.f11341a.a();
            Function2 r14 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r12, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, r13, r14, r15) != r0) goto L20;
            return r0;
        L15:
            r6 = null;
            goto L16
        L11:
            r4 = null;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$4", f = "MemoryListFragment.kt", i = {}, l = {TypedValues.AttributesType.TYPE_PIVOT_TARGET}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryListFragment this$0;

        AnonymousClass4(MemoryListFragment r3, Continuation<? super AnonymousClass4> r4) {
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
            MemoryListAdapter r7 = MemoryListFragment.access$getMemoryListAdapter$p(this.this$0);
            if (r7 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
            r7 = null;
        L11:
            kotlinx.coroutines.flow.i<CombinedLoadStates> r8 = r7.e();
            final MemoryListFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super CombinedLoadStates> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r8.collect(r2, r4) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$5", f = "MemoryListFragment.kt", i = {}, l = {344}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryListFragment this$0;

        AnonymousClass5(MemoryListFragment r3, Continuation<? super AnonymousClass5> r4) {
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
            kotlinx.coroutines.flow.ar<Pair<MemoryTab, Pair<LocalDate, AppEntity>>> r7 = MemoryListFragment.access$getShareViewModel(this.this$0).getTargetEntityFlow();
            final MemoryListFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Pair<MemoryTab, Pair<LocalDate, AppEntity>>> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$6", f = "MemoryListFragment.kt", i = {}, l = {362}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryListFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$6$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListFragment$observeData$6$1", f = "MemoryListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MemoryListFragment this$0;

            AnonymousClass1(MemoryListFragment r3, Continuation<? super AnonymousClass1> r4) {
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
                if (Intrinsics.areEqual(MemoryListShareViewModel.getMixTab$default(MemoryListFragment.access$getShareViewModel(this.this$0), null, 1, null), MemoryListFragment.access$getMemoryTab(this.this$0).getText()) == false) goto L12;
                RunLog.INSTANCE.debug(MemoryListFragment.TAG, MemoryListFragment.access$getMemoryTab(this.this$0) + ", refresh=" + r6);
                MemoryListAdapter r4 = MemoryListFragment.access$getMemoryListAdapter$p(this.this$0);
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

        AnonymousClass6(MemoryListFragment r3, Continuation<? super AnonymousClass6> r4) {
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(MemoryListFragment.access$getShareViewModel(this.this$0).getMemoryDeleteFlow(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryListFragment() {
        this.viewModel$delegate = LazyKt.lazy(new $$Lambda$MemoryListFragment$5Og37tcybj0sbA9a3ZQ_aL55uiU(this));
        this.shareViewModel$delegate = LazyKt.lazy(new $$Lambda$MemoryListFragment$zItxD4aIbCEcdwXYfQrCU4ucNUM(this));
        this.position$delegate = LazyKt.lazy(new $$Lambda$MemoryListFragment$s4TBvtqPliJrkO9dIOYJKB73WMA(this));
        this.memoryTab$delegate = LazyKt.lazy(new $$Lambda$MemoryListFragment$4kuKQl1SSOhx4WPSdRjdZLzULs(this));
        this.sourceFilter$delegate = LazyKt.lazy(new $$Lambda$MemoryListFragment$VDMBQKYVxE2eUNX0HzIER5kvzw(this));
        this.appliedTopPadding = -1;
    }

    public static final /* synthetic */ FragmentMemoryListBinding access$getBinding$p(MemoryListFragment r0) {
        return r0.binding;
    }

    public static final /* synthetic */ AppEntity access$getJumpTargetEntity$p(MemoryListFragment r0) {
        return r0.jumpTargetEntity;
    }

    public static final /* synthetic */ MemoryListAdapter access$getMemoryListAdapter$p(MemoryListFragment r0) {
        return r0.memoryListAdapter;
    }

    public static final /* synthetic */ MemoryTab access$getMemoryTab(MemoryListFragment r0) {
        return r0.getMemoryTab();
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.a access$getRecyclerViewInterceptor$p(MemoryListFragment r0) {
        return r0.recyclerViewInterceptor;
    }

    public static final /* synthetic */ MemoryListShareViewModel access$getShareViewModel(MemoryListFragment r0) {
        return r0.getShareViewModel();
    }

    public static final /* synthetic */ MemorySourceFilter access$getSourceFilter(MemoryListFragment r0) {
        return r0.getSourceFilter();
    }

    public static final /* synthetic */ String access$pagingLifecycleSnapshot(MemoryListFragment r0, String r1) {
        return r0.pagingLifecycleSnapshot(r1);
    }

    public static final /* synthetic */ void access$scrollToItemIfNeeded(MemoryListFragment r0, AppEntity r1, boolean r2) {
        r0.scrollToItemIfNeeded(r1, r2);
    }

    public static final /* synthetic */ void access$setJumpTargetEntity$p(MemoryListFragment r0, AppEntity r1) {
        r0.jumpTargetEntity = r1;
    }

    public static final /* synthetic */ boolean access$shouldHandleTargetEntity(MemoryListFragment r0, AppEntity r1) {
        return r0.shouldHandleTargetEntity(r1);
    }

    private static final void applyRecyclerViewTopPadding$lambda$13(MemoryListFragment r1) {
        r1.dumpBottomOverlapDiag("applyRecyclerViewTopPadding.post");
    }

    private final void applyTopPaddingOnce(int r8) {
        if (r8 > 0) goto L5;
        return;
    L5:
        if (this.appliedTopPadding != r8) goto L7;
        return;
    L7:
        FragmentMemoryListBinding r0 = this.binding;
        String r2 = null;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L10:
        int r1 = r0.rvMemoryList.getPaddingTop();
        this.appliedTopPadding = r8;
        FragmentMemoryListBinding r3 = this.binding;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L13:
        RecyclerView r4 = r3.rvMemoryList;
        FragmentMemoryListBinding r5 = this.binding;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L16:
        int r6 = r5.rvMemoryList.getPaddingLeft();
        FragmentMemoryListBinding r7 = this.binding;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L19:
        int r9 = r7.rvMemoryList.getPaddingRight();
        FragmentMemoryListBinding r10 = this.binding;
        if (r10 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L22:
        r4.setPadding(r6, r8, r9, r10.rvMemoryList.getPaddingBottom());
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L29;
        RunLog r11 = RunLog.INSTANCE;
        StringBuilder r12 = new StringBuilder().append("[OTabDiag][List] applyTopPaddingOnce tab=").append(getMemoryTab()).append(" source=");
        MemorySourceFilter r13 = getSourceFilter();
        if (r13 == null) goto L27;
        r2 = r13.getStableKey();
    L27:
        r11.debug(TAG, r12.append(r2).append(" old=").append(r1).append(" new=").append(r8).append(" applied=").append(this.appliedTopPadding).append(" rv=").append(recyclerSnapshot()).toString());
        return;
    }

    private final void dumpBottomOverlapDiag(String r13) {
        if (this.binding != null) goto L6;
        return;
    L6:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == true) goto L8;
        return;
    L8:
        FragmentMemoryListBinding r0 = this.binding;
        String r1 = null;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L11:
        RecyclerView r2 = r0.rvMemoryList;
        Intrinsics.checkNotNullExpressionValue(r2, "rvMemoryList");
        RecyclerView.h r3 = r2.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r3, LinearLayoutManager.class) == false) goto L14;
        LinearLayoutManager r4 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r3, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L15:
        int r5 = -1;
        if (r4 == null) goto L18;
        int r6 = r4.o();
    L19:
        if (r4 == null) goto L21;
        r5 = r4.p();
    L21:
        if (r6 < 0) goto L24;
        if (r4 == null) goto L24;
        View r7 = r4.c(r6);
    L25:
        if (r5 < 0) goto L28;
        if (r4 == null) goto L28;
        View r8 = r4.c(r5);
    L29:
        FragmentActivity r9 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L32;
        View r10 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.memory_container_tab_view, OaidModel.KEY_ID, "memory_container_tab_view"));
    L33:
        FragmentActivity r11 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L36;
        View r12 = r11.findViewById(ZeusTransformUtils.mapRes(R.id.cut_off_bottom, OaidModel.KEY_ID, "cut_off_bottom"));
    L37:
        RunLog r14 = RunLog.INSTANCE;
        StringBuilder r15 = new StringBuilder().append("[OTabDiag][List] bottomOverlap[").append(r13).append("] tab=").append(getMemoryTab()).append(" source=");
        MemorySourceFilter r16 = getSourceFilter();
        if (r16 == null) goto L40;
        r1 = r16.getStableKey();
    L40:
        r14.debug(TAG, r15.append(r1).append(" rv=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"))).append(" first=").append(r6).append(" firstView=").append(viewDiag(r7)).append(" last=").append(r5).append(" lastView=").append(viewDiag(r8)).append(" bottomNav=").append(viewDiag(r10)).append(" cutOffBottom=").append(viewDiag(r12)).toString());
        return;
    L36:
        r12 = null;
        goto L37
    L32:
        r10 = null;
    L28:
        r8 = null;
    L24:
        r7 = null;
        goto L25
    L18:
        r6 = -1;
        goto L19
    L14:
        r4 = null;
        goto L15
    }

    private final MemoryTab getMemoryTab() {
        return (MemoryTab) ZeusTransformUtils.preCheckCast(this.memoryTab$delegate.getValue(), MemoryTab.class, "com.obric.memorydata.plugin");
    }

    private final int getPosition() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.position$delegate.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final MemoryListShareViewModel getShareViewModel() {
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(this.shareViewModel$delegate.getValue(), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    private final MemorySourceFilter getSourceFilter() {
        return (MemorySourceFilter) ZeusTransformUtils.preCheckCast(this.sourceFilter$delegate.getValue(), MemorySourceFilter.class, "com.obric.memorydata.plugin");
    }

    private final int getTopContentInset() {
        if (getMemoryTab() != MemoryTab.COLLECT) goto L5;
        int r2 = 104;
    L7:
        return MathKt.roundToInt(TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics()));
    L5:
        r2 = 56;
        goto L7
    }

    /* JADX INFO: renamed from: lambda$4kuKQl1SSO-hx4WPSdRjdZLzULs, reason: not valid java name */
    public static /* synthetic */ MemoryTab m888lambda$4kuKQl1SSOhx4WPSdRjdZLzULs(MemoryListFragment r0) {
        return memoryTab_delegate$lambda$3(r0);
    }

    public static /* synthetic */ MemoryListViewModel lambda$5Og37tcybj0sbA9a3ZQ_aL55uiU(MemoryListFragment r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$Tgb8dWtYGdydcxexuif4hWxZBlI(MemoryListFragment r0) {
        applyRecyclerViewTopPadding$lambda$13(r0);
    }

    /* JADX INFO: renamed from: lambda$VDMBQKYVxE2eUN-X0HzIER5kvzw, reason: not valid java name */
    public static /* synthetic */ MemorySourceFilter m889lambda$VDMBQKYVxE2eUNX0HzIER5kvzw(MemoryListFragment r0) {
        return sourceFilter_delegate$lambda$4(r0);
    }

    public static /* synthetic */ void lambda$jApgWGTVndJxlSEH_QKycyJMAyQ(MemoryListFragment r0, int r1) {
        scrollToTargetPosition$lambda$6(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$kgN8qkx2F98wQju_cGyPX91-ndY, reason: not valid java name */
    public static /* synthetic */ WindowInsetsCompat m890lambda$kgN8qkx2F98wQju_cGyPX91ndY(MemoryListFragment r0, View r1, WindowInsetsCompat r2) {
        return setupRecyclerView$lambda$10$lambda$8(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$s1AUbtFqsZXZFBSIfQrmOfx4dJ4(MemoryListFragment r0) {
        setupRecyclerView$lambda$10$lambda$9(r0);
    }

    public static /* synthetic */ int lambda$s4TBvtqPliJrkO9dIOYJKB73WMA(MemoryListFragment r0) {
        return position_delegate$lambda$2(r0);
    }

    public static /* synthetic */ MemoryListShareViewModel lambda$zItxD4aIbCEcdwXYfQrCU4ucNUM(MemoryListFragment r0) {
        return shareViewModel_delegate$lambda$1(r0);
    }

    private static final MemoryTab memoryTab_delegate$lambda$3(MemoryListFragment r1) {
        return MemoryTab.Companion.a(r1.getPosition());
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
    }

    private final String pagingLifecycleSnapshot(String r3) {
        StringBuilder r4 = new StringBuilder().append("[MEM][PagingLifecycle] ").append(r3).append(" page=").append(getMemoryTab()).append(" source=");
        MemorySourceFilter r0 = getSourceFilter();
        if (r0 == null) goto L5;
        String r1 = r0.getStableKey();
    L6:
        StringBuilder r5 = r4.append(r1).append(" fragmentState=").append(getLifecycle().getCurrentState()).append(" viewState=").append(getViewLifecycleOwner().getLifecycle().getCurrentState()).append(" pagerItem=");
        ViewPager2 r2 = this.viewPager;
        if (r2 == null) goto L9;
        int r6 = r2.getCurrentItem();
    L11:
        return r5.append(r6).toString();
    L9:
        r6 = -1;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    private static final int position_delegate$lambda$2(MemoryListFragment r1) {
        Bundle r2 = r1.getArguments();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.getInt(ARG_POSITION);
    }

    private final String recyclerSnapshot() {
        FragmentMemoryListBinding r0 = this.binding;
        if (r0 != null) goto L6;
        return "bindingNotInitialized";
    L6:
        MemoryListAdapter r1 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L9:
        RecyclerView r2 = r0.rvMemoryList;
        Intrinsics.checkNotNullExpressionValue(r2, "rvMemoryList");
        StringBuilder r3 = new StringBuilder().append("shown=").append(r2.isShown()).append(",vis=").append(r2.getVisibility()).append(",h=").append(r2.getHeight()).append(",top=").append(r2.getTop()).append(",bottom=").append(r2.getBottom()).append(",paddingTop=").append(r2.getPaddingTop()).append(",paddingBottom=").append(r2.getPaddingBottom()).append(",clipToPadding=").append(r2.getClipToPadding()).append(",itemCount=");
        MemoryListAdapter r4 = this.memoryListAdapter;
        if (r4 == null) goto L15;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
    L14:
        int r5 = r1.d();
    L17:
        return r3.append(r5).toString();
    L13:
        r1 = r4;
        goto L14
    L15:
        r5 = -1;
        goto L17
    }

    private final void scrollToItemIfNeeded(AppEntity r11, boolean r12) {
        MemoryListAdapter r0 = this.memoryListAdapter;
        FragmentMemoryListBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
        r0 = null;
    L5:
        ItemSnapshotList<com.obric.memorydata.memory.ui.data.a> r2 = r0.c();
        Iterator r3 = ((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin")).iterator();
        int r5 = 0;
    L7:
        if (r3.hasNext() == false) goto L17;
        com.obric.memorydata.memory.ui.data.a r6 = (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.h.class) == true) goto L11;
    L13:
        boolean r7 = false;
    L14:
        if (r7 == true) goto L19;
        r5 = r5 + 1;
    L19:
        if (r5 < 0) goto L29;
        int r13 = r5 - 1;
        if (r13 >= 0) goto L23;
    L25:
        RunLog r14 = RunLog.INSTANCE;
        StringBuilder r4 = new StringBuilder().append(getMemoryTab()).append(" scrollToItemIfNeeded, scrollToTargetPosition ").append(r5).append(", paddingTop=");
        FragmentMemoryListBinding r8 = this.binding;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L28:
        r14.debug(TAG, r4.append(r8.rvMemoryList.getPaddingTop()).toString());
        this.jumpTargetEntity = null;
        scrollToTargetPosition(r5);
        return;
    L23:
        if (ZeusTransformUtils.instanceOf((com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r2.get(r13), com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"), com.obric.memorydata.memory.ui.data.a.d.class) == false) goto L25;
        r5 = r13;
        goto L25
    L29:
        if (r12 == false) goto L35;
        RunLog.INSTANCE.debug(TAG, getMemoryTab() + " scrollToItemIfNeeded, scrollToPosition start");
        FragmentMemoryListBinding r10 = this.binding;
        if (r10 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L34:
        r1.rvMemoryList.scrollToPosition(0);
        return;
    L33:
        r1 = r10;
        goto L34
    L35:
        RunLog.INSTANCE.debug(TAG, getMemoryTab() + " scrollToItemIfNeeded, scrollToPosition end");
        FragmentMemoryListBinding r15 = this.binding;
        if (r15 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L39:
        r1.rvMemoryList.scrollToPosition(r2.size() - 1);
        return;
    L38:
        r1 = r15;
        goto L39
    L11:
        if (Intrinsics.areEqual(r11.getId(), ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getId()) == false) goto L13;
        r7 = true;
        goto L14
    L17:
        r5 = -1;
        goto L19
    }

    private final void scrollToTargetPosition(final int r3) {
        FragmentMemoryListBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.rvMemoryList.post(new $$Lambda$MemoryListFragment$jApgWGTVndJxlSEH_QKycyJMAyQ(this, r3));
    }

    private static final void scrollToTargetPosition$lambda$6(MemoryListFragment r5, int r6) {
        FragmentMemoryListBinding r0 = r5.binding;
        FragmentMemoryListBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        RecyclerView.h r1 = r0.rvMemoryList.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r1, LinearLayoutManager.class) == false) goto L8;
        LinearLayoutManager r3 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r1, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L9:
        if (r3 == null) goto L11;
        r3.b(r6, 0);
        return;
    L11:
        FragmentMemoryListBinding r7 = r5.binding;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r2.rvMemoryList.scrollToPosition(r6);
        return;
    L14:
        r2 = r7;
        goto L15
    L8:
        r3 = null;
        goto L9
    }

    private final void setupRecyclerView() {
        FragmentMemoryListBinding r0 = this.binding;
        GlobalMemoryTabFragment r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        RecyclerView r2 = r0.rvMemoryList;
        r2.setClipToPadding(false);
        r2.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        FragmentActivity r3 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.memorydata.memory.ui.list.MemoryListActivity");
        MemoryListActivity r4 = (MemoryListActivity) ZeusTransformUtils.preCheckCast(r3, MemoryListActivity.class, "com.obric.memorydata.plugin");
        MemoryListAdapter r5 = new MemoryListAdapter(getShareViewModel().getSelectionManager(), null, false, 6, null);
        this.memoryListAdapter = r5;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
        r5 = null;
    L8:
        r2.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r5.a((com.obric.memorydata.ui.recyclerview.a) ZeusTransformUtils.preCheckCast(new i(), com.obric.memorydata.ui.recyclerview.a.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.ui.recyclerview.a) ZeusTransformUtils.preCheckCast(new i(), com.obric.memorydata.ui.recyclerview.a.class, "com.obric.memorydata.plugin")), RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r2);
        this.recyclerViewInterceptor = new com.obric.memorydata.memory.ui.a(r2, this.viewPager, false, false);
        RecyclerView.e r6 = r2.getItemAnimator();
        if (ZeusTransformUtils.instanceOf(r6, com.obric.oui.orecyclerview.widget.z.class) == false) goto L11;
        com.obric.oui.orecyclerview.widget.z r7 = (com.obric.oui.orecyclerview.widget.z) ZeusTransformUtils.preCheckCast(r6, com.obric.oui.orecyclerview.widget.z.class, "com.obric.memorydata.plugin");
    L12:
        if (r7 == null) goto L14;
        r7.a(false);
    L14:
        int r8 = com.obric.memorydata.memory.ui.b.f10769a.a();
        if (getMemoryTab() != MemoryTab.COLLECT) goto L18;
        int r9 = MathKt.roundToInt(TypedValue.applyDimension(1, 148, Resources.getSystem().getDisplayMetrics()));
    L17:
        applyTopPaddingOnce(r9);
    L21:
        r2.post(new $$Lambda$MemoryListFragment$s1AUbtFqsZXZFBSIfQrmOfx4dJ4(this));
        Fragment r10 = getParentFragment();
        if (ZeusTransformUtils.instanceOf(r10, GlobalMemoryTabFragment.class) == false) goto L24;
        r1 = (GlobalMemoryTabFragment) ZeusTransformUtils.preCheckCast(r10, GlobalMemoryTabFragment.class, "com.obric.memorydata.plugin");
    L24:
        if (r1 == null) goto L27;
        r1.applyCurrentRecyclerViewTopPadding$memory_obricRelease(this);
        return;
    L27:
        return;
    L18:
        if (r8 <= 0) goto L20;
        r9 = r8 + getTopContentInset();
        goto L17
    L20:
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryListFragment$kgN8qkx2F98wQju_cGyPX91ndY(this));
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        goto L21
    L11:
        r7 = null;
        goto L12
    }

    private static final WindowInsetsCompat setupRecyclerView$lambda$10$lambda$8(MemoryListFragment r2, View r3, WindowInsetsCompat r4) {
        Intrinsics.checkNotNullParameter(r3, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r4, "insets");
        int r0 = r4.getInsets(WindowInsetsCompat.Type.statusBars()).top;
        if (r2.appliedTopPadding >= 0) goto L6;
        if (r0 <= 0) goto L6;
        r2.applyTopPaddingOnce(r0 + r2.getTopContentInset());
        ViewCompat.setOnApplyWindowInsetsListener(r3, null);
    L6:
        return r4;
    }

    private static final void setupRecyclerView$lambda$10$lambda$9(MemoryListFragment r1) {
        r1.dumpBottomOverlapDiag("setupRecyclerView.post");
    }

    private static final MemoryListShareViewModel shareViewModel_delegate$lambda$1(MemoryListFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(MemoryListShareViewModel.class), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    private final boolean shouldHandleTargetEntity(AppEntity r7) {
        MemorySourceFilter r0 = getSourceFilter();
        if (r0 != null) goto L6;
        return true;
    L6:
        if (getShareViewModel().getForceCollectAllForTarget() == true) goto L8;
        String r2 = getShareViewModel().getTargetCollectSourcePackage();
        if (r2 == null) goto L19;
        if (Intrinsics.areEqual(r0.getSourcePackageName(), r2) == false) goto L17;
        if (Intrinsics.areEqual(r0.getSourceProductType(), getShareViewModel().getTargetCollectSourceProductType()) == false) goto L17;
        return true;
    L17:
        return false;
    L19:
        if (r0.isAll() == false) goto L21;
        return true;
    L21:
        Integer r4 = null;
        if (ZeusTransformUtils.instanceOf(r7, MemoryEntity.class) == false) goto L24;
        MemoryEntity r6 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r7, MemoryEntity.class, "com.obric.memorydata.plugin");
    L25:
        if (r6 == null) goto L27;
        String r8 = r6.getSourcePackageName();
    L29:
        if (ZeusTransformUtils.instanceOf(r7, MemoryEntity.class) == false) goto L31;
        MemoryEntity r9 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r7, MemoryEntity.class, "com.obric.memorydata.plugin");
    L32:
        if (r9 == null) goto L35;
        r4 = Integer.valueOf(MemorySourceFilter.Companion.c(r9.getProductType()));
    L35:
        if (Intrinsics.areEqual(r8, r0.getSourcePackageName()) == false) goto L40;
        if (Intrinsics.areEqual(r4, r0.getSourceProductType()) == false) goto L40;
        return true;
    L40:
        return false;
    L31:
        r9 = null;
        goto L32
    L27:
        r8 = null;
        goto L29
    L24:
        r6 = null;
        goto L25
    L8:
        return r0.isAll();
    }

    private static final MemorySourceFilter sourceFilter_delegate$lambda$4(MemoryListFragment r2) {
        Bundle r3 = r2.getArguments();
        if (r3 != null) goto L7;
        return null;
    L7:
        return (MemorySourceFilter) ZeusTransformUtils.preCheckCast(r3.getParcelable(ARG_SOURCE_FILTER), MemorySourceFilter.class, "com.obric.memorydata.plugin");
    }

    private final String viewDiag(View r5) {
        if (r5 != null) goto L5;
        return "null";
    L5:
        int[] r4 = new int[2];
        r5.getLocationInWindow(r4);
        StringBuilder r0 = new StringBuilder();
        r0.append(r5.getClass().getSimpleName()).append('@').append(r4[0]).append(',').append(r4[1]).append(" size=").append(r5.getWidth()).append('x').append(r5.getHeight()).append(" top=").append(r5.getTop()).append(" bottom=").append(r5.getBottom()).append(" padding=").append(r5.getPaddingLeft()).append(',').append(r5.getPaddingTop()).append(',').append(r5.getPaddingRight()).append(',').append(r5.getPaddingBottom()).append(" visible=").append(r5.getVisibility());
        r0.append(" alpha=").append(r5.getAlpha());
        return r0.toString();
    }

    private static final MemoryListViewModel viewModel_delegate$lambda$0(MemoryListFragment r3) {
        return (MemoryListViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r3, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(MemoryListViewModel.class), MemoryListViewModel.class, "com.obric.memorydata.plugin");
    }

    public final void applyRecyclerViewTopPadding$memory_obricRelease(int r11) {
        if (r11 <= 0) goto L50;
        FragmentMemoryListBinding r0 = this.binding;
        if (r0 == null) goto L51;
        FragmentMemoryListBinding r2 = null;
        String r3 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L9:
        r0.rvMemoryList.setClipToPadding(false);
        FragmentMemoryListBinding r1 = this.binding;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L13:
        if (r1.rvMemoryList.getPaddingTop() == r11) goto L15;
        FragmentMemoryListBinding r4 = this.binding;
        if (r4 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L24:
        int r5 = r4.rvMemoryList.getPaddingTop();
        this.appliedTopPadding = r11;
        FragmentMemoryListBinding r6 = this.binding;
        if (r6 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L27:
        RecyclerView r7 = r6.rvMemoryList;
        FragmentMemoryListBinding r8 = this.binding;
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L30:
        int r9 = r8.rvMemoryList.getPaddingLeft();
        FragmentMemoryListBinding r10 = this.binding;
        if (r10 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L33:
        int r12 = r10.rvMemoryList.getPaddingRight();
        FragmentMemoryListBinding r13 = this.binding;
        if (r13 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L36:
        r7.setPadding(r9, r11, r12, r13.rvMemoryList.getPaddingBottom());
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L43;
        RunLog r14 = RunLog.INSTANCE;
        StringBuilder r15 = new StringBuilder().append("[OTabDiag][List] applyRecyclerViewTopPadding tab=").append(getMemoryTab()).append(" source=");
        MemorySourceFilter r16 = getSourceFilter();
        if (r16 == null) goto L41;
        String r17 = r16.getStableKey();
    L42:
        r14.debug(TAG, r15.append(r17).append(" old=").append(r5).append(" new=").append(r11).append(" rv=").append(recyclerSnapshot()).toString());
        goto L43
    L41:
        r17 = null;
    L43:
        FragmentMemoryListBinding r18 = this.binding;
        if (r18 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L47:
        r2.rvMemoryList.post(new $$Lambda$MemoryListFragment$Tgb8dWtYGdydcxexuif4hWxZBlI(this));
        return;
    L46:
        r2 = r18;
        goto L47
    L15:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L49;
        RunLog r19 = RunLog.INSTANCE;
        StringBuilder r20 = new StringBuilder().append("[OTabDiag][List] applyRecyclerViewTopPadding.skipSame tab=").append(getMemoryTab()).append(" source=");
        MemorySourceFilter r21 = getSourceFilter();
        if (r21 == null) goto L19;
        r3 = r21.getStableKey();
    L19:
        r19.debug(TAG, r20.append(r3).append(" top=").append(r11).append(" rv=").append(recyclerSnapshot()).toString());
        return;
    L49:
        return;
    L51:
        return;
    }

    public final MemoryListViewModel getViewModel() {
        return (MemoryListViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), MemoryListViewModel.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r8) {
        Intrinsics.checkNotNullParameter(r8, "newConfig");
        super.onConfigurationChanged(r8);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onConfigurationChanged, newConfig: " + r8, false, 4, null);
        MemoryListAdapter r9 = this.memoryListAdapter;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
        r9 = null;
    L5:
        MemoryListAdapter r7 = this.memoryListAdapter;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
        r7 = null;
    L8:
        r9.a(0, r7.d(), new MemoryListAdapter.Companion.a("theme_changed", null));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        FragmentMemoryListBinding r6 = FragmentMemoryListBinding.inflate(r3, r4, false);
        Intrinsics.checkNotNullExpressionValue(r6, "inflate(...)");
        this.binding = r6;
        this.viewPager = (ViewPager2) ZeusTransformUtils.preCheckCast(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.view_pager_memory, OaidModel.KEY_ID, "view_pager_memory")), ViewPager2.class, "com.obric.memorydata.plugin");
        FragmentMemoryListBinding r2 = this.binding;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L5:
        ConstraintLayout r7 = r2.getRoot();
        Intrinsics.checkNotNullExpressionValue(r7, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getShareViewModel().getSelectionManager().j();
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
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        setupRecyclerView();
        observeData();
    }
}
