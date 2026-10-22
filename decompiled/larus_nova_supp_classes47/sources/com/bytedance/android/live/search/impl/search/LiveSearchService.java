package com.bytedance.android.live.search.impl.search;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.search.api.ILiveSearchService;
import com.bytedance.android.live.search.impl.search.ui.SearchHeadListView;
import com.bytedance.android.livesdk.config.ar0;
import com.bytedance.android.livesdk.config.q01;
import com.bytedance.android.livesdk.utils.e5;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J,\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J4\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u001a\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/search/impl/search/LiveSearchService;", "Lcom/bytedance/android/live/search/api/ILiveSearchService;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "inputContainer", "Landroid/os/Bundle;", "bundle", "Lpa1/d;", "searchCallback", "Landroidx/fragment/app/Fragment;", "createSearchResultFragment", "Lpa1/e;", "config", "createSearchUserFragment", "", "isTrial", "parent", "Landroid/view/View;", "createSearchUserHeadListView", "createSearchInputView", "supportSearch", "", "roomId", "Landroid/app/Activity;", "activity", "shouldJumpToSearch", "hasShowSearch", "", "clearCache", "", "getSearchSlideType", "<init>", "()V", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveSearchService implements ILiveSearchService {
    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public void clearCache() {
        a.f = null;
        a.e = 0;
        a.a = "";
        a.b = 0;
        a.c = "";
        a.d = 0;
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public int getSearchSlideType() {
        return ((Integer) q01.a.getValue()).intValue();
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public boolean supportSearch() {
        return ((Boolean) ar0.a.getValue()).booleanValue();
    }

    public LiveSearchService() {
        jc1.k.l(ILiveSearchService.class, this);
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public boolean hasShowSearch(Activity r2) {
        if (r2 == null) goto L6;
        int r3 = r2.hashCode();
        String r0 = a.a;
        if (r3 != a.d) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public View createSearchInputView(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return LayoutInflater.from(r3).inflate(2131567420, r4, false);
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public View createSearchUserHeadListView(Context r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new SearchHeadListView(r4, null, 6, 0);
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public boolean shouldJumpToSearch(long r3, Activity r5) {
        String r0 = a.a;
        if (a.e == 0) goto L12;
        if (r5 == null) goto L11;
        int r1 = r5.hashCode();
        int r2 = a.d;
        if (r1 == r2) goto L11;
        if (r2 == r5.hashCode()) goto L12;
        if (a.b != r3) goto L12;
    L11:
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public Fragment createSearchResultFragment(Context r2, ViewGroup r3, Bundle r4, pa1.d r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "searchCallback");
        if (r3 == null) goto L7;
        View r6 = createSearchInputView(r2, r3);
        r3.removeAllViews();
        r3.addView(r6);
        if (e5.n() == false) goto L7;
        r6.setBackgroundResource(2131252927);
    L7:
        LiveSearchResultFragment r7 = new LiveSearchResultFragment();
        if (r3 == null) goto L10;
        r7.Y90(r3);
    L10:
        r7.r = r5;
        if (r4 != null) goto L13;
        r4 = new Bundle();
    L13:
        r7.setArguments(r4);
        Bundle r8 = r7.getArguments();
        if (r8 == null) goto L19;
        if (r3 != null) goto L17;
        boolean r9 = true;
    L18:
        r8.putBoolean("bundle_need_show_input_container_inside", r9);
        goto L19
    L17:
        r9 = false;
    L19:
        return r7;
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public Fragment createSearchUserFragment(Context r1, ViewGroup r2, Bundle r3, pa1.e r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "config");
        int r5 = LiveSearchUserFragment.z;
        Intrinsics.checkNotNullParameter(r4, "config");
        LiveSearchUserFragment r6 = new LiveSearchUserFragment();
        r6.s = r4;
        return r6;
    }

    @Override // com.bytedance.android.live.search.api.ILiveSearchService
    public Fragment createSearchUserFragment(Context r1, ViewGroup r2, Bundle r3, pa1.e r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "config");
        int r6 = LiveSearchUserFragment.z;
        Intrinsics.checkNotNullParameter(r4, "config");
        LiveSearchUserFragment r7 = new LiveSearchUserFragment();
        r7.s = r4;
        r7.u = r5;
        return r7;
    }
}
