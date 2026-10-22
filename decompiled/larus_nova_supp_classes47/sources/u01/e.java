package u01;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.za;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.IKtvInteractFeedView;
import com.bytedance.android.livesdkapi.feed.IMultiFeedView;
import com.bytedance.android.livesdkapi.feed.IPkFeedView;
import com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility;
import com.bytedance.android.livesdkapi.feed.ImCacheUnit;
import com.bytedance.android.livesdkapi.feed.data.FeedViewRoomInfoStore;
import com.bytedance.android.livesdkapi.feed.data.IPkExposeData;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.ktv.KTVRoomFeedModel;
import com.bytedance.android.livesdkapi.model.NullableOrderInfo;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.InteractFeedActionCaller;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.android.livesdkapi.view.IRenderView;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements IKtvComponentFeedView {
    public final qc0.a a;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r3) {
            za r4 = (za) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            if ((r4 instanceof OrderInfo) == true) goto L6;
            r4 = null;
        L6:
            return new NullableOrderInfo((OrderInfo) r4);
        }
    }

    public final boolean getKtvComponentLyricsViewShowStatus() {
        return true;
    }

    public final void onOnlineListChanged(List<? extends ILinkPlayerInfoBridge> r1) {
    }

    public final void setLivePlayerClient(ILivePlayerClient r1) {
    }

    public final void setLivePlayerContainerAbility(IPreviewPlayerContainerAbility r1) {
    }

    public final void updateKtvComponentLyricsViewShowStatus(boolean r1) {
    }

    public final String getFeedViewName() {
        return this.a.getFeedViewName();
    }

    public final HashMap<String, Object> getKtvEnterRoomExtraParam() {
        return this.a.getKtvEnterRoomExtraParam();
    }

    public final Object getKtvSeiModelObject() {
        return this.a.getKtvSeiModelObject();
    }

    public final ViewGroup getKtvVideoContainer() {
        return this.a.getKtvVideoContainer();
    }

    public final Observable<NullableOrderInfo> getOrderInfoObservable() {
        return this.a.getOrderInfoObservable().map(a.a);
    }

    public final void reset() {
        this.a.reset();
    }

    public final void setRenderViewBitmapToMockView() {
        this.a.setRenderViewBitmapToMockView();
    }

    public final HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        return IKtvComponentFeedView.DefaultImpls.getChatRoomEnterRoomExtraParam(this);
    }

    public final Object getCurrentSeiParseResultData() {
        return IKtvComponentFeedView.DefaultImpls.getCurrentSeiParseResultData(this);
    }

    public final String getCurrentSingUserIdString() {
        return IKtvComponentFeedView.DefaultImpls.getCurrentSingUserIdString(this);
    }

    public final FeedViewRoomInfoStore getFeedViewRoomInfoStore() {
        return IKtvComponentFeedView.DefaultImpls.getFeedViewRoomInfoStore(this);
    }

    public final IKtvInteractFeedView getIKtvInteractFeedView() {
        return IKtvComponentFeedView.DefaultImpls.getIKtvInteractFeedView(this);
    }

    public final IMultiFeedView getIMultiFeedView() {
        return IKtvComponentFeedView.DefaultImpls.getIMultiFeedView(this);
    }

    public final IPkFeedView getIPkFeedView() {
        return IKtvComponentFeedView.DefaultImpls.getIPkFeedView(this);
    }

    public final List<String> getImCacheTags() {
        return IKtvComponentFeedView.DefaultImpls.getImCacheTags(this);
    }

    public final IKtvComponentFeedView getKtvComponentFeedView() {
        return IKtvComponentFeedView.DefaultImpls.getKtvComponentFeedView(this);
    }

    public final List<ILinkPlayerInfoBridge> getOnlineList() {
        return IKtvComponentFeedView.DefaultImpls.getOnlineList(this);
    }

    public final View getViewCompat() {
        return IKtvComponentFeedView.DefaultImpls.getViewCompat(this);
    }

    public final Observable<IPkExposeData> observeFeedViewExposeData() {
        return IKtvComponentFeedView.DefaultImpls.observeFeedViewExposeData(this);
    }

    public final void onOnlineListChanged() {
        IKtvComponentFeedView.DefaultImpls.onOnlineListChanged(this);
    }

    public final void onViewHolderPause() {
        IKtvComponentFeedView.DefaultImpls.onViewHolderPause(this);
    }

    public final void onViewHolderResume() {
        IKtvComponentFeedView.DefaultImpls.onViewHolderResume(this);
    }

    public final void onViewHolderSelected() {
        IKtvComponentFeedView.DefaultImpls.onViewHolderSelected(this);
    }

    public final void onViewHolderUnBind() {
        IKtvComponentFeedView.DefaultImpls.onViewHolderUnBind(this);
    }

    public final void onViewHolderUnSelected() {
        IKtvComponentFeedView.DefaultImpls.onViewHolderUnSelected(this);
    }

    public final void resetKtvSeiModelObject() {
        IKtvComponentFeedView.DefaultImpls.resetKtvSeiModelObject(this);
    }

    public e(qc0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }

    public final void bind(KTVRoomFeedModel r2) {
        Intrinsics.checkNotNullParameter(r2, "feedModelKTV");
        this.a.a(r2);
    }

    public final void monitorLayouts(String r1) {
        IKtvComponentFeedView.DefaultImpls.monitorLayouts(this, r1);
    }

    public final void onKtvVideoStateChange(ld0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "videoSei");
        this.a.b(r2);
    }

    public final void onSeiUpdated(SeiAppData r1) {
        IKtvComponentFeedView.DefaultImpls.onSeiUpdated(this, r1);
    }

    public final void onSeiUpdatedRaw(String r1) {
        IKtvComponentFeedView.DefaultImpls.onSeiUpdatedRaw(this, r1);
    }

    public final void putImCacheContent(Map<String, ? extends ImCacheUnit> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        IKtvComponentFeedView.DefaultImpls.putImCacheContent(this, r2);
    }

    public final void sendMessage(List<? extends tlc.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "msgList");
        IKtvComponentFeedView.DefaultImpls.sendMessage(this, r2);
    }

    public final void setDataMergeCenter(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "dataMergeCenter");
        IKtvComponentFeedView.DefaultImpls.setDataMergeCenter(this, r2);
    }

    public final void setDataMergeCenterV2(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "dataMergeCenter");
        IKtvComponentFeedView.DefaultImpls.setDataMergeCenterV2(this, r2);
    }

    public final void setInteractPlayView(IInteractPlayView r2) {
        Intrinsics.checkNotNullParameter(r2, "interactPlayView");
        IKtvComponentFeedView.DefaultImpls.setInteractPlayView(this, r2);
    }

    public final void setLivePlayerView(IRenderView r2) {
        this.a.setLivePlayerView(r2);
    }

    public final void updateActionCaller(InteractFeedActionCaller r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        IKtvComponentFeedView.DefaultImpls.updateActionCaller(this, r2);
    }

    public final void updateKsongLayout(ViewGroup.LayoutParams r2) {
        Intrinsics.checkNotNullParameter(r2, "layoutParam");
        this.a.updateKsongLayout(r2);
    }

    public final void updateMessageHub(MessageHub r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        IKtvComponentFeedView.DefaultImpls.updateMessageHub(this, r2);
    }

    public final void updateMvControllerSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvComponentFeedView.DefaultImpls.updateMvControllerSei(this, r2);
    }

    public final void updateRadioSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvComponentFeedView.DefaultImpls.updateRadioSei(this, r2);
    }

    public final void updateRadioTextSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvComponentFeedView.DefaultImpls.updateRadioTextSei(this, r2);
    }

    public final void updateRoom(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
        this.a.updateRoom(r2);
    }

    public final void updateRoomBeforeSelect(IRoom r1) {
        IKtvComponentFeedView.DefaultImpls.updateRoomBeforeSelect(this, r1);
    }

    public final void updateSpeechRecognitionSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvComponentFeedView.DefaultImpls.updateSpeechRecognitionSei(this, r2);
    }

    public final void updateSpeechRhythmSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvComponentFeedView.DefaultImpls.updateSpeechRhythmSei(this, r2);
    }

    public final void updateSubtitleSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvComponentFeedView.DefaultImpls.updateSubtitleSei(this, r2);
    }

    public final void updateTalkState(HashMap<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
        IKtvComponentFeedView.DefaultImpls.updateTalkState(this, r2);
    }

    public final void onSeiUpdated(JSONObject r1) {
        IKtvComponentFeedView.DefaultImpls.onSeiUpdated(this, r1);
    }

    public final void updateKsongLayout(Function1<? super ViewGroup.LayoutParams, ? extends ViewGroup.LayoutParams> r2) {
        Intrinsics.checkNotNullParameter(r2, "updateTask");
        this.a.updateKsongLayout(r2);
    }

    public final void updateTalkState(Map<String, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
        IKtvComponentFeedView.DefaultImpls.updateTalkState(this, r2);
    }

    public final void bindMultiScenePreviewReportData(IMultiScenePreviewStatistics r1, long r2) {
        IKtvComponentFeedView.DefaultImpls.bindMultiScenePreviewReportData(this, r1, r2);
    }

    public final void onScreenSizeChange(int r1, int r2) {
        IKtvComponentFeedView.DefaultImpls.onScreenSizeChange(this, r1, r2);
    }

    public final void onWrdsDataUpdate(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "syncKey");
        IKtvComponentFeedView.DefaultImpls.onWrdsDataUpdate(this, r2, r3);
    }

    public final void refreshSeiCanvasAndSeiVersion(JSONObject r1, Integer r2) {
        IKtvComponentFeedView.DefaultImpls.refreshSeiCanvasAndSeiVersion(this, r1, r2);
    }

    public final void setAttachParent(ViewGroup r2, ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r3, "layoutParam");
        this.a.setAttachParent(r2, r3);
    }

    public final void updateEnterFrom(String r1, String r2) {
        IKtvComponentFeedView.DefaultImpls.updateEnterFrom(this, r1, r2);
    }

    public final void updateSeiVerAndUiLayout(int r1, int r2) {
        IKtvComponentFeedView.DefaultImpls.updateSeiVerAndUiLayout(this, r1, r2);
    }
}
