package g42;

import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class l<T> {
    public final PinType a;
    public final T b;
    public final long c;
    public boolean d;

    public l() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(PinType r2, Object r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "pinType");
        Intrinsics.checkNotNullParameter(r3, "data");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = false;
    }
}
