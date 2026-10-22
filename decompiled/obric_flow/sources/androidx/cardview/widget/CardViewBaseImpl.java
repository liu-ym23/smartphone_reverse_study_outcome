package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class CardViewBaseImpl implements CardViewImpl {
    final RectF mCornerRect;

    public CardViewBaseImpl() {
        this.mCornerRect = new RectF();
    }

    private RoundRectDrawableWithShadow createBackground(Context r10, ColorStateList r11, float r12, float r13, float r14) {
        return new RoundRectDrawableWithShadow(r10.getResources(), r11, r12, r13, r14);
    }

    private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate r5) {
        return (RoundRectDrawableWithShadow) r5.getCardBackground();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList getBackgroundColor(CardViewDelegate r5) {
        return getShadowBackground(r5).getColor();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getElevation(CardViewDelegate r5) {
        return getShadowBackground(r5).getShadowSize();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMaxElevation(CardViewDelegate r5) {
        return getShadowBackground(r5).getMaxShadowSize();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinHeight(CardViewDelegate r5) {
        return getShadowBackground(r5).getMinHeight();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinWidth(CardViewDelegate r5) {
        return getShadowBackground(r5).getMinWidth();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getRadius(CardViewDelegate r5) {
        return getShadowBackground(r5).getCornerRadius();
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
    public void onCompatPaddingChanged(CardViewDelegate r5) {
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onPreventCornerOverlapChanged(CardViewDelegate r5) {
        getShadowBackground(r5).setAddPaddingForCorners(r5.getPreventCornerOverlap());
        updatePadding(r5);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setBackgroundColor(CardViewDelegate r5, @Nullable ColorStateList r10) {
        getShadowBackground(r5).setColor(r10);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setElevation(CardViewDelegate r5, float r10) {
        getShadowBackground(r5).setShadowSize(r10);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setMaxElevation(CardViewDelegate r5, float r10) {
        getShadowBackground(r5).setMaxShadowSize(r10);
        updatePadding(r5);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setRadius(CardViewDelegate r5, float r10) {
        getShadowBackground(r5).setCornerRadius(r10);
        updatePadding(r5);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void updatePadding(CardViewDelegate r5) {
        Rect r10 = new Rect();
        getShadowBackground(r5).getMaxShadowAndCornerPadding(r10);
        r5.setMinWidthHeightInternal((int) Math.ceil(getMinWidth(r5)), (int) Math.ceil(getMinHeight(r5)));
        r5.setShadowPadding(r10.left, r10.top, r10.right, r10.bottom);
    }
}
