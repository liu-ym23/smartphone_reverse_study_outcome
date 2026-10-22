package qz1;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleSweepGiftViewHolder;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ SimpleSweepGiftViewHolder a;

    public v(SimpleSweepGiftViewHolder r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        GiftIconMaskView r4 = this.a.W3();
        if (r4 == null) goto L6;
        r4.setVisibility(8);
        return;
    }
}
