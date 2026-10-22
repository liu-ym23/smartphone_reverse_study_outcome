package com.larus.showcase.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.utils.LoadMoreManager;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.showcase.impl.databinding.LarusFragmentCaseListBinding;
import com.larus.showcase.impl.databinding.LarusPageCaseErrorBinding;
import com.larus.showcase.impl.databinding.LarusPageCaseLoadingSkeletonBinding;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0015\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010'\u001a\u00020\u001aH\u0016J\n\u0010(\u001a\u0004\u0018\u00010\rH\u0002J\n\u0010)\u001a\u0004\u0018\u00010*H\u0002J\b\u0010+\u001a\u00020\u001aH\u0002J\b\u0010,\u001a\u00020\u001aH\u0002J\b\u0010-\u001a\u00020\u001aH\u0002J\b\u0010.\u001a\u00020\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016¨\u00060"}, d2 = {"Lcom/larus/showcase/view/CaseListFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "tag", "", "binding", "Lcom/larus/showcase/impl/databinding/LarusFragmentCaseListBinding;", "loadMoreManager", "Lcom/larus/bmhome/utils/LoadMoreManager;", "viewModel", "Lcom/larus/showcase/view/CaseViewModel;", "listAdapter", "Lcom/larus/showcase/view/CaseListAdapter;", "needReloadCaseList", "", "isFromRecommend", "()Z", "setFromRecommend", "(Z)V", "caseListCallback", "com/larus/showcase/view/CaseListFragment$caseListCallback$1", "Lcom/larus/showcase/view/CaseListFragment$caseListCallback$1;", "getPageTitle", "getPreviousPage", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "preFetchCurrentMessages", "onResume", "getCaseListAdapter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "initData", "observeData", "resetReloadStatue", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CaseListFragment extends Fragment {
    public static final /* synthetic */ int j = 0;
    public final String d;
    public LarusFragmentCaseListBinding e;
    public LoadMoreManager f;
    public final CaseViewModel g;
    public CaseListAdapter h;
    public final CaseListFragment$caseListCallback$1 i;

    public static final class a {
    }

    public static final class b implements LoadMoreManager.b {
        public final /* synthetic */ CaseListFragment a;

        public b(CaseListFragment r1) {
            this.a = r1;
        }

        public final View a(FrameLayout r4) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            return LayoutInflater.from(this.a.getContext()).inflate(2131562582, r4, false);
        }

        public final View b(FrameLayout r4) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            return LayoutInflater.from(this.a.getContext()).inflate(2131562581, r4, false);
        }

        public final View c(FrameLayout r4) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            return LayoutInflater.from(this.a.getContext()).inflate(2131562327, r4, false);
        }
    }

    static {
    }

    public final CaseListAdapter S90() {
        LarusFragmentCaseListBinding r0 = this.e;
        if (r0 == null) goto L5;
        RecyclerView r1 = r0.d;
    L6:
        if (r1 == null) goto L8;
        RecyclerView.Adapter r2 = r1.getAdapter();
    L10:
        if ((r2 instanceof ConcatAdapter) == false) goto L12;
        ConcatAdapter r3 = (ConcatAdapter) r2;
    L13:
        if (r3 == null) goto L23;
        List r4 = r3.getAdapters();
        if (r4 == null) goto L23;
        Iterator r5 = r4.iterator();
    L18:
        if (r5.hasNext() == false) goto L23;
        CaseListAdapter r6 = (RecyclerView.Adapter) r5.next();
        if ((r6 instanceof CaseListAdapter) == false) goto L18;
        return r6;
    L23:
        return null;
    L12:
        r3 = null;
        goto L13
    L8:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.showcase.view.CaseListFragment$caseListCallback$1] */
    public CaseListFragment() {
        this.d = "CaseListFragment" + hashCode();
        this.g = new CaseViewModel();
        this.i = new CaseListFragment$caseListCallback$1(this);
    }

    public final void onResume() {
        super.onResume();
        FLogger.a.i(this.d, "[onResume], needReloadCaseList = false");
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Context r5 = getContext();
        if (r5 != null) goto L5;
        return;
    L5:
        this.f = new LoadMoreManager(r5, new com.larus.showcase.view.a(this), new b(this));
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        FLogger r12 = FLogger.a;
        r12.i(this.d, "[initView]");
        LarusFragmentCaseListBinding r13 = this.e;
        if (r13 == null) goto L11;
        RecyclerView r1 = r13.d;
        if (r1 == null) goto L11;
        r1.setLayoutManager(new LinearLayoutManager(r1.getContext()));
        r1.setItemAnimator(null);
        CaseListAdapter r14 = new CaseListAdapter(this.i);
        this.h = r14;
        LoadMoreManager r2 = this.f;
        if (r2 == null) goto L9;
        ConcatAdapter r15 = r2.d(r1, r14);
    L10:
        boolean r16 = r15 instanceof ConcatAdapter;
        r1.setItemViewCacheSize(20);
        r1.addItemDecoration(new CaseListFragment$initView$1$2());
        r1.addOnScrollListener(new CaseListFragment$initView$1$3(this));
        y6.d(r1, null, null, null, new com.larus.showcase.view.b(this), 15);
        goto L11
    L9:
        r15 = null;
    L11:
        LarusFragmentCaseListBinding r17 = this.e;
        if (r17 == null) goto L20;
        ConstraintLayout r18 = r17.g;
        if (r18 == null) goto L20;
        ViewGroup.LayoutParams r3 = r18.getLayoutParams();
        if (r3 == null) goto L19;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        i0.a.getClass();
        r4.topMargin = i0.g();
        r18.setLayoutParams(r4);
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L20:
        LarusFragmentCaseListBinding r19 = this.e;
        if (r19 == null) goto L29;
        RecyclerView r110 = r19.d;
        if (r110 == null) goto L29;
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L27;
        int r6 = u.b(r5);
    L28:
        int r7 = r110.getPaddingStart();
        int r8 = r110.getPaddingTop();
        int r9 = r110.getPaddingEnd();
        r12.i("updatePaddingRelative", "view:" + r110.getClass().getSimpleName() + ",source:needAdaptNavigationBarPadding,start:" + r7 + ",top:" + r8 + ",end:" + r9 + ",bottom:" + r6);
        r110.setPaddingRelative(r7, r8, r9, r6);
        goto L29
    L27:
        r6 = 0;
    L29:
        LarusFragmentCaseListBinding r111 = this.e;
        if (r111 == null) goto L34;
        ImageView r112 = r111.b;
        if (r112 == null) goto L34;
        e1.d(r112, new c(this));
    L34:
        LarusFragmentCaseListBinding r113 = this.e;
        if (r113 == null) goto L47;
        AppCompatTextView r114 = r113.f;
        if (r114 == null) goto L47;
        Bundle r20 = getArguments();
        if (r20 == null) goto L42;
        String r21 = r20.getString("case_title");
        if (r21 == null) goto L42;
    L46:
        r114.setText(r21);
    L42:
        Context r22 = getContext();
        if (r22 == null) goto L45;
        r21 = r22.getString(2131909394);
        goto L46
    L45:
        r21 = null;
    L47:
        r12.i(this.d, "[initData]");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CaseListFragment$observeData$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CaseListFragment$observeData$2(this, null), 3, null);
        CaseViewModel r115 = this.g;
        if (r115 == null) goto L51;
        r115.queryCaseList();
        return;
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        FLogger.a.i(this.d, "[onCreateView]");
        ConstraintLayout r12 = r9.inflate(2131562353, r10, false);
        int r13 = 2131363779;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r12, 2131363779);
        if (r2 == null) goto L23;
        r13 = 2131365253;
        ConstraintLayout r0 = ViewBindings.findChildViewById(r12, 2131365253);
        if (r0 == null) goto L23;
        int r14 = 2131383232;
        if (ViewBindings.findChildViewById(r0, 2131383232) == null) goto L21;
        r14 = 2131383234;
        if (ViewBindings.findChildViewById(r0, 2131383234) == null) goto L21;
        LarusPageCaseErrorBinding r3 = new LarusPageCaseErrorBinding(r0);
        r13 = 2131365255;
        RecyclerView r4 = ViewBindings.findChildViewById(r12, 2131365255);
        if (r4 == null) goto L23;
        r13 = 2131365256;
        ConstraintLayout r1 = ViewBindings.findChildViewById(r12, 2131365256);
        if (r1 == null) goto L23;
        LarusPageCaseLoadingSkeletonBinding r5 = new LarusPageCaseLoadingSkeletonBinding(r1);
        r13 = 2131388772;
        AppCompatTextView r6 = ViewBindings.findChildViewById(r12, 2131388772);
        if (r6 == null) goto L23;
        r13 = 2131389118;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r12, 2131389118);
        if (r7 == null) goto L23;
        ConstraintLayout r15 = r12;
        this.e = new LarusFragmentCaseListBinding(r15, r2, r3, r4, r5, r6, r7);
        return r15;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r14)));
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
