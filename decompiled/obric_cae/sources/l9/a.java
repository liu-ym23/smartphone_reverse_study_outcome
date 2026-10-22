package l9;

import aa.j;
import aa.n;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public class a extends CardView implements Checkable, n {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int[] f9186s = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f9187r;

    /* JADX INFO: renamed from: l9.a$a, reason: collision with other inner class name */
    public interface InterfaceC0112a {
    }

    static {
        f9186s = new int[]{R.attr.state_dragged};
    }

    private RectF getBoundsAsRectF() {
        new RectF();
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        throw null;
    }

    public ColorStateList getCardForegroundColor() {
        throw null;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        throw null;
    }

    public int getCheckedIconGravity() {
        throw null;
    }

    public int getCheckedIconMargin() {
        throw null;
    }

    public int getCheckedIconSize() {
        throw null;
    }

    public ColorStateList getCheckedIconTint() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        throw null;
    }

    public float getProgress() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        throw null;
    }

    public ColorStateList getRippleColor() {
        throw null;
    }

    public j getShapeAppearanceModel() {
        throw null;
    }

    @Deprecated
    public int getStrokeColor() {
        throw null;
    }

    public ColorStateList getStrokeColorStateList() {
        throw null;
    }

    public int getStrokeWidth() {
        throw null;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int r8) {
        int[] r10 = super.onCreateDrawableState(r8 + 3);
        if (this.f9187r == false) goto L5;
        FrameLayout.mergeDrawableStates(r10, f9186s);
    L5:
        return r10;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r8) {
        super.onInitializeAccessibilityEvent(r8);
        r8.setClassName("androidx.cardview.widget.CardView");
        r8.setChecked(false);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r8) {
        super.onInitializeAccessibilityNodeInfo(r8);
        r8.setClassName("androidx.cardview.widget.CardView");
        r8.setCheckable(false);
        r8.setClickable(isClickable());
        r8.setChecked(false);
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
        getMeasuredWidth();
        getMeasuredHeight();
        throw null;
    }

    @Override // android.view.View
    public void setBackground(Drawable r8) {
        setBackgroundDrawable(r8);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r8) {
    }

    public void setBackgroundInternal(Drawable r8) {
        super.setBackgroundDrawable(r8);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int r8) {
        ColorStateList.valueOf(r8);
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float r8) {
        super.setCardElevation(r8);
        throw null;
    }

    public void setCardForegroundColor(ColorStateList r8) {
        throw null;
    }

    public void setCheckable(boolean r8) {
        throw null;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r8) {
    }

    public void setCheckedIcon(Drawable r8) {
        throw null;
    }

    public void setCheckedIconGravity(int r8) {
        throw null;
    }

    public void setCheckedIconMargin(int r8) {
        throw null;
    }

    public void setCheckedIconMarginResource(int r8) {
        if (r8 != (-1)) goto L5;
        return;
    L5:
        getResources().getDimensionPixelSize(r8);
        throw null;
    }

    public void setCheckedIconResource(int r8) {
        d.a.a(getContext(), r8);
        throw null;
    }

    public void setCheckedIconSize(int r8) {
        throw null;
    }

    public void setCheckedIconSizeResource(int r8) {
        if (r8 != 0) goto L4;
        return;
    L4:
        getResources().getDimensionPixelSize(r8);
        throw null;
    }

    public void setCheckedIconTint(ColorStateList r8) {
        throw null;
    }

    @Override // android.view.View
    public void setClickable(boolean r8) {
        super.setClickable(r8);
    }

    public void setDragged(boolean r8) {
        if (this.f9187r != r8) goto L5;
        return;
    L5:
        this.f9187r = r8;
        refreshDrawableState();
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float r8) {
        super.setMaxCardElevation(r8);
        throw null;
    }

    public void setOnCheckedChangeListener(InterfaceC0112a r8) {
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean r8) {
        super.setPreventCornerOverlap(r8);
        throw null;
    }

    public void setProgress(float r8) {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float r8) {
        super.setRadius(r8);
        throw null;
    }

    public void setRippleColor(ColorStateList r8) {
        throw null;
    }

    public void setRippleColorResource(int r8) {
        androidx.core.content.a.b(getContext(), r8);
        throw null;
    }

    @Override // aa.n
    public void setShapeAppearanceModel(j r8) {
        setClipToOutline(r8.d(getBoundsAsRectF()));
        throw null;
    }

    public void setStrokeColor(int r8) {
        setStrokeColor(ColorStateList.valueOf(r8));
    }

    public void setStrokeWidth(int r8) {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean r8) {
        super.setUseCompatPadding(r8);
        throw null;
    }

    @Override // android.widget.Checkable
    public final void toggle() {
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList r8) {
        throw null;
    }

    public void setStrokeColor(ColorStateList r8) {
        throw null;
    }
}
