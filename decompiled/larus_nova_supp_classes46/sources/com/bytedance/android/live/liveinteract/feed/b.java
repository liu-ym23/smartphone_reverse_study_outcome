package com.bytedance.android.live.liveinteract.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.utils.d5;
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
import com.bytedance.android.livesdkapi.service.InteractFeedActionCaller;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b extends FrameLayout implements IInteractFeedView {
    public boolean a;
    public IRoom b;
    public final CompositeDisposable c;
    public IPreviewPlayerContainerAbility d;
    public FeedViewRoomInfoStore e;
    public int f;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.feed.b$b, reason: collision with other inner class name */
    public static final class C0029b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0029b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.e<w0> r7 = (com.bytedance.android.live.network.response.e) r6;
            Intrinsics.checkNotNullParameter(r7, "response");
            b r0 = this.a;
            r0.a = false;
            FeedViewRoomInfoStore r1 = r0.getFeedViewRoomInfoStore();
            if (r1 == null) goto L14;
            List<com.bytedance.android.livesdk.link.model.bridge.k> r2 = r7.data.getMPlayerInfo();
            if (r2 == null) goto L12;
            List<com.bytedance.android.livesdk.link.model.bridge.k> r3 = r2;
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
            Iterator<T> r5 = r3.iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            r4.add(je0.d.d0((com.bytedance.android.livesdk.link.model.bridge.k) r5.next(), true));
            goto L8
        L10:
            List r8 = CollectionsKt.toMutableList(r4);
            if (r8 == null) goto L12;
        L13:
            r1.setOnlineList(r8);
        L12:
            r8 = new ArrayList();
        L14:
            this.a.b(r7);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.c();
            b r0 = this.a;
            r0.a = false;
            String r1 = r0.getTagName();
            je0.d.Q(r1, (Throwable) r3);
        }
    }

    static {
    }

    public abstract void a();

    public abstract void b(com.bytedance.android.live.network.response.e<w0> r1);

    public abstract void c();

    public abstract String getTagName();

    public void onSeiUpdated(JSONObject r1) {
    }

    public FeedViewRoomInfoStore getFeedViewRoomInfoStore() {
        if (this.e != null) goto L10;
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        FeedViewRoomInfoStore r1 = r0.getFeedViewRoomInfoStore();
    L8:
        this.e = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return this.e;
    }

    public final void onOnlineListChanged() {
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        IRoom r0 = this.b;
        if (r0 == null) goto L16;
        LinkAnchorApi r2 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        long r3 = r0.getId();
        long r5 = d5.c(r0.getAnchorId());
        String r1 = r0.getAnchorId();
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        a();
        Disposable r4 = r2.getLinkListV2(r3, r5, r1, true, r0.isOfficialChannelRoom()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0029b(this), new c(this));
        if (r4 == null) goto L13;
        Boolean r6 = Boolean.valueOf(this.c.add(r4));
    L14:
        r6.booleanValue();
        return;
    L13:
        r6 = null;
        goto L14
    }

    public HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        return IInteractFeedView.DefaultImpls.getChatRoomEnterRoomExtraParam(this);
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

    public final IPreviewPlayerContainerAbility getMPlayerContainerAbility() {
        return this.d;
    }

    public final IRoom getMRoom$liveinteract_impl_saasRelease() {
        return this.b;
    }

    public final int getShowFrom() {
        return this.f;
    }

    public final void onViewHolderPause() {
        IInteractFeedView.DefaultImpls.onViewHolderPause(this);
    }

    public final void onViewHolderResume() {
        IInteractFeedView.DefaultImpls.onViewHolderResume(this);
    }

    public void onViewHolderSelected() {
        IInteractFeedView.DefaultImpls.onViewHolderSelected(this);
    }

    public final void onViewHolderUnBind() {
        IInteractFeedView.DefaultImpls.onViewHolderUnBind(this);
    }

    public void onViewHolderUnSelected() {
        IInteractFeedView.DefaultImpls.onViewHolderUnSelected(this);
    }

    public final void monitorLayouts(String r1) {
        IInteractFeedView.DefaultImpls.monitorLayouts(this, r1);
    }

    public void onSeiUpdated(SeiAppData r1) {
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

    public void setLivePlayerContainerAbility(IPreviewPlayerContainerAbility r1) {
        this.d = r1;
    }

    public final void setMPlayerContainerAbility(IPreviewPlayerContainerAbility r1) {
        this.d = r1;
    }

    public final void setMRoom$liveinteract_impl_saasRelease(IRoom r1) {
        this.b = r1;
    }

    public final void setShowFrom(int r1) {
        this.f = r1;
    }

    public final void updateActionCaller(InteractFeedActionCaller r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        IInteractFeedView.DefaultImpls.updateActionCaller(this, r2);
    }

    public void updateMessageHub(MessageHub r2) {
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

    public void updateRadioTextSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IInteractFeedView.DefaultImpls.updateRadioTextSei(this, r2);
    }

    public void updateRoom(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
        this.b = r2;
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

    public void updateTalkState(HashMap<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
        IInteractFeedView.DefaultImpls.updateTalkState(this, r2);
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

    public void updateEnterFrom(String r1, String r2) {
        IInteractFeedView.DefaultImpls.updateEnterFrom(this, r1, r2);
    }

    public final void updateSeiVerAndUiLayout(int r1, int r2) {
        IInteractFeedView.DefaultImpls.updateSeiVerAndUiLayout(this, r1, r2);
    }

    public b(Context r2, int r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r4, r5);
        this.f = r3;
        this.c = new CompositeDisposable();
    }
}
