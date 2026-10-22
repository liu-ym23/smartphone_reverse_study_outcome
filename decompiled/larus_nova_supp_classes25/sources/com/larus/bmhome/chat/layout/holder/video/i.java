package com.larus.bmhome.chat.layout.holder.video;

import com.larus.platform.api.IVideoController;
import com.larus.platform.api.l4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i implements l4 {
    public final /* synthetic */ String a;

    public i(String r1) {
        this.a = r1;
    }

    public final void a(String r4, com.larus.video.impl.sdk.a r5) {
        if (Intrinsics.areEqual(this.a, r4) == false) goto L8;
        IVideoController r6 = ps8.a.a.a(ps8.d.a, null, 7);
        if (r6 == null) goto L9;
        IVideoController.a.a(r6, r5, 30720000, 26);
        return;
    L9:
        return;
    }
}
