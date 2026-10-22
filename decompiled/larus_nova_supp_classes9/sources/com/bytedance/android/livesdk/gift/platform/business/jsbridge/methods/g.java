package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ h b;
    public final /* synthetic */ String c;
    public final /* synthetic */ List d;

    public g(long r1, h r3, String r4, List r5) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        this.b.finishWithFailure();
        com.bytedance.android.livesdk.gift.platform.core.utils.h.t(this.c, this.a, 2, r8);
        c0.a.q(this.c, this.a, 2, r8);
        String r9 = r8.getMessage();
        if (r9 != null) goto L5;
        r9 = BuildConfig.FLAVOR;
    L5:
        jy0.b.c("GetGiftDataMethod", r9, null, 4);
    }
}
