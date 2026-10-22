package l30;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.ies.web.jsbridge2.d0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ IHybridComponent b;

    public b(d0 r1, IHybridComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        d0 r5 = this.a;
        if (r5 != null) goto L5;
    L7:
        IHybridComponent r6 = this.b;
        if (r6 == null) goto L11;
        r6.sendJsEvent("deviceOrientationEvent", d.a());
        return;
    L11:
        return;
    L5:
        if (r5.f == true) goto L7;
        r5.f("deviceOrientationEvent", d.a());
        goto L7
    }
}
