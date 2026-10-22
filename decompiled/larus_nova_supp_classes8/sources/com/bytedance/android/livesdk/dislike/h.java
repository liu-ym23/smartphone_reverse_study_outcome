package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.livesdk.dislike.layout.OptionDescItemLayoutV2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ DislikeOptionsBottomDialog a;

    public h(DislikeOptionsBottomDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        OptionDescItemLayoutV2 r4 = this.a.F;
        if (r4 == null) goto L6;
        r4.setVisibility(8);
        return;
    }
}
