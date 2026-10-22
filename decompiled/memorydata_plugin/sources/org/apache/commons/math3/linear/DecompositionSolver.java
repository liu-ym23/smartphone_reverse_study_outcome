package org.apache.commons.math3.linear;

/* JADX INFO: loaded from: classes6.dex */
public interface DecompositionSolver {
    RealMatrix getInverse();

    RealVector solve(RealVector r1);
}
