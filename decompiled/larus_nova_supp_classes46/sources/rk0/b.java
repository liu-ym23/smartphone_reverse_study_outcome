package rk0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import yz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final String a() {
        g r0 = f.d(j.C0.a(), g.class);
        if (r0 == null) goto L8;
        IBaseUser r1 = r0.getUser();
        if (r1 == null) goto L8;
        String r2 = r1.getIdString();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }
}
