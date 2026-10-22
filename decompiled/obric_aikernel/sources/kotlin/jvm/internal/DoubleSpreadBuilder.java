package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class DoubleSpreadBuilder extends PrimitiveSpreadBuilder<double[]> {
    private final double[] values;

    public DoubleSpreadBuilder(int r10) {
        super(r10);
        this.values = new double[r10];
    }

    public final void add(double r10) {
        double[] r11 = this.values;
        int r12 = getPosition();
        setPosition(r12 + 1);
        r11[r12] = r10;
    }

    @Override // kotlin.jvm.internal.PrimitiveSpreadBuilder
    public /* bridge */ /* synthetic */ int getSize(double[] r10) {
        return getSize2(r10);
    }

    /* JADX INFO: renamed from: getSize, reason: avoid collision after fix types in other method */
    protected int getSize2(double[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.length;
    }

    public final double[] toArray() {
        return toArray(this.values, new double[size()]);
    }
}
