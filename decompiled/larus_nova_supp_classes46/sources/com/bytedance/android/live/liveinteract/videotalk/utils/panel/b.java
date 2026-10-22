package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements com.bytedance.android.live.liveinteract.plantform.camera.a {
    public final /* synthetic */ ih0.h a;

    @Override // com.bytedance.android.live.liveinteract.plantform.camera.a
    public final void onSuccess() {
        this.a.a(UpdateLinkmicStatusResultModel.Code.Success, "interact_panel_click#camera_operation self success", null);
        a.j.dismissDialog();
    }

    public b(ih0.h r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.camera.a
    public final void onError(Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        this.a.a(UpdateLinkmicStatusResultModel.Code.Failed, "interact_panel_click#camera_operation self fail", null);
    }
}
