package g42;

import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class h<T> {
    public final PinType a;
    public final T b;
    public final long c;
    public final String d;

    public /* synthetic */ h(PinType r7, Object r8, long r9) {
        this(r7, r8, r9, String.valueOf(r9));
    }

    public h(PinType r2, T r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r2, "pinType");
        Intrinsics.checkNotNullParameter(r3, "data");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
    }
}
