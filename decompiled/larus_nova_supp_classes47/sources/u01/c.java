package u01;

import android.view.View;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
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
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements IInteractFeedView {
    public final qc0.f a;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            pc0.d r3 = (pc0.d) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return new j(r3);
        }
    }

    public final void setLivePlayerClient(ILivePlayerClient r1) {
    }

    public final void setLivePlayerContainerAbility(IPreviewPlayerContainerAbility r1) {
    }

    public final String getFeedViewName() {
        qc0.f r0 = this.a;
        if (r0 == null) goto L5;
        String r1 = r0.getFeedViewName();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final IKtvInteractFeedView getIKtvInteractFeedView() {
        qc0.f r0 = this.a;
        if (r0 == null) goto L7;
        qc0.a r1 = r0.getKtvComponentFeedView();
        if (r1 == null) goto L7;
        return new f(r1);
    L7:
        return null;
    }

    public final IMultiFeedView getIMultiFeedView() {
        qc0.f r0 = this.a;
        if (r0 == null) goto L7;
        qc0.b r1 = r0.getIMultiFeedView();
        if (r1 == null) goto L7;
        return new h(r1);
    L7:
        return null;
    }

    public final IPkFeedView getIPkFeedView() {
        qc0.f r0 = this.a;
        if (r0 == null) goto L7;
        qc0.c r1 = r0.getIPkFeedView();
        if (r1 == null) goto L7;
        return new i(r1);
    L7:
        return null;
    }

    public final List<String> getImCacheTags() {
        qc0.f r0 = this.a;
        if (r0 == null) goto L7;
        List<String> r1 = r0.getImCacheTags();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public final IKtvComponentFeedView getKtvComponentFeedView() {
        qc0.f r0 = this.a;
        if (r0 == null) goto L7;
        qc0.a r1 = r0.getKtvComponentFeedView();
        if (r1 == null) goto L7;
        return new e(r1);
    L7:
        return null;
    }

    public final View getViewCompat() {
        qc0.f r0 = this.a;
        if ((r0 instanceof View) == true) goto L6;
        r0 = null;
    L6:
        return (View) r0;
    }

    public final Observable<IPkExposeData> observeFeedViewExposeData() {
        qc0.f r0 = this.a;
        if (r0 == null) goto L7;
        Observable r1 = r0.observeFeedViewExposeData();
        if (r1 == null) goto L7;
        return r1.map(a.a);
    L7:
        return null;
    }

    public final void onOnlineListChanged() {
        qc0.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.onOnlineListChanged();
        return;
    }

    public final void onViewHolderPause() {
        qc0.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.onViewHolderPause();
        return;
    }

    public final void onViewHolderResume() {
        qc0.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.onViewHolderResume();
        return;
    }

    public final void onViewHolderSelected() {
        qc0.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.onViewHolderSelected();
        return;
    }

    public final void onViewHolderUnSelected() {
        qc0.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.onViewHolderUnSelected();
        return;
    }

    public final void reset() {
        qc0.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.reset();
        return;
    }

    public final HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        return IInteractFeedView.DefaultImpls.getChatRoomEnterRoomExtraParam(this);
    }

    public final FeedViewRoomInfoStore getFeedViewRoomInfoStore() {
        return IInteractFeedView.DefaultImpls.getFeedViewRoomInfoStore(this);
    }

    public final List<ILinkPlayerInfoBridge> getOnlineList() {
        return IInteractFeedView.DefaultImpls.getOnlineList(this);
    }

    public final void onViewHolderUnBind() {
        IInteractFeedView.DefaultImpls.onViewHolderUnBind(this);
    }

    public c(qc0.f r1) {
        this.a = r1;
    }

    public final void monitorLayouts(String r2) {
        qc0.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.monitorLayouts(r2);
        return;
    }

    public final void onSeiUpdated(SeiAppData r3) {
        qc0.f r0 = this.a;
        if (r0 == null) goto L9;
        if (r3 == null) goto L6;
        m r1 = new m(r3);
    L7:
        r0.a(r1);
        return;
    L6:
        r1 = null;
        goto L7
    }

    public final void onSeiUpdatedRaw(String r2) {
        qc0.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.onSeiUpdatedRaw(r2);
        return;
    }

    public final void putImCacheContent(Map<String, ? extends ImCacheUnit> r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, ? extends ImCacheUnit>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        Map.Entry<String, ? extends ImCacheUnit> r1 = r6.next();
        ImCacheUnit r2 = r1.getValue();
        if ((r2 instanceof d) == true) goto L8;
        r2 = null;
    L8:
        d r3 = (d) r2;
        if (r3 == null) goto L4;
        String r4 = r1.getKey();
        ImCacheUnit r7 = r1.getValue();
        r0.put(r4, r3.a);
        goto L4
    L11:
        qc0.f r8 = this.a;
        if (r8 == null) goto L20;
        r8.putImCacheContent(r0);
        return;
    }

    public final void sendMessage(List<? extends tlc.d> r4) {
        Intrinsics.checkNotNullParameter(r4, "msgList");
        qc0.f r0 = this.a;
        if (r0 == null) goto L16;
        List<? extends tlc.d> r5 = r4;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L12;
        yh6.c r2 = (tlc.d) r6.next();
        if (r2 == null) goto L11;
        r1.add(r2);
        goto L6
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.RevenueImMessage /* = com.bytedance.live.kmp.message.KmpImMessage */");
    L12:
        r0.sendMessage(r1);
        return;
    }

    public final void setInteractPlayView(IInteractPlayView r2) {
        Intrinsics.checkNotNullParameter(r2, "interactPlayView");
        IInteractFeedView.DefaultImpls.setInteractPlayView(this, r2);
    }

    public final void setLivePlayerView(IRenderView r2) {
        qc0.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.setLivePlayerView(r2);
        return;
    }

    public final void updateActionCaller(InteractFeedActionCaller r3) {
        Intrinsics.checkNotNullParameter(r3, "caller");
        qc0.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.e(new k(r3));
        return;
    }

    public final void updateMessageHub(MessageHub r3) {
        Intrinsics.checkNotNullParameter(r3, "hub");
        qc0.f r0 = this.a;
        if (r0 == null) goto L5;
        r0.d(new l(r3));
    L5:
        qc0.f r1 = this.a;
        if (r1 == null) goto L9;
        r1.setJsBridgeMap(jc1.k.n(IBrowserService.class).provideRegisterMessageMethodInFeed(r3));
        return;
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

    public final void updateRoom(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
        qc0.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.updateRoom(r2);
        return;
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

    public final void updateTalkState(HashMap<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
        qc0.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.updateTalkState(r2);
        return;
    }

    public final void onSeiUpdated(JSONObject r1) {
        qc0.f r2 = this.a;
        if (r2 == null) goto L6;
        r2.b();
        return;
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

    public final void updateEnterFrom(String r1, String r2) {
        qc0.f r3 = this.a;
        if (r3 == null) goto L6;
        r3.c();
        return;
    }

    public final void updateSeiVerAndUiLayout(int r1, int r2) {
        IInteractFeedView.DefaultImpls.updateSeiVerAndUiLayout(this, r1, r2);
    }
}
