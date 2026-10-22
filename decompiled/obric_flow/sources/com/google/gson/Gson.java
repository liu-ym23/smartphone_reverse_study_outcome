package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class Gson {
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    final List<TypeAdapterFactory> builderFactories;
    final List<TypeAdapterFactory> builderHierarchyFactories;
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;
    final String datePattern;
    final int dateStyle;
    final Excluder excluder;
    final List<TypeAdapterFactory> factories;
    final FieldNamingStrategy fieldNamingStrategy;
    final FormattingStyle formattingStyle;
    final boolean generateNonExecutableJson;
    final boolean htmlSafe;
    final Map<Type, InstanceCreator<?>> instanceCreators;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    final LongSerializationPolicy longSerializationPolicy;
    final ToNumberStrategy numberToNumberStrategy;
    final ToNumberStrategy objectToNumberStrategy;
    final List<ReflectionAccessFilter> reflectionFilters;
    final boolean serializeNulls;
    final boolean serializeSpecialFloatingPointValues;
    final Strictness strictness;
    private final ThreadLocal<Map<TypeToken<?>, TypeAdapter<?>>> threadLocalAdapterResults;
    final int timeStyle;
    private final ConcurrentMap<TypeToken<?>, TypeAdapter<?>> typeTokenCache;
    final boolean useJdkUnsafe;

    public static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
        private TypeAdapter<T> delegate;

        public FutureTypeAdapter() {
            this.delegate = null;
        }

        private TypeAdapter<T> delegate() {
            TypeAdapter<T> r5 = this.delegate;
            if (r5 == null) goto L6;
            return r5;
        L6:
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
        public TypeAdapter<T> getSerializationDelegate() {
            return delegate();
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r5) throws IOException {
            return delegate().read(r5);
        }

        public void setDelegate(TypeAdapter<T> r5) {
            if (this.delegate != null) goto L7;
            this.delegate = r5;
            return;
        L7:
            throw new AssertionError("Delegate is already set");
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r5, T r10) throws IOException {
            delegate().write(r5, r10);
        }
    }

    public Gson() {
        this(GsonBuilder.DEFAULT);
    }

    private static void assertFullConsumption(Object r5, JsonReader r10) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            if (r0 == 0) goto L23
            com.google.gson.stream.JsonToken r0 = r1.peek()     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L15
            com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L15
            if (r0 != r1) goto Lb
            goto L23
        Lb:
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L15
            java.lang.String r1 = "JSON document was not fully consumed."
            r0.<init>(r1)     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L15
            throw r0     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L15
        L13:
            r0 = move-exception
            goto L17
        L15:
            r0 = move-exception
            goto L1d
        L17:
            com.google.gson.JsonIOException r1 = new com.google.gson.JsonIOException
            r1.<init>(r0)
            throw r1
        L1d:
            com.google.gson.JsonSyntaxException r1 = new com.google.gson.JsonSyntaxException
            r1.<init>(r0)
            throw r1
        L23:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.assertFullConsumption(java.lang.Object, com.google.gson.stream.JsonReader):void");
    }

    @Deprecated
    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public <T> T fromJson(String r5, Class<T> r10) throws JsonSyntaxException {
        return (T) fromJson(r5, TypeToken.get(r10));
    }

    public <T> TypeAdapter<T> getAdapter(TypeToken<T> r10) {
        Objects.requireNonNull(r10, "type must not be null");
        TypeAdapter<T> r5 = (TypeAdapter) this.typeTokenCache.get(r10);
        if (r5 == null) goto L5;
        return r5;
    L5:
        Map<? extends TypeToken<?>, ? extends TypeAdapter<?>> r11 = this.threadLocalAdapterResults.get();
        if (r11 != null) goto L8;
        r11 = new HashMap();
        this.threadLocalAdapterResults.set((Map<TypeToken<?>, TypeAdapter<?>>) r11);
        boolean r12 = true;
    L32:
        FutureTypeAdapter r13 = new FutureTypeAdapter();     // Catch: Throwable -> L19
        r11.put(r10, r13);     // Catch: Throwable -> L19
        Iterator<TypeAdapterFactory> r14 = this.factories.iterator();     // Catch: Throwable -> L19
        TypeAdapter<T> r15 = null;
    L14:
        if (r14.hasNext() == false) goto L21;
        r15 = r14.next().create(this, r10);     // Catch: Throwable -> L19
        if (r15 == null) goto L14;
        r13.setDelegate(r15);     // Catch: Throwable -> L19
        r11.put(r10, r15);     // Catch: Throwable -> L19
    L21:
        if (r12 == false) goto L23;
        this.threadLocalAdapterResults.remove();
    L23:
        if (r15 == null) goto L28;
        if (r12 == false) goto L26;
        this.typeTokenCache.putAll(r11);
    L26:
        return r15;
    L28:
        throw new IllegalArgumentException("GSON (2.14.0) cannot handle " + r10);
    L19:
        th = move-exception;
        if (r12 == false) goto L31;
        this.threadLocalAdapterResults.remove();
    L31:
        throw th;
    L8:
        TypeAdapter<T> r16 = (TypeAdapter) r11.get(r10);
        if (r16 == null) goto L11;
        return r16;
    L11:
        r12 = false;
        goto L32
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory r5, TypeToken<T> r10) {
        Objects.requireNonNull(r5, "skipPast must not be null");
        Objects.requireNonNull(r10, "type must not be null");
        if (this.jsonAdapterFactory.isClassJsonAdapterFactory(r10, r5) == false) goto L5;
        r5 = this.jsonAdapterFactory;
    L5:
        Iterator<TypeAdapterFactory> r11 = this.factories.iterator();
        boolean r12 = false;
    L7:
        if (r11.hasNext() == false) goto L15;
        TypeAdapterFactory r13 = r11.next();
        if (r12 == false) goto L10;
        TypeAdapter<T> r14 = r13.create(this, r10);
        if (r14 == null) goto L7;
        return r14;
    L10:
        if (r13 != r5) goto L7;
        r12 = true;
        goto L7
    L15:
        if (r12 == true) goto L19;
        return getAdapter(r10);
    L19:
        throw new IllegalArgumentException("GSON cannot serialize or deserialize " + r10);
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }

    public JsonReader newJsonReader(Reader r5) {
        JsonReader r10 = new JsonReader(r5);
        Strictness r11 = this.strictness;
        if (r11 != null) goto L5;
        r11 = Strictness.LEGACY_STRICT;
    L5:
        r10.setStrictness(r11);
        return r10;
    }

    public JsonWriter newJsonWriter(Writer r5) throws IOException {
        if (this.generateNonExecutableJson == false) goto L5;
        r5.write(JSON_NON_EXECUTABLE_PREFIX);
    L5:
        JsonWriter r10 = new JsonWriter(r5);
        r10.setFormattingStyle(this.formattingStyle);
        r10.setHtmlSafe(this.htmlSafe);
        Strictness r11 = this.strictness;
        if (r11 != null) goto L8;
        r11 = Strictness.LEGACY_STRICT;
    L8:
        r10.setStrictness(r11);
        r10.setSerializeNulls(this.serializeNulls);
        return r10;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public String toJson(Object r5) {
        if (r5 != null) goto L6;
        return toJson(JsonNull.INSTANCE);
    L6:
        return toJson(r5, r5.getClass());
    }

    public JsonElement toJsonTree(Object r5) {
        if (r5 != null) goto L6;
        return JsonNull.INSTANCE;
    L6:
        return toJsonTree(r5, r5.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    public Gson(GsonBuilder r5) {
        this.threadLocalAdapterResults = new ThreadLocal();
        this.typeTokenCache = new ConcurrentHashMap();
        this.excluder = r5.excluder;
        this.fieldNamingStrategy = r5.fieldNamingPolicy;
        HashMap r10 = new HashMap(r5.instanceCreators);
        this.instanceCreators = r10;
        this.serializeNulls = r5.serializeNulls;
        this.complexMapKeySerialization = r5.complexMapKeySerialization;
        this.generateNonExecutableJson = r5.generateNonExecutableJson;
        this.htmlSafe = r5.escapeHtmlChars;
        this.formattingStyle = r5.formattingStyle;
        this.strictness = r5.strictness;
        this.serializeSpecialFloatingPointValues = r5.serializeSpecialFloatingPointValues;
        boolean r11 = r5.useJdkUnsafe;
        this.useJdkUnsafe = r11;
        this.longSerializationPolicy = r5.longSerializationPolicy;
        this.datePattern = r5.datePattern;
        this.dateStyle = r5.dateStyle;
        this.timeStyle = r5.timeStyle;
        this.builderFactories = GsonBuilder.newImmutableList(r5.factories);
        this.builderHierarchyFactories = GsonBuilder.newImmutableList(r5.hierarchyFactories);
        this.objectToNumberStrategy = r5.objectToNumberStrategy;
        this.numberToNumberStrategy = r5.numberToNumberStrategy;
        List<ReflectionAccessFilter> r12 = GsonBuilder.newImmutableList(r5.reflectionFilters);
        this.reflectionFilters = r12;
        if (r5 != GsonBuilder.DEFAULT) goto L5;
        this.constructorConstructor = GsonBuilder.DEFAULT_CONSTRUCTOR_CONSTRUCTOR;
        this.jsonAdapterFactory = GsonBuilder.DEFAULT_JSON_ADAPTER_ANNOTATION_TYPE_ADAPTER_FACTORY;
        this.factories = GsonBuilder.DEFAULT_TYPE_ADAPTER_FACTORIES;
        return;
    L5:
        ConstructorConstructor r13 = new ConstructorConstructor(r10, r11, r12);
        this.constructorConstructor = r13;
        JsonAdapterAnnotationTypeAdapterFactory r14 = new JsonAdapterAnnotationTypeAdapterFactory(r13);
        this.jsonAdapterFactory = r14;
        this.factories = r5.createFactories(r13, r14);
    }

    public <T> T fromJson(String r5, Type r10) throws JsonSyntaxException {
        return (T) fromJson(r5, TypeToken.get(r10));
    }

    public <T> T fromJson(String r5, TypeToken<T> r10) throws JsonSyntaxException {
        if (r5 != null) goto L6;
        return null;
    L6:
        return (T) fromJson(new StringReader(r5), r10);
    }

    public String toJson(Object r5, Type r10) {
        StringBuilder r11 = new StringBuilder();
        toJson(r5, r10, r11);
        return r11.toString();
    }

    public JsonElement toJsonTree(Object r5, Type r10) {
        JsonTreeWriter r11 = new JsonTreeWriter();
        toJson(r5, r10, r11);
        return r11.get();
    }

    public <T> T fromJson(Reader r5, Class<T> r10) throws JsonSyntaxException, JsonIOException {
        return (T) fromJson(r5, TypeToken.get(r10));
    }

    public <T> T fromJson(Reader r5, Type r10) throws JsonIOException, JsonSyntaxException {
        return (T) fromJson(r5, TypeToken.get(r10));
    }

    public void toJson(Object r5, Appendable r10) throws JsonIOException {
        if (r5 == null) goto L4;
        toJson(r5, r5.getClass(), r10);
        return;
    L4:
        toJson(JsonNull.INSTANCE, r10);
    }

    public <T> T fromJson(Reader r5, TypeToken<T> r10) throws JsonIOException, JsonSyntaxException {
        JsonReader r11 = newJsonReader(r5);
        T r12 = (T) fromJson(r11, r10);
        assertFullConsumption(r12, r11);
        return r12;
    }

    public void toJson(Object r5, Type r10, Appendable r11) throws JsonIOException {
        toJson(r5, r10, newJsonWriter(Streams.writerForAppendable(r11)));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public <T> T fromJson(JsonReader r5, Type r10) throws JsonIOException, JsonSyntaxException {
        return (T) fromJson(r5, TypeToken.get(r10));
    }

    public <T> T fromJson(JsonReader r10, TypeToken<T> r11) throws JsonIOException, JsonSyntaxException {
        Strictness r5 = r10.getStrictness();
        Strictness r12 = this.strictness;
        if (r12 == null) goto L6;
        r10.setStrictness(r12);
    L46:
        r10.peek();     // Catch: Throwable -> L17 AssertionError -> L19 IOException -> L21 IllegalStateException -> L23 EOFException -> L35
        boolean r13 = false;
        TypeAdapter<T> r14 = getAdapter(r11);     // Catch: Throwable -> L17 AssertionError -> L19 IOException -> L21 IllegalStateException -> L23 EOFException -> L25
        T r15 = r14.read(r10);     // Catch: Throwable -> L17 AssertionError -> L19 IOException -> L21 IllegalStateException -> L23 EOFException -> L25
        Class r16 = Primitives.wrap(r11.getRawType());     // Catch: Throwable -> L17 AssertionError -> L19 IOException -> L21 IllegalStateException -> L23 EOFException -> L25
        if (r15 != null) goto L13;
    L27:
        r10.setStrictness(r5);
        return r15;
    L13:
        if (r16.isInstance(r15) == true) goto L27;
        throw new ClassCastException("Type adapter '" + r14 + "' returned wrong type; requested " + r11.getRawType() + " but got instance of " + r15.getClass() + "\nVerify that the adapter was registered for the correct type.");     // Catch: Throwable -> L17 AssertionError -> L19 IOException -> L21 IllegalStateException -> L23 EOFException -> L25
    L25:
        e = e;
    L37:
        if (r13 == false) goto L41;
        r10.setStrictness(r5);
        return null;
    L41:
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r10.setStrictness(r5);
        throw th;
    L35:
        e = e;
        r13 = true;
    L21:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L17
    L19:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.14.0): " + e.getMessage(), e);     // Catch: Throwable -> L17
    L23:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L17
    L6:
        if (r10.getStrictness() != Strictness.LEGACY_STRICT) goto L46;
        r10.setStrictness(Strictness.LENIENT);
        goto L46
    }

    public void toJson(Object r10, Type r11, JsonWriter r12) throws JsonIOException {
        TypeAdapter r13 = getAdapter(TypeToken.get(r11));
        Strictness r5 = r12.getStrictness();
        Strictness r14 = this.strictness;
        if (r14 == null) goto L6;
        r12.setStrictness(r14);
    L8:
        boolean r15 = r12.isHtmlSafe();
        boolean r16 = r12.getSerializeNulls();
        r12.setHtmlSafe(this.htmlSafe);
        r12.setSerializeNulls(this.serializeNulls);
        r13.write(r12, r10);     // Catch: Throwable -> L12 AssertionError -> L14 IOException -> L17
        r12.setStrictness(r5);
        r12.setHtmlSafe(r15);
        r12.setSerializeNulls(r16);
        return;
    L12:
        th = move-exception;
        r12.setStrictness(r5);
        r12.setHtmlSafe(r15);
        r12.setSerializeNulls(r16);
        throw th;
    L17:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L12
    L14:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.14.0): " + e.getMessage(), e);     // Catch: Throwable -> L12
    L6:
        if (r12.getStrictness() != Strictness.LEGACY_STRICT) goto L8;
        r12.setStrictness(Strictness.LENIENT);
        goto L8
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> r5) {
        return getAdapter(TypeToken.get(r5));
    }

    public String toJson(JsonElement r5) {
        StringBuilder r10 = new StringBuilder();
        toJson(r5, r10);
        return r10.toString();
    }

    public <T> T fromJson(JsonElement r5, Class<T> r10) throws JsonSyntaxException {
        return (T) fromJson(r5, TypeToken.get(r10));
    }

    public <T> T fromJson(JsonElement r5, Type r10) throws JsonSyntaxException {
        return (T) fromJson(r5, TypeToken.get(r10));
    }

    public void toJson(JsonElement r5, Appendable r10) throws JsonIOException {
        toJson(r5, newJsonWriter(Streams.writerForAppendable(r10)));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public <T> T fromJson(JsonElement r5, TypeToken<T> r10) throws JsonSyntaxException {
        if (r5 != null) goto L6;
        return null;
    L6:
        return (T) fromJson(new JsonTreeReader(r5), r10);
    }

    public void toJson(JsonElement r10, JsonWriter r11) throws JsonIOException {
        Strictness r5 = r11.getStrictness();
        boolean r12 = r11.isHtmlSafe();
        boolean r13 = r11.getSerializeNulls();
        r11.setHtmlSafe(this.htmlSafe);
        r11.setSerializeNulls(this.serializeNulls);
        Strictness r14 = this.strictness;
        if (r14 == null) goto L6;
        r11.setStrictness(r14);
    L21:
        Streams.write(r10, r11);     // Catch: Throwable -> L11 AssertionError -> L13 IOException -> L16
        r11.setStrictness(r5);
        r11.setHtmlSafe(r12);
        r11.setSerializeNulls(r13);
        return;
    L11:
        th = move-exception;
        r11.setStrictness(r5);
        r11.setHtmlSafe(r12);
        r11.setSerializeNulls(r13);
        throw th;
    L16:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L11
    L13:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.14.0): " + e.getMessage(), e);     // Catch: Throwable -> L11
    L6:
        if (r11.getStrictness() != Strictness.LEGACY_STRICT) goto L21;
        r11.setStrictness(Strictness.LENIENT);
        goto L21
    }
}
