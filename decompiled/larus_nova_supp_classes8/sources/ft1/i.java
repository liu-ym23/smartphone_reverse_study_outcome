package ft1;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ e a;

    public i(e r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if (((Boolean) r2).booleanValue() == false) goto L5;
        Map<String, String> r3 = d.a;
        d.b(String.valueOf(7), this.a.hashCode());
        return;
    L5:
        IInteractService r4 = jc1.k.f(IInteractService.class);
        if (r4 == null) goto L8;
        Integer r5 = Integer.valueOf(r4.getCurrentScene());
    L9:
        Map<String, String> r0 = d.a;
        d.b(String.valueOf(r5), this.a.hashCode());
        return;
    L8:
        r5 = null;
        goto L9
    }
}
