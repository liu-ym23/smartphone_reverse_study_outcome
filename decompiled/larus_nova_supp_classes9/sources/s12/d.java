package s12;

import com.bytedance.android.livesdk.gift.platform.format.panel.view.FormatGiftListWidget;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ FormatGiftListWidget a;

    public d(FormatGiftListWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        Disposable r4 = this.a.h;
        if (r4 == null) goto L5;
        r4.dispose();
    L5:
        FormatGiftListWidget r5 = this.a;
        r5.c.h(r5.zq());
    }
}
