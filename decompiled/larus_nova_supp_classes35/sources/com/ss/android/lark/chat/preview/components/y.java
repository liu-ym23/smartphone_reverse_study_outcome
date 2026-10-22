package com.ss.android.lark.chat.preview.components;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class y implements View.OnAttachStateChangeListener {
    public y() {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        CircularProgressDrawable r1 = null;
        if ((r3 instanceof ImageView) == false) goto L5;
        ImageView r4 = (ImageView) r3;
    L6:
        if (r4 == null) goto L8;
        Drawable r5 = r4.getDrawable();
    L10:
        if ((r5 instanceof CircularProgressDrawable) == false) goto L12;
        r1 = (CircularProgressDrawable) r5;
    L12:
        if (r1 != null) goto L15;
        return;
    L15:
        if (r1.isRunning() == true) goto L18;
        r1.start();
        return;
    L18:
        return;
    L8:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        CircularProgressDrawable r1 = null;
        if ((r3 instanceof ImageView) == false) goto L5;
        ImageView r4 = (ImageView) r3;
    L6:
        if (r4 == null) goto L8;
        Drawable r5 = r4.getDrawable();
    L10:
        if ((r5 instanceof CircularProgressDrawable) == false) goto L12;
        r1 = (CircularProgressDrawable) r5;
    L12:
        if (r1 == null) goto L15;
        r1.stop();
        return;
    L15:
        return;
    L8:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
