package com.obric.memorydata.recommend.ui.list;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryFragmentAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "activity", "Lcom/obric/memorydata/recommend/ui/list/RecommendMemoryListActivity;", "<init>", "(Lcom/obric/memorydata/recommend/ui/list/RecommendMemoryListActivity;)V", "getItemCount", "", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryFragmentAdapter extends FragmentStateAdapter {
    public MemoryFragmentAdapter(RecommendMemoryListActivity r3) {
        RecommendMemoryListActivity r4 = (RecommendMemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r3, RecommendMemoryListActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "activity");
        super((FragmentActivity) ZeusTransformUtils.preCheckCast(r4, FragmentActivity.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int r2) {
        if (r2 != MemoryTab.COMMON.ordinal()) goto L5;
    L14:
        Object r1 = ContextListFragment.Companion.a(r2);
    L16:
        return (Fragment) ZeusTransformUtils.preCheckCast(r1, Fragment.class, "com.obric.memorydata.plugin");
    L5:
        if (r2 == MemoryTab.REALTIME_STATUS.ordinal()) goto L14;
        if (r2 != MemoryTab.TODO.ordinal()) goto L11;
        r1 = UserTodoFragment.Companion.a(r2);
        goto L16
    L11:
        if (r2 != MemoryTab.PORTRAIT.ordinal()) goto L13;
        r1 = UserPortraitFragment.Companion.a(r2);
        goto L16
    L13:
        r1 = MemoryListFragment.Companion.a(r2);
        goto L16
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return MemoryTab.Companion.a();
    }
}
