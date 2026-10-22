package org.apache.xmlbeans.soap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

/* JADX INFO: loaded from: classes7.dex */
public final class SOAPArrayType {
    private static final int[] EMPTY_INT_ARRAY = null;
    private int[] _dimensions;
    private int[] _ranks;
    private QName _type;

    static {
        EMPTY_INT_ARRAY = new int[0];
    }

    private SOAPArrayType() {
    }

    public SOAPArrayType(QName r3, String r4) {
        int r0 = r4.indexOf(91);
        this._type = r3;
        if (r0 >= 0) goto L14;
        this._ranks = EMPTY_INT_ARRAY;
        String[] r5 = XmlWhitespace.collapse(r4, 3).split(" ");
        int r6 = 0;
    L6:
        if (r6 >= r5.length) goto L21;
        if (r5[r6].equals("*") == false) goto L16;
        this._dimensions[r6] = -1;
    L11:
        r6 = r6 + 1;
        goto L6
    L16:
        this._dimensions[r6] = Integer.parseInt(r5[r6]);     // Catch: Exception -> L12
    L13:
        throw new XmlValueOutOfRangeException();
    L21:
        return;
    L14:
        initDimensions(r4, r0);
    }

    private static int collapseDimString(String r1) {
        String r2 = XmlWhitespace.collapse(r1, 3);
        if ("*".equals(r2) == false) goto L6;
    L10:
        return -1;
    L6:
        if (r2.isEmpty() == true) goto L10;
        return Integer.parseInt(r2);
    L13:
        throw new XmlValueOutOfRangeException("Malformed integer in SOAP array index");
    }

    private void initDimensions(String r7, int r8) {
        ArrayList r0 = new ArrayList();
        int r1 = -1;
    L3:
        if (r8 < 0) goto L10;
        r1 = r7.indexOf(93, r8);
        if (r1 < 0) goto L8;
        r0.add(r7.substring(r8 + 1, r1));
        r8 = r7.indexOf(91, r1);
        goto L3
    L8:
        throw new XmlValueOutOfRangeException();
    L10:
        if (XmlWhitespace.isAllSpace(r7.substring(r1 + 1)) == false) goto L29;
        this._ranks = new int[r0.size() - 1];
        int r9 = 0;
    L13:
        if (r9 >= this._ranks.length) goto L26;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get(r9), String.class, "com.obric.memorydata.plugin");
        int r3 = 0;
        int r4 = 0;
    L16:
        if (r3 >= r2.length()) goto L25;
        char r5 = r2.charAt(r3);
        if (r5 != ',') goto L21;
        r4 = r4 + 1;
    L22:
        r3 = r3 + 1;
        goto L16
    L21:
        if (XmlWhitespace.isSpace(r5) == true) goto L22;
        throw new XmlValueOutOfRangeException();
    L25:
        this._ranks[r9] = r4 + 1;
        r9 = r9 + 1;
        goto L13
    L26:
        this._dimensions = internalParseCommaIntString((String) ZeusTransformUtils.preCheckCast(r0.get(r0.size() - 1), String.class, "com.obric.memorydata.plugin"));
        return;
    L29:
        throw new XmlValueOutOfRangeException();
    }

    private static int[] internalParseCommaIntString(String r3) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L3:
        int r2 = r3.indexOf(44, r1);
        if (r2 < 0) goto L5;
        r0.add(r3.substring(r1, r2));
        r1 = r2 + 1;
        goto L3
    L5:
        r0.add(r3.substring(r1));
        return r0.stream().mapToInt($$Lambda$SOAPArrayType$GSsxBQnp4SfD5XqcQyArGPbFetQ.INSTANCE).toArray();
    }

    public static /* synthetic */ int lambda$GSsxBQnp4SfD5XqcQyArGPbFetQ(String r0) {
        return collapseDimString(r0);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SOAPArrayType.class) == true) goto L8;
        return false;
    L8:
        SOAPArrayType r6 = (SOAPArrayType) ZeusTransformUtils.preCheckCast(r5, SOAPArrayType.class, "com.obric.memorydata.plugin");
        if (this._type.equals(r6._type) == false) goto L16;
        if (Arrays.equals(this._ranks, r6._ranks) == false) goto L16;
        if (Arrays.equals(this._dimensions, r6._dimensions) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this._type.hashCode();
        int[] r1 = this._dimensions;
        int r2 = (r0 + r1.length) + this._ranks.length;
        int r3 = 0;
        if (r1.length == 0) goto L7;
        r3 = r1[0];
    L7:
        return r2 + r3;
    }
}
