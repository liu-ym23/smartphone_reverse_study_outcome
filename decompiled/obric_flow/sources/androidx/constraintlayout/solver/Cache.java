package androidx.constraintlayout.solver;

/* JADX INFO: loaded from: classes.dex */
public class Cache {
    Pools.Pool<ArrayRow> arrayRowPool;
    SolverVariable[] mIndexedVariables;
    Pools.Pool<ArrayRow> optimizedArrayRowPool;
    Pools.Pool<SolverVariable> solverVariablePool;

    public Cache() {
        this.optimizedArrayRowPool = new Pools.SimplePool(256);
        this.arrayRowPool = new Pools.SimplePool(256);
        this.solverVariablePool = new Pools.SimplePool(256);
        this.mIndexedVariables = new SolverVariable[32];
    }
}
