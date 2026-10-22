package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.impl.values.TypeStoreVisitor;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaTypeVisitorImpl implements TypeStoreVisitor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean _isValid;
    private SchemaParticle _matchedParticle;
    private VisitorState[] _rollback;
    private int _rollbackIndex;
    int _rollbackSize;
    private VisitorState[] _stack;
    int _stackSize;
    private VisitorState _top;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class VisitorState {
        int _childCount;
        int _curCount;
        int _curMax;
        int _curMin;
        SchemaParticle _curPart;
        int _processedChildCount;
        boolean[] _seen;

        private VisitorState() {
        }

        /* synthetic */ VisitorState(AnonymousClass1 r1) {
            this();
        }

        public void copy(VisitorState r3) {
            this._curPart = r3._curPart;
            this._curCount = r3._curCount;
            this._curMin = r3._curMin;
            this._curMax = r3._curMax;
            this._processedChildCount = r3._processedChildCount;
            this._childCount = r3._childCount;
            boolean[] r0 = r3._seen;
            if (r0 == null) goto L6;
            boolean[] r1 = new boolean[r0.length];
            this._seen = r1;
            boolean[] r2 = r3._seen;
            System.arraycopy(r2, 0, r1, 0, r2.length);
            return;
        }

        public void init(SchemaParticle r3) {
            SchemaParticle r4 = (SchemaParticle) ZeusTransformUtils.wrapperContextForParams(r3, SchemaParticle.class, "com.obric.memorydata.plugin");
            this._curPart = r4;
            this._curMin = r4.getIntMinOccurs();
            this._curMax = r4.getIntMaxOccurs();
            this._curCount = 0;
            this._processedChildCount = 0;
            this._childCount = r4.countOfParticleChild();
            if (r4.getParticleType() != 1) goto L5;
            boolean[] r5 = new boolean[this._childCount];
        L6:
            this._seen = r5;
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    public SchemaTypeVisitorImpl() {
    }

    public SchemaTypeVisitorImpl(SchemaParticle r3) {
        init((SchemaParticle) ZeusTransformUtils.wrapperContextForParams(r3, SchemaParticle.class, "com.obric.memorydata.plugin"));
    }

    void addParticle(SchemaParticle r4) {
        SchemaParticle r5 = (SchemaParticle) ZeusTransformUtils.wrapperContextForParams(r4, SchemaParticle.class, "com.obric.memorydata.plugin");
        VisitorState[] r0 = this._stack;
        if (r0.length != this._stackSize) goto L5;
        this._stack = expand(r0);
    L5:
        this._stack[this._stackSize].init(r5);
        this._stackSize++;
    }

    void commit() {
        this._top = null;
        this._rollbackIndex = this._stackSize;
        this._rollbackSize = 0;
    }

    public SchemaParticle currentParticle() {
        return this._matchedParticle;
    }

    public VisitorState[] expand(VisitorState[] r4) {
        if (r4 != null) goto L4;
        int r3 = 4;
    L5:
        VisitorState[] r0 = new VisitorState[r3];
        int r1 = 0;
        if (r4 == null) goto L8;
        System.arraycopy(r4, 0, r0, 0, r4.length);
    L8:
        if (r4 == null) goto L11;
        r1 = r4.length;
    L11:
        if (r1 >= r3) goto L13;
        r0[r1] = new VisitorState(null);
        r1 = r1 + 1;
        goto L11
    L13:
        return r0;
    L4:
        r3 = r4.length * 2;
        goto L5
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public String get_default_text() {
        if (currentParticle() != null) goto L5;
        return null;
    L5:
        if (currentParticle().getParticleType() == 4) goto L8;
        return null;
    L8:
        return ((SchemaLocalElement) ZeusTransformUtils.preCheckCast(currentParticle(), SchemaLocalElement.class, "com.obric.memorydata.plugin")).getDefaultText();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public int get_elementflags() {
        int r1 = 0;
        if (currentParticle() != null) goto L5;
    L16:
        return 0;
    L5:
        if (currentParticle().getParticleType() != 4) goto L16;
        SchemaLocalElement r4 = (SchemaLocalElement) ZeusTransformUtils.preCheckCast(currentParticle(), SchemaLocalElement.class, "com.obric.memorydata.plugin");
        boolean r0 = r4.isNillable();
        if (r4.isDefault() == false) goto L10;
        int r3 = 2;
    L11:
        int r2 = (r0 ? 1 : 0) | r3;
        if (r4.isFixed() == false) goto L15;
        r1 = 4;
    L15:
        return r2 | r1;
    L10:
        r3 = 0;
        goto L11
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public SchemaField get_schema_field() {
        if (ZeusTransformUtils.instanceOf(currentParticle(), SchemaField.class) == true) goto L5;
        return null;
    L5:
        return (SchemaField) ZeusTransformUtils.preCheckCast(currentParticle(), SchemaField.class, "com.obric.memorydata.plugin");
    }

    public void init(SchemaParticle r3) {
        SchemaParticle r4 = (SchemaParticle) ZeusTransformUtils.wrapperContextForParams(r3, SchemaParticle.class, "com.obric.memorydata.plugin");
        if (this._stack != null) goto L6;
        this._stack = expand(null);
    L6:
        if (this._rollback != null) goto L8;
        this._rollback = expand(null);
    L8:
        this._stackSize = 0;
        this._rollbackSize = 0;
        if (r4 == null) goto L12;
        push(r4);
        this._rollbackIndex = 1;
        return;
    }

    boolean notValid() {
        this._isValid = false;
        this._matchedParticle = null;
        rollback();
        return false;
    }

    boolean ok(SchemaParticle r3, boolean r4) {
        SchemaParticle r5 = (SchemaParticle) ZeusTransformUtils.wrapperContextForParams(r3, SchemaParticle.class, "com.obric.memorydata.plugin");
        if (r4 == true) goto L5;
        this._matchedParticle = r5;
        commit();
        return true;
    L5:
        rollback();
        return true;
    }

    boolean pop() {
        int r0 = this._stackSize - 1;
        this._stackSize = r0;
        if (r0 <= this._rollbackIndex) goto L5;
        this._top = topRef();
        return true;
    L5:
        return prepare();
    }

    boolean prepare() {
        if (this._rollbackIndex != 0) goto L6;
        this._top = null;
        return false;
    L6:
        VisitorState r0 = topRef();
        this._top = r0;
        saveCopy(r0);
        this._rollbackIndex = this._stackSize - 1;
        return true;
    }

    void push(SchemaParticle r3) {
        addParticle((SchemaParticle) ZeusTransformUtils.wrapperContextForParams(r3, SchemaParticle.class, "com.obric.memorydata.plugin"));
        this._top = topRef();
    }

    void rollback() {
    L2:
        int r0 = this._rollbackSize;
        if (r0 <= 0) goto L5;
        int r1 = r0 - 1;
        this._rollbackSize = r1;
        VisitorState[] r2 = this._stack;
        int r3 = this._rollbackIndex;
        VisitorState r4 = r2[r3];
        VisitorState[] r5 = this._rollback;
        r2[r3] = r5[r1];
        r5[r1] = r4;
        this._rollbackIndex = r3 + 1;
        goto L2
    L5:
        this._stackSize = this._rollbackIndex;
        this._top = null;
    }

    void saveCopy(VisitorState r4) {
        VisitorState[] r0 = this._rollback;
        if (r0.length != this._rollbackSize) goto L5;
        this._rollback = expand(r0);
    L5:
        this._rollback[this._rollbackSize].copy(r4);
        this._rollbackSize++;
    }

    public boolean testValid(QName r2) {
        return visit(r2, true);
    }

    VisitorState topRef() {
        return this._stack[this._stackSize - 1];
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public boolean visit(QName r2) {
        return visit(r2, false);
    }

    public boolean visit(QName r9, boolean r10) {
        if (prepare() == false) goto L5;
        int r0 = -2;
        int r1 = -2;
    L8:
        if (this._top._curCount > this._top._curMin) goto L10;
    L14:
        r0 = this._top._processedChildCount;
        r1 = this._stackSize;
    L16:
        if (this._top._curCount < this._top._curMax) goto L20;
        if (pop() == true) goto L16;
    L92:
        if (r9 != null) goto L95;
        SchemaParticle r11 = null;
    L36:
        return ok(r11, r10);
    L95:
        return notValid();
    L20:
        int r2 = this._top._curPart.getParticleType();
        int r3 = 0;
        if (r2 != 1) goto L23;
        int r4 = this._top._processedChildCount;
        int r5 = 0;
    L73:
        if (r5 >= this._top._childCount) goto L85;
        if (this._top._seen[r5] == true) goto L83;
        SchemaParticle r6 = this._top._curPart.getParticleChild(r5);
        if (r6.canStartWithElement(r9) == true) goto L79;
        if (r6.isSkippable() == false) goto L83;
        r4 = r4 + 1;
        goto L83
    L79:
        this._top._processedChildCount++;
        this._top._seen[r5] = true;
        push(r6);
    L83:
        r5 = r5 + 1;
        goto L73
    L85:
        if (r4 < this._top._childCount) goto L87;
        this._top._curCount++;
        this._top._processedChildCount = 0;
        Arrays.fill(this._top._seen, false);
        goto L8
    L87:
        if (this._top._curCount < this._top._curMin) goto L89;
    L91:
        if (pop() == true) goto L8;
    L89:
        return notValid();
    L23:
        if (r2 != 2) goto L25;
    L60:
        if (r3 >= this._top._childCount) goto L66;
        SchemaParticle r7 = this._top._curPart.getParticleChild(r3);
        if (r7.canStartWithElement(r9) == true) goto L63;
        r3 = r3 + 1;
        goto L60
    L63:
        this._top._curCount++;
        push(r7);
        goto L8
    L66:
        if (this._top._curCount >= this._top._curMin) goto L91;
        if (this._top._curPart.isSkippable() == true) goto L91;
        return notValid();
    L25:
        if (r2 != 3) goto L27;
        int r8 = this._top._processedChildCount;
    L45:
        if (r8 >= this._top._childCount) goto L58;
        SchemaParticle r12 = this._top._curPart.getParticleChild(r8);
        if (r12.canStartWithElement(r9) == true) goto L48;
        if (r12.isSkippable() == false) goto L52;
        r8 = r8 + 1;
        goto L45
    L52:
        if (this._top._processedChildCount != 0) goto L56;
        if (this._top._curCount >= this._top._curMin) goto L91;
    L56:
        return notValid();
    L48:
        this._top._processedChildCount = r8 + 1;
        push(r12);
        goto L8
    L58:
        this._top._curCount++;
        this._top._processedChildCount = 0;
        goto L8
    L27:
        if (r2 == 4) goto L38;
        if (this._top._curPart.canStartWithElement(r9) == true) goto L34;
        if (this._top._curCount >= this._top._curMin) goto L91;
        return notValid();
    L34:
        this._top._curCount++;
        r11 = this._top._curPart;
        goto L36
    L38:
        if (this._top._curPart.canStartWithElement(r9) == true) goto L34;
        if (this._top._curCount >= this._top._curMin) goto L91;
        return notValid();
    L10:
        if (r0 != this._top._processedChildCount) goto L14;
        if (r1 != this._stackSize) goto L14;
        VisitorState r13 = this._top;
        r13._curCount = r13._curMax;
        goto L14
    L5:
        return notValid();
    }
}
