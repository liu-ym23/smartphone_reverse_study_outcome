package com.ss.android.lark.chameleonv2.lkapi.transport;

import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends z0b.a {
    public static final /* synthetic */ int c = 0;
    public WeakReference<b> a;
    public final Set<Disposable> b;

    public static final class a {
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        b r0 = new b(new WeakReference(this));
        this.a = new WeakReference(r0);
        return CollectionsKt.arrayListOf(new AbsChameleonHandler[]{new com.ss.android.lark.chameleonv2.lkapi.transport.a(), r0});
    }

    public c() {
        this.b = new LinkedHashSet();
    }

    @Override // z0b.a
    public final void e(IChameleonHandlerContext r2) {
        Iterator<T> r3 = this.b.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Disposable) r3.next()).dispose();
        goto L4
    L6:
        this.b.clear();
    }
}
