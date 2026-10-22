package com.bytedance.android.live.liveinteract.feedv2.feedview;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.liveinteract.feed.datamerge.LinkMicGameFeedViewWindowListHelper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.LinkMicGameWindowHelperV2;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.model.ParseSeiData;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/feedv2/feedview/MultiLinkGameFeedPreview;", "Lcom/bytedance/android/live/liveinteract/feedv2/feedview/MultiLinkCommonVideoFeedPreview;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkGameFeedPreview extends MultiLinkCommonVideoFeedPreview {
    public boolean I;
    public boolean J;
    public com.bytedance.android.live.liveinteract.feed.datamerge.m K;
    public ue0.b L;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
        public final /* synthetic */ MultiLinkGameFeedPreview a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.commonwindow.i b;

            public a(b r1, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.L(this.b.a);     // Catch: Throwable -> L6
                com.bytedance.android.live.liveinteract.plantform.datamerge.a r0 = this.a.a.getWindowListHelper();     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.u();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public b(MultiLinkGameFeedPreview r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2) {
            Intrinsics.checkNotNullParameter(r2, "request");
            ALogger.e("MultiLinkGameFeedPreview", "onSeiUpdated loadLayoutConfig onFailed ");
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r3) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r3, "response");
            ALogger.i("MultiLinkGameFeedPreview", "onSeiUpdated loadLayoutConfig success ");
            MainThreadPostUtils.e(new a(this, r3));
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview
    public final boolean E() {
        return false;
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
        ue0.b r0 = this.L;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View r0 = getRootView();
        if (r0 == null) goto L8;
        View r1 = r0.findViewById(2131392386);
        if (r1 == null) goto L9;
        ALogger.i("MultiLinkGameFeedPreview", "show videoTalkCover");
        r1.setVisibility(0);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        View r0 = getRootView();
        if (r0 == null) goto L8;
        View r1 = r0.findViewById(2131392386);
        if (r1 == null) goto L9;
        ALogger.i("MultiLinkGameFeedPreview", "hide videoTalkCover");
        r1.setVisibility(8);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview, com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void release() {
        super.release();
        ue0.c r0 = getConfigInnerProvider().f();
        ue0.b r1 = this.L;
        if (r1 == null) goto L6;
        if (r0 == null) goto L6;
        r0.v(r1);
    L6:
        com.bytedance.android.live.liveinteract.feed.datamerge.m r2 = this.K;
        if (r2 == null) goto L11;
        if (r0 == null) goto L12;
        r0.v(r2);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview
    public final void C(final com.bytedance.android.live.liveinteract.plantform.commonwindow.m r11) {
        Intrinsics.checkNotNullParameter(r11, "layoutConfig");
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r0 = r11.h();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.e> r3 = r11.k();
        if (r3 == null) goto L9;
        r1 = r3.size();
    L9:
        final com.bytedance.android.live.liveinteract.plantform.datamerge.k r6 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(r2 + r1);
        ue0.c r7 = getConfigInnerProvider().f();
        if (r7 == null) goto L12;
        setWindowListHelper(new LinkMicGameFeedViewWindowListHelper(getConfigOuterProvider().getRoom(), getFeedDataCenter(), r11, r6, r7, getConfigOuterProvider().getShowFrom(), new MultiLinkGameFeedPreview$initWindowListHelper$$inlined$let$lambda$1(this, r11, r6)));
    L12:
        getConfigOuterProvider().printALogger("MultiLinkGameFeedPreview", hashCode(), "initWindowListHelper, dataMergeCenter = " + getConfigInnerProvider().f() + ", windowListHelper = " + getWindowListHelper(), true);
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r12 = getWindowListHelper();
        if (r12 == null) goto L22;
        ((com.bytedance.android.live.liveinteract.feed.datamerge.i) r12).x(getConfigOuterProvider().getRoom());
        BaseLinkSeatWindowView r13 = getBaseWindowView();
        if (r13 == null) goto L17;
        r13.y = getWindowListHelper();
    L17:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r14 = getDynamicWidget();
        if (r14 == null) goto L23;
        r14.fd(getWindowListHelper());
        return;
    L23:
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.feed.datamerge.FeedViewWindowListHelper");
    L5:
        r2 = 0;
        goto L6
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
        eh0.b r9 = getConfigInnerProvider().Y3();
        if (r8 == null) goto L13;
        if (r9 == null) goto L13;
        setWindowListHelper(new LinkMicGameWindowHelperV2(getConfigOuterProvider().getRoom(), getFeedDataCenter(), false, r12, r7, r8, r9, getConfigOuterProvider().getShowFrom()));
    L13:
        getConfigOuterProvider().printALogger("MultiLinkGameFeedPreview", hashCode(), "initWindowListHelper, dataMergeCenter = " + getConfigInnerProvider().f() + ", windowListHelper = " + getWindowListHelper(), true);
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
    public final void h(SeiAppData r7) {
        Intrinsics.checkNotNullParameter(r7, "seiAppData");
        super.h(r7);
        com.bytedance.android.live.liveinteract.feed.datamerge.m r0 = this.K;
        if (r0 == null) goto L6;
        r0.e(r7);
    L6:
        if (r7.getPositionStashStatus() != 2) goto L8;
        boolean r1 = true;
    L10:
        if (r1 == this.I) goto L12;
    L13:
        this.J = true;
        JsonObject r2 = new JsonObject();
        if (r1 == false) goto L16;
        String r3 = "1";
    L17:
        r2.addProperty("fold_status", r3);
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r4 = getDynamicWidget();
        if (r4 == null) goto L21;
        r4.Dk("seat", "barrage_layout_data", r2, false);
    L21:
        if (r1 == this.I) goto L24;
        ALogger.i("MultiLinkGameFeedPreview", "onSeiUpdated, isMicSeatStash change from " + this.I + " to " + r1 + ", status: " + r7.getPositionStashStatus());
        this.I = r1;
        int r8 = qi0.b.a;
        qi0.b.a(r1, getConfigInnerProvider().getContainerWidth(), getConfigInnerProvider().l(), getFeedDataCenter(), new b(this));
        return;
    L24:
        return;
    L16:
        r3 = "0";
        goto L17
    L12:
        if (this.J == true) goto L21;
    L8:
        r1 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview, com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updatePreloadRoomLinkMicSyncData(RoomLinkMicSyncData r2) {
        Intrinsics.checkNotNullParameter(r2, "wrds");
        ue0.b r0 = this.L;
        if (r0 == null) goto L6;
        r0.g(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview
    public final void B(int r4, int r5) {
        int r6 = qi0.b.a;
        qi0.b.a(this.I, getConfigInnerProvider().getContainerWidth(), getConfigInnerProvider().l(), getFeedDataCenter(), new d0(this));
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview, com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void o(IPreviewMultiLinkOuterConfigProvider r4, te0.a r5) {
        Intrinsics.checkNotNullParameter(r4, "configOuterProvider");
        Intrinsics.checkNotNullParameter(r5, "configInnerProvider");
        super.o(r4, r5);
        ue0.c r6 = getConfigInnerProvider().f();
        if (r6 == null) goto L6;
        this.K = new com.bytedance.android.live.liveinteract.feed.datamerge.m(getConfigOuterProvider().getRoom(), new e0(this));
        ArrayList r7 = new ArrayList();
        com.bytedance.android.live.liveinteract.feed.datamerge.m r0 = this.K;
        Intrinsics.checkNotNull(r0);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "proxy");
        r0.a = r6;
        r7.add(r0);
        this.L = new ue0.b(r7, getConfigOuterProvider());
        com.bytedance.android.live.liveinteract.feed.datamerge.m r8 = this.K;
        Intrinsics.checkNotNull(r8);
        r6.u(r8);
        ue0.b r9 = this.L;
        Intrinsics.checkNotNull(r9);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r6, "proxy");
        r9.a = r6;
        r6.u(r9);
        return;
    }

    public MultiLinkGameFeedPreview(Context r2, ParseSeiData r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "parseSeiData");
        boolean r0 = false;
        super(r2, r4, r5, 0);
        if (r3.getPositionStashStatus() != 2) goto L5;
        r0 = true;
    L5:
        this.I = r0;
        ALogger.i("MultiLinkGameFeedPreview", "init, isCurrentMicSeatStash: " + this.I);
    }
}
