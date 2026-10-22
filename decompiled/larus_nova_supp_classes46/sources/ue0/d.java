package ue0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.feed.datamerge.j;
import com.bytedance.android.live.liveinteract.feed.datamerge.k;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.multianchor.model.h;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.config.bb0;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.crossroom.CrossRoomLinkmicUIInfo;
import com.bytedance.android.livesdkapi.depend.message.crossroom.CrossRoomLinkmicUIInfoMainKt;
import com.bytedance.android.livesdkapi.depend.message.crossroom.UserInfo;
import com.bytedance.android.livesdkapi.depend.message.wrds.MultiPreviewSyncDataType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContent;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.android.livesdkapi.service.MessageHub;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends com.bytedance.android.live.liveinteract.feed.datamerge.a implements l, OnWRDSDataUpdateListener {
    public final List<ILinkPlayerInfoBridge> b;
    public final List<ILinkPlayerInfoBridge> c;
    public List<LinkmicPositionItem> d;
    public final CompositeDisposable e;
    public ylc.c f;
    public final List<j> g;
    public final IPreviewMultiLinkOuterConfigProvider h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void attach() {
        this.h.printALogger("LivePreviewMultiLinkOnlineUserListHandler", hashCode(), "attach: MessageHub = " + c().getMessageHub(), true);
        MessageHub r0 = c().getMessageHub();
        if (r0 == null) goto L5;
        r0.addMessageListener(MessageType.LINKER.getKey(), this);
    L5:
        MessageHub r1 = c().getMessageHub();
        if (r1 == null) goto L8;
        r1.addMessageListener(MessageType.LINK_MIC.getKey(), this);
    L8:
        MessageHub r2 = c().getMessageHub();
        if (r2 == null) goto L11;
        r2.addWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, this, true);
    L11:
        IRoom r3 = this.h.getRoom();
        LinkAnchorApi r4 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        long r5 = r3.getId();
        long r6 = d5.c(r3.getAnchorId());
        String r7 = r3.getAnchorId();
        if (r7 != null) goto L14;
        r7 = "";
    L14:
        this.e.add(r4.getLinkListV2(r5, r6, r7, true, r3.isOfficialChannelRoom()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), new f(this)));
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void detach() {
        this.h.printALogger("LivePreviewMultiLinkOnlineUserListHandler", hashCode(), "detach: MessageHub = " + c().getMessageHub(), true);
        MessageHub r0 = c().getMessageHub();
        if (r0 == null) goto L5;
        r0.removeMessageListener(MessageType.LINKER.getKey(), this);
    L5:
        MessageHub r1 = c().getMessageHub();
        if (r1 == null) goto L8;
        r1.removeMessageListener(MessageType.LINK_MIC.getKey(), this);
    L8:
        MessageHub r2 = c().getMessageHub();
        if (r2 == null) goto L11;
        r2.removeWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, this);
    L11:
        this.e.clear();
    }

    public final ylc.c getDataSyncListener() {
        return this.f;
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
        List<ILinkPlayerInfoBridge> r17 = this.c;
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

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.a, com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final j.a b(List<ch0.e> r14) {
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

    public final void e(List<? extends LinkmicPositionItem> r8) {
        boolean r0 = !gh0.a.e(this.d, r8);
        IPreviewMultiLinkOuterConfigProvider r2 = this.h;
        int r3 = hashCode();
        StringBuilder r4 = new StringBuilder("onLockListChanged: hasModified = ");
        r4.append(r0);
        r4.append(", oldList = ");
        List<LinkmicPositionItem> r5 = this.d;
        Integer r6 = null;
        if (r5 == null) goto L5;
        Integer r7 = Integer.valueOf(r5.size());
    L6:
        r4.append(r7);
        r4.append(", newList = ");
        if (r8 == null) goto L9;
        r6 = Integer.valueOf(r8.size());
    L9:
        r4.append(r6);
        r2.printALogger("LivePreviewMultiLinkOnlineUserListHandler", r3, r4.toString(), true);
        if (r0 == false) goto L25;
        if (r8 == null) goto L18;
        List<? extends LinkmicPositionItem> r9 = r8;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L14:
        if (r10.hasNext() == false) goto L16;
        r1.add(h.a((LinkmicPositionItem) r10.next()));
        goto L14
    L16:
        List<LinkmicPositionItem> r11 = CollectionsKt.toMutableList(r1);
        if (r11 == null) goto L18;
    L19:
        this.d = r11;
        k r12 = c();
        List<LinkmicPositionItem> r13 = this.d;
        if (r13 != null) goto L22;
        r13 = CollectionsKt.emptyList();
    L22:
        r12.p(r13);
        return;
    L18:
        r11 = new ArrayList();
        goto L19
    L25:
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final void onMessage(tlc.d r4) {
        if (this.h.getFeedLiveType() == 5) goto L6;
        return;
    L6:
        if ((r4 instanceof h1) == false) goto L20;
        h1 r5 = (h1) r4;
        if (r5.getMType() != 12) goto L21;
        ILinkerUpdateUserContent r0 = r5.getMUpdateUser();
        ClientUIInfo r1 = null;
        if (r0 == null) goto L14;
        List r2 = r0.getMLinkUsers();
        if (r2 == null) goto L14;
        ArrayList<ILinkPlayerInfoBridge> r3 = je0.d.f0(r2, false);
    L15:
        ILinkerUpdateUserContent r6 = r5.getMUpdateUser();
        if (r6 == null) goto L18;
        r1 = r6.getClientUiInfo();
    L18:
        f(r3, r1);
        return;
    L14:
        r3 = null;
        goto L15
    L21:
        return;
    }

    public final void setDataSyncListener(ylc.c r1) {
        this.f = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends j> r2, IPreviewMultiLinkOuterConfigProvider r3) {
        Intrinsics.checkNotNullParameter(r2, "childHandlers");
        Intrinsics.checkNotNullParameter(r3, "configProvider");
        this.g = r2;
        this.h = r3;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new CompositeDisposable();
    }

    public final void f(List<ILinkPlayerInfoBridge> r8, ClientUIInfo r9) {
        boolean r0 = !gh0.a.f(this.b, r8);
        IPreviewMultiLinkOuterConfigProvider r2 = this.h;
        int r3 = hashCode();
        StringBuilder r4 = new StringBuilder("onOnlineListChanged: hasModified = ");
        r4.append(r0);
        r4.append(", oldList = ");
        r4.append(((ArrayList) this.b).size());
        r4.append(", newList = ");
        if (r8 == null) goto L5;
        Integer r6 = Integer.valueOf(r8.size());
    L6:
        r4.append(r6);
        r2.printALogger("LivePreviewMultiLinkOnlineUserListHandler", r3, r4.toString(), true);
        if (r0 == false) goto L58;
        ((ArrayList) this.b).clear();
        if (r8 == null) goto L33;
        ((ArrayList) this.b).addAll(r8);
        Iterator<T> r1 = r8.iterator();
    L12:
        if (r1.hasNext() == false) goto L32;
        ILinkPlayerInfoBridge r5 = (ILinkPlayerInfoBridge) r1.next();
        if (((Boolean) bb0.a.getValue()).booleanValue() == false) goto L12;
        if (r5 == null) goto L12;
        int r7 = ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION;
        r5.setClientUIPosition(ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION);
        if (r9 == null) goto L12;
        CrossRoomLinkmicUIInfo r10 = r9.getCrossRoomLinkmic();
        if (r10 == null) goto L12;
        Map r11 = CrossRoomLinkmicUIInfoMainKt.getUserInfoString(r10);
        if (r11 == null) goto L31;
        IBaseUser r12 = r5.getUser();
        if (r12 == null) goto L27;
        String r13 = r12.getIdString();
    L28:
        UserInfo r14 = (UserInfo) r11.get(r13);
        if (r14 == null) goto L31;
        r7 = (int) r14.getClientPosition();
        goto L31
    L27:
        r13 = null;
    L31:
        r5.setClientUIPosition(r7);
        goto L12
    L32:
        c().a(r8);
    L33:
        j.a r15 = b(c().o());
        boolean r16 = r15.a;
        Iterator<j> r17 = this.g.iterator();
    L35:
        if (r17.hasNext() == false) goto L39;
        r15 = r17.next().b(r15.b);
        if (r15.a == false) goto L35;
        r16 = true;
        goto L35
    L39:
        if (r16 == false) goto L59;
        r15.a = true;
        c().t(r15);
        return;
    L59:
        return;
    L58:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void onWRDSDataUpdate(String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "syncKey");
        if (((Boolean) vm2.d.y2.getValue(null, vm2.d.a[178(0xb2, float:2.5E-43)])).booleanValue() == false) goto L8;
        if (this.h.getRoom().isOfficialChannelRoom() == false) goto L8;
        return;
    L8:
        if ((r4 instanceof IRoomLinkMicSyncData) == true) goto L10;
        r4 = null;
    L10:
        IRoomLinkMicSyncData r5 = (IRoomLinkMicSyncData) r4;
        if (r5 == null) goto L17;
        List r6 = r5.getMLinkUsers();
        if (r6 == null) goto L15;
        f(je0.d.f0(r6, false), r5.getClientUIInfo());
    L15:
        e(r5.getLockedPositions());
        return;
    }
}
