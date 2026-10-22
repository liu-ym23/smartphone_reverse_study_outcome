package com.bytedance.android.live.revlink.impl.pk.feedview.bridge;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ FeedPkBridgePresenter a;

    public a(FeedPkBridgePresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        String r7 = (String) this.a.m.getValue();
        if (r7 == null) goto L5;
        CastLongProtector.parseLong(r7);
    L5:
        MutableLiveData<String> r8 = this.a.m;
        long r0 = System.currentTimeMillis();
        String r2 = (String) this.a.l.getValue();
        if (r2 == null) goto L8;
        long r3 = CastLongProtector.parseLong(r2);
    L9:
        r8.setValue(String.valueOf((r0 - r3) / ((long) WebcastRedirectException.UNKNOWN)));
        return;
    L8:
        r3 = 0;
        goto L9
    }
}
