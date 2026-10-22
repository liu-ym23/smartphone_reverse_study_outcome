package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel;

import a20.b;
import a20.d;
import c20.c;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.h0;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import e10.a;
import f10.f;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b7\u00108J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016JT\u0010\u0016\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0012\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R%\u0010*\u001a\f\u0012\u0004\u0012\u00020&\u0012\u0002\b\u00030%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010!\u001a\u0004\b(\u0010)R\"\u0010+\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R*\u00101\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewmodel/LiveOpenFeaturePanelViewModel;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewmodel/AbsOpenFeaturePanelViewModel;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "", "isInLive", "isHiding", "La20/b;", "cb", "", "onBehaviorCallbackInit", "Lc20/c;", "data", "showOpenFeatureListData", "", "Lf10/f;", "groupIconList", "", "groupNameList", "tabIconList", "tabNameList", "isFromCache", "showOpenFeatureListOldData", "t", "onChanged", "openPlatformBehaviorCallback", "La20/b;", "getOpenPlatformBehaviorCallback$livebroadcastgame_impl_saasRelease", "()La20/b;", "setOpenPlatformBehaviorCallback$livebroadcastgame_impl_saasRelease", "(La20/b;)V", "La20/d;", "featureIconBehaviorController$delegate", "Lkotlin/Lazy;", "getFeatureIconBehaviorController", "()La20/d;", "featureIconBehaviorController", "Le10/a;", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "openFeatureFilter$delegate", "getOpenFeatureFilter", "()Le10/a;", "openFeatureFilter", "disablePanelDragDown", "Z", "getDisablePanelDragDown$livebroadcastgame_impl_saasRelease", "()Z", "setDisablePanelDragDown$livebroadcastgame_impl_saasRelease", "(Z)V", "highLightArray", "Ljava/util/List;", "getHighLightArray", "()Ljava/util/List;", "setHighLightArray", "(Ljava/util/List;)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenFeaturePanelViewModel extends AbsOpenFeaturePanelViewModel implements Observer<KVData> {
    private boolean disablePanelDragDown;
    private final Lazy featureIconBehaviorController$delegate;
    private List<String> highLightArray;
    private final Lazy openFeatureFilter$delegate;
    private b openPlatformBehaviorCallback;

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel
    public d getFeatureIconBehaviorController() {
        return (d) this.featureIconBehaviorController$delegate.getValue();
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel
    public a<InteractEntranceCell, ?> getOpenFeatureFilter() {
        return (a) this.openFeatureFilter$delegate.getValue();
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel
    public boolean isInLive() {
        return true;
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel
    public boolean isHiding() {
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L11;
        n r1 = r0.getShelfInfo();
        if (r1 == null) goto L11;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
        if (r2 == null) goto L11;
        if (r2.punishStatus != 1) goto L11;
        return true;
    L11:
        return false;
    }

    public LiveOpenFeaturePanelViewModel() {
        this.featureIconBehaviorController$delegate = InfraKotlinExtsKt.mainThreadLazy(new LiveOpenFeaturePanelViewModel$featureIconBehaviorController$2(this));
        this.openFeatureFilter$delegate = InfraKotlinExtsKt.mainThreadLazy(LiveOpenFeaturePanelViewModel$openFeatureFilter$2.INSTANCE);
    }

    public final boolean getDisablePanelDragDown$livebroadcastgame_impl_saasRelease() {
        return this.disablePanelDragDown;
    }

    public final List<String> getHighLightArray() {
        return this.highLightArray;
    }

    public final b getOpenPlatformBehaviorCallback$livebroadcastgame_impl_saasRelease() {
        return this.openPlatformBehaviorCallback;
    }

    public final void onBehaviorCallbackInit(b r3) {
        Intrinsics.checkNotNullParameter(r3, "cb");
        this.openPlatformBehaviorCallback = r3;
        if (r3 == null) goto L7;
        DataCenter r4 = r3.d();
        if (r4 == null) goto L7;
        r4.observe("data_link_state", this);
    L7:
        b r5 = this.openPlatformBehaviorCallback;
        if (r5 == null) goto L12;
        DataCenter r6 = r5.d();
        if (r6 == null) goto L12;
        r6.observe("data_join_channel_finished", this);
    L12:
        a<InteractEntranceCell, ?> r7 = getOpenFeatureFilter();
        DataCenter r1 = null;
        if ((r7 instanceof h0) == true) goto L15;
        r7 = null;
    L15:
        h0 r8 = (h0) r7;
        if (r8 == null) goto L22;
        b r0 = this.openPlatformBehaviorCallback;
        if (r0 == null) goto L20;
        r1 = r0.d();
    L20:
        r8.a = r1;
        return;
    }

    public void onChanged(KVData r4) {
        String r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.getKey();
    L7:
        if (Intrinsics.areEqual(r1, "data_link_state") == true) goto L12;
        if (r4 == null) goto L11;
        r0 = r4.getKey();
    L11:
        if (Intrinsics.areEqual(r0, "data_join_channel_finished") == true) goto L12;
        return;
    L12:
        getFeatureListHandler().e();
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void setDisablePanelDragDown$livebroadcastgame_impl_saasRelease(boolean r1) {
        this.disablePanelDragDown = r1;
    }

    public final void setHighLightArray(List<String> r1) {
        this.highLightArray = r1;
    }

    public final void setOpenPlatformBehaviorCallback$livebroadcastgame_impl_saasRelease(b r1) {
        this.openPlatformBehaviorCallback = r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel
    public void showOpenFeatureListData(c r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        b r0 = this.openPlatformBehaviorCallback;
        if (r0 == null) goto L5;
        r0.e();
    L5:
        super.showOpenFeatureListData(r2);
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel
    public void showOpenFeatureListOldData(List<List<f>> r2, List<String> r3, List<List<f>> r4, List<String> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "groupIconList");
        Intrinsics.checkNotNullParameter(r3, "groupNameList");
        Intrinsics.checkNotNullParameter(r4, "tabIconList");
        Intrinsics.checkNotNullParameter(r5, "tabNameList");
        b r0 = this.openPlatformBehaviorCallback;
        if (r0 == null) goto L5;
        r0.e();
    L5:
        super.showOpenFeatureListOldData(r2, r3, r4, r5, r6);
    }
}
