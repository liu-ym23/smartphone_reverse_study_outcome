package r5;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class f extends Property<ImageView, Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matrix f12682a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.f12682a = new Matrix();
    }

    @NonNull
    public Matrix a(@NonNull ImageView r10) {
        this.f12682a.set(r10.getImageMatrix());
        return this.f12682a;
    }

    public void b(@NonNull ImageView r10, @NonNull Matrix r11) {
        r10.setImageMatrix(r11);
    }

    @Override // android.util.Property
    @NonNull
    public /* bridge */ /* synthetic */ Matrix get(@NonNull ImageView r10) {
        return a(r10);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull ImageView r10, @NonNull Matrix r11) {
        b(r10, r11);
    }
}
