package com.larksuite.component.universe_design.toast;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface c {
    void cancel();

    boolean isShowing();

    void setIcon(int r1);

    void setIcon(Drawable r1);

    void setText(CharSequence r1);

    void show();
}
