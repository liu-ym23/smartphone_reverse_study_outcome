package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements Runnable {
    public final /* synthetic */ TextView a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(AutoEllipsesTextView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.a.getLineCount() != 1) goto L9;
        TextView r0 = this.a;     // Catch: Throwable -> L6
        r0.setPadding(r0.getPaddingLeft(), this.a.getPaddingTop(), UtilityKotlinExtentionsKt.i(3), this.a.getPaddingBottom());     // Catch: Throwable -> L6
        return;
    }
}
