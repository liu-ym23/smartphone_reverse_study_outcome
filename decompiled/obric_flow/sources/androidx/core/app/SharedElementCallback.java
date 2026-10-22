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
        int r5 = r10.getIntrinsicWidth();
        int r11 = r10.getIntrinsicHeight();
        if (r5 <= 0) goto L14;
        if (r11 <= 0) goto L16;
        float r12 = Math.min(1.0f, 1048576.0f / (r5 * r11));
        if ((r10 instanceof BitmapDrawable) == true) goto L9;
    L12:
        int r13 = (int) (r5 * r12);
        int r14 = (int) (r11 * r12);
        Bitmap r15 = Bitmap.createBitmap(r13, r14, Bitmap.Config.ARGB_8888);
        Canvas r16 = new Canvas(r15);
        Rect r17 = r10.getBounds();
        int r18 = r17.left;
        int r19 = r17.top;
        int r20 = r17.right;
        int r21 = r17.bottom;
        r10.setBounds(0, 0, r13, r14);
        r10.draw(r16);
        r10.setBounds(r18, r19, r20, r21);
        return r15;
    L9:
        if (r12 != 1.0f) goto L12;
        return ((BitmapDrawable) r10).getBitmap();
    L16:
        return null;
    L14:
        return null;
    }

    public Parcelable onCaptureSharedElementSnapshot(View r5, Matrix r10, RectF r11) {
        if ((r5 instanceof ImageView) == false) goto L13;
        ImageView r12 = (ImageView) r5;
        Drawable r13 = r12.getDrawable();
        Drawable r14 = r12.getBackground();
        if (r13 == null) goto L13;
        if (r14 != null) goto L13;
        Bitmap r15 = createDrawableBitmap(r13);
        if (r15 == null) goto L13;
        Bundle r16 = new Bundle();
        r16.putParcelable(BUNDLE_SNAPSHOT_BITMAP, r15);
        r16.putString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE, r12.getScaleType().toString());
        if (r12.getScaleType() != ImageView.ScaleType.MATRIX) goto L12;
        float[] r17 = new float[9];
        r12.getImageMatrix().getValues(r17);
        r16.putFloatArray(BUNDLE_SNAPSHOT_IMAGE_MATRIX, r17);
    L12:
        return r16;
    L13:
        int r18 = Math.round(r11.width());
        int r19 = Math.round(r11.height());
        if (r18 <= 0) goto L20;
        if (r19 <= 0) goto L20;
        float r20 = Math.min(1.0f, 1048576.0f / (r18 * r19));
        int r21 = (int) (r18 * r20);
        int r22 = (int) (r19 * r20);
        if (this.mTempMatrix != null) goto L19;
        this.mTempMatrix = new Matrix();
    L19:
        this.mTempMatrix.set(r10);
        this.mTempMatrix.postTranslate(-r11.left, -r11.top);
        this.mTempMatrix.postScale(r20, r20);
        Bitmap r23 = Bitmap.createBitmap(r21, r22, Bitmap.Config.ARGB_8888);
        Canvas r24 = new Canvas(r23);
        r24.concat(this.mTempMatrix);
        r5.draw(r24);
        return r23;
    L20:
        return null;
    }

    public View onCreateSnapshotView(Context r5, Parcelable r10) {
        if ((r10 instanceof Bundle) == false) goto L11;
        Bundle r11 = (Bundle) r10;
        Bitmap r12 = (Bitmap) r11.getParcelable(BUNDLE_SNAPSHOT_BITMAP);
        if (r12 != null) goto L7;
        return null;
    L7:
        ImageView r13 = new ImageView(r5);
        r13.setImageBitmap(r12);
        r13.setScaleType(ImageView.ScaleType.valueOf(r11.getString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE)));
        if (r13.getScaleType() != ImageView.ScaleType.MATRIX) goto L14;
        float[] r14 = r11.getFloatArray(BUNDLE_SNAPSHOT_IMAGE_MATRIX);
        Matrix r15 = new Matrix();
        r15.setValues(r14);
        r13.setImageMatrix(r15);
        return r13;
    L14:
        return r13;
    L11:
        if ((r10 instanceof Bitmap) == false) goto L16;
        ImageView r16 = new ImageView(r5);
        r16.setImageBitmap((Bitmap) r10);
        return r16;
    L16:
        return null;
    }

    public void onMapSharedElements(List<String> r5, Map<String, View> r10) {
    }

    public void onRejectSharedElements(List<View> r5) {
    }

    public void onSharedElementEnd(List<String> r5, List<View> r10, List<View> r11) {
    }

    public void onSharedElementStart(List<String> r5, List<View> r10, List<View> r11) {
    }

    public void onSharedElementsArrived(List<String> r5, List<View> r10, OnSharedElementsReadyListener r11) {
        r11.onSharedElementsReady();
    }
}
