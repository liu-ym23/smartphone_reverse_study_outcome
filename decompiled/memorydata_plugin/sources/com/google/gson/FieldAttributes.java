package com.google.gson;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class FieldAttributes {
    private final Field field;

    public FieldAttributes(Field r3) {
        this.field = (Field) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r3), Field.class, "com.obric.memorydata.plugin");
    }

    public <T extends Annotation> T getAnnotation(Class<T> r1) {
        return (T) this.field.getAnnotation(r1);
    }

    public Collection<Annotation> getAnnotations() {
        return Arrays.asList(this.field.getAnnotations());
    }

    public Class<?> getDeclaredClass() {
        return this.field.getType();
    }

    public Type getDeclaredType() {
        return this.field.getGenericType();
    }

    public Class<?> getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public String getName() {
        return this.field.getName();
    }

    public boolean hasModifier(int r1) {
        if ((this.field.getModifiers() & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return this.field.toString();
    }
}
