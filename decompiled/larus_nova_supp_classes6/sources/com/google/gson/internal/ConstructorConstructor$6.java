package com.google.gson.internal;

import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ConstructorConstructor$6<T> implements ObjectConstructor<T> {
    final /* synthetic */ Type val$type;

    public T construct() {
        Type r0 = this.val$type;
        if ((r0 instanceof ParameterizedType) == false) goto L11;
        Type r1 = ((ParameterizedType) r0).getActualTypeArguments()[0];
        if ((r1 instanceof Class) == false) goto L9;
        return (T) new EnumMap((Class) r1);
    L9:
        throw new JsonIOException("Invalid EnumMap type: " + this.val$type.toString());
    L11:
        throw new JsonIOException("Invalid EnumMap type: " + this.val$type.toString());
    }

    public ConstructorConstructor$6(Type r1) {
        this.val$type = r1;
    }
}
