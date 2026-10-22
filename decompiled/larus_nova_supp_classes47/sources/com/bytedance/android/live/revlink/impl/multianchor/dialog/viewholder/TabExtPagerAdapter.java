package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/TabExtPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TabExtPagerAdapter extends FragmentPagerAdapter {
    public final List<TabFragment> a;
    public final List<TabFragment> b;
    public final me.drakeet.multitype.e c;

    public final int getCount() {
        return ((ArrayList) this.a).size();
    }

    public final Fragment getItem(int r2) {
        return (Fragment) ListProtector.get(this.a, r2);
    }

    public final long getItemId(int r3) {
        return ((TabFragment) ListProtector.get(this.a, r3)).hashCode();
    }

    public final int getItemPosition(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "object");
        if (CollectionsKt.contains(this.a, r2) == true) goto L5;
        return -2;
    L5:
        return CollectionsKt.indexOf(this.a, r2);
    }

    public TabExtPagerAdapter(FragmentManager r2, List<TabFragment> r3, me.drakeet.multitype.e r4) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "tabFragmentCache");
        Intrinsics.checkNotNullParameter(r4, "typePool");
        super(r2);
        this.b = r3;
        this.c = r4;
        this.a = new ArrayList();
    }
}
