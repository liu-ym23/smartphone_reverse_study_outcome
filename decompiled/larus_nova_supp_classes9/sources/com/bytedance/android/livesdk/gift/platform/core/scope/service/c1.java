package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c1<T> implements Consumer {
    public final /* synthetic */ d1 a;
    public final /* synthetic */ Ref.ObjectRef b;

    public c1(d1 r1, Ref.ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        int r0 = 0;
        if (com.bytedance.android.livesdk.gift.platform.business.i.l().m0() == false) goto L13;
        i12.e r6 = i12.o.b();
        if (r6 == null) goto L7;
        Object r7 = com.bytedance.android.scope.m.e.d(r6, com.bytedance.android.livesdk.gift.platform.core.giftlist.h.class);
    L8:
        com.bytedance.android.livesdk.gift.platform.core.giftlist.h r8 = (com.bytedance.android.livesdk.gift.platform.core.giftlist.h) r7;
        if (r8 == null) goto L13;
        boolean r1 = true;
        if (r8.Si() != true) goto L13;
    L14:
        GiftDataStorageService r9 = (GiftDataStorageService) this.b.element;
        if (r9 == null) goto L17;
        r0 = r9.p;
    L17:
        if (r0 > 0) goto L22;
        if (r1 == true) goto L22;
        if (this.a.c == true) goto L22;
        this.a.a("GiftListRoom-Timer");
    L22:
        this.a.i = 2;
        return;
    L7:
        r7 = null;
    L13:
        r1 = false;
        goto L14
    }
}
