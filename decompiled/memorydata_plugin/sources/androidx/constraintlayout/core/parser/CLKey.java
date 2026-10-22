package androidx.constraintlayout.core.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class CLKey extends CLContainer {
    private static ArrayList<String> sections;

    static {
        ArrayList<String> r0 = new ArrayList();
        sections = r0;
        r0.add("ConstraintSets");
        sections.add("Variables");
        sections.add("Generate");
        sections.add(TypedValues.TransitionType.NAME);
        sections.add("KeyFrames");
        sections.add(TypedValues.AttributesType.NAME);
        sections.add("KeyPositions");
        sections.add("KeyCycles");
    }

    public CLKey(char[] r1) {
        super(r1);
    }

    public static CLElement allocate(String r3, CLElement r4) {
        CLKey r0 = new CLKey(r3.toCharArray());
        r0.setStart(0);
        r0.setEnd(r3.length() - 1);
        r0.set(r4);
        return r0;
    }

    public static CLElement allocate(char[] r1) {
        return new CLKey(r1);
    }

    public String getName() {
        return content();
    }

    public CLElement getValue() {
        if (this.mElements.size() > 0) goto L5;
        return null;
    L5:
        return (CLElement) ZeusTransformUtils.preCheckCast(this.mElements.get(0), CLElement.class, "com.obric.memorydata.plugin");
    }

    public void set(CLElement r2) {
        int r0 = this.mElements.size();
        ArrayList<CLElement> r1 = this.mElements;
        if (r0 <= 0) goto L5;
        r1.set(0, r2);
        return;
    L5:
        r1.add(r2);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int r7, int r8) {
        StringBuilder r0 = new StringBuilder(getDebugName());
        addIndent(r0, r7);
        String r1 = content();
        if (this.mElements.size() <= 0) goto L16;
        r0.append(r1);
        r0.append(": ");
        if (sections.contains(r1) == false) goto L8;
        r8 = 3;
    L8:
        if (r8 <= 0) goto L10;
    L9:
        r0.append(((CLElement) ZeusTransformUtils.preCheckCast(this.mElements.get(0), CLElement.class, "com.obric.memorydata.plugin")).toFormattedJSON(r7, r8 - 1));
    L14:
        return r0.toString();
    L10:
        String r3 = ((CLElement) ZeusTransformUtils.preCheckCast(this.mElements.get(0), CLElement.class, "com.obric.memorydata.plugin")).toJSON();
        if ((r3.length() + r7) >= MAX_LINE) goto L9;
        r0.append(r3);
        goto L14
    L16:
        return r1 + ": <> ";
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        if (this.mElements.size() <= 0) goto L7;
        StringBuilder r3 = new StringBuilder().append(getDebugName()).append(content()).append(": ").append(((CLElement) ZeusTransformUtils.preCheckCast(this.mElements.get(0), CLElement.class, "com.obric.memorydata.plugin")).toJSON());
    L6:
        return r3.toString();
    L7:
        r3 = new StringBuilder().append(getDebugName()).append(content()).append(": <> ");
        goto L6
    }
}
