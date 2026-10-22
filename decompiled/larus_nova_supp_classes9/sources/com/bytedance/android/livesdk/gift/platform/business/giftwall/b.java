package com.bytedance.android.livesdk.gift.platform.business.giftwall;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ GiftWallPreRequestManager a;
    public final /* synthetic */ String b;

    public b(GiftWallPreRequestManager r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Pair r7 = (Pair) r6;
        jy0.b.a("ttlive_gift_wall", "fetchExhibitionData uid=" + this.b + " success");
        this.a.f.put(this.b, TuplesKt.to(Long.valueOf(System.currentTimeMillis()), r7.getFirst()));
        this.a.g.put(this.b, TuplesKt.to(Long.valueOf(System.currentTimeMillis()), r7.getSecond()));
        if (this.a.e.d() == false) goto L11;
        GiftWallPreRequestManager r0 = this.a;
        String r1 = this.b;
        JsonObject r2 = (JsonObject) r7.getFirst();
        JsonObject r8 = (JsonObject) r7.getSecond();
        IRoom r3 = r0.j.getRoom();
        boolean r4 = r0.k.f(r1);
        IBaseUser r5 = r3.getOwner();
        if (r5 != null) goto L7;
    L8:
        if (r4 == false) goto L12;
    L9:
        f r9 = f.a;
        GiftWallPreRequestManager$prefetchRareGiftImage$1 r10 = new GiftWallPreRequestManager$prefetchRareGiftImage$1(r0, r8);
        r9.getClass();
        f.b(r10);
        GiftWallPreRequestManager$prefetchHomeGiftImage$1 r11 = new GiftWallPreRequestManager$prefetchHomeGiftImage$1(r0, r2);
        r9.getClass();
        f.b(r11);
        return;
    L12:
        return;
    L7:
        if (r5.isFollowing() == true) goto L9;
    }
}
