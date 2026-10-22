package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    private boolean excludeClassChecks(Class<?> r6) {
        if (this.version == IGNORE_VERSIONS) goto L8;
        if (isValidVersion((Since) ZeusTransformUtils.preCheckCast(r6.getAnnotation(Since.class), Since.class, "com.obric.memorydata.plugin"), (Until) ZeusTransformUtils.preCheckCast(r6.getAnnotation(Until.class), Until.class, "com.obric.memorydata.plugin")) == true) goto L8;
        return true;
    L8:
        if (this.serializeInnerClasses == true) goto L13;
        if (isInnerClass(r6) == false) goto L13;
        return true;
    L13:
        return isAnonymousOrNonStaticLocal(r6);
    }

    private boolean excludeClassInStrategy(Class<?> r3, boolean r4) {
        if (r4 == false) goto L4;
        List<ExclusionStrategy> r2 = this.serializationStrategies;
    L5:
        Iterator<ExclusionStrategy> r5 = r2.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        if (((ExclusionStrategy) ZeusTransformUtils.preCheckCast(r5.next(), ExclusionStrategy.class, "com.obric.memorydata.plugin")).shouldSkipClass(r3) == false) goto L7;
        return true;
    L12:
        return false;
    L4:
        r2 = this.deserializationStrategies;
        goto L5
    }

    private boolean isAnonymousOrNonStaticLocal(Class<?> r2) {
        if (Enum.class.isAssignableFrom(r2) == false) goto L5;
    L11:
        return false;
    L5:
        if (isStatic(r2) == true) goto L11;
        if (r2.isAnonymousClass() == false) goto L9;
    L10:
        return true;
    L9:
        if (r2.isLocalClass() == false) goto L11;
        goto L10
    }

    private boolean isInnerClass(Class<?> r2) {
        if (r2.isMemberClass() == true) goto L5;
    L7:
        return false;
    L5:
        if (isStatic(r2) == true) goto L7;
        return true;
    }

    private boolean isStatic(Class<?> r1) {
        if ((r1.getModifiers() & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isValidSince(Since r4) {
        Since r5 = (Since) ZeusTransformUtils.wrapperContextForParams(r4, Since.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L9;
        double r1 = r5.value();
        if (this.version >= r1) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    private boolean isValidUntil(Until r4) {
        Until r5 = (Until) ZeusTransformUtils.wrapperContextForParams(r4, Until.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L9;
        double r1 = r5.value();
        if (this.version < r1) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    private boolean isValidVersion(Since r3, Until r4) {
        Since r5 = (Since) ZeusTransformUtils.wrapperContextForParams(r3, Since.class, "com.obric.memorydata.plugin");
        Until r6 = (Until) ZeusTransformUtils.wrapperContextForParams(r4, Until.class, "com.obric.memorydata.plugin");
        if (isValidSince(r5) == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidUntil(r6) == false) goto L7;
        return true;
    }

    public Excluder clone() {
        return (Excluder) ZeusTransformUtils.preCheckCast(super.clone(), Excluder.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m140clone() {
        return clone();
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson r12, final TypeToken<T> r13) {
        Class<? super T> r0 = r13.getRawType();
        boolean r1 = excludeClassChecks(r0);
        if (r1 == false) goto L5;
    L8:
        final boolean r8 = true;
    L9:
        if (r1 == false) goto L11;
    L14:
        final boolean r7 = true;
    L15:
        if (r8 == true) goto L20;
        if (r7 == true) goto L20;
        return null;
    L20:
        return new AnonymousClass1(this, r7, r8, r12, r13);
    L11:
        if (excludeClassInStrategy(r0, false) == true) goto L14;
        r7 = false;
        goto L15
    L5:
        if (excludeClassInStrategy(r0, true) == true) goto L8;
        r8 = false;
        goto L9
    }

    public Excluder disableInnerClassSerialization() {
        Excluder r1 = clone();
        r1.serializeInnerClasses = false;
        return r1;
    }

    public boolean excludeClass(Class<?> r2, boolean r3) {
        if (excludeClassChecks(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (excludeClassInStrategy(r2, r3) == true) goto L8;
        return false;
    }

    public boolean excludeField(Field r7, boolean r8) {
        if ((this.modifiers & r7.getModifiers()) == 0) goto L6;
        return true;
    L6:
        if (this.version == IGNORE_VERSIONS) goto L11;
        if (isValidVersion((Since) ZeusTransformUtils.preCheckCast(r7.getAnnotation(Since.class), Since.class, "com.obric.memorydata.plugin"), (Until) ZeusTransformUtils.preCheckCast(r7.getAnnotation(Until.class), Until.class, "com.obric.memorydata.plugin")) == true) goto L11;
        return true;
    L11:
        if (r7.isSynthetic() == false) goto L14;
        return true;
    L14:
        if (this.requireExpose == false) goto L25;
        Expose r0 = (Expose) ZeusTransformUtils.preCheckCast(r7.getAnnotation(Expose.class), Expose.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L23;
        if (r8 == false) goto L22;
        if (r0.serialize() == true) goto L25;
    L22:
        if (r0.deserialize() == true) goto L25;
    L23:
        return true;
    L25:
        if (this.serializeInnerClasses == true) goto L30;
        if (isInnerClass(r7.getType()) == false) goto L30;
        return true;
    L30:
        if (isAnonymousOrNonStaticLocal(r7.getType()) == false) goto L32;
        return true;
    L32:
        if (r8 == false) goto L34;
        List<ExclusionStrategy> r6 = this.serializationStrategies;
    L36:
        if (r6.isEmpty() == true) goto L43;
        FieldAttributes r9 = new FieldAttributes(r7);
        Iterator<ExclusionStrategy> r10 = r6.iterator();
    L39:
        if (r10.hasNext() == false) goto L48;
        if (((ExclusionStrategy) ZeusTransformUtils.preCheckCast(r10.next(), ExclusionStrategy.class, "com.obric.memorydata.plugin")).shouldSkipField(r9) == false) goto L39;
        return true;
    L48:
        return false;
    L43:
        return false;
    L34:
        r6 = this.deserializationStrategies;
        goto L36
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder r1 = clone();
        r1.requireExpose = true;
        return r1;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy r3, boolean r4, boolean r5) {
        ExclusionStrategy r6 = (ExclusionStrategy) ZeusTransformUtils.wrapperContextForParams(r3, ExclusionStrategy.class, "com.obric.memorydata.plugin");
        Excluder r0 = clone();
        if (r4 == false) goto L5;
        ArrayList r7 = new ArrayList(this.serializationStrategies);
        r0.serializationStrategies = r7;
        r7.add(r6);
    L5:
        if (r5 == false) goto L7;
        ArrayList r8 = new ArrayList(this.deserializationStrategies);
        r0.deserializationStrategies = r8;
        r8.add(r6);
    L7:
        return r0;
    }

    public Excluder withModifiers(int... r5) {
        Excluder r4 = clone();
        int r0 = 0;
        r4.modifiers = 0;
        int r1 = r5.length;
    L3:
        if (r0 >= r1) goto L5;
        r4.modifiers = r5[r0] | r4.modifiers;
        r0 = r0 + 1;
        goto L3
    L5:
        return r4;
    }

    public Excluder withVersion(double r1) {
        Excluder r0 = clone();
        r0.version = r1;
        return r0;
    }
}
