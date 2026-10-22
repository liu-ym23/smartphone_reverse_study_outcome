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
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.drawable.WrappedDrawable;
import com.bytedance.keva.KevaImpl;

/* JADX INFO: loaded from: classes.dex */
class AppCompatProgressBarHelper {
    private static final int[] TINT_ATTRS = null;
    private Bitmap mSampleTile;
    private final ProgressBar mView;

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void transferLayerProperties(LayerDrawable r5, LayerDrawable r10, int r11) {
            r10.setLayerGravity(r11, r5.getLayerGravity(r11));
            r10.setLayerWidth(r11, r5.getLayerWidth(r11));
            r10.setLayerHeight(r11, r5.getLayerHeight(r11));
            r10.setLayerInsetLeft(r11, r5.getLayerInsetLeft(r11));
            r10.setLayerInsetRight(r11, r5.getLayerInsetRight(r11));
            r10.setLayerInsetTop(r11, r5.getLayerInsetTop(r11));
            r10.setLayerInsetBottom(r11, r5.getLayerInsetBottom(r11));
            r10.setLayerInsetStart(r11, r5.getLayerInsetStart(r11));
            r10.setLayerInsetEnd(r11, r5.getLayerInsetEnd(r11));
        }
    }

    static {
        TINT_ATTRS = new int[]{R.attr.indeterminateDrawable, R.attr.progressDrawable};
    }

    public AppCompatProgressBarHelper(ProgressBar r5) {
        this.mView = r5;
    }

    private Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    private Drawable tileifyIndeterminate(Drawable r10) {
        if ((r10 instanceof AnimationDrawable) == false) goto L11;
        AnimationDrawable r11 = (AnimationDrawable) r10;
        int r5 = r11.getNumberOfFrames();
        AnimationDrawable r12 = new AnimationDrawable();
        r12.setOneShot(r11.isOneShot());
        int r13 = 0;
    L6:
        if (r13 >= r5) goto L8;
        Drawable r14 = tileify(r11.getFrame(r13), true);
        r14.setLevel(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        r12.addFrame(r14, r11.getDuration(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        r12.setLevel(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        return r12;
    L11:
        return r10;
    }

    public Bitmap getSampleTile() {
        return this.mSampleTile;
    }

    public void loadFromAttributes(AttributeSet r5, int r10) {
        TintTypedArray r11 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r5, TINT_ATTRS, r10, 0);
        Drawable r12 = r11.getDrawableIfKnown(0);
        if (r12 == null) goto L5;
        this.mView.setIndeterminateDrawable(tileifyIndeterminate(r12));
    L5:
        Drawable r13 = r11.getDrawableIfKnown(1);
        if (r13 == null) goto L8;
        this.mView.setProgressDrawable(tileify(r13, false));
    L8:
        r11.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    public Drawable tileify(Drawable r10, boolean r11) {
        if ((r10 instanceof WrappedDrawable) == false) goto L8;
        WrappedDrawable r5 = (WrappedDrawable) r10;
        Drawable r12 = r5.getWrappedDrawable();
        if (r12 == null) goto L32;
        r5.setWrappedDrawable(tileify(r12, r11));
    L32:
        return r10;
    L8:
        if ((r10 instanceof LayerDrawable) == false) goto L24;
        LayerDrawable r13 = (LayerDrawable) r10;
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
        r15[r17] = tileify(r19, r20);
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
        Api23Impl.transferLayerProperties(r13, r21, r16);
        r16 = r16 + 1;
        goto L20
    L22:
        return r21;
    L24:
        if ((r10 instanceof BitmapDrawable) == false) goto L32;
        BitmapDrawable r22 = (BitmapDrawable) r10;
        Bitmap r23 = r22.getBitmap();
        if (this.mSampleTile != null) goto L28;
        this.mSampleTile = r23;
    L28:
        ShapeDrawable r24 = new ShapeDrawable(getDrawableShape());
        r24.getPaint().setShader(new BitmapShader(r23, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
        r24.getPaint().setColorFilter(r22.getPaint().getColorFilter());
        if (r11 == true) goto L31;
        return r24;
    L31:
        return new ClipDrawable(r24, 3, 1);
    }
}
