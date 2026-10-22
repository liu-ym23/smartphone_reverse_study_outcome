package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class TabItem extends View {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f3813c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Drawable f3814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3815h;

    public TabItem(Context r10) {
        this(r10, null);
    }

    public TabItem(Context r10, AttributeSet r11) {
        super(r10, r11);
        TintTypedArray r12 = TintTypedArray.obtainStyledAttributes(r10, r11, l.TabItem);
        this.f3813c = r12.getText(l.TabItem_android_text);
        this.f3814g = r12.getDrawable(l.TabItem_android_icon);
        this.f3815h = r12.getResourceId(l.TabItem_android_layout, 0);
        r12.recycle();
    }
}
