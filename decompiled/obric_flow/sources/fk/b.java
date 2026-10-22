package fk;

import androidx.core.util.Pools;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pools.SimplePool f16917c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JavaOnlyArray f16918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16919b;

    static {
        f16917c = new Pools.SimplePool(10);
    }

    @Override // fk.a
    public final ReadableArray asArray() {
        JavaOnlyArray r5 = this.f16918a;
        if (r5 == null) goto L7;
        return r5.getArray(this.f16919b);
    L7:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // fk.a
    public final boolean asBoolean() {
        JavaOnlyArray r5 = this.f16918a;
        if (r5 == null) goto L7;
        return r5.getBoolean(this.f16919b);
    L7:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // fk.a
    public final double asDouble() {
        JavaOnlyArray r5 = this.f16918a;
        if (r5 == null) goto L7;
        return r5.getDouble(this.f16919b);
    L7:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // fk.a
    public final ReadableMap asMap() {
        JavaOnlyArray r5 = this.f16918a;
        if (r5 == null) goto L7;
        return r5.getMap(this.f16919b);
    L7:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // fk.a
    public final String asString() {
        JavaOnlyArray r5 = this.f16918a;
        if (r5 == null) goto L7;
        return r5.getString(this.f16919b);
    L7:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // fk.a
    public final ReadableType getType() {
        JavaOnlyArray r5 = this.f16918a;
        if (r5 == null) goto L7;
        return r5.getType(this.f16919b);
    L7:
        throw new IllegalStateException("This dynamic value has been recycled");
    }
}
