package com.larus.photopicker.v2.impl.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.photopicker.v2.impl.MediaSelectorListFragment;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MediaListTabPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "tabs", "", "Lcom/larus/photopicker/v2/impl/model/MediaTab;", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/util/List;)V", "getItemCount", "", "createFragment", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaListTabPagerAdapter extends FragmentStateAdapter {
    public final List<MediaTab> a;

    public final int getItemCount() {
        return this.a.size();
    }

    public final Fragment createFragment(int r4) {
        int r0 = MediaSelectorListFragment.p;
        MediaTab r5 = (MediaTab) ListProtector.get(this.a, r4);
        Intrinsics.checkNotNullParameter(r5, "mediaTab");
        MediaSelectorListFragment r1 = new MediaSelectorListFragment();
        Bundle r2 = new Bundle();
        r2.putString("media_type", r5.name());
        r1.setArguments(r2);
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MediaListTabPagerAdapter(Fragment r2, List<? extends MediaTab> r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "tabs");
        super(r2);
        this.a = r3;
    }
}
