package com.bytedance.android.livesdk.interactivity.like.view;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Function;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r<T, R> implements Function {
    public final /* synthetic */ DiggCountFlipperLayout a;

    public r(DiggCountFlipperLayout r1) {
        this.a = r1;
    }

    public final Object apply(Object r5) {
        Long r6 = (Long) r5;
        Intrinsics.checkNotNullParameter(r6, "count");
        DiggCountFlipperLayout r0 = this.a;
        if (r0.k == false) goto L14;
        r0.setFlipCount((int) r6.longValue());
        DiggCountFlipperLayout r1 = this.a;
        DiggCountFlipperLayout.b r2 = r1.r;
        if (r2 == null) goto L9;
        r2.a(r1.getFlipCount());
    L9:
        if ((((int) r6.longValue()) % 2) != 1) goto L11;
        this.a.j(true, true, true);
        String r7 = "like";
    L12:
        com.bytedance.android.livesdk.log.u.l().sendLog("live_room_info_change", MapsKt.mapOf(TuplesKt.to("rank_type", r7)), new Object[]{Room.class});
        goto L14
    L11:
        this.a.k(true, true, true);
        r7 = "room_money";
    L14:
        return Unit.INSTANCE;
    }
}
