package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class BooleanSpreadBuilder extends PrimitiveSpreadBuilder<boolean[]> {
    private final boolean[] values;

    public BooleanSpreadBuilder(int r10) {
        super(r10);
        this.values = new boolean[r10];
    }

    public final void add(boolean r10) {
        boolean[] r11 = this.values;
        int r12 = getPosition();
        setPosition(r12 + 1);
        r11[r12] = r10;
    }

    @Override // kotlin.jvm.internal.PrimitiveSpreadBuilder
    public /* bridge */ /* synthetic */ int getSize(boolean[] r10) {
        return getSize2(r10);
    }

    /* JADX INFO: renamed from: getSize, reason: avoid collision after fix types in other method */
    protected int getSize2(boolean[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.length;
    }

    public final boolean[] toArray() {
        return toArray(this.values, new boolean[size()]);
    }
}
