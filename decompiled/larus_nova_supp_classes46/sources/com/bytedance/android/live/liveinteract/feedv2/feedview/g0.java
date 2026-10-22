package com.bytedance.android.live.liveinteract.feedv2.feedview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.bytedance.android.livesdkapi.feed.IKtvRoomFeedView;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g0 implements b {
    public IPreviewMultiLinkOuterConfigProvider a;
    public te0.a b;
    public IKtvRoomFeedView c;
    public final CompositeDisposable d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void f(qb r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final String getFeedViewName() {
        return "MultiLinkKtvRoomFeedPreview";
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void j(cj r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void m(int r1, int r2, List<Integer> r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onLivePlayerVideoSizeChanged() {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void removeEffectView() {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void s() {
    }

    private final Context getContext() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        return r0.getContext();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.b
    public final Object getCurrentSeiParseResultData() {
        IKtvRoomFeedView r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentSeiParseResultData();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.b
    public final String getCurrentSingUserIdString() {
        IKtvRoomFeedView r0 = this.c;
        if (r0 == null) goto L6;
        String r1 = r0.getCurrentSingUserIdString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final FrameLayout.LayoutParams getKtvComponentLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -2);
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.b
    public final HashMap<String, Object> getKtvEnterRoomExtraParam() {
        IKtvRoomFeedView r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvEnterRoomExtraParam();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.b
    public final Object getKtvSeiModelObject() {
        IKtvRoomFeedView r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvSeiModelObject();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final View getViewCompat() {
        IKtvRoomFeedView r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getViewCompat();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderPause() {
        IKtvRoomFeedView r0 = this.c;
        if (r0 == null) goto L6;
        r0.onViewHolderPause();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderResume() {
        IKtvRoomFeedView r0 = this.c;
        if (r0 == null) goto L6;
        r0.onViewHolderResume();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderSelected() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, "MultiLinkKtvRoomFeedPreview", hashCode(), "onViewHolderSelected", false, 8, null);
        IKtvRoomFeedView r1 = this.c;
        if (r1 == null) goto L9;
        r1.onViewHolderSelected();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderUnSelected() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, "MultiLinkKtvRoomFeedPreview", hashCode(), "onViewHolderUnSelected", false, 8, null);
        IKtvRoomFeedView r1 = this.c;
        if (r1 == null) goto L9;
        r1.onViewHolderUnSelected();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void release() {
        this.d.dispose();
        IKtvRoomFeedView r0 = this.c;
        if (r0 == null) goto L6;
        r0.reset();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.b
    public final void resetKtvSeiModelObject() {
        IKtvRoomFeedView r0 = this.c;
        if (r0 == null) goto L6;
        r0.resetKtvSeiModelObject();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.b
    public final void setRenderViewBitmapToMockView() {
        IKtvRoomFeedView r0 = this.c;
        if (r0 == null) goto L6;
        r0.setRenderViewBitmapToMockView();
        return;
    }

    public g0() {
        this.d = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "seiString");
        IKtvRoomFeedView r0 = this.c;
        if (r0 == null) goto L6;
        r0.onSeiUpdatedRaw(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void h(SeiAppData r2) {
        Intrinsics.checkNotNullParameter(r2, "seiAppData");
        IKtvRoomFeedView r0 = this.c;
        if (r0 == null) goto L6;
        r0.onSeiUpdated(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.b
    public final void onKtvVideoStateChange(ld0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "seiData");
        IKtvRoomFeedView r0 = this.c;
        if (r0 == null) goto L6;
        r0.onKtvVideoStateChange(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateMvControllerSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updatePreloadRoomLinkMicSyncData(RoomLinkMicSyncData r2) {
        Intrinsics.checkNotNullParameter(r2, "wrds");
        Intrinsics.checkNotNullParameter(r2, "wrds");
        Intrinsics.checkNotNullParameter(r2, "wrds");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateRadioSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateRadioTextSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateSpeechRecognitionSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateSpeechRhythmSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateSubtitleSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void b(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "syncKey");
        IKtvRoomFeedView r0 = this.c;
        if (r0 == null) goto L6;
        r0.onWrdsDataUpdate(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void insertEffectView(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void o(IPreviewMultiLinkOuterConfigProvider r10, te0.a r11) {
        Intrinsics.checkNotNullParameter(r10, "configOuterProvider");
        Intrinsics.checkNotNullParameter(r11, "configInnerProvider");
        this.a = r10;
        this.b = r11;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r10, "MultiLinkKtvRoomFeedPreview", hashCode(), "initView", false, 8, null);
        LinkFeedTypeConstant.Companion r12 = LinkFeedTypeConstant.Companion;
        IPreviewMultiLinkOuterConfigProvider r13 = this.a;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        boolean r14 = !r12.isDouyinFullScreen(r13.getShowFrom());
        IKtvService r15 = jc1.k.f(IKtvService.class);
        IRenderView r2 = null;
        if (r15 == null) goto L14;
        Context r3 = getContext();
        IPreviewMultiLinkOuterConfigProvider r4 = this.a;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L13:
        IInteractFeedView r16 = r15.getKtvRoomFeedView(r3, r14, r4.getShowFrom());
    L15:
        if (r16 == null) goto L83;
        IKtvRoomFeedView r17 = (IKtvRoomFeedView) r16;
        this.c = r17;
        IPreviewMultiLinkOuterConfigProvider r18 = this.a;
        if (r18 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L19:
        r17.updateMessageHub(r18.getMessageHub());
        int r19 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;
        IPreviewMultiLinkOuterConfigProvider r110 = this.a;
        if (r110 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L23:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r110.getShowFrom()) == false) goto L32;
        te0.a r111 = this.b;
        if (r111 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L27:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.h r112 = r111.c();
        if (r112 == null) goto L40;
        IKtvRoomFeedView r113 = this.c;
        if (r113 == null) goto L40;
        r113.setDataMergeCenterV2(r112);
    L40:
        IKtvRoomFeedView r114 = this.c;
        if (r114 == null) goto L49;
        IPreviewMultiLinkOuterConfigProvider r115 = this.a;
        if (r115 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L45:
        String r116 = r115.getEnterFromMerge();
        IPreviewMultiLinkOuterConfigProvider r5 = this.a;
        if (r5 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L48:
        r114.updateEnterFrom(r116, r5.getEnterMethod());
    L49:
        IKtvRoomFeedView r117 = this.c;
        if (r117 == null) goto L55;
        IPreviewMultiLinkOuterConfigProvider r118 = this.a;
        if (r118 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L54:
        r117.updateRoom(r118.getRoom());
    L55:
        IKtvRoomFeedView r119 = this.c;
        if (r119 == null) goto L61;
        IPreviewMultiLinkOuterConfigProvider r120 = this.a;
        if (r120 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L60:
        r119.setLivePlayerContainerAbility(r120.getPlayerContainerAbility());
    L61:
        IKtvRoomFeedView r121 = this.c;
        if (r121 == null) goto L71;
        IPreviewMultiLinkOuterConfigProvider r122 = this.a;
        if (r122 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L66:
        if (r122 == null) goto L70;
        LivePlayerView r123 = r122.getLivePlayerView();
        if (r123 == null) goto L70;
        r2 = r123.getRenderView();
    L70:
        r121.setLivePlayerView(r2);
    L71:
        te0.a r124 = this.b;
        if (r124 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L74:
        ue0.c r125 = r124.f();
        if (r125 == null) goto L84;
        BehaviorSubject<List<ch0.e>> r126 = r125.b;
        if (r126 == null) goto L85;
        Disposable r127 = r126.subscribe(new h0(this));
        if (r127 == null) goto L86;
        RxUtilKt.c(r127, this.d);
        return;
    L86:
        return;
    L85:
        return;
    L84:
        return;
    L32:
        te0.a r128 = this.b;
        if (r128 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L35:
        ue0.c r129 = r128.f();
        if (r129 == null) goto L40;
        IKtvRoomFeedView r130 = this.c;
        if (r130 == null) goto L40;
        r130.setDataMergeCenter(r129);
        goto L40
    L83:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.feed.IKtvRoomFeedView");
    L14:
        r16 = null;
        goto L15
    }
}
