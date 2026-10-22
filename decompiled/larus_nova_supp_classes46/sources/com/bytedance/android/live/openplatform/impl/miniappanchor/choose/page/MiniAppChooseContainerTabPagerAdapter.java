package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/MiniAppChooseContainerTabPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppChooseContainerTabPagerAdapter extends FragmentPagerAdapter {
    public final List<BaseFragment> a;
    public final List<String> b;

    public final int getCount() {
        return ((ArrayList) this.a).size();
    }

    public MiniAppChooseContainerTabPagerAdapter(FragmentManager r2) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        super(r2);
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public final Fragment getItem(int r2) {
        return (Fragment) ListProtector.get(this.a, r2);
    }

    public final long getItemId(int r3) {
        return ((BaseFragment) ListProtector.get(this.a, r3)).hashCode();
    }

    public final int getItemPosition(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "object");
        if ((r2 instanceof Fragment) == false) goto L10;
        int r3 = CollectionsKt.indexOf(this.a, r2);
        if (r3 != (-1)) goto L11;
        return -2;
    L11:
        return r3;
    L10:
        return super/*androidx.viewpager.widget.PagerAdapter*/.getItemPosition(r2);
    }

    public final CharSequence getPageTitle(int r2) {
        return (CharSequence) ListProtector.get(this.b, r2);
    }

    public final void f(BaseFragment r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "title");
        if (r2 == null) goto L6;
        ((ArrayList) this.a).add(r2);
        ((ArrayList) this.b).add(r3);
        return;
    }
}
