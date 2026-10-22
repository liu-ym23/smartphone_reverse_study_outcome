package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends eh0.a {
    public final List<ILinkPlayerInfoBridge> b;
    public final C0057b c;
    public final List<eh0.c> d;
    public final com.bytedance.android.live.liveinteract.plantform.datamergev2.d e;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.b$b, reason: collision with other inner class name */
    public static final class C0057b extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
        public final /* synthetic */ b a;

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void l(List<ILinkPlayerInfoBridge> r2) {
            Intrinsics.checkNotNullParameter(r2, "list");
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r2) {
            Intrinsics.checkNotNullParameter(r2, "list");
        }

        public C0057b(b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void d(List<ILinkPlayerInfoBridge> r9, List<ILinkPlayerInfoBridge> r10) {
            Intrinsics.checkNotNullParameter(r9, "list");
            Intrinsics.checkNotNullParameter(r10, "peerList");
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d r1 = this.a.e;
            if (r1 == null) goto L5;
            com.bytedance.android.live.liveinteract.plantform.datamergev2.d.a.a(r1, "RemoteLinkUserCenterHandlerV2", hashCode(), "call onLinkRoomOnlineListChanged by linkUserCenter, listSize: " + r9.size() + ", peerListSize: " + r10.size(), false, 24);
        L5:
            Iterator<T> r11 = r10.iterator();
        L7:
            if (r11.hasNext() == false) goto L9;
            ILinkPlayerInfoBridge r0 = (ILinkPlayerInfoBridge) r11.next();
            r0.setLinkRoomUser(true);
            int r2 = tc0.e.a;
            tc0.e.b(r0, tc0.c.h().o);
            goto L7
        L9:
            boolean r12 = !gh0.a.f(r10, this.a.b);
            this.a.getClass();
            StringBuilder r3 = new StringBuilder("\n");
            int r4 = r10.size();
            int r5 = 0;
        L10:
            if (r5 >= r4) goto L16;
            ILinkPlayerInfoBridge r6 = (ILinkPlayerInfoBridge) ListProtector.get(r10, r5);
            StringBuilder r7 = new StringBuilder("position: ");
            r7.append(r5);
            r7.append(", GuestItemData, nickName = ");
            IBaseUser r8 = r6.getUser();
            if (r8 == null) goto L14;
            String r13 = r8.getNickName();
        L15:
            r7.append(r13);
            r7.append(", linkType = ");
            r7.append(r6.getLinkType());
            r7.append('\n');
            r3.append(r7.toString());
            r5 = r5 + 1;
            goto L10
        L14:
            r13 = null;
            goto L15
        L16:
            gh0.b.a("DataMerge", "onOnlineListChanged:  hasModified = " + r12 + ", " + r3.toString(), false);
            if (r12 == false) goto L36;
            ((ArrayList) this.a.b).clear();
            ((ArrayList) this.a.b).addAll(r10);
            b r14 = this.a;
            com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a r15 = r14.a(r14.b().d());
            boolean r16 = r15.a;
            Iterator<eh0.c> r17 = r14.d.iterator();
        L20:
            if (r17.hasNext() == false) goto L24;
            r15 = r17.next().a(r15.b);
            if (r15.a == false) goto L20;
            r16 = true;
            goto L20
        L24:
            if (r16 == false) goto L37;
            r15.a = true;
            r14.b().m(r15);
            return;
        L37:
            return;
        }
    }

    static {
    }

    @Override // eh0.c
    public final void attach() {
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r0 = this.e;
        if (r0 == null) goto L6;
        r0.f(this.c);
        return;
    }

    @Override // eh0.c
    public final void detach() {
        com.bytedance.android.live.liveinteract.plantform.datamergev2.d r0 = this.e;
        if (r0 == null) goto L6;
        r0.k(this.c);
        return;
    }

    @Override // eh0.a, eh0.c
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a a(List<ch0.e> r15) {
        Intrinsics.checkNotNullParameter(r15, "oldMergeDataList");
        List<ch0.e> r0 = r15;
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator<T> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Object r2 = r1.next();
        r3.put(((ch0.e) r2).a.getInteractId(), r2);
        goto L4
    L6:
        List<ILinkPlayerInfoBridge> r4 = this.b;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = ((ArrayList) r4).iterator();
        boolean r7 = false;
        ch0.e r8 = null;
    L7:
        boolean r9 = true;
        if (r6.hasNext() == false) goto L26;
        ILinkPlayerInfoBridge r10 = (ILinkPlayerInfoBridge) r6.next();
        ch0.e r11 = (ch0.e) r3.get(r10.getInteractId());
        if (r11 != null) goto L12;
        ch0.e r12 = new ch0.e(r10);
    L16:
        IBaseUser r13 = r12.a.getUser();
        if (r13 == null) goto L19;
        String r14 = r13.getIdString();
    L21:
        if (Intrinsics.areEqual(r14, gh0.a.c()) == false) goto L24;
        if (r12 == r11) goto L24;
        r8 = r12;
    L24:
        r5.add(r12);
        r7 = r9;
        goto L7
    L19:
        r14 = null;
        goto L21
    L12:
        if (r11.b(r10) == false) goto L14;
        r9 = r7;
        r12 = r11;
        goto L16
    L14:
        r12 = ch0.e.a(r11, r10, null, null, null, 14);
        goto L16
    L26:
        if ((!r15.isEmpty()) == false) goto L31;
        if (((ArrayList) this.b).isEmpty() == false) goto L31;
        r7 = true;
    L31:
        return new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a(r7, r5, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends eh0.c> r2, com.bytedance.android.live.liveinteract.plantform.datamergev2.d r3) {
        Intrinsics.checkNotNullParameter(r2, "remoteChildHandlers");
        this.d = r2;
        this.e = r3;
        this.b = new ArrayList();
        this.c = new C0057b(this);
    }
}
