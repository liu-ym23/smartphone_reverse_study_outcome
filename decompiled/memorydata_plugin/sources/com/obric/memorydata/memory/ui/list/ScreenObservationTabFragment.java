package com.obric.memorydata.memory.ui.list;

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
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.memorydata.memory.databinding.MemoryCalendarTabFragmentLayoutBinding;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\"H\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J \u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0015H\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u0015H\u0002J\u0012\u00101\u001a\u00020\u00152\b\u00102\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u00103\u001a\u00020\u00152\b\u00104\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u00105\u001a\u00020\u0015H\u0002J\u0012\u00106\u001a\u0004\u0018\u00010*2\u0006\u0010\u0016\u001a\u00020\rH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/ScreenObservationTabFragment;", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarTabFragment;", "<init>", "()V", "screenObservationViewModel", "Lcom/obric/memorydata/memory/ui/list/ScreenObservationViewModel;", "getScreenObservationViewModel$memory_obricRelease", "()Lcom/obric/memorydata/memory/ui/list/ScreenObservationViewModel;", "screenObservationViewModel$delegate", "Lkotlin/Lazy;", "listFragmentAdapter", "Lcom/obric/memorydata/memory/ui/MemoryCalendarListPageAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupDayNumberText", "binding", "Lcom/obric/memorydata/memory/databinding/MemoryCalendarTabFragmentLayoutBinding;", "onResume", "getCurrentBottomTab", "", "setCurrentDate", "date", "Ljava/time/LocalDate;", "getCurrentDate", "getCurrentDateStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "refreshCalendar", "setupCalendarDateData", "memoryCalendarAdapter", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarAdapter;", "layoutManager", "Lcom/obric/oui/orecyclerview/widget/LinearLayoutManager;", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "updateTargetMemoryEntity", "isValidateTab", "", "tab", "Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "setupScreenObservationViewPager", "setupDefaultItem", "defaultItemId", "updateScreenObservationListPageOnSelectDateChange", "selectDate", "updateRecyclerViewTopPadding", "findRecyclerView", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenObservationTabFragment extends MemoryCalendarTabFragment {
    public static final a Companion = null;
    private static final String TAG = "ScreenObservationTabFragment";
    private com.obric.memorydata.memory.ui.d listFragmentAdapter;
    private final Lazy screenObservationViewModel$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/ScreenObservationTabFragment$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/list/ScreenObservationTabFragment$setupScreenObservationViewPager$4", "Lcom/obric/oui/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends ViewPager2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScreenObservationTabFragment f11129a;

        b(ScreenObservationTabFragment r1) {
            this.f11129a = r1;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
        public void b(int r5) {
            super.b(r5);
            com.obric.memorydata.memory.ui.d r0 = ScreenObservationTabFragment.access$getListFragmentAdapter$p(this.f11129a);
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("listFragmentAdapter");
            r0 = null;
        L5:
            LocalDate r1 = r0.a();
            RunLog.INSTANCE.debug(ScreenObservationTabFragment.TAG, "onPageSelected, position " + r5 + ", date " + r1);
            if (r1 != null) goto L8;
        L10:
            ScreenObservationTabFragment.access$updateRecyclerViewTopPadding(this.f11129a);
            return;
        L8:
            if (Intrinsics.areEqual(r1, this.f11129a.getScreenObservationViewModel$memory_obricRelease().getCurrentSelectDate().c()) == true) goto L10;
            this.f11129a.getScreenObservationViewModel$memory_obricRelease().setCurrentSelectDate(r1);
            com.obric.memorydata.memory.ui.g.f10964a.a();
            goto L10
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$onCreateView$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$onCreateView$1", f = "ScreenObservationTabFragment.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationTabFragment this$0;

        AnonymousClass1(ScreenObservationTabFragment r3, Continuation<? super AnonymousClass1> r4) {
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
            kotlinx.coroutines.flow.ar<Boolean> r7 = this.this$0.getShareViewModel().getSelectionManager().b();
            final ScreenObservationTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05901(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$onResume$1", f = "ScreenObservationTabFragment.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
    static final class C11821 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationTabFragment this$0;

        C11821(ScreenObservationTabFragment r3, Continuation<? super C11821> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11821(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11821) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11821.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            ScreenObservationViewModel r6 = this.this$0.getScreenObservationViewModel$memory_obricRelease();
            Continuation<? super Unit> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r6.refreshScreenMemoryValidateDay(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$refreshCalendar$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$refreshCalendar$1", f = "ScreenObservationTabFragment.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
    static final class C11831 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationTabFragment this$0;

        C11831(ScreenObservationTabFragment r3, Continuation<? super C11831> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11831(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11831) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11831.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            ScreenObservationViewModel r6 = this.this$0.getScreenObservationViewModel$memory_obricRelease();
            Continuation<? super Unit> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r6.refreshScreenMemoryDateList(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupCalendarDateData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupCalendarDateData$1", f = "ScreenObservationTabFragment.kt", i = {}, l = {138, 139}, m = "invokeSuspend", n = {}, s = {})
    static final class C11841 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ LinearLayoutManager $layoutManager;
        final /* synthetic */ m $memoryCalendarAdapter;
        final /* synthetic */ RecyclerView $recyclerView;
        int label;
        final /* synthetic */ ScreenObservationTabFragment this$0;

        C11841(ScreenObservationTabFragment r3, m r4, LinearLayoutManager r5, RecyclerView r6, Continuation<? super C11841> r7) {
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
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11841(this.this$0, this.$memoryCalendarAdapter, this.$layoutManager, this.$recyclerView, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11841) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11841.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L7;
            ResultKt.throwOnFailure(r9);
        L17:
            throw new KotlinNothingValueException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r9);
        L13:
            kotlinx.coroutines.flow.ar<List<p>> r10 = this.this$0.getScreenObservationViewModel$memory_obricRelease().getScreenMemoryDate();
            final m r3 = this.$memoryCalendarAdapter;
            final ScreenObservationTabFragment r5 = this.this$0;
            final LinearLayoutManager r6 = this.$layoutManager;
            final RecyclerView r7 = this.$recyclerView;
            kotlinx.coroutines.flow.j<? super List<p>> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05911(r3, r5, r6, r7), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            if (r10.collect(r2, r4) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r9);
            ScreenObservationViewModel r11 = this.this$0.getScreenObservationViewModel$memory_obricRelease();
            Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r11.refreshScreenMemoryDateList(r8) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupCalendarDateData$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupCalendarDateData$2", f = "ScreenObservationTabFragment.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ LinearLayoutManager $layoutManager;
        final /* synthetic */ RecyclerView $recyclerView;
        int label;
        final /* synthetic */ ScreenObservationTabFragment this$0;

        AnonymousClass2(ScreenObservationTabFragment r3, LinearLayoutManager r4, RecyclerView r5, Continuation<? super AnonymousClass2> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$layoutManager = r4;
            this.$recyclerView = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$layoutManager, this.$recyclerView, r6), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r7);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            kotlinx.coroutines.flow.ar<LocalDate> r8 = this.this$0.getScreenObservationViewModel$memory_obricRelease().getCurrentSelectDate();
            final ScreenObservationTabFragment r3 = this.this$0;
            final LinearLayoutManager r4 = this.$layoutManager;
            final RecyclerView r5 = this.$recyclerView;
            kotlinx.coroutines.flow.j<? super LocalDate> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, r4, r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r8.collect(r2, r6) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupCalendarDateData$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupCalendarDateData$3", f = "ScreenObservationTabFragment.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ m $memoryCalendarAdapter;
        int label;
        final /* synthetic */ ScreenObservationTabFragment this$0;

        AnonymousClass3(ScreenObservationTabFragment r3, m r4, Continuation<? super AnonymousClass3> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$memoryCalendarAdapter = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, this.$memoryCalendarAdapter, r5), Continuation.class, "com.obric.memorydata.plugin");
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
            kotlinx.coroutines.flow.ai<LocalDate> r7 = this.this$0.getScreenObservationViewModel$memory_obricRelease().getTotalCountsChangeEvent();
            final m r3 = this.$memoryCalendarAdapter;
            final ScreenObservationTabFragment r4 = this.this$0;
            kotlinx.coroutines.flow.j<? super LocalDate> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r5) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupDayNumberText$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupDayNumberText$1", f = "ScreenObservationTabFragment.kt", i = {}, l = {74, 75}, m = "invokeSuspend", n = {}, s = {})
    static final class C11851 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationTabFragment this$0;

        C11851(ScreenObservationTabFragment r3, Continuation<? super C11851> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11851(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11851) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11851.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L7;
            ResultKt.throwOnFailure(r6);
        L17:
            throw new KotlinNothingValueException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L13:
            kotlinx.coroutines.flow.ar<Long> r7 = this.this$0.getScreenObservationViewModel$memory_obricRelease().getScreenMemoryValidateDay();
            final ScreenObservationTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Long> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05921(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            if (r7.collect(r2, r4) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r6);
            ScreenObservationViewModel r8 = this.this$0.getScreenObservationViewModel$memory_obricRelease();
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r8.refreshScreenMemoryValidateDay(r5) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupDayNumberText$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupDayNumberText$2", f = "ScreenObservationTabFragment.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    static final class C11862 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationTabFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupDayNumberText$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Ljava/time/LocalDate;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupDayNumberText$2$1", f = "ScreenObservationTabFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<LocalDate, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ScreenObservationTabFragment this$0;

            AnonymousClass1(ScreenObservationTabFragment r3, Continuation<? super AnonymousClass1> r4) {
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
            public final Object invokeSuspend(Object r6) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r6);
                LocalDate r7 = (LocalDate) ZeusTransformUtils.preCheckCast(this.L$0, LocalDate.class, "com.obric.memorydata.plugin");
                ScreenObservationTabFragment r5 = this.this$0;
                String r0 = "";
                if (r7 == null) goto L7;
                r0 = String.valueOf(r7.getYear());
                String r8 = String.valueOf(r7.getMonthValue());
            L8:
                StringCompanionObject r1 = StringCompanionObject.INSTANCE;
                String r2 = r5.getString(ZeusTransformUtils.mapRes(R.string.screen_memory_date_title, TypedValues.Custom.S_STRING, "screen_memory_date_title"));
                Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
                String r9 = String.format(r2, Arrays.copyOf(new Object[]{r0, r8}, 2));
                Intrinsics.checkNotNullExpressionValue(r9, "format(...)");
                r5.setNormalTitleBarTitle(r9);
                return Unit.INSTANCE;
            L7:
                r8 = "";
                goto L8
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C11862(ScreenObservationTabFragment r3, Continuation<? super C11862> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11862(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11862) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11862.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.this$0.getScreenObservationViewModel$memory_obricRelease().getCurrentSelectDate(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupScreenObservationViewPager$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupScreenObservationViewPager$2", f = "ScreenObservationTabFragment.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
    static final class C11872 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationTabFragment this$0;

        C11872(ScreenObservationTabFragment r3, Continuation<? super C11872> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11872(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11872) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11872.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.ar<List<p>> r7 = this.this$0.getScreenObservationViewModel$memory_obricRelease().getScreenMemoryDate();
            final ScreenObservationTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super List<p>> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupScreenObservationViewPager$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationTabFragment$setupScreenObservationViewPager$3", f = "ScreenObservationTabFragment.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
    static final class C11883 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationTabFragment this$0;

        C11883(ScreenObservationTabFragment r3, Continuation<? super C11883> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11883(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11883) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11883.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.ar<LocalDate> r7 = this.this$0.getScreenObservationViewModel$memory_obricRelease().getCurrentSelectDate();
            final ScreenObservationTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super LocalDate> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public ScreenObservationTabFragment() {
        this.screenObservationViewModel$delegate = LazyKt.lazy(new $$Lambda$ScreenObservationTabFragment$Mw8_R_YnBP94ai7giN8jqdCVidQ(this));
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.d access$getListFragmentAdapter$p(ScreenObservationTabFragment r0) {
        return r0.listFragmentAdapter;
    }

    public static final /* synthetic */ void access$updateRecyclerViewTopPadding(ScreenObservationTabFragment r0) {
        r0.updateRecyclerViewTopPadding();
    }

    public static final /* synthetic */ void access$updateScreenObservationListPageOnSelectDateChange(ScreenObservationTabFragment r0, LocalDate r1) {
        r0.updateScreenObservationListPageOnSelectDateChange(r1);
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

    private final boolean isValidateTab(MemoryTab r1) {
        if (r1 != MemoryTab.OBSERVATION) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ Unit lambda$00gVYb8jWZfGtf233FjreNheTcA(ScreenObservationTabFragment r0) {
        return onViewCreated$lambda$1(r0);
    }

    public static /* synthetic */ Unit lambda$Fetnu9JwDr0lydbPanGlQxVJnDk(ScreenObservationTabFragment r0) {
        return updateRecyclerViewTopPadding$lambda$6(r0);
    }

    public static /* synthetic */ ScreenObservationViewModel lambda$Mw8_R_YnBP94ai7giN8jqdCVidQ(ScreenObservationTabFragment r0) {
        return screenObservationViewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ Fragment lambda$VSko2mkWjDwrFQHTkYZQGPJiW1I(LocalDate r0) {
        return setupScreenObservationViewPager$lambda$2(r0);
    }

    private static final Unit onViewCreated$lambda$1(ScreenObservationTabFragment r0) {
        r0.updateRecyclerViewTopPadding();
        return Unit.INSTANCE;
    }

    private static final ScreenObservationViewModel screenObservationViewModel_delegate$lambda$0(ScreenObservationTabFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (ScreenObservationViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(ScreenObservationViewModel.class), ScreenObservationViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void setupDefaultItem(String r4) {
        getScreenObservationViewModel$memory_obricRelease().setCurrentSelectDate(o.a(o.f11323a, (LocalDate) ZeusTransformUtils.preCheckCast(getScreenObservationViewModel$memory_obricRelease().getCurrentSelectDate().c(), LocalDate.class, "com.obric.memorydata.plugin"), null, 2, null));
    }

    private final void setupScreenObservationViewPager() {
        ViewPager2 r0 = getMemoryListContainer();
        r0.setTag(MemoryTab.OBSERVATION.getText());
        com.obric.memorydata.memory.ui.d r1 = new com.obric.memorydata.memory.ui.d((Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.memorydata.plugin"), r0, $$Lambda$ScreenObservationTabFragment$VSko2mkWjDwrFQHTkYZQGPJiW1I.INSTANCE);
        this.listFragmentAdapter = r1;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listFragmentAdapter");
        r1 = null;
    L5:
        r0.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r1, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11872(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11883(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        r0.a((ViewPager2.e) ZeusTransformUtils.preCheckCast(new b(this), ViewPager2.e.class, "com.obric.memorydata.plugin"));
    }

    private static final Fragment setupScreenObservationViewPager$lambda$2(LocalDate r2) {
        Intrinsics.checkNotNullParameter(r2, "date");
        return (Fragment) ZeusTransformUtils.preCheckCast(ScreenObservationFragment.Companion.a(r2), Fragment.class, "com.obric.memorydata.plugin");
    }

    private final void updateRecyclerViewTopPadding() {
        OBlurMaskView r0 = getBinding().titleBarContainer;
        Intrinsics.checkNotNullExpressionValue(r0, "titleBarContainer");
        safeViewPost((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"), new $$Lambda$ScreenObservationTabFragment$Fetnu9JwDr0lydbPanGlQxVJnDk(this));
    }

    private static final Unit updateRecyclerViewTopPadding$lambda$6(ScreenObservationTabFragment r9) {
        int r0 = r9.getBinding().titleBarContainer.getHeight();
        ViewPager2 r1 = r9.getBinding().memoryListContainer;
        Intrinsics.checkNotNullExpressionValue(r1, "memoryListContainer");
        View r2 = r1.getChildAt(0);
        if (ZeusTransformUtils.instanceOf(r2, RecyclerView.class) == false) goto L5;
        RecyclerView r3 = (RecyclerView) ZeusTransformUtils.preCheckCast(r2, RecyclerView.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 == null) goto L8;
        r3.setClipToPadding(false);
        r3.setClipChildren(false);
    L8:
        Iterator<Fragment> r4 = r9.getChildFragmentManager().getFragments().iterator();
    L10:
        if (r4.hasNext() == false) goto L20;
        View r5 = ((Fragment) ZeusTransformUtils.preCheckCast(r4.next(), Fragment.class, "com.obric.memorydata.plugin")).getView();
        if (r5 == null) goto L10;
        RecyclerView r6 = r9.findRecyclerView(r5);
        if (r6 == null) goto L17;
        r6.setPadding(r6.getPaddingLeft(), r0, r6.getPaddingRight(), r6.getPaddingBottom());
        r6.setClipToPadding(false);
    L17:
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L10;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin")).setClipChildren(false);
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin")).setClipToPadding(false);
        goto L10
    L20:
        return Unit.INSTANCE;
    L5:
        r3 = null;
        goto L6
    }

    private final void updateScreenObservationListPageOnSelectDateChange(LocalDate r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        com.obric.memorydata.memory.ui.d r0 = this.listFragmentAdapter;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("listFragmentAdapter");
        r0 = null;
    L7:
        r0.a(r1);
    }

    private final void updateTargetMemoryEntity() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        AppEntity r1 = (AppEntity) ZeusTransformUtils.preCheckCast(r0.getParcelable("entity"), AppEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (isValidateTab(com.obric.memorydata.memory.utils.f.f11537a.a(r1)) == true) goto L11;
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r1, ProactiveMemoryEntity.class) == false) goto L15;
        getScreenObservationViewModel$memory_obricRelease().changeMemoryDateByEntity((ProactiveMemoryEntity) ZeusTransformUtils.preCheckCast(r1, ProactiveMemoryEntity.class, "com.obric.memorydata.plugin"), getShareViewModel());
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment
    public String getCurrentBottomTab() {
        return MemoryTab.OBSERVATION.getText();
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment
    public LocalDate getCurrentDate() {
        return (LocalDate) ZeusTransformUtils.preCheckCast(getScreenObservationViewModel$memory_obricRelease().getCurrentSelectDate().c(), LocalDate.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment
    public kotlinx.coroutines.flow.ar<LocalDate> getCurrentDateStateFlow() {
        return getScreenObservationViewModel$memory_obricRelease().getCurrentSelectDate();
    }

    public final ScreenObservationViewModel getScreenObservationViewModel$memory_obricRelease() {
        return (ScreenObservationViewModel) ZeusTransformUtils.preCheckCast(this.screenObservationViewModel$delegate.getValue(), ScreenObservationViewModel.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = super.onCreateView(r8, r9, r10);
        setupScreenObservationViewPager();
        setupDefaultItem(null);
        updateTargetMemoryEntity();
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return r11;
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11821(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(getBinding().getRoot(), View.class, "com.obric.memorydata.plugin"));
        OBlurMaskView r4 = getBinding().titleBarContainer;
        Intrinsics.checkNotNullExpressionValue(r4, "titleBarContainer");
        safeViewPost((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), new $$Lambda$ScreenObservationTabFragment$00gVYb8jWZfGtf233FjreNheTcA(this));
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment
    public void refreshCalendar() {
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11831(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment
    public void setCurrentDate(LocalDate r2) {
        Intrinsics.checkNotNullParameter(r2, "date");
        getScreenObservationViewModel$memory_obricRelease().setCurrentSelectDate(r2);
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment
    public void setupCalendarDateData(m r10, LinearLayoutManager r11, RecyclerView r12) {
        Intrinsics.checkNotNullParameter(r10, "memoryCalendarAdapter");
        Intrinsics.checkNotNullParameter(r11, "layoutManager");
        Intrinsics.checkNotNullParameter(r12, "recyclerView");
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11841(this, r10, r11, r12, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r11, r12, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryCalendarTabFragment
    public void setupDayNumberText(MemoryCalendarTabFragmentLayoutBinding r9) {
        Intrinsics.checkNotNullParameter(r9, "binding");
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11851(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11862(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
