package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o {
    public final kh0.a a;
    public final DataCenter b;

    public static final class a {
    }

    static {
    }

    public o(boolean r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter("multi_seat_widget", "panelId");
        this.b = r4;
        this.a = new kh0.a(r3, null, "multi_seat_widget", null);
    }
}
