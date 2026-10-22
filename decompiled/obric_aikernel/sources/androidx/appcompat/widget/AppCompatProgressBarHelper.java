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
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.drawable.WrappedDrawable;

/* JADX INFO: loaded from: classes.dex */
class AppCompatProgressBarHelper {
    private static final int[] TINT_ATTRS = null;
    private Bitmap mSampleTile;
    private final ProgressBar mView;

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        public static void transferLayerProperties(LayerDrawable r10, LayerDrawable r11, int r12) {
            r11.setLayerGravity(r12, r10.getLayerGravity(r12));
            r11.setLayerWidth(r12, r10.getLayerWidth(r12));
            r11.setLayerHeight(r12, r10.getLayerHeight(r12));
            r11.setLayerInsetLeft(r12, r10.getLayerInsetLeft(r12));
            r11.setLayerInsetRight(r12, r10.getLayerInsetRight(r12));
            r11.setLayerInsetTop(r12, r10.getLayerInsetTop(r12));
            r11.setLayerInsetBottom(r12, r10.getLayerInsetBottom(r12));
            r11.setLayerInsetStart(r12, r10.getLayerInsetStart(r12));
            r11.setLayerInsetEnd(r12, r10.getLayerInsetEnd(r12));
        }
    }

    static {
        TINT_ATTRS = new int[]{R.attr.indeterminateDrawable, R.attr.progressDrawable};
    }

    AppCompatProgressBarHelper(ProgressBar r10) {
        this.mView = r10;
    }

    private Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    private Drawable tileifyIndeterminate(Drawable r10) {
        if ((r10 instanceof AnimationDrawable) == false) goto L11;
        AnimationDrawable r11 = (AnimationDrawable) r10;
        int r12 = r11.getNumberOfFrames();
        AnimationDrawable r13 = new AnimationDrawable();
        r13.setOneShot(r11.isOneShot());
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L8;
        Drawable r15 = tileify(r11.getFrame(r14), true);
        r15.setLevel(10000);
        r13.addFrame(r15, r11.getDuration(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        r13.setLevel(10000);
        return r13;
    L11:
        return r10;
    }

    Bitmap getSampleTile() {
        return this.mSampleTile;
    }

    void loadFromAttributes(AttributeSet r10, int r11) {
        TintTypedArray r12 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r10, TINT_ATTRS, r11, 0);
        Drawable r13 = r12.getDrawableIfKnown(0);
        if (r13 == null) goto L5;
        this.mView.setIndeterminateDrawable(tileifyIndeterminate(r13));
    L5:
        Drawable r14 = r12.getDrawableIfKnown(1);
        if (r14 == null) goto L8;
        this.mView.setProgressDrawable(tileify(r14, false));
    L8:
        r12.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    Drawable tileify(Drawable r10, boolean r11) {
        if ((r10 instanceof WrappedDrawable) == false) goto L8;
        WrappedDrawable r12 = (WrappedDrawable) r10;
        Drawable r13 = r12.getWrappedDrawable();
        if (r13 == null) goto L35;
        r12.setWrappedDrawable(tileify(r13, r11));
    L35:
        return r10;
    L8:
        if ((r10 instanceof LayerDrawable) == false) goto L27;
        LayerDrawable r14 = (LayerDrawable) r10;
        int r15 = r14.getNumberOfLayers();
        Drawable[] r16 = new Drawable[r15];
        int r17 = 0;
        int r18 = 0;
    L10:
        if (r18 >= r15) goto L19;
        int r19 = r14.getId(r18);
        Drawable r20 = r14.getDrawable(r18);
        if (r19 != 16908301) goto L14;
    L17:
        boolean r21 = true;
    L18:
        r16[r18] = tileify(r20, r21);
        r18 = r18 + 1;
        goto L10
    L14:
        if (r19 == 16908303) goto L17;
        r21 = false;
        goto L18
    L19:
        LayerDrawable r22 = new LayerDrawable(r16);
    L20:
        if (r17 >= r15) goto L25;
        r22.setId(r17, r14.getId(r17));
        if (Build.VERSION.SDK_INT < 23) goto L24;
        Api23Impl.transferLayerProperties(r14, r22, r17);
    L24:
        r17 = r17 + 1;
        goto L20
    L25:
        return r22;
    L27:
        if ((r10 instanceof BitmapDrawable) == false) goto L35;
        BitmapDrawable r23 = (BitmapDrawable) r10;
        Bitmap r24 = r23.getBitmap();
        if (this.mSampleTile != null) goto L31;
        this.mSampleTile = r24;
    L31:
        ShapeDrawable r25 = new ShapeDrawable(getDrawableShape());
        r25.getPaint().setShader(new BitmapShader(r24, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
        r25.getPaint().setColorFilter(r23.getPaint().getColorFilter());
        if (r11 == true) goto L34;
        return r25;
    L34:
        return new ClipDrawable(r25, 3, 1);
    }
}
