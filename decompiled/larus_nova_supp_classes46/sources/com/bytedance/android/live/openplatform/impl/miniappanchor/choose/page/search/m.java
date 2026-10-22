package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.utility.SharedPrefHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m {
    public final SharedPrefHelper a;
    public final String b;

    public m() {
        this.a = SharedPrefHelper.b(s1.getContext());
        StringBuilder r0 = new StringBuilder("opensearch:");
        IUserService r1 = jc1.k.f(IUserService.class);
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.user.f r2 = r1.user();
        if (r2 == null) goto L7;
        String r3 = r2.n();
    L8:
        r0.append(r3);
        this.b = r0.toString();
        return;
    L7:
        r3 = null;
        goto L8
    }
}
