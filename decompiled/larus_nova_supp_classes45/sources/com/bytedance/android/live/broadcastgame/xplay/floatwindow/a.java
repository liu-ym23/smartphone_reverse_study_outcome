package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final DataCenter a;
    public final com.bytedance.android.live.core.arch.mvvm.c<Boolean> b;
    public final p c;

    public a(DataCenter r2, PropertyOwner r3, p r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "isInteractive");
        Intrinsics.checkNotNullParameter(r4, "env");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
