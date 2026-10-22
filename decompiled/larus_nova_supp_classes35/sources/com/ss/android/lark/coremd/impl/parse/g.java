package com.ss.android.lark.coremd.impl.parse;

import android.view.View;
import com.ss.android.lark.coremd.base.parse.z;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements com.ss.android.lark.coremd.base.parse.n {
    public final ConcurrentHashMap<Class<? extends s>, com.ss.android.lark.coremd.base.parse.n.b<s>> a;
    public final ConcurrentHashMap<Class<? extends View>, z<View>> b;

    public g() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
    }

    @Override // com.ss.android.lark.coremd.base.parse.n
    public final <T extends s> com.ss.android.lark.coremd.base.parse.n.b<T> b(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Object r3 = this.a.get(r2);
        if ((r3 instanceof com.ss.android.lark.coremd.base.parse.n.b) == true) goto L7;
        return null;
    L7:
        return (com.ss.android.lark.coremd.base.parse.n.b) r3;
    }

    public final void c(z<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "adapter");
        this.b.put((Class<? extends View>) r3.b(), (z<View>) r3);
    }

    @Override // com.ss.android.lark.coremd.base.parse.n
    public final <T extends s> void a(Class<T> r2, com.ss.android.lark.coremd.base.parse.n.b<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "handler");
        this.a.put(r2, r3);
    }
}
