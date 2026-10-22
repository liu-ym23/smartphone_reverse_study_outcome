package s92;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public t a;
    public long b;
    public final boolean c;

    public final boolean a() {
        if (this.c == true) goto L5;
        return true;
    L5:
        t r0 = this.a;
        if (r0 == null) goto L10;
        m0 r1 = r0.getBaseMessage();
        if (r1 == null) goto L10;
        long r4 = r1.getAnchorFoldDuration();
    L12:
        if (r4 > 0) goto L14;
        return true;
    L14:
        if (this.b > 0) goto L16;
        return true;
    L16:
        if ((System.currentTimeMillis() - this.b) >= (r4 * 1000)) goto L22;
        return false;
    L22:
        return true;
    L10:
        r4 = 0;
        goto L12
    }

    public b(boolean r1) {
        this.c = r1;
    }
}
