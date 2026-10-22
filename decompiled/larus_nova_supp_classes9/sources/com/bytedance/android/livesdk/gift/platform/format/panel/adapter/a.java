package com.bytedance.android.livesdk.gift.platform.format.panel.adapter;

import android.os.SystemClock;
import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements Runnable {
    public final /* synthetic */ FormatGiftDialogViewPagerAdapter$createRecyclerView$$inlined$apply$lambda$1 a;

    public a(FormatGiftDialogViewPagerAdapter$createRecyclerView$$inlined$apply$lambda$1 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FormatGiftDialogViewPagerAdapter$createRecyclerView$$inlined$apply$lambda$1 r0 = this.a;     // Catch: Throwable -> L4
        r0.c = -1;     // Catch: Throwable -> L4
        r0.d.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
