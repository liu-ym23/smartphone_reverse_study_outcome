package com.larus.uaigc.chat.markdown.video.statemanager;

import com.larus.platform.api.IVideoController;
import com.larus.platform.api.l4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m implements l4 {
    public final /* synthetic */ nr9.g a;
    public final /* synthetic */ i b;

    public m(nr9.g r1, i r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.platform.api.l4
    public final void a(String r4, com.larus.video.impl.sdk.a r5) {
        if (Intrinsics.areEqual(this.a.b, r4) == false) goto L8;
        IVideoController r6 = this.b.i();
        if (r6 == null) goto L9;
        IVideoController.a.a(r6, r5, 30720000, 26);
        return;
    L9:
        return;
    }
}
