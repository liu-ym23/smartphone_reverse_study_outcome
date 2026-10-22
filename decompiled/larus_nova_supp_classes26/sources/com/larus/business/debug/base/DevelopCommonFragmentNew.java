package com.larus.business.debug.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.larus.business.debug.base.adapter.EntranceTabAdapter;
import com.larus.business.debug.base.view.DebugEntrancePageTagListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/business/debug/base/DevelopCommonFragmentNew;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DevelopCommonFragmentNew extends Fragment {
    public DevelopCommonFragmentNew() {
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        EntranceTabAdapter r6 = new EntranceTabAdapter();
        ViewPager r0 = r4.findViewById(2131368588);
        DebugEntrancePageTagListView r2 = null;
        if ((r0 instanceof ViewPager) == false) goto L5;
        ViewPager r1 = r0;
    L6:
        View r7 = r4.findViewById(2131368589);
        if ((r7 instanceof DebugEntrancePageTagListView) == false) goto L9;
        r2 = (DebugEntrancePageTagListView) r7;
    L9:
        if (r1 == null) goto L11;
        r1.setOffscreenPageLimit(2);
    L11:
        if (r1 == null) goto L13;
        r1.setAdapter(r6);
    L13:
        if (r2 == null) goto L16;
        r2.setupWithViewPager(r1);
        return;
    L16:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131563064, r3, false);
    }
}
