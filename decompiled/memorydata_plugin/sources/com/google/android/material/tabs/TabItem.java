package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class TabItem extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f4108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f4109b;
    public final int c;

    public TabItem(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public TabItem(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        TintTypedArray r7 = TintTypedArray.obtainStyledAttributes(r5, r6, R.styleable.TabItem);
        this.f4108a = r7.getText(ZeusTransformUtils.mapRes(R.styleable.TabItem_android_text, "styleable", "TabItem_android_text"));
        this.f4109b = r7.getDrawable(ZeusTransformUtils.mapRes(R.styleable.TabItem_android_icon, "styleable", "TabItem_android_icon"));
        this.c = r7.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TabItem_android_layout, "styleable", "TabItem_android_layout"), 0);
        r7.recycle();
    }
}
