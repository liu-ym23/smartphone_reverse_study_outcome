package ft1;

import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ e a;

    public g(e r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.j) r2;
        if (r3 == null) goto L5;
        int r0 = r3.a;
    L6:
        if (r0 <= 0) goto L9;
        Map<String, String> r1 = d.a;
        d.b(String.valueOf(r3.a), this.a.hashCode());
        return;
    L9:
        return;
    L5:
        r0 = 0;
        goto L6
    }
}
