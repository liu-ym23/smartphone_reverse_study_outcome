package com.lynx.lottieadapter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.util.AnimaXLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LottieAdapterAnimaX$l implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ LottieAdapterAnimaX b;

    public final void a() {
        Drawable r0 = AppCompatResources.getDrawable(LottieAdapterAnimaX.access$1400(this.b), this.a);     // Catch: Resources.NotFoundException -> L6
        if (r0 == null) goto L10;
        LottieAdapterAnimaX.access$1500(this.b, r0);     // Catch: Resources.NotFoundException -> L6
        return;
    L10:
        return;
    L6:
        AnimaXLog.d("LottieAdapterAnimaX", "Image resource not found: " + this.a);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public LottieAdapterAnimaX$l(LottieAdapterAnimaX r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
