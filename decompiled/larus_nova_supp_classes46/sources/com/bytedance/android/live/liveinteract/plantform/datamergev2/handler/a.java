package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.model.v0;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {
    public final List<ILinkPlayerInfoBridge> b;
    public List<LinkmicPositionItem> c;
    public ch0.m d;
    public final b e;
    public final List<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> f;
    public final com.bytedance.android.live.liveinteract.plantform.datamergev2.d g;
    public final DataCenter h;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.a$a, reason: collision with other inner class name */
    public static final class C0056a {
    }

    public static final class b extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void e(List<? extends LinkmicPositionItem> r9) {
            boolean r0 = !gh0.a.e(this.a.c, r9);
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r2 = this.a.g;
            if (r2 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r2, "LinkUserCenterHandlerV2", hashCode(), "call onLockListChanged by linkUserCenter, hasModified = " + r0 + ",  lockList: " + r9, false, 24);
        L5:
            if (r0 == false) goto L21;
            a r1 = this.a;
            if (r9 == null) goto L14;
            List<? extends LinkmicPositionItem> r10 = r9;
            ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
            Iterator<T> r11 = r10.iterator();
        L10:
            if (r11.hasNext() == false) goto L12;
            r3.add(com.bytedance.android.live.liveinteract.multianchor.model.h.a((LinkmicPositionItem) r11.next()));
            goto L10
        L12:
            List<LinkmicPositionItem> r12 = CollectionsKt.toMutableList(r3);
            if (r12 == null) goto L14;
        L15:
            r1.c = r12;
            com.bytedance.android.live.liveinteract.plantform.datamerge.d r13 = this.a.a();
            List<LinkmicPositionItem> r4 = this.a.c;
            if (r4 != null) goto L18;
            r4 = CollectionsKt.emptyList();
        L18:
            r13.T0(r4);
            return;
        L14:
            r12 = new ArrayList();
            goto L15
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void l(List<ILinkPlayerInfoBridge> r2) {
            Intrinsics.checkNotNullParameter(r2, "list");
            onOnlineListChanged(r2);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r19) {
            Intrinsics.checkNotNullParameter(r19, "list");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r3 = this.a.g;
            if (r3 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r3, "LinkUserCenterHandlerV2", hashCode(), "call onOnlineListChanged by linkUserCenter, listSize: " + r19.size(), false, 24);
        L5:
            boolean r2 = !gh0.a.f(this.a.b, r19);
            Lazy r4 = MultiLinkLoadWidgetUtils.a;
            MultiLinkLoadWidgetUtils.n(this.a.h, "LinkUserCenterHandlerV2", "call onOnlineListChanged, listSize: " + r19.size() + ", hasModified = " + r2);
            if (r2 == false) goto L45;
            ((ArrayList) this.a.b).clear();
            ((ArrayList) this.a.b).addAll(r19);
            a r5 = this.a;
            BehaviorSubject<List<ch0.e>> r6 = r5.a().f();
            if (r6 == null) goto L11;
            List<ch0.e> r7 = (List) r6.getValue();
            if (r7 == null) goto L11;
        L12:
            com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a r8 = r5.b(r7);
            boolean r9 = r8.a;
            Iterator<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> r10 = r5.f.iterator();
        L14:
            if (r10.hasNext() == false) goto L18;
            r8 = r10.next().b(r8.b);
            if (r8.a == false) goto L14;
            r9 = true;
            goto L14
        L18:
            boolean r11 = r8.a;
            List<ch0.e> r12 = r8.b;
            StringBuilder r13 = new StringBuilder("\n");
            int r14 = r12.size();
            int r15 = 0;
        L20:
            if (r15 >= r14) goto L29;
            ch0.e r16 = (ch0.e) ListProtector.get(r12, r15);
            StringBuilder r17 = new StringBuilder("position: ");
            r17.append(r15);
            r17.append(", nickName = ");
            IBaseUser r18 = r16.a.getUser();
            Boolean r110 = null;
            if (r18 == null) goto L24;
            String r111 = r18.getNickName();
        L25:
            r17.append(r111);
            r17.append(", fanTicket = [");
            com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a r112 = r8;
            r17.append(r16.a.getFanTicket());
            r17.append(", ");
            r17.append(r16.a.getFanTicketDisplayStr());
            r17.append(", ");
            r17.append(r16.a.getFuzzyFanTicket());
            r17.append("], isEnlarged = ");
            r17.append(r16.a.isEnlarged());
            r17.append(", isBackground = ");
            r17.append(r16.a.isBackground());
            r17.append(", isMysteryMan = ");
            IBaseUser r20 = r16.a.getUser();
            if (r20 == null) goto L28;
            r110 = Boolean.valueOf(r20.isMysteryMan());
        L28:
            r17.append(r110);
            r17.append(", linkTypeIsVideoOrAvatar = ");
            r17.append(ch0.f.c(r16));
            r17.append(", mediaTypeIsVideoOrAvatar = ");
            r17.append(ch0.f.d(r16));
            r17.append('\n');
            r13.append(r17.toString());
            r15 = r15 + 1;
            r8 = r112;
            goto L20
        L24:
            r111 = null;
            goto L25
        L29:
            com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a r113 = r8;
            gh0.b.a("DataMerge", "onOnlineListChanged:  hasModified = " + r11 + ", " + r13.toString(), false);
            if (r9 == false) goto L32;
            r113.a = true;
            r5.a().v0(r113);
        L32:
            com.bytedance.android.live.liveinteract.plantform.datamerge.d r21 = this.a.a();
            List<? extends ILinkPlayerInfoBridge> r1 = KotlinTypeUtilsKt.castElementType(r19);
            if (r1 != null) goto L35;
            r1 = CollectionsKt.emptyList();
        L35:
            r21.a(r1);
            return;
        L11:
            r7 = CollectionsKt.emptyList();
            goto L12
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void d(List<ILinkPlayerInfoBridge> r8, List<ILinkPlayerInfoBridge> r9) {
            Intrinsics.checkNotNullParameter(r8, "list");
            Intrinsics.checkNotNullParameter(r9, "peerList");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.g;
            if (r1 == null) goto L6;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "LinkUserCenterHandlerV2", hashCode(), "call onLinkRoomOnlineListChanged by linkUserCenter, listSize: " + r8.size() + ", peerListSize: " + r9.size(), false, 24);
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void n(List<ILinkPlayerInfoBridge> r8, long r9, n0 r11) {
            Intrinsics.checkNotNullParameter(r8, "list");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.g;
            if (r1 == null) goto L11;
            int r3 = hashCode();
            StringBuilder r0 = new StringBuilder("call onWaitingListChanged by linkUserCenter, listSize: ");
            r0.append(((CopyOnWriteArrayList) r8).size());
            r0.append(", totalCount: ");
            r0.append(r9);
            r0.append(", waitingUserId: ");
            if (r11 == null) goto L9;
            IBaseUser r4 = r11.getUserFlex();
            if (r4 == null) goto L9;
            String r5 = r4.getIdString();
        L10:
            r0.append(r5);
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "LinkUserCenterHandlerV2", r3, r0.toString(), false, 24);
        L9:
            r5 = null;
        L11:
            ch0.m r2 = new ch0.m(r8, r9, r11);
            if (Intrinsics.areEqual(this.a.d, r2) == false) goto L15;
            a r10 = this.a;
            r10.d = r2;
            r10.a().D0(this.a.d);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        int r0 = MultiSceneEnterRoomStatisticsUtils.u;
        long r1 = 0;
        MultiSceneEnterRoomStatisticsUtils r2 = MultiSceneEnterRoomStatisticsUtils.a.a(this.h, 0L);
        if (r2 == null) goto L5;
        r2.c();
    L5:
        System.currentTimeMillis();
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r3 = this.g;
        if (r3 == null) goto L8;
        r3.f(this.e);
    L8:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r4 = this.g;
        if (r4 != null) goto L11;
    L28:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r5 = this.g;
        if (r5 == null) goto L34;
        r5.j(true);
        return;
    L34:
        return;
    L11:
        if (r4.getShowFrom() != 0) goto L28;
        List<ILinkPlayerInfoBridge> r6 = this.g.getOnlineList();
        if ((!r6.isEmpty()) == false) goto L15;
        Lazy r7 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(this.h, "LinkUserCenterHandlerV2", "initListData list is not empty, listSize=" + r6.size());
        this.e.onOnlineListChanged(r6);
    L25:
        List<LinkmicPositionItem> r8 = this.g.d();
        if ((!r8.isEmpty()) == false) goto L32;
        this.e.e(r8);
        return;
    L32:
        return;
    L15:
        final long r9 = System.currentTimeMillis();
        IRoomModuleService r10 = jc1.k.f(IRoomModuleService.class);
        if (r10 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.room.backend.g r11 = r10.getLiveRoomBackendUtils();
        if (r11 == null) goto L25;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r12 = this.g;
        if (r12 == null) goto L24;
        IRoom r13 = r12.getRoom();
        if (r13 == null) goto L24;
        r1 = r13.getId();
    L24:
        r11.f(r1, v0.class, new LinkUserCenterHandlerV2$initListData$1(this, r9));
        goto L25
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r0 = this.g;
        if (r0 == null) goto L6;
        r0.k(this.e);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a b(List<ch0.e> r14) {
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
        return new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a(r4, r3, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> r2, com.bytedance.android.live.liveinteract.plantform.datamergev2.d r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "childHandlers");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.b = new ArrayList();
        this.c = new ArrayList();
        int r5 = ch0.m.d;
        this.d = ch0.m.a.a();
        this.e = new b(this);
    }
}
