package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context r5) {
        this(r5, null);
    }

    public TabItem(Context r5, AttributeSet r10) {
        super(r5, r10);
        TintTypedArray r11 = TintTypedArray.obtainStyledAttributes(r5, r10, R.styleable.TabItem);
        this.text = r11.getText(R.styleable.TabItem_android_text);
        this.icon = r11.getDrawable(R.styleable.TabItem_android_icon);
        this.customLayout = r11.getResourceId(R.styleable.TabItem_android_layout, 0);
        r11.recycle();
    }
}
