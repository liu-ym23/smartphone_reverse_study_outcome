package com.bytedance.android.live.liveinteract.feedv2.feedview;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.LinkRoomFightWindowListHelperV2;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/feedv2/feedview/MultiLinkLinkRoomFightFeedPreview;", "Lcom/bytedance/android/live/liveinteract/feedv2/feedview/MultiLinkCommonVideoFeedPreview;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkLinkRoomFightFeedPreview extends MultiLinkCommonVideoFeedPreview {
    public com.bytedance.android.live.liveinteract.feed.datamerge.m I;
    public ue0.b J;
    public com.bytedance.android.live.liveinteract.widget.widget.v K;

    public static final class a implements com.bytedance.android.live.liveinteract.widget.widget.v.a {
        public final /* synthetic */ MultiLinkLinkRoomFightFeedPreview a;

        @Override // com.bytedance.android.live.liveinteract.widget.widget.v.a
        public final View c() {
            BaseLinkSeatWindowView r0 = this.a.getBaseWindowView();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getDynamicBgContainer();
        }

        public a(MultiLinkLinkRoomFightFeedPreview r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview
    public /* bridge */ /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview, com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void s() {
        ue0.b r0 = this.J;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview, com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void release() {
        super.release();
        ue0.c r0 = getConfigInnerProvider().f();
        ue0.b r1 = this.J;
        if (r1 == null) goto L6;
        if (r0 == null) goto L6;
        r0.v(r1);
    L6:
        com.bytedance.android.live.liveinteract.feed.datamerge.m r2 = this.I;
        if (r2 == null) goto L11;
        if (r0 == null) goto L12;
        r0.v(r2);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview
    public final void D(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r12) {
        Intrinsics.checkNotNullParameter(r12, "layoutConfig");
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r0 = r12.h();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.e> r3 = r12.k();
        if (r3 == null) goto L9;
        r1 = r3.size();
    L9:
        com.bytedance.android.live.liveinteract.plantform.datamerge.k r7 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(r2 + r1);
        com.bytedance.android.live.liveinteract.plantform.datamergev2.h r8 = getConfigInnerProvider().c();
        eh0.b r9 = getConfigInnerProvider().p5();
        if (r8 == null) goto L13;
        if (r9 == null) goto L13;
        setWindowListHelper(new LinkRoomFightWindowListHelperV2(getConfigOuterProvider().getRoom(), getFeedDataCenter(), false, r12, r7, r8, r9, getConfigOuterProvider().getShowFrom()));
    L13:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r13 = getWindowListHelper();
        if (r13 == null) goto L16;
        r13.b();
    L16:
        BaseLinkSeatWindowView r14 = getBaseWindowView();
        if (r14 == null) goto L19;
        r14.y = getWindowListHelper();
    L19:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r15 = getDynamicWidget();
        if (r15 == null) goto L23;
        r15.fd(getWindowListHelper());
        return;
    L23:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview, com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void h(SeiAppData r2) {
        Intrinsics.checkNotNullParameter(r2, "seiAppData");
        super.h(r2);
        com.bytedance.android.live.liveinteract.feed.datamerge.m r0 = this.I;
        if (r0 == null) goto L6;
        r0.e(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview, com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updatePreloadRoomLinkMicSyncData(RoomLinkMicSyncData r2) {
        Intrinsics.checkNotNullParameter(r2, "wrds");
        ue0.b r0 = this.J;
        if (r0 == null) goto L6;
        r0.g(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview, com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void o(IPreviewMultiLinkOuterConfigProvider r4, te0.a r5) {
        Intrinsics.checkNotNullParameter(r4, "configOuterProvider");
        Intrinsics.checkNotNullParameter(r5, "configInnerProvider");
        super.o(r4, r5);
        ue0.c r6 = getConfigInnerProvider().f();
        if (r6 == null) goto L5;
        this.I = new com.bytedance.android.live.liveinteract.feed.datamerge.m(getConfigOuterProvider().getRoom(), new i0(this));
        ArrayList r7 = new ArrayList();
        com.bytedance.android.live.liveinteract.feed.datamerge.m r0 = this.I;
        Intrinsics.checkNotNull(r0);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "proxy");
        r0.a = r6;
        r7.add(r0);
        this.J = new ue0.b(r7, getConfigOuterProvider());
        com.bytedance.android.live.liveinteract.feed.datamerge.m r8 = this.I;
        Intrinsics.checkNotNull(r8);
        r6.u(r8);
        ue0.b r9 = this.J;
        Intrinsics.checkNotNull(r9);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r6, "proxy");
        r9.a = r6;
        r6.u(r9);
    L5:
        this.K = new com.bytedance.android.live.liveinteract.widget.widget.v(getContext(), getFeedDataCenter(), new a(this));
    }

    public MultiLinkLinkRoomFightFeedPreview(Context r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final void updateViewInLiveBg(String r2, JsonObject r3, ih0.h r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "updateCallback");
        com.bytedance.android.live.liveinteract.widget.widget.v r0 = this.K;
        if (r0 == null) goto L6;
        r0.b(r2, r3, r4);
        return;
    }
}
