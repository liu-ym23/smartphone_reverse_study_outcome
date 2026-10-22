package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.NumberLimits;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonPrimitive extends JsonElement {
    private final Object value;

    public JsonPrimitive(Boolean r5) {
        Objects.requireNonNull(r5);
        this.value = r5;
    }

    private static boolean isIntegral(JsonPrimitive r5) {
        Object r10 = r5.value;
        if ((r10 instanceof Number) == false) goto L16;
        Number r11 = (Number) r10;
        if ((r11 instanceof BigInteger) == false) goto L7;
    L14:
        return true;
    L7:
        if ((r11 instanceof Long) == true) goto L14;
        if ((r11 instanceof Integer) == true) goto L14;
        if ((r11 instanceof Short) == true) goto L14;
        if ((r11 instanceof Byte) == true) goto L14;
        return false;
    L16:
        return false;
    }

    @Override // com.google.gson.JsonElement
    public JsonPrimitive deepCopy() {
        return this;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L56:
        return false;
    L8:
        if (JsonPrimitive.class != r10.getClass()) goto L56;
        JsonPrimitive r11 = (JsonPrimitive) r10;
        if (this.value != null) goto L18;
        if (r11.value != null) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (isIntegral(this) == true) goto L20;
    L32:
        Object r5 = this.value;
        if ((r5 instanceof Number) == false) goto L55;
        Object r12 = r11.value;
        if ((r12 instanceof Number) == false) goto L55;
        if ((r5 instanceof BigDecimal) == true) goto L39;
    L45:
        double r13 = getAsDouble();
        double r14 = r11.getAsDouble();
        if (r13 != r14) goto L48;
        return true;
    L48:
        if (Double.isNaN(r13) == false) goto L53;
        if (Double.isNaN(r14) == false) goto L53;
        return true;
    L53:
        return false;
    L39:
        if ((r12 instanceof BigDecimal) == false) goto L45;
        if (getAsBigDecimal().compareTo(r11.getAsBigDecimal()) != 0) goto L44;
        return true;
    L44:
        return false;
    L55:
        return r5.equals(r11.value);
    L20:
        if (isIntegral(r11) == false) goto L32;
        if ((this.value instanceof BigInteger) == true) goto L31;
        if ((r11.value instanceof BigInteger) == true) goto L31;
        if (getAsNumber().longValue() != r11.getAsNumber().longValue()) goto L58;
        return true;
    L58:
        return false;
    L31:
        return getAsBigInteger().equals(r11.getAsBigInteger());
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        Object r5 = this.value;
        if ((r5 instanceof BigDecimal) == false) goto L6;
        return (BigDecimal) r5;
    L6:
        return NumberLimits.parseBigDecimal(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        Object r5 = this.value;
        if ((r5 instanceof BigInteger) == false) goto L6;
        return (BigInteger) r5;
    L6:
        if (isIntegral(this) == false) goto L9;
        return BigInteger.valueOf(getAsNumber().longValue());
    L9:
        return NumberLimits.parseBigInteger(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (isBoolean() == false) goto L7;
        return ((Boolean) this.value).booleanValue();
    L7:
        return Boolean.parseBoolean(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        if (isNumber() == false) goto L6;
        return getAsNumber().byteValue();
    L6:
        return Byte.parseByte(getAsString());
    }

    @Override // com.google.gson.JsonElement
    @Deprecated
    public char getAsCharacter() {
        String r5 = getAsString();
        if (r5.isEmpty() == true) goto L7;
        return r5.charAt(0);
    L7:
        throw new UnsupportedOperationException("String value is empty");
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        if (isNumber() == false) goto L6;
        return getAsNumber().doubleValue();
    L6:
        return Double.parseDouble(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        if (isNumber() == false) goto L6;
        return getAsNumber().floatValue();
    L6:
        return Float.parseFloat(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        if (isNumber() == false) goto L6;
        return getAsNumber().intValue();
    L6:
        return Integer.parseInt(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        if (isNumber() == false) goto L6;
        return getAsNumber().longValue();
    L6:
        return Long.parseLong(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        Object r5 = this.value;
        if ((r5 instanceof Number) == false) goto L7;
        return (Number) r5;
    L7:
        if ((r5 instanceof String) == false) goto L11;
        return new LazilyParsedNumber((String) r5);
    L11:
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        if (isNumber() == false) goto L6;
        return getAsNumber().shortValue();
    L6:
        return Short.parseShort(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        Object r5 = this.value;
        if ((r5 instanceof String) == false) goto L7;
        return (String) r5;
    L7:
        if (isNumber() == false) goto L11;
        return getAsNumber().toString();
    L11:
        if (isBoolean() == false) goto L15;
        return ((Boolean) this.value).toString();
    L15:
        throw new AssertionError("Unexpected value type: " + this.value.getClass());
    }

    public int hashCode() {
        if (this.value != null) goto L7;
        return 31;
    L7:
        if (isIntegral(this) == false) goto L11;
        long r5 = getAsNumber().longValue();
    L10:
        return (int) ((r5 >>> 32) ^ r5);
    L11:
        Object r10 = this.value;
        if ((r10 instanceof Number) == false) goto L15;
        r5 = Double.doubleToLongBits(getAsNumber().doubleValue());
        goto L10
    L15:
        return r10.hashCode();
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    public JsonPrimitive(Number r5) {
        Objects.requireNonNull(r5);
        this.value = r5;
    }

    public JsonPrimitive(String r5) {
        Objects.requireNonNull(r5);
        this.value = r5;
    }

    public JsonPrimitive(Character r5) {
        Objects.requireNonNull(r5);
        this.value = r5.toString();
    }
}
