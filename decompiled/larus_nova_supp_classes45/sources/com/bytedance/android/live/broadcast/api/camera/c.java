package com.bytedance.android.live.broadcast.api.camera;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements l00.d.a {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    @Override // l00.d.a
    public final void onFail(String r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        ALogger.i("CameraDirtyCheckController", "download fail,error:" + r3);
    }

    @Override // l00.d.a
    public final void onSuccess(String r3) {
        Intrinsics.checkNotNullParameter(r3, "path");
        ALogger.i("CameraDirtyCheckController", "download success,path:" + r3);
        a r0 = this.a;
        r0.d = r3;
        r0.e.O0(r0.b, r3);
    }
}
