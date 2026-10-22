package com.obric.memorydata.memory.ui.list.contextawareness;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.memory.databinding.MemoryCalendarTabFragmentLayoutBinding;
import com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment;
import com.obric.memorydata.memory.ui.list.MemoryContainerTab;
import com.obric.memorydata.memory.ui.list.MemoryListShareViewModel;
import com.obric.memorydata.memory.ui.list.SelectionStateManager;
import com.obric.memorydata.memory.ui.settings.contextawareness.ContextAwarenessSettingsActivity;
import com.obric.memorydata.plugin.R;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\u0010\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0+H\u0016J\b\u0010,\u001a\u00020\u001bH\u0016J \u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016J\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0094@¢\u0006\u0002\u00107J*\u00108\u001a\b\u0012\u0004\u0012\u000206052\f\u00109\u001a\b\u0012\u0004\u0012\u0002060:2\u0006\u0010;\u001a\u00020<H\u0082@¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020\u001bH\u0002J\b\u0010?\u001a\u00020\u001bH\u0002J\b\u0010@\u001a\u00020\u001bH\u0002J\b\u0010A\u001a\u00020\u001bH\u0002J\u0010\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020\u001bH\u0002J\b\u0010F\u001a\u00020\u001bH\u0002J\u0012\u0010G\u001a\u0004\u0018\u0001032\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010H\u001a\u00020\u001bH\u0016J\b\u0010I\u001a\u00020\u001bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineFragment;", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarTabFragment;", "<init>", "()V", "viewModel", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "listFragmentAdapter", "Lcom/obric/memorydata/memory/ui/MemoryCalendarListPageAdapter;", "pageChangeCallback", "Lcom/obric/oui/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "activeTargetRequest", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequest;", "targetResolutionJob", "Lkotlinx/coroutines/Job;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "setupDayNumberText", "binding", "Lcom/obric/memorydata/memory/databinding/MemoryCalendarTabFragmentLayoutBinding;", "getCurrentBottomTab", "", "openSettingsPage", "context", "Landroid/content/Context;", "setCurrentDate", "date", "Ljava/time/LocalDate;", "getCurrentDate", "getCurrentDateStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "refreshCalendar", "setupCalendarDateData", "memoryCalendarAdapter", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarAdapter;", "layoutManager", "Lcom/obric/oui/orecyclerview/widget/LinearLayoutManager;", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "getEntityMetaInfo", "", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryMixedMetaInfo", "selectedOrExcludedItems", "", "withSpecifiedRange", "", "(Ljava/util/Collection;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupTimelineViewPager", "observeEditMode", "observeTargetRequest", "cancelTargetForUserNavigation", "completeTargetSearch", "requestId", "", "showTargetSearchFailed", "updateRecyclerViewTopPadding", "findRecyclerView", "onDestroyView", "onDestroy", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextAwarenessTimelineFragment extends MemoryCalendarTabFragment {
    private l activeTargetRequest;
    private com.obric.memorydata.memory.ui.d listFragmentAdapter;
    private ViewPager2.e pageChangeCallback;
    private bx targetResolutionJob;
    private final Lazy viewModel$delegate;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11251a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f11252b = null;

        static {
            int[] r0 = new int[ContextAwarenessSettingsNavigationTarget.values().length];
            r0[ContextAwarenessSettingsNavigationTarget.CONTEXT_AWARENESS_SETTINGS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ContextAwarenessSettingsNavigationTarget.GLOBAL_MEMORY_SETTINGS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L6:
            f11251a = r0;
            int[] r1 = new int[SelectionStateManager.SelectAllState.values().length];
            r1[SelectionStateManager.SelectAllState.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L29:
            r1[SelectionStateManager.SelectAllState.PARTIAL_SELECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L23:
            r1[SelectionStateManager.SelectAllState.PARTIAL_UNSELECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L25:
            r1[SelectionStateManager.SelectAllState.ALL_SELECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L11:
            f11252b = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineFragment$setupTimelineViewPager$4", "Lcom/obric/oui/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends ViewPager2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ContextAwarenessTimelineFragment f11253a;

        b(ContextAwarenessTimelineFragment r1) {
            this.f11253a = r1;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
        public void b(int r2) {
            com.obric.memorydata.memory.ui.d r0 = ContextAwarenessTimelineFragment.access$getListFragmentAdapter$p(this.f11253a);
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("listFragmentAdapter");
            r0 = null;
        L5:
            LocalDate r3 = r0.d(r2);
            if (r3 != null) goto L9;
            return;
        L9:
            if (Intrinsics.areEqual(r3, ContextAwarenessTimelineFragment.access$getViewModel(this.f11253a).getSelectedDate().c()) == true) goto L11;
            ContextAwarenessTimelineFragment.access$cancelTargetForUserNavigation(this.f11253a);
            ContextAwarenessTimelineFragment.access$getViewModel(this.f11253a).selectDate(r3);
            com.obric.memorydata.memory.ui.g.f10964a.a();
        L11:
            ContextAwarenessTimelineFragment.access$updateRecyclerViewTopPadding(this.f11253a);
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$observeEditMode$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$observeEditMode$1", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {269}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$observeEditMode$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isEditMode", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$observeEditMode$1$1", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C05951 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            /* synthetic */ boolean Z$0;
            int label;
            final /* synthetic */ ContextAwarenessTimelineFragment this$0;

            C05951(ContextAwarenessTimelineFragment r3, Continuation<? super C05951> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                C05951 r0 = new C05951(this.this$0, r5);
                r0.Z$0 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(Boolean r3, Continuation<? super Unit> r4) {
                return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            public final Object invoke(boolean r3, Continuation<? super Unit> r4) {
                Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return ((C05951) ZeusTransformUtils.preCheckCast(create(Boolean.valueOf(r3), r5), C05951.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L12;
                ResultKt.throwOnFailure(r5);
                if (this.Z$0 == false) goto L10;
                if (Intrinsics.areEqual(ContextAwarenessTimelineFragment.access$getShareViewModel(this.this$0).getSelectBottomTab().c(), MemoryContainerTab.CONTEXT_AWARENESS.getText()) == false) goto L10;
                ContextAwarenessTimelineFragment.access$getShareViewModel(this.this$0).getSelectionManager().a(SelectionStateManager.f11168a.a(new String[]{MemoryContainerTab.CONTEXT_AWARENESS.getText(), this.this$0.getCurrentDate().toString()}));
            L10:
                return Unit.INSTANCE;
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(ContextAwarenessTimelineFragment r3, Continuation<? super AnonymousClass1> r4) {
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineFragment.access$getShareViewModel(this.this$0).getSelectionManager().b(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C05951(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$observeEditMode$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$observeEditMode$2", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {281}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$observeEditMode$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "date", "Ljava/time/LocalDate;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$observeEditMode$2$1", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<LocalDate, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContextAwarenessTimelineFragment this$0;

            AnonymousClass1(ContextAwarenessTimelineFragment r3, Continuation<? super AnonymousClass1> r4) {
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
            public /* synthetic */ Object invoke(LocalDate r3, Continuation<? super Unit> r4) {
                return invoke2((LocalDate) ZeusTransformUtils.preCheckCast(r3, LocalDate.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(LocalDate r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L12;
                ResultKt.throwOnFailure(r5);
                LocalDate r6 = (LocalDate) ZeusTransformUtils.preCheckCast(this.L$0, LocalDate.class, "com.obric.memorydata.plugin");
                if (((Boolean) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineFragment.access$getShareViewModel(this.this$0).getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L10;
                if (Intrinsics.areEqual(ContextAwarenessTimelineFragment.access$getShareViewModel(this.this$0).getSelectBottomTab().c(), MemoryContainerTab.CONTEXT_AWARENESS.getText()) == false) goto L10;
                ContextAwarenessTimelineFragment.access$getShareViewModel(this.this$0).getSelectionManager().a(SelectionStateManager.f11168a.a(new String[]{MemoryContainerTab.CONTEXT_AWARENESS.getText(), r6.toString()}));
            L10:
                return Unit.INSTANCE;
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass2(ContextAwarenessTimelineFragment r3, Continuation<? super AnonymousClass2> r4) {
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineFragment.access$getViewModel(this.this$0).getSelectedDate(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$observeTargetRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$observeTargetRequest$1", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {297}, m = "invokeSuspend", n = {}, s = {})
    static final class C11931 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$observeTargetRequest$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", Ext.KEY_REQUEST, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequest;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$observeTargetRequest$1$1", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C05961 extends SuspendLambda implements Function2<l, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContextAwarenessTimelineFragment this$0;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$observeTargetRequest$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$observeTargetRequest$1$1$1", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {309}, m = "invokeSuspend", n = {}, s = {})
            static final class C05971 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
                final /* synthetic */ l $request;
                int label;
                final /* synthetic */ ContextAwarenessTimelineFragment this$0;

                C05971(ContextAwarenessTimelineFragment r3, l r4, Continuation<? super C05971> r5) {
                    Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                    this.this$0 = r3;
                    this.$request = r4;
                    super(2, r6);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                    Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    return (Continuation) ZeusTransformUtils.preCheckCast(new C05971(this.this$0, this.$request, r5), Continuation.class, "com.obric.memorydata.plugin");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                    return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                    return ((C05971) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05971.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r9) {
                    Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r1 = this.label;
                    boolean r3 = true;
                    if (r1 == 0) goto L9;
                    if (r1 != 1) goto L8;
                    ResultKt.throwOnFailure(r9);     // Catch: SQLiteException -> L28
                L13:
                    LocalDate r10 = (LocalDate) ZeusTransformUtils.preCheckCast(r9, LocalDate.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L28
                    l r2 = ContextAwarenessTimelineFragment.access$getActiveTargetRequest$p(this.this$0);
                    if (r2 != null) goto L17;
                L19:
                    r3 = false;
                L20:
                    if (r3 == false) goto L22;
                    if (r10 != null) goto L27;
                L24:
                    ContextAwarenessTimelineFragment.access$completeTargetSearch(this.this$0, this.$request.a());
                L26:
                    return Unit.INSTANCE;
                L27:
                    ContextAwarenessTimelineFragment.access$getViewModel(this.this$0).selectDate(r10);
                    ContextAwarenessTimelineFragment.access$getViewModel(this.this$0).publishResolvedTarget(this.$request, r10);
                    ContextAwarenessTimelineFragment.access$getViewModel(this.this$0).refreshCalendar();
                    goto L26
                L22:
                    return Unit.INSTANCE;
                L17:
                    if (r2.a() != this.$request.a()) goto L19;
                L8:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L9:
                    ResultKt.throwOnFailure(r9);
                    ContextAwarenessTimelineViewModel r11 = ContextAwarenessTimelineFragment.access$getViewModel(this.this$0);     // Catch: SQLiteException -> L28
                    v r4 = this.$request.b();     // Catch: SQLiteException -> L28
                    Continuation<? super LocalDate> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L28
                    this.label = 1;     // Catch: SQLiteException -> L28
                    r9 = r11.resolveTargetDate(r4, r5);     // Catch: SQLiteException -> L28
                    if (r9 != r0) goto L13;
                    return r0;
                L28:
                    ContextAwarenessTimelineFragment.access$showTargetSearchFailed(this.this$0);
                    goto L24
                }
            }

            C05961(ContextAwarenessTimelineFragment r3, Continuation<? super C05961> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                C05961 r0 = new C05961(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(l r3, Continuation<? super Unit> r4) {
                return ((C05961) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05961.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(l r3, Continuation<? super Unit> r4) {
                return invoke2((l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r11) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L25;
                ResultKt.throwOnFailure(r11);
                l r12 = (l) ZeusTransformUtils.preCheckCast(this.L$0, l.class, "com.obric.memorydata.plugin");
                l r0 = ContextAwarenessTimelineFragment.access$getActiveTargetRequest$p(this.this$0);
                if (r0 == null) goto L7;
                Long r1 = Boxing.boxLong(r0.a());
            L8:
                if (r12 == null) goto L10;
                Long r3 = Boxing.boxLong(r12.a());
            L12:
                if (Intrinsics.areEqual(r1, r3) == true) goto L14;
                bx r2 = ContextAwarenessTimelineFragment.access$getTargetResolutionJob$p(this.this$0);
                if (r2 == null) goto L18;
                bx.a.a(r2, null, 1, null);
            L18:
                ContextAwarenessTimelineFragment.access$setActiveTargetRequest$p(this.this$0, r12);
                if (r12 != null) goto L23;
                ContextAwarenessTimelineViewModel.clearResolvedTarget$default(ContextAwarenessTimelineFragment.access$getViewModel(this.this$0), null, 1, null);
            L22:
                return Unit.INSTANCE;
            L23:
                ContextAwarenessTimelineViewModel.clearResolvedTarget$default(ContextAwarenessTimelineFragment.access$getViewModel(this.this$0), null, 1, null);
                ContextAwarenessTimelineFragment r4 = this.this$0;
                LifecycleOwner r5 = r4.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(r5, "getViewLifecycleOwner(...)");
                ContextAwarenessTimelineFragment.access$setTargetResolutionJob$p(r4, kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r5), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C05971(this.this$0, r12, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
                goto L22
            L14:
                return Unit.INSTANCE;
            L10:
                r3 = null;
                goto L12
            L7:
                r1 = null;
                goto L8
            L25:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C11931(ContextAwarenessTimelineFragment r3, Continuation<? super C11931> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11931(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11931) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11931.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineFragment.access$getShareViewModel(this.this$0).getContextAwarenessTargetRequest$memory_obricRelease(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C05961(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupCalendarDateData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupCalendarDateData$1", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
    static final class C11941 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ LinearLayoutManager $layoutManager;
        final /* synthetic */ com.obric.memorydata.memory.ui.list.m $memoryCalendarAdapter;
        final /* synthetic */ RecyclerView $recyclerView;
        int label;
        final /* synthetic */ ContextAwarenessTimelineFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupCalendarDateData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessCalendarState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupCalendarDateData$1$1", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C05981 extends SuspendLambda implements Function2<c, Continuation<? super Unit>, Object> {
            final /* synthetic */ LinearLayoutManager $layoutManager;
            final /* synthetic */ com.obric.memorydata.memory.ui.list.m $memoryCalendarAdapter;
            final /* synthetic */ RecyclerView $recyclerView;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContextAwarenessTimelineFragment this$0;

            C05981(com.obric.memorydata.memory.ui.list.m r3, ContextAwarenessTimelineFragment r4, LinearLayoutManager r5, RecyclerView r6, Continuation<? super C05981> r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                this.$memoryCalendarAdapter = r3;
                this.this$0 = r4;
                this.$layoutManager = r5;
                this.$recyclerView = r6;
                super(2, r8);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
                C05981 r11 = new C05981(this.$memoryCalendarAdapter, this.this$0, this.$layoutManager, this.$recyclerView, r7);
                r11.L$0 = r9;
                return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(c r3, Continuation<? super Unit> r4) {
                return ((C05981) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05981.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(c r3, Continuation<? super Unit> r4) {
                return invoke2((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r4);
                c r5 = (c) ZeusTransformUtils.preCheckCast(this.L$0, c.class, "com.obric.memorydata.plugin");
                this.$memoryCalendarAdapter.a(r5.a());
                this.$memoryCalendarAdapter.b(r5.c());
                ContextAwarenessTimelineFragment r6 = this.this$0;
                ContextAwarenessTimelineFragment.access$updateCalendarAdapterOnSelectDateChange(r6, (LocalDate) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineFragment.access$getViewModel(r6).getSelectedDate().c(), LocalDate.class, "com.obric.memorydata.plugin"), this.$layoutManager, this.$recyclerView);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C11941(ContextAwarenessTimelineFragment r3, com.obric.memorydata.memory.ui.list.m r4, LinearLayoutManager r5, RecyclerView r6, Continuation<? super C11941> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$memoryCalendarAdapter = r4;
            this.$layoutManager = r5;
            this.$recyclerView = r6;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11941(this.this$0, this.$memoryCalendarAdapter, this.$layoutManager, this.$recyclerView, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11941) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11941.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            kotlinx.coroutines.flow.i r12 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineFragment.access$getViewModel(this.this$0).getCalendarState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C05981(this.$memoryCalendarAdapter, this.this$0, this.$layoutManager, this.$recyclerView, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r12, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupCalendarDateData$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupCalendarDateData$2", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
    static final class C11952 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ LinearLayoutManager $layoutManager;
        final /* synthetic */ RecyclerView $recyclerView;
        int label;
        final /* synthetic */ ContextAwarenessTimelineFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupCalendarDateData$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "date", "Ljava/time/LocalDate;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupCalendarDateData$2$1", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<LocalDate, Continuation<? super Unit>, Object> {
            final /* synthetic */ LinearLayoutManager $layoutManager;
            final /* synthetic */ RecyclerView $recyclerView;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContextAwarenessTimelineFragment this$0;

            AnonymousClass1(ContextAwarenessTimelineFragment r3, LinearLayoutManager r4, RecyclerView r5, Continuation<? super AnonymousClass1> r6) {
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                this.$layoutManager = r4;
                this.$recyclerView = r5;
                super(2, r7);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$layoutManager, this.$recyclerView, r7);
                r0.L$0 = r5;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(LocalDate r3, Continuation<? super Unit> r4) {
                return invoke2((LocalDate) ZeusTransformUtils.preCheckCast(r3, LocalDate.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(LocalDate r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                LocalDate r4 = (LocalDate) ZeusTransformUtils.preCheckCast(this.L$0, LocalDate.class, "com.obric.memorydata.plugin");
                ContextAwarenessTimelineFragment.access$updateCalendarAdapterOnSelectDateChange(this.this$0, r4, this.$layoutManager, this.$recyclerView);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C11952(ContextAwarenessTimelineFragment r3, LinearLayoutManager r4, RecyclerView r5, Continuation<? super C11952> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$layoutManager = r4;
            this.$recyclerView = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11952(this.this$0, this.$layoutManager, this.$recyclerView, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11952) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11952.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            kotlinx.coroutines.flow.i r10 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineFragment.access$getViewModel(this.this$0).getSelectedDate(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$layoutManager, this.$recyclerView, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r10, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupDayNumberText$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupDayNumberText$1", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    static final class C11961 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupDayNumberText$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessCalendarState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupDayNumberText$1$1", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C05991 extends SuspendLambda implements Function2<c, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContextAwarenessTimelineFragment this$0;

            C05991(ContextAwarenessTimelineFragment r3, Continuation<? super C05991> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                C05991 r0 = new C05991(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(c r3, Continuation<? super Unit> r4) {
                return ((C05991) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05991.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(c r3, Continuation<? super Unit> r4) {
                return invoke2((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r4);
                c r5 = (c) ZeusTransformUtils.preCheckCast(this.L$0, c.class, "com.obric.memorydata.plugin");
                ContextAwarenessTimelineFragment r3 = this.this$0;
                ContextAwarenessTimelineFragment.access$setNormalTitleBarSubtitle(r3, r3.getString(ZeusTransformUtils.mapRes(R.string.context_awareness_timeline_recorded_days, TypedValues.Custom.S_STRING, "context_awareness_timeline_recorded_days"), new Object[]{Boxing.boxInt(r5.b())}));
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C11961(ContextAwarenessTimelineFragment r3, Continuation<? super C11961> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11961(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11961) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11961.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineFragment.access$getViewModel(this.this$0).getCalendarState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C05991(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupDayNumberText$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupDayNumberText$2", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    static final class C11972 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupDayNumberText$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "date", "Ljava/time/LocalDate;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupDayNumberText$2$1", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<LocalDate, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContextAwarenessTimelineFragment this$0;

            AnonymousClass1(ContextAwarenessTimelineFragment r3, Continuation<? super AnonymousClass1> r4) {
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
            public /* synthetic */ Object invoke(LocalDate r3, Continuation<? super Unit> r4) {
                return invoke2((LocalDate) ZeusTransformUtils.preCheckCast(r3, LocalDate.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(LocalDate r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r5);
                LocalDate r6 = (LocalDate) ZeusTransformUtils.preCheckCast(this.L$0, LocalDate.class, "com.obric.memorydata.plugin");
                ContextAwarenessTimelineFragment r4 = this.this$0;
                ContextAwarenessTimelineFragment.access$setNormalTitleBarTitle(r4, r4.getString(ZeusTransformUtils.mapRes(R.string.context_awareness_timeline_month_title, TypedValues.Custom.S_STRING, "context_awareness_timeline_month_title"), new Object[]{Boxing.boxInt(r6.getYear()), Boxing.boxInt(r6.getMonthValue())}));
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C11972(ContextAwarenessTimelineFragment r3, Continuation<? super C11972> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11972(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11972) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11972.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineFragment.access$getViewModel(this.this$0).getSelectedDate(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupTimelineViewPager$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupTimelineViewPager$2", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {})
    static final class C11982 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupTimelineViewPager$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessCalendarState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupTimelineViewPager$2$1", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<c, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContextAwarenessTimelineFragment this$0;

            AnonymousClass1(ContextAwarenessTimelineFragment r3, Continuation<? super AnonymousClass1> r4) {
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
            public final Object invoke2(c r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(c r3, Continuation<? super Unit> r4) {
                return invoke2((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r7) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L22;
                ResultKt.throwOnFailure(r7);
                Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(((c) ZeusTransformUtils.preCheckCast(this.L$0, c.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin");
                Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
                Iterator r9 = r8.iterator();
            L6:
                if (r9.hasNext() == false) goto L12;
                Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(((com.obric.memorydata.memory.ui.list.p) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.memorydata.memory.ui.list.p.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin");
                Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
                Iterator r4 = r2.iterator();
            L9:
                if (r4.hasNext() == false) goto L11;
                r3.add(((com.obric.memorydata.memory.ui.list.n) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.memorydata.memory.ui.list.n.class, "com.obric.memorydata.plugin")).a());
                goto L9
            L11:
                CollectionsKt.addAll(r0, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
                goto L6
            L12:
                List<LocalDate> r10 = CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"), ContextAwarenessTimelineFragment.access$getViewModel(this.this$0).getSelectedDate().c()), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
                com.obric.memorydata.memory.ui.d r1 = ContextAwarenessTimelineFragment.access$getListFragmentAdapter$p(this.this$0);
                com.obric.memorydata.memory.ui.d r5 = null;
                if (r1 != null) goto L15;
                Intrinsics.throwUninitializedPropertyAccessException("listFragmentAdapter");
                r1 = null;
            L15:
                r1.a(r10);
                com.obric.memorydata.memory.ui.d r11 = ContextAwarenessTimelineFragment.access$getListFragmentAdapter$p(this.this$0);
                if (r11 != null) goto L18;
                Intrinsics.throwUninitializedPropertyAccessException("listFragmentAdapter");
            L19:
                r5.a((LocalDate) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineFragment.access$getViewModel(this.this$0).getSelectedDate().c(), LocalDate.class, "com.obric.memorydata.plugin"));
                return Unit.INSTANCE;
            L18:
                r5 = r11;
                goto L19
            L22:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C11982(ContextAwarenessTimelineFragment r3, Continuation<? super C11982> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11982(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11982) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11982.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineFragment.access$getViewModel(this.this$0).getCalendarState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupTimelineViewPager$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupTimelineViewPager$3", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupTimelineViewPager$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "date", "Ljava/time/LocalDate;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment$setupTimelineViewPager$3$1", f = "ContextAwarenessTimelineFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<LocalDate, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContextAwarenessTimelineFragment this$0;

            AnonymousClass1(ContextAwarenessTimelineFragment r3, Continuation<? super AnonymousClass1> r4) {
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
            public /* synthetic */ Object invoke(LocalDate r3, Continuation<? super Unit> r4) {
                return invoke2((LocalDate) ZeusTransformUtils.preCheckCast(r3, LocalDate.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(LocalDate r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r3);
                LocalDate r4 = (LocalDate) ZeusTransformUtils.preCheckCast(this.L$0, LocalDate.class, "com.obric.memorydata.plugin");
                com.obric.memorydata.memory.ui.d r2 = ContextAwarenessTimelineFragment.access$getListFragmentAdapter$p(this.this$0);
                if (r2 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("listFragmentAdapter");
                r2 = null;
            L7:
                r2.a(r4);
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass3(ContextAwarenessTimelineFragment r3, Continuation<? super AnonymousClass3> r4) {
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
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineFragment.access$getViewModel(this.this$0).getSelectedDate(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    public ContextAwarenessTimelineFragment() {
        this.viewModel$delegate = LazyKt.lazy(new $$Lambda$ContextAwarenessTimelineFragment$ck20jRKDw4T9dDs8yZSjcCk7QEs(this));
    }

    public static final /* synthetic */ void access$cancelTargetForUserNavigation(ContextAwarenessTimelineFragment r0) {
        r0.cancelTargetForUserNavigation();
    }

    public static final /* synthetic */ void access$completeTargetSearch(ContextAwarenessTimelineFragment r0, long r1) {
        r0.completeTargetSearch(r1);
    }

    public static final /* synthetic */ l access$getActiveTargetRequest$p(ContextAwarenessTimelineFragment r0) {
        return r0.activeTargetRequest;
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.d access$getListFragmentAdapter$p(ContextAwarenessTimelineFragment r0) {
        return r0.listFragmentAdapter;
    }

    public static final /* synthetic */ MemoryListShareViewModel access$getShareViewModel(ContextAwarenessTimelineFragment r0) {
        return r0.getShareViewModel();
    }

    public static final /* synthetic */ bx access$getTargetResolutionJob$p(ContextAwarenessTimelineFragment r0) {
        return r0.targetResolutionJob;
    }

    public static final /* synthetic */ ContextAwarenessTimelineViewModel access$getViewModel(ContextAwarenessTimelineFragment r0) {
        return r0.getViewModel();
    }

    public static final /* synthetic */ Object access$queryMixedMetaInfo(ContextAwarenessTimelineFragment r2, Collection r3, boolean r4, Continuation r5) {
        return r2.queryMixedMetaInfo((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$setActiveTargetRequest$p(ContextAwarenessTimelineFragment r0, l r1) {
        r0.activeTargetRequest = r1;
    }

    public static final /* synthetic */ void access$setNormalTitleBarSubtitle(ContextAwarenessTimelineFragment r0, String r1) {
        r0.setNormalTitleBarSubtitle(r1);
    }

    public static final /* synthetic */ void access$setNormalTitleBarTitle(ContextAwarenessTimelineFragment r0, String r1) {
        r0.setNormalTitleBarTitle(r1);
    }

    public static final /* synthetic */ void access$setTargetResolutionJob$p(ContextAwarenessTimelineFragment r2, bx r3) {
        r2.targetResolutionJob = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$showTargetSearchFailed(ContextAwarenessTimelineFragment r0) {
        r0.showTargetSearchFailed();
    }

    public static final /* synthetic */ void access$updateCalendarAdapterOnSelectDateChange(ContextAwarenessTimelineFragment r0, LocalDate r1, LinearLayoutManager r2, RecyclerView r3) {
        r0.updateCalendarAdapterOnSelectDateChange(r1, r2, r3);
    }

    public static final /* synthetic */ void access$updateRecyclerViewTopPadding(ContextAwarenessTimelineFragment r0) {
        r0.updateRecyclerViewTopPadding();
    }

    private final void cancelTargetForUserNavigation() {
        l r0 = this.activeTargetRequest;
        if (r0 == null) goto L6;
        completeTargetSearch(r0.a());
        return;
    }

    private final void completeTargetSearch(long r6) {
        l r0 = this.activeTargetRequest;
        boolean r2 = false;
        if (r0 != null) goto L5;
    L7:
        if (r2 == true) goto L9;
        return;
    L9:
        this.activeTargetRequest = null;
        bx r3 = this.targetResolutionJob;
        if (r3 == null) goto L12;
        bx.a.a(r3, null, 1, null);
    L12:
        this.targetResolutionJob = null;
        getViewModel().clearResolvedTarget(Long.valueOf(r6));
        getShareViewModel().completeContextAwarenessTarget$memory_obricRelease(r6);
        return;
    L5:
        if (r0.a() != r6) goto L7;
        r2 = true;
        goto L7
    }

    private final RecyclerView findRecyclerView(View r6) {
        if (ZeusTransformUtils.instanceOf(r6, RecyclerView.class) == false) goto L7;
        return (RecyclerView) ZeusTransformUtils.preCheckCast(r6, RecyclerView.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L14;
        int r0 = 0;
        int r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
    L9:
        if (r0 >= r2) goto L18;
        View r3 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(r0);
        Intrinsics.checkNotNullExpressionValue(r3, "getChildAt(...)");
        RecyclerView r4 = findRecyclerView(r3);
        if (r4 != null) goto L12;
        r0 = r0 + 1;
        goto L9
    L12:
        return r4;
    L18:
        return null;
    L14:
        return null;
    }

    private final ContextAwarenessTimelineViewModel getViewModel() {
        return (ContextAwarenessTimelineViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), ContextAwarenessTimelineViewModel.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ ContextAwarenessTimelineViewModel lambda$ck20jRKDw4T9dDs8yZSjcCk7QEs(ContextAwarenessTimelineFragment r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ Unit lambda$pJ4NKw1Xo8IPIrKlnqN83AKLgXA(ContextAwarenessTimelineFragment r0) {
        return onViewCreated$lambda$1(r0);
    }

    public static /* synthetic */ Fragment lambda$pns_r0cQaG4zmkIovFBPzZ2KVTw(LocalDate r0) {
        return setupTimelineViewPager$lambda$5(r0);
    }

    public static /* synthetic */ Unit lambda$uQyx0dOEP1W293ilK3DRcO0ehU8(ContextAwarenessTimelineFragment r0) {
        return updateRecyclerViewTopPadding$lambda$14(r0);
    }

    private final void observeEditMode() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        LifecycleOwner r1 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r1, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r1), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void observeTargetRequest() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11931(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final Unit onViewCreated$lambda$1(ContextAwarenessTimelineFragment r0) {
        r0.updateRecyclerViewTopPadding();
        return Unit.INSTANCE;
    }

    private final Object queryMixedMetaInfo(Collection<cu> r10, boolean r11, Continuation<? super List<cu>> r12) {
        Collection r13 = (Collection) ZeusTransformUtils.wrapperContextForParams(r10, Collection.class, "com.obric.memorydata.plugin");
        Continuation<? super List<cu>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L3:
        boolean r3 = true;
        if (r15.hasNext() == false) goto L11;
        Object r2 = r15.next();
        if (((cu) ZeusTransformUtils.preCheckCast(r2, cu.class, "com.obric.memorydata.plugin")).getType() == 502) goto L9;
        r3 = false;
    L9:
        if (r3 == false) goto L3;
        r0.add(r2);
        goto L3
    L11:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r16.iterator();
    L13:
        if (r17.hasNext() == false) goto L15;
        r1.add(((cu) ZeusTransformUtils.preCheckCast(r17.next(), cu.class, "com.obric.memorydata.plugin")).a());
        goto L13
    L15:
        List<String> r18 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r110 = r19.iterator();
    L17:
        if (r110.hasNext() == false) goto L24;
        Object r6 = r110.next();
        if (((cu) ZeusTransformUtils.preCheckCast(r6, cu.class, "com.obric.memorydata.plugin")).getType() != 502) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == true) goto L17;
        r4.add(r6);
        goto L17
    L21:
        r8 = false;
        goto L22
    L24:
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r112 = r111.iterator();
    L26:
        if (r112.hasNext() == false) goto L29;
        r5.add(((cu) ZeusTransformUtils.preCheckCast(r112.next(), cu.class, "com.obric.memorydata.plugin")).a());
        goto L26
    L29:
        return getViewModel().querySelectionMetaInfo(getCurrentDate(), (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), r18, r11, r7);
    }

    private final void setupTimelineViewPager() {
        ViewPager2 r0 = getMemoryListContainer();
        r0.setTag(MemoryContainerTab.CONTEXT_AWARENESS.getText());
        com.obric.memorydata.memory.ui.d r1 = new com.obric.memorydata.memory.ui.d((Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.memorydata.plugin"), r0, $$Lambda$ContextAwarenessTimelineFragment$pns_r0cQaG4zmkIovFBPzZ2KVTw.INSTANCE);
        this.listFragmentAdapter = r1;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listFragmentAdapter");
        r1 = null;
    L5:
        r0.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r1, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        LifecycleOwner r2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r2, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r2), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11982(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        LifecycleOwner r3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r3, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r3), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        b r4 = new b(this);
        r0.a((ViewPager2.e) ZeusTransformUtils.preCheckCast(r4, ViewPager2.e.class, "com.obric.memorydata.plugin"));
        this.pageChangeCallback = (ViewPager2.e) ZeusTransformUtils.preCheckCast(r4, ViewPager2.e.class, "com.obric.memorydata.plugin");
    }

    private static final Fragment setupTimelineViewPager$lambda$5(LocalDate r2) {
        Intrinsics.checkNotNullParameter(r2, "date");
        return (Fragment) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineListFragment.Companion.a(r2), Fragment.class, "com.obric.memorydata.plugin");
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

    private final void updateRecyclerViewTopPadding() {
        OBlurMaskView r0 = getBinding().titleBarContainer;
        Intrinsics.checkNotNullExpressionValue(r0, "titleBarContainer");
        safeViewPost((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"), new $$Lambda$ContextAwarenessTimelineFragment$uQyx0dOEP1W293ilK3DRcO0ehU8(this));
    }

    private static final Unit updateRecyclerViewTopPadding$lambda$14(ContextAwarenessTimelineFragment r10) {
        int r0 = r10.getBinding().titleBarContainer.getHeight();
        ViewPager2 r1 = r10.getBinding().memoryListContainer;
        Intrinsics.checkNotNullExpressionValue(r1, "memoryListContainer");
        View r2 = r1.getChildAt(0);
        if (ZeusTransformUtils.instanceOf(r2, RecyclerView.class) == false) goto L5;
        RecyclerView r3 = (RecyclerView) ZeusTransformUtils.preCheckCast(r2, RecyclerView.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 == null) goto L8;
        r3.setClipToPadding(false);
        r3.setClipChildren(false);
    L8:
        List<Fragment> r4 = r10.getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(r4, "getFragments(...)");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r5.hasNext() == false) goto L23;
        View r6 = ((Fragment) ZeusTransformUtils.preCheckCast(r5.next(), Fragment.class, "com.obric.memorydata.plugin")).getView();
        if (r6 == null) goto L10;
        RecyclerView r7 = r10.findRecyclerView(r6);
        if (r7 == null) goto L17;
        r7.setPadding(r7.getPaddingLeft(), r0, r7.getPaddingRight(), r7.getPaddingBottom());
        r7.setClipToPadding(false);
    L17:
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L19;
        ViewGroup r8 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin");
    L20:
        if (r8 == null) goto L10;
        r8.setClipChildren(false);
        r8.setClipToPadding(false);
        goto L10
    L19:
        r8 = null;
        goto L20
    L23:
        return Unit.INSTANCE;
    L5:
        r3 = null;
        goto L6
    }

    private static final ContextAwarenessTimelineViewModel viewModel_delegate$lambda$0(ContextAwarenessTimelineFragment r3) {
        return (ContextAwarenessTimelineViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r3, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(ContextAwarenessTimelineViewModel.class), ContextAwarenessTimelineViewModel.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment
    public String getCurrentBottomTab() {
        return MemoryContainerTab.CONTEXT_AWARENESS.getText();
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment
    public LocalDate getCurrentDate() {
        return (LocalDate) ZeusTransformUtils.preCheckCast(getViewModel().getSelectedDate().c(), LocalDate.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment
    public ar<LocalDate> getCurrentDateStateFlow() {
        return getViewModel().getSelectedDate();
    }

    @Override // com.obric.memorydata.memory.ui.list.AbstractMemoryTabFragment
    public Object getEntityMetaInfo(Continuation<? super List<cu>> r7) {
        Continuation<? super List<cu>> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        SelectionStateManager r0 = getShareViewModel().getSelectionManager();
        SelectionStateManager.SelectAllState r2 = (SelectionStateManager.SelectAllState) ZeusTransformUtils.preCheckCast(r0.c().c(), SelectionStateManager.SelectAllState.class, "com.obric.memorydata.plugin");
        int r3 = a.f11252b[r2.ordinal()];
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L7;
        Collection<cu> r1 = r0.d().values();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-values>(...)");
        return queryMixedMetaInfo(r1, true, r8);
    L7:
        if (r3 != 3) goto L9;
        Collection<cu> r4 = r0.e().values();
        Intrinsics.checkNotNullExpressionValue(r4, "<get-values>(...)");
        return queryMixedMetaInfo(r4, false, r8);
    L9:
        if (r3 != 4) goto L13;
        return queryMixedMetaInfo((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.emptyList(), Collection.class, "com.obric.memorydata.plugin"), false, r8);
    L13:
        throw new NoWhenBranchMatchedException();
    L19:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return super.onCreateView(r2, r3, r4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        getShareViewModel().getSelectionManager().j();
        super.onDestroy();
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        bx r0 = this.targetResolutionJob;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        this.targetResolutionJob = null;
        this.activeTargetRequest = null;
        if (this.listFragmentAdapter == null) goto L11;
        ViewPager2.e r1 = this.pageChangeCallback;
        if (r1 == null) goto L10;
        getMemoryListContainer().b(r1);
    L10:
        getMemoryListContainer().setAdapter(null);
    L11:
        this.pageChangeCallback = null;
        super.onDestroyView();
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getViewModel().refreshCalendar();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        setupTimelineViewPager();
        observeEditMode();
        observeTargetRequest();
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(getBinding().getRoot(), View.class, "com.obric.memorydata.plugin"));
        OBlurMaskView r4 = getBinding().titleBarContainer;
        Intrinsics.checkNotNullExpressionValue(r4, "titleBarContainer");
        safeViewPost((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), new $$Lambda$ContextAwarenessTimelineFragment$pJ4NKw1Xo8IPIrKlnqN83AKLgXA(this));
    }

    @Override // com.obric.memorydata.memory.ui.list.AbstractMemoryTabFragment
    public void openSettingsPage(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        ContextAwarenessSettingsNavigationTarget r0 = j.f11274a.a(com.obric.memorydata.utils.ar.c());
        int r1 = a.f11251a[r0.ordinal()];
        if (r1 != 1) goto L5;
        ContextAwarenessSettingsActivity.Companion.a(r4);
        return;
    L5:
        if (r1 != 2) goto L8;
        super.openSettingsPage(r4);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment
    public void refreshCalendar() {
        getViewModel().refreshCalendar();
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment
    public void setCurrentDate(LocalDate r2) {
        Intrinsics.checkNotNullParameter(r2, "date");
        if (Intrinsics.areEqual(r2, getViewModel().getSelectedDate().c()) == true) goto L6;
        cancelTargetForUserNavigation();
        getViewModel().selectDate(r2);
        return;
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment
    public void setupCalendarDateData(com.obric.memorydata.memory.ui.list.m r12, LinearLayoutManager r13, RecyclerView r14) {
        Intrinsics.checkNotNullParameter(r12, "memoryCalendarAdapter");
        Intrinsics.checkNotNullParameter(r13, "layoutManager");
        Intrinsics.checkNotNullParameter(r14, "recyclerView");
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11941(this, r12, r13, r14, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        LifecycleOwner r15 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r15, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r15), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11952(this, r13, r14, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment
    public void setupDayNumberText(MemoryCalendarTabFragmentLayoutBinding r9) {
        Intrinsics.checkNotNullParameter(r9, "binding");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11961(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11972(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
