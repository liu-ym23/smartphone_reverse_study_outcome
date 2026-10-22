package com.larus.setting.impl.blocklist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.home.api.block.BlockUserViewModel;
import com.larus.setting.impl.databinding.LarusPageBlockListSettingBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/setting/impl/blocklist/BlockListFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/setting/impl/databinding/LarusPageBlockListSettingBinding;", "viewModel", "Lcom/larus/home/api/block/BlockUserViewModel;", "getViewModel", "()Lcom/larus/home/api/block/BlockUserViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/larus/setting/impl/blocklist/BlockListAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupRecycleView", "getBlockConfirmContent", "", "updatePageState", "pageStatus", "", "triggerLoadMore", "refresh", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class BlockListFragment extends Fragment {
    public static final /* synthetic */ int g = 0;
    public LarusPageBlockListSettingBinding d;
    public final Lazy e;
    public final BlockListAdapter f;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final BlockUserViewModel S90() {
        return (BlockUserViewModel) this.e.getValue();
    }

    public BlockListFragment() {
        final Function0<Fragment> r0 = new BlockListFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BlockUserViewModel.class), new BlockListFragment$special$$inlined$viewModels$default$2(r0), new BlockListFragment$special$$inlined$viewModels$default$3(r0, this));
        this.f = new BlockListAdapter(new FPagingAdapter.a(new e(this)));
    }

    public final void T90(int r9) {
        if (r9 != 0) goto L5;
        LarusPageBlockListSettingBinding r10 = this.d;
        if (r10 == null) goto L65;
        RecyclerView r11 = r10.c;
        if (r11 == null) goto L65;
        r11.setVisibility(0);
    L65:
        LarusPageBlockListSettingBinding r12 = this.d;
        if (r12 == null) goto L70;
        LinearLayout r13 = r12.d;
        if (r13 == null) goto L70;
        r13.setVisibility(8);
    L70:
        LarusPageBlockListSettingBinding r14 = this.d;
        if (r14 == null) goto L84;
        TextView r15 = r14.b;
        if (r15 == null) goto L85;
        r15.setVisibility(8);
        return;
    L85:
        return;
    L84:
        return;
    L5:
        if (r9 != 1) goto L7;
        LarusPageBlockListSettingBinding r16 = this.d;
        if (r16 == null) goto L50;
        RecyclerView r17 = r16.c;
        if (r17 == null) goto L50;
        r17.setVisibility(8);
    L50:
        LarusPageBlockListSettingBinding r18 = this.d;
        if (r18 == null) goto L55;
        LinearLayout r19 = r18.d;
        if (r19 == null) goto L55;
        r19.setVisibility(8);
    L55:
        LarusPageBlockListSettingBinding r20 = this.d;
        if (r20 == null) goto L81;
        TextView r21 = r20.b;
        if (r21 == null) goto L82;
        r21.setVisibility(0);
        return;
    L82:
        return;
    L81:
        return;
    L7:
        if (r9 != 2) goto L9;
        LarusPageBlockListSettingBinding r22 = this.d;
        if (r22 == null) goto L35;
        RecyclerView r23 = r22.c;
        if (r23 == null) goto L35;
        r23.setVisibility(8);
    L35:
        LarusPageBlockListSettingBinding r24 = this.d;
        if (r24 == null) goto L40;
        LinearLayout r25 = r24.d;
        if (r25 == null) goto L40;
        r25.setVisibility(0);
    L40:
        LarusPageBlockListSettingBinding r26 = this.d;
        if (r26 == null) goto L78;
        TextView r27 = r26.b;
        if (r27 == null) goto L79;
        r27.setVisibility(8);
        return;
    L79:
        return;
    L78:
        return;
    L9:
        if (r9 != 3) goto L86;
        LarusPageBlockListSettingBinding r28 = this.d;
        if (r28 == null) goto L16;
        RecyclerView r29 = r28.c;
        if (r29 == null) goto L16;
        r29.setVisibility(0);
    L16:
        LarusPageBlockListSettingBinding r30 = this.d;
        if (r30 == null) goto L21;
        LinearLayout r31 = r30.d;
        if (r31 == null) goto L21;
        r31.setVisibility(8);
    L21:
        LarusPageBlockListSettingBinding r32 = this.d;
        if (r32 == null) goto L26;
        TextView r33 = r32.b;
        if (r33 == null) goto L26;
        r33.setVisibility(8);
    L26:
        BlockListAdapter r34 = this.f;
        m[] r2 = new m[6];
        int r3 = 0;
    L27:
        if (r3 >= 6) goto L29;
        r2[r3] = new m(null, false, -1, 10);
        r3 = r3 + 1;
        goto L27
    L29:
        r34.E2(ArraysKt.toList(r2));
        return;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        LarusPageBlockListSettingBinding r10 = this.d;
        if (r10 == null) goto L5;
        NovaTitleBarEx r0 = r10.e;
        NovaTitleBarEx.Y5(r0, getString(2131900173), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131241477, false, null, null, new com.larus.setting.impl.blocklist.b(this), 14);
        e1.d(r10.d, new d(this));
    L5:
        LarusPageBlockListSettingBinding r11 = this.d;
        if (r11 == null) goto L10;
        RecyclerView r12 = r11.c;
        if (r12 == null) goto L10;
        r12.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        r12.setAdapter(this.f);
    L10:
        BlockListAdapter r13 = this.f;
        Function1<? super String, Unit> r14 = new f(this);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "listener");
        r13.f = r14;
        BlockListAdapter r15 = this.f;
        Function1<? super String, Unit> r16 = new g(this);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "listener");
        r15.g = r16;
        S90().getBlockLiveData().observe(getViewLifecycleOwner(), new b(new h(this)));
        S90().getUnblockLiveData().observe(getViewLifecycleOwner(), new b(new i(this)));
        S90().getRefreshBlockListEvent().observe(getViewLifecycleOwner(), new b(new j(this)));
        S90().getLoadMoreBlockListEvent().observe(getViewLifecycleOwner(), new b(new k(this)));
        S90().isLoadingMoreBlockListEvent().observe(getViewLifecycleOwner(), new b(new l(this)));
        FLogger.a.i("BlockListFragment", "refreshing blocklist fragment");
        S90().requestBlockList();
        T90(3);
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131562997, r8, false);
        int r11 = 2131364277;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r10, 2131364277);
        if (r2 == null) goto L19;
        LinearLayout r12 = (LinearLayout) r10;
        RecyclerView r3 = ViewBindings.findChildViewById(r10, 2131384076);
        if (r3 == null) goto L17;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131384140);
        if (r4 != null) goto L9;
        r11 = 2131384140;
        goto L19
    L9:
        if (((TextView) ViewBindings.findChildViewById(r10, 2131384145)) == null) goto L15;
        NovaTitleBarEx r5 = ViewBindings.findChildViewById(r10, 2131388772);
        if (r5 == null) goto L14;
        this.d = new LarusPageBlockListSettingBinding(r12, r2, r3, r4, r5);
        return r12;
    L14:
        r11 = 2131388772;
        goto L19
    L15:
        r11 = 2131384145;
        goto L19
    L17:
        r11 = 2131384076;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
