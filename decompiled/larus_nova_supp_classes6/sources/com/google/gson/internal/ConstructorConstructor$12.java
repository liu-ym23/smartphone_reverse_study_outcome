package com.google.gson.internal;

import java.util.ArrayDeque;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ConstructorConstructor$12<T> implements ObjectConstructor<T> {
    public ConstructorConstructor$12() {
    }

    public T construct() {
        return (T) new ArrayDeque();
    }
}
