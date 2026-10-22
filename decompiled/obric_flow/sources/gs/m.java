package gs;

import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float[] f17220j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f17221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PorterDuffXfermode f17222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f17223c;
    public final Matrix d;
    public boolean e;
    public float f;
    public LinearGradient g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearGradient f17224h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f17225i;

    static {
        f17220j = new float[]{0.0f, 1.0f};
    }

    public m() {
        this.f17221a = new Paint(1);
        this.f17222b = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.f17223c = new Matrix();
        this.d = new Matrix();
        this.f17225i = -1.0f;
    }
}
