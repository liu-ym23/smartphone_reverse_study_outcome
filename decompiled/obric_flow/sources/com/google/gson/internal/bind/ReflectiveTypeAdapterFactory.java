package com.google.gson.internal.bind;

import ai.j0;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.GsonTypes;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.TroubleshootingGuide;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
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
        private final FieldsData fieldsData;

        public Adapter(FieldsData r5) {
            this.fieldsData = r5;
        }

        public abstract A createAccumulator();

        public abstract T finalize(A r5);

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r5) throws IOException {
            if (r5.peek() != JsonToken.NULL) goto L6;
            r5.nextNull();
            return null;
        L6:
            A r10 = createAccumulator();
            Map<String, BoundField> r11 = this.fieldsData.deserializedFields;
            r5.beginObject();     // Catch: IllegalAccessException -> L13 IllegalStateException -> L15
        L8:
            if (r5.hasNext() == false) goto L19;
            BoundField r12 = r11.get(r5.nextName());     // Catch: IllegalAccessException -> L13 IllegalStateException -> L15
            if (r12 == null) goto L12;
            readField(r10, r5, r12);     // Catch: IllegalAccessException -> L13 IllegalStateException -> L15
            goto L8
        L12:
            r5.skipValue();     // Catch: IllegalAccessException -> L13 IllegalStateException -> L15
            goto L8
        L19:
            r5.endObject();
            return finalize(r10);
        L13:
            e = move-exception;
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
        L15:
            e = move-exception;
            throw new JsonSyntaxException(e);
        }

        public abstract void readField(A r5, JsonReader r10, BoundField r11) throws IllegalAccessException, IOException;

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r5, T r10) throws IOException {
            if (r10 != null) goto L5;
            r5.nullValue();
            return;
        L5:
            r5.beginObject();
            Iterator<BoundField> r11 = this.fieldsData.serializedFields.iterator();     // Catch: IllegalAccessException -> L11
        L8:
            if (r11.hasNext() == false) goto L13;
            r11.next().write(r5, r10);     // Catch: IllegalAccessException -> L11
            goto L8
        L13:
            r5.endObject();
            return;
        L11:
            e = move-exception;
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
        }
    }

    public static abstract class BoundField {
        final Field field;
        final String fieldName;
        final String serializedName;

        public BoundField(String r5, Field r10) {
            this.serializedName = r5;
            this.field = r10;
            this.fieldName = r10.getName();
        }

        public abstract void readIntoArray(JsonReader r5, int r10, Object[] r11) throws IOException, JsonParseException;

        public abstract void readIntoField(JsonReader r5, Object r10) throws IOException, IllegalAccessException;

        public abstract void write(JsonWriter r5, Object r10) throws IOException, IllegalAccessException;
    }

    public static final class FieldReflectionAdapter<T> extends Adapter<T, T> {
        private final ObjectConstructor<T> constructor;

        public FieldReflectionAdapter(ObjectConstructor<T> r5, FieldsData r10) {
            super(r10);
            this.constructor = r5;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public T createAccumulator() {
            return this.constructor.construct();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public T finalize(T r5) {
            return r5;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public void readField(T r5, JsonReader r10, BoundField r11) throws IllegalAccessException, IOException {
            r11.readIntoField(r10, r5);
        }
    }

    public static class FieldsData {
        static final FieldsData EMPTY = null;
        final Map<String, BoundField> deserializedFields;
        final List<BoundField> serializedFields;

        static {
            EMPTY = new FieldsData(Collections.emptyMap(), Collections.emptyList());
        }

        public FieldsData(Map<String, BoundField> r5, List<BoundField> r10) {
            this.deserializedFields = r5;
            this.serializedFields = r10;
        }
    }

    public static final class RecordAdapter<T> extends Adapter<T, Object[]> {
        static final Map<Class<?>, Object> PRIMITIVE_DEFAULTS = null;
        private final Map<String, Integer> componentIndices;
        private final Constructor<T> constructor;
        private final Object[] constructorArgsDefaults;

        static {
            PRIMITIVE_DEFAULTS = primitiveDefaults();
        }

        public RecordAdapter(Class<T> r5, FieldsData r10, boolean r11) {
            super(r10);
            this.componentIndices = new HashMap();
            Constructor<T> r12 = ReflectionHelper.getCanonicalRecordConstructor(r5);
            this.constructor = r12;
            if (r11 == false) goto L5;
            ReflectiveTypeAdapterFactory.access$000(null, r12);
        L6:
            String[] r13 = ReflectionHelper.getRecordComponentNames(r5);
            int r14 = 0;
            int r15 = 0;
        L8:
            if (r15 >= r13.length) goto L10;
            this.componentIndices.put(r13[r15], Integer.valueOf(r15));
            r15 = r15 + 1;
            goto L8
        L10:
            Class<?>[] r16 = this.constructor.getParameterTypes();
            this.constructorArgsDefaults = new Object[r16.length];
        L12:
            if (r14 >= r16.length) goto L14;
            this.constructorArgsDefaults[r14] = PRIMITIVE_DEFAULTS.get(r16[r14]);
            r14 = r14 + 1;
            goto L12
        L14:
            return;
        L5:
            ReflectionHelper.makeAccessible(r12);
            goto L6
        }

        private static Map<Class<?>, Object> primitiveDefaults() {
            HashMap r5 = new HashMap();
            r5.put(Byte.TYPE, (byte) 0);
            r5.put(Short.TYPE, (short) 0);
            r5.put(Integer.TYPE, 0);
            r5.put(Long.TYPE, 0L);
            r5.put(Float.TYPE, Float.valueOf(0.0f));
            r5.put(Double.TYPE, Double.valueOf(0.0d));
            r5.put(Character.TYPE, (char) 0);
            r5.put(Boolean.TYPE, Boolean.FALSE);
            return r5;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public /* bridge */ /* synthetic */ Object[] createAccumulator() {
            return createAccumulator2();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public /* bridge */ /* synthetic */ Object finalize(Object[] r5) {
            return finalize2(r5);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public /* bridge */ /* synthetic */ void readField(Object[] r5, JsonReader r10, BoundField r11) throws IllegalAccessException, IOException {
            readField2(r5, r10, r11);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* JADX INFO: renamed from: createAccumulator, reason: avoid collision after fix types in other method */
        public Object[] createAccumulator2() {
            return (Object[]) this.constructorArgsDefaults.clone();
        }

        /* JADX INFO: renamed from: finalize, reason: avoid collision after fix types in other method */
        public T finalize2(Object[] r10) {
            return this.constructor.newInstance(r10);
        L9:
            e = move-exception;
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
        L7:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(r10), e);
        L5:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(r10), e.getCause());
        }

        /* JADX INFO: renamed from: readField, reason: avoid collision after fix types in other method */
        public void readField2(Object[] r5, JsonReader r10, BoundField r11) throws IOException {
            Integer r12 = this.componentIndices.get(r11.fieldName);
            if (r12 == null) goto L6;
            r11.readIntoArray(r10, r12.intValue(), r5);
            return;
        L6:
            StringBuilder r13 = new StringBuilder("Could not find the index in the constructor '");
            r13.append(ReflectionHelper.constructorToString(this.constructor));
            r13.append("' for field with name '");
            throw new IllegalStateException(j0.q(r13, r11.fieldName, "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters."));
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor r5, FieldNamingStrategy r10, Excluder r11, JsonAdapterAnnotationTypeAdapterFactory r12, List<ReflectionAccessFilter> r13) {
        this.constructorConstructor = r5;
        this.fieldNamingPolicy = r10;
        this.excluder = r11;
        this.jsonAdapterFactory = r12;
        this.reflectionFilters = r13;
    }

    public static /* synthetic */ void access$000(Object r5, AccessibleObject r10) {
        checkAccessible(r5, r10);
    }

    private static <M extends AccessibleObject & Member> void checkAccessible(Object r5, M r10) {
        if (Modifier.isStatic(r10.getModifiers()) == false) goto L6;
        r5 = null;
    L6:
        if (ReflectionAccessFilterHelper.canAccess(r10, r5) == false) goto L9;
        return;
    L9:
        throw new JsonIOException(j0.j(ReflectionHelper.getAccessibleObjectDescription(r10, true), " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type."));
    }

    private BoundField createBoundField(Gson r14, final Field r15, final Method r16, final String r17, TypeToken<?> r18, boolean r19, final boolean r20) {
        final boolean r10 = Primitives.isPrimitive(r18.getRawType());
        int r5 = r15.getModifiers();
        boolean r11 = false;
        if (Modifier.isStatic(r5) == true) goto L5;
    L7:
        boolean r12 = false;
    L8:
        JsonAdapter r13 = (JsonAdapter) r15.getAnnotation(JsonAdapter.class);
        if (r13 == null) goto L11;
        TypeAdapter<?> r21 = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, r14, r18, r13, false);
    L12:
        if (r21 == null) goto L15;
        r11 = true;
    L15:
        if (r21 != null) goto L17;
        r21 = r14.getAdapter(r18);
    L17:
        final TypeAdapter<?> r22 = r21;
        if (r19 == false) goto L23;
        if (r11 == false) goto L21;
        TypeAdapter<?> r23 = r22;
    L22:
        final TypeAdapter<?> r24 = r23;
    L24:
        final boolean r25 = r12;
        return new AnonymousClass2(this, r17, r15, r20, r16, r24, r22, r10, r25);
    L21:
        r23 = new TypeAdapterRuntimeTypeWrapper(r14, r22, r18.getType());
        goto L22
    L23:
        r24 = r22;
        goto L24
    L11:
        r21 = null;
        goto L12
    L5:
        if (Modifier.isFinal(r5) == false) goto L7;
        r12 = true;
        goto L8
    }

    private static IllegalArgumentException createDuplicateFieldException(Class<?> r5, String r10, Field r11, Field r12) {
        throw new IllegalArgumentException("Class " + r5.getName() + " declares multiple JSON fields named '" + r10 + "'; conflict is caused by fields " + ReflectionHelper.fieldToString(r11) + " and " + ReflectionHelper.fieldToString(r12) + "\nSee " + TroubleshootingGuide.createUrl("duplicate-fields"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.google.gson.internal.bind.ReflectiveTypeAdapterFactory] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v3 */
    private FieldsData getBoundFields(Gson r24, TypeToken<?> r25, Class<?> r26, boolean r27, boolean r28) {
        if (r26.isInterface() == true) goto L5;
        LinkedHashMap r10 = new LinkedHashMap();
        LinkedHashMap r11 = new LinkedHashMap();
        TypeToken<?> r12 = r25;
        boolean r5 = r27;
        Class<?> r13 = r26;
    L8:
        if (r13 == Object.class) goto L66;
        Field[] r14 = r13.getDeclaredFields();
        boolean r15 = true;
        ?? r16 = 0;
        if (r13 != r26) goto L12;
    L19:
        boolean r17 = r5;
        int r18 = r14.length;
        int r19 = 0;
    L23:
        if (r19 >= r18) goto L64;
        Field r20 = r14[r19];
        boolean r110 = includeField(r20, r15);
        boolean r21 = includeField(r20, r16);
        if (r110 == true) goto L28;
        if (r21 == true) goto L28;
        int r22 = r19;
        int r111 = r18;
        ?? r23 = r16;
    L63:
        r19 = r22 + 1;
        r18 = r111;
        r16 = r23;
        r15 = true;
    L28:
        Method r29 = null;
        if (r28 == true) goto L31;
    L43:
        ?? r112 = r21;
        Method r30 = r29;
    L44:
        if (r17 == true) goto L47;
        if (r30 != null) goto L47;
        ReflectionHelper.makeAccessible(r20);
    L47:
        Type r31 = GsonTypes.resolve(r12.getType(), r13, r20.getGenericType());
        List<String> r32 = getFieldNames(r20);
        String r33 = r32.get(r16);
        r22 = r19;
        r111 = r18;
        r23 = r16;
        BoundField r34 = createBoundField(r24, r20, r30, r33, TypeToken.get(r31), r110, r17);
        if (r112 == 0) goto L57;
        Iterator<String> r35 = r32.iterator();
    L51:
        if (r35.hasNext() == false) goto L57;
        String r36 = r35.next();
        BoundField r37 = (BoundField) r10.put(r36, r34);
        if (r37 == null) goto L51;
        throw createDuplicateFieldException(r26, r36, r37.field, r20);
    L57:
        if (r110 == false) goto L63;
        BoundField r38 = (BoundField) r11.put(r33, r34);
        if (r38 == null) goto L63;
        throw createDuplicateFieldException(r26, r33, r38.field, r20);
    L31:
        if (Modifier.isStatic(r20.getModifiers()) == false) goto L33;
        r30 = null;
        r112 = r16;
        goto L44
    L33:
        r29 = ReflectionHelper.getAccessor(r13, r20);
        if (r17 == true) goto L37;
        ReflectionHelper.makeAccessible(r29);
    L37:
        if (r29.getAnnotation(SerializedName.class) == null) goto L43;
        if (r20.getAnnotation(SerializedName.class) != null) goto L43;
        throw new JsonIOException(j0.k("@SerializedName on ", ReflectionHelper.getAccessibleObjectDescription(r29, r16), " is not supported"));
    L64:
        r12 = TypeToken.get(GsonTypes.resolve(r12.getType(), r13, r13.getGenericSuperclass()));
        r13 = r12.getRawType();
        r5 = r17;
        goto L8
    L12:
        if (r14.length <= 0) goto L19;
        ReflectionAccessFilter.FilterResult r39 = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, r13);
        if (r39 == ReflectionAccessFilter.FilterResult.BLOCK_ALL) goto L21;
        if (r39 != ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) goto L18;
        r5 = true;
        goto L19
    L18:
        r5 = false;
        goto L19
    L21:
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + r13 + " (supertype of " + r26 + "). Register a TypeAdapter for this type or adjust the access filter.");
    L66:
        return new FieldsData(r10, new ArrayList(r11.values()));
    L5:
        return FieldsData.EMPTY;
    }

    private List<String> getFieldNames(Field r5) {
        SerializedName r10 = (SerializedName) r5.getAnnotation(SerializedName.class);
        if (r10 != null) goto L5;
        String r11 = this.fieldNamingPolicy.translateName(r5);
        List<String> r12 = this.fieldNamingPolicy.alternateNames(r5);
    L7:
        if (r12.isEmpty() == true) goto L9;
        ArrayList r13 = new ArrayList(r12.size() + 1);
        r13.add(r11);
        r13.addAll(r12);
        return r13;
    L9:
        return Collections.singletonList(r11);
    L5:
        String r14 = r10.value();
        List<String> r15 = Arrays.asList(r10.alternate());
        r11 = r14;
        r12 = r15;
        goto L7
    }

    private boolean includeField(Field r5, boolean r10) {
        return !this.excluder.excludeField(r5, r10);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r11, TypeToken<T> r12) {
        Class<? super T> r10 = r12.getRawType();
        if (Object.class.isAssignableFrom(r10) == true) goto L7;
        return null;
    L7:
        if (ReflectionHelper.isAnonymousOrNonStaticLocal(r10) == true) goto L9;
        ReflectionAccessFilter.FilterResult r5 = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, r10);
        if (r5 == ReflectionAccessFilter.FilterResult.BLOCK_ALL) goto L23;
        if (r5 != ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) goto L15;
        boolean r13 = true;
    L17:
        if (ReflectionHelper.isRecord(r10) == false) goto L21;
        return new RecordAdapter(r10, getBoundFields(r11, r12, r10, r13, true), r13);
    L21:
        return new FieldReflectionAdapter(this.constructorConstructor.get(r12, true), getBoundFields(r11, r12, r10, r13, false));
    L15:
        r13 = false;
        goto L17
    L23:
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + r10 + ". Register a TypeAdapter for this type or adjust the access filter.");
    L9:
        return new AnonymousClass1(this);
    }
}
