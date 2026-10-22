package com.bytedance.android.live.ktv.common.karaokestation.view;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/KtvCommonPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvCommonPagerAdapter extends FragmentStatePagerAdapter {
    public final List<Object> a;

    public final int getCount() {
        return ((ArrayList) this.a).size();
    }

    public final void f(List<Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "fragmentList");
        ((ArrayList) this.a).clear();
        ((ArrayList) this.a).addAll(r2);
        notifyDataSetChanged();
    }

    public final Fragment getItem(int r2) {
        Object r3 = ListProtector.get(this.a, r2);
        if (r3 == null) goto L7;
        return (Fragment) r3;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
    }

    public KtvCommonPagerAdapter(FragmentManager r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        super(r2, r3);
        this.a = new ArrayList();
    }

    public final Object instantiateItem(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, KtvSubElement.CONTAINER);
        return super.instantiateItem(r2, r3);
    }

    public final void destroyItem(ViewGroup r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r4, "object");
        super.destroyItem(r2, r3, r4);
    }
}
