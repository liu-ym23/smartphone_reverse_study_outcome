package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v {
    public final WelfareLandscapeCardWindow a;
    public final DataCenter b;

    public v(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
        this.a = new WelfareLandscapeCardWindow(r2);
    }
}
