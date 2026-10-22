package com.google.gson.internal.bind;

import androidx.constraintlayout.motion.widget.a;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes2.dex */
public final class TypeAdapters {
    public static final TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN = null;
    public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY = null;
    public static final TypeAdapter<AtomicInteger> ATOMIC_INTEGER = null;
    public static final TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY = null;
    public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY = null;
    public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY = null;
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL = null;
    public static final TypeAdapterFactory BIG_DECIMAL_FACTORY = null;
    public static final TypeAdapter<BigInteger> BIG_INTEGER = null;
    public static final TypeAdapterFactory BIG_INTEGER_FACTORY = null;
    public static final TypeAdapter<BitSet> BIT_SET = null;
    public static final TypeAdapterFactory BIT_SET_FACTORY = null;
    public static final TypeAdapter<Boolean> BOOLEAN = null;
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING = null;
    public static final TypeAdapterFactory BOOLEAN_FACTORY = null;
    public static final TypeAdapter<Number> BYTE = null;
    public static final TypeAdapterFactory BYTE_FACTORY = null;
    public static final TypeAdapter<Calendar> CALENDAR = null;
    public static final TypeAdapterFactory CALENDAR_FACTORY = null;
    public static final TypeAdapter<Character> CHARACTER = null;
    public static final TypeAdapterFactory CHARACTER_FACTORY = null;
    public static final TypeAdapter<Class> CLASS = null;
    public static final TypeAdapterFactory CLASS_FACTORY = null;
    public static final TypeAdapter<Currency> CURRENCY = null;
    public static final TypeAdapterFactory CURRENCY_FACTORY = null;
    public static final TypeAdapter<Number> DOUBLE = null;
    public static final TypeAdapter<Number> DOUBLE_STRICT = null;
    public static final TypeAdapterFactory ENUM_FACTORY = null;
    public static final TypeAdapter<Number> FLOAT = null;
    public static final TypeAdapter<Number> FLOAT_STRICT = null;
    public static final TypeAdapter<InetAddress> INET_ADDRESS = null;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY = null;
    public static final TypeAdapter<Number> INTEGER = null;
    public static final TypeAdapterFactory INTEGER_FACTORY = null;
    public static final TypeAdapter<JsonElement> JSON_ELEMENT = null;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY = null;
    public static final TypeAdapter<LazilyParsedNumber> LAZILY_PARSED_NUMBER = null;
    public static final TypeAdapterFactory LAZILY_PARSED_NUMBER_FACTORY = null;
    public static final TypeAdapter<Locale> LOCALE = null;
    public static final TypeAdapterFactory LOCALE_FACTORY = null;
    public static final TypeAdapter<Number> LONG = null;
    public static final TypeAdapter<Number> LONG_AS_STRING = null;
    public static final TypeAdapter<Number> SHORT = null;
    public static final TypeAdapterFactory SHORT_FACTORY = null;
    public static final TypeAdapter<String> STRING = null;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER = null;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY = null;
    public static final TypeAdapter<StringBuilder> STRING_BUILDER = null;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY = null;
    public static final TypeAdapterFactory STRING_FACTORY = null;
    public static final TypeAdapter<URI> URI = null;
    public static final TypeAdapterFactory URI_FACTORY = null;
    public static final TypeAdapter<URL> URL = null;
    public static final TypeAdapterFactory URL_FACTORY = null;
    public static final TypeAdapter<UUID> UUID = null;
    public static final TypeAdapterFactory UUID_FACTORY = null;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$34, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass34 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r5 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r5;
            r5[JsonToken.NUMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class DoubleAdapter extends TypeAdapter<Number> {
        private final boolean strict;

        public DoubleAdapter(boolean r5) {
            this.strict = r5;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public /* bridge */ /* synthetic */ Number read2(JsonReader r5) throws IOException {
            return read(r5);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter r5, Number r10) throws IOException {
            write2(r5, r10);
        }

        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader r5) throws IOException {
            if (r5.peek() != JsonToken.NULL) goto L7;
            r5.nextNull();
            return null;
        L7:
            return Double.valueOf(r5.nextDouble());
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(JsonWriter r5, Number r10) throws IOException {
            if (r10 != null) goto L5;
            r5.nullValue();
            return;
        L5:
            double r11 = r10.doubleValue();
            if (this.strict == false) goto L8;
            TypeAdapters.access$000(r11);
        L8:
            r5.value(r11);
        }
    }

    public interface FactorySupplier {
        TypeAdapterFactory get();
    }

    public static class FloatAdapter extends TypeAdapter<Number> {
        private final boolean strict;

        public FloatAdapter(boolean r5) {
            this.strict = r5;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public /* bridge */ /* synthetic */ Number read2(JsonReader r5) throws IOException {
            return read(r5);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter r5, Number r10) throws IOException {
            write2(r5, r10);
        }

        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader r5) throws IOException {
            if (r5.peek() != JsonToken.NULL) goto L7;
            r5.nextNull();
            return null;
        L7:
            return Float.valueOf((float) r5.nextDouble());
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(JsonWriter r5, Number r10) throws IOException {
            if (r10 != null) goto L5;
            r5.nullValue();
            return;
        L5:
            float r11 = r10.floatValue();
            if (this.strict == false) goto L9;
            TypeAdapters.access$000(r11);
        L9:
            if ((r10 instanceof Float) == true) goto L12;
            r10 = Float.valueOf(r11);
        L12:
            r5.value(r10);
        }
    }

    public static abstract class IntegerFieldsTypeAdapter<T> extends TypeAdapter<T> {
        private final List<String> fields;

        public IntegerFieldsTypeAdapter(String... r5) {
            this.fields = Arrays.asList(r5);
        }

        public abstract T create(long[] r5);

        public abstract long[] integerValues(T r5);

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r5) throws IOException {
            if (r5.peek() != JsonToken.NULL) goto L6;
            r5.nextNull();
            return null;
        L6:
            r5.beginObject();
            long[] r10 = new long[this.fields.size()];
        L8:
            if (r5.peek() == JsonToken.END_OBJECT) goto L13;
            String r11 = r5.nextName();
            int r12 = this.fields.indexOf(r11);
            if (r12 >= 0) goto L11;
            r5.skipValue();
            goto L8
        L11:
            r10[r12] = r5.nextLong();
            goto L8
        L13:
            r5.endObject();
            return create(r10);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r5, T r10) throws IOException {
            if (r10 != null) goto L5;
            r5.nullValue();
            return;
        L5:
            r5.beginObject();
            long[] r11 = integerValues(r10);
            int r12 = 0;
        L7:
            if (r12 >= this.fields.size()) goto L9;
            r5.name(this.fields.get(r12));
            r5.value(r11[r12]);
            r12 = r12 + 1;
            goto L7
        L9:
            r5.endObject();
        }
    }

    static {
        TypeAdapter<Class> r5 = new AnonymousClass1().nullSafe();
        CLASS = r5;
        CLASS_FACTORY = newFactory(Class.class, r5);
        TypeAdapter<BitSet> r10 = new AnonymousClass2().nullSafe();
        BIT_SET = r10;
        BIT_SET_FACTORY = newFactory(BitSet.class, r10);
        TypeAdapter<Boolean> r11 = new AnonymousClass3();
        BOOLEAN = r11;
        BOOLEAN_AS_STRING = new AnonymousClass4();
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, r11);
        TypeAdapter<Number> r12 = new AnonymousClass5();
        BYTE = r12;
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, r12);
        TypeAdapter<Number> r13 = new AnonymousClass6();
        SHORT = r13;
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, r13);
        TypeAdapter<Number> r14 = new AnonymousClass7();
        INTEGER = r14;
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, r14);
        TypeAdapter<AtomicInteger> r15 = new AnonymousClass8().nullSafe();
        ATOMIC_INTEGER = r15;
        ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, r15);
        TypeAdapter<AtomicBoolean> r16 = new AnonymousClass10().nullSafe();
        ATOMIC_BOOLEAN = r16;
        ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, r16);
        TypeAdapter<AtomicIntegerArray> r17 = new AnonymousClass11().nullSafe();
        ATOMIC_INTEGER_ARRAY = r17;
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, r17);
        LONG = new AnonymousClass13();
        LONG_AS_STRING = new AnonymousClass14();
        FLOAT = new FloatAdapter(false);
        FLOAT_STRICT = new FloatAdapter(true);
        DOUBLE = new DoubleAdapter(false);
        DOUBLE_STRICT = new DoubleAdapter(true);
        TypeAdapter<Character> r18 = new AnonymousClass15();
        CHARACTER = r18;
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, r18);
        TypeAdapter<String> r19 = new AnonymousClass16();
        STRING = r19;
        TypeAdapter<BigDecimal> r20 = new AnonymousClass17();
        BIG_DECIMAL = r20;
        BIG_DECIMAL_FACTORY = newFactory(BigDecimal.class, r20);
        TypeAdapter<BigInteger> r21 = new AnonymousClass18();
        BIG_INTEGER = r21;
        BIG_INTEGER_FACTORY = newFactory(BigInteger.class, r21);
        TypeAdapter<LazilyParsedNumber> r22 = new AnonymousClass19();
        LAZILY_PARSED_NUMBER = r22;
        LAZILY_PARSED_NUMBER_FACTORY = newFactory(LazilyParsedNumber.class, r22);
        STRING_FACTORY = newFactory(String.class, r19);
        TypeAdapter<StringBuilder> r23 = new AnonymousClass20();
        STRING_BUILDER = r23;
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, r23);
        TypeAdapter<StringBuffer> r24 = new AnonymousClass21();
        STRING_BUFFER = r24;
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, r24);
        TypeAdapter<URL> r25 = new AnonymousClass22();
        URL = r25;
        URL_FACTORY = newFactory(URL.class, r25);
        TypeAdapter<URI> r26 = new AnonymousClass23();
        URI = r26;
        URI_FACTORY = newFactory(URI.class, r26);
        TypeAdapter<InetAddress> r27 = new AnonymousClass24();
        INET_ADDRESS = r27;
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, r27);
        TypeAdapter<UUID> r28 = new AnonymousClass25();
        UUID = r28;
        UUID_FACTORY = newFactory(UUID.class, r28);
        TypeAdapter<Currency> r29 = new AnonymousClass26().nullSafe();
        CURRENCY = r29;
        CURRENCY_FACTORY = newFactory(Currency.class, r29);
        final String[] r30 = {"year", "month", "dayOfMonth", "hourOfDay", "minute", "second"};
        IntegerFieldsTypeAdapter<Calendar> r31 = new AnonymousClass27(r30);
        CALENDAR = r31;
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, r31);
        TypeAdapter<Locale> r32 = new AnonymousClass28();
        LOCALE = r32;
        LOCALE_FACTORY = newFactory(Locale.class, r32);
        JsonElementTypeAdapter r33 = JsonElementTypeAdapter.ADAPTER;
        JSON_ELEMENT = r33;
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, r33);
        ENUM_FACTORY = EnumTypeAdapter.FACTORY;
    }

    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ void access$000(double r5) {
        checkValidFloatingPoint(r5);
    }

    public static /* synthetic */ int access$100(long r5) {
        return toIntExact(r5);
    }

    public static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> r5) {
        Objects.requireNonNull(r5);
        return new AnonymousClass9(r5).nullSafe();
    }

    public static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> r5) {
        Objects.requireNonNull(r5);
        return new AnonymousClass12(r5).nullSafe();
    }

    private static void checkValidFloatingPoint(double r5) {
        if (Double.isNaN(r5) == true) goto L8;
        if (Double.isInfinite(r5) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(r5 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    public static TypeAdapterFactory javaTimeTypeAdapterFactory() {
        TypeAdapter<LocalTime> r5 = JavaTimeTypeAdapters.LOCAL_TIME;     // Catch: Throwable -> L5
        return ((FactorySupplier) JavaTimeTypeAdapters.class.getDeclaredConstructor(null).newInstance(null)).get();
    L8:
        return null;
    }

    public static <TT> TypeAdapterFactory newFactory(final TypeToken<TT> r5, final TypeAdapter<TT> r10) {
        return new AnonymousClass29(r5, r10);
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(final Class<TT> r5, final Class<? extends TT> r10, final TypeAdapter<? super TT> r11) {
        return new AnonymousClass32(r5, r10, r11);
    }

    public static <T1> TypeAdapterFactory newTypeHierarchyFactory(final Class<T1> r5, final TypeAdapter<T1> r10) {
        return new AnonymousClass33(r5, r10);
    }

    private static int toIntExact(long r5) {
        int r10 = (int) r5;
        if (r10 != r5) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException(a.j(r5, "Too big for an int: "));
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> r5, final TypeAdapter<TT> r10) {
        return new AnonymousClass30(r5, r10);
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> r5, final Class<TT> r10, final TypeAdapter<? super TT> r11) {
        return new AnonymousClass31(r5, r10, r11);
    }
}
