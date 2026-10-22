package fk;

import androidx.core.util.Pools;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pools.SimplePool f16920c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JavaOnlyMap f16921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16922b;

    static {
        f16920c = new Pools.SimplePool(10);
    }

    @Override // fk.a
    public final ReadableArray asArray() {
        JavaOnlyMap r5 = this.f16921a;
        if (r5 == null) goto L9;
        String r10 = this.f16922b;
        if (r10 == null) goto L9;
        return r5.getArray(r10);
    L9:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // fk.a
    public final boolean asBoolean() {
        JavaOnlyMap r5 = this.f16921a;
        if (r5 == null) goto L9;
        String r10 = this.f16922b;
        if (r10 == null) goto L9;
        return r5.getBoolean(r10);
    L9:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // fk.a
    public final double asDouble() {
        JavaOnlyMap r5 = this.f16921a;
        if (r5 == null) goto L9;
        String r10 = this.f16922b;
        if (r10 == null) goto L9;
        return r5.getDouble(r10);
    L9:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // fk.a
    public final ReadableMap asMap() {
        JavaOnlyMap r5 = this.f16921a;
        if (r5 == null) goto L9;
        String r10 = this.f16922b;
        if (r10 == null) goto L9;
        return r5.getMap(r10);
    L9:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // fk.a
    public final String asString() {
        JavaOnlyMap r5 = this.f16921a;
        if (r5 == null) goto L9;
        String r10 = this.f16922b;
        if (r10 == null) goto L9;
        return r5.getString(r10);
    L9:
        throw new IllegalStateException("This dynamic value has been recycled");
    }

    @Override // fk.a
    public final ReadableType getType() {
        JavaOnlyMap r5 = this.f16921a;
        if (r5 == null) goto L9;
        String r10 = this.f16922b;
        if (r10 == null) goto L9;
        return r5.getType(r10);
    L9:
        throw new IllegalStateException("This dynamic value has been recycled");
    }
}
