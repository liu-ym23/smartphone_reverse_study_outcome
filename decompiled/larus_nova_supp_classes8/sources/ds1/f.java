package ds1;

import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ VSChorusConcertWidget a;

    public f(VSChorusConcertWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Boolean r5 = (Boolean) r4;
        int r2 = VSChorusConcertWidget.l;
        this.a.zq("showLatestEvent 是否不在直播位置" + r5);
        if (r5.booleanValue() == false) goto L5;
        this.a.yq();
        return;
    L5:
        es1.a r6 = this.a.xq(false);
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.a != true) goto L13;
        this.a.Cq();
        return;
    }
}
