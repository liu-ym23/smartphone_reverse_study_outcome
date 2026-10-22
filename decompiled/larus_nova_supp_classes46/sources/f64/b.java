package f64;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final void a(Map r3, PolarisFileOutputStreamWrapper r4) throws XmlPullParserException, IOException {
        a r0 = new a();
        r0.setOutput(r4, "utf-8");
        r0.startDocument(null, Boolean.TRUE);
        r0.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        b(r3, null, r0);
        r0.flush();
    }

    public static final void b(Map r3, String r4, a r5) throws XmlPullParserException, IOException {
        if (r3 != null) goto L6;
        r5.startTag(null, "null");
        r5.endTag(null, "null");
        return;
    L6:
        Iterator r6 = r3.entrySet().iterator();
        r5.startTag(null, "map");
        if (r4 == null) goto L10;
        r5.attribute(null, "name", r4);
    L10:
        if (r6.hasNext() == false) goto L12;
        Map.Entry r7 = (Map.Entry) r6.next();
        c(r7.getValue(), (String) r7.getKey(), r5);
        goto L10
    L12:
        r5.endTag(null, "map");
    }

    public static final void c(Object r7, String r8, a r9) throws XmlPullParserException, IOException {
        if (r7 != null) goto L10;
        r9.startTag(null, "null");
        if (r8 == null) goto L7;
        r9.attribute(null, "name", r8);
    L7:
        r9.endTag(null, "null");
        return;
    L10:
        if ((r7 instanceof String) == false) goto L17;
        r9.startTag(null, "string");
        if (r8 == null) goto L14;
        r9.attribute(null, "name", r8);
    L14:
        r9.text(r7.toString());
        r9.endTag(null, "string");
        return;
    L17:
        if ((r7 instanceof Integer) == false) goto L20;
        String r2 = "int";
    L31:
        r9.startTag(null, r2);
        if (r8 == null) goto L34;
        r9.attribute(null, "name", r8);
    L34:
        r9.attribute(null, "value", r7.toString());
        r9.endTag(null, r2);
        return;
    L20:
        if ((r7 instanceof Long) == false) goto L23;
        r2 = "long";
        goto L31
    L23:
        if ((r7 instanceof Float) == false) goto L26;
        r2 = "float";
        goto L31
    L26:
        if ((r7 instanceof Double) == false) goto L29;
        r2 = "double";
        goto L31
    L29:
        if ((r7 instanceof Boolean) == false) goto L36;
        r2 = "boolean";
        goto L31
    L36:
        int r6 = 0;
        if ((r7 instanceof byte[]) == false) goto L55;
        byte[] r10 = (byte[]) r7;
        r9.startTag(null, "byte-array");
        if (r8 == null) goto L41;
        r9.attribute(null, "name", r8);
    L41:
        int r11 = r10.length;
        r9.attribute(null, "num", Integer.toString(r11));
        StringBuilder r0 = new StringBuilder(r10.length * 2);
    L42:
        if (r6 >= r11) goto L52;
        byte r3 = r10[r6];
        int r4 = r3 >> 4;
        if (r4 < 10) goto L46;
        int r5 = (r4 + 97) - 10;
    L47:
        r0.append(r5);
        int r12 = r3 & 255;
        if (r12 < 10) goto L50;
        int r13 = (r12 + 97) - 10;
    L51:
        r0.append(r13);
        r6 = r6 + 1;
        goto L42
    L50:
        r13 = r12 + 48;
        goto L51
    L46:
        r5 = r4 + 48;
        goto L47
    L52:
        r9.text(r0.toString());
        r9.endTag(null, "byte-array");
        return;
    L55:
        if ((r7 instanceof int[]) == false) goto L65;
        int[] r14 = (int[]) r7;
        r9.startTag(null, "int-array");
        if (r8 == null) goto L59;
        r9.attribute(null, "name", r8);
    L59:
        int r15 = r14.length;
        r9.attribute(null, "num", Integer.toString(r15));
    L60:
        if (r6 >= r15) goto L62;
        r9.startTag(null, "item");
        r9.attribute(null, "value", Integer.toString(r14[r6]));
        r9.endTag(null, "item");
        r6 = r6 + 1;
        goto L60
    L62:
        r9.endTag(null, "int-array");
        return;
    L65:
        if ((r7 instanceof Map) == false) goto L69;
        b((Map) r7, r8, r9);
        return;
    L69:
        if ((r7 instanceof List) == false) goto L79;
        List r16 = (List) r7;
        r9.startTag(null, "list");
        if (r8 == null) goto L73;
        r9.attribute(null, "name", r8);
    L73:
        int r17 = r16.size();
    L74:
        if (r6 >= r17) goto L76;
        c(ListProtector.get(r16, r6), null, r9);
        r6 = r6 + 1;
        goto L74
    L76:
        r9.endTag(null, "list");
        return;
    L79:
        if ((r7 instanceof Set) == false) goto L90;
        Set r18 = (Set) r7;
        r9.startTag(null, "set");
        if (r8 == null) goto L83;
        r9.attribute(null, "name", r8);
    L83:
        Iterator r19 = r18.iterator();
    L85:
        if (r19.hasNext() == false) goto L87;
        c(r19.next(), null, r9);
        goto L85
    L87:
        r9.endTag(null, "set");
        return;
    L90:
        if ((r7 instanceof CharSequence) == false) goto L97;
        r9.startTag(null, "string");
        if (r8 == null) goto L94;
        r9.attribute(null, "name", r8);
    L94:
        r9.text(r7.toString());
        r9.endTag(null, "string");
        return;
    L97:
        throw new RuntimeException("writeValueXml: unable to write " + r8 + ", class " + r7.getClass() + ", value " + r7);
    }
}
