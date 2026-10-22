package com.google.gson.internal;

import com.google.gson.JsonIOException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ConstructorConstructor$20<T> implements ObjectConstructor<T> {
    final /* synthetic */ ConstructorConstructor this$0;
    final /* synthetic */ String val$exceptionMessage;

    public T construct() {
        throw new JsonIOException(this.val$exceptionMessage);
    }

    public ConstructorConstructor$20(ConstructorConstructor r1, String r2) {
        this.this$0 = r1;
        this.val$exceptionMessage = r2;
    }
}
