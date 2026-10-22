package com.google.gson.internal.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ReflectionHelper$RecordNotSupportedHelper extends ReflectionHelper.RecordHelper {
    private ReflectionHelper$RecordNotSupportedHelper() {
        super(null);
    }

    public boolean isRecord(Class<?> r1) {
        return false;
    }

    public /* synthetic */ ReflectionHelper$RecordNotSupportedHelper(ReflectionHelper$1 r1) {
        this();
    }

    public <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r2) {
        throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
    }

    public String[] getRecordComponentNames(Class<?> r2) {
        throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
    }

    public Method getAccessor(Class<?> r1, Field r2) {
        throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
    }
}
