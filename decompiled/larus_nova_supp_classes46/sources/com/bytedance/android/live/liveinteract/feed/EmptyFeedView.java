package com.bytedance.android.live.liveinteract.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.bytedance.android.livesdkapi.feed.IKtvInteractFeedView;
import com.bytedance.android.livesdkapi.feed.IMultiFeedView;
import com.bytedance.android.livesdkapi.feed.IPkFeedView;
import com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility;
import com.bytedance.android.livesdkapi.feed.ImCacheUnit;
import com.bytedance.android.livesdkapi.feed.data.FeedViewRoomInfoStore;
import com.bytedance.android.livesdkapi.feed.data.IPkExposeData;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.InteractFeedActionCaller;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.android.livesdkapi.view.IRenderView;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/liveinteract/feed/EmptyFeedView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdkapi/feed/IInteractFeedView;", "", "getFeedViewName", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", "renderView", "", "setLivePlayerView", "Lcom/bytedance/android/livesdkapi/feed/IPreviewPlayerContainerAbility;", "playerContainerAbility", "setLivePlayerContainerAbility", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "livePlayerClient", "setLivePlayerClient", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EmptyFeedView extends FrameLayout implements IInteractFeedView {
    public final HSImageView a;

    public EmptyFeedView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public EmptyFeedView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public String getFeedViewName() {
        return "EmptyFeedView";
    }

    public final void onOnlineListChanged() {
    }

    public final void onSeiUpdated(SeiAppData r1) {
    }

    public final void onViewHolderSelected() {
    }

    public final void onViewHolderUnSelected() {
    }

    public final void reset() {
    }

    public void setLivePlayerClient(ILivePlayerClient r1) {
    }

    public void setLivePlayerContainerAbility(IPreviewPlayerContainerAbility r1) {
    }

    public void setLivePlayerView(IRenderView r1) {
    }

    public final void updateEnterFrom(String r1, String r2) {
    }

    public final void updateTalkState(HashMap<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
    }

    public HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        return IInteractFeedView.DefaultImpls.getChatRoomEnterRoomExtraParam(this);
    }

    public FeedViewRoomInfoStore getFeedViewRoomInfoStore() {
        return IInteractFeedView.DefaultImpls.getFeedViewRoomInfoStore(this);
    }

    public IKtvInteractFeedView getIKtvInteractFeedView() {
        return IInteractFeedView.DefaultImpls.getIKtvInteractFeedView(this);
    }

    public IMultiFeedView getIMultiFeedView() {
        return IInteractFeedView.DefaultImpls.getIMultiFeedView(this);
    }

    public IPkFeedView getIPkFeedView() {
        return IInteractFeedView.DefaultImpls.getIPkFeedView(this);
    }

    public List<String> getImCacheTags() {
        return IInteractFeedView.DefaultImpls.getImCacheTags(this);
    }

    public IKtvComponentFeedView getKtvComponentFeedView() {
        return IInteractFeedView.DefaultImpls.getKtvComponentFeedView(this);
    }

    public List<ILinkPlayerInfoBridge> getOnlineList() {
        return IInteractFeedView.DefaultImpls.getOnlineList(this);
    }

    public View getViewCompat() {
        return IInteractFeedView.DefaultImpls.getViewCompat(this);
    }

    public final Observable<IPkExposeData> observeFeedViewExposeData() {
        return IInteractFeedView.DefaultImpls.observeFeedViewExposeData(this);
    }

    public final void onViewHolderPause() {
        IInteractFeedView.DefaultImpls.onViewHolderPause(this);
    }

    public final void onViewHolderResume() {
        IInteractFeedView.DefaultImpls.onViewHolderResume(this);
    }

    public final void onViewHolderUnBind() {
        IInteractFeedView.DefaultImpls.onViewHolderUnBind(this);
    }

    public final void monitorLayouts(String r1) {
        IInteractFeedView.DefaultImpls.monitorLayouts(this, r1);
    }

    public final void onSeiUpdated(JSONObject r1) {
        IInteractFeedView.DefaultImpls.onSeiUpdated(this, r1);
    }

    public final void onSeiUpdatedRaw(String r1) {
        IInteractFeedView.DefaultImpls.onSeiUpdatedRaw(this, r1);
    }

    public final void putImCacheContent(Map<String, ? extends ImCacheUnit> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        IInteractFeedView.DefaultImpls.putImCacheContent(this, r2);
    }

    public final void sendMessage(List<? extends tlc.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "msgList");
        IInteractFeedView.DefaultImpls.sendMessage(this, r2);
    }

    public void setInteractPlayView(IInteractPlayView r2) {
        Intrinsics.checkNotNullParameter(r2, "interactPlayView");
        IInteractFeedView.DefaultImpls.setInteractPlayView(this, r2);
    }

    public final void updateActionCaller(InteractFeedActionCaller r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        IInteractFeedView.DefaultImpls.updateActionCaller(this, r2);
    }

    public final void updateMessageHub(MessageHub r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        IInteractFeedView.DefaultImpls.updateMessageHub(this, r2);
    }

    public final void updateMvControllerSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IInteractFeedView.DefaultImpls.updateMvControllerSei(this, r2);
    }

    public final void updateRadioSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IInteractFeedView.DefaultImpls.updateRadioSei(this, r2);
    }

    public final void updateRadioTextSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IInteractFeedView.DefaultImpls.updateRadioTextSei(this, r2);
    }

    public final void updateRoom(IRoom r4) {
        Intrinsics.checkNotNullParameter(r4, PbRequest.SwitchType.ROOM);
        removeAllViews();
        this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.a);
        HSImageView r0 = this.a;
        py.k r1 = r4.getCover();
        if (r1 != null) goto L8;
        IBaseUser r5 = r4.getOwner();
        if (r5 == null) goto L7;
        r1 = r5.getAvatarMedium();
        goto L8
    L7:
        r1 = null;
    L8:
        ImageUtil.loadImage(r0, r1, 0);
    }

    public final void updateRoomBeforeSelect(IRoom r1) {
        IInteractFeedView.DefaultImpls.updateRoomBeforeSelect(this, r1);
    }

    public final void updateSpeechRecognitionSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IInteractFeedView.DefaultImpls.updateSpeechRecognitionSei(this, r2);
    }

    public final void updateSpeechRhythmSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IInteractFeedView.DefaultImpls.updateSpeechRhythmSei(this, r2);
    }

    public final void updateSubtitleSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IInteractFeedView.DefaultImpls.updateSubtitleSei(this, r2);
    }

    public final void bindMultiScenePreviewReportData(IMultiScenePreviewStatistics r1, long r2) {
        IInteractFeedView.DefaultImpls.bindMultiScenePreviewReportData(this, r1, r2);
    }

    public final void onScreenSizeChange(int r1, int r2) {
        IInteractFeedView.DefaultImpls.onScreenSizeChange(this, r1, r2);
    }

    public final void onWrdsDataUpdate(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "syncKey");
        IInteractFeedView.DefaultImpls.onWrdsDataUpdate(this, r2, r3);
    }

    public final void refreshSeiCanvasAndSeiVersion(JSONObject r1, Integer r2) {
        IInteractFeedView.DefaultImpls.refreshSeiCanvasAndSeiVersion(this, r1, r2);
    }

    public final void updateSeiVerAndUiLayout(int r1, int r2) {
        IInteractFeedView.DefaultImpls.updateSeiVerAndUiLayout(this, r1, r2);
    }

    public EmptyFeedView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new HSImageView(r2);
    }

    public /* synthetic */ EmptyFeedView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
