package io.noties.markwon.g;

import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
public abstract class e {
    public static void a(Node r1, Node r2) {
        Node r3 = r2.getNext();
    L3:
        if (r3 == null) goto L5;
        Node r0 = r3.getNext();
        r1.appendChild(r3);
        r3 = r0;
        goto L3
    }
}
