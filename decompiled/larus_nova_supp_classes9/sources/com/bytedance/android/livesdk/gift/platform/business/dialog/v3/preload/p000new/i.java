package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListPanelRepository;
import com.bytedance.android.livesdk.gift.platform.core.model.j;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.SendGiftRelationService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements o, j {
    public final e a;
    public final c b;
    public final GiftExtraPreloader c;
    public final d d;
    public final IRoom e;
    public final k f;
    public final GiftListPanelRepository g;
    public final x h;
    public final y i;
    public final SendGiftRelationService j;

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.j
    public final boolean a() {
        return this.j.f(this.e.getAnchorId());
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.j
    public final IBaseUser c() {
        IBaseUser r0 = this.i.i();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.h.a();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.j
    public final j d() {
        GiftListPanelRepository r0 = this.g;
        y r1 = this.i;
        IBaseUser r2 = r1.i();
        if (r2 != null) goto L6;
        r2 = this.h.a();
    L6:
        return r0.Mn(r1.h(r2));
    }

    public final void onStart() {
        HashMap<GiftPreloadResType, k<?>> r0 = GiftPreloadManager.a;
        GiftPreloadManager.c(this.d);
        GiftPreloadManager.c(this.a);
        GiftPreloadManager.c(this.b);
        GiftPreloadManager.c(this.c);
    }

    public final void onStop() {
        HashMap<GiftPreloadResType, k<?>> r0 = GiftPreloadManager.a;
        GiftPreloadManager.d(this.d);
        GiftPreloadManager.d(this.a);
        GiftPreloadManager.d(this.b);
        GiftPreloadManager.d(this.c);
        GiftPreloadManager.b.clear();
        Iterator<T> r1 = GiftPreloadManager.a.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((k) r1.next()).clear();
        goto L4
    }

    public i(Context r2, GiftExtraRepo r3, k r4, GiftListPanelRepository r5, x r6, y r7, SendGiftRelationService r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        Intrinsics.checkNotNullParameter(r5, "listPanelRepository");
        Intrinsics.checkNotNullParameter(r6, "recommendReceiverService");
        Intrinsics.checkNotNullParameter(r7, "selectReceiverService");
        Intrinsics.checkNotNullParameter(r8, "sendGiftRelationService");
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.a = new e(r2, this);
        this.b = new c(this);
        this.c = new GiftExtraPreloader(r3, this);
        this.d = new d();
        this.e = r4.getRoom();
    }
}
