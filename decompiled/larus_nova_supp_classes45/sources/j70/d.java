package j70;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import h70.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class d<T extends h70.b> {
    public d() {
    }

    public abstract boolean B(T r1);

    public abstract f C(T r1);

    public abstract LayerIndex E(T r1);

    public final boolean D(T r5) {
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        z70.b r0 = r5.a;
        if (r0 == null) goto L22;
        if (r0.k() != true) goto L22;
        if ((C(r5) instanceof c) == true) goto L13;
        z70.b r1 = r5.a;
        if (r1 != null) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == true) goto L17;
    L19:
        return false;
    L17:
        if (B(r5) == false) goto L19;
        return true;
    L12:
        if (r1.d(C(r5)) == true) goto L14;
    L13:
        r2 = true;
    L22:
        return B(r5);
    }
}
