package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = null;
    private static final double IGNORE_VERSIONS = -1.0d;
    private List<ExclusionStrategy> deserializationStrategies;
    private int modifiers;
    private boolean requireExpose;
    private List<ExclusionStrategy> serializationStrategies;
    private boolean serializeInnerClasses;
    private double version;

    static {
        DEFAULT = new Excluder();
    }

    public Excluder() {
        this.version = IGNORE_VERSIONS;
        this.modifiers = 136;
        this.serializeInnerClasses = true;
        this.serializationStrategies = Collections.emptyList();
        this.deserializationStrategies = Collections.emptyList();
    }

    private static boolean isInnerClass(Class<?> r5) {
        if (r5.isMemberClass() == true) goto L5;
    L7:
        return false;
    L5:
        if (ReflectionHelper.isStatic(r5) == true) goto L7;
        return true;
    }

    private boolean isValidSince(Since r5) {
        if (r5 == null) goto L9;
        double r10 = r5.value();
        if (this.version >= r10) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    private boolean isValidUntil(Until r5) {
        if (r5 == null) goto L9;
        double r10 = r5.value();
        if (this.version < r10) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    private boolean isValidVersion(Since r5, Until r10) {
        if (isValidSince(r5) == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidUntil(r10) == false) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m97clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson r10, final TypeToken<T> r11) {
        Class<? super T> r5 = r11.getRawType();
        final boolean r12 = excludeClass(r5, true);
        final boolean r13 = excludeClass(r5, false);
        if (r12 == true) goto L8;
        if (r13 == true) goto L8;
        return null;
    L8:
        return new AnonymousClass1(this, r13, r12, r10, r11);
    }

    public Excluder disableInnerClassSerialization() {
        Excluder r5 = clone();
        r5.serializeInnerClasses = false;
        return r5;
    }

    public boolean excludeClass(Class<?> r5, boolean r10) {
        if (this.version == IGNORE_VERSIONS) goto L8;
        if (isValidVersion((Since) r5.getAnnotation(Since.class), (Until) r5.getAnnotation(Until.class)) == true) goto L8;
        return true;
    L8:
        if (this.serializeInnerClasses == false) goto L10;
    L12:
        if (r10 == false) goto L14;
    L18:
        if (r10 == false) goto L20;
        List<ExclusionStrategy> r11 = this.serializationStrategies;
    L21:
        Iterator<ExclusionStrategy> r12 = r11.iterator();
    L23:
        if (r12.hasNext() == false) goto L27;
        if (r12.next().shouldSkipClass(r5) == false) goto L23;
        return true;
    L27:
        return false;
    L20:
        r11 = this.deserializationStrategies;
        goto L21
    L14:
        if (Enum.class.isAssignableFrom(r5) == true) goto L18;
        if (ReflectionHelper.isAnonymousOrNonStaticLocal(r5) == false) goto L18;
        return true;
    L10:
        if (isInnerClass(r5) == false) goto L12;
        return true;
    }

    public boolean excludeField(Field r10, boolean r11) {
        if ((this.modifiers & r10.getModifiers()) == 0) goto L6;
        return true;
    L6:
        if (this.version == IGNORE_VERSIONS) goto L11;
        if (isValidVersion((Since) r10.getAnnotation(Since.class), (Until) r10.getAnnotation(Until.class)) == true) goto L11;
        return true;
    L11:
        if (r10.isSynthetic() == false) goto L14;
        return true;
    L14:
        if (this.requireExpose == false) goto L25;
        Expose r5 = (Expose) r10.getAnnotation(Expose.class);
        if (r5 == null) goto L23;
        if (r11 == false) goto L22;
        if (r5.serialize() == true) goto L25;
    L22:
        if (r5.deserialize() == true) goto L25;
    L23:
        return true;
    L25:
        if (excludeClass(r10.getType(), r11) == false) goto L27;
        return true;
    L27:
        if (r11 == false) goto L29;
        List<ExclusionStrategy> r12 = this.serializationStrategies;
    L31:
        if (r12.isEmpty() == true) goto L38;
        FieldAttributes r13 = new FieldAttributes(r10);
        Iterator<ExclusionStrategy> r14 = r12.iterator();
    L34:
        if (r14.hasNext() == false) goto L43;
        if (r14.next().shouldSkipField(r13) == false) goto L34;
        return true;
    L43:
        return false;
    L38:
        return false;
    L29:
        r12 = this.deserializationStrategies;
        goto L31
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder r5 = clone();
        r5.requireExpose = true;
        return r5;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy r5, boolean r10, boolean r11) {
        Excluder r12 = clone();
        if (r10 == false) goto L5;
        ArrayList r13 = new ArrayList(this.serializationStrategies);
        r12.serializationStrategies = r13;
        r13.add(r5);
    L5:
        if (r11 == false) goto L7;
        ArrayList r14 = new ArrayList(this.deserializationStrategies);
        r12.deserializationStrategies = r14;
        r14.add(r5);
    L7:
        return r12;
    }

    public Excluder withModifiers(int... r5) {
        Excluder r10 = clone();
        int r11 = 0;
        r10.modifiers = 0;
        int r12 = r5.length;
    L3:
        if (r11 >= r12) goto L5;
        r10.modifiers = r5[r11] | r10.modifiers;
        r11 = r11 + 1;
        goto L3
    L5:
        return r10;
    }

    public Excluder withVersion(double r5) {
        Excluder r10 = clone();
        r10.version = r5;
        return r10;
    }

    public Excluder clone() {
        return (Excluder) super.clone();
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }
}
