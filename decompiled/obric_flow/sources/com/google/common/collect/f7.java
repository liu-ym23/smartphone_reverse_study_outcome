package com.google.common.collect;

import java.io.Serializable;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public final class f7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8976a;

    public f7(Field r5) {
        this.f8976a = r5;
        r5.setAccessible(true);
    }

    public void a(Serializable r5, Object r10) {
        ((Field) this.f8976a).set(r5, r10);     // Catch: IllegalAccessException -> L4
        return;
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public f7(com.google.common.base.q r5) {
        this.f8976a = r5;
    }
}
