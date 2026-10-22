package com.google.gson;

import ai.j0;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes2.dex */
public final class GsonBuilder {
    static final GsonBuilder DEFAULT = null;
    private static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final ConstructorConstructor DEFAULT_CONSTRUCTOR_CONSTRUCTOR = null;
    private static final String DEFAULT_DATE_PATTERN = null;
    private static final boolean DEFAULT_ESCAPE_HTML = true;
    private static final FieldNamingStrategy DEFAULT_FIELD_NAMING_STRATEGY = null;
    private static final FormattingStyle DEFAULT_FORMATTING_STYLE = null;
    static final JsonAdapterAnnotationTypeAdapterFactory DEFAULT_JSON_ADAPTER_ANNOTATION_TYPE_ADAPTER_FACTORY = null;
    private static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    private static final ToNumberStrategy DEFAULT_NUMBER_TO_NUMBER_STRATEGY = null;
    private static final ToNumberStrategy DEFAULT_OBJECT_TO_NUMBER_STRATEGY = null;
    private static final boolean DEFAULT_SERIALIZE_NULLS = false;
    private static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    private static final Strictness DEFAULT_STRICTNESS = null;
    static final List<TypeAdapterFactory> DEFAULT_TYPE_ADAPTER_FACTORIES = null;
    private static final boolean DEFAULT_USE_JDK_UNSAFE = true;
    boolean complexMapKeySerialization;
    String datePattern;
    int dateStyle;
    boolean escapeHtmlChars;
    Excluder excluder;
    final List<TypeAdapterFactory> factories;
    FieldNamingStrategy fieldNamingPolicy;
    FormattingStyle formattingStyle;
    boolean generateNonExecutableJson;
    final List<TypeAdapterFactory> hierarchyFactories;
    final Map<Type, InstanceCreator<?>> instanceCreators;
    LongSerializationPolicy longSerializationPolicy;
    ToNumberStrategy numberToNumberStrategy;
    ToNumberStrategy objectToNumberStrategy;
    final ArrayDeque<ReflectionAccessFilter> reflectionFilters;
    boolean serializeNulls;
    boolean serializeSpecialFloatingPointValues;
    Strictness strictness;
    int timeStyle;
    boolean useJdkUnsafe;

    static {
        DEFAULT_FORMATTING_STYLE = FormattingStyle.COMPACT;
        DEFAULT_DATE_PATTERN = null;
        DEFAULT_FIELD_NAMING_STRATEGY = FieldNamingPolicy.IDENTITY;
        DEFAULT_OBJECT_TO_NUMBER_STRATEGY = ToNumberPolicy.DOUBLE;
        DEFAULT_NUMBER_TO_NUMBER_STRATEGY = ToNumberPolicy.LAZILY_PARSED_NUMBER;
        ConstructorConstructor r5 = new ConstructorConstructor(Collections.emptyMap(), true, Collections.emptyList());
        DEFAULT_CONSTRUCTOR_CONSTRUCTOR = r5;
        JsonAdapterAnnotationTypeAdapterFactory r10 = new JsonAdapterAnnotationTypeAdapterFactory(r5);
        DEFAULT_JSON_ADAPTER_ANNOTATION_TYPE_ADAPTER_FACTORY = r10;
        GsonBuilder r11 = new GsonBuilder();
        DEFAULT = r11;
        DEFAULT_TYPE_ADAPTER_FACTORIES = r11.createFactories(r5, r10);
    }

    public GsonBuilder() {
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = DEFAULT_FIELD_NAMING_STRATEGY;
        this.instanceCreators = new HashMap();
        this.factories = new ArrayList();
        this.hierarchyFactories = new ArrayList();
        this.serializeNulls = false;
        this.datePattern = DEFAULT_DATE_PATTERN;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.formattingStyle = DEFAULT_FORMATTING_STYLE;
        this.generateNonExecutableJson = false;
        this.strictness = DEFAULT_STRICTNESS;
        this.useJdkUnsafe = true;
        this.objectToNumberStrategy = DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
        this.numberToNumberStrategy = DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
        this.reflectionFilters = new ArrayDeque();
    }

    private void addDateTypeAdapters(List<TypeAdapterFactory> r10) {
        boolean r5 = SqlTypesSupport.SUPPORTS_SQL_TYPES;
        String r11 = this.datePattern;
        TypeAdapterFactory r12 = null;
        if (r11 != null) goto L5;
    L10:
        int r13 = this.dateStyle;
        if (r13 == 2) goto L13;
    L16:
        TypeAdapterFactory r14 = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(r13, this.timeStyle);
        if (r5 == true) goto L18;
    L9:
        TypeAdapterFactory r15 = null;
    L19:
        r10.add(r14);
        if (r5 == false) goto L23;
        r10.add(r12);
        r10.add(r15);
        return;
    L23:
        return;
    L18:
        r12 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(this.dateStyle, this.timeStyle);
        r15 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(this.dateStyle, this.timeStyle);
        goto L19
    L13:
        if (this.timeStyle != 2) goto L16;
        return;
    L5:
        if (r11.trim().isEmpty() == true) goto L10;
        r14 = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(this.datePattern);
        if (r5 == false) goto L9;
        r12 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(this.datePattern);
        r15 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(this.datePattern);
        goto L19
    }

    private void addUserDefinedAdapters(List<TypeAdapterFactory> r5) {
        if (this.factories.isEmpty() == true) goto L6;
        ArrayList r10 = new ArrayList(this.factories);
        Collections.reverse(r10);
        r5.addAll(r10);
    L6:
        if (this.hierarchyFactories.isEmpty() == true) goto L9;
        ArrayList r11 = new ArrayList(this.hierarchyFactories);
        Collections.reverse(r11);
        r5.addAll(r11);
        return;
    }

    private static int checkDateFormatStyle(int r5) {
        if (r5 < 0) goto L7;
        if (r5 > 3) goto L7;
        return r5;
    L7:
        throw new IllegalArgumentException(j0.g(r5, "Invalid style: "));
    }

    private TypeAdapter<Number> doubleAdapter() {
        if (this.serializeSpecialFloatingPointValues == false) goto L6;
        return TypeAdapters.DOUBLE;
    L6:
        return TypeAdapters.DOUBLE_STRICT;
    }

    private TypeAdapter<Number> floatAdapter() {
        if (this.serializeSpecialFloatingPointValues == false) goto L6;
        return TypeAdapters.FLOAT;
    L6:
        return TypeAdapters.FLOAT_STRICT;
    }

    private static boolean hasNonOverridableAdapter(Type r5) {
        if (r5 != Object.class) goto L5;
        return true;
    L5:
        return false;
    }

    public static <E> List<E> newImmutableList(Collection<E> r5) {
        if (r5.isEmpty() == false) goto L7;
        return Collections.emptyList();
    L7:
        if (r5.size() != 1) goto L15;
        if ((r5 instanceof List) == false) goto L11;
        Object r10 = ((List) r5).get(0);
    L13:
        return Collections.singletonList(r10);
    L11:
        r10 = r5.iterator().next();
        goto L13
    L15:
        return Collections.unmodifiableList(Arrays.asList(r5.toArray()));
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy r5) {
        Objects.requireNonNull(r5);
        this.excluder = this.excluder.withExclusionStrategy(r5, false, true);
        return this;
    }

    public GsonBuilder addReflectionAccessFilter(ReflectionAccessFilter r5) {
        Objects.requireNonNull(r5);
        this.reflectionFilters.addFirst(r5);
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy r5) {
        Objects.requireNonNull(r5);
        this.excluder = this.excluder.withExclusionStrategy(r5, true, false);
        return this;
    }

    public Gson create() {
        return new Gson(this);
    }

    public List<TypeAdapterFactory> createFactories(ConstructorConstructor r10, JsonAdapterAnnotationTypeAdapterFactory r11) {
        ArrayList r5 = new ArrayList();
        r5.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        r5.add(ObjectTypeAdapter.getFactory(this.objectToNumberStrategy));
        r5.add(this.excluder);
        addUserDefinedAdapters(r5);
        addDateTypeAdapters(r5);
        r5.add(TypeAdapters.STRING_FACTORY);
        r5.add(TypeAdapters.INTEGER_FACTORY);
        r5.add(TypeAdapters.BOOLEAN_FACTORY);
        r5.add(TypeAdapters.BYTE_FACTORY);
        r5.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapter<Number> r12 = this.longSerializationPolicy.typeAdapter();
        r5.add(TypeAdapters.newFactory(Long.TYPE, Long.class, r12));
        r5.add(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter()));
        r5.add(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter()));
        r5.add(NumberTypeAdapter.getFactory(this.numberToNumberStrategy));
        r5.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        r5.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        r5.add(TypeAdapters.newFactory(AtomicLong.class, TypeAdapters.atomicLongAdapter(r12)));
        r5.add(TypeAdapters.newFactory(AtomicLongArray.class, TypeAdapters.atomicLongArrayAdapter(r12)));
        r5.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        r5.add(TypeAdapters.CHARACTER_FACTORY);
        r5.add(TypeAdapters.STRING_BUILDER_FACTORY);
        r5.add(TypeAdapters.STRING_BUFFER_FACTORY);
        r5.add(TypeAdapters.BIG_DECIMAL_FACTORY);
        r5.add(TypeAdapters.BIG_INTEGER_FACTORY);
        r5.add(TypeAdapters.LAZILY_PARSED_NUMBER_FACTORY);
        r5.add(TypeAdapters.URL_FACTORY);
        r5.add(TypeAdapters.URI_FACTORY);
        r5.add(TypeAdapters.UUID_FACTORY);
        r5.add(TypeAdapters.CURRENCY_FACTORY);
        r5.add(TypeAdapters.LOCALE_FACTORY);
        r5.add(TypeAdapters.INET_ADDRESS_FACTORY);
        r5.add(TypeAdapters.BIT_SET_FACTORY);
        r5.add(DefaultDateTypeAdapter.DEFAULT_STYLE_FACTORY);
        r5.add(TypeAdapters.CALENDAR_FACTORY);
        TypeAdapterFactory r13 = TypeAdapters.javaTimeTypeAdapterFactory();
        if (r13 == null) goto L5;
        r5.add(r13);
    L5:
        r5.addAll(SqlTypesSupport.SQL_TYPE_FACTORIES);
        r5.add(ArrayTypeAdapter.FACTORY);
        r5.add(TypeAdapters.CLASS_FACTORY);
        r5.add(new CollectionTypeAdapterFactory(r10));
        r5.add(new MapTypeAdapterFactory(r10, this.complexMapKeySerialization));
        r5.add(r11);
        r5.add(TypeAdapters.ENUM_FACTORY);
        r5.add(new ReflectiveTypeAdapterFactory(r10, this.fieldNamingPolicy, this.excluder, r11, newImmutableList(this.reflectionFilters)));
        r5.trimToSize();
        return Collections.unmodifiableList(r5);
    }

    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }

    public GsonBuilder disableJdkUnsafe() {
        this.useJdkUnsafe = false;
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... r5) {
        Objects.requireNonNull(r5);
        this.excluder = this.excluder.withModifiers(r5);
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type r5, Object r10) {
        Objects.requireNonNull(r5);
        Objects.requireNonNull(r10);
        boolean r11 = r10 instanceof JsonSerializer;
        if (r11 == true) goto L14;
        if ((r10 instanceof JsonDeserializer) == true) goto L14;
        if ((r10 instanceof InstanceCreator) == true) goto L14;
        if ((r10 instanceof TypeAdapter) == true) goto L14;
        throw new IllegalArgumentException("Class " + r10.getClass().getName() + " does not implement any supported type adapter class or interface");
    L14:
        if (hasNonOverridableAdapter(r5) == true) goto L27;
        if ((r10 instanceof InstanceCreator) == false) goto L18;
        this.instanceCreators.put(r5, (InstanceCreator) r10);
    L18:
        if (r11 == false) goto L20;
    L21:
        this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(TypeToken.get(r5), r10));
    L23:
        if ((r10 instanceof TypeAdapter) == false) goto L25;
        this.factories.add(TypeAdapters.newFactory(TypeToken.get(r5), (TypeAdapter) r10));
    L25:
        return this;
    L20:
        if ((r10 instanceof JsonDeserializer) == false) goto L23;
    L27:
        throw new IllegalArgumentException(j0.m("Cannot override built-in adapter for ", r5));
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory r5) {
        Objects.requireNonNull(r5);
        this.factories.add(r5);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> r5, Object r10) {
        Objects.requireNonNull(r5);
        Objects.requireNonNull(r10);
        boolean r11 = r10 instanceof JsonSerializer;
        if (r11 == true) goto L12;
        if ((r10 instanceof JsonDeserializer) == true) goto L12;
        if ((r10 instanceof TypeAdapter) == true) goto L12;
        throw new IllegalArgumentException("Class " + r10.getClass().getName() + " does not implement any supported type adapter class or interface");
    L12:
        if ((r10 instanceof JsonDeserializer) == true) goto L14;
        if (r11 == true) goto L14;
    L16:
        if ((r10 instanceof TypeAdapter) == false) goto L18;
        this.factories.add(TypeAdapters.newTypeHierarchyFactory(r5, (TypeAdapter) r10));
    L18:
        return this;
    L14:
        this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(r5, r10));
        goto L16
    }

    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public GsonBuilder setDateFormat(String r5) {
        if (r5 != null) goto L10;
    L8:
        this.datePattern = r5;
        return this;
    L10:
        new SimpleDateFormat(r5);     // Catch: IllegalArgumentException -> L5
    L5:
        e = move-exception;
        throw new IllegalArgumentException(j0.k("The date pattern '", r5, "' is not valid"), e);
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... r10) {
        Objects.requireNonNull(r10);
        int r5 = r10.length;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L5;
        ExclusionStrategy r12 = r10[r11];
        this.excluder = this.excluder.withExclusionStrategy(r12, true, true);
        r11 = r11 + 1;
        goto L3
    L5:
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy r5) {
        return setFieldNamingStrategy(r5);
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy r5) {
        Objects.requireNonNull(r5);
        this.fieldNamingPolicy = r5;
        return this;
    }

    public GsonBuilder setFormattingStyle(FormattingStyle r5) {
        Objects.requireNonNull(r5);
        this.formattingStyle = r5;
        return this;
    }

    @Deprecated
    public GsonBuilder setLenient() {
        return setStrictness(Strictness.LENIENT);
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy r5) {
        Objects.requireNonNull(r5);
        this.longSerializationPolicy = r5;
        return this;
    }

    public GsonBuilder setNumberToNumberStrategy(ToNumberStrategy r5) {
        Objects.requireNonNull(r5);
        this.numberToNumberStrategy = r5;
        return this;
    }

    public GsonBuilder setObjectToNumberStrategy(ToNumberStrategy r5) {
        Objects.requireNonNull(r5);
        this.objectToNumberStrategy = r5;
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        return setFormattingStyle(FormattingStyle.PRETTY);
    }

    public GsonBuilder setStrictness(Strictness r5) {
        Objects.requireNonNull(r5);
        this.strictness = r5;
        return this;
    }

    public GsonBuilder setVersion(double r5) {
        if (Double.isNaN(r5) == true) goto L9;
        if (r5 < 0.0d) goto L9;
        this.excluder = this.excluder.withVersion(r5);
        return this;
    L9:
        throw new IllegalArgumentException("Invalid version: " + r5);
    }

    @Deprecated
    public GsonBuilder setDateFormat(int r5) {
        this.dateStyle = checkDateFormatStyle(r5);
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(int r5, int r10) {
        this.dateStyle = checkDateFormatStyle(r5);
        this.timeStyle = checkDateFormatStyle(r10);
        this.datePattern = null;
        return this;
    }

    public GsonBuilder(Gson r10) {
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = DEFAULT_FIELD_NAMING_STRATEGY;
        HashMap r5 = new HashMap();
        this.instanceCreators = r5;
        ArrayList r11 = new ArrayList();
        this.factories = r11;
        ArrayList r12 = new ArrayList();
        this.hierarchyFactories = r12;
        this.serializeNulls = false;
        this.datePattern = DEFAULT_DATE_PATTERN;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.formattingStyle = DEFAULT_FORMATTING_STYLE;
        this.generateNonExecutableJson = false;
        this.strictness = DEFAULT_STRICTNESS;
        this.useJdkUnsafe = true;
        this.objectToNumberStrategy = DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
        this.numberToNumberStrategy = DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
        ArrayDeque<ReflectionAccessFilter> r13 = new ArrayDeque();
        this.reflectionFilters = r13;
        this.excluder = r10.excluder;
        this.fieldNamingPolicy = r10.fieldNamingStrategy;
        r5.putAll(r10.instanceCreators);
        this.serializeNulls = r10.serializeNulls;
        this.complexMapKeySerialization = r10.complexMapKeySerialization;
        this.generateNonExecutableJson = r10.generateNonExecutableJson;
        this.escapeHtmlChars = r10.htmlSafe;
        this.formattingStyle = r10.formattingStyle;
        this.strictness = r10.strictness;
        this.serializeSpecialFloatingPointValues = r10.serializeSpecialFloatingPointValues;
        this.longSerializationPolicy = r10.longSerializationPolicy;
        this.datePattern = r10.datePattern;
        this.dateStyle = r10.dateStyle;
        this.timeStyle = r10.timeStyle;
        r11.addAll(r10.builderFactories);
        r12.addAll(r10.builderHierarchyFactories);
        this.useJdkUnsafe = r10.useJdkUnsafe;
        this.objectToNumberStrategy = r10.objectToNumberStrategy;
        this.numberToNumberStrategy = r10.numberToNumberStrategy;
        r13.addAll(r10.reflectionFilters);
    }
}
