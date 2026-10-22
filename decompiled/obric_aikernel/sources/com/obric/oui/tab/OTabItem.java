package com.obric.oui.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
public final class OTabItem extends View {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final CharSequence f7510c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Drawable f7511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f7512h;

    public OTabItem(Context r10) {
        this(r10, null);
    }

    @SuppressLint({"RestrictedApi"})
    public OTabItem(Context r10, AttributeSet r11) {
        super(r10, r11);
        TintTypedArray r12 = TintTypedArray.obtainStyledAttributes(r10, r11, l.OTabItem);
        this.f7510c = r12.getText(l.OTabItem_android_text);
        this.f7511g = r12.getDrawable(l.OTabItem_android_icon);
        this.f7512h = r12.getResourceId(l.OTabItem_android_layout, 0);
        r12.recycle();
    }
}
