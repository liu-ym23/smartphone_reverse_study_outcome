package com.google.android.material.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class f extends Property<ImageView, Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matrix f3747a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.f3747a = new Matrix();
    }

    public Matrix a(ImageView r2) {
        this.f3747a.set(r2.getImageMatrix());
        return this.f3747a;
    }

    public void a(ImageView r1, Matrix r2) {
        r1.setImageMatrix(r2);
    }

    @Override // android.util.Property
    public /* synthetic */ Matrix get(ImageView r3) {
        return a((ImageView) ZeusTransformUtils.preCheckCast(r3, ImageView.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.util.Property
    public /* synthetic */ void set(ImageView r3, Matrix r4) {
        a((ImageView) ZeusTransformUtils.preCheckCast(r3, ImageView.class, "com.obric.memorydata.plugin"), (Matrix) ZeusTransformUtils.preCheckCast(r4, Matrix.class, "com.obric.memorydata.plugin"));
    }
}
