package io.noties.markwon.inlineparser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes6.dex */
public abstract class h {
    public static void a(Node r2) {
        if (r2.getFirstChild() != r2.getLastChild()) goto L5;
        return;
    L5:
        b(r2.getFirstChild(), r2.getLastChild());
    }

    public static void a(Node r1, Node r2) {
        if (r1 != r2) goto L4;
        return;
    L4:
        if (r1.getNext() == r2) goto L9;
        b(r1.getNext(), r2.getPrevious());
        return;
    }

    public static void a(Text r3, Text r4, int r5) {
        if (r3 == null) goto L11;
        if (r4 == null) goto L12;
        if (r3 == r4) goto L13;
        StringBuilder r0 = new StringBuilder(r5);
        r0.append(r3.getLiteral());
        Node r6 = r3.getNext();
        Node r7 = r4.getNext();
    L6:
        if (r6 == r7) goto L8;
        r0.append(((Text) ZeusTransformUtils.preCheckCast(r6, Text.class, "com.obric.memorydata.plugin")).getLiteral());
        Node r1 = r6.getNext();
        r6.unlink();
        r6 = r1;
        goto L6
    L8:
        r3.setLiteral(r0.toString());
        return;
    L13:
        return;
    L12:
        return;
    }

    public static void b(Node r6, Node r7) {
        int r4 = 0;
        Text r2 = null;
        Text r3 = null;
    L3:
        if (r6 == null) goto L14;
        if (ZeusTransformUtils.instanceOf(r6, Text.class) == false) goto L10;
        r3 = (Text) ZeusTransformUtils.preCheckCast(r6, Text.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L9;
        r2 = r3;
    L9:
        r4 = r4 + r3.getLiteral().length();
    L11:
        if (r6 == r7) goto L14;
        r6 = r6.getNext();
        goto L3
    L10:
        a(r2, r3, r4);
        r4 = 0;
        r2 = null;
        r3 = null;
    L14:
        a(r2, r3, r4);
    }
}
