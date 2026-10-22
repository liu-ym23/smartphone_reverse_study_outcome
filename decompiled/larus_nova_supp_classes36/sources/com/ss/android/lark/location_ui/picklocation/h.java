package com.ss.android.lark.location_ui.picklocation;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements com.ss.android.lark.location.service.h.a {
    public final /* synthetic */ LocationView.f a;

    public h(LocationView.a r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.location.service.h.a
    public final void a(POIInfo r6) {
        LocationView.a r0 = (LocationView.a) this.a;
        r0.getClass();
        Log.i("LocationView", "onRegeocodeSearched called.");
        LocationView r1 = r0.a;
        r1.q = true;
        r1.mNearByListView.setVisibility(0);
        r0.a.mNearbyLoading.setVisibility(8);
        if (r6 != null) goto L5;
        r0.a.mSearchBar.setEditTextEnabled(true);
        return;
    L5:
        iqb.a r2 = r0.a.l;
        if (r2.b != null) goto L9;
        r2.b = new ArrayList();
    L9:
        if (r2.b.size() < 0) goto L12;
        ListProtector.add(r2.b, 0, r6);
        r2.notifyDataSetChanged();
    L12:
        LocationView.h(r0.a, 0);
        r0.a.mSearchBar.setEditTextEnabled(true);
    }
}
