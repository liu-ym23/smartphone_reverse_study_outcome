package com.larus.uaigc.music.template;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    public o(ConstraintLayout r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r8) {
        this.a.removeOnAttachStateChangeListener(this);
        WindowInsetsCompat r0 = ViewCompat.getRootWindowInsets(r8);
        if (r0 == null) goto L7;
        Insets r1 = r0.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r1 == null) goto L7;
        int r2 = r1.bottom;
    L8:
        int r3 = r8.getPaddingStart();
        int r4 = r8.getPaddingTop();
        int r5 = r8.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r8.getClass().getSimpleName() + ",source:resetPadding,start:" + r3 + ",top:" + r4 + ",end:" + r5 + ",bottom:" + r2);
        r8.setPaddingRelative(r3, r4, r5, r2);
        return;
    L7:
        r2 = 0;
        goto L8
    }
}
