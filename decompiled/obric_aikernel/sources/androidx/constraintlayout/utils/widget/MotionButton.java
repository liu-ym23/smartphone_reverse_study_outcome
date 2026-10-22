package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class MotionButton extends AppCompatButton {
    private Path mPath;
    RectF mRect;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;

    public MotionButton(Context r10) {
        super(r10);
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(r10, null);
    }

    public MotionButton(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(r10, r11);
    }

    public MotionButton(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(r10, r11);
    }

    static /* synthetic */ float access$000(MotionButton r10) {
        return r10.mRoundPercent;
    }

    static /* synthetic */ float access$100(MotionButton r10) {
        return r10.mRound;
    }

    private void init(Context r10, AttributeSet r11) {
        int r12 = 0;
        setPadding(0, 0, 0, 0);
        if (r11 == null) goto L25;
        TypedArray r13 = getContext().obtainStyledAttributes(r11, R.styleable.ImageFilterView);
        int r14 = r13.getIndexCount();
    L5:
        if (r12 >= r14) goto L17;
        int r15 = r13.getIndex(r12);
        if (r15 != R.styleable.ImageFilterView_round) goto L12;
        if (Build.VERSION.SDK_INT < 21) goto L16;
        setRound(r13.getDimension(r15, 0.0f));
    L16:
        r12 = r12 + 1;
        goto L5
    L12:
        if (r15 != R.styleable.ImageFilterView_roundPercent) goto L16;
        if (Build.VERSION.SDK_INT < 21) goto L16;
        setRoundPercent(r13.getFloat(r15, 0.0f));
        goto L16
    L17:
        r13.recycle();
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
    L9:
        boolean r11 = false;
    L10:
        super.draw(r10);
        if (r11 == false) goto L14;
        r10.restore();
        return;
    L14:
        return;
    L5:
        if (this.mRound == 0.0f) goto L9;
        if (this.mPath == null) goto L9;
        r11 = true;
        r10.save();
        r10.clipPath(this.mPath);
        goto L10
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    @RequiresApi(21)
    public void setRound(float r10) {
        if (Float.isNaN(r10) == false) goto L7;
        this.mRound = r10;
        float r11 = this.mRoundPercent;
        this.mRoundPercent = -1.0f;
        setRoundPercent(r11);
        return;
    L7:
        if (this.mRound == r10) goto L9;
        boolean r12 = true;
    L10:
        this.mRound = r10;
        if (r10 == 0.0f) goto L26;
        if (this.mPath != null) goto L16;
        this.mPath = new Path();
    L16:
        if (this.mRect != null) goto L19;
        this.mRect = new RectF();
    L19:
        if (Build.VERSION.SDK_INT >= 21) goto L21;
    L24:
        this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mPath.reset();
        Path r13 = this.mPath;
        RectF r14 = this.mRect;
        float r15 = this.mRound;
        r13.addRoundRect(r14, r15, r15, Path.Direction.CW);
    L28:
        if (r12 == true) goto L30;
        return;
    L30:
        if (Build.VERSION.SDK_INT < 21) goto L34;
        invalidateOutline();
        return;
    L34:
        return;
    L21:
        if (this.mViewOutlineProvider != null) goto L23;
        ViewOutlineProvider r16 = new AnonymousClass2(this);
        this.mViewOutlineProvider = r16;
        setOutlineProvider(r16);
    L23:
        setClipToOutline(true);
        goto L24
    L26:
        if (Build.VERSION.SDK_INT < 21) goto L28;
        setClipToOutline(false);
        goto L28
    L9:
        r12 = false;
        goto L10
    }

    @RequiresApi(21)
    public void setRoundPercent(float r10) {
        if (this.mRoundPercent == r10) goto L5;
        boolean r11 = true;
    L6:
        this.mRoundPercent = r10;
        if (r10 == 0.0f) goto L22;
        if (this.mPath != null) goto L12;
        this.mPath = new Path();
    L12:
        if (this.mRect != null) goto L15;
        this.mRect = new RectF();
    L15:
        if (Build.VERSION.SDK_INT >= 21) goto L17;
    L20:
        int r12 = getWidth();
        int r13 = getHeight();
        float r14 = (Math.min(r12, r13) * this.mRoundPercent) / 2.0f;
        this.mRect.set(0.0f, 0.0f, r12, r13);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, r14, r14, Path.Direction.CW);
    L24:
        if (r11 == true) goto L26;
        return;
    L26:
        if (Build.VERSION.SDK_INT < 21) goto L30;
        invalidateOutline();
        return;
    L30:
        return;
    L17:
        if (this.mViewOutlineProvider != null) goto L19;
        ViewOutlineProvider r15 = new AnonymousClass1(this);
        this.mViewOutlineProvider = r15;
        setOutlineProvider(r15);
    L19:
        setClipToOutline(true);
        goto L20
    L22:
        if (Build.VERSION.SDK_INT < 21) goto L24;
        setClipToOutline(false);
        goto L24
    L5:
        r11 = false;
        goto L6
    }
}
