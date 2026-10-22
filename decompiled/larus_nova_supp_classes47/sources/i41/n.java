package i41;

import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n<T, R> implements Function {
    public final /* synthetic */ a a;

    public n(a r1) {
        this.a = r1;
    }

    public final Object apply(Object r5) {
        long r0 = ((Number) r5).longValue();
        return Long.valueOf(((long) this.a.b) - r0);
    }
}
