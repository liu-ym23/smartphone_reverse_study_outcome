package ue0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.liveinteract.feed.datamerge.j;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.livesdk.config.bb0;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.crossroom.CrossRoomLinkmicUIInfo;
import com.bytedance.android.livesdkapi.depend.message.crossroom.CrossRoomLinkmicUIInfoMainKt;
import com.bytedance.android.livesdkapi.depend.message.crossroom.UserInfo;
import com.bytedance.android.livesdkapi.depend.message.wrds.MultiPreviewSyncDataType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.android.livesdkapi.service.MessageHub;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends com.bytedance.android.live.liveinteract.feed.datamerge.a implements OnWRDSDataUpdateListener {
    public final List<ILinkPlayerInfoBridge> b;
    public final CompositeDisposable c;
    public ylc.c d;
    public final List<j> e;
    public final IPreviewMultiLinkOuterConfigProvider f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            Intrinsics.checkNotNullParameter(r8, "response");
            Map<Long, g2> r0 = ((w0) r8.data).getLinkerContentMap();
            if (r0 == null) goto L5;
            int r1 = r0.size();
        L6:
            List<ILinkPlayerInfoBridge> r2 = null;
            if (r1 <= 1) goto L26;
            Map<Long, g2> r3 = ((w0) r8.data).getLinkerContentMap();
            if (r3 == null) goto L19;
            Collection<g2> r4 = r3.values();
            if (r4 == null) goto L19;
            ArrayList r5 = new ArrayList();
            Iterator<T> r6 = r4.iterator();
        L14:
            if (r6.hasNext() == false) goto L20;
            List r9 = ((g2) r6.next()).getLinkedUsers();
            if (r9 != null) goto L18;
            r9 = CollectionsKt.emptyList();
        L18:
            CollectionsKt.addAll(r5, r9);
        L20:
            if (r5 == null) goto L39;
            ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator<T> r11 = r5.iterator();
        L23:
            if (r11.hasNext() == false) goto L25;
            r10.add(je0.d.d0((k) r11.next(), true));
            goto L23
        L25:
            r2 = CollectionsKt.toMutableList(r10);
        L39:
            if (r2 == null) goto L44;
            Iterator<T> r12 = r2.iterator();
        L42:
            if (r12.hasNext() == false) goto L44;
            ILinkPlayerInfoBridge r13 = (ILinkPlayerInfoBridge) r12.next();
            int r14 = tc0.e.a;
            tc0.e.b(r13, ((w0) r8.data).getLinkerContentMap());
        L44:
            this.a.e(r2, ((w0) r8.data).getLinkerContentMap(), ((w0) r8.data).getClientUiInfo());
            return;
        L19:
            r5 = null;
            goto L20
        L26:
            Map<Long, g2> r15 = ((w0) r8.data).getLinkerContentMap();
            if (r15 == null) goto L39;
            Map.Entry r16 = z0.a(r15);
            if (r16 == null) goto L39;
            g2 r17 = (g2) r16.getValue();
            if (r17 == null) goto L39;
            List r18 = r17.getLinkedUsers();
            if (r18 == null) goto L39;
            List r19 = r18;
            ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
            Iterator<T> r21 = r19.iterator();
        L36:
            if (r21.hasNext() == false) goto L38;
            r20.add(je0.d.d0((k) r21.next(), true));
            goto L36
        L38:
            r2 = CollectionsKt.toMutableList(r20);
            goto L39
        L5:
            r1 = 0;
            goto L6
        }
    }

    /* JADX INFO: renamed from: ue0.b$b, reason: collision with other inner class name */
    public static final class C0279b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0279b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            b r0 = this.a;
            r0.f.printALogger("LivePreviewMultiLinkOnlineUserListHandler", r0.hashCode(), ((Throwable) r5).toString(), true);
        }
    }

    public final void f() {
        boolean r2 = true;
        if (this.f.getFeedLiveType() != 5) goto L5;
    L10:
        if (r2 == true) goto L12;
        return;
    L12:
        IRoom r0 = this.f.getRoom();
        LinkAnchorApi r3 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        long r4 = r0.getId();
        long r5 = d5.c(r0.getAnchorId());
        String r1 = r0.getAnchorId();
        if (r1 != null) goto L15;
        r1 = "";
    L15:
        Disposable r6 = r3.getLinkListV2(r4, r5, r1, true, r0.isOfficialChannelRoom()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), new C0279b(this));
        this.c.add(r6);
        return;
    L5:
        if (this.f.getFeedLiveType() == 9) goto L10;
        if (this.f.getFeedLiveType() == 1) goto L10;
        r2 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void attach() {
        MessageHub r0 = c().getMessageHub();
        if (r0 == null) goto L5;
        r0.addWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, this, true);
    L5:
        RoomLinkMicSyncData r1 = this.f.getPreloadRoomLinkMicSyncData();
        if (r1 == null) goto L8;
        g(r1);
    L8:
        f();
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void detach() {
        MessageHub r0 = c().getMessageHub();
        if (r0 == null) goto L5;
        r0.removeWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, this);
    L5:
        this.c.clear();
    }

    public final ylc.c getDataSyncListener() {
        return this.d;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.a, com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final j.a a(List<ch0.e> r14) {
        Intrinsics.checkNotNullParameter(r14, "oldMergeDataList");
        List<ch0.e> r15 = r14;
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r15, 10)), 16));
        Iterator<T> r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        Object r1 = r16.next();
        r2.put(((ch0.e) r1).a.getInteractId(), r1);
        goto L4
    L6:
        List<ILinkPlayerInfoBridge> r17 = this.b;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r18 = ((ArrayList) r17).iterator();
        boolean r4 = false;
        ch0.e r5 = null;
    L8:
        if (r18.hasNext() == false) goto L26;
        ILinkPlayerInfoBridge r7 = (ILinkPlayerInfoBridge) r18.next();
        ch0.e r6 = (ch0.e) r2.get(r7.getInteractId());
        boolean r12 = true;
        if (r6 != null) goto L12;
        ch0.e r8 = new ch0.e(r7);
    L16:
        IBaseUser r9 = r8.a.getUser();
        if (r9 == null) goto L19;
        String r10 = r9.getIdString();
    L21:
        if (Intrinsics.areEqual(r10, gh0.a.c()) == false) goto L24;
        if (r8 == r6) goto L24;
        r5 = r8;
    L24:
        r3.add(r8);
        r4 = r12;
        goto L8
    L19:
        r10 = null;
        goto L21
    L12:
        if (r6.b(r7) == false) goto L14;
        r12 = r4;
        r8 = r6;
        goto L16
    L14:
        r8 = ch0.e.a(r6, r7, null, null, null, 14);
        goto L16
    L26:
        return new j.a(r4, r3, r5);
    }

    public final void g(RoomLinkMicSyncData r5) {
        Intrinsics.checkNotNullParameter(r5, "wrds");
        Map r0 = r5.linkerContentMap;
        if (r0 == null) goto L15;
        Map.Entry r1 = z0.a(r0);
        if (r1 == null) goto L15;
        RoomLinkerContent r2 = (RoomLinkerContent) r1.getValue();
        if (r2 == null) goto L15;
        List<k> r3 = r2.linkedUsers;
        if (r3 == null) goto L15;
        List<k> r4 = r3;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r7 = r4.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        r6.add(je0.d.d0((k) r7.next(), true));
        goto L12
    L14:
        List<ILinkPlayerInfoBridge> r8 = CollectionsKt.toMutableList(r6);
    L16:
        if (r8 == null) goto L21;
        Iterator<T> r9 = r8.iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        ILinkPlayerInfoBridge r10 = (ILinkPlayerInfoBridge) r9.next();
        int r11 = tc0.e.a;
        tc0.e.b(r10, r5.linkerContentMap);
    L21:
        e(r8, r5.linkerContentMap, r5.clientUIInfo);
        return;
    L15:
        r8 = null;
        goto L16
    }

    public final void setDataSyncListener(ylc.c r1) {
        this.d = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends j> r2, IPreviewMultiLinkOuterConfigProvider r3) {
        Intrinsics.checkNotNullParameter(r2, "childHandlers");
        Intrinsics.checkNotNullParameter(r3, "configProvider");
        this.e = r2;
        this.f = r3;
        this.b = new ArrayList();
        this.c = new CompositeDisposable();
    }

    public final void onWRDSDataUpdate(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "syncKey");
        List<ILinkPlayerInfoBridge> r0 = null;
        if ((r5 instanceof IRoomLinkMicSyncData) == true) goto L5;
        r5 = null;
    L5:
        IRoomLinkMicSyncData r6 = (IRoomLinkMicSyncData) r5;
        if (r6 == null) goto L29;
        Map r7 = r6.getLinkerContentMap();
        if (r7 == null) goto L20;
        Map.Entry r8 = z0.a(r7);
        if (r8 == null) goto L20;
        g2 r9 = (g2) r8.getValue();
        if (r9 == null) goto L20;
        List r10 = r9.getLinkedUsers();
        if (r10 == null) goto L20;
        List r11 = r10;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r12 = r11.iterator();
    L17:
        if (r12.hasNext() == false) goto L19;
        r1.add(je0.d.d0((k) r12.next(), true));
        goto L17
    L19:
        r0 = CollectionsKt.toMutableList(r1);
    L20:
        if (r0 == null) goto L25;
        Iterator<T> r13 = r0.iterator();
    L23:
        if (r13.hasNext() == false) goto L25;
        ILinkPlayerInfoBridge r2 = (ILinkPlayerInfoBridge) r13.next();
        int r3 = tc0.e.a;
        tc0.e.b(r2, r6.getLinkerContentMap());
    L25:
        e(r0, r6.getLinkerContentMap(), r6.getClientUIInfo());
        return;
    }

    public final void e(List<ILinkPlayerInfoBridge> r6, Map<Long, ? extends g2> r7, ClientUIInfo r8) {
        tc0.c.h().l(r7);
        if (r6 == null) goto L6;
        r6.size();
    L6:
        if (r6 == null) goto L31;
        Iterator<T> r0 = r6.iterator();
    L9:
        if (r0.hasNext() == false) goto L31;
        ILinkPlayerInfoBridge r1 = (ILinkPlayerInfoBridge) r0.next();
        if (((Boolean) bb0.a.getValue()).booleanValue() == false) goto L29;
        if (r1 == null) goto L29;
        int r2 = ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION;
        r1.setClientUIPosition(ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION);
        if (r8 == null) goto L29;
        CrossRoomLinkmicUIInfo r3 = r8.getCrossRoomLinkmic();
        if (r3 == null) goto L29;
        Map r4 = CrossRoomLinkmicUIInfoMainKt.getUserInfoString(r3);
        if (r4 == null) goto L28;
        IBaseUser r5 = r1.getUser();
        if (r5 == null) goto L24;
        String r9 = r5.getIdString();
    L25:
        UserInfo r10 = (UserInfo) r4.get(r9);
        if (r10 == null) goto L28;
        r2 = (int) r10.getClientPosition();
        goto L28
    L24:
        r9 = null;
    L28:
        r1.setClientUIPosition(r2);
    L29:
        r1.setLinkRoomUser(true);
    L31:
        if ((!gh0.a.f(this.b, r6)) == false) goto L55;
        ((ArrayList) this.b).clear();
        if (r6 == null) goto L35;
        ((ArrayList) this.b).addAll(r6);
    L35:
        j.a r11 = a(c().d());
        boolean r12 = r11.a;
        Iterator<j> r13 = this.e.iterator();
    L37:
        if (r13.hasNext() == false) goto L41;
        r11 = r13.next().a(r11.b);
        if (r11.a == false) goto L37;
        r12 = true;
        goto L37
    L41:
        if (r12 == false) goto L56;
        r11.a = true;
        c().n(r11);
        return;
    L56:
        return;
    }
}
