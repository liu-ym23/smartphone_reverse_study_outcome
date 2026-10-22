package org.apache.poi.poifs.property;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes7.dex */
public class DirectoryProperty extends Property implements Iterable<Property>, Parent {
    private final List<Property> _children;
    private final Set<String> _children_names;

    public static class PropertyComparator implements Serializable, Comparator<Property> {
        public PropertyComparator() {
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(Property r3, Property r4) {
            return compare2((Property) ZeusTransformUtils.preCheckCast(r3, Property.class, "com.obric.memorydata.plugin"), (Property) ZeusTransformUtils.preCheckCast(r4, Property.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Property r4, Property r5) {
            String r3 = r4.getName();
            String r6 = r5.getName();
            int r7 = r3.length() - r6.length();
            if (r7 == 0) goto L5;
            return r7;
        L5:
            if (r3.compareTo("_VBA_PROJECT") != 0) goto L8;
        L22:
            return 1;
        L8:
            if (r6.compareTo("_VBA_PROJECT") != 0) goto L11;
        L23:
            return -1;
        L11:
            if (r3.startsWith("__") == false) goto L16;
            if (r6.startsWith("__") == false) goto L16;
        L24:
            return r3.compareToIgnoreCase(r6);
        L16:
            if (r3.startsWith("__") == true) goto L22;
            if (r6.startsWith("__") == false) goto L24;
            goto L23
        }
    }

    public DirectoryProperty(int r1, byte[] r2, int r3) {
        super(r1, r2, r3);
        this._children = new ArrayList();
        this._children_names = new HashSet();
    }

    public DirectoryProperty(String r2) {
        this._children = new ArrayList();
        this._children_names = new HashSet();
        setName(r2);
        setSize(0);
        setPropertyType((byte) 1);
        setStartBlock(0);
        setNodeColor((byte) 1);
    }

    public void addChild(Property r3) {
        String r0 = r3.getName();
        if (this._children_names.contains(r0) == true) goto L7;
        this._children_names.add(r0);
        this._children.add(r3);
        return;
    L7:
        throw new IOException("Duplicate name \"" + r0 + "\"");
    }

    public boolean deleteChild(Property r2) {
        boolean r0 = this._children.remove(r2);
        if (r0 == false) goto L5;
        this._children_names.remove(r2.getName());
    L5:
        return r0;
    }

    public Iterator<Property> getChildren() {
        return this._children.iterator();
    }

    @Override // org.apache.poi.poifs.property.Property
    public boolean isDirectory() {
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<Property> iterator() {
        return getChildren();
    }

    @Override // java.lang.Iterable
    public Spliterator<Property> spliterator() {
        return this._children.spliterator();
    }
}
