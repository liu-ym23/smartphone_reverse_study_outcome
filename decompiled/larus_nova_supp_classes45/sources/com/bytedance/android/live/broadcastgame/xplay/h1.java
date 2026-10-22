package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.Completable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h1 extends k {
    public final String c;

    @Override // com.bytedance.android.live.broadcastgame.xplay.j1
    public final String getName() {
        return this.c;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.k
    public final Completable b(Collection<? extends l1> r3) {
        Intrinsics.checkNotNullParameter(r3, "components");
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0.add(((l1) r4.next()).a());
        goto L4
    L7:
        return Completable.concat(r0);
    }

    public h1(List r3, Function2 r4) {
        Intrinsics.checkNotNullParameter(r3, "tasks");
        Intrinsics.checkNotNullParameter("root", "name");
        super(r3, r4);
        this.c = "root";
    }
}
