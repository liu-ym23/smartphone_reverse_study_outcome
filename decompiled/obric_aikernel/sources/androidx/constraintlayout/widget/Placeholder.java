package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes.dex */
public class Placeholder extends View {
    private View mContent;
    private int mContentId;
    private int mEmptyVisibility;

    public Placeholder(Context r10) {
        super(r10);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(null);
    }

    public Placeholder(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(r11);
    }

    public Placeholder(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(r11);
    }

    public Placeholder(Context r10, AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(r11);
    }

    private void init(AttributeSet r10) {
        super.setVisibility(this.mEmptyVisibility);
        this.mContentId = -1;
        if (r10 == null) goto L19;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R.styleable.ConstraintLayout_placeholder);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L13;
        int r14 = r11.getIndex(r13);
        if (r14 != R.styleable.ConstraintLayout_placeholder_content) goto L10;
        this.mContentId = r11.getResourceId(r14, this.mContentId);
    L12:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R.styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) goto L12;
        this.mEmptyVisibility = r11.getInt(r14, this.mEmptyVisibility);
        goto L12
    L13:
        r11.recycle();
        return;
    }

    public View getContent() {
        return this.mContent;
    }

    public int getEmptyVisibility() {
        return this.mEmptyVisibility;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        if (isInEditMode() == false) goto L6;
        r10.drawRGB(223, 223, 223);
        Paint r11 = new Paint();
        r11.setARGB(255, 210, 210, 210);
        r11.setTextAlign(Paint.Align.CENTER);
        r11.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        Rect r12 = new Rect();
        r10.getClipBounds(r12);
        r11.setTextSize(r12.height());
        int r13 = r12.height();
        int r14 = r12.width();
        r11.setTextAlign(Paint.Align.LEFT);
        r11.getTextBounds("?", 0, 1, r12);
        r10.drawText("?", ((r14 / 2.0f) - (r12.width() / 2.0f)) - r12.left, ((r13 / 2.0f) + (r12.height() / 2.0f)) - r12.bottom, r11);
        return;
    }

    public void setContentId(int r10) {
        if (this.mContentId != r10) goto L5;
        return;
    L5:
        View r11 = this.mContent;
        if (r11 == null) goto L8;
        r11.setVisibility(0);
        ((ConstraintLayout.LayoutParams) this.mContent.getLayoutParams()).isInPlaceholder = false;
        this.mContent = null;
    L8:
        this.mContentId = r10;
        if (r10 == (-1)) goto L14;
        View r12 = ((View) getParent()).findViewById(r10);
        if (r12 == null) goto L15;
        r12.setVisibility(8);
        return;
    L15:
        return;
    }

    public void setEmptyVisibility(int r10) {
        this.mEmptyVisibility = r10;
    }

    public void updatePostMeasure(ConstraintLayout r10) {
        if (this.mContent != null) goto L5;
        return;
    L5:
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) this.mContent.getLayoutParams();
        r12.widget.setVisibility(0);
        ConstraintWidget.DimensionBehaviour r13 = r11.widget.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r13 == r14) goto L9;
        r11.widget.setWidth(r12.widget.getWidth());
    L9:
        if (r11.widget.getVerticalDimensionBehaviour() == r14) goto L11;
        r11.widget.setHeight(r12.widget.getHeight());
    L11:
        r12.widget.setVisibility(8);
    }

    public void updatePreLayout(ConstraintLayout r10) {
        if (this.mContentId == (-1)) goto L5;
    L7:
        View r11 = r10.findViewById(this.mContentId);
        this.mContent = r11;
        if (r11 == null) goto L11;
        ((ConstraintLayout.LayoutParams) r11.getLayoutParams()).isInPlaceholder = true;
        this.mContent.setVisibility(0);
        setVisibility(0);
        return;
    L11:
        return;
    L5:
        if (isInEditMode() == true) goto L7;
        setVisibility(this.mEmptyVisibility);
        goto L7
    }
}
