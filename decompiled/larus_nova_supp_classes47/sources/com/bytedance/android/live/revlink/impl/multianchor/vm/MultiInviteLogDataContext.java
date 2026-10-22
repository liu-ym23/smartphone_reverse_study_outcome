package com.bytedance.android.live.revlink.impl.multianchor.vm;

import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiInviteLogDataContext {
    public final Lazy a;
    public final Lazy b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    public MultiInviteLogDataContext(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.c = r1;
        this.a = LazyKt.lazy(MultiInviteLogDataContext$linkParams$2.INSTANCE);
        this.b = LazyKt.lazy(MultiInviteLogDataContext$inviteeParams$2.INSTANCE);
    }

    public final void a(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((Map) this.b.getValue()).remove(r2);
        ((Map) this.a.getValue()).remove(r2);
        if (((Map) this.b.getValue()).isEmpty() == true) goto L17;
        com.bytedance.android.live.revlink.impl.global.c r3 = this.c;
        if (r3 == null) goto L9;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r4 = r3.R8();
    L10:
        if (r4 == null) goto L17;
        i11.b r5 = r4.getLinkUserCenter();
        if (r5 == null) goto L17;
        List<IBaseUser> r6 = r5.getInviteeList();
        if (r6 == null) goto L17;
        if (r6.isEmpty() == true) goto L17;
        return;
    L9:
        r4 = null;
    L17:
        ((Map) this.b.getValue()).clear();
        ((Map) this.a.getValue()).clear();
    }
}
