package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class CharSpreadBuilder extends PrimitiveSpreadBuilder<char[]> {
    private final char[] values;

    public CharSpreadBuilder(int r10) {
        super(r10);
        this.values = new char[r10];
    }

    public final void add(char r10) {
        char[] r11 = this.values;
        int r12 = getPosition();
        setPosition(r12 + 1);
        r11[r12] = r10;
    }

    @Override // kotlin.jvm.internal.PrimitiveSpreadBuilder
    public /* bridge */ /* synthetic */ int getSize(char[] r10) {
        return getSize2(r10);
    }

    /* JADX INFO: renamed from: getSize, reason: avoid collision after fix types in other method */
    protected int getSize2(char[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.length;
    }

    public final char[] toArray() {
        return toArray(this.values, new char[size()]);
    }
}
