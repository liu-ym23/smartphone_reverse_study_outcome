package u01;

import android.view.View;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
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
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements IKtvInteractFeedView {
    public final qc0.a a;

    public final String getCurrentSingUserIdString() {
        return "";
    }

    public final void setLivePlayerClient(ILivePlayerClient r1) {
    }

    public final void setLivePlayerContainerAbility(IPreviewPlayerContainerAbility r1) {
    }

    public final String getFeedViewName() {
        return this.a.getFeedViewName();
    }

    public final void reset() {
        this.a.reset();
    }

    public final HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        return IKtvInteractFeedView.DefaultImpls.getChatRoomEnterRoomExtraParam(this);
    }

    public final String getCurrentSingUserId() {
        return IKtvInteractFeedView.DefaultImpls.getCurrentSingUserId(this);
    }

    public final FeedViewRoomInfoStore getFeedViewRoomInfoStore() {
        return IKtvInteractFeedView.DefaultImpls.getFeedViewRoomInfoStore(this);
    }

    public final IKtvInteractFeedView getIKtvInteractFeedView() {
        return IKtvInteractFeedView.DefaultImpls.getIKtvInteractFeedView(this);
    }

    public final IMultiFeedView getIMultiFeedView() {
        return IKtvInteractFeedView.DefaultImpls.getIMultiFeedView(this);
    }

    public final IPkFeedView getIPkFeedView() {
        return IKtvInteractFeedView.DefaultImpls.getIPkFeedView(this);
    }

    public final List<String> getImCacheTags() {
        return IKtvInteractFeedView.DefaultImpls.getImCacheTags(this);
    }

    public final IKtvComponentFeedView getKtvComponentFeedView() {
        return IKtvInteractFeedView.DefaultImpls.getKtvComponentFeedView(this);
    }

    public final Object getKtvSeiModelObject() {
        return IKtvInteractFeedView.DefaultImpls.getKtvSeiModelObject(this);
    }

    public final List<ILinkPlayerInfoBridge> getOnlineList() {
        return IKtvInteractFeedView.DefaultImpls.getOnlineList(this);
    }

    public final View getViewCompat() {
        return IKtvInteractFeedView.DefaultImpls.getViewCompat(this);
    }

    public final Observable<IPkExposeData> observeFeedViewExposeData() {
        return IKtvInteractFeedView.DefaultImpls.observeFeedViewExposeData(this);
    }

    public final void onOnlineListChanged() {
        IKtvInteractFeedView.DefaultImpls.onOnlineListChanged(this);
    }

    public final void onViewHolderPause() {
        IKtvInteractFeedView.DefaultImpls.onViewHolderPause(this);
    }

    public final void onViewHolderResume() {
        IKtvInteractFeedView.DefaultImpls.onViewHolderResume(this);
    }

    public final void onViewHolderSelected() {
        IKtvInteractFeedView.DefaultImpls.onViewHolderSelected(this);
    }

    public final void onViewHolderUnBind() {
        IKtvInteractFeedView.DefaultImpls.onViewHolderUnBind(this);
    }

    public final void onViewHolderUnSelected() {
        IKtvInteractFeedView.DefaultImpls.onViewHolderUnSelected(this);
    }

    public final void resetKtvSeiModelObject() {
        IKtvInteractFeedView.DefaultImpls.resetKtvSeiModelObject(this);
    }

    public f(qc0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }

    public final void monitorLayouts(String r1) {
        IKtvInteractFeedView.DefaultImpls.monitorLayouts(this, r1);
    }

    public final void onKtvRoomSeiModel(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        this.a.onSeiUpdatedRaw(r2);
    }

    public final void onSeiUpdated(SeiAppData r1) {
        IKtvInteractFeedView.DefaultImpls.onSeiUpdated(this, r1);
    }

    public final void onSeiUpdatedRaw(String r1) {
        IKtvInteractFeedView.DefaultImpls.onSeiUpdatedRaw(this, r1);
    }

    public final void putImCacheContent(Map<String, ? extends ImCacheUnit> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        IKtvInteractFeedView.DefaultImpls.putImCacheContent(this, r2);
    }

    public final void sendMessage(List<? extends tlc.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "msgList");
        IKtvInteractFeedView.DefaultImpls.sendMessage(this, r2);
    }

    public final void setInteractPlayView(IInteractPlayView r2) {
        Intrinsics.checkNotNullParameter(r2, "interactPlayView");
        IKtvInteractFeedView.DefaultImpls.setInteractPlayView(this, r2);
    }

    public final void setLivePlayerView(IRenderView r2) {
        this.a.setLivePlayerView(r2);
    }

    public final void updateActionCaller(InteractFeedActionCaller r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        IKtvInteractFeedView.DefaultImpls.updateActionCaller(this, r2);
    }

    public final void updateMessageHub(MessageHub r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        IKtvInteractFeedView.DefaultImpls.updateMessageHub(this, r2);
    }

    public final void updateMvControllerSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvInteractFeedView.DefaultImpls.updateMvControllerSei(this, r2);
    }

    public final void updateRadioSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvInteractFeedView.DefaultImpls.updateRadioSei(this, r2);
    }

    public final void updateRadioTextSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvInteractFeedView.DefaultImpls.updateRadioTextSei(this, r2);
    }

    public final void updateRoom(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
        this.a.updateRoom(r2);
    }

    public final void updateRoomBeforeSelect(IRoom r1) {
        IKtvInteractFeedView.DefaultImpls.updateRoomBeforeSelect(this, r1);
    }

    public final void updateSpeechRecognitionSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvInteractFeedView.DefaultImpls.updateSpeechRecognitionSei(this, r2);
    }

    public final void updateSpeechRhythmSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvInteractFeedView.DefaultImpls.updateSpeechRhythmSei(this, r2);
    }

    public final void updateSubtitleSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvInteractFeedView.DefaultImpls.updateSubtitleSei(this, r2);
    }

    public final void updateTalkState(HashMap<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
        IKtvInteractFeedView.DefaultImpls.updateTalkState(this, r2);
    }

    public final void onSeiUpdated(JSONObject r1) {
        IKtvInteractFeedView.DefaultImpls.onSeiUpdated(this, r1);
    }

    public final void bindMultiScenePreviewReportData(IMultiScenePreviewStatistics r1, long r2) {
        IKtvInteractFeedView.DefaultImpls.bindMultiScenePreviewReportData(this, r1, r2);
    }

    public final void onScreenSizeChange(int r1, int r2) {
        IKtvInteractFeedView.DefaultImpls.onScreenSizeChange(this, r1, r2);
    }

    public final void onWrdsDataUpdate(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "syncKey");
        IKtvInteractFeedView.DefaultImpls.onWrdsDataUpdate(this, r2, r3);
    }

    public final void refreshSeiCanvasAndSeiVersion(JSONObject r1, Integer r2) {
        IKtvInteractFeedView.DefaultImpls.refreshSeiCanvasAndSeiVersion(this, r1, r2);
    }

    public final void updateEnterFrom(String r1, String r2) {
        IKtvInteractFeedView.DefaultImpls.updateEnterFrom(this, r1, r2);
    }

    public final void updateSeiVerAndUiLayout(int r1, int r2) {
        IKtvInteractFeedView.DefaultImpls.updateSeiVerAndUiLayout(this, r1, r2);
    }
}
