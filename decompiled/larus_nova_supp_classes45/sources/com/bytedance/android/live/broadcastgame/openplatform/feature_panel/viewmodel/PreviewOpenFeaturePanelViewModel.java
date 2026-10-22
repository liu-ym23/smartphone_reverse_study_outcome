package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel;

import a20.d;
import android.view.MotionEvent;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import e10.a;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u001b\u0010\n\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR%\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\f\u0012\u0002\b\u00030\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewmodel/PreviewOpenFeaturePanelViewModel;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewmodel/AbsOpenFeaturePanelViewModel;", "", "isInLive", "isHiding", "La20/d;", "featureIconBehaviorController$delegate", "Lkotlin/Lazy;", "getFeatureIconBehaviorController", "()La20/d;", "featureIconBehaviorController", "Le10/a;", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "openFeatureFilter$delegate", "getOpenFeatureFilter", "()Le10/a;", "openFeatureFilter", "Landroidx/lifecycle/MutableLiveData;", "showTitleBarSearchBtn", "Landroidx/lifecycle/MutableLiveData;", "getShowTitleBarSearchBtn", "()Landroidx/lifecycle/MutableLiveData;", "setShowTitleBarSearchBtn", "(Landroidx/lifecycle/MutableLiveData;)V", "showTitleBarSettingBtn", "getShowTitleBarSettingBtn", "setShowTitleBarSettingBtn", "", "showPopupView", "getShowPopupView", "setShowPopupView", "Landroid/view/MotionEvent;", "onTouch", "getOnTouch", "setOnTouch", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewOpenFeaturePanelViewModel extends AbsOpenFeaturePanelViewModel {
    private final Lazy featureIconBehaviorController$delegate;
    private MutableLiveData<MotionEvent> onTouch;
    private final Lazy openFeatureFilter$delegate;
    private MutableLiveData<String> showPopupView;
    private MutableLiveData<Boolean> showTitleBarSearchBtn;
    private MutableLiveData<Boolean> showTitleBarSettingBtn;

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel
    public d getFeatureIconBehaviorController() {
        return (d) this.featureIconBehaviorController$delegate.getValue();
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel
    public a<InteractEntranceCell, ?> getOpenFeatureFilter() {
        return (a) this.openFeatureFilter$delegate.getValue();
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel
    public boolean isHiding() {
        return false;
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel
    public boolean isInLive() {
        return false;
    }

    public PreviewOpenFeaturePanelViewModel() {
        this.featureIconBehaviorController$delegate = InfraKotlinExtsKt.mainThreadLazy(new PreviewOpenFeaturePanelViewModel$featureIconBehaviorController$2(this));
        this.openFeatureFilter$delegate = InfraKotlinExtsKt.mainThreadLazy(PreviewOpenFeaturePanelViewModel$openFeatureFilter$2.INSTANCE);
        this.showTitleBarSearchBtn = new MutableLiveData();
        this.showTitleBarSettingBtn = new MutableLiveData();
        this.showPopupView = new MutableLiveData();
        this.onTouch = new MutableLiveData();
    }

    public final MutableLiveData<MotionEvent> getOnTouch() {
        return this.onTouch;
    }

    public final MutableLiveData<String> getShowPopupView() {
        return this.showPopupView;
    }

    public final MutableLiveData<Boolean> getShowTitleBarSearchBtn() {
        return this.showTitleBarSearchBtn;
    }

    public final MutableLiveData<Boolean> getShowTitleBarSettingBtn() {
        return this.showTitleBarSettingBtn;
    }

    public final void setOnTouch(MutableLiveData<MotionEvent> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.onTouch = r2;
    }

    public final void setShowPopupView(MutableLiveData<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.showPopupView = r2;
    }

    public final void setShowTitleBarSearchBtn(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.showTitleBarSearchBtn = r2;
    }

    public final void setShowTitleBarSettingBtn(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.showTitleBarSettingBtn = r2;
    }
}
