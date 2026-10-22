package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.live.revlink.impl.behavior.ToolbarPkBehavior;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t {
    public final boolean a;
    public final IRoom b;
    public final ToolbarPkBehavior c;

    public t(boolean r2, IRoom r3, DataCenter r4, ToolbarPkBehavior r5) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "pkBehavior");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
