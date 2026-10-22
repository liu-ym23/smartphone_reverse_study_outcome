package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    private final List<ReflectionAccessFilter> reflectionFilters;

    public static abstract class Adapter<T, A> extends TypeAdapter<T> {
        final Map<String, BoundField> boundFields;

        Adapter(Map<String, BoundField> r3) {
            this.boundFields = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        }

        abstract A createAccumulator();

        abstract T finalize(A r1);

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r5) {
            if (r5.peek() != JsonToken.NULL) goto L6;
            r5.nextNull();
            return null;
        L6:
            A r0 = createAccumulator();
            r5.beginObject();     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
        L8:
            if (r5.hasNext() == false) goto L18;
            String r1 = r5.nextName();     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
            BoundField r2 = (BoundField) ZeusTransformUtils.preCheckCast(this.boundFields.get(r1), BoundField.class, "com.obric.memorydata.plugin");     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
            if (r2 == null) goto L16;
            if (r2.deserialized == false) goto L16;
            readField(r0, r5, r2);     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
        L16:
            r5.skipValue();     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
            goto L8
        L18:
            r5.endObject();
            return finalize(r0);
        L20:
            e = move-exception;
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
        L23:
            e = move-exception;
            throw new JsonSyntaxException(e);
        }

        abstract void readField(A r1, JsonReader r2, BoundField r3);

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r4, T r5) {
            if (r5 != null) goto L5;
            r4.nullValue();
            return;
        L5:
            r4.beginObject();
            Iterator<BoundField> r3 = this.boundFields.values().iterator();     // Catch: IllegalAccessException -> L13
        L8:
            if (r3.hasNext() == false) goto L11;
            ((BoundField) ZeusTransformUtils.preCheckCast(r3.next(), BoundField.class, "com.obric.memorydata.plugin")).write(r4, r5);     // Catch: IllegalAccessException -> L13
            goto L8
        L11:
            r4.endObject();
            return;
        L13:
            e = move-exception;
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
        }
    }

    static abstract class BoundField {
        final boolean deserialized;
        final Field field;
        final String fieldName;
        final String name;
        final boolean serialized;

        public BoundField(String r1, Field r2, boolean r3, boolean r4) {
            this.name = r1;
            this.field = r2;
            this.fieldName = r2.getName();
            this.serialized = r3;
            this.deserialized = r4;
        }

        abstract void readIntoArray(JsonReader r1, int r2, Object[] r3);

        abstract void readIntoField(JsonReader r1, Object r2);

        abstract void write(JsonWriter r1, Object r2);
    }

    private static final class FieldReflectionAdapter<T> extends Adapter<T, T> {
        private final ObjectConstructor<T> constructor;

        FieldReflectionAdapter(ObjectConstructor<T> r3, Map<String, BoundField> r4) {
            ObjectConstructor<T> r5 = (ObjectConstructor) ZeusTransformUtils.wrapperContextForParams(r3, ObjectConstructor.class, "com.obric.memorydata.plugin");
            super((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
            this.constructor = r5;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        T createAccumulator() {
            return this.constructor.construct();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        T finalize(T r1) {
            return r1;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        void readField(T r1, JsonReader r2, BoundField r3) {
            r3.readIntoField(r2, r1);
        }
    }

    private static final class RecordAdapter<T> extends Adapter<T, Object[]> {
        static final Map<Class<?>, Object> PRIMITIVE_DEFAULTS = null;
        private final Map<String, Integer> componentIndices;
        private final Constructor<T> constructor;
        private final Object[] constructorArgsDefaults;

        static {
            PRIMITIVE_DEFAULTS = primitiveDefaults();
        }

        RecordAdapter(Class<T> r4, Map<String, BoundField> r5, boolean r6) {
            super((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"));
            this.componentIndices = new HashMap();
            Constructor<T> r7 = ReflectionHelper.getCanonicalRecordConstructor(r4);
            this.constructor = r7;
            if (r6 == false) goto L5;
            ReflectiveTypeAdapterFactory.access$000(null, r7);
        L6:
            String[] r8 = ReflectionHelper.getRecordComponentNames(r4);
            int r9 = 0;
            int r10 = 0;
        L8:
            if (r10 >= r8.length) goto L10;
            this.componentIndices.put(r8[r10], Integer.valueOf(r10));
            r10 = r10 + 1;
            goto L8
        L10:
            Class<?>[] r11 = this.constructor.getParameterTypes();
            this.constructorArgsDefaults = new Object[r11.length];
        L12:
            if (r9 >= r11.length) goto L14;
            this.constructorArgsDefaults[r9] = PRIMITIVE_DEFAULTS.get(r11[r9]);
            r9 = r9 + 1;
            goto L12
        L14:
            return;
        L5:
            ReflectionHelper.makeAccessible(r7);
            goto L6
        }

        private static Map<Class<?>, Object> primitiveDefaults() {
            HashMap r0 = new HashMap();
            r0.put(Byte.TYPE, (byte) 0);
            r0.put(Short.TYPE, (short) 0);
            r0.put(Integer.TYPE, 0);
            r0.put(Long.TYPE, 0L);
            r0.put(Float.TYPE, Float.valueOf(0.0f));
            r0.put(Double.TYPE, Double.valueOf(0.0d));
            r0.put(Character.TYPE, (char) 0);
            r0.put(Boolean.TYPE, false);
            return r0;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* bridge */ /* synthetic */ Object[] createAccumulator() {
            return createAccumulator2();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* JADX INFO: renamed from: createAccumulator, reason: avoid collision after fix types in other method */
        Object[] createAccumulator2() {
            return (Object[]) ZeusTransformUtils.preCheckCast(this.constructorArgsDefaults.clone(), Object[].class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* synthetic */ Object finalize(Object[] r3) {
            return finalize2((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: finalize, reason: avoid collision after fix types in other method */
        T finalize2(Object[] r6) {
            return this.constructor.newInstance(r6);
        L11:
            e = move-exception;
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
        L8:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(r6), e);
        L5:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(r6), e.getCause());
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* synthetic */ void readField(Object[] r3, JsonReader r4, BoundField r5) {
            readField2((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.memorydata.plugin"), r4, r5);
        }

        /* JADX INFO: renamed from: readField, reason: avoid collision after fix types in other method */
        void readField2(Object[] r4, JsonReader r5, BoundField r6) {
            Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.componentIndices.get(r6.fieldName), Integer.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L7;
            r6.readIntoArray(r5, r0.intValue(), r4);
            return;
        L7:
            throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' for field with name '" + r6.fieldName + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor r3, FieldNamingStrategy r4, Excluder r5, JsonAdapterAnnotationTypeAdapterFactory r6, List<ReflectionAccessFilter> r7) {
        FieldNamingStrategy r8 = (FieldNamingStrategy) ZeusTransformUtils.wrapperContextForParams(r4, FieldNamingStrategy.class, "com.obric.memorydata.plugin");
        List<ReflectionAccessFilter> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.constructorConstructor = r3;
        this.fieldNamingPolicy = r8;
        this.excluder = r5;
        this.jsonAdapterFactory = r6;
        this.reflectionFilters = r9;
    }

    static /* synthetic */ void access$000(Object r0, AccessibleObject r1) {
        checkAccessible(r0, r1);
    }

    private static <M extends AccessibleObject & Member> void checkAccessible(Object r2, M r3) {
        if (Modifier.isStatic(((Member) ZeusTransformUtils.preCheckCast(r3, Member.class, "com.obric.memorydata.plugin")).getModifiers()) == false) goto L6;
        r2 = null;
    L6:
        if (ReflectionAccessFilterHelper.canAccess(r3, r2) == false) goto L9;
        return;
    L9:
        throw new JsonIOException(ReflectionHelper.getAccessibleObjectDescription(r3, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private BoundField createBoundField(final Gson r16, final Field r17, final Method r18, final String r19, final TypeToken<?> r20, final boolean r21, final boolean r22, final boolean r23) {
        final boolean r12 = Primitives.isPrimitive(r20.getRawType());
        int r0 = r17.getModifiers();
        if (Modifier.isStatic(r0) == true) goto L5;
    L7:
        final boolean r13 = false;
    L8:
        JsonAdapter r1 = (JsonAdapter) ZeusTransformUtils.preCheckCast(r17.getAnnotation(JsonAdapter.class), JsonAdapter.class, "com.obric.memorydata.plugin");
        TypeAdapter<?> r2 = null;
        if (r1 == null) goto L11;
        r2 = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, r16, r20, r1);
    L11:
        if (r2 == null) goto L13;
        final boolean r8 = true;
    L14:
        if (r2 != null) goto L16;
        final TypeAdapter<?> r9 = r16.getAdapter(r20);
    L18:
        return new AnonymousClass1(this, r19, r17, r21, r22, r23, r18, r8, r9, r16, r20, r12, r13);
    L16:
        r9 = r2;
        goto L18
    L13:
        r8 = false;
        goto L14
    L5:
        if (Modifier.isFinal(r0) == false) goto L7;
        r13 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r21v0 */
    private Map<String, BoundField> getBoundFields(Gson r29, TypeToken<?> r30, Class<?> r31, boolean r32, boolean r33) {
        Class<?> r10 = r31;
        LinkedHashMap r11 = new LinkedHashMap();
        if (r31.isInterface() == false) goto L5;
        return r11;
    L5:
        TypeToken<?> r12 = r30;
        boolean r0 = r32;
        Class<?> r13 = r10;
    L7:
        if (r13 == Object.class) goto L63;
        Field[] r14 = r13.getDeclaredFields();
        boolean r15 = true;
        boolean r8 = false;
        if (r13 != r10) goto L11;
    L20:
        boolean r16 = r0;
        int r7 = r14.length;
        int r6 = 0;
    L21:
        if (r6 >= r7) goto L62;
        Field r5 = r14[r6];
        boolean r1 = this.includeField(r5, r15);
        boolean r2 = this.includeField(r5, r8);
        if (r1 == true) goto L26;
        if (r2 == true) goto L26;
        int r25 = r6;
        int r26 = r7;
        boolean r27 = r8;
    L59:
        r6 = r25 + 1;
        ReflectiveTypeAdapterFactory this = this;
        r7 = r26;
        r8 = r27;
        r15 = true;
    L26:
        BoundField r3 = null;
        if (r33 == true) goto L29;
        boolean r17 = r2;
        Method r18 = null;
    L43:
        if (r16 == true) goto L46;
        if (r18 != null) goto L46;
        ReflectionHelper.makeAccessible(r5);
    L46:
        Type r19 = C$Gson$Types.resolve(r12.getType(), r13, r5.getGenericType());
        List<String> r4 = this.getFieldNames(r5);
        int r9 = r4.size();
        ?? r20 = r8;
    L47:
        if (r20 >= r9) goto L57;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r4.get(r20), String.class, "com.obric.memorydata.plugin");
        if (r20 == 0) goto L51;
        boolean r21 = false;
    L52:
        ?? r22 = r20;
        BoundField r111 = r3;
        int r23 = r9;
        List<String> r24 = r4;
        Field r28 = r5;
        int r210 = r6;
        int r211 = r7;
        BoundField r34 = (BoundField) ZeusTransformUtils.preCheckCast(r11.put(r110, createBoundField(r29, r5, r18, r110, TypeToken.get(r19), r21, r17, r16)), BoundField.class, "com.obric.memorydata.plugin");
        if (r111 != null) goto L55;
        r3 = r34;
    L56:
        r1 = r21;
        r9 = r23;
        r4 = r24;
        r5 = r28;
        r6 = r210;
        r7 = r211;
        r8 = false;
        r20 = (r22 == true ? 1 : 0) + 1;
        goto L47
    L55:
        r3 = r111;
        goto L56
    L51:
        r21 = r1;
        goto L52
    L57:
        BoundField r112 = r3;
        Field r212 = r5;
        r25 = r6;
        r26 = r7;
        r27 = r8;
        if (r112 == null) goto L59;
        throw new IllegalArgumentException("Class " + r31.getName() + " declares multiple JSON fields named '" + r112.name + "'; conflict is caused by fields " + ReflectionHelper.fieldToString(r112.field) + " and " + ReflectionHelper.fieldToString(r212));
    L29:
        if (Modifier.isStatic(r5.getModifiers()) == false) goto L31;
        r18 = null;
        r17 = r8;
        goto L43
    L31:
        Method r35 = ReflectionHelper.getAccessor(r13, r5);
        if (r16 == true) goto L35;
        ReflectionHelper.makeAccessible(r35);
    L35:
        if (r35.getAnnotation(SerializedName.class) != null) goto L37;
    L41:
        r17 = r2;
        r18 = r35;
        goto L43
    L37:
        if (r5.getAnnotation(SerializedName.class) != null) goto L41;
        throw new JsonIOException("@SerializedName on " + ReflectionHelper.getAccessibleObjectDescription(r35, r8) + " is not supported");
    L62:
        r12 = TypeToken.get(C$Gson$Types.resolve(r12.getType(), r13, r13.getGenericSuperclass()));
        r13 = r12.getRawType();
        r10 = r31;
        r0 = r16;
        goto L7
    L11:
        if (r14.length <= 0) goto L20;
        ReflectionAccessFilter.FilterResult r36 = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, r13);
        if (r36 == ReflectionAccessFilter.FilterResult.BLOCK_ALL) goto L19;
        if (r36 != ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) goto L17;
        r0 = true;
        goto L20
    L17:
        r0 = false;
        goto L20
    L19:
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + r13 + " (supertype of " + r10 + "). Register a TypeAdapter for this type or adjust the access filter.");
    L63:
        return r11;
    }

    private List<String> getFieldNames(Field r4) {
        SerializedName r0 = (SerializedName) ZeusTransformUtils.preCheckCast(r4.getAnnotation(SerializedName.class), SerializedName.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        String r3 = r0.value();
        String[] r5 = r0.alternate();
        if (r5.length == 0) goto L9;
        ArrayList r1 = new ArrayList(r5.length + 1);
        r1.add(r3);
        Collections.addAll(r1, r5);
        return r1;
    L9:
        return Collections.singletonList(r3);
    L5:
        return Collections.singletonList(this.fieldNamingPolicy.translateName(r4));
    }

    private boolean includeField(Field r3, boolean r4) {
        if (this.excluder.excludeClass(r3.getType(), r4) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.excluder.excludeField(r3, r4) == true) goto L7;
        return true;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r11, TypeToken<T> r12) {
        Class<? super T> r6 = r12.getRawType();
        if (Object.class.isAssignableFrom(r6) == true) goto L6;
        return null;
    L6:
        ReflectionAccessFilter.FilterResult r0 = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, r6);
        if (r0 == ReflectionAccessFilter.FilterResult.BLOCK_ALL) goto L19;
        if (r0 != ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) goto L11;
        boolean r1 = true;
    L12:
        boolean r7 = r1;
        if (ReflectionHelper.isRecord(r6) == false) goto L17;
        return new RecordAdapter(r6, getBoundFields(r11, r12, r6, r7, true), r7);
    L17:
        return new FieldReflectionAdapter(this.constructorConstructor.get(r12), getBoundFields(r11, r12, r6, r7, false));
    L11:
        r1 = false;
        goto L12
    L19:
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + r6 + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
