package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ ih0.h a;

    public p(ih0.h r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        ih0.h r0 = this.a;
        UpdateLinkmicStatusResultModel.Code r1 = UpdateLinkmicStatusResultModel.Code.Success;
        r0.a(r1, "", (JsonObject) r4);
    }
}
