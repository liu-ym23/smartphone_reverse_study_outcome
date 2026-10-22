package androidx.constraintlayout.core;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ArrayRow implements LinearSystem.Row {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    float constantValue;
    boolean isSimpleDefinition;
    boolean used;
    SolverVariable variable;
    public ArrayRowVariables variables;
    ArrayList<SolverVariable> variablesToUpdate;

    public interface ArrayRowVariables {
        void add(SolverVariable r10, float r11, boolean r12);

        void clear();

        boolean contains(SolverVariable r10);

        void display();

        void divideByAmount(float r10);

        float get(SolverVariable r10);

        int getCurrentSize();

        SolverVariable getVariable(int r10);

        float getVariableValue(int r10);

        int indexOf(SolverVariable r10);

        void invert();

        void put(SolverVariable r10, float r11);

        float remove(SolverVariable r10, boolean r11);

        int sizeInBytes();

        float use(ArrayRow r10, boolean r11);
    }

    public ArrayRow() {
        this.variable = null;
        this.constantValue = 0.0f;
        this.used = false;
        this.variablesToUpdate = new ArrayList();
        this.isSimpleDefinition = false;
    }

    public ArrayRow(Cache r10) {
        this.variable = null;
        this.constantValue = 0.0f;
        this.used = false;
        this.variablesToUpdate = new ArrayList();
        this.isSimpleDefinition = false;
        this.variables = new ArrayLinkedVariables(this, r10);
    }

    private boolean isNew(SolverVariable r10, LinearSystem r11) {
        if (r10.usageInRowCount <= 1) goto L7;
        return false;
    L7:
        return true;
    }

    private SolverVariable pickPivotInVariables(boolean[] r10, SolverVariable r11) {
        int r12 = this.variables.getCurrentSize();
        SolverVariable r13 = null;
        int r14 = 0;
        float r15 = 0.0f;
    L3:
        if (r14 >= r12) goto L19;
        float r16 = this.variables.getVariableValue(r14);
        if (r16 >= 0.0f) goto L18;
        SolverVariable r17 = this.variables.getVariable(r14);
        if (r10 != null) goto L9;
    L10:
        if (r17 == r11) goto L18;
        SolverVariable.Type r18 = r17.mType;
        if (r18 == SolverVariable.Type.SLACK) goto L16;
        if (r18 != SolverVariable.Type.ERROR) goto L18;
    L16:
        if (r16 >= r15) goto L18;
        r15 = r16;
        r13 = r17;
        goto L18
    L9:
        if (r10[r17.id] == false) goto L10;
    L18:
        r14 = r14 + 1;
        goto L3
    L19:
        return r13;
    }

    public ArrayRow addError(LinearSystem r10, int r11) {
        this.variables.put(r10.createErrorVariable(r11, "ep"), 1.0f);
        this.variables.put(r10.createErrorVariable(r11, "em"), -1.0f);
        return this;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable r10) {
        int r11 = r10.strength;
        float r12 = 1.0f;
        if (r11 != 1) goto L6;
    L17:
        this.variables.put(r10, r12);
        return;
    L6:
        if (r11 != 2) goto L9;
        r12 = 1000.0f;
        goto L17
    L9:
        if (r11 != 3) goto L12;
        r12 = 1000000.0f;
        goto L17
    L12:
        if (r11 != 4) goto L15;
        r12 = 1.0E9f;
        goto L17
    L15:
        if (r11 != 5) goto L17;
        r12 = 1.0E12f;
        goto L17
    }

    ArrayRow addSingleError(SolverVariable r10, int r11) {
        this.variables.put(r10, r11);
        return this;
    }

    boolean chooseSubject(LinearSystem r10) {
        SolverVariable r11 = chooseSubjectInVariables(r10);
        if (r11 != null) goto L5;
        boolean r12 = true;
    L7:
        if (this.variables.getCurrentSize() != 0) goto L9;
        this.isSimpleDefinition = true;
    L9:
        return r12;
    L5:
        pivot(r11);
        r12 = false;
        goto L7
    }

    SolverVariable chooseSubjectInVariables(LinearSystem r15) {
        int r10 = this.variables.getCurrentSize();
        SolverVariable r11 = null;
        int r12 = 0;
        boolean r13 = false;
        boolean r14 = false;
        float r16 = 0.0f;
        float r17 = 0.0f;
        SolverVariable r18 = null;
    L3:
        if (r12 >= r10) goto L28;
        float r19 = this.variables.getVariableValue(r12);
        SolverVariable r110 = this.variables.getVariable(r12);
        if (r110.mType != SolverVariable.Type.UNRESTRICTED) goto L15;
        if (r11 != null) goto L9;
    L7:
        r13 = isNew(r110, r15);
        r16 = r19;
        r11 = r110;
    L27:
        r12 = r12 + 1;
        goto L3
    L9:
        if (r16 > r19) goto L7;
        if (r13 == true) goto L27;
        if (isNew(r110, r15) == false) goto L27;
        r16 = r19;
        r11 = r110;
        r13 = true;
        goto L27
    L15:
        if (r11 != null) goto L27;
        if (r19 >= 0.0f) goto L27;
        if (r18 != null) goto L21;
    L19:
        r14 = isNew(r110, r15);
        r17 = r19;
        r18 = r110;
        goto L27
    L21:
        if (r17 > r19) goto L19;
        if (r14 == true) goto L27;
        if (isNew(r110, r15) == false) goto L27;
        r17 = r19;
        r18 = r110;
        r14 = true;
        goto L27
    L28:
        if (r11 == null) goto L30;
        return r11;
    L30:
        return r18;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0.0f;
    }

    ArrayRow createRowCentering(SolverVariable r10, SolverVariable r11, int r12, float r13, SolverVariable r14, SolverVariable r15, int r16) {
        if (r11 != r14) goto L7;
        this.variables.put(r10, 1.0f);
        this.variables.put(r15, 1.0f);
        this.variables.put(r11, -2.0f);
        return this;
    L7:
        if (r13 != 0.5f) goto L14;
        this.variables.put(r10, 1.0f);
        this.variables.put(r11, -1.0f);
        this.variables.put(r14, -1.0f);
        this.variables.put(r15, 1.0f);
        if (r12 > 0) goto L11;
        if (r16 > 0) goto L11;
    L24:
        return this;
    L11:
        int r17 = (-r12) + r16;
    L12:
        float r18 = r17;
    L16:
        this.constantValue = r18;
        goto L24
    L14:
        if (r13 > 0.0f) goto L18;
        this.variables.put(r10, -1.0f);
        this.variables.put(r11, 1.0f);
        r18 = r12;
        goto L16
    L18:
        if (r13 < 1.0f) goto L20;
        this.variables.put(r15, -1.0f);
        this.variables.put(r14, 1.0f);
        r17 = -r16;
        goto L12
    L20:
        float r19 = 1.0f - r13;
        this.variables.put(r10, r19 * 1.0f);
        this.variables.put(r11, r19 * (-1.0f));
        this.variables.put(r14, (-1.0f) * r13);
        this.variables.put(r15, 1.0f * r13);
        if (r12 > 0) goto L23;
        if (r16 <= 0) goto L24;
    L23:
        r18 = ((-r12) * r19) + (r16 * r13);
        goto L16
    }

    ArrayRow createRowDefinition(SolverVariable r10, int r11) {
        this.variable = r10;
        float r12 = r11;
        r10.computedValue = r12;
        this.constantValue = r12;
        this.isSimpleDefinition = true;
        return this;
    }

    ArrayRow createRowDimensionPercent(SolverVariable r10, SolverVariable r11, float r12) {
        this.variables.put(r10, -1.0f);
        this.variables.put(r11, r12);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable r10, SolverVariable r11, SolverVariable r12, SolverVariable r13, float r14) {
        this.variables.put(r10, -1.0f);
        this.variables.put(r11, 1.0f);
        this.variables.put(r12, r14);
        this.variables.put(r13, -r14);
        return this;
    }

    public ArrayRow createRowEqualDimension(float r10, float r11, float r12, SolverVariable r13, int r14, SolverVariable r15, int r16, SolverVariable r17, int r18, SolverVariable r19, int r110) {
        if (r11 != 0.0f) goto L5;
    L8:
        this.constantValue = (((-r14) - r16) + r18) + r110;
        this.variables.put(r13, 1.0f);
        this.variables.put(r15, -1.0f);
        this.variables.put(r19, 1.0f);
        this.variables.put(r17, -1.0f);
    L9:
        return this;
    L5:
        if (r10 == r12) goto L8;
        float r20 = (r10 / r11) / (r12 / r11);
        this.constantValue = (((-r14) - r16) + (r18 * r20)) + (r110 * r20);
        this.variables.put(r13, 1.0f);
        this.variables.put(r15, -1.0f);
        this.variables.put(r19, r20);
        this.variables.put(r17, -r20);
        goto L9
    }

    public ArrayRow createRowEqualMatchDimensions(float r10, float r11, float r12, SolverVariable r13, SolverVariable r14, SolverVariable r15, SolverVariable r16) {
        this.constantValue = 0.0f;
        if (r11 != 0.0f) goto L5;
    L14:
        this.variables.put(r13, 1.0f);
        this.variables.put(r14, -1.0f);
        this.variables.put(r16, 1.0f);
        this.variables.put(r15, -1.0f);
    L15:
        return this;
    L5:
        if (r10 == r12) goto L14;
        if (r10 != 0.0f) goto L11;
        this.variables.put(r13, 1.0f);
        this.variables.put(r14, -1.0f);
        goto L15
    L11:
        if (r12 != 0.0f) goto L13;
        this.variables.put(r15, 1.0f);
        this.variables.put(r16, -1.0f);
        goto L15
    L13:
        float r17 = (r10 / r11) / (r12 / r11);
        this.variables.put(r13, 1.0f);
        this.variables.put(r14, -1.0f);
        this.variables.put(r16, r17);
        this.variables.put(r15, -r17);
        goto L15
    }

    public ArrayRow createRowEquals(SolverVariable r10, int r11) {
        if (r11 >= 0) goto L4;
        this.constantValue = r11 * (-1);
        ArrayRowVariables r12 = this.variables;
        float r13 = 1.0f;
    L5:
        r12.put(r10, r13);
        return this;
    L4:
        this.constantValue = r11;
        r12 = this.variables;
        r13 = -1.0f;
        goto L5
    }

    public ArrayRow createRowEquals(SolverVariable r10, SolverVariable r11, int r12) {
        boolean r13 = false;
        if (r12 == 0) goto L8;
        if (r12 >= 0) goto L6;
        r12 = r12 * (-1);
        r13 = true;
    L6:
        this.constantValue = r12;
    L8:
        if (r13 == true) goto L10;
        this.variables.put(r10, -1.0f);
        this.variables.put(r11, 1.0f);
    L11:
        return this;
    L10:
        this.variables.put(r10, 1.0f);
        this.variables.put(r11, -1.0f);
        goto L11
    }

    public ArrayRow createRowGreaterThan(SolverVariable r10, int r11, SolverVariable r12) {
        this.constantValue = r11;
        this.variables.put(r10, -1.0f);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable r10, SolverVariable r11, SolverVariable r12, int r13) {
        boolean r14 = false;
        if (r13 == 0) goto L8;
        if (r13 >= 0) goto L6;
        r13 = r13 * (-1);
        r14 = true;
    L6:
        this.constantValue = r13;
    L8:
        if (r14 == true) goto L10;
        this.variables.put(r10, -1.0f);
        this.variables.put(r11, 1.0f);
        this.variables.put(r12, 1.0f);
    L11:
        return this;
    L10:
        this.variables.put(r10, 1.0f);
        this.variables.put(r11, -1.0f);
        this.variables.put(r12, -1.0f);
        goto L11
    }

    public ArrayRow createRowLowerThan(SolverVariable r10, SolverVariable r11, SolverVariable r12, int r13) {
        boolean r14 = false;
        if (r13 == 0) goto L8;
        if (r13 >= 0) goto L6;
        r13 = r13 * (-1);
        r14 = true;
    L6:
        this.constantValue = r13;
    L8:
        if (r14 == true) goto L10;
        this.variables.put(r10, -1.0f);
        this.variables.put(r11, 1.0f);
        this.variables.put(r12, -1.0f);
    L11:
        return this;
    L10:
        this.variables.put(r10, 1.0f);
        this.variables.put(r11, -1.0f);
        this.variables.put(r12, 1.0f);
        goto L11
    }

    public ArrayRow createRowWithAngle(SolverVariable r10, SolverVariable r11, SolverVariable r12, SolverVariable r13, float r14) {
        this.variables.put(r12, 0.5f);
        this.variables.put(r13, 0.5f);
        this.variables.put(r10, -0.5f);
        this.variables.put(r11, -0.5f);
        this.constantValue = -r14;
        return this;
    }

    void ensurePositiveConstant() {
        float r10 = this.constantValue;
        if (r10 >= 0.0f) goto L6;
        this.constantValue = r10 * (-1.0f);
        this.variables.invert();
        return;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getKey() {
        return this.variable;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem r10, boolean[] r11) {
        return pickPivotInVariables(r11, null);
    }

    boolean hasKeyVariable() {
        SolverVariable r10 = this.variable;
        if (r10 != null) goto L5;
    L9:
        return false;
    L5:
        if (r10.mType != SolverVariable.Type.UNRESTRICTED) goto L7;
    L8:
        return true;
    L7:
        if (this.constantValue < 0.0f) goto L9;
        goto L8
    }

    boolean hasVariable(SolverVariable r10) {
        return this.variables.contains(r10);
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void initFromRow(LinearSystem.Row r10) {
        if ((r10 instanceof ArrayRow) == false) goto L8;
        ArrayRow r11 = (ArrayRow) r10;
        this.variable = null;
        this.variables.clear();
        int r12 = 0;
    L6:
        if (r12 >= r11.variables.getCurrentSize()) goto L10;
        SolverVariable r13 = r11.variables.getVariable(r12);
        float r14 = r11.variables.getVariableValue(r12);
        this.variables.add(r13, r14, true);
        r12 = r12 + 1;
        goto L6
    L10:
        return;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        if (this.variable == null) goto L5;
    L9:
        return false;
    L5:
        if (this.constantValue != 0.0f) goto L9;
        if (this.variables.getCurrentSize() != 0) goto L9;
        return true;
    }

    public SolverVariable pickPivot(SolverVariable r10) {
        return pickPivotInVariables(null, r10);
    }

    void pivot(SolverVariable r10) {
        SolverVariable r11 = this.variable;
        if (r11 == null) goto L5;
        this.variables.put(r11, -1.0f);
        this.variable.definitionId = -1;
        this.variable = null;
    L5:
        float r12 = this.variables.remove(r10, true) * (-1.0f);
        this.variable = r10;
        if (r12 != 1.0f) goto L8;
        return;
    L8:
        this.constantValue /= r12;
        this.variables.divideByAmount(r12);
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    int sizeInBytes() {
        if (this.variable == null) goto L5;
        int r10 = 4;
    L7:
        return ((r10 + 4) + 4) + this.variables.sizeInBytes();
    L5:
        r10 = 0;
        goto L7
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    java.lang.String toReadableString() {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.ArrayRow.toReadableString():java.lang.String");
    }

    public String toString() {
        return toReadableString();
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromFinalVariable(LinearSystem r10, SolverVariable r11, boolean r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isFinalValue == false) goto L18;
        this.constantValue += r11.computedValue * this.variables.get(r11);
        this.variables.remove(r11, r12);
        if (r12 == false) goto L10;
        r11.removeFromRow(this);
    L10:
        if (LinearSystem.SIMPLIFY_SYNONYMS == true) goto L12;
        return;
    L12:
        if (this.variables.getCurrentSize() != 0) goto L17;
        this.isSimpleDefinition = true;
        r10.hasSimpleDefinition = true;
        return;
    L17:
        return;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem r10, ArrayRow r11, boolean r12) {
        this.constantValue += r11.constantValue * this.variables.use(r11, r12);
        if (r12 == false) goto L6;
        r11.variable.removeFromRow(this);
    L6:
        if (LinearSystem.SIMPLIFY_SYNONYMS == true) goto L8;
        return;
    L8:
        if (this.variable != null) goto L10;
        return;
    L10:
        if (this.variables.getCurrentSize() != 0) goto L15;
        this.isSimpleDefinition = true;
        r10.hasSimpleDefinition = true;
        return;
    }

    public void updateFromSynonymVariable(LinearSystem r10, SolverVariable r11, boolean r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isSynonym == false) goto L18;
        float r13 = this.variables.get(r11);
        this.constantValue += r11.synonymDelta * r13;
        this.variables.remove(r11, r12);
        if (r12 == false) goto L9;
        r11.removeFromRow(this);
    L9:
        this.variables.add(r10.mCache.mIndexedVariables[r11.synonym], r13, r12);
        if (LinearSystem.SIMPLIFY_SYNONYMS == true) goto L12;
        return;
    L12:
        if (this.variables.getCurrentSize() != 0) goto L17;
        this.isSimpleDefinition = true;
        r10.hasSimpleDefinition = true;
        return;
    L17:
        return;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromSystem(LinearSystem r10) {
        if (r10.mRows.length != 0) goto L5;
        return;
    L5:
        boolean r11 = false;
    L7:
        if (r11 == true) goto L33;
        int r12 = this.variables.getCurrentSize();
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L18;
        SolverVariable r14 = this.variables.getVariable(r13);
        if (r14.definitionId == (-1)) goto L13;
    L16:
        this.variablesToUpdate.add(r14);
    L17:
        r13 = r13 + 1;
        goto L9
    L13:
        if (r14.isFinalValue == true) goto L16;
        if (r14.isSynonym == false) goto L17;
    L18:
        int r15 = this.variablesToUpdate.size();
        if (r15 > 0) goto L20;
        r11 = true;
        goto L7
    L20:
        int r16 = 0;
    L21:
        if (r16 >= r15) goto L30;
        SolverVariable r17 = this.variablesToUpdate.get(r16);
        if (r17.isFinalValue == false) goto L26;
        updateFromFinalVariable(r10, r17, true);
    L29:
        r16 = r16 + 1;
        goto L21
    L26:
        if (r17.isSynonym == false) goto L28;
        updateFromSynonymVariable(r10, r17, true);
        goto L29
    L28:
        updateFromRow(r10, r10.mRows[r17.definitionId], true);
        goto L29
    L30:
        this.variablesToUpdate.clear();
        goto L7
    L33:
        if (LinearSystem.SIMPLIFY_SYNONYMS == true) goto L35;
        return;
    L35:
        if (this.variable != null) goto L37;
        return;
    L37:
        if (this.variables.getCurrentSize() != 0) goto L55;
        this.isSimpleDefinition = true;
        r10.hasSimpleDefinition = true;
        return;
    }
}
