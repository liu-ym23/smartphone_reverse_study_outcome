package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class CardViewBaseImpl implements CardViewImpl {
    final RectF mCornerRect;

    CardViewBaseImpl() {
        this.mCornerRect = new RectF();
    }

    private RoundRectDrawableWithShadow createBackground(Context r8, ColorStateList r9, float r10, float r11, float r12) {
        return new RoundRectDrawableWithShadow(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin"), r9, r10, r11, r12);
    }

    private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate r2) {
        return (RoundRectDrawableWithShadow) ZeusTransformUtils.preCheckCast(((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r2, CardViewDelegate.class, "com.obric.memorydata.plugin")).getCardBackground(), RoundRectDrawableWithShadow.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList getBackgroundColor(CardViewDelegate r3) {
        return getShadowBackground((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin")).getColor();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getElevation(CardViewDelegate r3) {
        return getShadowBackground((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin")).getShadowSize();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMaxElevation(CardViewDelegate r3) {
        return getShadowBackground((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin")).getMaxShadowSize();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinHeight(CardViewDelegate r3) {
        return getShadowBackground((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin")).getMinHeight();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinWidth(CardViewDelegate r3) {
        return getShadowBackground((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin")).getMinWidth();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getRadius(CardViewDelegate r3) {
        return getShadowBackground((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin")).getCornerRadius();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new AnonymousClass1(this);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initialize(CardViewDelegate r7, Context r8, ColorStateList r9, float r10, float r11, float r12) {
        CardViewDelegate r13 = (CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r7, CardViewDelegate.class, "com.obric.memorydata.plugin");
        RoundRectDrawableWithShadow r14 = createBackground((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin"), r9, r10, r11, r12);
        r14.setAddPaddingForCorners(r13.getPreventCornerOverlap());
        r13.setCardBackground(r14);
        updatePadding(r13);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onCompatPaddingChanged(CardViewDelegate r2) {
        CardViewDelegate r1 = (CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r2, CardViewDelegate.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onPreventCornerOverlapChanged(CardViewDelegate r3) {
        CardViewDelegate r4 = (CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin");
        getShadowBackground(r4).setAddPaddingForCorners(r4.getPreventCornerOverlap());
        updatePadding(r4);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setBackgroundColor(CardViewDelegate r3, ColorStateList r4) {
        getShadowBackground((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin")).setColor(r4);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setElevation(CardViewDelegate r3, float r4) {
        getShadowBackground((CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin")).setShadowSize(r4);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setMaxElevation(CardViewDelegate r3, float r4) {
        CardViewDelegate r5 = (CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin");
        getShadowBackground(r5).setMaxShadowSize(r4);
        updatePadding(r5);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setRadius(CardViewDelegate r3, float r4) {
        CardViewDelegate r5 = (CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r3, CardViewDelegate.class, "com.obric.memorydata.plugin");
        getShadowBackground(r5).setCornerRadius(r4);
        updatePadding(r5);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void updatePadding(CardViewDelegate r5) {
        CardViewDelegate r6 = (CardViewDelegate) ZeusTransformUtils.wrapperContextForParams(r5, CardViewDelegate.class, "com.obric.memorydata.plugin");
        Rect r0 = new Rect();
        getShadowBackground(r6).getMaxShadowAndCornerPadding(r0);
        r6.setMinWidthHeightInternal((int) Math.ceil(getMinWidth(r6)), (int) Math.ceil(getMinHeight(r6)));
        r6.setShadowPadding(r0.left, r0.top, r0.right, r0.bottom);
    }
}
