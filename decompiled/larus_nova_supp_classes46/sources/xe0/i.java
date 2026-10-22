package xe0;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ h a;

    public i(h r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        h r8 = this.a;
        if (r8.a == 0) goto L16;
        long r0 = r8.b;
        if (r0 > 0) goto L8;
        ALogger.e("ttlive_link_paid", "selfRemainingTime=" + r8.b + " invalid");
        return;
    L8:
        r8.b = r0 - 1000;
        Iterator<h.a> r1 = r8.d.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        r1.next().B0(r8.b);
        goto L10
    L12:
        r8.a(true, null);
        return;
    }
}
