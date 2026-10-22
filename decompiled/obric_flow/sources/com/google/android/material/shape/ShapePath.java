package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ShapePath {
    protected static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    private boolean containsIncompatibleShadowOp;

    @Deprecated
    public float currentShadowAngle;

    @Deprecated
    public float endShadowAngle;

    @Deprecated
    public float endX;

    @Deprecated
    public float endY;
    private final List<PathOperation> operations;
    private final List<ShadowCompatOperation> shadowCompatOperations;

    @Deprecated
    public float startX;

    @Deprecated
    public float startY;

    public static class ArcShadowOperation extends ShadowCompatOperation {
        private final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation r5) {
            this.operation = r5;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix r10, @NonNull ShadowRenderer r11, int r12, @NonNull Canvas r13) {
            float r14 = PathArcOperation.access$800(this.operation);
            float r15 = PathArcOperation.access$900(this.operation);
            r11.drawCornerShadow(r13, r10, new RectF(PathArcOperation.access$1000(this.operation), PathArcOperation.access$1100(this.operation), PathArcOperation.access$1200(this.operation), PathArcOperation.access$1300(this.operation)), r12, r14, r15);
        }
    }

    public static class InnerCornerShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation1;
        private final PathLineOperation operation2;
        private final float startX;
        private final float startY;

        public InnerCornerShadowOperation(PathLineOperation r5, PathLineOperation r10, float r11, float r12) {
            this.operation1 = r5;
            this.operation2 = r10;
            this.startX = r11;
            this.startY = r12;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix r18, ShadowRenderer r19, int r20, Canvas r21) {
            float r10 = getSweepAngle();
            if (r10 <= 0.0f) goto L5;
            return;
        L5:
            double r5 = Math.hypot(PathLineOperation.access$000(this.operation1) - this.startX, PathLineOperation.access$100(this.operation1) - this.startY);
            double r14 = Math.hypot(PathLineOperation.access$000(this.operation2) - PathLineOperation.access$000(this.operation1), PathLineOperation.access$100(this.operation2) - PathLineOperation.access$100(this.operation1));
            float r11 = (float) Math.min(r20, Math.min(r5, r14));
            double r12 = r11;
            double r13 = Math.tan(Math.toRadians((-r10) / 2.0f)) * r12;
            if (r5 <= r13) goto L9;
            RectF r15 = new RectF(0.0f, 0.0f, (float) (r5 - r13), 0.0f);
            this.renderMatrix.set(r18);
            this.renderMatrix.preTranslate(this.startX, this.startY);
            this.renderMatrix.preRotate(getStartAngle());
            r19.drawEdgeShadow(r21, this.renderMatrix, r15, r20);
        L9:
            float r16 = 2.0f * r11;
            RectF r17 = new RectF(0.0f, 0.0f, r16, r16);
            this.renderMatrix.set(r18);
            this.renderMatrix.preTranslate(PathLineOperation.access$000(this.operation1), PathLineOperation.access$100(this.operation1));
            this.renderMatrix.preRotate(getStartAngle());
            this.renderMatrix.preTranslate((float) ((-r13) - r12), (-2.0f) * r11);
            r19.drawInnerCornerShadow(r21, this.renderMatrix, r17, (int) r11, 450.0f, r10, new float[]{(float) (r12 + r13), r16});
            if (r14 <= r13) goto L13;
            RectF r22 = new RectF(0.0f, 0.0f, (float) (r14 - r13), 0.0f);
            this.renderMatrix.set(r18);
            this.renderMatrix.preTranslate(PathLineOperation.access$000(this.operation1), PathLineOperation.access$100(this.operation1));
            this.renderMatrix.preRotate(getEndAngle());
            this.renderMatrix.preTranslate((float) r13, 0.0f);
            r19.drawEdgeShadow(r21, this.renderMatrix, r22, r20);
            return;
        }

        public float getEndAngle() {
            return (float) Math.toDegrees(Math.atan((PathLineOperation.access$100(this.operation2) - PathLineOperation.access$100(this.operation1)) / (PathLineOperation.access$000(this.operation2) - PathLineOperation.access$000(this.operation1))));
        }

        public float getStartAngle() {
            return (float) Math.toDegrees(Math.atan((PathLineOperation.access$100(this.operation1) - this.startY) / (PathLineOperation.access$000(this.operation1) - this.startX)));
        }

        public float getSweepAngle() {
            float r5 = ((getEndAngle() - getStartAngle()) + 360.0f) % 360.0f;
            if (r5 > ShapePath.ANGLE_LEFT) goto L6;
            return r5;
        L6:
            return r5 - 360.0f;
        }
    }

    public static class LineShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation;
        private final float startX;
        private final float startY;

        public LineShadowOperation(PathLineOperation r5, float r10, float r11) {
            this.operation = r5;
            this.startX = r10;
            this.startY = r11;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix r10, @NonNull ShadowRenderer r11, int r12, @NonNull Canvas r13) {
            RectF r5 = new RectF(0.0f, 0.0f, (float) Math.hypot(PathLineOperation.access$100(this.operation) - this.startY, PathLineOperation.access$000(this.operation) - this.startX), 0.0f);
            this.renderMatrix.set(r10);
            this.renderMatrix.preTranslate(this.startX, this.startY);
            this.renderMatrix.preRotate(getAngle());
            r11.drawEdgeShadow(r13, this.renderMatrix, r5, r12);
        }

        public float getAngle() {
            return (float) Math.toDegrees(Math.atan((PathLineOperation.access$100(this.operation) - this.startY) / (PathLineOperation.access$000(this.operation) - this.startX)));
        }
    }

    public static class PathArcOperation extends PathOperation {
        private static final RectF rectF = null;

        @Deprecated
        public float bottom;

        @Deprecated
        public float left;

        @Deprecated
        public float right;

        @Deprecated
        public float startAngle;

        @Deprecated
        public float sweepAngle;

        @Deprecated
        public float top;

        static {
            rectF = new RectF();
        }

        public PathArcOperation(float r5, float r10, float r11, float r12) {
            setLeft(r5);
            setTop(r10);
            setRight(r11);
            setBottom(r12);
        }

        public static /* synthetic */ float access$1000(PathArcOperation r5) {
            return r5.getLeft();
        }

        public static /* synthetic */ float access$1100(PathArcOperation r5) {
            return r5.getTop();
        }

        public static /* synthetic */ float access$1200(PathArcOperation r5) {
            return r5.getRight();
        }

        public static /* synthetic */ float access$1300(PathArcOperation r5) {
            return r5.getBottom();
        }

        public static /* synthetic */ void access$600(PathArcOperation r5, float r10) {
            r5.setStartAngle(r10);
        }

        public static /* synthetic */ void access$700(PathArcOperation r5, float r10) {
            r5.setSweepAngle(r10);
        }

        public static /* synthetic */ float access$800(PathArcOperation r5) {
            return r5.getStartAngle();
        }

        public static /* synthetic */ float access$900(PathArcOperation r5) {
            return r5.getSweepAngle();
        }

        private float getBottom() {
            return this.bottom;
        }

        private float getLeft() {
            return this.left;
        }

        private float getRight() {
            return this.right;
        }

        private float getStartAngle() {
            return this.startAngle;
        }

        private float getSweepAngle() {
            return this.sweepAngle;
        }

        private float getTop() {
            return this.top;
        }

        private void setBottom(float r5) {
            this.bottom = r5;
        }

        private void setLeft(float r5) {
            this.left = r5;
        }

        private void setRight(float r5) {
            this.right = r5;
        }

        private void setStartAngle(float r5) {
            this.startAngle = r5;
        }

        private void setSweepAngle(float r5) {
            this.sweepAngle = r5;
        }

        private void setTop(float r5) {
            this.top = r5;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix r10, @NonNull Path r11) {
            Matrix r5 = this.matrix;
            r10.invert(r5);
            r11.transform(r5);
            RectF r12 = rectF;
            r12.set(getLeft(), getTop(), getRight(), getBottom());
            r11.arcTo(r12, getStartAngle(), getSweepAngle(), false);
            r11.transform(r10);
        }
    }

    public static class PathCubicOperation extends PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        public PathCubicOperation(float r5, float r10, float r11, float r12, float r13, float r14) {
            setControlX1(r5);
            setControlY1(r10);
            setControlX2(r11);
            setControlY2(r12);
            setEndX(r13);
            setEndY(r14);
        }

        private float getControlX1() {
            return this.controlX1;
        }

        private float getControlX2() {
            return this.controlX2;
        }

        private float getControlY1() {
            return this.controlY1;
        }

        private float getControlY2() {
            return this.controlY1;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX1(float r5) {
            this.controlX1 = r5;
        }

        private void setControlX2(float r5) {
            this.controlX2 = r5;
        }

        private void setControlY1(float r5) {
            this.controlY1 = r5;
        }

        private void setControlY2(float r5) {
            this.controlY2 = r5;
        }

        private void setEndX(float r5) {
            this.endX = r5;
        }

        private void setEndY(float r5) {
            this.endY = r5;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix r10, @NonNull Path r11) {
            Matrix r5 = this.matrix;
            r10.invert(r5);
            r11.transform(r5);
            r11.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            r11.transform(r10);
        }
    }

    public static class PathLineOperation extends PathOperation {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private float f8585x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private float f8586y;

        public PathLineOperation() {
        }

        public static /* synthetic */ float access$000(PathLineOperation r5) {
            return r5.f8585x;
        }

        public static /* synthetic */ float access$002(PathLineOperation r5, float r10) {
            r5.f8585x = r10;
            return r10;
        }

        public static /* synthetic */ float access$100(PathLineOperation r5) {
            return r5.f8586y;
        }

        public static /* synthetic */ float access$102(PathLineOperation r5, float r10) {
            r5.f8586y = r10;
            return r10;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix r5, @NonNull Path r10) {
            Matrix r11 = this.matrix;
            r5.invert(r11);
            r10.transform(r11);
            r10.lineTo(this.f8585x, this.f8586y);
            r10.transform(r5);
        }
    }

    public static abstract class PathOperation {
        protected final Matrix matrix;

        public PathOperation() {
            this.matrix = new Matrix();
        }

        public abstract void applyToPath(Matrix r5, Path r10);
    }

    public static class PathQuadOperation extends PathOperation {

        @Deprecated
        public float controlX;

        @Deprecated
        public float controlY;

        @Deprecated
        public float endX;

        @Deprecated
        public float endY;

        public PathQuadOperation() {
        }

        public static /* synthetic */ void access$200(PathQuadOperation r5, float r10) {
            r5.setControlX(r10);
        }

        public static /* synthetic */ void access$300(PathQuadOperation r5, float r10) {
            r5.setControlY(r10);
        }

        public static /* synthetic */ void access$400(PathQuadOperation r5, float r10) {
            r5.setEndX(r10);
        }

        public static /* synthetic */ void access$500(PathQuadOperation r5, float r10) {
            r5.setEndY(r10);
        }

        private float getControlX() {
            return this.controlX;
        }

        private float getControlY() {
            return this.controlY;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX(float r5) {
            this.controlX = r5;
        }

        private void setControlY(float r5) {
            this.controlY = r5;
        }

        private void setEndX(float r5) {
            this.endX = r5;
        }

        private void setEndY(float r5) {
            this.endY = r5;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix r5, @NonNull Path r10) {
            Matrix r11 = this.matrix;
            r5.invert(r11);
            r10.transform(r11);
            r10.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            r10.transform(r5);
        }
    }

    public static abstract class ShadowCompatOperation {
        static final Matrix IDENTITY_MATRIX = null;
        final Matrix renderMatrix;

        static {
            IDENTITY_MATRIX = new Matrix();
        }

        public ShadowCompatOperation() {
            this.renderMatrix = new Matrix();
        }

        public abstract void draw(Matrix r5, ShadowRenderer r10, int r11, Canvas r12);

        public final void draw(ShadowRenderer r5, int r10, Canvas r11) {
            draw(IDENTITY_MATRIX, r5, r10, r11);
        }
    }

    public ShapePath() {
        this.operations = new ArrayList();
        this.shadowCompatOperations = new ArrayList();
        reset(0.0f, 0.0f);
    }

    private void addConnectingShadowIfNecessary(float r10) {
        if (getCurrentShadowAngle() != r10) goto L5;
        return;
    L5:
        float r5 = ((r10 - getCurrentShadowAngle()) + 360.0f) % 360.0f;
        if (r5 <= ANGLE_LEFT) goto L8;
        return;
    L8:
        PathArcOperation r11 = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
        PathArcOperation.access$600(r11, getCurrentShadowAngle());
        PathArcOperation.access$700(r11, r5);
        this.shadowCompatOperations.add(new ArcShadowOperation(r11));
        setCurrentShadowAngle(r10);
    }

    private void addShadowCompatOperation(ShadowCompatOperation r5, float r10, float r11) {
        addConnectingShadowIfNecessary(r10);
        this.shadowCompatOperations.add(r5);
        setCurrentShadowAngle(r11);
    }

    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    private void setCurrentShadowAngle(float r5) {
        this.currentShadowAngle = r5;
    }

    private void setEndShadowAngle(float r5) {
        this.endShadowAngle = r5;
    }

    private void setEndX(float r5) {
        this.endX = r5;
    }

    private void setEndY(float r5) {
        this.endY = r5;
    }

    private void setStartX(float r5) {
        this.startX = r5;
    }

    private void setStartY(float r5) {
        this.startY = r5;
    }

    public void addArc(float r5, float r10, float r11, float r12, float r13, float r14) {
        PathArcOperation r15 = new PathArcOperation(r5, r10, r11, r12);
        PathArcOperation.access$600(r15, r13);
        PathArcOperation.access$700(r15, r14);
        this.operations.add(r15);
        ArcShadowOperation r16 = new ArcShadowOperation(r15);
        float r17 = r13 + r14;
        if (r14 >= 0.0f) goto L5;
        boolean r18 = true;
    L7:
        if (r18 == false) goto L9;
        r13 = (r13 + ANGLE_LEFT) % 360.0f;
    L9:
        if (r18 == false) goto L11;
        float r19 = (ANGLE_LEFT + r17) % 360.0f;
    L12:
        addShadowCompatOperation(r16, r13, r19);
        double r20 = r17;
        setEndX((((r11 - r5) / 2.0f) * ((float) Math.cos(Math.toRadians(r20)))) + ((r5 + r11) * 0.5f));
        setEndY((((r12 - r10) / 2.0f) * ((float) Math.sin(Math.toRadians(r20)))) + ((r10 + r12) * 0.5f));
        return;
    L11:
        r19 = r17;
        goto L12
    L5:
        r18 = false;
        goto L7
    }

    public void applyToPath(Matrix r5, Path r10) {
        int r11 = this.operations.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.operations.get(r12).applyToPath(r5, r10);
        r12 = r12 + 1;
        goto L3
    }

    public boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    @NonNull
    public ShadowCompatOperation createShadowCompatOperation(Matrix r5) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        final Matrix r10 = new Matrix(r5);
        final ArrayList r11 = new ArrayList(this.shadowCompatOperations);
        return new AnonymousClass1(this, r11, r10);
    }

    @RequiresApi(21)
    public void cubicToPoint(float r10, float r11, float r12, float r13, float r14, float r15) {
        PathCubicOperation r16 = new PathCubicOperation(r10, r11, r12, r13, r14, r15);
        this.operations.add(r16);
        this.containsIncompatibleShadowOp = true;
        setEndX(r14);
        setEndY(r15);
    }

    public float getEndX() {
        return this.endX;
    }

    public float getEndY() {
        return this.endY;
    }

    public float getStartX() {
        return this.startX;
    }

    public float getStartY() {
        return this.startY;
    }

    public void lineTo(float r5, float r10) {
        PathLineOperation r11 = new PathLineOperation();
        PathLineOperation.access$002(r11, r5);
        PathLineOperation.access$102(r11, r10);
        this.operations.add(r11);
        LineShadowOperation r12 = new LineShadowOperation(r11, getEndX(), getEndY());
        addShadowCompatOperation(r12, r12.getAngle() + ANGLE_UP, r12.getAngle() + ANGLE_UP);
        setEndX(r5);
        setEndY(r10);
    }

    @RequiresApi(21)
    public void quadToPoint(float r5, float r10, float r11, float r12) {
        PathQuadOperation r13 = new PathQuadOperation();
        PathQuadOperation.access$200(r13, r5);
        PathQuadOperation.access$300(r13, r10);
        PathQuadOperation.access$400(r13, r11);
        PathQuadOperation.access$500(r13, r12);
        this.operations.add(r13);
        this.containsIncompatibleShadowOp = true;
        setEndX(r11);
        setEndY(r12);
    }

    public void reset(float r5, float r10) {
        reset(r5, r10, ANGLE_UP, 0.0f);
    }

    public void reset(float r5, float r10, float r11, float r12) {
        setStartX(r5);
        setStartY(r10);
        setEndX(r5);
        setEndY(r10);
        setCurrentShadowAngle(r11);
        setEndShadowAngle((r11 + r12) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }

    public ShapePath(float r5, float r10) {
        this.operations = new ArrayList();
        this.shadowCompatOperations = new ArrayList();
        reset(r5, r10);
    }

    public void lineTo(float r10, float r11, float r12, float r13) {
        if (Math.abs(r10 - getEndX()) >= 0.001f) goto L7;
        if (Math.abs(r11 - getEndY()) >= 0.001f) goto L7;
    L10:
        lineTo(r12, r13);
        return;
    L7:
        if (Math.abs(r10 - r12) < 0.001f) goto L9;
    L12:
        PathLineOperation r5 = new PathLineOperation();
        PathLineOperation.access$002(r5, r10);
        PathLineOperation.access$102(r5, r11);
        this.operations.add(r5);
        PathLineOperation r14 = new PathLineOperation();
        PathLineOperation.access$002(r14, r12);
        PathLineOperation.access$102(r14, r13);
        this.operations.add(r14);
        InnerCornerShadowOperation r15 = new InnerCornerShadowOperation(r5, r14, getEndX(), getEndY());
        if (r15.getSweepAngle() <= 0.0f) goto L16;
        lineTo(r10, r11);
        lineTo(r12, r13);
        return;
    L16:
        addShadowCompatOperation(r15, r15.getStartAngle() + ANGLE_UP, r15.getEndAngle() + ANGLE_UP);
        setEndX(r12);
        setEndY(r13);
        return;
    L9:
        if (Math.abs(r11 - r13) >= 0.001f) goto L12;
        goto L10
    }
}
