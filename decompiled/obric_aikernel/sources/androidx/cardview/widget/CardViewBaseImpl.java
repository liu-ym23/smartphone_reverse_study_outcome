package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class CardViewBaseImpl implements CardViewImpl {
    final RectF mCornerRect;

    CardViewBaseImpl() {
        this.mCornerRect = new RectF();
    }

    private RoundRectDrawableWithShadow createBackground(Context r10, ColorStateList r11, float r12, float r13, float r14) {
        return new RoundRectDrawableWithShadow(r10.getResources(), r11, r12, r13, r14);
    }

    private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate r10) {
        return (RoundRectDrawableWithShadow) r10.getCardBackground();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList getBackgroundColor(CardViewDelegate r10) {
        return getShadowBackground(r10).getColor();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getElevation(CardViewDelegate r10) {
        return getShadowBackground(r10).getShadowSize();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMaxElevation(CardViewDelegate r10) {
        return getShadowBackground(r10).getMaxShadowSize();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinHeight(CardViewDelegate r10) {
        return getShadowBackground(r10).getMinHeight();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinWidth(CardViewDelegate r10) {
        return getShadowBackground(r10).getMinWidth();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getRadius(CardViewDelegate r10) {
        return getShadowBackground(r10).getCornerRadius();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new AnonymousClass1(this);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initialize(CardViewDelegate r10, Context r11, ColorStateList r12, float r13, float r14, float r15) {
        RoundRectDrawableWithShadow r16 = createBackground(r11, r12, r13, r14, r15);
        r16.setAddPaddingForCorners(r10.getPreventCornerOverlap());
        r10.setCardBackground(r16);
        updatePadding(r10);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onCompatPaddingChanged(CardViewDelegate r10) {
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onPreventCornerOverlapChanged(CardViewDelegate r10) {
        getShadowBackground(r10).setAddPaddingForCorners(r10.getPreventCornerOverlap());
        updatePadding(r10);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setBackgroundColor(CardViewDelegate r10, @Nullable ColorStateList r11) {
        getShadowBackground(r10).setColor(r11);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setElevation(CardViewDelegate r10, float r11) {
        getShadowBackground(r10).setShadowSize(r11);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setMaxElevation(CardViewDelegate r10, float r11) {
        getShadowBackground(r10).setMaxShadowSize(r11);
        updatePadding(r10);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setRadius(CardViewDelegate r10, float r11) {
        getShadowBackground(r10).setCornerRadius(r11);
        updatePadding(r10);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void updatePadding(CardViewDelegate r10) {
        Rect r11 = new Rect();
        getShadowBackground(r10).getMaxShadowAndCornerPadding(r11);
        r10.setMinWidthHeightInternal((int) Math.ceil(getMinWidth(r10)), (int) Math.ceil(getMinHeight(r10)));
        r10.setShadowPadding(r11.left, r11.top, r11.right, r11.bottom);
    }
}
