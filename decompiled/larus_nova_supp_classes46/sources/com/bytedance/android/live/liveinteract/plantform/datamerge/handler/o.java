package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

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
public final class o extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {
    public final List<ILinkPlayerInfoBridge> b;
    public List<LinkmicPositionItem> c;
    public ch0.m d;
    public final b e;
    public final List<h> f;
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> g;
    public final DataCenter h;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
        public final /* synthetic */ o a;

        public b(o r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void e(List<LinkmicPositionItem> r5) {
            boolean r0 = !gh0.a.e(this.a.c, r5);
            gh0.a.b("LinkUserCenterHandler", "call onLockListChanged by linkUserCenter, hasModified = " + r0 + ",  lockList: " + r5, 4);
            if (r0 == false) goto L19;
            o r1 = this.a;
            if (r5 == null) goto L12;
            List<LinkmicPositionItem> r6 = r5;
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator<T> r7 = r6.iterator();
        L8:
            if (r7.hasNext() == false) goto L10;
            r2.add(com.bytedance.android.live.liveinteract.multianchor.model.h.a((LinkmicPositionItem) r7.next()));
            goto L8
        L10:
            List<LinkmicPositionItem> r8 = CollectionsKt.toMutableList(r2);
            if (r8 == null) goto L12;
        L13:
            r1.c = r8;
            com.bytedance.android.live.liveinteract.plantform.datamerge.d r9 = this.a.a();
            List<LinkmicPositionItem> r3 = this.a.c;
            if (r3 != null) goto L16;
            r3 = CollectionsKt.emptyList();
        L16:
            r9.T0(r3);
            return;
        L12:
            r8 = new ArrayList();
            goto L13
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void l(List<ILinkPlayerInfoBridge> r2) {
            Intrinsics.checkNotNullParameter(r2, "list");
            onOnlineListChanged(r2);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r19) {
            Intrinsics.checkNotNullParameter(r19, "list");
            gh0.a.b("LinkUserCenterHandler", "call onOnlineListChanged by linkUserCenter, listSize: " + r19.size(), 4);
            boolean r2 = gh0.a.f(this.a.b, r19) ^ true;
            Lazy r5 = MultiLinkLoadWidgetUtils.a;
            MultiLinkLoadWidgetUtils.n(this.a.h, "LinkUserCenterHandler", "call onOnlineListChanged, listSize: " + r19.size() + ", hasModified = " + r2);
            if (r2 == false) goto L40;
            ((ArrayList) this.a.b).clear();
            ((ArrayList) this.a.b).addAll(r19);
            o r3 = this.a;
            List<ch0.e> r4 = (List) r3.a().f().getValue();
            if (r4 != null) goto L7;
            r4 = CollectionsKt.emptyList();
        L7:
            h.a r6 = r3.b(r4);
            boolean r7 = r6.a;
            Iterator<h> r8 = r3.f.iterator();
        L9:
            if (r8.hasNext() == false) goto L13;
            r6 = r8.next().b(r6.b);
            if (r6.a == false) goto L9;
            r7 = true;
            goto L9
        L13:
            boolean r9 = r6.a;
            List<ch0.e> r10 = r6.b;
            StringBuilder r11 = new StringBuilder("\n");
            int r12 = r10.size();
            int r13 = 0;
        L15:
            if (r13 >= r12) goto L24;
            ch0.e r14 = (ch0.e) ListProtector.get(r10, r13);
            StringBuilder r15 = new StringBuilder("position: ");
            r15.append(r13);
            r15.append(", nickName = ");
            IBaseUser r16 = r14.a.getUser();
            Boolean r17 = null;
            if (r16 == null) goto L19;
            String r18 = r16.getNickName();
        L20:
            r15.append(r18);
            r15.append(", fanTicket = [");
            h.a r110 = r6;
            r15.append(r14.a.getFanTicket());
            r15.append(", ");
            r15.append(r14.a.getFanTicketDisplayStr());
            r15.append(", ");
            r15.append(r14.a.getFuzzyFanTicket());
            r15.append("], isEnlarged = ");
            r15.append(r14.a.isEnlarged());
            r15.append(", isBackground = ");
            r15.append(r14.a.isBackground());
            r15.append(", isMysteryMan = ");
            IBaseUser r20 = r14.a.getUser();
            if (r20 == null) goto L23;
            r17 = Boolean.valueOf(r20.isMysteryMan());
        L23:
            r15.append(r17);
            r15.append(", linkTypeIsVideoOrAvatar = ");
            r15.append(ch0.f.c(r14));
            r15.append(", mediaTypeIsVideoOrAvatar = ");
            r15.append(ch0.f.d(r14));
            r15.append('\n');
            r11.append(r15.toString());
            r13 = r13 + 1;
            r6 = r110;
            goto L15
        L19:
            r18 = null;
            goto L20
        L24:
            h.a r111 = r6;
            gh0.b.a("DataMerge", "onOnlineListChanged:  hasModified = " + r9 + ", " + r11.toString(), false);
            if (r7 == false) goto L27;
            r111.a = true;
            r3.a().v0(r111);
        L27:
            com.bytedance.android.live.liveinteract.plantform.datamerge.d r21 = this.a.a();
            List<? extends ILinkPlayerInfoBridge> r1 = KotlinTypeUtilsKt.castElementType(r19);
            if (r1 != null) goto L30;
            r1 = CollectionsKt.emptyList();
        L30:
            r21.a(r1);
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void d(List<ILinkPlayerInfoBridge> r3, List<ILinkPlayerInfoBridge> r4) {
            Intrinsics.checkNotNullParameter(r3, "list");
            Intrinsics.checkNotNullParameter(r4, "peerList");
            gh0.a.b("LinkUserCenterHandler", "call onLinkRoomOnlineListChanged by linkUserCenter, listSize: " + r3.size() + ", peerListSize: " + r4.size(), 4);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void n(List<ILinkPlayerInfoBridge> r4, long r5, n0 r7) {
            Intrinsics.checkNotNullParameter(r4, "list");
            StringBuilder r0 = new StringBuilder("call onWaitingListChanged by linkUserCenter, listSize: ");
            CopyOnWriteArrayList r6 = (CopyOnWriteArrayList) r4;
            r0.append(r6.size());
            r0.append(", totalCount: ");
            r0.append(r5);
            r0.append(", waitingUserId: ");
            if (r7 == null) goto L7;
            IBaseUser r1 = r7.getUserFlex();
            if (r1 == null) goto L7;
            String r2 = r1.getIdString();
        L8:
            r0.append(r2);
            gh0.a.b("LinkUserCenterHandler", r0.toString(), 4);
            ch0.m r3 = new ch0.m(r6, r5, r7);
            if (Intrinsics.areEqual(this.a.d, r3) == false) goto L12;
            o r8 = this.a;
            r8.d = r3;
            r8.a().D0(this.a.d);
            return;
        L12:
            return;
        L7:
            r2 = null;
            goto L8
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        int r0 = MultiSceneEnterRoomStatisticsUtils.u;
        long r1 = 0;
        MultiSceneEnterRoomStatisticsUtils r2 = MultiSceneEnterRoomStatisticsUtils.a.a(this.h, 0L);
        if (r2 == null) goto L5;
        r2.c();
    L5:
        System.currentTimeMillis();
        this.g.Q4(this.e);
        List<T> r3 = this.g.getOnlineUserList();
        if ((!r3.isEmpty()) == false) goto L8;
        Lazy r4 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(this.h, "LinkUserCenterHandler", "initListData list is not empty, listSize=" + r3.size());
        this.e.onOnlineListChanged(r3);
    L20:
        List<LinkmicPositionItem> r5 = this.g.d();
        if ((!r5.isEmpty()) == false) goto L24;
        this.e.e(r5);
        return;
    L24:
        return;
    L8:
        final long r6 = System.currentTimeMillis();
        IRoomModuleService r7 = jc1.k.f(IRoomModuleService.class);
        if (r7 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.room.backend.g r8 = r7.getLiveRoomBackendUtils();
        if (r8 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.o r9 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.h, null, 2);
        if (r9 == null) goto L19;
        com.bytedance.live.datacontext.m r10 = r9.getRoom();
        if (r10 == null) goto L19;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L19;
        r1 = r11.getId();
    L19:
        r8.f(r1, v0.class, new LinkUserCenterHandler$initListData$1(this, r6));
        goto L20
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.g.T4(this.e);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r14) {
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
        return new h.a(r4, r3, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(List<? extends h> r2, com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "childHandlers");
        Intrinsics.checkNotNullParameter(r3, "linkUserCenter");
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
