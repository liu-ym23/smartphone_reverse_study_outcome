package com.bytedance.android.live.profit.dress;

import io.reactivex.Completable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements Action {
    public final /* synthetic */ List a;
    public final /* synthetic */ String b;

    public static final class a implements Action {
        public final /* synthetic */ h a;
        public final /* synthetic */ iz0.a b;

        public a(h r1, iz0.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            jy0.b.f("DressKevaUtils", "store on complete", null, 4);
            this.b.g(this.a.b);
            iz0.a r0 = i.a;
            i.c = this.a.b;
        }
    }

    public h(List r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        p r0 = (p) CollectionsKt.firstOrNull(this.a);
        if (r0 == null) goto L5;
        byte[] r1 = r0.getPbBytes();
    L6:
        if (r1 == null) goto L8;
        boolean r2 = true;
    L9:
        jy0.b.f("DressKevaUtils", "write " + this.a.size() + " models to storage. isPb=" + r2 + ", version=" + this.b, null, 4);
        Boolean r3 = Boolean.valueOf(r2);
        iz0.a r4 = i.a;
        iz0.a r5 = i.b;
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == true) goto L13;
        r4 = r5;
    L13:
        List r6 = this.a;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
    L15:
        if (r8.hasNext() == false) goto L21;
        p r9 = (p) r8.next();
        if (r2 == false) goto L19;
        Pair r10 = TuplesKt.to(r9.getDecoded().getDressId(), r9.getPbBytes());
    L20:
        r7.add(r10);
        goto L15
    L19:
        r10 = TuplesKt.to(r9.getDecoded().getDressId(), r9.getJsonString());
        goto L20
    L21:
        Completable r12 = r4.c(MapsKt.toMap(CollectionsKt.asSequence(r7)));
        int r13 = com.bytedance.revenue.platform.api.core.rx.p.a;
        r12.observeOn(Schedulers.io()).subscribe(new a(this, r4));
        return;
    L8:
        r2 = false;
        goto L9
    L5:
        r1 = null;
        goto L6
    }
}
