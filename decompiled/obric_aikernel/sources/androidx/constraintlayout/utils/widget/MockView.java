package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class MockView extends View {
    private int mDiagonalsColor;
    private boolean mDrawDiagonals;
    private boolean mDrawLabel;
    private int mMargin;
    private Paint mPaintDiagonals;
    private Paint mPaintText;
    private Paint mPaintTextBackground;
    protected String mText;
    private int mTextBackgroundColor;
    private Rect mTextBounds;
    private int mTextColor;

    public MockView(Context r10) {
        super(r10);
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(255, 0, 0, 0);
        this.mTextColor = Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(r10, null);
    }

    public MockView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(255, 0, 0, 0);
        this.mTextColor = Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(r10, r11);
    }

    public MockView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mPaintDiagonals = new Paint();
        this.mPaintText = new Paint();
        this.mPaintTextBackground = new Paint();
        this.mDrawDiagonals = true;
        this.mDrawLabel = true;
        this.mText = null;
        this.mTextBounds = new Rect();
        this.mDiagonalsColor = Color.argb(255, 0, 0, 0);
        this.mTextColor = Color.argb(255, 200, 200, 200);
        this.mTextBackgroundColor = Color.argb(255, 50, 50, 50);
        this.mMargin = 4;
        init(r10, r11);
    }

    private void init(Context r10, AttributeSet r11) {
        if (r11 == null) goto L26;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.MockView);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L24;
        int r15 = r12.getIndex(r14);
        if (r15 != R.styleable.MockView_mock_label) goto L9;
        this.mText = r12.getString(r15);
    L23:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r15 != R.styleable.MockView_mock_showDiagonals) goto L12;
        this.mDrawDiagonals = r12.getBoolean(r15, this.mDrawDiagonals);
        goto L23
    L12:
        if (r15 != R.styleable.MockView_mock_diagonalsColor) goto L15;
        this.mDiagonalsColor = r12.getColor(r15, this.mDiagonalsColor);
        goto L23
    L15:
        if (r15 != R.styleable.MockView_mock_labelBackgroundColor) goto L18;
        this.mTextBackgroundColor = r12.getColor(r15, this.mTextBackgroundColor);
        goto L23
    L18:
        if (r15 != R.styleable.MockView_mock_labelColor) goto L21;
        this.mTextColor = r12.getColor(r15, this.mTextColor);
        goto L23
    L21:
        if (r15 != R.styleable.MockView_mock_showLabel) goto L23;
        this.mDrawLabel = r12.getBoolean(r15, this.mDrawLabel);
        goto L23
    L24:
        r12.recycle();
    L26:
        if (this.mText == null) goto L31;
    L28:
        this.mPaintDiagonals.setColor(this.mDiagonalsColor);
        this.mPaintDiagonals.setAntiAlias(true);
        this.mPaintText.setColor(this.mTextColor);
        this.mPaintText.setAntiAlias(true);
        this.mPaintTextBackground.setColor(this.mTextBackgroundColor);
        this.mMargin = Math.round(this.mMargin * (getResources().getDisplayMetrics().xdpi / 160.0f));
        return;
    L31:
        this.mText = r10.getResources().getResourceEntryName(getId());     // Catch: Exception -> L30
        goto L28
    }

    @Override // android.view.View
    public void onDraw(Canvas r14) {
        super.onDraw(r14);
        int r10 = getWidth();
        int r11 = getHeight();
        if (this.mDrawDiagonals == false) goto L5;
        r10 = r10 - 1;
        r11 = r11 - 1;
        float r12 = r10;
        float r13 = r11;
        r14.drawLine(0.0f, 0.0f, r12, r13, this.mPaintDiagonals);
        r14.drawLine(0.0f, r13, r12, 0.0f, this.mPaintDiagonals);
        r14.drawLine(0.0f, 0.0f, r12, 0.0f, this.mPaintDiagonals);
        r14.drawLine(r12, 0.0f, r12, r13, this.mPaintDiagonals);
        r14.drawLine(r12, r13, 0.0f, r13, this.mPaintDiagonals);
        r14.drawLine(0.0f, r13, 0.0f, 0.0f, this.mPaintDiagonals);
    L5:
        String r15 = this.mText;
        if (r15 != null) goto L8;
        return;
    L8:
        if (this.mDrawLabel == false) goto L12;
        this.mPaintText.getTextBounds(r15, 0, r15.length(), this.mTextBounds);
        float r16 = (r10 - this.mTextBounds.width()) / 2.0f;
        float r17 = ((r11 - this.mTextBounds.height()) / 2.0f) + this.mTextBounds.height();
        this.mTextBounds.offset((int) r16, (int) r17);
        Rect r18 = this.mTextBounds;
        int r19 = r18.left;
        int r20 = this.mMargin;
        r18.set(r19 - r20, r18.top - r20, r18.right + r20, r18.bottom + r20);
        r14.drawRect(this.mTextBounds, this.mPaintTextBackground);
        r14.drawText(this.mText, r16, r17, this.mPaintText);
        return;
    }
}
