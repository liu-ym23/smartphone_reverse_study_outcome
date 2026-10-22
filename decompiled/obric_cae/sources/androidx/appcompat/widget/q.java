package androidx.appcompat.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.bytedance.keva.KevaImpl;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f1245c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProgressBar f1246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f1247b;

    static {
        f1245c = new int[]{R.attr.indeterminateDrawable, R.attr.progressDrawable};
    }

    public q(ProgressBar r8) {
        this.f1246a = r8;
    }

    public void a(AttributeSet r10, int r11) {
        ProgressBar r8 = this.f1246a;
        v0 r12 = v0.m(r8.getContext(), r10, f1245c, r11);
        Drawable r13 = r12.f(0);
        if (r13 != null) goto L5;
    L12:
        Drawable r14 = r12.f(1);
        if (r14 == null) goto L15;
        r8.setProgressDrawable(b(r14, false));
    L15:
        r12.n();
        return;
    L5:
        if ((r13 instanceof AnimationDrawable) == false) goto L11;
        AnimationDrawable r15 = (AnimationDrawable) r13;
        int r16 = r15.getNumberOfFrames();
        AnimationDrawable r17 = new AnimationDrawable();
        r17.setOneShot(r15.isOneShot());
        int r18 = 0;
    L8:
        if (r18 >= r16) goto L10;
        Drawable r19 = b(r15.getFrame(r18), true);
        r19.setLevel(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        r17.addFrame(r19, r15.getDuration(r18));
        r18 = r18 + 1;
        goto L8
    L10:
        r17.setLevel(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        r13 = r17;
    L11:
        r8.setIndeterminateDrawable(r13);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Drawable b(Drawable r8, boolean r10) {
        if ((r8 instanceof b0.b) == false) goto L8;
        b0.b r11 = (b0.b) r8;
        Drawable r12 = r11.a();
        if (r12 == null) goto L32;
        r11.b(b(r12, r10));
    L32:
        return r8;
    L8:
        if ((r8 instanceof LayerDrawable) == false) goto L24;
        LayerDrawable r13 = (LayerDrawable) r8;
        int r14 = r13.getNumberOfLayers();
        Drawable[] r15 = new Drawable[r14];
        int r16 = 0;
        int r17 = 0;
    L10:
        if (r17 >= r14) goto L19;
        int r18 = r13.getId(r17);
        Drawable r19 = r13.getDrawable(r17);
        if (r18 != 16908301) goto L14;
    L17:
        boolean r20 = true;
    L18:
        r15[r17] = b(r19, r20);
        r17 = r17 + 1;
        goto L10
    L14:
        if (r18 == 16908303) goto L17;
        r20 = false;
        goto L18
    L19:
        LayerDrawable r21 = new LayerDrawable(r15);
    L20:
        if (r16 >= r14) goto L22;
        r21.setId(r16, r13.getId(r16));
        r21.setLayerGravity(r16, r13.getLayerGravity(r16));
        r21.setLayerWidth(r16, r13.getLayerWidth(r16));
        r21.setLayerHeight(r16, r13.getLayerHeight(r16));
        r21.setLayerInsetLeft(r16, r13.getLayerInsetLeft(r16));
        r21.setLayerInsetRight(r16, r13.getLayerInsetRight(r16));
        r21.setLayerInsetTop(r16, r13.getLayerInsetTop(r16));
        r21.setLayerInsetBottom(r16, r13.getLayerInsetBottom(r16));
        r21.setLayerInsetStart(r16, r13.getLayerInsetStart(r16));
        r21.setLayerInsetEnd(r16, r13.getLayerInsetEnd(r16));
        r16 = r16 + 1;
        goto L20
    L22:
        return r21;
    L24:
        if ((r8 instanceof BitmapDrawable) == false) goto L32;
        BitmapDrawable r22 = (BitmapDrawable) r8;
        Bitmap r23 = r22.getBitmap();
        if (this.f1247b != null) goto L28;
        this.f1247b = r23;
    L28:
        ShapeDrawable r24 = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
        r24.getPaint().setShader(new BitmapShader(r23, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
        r24.getPaint().setColorFilter(r22.getPaint().getColorFilter());
        if (r10 == true) goto L31;
        return r24;
    L31:
        return new ClipDrawable(r24, 3, 1);
    }
}
