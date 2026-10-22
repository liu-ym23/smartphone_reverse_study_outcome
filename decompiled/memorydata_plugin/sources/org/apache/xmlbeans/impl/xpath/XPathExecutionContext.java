package org.apache.xmlbeans.impl.xpath;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes7.dex */
public class XPathExecutionContext {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private PathContext[] _paths;
    private final ArrayList<QName> _stack;
    private XPath _xpath;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.xpath.XPathExecutionContext$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class PathContext {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private XPathStep _curr;
        private final List<XPathStep> _prev;
        final /* synthetic */ XPathExecutionContext this$0;

        static {
        }

        private PathContext(XPathExecutionContext r1) {
            this.this$0 = r1;
            this._prev = new ArrayList();
        }

        /* synthetic */ PathContext(XPathExecutionContext r1, AnonymousClass1 r2) {
            this(r1);
        }

        private void backtrack() {
            if (this._curr._hasBacktrack == false) goto L6;
            this._curr = this._curr._backtrack;
            return;
        L6:
            this._curr = this._curr._prev;
            if (this._curr._deep == true) goto L15;
            int r0 = 0;
            XPathStep r1 = this._curr;
        L10:
            if (r1._deep == true) goto L19;
            int r2 = r0 + 1;
            if (r1.match(top(r0)) == false) goto L6;
            r1 = r1._prev;
            r0 = r2;
            goto L10
        L19:
            return;
        }

        private QName top(int r2) {
            return (QName) ZeusTransformUtils.preCheckCast(XPathExecutionContext.access$000(this.this$0).get((XPathExecutionContext.access$000(this.this$0).size() - 1) - r2), QName.class, "com.obric.memorydata.plugin");
        }

        boolean attr(QName r2) {
            XPathStep r0 = this._curr;
            if (r0 != null) goto L5;
        L9:
            return false;
        L5:
            if (r0._attr == false) goto L9;
            if (this._curr.match(r2) == false) goto L9;
            return true;
        }

        int element(QName r3) {
            this._prev.add(this._curr);
            XPathStep r0 = this._curr;
            if (r0 != null) goto L6;
            return 0;
        L6:
            if (r0._attr == true) goto L18;
            if (this._curr.match(r3) == false) goto L18;
            XPathStep r4 = this._curr._next;
            this._curr = r4;
            if (r4._name != null) goto L12;
            backtrack();
            XPathStep r2 = this._curr;
            if (r2 != null) goto L17;
            return 1;
        L17:
            return 1 | r2._flags;
        L12:
            return this._curr._flags;
        L18:
            backtrack();
            XPathStep r1 = this._curr;
            if (r1 == null) goto L20;
            if (r1.match(r3) == true) goto L23;
            if (this._curr._deep == false) goto L18;
        L23:
            this._curr = this._curr._next;
            goto L12
        L20:
            return 0;
        }

        void end() {
            List<XPathStep> r0 = this._prev;
            this._curr = (XPathStep) ZeusTransformUtils.preCheckCast(r0.remove(r0.size() - 1), XPathStep.class, "com.obric.memorydata.plugin");
        }

        void init(XPathStep r1) {
            this._curr = r1;
            this._prev.clear();
        }

        int start() {
            if (this._curr._name != null) goto L5;
            this._curr = null;
            return 1;
        L5:
            return this._curr._flags;
        }
    }

    static {
    }

    public XPathExecutionContext() {
        this._stack = new ArrayList();
    }

    static /* synthetic */ ArrayList access$000(XPathExecutionContext r0) {
        return r0._stack;
    }

    public final boolean attr(QName r5) {
        PathContext[] r4 = this._paths;
        int r0 = r4.length;
        int r1 = 0;
        boolean r2 = false;
    L3:
        if (r1 >= r0) goto L5;
        r2 = r2 | r4[r1].attr(r5);
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }

    public final int element(QName r5) {
        this._stack.add(r5);
        PathContext[] r4 = this._paths;
        int r0 = r4.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r2 = r2 | r4[r1].element(r5);
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }

    public final void end() {
        ArrayList<QName> r0 = this._stack;
        r0.remove(r0.size() - 1);
        PathContext[] r3 = this._paths;
        int r1 = r3.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r3[r2].end();
        r2 = r2 + 1;
        goto L3
    }

    public final void init(XPath r4) {
        if (this._xpath == r4) goto L5;
        this._xpath = r4;
        PathContext[] r0 = new PathContext[r4._selector._paths.length];
        this._paths = r0;
        Arrays.setAll(r0, new $$Lambda$XPathExecutionContext$kOw6c7jmfp1q45xE29ICk1OikJ0(this));
    L5:
        this._stack.clear();
        int r1 = 0;
    L6:
        PathContext[] r2 = this._paths;
        if (r1 >= r2.length) goto L9;
        r2[r1].init(r4._selector._paths[r1]);
        r1 = r1 + 1;
        goto L6
    }

    public /* synthetic */ PathContext lambda$init$0$XPathExecutionContext(int r2) {
        return new PathContext(this, null);
    }

    public final int start() {
        PathContext[] r4 = this._paths;
        int r0 = r4.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r2 = r2 | r4[r1].start();
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }
}
