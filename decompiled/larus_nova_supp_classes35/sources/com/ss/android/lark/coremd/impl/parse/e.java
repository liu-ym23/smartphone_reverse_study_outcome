package com.ss.android.lark.coremd.impl.parse;

import com.ss.android.lark.coremd.base.parse.v;
import com.ss.android.lark.coremd.base.parse.y;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements com.ss.android.lark.coremd.base.parse.m {
    public final WeakHashMap<a, Unit> a;
    public final Map<y, CharSequence> b;

    public interface a {
        void a(Object r1, boolean r2);

        void b(y r1, CharSequence r2);

        void c(s r1, v r2, ProxyClickSpanInner$Companion$proxyNodeClickInner$1$proxySpan$1.a r3, int r4);
    }

    public e() {
        this.a = new WeakHashMap();
        this.b = new LinkedHashMap();
    }

    public final void b(a r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.a.put(r4, Unit.INSTANCE);
        Iterator r0 = ((LinkedHashMap) this.b).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r0.next();
        r4.b((y) r1.getKey(), (CharSequence) r1.getValue());
        goto L4
    L6:
        ((LinkedHashMap) this.b).clear();
    }

    @Override // com.ss.android.lark.coremd.base.parse.m
    public final void a(Object r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "span");
        Iterator r0 = CollectionsKt.toList(this.a.keySet()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).a(r3, r4);
        goto L4
    }
}
