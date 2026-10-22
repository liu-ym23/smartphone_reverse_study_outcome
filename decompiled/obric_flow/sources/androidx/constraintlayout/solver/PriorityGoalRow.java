package androidx.constraintlayout.solver;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
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

    public class GoalVariableAccessor implements Comparable {
        PriorityGoalRow row;
        final /* synthetic */ PriorityGoalRow this$0;
        SolverVariable variable;

        public GoalVariableAccessor(PriorityGoalRow r5, PriorityGoalRow r10) {
            this.this$0 = r5;
            this.row = r10;
        }

        public void add(SolverVariable r5) {
            int r10 = 0;
        L4:
            if (r10 >= 9) goto L9;
            float[] r11 = this.variable.goalStrengthVector;
            float r12 = r11[r10] + r5.goalStrengthVector[r10];
            r11[r10] = r12;
            if (Math.abs(r12) >= 1.0E-4f) goto L8;
            this.variable.goalStrengthVector[r10] = 0.0f;
        L8:
            r10 = r10 + 1;
            goto L4
        }

        public boolean addToGoal(SolverVariable r10, float r11) {
            int r5 = 0;
            boolean r12 = true;
            if (this.variable.inGoal == false) goto L14;
            int r13 = 0;
        L5:
            if (r13 >= 9) goto L11;
            float[] r14 = this.variable.goalStrengthVector;
            float r15 = (r10.goalStrengthVector[r13] * r11) + r14[r13];
            r14[r13] = r15;
            if (Math.abs(r15) >= 1.0E-4f) goto L9;
            this.variable.goalStrengthVector[r13] = 0.0f;
        L10:
            r13 = r13 + 1;
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
            if (r5 >= 9) goto L23;
            float r16 = r10.goalStrengthVector[r5];
            if (r16 == 0.0f) goto L21;
            float r17 = r16 * r11;
            if (Math.abs(r17) >= 1.0E-4f) goto L20;
            r17 = 0.0f;
        L20:
            this.variable.goalStrengthVector[r5] = r17;
        L22:
            r5 = r5 + 1;
            goto L14
        L21:
            this.variable.goalStrengthVector[r5] = 0.0f;
            goto L22
        L23:
            return true;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r5) {
            return this.variable.f437id - ((SolverVariable) r5).f437id;
        }

        public void init(SolverVariable r5) {
            this.variable = r5;
        }

        public final boolean isNegative() {
            int r5 = 8;
        L4:
            if (r5 < 0) goto L13;
            float r10 = this.variable.goalStrengthVector[r5];
            if (r10 > 0.0f) goto L7;
            if (r10 < 0.0f) goto L10;
            r5 = r5 - 1;
            goto L4
        L10:
            return true;
        L7:
            return false;
        L13:
            return false;
        }

        public final boolean isNull() {
            int r5 = 0;
        L4:
            if (r5 >= 9) goto L9;
            if (this.variable.goalStrengthVector[r5] != 0.0f) goto L7;
            r5 = r5 + 1;
            goto L4
        L7:
            return false;
        L9:
            return true;
        }

        public final boolean isSmallerThan(SolverVariable r10) {
            int r5 = 8;
        L4:
            if (r5 < 0) goto L12;
            float r11 = r10.goalStrengthVector[r5];
            float r12 = this.variable.goalStrengthVector[r5];
            if (r12 != r11) goto L9;
            r5 = r5 - 1;
            goto L4
        L9:
            if (r12 >= r11) goto L12;
            return true;
        L12:
            return false;
        }

        public void reset() {
            Arrays.fill(this.variable.goalStrengthVector, 0.0f);
        }

        public String toString() {
            String r5 = "[ ";
            if (this.variable == null) goto L8;
            int r10 = 0;
        L6:
            if (r10 >= 9) goto L8;
            r5 = a.r(j0.u(r5), this.variable.goalStrengthVector[r10], " ");
            r10 = r10 + 1;
        L8:
            StringBuilder r11 = j0.w(r5, "] ");
            r11.append(this.variable);
            return r11.toString();
        }
    }

    public PriorityGoalRow(Cache r5) {
        super(r5);
        this.TABLE_SIZE = 128;
        this.arrayGoals = new SolverVariable[128];
        this.sortArray = new SolverVariable[128];
        this.numGoals = 0;
        this.accessor = new GoalVariableAccessor(this, this);
        this.mCache = r5;
    }

    public static /* synthetic */ void access$000(PriorityGoalRow r5, SolverVariable r10) {
        r5.removeGoal(r10);
    }

    private final void addToGoal(SolverVariable r10) {
        int r5 = this.numGoals + 1;
        SolverVariable[] r11 = this.arrayGoals;
        if (r5 <= r11.length) goto L5;
        SolverVariable[] r12 = (SolverVariable[]) Arrays.copyOf(r11, r11.length * 2);
        this.arrayGoals = r12;
        this.sortArray = (SolverVariable[]) Arrays.copyOf(r12, r12.length * 2);
    L5:
        SolverVariable[] r13 = this.arrayGoals;
        int r14 = this.numGoals;
        r13[r14] = r10;
        int r15 = r14 + 1;
        this.numGoals = r15;
        if (r15 > 1) goto L8;
    L17:
        r10.inGoal = true;
        r10.addToRow(this);
        return;
    L8:
        if (r13[r14].f437id <= r10.f437id) goto L17;
        int r16 = 0;
        int r17 = 0;
    L10:
        int r18 = this.numGoals;
        if (r17 >= r18) goto L13;
        this.sortArray[r17] = this.arrayGoals[r17];
        r17 = r17 + 1;
        goto L10
    L13:
        Arrays.sort(this.sortArray, 0, r18, new AnonymousClass1(this));
    L15:
        if (r16 >= this.numGoals) goto L17;
        this.arrayGoals[r16] = this.sortArray[r16];
        r16 = r16 + 1;
        goto L15
    }

    private final void removeGoal(SolverVariable r10) {
        int r5 = 0;
    L4:
        if (r5 >= this.numGoals) goto L13;
        if (this.arrayGoals[r5] == r10) goto L7;
        r5 = r5 + 1;
    L7:
        int r11 = this.numGoals;
        if (r5 >= (r11 - 1)) goto L10;
        SolverVariable[] r12 = this.arrayGoals;
        int r13 = r5 + 1;
        r12[r5] = r12[r13];
        r5 = r13;
        goto L7
    L10:
        this.numGoals = r11 - 1;
        r10.inGoal = false;
        return;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable r5) {
        this.accessor.init(r5);
        this.accessor.reset();
        r5.goalStrengthVector[r5.strength] = 1.0f;
        addToGoal(r5);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem r5, boolean[] r10) {
        int r11 = 0;
        int r12 = -1;
    L4:
        if (r11 >= this.numGoals) goto L17;
        SolverVariable r13 = this.arrayGoals[r11];
        if (r10[r13.f437id] == true) goto L16;
        this.accessor.init(r13);
        if (r12 != (-1)) goto L14;
        if (this.accessor.isNegative() == false) goto L16;
    L15:
        r12 = r11;
        goto L16
    L14:
        if (this.accessor.isSmallerThan(this.arrayGoals[r12]) == true) goto L15;
    L16:
        r11 = r11 + 1;
        goto L4
    L17:
        if (r12 != (-1)) goto L21;
        return null;
    L21:
        return this.arrayGoals[r12];
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        if (this.numGoals != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow
    public String toString() {
        String r5 = a.r(new StringBuilder(" goal -> ("), this.constantValue, ") : ");
        int r10 = 0;
    L4:
        if (r10 >= this.numGoals) goto L6;
        SolverVariable r11 = this.arrayGoals[r10];
        this.accessor.init(r11);
        StringBuilder r12 = j0.u(r5);
        r12.append(this.accessor);
        r12.append(" ");
        r5 = r12.toString();
        r10 = r10 + 1;
        goto L4
    L6:
        return r5;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromRow(LinearSystem r10, ArrayRow r11, boolean r12) {
        SolverVariable r13 = r11.variable;
        if (r13 != null) goto L5;
        return;
    L5:
        ArrayRow.ArrayRowVariables r14 = r11.variables;
        int r5 = r14.getCurrentSize();
        int r15 = 0;
    L6:
        if (r15 >= r5) goto L11;
        SolverVariable r16 = r14.getVariable(r15);
        float r17 = r14.getVariableValue(r15);
        this.accessor.init(r16);
        if (this.accessor.addToGoal(r13, r17) == false) goto L10;
        addToGoal(r16);
    L10:
        float r18 = this.constantValue;
        this.constantValue = (r11.constantValue * r17) + r18;
        r15 = r15 + 1;
        goto L6
    L11:
        removeGoal(r13);
    }
}
