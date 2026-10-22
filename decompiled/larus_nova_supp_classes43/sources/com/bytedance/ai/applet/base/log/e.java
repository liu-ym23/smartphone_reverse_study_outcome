package com.bytedance.ai.applet.base.log;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements u1<Map<String, ? extends String>>, CoroutineContext.Element {
    public static final a b = null;
    public static final String c = null;
    public static final AtomicLong d = null;
    public final Map<String, String> a;

    public static final class a implements CoroutineContext.Key<e> {
        public a() {
        }
    }

    static {
        b = new a();
        c = Long.toString(System.currentTimeMillis(), CharsKt.checkRadix(36));
        d = new AtomicLong();
        new e(MapsKt.emptyMap());
    }

    public final CoroutineContext.Key<e> getKey() {
        return b;
    }

    public e(Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r10, "values");
        this.a = r10;
    }

    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r1) {
        return (E) CoroutineContext.Element.DefaultImpls.get(this, r1);
    }

    public final CoroutineContext minusKey(CoroutineContext.Key<?> r1) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, r1);
    }

    public final CoroutineContext plus(CoroutineContext r1) {
        return CoroutineContext.Element.DefaultImpls.plus(this, r1);
    }

    public final Object updateThreadContext(CoroutineContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Map<String, String> r11 = f.a.get();
        f.b(this.a);
        return r11;
    }

    public final <R> R fold(R r1, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r10) {
        return (R) CoroutineContext.Element.DefaultImpls.fold(this, r1, r10);
    }

    public final void restoreThreadContext(CoroutineContext r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        f.b((Map) r11);
    }
}
