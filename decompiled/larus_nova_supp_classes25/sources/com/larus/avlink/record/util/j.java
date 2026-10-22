package com.larus.avlink.record.util;

import com.larus.avlink.n1;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j implements f09.a.b {
    public final /* synthetic */ String a;

    public final void onAllActivityDestroyed() {
    }

    public final void onAppBackground() {
    }

    public final void onAppForeground() {
        AppHost.a.a().c(this);
        if (Intrinsics.areEqual(LarkRecordMinutesManager.G, this) == false) goto L6;
        LarkRecordMinutesManager.G = null;
    L6:
        if (Intrinsics.areEqual(LarkRecordMinutesManager.A, this.a) == true) goto L9;
        n1.d("LarkRecordMinutesManager", "GRecord skip deferred open recording page, recording finished or changed, recordingId=" + this.a);
        return;
    L9:
        LarkRecordMinutesManager r0 = LarkRecordMinutesManager.a;
        String r1 = this.a;
        r0.getClass();
        LarkRecordMinutesManager.A(r1);
    }

    public j(String r1) {
        this.a = r1;
    }
}
