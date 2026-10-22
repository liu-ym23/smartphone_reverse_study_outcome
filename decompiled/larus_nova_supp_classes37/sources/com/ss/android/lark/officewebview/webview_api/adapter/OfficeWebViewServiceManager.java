package com.ss.android.lark.officewebview.webview_api.adapter;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeWebViewServiceManager implements txb.b {
    public final OfficeWebView a;
    public final ConcurrentHashMap<String, txb.c> b;
    public final Lazy c;

    public OfficeWebViewServiceManager(OfficeWebView r2) {
        Intrinsics.checkNotNullParameter(r2, "officeWebView");
        this.a = r2;
        this.b = new ConcurrentHashMap();
        this.c = LazyKt.lazy(new OfficeWebViewServiceManager$renderServiceAdapter$2(this));
    }

    @Override // txb.b
    public final void b(Class<? extends txb.c> r4) {
        Intrinsics.checkNotNullParameter(r4, "serviceImplClass");
        boolean r0 = false;
        txb.c r1 = r4.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        Class<?>[] r5 = r4.getInterfaces();
        Intrinsics.checkNotNull(r5);
        if (r5.length != 0) goto L5;
        r0 = true;
    L5:
        if (r0 == false) goto L7;
        return;
    L7:
        Iterator r6 = ArrayIteratorKt.iterator(r5);
    L9:
        if (r6.hasNext() == false) goto L13;
        Class r2 = (Class) r6.next();
        if (txb.c.class.isAssignableFrom(r2) == false) goto L9;
        this.b.put(r2.getCanonicalName(), r1);
        goto L9
    }

    @Override // txb.b
    public final <T extends txb.c> T getService(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "serviceInterface");
        if (Intrinsics.areEqual(r3, txb.a.class) == false) goto L8;
        txb.a r4 = (txb.a) this.c.getValue();
        if ((r4 instanceof txb.c) == true) goto L7;
        return null;
    L7:
        return r4;
    L8:
        txb.c r5 = this.b.get(r3.getCanonicalName());
        if ((r5 instanceof txb.c) == true) goto L11;
        return null;
    L11:
        return (T) r5;
    }
}
