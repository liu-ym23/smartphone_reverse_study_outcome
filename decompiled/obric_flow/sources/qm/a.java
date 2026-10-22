package qm;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements pm.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f21520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21521b;

    public a(f r5, int r10) {
        this.f21520a = r5;
        this.f21521b = r10;
    }

    @Override // pm.a
    public final ReadableArray asArray() {
        return this.f21520a.getArray(this.f21521b);
    }

    @Override // pm.a
    public final boolean asBoolean() {
        return this.f21520a.getBoolean(this.f21521b);
    }

    @Override // pm.a
    public final double asDouble() {
        return this.f21520a.getDouble(this.f21521b);
    }

    @Override // pm.a
    public final int asInt() {
        return this.f21520a.getInt(this.f21521b);
    }

    @Override // pm.a
    public final long asLong() {
        return this.f21520a.getLong(this.f21521b);
    }

    @Override // pm.a
    public final ReadableMap asMap() {
        this.f21520a.getClass();
        return null;
    }

    @Override // pm.a
    public final String asString() {
        return this.f21520a.getString(this.f21521b);
    }

    @Override // pm.a
    public final ReadableType getType() {
        return this.f21520a.getType(this.f21521b);
    }
}
