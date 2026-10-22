package com.ss.android.lark.keyboard.utils;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h {
    public static View b(Context r4) {
        ImageView r0 = new ImageView(r4);
        r0.setId(2131364828);
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 8388629;
        int r2 = UIUtils.getDimens(r4, 2131166602);
        int r3 = UIUtils.getDimens(r4, 2131166599);
        r0.setLayoutParams(r1);
        r0.setImageDrawable(ContextCompat.getDrawable(r4, 2131255630));
        r0.setImageTintList(UIUtils.getColorStateList(r4, 2131102496));
        r0.setEnabled(false);
        r0.setClickable(true);
        r0.setPadding(r3, r2, 0, r2);
        return r0;
    }

    public static AppCompatImageView a(Context r1, int r2, int r3) {
        AppCompatImageView r0 = new AppCompatImageView(r1);
        r0.setId(r2);
        r0.setImageDrawable(AppCompatResources.getDrawable(r1, r3));
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-2, -2);
        r4.gravity = 16;
        r0.setClickable(true);
        r0.setFocusable(true);
        r0.setLayoutParams(r4);
        return r0;
    }
}
