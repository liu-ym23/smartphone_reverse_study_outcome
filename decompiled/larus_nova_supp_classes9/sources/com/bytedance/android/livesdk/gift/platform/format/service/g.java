package com.bytedance.android.livesdk.gift.platform.format.service;

import android.os.SystemClock;
import ca0.w;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftListViewModel$mSyncGiftListCallback$1;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ FormatGiftListService a;
    public final /* synthetic */ int b;
    public final /* synthetic */ w c;
    public final /* synthetic */ long d;

    public g(FormatGiftListService r1, FormatGiftListViewModel$mSyncGiftListCallback$1 r2, long r3) {
        this.a = r1;
        this.b = 4096;
        this.c = r2;
        this.d = r3;
    }

    public final void accept(Object r6) {
        ExtraResponse r7 = (ExtraResponse) r6;
        FormatGiftListService r0 = this.a;
        if (r7 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.model.i r8 = (com.bytedance.android.livesdk.gift.platform.core.model.i) r7.data;
    L6:
        int r1 = this.b;
        w r2 = this.c;
        r0.getClass();
        if (r8 == null) goto L11;
        List<? extends w1> r4 = r8.giftPages;
        if (r4 == null) goto L11;
        int r5 = r4.size();
    L12:
        if (r5 != 0) goto L14;
        c0.a.d("response.data is empty", 0, r1);
    L20:
        long r3 = SystemClock.uptimeMillis() - this.d;
        c0 r9 = c0.a;
        c0.e(r3, this.b);
        return;
    L14:
        ((ArrayList) r0.b).clear();
        if (r8 == null) goto L19;
        List<? extends w1> r10 = r8.giftPages;
        if (r10 == null) goto L19;
        ArrayList r11 = (ArrayList) r0.b;
        r11.addAll(r10);
    L19:
        Single.create(new c(r0, r2)).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.user.h());
        Single.create(new i(r0, r8)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
    L11:
        r5 = 0;
        goto L12
    L5:
        r8 = null;
        goto L6
    }
}
