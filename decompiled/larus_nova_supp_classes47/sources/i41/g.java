package i41;

import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ a a;

    public g(a r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        a r7 = this.a;
        if (r7.f == false) goto L8;
        Iterator r8 = ((ArrayList) r7.a).iterator();
    L6:
        if (r8.hasNext() == false) goto L10;
        ((p) r8.next()).qn(false, true, AutoMatchSource.MaxWaitTimeOut);
        goto L6
    L10:
        return;
    }
}
