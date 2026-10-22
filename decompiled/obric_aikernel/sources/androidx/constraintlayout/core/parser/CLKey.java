package androidx.constraintlayout.core.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class CLKey extends CLContainer {
    private static ArrayList<String> sections;

    static {
        ArrayList<String> r10 = new ArrayList();
        sections = r10;
        r10.add("ConstraintSets");
        sections.add("Variables");
        sections.add("Generate");
        sections.add(TypedValues.TransitionType.NAME);
        sections.add("KeyFrames");
        sections.add(TypedValues.AttributesType.NAME);
        sections.add("KeyPositions");
        sections.add("KeyCycles");
    }

    public CLKey(char[] r10) {
        super(r10);
    }

    public static CLElement allocate(String r10, CLElement r11) {
        CLKey r12 = new CLKey(r10.toCharArray());
        r12.setStart(0);
        r12.setEnd(r10.length() - 1);
        r12.set(r11);
        return r12;
    }

    public static CLElement allocate(char[] r10) {
        return new CLKey(r10);
    }

    public String getName() {
        return content();
    }

    public CLElement getValue() {
        if (this.mElements.size() > 0) goto L5;
        return null;
    L5:
        return this.mElements.get(0);
    }

    public void set(CLElement r10) {
        int r11 = this.mElements.size();
        ArrayList<CLElement> r12 = this.mElements;
        if (r11 <= 0) goto L5;
        r12.set(0, r10);
        return;
    L5:
        r12.add(r10);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int r10, int r11) {
        StringBuilder r12 = new StringBuilder(getDebugName());
        addIndent(r12, r10);
        String r13 = content();
        if (this.mElements.size() <= 0) goto L16;
        r12.append(r13);
        r12.append(": ");
        if (sections.contains(r13) == false) goto L8;
        r11 = 3;
    L8:
        if (r11 <= 0) goto L10;
    L9:
        r12.append(this.mElements.get(0).toFormattedJSON(r10, r11 - 1));
    L14:
        return r12.toString();
    L10:
        String r14 = this.mElements.get(0).toJSON();
        if ((r14.length() + r10) >= CLElement.MAX_LINE) goto L9;
        r12.append(r14);
        goto L14
    L16:
        return r13 + ": <> ";
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        if (this.mElements.size() <= 0) goto L7;
        StringBuilder r10 = new StringBuilder();
        r10.append(getDebugName());
        r10.append(content());
        r10.append(": ");
        String r11 = this.mElements.get(0).toJSON();
    L5:
        r10.append(r11);
        return r10.toString();
    L7:
        r10 = new StringBuilder();
        r10.append(getDebugName());
        r10.append(content());
        r11 = ": <> ";
        goto L5
    }
}
