package androidx.constraintlayout.core;

/* JADX INFO: loaded from: classes.dex */
public class GoalRow extends ArrayRow {
    public GoalRow(Cache r10) {
        super(r10);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable r10) {
        super.addError(r10);
        r10.usageInRowCount--;
    }
}
