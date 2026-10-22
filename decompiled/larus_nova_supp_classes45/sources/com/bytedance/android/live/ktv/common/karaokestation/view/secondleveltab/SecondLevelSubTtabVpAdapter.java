package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.uikit.viewpager.FragmentPagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/SecondLevelSubTtabVpAdapter;", "Lcom/bytedance/android/live/uikit/viewpager/FragmentPagerAdapter;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SecondLevelSubTtabVpAdapter extends FragmentPagerAdapter {
    public final ArrayList<BaseSecondLevelTabFragment> a;
    public final ArrayList<String> b;

    public final int getCount() {
        return this.a.size();
    }

    public SecondLevelSubTtabVpAdapter(FragmentManager r2) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        super(r2);
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public final void f(BaseSecondLevelTabFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fr");
        this.a.add(r2);
        this.b.add(r2.k.d);
    }

    public final Fragment getItem(int r2) {
        return (Fragment) ListProtector.get(this.a, r2);
    }

    public final CharSequence getPageTitle(int r2) {
        return (CharSequence) ListProtector.get(this.b, r2);
    }

    public final Object instantiateItem(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, KtvSubElement.CONTAINER);
        return super.instantiateItem(r2, r3);
    }
}
