package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v extends DynamicFactor<Long> {
    public final DataCenter b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "room_id";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Long b() {
        IRoom r0 = com.bytedance.android.live.core.utils.a0.o(this.b);
        if (r0 == null) goto L5;
        long r1 = r0.getRoomId();
    L7:
        return Long.valueOf(r1);
    L5:
        r1 = 0;
        goto L7
    }

    public v(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
    }
}
