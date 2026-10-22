package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b1<T> implements Consumer {
    public final /* synthetic */ d1 a;
    public final /* synthetic */ Ref.ObjectRef b;

    public b1(d1 r1, Ref.ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        d1 r4 = this.a;
        r4.j = 2;
        GiftDataStorageService r0 = (GiftDataStorageService) this.b.element;
        if (r0 == null) goto L5;
        int r1 = r0.p;
    L6:
        if (r1 > 0) goto L9;
        r4.f("GiftListRoomService-Timer");
        return;
    L9:
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
