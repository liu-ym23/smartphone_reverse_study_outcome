package pm;

import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JavaOnlyMap f21363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21364b;

    public c(String r5, JavaOnlyMap r10) {
        this.f21363a = r10;
        this.f21364b = r5;
    }

    @Override // pm.a
    public final ReadableArray asArray() {
        return this.f21363a.getArray(this.f21364b);
    }

    @Override // pm.a
    public final boolean asBoolean() {
        return this.f21363a.getBoolean(this.f21364b);
    }

    @Override // pm.a
    public final double asDouble() {
        return this.f21363a.getDouble(this.f21364b);
    }

    @Override // pm.a
    public final int asInt() {
        return this.f21363a.getInt(this.f21364b);
    }

    @Override // pm.a
    public final long asLong() {
        return this.f21363a.getLong(this.f21364b);
    }

    @Override // pm.a
    public final ReadableMap asMap() {
        return this.f21363a.getMap(this.f21364b);
    }

    @Override // pm.a
    public final String asString() {
        return this.f21363a.getString(this.f21364b);
    }

    @Override // pm.a
    public final ReadableType getType() {
        return this.f21363a.getType(this.f21364b);
    }
}
