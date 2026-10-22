package androidx.core.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class SharedElementCallback {
    private static final String BUNDLE_SNAPSHOT_BITMAP = "sharedElement:snapshot:bitmap";
    private static final String BUNDLE_SNAPSHOT_IMAGE_MATRIX = "sharedElement:snapshot:imageMatrix";
    private static final String BUNDLE_SNAPSHOT_IMAGE_SCALETYPE = "sharedElement:snapshot:imageScaleType";
    private static final int MAX_IMAGE_SIZE = 1048576;
    private Matrix mTempMatrix;

    public interface OnSharedElementsReadyListener {
        void onSharedElementsReady();
    }

    public SharedElementCallback() {
    }

    private static Bitmap createDrawableBitmap(Drawable r10) {
        int r11 = r10.getIntrinsicWidth();
        int r12 = r10.getIntrinsicHeight();
        if (r11 <= 0) goto L14;
        if (r12 <= 0) goto L16;
        float r13 = Math.min(1.0f, 1048576.0f / (r11 * r12));
        if ((r10 instanceof BitmapDrawable) == true) goto L9;
    L12:
        int r14 = (int) (r11 * r13);
        int r15 = (int) (r12 * r13);
        Bitmap r16 = Bitmap.createBitmap(r14, r15, Bitmap.Config.ARGB_8888);
        Canvas r17 = new Canvas(r16);
        Rect r18 = r10.getBounds();
        int r19 = r18.left;
        int r20 = r18.top;
        int r21 = r18.right;
        int r22 = r18.bottom;
        r10.setBounds(0, 0, r14, r15);
        r10.draw(r17);
        r10.setBounds(r19, r20, r21, r22);
        return r16;
    L9:
        if (r13 != 1.0f) goto L12;
        return ((BitmapDrawable) r10).getBitmap();
    L16:
        return null;
    L14:
        return null;
    }

    public Parcelable onCaptureSharedElementSnapshot(View r10, Matrix r11, RectF r12) {
        if ((r10 instanceof ImageView) == false) goto L13;
        ImageView r13 = (ImageView) r10;
        Drawable r14 = r13.getDrawable();
        Drawable r15 = r13.getBackground();
        if (r14 == null) goto L13;
        if (r15 != null) goto L13;
        Bitmap r16 = createDrawableBitmap(r14);
        if (r16 == null) goto L13;
        Bundle r17 = new Bundle();
        r17.putParcelable(BUNDLE_SNAPSHOT_BITMAP, r16);
        r17.putString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE, r13.getScaleType().toString());
        if (r13.getScaleType() != ImageView.ScaleType.MATRIX) goto L12;
        float[] r18 = new float[9];
        r13.getImageMatrix().getValues(r18);
        r17.putFloatArray(BUNDLE_SNAPSHOT_IMAGE_MATRIX, r18);
    L12:
        return r17;
    L13:
        int r19 = Math.round(r12.width());
        int r20 = Math.round(r12.height());
        if (r19 <= 0) goto L21;
        if (r20 <= 0) goto L22;
        float r21 = Math.min(1.0f, 1048576.0f / (r19 * r20));
        int r22 = (int) (r19 * r21);
        int r23 = (int) (r20 * r21);
        if (this.mTempMatrix != null) goto L19;
        this.mTempMatrix = new Matrix();
    L19:
        this.mTempMatrix.set(r11);
        this.mTempMatrix.postTranslate(-r12.left, -r12.top);
        this.mTempMatrix.postScale(r21, r21);
        Bitmap r24 = Bitmap.createBitmap(r22, r23, Bitmap.Config.ARGB_8888);
        Canvas r25 = new Canvas(r24);
        r25.concat(this.mTempMatrix);
        r10.draw(r25);
        return r24;
    L22:
        return null;
    L21:
        return null;
    }

    public View onCreateSnapshotView(Context r10, Parcelable r11) {
        if ((r11 instanceof Bundle) == false) goto L11;
        Bundle r12 = (Bundle) r11;
        Bitmap r13 = (Bitmap) r12.getParcelable(BUNDLE_SNAPSHOT_BITMAP);
        if (r13 != null) goto L7;
        return null;
    L7:
        ImageView r14 = new ImageView(r10);
        r14.setImageBitmap(r13);
        r14.setScaleType(ImageView.ScaleType.valueOf(r12.getString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE)));
        if (r14.getScaleType() != ImageView.ScaleType.MATRIX) goto L14;
        float[] r15 = r12.getFloatArray(BUNDLE_SNAPSHOT_IMAGE_MATRIX);
        Matrix r16 = new Matrix();
        r16.setValues(r15);
        r14.setImageMatrix(r16);
        return r14;
    L14:
        return r14;
    L11:
        if ((r11 instanceof Bitmap) == false) goto L16;
        ImageView r17 = new ImageView(r10);
        r17.setImageBitmap((Bitmap) r11);
        return r17;
    L16:
        return null;
    }

    public void onMapSharedElements(List<String> r10, Map<String, View> r11) {
    }

    public void onRejectSharedElements(List<View> r10) {
    }

    public void onSharedElementEnd(List<String> r10, List<View> r11, List<View> r12) {
    }

    public void onSharedElementStart(List<String> r10, List<View> r11, List<View> r12) {
    }

    public void onSharedElementsArrived(List<String> r10, List<View> r11, OnSharedElementsReadyListener r12) {
        r12.onSharedElementsReady();
    }
}
