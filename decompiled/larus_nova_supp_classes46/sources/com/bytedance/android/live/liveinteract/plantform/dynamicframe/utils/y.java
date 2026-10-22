package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y implements qh0.d<rh0.a> {
    public final /* synthetic */ ih0.h a;

    public y(com.bytedance.android.live.liveinteract.jsbridge.method.j r1) {
        this.a = r1;
    }

    @Override // qh0.d
    public final void b(BaseCheckException r4) {
        Intrinsics.checkNotNullParameter(r4, "exception");
        ALogger.i("PermissionUtils", "checkPermission onFailure, " + r4);
        this.a.a(UpdateLinkmicStatusResultModel.Code.Failed, "", null);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r4) {
        ALogger.i("PermissionUtils", "checkPermission onResult");
        this.a.a(UpdateLinkmicStatusResultModel.Code.Success, "checkPermission success", null);
    }
}
