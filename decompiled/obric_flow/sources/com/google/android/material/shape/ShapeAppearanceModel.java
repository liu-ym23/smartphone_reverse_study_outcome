package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public class ShapeAppearanceModel {
    public static final CornerSize PILL = null;
    EdgeTreatment bottomEdge;
    CornerTreatment bottomLeftCorner;
    CornerSize bottomLeftCornerSize;
    CornerTreatment bottomRightCorner;
    CornerSize bottomRightCornerSize;
    EdgeTreatment leftEdge;
    EdgeTreatment rightEdge;
    EdgeTreatment topEdge;
    CornerTreatment topLeftCorner;
    CornerSize topLeftCornerSize;
    CornerTreatment topRightCorner;
    CornerSize topRightCornerSize;

    /* JADX INFO: renamed from: com.google.android.material.shape.ShapeAppearanceModel$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {

        @NonNull
        private EdgeTreatment bottomEdge;

        @NonNull
        private CornerTreatment bottomLeftCorner;

        @NonNull
        private CornerSize bottomLeftCornerSize;

        @NonNull
        private CornerTreatment bottomRightCorner;

        @NonNull
        private CornerSize bottomRightCornerSize;

        @NonNull
        private EdgeTreatment leftEdge;

        @NonNull
        private EdgeTreatment rightEdge;

        @NonNull
        private EdgeTreatment topEdge;

        @NonNull
        private CornerTreatment topLeftCorner;

        @NonNull
        private CornerSize topLeftCornerSize;

        @NonNull
        private CornerTreatment topRightCorner;

        @NonNull
        private CornerSize topRightCornerSize;

        public Builder() {
            this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        }

        public static /* synthetic */ CornerTreatment access$100(Builder r5) {
            return r5.topLeftCorner;
        }

        public static /* synthetic */ EdgeTreatment access$1000(Builder r5) {
            return r5.rightEdge;
        }

        public static /* synthetic */ EdgeTreatment access$1100(Builder r5) {
            return r5.bottomEdge;
        }

        public static /* synthetic */ EdgeTreatment access$1200(Builder r5) {
            return r5.leftEdge;
        }

        public static /* synthetic */ CornerTreatment access$200(Builder r5) {
            return r5.topRightCorner;
        }

        public static /* synthetic */ CornerTreatment access$300(Builder r5) {
            return r5.bottomRightCorner;
        }

        public static /* synthetic */ CornerTreatment access$400(Builder r5) {
            return r5.bottomLeftCorner;
        }

        public static /* synthetic */ CornerSize access$500(Builder r5) {
            return r5.topLeftCornerSize;
        }

        public static /* synthetic */ CornerSize access$600(Builder r5) {
            return r5.topRightCornerSize;
        }

        public static /* synthetic */ CornerSize access$700(Builder r5) {
            return r5.bottomRightCornerSize;
        }

        public static /* synthetic */ CornerSize access$800(Builder r5) {
            return r5.bottomLeftCornerSize;
        }

        public static /* synthetic */ EdgeTreatment access$900(Builder r5) {
            return r5.topEdge;
        }

        private static float compatCornerTreatmentSize(CornerTreatment r5) {
            if ((r5 instanceof RoundedCornerTreatment) == false) goto L7;
            return ((RoundedCornerTreatment) r5).radius;
        L7:
            if ((r5 instanceof CutCornerTreatment) == true) goto L9;
            return -1.0f;
        L9:
            return ((CutCornerTreatment) r5).size;
        }

        @NonNull
        public ShapeAppearanceModel build() {
            return new ShapeAppearanceModel(this, null);
        }

        @NonNull
        public Builder setAllCornerSizes(@NonNull CornerSize r5) {
            return setTopLeftCornerSize(r5).setTopRightCornerSize(r5).setBottomRightCornerSize(r5).setBottomLeftCornerSize(r5);
        }

        @NonNull
        public Builder setAllCorners(int r5, @Dimension float r10) {
            return setAllCorners(MaterialShapeUtils.createCornerTreatment(r5)).setAllCornerSizes(r10);
        }

        @NonNull
        public Builder setAllEdges(@NonNull EdgeTreatment r5) {
            return setLeftEdge(r5).setTopEdge(r5).setRightEdge(r5).setBottomEdge(r5);
        }

        @NonNull
        public Builder setBottomEdge(@NonNull EdgeTreatment r5) {
            this.bottomEdge = r5;
            return this;
        }

        @NonNull
        public Builder setBottomLeftCorner(int r5, @Dimension float r10) {
            return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(r5)).setBottomLeftCornerSize(r10);
        }

        @NonNull
        public Builder setBottomLeftCornerSize(@Dimension float r5) {
            this.bottomLeftCornerSize = new AbsoluteCornerSize(r5);
            return this;
        }

        @NonNull
        public Builder setBottomRightCorner(int r5, @Dimension float r10) {
            return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(r5)).setBottomRightCornerSize(r10);
        }

        @NonNull
        public Builder setBottomRightCornerSize(@Dimension float r5) {
            this.bottomRightCornerSize = new AbsoluteCornerSize(r5);
            return this;
        }

        @NonNull
        public Builder setLeftEdge(@NonNull EdgeTreatment r5) {
            this.leftEdge = r5;
            return this;
        }

        @NonNull
        public Builder setRightEdge(@NonNull EdgeTreatment r5) {
            this.rightEdge = r5;
            return this;
        }

        @NonNull
        public Builder setTopEdge(@NonNull EdgeTreatment r5) {
            this.topEdge = r5;
            return this;
        }

        @NonNull
        public Builder setTopLeftCorner(int r5, @Dimension float r10) {
            return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(r5)).setTopLeftCornerSize(r10);
        }

        @NonNull
        public Builder setTopLeftCornerSize(@Dimension float r5) {
            this.topLeftCornerSize = new AbsoluteCornerSize(r5);
            return this;
        }

        @NonNull
        public Builder setTopRightCorner(int r5, @Dimension float r10) {
            return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(r5)).setTopRightCornerSize(r10);
        }

        @NonNull
        public Builder setTopRightCornerSize(@Dimension float r5) {
            this.topRightCornerSize = new AbsoluteCornerSize(r5);
            return this;
        }

        @NonNull
        public Builder setBottomLeftCornerSize(@NonNull CornerSize r5) {
            this.bottomLeftCornerSize = r5;
            return this;
        }

        @NonNull
        public Builder setBottomRightCornerSize(@NonNull CornerSize r5) {
            this.bottomRightCornerSize = r5;
            return this;
        }

        @NonNull
        public Builder setTopLeftCornerSize(@NonNull CornerSize r5) {
            this.topLeftCornerSize = r5;
            return this;
        }

        @NonNull
        public Builder setTopRightCornerSize(@NonNull CornerSize r5) {
            this.topRightCornerSize = r5;
            return this;
        }

        @NonNull
        public Builder setAllCorners(@NonNull CornerTreatment r5) {
            return setTopLeftCorner(r5).setTopRightCorner(r5).setBottomRightCorner(r5).setBottomLeftCorner(r5);
        }

        @NonNull
        public Builder setBottomLeftCorner(int r5, @NonNull CornerSize r10) {
            return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(r5)).setBottomLeftCornerSize(r10);
        }

        @NonNull
        public Builder setBottomRightCorner(int r5, @NonNull CornerSize r10) {
            return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(r5)).setBottomRightCornerSize(r10);
        }

        @NonNull
        public Builder setTopLeftCorner(int r5, @NonNull CornerSize r10) {
            return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(r5)).setTopLeftCornerSize(r10);
        }

        @NonNull
        public Builder setTopRightCorner(int r5, @NonNull CornerSize r10) {
            return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(r5)).setTopRightCornerSize(r10);
        }

        @NonNull
        public Builder setAllCornerSizes(@Dimension float r5) {
            return setTopLeftCornerSize(r5).setTopRightCornerSize(r5).setBottomRightCornerSize(r5).setBottomLeftCornerSize(r5);
        }

        @NonNull
        public Builder setBottomLeftCorner(@NonNull CornerTreatment r5) {
            this.bottomLeftCorner = r5;
            float r10 = compatCornerTreatmentSize(r5);
            if (r10 == (-1.0f)) goto L5;
            setBottomLeftCornerSize(r10);
        L5:
            return this;
        }

        @NonNull
        public Builder setBottomRightCorner(@NonNull CornerTreatment r5) {
            this.bottomRightCorner = r5;
            float r10 = compatCornerTreatmentSize(r5);
            if (r10 == (-1.0f)) goto L5;
            setBottomRightCornerSize(r10);
        L5:
            return this;
        }

        @NonNull
        public Builder setTopLeftCorner(@NonNull CornerTreatment r5) {
            this.topLeftCorner = r5;
            float r10 = compatCornerTreatmentSize(r5);
            if (r10 == (-1.0f)) goto L5;
            setTopLeftCornerSize(r10);
        L5:
            return this;
        }

        @NonNull
        public Builder setTopRightCorner(@NonNull CornerTreatment r5) {
            this.topRightCorner = r5;
            float r10 = compatCornerTreatmentSize(r5);
            if (r10 == (-1.0f)) goto L5;
            setTopRightCornerSize(r10);
        L5:
            return this;
        }

        public Builder(@NonNull ShapeAppearanceModel r5) {
            this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.topLeftCorner = r5.topLeftCorner;
            this.topRightCorner = r5.topRightCorner;
            this.bottomRightCorner = r5.bottomRightCorner;
            this.bottomLeftCorner = r5.bottomLeftCorner;
            this.topLeftCornerSize = r5.topLeftCornerSize;
            this.topRightCornerSize = r5.topRightCornerSize;
            this.bottomRightCornerSize = r5.bottomRightCornerSize;
            this.bottomLeftCornerSize = r5.bottomLeftCornerSize;
            this.topEdge = r5.topEdge;
            this.rightEdge = r5.rightEdge;
            this.bottomEdge = r5.bottomEdge;
            this.leftEdge = r5.leftEdge;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface CornerSizeUnaryOperator {
        @NonNull
        CornerSize apply(@NonNull CornerSize r5);
    }

    static {
        PILL = new RelativeCornerSize(0.5f);
    }

    public /* synthetic */ ShapeAppearanceModel(Builder r5, AnonymousClass1 r10) {
        this(r5);
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @NonNull
    private static CornerSize getCornerSize(TypedArray r5, int r10, @NonNull CornerSize r11) {
        TypedValue r12 = r5.peekValue(r10);
        if (r12 != null) goto L5;
        return r11;
    L5:
        int r13 = r12.type;
        if (r13 != 5) goto L10;
        return new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(r12.data, r5.getResources().getDisplayMetrics()));
    L10:
        if (r13 == 6) goto L12;
        return r11;
    L12:
        return new RelativeCornerSize(r12.getFraction(1.0f, 1.0f));
    }

    @NonNull
    public EdgeTreatment getBottomEdge() {
        return this.bottomEdge;
    }

    @NonNull
    public CornerTreatment getBottomLeftCorner() {
        return this.bottomLeftCorner;
    }

    @NonNull
    public CornerSize getBottomLeftCornerSize() {
        return this.bottomLeftCornerSize;
    }

    @NonNull
    public CornerTreatment getBottomRightCorner() {
        return this.bottomRightCorner;
    }

    @NonNull
    public CornerSize getBottomRightCornerSize() {
        return this.bottomRightCornerSize;
    }

    @NonNull
    public EdgeTreatment getLeftEdge() {
        return this.leftEdge;
    }

    @NonNull
    public EdgeTreatment getRightEdge() {
        return this.rightEdge;
    }

    @NonNull
    public EdgeTreatment getTopEdge() {
        return this.topEdge;
    }

    @NonNull
    public CornerTreatment getTopLeftCorner() {
        return this.topLeftCorner;
    }

    @NonNull
    public CornerSize getTopLeftCornerSize() {
        return this.topLeftCornerSize;
    }

    @NonNull
    public CornerTreatment getTopRightCorner() {
        return this.topRightCorner;
    }

    @NonNull
    public CornerSize getTopRightCornerSize() {
        return this.topRightCornerSize;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect(@NonNull RectF r10) {
        if (this.leftEdge.getClass().equals(EdgeTreatment.class) == true) goto L5;
    L11:
        boolean r5 = false;
    L12:
        float r11 = this.topLeftCornerSize.getCornerSize(r10);
        if (this.topRightCornerSize.getCornerSize(r10) == r11) goto L15;
    L19:
        boolean r12 = false;
    L21:
        if ((this.topRightCorner instanceof RoundedCornerTreatment) == true) goto L23;
    L29:
        boolean r13 = false;
    L30:
        if (r5 == false) goto L35;
        if (r12 == false) goto L36;
        if (r13 == true) goto L34;
        return false;
    L34:
        return true;
    L36:
        return false;
    L35:
        return false;
    L23:
        if ((this.topLeftCorner instanceof RoundedCornerTreatment) == false) goto L29;
        if ((this.bottomRightCorner instanceof RoundedCornerTreatment) == false) goto L29;
        if ((this.bottomLeftCorner instanceof RoundedCornerTreatment) == false) goto L29;
        r13 = true;
        goto L30
    L15:
        if (this.bottomLeftCornerSize.getCornerSize(r10) != r11) goto L19;
        if (this.bottomRightCornerSize.getCornerSize(r10) != r11) goto L19;
        r12 = true;
        goto L21
    L5:
        if (this.rightEdge.getClass().equals(EdgeTreatment.class) == false) goto L11;
        if (this.topEdge.getClass().equals(EdgeTreatment.class) == false) goto L11;
        if (this.bottomEdge.getClass().equals(EdgeTreatment.class) == false) goto L11;
        r5 = true;
        goto L12
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @NonNull
    public ShapeAppearanceModel withCornerSize(float r5) {
        return toBuilder().setAllCornerSizes(r5).build();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ShapeAppearanceModel withTransformedCornerSizes(@NonNull CornerSizeUnaryOperator r5) {
        return toBuilder().setTopLeftCornerSize(r5.apply(getTopLeftCornerSize())).setTopRightCornerSize(r5.apply(getTopRightCornerSize())).setBottomLeftCornerSize(r5.apply(getBottomLeftCornerSize())).setBottomRightCornerSize(r5.apply(getBottomRightCornerSize())).build();
    }

    private ShapeAppearanceModel(@NonNull Builder r5) {
        this.topLeftCorner = Builder.access$100(r5);
        this.topRightCorner = Builder.access$200(r5);
        this.bottomRightCorner = Builder.access$300(r5);
        this.bottomLeftCorner = Builder.access$400(r5);
        this.topLeftCornerSize = Builder.access$500(r5);
        this.topRightCornerSize = Builder.access$600(r5);
        this.bottomRightCornerSize = Builder.access$700(r5);
        this.bottomLeftCornerSize = Builder.access$800(r5);
        this.topEdge = Builder.access$900(r5);
        this.rightEdge = Builder.access$1000(r5);
        this.bottomEdge = Builder.access$1100(r5);
        this.leftEdge = Builder.access$1200(r5);
    }

    @NonNull
    public static Builder builder(@NonNull Context r5, AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        return builder(r5, r10, r11, r12, 0);
    }

    @NonNull
    public ShapeAppearanceModel withCornerSize(@NonNull CornerSize r5) {
        return toBuilder().setAllCornerSizes(r5).build();
    }

    @NonNull
    public static Builder builder(@NonNull Context r5, AttributeSet r10, @AttrRes int r11, @StyleRes int r12, int r13) {
        return builder(r5, r10, r11, r12, new AbsoluteCornerSize(r13));
    }

    @NonNull
    public static Builder builder(@NonNull Context r5, AttributeSet r10, @AttrRes int r11, @StyleRes int r12, @NonNull CornerSize r13) {
        TypedArray r14 = r5.obtainStyledAttributes(r10, R.styleable.MaterialShape, r11, r12);
        int r15 = r14.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int r16 = r14.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        r14.recycle();
        return builder(r5, r15, r16, r13);
    }

    @NonNull
    public static Builder builder(Context r5, @StyleRes int r10, @StyleRes int r11) {
        return builder(r5, r10, r11, 0);
    }

    @NonNull
    private static Builder builder(Context r5, @StyleRes int r10, @StyleRes int r11, int r12) {
        return builder(r5, r10, r11, new AbsoluteCornerSize(r12));
    }

    @NonNull
    private static Builder builder(Context r10, @StyleRes int r11, @StyleRes int r12, @NonNull CornerSize r13) {
        ContextThemeWrapper r5 = new ContextThemeWrapper(r10, r11);
        if (r12 == 0) goto L5;
        r5 = new ContextThemeWrapper(r5, r12);
    L5:
        TypedArray r14 = r5.obtainStyledAttributes(R.styleable.ShapeAppearance);
        int r15 = r14.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);     // Catch: Throwable -> L9
        int r16 = r14.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, r15);     // Catch: Throwable -> L9
        int r17 = r14.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, r15);     // Catch: Throwable -> L9
        int r18 = r14.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, r15);     // Catch: Throwable -> L9
        int r19 = r14.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, r15);     // Catch: Throwable -> L9
        CornerSize r20 = getCornerSize(r14, R.styleable.ShapeAppearance_cornerSize, r13);     // Catch: Throwable -> L9
        CornerSize r21 = getCornerSize(r14, R.styleable.ShapeAppearance_cornerSizeTopLeft, r20);     // Catch: Throwable -> L9
        CornerSize r22 = getCornerSize(r14, R.styleable.ShapeAppearance_cornerSizeTopRight, r20);     // Catch: Throwable -> L9
        CornerSize r23 = getCornerSize(r14, R.styleable.ShapeAppearance_cornerSizeBottomRight, r20);     // Catch: Throwable -> L9
        CornerSize r24 = getCornerSize(r14, R.styleable.ShapeAppearance_cornerSizeBottomLeft, r20);     // Catch: Throwable -> L9
        Builder r25 = new Builder().setTopLeftCorner(r16, r21).setTopRightCorner(r17, r22).setBottomRightCorner(r18, r23).setBottomLeftCorner(r19, r24);     // Catch: Throwable -> L9
        r14.recycle();
        return r25;
    L9:
        th = move-exception;
        r14.recycle();
        throw th;
    }

    public ShapeAppearanceModel() {
        this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
    }
}
