package com.google.gson.internal;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ConstructorConstructor$15<T> implements ObjectConstructor<T> {
    public ConstructorConstructor$15() {
    }

    public T construct() {
        return (T) new ConcurrentHashMap();
    }
}
