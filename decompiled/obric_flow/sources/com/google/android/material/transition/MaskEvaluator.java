package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

/* JADX INFO: loaded from: classes2.dex */
class MaskEvaluator {
    private ShapeAppearanceModel currentShapeAppearanceModel;
    private final Path endPath;
    private final Path path;
    private final ShapeAppearancePathProvider pathProvider;
    private final Path startPath;

    public MaskEvaluator() {
        this.path = new Path();
        this.startPath = new Path();
        this.endPath = new Path();
        this.pathProvider = ShapeAppearancePathProvider.getInstance();
    }

    public void clip(Canvas r5) {
        r5.clipPath(this.path);
    }

    public void evaluate(float r10, ShapeAppearanceModel r11, ShapeAppearanceModel r12, RectF r13, RectF r14, RectF r15, MaterialContainerTransform.ProgressThresholds r16) {
        ShapeAppearanceModel r17 = TransitionUtils.lerp(r11, r12, r13, r15, r16.getStart(), r16.getEnd(), r10);
        this.currentShapeAppearanceModel = r17;
        this.pathProvider.calculatePath(r17, 1.0f, r14, this.startPath);
        this.pathProvider.calculatePath(this.currentShapeAppearanceModel, 1.0f, r15, this.endPath);
        this.path.op(this.startPath, this.endPath, Path.Op.UNION);
    }

    public ShapeAppearanceModel getCurrentShapeAppearanceModel() {
        return this.currentShapeAppearanceModel;
    }

    public Path getPath() {
        return this.path;
    }
}
