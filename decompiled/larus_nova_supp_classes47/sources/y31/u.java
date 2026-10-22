package y31;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u {
    public final List<com.bytedance.android.livesdk.link.model.p> a;

    public u(List<? extends com.bytedance.android.livesdk.link.model.p> r5) {
        Intrinsics.checkNotNullParameter(r5, "anchorList");
        this.a = r5;
        String r0 = iz.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b());
        int r6 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L12;
        IBaseUser r3 = ((com.bytedance.android.livesdk.link.model.p) ListProtector.get(this.a, r2)).getUser();
        if (r3 == null) goto L7;
        String r4 = r3.getIdString();
    L9:
        if (Intrinsics.areEqual(r4, r0) == true) goto L13;
        r2 = r2 + 1;
    L13:
        if (r2 != 0) goto L15;
        return;
    L15:
        if ((!this.a.isEmpty()) == false) goto L21;
        Collections.swap(this.a, 0, r2);
        return;
    L21:
        return;
    L7:
        r4 = null;
        goto L9
    L12:
        r2 = 0;
        goto L13
    }
}
