package com.ss.android.lark.forwardv2.impl.view;

import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class s implements RecentForwardAdapterV3.a {
    public final /* synthetic */ d0 a;

    public s(d0 r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3.a
    public final boolean a(SearchBaseInfo r3) {
        boolean r4 = d0.h(this.a, r3);
        Log.i("TemplateForwardView", "recent forward consume item click:" + r4);
        return r4;
    }
}
