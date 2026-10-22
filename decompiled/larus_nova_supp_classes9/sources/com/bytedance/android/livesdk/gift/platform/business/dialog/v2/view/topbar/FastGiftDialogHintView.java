package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class FastGiftDialogHintView extends FrameLayout {
    public TextView a;
    public TextView b;
    public TextView c;
    public CheckBox d;

    public FastGiftDialogHintView(Context r2) {
        this(r2, null);
    }

    public FastGiftDialogHintView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public FastGiftDialogHintView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LayoutInflater.from(getContext()).inflate(2131565960, this);
        this.a = (TextView) findViewById(2131365427);
        this.b = (TextView) findViewById(2131365407);
        this.c = (TextView) findViewById(2131365405);
        this.d = (CheckBox) findViewById(2131365404);
    }
}
