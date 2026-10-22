package qz1;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleSweepGiftViewHolder;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ SimpleSweepGiftViewHolder a;

    public u(SimpleSweepGiftViewHolder r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        rz1.b r0 = this.a.V3();
        r0.a((Bitmap) r2);
        this.a.V3().c(null);
    }
}
