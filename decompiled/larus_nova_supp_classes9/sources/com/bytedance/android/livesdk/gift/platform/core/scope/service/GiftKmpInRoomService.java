package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.kmp.livesdk.gift.platform.GiftContext;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftKmpInRoomService implements v2, com.bytedance.android.scope.o {
    public Pair<GiftContext, ? extends Disposable> a;

    public GiftKmpInRoomService() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.v2
    public final GiftContext bl() {
        Pair<GiftContext, ? extends Disposable> r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (GiftContext) r0.getFirst();
    }

    public final void onStart() {
        jy0.b.a("GiftKmpInRoomService", "onStart");
        this.a = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
    }

    public final void onStop() {
        jy0.b.a("GiftKmpInRoomService", "onStop");
        Pair<GiftContext, ? extends Disposable> r0 = this.a;
        if (r0 == null) goto L8;
        Disposable r1 = (Disposable) r0.getSecond();
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    L9:
        return;
    }
}
