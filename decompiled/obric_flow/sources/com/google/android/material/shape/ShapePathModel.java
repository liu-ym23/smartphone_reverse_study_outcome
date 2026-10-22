package com.google.android.material.shape;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class ShapePathModel extends ShapeAppearanceModel {
    public ShapePathModel() {
    }

    @Deprecated
    public void setAllCorners(CornerTreatment r5) {
        this.topLeftCorner = r5;
        this.topRightCorner = r5;
        this.bottomRightCorner = r5;
        this.bottomLeftCorner = r5;
    }

    @Deprecated
    public void setAllEdges(EdgeTreatment r5) {
        this.leftEdge = r5;
        this.topEdge = r5;
        this.rightEdge = r5;
        this.bottomEdge = r5;
    }

    @Deprecated
    public void setBottomEdge(EdgeTreatment r5) {
        this.bottomEdge = r5;
    }

    @Deprecated
    public void setBottomLeftCorner(CornerTreatment r5) {
        this.bottomLeftCorner = r5;
    }

    @Deprecated
    public void setBottomRightCorner(CornerTreatment r5) {
        this.bottomRightCorner = r5;
    }

    @Deprecated
    public void setCornerTreatments(CornerTreatment r5, CornerTreatment r10, CornerTreatment r11, CornerTreatment r12) {
        this.topLeftCorner = r5;
        this.topRightCorner = r10;
        this.bottomRightCorner = r11;
        this.bottomLeftCorner = r12;
    }

    @Deprecated
    public void setEdgeTreatments(EdgeTreatment r5, EdgeTreatment r10, EdgeTreatment r11, EdgeTreatment r12) {
        this.leftEdge = r5;
        this.topEdge = r10;
        this.rightEdge = r11;
        this.bottomEdge = r12;
    }

    @Deprecated
    public void setLeftEdge(EdgeTreatment r5) {
        this.leftEdge = r5;
    }

    @Deprecated
    public void setRightEdge(EdgeTreatment r5) {
        this.rightEdge = r5;
    }

    @Deprecated
    public void setTopEdge(EdgeTreatment r5) {
        this.topEdge = r5;
    }

    @Deprecated
    public void setTopLeftCorner(CornerTreatment r5) {
        this.topLeftCorner = r5;
    }

    @Deprecated
    public void setTopRightCorner(CornerTreatment r5) {
        this.topRightCorner = r5;
    }
}
