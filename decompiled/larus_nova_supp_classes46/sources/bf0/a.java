package bf0;

import com.bytedance.android.live.broadcastgame.api.xplay.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a<T> {
    public a<T> a;

    public a() {
    }

    public abstract g b(Object r1);

    public final void a(T r2) {
        g r3 = b(r2);
        a<T> r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r3);
        return;
    }
}
