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

    public PathProperty(Property<T, PointF> r5, Path r10) {
        super(Float.class, r5.getName());
        this.mPosition = new float[2];
        this.mPointF = new PointF();
        this.mProperty = r5;
        PathMeasure r11 = new PathMeasure(r10, false);
        this.mPathMeasure = r11;
        this.mPathLength = r11.getLength();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(Object r5) {
        return get(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Object r5, Float r10) {
        set2(r5, r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public Float get(T r5) {
        return Float.valueOf(this.mCurrentFraction);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(T r5, Float r10) {
        this.mCurrentFraction = r10.floatValue();
        PathMeasure r11 = this.mPathMeasure;
        float r12 = this.mPathLength;
        r11.getPosTan(r10.floatValue() * r12, this.mPosition, null);
        PointF r13 = this.mPointF;
        float[] r14 = this.mPosition;
        r13.x = r14[0];
        r13.y = r14[1];
        this.mProperty.set(r5, r13);
    }
}
