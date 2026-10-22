package com.bytedance.android.live.liveinteract.service;

import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements gd0.c {
    public final /* synthetic */ DataCenter a;

    @Override // gd0.c
    public final void onCancelClick() {
    }

    public n(DataCenter r1) {
        this.a = r1;
    }

    @Override // gd0.c
    public final void a(LiveDialogFragment r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        DataCenter r4 = this.a;
        if (r4 == null) goto L6;
        r4.put("data_voice_chat_room_close_page", "link_panel");
        return;
    }
}
