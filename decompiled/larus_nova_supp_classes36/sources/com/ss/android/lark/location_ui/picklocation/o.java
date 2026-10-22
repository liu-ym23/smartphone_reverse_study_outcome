package com.ss.android.lark.location_ui.picklocation;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.location.dto.POIInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o extends LocationView.i {
    public final /* synthetic */ POIInfo a;
    public final /* synthetic */ LocationView b;

    @Override // com.ss.android.lark.location_ui.picklocation.LocationView.i, com.ss.android.lark.location_ui.picklocation.LocationView.h
    public final void a(com.ss.android.lark.location.service.k r3) {
        this.b.mNearByListView.setVisibility(0);
        this.b.mNearbyLoading.setVisibility(8);
        this.a.setIsCurrent(true);
        iqb.a r4 = this.b.l;
        POIInfo r0 = this.a;
        if (r0 != null) goto L6;
        r4.getClass();
    L9:
        kqb.c.a(this.b.mNearByListView);
        this.b.T();
        return;
    L6:
        if (r4.b != null) goto L8;
        r4.b = new ArrayList();
    L8:
        r4.b.add(r0);
        r4.notifyDataSetChanged();
        goto L9
    }

    @Override // com.ss.android.lark.location_ui.picklocation.LocationView.h
    public final void b(List<POIInfo> r7) {
        this.a.setIsCurrent(true);
        this.b.mNearByListView.setVisibility(0);
        this.b.mNearbyLoading.setVisibility(8);
        if (r7 != null) goto L5;
    L25:
        iqb.a r8 = this.b.l;
        POIInfo r0 = this.a;
        if (r0 != null) goto L29;
        r8.getClass();
    L32:
        kqb.c.a(this.b.mNearByListView);
        this.b.T();
        return;
    L29:
        if (r8.b != null) goto L31;
        r8.b = new ArrayList();
    L31:
        r8.b.add(r0);
        r8.notifyDataSetChanged();
        goto L32
    L5:
        if (((ArrayList) r7).size() <= 0) goto L25;
        LocationView r1 = this.b;
        POIInfo r2 = this.a;
        r1.getClass();
        if (r2 == null) goto L18;
        CopyOnWriteArrayList r3 = new CopyOnWriteArrayList(r7);
        Iterator r9 = r3.iterator();
    L11:
        if (r9.hasNext() == false) goto L17;
        POIInfo r4 = (POIInfo) r9.next();
        if (TextUtils.equals(r4.getLocationName(), r2.getLocationName()) == false) goto L11;
        if (TextUtils.equals(r4.getLocationAddress(), r2.getLocationAddress()) == false) goto L11;
        r3.remove(r4);
        goto L11
    L17:
        ListProtector.add(r3, 0, r2);
        r7 = r3;
    L18:
        iqb.a r5 = this.b.l;
        r5.getClass();
        if (CollectionUtils.isEmpty(r7) == true) goto L32;
        if (r5.b != null) goto L24;
        r5.b = new ArrayList();
    L24:
        r5.b.addAll(r7);
        r5.notifyDataSetChanged();
        goto L32
    }

    public o(LocationView r1, POIInfo r2) {
        this.b = r1;
        this.a = r2;
    }
}
