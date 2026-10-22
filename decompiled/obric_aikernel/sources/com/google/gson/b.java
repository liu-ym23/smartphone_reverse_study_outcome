package com.google.gson;

import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Field f4191a;

    public b(Field r10) {
        Objects.requireNonNull(r10);
        this.f4191a = r10;
    }

    public String toString() {
        return this.f4191a.toString();
    }
}
