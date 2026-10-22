package com.bytedance.android.live.livepkaudience.widget;

import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements qh0.d<rh0.a> {
    public c() {
    }

    @Override // qh0.d
    public final void b(BaseCheckException r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        if (r2.getCheckType() != BaseCheckException.CheckType.ServerPermission) goto L6;
        com.bytedance.android.livesdk.sharedpref.e r3 = b6.c;
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, 2);
        return;
    }

    @Override // qh0.d
    public final /* bridge */ /* synthetic */ void onResult(rh0.a r1) {
    }
}
