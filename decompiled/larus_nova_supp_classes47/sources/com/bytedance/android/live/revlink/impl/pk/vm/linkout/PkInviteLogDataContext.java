package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PkInviteLogDataContext {
    public boolean a;
    public int b;
    public AnchorLinkUserCenterV2 c;
    public final Lazy d;
    public final com.bytedance.android.live.revlink.impl.global.c e;

    public final Map<String, Pair<Integer, d11.d>> a() {
        return (Map) this.d.getValue();
    }

    public PkInviteLogDataContext(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.e = r1;
        this.d = LazyKt.lazy(PkInviteLogDataContext$inviteeParams$2.INSTANCE);
    }
}
