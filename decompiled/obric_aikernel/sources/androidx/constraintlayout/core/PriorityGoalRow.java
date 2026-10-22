package androidx.constraintlayout.core;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    static final int NOT_FOUND = -1;
    private static final float epsilon = 1.0E-4f;
    private int TABLE_SIZE;
    GoalVariableAccessor accessor;
    private SolverVariable[] arrayGoals;
    Cache mCache;
    private int numGoals;
    private SolverVariable[] sortArray;

    class GoalVariableAccessor {
        PriorityGoalRow row;
        final /* synthetic */ PriorityGoalRow this$0;
        SolverVariable variable;

        public GoalVariableAccessor(PriorityGoalRow r10, PriorityGoalRow r11) {
            this.this$0 = r10;
            this.row = r11;
        }

        public void add(SolverVariable r10) {
            int r11 = 0;
        L4:
            if (r11 >= 9) goto L9;
            float[] r12 = this.variable.goalStrengthVector;
            r12[r11] = r12[r11] + r10.goalStrengthVector[r11];
            if (Math.abs(r12[r11]) >= PriorityGoalRow.epsilon) goto L8;
            this.variable.goalStrengthVector[r11] = 0.0f;
        L8:
            r11 = r11 + 1;
            goto L4
        }

        public boolean addToGoal(SolverVariable r10, float r11) {
            boolean r12 = true;
            int r13 = 0;
            if (this.variable.inGoal == false) goto L14;
            int r14 = 0;
        L5:
            if (r14 >= 9) goto L11;
            float[] r15 = this.variable.goalStrengthVector;
            r15[r14] = r15[r14] + (r10.goalStrengthVector[r14] * r11);
            if (Math.abs(r15[r14]) >= PriorityGoalRow.epsilon) goto L9;
            this.variable.goalStrengthVector[r14] = 0.0f;
        L10:
            r14 = r14 + 1;
            goto L5
        L9:
            r12 = false;
            goto L10
        L11:
            if (r12 == false) goto L13;
            PriorityGoalRow.access$000(this.this$0, this.variable);
        L13:
            return false;
        L14:
            if (r13 >= 9) goto L23;
            float r16 = r10.goalStrengthVector[r13];
            if (r16 == 0.0f) goto L21;
            float r17 = r16 * r11;
            if (Math.abs(r17) >= PriorityGoalRow.epsilon) goto L20;
            r17 = 0.0f;
        L20:
            this.variable.goalStrengthVector[r13] = r17;
        L22:
            r13 = r13 + 1;
            goto L14
        L21:
            this.variable.goalStrengthVector[r13] = 0.0f;
            goto L22
        L23:
            return true;
        }

        public void init(SolverVariable r10) {
            this.variable = r10;
        }

        public final boolean isNegative() {
            int r10 = 8;
        L4:
            if (r10 < 0) goto L13;
            float r11 = this.variable.goalStrengthVector[r10];
            if (r11 > 0.0f) goto L7;
            if (r11 < 0.0f) goto L10;
            r10 = r10 - 1;
            goto L4
        L10:
            return true;
        L7:
            return false;
        L13:
            return false;
        }

        public final boolean isNull() {
            int r10 = 0;
        L4:
            if (r10 >= 9) goto L9;
            if (this.variable.goalStrengthVector[r10] != 0.0f) goto L7;
            r10 = r10 + 1;
            goto L4
        L7:
            return false;
        L9:
            return true;
        }

        public final boolean isSmallerThan(SolverVariable r10) {
            int r11 = 8;
        L4:
            if (r11 < 0) goto L12;
            float r12 = r10.goalStrengthVector[r11];
            float r13 = this.variable.goalStrengthVector[r11];
            if (r13 != r12) goto L9;
            r11 = r11 - 1;
            goto L4
        L9:
            if (r13 >= r12) goto L12;
            return true;
        L12:
            return false;
        }

        public void reset() {
            Arrays.fill(this.variable.goalStrengthVector, 0.0f);
        }

        public String toString() {
            String r10 = "[ ";
            if (this.variable == null) goto L9;
            int r11 = 0;
        L6:
            if (r11 >= 9) goto L9;
            r10 = r10 + this.variable.goalStrengthVector[r11] + " ";
            r11 = r11 + 1;
        L9:
            return r10 + "] " + this.variable;
        }
    }

    public PriorityGoalRow(Cache r10) {
        super(r10);
        this.TABLE_SIZE = 128;
        this.arrayGoals = new SolverVariable[128];
        this.sortArray = new SolverVariable[128];
        this.numGoals = 0;
        this.accessor = new GoalVariableAccessor(this, this);
        this.mCache = r10;
    }

    static /* synthetic */ void access$000(PriorityGoalRow r10, SolverVariable r11) {
        r10.removeGoal(r11);
    }

    private final void addToGoal(SolverVariable r10) {
        int r11 = this.numGoals + 1;
        SolverVariable[] r12 = this.arrayGoals;
        if (r11 <= r12.length) goto L5;
        SolverVariable[] r13 = (SolverVariable[]) Arrays.copyOf(r12, r12.length * 2);
        this.arrayGoals = r13;
        this.sortArray = (SolverVariable[]) Arrays.copyOf(r13, r13.length * 2);
    L5:
        SolverVariable[] r14 = this.arrayGoals;
        int r15 = this.numGoals;
        r14[r15] = r10;
        int r16 = r15 + 1;
        this.numGoals = r16;
        if (r16 > 1) goto L8;
    L17:
        r10.inGoal = true;
        r10.addToRow(this);
        return;
    L8:
        if (r14[r16 - 1].id <= r10.id) goto L17;
        int r17 = 0;
        int r18 = 0;
    L10:
        int r19 = this.numGoals;
        if (r18 >= r19) goto L13;
        this.sortArray[r18] = this.arrayGoals[r18];
        r18 = r18 + 1;
        goto L10
    L13:
        Arrays.sort(this.sortArray, 0, r19, new AnonymousClass1(this));
    L15:
        if (r17 >= this.numGoals) goto L17;
        this.arrayGoals[r17] = this.sortArray[r17];
        r17 = r17 + 1;
        goto L15
    }

    private final void removeGoal(SolverVariable r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.numGoals) goto L13;
        if (this.arrayGoals[r11] == r10) goto L7;
        r11 = r11 + 1;
    L7:
        int r12 = this.numGoals;
        if (r11 >= (r12 - 1)) goto L10;
        SolverVariable[] r13 = this.arrayGoals;
        int r14 = r11 + 1;
        r13[r11] = r13[r14];
        r11 = r14;
        goto L7
    L10:
        this.numGoals = r12 - 1;
        r10.inGoal = false;
        return;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable r10) {
        this.accessor.init(r10);
        this.accessor.reset();
        r10.goalStrengthVector[r10.strength] = 1.0f;
        addToGoal(r10);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem r10, boolean[] r11) {
        int r12 = 0;
        int r13 = -1;
    L4:
        if (r12 >= this.numGoals) goto L17;
        SolverVariable r14 = this.arrayGoals[r12];
        if (r11[r14.id] == true) goto L16;
        this.accessor.init(r14);
        GoalVariableAccessor r15 = this.accessor;
        if (r13 != (-1)) goto L14;
        if (r15.isNegative() == false) goto L16;
    L15:
        r13 = r12;
        goto L16
    L14:
        if (r15.isSmallerThan(this.arrayGoals[r13]) == true) goto L15;
    L16:
        r12 = r12 + 1;
        goto L4
    L17:
        if (r13 != (-1)) goto L21;
        return null;
    L21:
        return this.arrayGoals[r13];
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        if (this.numGoals != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public String toString() {
        String r10 = " goal -> (" + this.constantValue + ") : ";
        int r11 = 0;
    L4:
        if (r11 >= this.numGoals) goto L6;
        this.accessor.init(this.arrayGoals[r11]);
        r10 = r10 + this.accessor + " ";
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem r10, ArrayRow r11, boolean r12) {
        SolverVariable r13 = r11.variable;
        if (r13 != null) goto L5;
        return;
    L5:
        ArrayRow.ArrayRowVariables r14 = r11.variables;
        int r15 = r14.getCurrentSize();
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L11;
        SolverVariable r17 = r14.getVariable(r16);
        float r18 = r14.getVariableValue(r16);
        this.accessor.init(r17);
        if (this.accessor.addToGoal(r13, r18) == false) goto L10;
        addToGoal(r17);
    L10:
        this.constantValue += r11.constantValue * r18;
        r16 = r16 + 1;
        goto L6
    L11:
        removeGoal(r13);
    }
}
