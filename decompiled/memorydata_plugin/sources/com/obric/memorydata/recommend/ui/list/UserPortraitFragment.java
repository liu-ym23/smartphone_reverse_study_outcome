package com.obric.memorydata.recommend.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.FragmentRecommendPortraitListBinding;
import com.obric.memorydata.ui.BaseFragment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/UserPortraitFragment;", "Lcom/obric/memorydata/ui/BaseFragment;", "<init>", "()V", "adapter", "Lcom/obric/memorydata/recommend/ui/list/CachedFragmentAdapter;", "binding", "Lcom/obric/memorydata/recommend/databinding/FragmentRecommendPortraitListBinding;", UserPortraitFragment.ARG_POSITION, "", "getPosition", "()I", "position$delegate", "Lkotlin/Lazy;", "currentPosition", "initialized", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupRecyclerView", "showFragment", "onSaveInstanceState", "outState", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserPortraitFragment extends BaseFragment {
    private static final String ARG_POSITION = "position";
    public static final a Companion = null;
    private static final String KEY_CURRENT_POSITION = "current_fragment_position";
    private static final String TAG = "UserPortraitFragment";
    private CachedFragmentAdapter adapter;
    private FragmentRecommendPortraitListBinding binding;
    private int currentPosition;
    private boolean initialized;
    private final Lazy position$delegate;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/UserPortraitFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_POSITION", "KEY_CURRENT_POSITION", "newInstance", "Lcom/obric/memorydata/recommend/ui/list/UserPortraitFragment;", UserPortraitFragment.ARG_POSITION, "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final UserPortraitFragment a(int r4) {
            UserPortraitFragment r3 = new UserPortraitFragment();
            RunLog.INSTANCE.debug(UserPortraitFragment.TAG, "newInstance ...");
            Bundle r0 = new Bundle();
            r0.putInt(UserPortraitFragment.ARG_POSITION, r4);
            r3.setArguments(r0);
            return r3;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/recommend/ui/list/UserPortraitFragment$setupRecyclerView$1", "Lcom/obric/memorydata/recommend/ui/list/FlowTabLayout$OnTabSelectedListener;", "onTabSelected", "", UserPortraitFragment.ARG_POSITION, "", "view", "Landroid/view/View;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements FlowTabLayout.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UserPortraitFragment f12692a;

        b(UserPortraitFragment r1) {
            this.f12692a = r1;
        }

        @Override // com.obric.memorydata.recommend.ui.list.FlowTabLayout.b
        public void a(int r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            UserPortraitFragment.access$showFragment(this.f12692a, r2);
        }
    }

    static {
        Companion = new a(null);
    }

    public UserPortraitFragment() {
        this.position$delegate = LazyKt.lazy(new $$Lambda$UserPortraitFragment$8W7Kr950ueCB_I_0KGIQQw8mM(this));
    }

    public static final /* synthetic */ void access$showFragment(UserPortraitFragment r0, int r1) {
        r0.showFragment(r1);
    }

    private final int getPosition() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.position$delegate.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    /* JADX INFO: renamed from: lambda$-8W7Kr950ueCB_I_0KG-IQQw8mM, reason: not valid java name */
    public static /* synthetic */ int m1148lambda$8W7Kr950ueCB_I_0KGIQQw8mM(UserPortraitFragment r0) {
        return position_delegate$lambda$0(r0);
    }

    private static final int position_delegate$lambda$0(UserPortraitFragment r1) {
        Bundle r2 = r1.getArguments();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.getInt(ARG_POSITION);
    }

    private final void setupRecyclerView() {
        FragmentRecommendPortraitListBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.recommendPortraitTags.setOnTabSelectedListener((FlowTabLayout.b) ZeusTransformUtils.preCheckCast(new b(this), FlowTabLayout.b.class, "com.obric.memorydata.plugin"));
    }

    private final void showFragment(int r6) {
        if (this.initialized == true) goto L5;
    L7:
        this.currentPosition = r6;
        CachedFragmentAdapter r0 = this.adapter;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L10:
        getChildFragmentManager().beginTransaction().replace(ZeusTransformUtils.mapRes(R.id.portrait_fragment_container, OaidModel.KEY_ID, "portrait_fragment_container"), r0.createFragment(r6)).addToBackStack(null).commit();
        this.initialized = true;
        return;
    L5:
        if (r6 != this.currentPosition) goto L7;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        FragmentRecommendPortraitListBinding r12 = FragmentRecommendPortraitListBinding.inflate(r9, r10, false);
        Intrinsics.checkNotNullExpressionValue(r12, "inflate(...)");
        this.binding = r12;
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(PortraitTag.f12672a.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        FragmentRecommendPortraitListBinding r0 = null;
        if (r13.hasNext() == false) goto L10;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        FragmentRecommendPortraitListBinding r2 = this.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        FlowTabLayout r1 = r0.recommendPortraitTags;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "requireContext(...)");
        PortraitTag r7 = new PortraitTag(r3, null, 0, 6, null);
        r7.setText((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"));
        r1.addView((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"));
        goto L3
    L8:
        r0 = r2;
        goto L9
    L10:
        setupRecyclerView();
        this.adapter = new CachedFragmentAdapter((Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.memorydata.plugin"));
        FragmentRecommendPortraitListBinding r8 = this.binding;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L14:
        LinearLayout r15 = r0.getRoot();
        Intrinsics.checkNotNullExpressionValue(r15, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin");
    L13:
        r0 = r8;
        goto L14
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super.onSaveInstanceState(r2);
        r2.putInt(KEY_CURRENT_POSITION, this.currentPosition);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        int r4 = 0;
        if (r3 == null) goto L5;
        r4 = r3.getInt(KEY_CURRENT_POSITION, 0);
    L5:
        this.currentPosition = r4;
        RunLog.INSTANCE.debug(TAG, "currentPosition: " + this.currentPosition);
        FragmentRecommendPortraitListBinding r5 = this.binding;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L8:
        r5.recommendPortraitTags.a(this.currentPosition);
        showFragment(this.currentPosition);
    }
}
