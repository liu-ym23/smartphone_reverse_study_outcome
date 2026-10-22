package com.larus.uaigc.chat.block.widget.video;

import com.larus.platform.api.IVideoController;
import com.larus.platform.api.l4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j implements l4 {
    public final /* synthetic */ String a;
    public final /* synthetic */ LocalVideoSuccessViewBinder b;

    public j(String r1, LocalVideoSuccessViewBinder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.platform.api.l4
    public final void a(String r4, com.larus.video.impl.sdk.a r5) {
        if (Intrinsics.areEqual(this.a, r4) == false) goto L8;
        IVideoController r6 = this.b.e();
        if (r6 == null) goto L9;
        IVideoController.a.a(r6, r5, 30720000, 26);
        return;
    L9:
        return;
    }
}
