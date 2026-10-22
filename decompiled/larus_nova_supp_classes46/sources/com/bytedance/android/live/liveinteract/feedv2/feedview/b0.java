package com.bytedance.android.live.liveinteract.feedv2.feedview;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0<T> implements Consumer {
    public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

    public b0(MultiLinkCommonVoiceFeedPreview r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        List<? extends tf0.e> r10 = (List) r9;
        te0.a r0 = this.a.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L5:
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r0.g(), "list_v2_time", 0, 2, null);
        this.a.G(r10);
        BaseLinkSeatWindowView r1 = this.a.getBaseWindowView();
        if (r1 == null) goto L8;
        r1.O7(r10);
    L8:
        BaseLinkSeatWindowView r2 = this.a.getBaseWindowView();
        if (r2 == null) goto L13;
        RecyclerView r3 = r2.getRecyclerView();
        if (r3 == null) goto L13;
        r3.post(new a0(this, r10));
    L13:
        ConstraintLayout r4 = this.a.getBaseWindowView();
        if (r4 == null) goto L17;
        int r5 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.e;
        this.a.S1.add(com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.a.a(r4, new MultiLinkCommonVoiceFeedPreview$registerWindowListHelperObservable$1$2(this)));
    L17:
        if ((!r10.isEmpty()) == false) goto L19;
        this.a.O();
        this.a.P();
    L19:
        this.a.D(r10);
        MultiLinkCommonVoiceFeedPreview.B(this.a, r10);
    }
}
