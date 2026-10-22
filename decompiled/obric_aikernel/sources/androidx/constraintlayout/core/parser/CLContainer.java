package androidx.constraintlayout.core.parser;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CLContainer extends CLElement {
    ArrayList<CLElement> mElements;

    public CLContainer(char[] r10) {
        super(r10);
        this.mElements = new ArrayList();
    }

    public static CLElement allocate(char[] r10) {
        return new CLContainer(r10);
    }

    public void add(CLElement r10) {
        this.mElements.add(r10);
        if (CLParser.DEBUG == false) goto L6;
        System.out.println("added element " + r10 + " to " + this);
        return;
    }

    public CLElement get(int r10) {
        if (r10 < 0) goto L8;
        if (r10 >= this.mElements.size()) goto L8;
        return this.mElements.get(r10);
    L8:
        throw new CLParsingException("no element at index " + r10, this);
    }

    public CLElement get(String r10) {
        Iterator<CLElement> r11 = this.mElements.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        CLKey r12 = (CLKey) r11.next();
        if (r12.content().equals(r10) == false) goto L4;
        return r12.getValue();
    L10:
        throw new CLParsingException("no element for key <" + r10 + ">", this);
    }

    public CLArray getArray(int r10) {
        CLElement r11 = get(r10);
        if ((r11 instanceof CLArray) == false) goto L7;
        return (CLArray) r11;
    L7:
        throw new CLParsingException("no array at index " + r10, this);
    }

    public CLArray getArray(String r10) {
        CLElement r11 = get(r10);
        if ((r11 instanceof CLArray) == false) goto L7;
        return (CLArray) r11;
    L7:
        throw new CLParsingException("no array found for key <" + r10 + ">, found [" + r11.getStrClass() + "] : " + r11, this);
    }

    public CLArray getArrayOrNull(String r10) {
        CLElement r11 = getOrNull(r10);
        if ((r11 instanceof CLArray) == true) goto L5;
        return null;
    L5:
        return (CLArray) r11;
    }

    public boolean getBoolean(int r10) {
        CLElement r11 = get(r10);
        if ((r11 instanceof CLToken) == false) goto L7;
        return ((CLToken) r11).getBoolean();
    L7:
        throw new CLParsingException("no boolean at index " + r10, this);
    }

    public boolean getBoolean(String r10) {
        CLElement r11 = get(r10);
        if ((r11 instanceof CLToken) == false) goto L7;
        return ((CLToken) r11).getBoolean();
    L7:
        throw new CLParsingException("no boolean found for key <" + r10 + ">, found [" + r11.getStrClass() + "] : " + r11, this);
    }

    public float getFloat(int r10) {
        CLElement r11 = get(r10);
        if (r11 == null) goto L7;
        return r11.getFloat();
    L7:
        throw new CLParsingException("no float at index " + r10, this);
    }

    public float getFloat(String r10) {
        CLElement r11 = get(r10);
        if (r11 == null) goto L7;
        return r11.getFloat();
    L7:
        throw new CLParsingException("no float found for key <" + r10 + ">, found [" + r11.getStrClass() + "] : " + r11, this);
    }

    public float getFloatOrNaN(String r10) {
        CLElement r11 = getOrNull(r10);
        if ((r11 instanceof CLNumber) == true) goto L5;
        return Float.NaN;
    L5:
        return r11.getFloat();
    }

    public int getInt(int r10) {
        CLElement r11 = get(r10);
        if (r11 == null) goto L7;
        return r11.getInt();
    L7:
        throw new CLParsingException("no int at index " + r10, this);
    }

    public int getInt(String r10) {
        CLElement r11 = get(r10);
        if (r11 == null) goto L7;
        return r11.getInt();
    L7:
        throw new CLParsingException("no int found for key <" + r10 + ">, found [" + r11.getStrClass() + "] : " + r11, this);
    }

    public CLObject getObject(int r10) {
        CLElement r11 = get(r10);
        if ((r11 instanceof CLObject) == false) goto L7;
        return (CLObject) r11;
    L7:
        throw new CLParsingException("no object at index " + r10, this);
    }

    public CLObject getObject(String r10) {
        CLElement r11 = get(r10);
        if ((r11 instanceof CLObject) == false) goto L7;
        return (CLObject) r11;
    L7:
        throw new CLParsingException("no object found for key <" + r10 + ">, found [" + r11.getStrClass() + "] : " + r11, this);
    }

    public CLObject getObjectOrNull(String r10) {
        CLElement r11 = getOrNull(r10);
        if ((r11 instanceof CLObject) == true) goto L5;
        return null;
    L5:
        return (CLObject) r11;
    }

    public CLElement getOrNull(int r10) {
        if (r10 >= 0) goto L4;
        return null;
    L4:
        if (r10 < this.mElements.size()) goto L6;
        return null;
    L6:
        return this.mElements.get(r10);
    }

    public CLElement getOrNull(String r10) {
        Iterator<CLElement> r11 = this.mElements.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        CLKey r12 = (CLKey) r11.next();
        if (r12.content().equals(r10) == false) goto L4;
        return r12.getValue();
    L9:
        return null;
    }

    public String getString(int r10) {
        CLElement r11 = get(r10);
        if ((r11 instanceof CLString) == false) goto L7;
        return r11.content();
    L7:
        throw new CLParsingException("no string at index " + r10, this);
    }

    public String getString(String r10) {
        CLElement r11 = get(r10);
        if ((r11 instanceof CLString) == true) goto L5;
        String r12 = null;
        if (r11 == null) goto L10;
        r12 = r11.getStrClass();
    L10:
        throw new CLParsingException("no string found for key <" + r10 + ">, found [" + r12 + "] : " + r11, this);
    L5:
        return r11.content();
    }

    public String getStringOrNull(int r10) {
        CLElement r11 = getOrNull(r10);
        if ((r11 instanceof CLString) == true) goto L5;
        return null;
    L5:
        return r11.content();
    }

    public String getStringOrNull(String r10) {
        CLElement r11 = getOrNull(r10);
        if ((r11 instanceof CLString) == true) goto L5;
        return null;
    L5:
        return r11.content();
    }

    public boolean has(String r10) {
        Iterator<CLElement> r11 = this.mElements.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        CLElement r12 = r11.next();
        if ((r12 instanceof CLKey) == false) goto L4;
        if (((CLKey) r12).content().equals(r10) == false) goto L4;
        return true;
    L11:
        return false;
    }

    public ArrayList<String> names() {
        ArrayList<String> r10 = new ArrayList();
        Iterator<CLElement> r11 = this.mElements.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        CLElement r12 = r11.next();
        if ((r12 instanceof CLKey) == false) goto L4;
        r10.add(((CLKey) r12).content());
        goto L4
    L8:
        return r10;
    }

    public void put(String r10, CLElement r11) {
        Iterator<CLElement> r12 = this.mElements.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        CLKey r13 = (CLKey) r12.next();
        if (r13.content().equals(r10) == false) goto L4;
        r13.set(r11);
        return;
    L9:
        CLKey r14 = (CLKey) CLKey.allocate(r10, r11);
        this.mElements.add(r14);
    }

    public void putNumber(String r10, float r11) {
        put(r10, new CLNumber(r11));
    }

    public void remove(String r10) {
        ArrayList r11 = new ArrayList();
        Iterator<CLElement> r12 = this.mElements.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        CLElement r13 = r12.next();
        if (((CLKey) r13).content().equals(r10) == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        Iterator r14 = r11.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        CLElement r15 = (CLElement) r14.next();
        this.mElements.remove(r15);
        goto L10
    }

    public int size() {
        return this.mElements.size();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        Iterator<CLElement> r11 = this.mElements.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        CLElement r12 = r11.next();
        if (r10.length() <= 0) goto L8;
        r10.append("; ");
    L8:
        r10.append(r12);
        goto L4
    L10:
        return super.toString() + " = <" + r10 + " >";
    }
}
