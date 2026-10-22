package com.obric.oui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class OTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected TextView f14756b;

    public OTitleBar(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    public OTitleBar(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public OTitleBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r6, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
        if (getBackground() != null) goto L6;
        setBackgroundColor(ContextCompat.getColor(r6, ZeusTransformUtils.mapRes(R.color.BGPrimary, TypedValues.Custom.S_COLOR, "BGPrimary")));
        return;
    }

    public TextView getTitleView() {
        return this.f14756b;
    }

    public abstract void setDividerLineBackground(int r1);

    public void setTitle(int r1) {
        TextView r0 = this.f14756b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setText(r1);
    }

    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        TextView r2 = this.f14756b;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.setText(r4);
    }

    public void setTitleColor(int r1) {
        TextView r0 = this.f14756b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTextColor(r1);
    }

    public void setTitleSize(float r1) {
        TextView r0 = this.f14756b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTextSize(r1);
    }

    public void setTitleSizePixel(float r2) {
        TextView r1 = this.f14756b;
        if (r1 != null) goto L5;
        return;
    L5:
        r1.setTextSize(0, r2);
    }
}
