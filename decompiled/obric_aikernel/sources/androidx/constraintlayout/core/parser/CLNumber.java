package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class CLNumber extends CLElement {
    float value;

    public CLNumber(float r10) {
        super(null);
        this.value = Float.NaN;
        this.value = r10;
    }

    public CLNumber(char[] r10) {
        super(r10);
        this.value = Float.NaN;
    }

    public static CLElement allocate(char[] r10) {
        return new CLNumber(r10);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public float getFloat() {
        if (Float.isNaN(this.value) == false) goto L6;
        this.value = Float.parseFloat(content());
    L6:
        return this.value;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int getInt() {
        if (Float.isNaN(this.value) == false) goto L6;
        this.value = Integer.parseInt(content());
    L6:
        return (int) this.value;
    }

    public boolean isInt() {
        float r10 = getFloat();
        if (((int) r10) != r10) goto L5;
        return true;
    L5:
        return false;
    }

    public void putValue(float r10) {
        this.value = r10;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int r10, int r11) {
        StringBuilder r12 = new StringBuilder();
        addIndent(r12, r10);
        float r13 = getFloat();
        int r14 = (int) r13;
        if (r14 != r13) goto L5;
        r12.append(r14);
    L7:
        return r12.toString();
    L5:
        r12.append(r13);
        goto L7
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        float r10 = getFloat();
        int r11 = (int) r10;
        if (r11 != r10) goto L7;
        return "" + r11;
    L7:
        return "" + r10;
    }
}
