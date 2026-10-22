package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import android.text.TextUtils;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r implements wp2.i {
    public final /* synthetic */ Long a;
    public final /* synthetic */ List b;
    public final /* synthetic */ int c;

    public final void a(wp2.d r3) {
        if (((wp2.k) r3).a != true) goto L12;
        String r0 = r3.c.optString("room_id");
        boolean r4 = r3.c.optBoolean("predict_value");
        GiftDataStorageService r1 = com.bytedance.android.livesdk.gift.platform.core.utils.s.b();
        if (r1 == null) goto L8;
        r1.o = r4 ? 1 : 0;
    L8:
        if (TextUtils.equals(String.valueOf(this.a), r0) == false) goto L13;
        if (r4 == false) goto L14;
        Completable.complete().observeOn(Schedulers.computation()).subscribe(new q(this));
        return;
    L14:
        return;
    L13:
        return;
    }

    public r(Long r1, List r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
