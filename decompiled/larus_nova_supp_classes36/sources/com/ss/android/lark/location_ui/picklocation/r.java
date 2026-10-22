package com.ss.android.lark.location_ui.picklocation;

import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class r extends LocationView.i {
    public final /* synthetic */ LocationView a;

    public r(LocationView r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.location_ui.picklocation.LocationView.i, com.ss.android.lark.location_ui.picklocation.LocationView.h
    public final void a(com.ss.android.lark.location.service.k r3) {
        Log.i("LocationView", "queryLocation onSearchResultError called. errorCode:" + r3);
        this.a.mNearbyLoading.a();
        LocationView r0 = this.a;
        r0.q = true;
        r0.T();
        LocationView.o(this.a);
        if (this.a.k.isAdminGpsEnabled() == false) goto L8;
        LocationView r1 = this.a;
        if (r1.s(r1.b) == false) goto L9;
        iqb.b.a(this.a.b, r3);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.location_ui.picklocation.LocationView.h
    public final void b(List<POIInfo> r5) {
        Log.i("LocationView", "queryLocation onSearchResultSuccess called.");
        if (r5 != null) goto L5;
    L13:
        this.a.mNearbyLoading.a();
        return;
    L5:
        if (((ArrayList) r5).size() <= 0) goto L13;
        this.a.mNearByListView.setVisibility(0);
        this.a.mNearbyLoading.setVisibility(8);
        this.a.o.addAll(r5);
        ArrayList<POIInfo> r6 = this.a.o;
        ArrayList r0 = new ArrayList(r6.size());
        Iterator<POIInfo> r1 = r6.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        POIInfo r2 = r1.next();
        if (r0.contains(r2) == true) goto L8;
        r0.add(r2);
        goto L8
    L12:
        r6.clear();
        r6.addAll(r0);
        LocationView r7 = this.a;
        r7.l.b(r7.o);
        kqb.c.a(this.a.mNearByListView);
        this.a.T();
        this.a.p++;
    }
}
