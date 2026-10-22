package com.bytedance.android.live.liveinteract.animation.universalwidget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements qh0.d<rh0.a> {
    public final /* synthetic */ Function0 a;

    public c(Function0 r1) {
        this.a = r1;
    }

    @Override // qh0.d
    public final void b(BaseCheckException r3) {
        Intrinsics.checkNotNullParameter(r3, "exception");
        ALogger.d("MultiLinkEffect.Widget", "check failed, exception: " + r3.getDetailMessage());
    }

    @Override // qh0.d
    public final void onResult(rh0.a r2) {
        ALogger.d("MultiLinkEffect.Widget", "check success");
        this.a.invoke();
    }
}
