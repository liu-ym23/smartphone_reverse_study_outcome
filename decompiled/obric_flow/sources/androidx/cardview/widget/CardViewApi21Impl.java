package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class CardViewApi21Impl implements CardViewImpl {
    public CardViewApi21Impl() {
    }

    private RoundRectDrawable getCardBackground(CardViewDelegate r5) {
        return (RoundRectDrawable) r5.getCardBackground();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList getBackgroundColor(CardViewDelegate r5) {
        return getCardBackground(r5).getColor();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getElevation(CardViewDelegate r5) {
        return r5.getCardView().getElevation();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMaxElevation(CardViewDelegate r5) {
        return getCardBackground(r5).getPadding();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinHeight(CardViewDelegate r5) {
        return getRadius(r5) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinWidth(CardViewDelegate r5) {
        return getRadius(r5) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getRadius(CardViewDelegate r5) {
        return getCardBackground(r5).getRadius();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initStatic() {
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initialize(CardViewDelegate r5, Context r10, ColorStateList r11, float r12, float r13, float r14) {
        r5.setCardBackground(new RoundRectDrawable(r11, r12));
        View r15 = r5.getCardView();
        r15.setClipToOutline(true);
        r15.setElevation(r13);
        setMaxElevation(r5, r14);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onCompatPaddingChanged(CardViewDelegate r5) {
        setMaxElevation(r5, getMaxElevation(r5));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onPreventCornerOverlapChanged(CardViewDelegate r5) {
        setMaxElevation(r5, getMaxElevation(r5));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setBackgroundColor(CardViewDelegate r5, @Nullable ColorStateList r10) {
        getCardBackground(r5).setColor(r10);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setElevation(CardViewDelegate r5, float r10) {
        r5.getCardView().setElevation(r10);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setMaxElevation(CardViewDelegate r5, float r10) {
        getCardBackground(r5).setPadding(r10, r5.getUseCompatPadding(), r5.getPreventCornerOverlap());
        updatePadding(r5);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setRadius(CardViewDelegate r5, float r10) {
        getCardBackground(r5).setRadius(r10);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void updatePadding(CardViewDelegate r5) {
        if (r5.getUseCompatPadding() == true) goto L6;
        r5.setShadowPadding(0, 0, 0, 0);
        return;
    L6:
        float r10 = getMaxElevation(r5);
        float r11 = getRadius(r5);
        int r12 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(r10, r11, r5.getPreventCornerOverlap()));
        int r13 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(r10, r11, r5.getPreventCornerOverlap()));
        r5.setShadowPadding(r12, r13, r12, r13);
    }
}
