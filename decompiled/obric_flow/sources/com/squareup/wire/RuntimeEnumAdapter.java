package com.squareup.wire;

import com.squareup.wire.WireEnum;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
final class RuntimeEnumAdapter<E extends WireEnum> extends EnumAdapter<E> {
    private Method fromValueMethod;
    private final Class<E> type;

    public RuntimeEnumAdapter(Class<E> r5) {
        super(r5);
        this.type = r5;
    }

    private Method getFromValueMethod() {
        Method r5 = this.fromValueMethod;
        if (r5 == null) goto L10;
        return r5;
    L10:
        Method r10 = this.type.getMethod("fromValue", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L7
        this.fromValueMethod = r10;     // Catch: NoSuchMethodException -> L7
        return r10;
    L7:
        e = move-exception;
        throw new AssertionError(e);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof RuntimeEnumAdapter) == true) goto L5;
    L7:
        return false;
    L5:
        if (((RuntimeEnumAdapter) r5).type != this.type) goto L7;
        return true;
    }

    @Override // com.squareup.wire.EnumAdapter
    public E fromValue(int r5) {
        return (E) getFromValueMethod().invoke(null, new Object[]{Integer.valueOf(r5)});
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public int hashCode() {
        return this.type.hashCode();
    }
}
