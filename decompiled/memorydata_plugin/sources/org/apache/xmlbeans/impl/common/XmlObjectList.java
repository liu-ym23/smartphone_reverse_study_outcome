package org.apache.xmlbeans.impl.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: loaded from: classes7.dex */
public class XmlObjectList {
    private final XmlObject[] _objects;

    public XmlObjectList(int r1) {
        this._objects = new XmlObject[r1];
    }

    private static String prettytrim(String r3) {
        int r0 = r3.length();
    L3:
        if (r0 <= 0) goto L8;
        if (XMLChar.isSpace(r3.charAt(r0 - 1)) == false) goto L8;
        r0 = r0 - 1;
    L8:
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L15;
        if (XMLChar.isSpace(r3.charAt(r1)) == false) goto L15;
        r1 = r1 + 1;
    L15:
        return r3.substring(r1, r0);
    }

    public boolean equals(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, XmlObjectList.class) == true) goto L5;
        return false;
    L5:
        XmlObjectList r7 = (XmlObjectList) ZeusTransformUtils.preCheckCast(r6, XmlObjectList.class, "com.obric.memorydata.plugin");
        if (r7._objects.length == this._objects.length) goto L8;
        return false;
    L8:
        int r0 = 0;
    L9:
        XmlObject[] r1 = this._objects;
        if (r0 >= r1.length) goto L21;
        if (r1[r0] == null) goto L20;
        XmlObject[] r3 = r7._objects;
        if (r3[r0] == null) goto L20;
        if (r1[r0].valueEquals(r3[r0]) == false) goto L18;
        r0 = r0 + 1;
        goto L9
    L18:
        return false;
    L20:
        return false;
    L21:
        return true;
    }

    public int hashCode() {
        int r0 = 0;
        int r1 = 0;
    L3:
        XmlObject[] r2 = this._objects;
        if (r0 >= r2.length) goto L9;
        if (r2[r0] == null) goto L8;
        r1 = (r1 * 31) + r2[r0].valueHashCode();
    L8:
        r0 = r0 + 1;
        goto L3
    L9:
        return r1;
    }

    public boolean set(XmlObject r3, int r4) {
        XmlObject r5 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        XmlObject[] r2 = this._objects;
        if (r2[r4] == null) goto L6;
        return false;
    L6:
        r2[r4] = r5;
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= this._objects.length) goto L9;
        if (r1 == 0) goto L7;
        r0.append(" ");
    L7:
        r0.append(prettytrim(((SimpleValue) ZeusTransformUtils.preCheckCast(this._objects[r1], SimpleValue.class, "com.obric.memorydata.plugin")).getStringValue()));
        r1 = r1 + 1;
        goto L4
    L9:
        return r0.toString();
    }

    public int unfilled() {
        int r0 = 0;
    L3:
        XmlObject[] r1 = this._objects;
        if (r0 >= r1.length) goto L9;
        if (r1[r0] == null) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return r0;
    L9:
        return -1;
    }
}
