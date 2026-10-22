package com.lynx.textra;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class JavaCanvasHelper {
    protected Canvas canvas_;
    protected int color_;
    protected boolean is_bold_;
    protected boolean is_italic_;
    protected boolean is_underline_;
    protected JavaFontManager mFontManager;
    protected Paint mPainter;
    protected final Paint paint_;
    protected int stroke_color_;
    protected char[] text_;
    protected float text_size_;
    protected float text_skew_;

    /* JADX INFO: renamed from: com.lynx.textra.JavaCanvasHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp = null;
        static final /* synthetic */ int[] $SwitchMap$com$lynx$textra$TTTextDefinition$PathType = null;

        static {
            int[] r0 = new int[TTTextDefinition.PathType.values().length];
            $SwitchMap$com$lynx$textra$TTTextDefinition$PathType = r0;
            r0[TTTextDefinition.PathType.kLines.ordinal()] = 1;     // Catch: NoSuchFieldError -> L42
        L93:
            $SwitchMap$com$lynx$textra$TTTextDefinition$PathType[TTTextDefinition.PathType.kArc.ordinal()] = 2;     // Catch: NoSuchFieldError -> L43
        L113:
            $SwitchMap$com$lynx$textra$TTTextDefinition$PathType[TTTextDefinition.PathType.kBezier.ordinal()] = 3;     // Catch: NoSuchFieldError -> L44
        L125:
            $SwitchMap$com$lynx$textra$TTTextDefinition$PathType[TTTextDefinition.PathType.kMoveTo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L45
        L131:
            $SwitchMap$com$lynx$textra$TTTextDefinition$PathType[TTTextDefinition.PathType.kMultiPath.ordinal()] = 5;     // Catch: NoSuchFieldError -> L46
        L12:
            int[] r5 = new int[TTTextDefinition.CanvasOp.values().length];
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp = r5;
            r5[TTTextDefinition.CanvasOp.kStartPaint.ordinal()] = 1;     // Catch: NoSuchFieldError -> L47
        L99:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kEndPaint.ordinal()] = 2;     // Catch: NoSuchFieldError -> L48
        L107:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kSave.ordinal()] = 3;     // Catch: NoSuchFieldError -> L49
        L111:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kRestore.ordinal()] = 4;     // Catch: NoSuchFieldError -> L50
        L119:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kClear.ordinal()] = 5;     // Catch: NoSuchFieldError -> L51
        L139:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kTranslate.ordinal()] = 6;     // Catch: NoSuchFieldError -> L52
        L77:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kScale.ordinal()] = 7;     // Catch: NoSuchFieldError -> L53
        L97:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kRotate.ordinal()] = 8;     // Catch: NoSuchFieldError -> L54
        L103:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kSkew.ordinal()] = 9;     // Catch: NoSuchFieldError -> L55
        L123:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kClipRect.ordinal()] = 10;     // Catch: NoSuchFieldError -> L56
        L129:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kClearRect.ordinal()] = 11;     // Catch: NoSuchFieldError -> L57
        L83:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kFillRect.ordinal()] = 12;     // Catch: NoSuchFieldError -> L58
        L85:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawArc.ordinal()] = 13;     // Catch: NoSuchFieldError -> L59
        L105:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawLine.ordinal()] = 14;     // Catch: NoSuchFieldError -> L60
        L109:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawOval.ordinal()] = 15;     // Catch: NoSuchFieldError -> L61
        L133:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawPath.ordinal()] = 16;     // Catch: NoSuchFieldError -> L62
        L135:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawRect.ordinal()] = 17;     // Catch: NoSuchFieldError -> L63
        L87:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawText.ordinal()] = 18;     // Catch: NoSuchFieldError -> L64
        L91:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawArcTo.ordinal()] = 19;     // Catch: NoSuchFieldError -> L65
        L115:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawColor.ordinal()] = 20;     // Catch: NoSuchFieldError -> L66
        L117:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawImage.ordinal()] = 21;     // Catch: NoSuchFieldError -> L67
        L137:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawCircle.ordinal()] = 22;     // Catch: NoSuchFieldError -> L68
        L75:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawGlyphs.ordinal()] = 23;     // Catch: NoSuchFieldError -> L69
        L95:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawImageRect.ordinal()] = 24;     // Catch: NoSuchFieldError -> L70
        L101:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawRunDelegate.ordinal()] = 25;     // Catch: NoSuchFieldError -> L71
        L121:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawBackgroundDelegate.ordinal()] = 26;     // Catch: NoSuchFieldError -> L72
        L127:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawBlockRegion.ordinal()] = 27;     // Catch: NoSuchFieldError -> L73
        L81:
            $SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawRoundRect.ordinal()] = 28;     // Catch: NoSuchFieldError -> L74
            return;
        }
    }

    public void clear() {
    }

    public void endPaint() throws IOException {
    }

    public void startPaint() throws IOException {
    }

    public void restore() {
        this.canvas_.restore();
    }

    public void save() {
        this.canvas_.save();
    }

    public JavaCanvasHelper(JavaFontManager r2) {
        this.paint_ = new Paint();
        this.mFontManager = null;
        this.mPainter = new Paint();
        this.text_ = new char[20];
        this.mFontManager = r2;
    }

    public void clearRect(BBufferInputStream r2) throws IOException {
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
    }

    public void clipRect(BBufferInputStream r5) throws IOException {
        float r0 = TTTextUtils.Dp2Px(r5.readFloat());
        float r1 = TTTextUtils.Dp2Px(r5.readFloat());
        float r2 = TTTextUtils.Dp2Px(r5.readFloat());
        float r6 = TTTextUtils.Dp2Px(r5.readFloat());
        this.canvas_.clipRect(r0, r1, r2, r6);
    }

    public void drawArc(BBufferInputStream r2) throws IOException {
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        r2.readInt();
        ReadPaint(r2, this.paint_);
    }

    public void drawArcTo(BBufferInputStream r2) throws IOException {
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        ReadPaint(r2, this.paint_);
    }

    public void drawBackgroundDelegate(BBufferInputStream r2) throws IOException {
        r2.readInt();
        ReadPaint(r2, this.paint_);
    }

    public void drawCircle(BBufferInputStream r6) throws IOException {
        float r0 = TTTextUtils.Dp2Px(r6.readFloat());
        float r1 = TTTextUtils.Dp2Px(r6.readFloat());
        float r2 = TTTextUtils.Dp2Px(r6.readFloat());
        Paint r7 = ReadPaint(r6, this.paint_);
        r7.setColor(this.color_);
        int r3 = this.color_;
        if (r3 != 0) goto L5;
    L7:
        if (r3 == 0) goto L10;
        r7.setStyle(Paint.Style.FILL);
        this.canvas_.drawCircle(r0, r1, r2, r7);
    L10:
        if (this.stroke_color_ == 0) goto L14;
        r7.setStyle(Paint.Style.STROKE);
        r7.setColor(this.stroke_color_);
        this.canvas_.drawCircle(r0, r1, r2, r7);
        return;
    L14:
        return;
    L5:
        if (this.stroke_color_ != r3) goto L7;
        r7.setStyle(Paint.Style.FILL_AND_STROKE);
        this.canvas_.drawCircle(r0, r1, r2, r7);
    }

    public void drawColor(BBufferInputStream r1) throws IOException {
        r1.readInt();
    }

    public void drawGlyphs(BBufferInputStream r9) throws IOException {
        this.mFontManager.GetTypefaceByIndex(r9.readInt());
        float r0 = TTTextUtils.Dp2Px(r9.readFloat());
        float r1 = TTTextUtils.Dp2Px(r9.readFloat());
        int r2 = r9.readInt();
        int[] r3 = new int[r2];
        float[] r4 = new float[r2 * 2];
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L5;
        r3[r5] = r9.readShort();
        int r6 = r5 * 2;
        r4[r6] = r9.readFloat() + r0;
        r4[r6 + 1] = r9.readFloat() + r1;
        r5 = r5 + 1;
        goto L3
    }

    public void drawImage(BBufferInputStream r11) throws IOException {
        int r0 = r11.readInt();
        byte[] r1 = new byte[r0];
        r11.read(r1, 0, r0);
        float r3 = TTTextUtils.Dp2Px(r11.readFloat());
        float r4 = TTTextUtils.Dp2Px(r11.readFloat());
        float r5 = TTTextUtils.Dp2Px(r11.readFloat());
        float r6 = TTTextUtils.Dp2Px(r11.readFloat());
        Paint r12 = ReadPaint(r11, this.paint_);
        Bitmap r2 = BitmapFactory.decodeByteArray(r1, 0, r0);
        this.canvas_.drawBitmap(r2, new Rect(0, 0, r2.getWidth(), r2.getHeight()), new Rect((int) r3, (int) r4, (int) r5, (int) r6), r12);
    }

    public void drawImgRect(BBufferInputStream r13) throws IOException {
        int r0 = r13.readInt();
        byte[] r1 = new byte[r0];
        r13.read(r1, 0, r0);
        float r3 = TTTextUtils.Dp2Px(r13.readFloat());
        float r4 = TTTextUtils.Dp2Px(r13.readFloat());
        float r5 = TTTextUtils.Dp2Px(r13.readFloat());
        float r6 = TTTextUtils.Dp2Px(r13.readFloat());
        float r7 = TTTextUtils.Dp2Px(r13.readFloat());
        float r8 = TTTextUtils.Dp2Px(r13.readFloat());
        float r9 = TTTextUtils.Dp2Px(r13.readFloat());
        float r10 = TTTextUtils.Dp2Px(r13.readFloat());
        Paint r14 = ReadPaint(r13, this.paint_);
        Bitmap r2 = BitmapFactory.decodeByteArray(r1, 0, r0);
        this.canvas_.drawBitmap(r2, new Rect((int) r3, (int) r4, (int) r5, (int) r6), new Rect((int) r7, (int) r8, (int) r9, (int) r10), r14);
    }

    public void drawLine(BBufferInputStream r11) throws IOException {
        float r0 = TTTextUtils.Dp2Px(r11.readFloat());
        float r7 = TTTextUtils.Dp2Px(r11.readFloat());
        float r8 = TTTextUtils.Dp2Px(r11.readFloat());
        float r9 = TTTextUtils.Dp2Px(r11.readFloat());
        Paint r12 = ReadPaint(r11, this.paint_);
        r12.setColor(this.color_);
        int r1 = this.color_;
        if (r1 != 0) goto L5;
    L7:
        if (r1 == 0) goto L10;
        r12.setStyle(Paint.Style.FILL);
        this.canvas_.drawLine(r0, r7, r8, r9, r12);
    L10:
        if (this.stroke_color_ == 0) goto L14;
        r12.setStyle(Paint.Style.STROKE);
        r12.setColor(this.stroke_color_);
        this.canvas_.drawLine(r0, r7, r8, r9, r12);
        return;
    L14:
        return;
    L5:
        if (this.stroke_color_ != r1) goto L7;
        r12.setStyle(Paint.Style.FILL_AND_STROKE);
        this.canvas_.drawLine(r0, r7, r8, r9, r12);
    }

    public void drawOval(BBufferInputStream r2) throws IOException {
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        ReadPaint(r2, this.paint_);
    }

    public void drawPath(BBufferInputStream r4) throws IOException {
        Path r0 = new Path();
        ReadPath(r0, r4);
        r0.close();
        Paint r5 = ReadPaint(r4, this.paint_);
        r5.setColor(this.color_);
        int r1 = this.color_;
        if (r1 != 0) goto L5;
    L7:
        if (r1 == 0) goto L10;
        r5.setStyle(Paint.Style.FILL);
        this.canvas_.drawPath(r0, r5);
    L10:
        if (this.stroke_color_ == 0) goto L14;
        r5.setStyle(Paint.Style.STROKE);
        r5.setColor(this.stroke_color_);
        this.canvas_.drawPath(r0, r5);
        return;
    L14:
        return;
    L5:
        if (this.stroke_color_ != r1) goto L7;
        r5.setStyle(Paint.Style.FILL_AND_STROKE);
        this.canvas_.drawPath(r0, r5);
    }

    public void drawRect(BBufferInputStream r11) throws IOException {
        float r0 = TTTextUtils.Dp2Px(r11.readFloat());
        float r7 = TTTextUtils.Dp2Px(r11.readFloat());
        float r8 = TTTextUtils.Dp2Px(r11.readFloat());
        float r9 = TTTextUtils.Dp2Px(r11.readFloat());
        Paint r12 = ReadPaint(r11, this.paint_);
        r12.setColor(this.color_);
        int r1 = this.color_;
        if (r1 != 0) goto L5;
    L7:
        if (r1 == 0) goto L10;
        r12.setStyle(Paint.Style.FILL);
        this.canvas_.drawRect(r0, r7, r8, r9, r12);
    L10:
        if (this.stroke_color_ == 0) goto L14;
        r12.setStyle(Paint.Style.STROKE);
        r12.setColor(this.stroke_color_);
        this.canvas_.drawRect(r0, r7, r8, r9, r12);
        return;
    L14:
        return;
    L5:
        if (this.stroke_color_ != r1) goto L7;
        r12.setStyle(Paint.Style.FILL_AND_STROKE);
        this.canvas_.drawRect(r0, r7, r8, r9, r12);
    }

    public void drawRoundRect(BBufferInputStream r14) throws IOException {
        float r0 = TTTextUtils.Dp2Px(r14.readFloat());
        float r9 = TTTextUtils.Dp2Px(r14.readFloat());
        float r10 = TTTextUtils.Dp2Px(r14.readFloat());
        float r11 = TTTextUtils.Dp2Px(r14.readFloat());
        float r12 = TTTextUtils.Dp2Px(r14.readFloat());
        Paint r15 = ReadPaint(r14, this.paint_);
        r15.setColor(this.color_);
        int r1 = this.color_;
        if (r1 != 0) goto L5;
    L7:
        if (r1 == 0) goto L10;
        r15.setStyle(Paint.Style.FILL);
        this.canvas_.drawRoundRect(r0, r9, r10, r11, r12, r12, r15);
    L10:
        if (this.stroke_color_ == 0) goto L14;
        r15.setStyle(Paint.Style.STROKE);
        r15.setColor(this.stroke_color_);
        this.canvas_.drawRoundRect(r0, r9, r10, r11, r12, r12, r15);
        return;
    L14:
        return;
    L5:
        if (this.stroke_color_ != r1) goto L7;
        r15.setStyle(Paint.Style.FILL_AND_STROKE);
        this.canvas_.drawRoundRect(r0, r9, r10, r11, r12, r12, r15);
    }

    public void drawRunDelegate(BBufferInputStream r2) throws IOException {
        r2.readInt();
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        ReadPaint(r2, this.paint_);
    }

    public void drawText(BBufferInputStream r12) throws IOException {
        JavaTypeface r0 = this.mFontManager.GetTypefaceByIndex(r12.readInt());
        int r1 = r12.readInt();
        if (r1 <= this.text_.length) goto L5;
        this.text_ = new char[r1];
    L5:
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        this.text_[r2] = (char) r12.readShort();
        r2 = r2 + 1;
    L8:
        if (r1 <= 0) goto L12;
        if (this.text_[r1 - 1] >= ' ') goto L12;
        r1 = r1 - 1;
    L12:
        float r3 = TTTextUtils.Dp2Px(r12.readFloat());
        float r10 = TTTextUtils.Dp2Px(r12.readFloat());
        this.paint_.setTypeface(r0.mTypeface);
        Paint r13 = ReadPaint(r12, this.paint_);
        r13.setFakeBoldText(this.is_bold_);
        if (this.is_italic_ == false) goto L15;
        float r4 = -0.25f;
    L16:
        r13.setTextSkewX(r4 + this.text_skew_);
        r13.setColor(this.color_);
        int r5 = this.color_;
        if (r5 != 0) goto L19;
    L21:
        if (r5 == 0) goto L24;
        r13.setStyle(Paint.Style.FILL);
        this.canvas_.drawText(this.text_, 0, r1, r3, r10, r13);
    L24:
        if (this.stroke_color_ == 0) goto L31;
        r13.setStyle(Paint.Style.STROKE);
        r13.setColor(this.stroke_color_);
        this.canvas_.drawText(this.text_, 0, r1, r3, r10, r13);
        return;
    L31:
        return;
    L19:
        if (this.stroke_color_ != r5) goto L21;
        r13.setStyle(Paint.Style.FILL_AND_STROKE);
        this.canvas_.drawText(this.text_, 0, r1, r3, r10, r13);
        return;
    L15:
        r4 = 0.0f;
        goto L16
    }

    public void fillRect(BBufferInputStream r9) throws IOException {
        int r0 = r9.readInt();
        float r3 = TTTextUtils.Dp2Px(r9.readFloat());
        float r4 = TTTextUtils.Dp2Px(r9.readFloat());
        float r5 = TTTextUtils.Dp2Px(r9.readFloat());
        float r6 = TTTextUtils.Dp2Px(r9.readFloat());
        Paint r7 = new Paint();
        r7.setColor(r0);
        r7.setStyle(Paint.Style.FILL);
        this.canvas_.drawRect(r3, r4, r5, r6, r7);
    }

    public void rotate(BBufferInputStream r2) throws IOException {
        float r3 = r2.readFloat();
        this.canvas_.rotate(r3);
    }

    public void scale(BBufferInputStream r3) throws IOException {
        float r0 = r3.readFloat();
        float r4 = r3.readFloat();
        this.canvas_.scale(r0, r4);
    }

    public void skew(BBufferInputStream r3) throws IOException {
        float r0 = TTTextUtils.Dp2Px(r3.readFloat());
        float r4 = TTTextUtils.Dp2Px(r3.readFloat());
        this.canvas_.skew(r0, r4);
    }

    public void translate(BBufferInputStream r3) throws IOException {
        float r0 = TTTextUtils.Dp2Px(r3.readFloat());
        float r4 = TTTextUtils.Dp2Px(r3.readFloat());
        this.canvas_.translate(r0, r4);
    }

    public Paint ReadPaint(BBufferInputStream r4, Paint r5) throws IOException {
        boolean r0 = true;
        r5.setAntiAlias(true);
        r5.setStrokeWidth(TTTextUtils.Dp2Px(r4.readFloat()));
        this.color_ = r4.readInt();
        this.stroke_color_ = r4.readInt();
        float r1 = TTTextUtils.Dp2Px(r4.readFloat());
        this.text_size_ = r1;
        r5.setTextSize(r1);
        this.text_skew_ = r4.readFloat();
        byte r6 = r4.readByte();
        int r2 = r6 & 3;
        if (r2 != 1) goto L5;
        r5.setStrokeCap(Paint.Cap.ROUND);
    L10:
        if ((r6 & 4) <= 0) goto L12;
        boolean r3 = true;
    L13:
        this.is_bold_ = r3;
        if ((r6 & 8) <= 0) goto L16;
        boolean r7 = true;
    L17:
        this.is_italic_ = r7;
        if ((r6 & 16) > 0) goto L21;
        r0 = false;
    L21:
        this.is_underline_ = r0;
        return r5;
    L16:
        r7 = false;
        goto L17
    L12:
        r3 = false;
        goto L13
    L5:
        if (r2 == 2) goto L7;
        r5.setStrokeCap(Paint.Cap.BUTT);
        goto L10
    L7:
        r5.setStrokeCap(Paint.Cap.SQUARE);
        goto L10
    }

    public void ReadPath(Path r14, BBufferInputStream r15) throws IOException {
        TTTextDefinition.PathType r0 = TTTextDefinition.GetPathType(r15.readInt());
        int r1 = AnonymousClass1.$SwitchMap$com$lynx$textra$TTTextDefinition$PathType[r0.ordinal()];
        int r2 = 0;
        if (r1 != 1) goto L5;
        int r3 = r15.readInt();
    L26:
        if (r2 >= r3) goto L38;
        r14.lineTo(TTTextUtils.Dp2Px(r15.readFloat()), TTTextUtils.Dp2Px(r15.readFloat()));
        r2 = r2 + 1;
        goto L26
    L38:
        return;
    L5:
        if (r1 != 2) goto L7;
        TTTextUtils.Dp2Px(r15.readFloat());
        TTTextUtils.Dp2Px(r15.readFloat());
        TTTextUtils.Dp2Px(r15.readFloat());
        TTTextUtils.Dp2Px(r15.readFloat());
        TTTextUtils.Dp2Px(r15.readFloat());
        TTTextUtils.Dp2Px(r15.readFloat());
        TTTextUtils.Dp2Px(r15.readFloat());
        return;
    L7:
        if (r1 != 3) goto L9;
        int r4 = r15.readInt();
        PointF[] r5 = new PointF[r4];
        int r6 = 0;
    L18:
        if (r6 >= r4) goto L20;
        r5[r6] = new PointF(TTTextUtils.Dp2Px(r15.readFloat()), TTTextUtils.Dp2Px(r15.readFloat()));
        r6 = r6 + 1;
        goto L18
    L20:
        if (r4 != 2) goto L22;
        PointF r16 = r5[0];
        float r7 = r16.x;
        float r17 = r16.y;
        PointF r8 = r5[1];
        r14.quadTo(r7, r17, r8.x, r8.y);
        return;
    L22:
        if (r4 < 3) goto L33;
        PointF r18 = r5[0];
        float r9 = r18.x;
        float r10 = r18.y;
        PointF r19 = r5[1];
        float r11 = r19.x;
        float r12 = r19.y;
        PointF r110 = r5[2];
        r14.cubicTo(r9, r10, r11, r12, r110.x, r110.y);
        return;
    L33:
        return;
    L9:
        if (r1 != 4) goto L11;
        r14.moveTo(TTTextUtils.Dp2Px(r15.readFloat()), TTTextUtils.Dp2Px(r15.readFloat()));
        return;
    L11:
        if (r1 != 5) goto L36;
        int r13 = r15.readInt();
    L14:
        if (r2 >= r13) goto L37;
        ReadPath(r14, r15);
        r2 = r2 + 1;
        goto L14
    L37:
        return;
    }

    public void drawBuffer(Canvas r1, byte[] r2) {
        this.canvas_ = r1;
        BBufferInputStream r3 = new BBufferInputStream(r2);
    L10:
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (r3.available() <= 0) goto L14;
        drawOp(TTTextDefinition.GetCanvasOp(r3.readByte()), r3);     // Catch: IOException -> L7
        goto L10
    }

    public void drawOp(TTTextDefinition.CanvasOp r2, BBufferInputStream r3) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$lynx$textra$TTTextDefinition$CanvasOp[r2.ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L14;
            case 19: goto L13;
            case 20: goto L12;
            case 21: goto L11;
            case 22: goto L10;
            case 23: goto L9;
            case 24: goto L8;
            case 25: goto L7;
            case 26: goto L6;
            case 27: goto L59;
            case 28: goto L5;
            default: goto L59;
        };
    L5:
        drawRoundRect(r3);
        return;
    L6:
        drawBackgroundDelegate(r3);
        return;
    L7:
        drawRunDelegate(r3);
        return;
    L8:
        drawImgRect(r3);
        return;
    L9:
        drawGlyphs(r3);
        return;
    L10:
        drawCircle(r3);
        return;
    L11:
        drawImage(r3);
        return;
    L12:
        drawColor(r3);
        return;
    L13:
        drawArcTo(r3);
        return;
    L14:
        drawText(r3);
        return;
    L15:
        drawRect(r3);
        return;
    L16:
        drawPath(r3);
        return;
    L17:
        drawOval(r3);
        return;
    L18:
        drawLine(r3);
        return;
    L19:
        drawArc(r3);
        return;
    L20:
        fillRect(r3);
        return;
    L21:
        clearRect(r3);
        return;
    L22:
        clipRect(r3);
        return;
    L23:
        skew(r3);
        return;
    L24:
        rotate(r3);
        return;
    L25:
        scale(r3);
        return;
    L26:
        translate(r3);
        return;
    L27:
        clear();
        return;
    L28:
        restore();
        return;
    L29:
        save();
        return;
    L30:
        endPaint();
        return;
    L31:
        startPaint();
        return;
    }
}
