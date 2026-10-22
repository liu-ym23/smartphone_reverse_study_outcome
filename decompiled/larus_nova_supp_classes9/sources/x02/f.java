package x02;

import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends d0 {
    public f() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final void c(com.bytedance.android.livesdk.gift.platform.core.model.t r2, p2 r3, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r4, Function1<? super y, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Intrinsics.checkNotNullParameter(r5, "nextPlugin");
        super.c(r2, r3, r4, r5);
        if (r2.a().b <= 0) goto L6;
        vh6.c.b(ar2.a.class).z5();
        return;
    }
}
