package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements Runnable {
    public final /* synthetic */ GiftMVIDetailView a;

    public m(GiftMVIDetailView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GiftMVIDetailView r0 = this.a;     // Catch: Throwable -> L7
        TextView r1 = r0.p;     // Catch: Throwable -> L7
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDynamicInfo");     // Catch: Throwable -> L7
    L5:
        GiftMVIDetailView.t(r0, r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
