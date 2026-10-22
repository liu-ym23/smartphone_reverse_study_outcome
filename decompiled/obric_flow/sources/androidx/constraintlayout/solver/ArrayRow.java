package androidx.constraintlayout.solver;

import ai.j0;
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
        void add(SolverVariable r5, float r10, boolean r11);

        void clear();

        boolean contains(SolverVariable r5);

        void display();

        void divideByAmount(float r5);

        float get(SolverVariable r5);

        int getCurrentSize();

        SolverVariable getVariable(int r5);

        float getVariableValue(int r5);

        int indexOf(SolverVariable r5);

        void invert();

        void put(SolverVariable r5, float r10);

        float remove(SolverVariable r5, boolean r10);

        int sizeInBytes();

        float use(ArrayRow r5, boolean r10);
    }

    public ArrayRow() {
        this.variable = null;
        this.constantValue = 0.0f;
        this.used = false;
        this.variablesToUpdate = new ArrayList();
        this.isSimpleDefinition = false;
    }

    private boolean isNew(SolverVariable r5, LinearSystem r10) {
        if (r5.usageInRowCount <= 1) goto L7;
        return false;
    L7:
        return true;
    }

    private SolverVariable pickPivotInVariables(boolean[] r10, SolverVariable r11) {
        int r5 = this.variables.getCurrentSize();
        SolverVariable r12 = null;
        int r13 = 0;
        float r14 = 0.0f;
    L3:
        if (r13 >= r5) goto L19;
        float r15 = this.variables.getVariableValue(r13);
        if (r15 >= 0.0f) goto L18;
        SolverVariable r16 = this.variables.getVariable(r13);
        if (r10 != null) goto L9;
    L10:
        if (r16 == r11) goto L18;
        SolverVariable.Type r17 = r16.mType;
        if (r17 == SolverVariable.Type.SLACK) goto L16;
        if (r17 != SolverVariable.Type.ERROR) goto L18;
    L16:
        if (r15 >= r14) goto L18;
        r14 = r15;
        r12 = r16;
        goto L18
    L9:
        if (r10[r16.f437id] == false) goto L10;
    L18:
        r13 = r13 + 1;
        goto L3
    L19:
        return r12;
    }

    public ArrayRow addError(LinearSystem r5, int r10) {
        this.variables.put(r5.createErrorVariable(r10, "ep"), 1.0f);
        this.variables.put(r5.createErrorVariable(r10, "em"), -1.0f);
        return this;
    }

    public ArrayRow addSingleError(SolverVariable r5, int r10) {
        this.variables.put(r5, r10);
        return this;
    }

    public boolean chooseSubject(LinearSystem r5) {
        SolverVariable r10 = chooseSubjectInVariables(r5);
        if (r10 != null) goto L5;
        boolean r11 = true;
    L7:
        if (this.variables.getCurrentSize() != 0) goto L9;
        this.isSimpleDefinition = true;
    L9:
        return r11;
    L5:
        pivot(r10);
        r11 = false;
        goto L7
    }

    public SolverVariable chooseSubjectInVariables(LinearSystem r15) {
        int r5 = this.variables.getCurrentSize();
        SolverVariable r10 = null;
        float r11 = 0.0f;
        float r12 = 0.0f;
        int r13 = 0;
        boolean r14 = false;
        boolean r16 = false;
        SolverVariable r17 = null;
    L3:
        if (r13 >= r5) goto L30;
        float r18 = this.variables.getVariableValue(r13);
        SolverVariable r19 = this.variables.getVariable(r13);
        if (r19.mType != SolverVariable.Type.UNRESTRICTED) goto L16;
        if (r10 != null) goto L10;
        boolean r20 = isNew(r19, r15);
    L8:
        r14 = r20;
        r11 = r18;
        r10 = r19;
    L29:
        r13 = r13 + 1;
        goto L3
    L10:
        if (r11 <= r18) goto L12;
        r20 = isNew(r19, r15);
        goto L8
    L12:
        if (r14 == true) goto L29;
        if (isNew(r19, r15) == false) goto L29;
        r11 = r18;
        r10 = r19;
        r14 = true;
        goto L29
    L16:
        if (r10 != null) goto L29;
        if (r18 >= 0.0f) goto L29;
        if (r17 != null) goto L23;
        boolean r21 = isNew(r19, r15);
    L21:
        r16 = r21;
        r12 = r18;
        r17 = r19;
        goto L29
    L23:
        if (r12 <= r18) goto L25;
        r21 = isNew(r19, r15);
        goto L21
    L25:
        if (r16 == true) goto L29;
        if (isNew(r19, r15) == false) goto L29;
        r12 = r18;
        r17 = r19;
        r16 = true;
        goto L29
    L30:
        if (r10 == null) goto L32;
        return r10;
    L32:
        return r17;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0.0f;
    }

    public ArrayRow createRowCentering(SolverVariable r10, SolverVariable r11, int r12, float r13, SolverVariable r14, SolverVariable r15, int r16) {
        if (r11 != r14) goto L7;
        this.variables.put(r10, 1.0f);
        this.variables.put(r15, 1.0f);
        this.variables.put(r11, -2.0f);
        return this;
    L7:
        if (r13 != 0.5f) goto L13;
        this.variables.put(r10, 1.0f);
        this.variables.put(r11, -1.0f);
        this.variables.put(r14, -1.0f);
        this.variables.put(r15, 1.0f);
        if (r12 > 0) goto L11;
        if (r16 > 0) goto L11;
    L22:
        return this;
    L11:
        this.constantValue = (-r12) + r16;
        goto L22
    L13:
        if (r13 > 0.0f) goto L16;
        this.variables.put(r10, -1.0f);
        this.variables.put(r11, 1.0f);
        this.constantValue = r12;
        goto L22
    L16:
        if (r13 < 1.0f) goto L18;
        this.variables.put(r15, -1.0f);
        this.variables.put(r14, 1.0f);
        this.constantValue = -r16;
        goto L22
    L18:
        float r5 = 1.0f - r13;
        this.variables.put(r10, r5 * 1.0f);
        this.variables.put(r11, r5 * (-1.0f));
        this.variables.put(r14, (-1.0f) * r13);
        this.variables.put(r15, 1.0f * r13);
        if (r12 > 0) goto L21;
        if (r16 <= 0) goto L22;
    L21:
        this.constantValue = (r16 * r13) + ((-r12) * r5);
        goto L22
    }

    public ArrayRow createRowDefinition(SolverVariable r5, int r10) {
        this.variable = r5;
        float r11 = r10;
        r5.computedValue = r11;
        this.constantValue = r11;
        this.isSimpleDefinition = true;
        return this;
    }

    public ArrayRow createRowDimensionPercent(SolverVariable r5, SolverVariable r10, float r11) {
        this.variables.put(r5, -1.0f);
        this.variables.put(r10, r11);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable r5, SolverVariable r10, SolverVariable r11, SolverVariable r12, float r13) {
        this.variables.put(r5, -1.0f);
        this.variables.put(r10, 1.0f);
        this.variables.put(r11, r13);
        this.variables.put(r12, -r13);
        return this;
    }

    public ArrayRow createRowEqualDimension(float r5, float r10, float r11, SolverVariable r12, int r13, SolverVariable r14, int r15, SolverVariable r16, int r17, SolverVariable r18, int r19) {
        if (r10 != 0.0f) goto L5;
    L8:
        this.constantValue = (((-r13) - r15) + r17) + r19;
        this.variables.put(r12, 1.0f);
        this.variables.put(r14, -1.0f);
        this.variables.put(r18, 1.0f);
        this.variables.put(r16, -1.0f);
    L9:
        return this;
    L5:
        if (r5 == r11) goto L8;
        float r20 = (r5 / r10) / (r11 / r10);
        this.constantValue = (r19 * r20) + ((r17 * r20) + ((-r13) - r15));
        this.variables.put(r12, 1.0f);
        this.variables.put(r14, -1.0f);
        this.variables.put(r18, r20);
        this.variables.put(r16, -r20);
        goto L9
    }

    public ArrayRow createRowEqualMatchDimensions(float r5, float r10, float r11, SolverVariable r12, SolverVariable r13, SolverVariable r14, SolverVariable r15) {
        this.constantValue = 0.0f;
        if (r10 != 0.0f) goto L5;
    L14:
        this.variables.put(r12, 1.0f);
        this.variables.put(r13, -1.0f);
        this.variables.put(r15, 1.0f);
        this.variables.put(r14, -1.0f);
    L15:
        return this;
    L5:
        if (r5 == r11) goto L14;
        if (r5 != 0.0f) goto L11;
        this.variables.put(r12, 1.0f);
        this.variables.put(r13, -1.0f);
        goto L15
    L11:
        if (r11 != 0.0f) goto L13;
        this.variables.put(r14, 1.0f);
        this.variables.put(r15, -1.0f);
        goto L15
    L13:
        float r16 = (r5 / r10) / (r11 / r10);
        this.variables.put(r12, 1.0f);
        this.variables.put(r13, -1.0f);
        this.variables.put(r15, r16);
        this.variables.put(r14, -r16);
        goto L15
    }

    public ArrayRow createRowEquals(SolverVariable r5, int r10) {
        if (r10 >= 0) goto L4;
        this.constantValue = r10 * (-1);
        this.variables.put(r5, 1.0f);
    L5:
        return this;
    L4:
        this.constantValue = r10;
        this.variables.put(r5, -1.0f);
        goto L5
    }

    public ArrayRow createRowGreaterThan(SolverVariable r5, SolverVariable r10, SolverVariable r11, int r12) {
        boolean r13 = false;
        if (r12 == 0) goto L8;
        if (r12 >= 0) goto L6;
        r12 = r12 * (-1);
        r13 = true;
    L6:
        this.constantValue = r12;
    L8:
        if (r13 == true) goto L10;
        this.variables.put(r5, -1.0f);
        this.variables.put(r10, 1.0f);
        this.variables.put(r11, 1.0f);
    L11:
        return this;
    L10:
        this.variables.put(r5, 1.0f);
        this.variables.put(r10, -1.0f);
        this.variables.put(r11, -1.0f);
        goto L11
    }

    public ArrayRow createRowLowerThan(SolverVariable r5, SolverVariable r10, SolverVariable r11, int r12) {
        boolean r13 = false;
        if (r12 == 0) goto L8;
        if (r12 >= 0) goto L6;
        r12 = r12 * (-1);
        r13 = true;
    L6:
        this.constantValue = r12;
    L8:
        if (r13 == true) goto L10;
        this.variables.put(r5, -1.0f);
        this.variables.put(r10, 1.0f);
        this.variables.put(r11, -1.0f);
    L11:
        return this;
    L10:
        this.variables.put(r5, 1.0f);
        this.variables.put(r10, -1.0f);
        this.variables.put(r11, 1.0f);
        goto L11
    }

    public ArrayRow createRowWithAngle(SolverVariable r5, SolverVariable r10, SolverVariable r11, SolverVariable r12, float r13) {
        this.variables.put(r11, 0.5f);
        this.variables.put(r12, 0.5f);
        this.variables.put(r5, -0.5f);
        this.variables.put(r10, -0.5f);
        this.constantValue = -r13;
        return this;
    }

    public void ensurePositiveConstant() {
        float r5 = this.constantValue;
        if (r5 >= 0.0f) goto L6;
        this.constantValue = r5 * (-1.0f);
        this.variables.invert();
        return;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getKey() {
        return this.variable;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem r5, boolean[] r10) {
        return pickPivotInVariables(r10, null);
    }

    public boolean hasKeyVariable() {
        SolverVariable r5 = this.variable;
        if (r5 != null) goto L5;
    L9:
        return false;
    L5:
        if (r5.mType != SolverVariable.Type.UNRESTRICTED) goto L7;
    L8:
        return true;
    L7:
        if (this.constantValue < 0.0f) goto L9;
        goto L8
    }

    public boolean hasVariable(SolverVariable r5) {
        return this.variables.contains(r5);
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void initFromRow(LinearSystem.Row r10) {
        if ((r10 instanceof ArrayRow) == false) goto L8;
        ArrayRow r11 = (ArrayRow) r10;
        this.variable = null;
        this.variables.clear();
        int r5 = 0;
    L6:
        if (r5 >= r11.variables.getCurrentSize()) goto L10;
        SolverVariable r12 = r11.variables.getVariable(r5);
        float r13 = r11.variables.getVariableValue(r5);
        this.variables.add(r12, r13, true);
        r5 = r5 + 1;
        goto L6
    L10:
        return;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        if (this.variable == null) goto L5;
    L9:
        return false;
    L5:
        if (this.constantValue != 0.0f) goto L9;
        if (this.variables.getCurrentSize() != 0) goto L9;
        return true;
    }

    public SolverVariable pickPivot(SolverVariable r5) {
        return pickPivotInVariables(null, r5);
    }

    public void pivot(SolverVariable r5) {
        SolverVariable r10 = this.variable;
        if (r10 == null) goto L5;
        this.variables.put(r10, -1.0f);
        this.variable.definitionId = -1;
        this.variable = null;
    L5:
        float r11 = this.variables.remove(r5, true) * (-1.0f);
        this.variable = r5;
        if (r11 != 1.0f) goto L8;
        return;
    L8:
        this.constantValue /= r11;
        this.variables.divideByAmount(r11);
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    public int sizeInBytes() {
        if (this.variable == null) goto L5;
        int r5 = 4;
    L6:
        int r10 = this.variables.sizeInBytes();
        return r10 + (r5 + 8);
    L5:
        r5 = 0;
        goto L6
    }

    public String toReadableString() {
        if (this.variable != null) goto L5;
        String r5 = "0";
    L6:
        String r10 = j0.j(r5, " = ");
        int r11 = 0;
        if (this.constantValue == 0.0f) goto L9;
        StringBuilder r12 = j0.u(r10);
        r12.append(this.constantValue);
        r10 = r12.toString();
        boolean r13 = true;
    L10:
        int r14 = this.variables.getCurrentSize();
    L11:
        if (r11 >= r14) goto L33;
        SolverVariable r15 = this.variables.getVariable(r11);
        if (r15 == null) goto L32;
        float r16 = this.variables.getVariableValue(r11);
        if (r16 == 0.0f) goto L32;
        String r17 = r15.toString();
        if (r13 == false) goto L21;
        if (r16 <= 0.0f) goto L26;
        r10 = j0.j(r10, " + ");
    L28:
        if (r16 != 1.0f) goto L30;
        r10 = j0.j(r10, r17);
    L31:
        r13 = true;
        goto L32
    L30:
        r10 = r10 + r16 + " " + r17;
        goto L31
    L26:
        r10 = j0.j(r10, " - ");
    L23:
        r16 = r16 * (-1.0f);
        goto L28
    L21:
        if (r16 >= 0.0f) goto L28;
        r10 = j0.j(r10, "- ");
    L32:
        r11 = r11 + 1;
        goto L11
    L33:
        if (r13 == false) goto L35;
        return r10;
    L35:
        return j0.j(r10, "0.0");
    L9:
        r13 = false;
        goto L10
    L5:
        r5 = "" + this.variable;
        goto L6
    }

    public String toString() {
        return toReadableString();
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromFinalVariable(LinearSystem r5, SolverVariable r10, boolean r11) {
        if (r10.isFinalValue == true) goto L5;
        return;
    L5:
        float r12 = this.variables.get(r10);
        float r13 = this.constantValue;
        this.constantValue = (r10.computedValue * r12) + r13;
        this.variables.remove(r10, r11);
        if (r11 == false) goto L9;
        r10.removeFromRow(this);
    L9:
        if (LinearSystem.SIMPLIFY_SYNONYMS == true) goto L11;
        return;
    L11:
        if (this.variables.getCurrentSize() != 0) goto L15;
        this.isSimpleDefinition = true;
        r5.hasSimpleDefinition = true;
        return;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromRow(LinearSystem r5, ArrayRow r10, boolean r11) {
        float r12 = this.variables.use(r10, r11);
        float r13 = this.constantValue;
        this.constantValue = (r10.constantValue * r12) + r13;
        if (r11 == false) goto L6;
        r10.variable.removeFromRow(this);
    L6:
        if (LinearSystem.SIMPLIFY_SYNONYMS == true) goto L8;
        return;
    L8:
        if (this.variable != null) goto L10;
        return;
    L10:
        if (this.variables.getCurrentSize() != 0) goto L15;
        this.isSimpleDefinition = true;
        r5.hasSimpleDefinition = true;
        return;
    }

    public void updateFromSynonymVariable(LinearSystem r5, SolverVariable r10, boolean r11) {
        if (r10.isSynonym == true) goto L5;
        return;
    L5:
        float r12 = this.variables.get(r10);
        float r13 = this.constantValue;
        this.constantValue = (r10.synonymDelta * r12) + r13;
        this.variables.remove(r10, r11);
        if (r11 == false) goto L8;
        r10.removeFromRow(this);
    L8:
        this.variables.add(r5.mCache.mIndexedVariables[r10.synonym], r12, r11);
        if (LinearSystem.SIMPLIFY_SYNONYMS == true) goto L11;
        return;
    L11:
        if (this.variables.getCurrentSize() != 0) goto L15;
        this.isSimpleDefinition = true;
        r5.hasSimpleDefinition = true;
        return;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromSystem(LinearSystem r10) {
        if (r10.mRows.length != 0) goto L5;
        return;
    L5:
        boolean r5 = false;
    L7:
        if (r5 == true) goto L33;
        int r11 = this.variables.getCurrentSize();
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L18;
        SolverVariable r13 = this.variables.getVariable(r12);
        if (r13.definitionId == (-1)) goto L13;
    L16:
        this.variablesToUpdate.add(r13);
    L17:
        r12 = r12 + 1;
        goto L9
    L13:
        if (r13.isFinalValue == true) goto L16;
        if (r13.isSynonym == false) goto L17;
    L18:
        int r14 = this.variablesToUpdate.size();
        if (r14 > 0) goto L20;
        r5 = true;
        goto L7
    L20:
        int r15 = 0;
    L21:
        if (r15 >= r14) goto L30;
        SolverVariable r16 = this.variablesToUpdate.get(r15);
        if (r16.isFinalValue == false) goto L26;
        updateFromFinalVariable(r10, r16, true);
    L29:
        r15 = r15 + 1;
        goto L21
    L26:
        if (r16.isSynonym == false) goto L28;
        updateFromSynonymVariable(r10, r16, true);
        goto L29
    L28:
        updateFromRow(r10, r10.mRows[r16.definitionId], true);
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

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable r5) {
        int r10 = r5.strength;
        float r11 = 1.0f;
        if (r10 != 1) goto L6;
    L17:
        this.variables.put(r5, r11);
        return;
    L6:
        if (r10 != 2) goto L9;
        r11 = 1000.0f;
        goto L17
    L9:
        if (r10 != 3) goto L12;
        r11 = 1000000.0f;
        goto L17
    L12:
        if (r10 != 4) goto L15;
        r11 = 1.0E9f;
        goto L17
    L15:
        if (r10 != 5) goto L17;
        r11 = 1.0E12f;
        goto L17
    }

    public ArrayRow createRowEquals(SolverVariable r5, SolverVariable r10, int r11) {
        boolean r12 = false;
        if (r11 == 0) goto L8;
        if (r11 >= 0) goto L6;
        r11 = r11 * (-1);
        r12 = true;
    L6:
        this.constantValue = r11;
    L8:
        if (r12 == true) goto L10;
        this.variables.put(r5, -1.0f);
        this.variables.put(r10, 1.0f);
    L11:
        return this;
    L10:
        this.variables.put(r5, 1.0f);
        this.variables.put(r10, -1.0f);
        goto L11
    }

    public ArrayRow(Cache r5) {
        this.variable = null;
        this.constantValue = 0.0f;
        this.used = false;
        this.variablesToUpdate = new ArrayList();
        this.isSimpleDefinition = false;
        this.variables = new ArrayLinkedVariables(this, r5);
    }

    public ArrayRow createRowGreaterThan(SolverVariable r5, int r10, SolverVariable r11) {
        this.constantValue = r10;
        this.variables.put(r5, -1.0f);
        return this;
    }
}
