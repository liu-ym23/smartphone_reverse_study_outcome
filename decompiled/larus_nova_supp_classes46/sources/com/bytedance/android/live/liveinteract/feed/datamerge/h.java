package com.bytedance.android.live.liveinteract.feed.datamerge;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
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
public final class h extends a {
    public final String b;
    public final List<ch0.j> c;
    public int d;
    public final com.bytedance.android.live.liveinteract.plantform.datamergev2.c e;

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void attach() {
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void detach() {
    }

    public h(com.bytedance.android.live.liveinteract.plantform.datamergev2.c r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.e = r2;
        this.b = "FeedViewSeiHandler";
        this.c = new ArrayList();
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.a, com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final j.a b(List<ch0.e> r13) {
        Intrinsics.checkNotNullParameter(r13, "oldMergeDataList");
        List<ch0.j> r0 = this.c;
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = ((ArrayList) r0).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Object r2 = r1.next();
        r3.put(((ch0.j) r2).a, r2);
        goto L4
    L6:
        List<ch0.e> r14 = r13;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
        boolean r5 = false;
        ch0.e r6 = null;
    L8:
        if (r15.hasNext() == false) goto L23;
        ch0.e r7 = (ch0.e) r15.next();
        ch0.j r9 = (ch0.j) r3.get(r7.a.getInteractId());
        if (r7.d(r9) == false) goto L12;
        boolean r8 = r5;
        ch0.e r10 = r7;
    L13:
        IBaseUser r11 = r10.a.getUser();
        if (r11 == null) goto L16;
        String r12 = r11.getIdString();
    L18:
        if (Intrinsics.areEqual(r12, gh0.a.c()) == false) goto L21;
        if (r10 == r7) goto L21;
        r6 = r10;
    L21:
        r4.add(r10);
        r5 = r8;
        goto L8
    L16:
        r12 = null;
        goto L18
    L12:
        r10 = ch0.e.a(r7, null, null, r9, null, 11);
        r8 = true;
        goto L13
    L23:
        return new j.a(r5, r4, r6);
    }

    public final void e(SeiAppData r19) {
        Intrinsics.checkNotNullParameter(r19, "sei");
        String r1 = r19.getChannelId();
        IRoom r3 = this.e.getRoom();
        Long r4 = null;
        if (r3 == null) goto L5;
        Long r5 = Long.valueOf(r3.getId());
    L6:
        boolean r2 = Intrinsics.areEqual(r1, String.valueOf(r5));
        boolean r6 = true;
        if ((!r2) == false) goto L13;
        String r7 = this.b;
        StringBuilder r8 = new StringBuilder("sei channel id wrong ");
        r8.append(r19.getChannelId());
        r8.append(" room ");
        IRoom r9 = this.e.getRoom();
        if (r9 == null) goto L11;
        r4 = Long.valueOf(r9.getId());
    L11:
        r8.append(r4);
        ALogger.d(r7, r8.toString());
        return;
    L13:
        ArrayList r10 = new ArrayList();
        int r11 = r19.getGrids().size();
        int r12 = 0;
        boolean r13 = false;
        boolean r14 = false;
    L14:
        if (r12 >= r11) goto L44;
        SeiRegion r15 = (SeiRegion) ListProtector.get(r19.getGrids(), r12);
        Iterator r16 = ((ArrayList) this.c).iterator();
    L17:
        if (r16.hasNext() == false) goto L21;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((ch0.j) r17).a, r15.getInteractId()) == false) goto L17;
    L22:
        ch0.j r18 = (ch0.j) r17;
        if (r18 != null) goto L25;
        r10.add(new ch0.j(r15.getInteractId(), r15.isTalking(), r15.getType(), r15.position, r15.isVisible()));
    L41:
        r13 = true;
        r14 = true;
    L42:
        r12 = r12 + 1;
        goto L14
    L25:
        if (r15.getType() != r18.c) goto L34;
        if (r15.position != r18.d) goto L34;
        if (r15.isTalking() != r18.b) goto L34;
        if (r15.isVisible() != r18.e) goto L34;
        r10.add(r18);
    L34:
        if (r15.getType() == r18.c) goto L36;
    L39:
        r10.add(ch0.j.a(r18, false, r15.getType(), r15.position, r15.isVisible(), 3));
        goto L41
    L36:
        if (r15.position != r18.d) goto L39;
        r10.add(ch0.j.a(r18, r15.isTalking(), 0, 0, r15.isVisible(), 13));
        r13 = true;
        goto L42
    L21:
        r17 = null;
        goto L22
    L44:
        if (((ArrayList) this.c).size() == r10.size()) goto L46;
        r14 = true;
    L47:
        if (r6 == false) goto L49;
    L50:
        ((ArrayList) this.c).clear();
        ((ArrayList) this.c).addAll(r10);
    L52:
        if (this.d == r19.getStyle()) goto L54;
        int r20 = r19.getStyle();
        this.d = r20;
        this.e.b(r20);
    L54:
        if (r6 == false) goto L64;
        k r21 = this.a;
        if (r21 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L58:
        j.a r22 = b(r21.o());
        if (r22.a == false) goto L64;
        k r23 = this.a;
        if (r23 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L63:
        r23.t(r22);
    L64:
        if (r14 == false) goto L74;
        this.e.a();
        return;
    L74:
        return;
    L49:
        if (r10.isEmpty() == false) goto L52;
    L46:
        r6 = r13;
        goto L47
    L5:
        r5 = null;
        goto L6
    }
}
