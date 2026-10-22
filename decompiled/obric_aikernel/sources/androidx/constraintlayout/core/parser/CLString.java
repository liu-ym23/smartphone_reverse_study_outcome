package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class CLString extends CLElement {
    public CLString(char[] r10) {
        super(r10);
    }

    public static CLElement allocate(char[] r10) {
        return new CLString(r10);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int r10, int r11) {
        StringBuilder r12 = new StringBuilder();
        addIndent(r12, r10);
        r12.append("'");
        r12.append(content());
        r12.append("'");
        return r12.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        return "'" + content() + "'";
    }
}
