package androidx.constraintlayout.core.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CLContainer extends CLElement {
    ArrayList<CLElement> mElements;

    public CLContainer(char[] r1) {
        super(r1);
        this.mElements = new ArrayList();
    }

    public static CLElement allocate(char[] r1) {
        return new CLContainer(r1);
    }

    public void add(CLElement r4) {
        this.mElements.add(r4);
        if (CLParser.DEBUG == false) goto L6;
        System.out.println("added element " + r4 + " to " + this);
        return;
    }

    public CLElement get(int r4) {
        if (r4 < 0) goto L8;
        if (r4 >= this.mElements.size()) goto L8;
        return (CLElement) ZeusTransformUtils.preCheckCast(this.mElements.get(r4), CLElement.class, "com.obric.memorydata.plugin");
    L8:
        throw new CLParsingException("no element at index " + r4, this);
    }

    public CLElement get(String r5) {
        Iterator<CLElement> r0 = this.mElements.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        CLKey r1 = (CLKey) ZeusTransformUtils.preCheckCast((CLElement) ZeusTransformUtils.preCheckCast(r0.next(), CLElement.class, "com.obric.memorydata.plugin"), CLKey.class, "com.obric.memorydata.plugin");
        if (r1.content().equals(r5) == false) goto L4;
        return r1.getValue();
    L10:
        throw new CLParsingException("no element for key <" + r5 + ">", this);
    }

    public CLArray getArray(int r4) {
        CLElement r0 = get(r4);
        if (ZeusTransformUtils.instanceOf(r0, CLArray.class) == false) goto L7;
        return (CLArray) ZeusTransformUtils.preCheckCast(r0, CLArray.class, "com.obric.memorydata.plugin");
    L7:
        throw new CLParsingException("no array at index " + r4, this);
    }

    public CLArray getArray(String r5) {
        CLElement r0 = get(r5);
        if (ZeusTransformUtils.instanceOf(r0, CLArray.class) == false) goto L7;
        return (CLArray) ZeusTransformUtils.preCheckCast(r0, CLArray.class, "com.obric.memorydata.plugin");
    L7:
        throw new CLParsingException("no array found for key <" + r5 + ">, found [" + r0.getStrClass() + "] : " + r0, this);
    }

    public CLArray getArrayOrNull(String r2) {
        CLElement r1 = getOrNull(r2);
        if (ZeusTransformUtils.instanceOf(r1, CLArray.class) == true) goto L5;
        return null;
    L5:
        return (CLArray) ZeusTransformUtils.preCheckCast(r1, CLArray.class, "com.obric.memorydata.plugin");
    }

    public boolean getBoolean(int r4) {
        CLElement r0 = get(r4);
        if (ZeusTransformUtils.instanceOf(r0, CLToken.class) == false) goto L7;
        return ((CLToken) ZeusTransformUtils.preCheckCast(r0, CLToken.class, "com.obric.memorydata.plugin")).getBoolean();
    L7:
        throw new CLParsingException("no boolean at index " + r4, this);
    }

    public boolean getBoolean(String r5) {
        CLElement r0 = get(r5);
        if (ZeusTransformUtils.instanceOf(r0, CLToken.class) == false) goto L7;
        return ((CLToken) ZeusTransformUtils.preCheckCast(r0, CLToken.class, "com.obric.memorydata.plugin")).getBoolean();
    L7:
        throw new CLParsingException("no boolean found for key <" + r5 + ">, found [" + r0.getStrClass() + "] : " + r0, this);
    }

    public float getFloat(int r4) {
        CLElement r0 = get(r4);
        if (r0 == null) goto L7;
        return r0.getFloat();
    L7:
        throw new CLParsingException("no float at index " + r4, this);
    }

    public float getFloat(String r5) {
        CLElement r0 = get(r5);
        if (r0 == null) goto L7;
        return r0.getFloat();
    L7:
        throw new CLParsingException("no float found for key <" + r5 + ">, found [" + r0.getStrClass() + "] : " + r0, this);
    }

    public float getFloatOrNaN(String r1) {
        CLElement r0 = getOrNull(r1);
        if (ZeusTransformUtils.instanceOf(r0, CLNumber.class) == true) goto L5;
        return Float.NaN;
    L5:
        return r0.getFloat();
    }

    public int getInt(int r4) {
        CLElement r0 = get(r4);
        if (r0 == null) goto L7;
        return r0.getInt();
    L7:
        throw new CLParsingException("no int at index " + r4, this);
    }

    public int getInt(String r5) {
        CLElement r0 = get(r5);
        if (r0 == null) goto L7;
        return r0.getInt();
    L7:
        throw new CLParsingException("no int found for key <" + r5 + ">, found [" + r0.getStrClass() + "] : " + r0, this);
    }

    public CLObject getObject(int r4) {
        CLElement r0 = get(r4);
        if (ZeusTransformUtils.instanceOf(r0, CLObject.class) == false) goto L7;
        return (CLObject) ZeusTransformUtils.preCheckCast(r0, CLObject.class, "com.obric.memorydata.plugin");
    L7:
        throw new CLParsingException("no object at index " + r4, this);
    }

    public CLObject getObject(String r5) {
        CLElement r0 = get(r5);
        if (ZeusTransformUtils.instanceOf(r0, CLObject.class) == false) goto L7;
        return (CLObject) ZeusTransformUtils.preCheckCast(r0, CLObject.class, "com.obric.memorydata.plugin");
    L7:
        throw new CLParsingException("no object found for key <" + r5 + ">, found [" + r0.getStrClass() + "] : " + r0, this);
    }

    public CLObject getObjectOrNull(String r2) {
        CLElement r1 = getOrNull(r2);
        if (ZeusTransformUtils.instanceOf(r1, CLObject.class) == true) goto L5;
        return null;
    L5:
        return (CLObject) ZeusTransformUtils.preCheckCast(r1, CLObject.class, "com.obric.memorydata.plugin");
    }

    public CLElement getOrNull(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.mElements.size()) goto L6;
        return null;
    L6:
        return (CLElement) ZeusTransformUtils.preCheckCast(this.mElements.get(r2), CLElement.class, "com.obric.memorydata.plugin");
    }

    public CLElement getOrNull(String r4) {
        Iterator<CLElement> r3 = this.mElements.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        CLKey r0 = (CLKey) ZeusTransformUtils.preCheckCast((CLElement) ZeusTransformUtils.preCheckCast(r3.next(), CLElement.class, "com.obric.memorydata.plugin"), CLKey.class, "com.obric.memorydata.plugin");
        if (r0.content().equals(r4) == false) goto L4;
        return r0.getValue();
    L9:
        return null;
    }

    public String getString(int r4) {
        CLElement r0 = get(r4);
        if (ZeusTransformUtils.instanceOf(r0, CLString.class) == false) goto L7;
        return r0.content();
    L7:
        throw new CLParsingException("no string at index " + r4, this);
    }

    public String getString(String r6) {
        CLElement r0 = get(r6);
        if (ZeusTransformUtils.instanceOf(r0, CLString.class) == true) goto L5;
        String r1 = null;
        if (r0 == null) goto L10;
        r1 = r0.getStrClass();
    L10:
        throw new CLParsingException("no string found for key <" + r6 + ">, found [" + r1 + "] : " + r0, this);
    L5:
        return r0.content();
    }

    public String getStringOrNull(int r1) {
        CLElement r0 = getOrNull(r1);
        if (ZeusTransformUtils.instanceOf(r0, CLString.class) == true) goto L5;
        return null;
    L5:
        return r0.content();
    }

    public String getStringOrNull(String r1) {
        CLElement r0 = getOrNull(r1);
        if (ZeusTransformUtils.instanceOf(r0, CLString.class) == true) goto L5;
        return null;
    L5:
        return r0.content();
    }

    public boolean has(String r4) {
        Iterator<CLElement> r3 = this.mElements.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        CLElement r0 = (CLElement) ZeusTransformUtils.preCheckCast(r3.next(), CLElement.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, CLKey.class) == false) goto L4;
        if (((CLKey) ZeusTransformUtils.preCheckCast(r0, CLKey.class, "com.obric.memorydata.plugin")).content().equals(r4) == false) goto L4;
        return true;
    L11:
        return false;
    }

    public ArrayList<String> names() {
        ArrayList<String> r0 = new ArrayList();
        Iterator<CLElement> r4 = this.mElements.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        CLElement r1 = (CLElement) ZeusTransformUtils.preCheckCast(r4.next(), CLElement.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, CLKey.class) == false) goto L4;
        r0.add(((CLKey) ZeusTransformUtils.preCheckCast(r1, CLKey.class, "com.obric.memorydata.plugin")).content());
        goto L4
    L8:
        return r0;
    }

    public void put(String r5, CLElement r6) {
        Iterator<CLElement> r0 = this.mElements.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        CLKey r1 = (CLKey) ZeusTransformUtils.preCheckCast((CLElement) ZeusTransformUtils.preCheckCast(r0.next(), CLElement.class, "com.obric.memorydata.plugin"), CLKey.class, "com.obric.memorydata.plugin");
        if (r1.content().equals(r5) == false) goto L4;
        r1.set(r6);
        return;
    L9:
        CLKey r7 = (CLKey) ZeusTransformUtils.preCheckCast(CLKey.allocate(r5, r6), CLKey.class, "com.obric.memorydata.plugin");
        this.mElements.add(r7);
    }

    public void putNumber(String r2, float r3) {
        put(r2, new CLNumber(r3));
    }

    public void remove(String r6) {
        ArrayList r0 = new ArrayList();
        Iterator<CLElement> r1 = this.mElements.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        CLElement r2 = (CLElement) ZeusTransformUtils.preCheckCast(r1.next(), CLElement.class, "com.obric.memorydata.plugin");
        if (((CLKey) ZeusTransformUtils.preCheckCast(r2, CLKey.class, "com.obric.memorydata.plugin")).content().equals(r6) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r7 = r0.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        CLElement r3 = (CLElement) ZeusTransformUtils.preCheckCast(r7.next(), CLElement.class, "com.obric.memorydata.plugin");
        this.mElements.remove(r3);
        goto L10
    }

    public int size() {
        return this.mElements.size();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Iterator<CLElement> r1 = this.mElements.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        CLElement r2 = (CLElement) ZeusTransformUtils.preCheckCast(r1.next(), CLElement.class, "com.obric.memorydata.plugin");
        if (r0.length() <= 0) goto L8;
        r0.append("; ");
    L8:
        r0.append(r2);
        goto L4
    L10:
        return super.toString() + " = <" + r0 + " >";
    }
}
