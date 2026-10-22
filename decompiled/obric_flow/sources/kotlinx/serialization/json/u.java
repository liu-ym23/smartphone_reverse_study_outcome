package kotlinx.serialization.json;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes3.dex */
@kotlinx.serialization.g(with = v.class)
public final class u extends b0 {
    public static final u INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Lazy f19448a = null;

    static {
        INSTANCE = new u();
        f19448a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, JsonNull$1.INSTANCE);
    }

    @Override // kotlinx.serialization.json.b0
    public final String b() {
        return "null";
    }

    public final kotlinx.serialization.c serializer() {
        return (kotlinx.serialization.c) f19448a.getValue();
    }
}
