package com.larus.discover.impl.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.larus.bot.api.IBotDiscoverService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ou8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larus/discover/impl/view/DiscoverMainAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "getItemCount", "", "createFragment", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DiscoverMainAdapter extends FragmentStateAdapter {
    public final Fragment a;

    public final int getItemCount() {
        return 2;
    }

    public DiscoverMainAdapter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.a = r2;
    }

    public final Fragment createFragment(int r2) {
        if (r2 != 0) goto L4;
        a r3 = IBotDiscoverService.a.b();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        Fragment r4 = (Fragment) r3;
    L5:
        Bundle r0 = this.a.getArguments();
        if (r0 != null) goto L8;
        r0 = new Bundle();
    L8:
        r4.setArguments(r0);
        return r4;
    L4:
        r4 = new Fragment();
        goto L5
    }
}
