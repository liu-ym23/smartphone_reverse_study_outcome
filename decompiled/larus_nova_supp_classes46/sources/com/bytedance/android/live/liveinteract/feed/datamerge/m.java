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
public final class m extends com.bytedance.android.live.liveinteract.feed.datamerge.a {
    public final String b;
    public final List<ch0.j> c;
    public final IRoom d;
    public final a e;

    public interface a {
        IRoom getRoom();
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void attach() {
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void detach() {
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.a, com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final j.a a(List<ch0.e> r13) {
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

    public final void e(SeiAppData r18) {
        Intrinsics.checkNotNullParameter(r18, "sei");
        String r1 = r18.getChannelId();
        IRoom r3 = this.e.getRoom();
        Long r4 = null;
        if (r3 == null) goto L5;
        Long r5 = Long.valueOf(r3.getId());
    L7:
        if ((!Intrinsics.areEqual(r1, String.valueOf(r5))) == false) goto L13;
        String r2 = this.b;
        StringBuilder r6 = new StringBuilder("sei channel id wrong ");
        r6.append(r18.getChannelId());
        r6.append(" room ");
        IRoom r7 = this.e.getRoom();
        if (r7 == null) goto L11;
        r4 = Long.valueOf(r7.getId());
    L11:
        r6.append(r4);
        ALogger.d(r2, r6.toString());
        return;
    L13:
        ArrayList r8 = new ArrayList();
        int r9 = r18.getGrids().size();
        int r10 = 0;
        boolean r11 = false;
    L14:
        if (r10 >= r9) goto L41;
        SeiRegion r12 = (SeiRegion) ListProtector.get(r18.getGrids(), r10);
        Iterator r13 = ((ArrayList) this.c).iterator();
    L17:
        if (r13.hasNext() == false) goto L21;
        Object r14 = r13.next();
        if (Intrinsics.areEqual(((ch0.j) r14).a, r12.getInteractId()) == false) goto L17;
    L22:
        ch0.j r15 = (ch0.j) r14;
        if (r15 != null) goto L25;
        r8.add(new ch0.j(r12.getInteractId(), r12.isTalking(), r12.getType(), r12.position, true));
    L39:
        r11 = true;
    L40:
        r10 = r10 + 1;
        goto L14
    L25:
        if (r12.getType() != r15.c) goto L32;
        if (r12.position != r15.d) goto L32;
        if (r12.isTalking() != r15.b) goto L32;
        r8.add(r15);
    L32:
        if (r12.getType() == r15.c) goto L34;
    L37:
        r8.add(ch0.j.a(r15, false, r12.getType(), r12.position, false, 19));
        goto L39
    L34:
        if (r12.position != r15.d) goto L37;
        r8.add(ch0.j.a(r15, r12.isTalking(), 0, 0, false, 29));
        goto L39
    L21:
        r14 = null;
        goto L22
    L41:
        if (r11 == false) goto L43;
    L44:
        ((ArrayList) this.c).clear();
        ((ArrayList) this.c).addAll(r8);
    L45:
        if (r11 == false) goto L62;
        k r16 = this.a;
        if (r16 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L49:
        j.a r17 = a(r16.d());
        if (r17.a == false) goto L63;
        k r19 = this.a;
        if (r19 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L54:
        r19.n(r17);
        return;
    L63:
        return;
    L62:
        return;
    L43:
        if (r8.isEmpty() == false) goto L45;
    L5:
        r5 = null;
        goto L7
    }

    public m(IRoom r2, a r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.d = r2;
        this.e = r3;
        this.b = "RemoteFeedViewSeiHandler";
        this.c = new ArrayList();
    }
}
