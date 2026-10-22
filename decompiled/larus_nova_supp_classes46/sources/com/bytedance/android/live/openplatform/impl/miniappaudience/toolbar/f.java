package com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ HybridDialog a;

    public f(HybridDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        this.a.sendJsEvent("microapp_onShelfInfoUpdated", UtilsKt.h(GsonProtectorUtils.toJsonTree(GsonHelper.get(), sh6.c.b((sh6.b) r3))));
    }
}
