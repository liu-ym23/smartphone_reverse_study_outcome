package androidx.constraintlayout.core.parser;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CLObject extends CLContainer implements Iterable<CLKey> {

    private class CLObjectIterator implements Iterator {
        int index;
        CLObject myObject;
        final /* synthetic */ CLObject this$0;

        public CLObjectIterator(CLObject r10, CLObject r11) {
            this.this$0 = r10;
            this.index = 0;
            this.myObject = r11;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.myObject.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            CLKey r10 = (CLKey) this.myObject.mElements.get(this.index);
            this.index++;
            return r10;
        }
    }

    public CLObject(char[] r10) {
        super(r10);
    }

    public static CLObject allocate(char[] r10) {
        return new CLObject(r10);
    }

    @Override // java.lang.Iterable
    public Iterator<CLKey> iterator() {
        return new CLObjectIterator(this, this);
    }

    public String toFormattedJSON() {
        return toFormattedJSON(0, 0);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int r10, int r11) {
        StringBuilder r12 = new StringBuilder(getDebugName());
        r12.append("{\n");
        Iterator<CLElement> r13 = this.mElements.iterator();
        boolean r14 = true;
    L4:
        if (r13.hasNext() == false) goto L10;
        CLElement r15 = r13.next();
        if (r14 == true) goto L8;
        r12.append(",\n");
    L9:
        r12.append(r15.toFormattedJSON(CLElement.BASE_INDENT + r10, r11 - 1));
        goto L4
    L8:
        r14 = false;
        goto L9
    L10:
        r12.append("\n");
        addIndent(r12, r10);
        r12.append("}");
        return r12.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder r10 = new StringBuilder(getDebugName() + "{ ");
        Iterator<CLElement> r11 = this.mElements.iterator();
        boolean r12 = true;
    L4:
        if (r11.hasNext() == false) goto L10;
        CLElement r13 = r11.next();
        if (r12 == true) goto L8;
        r10.append(", ");
    L9:
        r10.append(r13.toJSON());
        goto L4
    L8:
        r12 = false;
        goto L9
    L10:
        r10.append(" }");
        return r10.toString();
    }
}
