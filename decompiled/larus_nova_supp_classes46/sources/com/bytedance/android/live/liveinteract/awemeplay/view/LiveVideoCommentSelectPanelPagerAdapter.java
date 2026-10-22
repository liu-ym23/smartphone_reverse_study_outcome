package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.android.live.liveinteract.awemeplay.model.VideoTab;
import com.bytedance.android.live.liveinteract.awemeplay.viewmodel.LiveVideoCommentSelectAwemePanelViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/awemeplay/view/LiveVideoCommentSelectPanelPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveVideoCommentSelectPanelPagerAdapter extends FragmentPagerAdapter {
    public final List<VideoTab> a;
    public final LiveVideoCommentSelectAwemePanelViewModel b;
    public final boolean c;

    public final int getCount() {
        return this.a.size();
    }

    public final Fragment getItem(int r5) {
        String r0 = LiveVideoCommentSelectPanelAwemeListFragment.r;
        VideoTab r6 = (VideoTab) ListProtector.get(this.a, r5);
        boolean r1 = this.c;
        Intrinsics.checkNotNullParameter(r6, "videoTab");
        LiveVideoCommentSelectPanelAwemeListFragment r2 = new LiveVideoCommentSelectPanelAwemeListFragment();
        Bundle r3 = new Bundle();
        r3.putSerializable("arg_video_tab", r6);
        r2.setArguments(r3);
        r2.d = r1;
        r2.g = this.b;
        return r2;
    }

    public final CharSequence getPageTitle(int r2) {
        if (r2 < 0) goto L8;
        if (r2 >= this.a.size()) goto L8;
        return ((VideoTab) ListProtector.get(this.a, r2)).getTitle();
    L8:
        return super/*androidx.viewpager.widget.PagerAdapter*/.getPageTitle(r2);
    }

    public LiveVideoCommentSelectPanelPagerAdapter(FragmentManager r2, List<VideoTab> r3, LiveVideoCommentSelectAwemePanelViewModel r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "tabList");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }
}
