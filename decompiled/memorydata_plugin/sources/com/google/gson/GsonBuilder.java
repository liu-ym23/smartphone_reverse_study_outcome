package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class GsonBuilder {
    private boolean complexMapKeySerialization;
    private String datePattern;
    private int dateStyle;
    private boolean escapeHtmlChars;
    private Excluder excluder;
    private final List<TypeAdapterFactory> factories;
    private FieldNamingStrategy fieldNamingPolicy;
    private boolean generateNonExecutableJson;
    private final List<TypeAdapterFactory> hierarchyFactories;
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private boolean lenient;
    private LongSerializationPolicy longSerializationPolicy;
    private ToNumberStrategy numberToNumberStrategy;
    private ToNumberStrategy objectToNumberStrategy;
    private boolean prettyPrinting;
    private final LinkedList<ReflectionAccessFilter> reflectionFilters;
    private boolean serializeNulls;
    private boolean serializeSpecialFloatingPointValues;
    private int timeStyle;
    private boolean useJdkUnsafe;

    public GsonBuilder() {
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        this.instanceCreators = new HashMap();
        this.factories = new ArrayList();
        this.hierarchyFactories = new ArrayList();
        this.serializeNulls = false;
        this.datePattern = Gson.DEFAULT_DATE_PATTERN;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        this.useJdkUnsafe = true;
        this.objectToNumberStrategy = Gson.DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
        this.numberToNumberStrategy = Gson.DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
        this.reflectionFilters = new LinkedList();
    }

    GsonBuilder(Gson r6) {
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        HashMap r0 = new HashMap();
        this.instanceCreators = r0;
        ArrayList r1 = new ArrayList();
        this.factories = r1;
        ArrayList r2 = new ArrayList();
        this.hierarchyFactories = r2;
        this.serializeNulls = false;
        this.datePattern = Gson.DEFAULT_DATE_PATTERN;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        this.useJdkUnsafe = true;
        this.objectToNumberStrategy = Gson.DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
        this.numberToNumberStrategy = Gson.DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
        LinkedList<ReflectionAccessFilter> r3 = new LinkedList();
        this.reflectionFilters = r3;
        this.excluder = r6.excluder;
        this.fieldNamingPolicy = r6.fieldNamingStrategy;
        r0.putAll(r6.instanceCreators);
        this.serializeNulls = r6.serializeNulls;
        this.complexMapKeySerialization = r6.complexMapKeySerialization;
        this.generateNonExecutableJson = r6.generateNonExecutableJson;
        this.escapeHtmlChars = r6.htmlSafe;
        this.prettyPrinting = r6.prettyPrinting;
        this.lenient = r6.lenient;
        this.serializeSpecialFloatingPointValues = r6.serializeSpecialFloatingPointValues;
        this.longSerializationPolicy = r6.longSerializationPolicy;
        this.datePattern = r6.datePattern;
        this.dateStyle = r6.dateStyle;
        this.timeStyle = r6.timeStyle;
        r1.addAll(r6.builderFactories);
        r2.addAll(r6.builderHierarchyFactories);
        this.useJdkUnsafe = r6.useJdkUnsafe;
        this.objectToNumberStrategy = r6.objectToNumberStrategy;
        this.numberToNumberStrategy = r6.numberToNumberStrategy;
        r3.addAll(r6.reflectionFilters);
    }

    private void addTypeAdaptersForDate(String r4, int r5, int r6, List<TypeAdapterFactory> r7) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        boolean r8 = SqlTypesSupport.SUPPORTS_SQL_TYPES;
        TypeAdapterFactory r0 = null;
        if (r4 == null) goto L11;
        if (r4.trim().isEmpty() == true) goto L11;
        TypeAdapterFactory r9 = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(r4);
        if (r8 == false) goto L9;
        r0 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(r4);
        TypeAdapterFactory r10 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(r4);
    L17:
        r3.add(r9);
        if (r8 == false) goto L23;
        r3.add(r0);
        r3.add(r10);
        return;
    L23:
        return;
    L9:
        r10 = null;
    L11:
        if (r5 == 2) goto L21;
        if (r6 == 2) goto L22;
        TypeAdapterFactory r11 = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(r5, r6);
        if (r8 == false) goto L16;
        r0 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(r5, r6);
        TypeAdapterFactory r12 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(r5, r6);
        r9 = r11;
        r10 = r12;
        goto L17
    L16:
        r9 = r11;
        goto L9
    L22:
        return;
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy r4) {
        ExclusionStrategy r5 = (ExclusionStrategy) ZeusTransformUtils.wrapperContextForParams(r4, ExclusionStrategy.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r5);
        this.excluder = this.excluder.withExclusionStrategy(r5, false, true);
        return this;
    }

    public GsonBuilder addReflectionAccessFilter(ReflectionAccessFilter r3) {
        ReflectionAccessFilter r4 = (ReflectionAccessFilter) ZeusTransformUtils.wrapperContextForParams(r3, ReflectionAccessFilter.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4);
        this.reflectionFilters.addFirst(r4);
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy r4) {
        ExclusionStrategy r5 = (ExclusionStrategy) ZeusTransformUtils.wrapperContextForParams(r4, ExclusionStrategy.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r5);
        this.excluder = this.excluder.withExclusionStrategy(r5, true, false);
        return this;
    }

    public Gson create() {
        List<TypeAdapterFactory> r1 = new ArrayList((this.factories.size() + this.hierarchyFactories.size()) + 3);
        r1.addAll(this.factories);
        Collections.reverse(r1);
        ArrayList r2 = new ArrayList(this.hierarchyFactories);
        Collections.reverse(r2);
        r1.addAll(r2);
        addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, r1);
        return new Gson(this.excluder, this.fieldNamingPolicy, new HashMap(this.instanceCreators), this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.useJdkUnsafe, this.longSerializationPolicy, this.datePattern, this.dateStyle, this.timeStyle, new ArrayList(this.factories), new ArrayList(this.hierarchyFactories), r1, this.objectToNumberStrategy, this.numberToNumberStrategy, new ArrayList(this.reflectionFilters));
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

    public GsonBuilder excludeFieldsWithModifiers(int... r2) {
        Objects.requireNonNull(r2);
        this.excluder = this.excluder.withModifiers(r2);
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

    public GsonBuilder registerTypeAdapter(Type r4, Object r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6);
        if (ZeusTransformUtils.instanceOf(r5, JsonSerializer.class) == false) goto L5;
    L12:
        boolean r0 = true;
    L13:
        C$Gson$Preconditions.checkArgument(r0);
        if (ZeusTransformUtils.instanceOf(r5, InstanceCreator.class) == false) goto L17;
        this.instanceCreators.put(r6, (InstanceCreator) ZeusTransformUtils.preCheckCast(r5, InstanceCreator.class, "com.obric.memorydata.plugin"));
    L17:
        if (ZeusTransformUtils.instanceOf(r5, JsonSerializer.class) == false) goto L19;
    L20:
        TypeToken<?> r1 = TypeToken.get(r6);
        this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(r1, r5));
    L22:
        if (ZeusTransformUtils.instanceOf(r5, TypeAdapter.class) == false) goto L24;
        TypeAdapterFactory r7 = TypeAdapters.newFactory(TypeToken.get(r6), (TypeAdapter) ZeusTransformUtils.preCheckCast(r5, TypeAdapter.class, "com.obric.memorydata.plugin"));
        this.factories.add(r7);
    L24:
        return this;
    L19:
        if (ZeusTransformUtils.instanceOf(r5, JsonDeserializer.class) == false) goto L22;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, JsonDeserializer.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r5, InstanceCreator.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r5, TypeAdapter.class) == true) goto L12;
        r0 = false;
        goto L13
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory r3) {
        TypeAdapterFactory r4 = (TypeAdapterFactory) ZeusTransformUtils.wrapperContextForParams(r3, TypeAdapterFactory.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4);
        this.factories.add(r4);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> r3, Object r4) {
        Objects.requireNonNull(r3);
        if (ZeusTransformUtils.instanceOf(r4, JsonSerializer.class) == false) goto L5;
    L10:
        boolean r0 = true;
    L11:
        C$Gson$Preconditions.checkArgument(r0);
        if (ZeusTransformUtils.instanceOf(r4, JsonDeserializer.class) == false) goto L14;
    L15:
        this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(r3, r4));
    L17:
        if (ZeusTransformUtils.instanceOf(r4, TypeAdapter.class) == false) goto L19;
        TypeAdapterFactory r5 = TypeAdapters.newTypeHierarchyFactory(r3, (TypeAdapter) ZeusTransformUtils.preCheckCast(r4, TypeAdapter.class, "com.obric.memorydata.plugin"));
        this.factories.add(r5);
    L19:
        return this;
    L14:
        if (ZeusTransformUtils.instanceOf(r4, JsonSerializer.class) == false) goto L17;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, JsonDeserializer.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r4, TypeAdapter.class) == true) goto L10;
        r0 = false;
        goto L11
    }

    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public GsonBuilder setDateFormat(int r1) {
        this.dateStyle = r1;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(int r1, int r2) {
        this.dateStyle = r1;
        this.timeStyle = r2;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(String r1) {
        this.datePattern = r1;
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... r6) {
        Objects.requireNonNull(r6);
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ExclusionStrategy r2 = r6[r1];
        this.excluder = this.excluder.withExclusionStrategy(r2, true, true);
        r1 = r1 + 1;
        goto L3
    L5:
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy r1) {
        return setFieldNamingStrategy(r1);
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy r3) {
        this.fieldNamingPolicy = (FieldNamingStrategy) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((FieldNamingStrategy) ZeusTransformUtils.wrapperContextForParams(r3, FieldNamingStrategy.class, "com.obric.memorydata.plugin")), FieldNamingStrategy.class, "com.obric.memorydata.plugin");
        return this;
    }

    public GsonBuilder setLenient() {
        this.lenient = true;
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy r3) {
        this.longSerializationPolicy = (LongSerializationPolicy) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r3), LongSerializationPolicy.class, "com.obric.memorydata.plugin");
        return this;
    }

    public GsonBuilder setNumberToNumberStrategy(ToNumberStrategy r3) {
        this.numberToNumberStrategy = (ToNumberStrategy) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((ToNumberStrategy) ZeusTransformUtils.wrapperContextForParams(r3, ToNumberStrategy.class, "com.obric.memorydata.plugin")), ToNumberStrategy.class, "com.obric.memorydata.plugin");
        return this;
    }

    public GsonBuilder setObjectToNumberStrategy(ToNumberStrategy r3) {
        this.objectToNumberStrategy = (ToNumberStrategy) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((ToNumberStrategy) ZeusTransformUtils.wrapperContextForParams(r3, ToNumberStrategy.class, "com.obric.memorydata.plugin")), ToNumberStrategy.class, "com.obric.memorydata.plugin");
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public GsonBuilder setVersion(double r3) {
        if (Double.isNaN(r3) == true) goto L9;
        if (r3 < 0.0d) goto L9;
        this.excluder = this.excluder.withVersion(r3);
        return this;
    L9:
        throw new IllegalArgumentException("Invalid version: " + r3);
    }
}
