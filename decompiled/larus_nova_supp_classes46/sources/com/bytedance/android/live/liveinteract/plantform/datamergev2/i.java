package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.liveinteract.feedv2.widget.LivePreviewMultiLinkCommonWidget;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.livesdk.config.bb0;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.crossroom.CrossRoomLinkmicUIInfo;
import com.bytedance.android.livesdkapi.depend.message.crossroom.CrossRoomLinkmicUIInfoMainKt;
import com.bytedance.android.livesdkapi.depend.message.crossroom.UserInfo;
import com.bytedance.android.livesdkapi.depend.message.wrds.IPreviewSyncDataType;
import com.bytedance.android.livesdkapi.depend.message.wrds.MultiPreviewSyncDataType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements d {
    public final List<com.bytedance.android.live.liveinteract.plantform.base.i.d> a;
    public final CompositeDisposable b;
    public boolean c;
    public final j d;
    public final k e;
    public final IPreviewMultiLinkOuterConfigProvider f;
    public final te0.a g;
    public final com.bytedance.android.live.liveinteract.plantform.datamergev2.c h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ i a;

        public b(i r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            Intrinsics.checkNotNullParameter(r8, "response");
            i r0 = this.a;
            int r1 = 0;
            r0.c = false;
            r0.g(((w0) r8.data).getMPlayerInfo(), ((w0) r8.data).getClientUiInfo());
            Iterator r2 = ((ArrayList) this.a.a).iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            ((com.bytedance.android.live.liveinteract.plantform.base.i.d) r2.next()).e(((w0) r8.data).getPositions());
            goto L4
        L6:
            Map<Long, g2> r3 = ((w0) r8.data).getLinkerContentMap();
            if (r3 == null) goto L9;
            r1 = r3.size();
        L9:
            List<ILinkPlayerInfoBridge> r4 = null;
            if (r1 <= 1) goto L29;
            Map<Long, g2> r5 = ((w0) r8.data).getLinkerContentMap();
            if (r5 == null) goto L22;
            Collection<g2> r6 = r5.values();
            if (r6 == null) goto L22;
            ArrayList r9 = new ArrayList();
            Iterator<T> r10 = r6.iterator();
        L17:
            if (r10.hasNext() == false) goto L23;
            List r11 = ((g2) r10.next()).getLinkedUsers();
            if (r11 != null) goto L21;
            r11 = CollectionsKt.emptyList();
        L21:
            CollectionsKt.addAll(r9, r11);
        L23:
            if (r9 == null) goto L42;
            ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
            Iterator<T> r13 = r9.iterator();
        L26:
            if (r13.hasNext() == false) goto L28;
            r12.add(je0.d.d0((com.bytedance.android.livesdk.link.model.bridge.k) r13.next(), true));
            goto L26
        L28:
            r4 = CollectionsKt.toMutableList(r12);
        L42:
            if (r4 == null) goto L47;
            Iterator<T> r14 = r4.iterator();
        L45:
            if (r14.hasNext() == false) goto L47;
            ILinkPlayerInfoBridge r15 = (ILinkPlayerInfoBridge) r14.next();
            int r16 = tc0.e.a;
            tc0.e.b(r15, ((w0) r8.data).getLinkerContentMap());
        L47:
            this.a.h(r4, ((w0) r8.data).getLinkerContentMap(), ((w0) r8.data).getClientUiInfo());
            return;
        L22:
            r9 = null;
            goto L23
        L29:
            Map<Long, g2> r17 = ((w0) r8.data).getLinkerContentMap();
            if (r17 == null) goto L42;
            Map.Entry r18 = z0.a(r17);
            if (r18 == null) goto L42;
            g2 r19 = (g2) r18.getValue();
            if (r19 == null) goto L42;
            List r20 = r19.getLinkedUsers();
            if (r20 == null) goto L42;
            List r21 = r20;
            ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
            Iterator<T> r23 = r21.iterator();
        L39:
            if (r23.hasNext() == false) goto L41;
            r22.add(je0.d.d0((com.bytedance.android.livesdk.link.model.bridge.k) r23.next(), true));
            goto L39
        L41:
            r4 = CollectionsKt.toMutableList(r22);
            goto L42
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ i a;

        public c(i r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            i r0 = this.a;
            d.a.a(r0, "LinkUserDataSourceFeedWrapper", r0.hashCode(), ((Throwable) r7).toString(), true, 16);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final void a() {
        this.h.a();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final List<ILinkPlayerInfoBridge> c() {
        return new ArrayList();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final List<LinkmicPositionItem> d() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final void e() {
        m("LinkUserDataSourceFeedWrapper", hashCode(), "attach: MessageHub = " + this.f.getMessageHub(), false, true);
        this.f.getMessageHub().addMessageListener(MessageType.LINK_MIC.getKey(), this.d);
        this.f.getMessageHub().addWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, this.e, true);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final List<ILinkPlayerInfoBridge> getOnlineList() {
        return new ArrayList();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.m
    public final IRoom getRoom() {
        return this.f.getRoom();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final int getShowFrom() {
        return this.f.getShowFrom();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final boolean n() {
        SeiAppData r0 = this.g.d();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getPositionStashStatus() != 2) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final void b(int r2) {
        this.h.b(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final void f(com.bytedance.android.live.liveinteract.plantform.base.i.d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((ArrayList) this.a).add(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final void j(boolean r10) {
        if (r10 == false) goto L6;
    L4:
        boolean r11 = true;
    L13:
        if (r11 == true) goto L15;
        return;
    L15:
        if (this.c == true) goto L20;
        this.c = true;
        IRoom r12 = this.f.getRoom();
        Disposable r13 = ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getLinkListV2(r12.getId(), d5.c(r12.getAnchorId()), String.valueOf(r12.getAnchorId()), true, r12.isOfficialChannelRoom()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
        this.b.add(r13);
        return;
    L20:
        return;
    L6:
        if (this.f.getFeedLiveType() == 5) goto L4;
        if (this.f.getFeedLiveType() == 9) goto L4;
        if (this.f.getFeedLiveType() == 1) goto L4;
        r11 = false;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final void k(com.bytedance.android.live.liveinteract.plantform.base.i.d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((ArrayList) this.a).remove(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final ILivePlayerClient o(DataCenter r1) {
        return this.f.getLivePlayerClient();
    }

    public final void addMessageListener(String r2, vlc.l r3) {
        Intrinsics.checkNotNullParameter(r2, "method");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.f.getMessageHub().addMessageListener(r2, r3);
    }

    public final void g(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r3, ClientUIInfo r4) {
        if (r3 == null) goto L11;
        ArrayList<ILinkPlayerInfoBridge> r5 = je0.d.f0(r3, false);
        Iterator<T> r0 = r5.iterator();
    L5:
        if (r0.hasNext() == false) goto L7;
        i((ILinkPlayerInfoBridge) r0.next(), r4);
        goto L5
    L7:
        Iterator<T> r6 = this.a.iterator();
    L9:
        if (r6.hasNext() == false) goto L14;
        ((com.bytedance.android.live.liveinteract.plantform.base.i.d) r6.next()).onOnlineListChanged(r5);
        goto L9
    L14:
        return;
    }

    public final <T extends tlc.d> T getLatestWRDSMessage(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "messageMethod");
        T r4 = (T) this.f.getMessageHub().getLatestWRDSMessage(r2, r3);
        if ((r4 instanceof tlc.d) == true) goto L6;
        return null;
    L6:
        return r4;
    }

    public final void i(ILinkPlayerInfoBridge r3, ClientUIInfo r4) {
        if (((Boolean) bb0.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        int r0 = ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION;
        r3.setClientUIPosition(ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION);
        if (r4 == null) goto L22;
        CrossRoomLinkmicUIInfo r5 = r4.getCrossRoomLinkmic();
        if (r5 == null) goto L23;
        Map r6 = CrossRoomLinkmicUIInfoMainKt.getUserInfoString(r5);
        if (r6 == null) goto L20;
        IBaseUser r1 = r3.getUser();
        if (r1 == null) goto L16;
        String r2 = r1.getIdString();
    L17:
        UserInfo r7 = (UserInfo) r6.get(r2);
        if (r7 == null) goto L20;
        r0 = (int) r7.getClientPosition();
        goto L20
    L16:
        r2 = null;
    L20:
        r3.setClientUIPosition(r0);
        return;
    L23:
        return;
    }

    public final void removeMessageListener(String r2, vlc.l r3) {
        Intrinsics.checkNotNullParameter(r2, "method");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.f.getMessageHub().removeMessageListener(r2, r3);
    }

    public final void removeWRDSListener(IPreviewSyncDataType r2, OnWRDSDataUpdateListener r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.f.getMessageHub().removeWRDSListener(r2, r3);
    }

    public final void addMessageListener(int r2, vlc.l r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.f.getMessageHub().addMessageListener(r2, r3);
    }

    public final void removeMessageListener(int r2, vlc.l r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.f.getMessageHub().removeMessageListener(r2, r3);
    }

    public i(IPreviewMultiLinkOuterConfigProvider r2, te0.a r3, LivePreviewMultiLinkCommonWidget.a r4) {
        Intrinsics.checkNotNullParameter(r2, "configOuterProvider");
        Intrinsics.checkNotNullParameter(r3, "configInnerProvider");
        Intrinsics.checkNotNullParameter(r4, "feedViewSeiCallback");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = new ArrayList();
        this.b = new CompositeDisposable();
        this.d = new j(this);
        this.e = new k(this);
    }

    public final void addWRDSListener(IPreviewSyncDataType r2, OnWRDSDataUpdateListener r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.f.getMessageHub().addWRDSListener(r2, r3, r4);
    }

    public final void h(List<ILinkPlayerInfoBridge> r3, Map<Long, ? extends g2> r4, ClientUIInfo r5) {
        tc0.c.h().l(r4);
        if (r3 == null) goto L5;
        r3.size();
    L5:
        if (r3 == null) goto L10;
        Iterator<T> r6 = r3.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        ILinkPlayerInfoBridge r0 = (ILinkPlayerInfoBridge) r6.next();
        i(r0, r5);
        r0.setLinkRoomUser(true);
    L10:
        Iterator<T> r7 = this.a.iterator();
    L12:
        if (r7.hasNext() == false) goto L16;
        com.bytedance.android.live.liveinteract.plantform.base.i.d r8 = (com.bytedance.android.live.liveinteract.plantform.base.i.d) r7.next();
        if (r3 == null) goto L12;
        r8.d(CollectionsKt.emptyList(), r3);
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final void m(String r4, int r5, String r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r4, "subTag");
        Intrinsics.checkNotNullParameter(r6, "content");
        if (r7 == false) goto L5;
        ALogger.d("FeedMergeDataCenter", r4 + '#' + r5 + ", content=" + r6);
        return;
    L5:
        if (r8 == false) goto L7;
        ALogger.e("FeedMergeDataCenter", r4 + '#' + r5 + ", content=" + r6);
        return;
    L7:
        ALogger.i("FeedMergeDataCenter", r4 + '#' + r5 + ", content=" + r6);
    }
}
