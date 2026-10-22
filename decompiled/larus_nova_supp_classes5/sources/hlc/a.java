package hlc;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import z.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public final b<String, IEffectPlatformBaseListener<?>> a;

    public a() {
        this.a = new b(true);
    }

    public final <T> IEffectPlatformBaseListener<T> a(String r3) {
        Object r4 = this.a.get(r3);
        if ((r4 instanceof IEffectPlatformBaseListener) == true) goto L5;
        r4 = null;
    L5:
        IEffectPlatformBaseListener<T> r5 = (IEffectPlatformBaseListener) r4;
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5;
    }

    public final void c(String r2) {
        this.a.remove(r2);
    }

    public final <T> void b(String r2, IEffectPlatformBaseListener<T> r3) {
        this.a.put(r2, r3);
    }
}
