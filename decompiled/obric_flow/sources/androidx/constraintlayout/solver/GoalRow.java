package androidx.constraintlayout.solver;

/* JADX INFO: loaded from: classes.dex */
public class GoalRow extends ArrayRow {
    public GoalRow(Cache r5) {
        super(r5);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable r5) {
        super.addError(r5);
        r5.usageInRowCount--;
    }
}
