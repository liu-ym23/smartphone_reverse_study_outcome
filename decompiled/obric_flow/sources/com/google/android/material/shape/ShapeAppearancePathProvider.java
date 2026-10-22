package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

/* JADX INFO: loaded from: classes2.dex */
public class ShapeAppearancePathProvider {
    private final Path boundsPath;
    private final Path cornerPath;
    private final ShapePath[] cornerPaths;
    private final Matrix[] cornerTransforms;
    private boolean edgeIntersectionCheckEnabled;
    private final Path edgePath;
    private final Matrix[] edgeTransforms;
    private final Path overlappedEdgePath;
    private final PointF pointF;
    private final float[] scratch;
    private final float[] scratch2;
    private final ShapePath shapePath;

    public static class Lazy {
        static final ShapeAppearancePathProvider INSTANCE = null;

        static {
            INSTANCE = new ShapeAppearancePathProvider();
        }

        private Lazy() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface PathListener {
        void onCornerPathCreated(ShapePath r5, Matrix r10, int r11);

        void onEdgePathCreated(ShapePath r5, Matrix r10, int r11);
    }

    public static final class ShapeAppearancePathSpec {

        @NonNull
        public final RectF bounds;
        public final float interpolation;

        @NonNull
        public final Path path;

        @Nullable
        public final PathListener pathListener;

        @NonNull
        public final ShapeAppearanceModel shapeAppearanceModel;

        public ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel r5, float r10, RectF r11, @Nullable PathListener r12, Path r13) {
            this.pathListener = r12;
            this.shapeAppearanceModel = r5;
            this.interpolation = r10;
            this.bounds = r11;
            this.path = r13;
        }
    }

    public ShapeAppearancePathProvider() {
        this.cornerPaths = new ShapePath[4];
        this.cornerTransforms = new Matrix[4];
        this.edgeTransforms = new Matrix[4];
        this.pointF = new PointF();
        this.overlappedEdgePath = new Path();
        this.boundsPath = new Path();
        this.shapePath = new ShapePath();
        this.scratch = new float[2];
        this.scratch2 = new float[2];
        this.edgePath = new Path();
        this.cornerPath = new Path();
        this.edgeIntersectionCheckEnabled = true;
        int r5 = 0;
    L3:
        if (r5 >= 4) goto L5;
        this.cornerPaths[r5] = new ShapePath();
        this.cornerTransforms[r5] = new Matrix();
        this.edgeTransforms[r5] = new Matrix();
        r5 = r5 + 1;
        goto L3
    }

    private float angleOfEdge(int r5) {
        return ((r5 + 1) % 4) * 90;
    }

    private void appendCornerPath(@NonNull ShapeAppearancePathSpec r5, int r10) {
        this.scratch[0] = this.cornerPaths[r10].getStartX();
        this.scratch[1] = this.cornerPaths[r10].getStartY();
        this.cornerTransforms[r10].mapPoints(this.scratch);
        if (r10 != 0) goto L5;
        Path r11 = r5.path;
        float[] r12 = this.scratch;
        r11.moveTo(r12[0], r12[1]);
    L6:
        this.cornerPaths[r10].applyToPath(this.cornerTransforms[r10], r5.path);
        PathListener r13 = r5.pathListener;
        if (r13 == null) goto L10;
        r13.onCornerPathCreated(this.cornerPaths[r10], this.cornerTransforms[r10], r10);
        return;
    L10:
        return;
    L5:
        Path r14 = r5.path;
        float[] r15 = this.scratch;
        r14.lineTo(r15[0], r15[1]);
        goto L6
    }

    private void appendEdgePath(@NonNull ShapeAppearancePathSpec r10, int r11) {
        int r5 = (r11 + 1) % 4;
        this.scratch[0] = this.cornerPaths[r11].getEndX();
        this.scratch[1] = this.cornerPaths[r11].getEndY();
        this.cornerTransforms[r11].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[r5].getStartX();
        this.scratch2[1] = this.cornerPaths[r5].getStartY();
        this.cornerTransforms[r5].mapPoints(this.scratch2);
        float[] r12 = this.scratch;
        float r13 = r12[0];
        float[] r14 = this.scratch2;
        float r15 = Math.max(((float) Math.hypot(r13 - r14[0], r12[1] - r14[1])) - 0.001f, 0.0f);
        float r16 = getEdgeCenterForIndex(r10.bounds, r11);
        this.shapePath.reset(0.0f, 0.0f);
        EdgeTreatment r17 = getEdgeTreatmentForIndex(r11, r10.shapeAppearanceModel);
        r17.getEdgePath(r15, r16, r10.interpolation, this.shapePath);
        this.edgePath.reset();
        this.shapePath.applyToPath(this.edgeTransforms[r11], this.edgePath);
        if (this.edgeIntersectionCheckEnabled == true) goto L5;
    L11:
        this.shapePath.applyToPath(this.edgeTransforms[r11], r10.path);
    L12:
        PathListener r18 = r10.pathListener;
        if (r18 == null) goto L16;
        r18.onEdgePathCreated(this.shapePath, this.edgeTransforms[r11], r11);
        return;
    L16:
        return;
    L5:
        if (r17.forceIntersection() == false) goto L7;
    L10:
        Path r19 = this.edgePath;
        r19.op(r19, this.boundsPath, Path.Op.DIFFERENCE);
        this.scratch[0] = this.shapePath.getStartX();
        this.scratch[1] = this.shapePath.getStartY();
        this.edgeTransforms[r11].mapPoints(this.scratch);
        Path r20 = this.overlappedEdgePath;
        float[] r21 = this.scratch;
        r20.moveTo(r21[0], r21[1]);
        this.shapePath.applyToPath(this.edgeTransforms[r11], this.overlappedEdgePath);
        goto L12
    L7:
        if (pathOverlapsCorner(this.edgePath, r11) == true) goto L10;
        if (pathOverlapsCorner(this.edgePath, r5) == false) goto L11;
        goto L10
    }

    private void getCoordinatesOfCorner(int r5, @NonNull RectF r10, @NonNull PointF r11) {
        if (r5 != 1) goto L5;
        r11.set(r10.right, r10.bottom);
        return;
    L5:
        if (r5 != 2) goto L7;
        r11.set(r10.left, r10.bottom);
        return;
    L7:
        if (r5 == 3) goto L9;
        r11.set(r10.right, r10.top);
        return;
    L9:
        r11.set(r10.left, r10.top);
    }

    private CornerSize getCornerSizeForIndex(int r5, @NonNull ShapeAppearanceModel r10) {
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L13;
        if (r5 == 3) goto L11;
        return r10.getTopRightCornerSize();
    L11:
        return r10.getTopLeftCornerSize();
    L13:
        return r10.getBottomLeftCornerSize();
    L15:
        return r10.getBottomRightCornerSize();
    }

    private CornerTreatment getCornerTreatmentForIndex(int r5, @NonNull ShapeAppearanceModel r10) {
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L13;
        if (r5 == 3) goto L11;
        return r10.getTopRightCorner();
    L11:
        return r10.getTopLeftCorner();
    L13:
        return r10.getBottomLeftCorner();
    L15:
        return r10.getBottomRightCorner();
    }

    private float getEdgeCenterForIndex(@NonNull RectF r5, int r10) {
        float[] r11 = this.scratch;
        ShapePath r12 = this.cornerPaths[r10];
        r11[0] = r12.endX;
        r11[1] = r12.endY;
        this.cornerTransforms[r10].mapPoints(r11);
        if (r10 == 1) goto L9;
        if (r10 == 3) goto L9;
        return Math.abs(r5.centerY() - this.scratch[1]);
    L9:
        return Math.abs(r5.centerX() - this.scratch[0]);
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int r5, @NonNull ShapeAppearanceModel r10) {
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L13;
        if (r5 == 3) goto L11;
        return r10.getRightEdge();
    L11:
        return r10.getTopEdge();
    L13:
        return r10.getLeftEdge();
    L15:
        return r10.getBottomEdge();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @UiThread
    public static ShapeAppearancePathProvider getInstance() {
        return Lazy.INSTANCE;
    }

    @RequiresApi(19)
    private boolean pathOverlapsCorner(Path r5, int r10) {
        this.cornerPath.reset();
        this.cornerPaths[r10].applyToPath(this.cornerTransforms[r10], this.cornerPath);
        RectF r11 = new RectF();
        r5.computeBounds(r11, true);
        this.cornerPath.computeBounds(r11, true);
        r5.op(this.cornerPath, Path.Op.INTERSECT);
        r5.computeBounds(r11, true);
        if (r11.isEmpty() == true) goto L5;
        return true;
    L5:
        if (r11.width() > 1.0f) goto L7;
    L9:
        return false;
    L7:
        if (r11.height() <= 1.0f) goto L9;
        return true;
    }

    private void setCornerPathAndTransform(@NonNull ShapeAppearancePathSpec r10, int r11) {
        CornerSize r12 = getCornerSizeForIndex(r11, r10.shapeAppearanceModel);
        getCornerTreatmentForIndex(r11, r10.shapeAppearanceModel).getCornerPath(this.cornerPaths[r11], 90.0f, r10.interpolation, r10.bounds, r12);
        float r5 = angleOfEdge(r11);
        this.cornerTransforms[r11].reset();
        getCoordinatesOfCorner(r11, r10.bounds, this.pointF);
        Matrix r13 = this.cornerTransforms[r11];
        PointF r14 = this.pointF;
        r13.setTranslate(r14.x, r14.y);
        this.cornerTransforms[r11].preRotate(r5);
    }

    private void setEdgePathAndTransform(int r10) {
        this.scratch[0] = this.cornerPaths[r10].getEndX();
        this.scratch[1] = this.cornerPaths[r10].getEndY();
        this.cornerTransforms[r10].mapPoints(this.scratch);
        float r5 = angleOfEdge(r10);
        this.edgeTransforms[r10].reset();
        Matrix r11 = this.edgeTransforms[r10];
        float[] r12 = this.scratch;
        r11.setTranslate(r12[0], r12[1]);
        this.edgeTransforms[r10].preRotate(r5);
    }

    public void calculatePath(ShapeAppearanceModel r10, float r11, RectF r12, @NonNull Path r13) {
        calculatePath(r10, r11, r12, null, r13);
    }

    public void setEdgeIntersectionCheckEnable(boolean r5) {
        this.edgeIntersectionCheckEnabled = r5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(ShapeAppearanceModel r10, float r11, RectF r12, PathListener r13, @NonNull Path r14) {
        r14.rewind();
        this.overlappedEdgePath.rewind();
        this.boundsPath.rewind();
        this.boundsPath.addRect(r12, Path.Direction.CW);
        ShapeAppearancePathSpec r5 = new ShapeAppearancePathSpec(r10, r11, r12, r13, r14);
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r16 >= 4) goto L6;
        setCornerPathAndTransform(r5, r16);
        setEdgePathAndTransform(r16);
        r16 = r16 + 1;
    L6:
        if (r15 >= 4) goto L8;
        appendCornerPath(r5, r15);
        appendEdgePath(r5, r15);
        r15 = r15 + 1;
        goto L6
    L8:
        r14.close();
        this.overlappedEdgePath.close();
        if (this.overlappedEdgePath.isEmpty() == true) goto L14;
        r14.op(this.overlappedEdgePath, Path.Op.UNION);
        return;
    }
}
