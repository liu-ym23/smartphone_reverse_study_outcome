package com.bytedance.android.live.liveinteract.feed;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.liveinteract.feed.datamerge.LinkMicGameFeedViewWindowListHelper;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/feed/MultiLinkGameFeedView;", "Lcom/bytedance/android/live/liveinteract/feed/CommonMultiLinkFeedView;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkGameFeedView extends CommonMultiLinkFeedView {
    public boolean k0;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
        public final /* synthetic */ MultiLinkGameFeedView a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.commonwindow.i b;

            public a(b r1, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.y(this.b.a);     // Catch: Throwable -> L6
                com.bytedance.android.live.liveinteract.feed.datamerge.i r0 = this.a.a.getWindowListHepler();     // Catch: Throwable -> L6
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

        public b(MultiLinkGameFeedView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2) {
            Intrinsics.checkNotNullParameter(r2, "request");
            ALogger.e("MultiLinkGameFeedView", "onSeiUpdated loadLayoutConfig onFailed ");
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r3) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r3, "response");
            ALogger.i("MultiLinkGameFeedView", "onSeiUpdated loadLayoutConfig success ");
            MainThreadPostUtils.e(new a(this, r3));
        }
    }

    public static final class c implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
        public final /* synthetic */ MultiLinkGameFeedView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2) {
            Intrinsics.checkNotNullParameter(r2, "request");
            ALogger.e("MultiLinkGameFeedView", "tryAdjustWindowUI loadLayoutConfig onFailed");
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r3, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r4) {
            Intrinsics.checkNotNullParameter(r3, "request");
            Intrinsics.checkNotNullParameter(r4, "response");
            ALogger.i("MultiLinkGameFeedView", "tryAdjustWindowUI loadLayoutConfig success");
            this.a.j(this.b, this.c, r4.a);
        }

        public c(MultiLinkGameFeedView r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.feed.CommonMultiLinkFeedView
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.CommonMultiLinkFeedView
    public /* bridge */ /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View r0 = getRootView();
        if (r0 == null) goto L8;
        View r1 = r0.findViewById(2131392386);
        if (r1 == null) goto L9;
        ALogger.i("MultiLinkGameFeedView", "show videoTalkCover");
        r1.setVisibility(0);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.CommonMultiLinkFeedView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        View r0 = getRootView();
        if (r0 == null) goto L8;
        View r1 = r0.findViewById(2131392386);
        if (r1 == null) goto L9;
        ALogger.i("MultiLinkGameFeedView", "hide videoTalkCover");
        r1.setVisibility(8);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.CommonMultiLinkFeedView
    public final com.bytedance.android.live.liveinteract.feed.datamerge.i A(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r11) {
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
        com.bytedance.android.live.liveinteract.plantform.datamerge.k r6 = new com.bytedance.android.live.liveinteract.plantform.datamerge.k(r2 + r1);
        return new LinkMicGameFeedViewWindowListHelper(getMRoom(), getFeedDataCenter(), r11, r6, getFeedViewDataMergeCenter(), getShowFrom(), new MultiLinkGameFeedView$windowListHelperProvider$1(this));
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.feed.CommonMultiLinkFeedView
    public final void onSeiUpdated(SeiAppData r5) {
        super.onSeiUpdated(r5);
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getPositionStashStatus() != 2) goto L7;
        boolean r0 = true;
    L9:
        if (r0 == this.k0) goto L13;
        ALogger.i("MultiLinkGameFeedView", "onSeiUpdated, isMicSeatStash change from " + this.k0 + " to " + r0 + ", status: " + r5.getPositionStashStatus());
        this.k0 = r0;
        int r6 = qi0.b.a;
        qi0.b.a(r0, getContainerWidth(), getContainerHeight(), getFeedDataCenter(), new b(this));
        return;
    L13:
        return;
    L7:
        r0 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.feed.CommonMultiLinkFeedView
    public final void w(int r6, int r7) {
        if (getHasAdjustWindowUI() == false) goto L5;
        return;
    L5:
        setHasAdjustWindowUI(true);
        int r0 = qi0.b.a;
        qi0.b.a(this.k0, getContainerWidth(), getContainerHeight(), getFeedDataCenter(), new c(this, r6, r7));
    }

    public MultiLinkGameFeedView(Context r8, SeiAppData r9, int r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "seiAppData");
        super(r8, r10, r11, r12, null, 0);
        if (r9.getPositionStashStatus() != 2) goto L5;
        boolean r13 = true;
    L6:
        this.k0 = r13;
        ALogger.i("MultiLinkGameFeedView", "init, isCurrentMicSeatStash: " + this.k0);
        return;
    L5:
        r13 = false;
        goto L6
    }
}
