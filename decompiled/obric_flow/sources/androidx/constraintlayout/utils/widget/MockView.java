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

    public MockView(Context r5) {
        super(r5);
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
        init(r5, null);
    }

    private void init(Context r5, AttributeSet r10) {
        if (r10 == null) goto L26;
        TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.MockView);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L24;
        int r14 = r11.getIndex(r13);
        if (r14 != R.styleable.MockView_mock_label) goto L9;
        this.mText = r11.getString(r14);
    L23:
        r13 = r13 + 1;
        goto L4
    L9:
        if (r14 != R.styleable.MockView_mock_showDiagonals) goto L12;
        this.mDrawDiagonals = r11.getBoolean(r14, this.mDrawDiagonals);
        goto L23
    L12:
        if (r14 != R.styleable.MockView_mock_diagonalsColor) goto L15;
        this.mDiagonalsColor = r11.getColor(r14, this.mDiagonalsColor);
        goto L23
    L15:
        if (r14 != R.styleable.MockView_mock_labelBackgroundColor) goto L18;
        this.mTextBackgroundColor = r11.getColor(r14, this.mTextBackgroundColor);
        goto L23
    L18:
        if (r14 != R.styleable.MockView_mock_labelColor) goto L21;
        this.mTextColor = r11.getColor(r14, this.mTextColor);
        goto L23
    L21:
        if (r14 != R.styleable.MockView_mock_showLabel) goto L23;
        this.mDrawLabel = r11.getBoolean(r14, this.mDrawLabel);
        goto L23
    L24:
        r11.recycle();
    L26:
        if (this.mText == null) goto L31;
    L28:
        this.mPaintDiagonals.setColor(this.mDiagonalsColor);
        this.mPaintDiagonals.setAntiAlias(true);
        this.mPaintText.setColor(this.mTextColor);
        this.mPaintText.setAntiAlias(true);
        this.mPaintTextBackground.setColor(this.mTextBackgroundColor);
        this.mMargin = Math.round((getResources().getDisplayMetrics().xdpi / 160.0f) * this.mMargin);
        return;
    L31:
        this.mText = r5.getResources().getResourceEntryName(getId());     // Catch: Exception -> L30
        goto L28
    }

    @Override // android.view.View
    public void onDraw(Canvas r11) {
        super.onDraw(r11);
        int r5 = getWidth();
        int r10 = getHeight();
        if (this.mDrawDiagonals == false) goto L5;
        r5 = r5 - 1;
        r10 = r10 - 1;
        float r12 = r5;
        float r13 = r10;
        r11.drawLine(0.0f, 0.0f, r12, r13, this.mPaintDiagonals);
        r11.drawLine(0.0f, r13, r12, 0.0f, this.mPaintDiagonals);
        r11.drawLine(0.0f, 0.0f, r12, 0.0f, this.mPaintDiagonals);
        r11.drawLine(r12, 0.0f, r12, r13, this.mPaintDiagonals);
        r11.drawLine(r12, r13, 0.0f, r13, this.mPaintDiagonals);
        r11.drawLine(0.0f, r13, 0.0f, 0.0f, this.mPaintDiagonals);
    L5:
        String r14 = this.mText;
        if (r14 != null) goto L8;
        return;
    L8:
        if (this.mDrawLabel == false) goto L12;
        this.mPaintText.getTextBounds(r14, 0, r14.length(), this.mTextBounds);
        float r15 = (r5 - this.mTextBounds.width()) / 2.0f;
        float r16 = ((r10 - this.mTextBounds.height()) / 2.0f) + this.mTextBounds.height();
        this.mTextBounds.offset((int) r15, (int) r16);
        Rect r17 = this.mTextBounds;
        int r18 = r17.left;
        int r19 = this.mMargin;
        r17.set(r18 - r19, r17.top - r19, r17.right + r19, r17.bottom + r19);
        r11.drawRect(this.mTextBounds, this.mPaintTextBackground);
        r11.drawText(this.mText, r15, r16, this.mPaintText);
        return;
    }

    public MockView(Context r5, AttributeSet r10) {
        super(r5, r10);
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
        init(r5, r10);
    }

    public MockView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
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
        init(r5, r10);
    }
}
