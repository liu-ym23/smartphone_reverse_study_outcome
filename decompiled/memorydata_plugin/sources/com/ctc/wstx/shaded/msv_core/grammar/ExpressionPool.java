package com.ctc.wstx.shaded.msv_core.grammar;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.ctc.wstx.shaded.msv_core.util.StringPair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ExpressionPool implements Serializable {
    private static final long serialVersionUID = 1;
    private final ClosedHash expTable;

    public static final class ClosedHash implements Serializable {
        private static final int initialCapacity = 191;
        private static final float loadFactor = 0.3f;
        private static final ObjectStreamField[] serialPersistentFields = null;
        private static final long serialVersionUID = -2924295970572669668L;
        private int count;
        private ClosedHash parent;
        private Expression[] table;
        private int threshold;

        static {
            serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField(CommonConsts.COUNT_TYPE, Integer.TYPE), new ObjectStreamField("streamVersion", Byte.TYPE), new ObjectStreamField("parent", ExpressionPool.class)};
        }

        public ClosedHash() {
            this(null);
        }

        public ClosedHash(ClosedHash r2) {
            this.table = new Expression[initialCapacity];
            this.threshold = 57;
            this.parent = r2;
        }

        private Expression getBinExp(int r5, Expression r6, Expression r7, Class r8) {
            ClosedHash r0 = this.parent;
            if (r0 == null) goto L7;
            Expression r1 = r0.getBinExp(r5, r6, r7, r8);
            if (r1 == null) goto L7;
            return r1;
        L7:
            Expression[] r4 = this.table;
            int r2 = Integer.MAX_VALUE & r5;
        L8:
            int r3 = r2 % r4.length;
            Expression r9 = r4[r3];
            if (r9 == null) goto L10;
            if (r9.hashCode() != r5) goto L21;
            if (r9.getClass() != r8) goto L21;
            BinaryExp r10 = (BinaryExp) ZeusTransformUtils.preCheckCast(r9, BinaryExp.class, "com.obric.memorydata.plugin");
            if (r10.exp1 != r6) goto L21;
            if (r10.exp2 != r7) goto L21;
            return r10;
        L21:
            r2 = r3 + 1;
            goto L8
        L10:
            return null;
        }

        private void readObject(ObjectInputStream r9) {
            ObjectInputStream.GetField r1 = r9.readFields();
            int r3 = 0;
            if (r1.get("streamVersion", (byte) 0) != 0) goto L5;
            this.count = r1.get(CommonConsts.COUNT_TYPE, 0);
            this.parent = (ClosedHash) ZeusTransformUtils.preCheckCast(r1.get("parent", null), ClosedHash.class, "com.obric.memorydata.plugin");
            this.table = (Expression[]) ZeusTransformUtils.preCheckCast((Expression[]) ZeusTransformUtils.preCheckCast(r1.get("table", null), Expression[].class, "com.obric.memorydata.plugin"), Expression[].class, "com.obric.memorydata.plugin");
            this.threshold = r1.get("threshold", 0);
            return;
        L5:
            int r2 = r1.get(CommonConsts.COUNT_TYPE, 0);
            this.parent = (ClosedHash) ZeusTransformUtils.preCheckCast(r1.get("parent", null), ClosedHash.class, "com.obric.memorydata.plugin");
            int r0 = (((int) (r2 / loadFactor)) * 2) + 10;
            this.threshold = this.count * 2;
            this.count = 0;
            this.table = new Expression[r0];
        L7:
            if (r3 >= this.count) goto L11;
            put((Expression) ZeusTransformUtils.preCheckCast(r9.readObject(), Expression.class, "com.obric.memorydata.plugin"));
            r3 = r3 + 1;
            goto L7
        }

        private void rehash() {
            Expression[] r0 = this.table;
            int r1 = r0.length;
            int r2 = (r1 * 2) + 1;
            Expression[] r3 = new Expression[r2];
        L3:
            int r4 = r1 - 1;
            if (r1 <= 0) goto L13;
            if (r0[r4] == null) goto L12;
            int r5 = r0[r4].hashCode() & Integer.MAX_VALUE;
        L8:
            int r6 = r5 % r2;
            if (r3[r6] == null) goto L11;
            r5 = r6 + 1;
            goto L8
        L11:
            r3[r6] = r0[r4];
        L12:
            r1 = r4;
            goto L3
        L13:
            this.threshold = (int) (r2 * loadFactor);
            this.table = r3;
        }

        private void writeObject(ObjectOutputStream r4) {
            ObjectOutputStream.PutField r0 = r4.putFields();
            r0.put(CommonConsts.COUNT_TYPE, this.count);
            r0.put("parent", this.parent);
            r0.put("streamVersion", (byte) 1);
            r4.writeFields();
            int r1 = 0;
        L3:
            Expression[] r2 = this.table;
            if (r1 >= r2.length) goto L9;
            if (r2[r1] == null) goto L8;
            r4.writeObject(r2[r1]);
        L8:
            r1 = r1 + 1;
            goto L3
        }

        public Expression get(int r5, Expression r6, Class r7) {
            ClosedHash r0 = this.parent;
            if (r0 == null) goto L7;
            Expression r1 = r0.get(r5, r6, r7);
            if (r1 == null) goto L7;
            return r1;
        L7:
            Expression[] r4 = this.table;
            int r2 = Integer.MAX_VALUE & r5;
        L8:
            int r3 = r2 % r4.length;
            Expression r8 = r4[r3];
            if (r8 == null) goto L10;
            if (r8.hashCode() != r5) goto L19;
            if (r8.getClass() != r7) goto L19;
            UnaryExp r9 = (UnaryExp) ZeusTransformUtils.preCheckCast(r8, UnaryExp.class, "com.obric.memorydata.plugin");
            if (r9.exp != r6) goto L19;
            return r9;
        L19:
            r2 = r3 + 1;
            goto L8
        L10:
            return null;
        }

        public Expression get(Expression r4) {
            ClosedHash r0 = this.parent;
            if (r0 == null) goto L7;
            Expression r1 = r0.get(r4);
            if (r1 == null) goto L7;
            return r1;
        L7:
            Expression[] r3 = this.table;
            int r2 = r4.hashCode() & Integer.MAX_VALUE;
        L8:
            int r5 = r2 % r3.length;
            Expression r6 = r3[r5];
            if (r6 == null) goto L10;
            if (r6.equals(r4) == true) goto L14;
            r2 = r5 + 1;
            goto L8
        L14:
            return r6;
        L10:
            return null;
        }

        public Expression getBinExp(Expression r3, Expression r4, Class r5) {
            return getBinExp((r3.hashCode() + r4.hashCode()) ^ r5.hashCode(), r3, r4, r5);
        }

        public void put(Expression r4) {
            if (this.count < this.threshold) goto L5;
            rehash();
        L5:
            Expression[] r0 = this.table;
            int r1 = r4.hashCode() & Integer.MAX_VALUE;
        L6:
            int r2 = r1 % r0.length;
            if (r0[r2] == null) goto L9;
            r1 = r2 + 1;
            goto L6
        L9:
            r0[r2] = r4;
            this.count++;
        }
    }

    public ExpressionPool() {
        this.expTable = new ClosedHash();
    }

    public ExpressionPool(ExpressionPool r2) {
        this.expTable = new ClosedHash(r2.expTable);
    }

    public final Expression createAnyString() {
        return Expression.anyString;
    }

    public final Expression createAttribute(NameClass r3) {
        return unify(new AttributeExp(r3, Expression.anyString));
    }

    public final Expression createAttribute(NameClass r2, Expression r3) {
        if (r3 != Expression.nullSet) goto L6;
        return r3;
    L6:
        return unify(new AttributeExp(r2, r3));
    }

    public final Expression createChoice(Expression r4, Expression r5) {
        if (r4 != Expression.nullSet) goto L6;
        return r5;
    L6:
        if (r5 != Expression.nullSet) goto L9;
        return r4;
    L9:
        if (r4 != Expression.epsilon) goto L14;
        if (r5.isEpsilonReducible() == false) goto L14;
        return r5;
    L14:
        if (r5 != Expression.epsilon) goto L19;
        if (r4.isEpsilonReducible() == false) goto L19;
        return r4;
    L19:
        if (ZeusTransformUtils.instanceOf(r5, ChoiceExp.class) == false) goto L22;
        ChoiceExp r6 = (ChoiceExp) ZeusTransformUtils.preCheckCast(r5, ChoiceExp.class, "com.obric.memorydata.plugin");
        return createChoice(createChoice(r4, r6.exp1), r6.exp2);
    L22:
        Expression r0 = r4;
    L23:
        if (r0 == r5) goto L24;
        if (ZeusTransformUtils.instanceOf(r0, ChoiceExp.class) == false) goto L27;
        ChoiceExp r1 = (ChoiceExp) ZeusTransformUtils.preCheckCast(r0, ChoiceExp.class, "com.obric.memorydata.plugin");
        if (r1.exp2 == r5) goto L34;
        r0 = r1.exp1;
        goto L23
    L34:
        return r4;
    L27:
        Expression r2 = this.expTable.getBinExp(r4, r5, ChoiceExp.class);
        if (r2 == null) goto L30;
        return r2;
    L30:
        return unify(new ChoiceExp(r4, r5));
    L24:
        return r4;
    }

    public final Expression createConcur(Expression r3, Expression r4) {
        if (r3 == Expression.nullSet) goto L30;
        if (r4 == Expression.nullSet) goto L30;
        if (r3 != Expression.epsilon) goto L16;
        if (r4.isEpsilonReducible() == false) goto L14;
        return Expression.epsilon;
    L14:
        return Expression.nullSet;
    L16:
        if (r4 != Expression.epsilon) goto L24;
        if (r3.isEpsilonReducible() == false) goto L22;
        return Expression.epsilon;
    L22:
        return Expression.nullSet;
    L24:
        if (ZeusTransformUtils.instanceOf(r4, ConcurExp.class) == false) goto L28;
        ConcurExp r5 = (ConcurExp) ZeusTransformUtils.preCheckCast(r4, ConcurExp.class, "com.obric.memorydata.plugin");
        return createConcur(createConcur(r3, r5.exp1), r5.exp2);
    L28:
        return unify(new ConcurExp(r3, r4));
    L30:
        return Expression.nullSet;
    }

    public final Expression createData(com.ctc.wstx.shaded.msv.relaxng_datatype.a r3, StringPair r4) {
        return createData((com.ctc.wstx.shaded.msv.relaxng_datatype.a) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.a.class, "com.obric.memorydata.plugin"), r4, Expression.nullSet);
    }

    public final Expression createData(com.ctc.wstx.shaded.msv.relaxng_datatype.a r3, StringPair r4, Expression r5) {
        return unify(new DataExp((com.ctc.wstx.shaded.msv.relaxng_datatype.a) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.a.class, "com.obric.memorydata.plugin"), r4, r5));
    }

    public final Expression createData(XSDatatype r4) {
        XSDatatype r5 = (XSDatatype) ZeusTransformUtils.wrapperContextForParams(r4, XSDatatype.class, "com.obric.memorydata.plugin");
        String r0 = r5.getNamespaceUri();
        if (r0 != null) goto L6;
        r0 = "\u0000";
    L6:
        return createData(r5, new StringPair(r0, r5.displayName()));
    }

    public final Expression createEpsilon() {
        return Expression.epsilon;
    }

    public final Expression createInterleave(Expression r3, Expression r4) {
        if (r3 != Expression.epsilon) goto L6;
        return r4;
    L6:
        if (r4 != Expression.epsilon) goto L9;
        return r3;
    L9:
        if (r3 == Expression.nullSet) goto L20;
        if (r4 == Expression.nullSet) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, InterleaveExp.class) == false) goto L18;
        InterleaveExp r5 = (InterleaveExp) ZeusTransformUtils.preCheckCast(r4, InterleaveExp.class, "com.obric.memorydata.plugin");
        return createInterleave(createInterleave(r3, r5.exp1), r5.exp2);
    L18:
        return unify(new InterleaveExp(r3, r4));
    L20:
        return Expression.nullSet;
    }

    public final Expression createList(Expression r2) {
        if (r2 != Expression.nullSet) goto L6;
        return r2;
    L6:
        return unify(new ListExp(r2));
    }

    public final Expression createMixed(Expression r2) {
        if (r2 != Expression.nullSet) goto L7;
        return Expression.nullSet;
    L7:
        if (r2 != Expression.epsilon) goto L11;
        return Expression.anyString;
    L11:
        return unify(new MixedExp(r2));
    }

    public final Expression createNullSet() {
        return Expression.nullSet;
    }

    public final Expression createOneOrMore(Expression r2) {
        if (r2 != Expression.epsilon) goto L5;
    L13:
        return r2;
    L5:
        if (r2 == Expression.anyString) goto L13;
        if (r2 == Expression.nullSet) goto L13;
        if (ZeusTransformUtils.instanceOf(r2, OneOrMoreExp.class) == true) goto L13;
        return unify(new OneOrMoreExp(r2));
    }

    public final Expression createOptional(Expression r2) {
        return createChoice(r2, Expression.epsilon);
    }

    public final Expression createSequence(Expression r3, Expression r4) {
        if (r3 == Expression.nullSet) goto L23;
        if (r4 == Expression.nullSet) goto L23;
        if (r3 != Expression.epsilon) goto L11;
        return r4;
    L11:
        if (r4 != Expression.epsilon) goto L14;
        return r3;
    L14:
        if (ZeusTransformUtils.instanceOf(r4, SequenceExp.class) == false) goto L17;
        SequenceExp r5 = (SequenceExp) ZeusTransformUtils.preCheckCast(r4, SequenceExp.class, "com.obric.memorydata.plugin");
        return createSequence(createSequence(r3, r5.exp1), r5.exp2);
    L17:
        Expression r0 = this.expTable.getBinExp(r3, r4, SequenceExp.class);
        if (r0 == null) goto L20;
        return r0;
    L20:
        return unify(new SequenceExp(r3, r4));
    L23:
        return Expression.nullSet;
    }

    public final Expression createValue(com.ctc.wstx.shaded.msv.relaxng_datatype.a r3, StringPair r4, Object r5) {
        return unify(new ValueExp((com.ctc.wstx.shaded.msv.relaxng_datatype.a) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.a.class, "com.obric.memorydata.plugin"), r4, r5));
    }

    public final Expression createValue(XSDatatype r4, Object r5) {
        XSDatatype r6 = (XSDatatype) ZeusTransformUtils.wrapperContextForParams(r4, XSDatatype.class, "com.obric.memorydata.plugin");
        return createValue(r6, new StringPair("", r6.displayName()), r5);
    }

    public final Expression createZeroOrMore(Expression r1) {
        return createOptional(createOneOrMore(r1));
    }

    public final Expression unify(Expression r3) {
        Expression r0 = this.expTable.get(r3);
        if (r0 != null) goto L17;
        ClosedHash r1 = this.expTable;
        monitor-enter(r1);
        r0 = this.expTable.get(r3);     // Catch: Throwable -> L13
        if (r0 != null) goto L11;
        this.expTable.put(r3);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return r3;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        return (Expression) ZeusTransformUtils.preCheckCast(r0, Expression.class, "com.obric.memorydata.plugin");
    }
}
