package e64;

import android.content.Context;
import android.os.Handler;
import com.bytedance.tma.base.keva.KevaManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends a {
    public b d;

    @Override // e64.a
    public final void a() {
        Handler r0 = (Handler) KevaManager.a.getValue();
        b r1 = this.d;
        if (r1 == null) goto L5;
        r0.removeCallbacks(r1);
    L6:
        r0.post(this.d);
        return;
    L5:
        this.d = new b(this);
        goto L6
    }

    public c(Context r1, String r2) {
        super(r2);
    }
}
