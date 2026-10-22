package com.larus.aweme.impl.main_bot;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.larus.aweme.impl.databinding.LarusDouyinWrapperFragmentLayoutBinding;
import com.larus.utils.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ DouYinWrapperFragment a;

    public /* synthetic */ c(DouYinWrapperFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DouYinWrapperFragment r0 = this.a;
        int r1 = DouYinWrapperFragment.n;
        FragmentActivity r2 = r0.getContext();
        View r3 = null;
        if ((r2 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r4 = r2;
    L6:
        if (r4 == null) goto L31;
        int r5 = u.b(r4);
        if (r5 != 0) goto L14;
        LarusDouyinWrapperFragmentLayoutBinding r6 = r0.d;
        if (r6 == null) goto L32;
        View r7 = r6.c;
        if (r7 == null) goto L33;
        r7.setVisibility(8);
        return;
    L33:
        return;
    L32:
        return;
    L14:
        if (r5 <= 0) goto L35;
        LarusDouyinWrapperFragmentLayoutBinding r8 = r0.d;
        if (r8 == null) goto L20;
        View r9 = r8.c;
        if (r9 == null) goto L20;
        r9.setVisibility(0);
    L20:
        LarusDouyinWrapperFragmentLayoutBinding r10 = r0.d;
        if (r10 == null) goto L25;
        View r11 = r10.c;
        if (r11 == null) goto L25;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
    L26:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r13 = (LinearLayout.LayoutParams) r12;
        r13.height = r5;
        LarusDouyinWrapperFragmentLayoutBinding r14 = r0.d;
        if (r14 == null) goto L29;
        r3 = r14.c;
    L29:
        Intrinsics.checkNotNull(r3);
        r3.setLayoutParams(r13);
        return;
    L25:
        r12 = null;
        goto L26
    L35:
        return;
    L31:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
