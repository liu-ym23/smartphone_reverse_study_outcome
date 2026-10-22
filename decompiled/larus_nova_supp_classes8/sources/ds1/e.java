package ds1;

import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ VSChorusConcertWidget a;

    public e(VSChorusConcertWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Boolean r5 = (Boolean) r4;
        int r2 = VSChorusConcertWidget.l;
        this.a.zq("initNessListener isLock:" + r5);
        if (r5.booleanValue() == false) goto L5;
        this.a.yq();
        return;
    L5:
        this.a.Cq();
    }
}
