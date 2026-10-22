package com.bytedance.android.livesdk.interactivity.zdanmaku;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.WindScreenCommonAnimTrayView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ WindScreenCommonAnimTrayView a;

    public c(WindScreenCommonAnimTrayView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Bitmap r3 = (Bitmap) r2;
        if (r3 == null) goto L7;
        this.a.setIcon(r3);
        return;
    }
}
