package com.bytedance.android.livesdk.gift.biggift.view;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements Runnable {
    public final /* synthetic */ BigGiftComboDialog.c a;

    @Override // java.lang.Runnable
    public final void run() {
        FrameLayout r0 = this.a.a.a;     // Catch: Throwable -> L7
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mComboTrayView");     // Catch: Throwable -> L7
    L5:
        UtilityKotlinExtentionsKt.t(r0);     // Catch: Throwable -> L7
        this.a.a.d(BigGiftComboDialog.DismissType.NORMAL);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public d(BigGiftComboDialog.c r1) {
        this.a = r1;
    }
}
