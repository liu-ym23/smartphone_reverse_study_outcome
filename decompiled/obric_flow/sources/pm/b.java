package pm;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JavaOnlyArray f21361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21362b;

    public b(JavaOnlyArray r5, int r10) {
        this.f21361a = r5;
        this.f21362b = r10;
    }

    @Override // pm.a
    public final ReadableArray asArray() {
        return this.f21361a.getArray(this.f21362b);
    }

    @Override // pm.a
    public final boolean asBoolean() {
        return this.f21361a.getBoolean(this.f21362b);
    }

    @Override // pm.a
    public final double asDouble() {
        return this.f21361a.getDouble(this.f21362b);
    }

    @Override // pm.a
    public final int asInt() {
        return this.f21361a.getInt(this.f21362b);
    }

    @Override // pm.a
    public final long asLong() {
        return this.f21361a.getLong(this.f21362b);
    }

    @Override // pm.a
    public final ReadableMap asMap() {
        return this.f21361a.getMap(this.f21362b);
    }

    @Override // pm.a
    public final String asString() {
        return this.f21361a.getString(this.f21362b);
    }

    @Override // pm.a
    public final ReadableType getType() {
        return this.f21361a.getType(this.f21362b);
    }
}
