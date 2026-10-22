package org.apache.xmlbeans.impl.regex;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Vector;

/* JADX INFO: loaded from: classes7.dex */
class Op {
    static int nofinstances;
    Op next;
    int type;

    static class CharOp extends Op {
        int charData;

        CharOp(int r1, int r2) {
            super(r1);
            this.charData = r2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        int getData() {
            return this.charData;
        }
    }

    static class ChildOp extends Op {
        Op child;

        ChildOp(int r1) {
            super(r1);
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        Op getChild() {
            return this.child;
        }

        void setChild(Op r1) {
            this.child = r1;
        }
    }

    static class ConditionOp extends Op {
        Op condition;
        Op no;
        int refNumber;
        Op yes;

        ConditionOp(int r1, int r2, Op r3, Op r4, Op r5) {
            super(r1);
            this.refNumber = r2;
            this.condition = r3;
            this.yes = r4;
            this.no = r5;
        }
    }

    static class ModifierOp extends ChildOp {
        int v1;
        int v2;

        ModifierOp(int r1, int r2, int r3) {
            super(r1);
            this.v1 = r2;
            this.v2 = r3;
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        int getData() {
            return this.v1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        int getData2() {
            return this.v2;
        }
    }

    static class RangeOp extends Op {
        Token tok;

        RangeOp(int r1, Token r2) {
            super(r1);
            this.tok = r2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        RangeToken getToken() {
            return (RangeToken) ZeusTransformUtils.preCheckCast(this.tok, RangeToken.class, "com.obric.memorydata.plugin");
        }
    }

    static class StringOp extends Op {
        String string;

        StringOp(int r1, String r2) {
            super(r1);
            this.string = r2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        String getString() {
            return this.string;
        }
    }

    static class UnionOp extends Op {
        Vector branches;

        UnionOp(int r1, int r2) {
            super(r1);
            this.branches = new Vector(r2);
        }

        void addElement(Op r1) {
            this.branches.addElement(r1);
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        Op elementAt(int r2) {
            return (Op) ZeusTransformUtils.preCheckCast(this.branches.elementAt(r2), Op.class, "com.obric.memorydata.plugin");
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        int size() {
            return this.branches.size();
        }
    }

    static {
    }

    public Op(int r2) {
        this.next = null;
        this.type = r2;
    }

    static CharOp createAnchor(int r2) {
        return new CharOp(5, r2);
    }

    static CharOp createBackReference(int r2) {
        return new CharOp(16, r2);
    }

    static CharOp createCapture(int r2, Op r3) {
        CharOp r0 = new CharOp(15, r2);
        r0.next = r3;
        return r0;
    }

    static CharOp createChar(int r2) {
        return new CharOp(1, r2);
    }

    static ChildOp createClosure(int r3) {
        return new ModifierOp(7, r3, -1);
    }

    static ConditionOp createCondition(Op r7, int r8, Op r9, Op r10, Op r11) {
        ConditionOp r6 = new ConditionOp(26, r8, r9, r10, r11);
        r6.next = r7;
        return r6;
    }

    static Op createDot() {
        return new Op(0);
    }

    static ChildOp createIndependent(Op r2, Op r3) {
        ChildOp r0 = new ChildOp(24);
        r0.setChild(r3);
        r0.next = r2;
        return r0;
    }

    static ChildOp createLook(int r1, Op r2, Op r3) {
        ChildOp r0 = new ChildOp(r1);
        r0.setChild(r3);
        r0.next = r2;
        return r0;
    }

    static ModifierOp createModifier(Op r2, Op r3, int r4, int r5) {
        ModifierOp r0 = new ModifierOp(25, r4, r5);
        r0.setChild(r3);
        r0.next = r2;
        return r0;
    }

    static ChildOp createNonGreedyClosure() {
        return new ChildOp(8);
    }

    static ChildOp createQuestion(boolean r1) {
        if (r1 == false) goto L5;
        int r2 = 10;
    L7:
        return new ChildOp(r2);
    L5:
        r2 = 9;
        goto L7
    }

    static RangeOp createRange(Token r2) {
        return new RangeOp(3, r2);
    }

    static StringOp createString(String r2) {
        return new StringOp(6, r2);
    }

    static UnionOp createUnion(int r2) {
        return new UnionOp(11, r2);
    }

    Op elementAt(int r3) {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    Op getChild() {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    int getData() {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    int getData2() {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    String getString() {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    RangeToken getToken() {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    int size() {
        return 0;
    }
}
