package com.google.crypto.tink.internal;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f4876a = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.JsonParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4877a = null;

        static {
            int[] r0 = new int[JsonToken.values().length];
            f4877a = r0;
            r0[JsonToken.BEGIN_ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f4877a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f4877a[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f4877a[JsonToken.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f4877a[JsonToken.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f4877a[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    private static final class LazilyParsedNumber extends Number {
        private final String value;

        public LazilyParsedNumber(String r1) {
            this.value = r1;
        }

        private void readObject(ObjectInputStream r1) {
            throw new NotSerializableException("serialization is not supported");
        }

        private Object writeReplace() {
            throw new NotSerializableException("serialization is not supported");
        }

        @Override // java.lang.Number
        public double doubleValue() {
            return Double.parseDouble(this.value);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L7;
            return true;
        L7:
            if (ZeusTransformUtils.instanceOf(r3, LazilyParsedNumber.class) == false) goto L10;
            LazilyParsedNumber r4 = (LazilyParsedNumber) ZeusTransformUtils.preCheckCast(r3, LazilyParsedNumber.class, "com.obric.memorydata.plugin");
            return this.value.equals(r4.value);
        L10:
            return false;
        }

        @Override // java.lang.Number
        public float floatValue() {
            return Float.parseFloat(this.value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @Override // java.lang.Number
        public int intValue() {
            return Integer.parseInt(this.value);
        L4:
            return (int) Long.parseLong(this.value);
        L8:
            return new BigDecimal(this.value).intValue();
        }

        @Override // java.lang.Number
        public long longValue() {
            return Long.parseLong(this.value);
        L5:
            return new BigDecimal(this.value).longValue();
        }

        public String toString() {
            return this.value;
        }
    }

    private static final class a extends TypeAdapter<JsonElement> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        private JsonElement a(JsonReader r1, JsonToken r2) {
            int r0 = AnonymousClass1.f4877a[r2.ordinal()];
            if (r0 != 1) goto L5;
            r1.beginArray();
            return new JsonArray();
        L5:
            if (r0 == 2) goto L8;
            return null;
        L8:
            r1.beginObject();
            return new JsonObject();
        }

        private JsonElement b(JsonReader r2, JsonToken r3) {
            int r1 = AnonymousClass1.f4877a[r3.ordinal()];
            if (r1 != 3) goto L5;
            String r4 = r2.nextString();
            if (JsonParser.a(r4) == false) goto L23;
            return new JsonPrimitive(r4);
        L23:
            throw new IOException("illegal characters in string");
        L5:
            if (r1 == 4) goto L17;
            if (r1 == 5) goto L15;
            if (r1 != 6) goto L13;
            r2.nextNull();
            return JsonNull.INSTANCE;
        L13:
            throw new IllegalStateException("Unexpected token: " + r3);
        L15:
            return new JsonPrimitive(Boolean.valueOf(r2.nextBoolean()));
        L17:
            return new JsonPrimitive(new LazilyParsedNumber(r2.nextString()));
        }

        public JsonElement a(JsonReader r8) {
            JsonToken r0 = r8.peek();
            JsonElement r1 = a(r8, r0);
            if (r1 == null) goto L5;
            ArrayDeque r2 = new ArrayDeque();
        L8:
            if (r8.hasNext() == true) goto L9;
            if (ZeusTransformUtils.instanceOf(r1, JsonArray.class) == false) goto L39;
            r8.endArray();
        L41:
            if (r2.isEmpty() == true) goto L42;
            r1 = (JsonElement) ZeusTransformUtils.preCheckCast(r2.removeLast(), JsonElement.class, "com.obric.memorydata.plugin");
            goto L8
        L42:
            return r1;
        L39:
            r8.endObject();
            goto L41
        L9:
            String r3 = null;
            if (ZeusTransformUtils.instanceOf(r1, JsonObject.class) == false) goto L16;
            r3 = r8.nextName();
            if (JsonParser.a(r3) == true) goto L16;
            throw new IOException("illegal characters in string");
        L16:
            JsonToken r4 = r8.peek();
            JsonElement r5 = a(r8, r4);
            if (r5 == null) goto L19;
            boolean r6 = true;
        L20:
            if (r5 != null) goto L23;
            r5 = b(r8, r4);
        L23:
            if (ZeusTransformUtils.instanceOf(r1, JsonArray.class) == false) goto L26;
            ((JsonArray) ZeusTransformUtils.preCheckCast(r1, JsonArray.class, "com.obric.memorydata.plugin")).add(r5);
        L28:
            if (r6 == false) goto L8;
            r2.addLast(r1);
            if (r2.size() > 100) goto L33;
            r1 = r5;
            goto L8
        L33:
            throw new IOException("too many recursions");
        L26:
            if (((JsonObject) ZeusTransformUtils.preCheckCast(r1, JsonObject.class, "com.obric.memorydata.plugin")).has(r3) == true) goto L35;
            ((JsonObject) ZeusTransformUtils.preCheckCast(r1, JsonObject.class, "com.obric.memorydata.plugin")).add(r3, r5);
            goto L28
        L35:
            throw new IOException("duplicate key: " + r3);
        L19:
            r6 = false;
            goto L20
        L5:
            return b(r8, r0);
        }

        public void a(JsonWriter r1, JsonElement r2) {
            throw new UnsupportedOperationException("write is not supported");
        }

        @Override // com.google.gson.TypeAdapter
        public /* synthetic */ JsonElement read(JsonReader r1) {
            return a(r1);
        }

        @Override // com.google.gson.TypeAdapter
        public /* synthetic */ void write(JsonWriter r3, JsonElement r4) {
            a(r3, (JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f4876a = new a(null);
    }

    public static boolean a(String r5) {
        int r0 = r5.length();
        int r2 = 0;
    L3:
        if (r2 == r0) goto L4;
        char r3 = r5.charAt(r2);
        r2 = r2 + 1;
        if (Character.isSurrogate(r3) == false) goto L3;
        if (Character.isLowSurrogate(r3) == true) goto L15;
        if (r2 == r0) goto L15;
        if (Character.isLowSurrogate(r5.charAt(r2)) == false) goto L15;
        r2 = r2 + 1;
    L15:
        return false;
    L4:
        return true;
    }
}
