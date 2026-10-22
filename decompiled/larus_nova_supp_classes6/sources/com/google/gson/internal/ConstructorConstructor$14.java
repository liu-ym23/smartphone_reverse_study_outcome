package com.google.gson.internal;

import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ConstructorConstructor$14<T> implements ObjectConstructor<T> {
    public ConstructorConstructor$14() {
    }

    public T construct() {
        return (T) new ConcurrentSkipListMap();
    }
}
