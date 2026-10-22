package com.larus.search.impl.global;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    public s(View r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r8) {
        this.a.removeOnAttachStateChangeListener(this);
        WindowInsetsCompat r0 = ViewCompat.getRootWindowInsets(r8);
        int r1 = 0;
        if (r0 == null) goto L7;
        Insets r2 = r0.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r2 == null) goto L7;
        int r3 = r2.bottom;
    L8:
        WindowInsetsCompat r4 = ViewCompat.getRootWindowInsets(r8);
        if (r4 == null) goto L13;
        Insets r5 = r4.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r5 == null) goto L13;
        r1 = r5.top;
    L13:
        int r6 = r8.getPaddingStart();
        int r7 = r8.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r8.getClass().getSimpleName() + ",source:resetPadding,start:" + r6 + ",top:" + r1 + ",end:" + r7 + ",bottom:" + r3);
        r8.setPaddingRelative(r6, r1, r7, r3);
        return;
    L7:
        r3 = 0;
        goto L8
    }
}
