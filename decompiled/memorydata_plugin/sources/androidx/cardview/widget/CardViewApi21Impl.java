package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class CardViewApi21Impl implements CardViewImpl {
    CardViewApi21Impl() {
    }

    private RoundRectDrawable getCardBackground(CardViewDelegate r2) {
        return (RoundRectDrawable) ZeusTransformUtils.preCheckCast(((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r2, CardViewDelegate.class, "com.obric.memorydata.plugin")).getCardBackground(), RoundRectDrawable.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList getBackgroundColor(CardViewDelegate r3) {
        return getCardBackground((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin")).getColor();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getElevation(CardViewDelegate r2) {
        return ((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r2, CardViewDelegate.class, "com.obric.memorydata.plugin")).getCardView().getElevation();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMaxElevation(CardViewDelegate r3) {
        return getCardBackground((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin")).getPadding();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinHeight(CardViewDelegate r3) {
        return getRadius((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin")) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinWidth(CardViewDelegate r3) {
        return getRadius((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin")) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getRadius(CardViewDelegate r3) {
        return getCardBackground((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin")).getRadius();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initStatic() {
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initialize(CardViewDelegate r3, Context r4, ColorStateList r5, float r6, float r7, float r8) {
        CardViewDelegate r9 = (CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin");
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        r9.setCardBackground(new RoundRectDrawable(r5, r6));
        View r11 = r9.getCardView();
        r11.setClipToOutline(true);
        r11.setElevation(r7);
        setMaxElevation(r9, r8);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onCompatPaddingChanged(CardViewDelegate r3) {
        CardViewDelegate r4 = (CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin");
        setMaxElevation(r4, getMaxElevation(r4));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onPreventCornerOverlapChanged(CardViewDelegate r3) {
        CardViewDelegate r4 = (CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin");
        setMaxElevation(r4, getMaxElevation(r4));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setBackgroundColor(CardViewDelegate r3, ColorStateList r4) {
        getCardBackground((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin")).setColor(r4);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setElevation(CardViewDelegate r2, float r3) {
        ((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r2, CardViewDelegate.class, "com.obric.memorydata.plugin")).getCardView().setElevation(r3);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setMaxElevation(CardViewDelegate r4, float r5) {
        CardViewDelegate r6 = (CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r4, CardViewDelegate.class, "com.obric.memorydata.plugin");
        getCardBackground(r6).setPadding(r5, r6.getUseCompatPadding(), r6.getPreventCornerOverlap());
        updatePadding(r6);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setRadius(CardViewDelegate r3, float r4) {
        getCardBackground((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin")).setRadius(r4);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void updatePadding(CardViewDelegate r5) {
        CardViewDelegate r6 = (CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r5, CardViewDelegate.class, "com.obric.memorydata.plugin");
        if (r6.getUseCompatPadding() == true) goto L6;
        r6.setShadowPadding(0, 0, 0, 0);
        return;
    L6:
        float r0 = getMaxElevation(r6);
        float r4 = getRadius(r6);
        int r1 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(r0, r4, r6.getPreventCornerOverlap()));
        int r7 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(r0, r4, r6.getPreventCornerOverlap()));
        r6.setShadowPadding(r1, r7, r1, r7);
    }
}
