package com.obric.memorydata.recommend.ui.rule;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.FragmentBlockMemoryListBinding;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.BaseFragment;
import com.obric.memorydata.utils.bb;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryFragment;", "Lcom/obric/memorydata/ui/BaseFragment;", "<init>", "()V", "binding", "Lcom/obric/memorydata/recommend/databinding/FragmentBlockMemoryListBinding;", "viewModel", "Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryContentViewModel;", "getViewModel", "()Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryContentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/obric/memorydata/recommend/ui/rule/ShieldContentAdapter;", "vp2ConflictHandler", "Lcom/obric/memorydata/recommend/ui/rule/ConflictWithViewPage2Handler;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "setupRecyclerView", "observeViewModel", "onStart", "onStop", "onDestroy", "onDestroyView", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BlockMemoryFragment extends BaseFragment {
    private static final String ARG_POSITION = "position";
    public static final a Companion = null;
    private static final String TAG = "AudioMemoryListFragment";
    private h adapter;
    private FragmentBlockMemoryListBinding binding;
    private final Lazy viewModel$delegate;
    private e vp2ConflictHandler;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_POSITION", "newInstance", "Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryFragment;", BlockMemoryFragment.ARG_POSITION, "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/obric/memorydata/recommend/ui/rule/BlockMemoryFragment$setupRecyclerView$1", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "state", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$State;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends RecyclerView.g {
        b() {
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
        public void a(Rect r2, View r3, RecyclerView r4, RecyclerView.s r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            super.a(r2, r3, r4, r5);
            if (r4.getChildAdapterPosition(r3) != (r5.e() - 1)) goto L6;
            r2.bottom = MathKt.roundToInt(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics()));
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    public BlockMemoryFragment() {
        this.viewModel$delegate = LazyKt.lazy(new $$Lambda$BlockMemoryFragment$YD4sYNWPsymwwNJzGBV7ouqZNZs(this));
    }

    private final BlockMemoryContentViewModel getViewModel() {
        return (BlockMemoryContentViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), BlockMemoryContentViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void initView() {
        setupRecyclerView();
    }

    public static /* synthetic */ BlockMemoryContentViewModel lambda$YD4sYNWPsymwwNJzGBV7ouqZNZs(BlockMemoryFragment r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ Unit lambda$fUYOvQvvPhGCT244g2Z_iRKzxcw(BlockMemoryFragment r0, Integer r1) {
        return observeViewModel$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit lambda$gUAvSEmA5iTBJXOESuN0QvMbSbs(BlockMemoryFragment r0, List r1) {
        return observeViewModel$lambda$1(r0, r1);
    }

    private final void observeViewModel() {
        getViewModel().getShieldContentItems().observe(getViewLifecycleOwner(), (Observer) ZeusTransformUtils.preCheckCast(new BlockMemoryFragment$sam$androidx_lifecycle_Observer$0(new $$Lambda$BlockMemoryFragment$gUAvSEmA5iTBJXOESuN0QvMbSbs(this)), Observer.class, "com.obric.memorydata.plugin"));
        getViewModel().getTitleBarHeight().observe(getViewLifecycleOwner(), (Observer) ZeusTransformUtils.preCheckCast(new BlockMemoryFragment$sam$androidx_lifecycle_Observer$0(new $$Lambda$BlockMemoryFragment$fUYOvQvvPhGCT244g2Z_iRKzxcw(this)), Observer.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit observeViewModel$lambda$1(BlockMemoryFragment r2, List r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        h r5 = r2.adapter;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r5 = null;
    L5:
        Intrinsics.checkNotNull(r4);
        r5.b(com.obric.memorydata.recommend.ui.rule.b.a(r4));
        return Unit.INSTANCE;
    }

    private static final Unit observeViewModel$lambda$2(BlockMemoryFragment r6, Integer r7) {
        if (r7.intValue() <= 0) goto L13;
        FragmentBlockMemoryListBinding r8 = r6.binding;
        FragmentBlockMemoryListBinding r0 = null;
        if (r8 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L7:
        RecyclerView r9 = r8.rvBlockContent;
        Intrinsics.checkNotNullExpressionValue(r9, "rvBlockContent");
        bb.b((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), BaseActivity.Companion.a() + MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())));
        FragmentBlockMemoryListBinding r10 = r6.binding;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L11:
        r0.rvBlockContent.scrollToPosition(0);
        goto L13
    L10:
        r0 = r10;
    L13:
        return Unit.INSTANCE;
    }

    private final void setupRecyclerView() {
        FragmentBlockMemoryListBinding r0 = this.binding;
        FragmentBlockMemoryListBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        RecyclerView r1 = r0.rvBlockContent;
        Intrinsics.checkNotNullExpressionValue(r1, "rvBlockContent");
        com.obric.memorydata.ui.g.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        BlockMemoryContentViewModel r4 = getViewModel();
        FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "requireActivity(...)");
        this.adapter = new h(r4, r6);
        FragmentBlockMemoryListBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        r3.rvBlockContent.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        FragmentBlockMemoryListBinding r5 = this.binding;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L11:
        r5.rvBlockContent.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(new b(), RecyclerView.g.class, "com.obric.memorydata.plugin"));
        FragmentBlockMemoryListBinding r7 = this.binding;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L14:
        RecyclerView r8 = r7.rvBlockContent;
        h r9 = this.adapter;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r9 = null;
    L17:
        r8.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r9, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        ViewPager2 r10 = (ViewPager2) ZeusTransformUtils.preCheckCast(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.viewPager, OaidModel.KEY_ID, "viewPager")), ViewPager2.class, "com.obric.memorydata.plugin");
        FragmentBlockMemoryListBinding r11 = this.binding;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        RecyclerView r12 = r2.rvBlockContent;
        Intrinsics.checkNotNullExpressionValue(r12, "rvBlockContent");
        this.vp2ConflictHandler = new e(r12, r10);
        return;
    L20:
        r2 = r11;
        goto L21
    }

    private static final BlockMemoryContentViewModel viewModel_delegate$lambda$0(BlockMemoryFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (BlockMemoryContentViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(BlockMemoryContentViewModel.class), BlockMemoryContentViewModel.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        FragmentBlockMemoryListBinding r4 = FragmentBlockMemoryListBinding.inflate(r1, r2, false);
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        this.binding = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L5:
        ConstraintLayout r0 = r4.getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        e r0 = this.vp2ConflictHandler;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.vp2ConflictHandler = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getViewModel().initializeDefaultCustomContent();
        getViewModel().startObservingDataChanges();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getViewModel().stopObservingDataChanges();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        initView();
        observeViewModel();
        getViewModel().loadShieldContent();
    }
}
