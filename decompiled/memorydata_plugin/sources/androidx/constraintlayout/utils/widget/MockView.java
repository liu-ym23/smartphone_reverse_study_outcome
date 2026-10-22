package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

    public MockView(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
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

    public MockView(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
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
        init(r5, r6);
    }

    public MockView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
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
        init(r6, r7);
    }

    private void init(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L27;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.MockView);
        int r0 = r12.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L25;
        int r3 = r12.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.MockView_mock_label, "styleable", "MockView_mock_label")) goto L10;
        this.mText = r12.getString(r3);
    L24:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.MockView_mock_showDiagonals, "styleable", "MockView_mock_showDiagonals")) goto L13;
        this.mDrawDiagonals = r12.getBoolean(r3, this.mDrawDiagonals);
        goto L24
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.MockView_mock_diagonalsColor, "styleable", "MockView_mock_diagonalsColor")) goto L16;
        this.mDiagonalsColor = r12.getColor(r3, this.mDiagonalsColor);
        goto L24
    L16:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.MockView_mock_labelBackgroundColor, "styleable", "MockView_mock_labelBackgroundColor")) goto L19;
        this.mTextBackgroundColor = r12.getColor(r3, this.mTextBackgroundColor);
        goto L24
    L19:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.MockView_mock_labelColor, "styleable", "MockView_mock_labelColor")) goto L22;
        this.mTextColor = r12.getColor(r3, this.mTextColor);
        goto L24
    L22:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.MockView_mock_showLabel, "styleable", "MockView_mock_showLabel")) goto L24;
        this.mDrawLabel = r12.getBoolean(r3, this.mDrawLabel);
        goto L24
    L25:
        r12.recycle();
    L27:
        if (this.mText == null) goto L32;
    L29:
        this.mPaintDiagonals.setColor(this.mDiagonalsColor);
        this.mPaintDiagonals.setAntiAlias(true);
        this.mPaintText.setColor(this.mTextColor);
        this.mPaintText.setAntiAlias(true);
        this.mPaintTextBackground.setColor(this.mTextBackgroundColor);
        this.mMargin = Math.round(this.mMargin * (ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().xdpi / 160.0f));
        return;
    L32:
        this.mText = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceEntryName(getId());     // Catch: Exception -> L31
        goto L29
    }

    @Override // android.view.View
    public void onDraw(Canvas r14) {
        super.onDraw(r14);
        int r0 = getWidth();
        int r1 = getHeight();
        if (this.mDrawDiagonals == false) goto L5;
        r0 = r0 - 1;
        r1 = r1 - 1;
        float r11 = r0;
        float r12 = r1;
        r14.drawLine(0.0f, 0.0f, r11, r12, this.mPaintDiagonals);
        r14.drawLine(0.0f, r12, r11, 0.0f, this.mPaintDiagonals);
        r14.drawLine(0.0f, 0.0f, r11, 0.0f, this.mPaintDiagonals);
        r14.drawLine(r11, 0.0f, r11, r12, this.mPaintDiagonals);
        r14.drawLine(r11, r12, 0.0f, r12, this.mPaintDiagonals);
        r14.drawLine(0.0f, r12, 0.0f, 0.0f, this.mPaintDiagonals);
    L5:
        String r2 = this.mText;
        if (r2 != null) goto L8;
        return;
    L8:
        if (this.mDrawLabel == false) goto L12;
        this.mPaintText.getTextBounds(r2, 0, r2.length(), this.mTextBounds);
        float r3 = (r0 - this.mTextBounds.width()) / 2.0f;
        float r4 = ((r1 - this.mTextBounds.height()) / 2.0f) + this.mTextBounds.height();
        this.mTextBounds.offset((int) r3, (int) r4);
        Rect r5 = this.mTextBounds;
        r5.set(r5.left - this.mMargin, this.mTextBounds.top - this.mMargin, this.mTextBounds.right + this.mMargin, this.mTextBounds.bottom + this.mMargin);
        r14.drawRect(this.mTextBounds, this.mPaintTextBackground);
        r14.drawText(this.mText, r3, r4, this.mPaintText);
        return;
    }
}
