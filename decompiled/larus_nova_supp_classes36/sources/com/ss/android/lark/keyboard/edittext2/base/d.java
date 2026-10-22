package com.ss.android.lark.keyboard.edittext2.base;

import com.ss.android.lark.keyboard.edittext2.base.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d<E extends a> implements a.InterfaceC0134a<E> {
    public final Class<E> a;

    @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a
    public final Class<E> a() {
        return this.a;
    }

    public d(Class<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        this.a = r2;
        FunctionEditText.b.add(r2);
    }
}
