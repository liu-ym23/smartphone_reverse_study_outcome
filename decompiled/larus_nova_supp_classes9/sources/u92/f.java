package u92;

import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements j {
    public f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j
    public final boolean a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "textMessage");
        c4 r3 = r2.b;
        int r0 = r.a;
        if ((r3 instanceof c4) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r3.getBizScene(), "ecom_order_msg") == false) goto L7;
        return true;
    }
}
