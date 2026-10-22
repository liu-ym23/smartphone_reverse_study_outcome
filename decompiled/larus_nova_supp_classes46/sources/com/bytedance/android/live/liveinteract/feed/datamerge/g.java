package com.bytedance.android.live.liveinteract.feed.datamerge;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends a {
    public final List<ILinkPlayerInfoBridge> b;
    public final List<ILinkPlayerInfoBridge> c;
    public List<LinkmicPositionItem> d;
    public final List<j> e;

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void attach() {
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void detach() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(List<? extends j> r2) {
        Intrinsics.checkNotNullParameter(r2, "childHandlers");
        this.e = r2;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
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

    public final void e(List<? extends LinkmicPositionItem> r3) {
        if ((!gh0.a.e(this.d, r3)) == false) goto L18;
        if (r3 == null) goto L11;
        List<? extends LinkmicPositionItem> r4 = r3;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r0.add(com.bytedance.android.live.liveinteract.multianchor.model.h.a((LinkmicPositionItem) r5.next()));
        goto L7
    L9:
        List<LinkmicPositionItem> r6 = CollectionsKt.toMutableList(r0);
        if (r6 == null) goto L11;
    L12:
        this.d = r6;
        k r7 = c();
        List<LinkmicPositionItem> r1 = this.d;
        if (r1 != null) goto L15;
        r1 = CollectionsKt.emptyList();
    L15:
        r7.p(r1);
        return;
    L11:
        r6 = new ArrayList();
        goto L12
    }

    public final void f(List<ILinkPlayerInfoBridge> r5) {
        if ((!gh0.a.f(this.b, r5)) == false) goto L21;
        ((ArrayList) this.b).clear();
        if (r5 == null) goto L7;
        ((ArrayList) this.b).addAll(r5);
    L7:
        j.a r6 = b(c().o());
        boolean r0 = r6.a;
        Iterator<j> r2 = this.e.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        r6 = r2.next().b(r6.b);
        if (r6.a == false) goto L9;
        r0 = true;
        goto L9
    L13:
        if (r0 == false) goto L22;
        r6.a = true;
        c().t(r6);
        return;
    L22:
        return;
    }
}
