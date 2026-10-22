package a6;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f110i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float[] f111j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f112k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float[] f113l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final Paint f114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final Paint f115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final Paint f116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint f121h;

    static {
        f110i = new int[3];
        f111j = new float[]{0.0f, 0.5f, 1.0f};
        f112k = new int[4];
        f113l = new float[]{0.0f, 0.0f, 0.5f, 1.0f};
    }

    public a() {
        this(ViewCompat.MEASURED_STATE_MASK);
    }

    public a(int r10) {
        this.f120g = new Path();
        this.f121h = new Paint();
        this.f114a = new Paint();
        d(r10);
        this.f121h.setColor(0);
        Paint r11 = new Paint(4);
        this.f115b = r11;
        r11.setStyle(Paint.Style.FILL);
        this.f116c = new Paint(r11);
    }

    public void a(@NonNull Canvas r21, @Nullable Matrix r22, @NonNull RectF r23, int r24, float r25, float r26) {
        if (r26 >= 0.0f) goto L5;
        boolean r10 = true;
    L6:
        Path r11 = this.f120g;
        if (r10 == false) goto L9;
        int[] r12 = f112k;
        r12[0] = 0;
        r12[1] = this.f119f;
        r12[2] = this.f118e;
        r12[3] = this.f117d;
    L10:
        float r16 = r23.width() / 2.0f;
        if (r16 > 0.0f) goto L13;
        return;
    L13:
        float r13 = 1.0f - (r24 / r16);
        float[] r18 = f113l;
        r18[1] = r13;
        r18[2] = ((1.0f - r13) / 2.0f) + r13;
        this.f115b.setShader(new RadialGradient(r23.centerX(), r23.centerY(), r16, f112k, r18, Shader.TileMode.CLAMP));
        r21.save();
        r21.concat(r22);
        r21.scale(1.0f, r23.height() / r23.width());
        if (r10 == true) goto L16;
        r21.clipPath(r11, Region.Op.DIFFERENCE);
        r21.drawPath(r11, this.f121h);
    L16:
        r21.drawArc(r23, r25, r26, true, this.f115b);
        r21.restore();
        return;
    L9:
        r11.rewind();
        r11.moveTo(r23.centerX(), r23.centerY());
        r11.arcTo(r23, r25, r26);
        r11.close();
        float r14 = -r24;
        r23.inset(r14, r14);
        int[] r15 = f112k;
        r15[0] = 0;
        r15[1] = this.f117d;
        r15[2] = this.f118e;
        r15[3] = this.f119f;
        goto L10
    L5:
        r10 = false;
        goto L6
    }

    public void b(@NonNull Canvas r10, @Nullable Matrix r11, @NonNull RectF r12, int r13) {
        r12.bottom += r13;
        r12.offset(0.0f, -r13);
        int[] r14 = f110i;
        r14[0] = this.f119f;
        r14[1] = this.f118e;
        r14[2] = this.f117d;
        Paint r15 = this.f116c;
        float r16 = r12.left;
        r15.setShader(new LinearGradient(r16, r12.top, r16, r12.bottom, r14, f111j, Shader.TileMode.CLAMP));
        r10.save();
        r10.concat(r11);
        r10.drawRect(r12, this.f116c);
        r10.restore();
    }

    @NonNull
    public Paint c() {
        return this.f114a;
    }

    public void d(int r10) {
        this.f117d = ColorUtils.setAlphaComponent(r10, 68);
        this.f118e = ColorUtils.setAlphaComponent(r10, 20);
        this.f119f = ColorUtils.setAlphaComponent(r10, 0);
        this.f114a.setColor(this.f117d);
    }
}
