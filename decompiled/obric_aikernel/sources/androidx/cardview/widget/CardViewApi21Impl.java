package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class CardViewApi21Impl implements CardViewImpl {
    CardViewApi21Impl() {
    }

    private RoundRectDrawable getCardBackground(CardViewDelegate r10) {
        return (RoundRectDrawable) r10.getCardBackground();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList getBackgroundColor(CardViewDelegate r10) {
        return getCardBackground(r10).getColor();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getElevation(CardViewDelegate r10) {
        return r10.getCardView().getElevation();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMaxElevation(CardViewDelegate r10) {
        return getCardBackground(r10).getPadding();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinHeight(CardViewDelegate r10) {
        return getRadius(r10) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinWidth(CardViewDelegate r10) {
        return getRadius(r10) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getRadius(CardViewDelegate r10) {
        return getCardBackground(r10).getRadius();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initStatic() {
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initialize(CardViewDelegate r10, Context r11, ColorStateList r12, float r13, float r14, float r15) {
        r10.setCardBackground(new RoundRectDrawable(r12, r13));
        View r16 = r10.getCardView();
        r16.setClipToOutline(true);
        r16.setElevation(r14);
        setMaxElevation(r10, r15);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onCompatPaddingChanged(CardViewDelegate r10) {
        setMaxElevation(r10, getMaxElevation(r10));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onPreventCornerOverlapChanged(CardViewDelegate r10) {
        setMaxElevation(r10, getMaxElevation(r10));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setBackgroundColor(CardViewDelegate r10, @Nullable ColorStateList r11) {
        getCardBackground(r10).setColor(r11);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setElevation(CardViewDelegate r10, float r11) {
        r10.getCardView().setElevation(r11);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setMaxElevation(CardViewDelegate r10, float r11) {
        getCardBackground(r10).setPadding(r11, r10.getUseCompatPadding(), r10.getPreventCornerOverlap());
        updatePadding(r10);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setRadius(CardViewDelegate r10, float r11) {
        getCardBackground(r10).setRadius(r11);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void updatePadding(CardViewDelegate r10) {
        if (r10.getUseCompatPadding() == true) goto L6;
        r10.setShadowPadding(0, 0, 0, 0);
        return;
    L6:
        float r11 = getMaxElevation(r10);
        float r12 = getRadius(r10);
        int r13 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(r11, r12, r10.getPreventCornerOverlap()));
        int r14 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(r11, r12, r10.getPreventCornerOverlap()));
        r10.setShadowPadding(r13, r14, r13, r14);
    }
}
