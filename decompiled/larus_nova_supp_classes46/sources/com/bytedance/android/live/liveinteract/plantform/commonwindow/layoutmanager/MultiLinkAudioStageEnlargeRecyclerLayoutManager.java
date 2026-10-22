package com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import pn0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/layoutmanager/MultiLinkAudioStageEnlargeRecyclerLayoutManager;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/layoutmanager/MultiLinkRecyclerLayoutManagerV2;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkAudioStageEnlargeRecyclerLayoutManager extends MultiLinkRecyclerLayoutManagerV2 {
    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager.MultiLinkRecyclerLayoutManagerV2, ug0.a
    public final Pair<Integer, Integer> a(int r6) {
        Iterator<T> r0 = this.b.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((f.c) r1).a != r6) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        f.c r2 = (f.c) r1;
        if (r2 == null) goto L15;
        if (r6 != 0) goto L20;
        return new Pair(Integer.valueOf(r2.e), Integer.valueOf((int) (((double) r2.f) * 1.15d)));
    L20:
        return new Pair(Integer.valueOf(r2.e), Integer.valueOf(r2.f));
    L15:
        return new Pair(0, 0);
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public MultiLinkAudioStageEnlargeRecyclerLayoutManager(m r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "linkWindowLayoutConfig");
        Intrinsics.checkNotNullParameter(r3, "layoutConfigResult");
        super(r2, r3);
    }
}
