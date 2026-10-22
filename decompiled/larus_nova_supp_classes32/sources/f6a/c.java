package f6a;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements a {
    public final ReadableMap a;
    public final String b;

    @Override // f6a.a
    public final void recycle() {
    }

    @Override // f6a.a
    public final ReadableArray asArray() {
        return this.a.getArray(this.b);
    }

    @Override // f6a.a
    public final boolean asBoolean() {
        return this.a.getBoolean(this.b);
    }

    @Override // f6a.a
    public final byte[] asByteArray() {
        return this.a.getByteArray(this.b);
    }

    @Override // f6a.a
    public final double asDouble() {
        return this.a.getDouble(this.b);
    }

    @Override // f6a.a
    public final int asInt() {
        return this.a.getInt(this.b);
    }

    @Override // f6a.a
    public final long asLong() {
        return this.a.getLong(this.b);
    }

    @Override // f6a.a
    public final ReadableMap asMap() {
        return this.a.getMap(this.b);
    }

    @Override // f6a.a
    public final String asString() {
        return this.a.getString(this.b);
    }

    @Override // f6a.a
    public ReadableType getType() {
        return this.a.getType(this.b);
    }

    @Override // f6a.a
    public final boolean isNull() {
        return this.a.isNull(this.b);
    }

    public c(ReadableMap r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
