package k70;

import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import j70.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class b<T extends j70.e> {
    public h70.b a;

    public b() {
    }

    public abstract Element<?> a(T r1);

    public final h70.b b() {
        h70.b r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L5:
        return r0;
    }
}
