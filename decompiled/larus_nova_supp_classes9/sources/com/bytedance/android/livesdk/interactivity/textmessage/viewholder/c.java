package com.bytedance.android.livesdk.interactivity.textmessage.viewholder;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ TextView b;

    public c(f r1, TextView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (Intrinsics.areEqual(this.b.getTag(2131389787), this.a) == true) goto L5;
        return;
    L5:
        if (this.b.getLineCount() != 1) goto L15;
        TextView r0 = this.b;     // Catch: Throwable -> L8
        r0.setPadding(r0.getPaddingLeft(), this.b.getPaddingTop(), UtilityKotlinExtentionsKt.i(3), this.b.getPaddingBottom());     // Catch: Throwable -> L8
        return;
    }
}
