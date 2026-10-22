package b22;

import com.bytedance.android.livesdk.gift.vs.panel.view.VSGiftListWidgetNew;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ VSGiftListWidgetNew a;

    public d(VSGiftListWidgetNew r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        Disposable r4 = this.a.h;
        if (r4 == null) goto L5;
        r4.dispose();
    L5:
        VSGiftListWidgetNew r5 = this.a;
        r5.c.h(r5.zq());
    }
}
