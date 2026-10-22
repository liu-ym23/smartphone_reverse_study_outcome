package com.bytedance.android.live.liveinteract.feedv2.feedview;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ MultiLinkCommonVideoFeedPreview a;

    public i(MultiLinkCommonVideoFeedPreview r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        List<? extends tf0.e> r10 = (List) r9;
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(this.a.getConfigOuterProvider(), "CommonVideoFeedPreview", this.a.hashCode(), "call updateSeatListWithDiff, itSize = " + r10.size() + ", baseWindowView = " + this.a.getBaseWindowView(), false, 8, null);
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(this.a.getConfigInnerProvider().g(), "list_v2_time", 0, 2, null);
        MultiLinkCommonVideoFeedPreview r0 = this.a;
        r0.getClass();
        Iterator<T> r1 = r10.iterator();
    L4:
        if (r1.hasNext() == false) goto L21;
        tf0.e r2 = (tf0.e) r1.next();
        if ((r2 instanceof MultiLinkGuestViewBinder.a) == true) goto L8;
        r2 = null;
    L8:
        MultiLinkGuestViewBinder.a r3 = (MultiLinkGuestViewBinder.a) r2;
        if (r3 == null) goto L4;
        ch0.e r4 = r3.k;
        if (r4 == null) goto L4;
        Map<String, Object> r5 = r4.d;
        if (r5 == null) goto L4;
        IPreviewMultiLinkOuterConfigProvider r6 = r0.b;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L17:
        String r7 = r6.getRoom().getOwnerUserIdString();
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        r5.put("EXT_KEY_ANCHOR_ID", r7);
        goto L4
    L21:
        BaseLinkSeatWindowView r8 = this.a.getBaseWindowView();
        if (r8 == null) goto L24;
        r8.O7(r10);
    L24:
        this.a.K(r10);
        ConstraintLayout r11 = this.a.getBaseWindowView();
        if (r11 == null) goto L37;
        int r12 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.e;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.a.a(r11, new MultiLinkCommonVideoFeedPreview$registerWindowListObservable$1$1(this));
        return;
    }
}
