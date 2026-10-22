package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.e0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickDialogTopContainer;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel.GiftGroupViewModel;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelMonitorService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.scope.o;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftPanelViewModel extends com.bytedance.android.livesdk.gift.framework.base.a<GiftPanelState, GiftAction> implements o {
    public final e0 v;
    public final e0 w;
    public final GiftPanelMonitorService x;
    public final OpenDialogService y;

    public final int U() {
        x.e.getClass();
        return x.d.c();
    }

    public final boolean e1() {
        x.e.getClass();
        return x.d.d();
    }

    public final void onStart() {
        GiftPanelMonitorService r0 = this.x;
        e0 r1 = this.v;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "tracer");
        r0.D = r1;
    }

    public final void onStop() {
        jy0.b.d("ttlive_gift", "panel onStop");
        x r0 = x.e;
        r0.getClass();
        if (x.d.e() == false) goto L6;
        v02.b.a(0, ((Boolean) x.c.getValue(r0, x.a[1])).booleanValue(), new AnonymousClass1(this), 3);
        return;
    }

    public final mb.b R() {
        return this.w;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftPanelState();
    }

    public final void s1(l0 r6, MVIState r7, p r8, Function1 r9) {
        GiftAction r10 = (GiftAction) r8;
        Intrinsics.checkNotNullParameter(r6, "$this$reduce");
        Intrinsics.checkNotNullParameter((GiftPanelState) r7, "state");
        Intrinsics.checkNotNullParameter(r10, "action");
        Intrinsics.checkNotNullParameter(r9, "dispatchReduce");
        long r11 = System.currentTimeMillis();
        if ((r10 instanceof ClickDialogTopContainer) == false) goto L5;
        OpenDialogService.d(this.y, 0, "top_container", 1);
    L5:
        r9.invoke(r10);
        this.x.c(r10, r11);
    }

    public GiftPanelViewModel(GiftMVIReceiverViewModel r18, GiftMVIListViewModel r19, GiftMVITabViewModel r20, GiftMVIRechargeViewModel r21, GiftMVITopViewModel r23, GiftMVIMinorsNoticeViewModel r24, GiftMVIDSNoticeViewModel r25, GiftMVITopExchangeViewModel r26, GiftPanelMonitorService r27, GiftMVIUserInfoViewModel r28, GiftMVITopPanelViewModel r29, GiftMVIDynamicPanelViewModel r210, GiftMVITopicViewModel r30, GiftMVIDetailViewModel r31, GiftGroupViewModel r33, GiftMVISearchViewModel r34, OpenDialogService r35) {
        Intrinsics.checkNotNullParameter(r18, "receiverVM");
        Intrinsics.checkNotNullParameter(r19, "listVM");
        Intrinsics.checkNotNullParameter(r20, "tabVM");
        Intrinsics.checkNotNullParameter(r21, "rechargeVM");
        Intrinsics.checkNotNullParameter(r23, "topVM");
        Intrinsics.checkNotNullParameter(r24, "noticeVM");
        Intrinsics.checkNotNullParameter(r25, "dsNoticeVM");
        Intrinsics.checkNotNullParameter(r26, "topExchangeVM");
        Intrinsics.checkNotNullParameter(r27, "panelMonitorService");
        Intrinsics.checkNotNullParameter(r28, "userInfoViewModel");
        Intrinsics.checkNotNullParameter(r29, "topPanelViewModel");
        Intrinsics.checkNotNullParameter(r210, "dynamicPanelViewModel");
        Intrinsics.checkNotNullParameter(r30, "topicViewModel");
        Intrinsics.checkNotNullParameter(r31, "detailViewModel");
        Intrinsics.checkNotNullParameter(r33, "groupViewModel");
        Intrinsics.checkNotNullParameter(r34, "giftSearchViewModel");
        Intrinsics.checkNotNullParameter(r35, "dialogService");
        super(CollectionsKt.listOf(new Object[]{r18, r19, r20, r21, r23, r24, r25, r26, r28, r29, r210, r30, r31, r33, r34}));
        this.x = r27;
        this.y = r35;
        e0 r0 = new e0();
        this.v = r0;
        this.w = r0;
        f0();
    }
}
