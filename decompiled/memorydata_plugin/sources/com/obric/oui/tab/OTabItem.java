package com.obric.oui.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class OTabItem extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CharSequence f14524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Drawable f14525b;
    final int c;

    public OTabItem(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public OTabItem(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        TintTypedArray r7 = TintTypedArray.obtainStyledAttributes(r5, r6, R.styleable.OTabItem);
        this.f14524a = r7.getText(ZeusTransformUtils.mapRes(R.styleable.OTabItem_android_text, "styleable", "OTabItem_android_text"));
        this.f14525b = r7.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OTabItem_android_icon, "styleable", "OTabItem_android_icon"));
        this.c = r7.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OTabItem_android_layout, "styleable", "OTabItem_android_layout"), 0);
        r7.recycle();
    }
}
