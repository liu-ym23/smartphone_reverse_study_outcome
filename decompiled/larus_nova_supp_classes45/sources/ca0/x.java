package ca0;

import com.bytedance.android.livesdk.gift.model.w1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class x extends w {
    public final w a;

    @Override // ca0.w
    public final void a() {
        w r0 = this.a;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public x(w r1) {
        this.a = r1;
    }

    @Override // ca0.w
    public void b(List<? extends w1> r2) {
        Intrinsics.checkNotNullParameter(r2, "giftPages");
        Intrinsics.checkNotNullParameter(r2, "giftPages");
        w r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }
}
