package com.obric.memorydata.recommend.ui.list;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\bJ\b\u0010\f\u001a\u00020\bH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/CachedFragmentAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "fragmentCache", "", "", "createFragment", "position", "getFragment", "getItemCount", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CachedFragmentAdapter extends FragmentStateAdapter {
    private final Map<Integer, Fragment> fragmentCache;

    public CachedFragmentAdapter(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        super(r3);
        this.fragmentCache = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int r4) {
        Map<Integer, Fragment> r3 = this.fragmentCache;
        Integer r0 = Integer.valueOf(r4);
        Fragment r1 = r3.get(r0);
        if (r1 != null) goto L6;
        r1 = (Fragment) ZeusTransformUtils.preCheckCast(PortraitChildFragment.Companion.a(r4), Fragment.class, "com.obric.memorydata.plugin");
        r3.put(r0, r1);
    L6:
        return (Fragment) ZeusTransformUtils.preCheckCast(r1, Fragment.class, "com.obric.memorydata.plugin");
    }

    public final Fragment getFragment(int r2) {
        return (Fragment) ZeusTransformUtils.preCheckCast(this.fragmentCache.get(Integer.valueOf(r2)), Fragment.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return PortraitTag.f12672a.a().size();
    }
}
