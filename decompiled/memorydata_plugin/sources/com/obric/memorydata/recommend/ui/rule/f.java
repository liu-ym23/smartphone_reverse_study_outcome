package com.obric.memorydata.recommend.ui.rule;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/RuleFragmentAdapter;", "Lcom/obric/oui/viewpager2/adapter/FragmentStateAdapter;", "activity", "Lcom/obric/memorydata/recommend/ui/rule/RuleMemoryActivity;", "<init>", "(Lcom/obric/memorydata/recommend/ui/rule/RuleMemoryActivity;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f extends com.obric.oui.viewpager2.adapter.a {
    public f(RuleMemoryActivity r3) {
        RuleMemoryActivity r4 = (RuleMemoryActivity) ZeusTransformUtils.wrapperContextForParams(r3, RuleMemoryActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "activity");
        super((FragmentActivity) ZeusTransformUtils.preCheckCast(r4, FragmentActivity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.viewpager2.adapter.a
    public Fragment b(int r2) {
        if (r2 != 0) goto L5;
        Object r3 = new AppMemoryFragment();
    L7:
        return (Fragment) ZeusTransformUtils.preCheckCast(r3, Fragment.class, "com.obric.memorydata.plugin");
    L5:
        r3 = new BlockMemoryFragment();
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return 2;
    }
}
