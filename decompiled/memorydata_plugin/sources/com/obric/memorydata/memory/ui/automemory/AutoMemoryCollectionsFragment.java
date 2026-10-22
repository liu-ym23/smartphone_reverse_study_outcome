package com.obric.memorydata.memory.ui.automemory;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListActivity;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsActivity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.BaseFragment;
import com.obric.oui.orecyclerview.widget.GridLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u000e\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010'\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020%H\u0016J\u0006\u0010)\u001a\u00020%J\b\u0010*\u001a\u00020%H\u0016J\u0006\u0010+\u001a\u00020%J\u0012\u0010,\u001a\u00020-2\b\u0010&\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020%H\u0002R\u0012\u0010\u0004\u001a\u00020\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionsFragment;", "Lcom/obric/memorydata/ui/BaseFragment;", "<init>", "()V", "tab", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTab;", "getTab", "()Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTab;", "viewModel", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "container", "Landroid/widget/FrameLayout;", "contentLayout", "Landroid/widget/LinearLayout;", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "emptyView", "Lcom/obric/oui/text/OTextView;", "adapter", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionAdapter;", "recyclerViewInterceptor", "Lcom/obric/memorydata/memory/ui/ConflictWithViewPage2Handler;", "currentOPopover", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/popover/v2/OPopover;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onPause", "dismissOperationMenu", "onDestroyView", "updateContentTopPadding", "viewDiag", "", "startPresetRuleSettings", "card", "Lcom/obric/memorydata/database/entity/MemoryRuleEntity;", "showAddLimitToast", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AutoMemoryCollectionsFragment extends BaseFragment {
    private static final a Companion = null;
    private static final String TAG = "AutoMemoryCollectionsFragment";
    private com.obric.memorydata.memory.ui.automemory.a adapter;
    private FrameLayout container;
    private LinearLayout contentLayout;
    private WeakReference<com.obric.oui.popover.v2.a> currentOPopover;
    private OTextView emptyView;
    private RecyclerView recyclerView;
    private com.obric.memorydata.memory.ui.a recyclerViewInterceptor;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionsFragment$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionsFragment$onCreateView$7", "Lcom/obric/oui/orecyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends GridLayoutManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AutoMemoryCollectionsFragment f10592a;

        b(AutoMemoryCollectionsFragment r1) {
            this.f10592a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.GridLayoutManager.b
        public int a(int r1) {
            com.obric.memorydata.memory.ui.automemory.a r0 = AutoMemoryCollectionsFragment.access$getAdapter$p(this.f10592a);
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            r0 = null;
        L6:
            if (r0.a(r1) != 1) goto L9;
            return 2;
        L9:
            return 1;
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"com/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionsFragment$onCreateView$8", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ItemDecoration;", "spacing", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "state", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$State;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends RecyclerView.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10593a;

        c() {
            this.f10593a = MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
        public void a(Rect r2, View r3, RecyclerView r4, RecyclerView.s r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            ViewGroup.LayoutParams r6 = r3.getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r6, GridLayoutManager.LayoutParams.class) == false) goto L5;
            GridLayoutManager.LayoutParams r7 = (GridLayoutManager.LayoutParams) ZeusTransformUtils.preCheckCast(r6, GridLayoutManager.LayoutParams.class, "com.obric.memorydata.plugin");
        L6:
            if (r7 != null) goto L8;
            return;
        L8:
            int r0 = 0;
            if (r7.b() != 2) goto L12;
            r2.set(0, 0, 0, 0);
            return;
        L12:
            int r8 = this.f10593a / 2;
            if (r7.a() != 0) goto L15;
            int r9 = 0;
        L16:
            r2.left = r9;
            if (r7.a() != 0) goto L19;
            r0 = r8;
        L19:
            r2.right = r0;
            r2.bottom = this.f10593a;
            return;
        L15:
            r9 = r8;
            goto L16
        L5:
            r7 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryCollectionsFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryCollectionsFragment$onViewCreated$1", f = "AutoMemoryCollectionsFragment.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AutoMemoryCollectionsFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryCollectionsFragment$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryCollectionsFragment$onViewCreated$1$1", f = "AutoMemoryCollectionsFragment.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
        static final class C05251 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AutoMemoryCollectionsFragment this$0;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryCollectionsFragment$onViewCreated$1$1$a */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f10596a = null;

                static {
                    int[] r0 = new int[AutoMemoryTab.values().length];
                    r0[AutoMemoryTab.AUTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
                L9:
                    r0[AutoMemoryTab.DISCOVER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
                L5:
                    f10596a = r0;
                }
            }

            C05251(AutoMemoryCollectionsFragment r3, Continuation<? super C05251> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            private static final boolean invokeSuspend$lambda$0(AutoMemoryCollectionsFragment r1, u r2, u r3) {
                AutoMemoryTab r4 = r1.getTab();
                int r5 = a.f10596a[r4.ordinal()];
                if (r5 != 1) goto L5;
                List<d> r6 = r2.c();
                List<d> r7 = r3.c();
            L11:
                return Intrinsics.areEqual(r6, r7);
            L5:
                if (r5 != 2) goto L8;
                r6 = r2.d();
                r7 = r3.d();
                goto L11
            L8:
                throw new NoWhenBranchMatchedException();
            }

            /* JADX INFO: renamed from: lambda$rduKlPzeyRcUzRcHj-4WM1m3ngQ, reason: not valid java name */
            public static /* synthetic */ boolean m779lambda$rduKlPzeyRcUzRcHj4WM1m3ngQ(AutoMemoryCollectionsFragment r0, u r1, u r2) {
                return invokeSuspend$lambda$0(r0, r1, r2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C05251(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((C05251) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05251.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
                kotlinx.coroutines.flow.i r7 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(AutoMemoryCollectionsFragment.access$getViewModel(this.this$0).getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
                final AutoMemoryCollectionsFragment r2 = this.this$0;
                kotlinx.coroutines.flow.i r8 = kotlinx.coroutines.flow.k.a(r7, new $$Lambda$AutoMemoryCollectionsFragment$onViewCreated$1$1$rduKlPzeyRcUzRcHj4WM1m3ngQ(r2));
                final AutoMemoryCollectionsFragment r4 = this.this$0;
                kotlinx.coroutines.flow.j r3 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05261(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                if (r8.collect(r3, r5) != r0) goto L12;
                return r0;
            }
        }

        AnonymousClass1(AutoMemoryCollectionsFragment r3, Continuation<? super AnonymousClass1> r4) {
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
            LifecycleOwner r8 = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(r8, "getViewLifecycleOwner(...)");
            Lifecycle.State r2 = Lifecycle.State.STARTED;
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new C05251(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public AutoMemoryCollectionsFragment() {
        this.viewModel$delegate = LazyKt.lazy(new $$Lambda$AutoMemoryCollectionsFragment$BwdvCTtMIORhnbNi2ngZk7lGaAY(this));
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.automemory.a access$getAdapter$p(AutoMemoryCollectionsFragment r0) {
        return r0.adapter;
    }

    public static final /* synthetic */ OTextView access$getEmptyView$p(AutoMemoryCollectionsFragment r0) {
        return r0.emptyView;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(AutoMemoryCollectionsFragment r0) {
        return r0.recyclerView;
    }

    public static final /* synthetic */ AutoMemoryViewModel access$getViewModel(AutoMemoryCollectionsFragment r0) {
        return r0.getViewModel();
    }

    public static final /* synthetic */ void access$showAddLimitToast(AutoMemoryCollectionsFragment r0) {
        r0.showAddLimitToast();
    }

    public static final /* synthetic */ void access$startPresetRuleSettings(AutoMemoryCollectionsFragment r0, MemoryRuleEntity r1) {
        r0.startPresetRuleSettings(r1);
    }

    private final AutoMemoryViewModel getViewModel() {
        return (AutoMemoryViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), AutoMemoryViewModel.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ AutoMemoryViewModel lambda$BwdvCTtMIORhnbNi2ngZk7lGaAY(AutoMemoryCollectionsFragment r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ Unit lambda$E3tp74QYcCwdm6eEsVvQdxLuseM(AutoMemoryCollectionsFragment r0, MemoryRuleEntity r1) {
        return onCreateView$lambda$11$lambda$10(r0, r1);
    }

    public static /* synthetic */ Unit lambda$Lu2ValKN9n9WT1K3cRhXPgOGMWM(MemoryRuleEntity r0, AutoMemoryCollectionsFragment r1) {
        return onCreateView$lambda$11$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit lambda$ZE3YzfNLG_taAq2o91iKVKcMMtU(AutoMemoryCollectionsFragment r0, MemoryRuleEntity r1) {
        return onCreateView$lambda$11$lambda$10$lambda$9(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$e-jJuDTy_1lajIRm4TvpT4SURvQ, reason: not valid java name */
    public static /* synthetic */ Unit m778lambda$ejJuDTy_1lajIRm4TvpT4SURvQ(AutoMemoryCollectionsFragment r0, MemoryRuleEntity r1) {
        return onCreateView$lambda$11$lambda$8(r0, r1);
    }

    public static /* synthetic */ Unit lambda$iu0A1iaO4Y4qBQDWdvY4VFbfnH0(AutoMemoryCollectionsFragment r0, d r1) {
        return onCreateView$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit lambda$oN1USmVr3CfrIqhUxe1uc8JXRzI(AutoMemoryCollectionsFragment r0, d r1, View r2) {
        return onCreateView$lambda$11(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$r166_g21Mz3O9V0BvfdsvmQIDo0(AutoMemoryCollectionsFragment r0, d r1) {
        return onCreateView$lambda$5(r0, r1);
    }

    private static final Unit onCreateView$lambda$11(final AutoMemoryCollectionsFragment r12, d r13, View r14) {
        Intrinsics.checkNotNullParameter(r13, "item");
        Intrinsics.checkNotNullParameter(r14, "anchor");
        if (r12.getTab() != AutoMemoryTab.AUTO) goto L5;
        WeakReference<com.obric.oui.popover.v2.a> r0 = r12.currentOPopover;
        if (r0 == null) goto L11;
        com.obric.oui.popover.v2.a r1 = (com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(r0.get(), com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        r1.dismiss();
    L11:
        final MemoryRuleEntity r15 = r13.a();
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "requireActivity(...)");
        r12.currentOPopover = new WeakReference(e.a((Activity) ZeusTransformUtils.preCheckCast(r2, Activity.class, "com.obric.memorydata.plugin"), r14, r15.isPaused(), null, false, new $$Lambda$AutoMemoryCollectionsFragment$Lu2ValKN9n9WT1K3cRhXPgOGMWM(r15, r12), new $$Lambda$AutoMemoryCollectionsFragment$ejJuDTy_1lajIRm4TvpT4SURvQ(r12, r15), new $$Lambda$AutoMemoryCollectionsFragment$E3tp74QYcCwdm6eEsVvQdxLuseM(r12, r15), null, 280, null));
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private static final Unit onCreateView$lambda$11$lambda$10(final AutoMemoryCollectionsFragment r7, final MemoryRuleEntity r8) {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "requireActivity(...)");
        e.a((Activity) ZeusTransformUtils.preCheckCast(r0, Activity.class, "com.obric.memorydata.plugin"), null, null, new $$Lambda$AutoMemoryCollectionsFragment$ZE3YzfNLG_taAq2o91iKVKcMMtU(r7, r8), 6, null);
        return Unit.INSTANCE;
    }

    private static final Unit onCreateView$lambda$11$lambda$10$lambda$9(AutoMemoryCollectionsFragment r2, MemoryRuleEntity r3) {
        r2.getViewModel().deleteMyCollection(r3.getId());
        return Unit.INSTANCE;
    }

    private static final Unit onCreateView$lambda$11$lambda$7(MemoryRuleEntity r8, AutoMemoryCollectionsFragment r9) {
        boolean r0 = !r8.isPaused();
        r9.getViewModel().updateMyCollectionPausedState(r8.getId(), r0);
        FragmentActivity r10 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L10;
        com.obric.oui.toast.a.C0786a r2 = com.obric.oui.toast.a.f14807a;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.memorydata.plugin");
        if (r0 == false) goto L7;
        int r1 = R.string.memory_auto_memory_stopped_toast;
        String r4 = "memory_auto_memory_stopped_toast";
    L8:
        String r5 = r9.getString(ZeusTransformUtils.mapRes(r1, TypedValues.Custom.S_STRING, r4));
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r2, r3, r5, 0, 4, null);
        goto L10
    L7:
        r1 = R.string.memory_auto_memory_started_toast;
        r4 = "memory_auto_memory_started_toast";
    L10:
        return Unit.INSTANCE;
    }

    private static final Unit onCreateView$lambda$11$lambda$8(AutoMemoryCollectionsFragment r3, MemoryRuleEntity r4) {
        MemoryTaskSettingsActivity.a r0 = MemoryTaskSettingsActivity.Companion;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "requireContext(...)");
        r0.a(r5, r4.getId());
        return Unit.INSTANCE;
    }

    private static final Unit onCreateView$lambda$4(AutoMemoryCollectionsFragment r3, d r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        MemoryRuleEntity r5 = r4.a();
        AutoMemoryCollectionListActivity.a r0 = AutoMemoryCollectionListActivity.Companion;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "requireContext(...)");
        r0.a(r6, r5.getId(), r5.getTitle());
        return Unit.INSTANCE;
    }

    private static final Unit onCreateView$lambda$5(AutoMemoryCollectionsFragment r9, d r10) {
        Intrinsics.checkNotNullParameter(r10, "item");
        MemoryRuleEntity r11 = r10.a();
        LifecycleOwner r0 = r9.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionsFragment$onCreateView$5$1(r9, r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return Unit.INSTANCE;
    }

    private final void showAddLimitToast() {
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
        int r0 = R.string.memory_create_add_up_limit_for_debug;
        String r2 = "memory_create_add_up_limit_for_debug";
    L6:
        int r1 = ZeusTransformUtils.mapRes(r0, TypedValues.Custom.S_STRING, r2);
        FragmentActivity r8 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L10;
        com.obric.oui.toast.a.C0786a r3 = com.obric.oui.toast.a.f14807a;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(r8, Context.class, "com.obric.memorydata.plugin");
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r1);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r3, r4, r5, 0, 4, null);
        return;
    L10:
        return;
    L5:
        r0 = R.string.memory_create_add_up_limit;
        r2 = "memory_create_add_up_limit";
        goto L6
    }

    private final void startPresetRuleSettings(MemoryRuleEntity r25) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L5:
        String r3 = r25.getTitle();
        String r5 = r25.getContent();
        int r17 = r25.getActiveStartMinute();
        int r18 = r25.getActiveEndMinute();
        com.obric.memorydata.memory.ui.automemory.settings.e r19 = com.obric.memorydata.memory.ui.automemory.settings.e.f10753a.a(r25.getMemoryInfoJson());
        Context r24 = r0;
        com.obric.memorydata.memory.ui.automemory.settings.b r10 = new com.obric.memorydata.memory.ui.automemory.settings.b(null, r3, null, r5, null, "", false, null, "", null, false, false, r25.getIconKey(), r25.getIconColorKey(), null, r17, r18, r19, true, 20116, null);
        String r1 = com.obric.memorydata.memory.ui.automemory.settings.g.f10759a.a(r10);
        MemoryTaskSettingsActivity.Companion.a(r24, r1);
    }

    private final String viewDiag(View r8) {
        if (r8 != null) goto L5;
        return "null";
    L5:
        int[] r0 = new int[2];
        int[] r7 = new int[2];
        r8.getLocationInWindow(r0);
        r8.getLocationOnScreen(r7);
        ViewGroup.LayoutParams r1 = r8.getLayoutParams();
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class) == false) goto L8;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L10:
        if (r2 == null) goto L12;
        r3 = " margin=" + r2.leftMargin + ',' + r2.topMargin + ',' + r2.rightMargin + ',' + r2.bottomMargin;
    L12:
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        StringBuilder r4 = new StringBuilder();
        r4.append(r8.getClass().getSimpleName()).append("@win=").append(r0[0]).append(',').append(r0[1]).append(" screen=").append(r7[0]).append(',').append(r7[1]).append(" size=").append(r8.getWidth()).append('x').append(r8.getHeight()).append(" top=").append(r8.getTop()).append(" bottom=").append(r8.getBottom()).append(" padding=").append(r8.getPaddingLeft()).append(',').append(r8.getPaddingTop()).append(',').append(r8.getPaddingRight());
        r4.append(',').append(r8.getPaddingBottom()).append(r3).append(" visible=").append(r8.getVisibility()).append(" alpha=").append(r8.getAlpha());
        return r4.toString();
    L8:
        r2 = null;
        goto L10
    }

    private static final AutoMemoryViewModel viewModel_delegate$lambda$0(AutoMemoryCollectionsFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (AutoMemoryViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(AutoMemoryViewModel.class), AutoMemoryViewModel.class, "com.obric.memorydata.plugin");
    }

    public final void dismissOperationMenu() {
        WeakReference<com.obric.oui.popover.v2.a> r0 = this.currentOPopover;
        if (r0 == null) goto L7;
        com.obric.oui.popover.v2.a r1 = (com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(r0.get(), com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        r1.dismiss();
    L7:
        this.currentOPopover = null;
    }

    public abstract AutoMemoryTab getTab();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        FrameLayout r15 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r15.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.container = r15;
        LinearLayout r16 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r16.setOrientation(1);
        r16.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        float r1 = 12;
        r16.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r1, Resources.getSystem().getDisplayMetrics())), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r1, Resources.getSystem().getDisplayMetrics())), 0);
        this.contentLayout = r16;
        RecyclerView r17 = new RecyclerView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r17.setId(View.generateViewId());
        r17.setBackgroundColor(0);
        r17.setClipToPadding(false);
        r17.setPadding(0, f.a((Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.memorydata.plugin")), 0, MathKt.roundToInt(TypedValue.applyDimension(1, 96, Resources.getSystem().getDisplayMetrics())));
        FrameLayout r18 = null;
        r17.setItemAnimator(null);
        Fragment r2 = getParentFragment();
        if (ZeusTransformUtils.instanceOf(r2, AutoMemoryTaskFragment.class) == false) goto L5;
        AutoMemoryTaskFragment r3 = (AutoMemoryTaskFragment) ZeusTransformUtils.preCheckCast(r2, AutoMemoryTaskFragment.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 == null) goto L8;
        ViewPager2 r4 = r3.getCollectionViewPager();
    L9:
        this.recyclerViewInterceptor = new com.obric.memorydata.memory.ui.a(r17, r4, false, false);
        this.recyclerView = r17;
        GridLayoutManager r19 = new GridLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 2);
        this.adapter = new com.obric.memorydata.memory.ui.automemory.a(getTab(), new $$Lambda$AutoMemoryCollectionsFragment$iu0A1iaO4Y4qBQDWdvY4VFbfnH0(this), new $$Lambda$AutoMemoryCollectionsFragment$r166_g21Mz3O9V0BvfdsvmQIDo0(this), new $$Lambda$AutoMemoryCollectionsFragment$oN1USmVr3CfrIqhUxe1uc8JXRzI(this));
        r19.a((GridLayoutManager.b) ZeusTransformUtils.preCheckCast(new b(this), GridLayoutManager.b.class, "com.obric.memorydata.plugin"));
        RecyclerView r5 = this.recyclerView;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r5 = null;
    L12:
        r5.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(r19, RecyclerView.h.class, "com.obric.memorydata.plugin"));
        RecyclerView r110 = this.recyclerView;
        if (r110 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r110 = null;
    L15:
        com.obric.memorydata.memory.ui.automemory.a r6 = this.adapter;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r6 = null;
    L18:
        r110.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r6, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        RecyclerView r111 = this.recyclerView;
        if (r111 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r111 = null;
    L21:
        r111.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(new c(), RecyclerView.g.class, "com.obric.memorydata.plugin"));
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "requireContext(...)");
        OTextView r112 = new OTextView(r7, null, 0, null, 14, null);
        if (getTab() != AutoMemoryTab.AUTO) goto L24;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        int r9 = R.string.memory_not_has_auto_memory;
        String r10 = "memory_not_has_auto_memory";
    L25:
        r112.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8.getString(ZeusTransformUtils.mapRes(r9, TypedValues.Custom.S_STRING, r10)), CharSequence.class, "com.obric.memorydata.plugin"));
        r112.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
        r112.setTextSize(16.0f);
        r112.setGravity(17);
        r112.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r112.setVisibility(8);
        this.emptyView = r112;
        LinearLayout r113 = this.contentLayout;
        if (r113 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        r113 = null;
    L28:
        RecyclerView r11 = this.recyclerView;
        if (r11 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r11 = null;
    L31:
        r113.addView((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, 0, 1.0f), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        FrameLayout r114 = this.container;
        if (r114 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("container");
        r114 = null;
    L34:
        LinearLayout r20 = this.contentLayout;
        if (r20 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        r20 = null;
    L37:
        r114.addView((View) ZeusTransformUtils.preCheckCast(r20, View.class, "com.obric.memorydata.plugin"));
        FrameLayout r115 = this.container;
        if (r115 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("container");
        r115 = null;
    L40:
        OTextView r21 = this.emptyView;
        if (r21 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("emptyView");
        r21 = null;
    L43:
        r115.addView((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.memorydata.plugin"));
        FrameLayout r116 = this.container;
        if (r116 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L48:
        return (View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.memorydata.plugin");
    L46:
        r18 = r116;
        goto L48
    L24:
        r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        r9 = R.string.memory_not_has_content;
        r10 = "memory_not_has_content";
        goto L25
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        com.obric.memorydata.memory.ui.a r0 = this.recyclerViewInterceptor;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.recyclerViewInterceptor = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismissOperationMenu();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateContentTopPadding();
        getViewModel().refreshMyCollections();
        dismissOperationMenu();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        LifecycleOwner r10 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r10, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r10), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void updateContentTopPadding() {
        if (this.recyclerView != null) goto L5;
        return;
    L5:
        int r0 = f.a((Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.memorydata.plugin"));
        RecyclerView r4 = null;
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L17;
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("[AutoTaskDiag] collectionPadding tab=").append(getTab()).append(" targetTop=").append(r0).append(" rv=");
        RecyclerView r6 = this.recyclerView;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r6 = null;
    L10:
        StringBuilder r3 = r2.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"))).append(" content=");
        LinearLayout r7 = this.contentLayout;
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        r7 = null;
    L13:
        StringBuilder r8 = r3.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"))).append(" container=");
        FrameLayout r9 = this.container;
        if (r9 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("container");
        r9 = null;
    L16:
        IRunLog.a.a(r5, TAG, r8.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"))).toString(), false, 4, null);
    L17:
        RecyclerView r1 = this.recyclerView;
        if (r1 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r1 = null;
    L21:
        if (r1.getPaddingTop() == r0) goto L37;
        RecyclerView r10 = this.recyclerView;
        if (r10 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r10 = null;
    L25:
        RecyclerView r11 = this.recyclerView;
        if (r11 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r11 = null;
    L28:
        int r12 = r11.getPaddingLeft();
        RecyclerView r13 = this.recyclerView;
        if (r13 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r13 = null;
    L31:
        int r14 = r13.getPaddingRight();
        RecyclerView r15 = this.recyclerView;
        if (r15 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L35:
        r10.setPadding(r12, r0, r14, r4.getPaddingBottom());
        return;
    L34:
        r4 = r15;
        goto L35
    }
}
