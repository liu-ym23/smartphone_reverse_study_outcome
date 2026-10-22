package uga;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d extends AbstractCoroutineContextElement {
    public static final a b = null;
    public final String a;

    public static final class a implements CoroutineContext.Key<d> {
        public a() {
        }
    }

    static {
        b = new a();
    }

    public d(String r2) {
        super(b);
        this.a = r2;
    }
}
