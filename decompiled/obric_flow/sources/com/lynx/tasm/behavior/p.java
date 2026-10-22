package com.lynx.tasm.behavior;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import androidx.core.view.accessibility.AccessibilityEventCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends Dialog {
    public static Activity b(Context r5) {
        if ((r5 instanceof Activity) == false) goto L7;
        return (Activity) r5;
    L7:
        if ((r5 instanceof ContextWrapper) == false) goto L11;
        return b(((ContextWrapper) r5).getBaseContext());
    L11:
        throw new IllegalArgumentException();
    }

    public final int a() {
        DisplayMetrics r5 = new DisplayMetrics();
        Display r10 = getWindow().getWindowManager().getDefaultDisplay();
        Point r11 = new Point();
        Point r12 = new Point();
        r10.getCurrentSizeRange(r11, r12);
        r10.getMetrics(r5);
        int r13 = r5.heightPixels;
        int r14 = r10.getRotation();
        if (r14 != 0) goto L5;
    L8:
        int r15 = r12.y;
        if (r15 >= r13) goto L11;
        r13 = r15;
    L11:
        int r16 = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r16 <= 0) goto L14;
        int r17 = getContext().getResources().getDimensionPixelSize(r16);
    L16:
        return r13 + r17;
    L14:
        r17 = 0;
        goto L16
    L5:
        if (r14 == 2) goto L8;
        return r13;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        getWindow().setGravity(3);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(2, -1);
        getWindow().setSoftInputMode(16);
        getWindow().addFlags(32);
        getWindow().addFlags(8);
        getWindow().addFlags(131072);
        getWindow().clearFlags(2);
        getWindow().clearFlags(1024);
        getWindow().clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        getWindow().clearFlags(256);
        getWindow().clearFlags(134217728);
        getWindow().getDecorView().setSystemUiVisibility(0);
        getWindow().getDecorView().setOutlineProvider(null);
        getWindow().getDecorView().setElevation(0.0f);
        getWindow().getDecorView().setTranslationZ(0.0f);
    }
}
