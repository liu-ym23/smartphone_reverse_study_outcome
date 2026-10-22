package androidx.constraintlayout.core.parser;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CLArray extends CLContainer {
    public CLArray(char[] r10) {
        super(r10);
    }

    public static CLElement allocate(char[] r10) {
        return new CLArray(r10);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int r10, int r11) {
        StringBuilder r12 = new StringBuilder();
        String r13 = toJSON();
        if (r11 <= 0) goto L5;
    L7:
        r12.append("[\n");
        Iterator<CLElement> r14 = this.mElements.iterator();
        boolean r15 = true;
    L9:
        if (r14.hasNext() == false) goto L15;
        CLElement r16 = r14.next();
        if (r15 == true) goto L13;
        r12.append(",\n");
    L14:
        addIndent(r12, CLElement.BASE_INDENT + r10);
        r12.append(r16.toFormattedJSON(CLElement.BASE_INDENT + r10, r11 - 1));
        goto L9
    L13:
        r15 = false;
        goto L14
    L15:
        r12.append("\n");
        addIndent(r12, r10);
        r12.append("]");
    L17:
        return r12.toString();
    L5:
        if ((r13.length() + r10) >= CLElement.MAX_LINE) goto L7;
        r12.append(r13);
        goto L17
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        StringBuilder r10 = new StringBuilder(getDebugName() + "[");
        boolean r11 = true;
        int r12 = 0;
    L4:
        if (r12 >= this.mElements.size()) goto L10;
        if (r11 == true) goto L7;
        r10.append(", ");
    L8:
        r10.append(this.mElements.get(r12).toJSON());
        r12 = r12 + 1;
        goto L4
    L7:
        r11 = false;
        goto L8
    L10:
        return r10 + "]";
    }
}
