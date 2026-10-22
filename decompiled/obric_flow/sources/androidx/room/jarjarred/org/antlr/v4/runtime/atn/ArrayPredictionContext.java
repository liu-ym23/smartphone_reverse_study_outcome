package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ArrayPredictionContext extends PredictionContext {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final PredictionContext[] parents;
    public final int[] returnStates;

    public ArrayPredictionContext(SingletonPredictionContext r5) {
        this(new PredictionContext[]{r5.parent}, new int[]{r5.returnState});
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContext
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ArrayPredictionContext) == true) goto L9;
        return false;
    L9:
        if (hashCode() == r5.hashCode()) goto L11;
        return false;
    L11:
        ArrayPredictionContext r10 = (ArrayPredictionContext) r5;
        if (Arrays.equals(this.returnStates, r10.returnStates) == false) goto L17;
        if (Arrays.equals(this.parents, r10.parents) == false) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContext
    public PredictionContext getParent(int r5) {
        return this.parents[r5];
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContext
    public int getReturnState(int r5) {
        return this.returnStates[r5];
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContext
    public boolean isEmpty() {
        if (this.returnStates[0] != Integer.MAX_VALUE) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContext
    public int size() {
        return this.returnStates.length;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "[]";
    L6:
        StringBuilder r5 = new StringBuilder("[");
        int r10 = 0;
    L8:
        if (r10 >= this.returnStates.length) goto L19;
        if (r10 <= 0) goto L11;
        r5.append(", ");
    L11:
        int r11 = this.returnStates[r10];
        if (r11 != Integer.MAX_VALUE) goto L14;
        r5.append("$");
    L18:
        r10 = r10 + 1;
        goto L8
    L14:
        r5.append(r11);
        if (this.parents[r10] == null) goto L17;
        r5.append(' ');
        r5.append(this.parents[r10].toString());
        goto L18
    L17:
        r5.append("null");
        goto L18
    L19:
        r5.append("]");
        return r5.toString();
    }

    public ArrayPredictionContext(PredictionContext[] r5, int[] r10) {
        super(PredictionContext.calculateHashCode(r5, r10));
        this.parents = r5;
        this.returnStates = r10;
    }
}
