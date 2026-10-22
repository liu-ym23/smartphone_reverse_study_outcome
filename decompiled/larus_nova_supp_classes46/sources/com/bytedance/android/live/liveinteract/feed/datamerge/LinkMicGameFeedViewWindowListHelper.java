package com.bytedance.android.live.liveinteract.feed.datamerge;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkMicGameFeedViewWindowListHelper extends i {
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.f k;

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final void d() {
        super.d();
        MainThreadPostUtils.d(this.k.f);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final void i(String r3, List<tf0.e> r4, List<ch0.e> r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "anchorId");
        Intrinsics.checkNotNullParameter(r4, "windowList");
        Intrinsics.checkNotNullParameter(r5, "linkedUserMergeDataList");
        List<ch0.e> r0 = this.j.d();
        ArrayList r1 = new ArrayList();
        r1.addAll(r5);
        r1.addAll(r0);
        this.k.a(r3, r4, r1, r6);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final void l(List<tf0.e> r3, List<ch0.e> r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "windowList");
        Intrinsics.checkNotNullParameter(r4, "linkedUserMergeDataList");
        Intrinsics.checkNotNullParameter(r6, "anchorId");
        List<ch0.e> r0 = this.j.d();
        ArrayList r1 = new ArrayList();
        r1.addAll(r4);
        r1.addAll(r0);
        this.k.b(r3, r1, r5, r6);
    }

    public LinkMicGameFeedViewWindowListHelper(IRoom r13, DataCenter r14, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r15, com.bytedance.android.live.liveinteract.plantform.datamerge.k r16, k r17, int r18, final Function0<? extends SeiAppData> r19) {
        Intrinsics.checkNotNullParameter(r15, "layoutConfig");
        Intrinsics.checkNotNullParameter(r16, "windowConfig");
        Intrinsics.checkNotNullParameter(r17, "dataMergeCenterProxy");
        Intrinsics.checkNotNullParameter(r19, "getLastSeiAppData");
        super(r13, r14, r15, r16, r17, r18);
        this.k = new com.bytedance.android.live.liveinteract.plantform.datamerge.f(r13, r14, false, r15, this, null, null, r18, new LinkMicGameFeedViewWindowListHelper$linkMicGameWindowHelperExt$1(r19));
    }
}
