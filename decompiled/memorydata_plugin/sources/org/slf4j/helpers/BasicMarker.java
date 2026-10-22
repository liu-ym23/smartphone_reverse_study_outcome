package org.slf4j.helpers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes8.dex */
public class BasicMarker implements Marker {
    private static final String CLOSE = " ]";
    private static final String OPEN = "[ ";
    private static final String SEP = ", ";
    private static final long serialVersionUID = -2849567615646933777L;
    private final String name;
    private final List<Marker> referenceList;

    BasicMarker(String r2) {
        this.referenceList = new CopyOnWriteArrayList();
        if (r2 == null) goto L7;
        this.name = r2;
        return;
    L7:
        throw new IllegalArgumentException("A marker name cannot be null");
    }

    @Override // org.slf4j.Marker
    public void add(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L13;
        if (contains(r4) == false) goto L8;
        return;
    L8:
        if (r4.contains(this) == false) goto L10;
        return;
    L10:
        this.referenceList.add(r4);
        return;
    L13:
        throw new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
    }

    @Override // org.slf4j.Marker
    public boolean contains(String r5) {
        if (r5 == null) goto L17;
        if (this.name.equals(r5) == false) goto L7;
        return true;
    L7:
        if (hasReferences() == false) goto L14;
        Iterator<Marker> r4 = this.referenceList.iterator();
    L10:
        if (r4.hasNext() == false) goto L21;
        if (((Marker) ZeusTransformUtils.preCheckCast(r4.next(), Marker.class, "com.obric.memorydata.plugin")).contains(r5) == false) goto L10;
        return true;
    L21:
        return false;
    L14:
        return false;
    L17:
        throw new IllegalArgumentException("Other cannot be null");
    }

    @Override // org.slf4j.Marker
    public boolean contains(Marker r5) {
        Marker r6 = (Marker) ZeusTransformUtils.wrapperContextForParams(r5, Marker.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L18;
        if (equals(r6) == false) goto L8;
        return true;
    L8:
        if (hasReferences() == false) goto L15;
        Iterator<Marker> r4 = this.referenceList.iterator();
    L11:
        if (r4.hasNext() == false) goto L22;
        if (((Marker) ZeusTransformUtils.preCheckCast(r4.next(), Marker.class, "com.obric.memorydata.plugin")).contains(r6) == false) goto L11;
        return true;
    L22:
        return false;
    L15:
        return false;
    L18:
        throw new IllegalArgumentException("Other cannot be null");
    }

    @Override // org.slf4j.Marker
    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if (r3 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, Marker.class) == true) goto L11;
        return false;
    L11:
        Marker r4 = (Marker) ZeusTransformUtils.preCheckCast(r3, Marker.class, "com.obric.memorydata.plugin");
        return this.name.equals(r4.getName());
    }

    @Override // org.slf4j.Marker
    public String getName() {
        return this.name;
    }

    @Override // org.slf4j.Marker
    @Deprecated
    public boolean hasChildren() {
        return hasReferences();
    }

    @Override // org.slf4j.Marker
    public boolean hasReferences() {
        if (this.referenceList.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.slf4j.Marker
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override // org.slf4j.Marker
    public Iterator<Marker> iterator() {
        return this.referenceList.iterator();
    }

    @Override // org.slf4j.Marker
    public boolean remove(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        return this.referenceList.remove(r4);
    }

    public String toString() {
        if (hasReferences() == false) goto L5;
        Iterator<Marker> r0 = iterator();
        StringBuilder r1 = new StringBuilder(getName());
        r1.append(' ').append(OPEN);
    L8:
        if (r0.hasNext() == false) goto L12;
        r1.append(((Marker) ZeusTransformUtils.preCheckCast(r0.next(), Marker.class, "com.obric.memorydata.plugin")).getName());
        if (r0.hasNext() == false) goto L8;
        r1.append(SEP);
        goto L8
    L12:
        r1.append(CLOSE);
        return r1.toString();
    L5:
        return getName();
    }
}
