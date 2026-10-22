package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class ImageMatrixProperty extends Property<ImageView, Matrix> {
    private final Matrix matrix;

    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
        this.matrix = new Matrix();
    }

    @Override // android.util.Property
    @NonNull
    public /* bridge */ /* synthetic */ Matrix get(@NonNull ImageView r5) {
        return get2(r5);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull ImageView r5, @NonNull Matrix r10) {
        set2(r5, r10);
    }

    @NonNull
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Matrix get2(@NonNull ImageView r5) {
        this.matrix.set(r5.getImageMatrix());
        return this.matrix;
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(@NonNull ImageView r5, @NonNull Matrix r10) {
        r5.setImageMatrix(r10);
    }
}
