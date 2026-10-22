package g6a;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.mapbuffer.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements f6a.a {
    public final e a;
    public final int b;

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
        this.a.getClass();
        return new byte[0];
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
        this.a.getClass();
        return null;
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
        this.a.getClass();
        return false;
    }

    public a(e r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
