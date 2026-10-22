package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoView extends AppCompatImageView {
    private k attacher;
    private ImageView.ScaleType pendingScaleType;

    public PhotoView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public PhotoView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public PhotoView(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
        init();
    }

    private void init() {
        this.attacher = new k(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType r0 = this.pendingScaleType;
        if (r0 == null) goto L6;
        setScaleType(r0);
        this.pendingScaleType = null;
        return;
    }

    public k getAttacher() {
        return this.attacher;
    }

    public void getDisplayMatrix(Matrix r1) {
        this.attacher.b(r1);
    }

    public RectF getDisplayRect() {
        return this.attacher.a();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.attacher.h();
    }

    public float getMaximumScale() {
        return this.attacher.d();
    }

    public float getMediumScale() {
        return this.attacher.c();
    }

    public float getMinimumScale() {
        return this.attacher.b();
    }

    public float getScale() {
        return this.attacher.e();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.attacher.f();
    }

    public void getSuppMatrix(Matrix r1) {
        this.attacher.c(r1);
    }

    public boolean isZoomable() {
        return this.attacher.g();
    }

    public void setAllowParentInterceptOnEdge(boolean r1) {
        this.attacher.a(r1);
    }

    public boolean setDisplayMatrix(Matrix r1) {
        return this.attacher.a(r1);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int r1, int r2, int r3, int r4) {
        boolean r5 = super.setFrame(r1, r2, r3, r4);
        if (r5 == false) goto L5;
        this.attacher.update();
    L5:
        return r5;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r1) {
        super.setImageDrawable(r1);
        k r0 = this.attacher;
        if (r0 == null) goto L6;
        r0.update();
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r1) {
        super.setImageResource(r1);
        k r0 = this.attacher;
        if (r0 == null) goto L6;
        r0.update();
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri r1) {
        super.setImageURI(r1);
        k r0 = this.attacher;
        if (r0 == null) goto L6;
        r0.update();
        return;
    }

    public void setMaximumScale(float r1) {
        this.attacher.e(r1);
    }

    public void setMediumScale(float r1) {
        this.attacher.d(r1);
    }

    public void setMinimumScale(float r1) {
        this.attacher.c(r1);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        this.attacher.a(r4);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r3) {
        GestureDetector.OnDoubleTapListener r4 = (GestureDetector.OnDoubleTapListener) ZeusTransformUtils.wrapperContextForParams(r3, GestureDetector.OnDoubleTapListener.class, "com.obric.memorydata.plugin");
        this.attacher.a(r4);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r3) {
        View.OnLongClickListener r4 = (View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnLongClickListener.class, "com.obric.memorydata.plugin");
        this.attacher.a(r4);
    }

    public void setOnMatrixChangeListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        this.attacher.a(r4);
    }

    public void setOnOutsidePhotoTapListener(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        this.attacher.a(r4);
    }

    public void setOnPhotoTapListener(f r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        this.attacher.a(r4);
    }

    public void setOnScaleChangeListener(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        this.attacher.a(r4);
    }

    public void setOnSingleFlingListener(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
        this.attacher.a(r4);
    }

    public void setOnViewDragListener(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        this.attacher.a(r4);
    }

    public void setOnViewTapListener(j r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        this.attacher.a(r4);
    }

    public void setRotationBy(float r1) {
        this.attacher.b(r1);
    }

    public void setRotationTo(float r1) {
        this.attacher.a(r1);
    }

    public void setScale(float r1) {
        this.attacher.f(r1);
    }

    public void setScale(float r1, float r2, float r3, boolean r4) {
        this.attacher.a(r1, r2, r3, r4);
    }

    public void setScale(float r1, boolean r2) {
        this.attacher.a(r1, r2);
    }

    public void setScaleLevels(float r1, float r2, float r3) {
        this.attacher.a(r1, r2, r3);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r2) {
        k r0 = this.attacher;
        if (r0 != null) goto L5;
        this.pendingScaleType = r2;
        return;
    L5:
        r0.a(r2);
    }

    public boolean setSuppMatrix(Matrix r1) {
        return this.attacher.a(r1);
    }

    public void setZoomTransitionDuration(int r1) {
        this.attacher.a(r1);
    }

    public void setZoomable(boolean r1) {
        this.attacher.b(r1);
    }
}
