package com.ss.android.lark.forwardv3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.forwardv3.recentforward.ChatPickerCustomBinderViewHolder;
import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import com.ss.android.lark.forwardv3.recentforward.RecentForwardItemDecorationV3;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.binder.ICustomBinder;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements ICustomBinder {
    public final /* synthetic */ ForwardNewFragment a;

    public final int getItemViewType(int r1) {
        return 100;
    }

    public l(ForwardNewFragment r1) {
        this.a = r1;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        View r9 = this.a.m;
        boolean r0 = false;
        if (r9 != null) goto L5;
        r9 = LayoutInflater.from(r7.getContext()).inflate(2131568193, r7, false);
    L5:
        ForwardNewFragment r10 = this.a;
        r10.m = r9;
        r10.n = r9.findViewById(2131383865);
        ForwardNewFragment r11 = this.a;
        r11.getClass();
        Log.i("NewForward", "init recent forward");
        RecyclerView r1 = r11.n;
        ForwardV3ViewModel r3 = null;
        if (r1 == null) goto L11;
        r1.setLayoutManager(new LinearLayoutManager(r1.getContext(), 0, false));
        RecyclerView.Adapter r4 = r11.h;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recentForwardAdapter");
        r4 = null;
    L10:
        r1.setAdapter(r4);
        r1.addItemDecoration(new RecentForwardItemDecorationV3());
        r1.setItemAnimator(null);
    L11:
        RecentForwardAdapterV3 r2 = r11.h;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recentForwardAdapter");
        r2 = null;
    L14:
        ForwardV3ViewModel r12 = r11.f;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        Integer r13 = (Integer) r3.getSelectMode().getValue();
        if (r13 != null) goto L22;
    L24:
        r2.switchMultiple(r0);
        Intrinsics.checkNotNull(r9);
        return new ChatPickerCustomBinderViewHolder(r9);
    L22:
        if (r13.intValue() != 1) goto L24;
        r0 = true;
        goto L24
    L17:
        r3 = r12;
        goto L18
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r1, SearchBaseInfo r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        Intrinsics.checkNotNullParameter(r2, "data");
        Log.i("NewForward", "bind custom view holder, but do nothing");
    }
}
