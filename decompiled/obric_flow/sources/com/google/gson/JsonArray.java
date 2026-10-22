package com.google.gson;

import ai.j0;
import com.google.gson.internal.NonNullElementWrapperList;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    private final ArrayList<JsonElement> elements;

    public JsonArray() {
        this.elements = new ArrayList();
    }

    private JsonElement getAsSingleElement() {
        int r5 = this.elements.size();
        if (r5 != 1) goto L7;
        return this.elements.get(0);
    L7:
        throw new IllegalStateException(j0.g(r5, "Array must have size 1, but has size "));
    }

    public void add(Boolean r5) {
        ArrayList<JsonElement> r10 = this.elements;
        if (r5 != null) goto L5;
        JsonElement r11 = JsonNull.INSTANCE;
    L6:
        r10.add(r11);
        return;
    L5:
        r11 = new JsonPrimitive(r5);
        goto L6
    }

    public void addAll(JsonArray r5) {
        this.elements.addAll(r5.elements);
    }

    public List<JsonElement> asList() {
        return new NonNullElementWrapperList(this.elements);
    }

    public boolean contains(JsonElement r5) {
        return this.elements.contains(r5);
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r5 instanceof JsonArray) == true) goto L6;
    L8:
        return false;
    L6:
        if (((JsonArray) r5).elements.equals(this.elements) == false) goto L8;
        goto L8
    }

    public JsonElement get(int r5) {
        return this.elements.get(r5);
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        return getAsSingleElement().getAsBigDecimal();
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        return getAsSingleElement().getAsBigInteger();
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        return getAsSingleElement().getAsBoolean();
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        return getAsSingleElement().getAsByte();
    }

    @Override // com.google.gson.JsonElement
    @Deprecated
    public char getAsCharacter() {
        return getAsSingleElement().getAsCharacter();
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        return getAsSingleElement().getAsDouble();
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        return getAsSingleElement().getAsFloat();
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        return getAsSingleElement().getAsInt();
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        return getAsSingleElement().getAsLong();
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        return getAsSingleElement().getAsNumber();
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        return getAsSingleElement().getAsShort();
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        return getAsSingleElement().getAsString();
    }

    public int hashCode() {
        return this.elements.hashCode();
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        return this.elements.iterator();
    }

    public boolean remove(JsonElement r5) {
        return this.elements.remove(r5);
    }

    public JsonElement set(int r5, JsonElement r10) {
        ArrayList<JsonElement> r11 = this.elements;
        if (r10 != null) goto L6;
        r10 = JsonNull.INSTANCE;
    L6:
        return r11.set(r5, r10);
    }

    public int size() {
        return this.elements.size();
    }

    public void add(Character r5) {
        ArrayList<JsonElement> r10 = this.elements;
        if (r5 != null) goto L5;
        JsonElement r11 = JsonNull.INSTANCE;
    L6:
        r10.add(r11);
        return;
    L5:
        r11 = new JsonPrimitive(r5);
        goto L6
    }

    @Override // com.google.gson.JsonElement
    public JsonArray deepCopy() {
        if (this.elements.isEmpty() == true) goto L10;
        JsonArray r5 = new JsonArray(this.elements.size());
        Iterator<JsonElement> r10 = this.elements.iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        r5.add(r10.next().deepCopy());
        goto L6
    L8:
        return r5;
    L10:
        return new JsonArray();
    }

    public JsonElement remove(int r5) {
        return this.elements.remove(r5);
    }

    public JsonArray(int r5) {
        this.elements = new ArrayList(r5);
    }

    public void add(Number r5) {
        ArrayList<JsonElement> r10 = this.elements;
        if (r5 != null) goto L5;
        JsonElement r11 = JsonNull.INSTANCE;
    L6:
        r10.add(r11);
        return;
    L5:
        r11 = new JsonPrimitive(r5);
        goto L6
    }

    public void add(String r5) {
        ArrayList<JsonElement> r10 = this.elements;
        if (r5 != null) goto L5;
        JsonElement r11 = JsonNull.INSTANCE;
    L6:
        r10.add(r11);
        return;
    L5:
        r11 = new JsonPrimitive(r5);
        goto L6
    }

    public void add(JsonElement r5) {
        if (r5 != null) goto L4;
        r5 = JsonNull.INSTANCE;
    L4:
        this.elements.add(r5);
    }
}
