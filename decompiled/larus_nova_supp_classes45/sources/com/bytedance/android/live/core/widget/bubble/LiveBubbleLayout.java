package com.bytedance.android.live.core.widget.bubble;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\fB\u0015\b\u0016\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001B!\b\u0016\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u0012\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u0001¢\u0006\u0006\b\u0084\u0001\u0010\u0088\u0001B*\b\u0016\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u0012\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u0001\u0012\u0007\u0010\u0089\u0001\u001a\u00020\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u008a\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\"\u0010.\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\r\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R\"\u00102\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b/\u0010\u001d\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010A\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010I\u001a\u00020B8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010M\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010<\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R\"\u0010Q\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010<\u001a\u0004\bO\u0010>\"\u0004\bP\u0010@R\"\u0010U\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010<\u001a\u0004\bS\u0010>\"\u0004\bT\u0010@R\"\u0010\\\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010`\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010W\u001a\u0004\b^\u0010Y\"\u0004\b_\u0010[R\"\u0010d\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010W\u001a\u0004\bb\u0010Y\"\u0004\bc\u0010[R\"\u0010h\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010W\u001a\u0004\bf\u0010Y\"\u0004\bg\u0010[R\"\u0010l\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010W\u001a\u0004\bj\u0010Y\"\u0004\bk\u0010[R\"\u0010p\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010W\u001a\u0004\bn\u0010Y\"\u0004\bo\u0010[R\"\u0010t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010<\u001a\u0004\br\u0010>\"\u0004\bs\u0010@R\"\u0010x\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010\r\u001a\u0004\bv\u0010\u000f\"\u0004\bw\u0010\u0011R\"\u0010|\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010<\u001a\u0004\bz\u0010>\"\u0004\b{\u0010@R,\u0010\u0081\u0001\u001a\u00020\u00022\u0006\u0010}\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0013\n\u0004\b~\u0010<\u001a\u0004\b\u007f\u0010>\"\u0005\b\u0080\u0001\u0010@¨\u0006\u008b\u0001"}, d2 = {"Lcom/bytedance/android/live/core/widget/bubble/LiveBubbleLayout;", "Landroid/widget/LinearLayout;", "", "bubbleOrientation", "", "setBubbleOrientation", "", "getBubbleOffset", "getPADDING", "", "need", "setNeedAddColor", "a", "F", "getMPadding", "()F", "setMPadding", "(F)V", "mPadding", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "getMFillPaint", "()Landroid/graphics/Paint;", "setMFillPaint", "(Landroid/graphics/Paint;)V", "mFillPaint", "Landroid/graphics/Path;", "c", "Landroid/graphics/Path;", "getMPath", "()Landroid/graphics/Path;", "setMPath", "(Landroid/graphics/Path;)V", "mPath", "d", "getMBubbleArrowPath", "setMBubbleArrowPath", "mBubbleArrowPath", "f", "getMWidth", "setMWidth", "mWidth", "g", "getMHeight", "setMHeight", "mHeight", "h", "getMBorderBubbleArrowPath", "setMBorderBubbleArrowPath", "mBorderBubbleArrowPath", "Landroid/graphics/RectF;", "i", "Landroid/graphics/RectF;", "getMBorderRoundRect", "()Landroid/graphics/RectF;", "setMBorderRoundRect", "(Landroid/graphics/RectF;)V", "mBorderRoundRect", "j", "I", "getMBorderWidth", "()I", "setMBorderWidth", "(I)V", "mBorderWidth", "Landroid/graphics/Matrix;", "k", "Landroid/graphics/Matrix;", "getMBorderMatrix", "()Landroid/graphics/Matrix;", "setMBorderMatrix", "(Landroid/graphics/Matrix;)V", "mBorderMatrix", "n", "getMBgColor", "setMBgColor", "mBgColor", "o", "getMBorderColor", "setMBorderColor", "mBorderColor", "p", "getMShadowColor", "setMShadowColor", "mShadowColor", "q", "Z", "getMNeedShadow", "()Z", "setMNeedShadow", "(Z)V", "mNeedShadow", "t", "getMNeedPath", "setMNeedPath", "mNeedPath", "u", "getMNeedPressFade", "setMNeedPressFade", "mNeedPressFade", "v", "getMNeedArrow", "setMNeedArrow", "mNeedArrow", "w", "getMNeedAddColor", "setMNeedAddColor", "mNeedAddColor", "x", "getUseDefaultView", "setUseDefaultView", "useDefaultView", "y", "getMAdjustHeight", "setMAdjustHeight", "mAdjustHeight", "z", "getCornerRadius", "setCornerRadius", "cornerRadius", "A", "getDefaultHeight", "setDefaultHeight", "defaultHeight", "value", "B", "getArrowHeight", "setArrowHeight", "arrowHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBubbleLayout extends LinearLayout {
    public static int C;
    public static int D;
    public static float E;
    public static float F;
    public static int G;
    public int A;
    public int B;
    public float a;
    public Paint b;
    public Path c;
    public Path d;
    public RectF e;
    public float f;
    public float g;
    public Path h;
    public RectF i;
    public int j;
    public Matrix k;
    public Bitmap l;
    public Canvas m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public float r;
    public int s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public int y;
    public float z;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Path r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L5:
        r0.reset();
        Path r1 = this.d;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L8:
        r1.moveTo(0.0f, 0.0f);
        Path r2 = this.d;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L11:
        int r3 = C;
        r2.lineTo(r3, -r3);
        Path r4 = this.d;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L14:
        int r5 = C;
        r4.lineTo(r5, r5);
        Path r6 = this.d;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L17:
        r6.close();
        Path r7 = this.h;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L20:
        r7.moveTo(0.0f, 0.0f);
        Path r8 = this.h;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L23:
        r8.lineTo((float) (((double) C) + (((double) this.j) * Math.sqrt(2.0d))), (float) (((double) (-C)) - (((double) this.j) * Math.sqrt(2.0d))));
        Path r9 = this.h;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L26:
        r9.lineTo((float) (((double) C) + (((double) this.j) * Math.sqrt(2.0d))), (float) (((double) C) + (((double) this.j) * Math.sqrt(2.0d))));
        Path r11 = this.h;
        if (r11 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L29:
        r11.close();
    }

    public final float getBubbleOffset() {
        float r0 = Math.max(this.r, F);
        int r1 = this.s;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r0, this.f - F);
    L18:
        return Math.min(r0, this.g - F);
    L19:
        return Math.min(r0, this.g - F);
    L15:
        return Math.min(r0, this.f - F);
    }

    public final Path getMBorderBubbleArrowPath() {
        Path r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L5:
        return r0;
    }

    public final Matrix getMBorderMatrix() {
        Matrix r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L5:
        return r0;
    }

    public final RectF getMBorderRoundRect() {
        RectF r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L5:
        return r0;
    }

    public final Path getMBubbleArrowPath() {
        Path r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L5:
        return r0;
    }

    public final Paint getMFillPaint() {
        Paint r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L5:
        return r0;
    }

    public final Path getMPath() {
        Path r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L5:
        return r0;
    }

    public final int getPADDING() {
        return C / 2;
    }

    public final int getArrowHeight() {
        return this.B;
    }

    public final float getCornerRadius() {
        return this.z;
    }

    public final int getDefaultHeight() {
        return this.A;
    }

    public final int getMAdjustHeight() {
        return this.y;
    }

    public final int getMBgColor() {
        return this.n;
    }

    public final int getMBorderColor() {
        return this.o;
    }

    public final int getMBorderWidth() {
        return this.j;
    }

    public final float getMHeight() {
        return this.g;
    }

    public final boolean getMNeedAddColor() {
        return this.w;
    }

    public final boolean getMNeedArrow() {
        return this.v;
    }

    public final boolean getMNeedPath() {
        return this.t;
    }

    public final boolean getMNeedPressFade() {
        return this.u;
    }

    public final boolean getMNeedShadow() {
        return this.q;
    }

    public final float getMPadding() {
        return this.a;
    }

    public final int getMShadowColor() {
        return this.p;
    }

    public final float getMWidth() {
        return this.f;
    }

    public final boolean getUseDefaultView() {
        return this.x;
    }

    public LiveBubbleLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r14) {
        Intrinsics.checkNotNullParameter(r14, "canvas");
        if (this.l != null) goto L5;
        Resources r0 = getContext().getResources();
        Bitmap r1 = Bitmap.createBitmap(WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.l = r1;
        this.m = new Canvas(r1);
    L5:
        float r2 = this.f;
        float r3 = this.g;
        float r4 = Math.max(this.r, F);
        Matrix r5 = new Matrix();
        this.k = new Matrix();
        int r6 = this.s;
        if (r6 != 0) goto L8;
        float r7 = Math.min(r4, r2 - F);
        r5.postRotate(90.0f);
        Matrix r8 = this.k;
        if (r8 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L33:
        r8.postRotate(90.0f);
        Matrix r9 = this.k;
        if (r9 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L36:
        int r11 = this.j;
        r9.postTranslate((((r11 * 3) / 2) + r7) - ((C * 3) / 2), r11 + 0.0f);
        setPadding(0, C, 0, 0);
        setGravity(17);
        this.e = new RectF(0.0f, C, this.f, this.g);
        float r12 = (this.j * 3) / 2;
        r5.postTranslate((r7 + r12) - ((C * 3) / 2), 0.0f + r12);
    L37:
        RectF r13 = this.e;
        if (r13 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L40:
        r13.left += (this.j * 3) / 2;
        RectF r15 = this.e;
        if (r15 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L43:
        r15.top += (this.j * 3) / 2;
        RectF r16 = this.e;
        if (r16 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L46:
        r16.right += (this.j * 3) / 2;
        RectF r17 = this.e;
        if (r17 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L49:
        r17.bottom += (this.j * 3) / 2;
        RectF r18 = new RectF();
        this.i = r18;
        RectF r19 = this.e;
        if (r19 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L52:
        r18.left = r19.left - (this.j / 2);
        RectF r21 = this.i;
        if (r21 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L55:
        RectF r22 = this.e;
        if (r22 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L58:
        r21.top = r22.top - (this.j / 2);
        RectF r23 = this.i;
        if (r23 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L61:
        RectF r24 = this.e;
        if (r24 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L64:
        r23.right = r24.right + (this.j / 2);
        RectF r25 = this.i;
        if (r25 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L67:
        RectF r26 = this.e;
        if (r26 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L70:
        r25.bottom = r26.bottom + (this.j / 2);
        if (this.q == false) goto L77;
        Paint r27 = this.b;
        if (r27 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L75:
        r27.setShadowLayer(2.0f, 2.0f, 5.0f, this.p);
    L77:
        if (this.t == false) goto L156;
        Paint r28 = this.b;
        if (r28 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L81:
        r28.setColor(this.o);
        Paint r29 = this.b;
        if (r29 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L84:
        r29.setStyle(Paint.Style.STROKE);
        Paint r31 = this.b;
        if (r31 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L87:
        r31.setStrokeWidth(this.j);
        Path r32 = this.c;
        if (r32 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L90:
        r32.reset();
        Path r33 = this.c;
        if (r33 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L93:
        RectF r34 = this.i;
        if (r34 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L96:
        float r110 = this.z;
        int r111 = this.j;
        r33.addRoundRect(r34, (r111 / 2) + r110, r110 + (r111 / 2), Path.Direction.CW);
        if (this.v == false) goto L108;
        Path r35 = this.c;
        if (r35 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L101:
        Path r112 = this.h;
        if (r112 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L104:
        Matrix r113 = this.k;
        if (r113 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L107:
        r35.addPath(r112, r113);
    L108:
        Canvas r36 = this.m;
        if (r36 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L111:
        Path r114 = this.c;
        if (r114 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L114:
        Paint r115 = this.b;
        if (r115 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L117:
        r36.drawPath(r114, r115);
        if (this.w == false) goto L156;
        Paint r37 = this.b;
        if (r37 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L122:
        r37.setColor(getResources().getColor(2131108464));
        Paint r38 = this.b;
        if (r38 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L125:
        r38.setStyle(Paint.Style.STROKE);
        Path r39 = this.c;
        if (r39 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L128:
        r39.reset();
        if (this.v == false) goto L140;
        Path r41 = this.c;
        if (r41 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L133:
        Path r116 = this.h;
        if (r116 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L136:
        Matrix r42 = this.k;
        if (r42 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L139:
        r41.addPath(r116, r42);
    L140:
        Path r43 = this.c;
        if (r43 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L143:
        RectF r44 = this.i;
        if (r44 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L146:
        float r45 = this.z;
        int r46 = this.j;
        r43.addRoundRect(r44, (r46 / 2) + r45, r45 + (r46 / 2), Path.Direction.CW);
        Canvas r47 = this.m;
        if (r47 != null) goto L149;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L149:
        Path r48 = this.c;
        if (r48 != null) goto L152;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L152:
        Paint r49 = this.b;
        if (r49 != null) goto L155;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L155:
        r47.drawPath(r48, r49);
    L156:
        Paint r51 = this.b;
        if (r51 != null) goto L159;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L159:
        r51.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        Paint r52 = this.b;
        if (r52 != null) goto L162;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L162:
        r52.setColor(this.n);
        Paint r53 = this.b;
        if (r53 != null) goto L165;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L165:
        r53.setStyle(Paint.Style.FILL);
        Path r54 = this.c;
        if (r54 != null) goto L168;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L168:
        r54.reset();
        Path r55 = this.c;
        if (r55 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L171:
        RectF r56 = this.e;
        if (r56 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L174:
        float r57 = this.z;
        r55.addRoundRect(r56, r57, r57, Path.Direction.CW);
        if (this.v == false) goto L183;
        Path r58 = this.c;
        if (r58 != null) goto L179;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L179:
        Path r59 = this.d;
        if (r59 != null) goto L182;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L182:
        r58.addPath(r59, r5);
    L183:
        Canvas r61 = this.m;
        if (r61 != null) goto L186;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L186:
        Path r62 = this.c;
        if (r62 != null) goto L189;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L189:
        Paint r63 = this.b;
        if (r63 != null) goto L192;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L192:
        r61.drawPath(r62, r63);
        Paint r64 = this.b;
        if (r64 != null) goto L195;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L195:
        r64.setXfermode(null);
        Bitmap r65 = this.l;
        if (r65 == null) goto L199;
        r14.drawBitmap(r65, C - UIUtils.dip2Px(getContext(), 1.4f), C - UIUtils.dip2Px(getContext(), 1.3f), null);
        return;
    L199:
        return;
    L8:
        if (r6 == 1) goto L26;
        if (r6 == 2) goto L19;
        if (r6 != 3) goto L37;
        float r66 = Math.min(r4, r2 - F);
        r5.postRotate(270.0f);
        Matrix r67 = this.k;
        if (r67 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L15:
        r67.postRotate(270.0f);
        Matrix r68 = this.k;
        if (r68 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L18:
        int r69 = this.j;
        r68.postTranslate((((r69 * 3) / 2) + r66) - ((C * 3) / 2), (r69 * 2) + r3);
        setPadding(0, 0, 0, C);
        setGravity(17);
        this.e = new RectF(0.0f, 0.0f, this.f, this.g - C);
        float r71 = (this.j * 3) / 2;
        r5.postTranslate((r66 + r71) - ((C * 3) / 2), r3 + r71);
        goto L37
    L19:
        float r72 = Math.min(r4, r3 - F);
        r5.postRotate(180.0f);
        Matrix r73 = this.k;
        if (r73 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L22:
        r73.postRotate(180.0f);
        Matrix r74 = this.k;
        if (r74 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L25:
        float r75 = this.j * 2;
        r74.postTranslate(r75 + r2, (r75 + r72) - ((C * 3) / 2));
        setPadding(0, 0, C, 0);
        setGravity(17);
        this.e = new RectF(0.0f, 0.0f, this.f - C, this.g);
        int r76 = this.j;
        r5.postTranslate(r2 + ((r76 * 3) / 2), (r72 + (r76 * 2)) - ((C * 3) / 2));
        goto L37
    L26:
        float r77 = Math.min(r4, r3 - F);
        setPadding(C, 0, 0, 0);
        setGravity(17);
        Matrix r78 = this.k;
        if (r78 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L29:
        int r79 = this.j;
        r78.postTranslate(r79 + 0.0f, ((r79 * 2) + r77) - ((C * 3) / 2));
        this.e = new RectF(C, 0.0f, this.f, this.g);
        int r81 = this.j;
        r5.postTranslate(0.0f + ((r81 * 3) / 2), (r77 + (r81 * 2)) - ((C * 3) / 2));
        goto L37
    }

    public final void setArrowHeight(int r1) {
        this.B = r1;
        C = r1;
        a();
    }

    public final void setBubbleOrientation(int r1) {
        this.s = r1;
    }

    public final void setCornerRadius(float r1) {
        this.z = r1;
    }

    public final void setDefaultHeight(int r1) {
        this.A = r1;
    }

    public final void setMAdjustHeight(int r1) {
        this.y = r1;
    }

    public final void setMBgColor(int r1) {
        this.n = r1;
    }

    public final void setMBorderBubbleArrowPath(Path r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    public final void setMBorderColor(int r1) {
        this.o = r1;
    }

    public final void setMBorderMatrix(Matrix r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.k = r2;
    }

    public final void setMBorderRoundRect(RectF r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i = r2;
    }

    public final void setMBorderWidth(int r1) {
        this.j = r1;
    }

    public final void setMBubbleArrowPath(Path r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setMFillPaint(Paint r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setMHeight(float r1) {
        this.g = r1;
    }

    public final void setMNeedAddColor(boolean r1) {
        this.w = r1;
    }

    public final void setMNeedArrow(boolean r1) {
        this.v = r1;
    }

    public final void setMNeedPath(boolean r1) {
        this.t = r1;
    }

    public final void setMNeedPressFade(boolean r1) {
        this.u = r1;
    }

    public final void setMNeedShadow(boolean r1) {
        this.q = r1;
    }

    public final void setMPadding(float r1) {
        this.a = r1;
    }

    public final void setMPath(Path r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setMShadowColor(int r1) {
        this.p = r1;
    }

    public final void setMWidth(float r1) {
        this.f = r1;
    }

    public final void setNeedAddColor(boolean r1) {
        this.w = r1;
    }

    public final void setUseDefaultView(boolean r1) {
        this.x = r1;
    }

    public LiveBubbleLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r11, int r12) {
        super.onMeasure(r11, r12);
        D = (int) UIUtils.dip2Px(getContext(), this.a + 5.0f);
        if ((getChildAt(0) instanceof TextView) == false) goto L9;
        View r1 = getChildAt(0);
        if (r1 == null) goto L8;
        TextView r2 = (TextView) r1;
    L10:
        int r3 = View.MeasureSpec.getMode(r11);
        int r13 = View.MeasureSpec.getSize(r11);
        int r4 = View.MeasureSpec.getMode(r12);
        int r14 = View.MeasureSpec.getSize(r12);
        if (r2 != null) goto L13;
        int r6 = getMeasuredWidth();
        char r7 = 0;
    L19:
        if (this.x == false) goto L34;
        int r0 = this.s;
        if (r0 == 2) goto L27;
        if (r0 == 1) goto L27;
        int r5 = G;
        if (r6 <= r5) goto L31;
        r5 = (D * 2) + r6;
    L31:
        if (r7 != 1) goto L33;
        int r8 = this.A;
    L35:
        int r9 = this.j;
        int r15 = r5 + (r9 * 3);
        int r16 = r8 + ((r9 * 3) + this.y);
        if (r3 != Integer.MIN_VALUE) goto L39;
        if (r4 != Integer.MIN_VALUE) goto L39;
        setMeasuredDimension(r15, r16);
    L43:
        this.f = getMeasuredWidth() - (C * 2);
        this.g = getMeasuredHeight() - (C * 2);
        return;
    L39:
        if (r3 != Integer.MIN_VALUE) goto L41;
        setMeasuredDimension(r15, r14);
        goto L43
    L41:
        if (r4 != Integer.MIN_VALUE) goto L43;
        setMeasuredDimension(r13, r16);
        goto L43
    L33:
        r8 = this.A + 19;
    L27:
        int r17 = G;
        if (r6 <= r17) goto L30;
        r17 = (D * 2) + r6;
    L30:
        r5 = r17 + C;
        goto L31
    L34:
        PopupWindow r18 = new PopupWindow(getChildAt(0), -2, -2, true);
        r18.getContentView().measure(0, 0);
        r5 = (r18.getContentView().getMeasuredWidth() + (C * 3)) + D;
        r8 = (r18.getContentView().getMeasuredHeight() + (C * 3)) + D;
        goto L35
    L13:
        if (((int) r2.getPaint().measureText(r2.getText().toString())) <= UIUtils.dip2Px(getContext(), 197.0f)) goto L15;
        int r19 = (int) UIUtils.dip2Px(getContext(), 197.0f);
        r7 = 2;
    L16:
        r6 = (r19 + r2.getPaddingLeft()) + r2.getPaddingRight();
        goto L19
    L15:
        r19 = (int) r2.getPaint().measureText(r2.getText().toString());
        r7 = 1;
        goto L16
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L9:
        r2 = null;
        goto L10
    }

    public LiveBubbleLayout(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = 12.0f;
        this.p = -16777216;
        this.r = 0.75f;
        this.s = 1;
        this.t = true;
        this.v = true;
        this.w = true;
        this.x = true;
        this.z = UIUtils.dip2Px(getContext(), 8.0f);
        this.A = (int) UIUtils.dip2Px(getContext(), 56.0f);
        this.B = (int) UIUtils.dip2Px(getContext(), 7.0f);
        new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        Intrinsics.checkNotNullParameter(r3, "context");
        this.j = (int) UIUtils.dip2Px(r3, 0.7f);
        C = this.B;
        E = 2.0f;
        F = UIUtils.dip2Px(r3, 3.0f);
        G = (int) UIUtils.dip2Px(r3, 40.0f);
        this.b = new Paint();
        this.c = new Path();
        this.h = new Path();
        this.d = new Path();
        Paint r6 = this.b;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L5:
        r6.setStyle(Paint.Style.FILL);
        Paint r7 = this.b;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L8:
        r7.setStrokeCap(Paint.Cap.BUTT);
        Paint r8 = this.b;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L11:
        r8.setAntiAlias(true);
        Paint r9 = this.b;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L14:
        r9.setStrokeWidth(E);
        Paint r11 = this.b;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L17:
        r11.setStrokeJoin(Paint.Join.MITER);
        this.n = getResources().getColor(2131108462);
        this.o = getResources().getColor(2131108201);
        Paint r12 = this.b;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L20:
        r12.setColor(this.n);
        Paint r13 = this.b;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L23:
        setLayerType(1, r13);
        if (this.q == false) goto L29;
        Paint r14 = this.b;
        if (r14 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L28:
        r14.setShadowLayer(2.0f, 2.0f, 5.0f, this.p);
    L29:
        a();
        setBackgroundColor(0);
        setClipChildren(false);
    }
}
