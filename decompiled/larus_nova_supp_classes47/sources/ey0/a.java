package ey0;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends AbstractCoroutineContextElement {
    public static final C0234a b = null;
    public boolean a;

    /* JADX INFO: renamed from: ey0.a$a, reason: collision with other inner class name */
    public static final class C0234a implements CoroutineContext.Key<a> {
        public C0234a() {
        }
    }

    static {
        b = new C0234a();
    }

    public a() {
        super(b);
    }
}
