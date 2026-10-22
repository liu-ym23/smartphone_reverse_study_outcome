package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private static final TypeAdapterFactory TREE_TYPE_CLASS_DUMMY_FACTORY = null;
    private static final TypeAdapterFactory TREE_TYPE_FIELD_DUMMY_FACTORY = null;
    private final ConcurrentMap<Class<?>, TypeAdapterFactory> adapterFactoryMap;
    private final ConstructorConstructor constructorConstructor;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class DummyTypeAdapterFactory implements TypeAdapterFactory {
        private DummyTypeAdapterFactory() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson r5, TypeToken<T> r10) {
            throw new AssertionError("Factory should not be used");
        }

        public /* synthetic */ DummyTypeAdapterFactory(AnonymousClass1 r5) {
            this();
        }
    }

    static {
        AnonymousClass1 r5 = null;
        TREE_TYPE_CLASS_DUMMY_FACTORY = new DummyTypeAdapterFactory(r5);
        TREE_TYPE_FIELD_DUMMY_FACTORY = new DummyTypeAdapterFactory(r5);
    }

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor r5) {
        this.constructorConstructor = r5;
        this.adapterFactoryMap = new ConcurrentHashMap();
    }

    private static Object createAdapter(ConstructorConstructor r5, Class<?> r10) {
        return r5.get(TypeToken.get(r10), true).construct();
    }

    private static JsonAdapter getAnnotation(Class<?> r5) {
        return (JsonAdapter) r5.getAnnotation(JsonAdapter.class);
    }

    private TypeAdapterFactory putFactoryAndGetCurrent(Class<?> r5, TypeAdapterFactory r10) {
        TypeAdapterFactory r11 = this.adapterFactoryMap.putIfAbsent(r5, r10);
        if (r11 != null) goto L5;
        return r10;
    L5:
        return r11;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r10, TypeToken<T> r11) {
        JsonAdapter r5 = getAnnotation(r11.getRawType());
        if (r5 != null) goto L7;
        return null;
    L7:
        return (TypeAdapter<T>) getTypeAdapter(this.constructorConstructor, r10, r11, r5, true);
    }

    public TypeAdapter<?> getTypeAdapter(ConstructorConstructor r10, Gson r11, TypeToken<?> r12, JsonAdapter r13, boolean r14) {
        Object r15 = createAdapter(r10, r13.value());
        boolean r16 = r13.nullSafe();
        if ((r15 instanceof TypeAdapter) == false) goto L6;
        TypeAdapter<?> r17 = (TypeAdapter) r15;
    L31:
        if (r17 == null) goto L35;
        if (r16 == true) goto L34;
        return r17;
    L34:
        return r17.nullSafe();
    L35:
        return r17;
    L6:
        if ((r15 instanceof TypeAdapterFactory) == false) goto L11;
        TypeAdapterFactory r18 = (TypeAdapterFactory) r15;
        if (r14 == false) goto L10;
        r18 = putFactoryAndGetCurrent(r12.getRawType(), r18);
    L10:
        r17 = r18.create(r11, r12);
        goto L31
    L11:
        boolean r19 = r15 instanceof JsonSerializer;
        if (r19 == true) goto L19;
        if ((r15 instanceof JsonDeserializer) == true) goto L19;
        throw new IllegalArgumentException("Invalid attempt to bind an instance of " + r15.getClass().getName() + " as a @JsonAdapter for " + r12.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
    L19:
        if (r19 == false) goto L21;
        JsonSerializer r5 = (JsonSerializer) r15;
    L23:
        if ((r15 instanceof JsonDeserializer) == false) goto L25;
        JsonDeserializer r20 = (JsonDeserializer) r15;
    L26:
        if (r14 == false) goto L29;
        TypeAdapterFactory r21 = TREE_TYPE_CLASS_DUMMY_FACTORY;
    L30:
        r17 = new TreeTypeAdapter(r5, r20, r11, r12, r21, r16);
        r16 = false;
        goto L31
    L29:
        r21 = TREE_TYPE_FIELD_DUMMY_FACTORY;
        goto L30
    L25:
        r20 = null;
        goto L26
    L21:
        r5 = null;
        goto L23
    }

    public boolean isClassJsonAdapterFactory(TypeToken<?> r5, TypeAdapterFactory r10) {
        Objects.requireNonNull(r5);
        Objects.requireNonNull(r10);
        if (r10 != TREE_TYPE_CLASS_DUMMY_FACTORY) goto L5;
        return true;
    L5:
        Class<? super Object> r11 = r5.getRawType();
        TypeAdapterFactory r12 = this.adapterFactoryMap.get(r11);
        if (r12 == null) goto L11;
        if (r12 != r10) goto L10;
        return true;
    L10:
        return false;
    L11:
        JsonAdapter r13 = getAnnotation(r11);
        if (r13 != null) goto L14;
        return false;
    L14:
        Class<?> r14 = r13.value();
        if (TypeAdapterFactory.class.isAssignableFrom(r14) == true) goto L18;
        return false;
    L18:
        if (putFactoryAndGetCurrent(r11, (TypeAdapterFactory) createAdapter(this.constructorConstructor, r14)) != r10) goto L21;
        return true;
    L21:
        return false;
    }
}
