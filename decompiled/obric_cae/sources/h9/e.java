package h9;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public final class e extends Property<ImageView, Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f7951a;

    public e() {
        super(Matrix.class, "imageMatrixProperty");
        this.f7951a = new Matrix();
    }

    @Override // android.util.Property
    public final Matrix get(ImageView r8) {
        Matrix r10 = this.f7951a;
        r10.set(r8.getImageMatrix());
        return r10;
    }

    @Override // android.util.Property
    public final void set(ImageView r8, Matrix r10) {
        r8.setImageMatrix(r10);
    }
}
