package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes.dex */
public class Placeholder extends View {
    private View mContent;
    private int mContentId;
    private int mEmptyVisibility;

    public Placeholder(Context r5) {
        super(r5);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(null);
    }

    private void init(AttributeSet r5) {
        super.setVisibility(this.mEmptyVisibility);
        this.mContentId = -1;
        if (r5 == null) goto L19;
        TypedArray r10 = getContext().obtainStyledAttributes(r5, R.styleable.ConstraintLayout_placeholder);
        int r11 = r10.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L13;
        int r13 = r10.getIndex(r12);
        if (r13 != R.styleable.ConstraintLayout_placeholder_content) goto L10;
        this.mContentId = r10.getResourceId(r13, this.mContentId);
    L12:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r13 != R.styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) goto L12;
        this.mEmptyVisibility = r10.getInt(r13, this.mEmptyVisibility);
        goto L12
    L13:
        r10.recycle();
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
        Rect r5 = new Rect();
        r10.getClipBounds(r5);
        r11.setTextSize(r5.height());
        int r12 = r5.height();
        int r13 = r5.width();
        r11.setTextAlign(Paint.Align.LEFT);
        r11.getTextBounds("?", 0, 1, r5);
        r10.drawText("?", ((r13 / 2.0f) - (r5.width() / 2.0f)) - r5.left, ((r5.height() / 2.0f) + (r12 / 2.0f)) - r5.bottom, r11);
        return;
    }

    public void setContentId(int r5) {
        if (this.mContentId != r5) goto L5;
        return;
    L5:
        View r10 = this.mContent;
        if (r10 == null) goto L8;
        r10.setVisibility(0);
        ((ConstraintLayout.LayoutParams) this.mContent.getLayoutParams()).isInPlaceholder = false;
        this.mContent = null;
    L8:
        this.mContentId = r5;
        if (r5 == (-1)) goto L14;
        View r11 = ((View) getParent()).findViewById(r5);
        if (r11 == null) goto L15;
        r11.setVisibility(8);
        return;
    L15:
        return;
    }

    public void setEmptyVisibility(int r5) {
        this.mEmptyVisibility = r5;
    }

    public void updatePostMeasure(ConstraintLayout r5) {
        if (this.mContent != null) goto L5;
        return;
    L5:
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) this.mContent.getLayoutParams();
        r11.widget.setVisibility(0);
        ConstraintWidget.DimensionBehaviour r12 = r10.widget.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r13 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r12 == r13) goto L9;
        r10.widget.setWidth(r11.widget.getWidth());
    L9:
        if (r10.widget.getVerticalDimensionBehaviour() == r13) goto L11;
        r10.widget.setHeight(r11.widget.getHeight());
    L11:
        r11.widget.setVisibility(8);
    }

    public void updatePreLayout(ConstraintLayout r5) {
        if (this.mContentId == (-1)) goto L5;
    L7:
        View r10 = r5.findViewById(this.mContentId);
        this.mContent = r10;
        if (r10 == null) goto L11;
        ((ConstraintLayout.LayoutParams) r10.getLayoutParams()).isInPlaceholder = true;
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

    public Placeholder(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(r10);
    }

    public Placeholder(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(r10);
    }

    public Placeholder(Context r5, AttributeSet r10, int r11, int r12) {
        super(r5, r10, r11);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(r10);
    }
}
