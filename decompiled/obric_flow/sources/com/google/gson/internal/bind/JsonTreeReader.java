package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonTreeReader extends JsonReader {
    private static final Object SENTINEL_CLOSED = null;
    private static final Reader UNREADABLE_READER = null;
    private int[] pathIndices;
    private String[] pathNames;
    private Object[] stack;
    private int stackSize;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.JsonTreeReader$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r5 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r5;
            r5[JsonToken.NAME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        UNREADABLE_READER = new AnonymousClass1();
        SENTINEL_CLOSED = new Object();
    }

    public JsonTreeReader(JsonElement r5) {
        super(UNREADABLE_READER);
        this.stack = new Object[32];
        this.stackSize = 0;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        push(r5);
    }

    private void expect(JsonToken r5) throws IOException {
        if (peek() != r5) goto L6;
        return;
    L6:
        throw new IllegalStateException("Expected " + r5 + " but was " + peek() + locationString());
    }

    private String getPath(boolean r10) {
        StringBuilder r5 = new StringBuilder("$");
        int r11 = 0;
    L3:
        int r12 = this.stackSize;
        if (r11 >= r12) goto L31;
        Object[] r13 = this.stack;
        Object r14 = r13[r11];
        if ((r14 instanceof JsonArray) == false) goto L21;
        r11 = r11 + 1;
        if (r11 >= r12) goto L29;
        if ((r13[r11] instanceof Iterator) == false) goto L29;
        int r15 = this.pathIndices[r11];
        if (r10 == false) goto L19;
        if (r15 <= 0) goto L19;
        if (r11 != (r12 - 1)) goto L17;
    L18:
        r15 = r15 - 1;
        goto L19
    L17:
        if (r11 == (r12 - 2)) goto L18;
    L19:
        r5.append('[');
        r5.append(r15);
        r5.append(']');
    L29:
        r11 = r11 + 1;
        goto L3
    L21:
        if ((r14 instanceof JsonObject) == false) goto L29;
        r11 = r11 + 1;
        if (r11 >= r12) goto L29;
        if ((r13[r11] instanceof Iterator) == false) goto L29;
        r5.append('.');
        String r16 = this.pathNames[r11];
        if (r16 == null) goto L29;
        r5.append(r16);
        goto L29
    L31:
        return r5.toString();
    }

    private String locationString() {
        return " at path " + getPath();
    }

    private String nextName(boolean r5) throws IOException {
        expect(JsonToken.NAME);
        Map.Entry r10 = (Map.Entry) ((Iterator) peekStack()).next();
        String r11 = (String) r10.getKey();
        String[] r12 = this.pathNames;
        int r13 = this.stackSize - 1;
        if (r5 == false) goto L5;
        String r14 = "<skipped>";
    L6:
        r12[r13] = r14;
        push(r10.getValue());
        return r11;
    L5:
        r14 = r11;
        goto L6
    }

    private Object peekStack() {
        return this.stack[this.stackSize - 1];
    }

    private Object popStack() {
        Object[] r5 = this.stack;
        int r10 = this.stackSize - 1;
        this.stackSize = r10;
        Object r11 = r5[r10];
        r5[r10] = null;
        return r11;
    }

    private void push(Object r5) {
        int r10 = this.stackSize;
        Object[] r11 = this.stack;
        if (r10 != r11.length) goto L5;
        int r12 = r10 * 2;
        this.stack = Arrays.copyOf(r11, r12);
        this.pathIndices = Arrays.copyOf(this.pathIndices, r12);
        this.pathNames = (String[]) Arrays.copyOf(this.pathNames, r12);
    L5:
        Object[] r13 = this.stack;
        int r14 = this.stackSize;
        this.stackSize = r14 + 1;
        r13[r14] = r5;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() throws IOException {
        expect(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) peekStack()).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() throws IOException {
        expect(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) peekStack()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stack = new Object[]{SENTINEL_CLOSED};
        this.stackSize = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() throws IOException {
        expect(JsonToken.END_ARRAY);
        popStack();
        popStack();
        int r5 = this.stackSize;
        if (r5 <= 0) goto L6;
        int[] r10 = this.pathIndices;
        int r11 = r5 - 1;
        r10[r11] = r10[r11] + 1;
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() throws IOException {
        expect(JsonToken.END_OBJECT);
        this.pathNames[this.stackSize - 1] = null;
        popStack();
        popStack();
        int r5 = this.stackSize;
        if (r5 <= 0) goto L6;
        int[] r10 = this.pathIndices;
        int r11 = r5 - 1;
        r10[r11] = r10[r11] + 1;
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPreviousPath() {
        return getPath(true);
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() throws IOException {
        JsonToken r5 = peek();
        if (r5 != JsonToken.END_OBJECT) goto L5;
    L9:
        return false;
    L5:
        if (r5 == JsonToken.END_ARRAY) goto L9;
        if (r5 == JsonToken.END_DOCUMENT) goto L9;
        return true;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() throws IOException {
        expect(JsonToken.BOOLEAN);
        boolean r5 = ((JsonPrimitive) popStack()).getAsBoolean();
        int r10 = this.stackSize;
        if (r10 <= 0) goto L5;
        int[] r11 = this.pathIndices;
        int r12 = r10 - 1;
        r11[r12] = r11[r12] + 1;
    L5:
        return r5;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() throws IOException {
        JsonToken r5 = peek();
        JsonToken r10 = JsonToken.NUMBER;
        if (r5 != r10) goto L5;
    L9:
        double r11 = ((JsonPrimitive) peekStack()).getAsDouble();
        if (isLenient() == false) goto L12;
    L18:
        popStack();
        int r12 = this.stackSize;
        if (r12 <= 0) goto L21;
        int[] r13 = this.pathIndices;
        int r14 = r12 - 1;
        r13[r14] = r13[r14] + 1;
    L21:
        return r11;
    L12:
        if (Double.isNaN(r11) == true) goto L17;
        if (Double.isInfinite(r11) == false) goto L18;
    L17:
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + r11);
    L5:
        if (r5 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + r10 + " but was " + r5 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() throws IOException {
        JsonToken r5 = peek();
        JsonToken r10 = JsonToken.NUMBER;
        if (r5 != r10) goto L5;
    L9:
        int r11 = ((JsonPrimitive) peekStack()).getAsInt();
        popStack();
        int r12 = this.stackSize;
        if (r12 <= 0) goto L12;
        int[] r13 = this.pathIndices;
        int r14 = r12 - 1;
        r13[r14] = r13[r14] + 1;
    L12:
        return r11;
    L5:
        if (r5 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + r10 + " but was " + r5 + locationString());
    }

    public JsonElement nextJsonElement() throws IOException {
        JsonToken r5 = peek();
        if (r5 == JsonToken.NAME) goto L13;
        if (r5 == JsonToken.END_ARRAY) goto L13;
        if (r5 == JsonToken.END_OBJECT) goto L13;
        if (r5 == JsonToken.END_DOCUMENT) goto L13;
        JsonElement r10 = (JsonElement) peekStack();
        skipValue();
        return r10;
    L13:
        throw new IllegalStateException("Unexpected " + r5 + " when reading a JsonElement.");
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() throws IOException {
        JsonToken r5 = peek();
        JsonToken r10 = JsonToken.NUMBER;
        if (r5 != r10) goto L5;
    L9:
        long r11 = ((JsonPrimitive) peekStack()).getAsLong();
        popStack();
        int r12 = this.stackSize;
        if (r12 <= 0) goto L12;
        int[] r13 = this.pathIndices;
        int r14 = r12 - 1;
        r13[r14] = r13[r14] + 1;
    L12:
        return r11;
    L5:
        if (r5 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + r10 + " but was " + r5 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() throws IOException {
        expect(JsonToken.NULL);
        popStack();
        int r5 = this.stackSize;
        if (r5 <= 0) goto L6;
        int[] r10 = this.pathIndices;
        int r11 = r5 - 1;
        r10[r11] = r10[r11] + 1;
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() throws IOException {
        JsonToken r5 = peek();
        JsonToken r10 = JsonToken.STRING;
        if (r5 != r10) goto L5;
    L9:
        String r11 = ((JsonPrimitive) popStack()).getAsString();
        int r12 = this.stackSize;
        if (r12 <= 0) goto L12;
        int[] r13 = this.pathIndices;
        int r14 = r12 - 1;
        r13[r14] = r13[r14] + 1;
    L12:
        return r11;
    L5:
        if (r5 == JsonToken.NUMBER) goto L9;
        throw new IllegalStateException("Expected " + r10 + " but was " + r5 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() throws IOException {
        if (this.stackSize == 0) goto L5;
        Object r5 = peekStack();
        if ((r5 instanceof Iterator) == false) goto L20;
        boolean r10 = this.stack[this.stackSize - 2] instanceof JsonObject;
        Iterator r11 = (Iterator) r5;
        if (r11.hasNext() == false) goto L15;
        if (r10 == true) goto L12;
        push(r11.next());
        return peek();
    L12:
        return JsonToken.NAME;
    L15:
        if (r10 == false) goto L18;
        return JsonToken.END_OBJECT;
    L18:
        return JsonToken.END_ARRAY;
    L20:
        if ((r5 instanceof JsonObject) == false) goto L24;
        return JsonToken.BEGIN_OBJECT;
    L24:
        if ((r5 instanceof JsonArray) == false) goto L28;
        return JsonToken.BEGIN_ARRAY;
    L28:
        if ((r5 instanceof JsonPrimitive) == false) goto L44;
        JsonPrimitive r12 = (JsonPrimitive) r5;
        if (r12.isString() == false) goto L34;
        return JsonToken.STRING;
    L34:
        if (r12.isBoolean() == false) goto L38;
        return JsonToken.BOOLEAN;
    L38:
        if (r12.isNumber() == false) goto L42;
        return JsonToken.NUMBER;
    L42:
        throw new AssertionError();
    L44:
        if ((r5 instanceof JsonNull) == false) goto L48;
        return JsonToken.NULL;
    L48:
        if (r5 != SENTINEL_CLOSED) goto L52;
        throw new IllegalStateException("JsonReader is closed");
    L52:
        throw new MalformedJsonException("Custom JsonElement subclass " + r5.getClass().getName() + " is not supported");
    L5:
        return JsonToken.END_DOCUMENT;
    }

    public void promoteNameToValue() throws IOException {
        expect(JsonToken.NAME);
        Map.Entry r5 = (Map.Entry) ((Iterator) peekStack()).next();
        push(r5.getValue());
        push(new JsonPrimitive((String) r5.getKey()));
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() throws IOException {
        JsonToken r5 = peek();
        int r10 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[r5.ordinal()];
        if (r10 != 1) goto L5;
        nextName(true);
        return;
    L5:
        if (r10 != 2) goto L7;
        endArray();
        return;
    L7:
        if (r10 != 3) goto L9;
        endObject();
        return;
    L9:
        if (r10 == 4) goto L17;
        popStack();
        int r11 = this.stackSize;
        if (r11 <= 0) goto L18;
        int[] r12 = this.pathIndices;
        int r13 = r11 - 1;
        r12[r13] = r12[r13] + 1;
        return;
    L18:
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return "JsonTreeReader" + locationString();
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() throws IOException {
        return nextName(false);
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        return getPath(false);
    }
}
