package com.bytedance.android.ec.adapter.impl.adapters.browser;

import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements IECBridgeMethod.b {
    public final /* synthetic */ f a;

    public d(f r1) {
        this.a = r1;
    }

    public final void onComplete(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        this.a.finishWithResult(r10);
    }

    public final void onError(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_MSG);
        this.a.finishWithFailure(new Throwable(r11));
    }
}
