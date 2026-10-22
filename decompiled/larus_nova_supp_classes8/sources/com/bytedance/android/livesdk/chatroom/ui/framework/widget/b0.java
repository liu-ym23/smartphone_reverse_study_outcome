package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b0 extends dmc.e {
    public final /* synthetic */ LiveScheduleMessageWidget d;
    public final /* synthetic */ Set e;

    public final void onMessage(tlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.d.wq();
    }

    public b0(LiveScheduleMessageWidget r1, Set r2, Set r3, Set r4, dmc.d r5) {
        this.d = r1;
        this.e = r2;
        super(r3, r4, r5);
    }
}
