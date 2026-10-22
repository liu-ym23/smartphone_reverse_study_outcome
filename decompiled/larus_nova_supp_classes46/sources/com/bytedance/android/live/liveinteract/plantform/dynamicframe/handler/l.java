package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends lh0.b {
    public final ih0.b d;

    public static final class a {
    }

    static {
    }

    public l(Context r2, DataCenter r3, ih0.b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "service");
        super(r2, r3);
        this.d = r4;
    }
}
