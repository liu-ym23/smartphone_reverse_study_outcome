package com.obric.oui.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.obric.common.oui.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public final class OTabItem extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f14643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f14644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14645c;

    public OTabItem(Context r5) {
        this(r5, null);
    }

    @SuppressLint({"RestrictedApi"})
    public OTabItem(Context r5, AttributeSet r10) {
        super(r5, r10);
        TintTypedArray r11 = TintTypedArray.obtainStyledAttributes(r5, r10, R$styleable.OTabItem);
        this.f14643a = r11.getText(R$styleable.OTabItem_android_text);
        this.f14644b = r11.getDrawable(R$styleable.OTabItem_android_icon);
        this.f14645c = r11.getResourceId(R$styleable.OTabItem_android_layout, 0);
        r11.recycle();
    }
}
