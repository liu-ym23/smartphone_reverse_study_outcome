package com.larus.bmhome.view.markableview.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\"\b\u0016\u0018\u0000 U2\u00020\u0001:\u0002TUB)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010 J\u0010\u00100\u001a\u00020.2\u0006\u00101\u001a\u000202H\u0016J\u000e\u00107\u001a\u0002042\u0006\u00108\u001a\u00020\u0012J\u000e\u0010;\u001a\u0002042\u0006\u00108\u001a\u00020\u0012J\u0010\u0010<\u001a\u00020.2\u0006\u00108\u001a\u00020\u0012H\u0016J\u0018\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u0002042\u0006\u0010B\u001a\u000204H\u0016J \u0010C\u001a\u00020.2\u0006\u0010D\u001a\u0002042\u0006\u0010E\u001a\u0002042\u0006\u0010F\u001a\u000204H\u0016J\u001e\u0010G\u001a\u00020.2\u0006\u0010H\u001a\u0002042\u0006\u0010E\u001a\u0002042\u0006\u0010F\u001a\u000204J\b\u0010I\u001a\u00020.H\u0004J0\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020(2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0007H\u0014J\b\u0010P\u001a\u00020.H\u0014J\u001a\u0010Q\u001a\u0002042\u0006\u00108\u001a\u00020\u00122\b\b\u0001\u0010R\u001a\u00020\u0007H\u0004J\b\u0010S\u001a\u00020.H\u0004R\u0014\u0010\n\u001a\u00020\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u00103\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b5\u00106R\u0011\u00109\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b:\u00106R\u0013\u0010=\u001a\u0004\u0018\u0001028F¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006V"}, d2 = {"Lcom/larus/bmhome/view/markableview/base/TransformImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCurrentImageCorners", "", "getMCurrentImageCorners", "()[F", "mCurrentImageCenter", "getMCurrentImageCenter", "mMatrixValues", "mCurrentImageMatrix", "Landroid/graphics/Matrix;", "getMCurrentImageMatrix", "()Landroid/graphics/Matrix;", "setMCurrentImageMatrix", "(Landroid/graphics/Matrix;)V", "mThisWidth", "getMThisWidth", "()I", "setMThisWidth", "(I)V", "mThisHeight", "getMThisHeight", "setMThisHeight", "mTransformImageListener", "Lcom/larus/bmhome/view/markableview/base/TransformImageView$TransformImageListener;", "getMTransformImageListener", "()Lcom/larus/bmhome/view/markableview/base/TransformImageView$TransformImageListener;", "setMTransformImageListener", "(Lcom/larus/bmhome/view/markableview/base/TransformImageView$TransformImageListener;)V", "mInitialImageCorners", "mInitialImageCenter", "mBitmapLaidOut", "", "getMBitmapLaidOut", "()Z", "setMBitmapLaidOut", "(Z)V", "setTransformImageListener", "", "transformImageListener", "setImageBitmap", "bitmap", "Landroid/graphics/Bitmap;", "currentScale", "", "getCurrentScale", "()F", "getMatrixScale", "matrix", "currentAngle", "getCurrentAngle", "getMatrixAngle", "setImageMatrix", "viewBitmap", "getViewBitmap", "()Landroid/graphics/Bitmap;", "postTranslate", "deltaX", "deltaY", "postScale", "deltaScale", "px", "py", "postRotate", "deltaAngle", "init", "onLayout", "changed", "left", "top", "right", "bottom", "onImageLaidOut", "getMatrixValue", "valueIndex", "updateCurrentImagePoints", "TransformImageListener", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TransformImageView extends AppCompatImageView {
    public final float[] a;
    public final float[] b;
    public final float[] c;
    public Matrix d;
    public int e;
    public int f;
    public float[] g;
    public float[] h;
    public boolean i;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public TransformImageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TransformImageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final b getMTransformImageListener() {
        return null;
    }

    public final void setMTransformImageListener(b r1) {
    }

    public final void setTransformImageListener(b r1) {
    }

    public final float getCurrentAngle() {
        Matrix r0 = this.d;
        Intrinsics.checkNotNullParameter(r0, "matrix");
        return -((float) (Math.atan2(j(r0, 1), j(r0, 0)) * 57.29577951308232d));
    }

    public final float getCurrentScale() {
        Matrix r0 = this.d;
        Intrinsics.checkNotNullParameter(r0, "matrix");
        return (float) Math.sqrt(Math.pow(j(r0, 0), 2.0d) + Math.pow(j(r0, 3), 2.0d));
    }

    public final void m() {
        Matrix r0 = this.d;
        float[] r1 = this.a;
        float[] r2 = this.g;
        float[] r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInitialImageCorners");
        r2 = null;
    L5:
        r0.mapPoints(r1, r2);
        Matrix r4 = this.d;
        float[] r5 = this.b;
        float[] r6 = this.h;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mInitialImageCenter");
    L9:
        r4.mapPoints(r5, r3);
        return;
    L8:
        r3 = r6;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Bitmap getViewBitmap() {
        if (getDrawable() != null) goto L5;
    L8:
        return null;
    L5:
        if ((getDrawable() instanceof jt8.a) == false) goto L8;
        Drawable r0 = getDrawable();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.bmhome.view.markableview.base.FastBitmapDrawable");
        return ((jt8.a) r0).b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l() {
        if (getDrawable() != null) goto L5;
        return;
    L5:
        int r0 = getDrawable().getIntrinsicWidth();
        int r1 = getDrawable().getIntrinsicHeight();
        FLogger.a.d("TransformImageView", "Image size: [" + r0 + ':' + r1 + ']');
        RectF r2 = new RectF(0.0f, 0.0f, (float) r0, (float) r1);
        float r3 = r2.left;
        float r4 = r2.top;
        float r6 = r2.right;
        float r5 = r2.bottom;
        this.g = new float[]{r3, r4, r6, r4, r6, r5, r3, r5};
        this.h = new float[]{r2.centerX(), r2.centerY()};
        this.i = true;
    }

    public final boolean getMBitmapLaidOut() {
        return this.i;
    }

    public final float[] getMCurrentImageCenter() {
        return this.b;
    }

    public final float[] getMCurrentImageCorners() {
        return this.a;
    }

    public final Matrix getMCurrentImageMatrix() {
        return this.d;
    }

    public final int getMThisHeight() {
        return this.f;
    }

    public final int getMThisWidth() {
        return this.e;
    }

    public void setImageBitmap(Bitmap r2) {
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        setImageDrawable(new jt8.a(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageMatrix(Matrix r2) {
        Intrinsics.checkNotNullParameter(r2, "matrix");
        super/*android.widget.ImageView*/.setImageMatrix(r2);
        this.d.set(r2);
        m();
    }

    public final void setMBitmapLaidOut(boolean r1) {
        this.i = r1;
    }

    public final void setMCurrentImageMatrix(Matrix r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setMThisHeight(int r1) {
        this.f = r1;
    }

    public final void setMThisWidth(int r1) {
        this.e = r1;
    }

    public final float j(Matrix r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "matrix");
        r2.getValues(this.c);
        return this.c[r3];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransformImageView(Context r1, AttributeSet r2, int r3) {
        Intrinsics.checkNotNull(r1);
        super(r1, r2, r3);
        this.a = new float[8];
        this.b = new float[2];
        this.c = new float[9];
        this.d = new Matrix();
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public /* synthetic */ TransformImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super/*android.widget.ImageView*/.onLayout(r1, r2, r3, r4, r5);
        if (r1 == false) goto L5;
    L6:
        this.e = (getWidth() - getPaddingLeft()) - getPaddingRight();
        this.f = (getHeight() - getPaddingTop()) - getPaddingBottom();
        l();
        return;
    L5:
        if (this.i == false) goto L6;
    }
}
