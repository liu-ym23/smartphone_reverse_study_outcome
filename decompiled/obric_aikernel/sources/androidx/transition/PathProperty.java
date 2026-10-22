package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
class PathProperty<T> extends Property<T, Float> {
    private float mCurrentFraction;
    private final float mPathLength;
    private final PathMeasure mPathMeasure;
    private final PointF mPointF;
    private final float[] mPosition;
    private final Property<T, PointF> mProperty;

    PathProperty(Property<T, PointF> r10, Path r11) {
        super(Float.class, r10.getName());
        this.mPosition = new float[2];
        this.mPointF = new PointF();
        this.mProperty = r10;
        PathMeasure r12 = new PathMeasure(r11, false);
        this.mPathMeasure = r12;
        this.mPathLength = r12.getLength();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public Float get(T r10) {
        return Float.valueOf(this.mCurrentFraction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(Object r10) {
        return get(r10);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(T r10, Float r11) {
        this.mCurrentFraction = r11.floatValue();
        this.mPathMeasure.getPosTan(this.mPathLength * r11.floatValue(), this.mPosition, null);
        PointF r12 = this.mPointF;
        float[] r13 = this.mPosition;
        r12.x = r13[0];
        r12.y = r13[1];
        this.mProperty.set(r10, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Object r10, Float r11) {
        set2(r10, r11);
    }
}
