package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

/* JADX INFO: loaded from: classes.dex */
public class EmptyPredictionContext extends SingletonPredictionContext {
    public EmptyPredictionContext() {
        super(null, Integer.MAX_VALUE);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SingletonPredictionContext, androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContext
    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SingletonPredictionContext, androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContext
    public PredictionContext getParent(int r5) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SingletonPredictionContext, androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContext
    public int getReturnState(int r5) {
        return this.returnState;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContext
    public boolean isEmpty() {
        return true;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SingletonPredictionContext, androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContext
    public int size() {
        return 1;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SingletonPredictionContext
    public String toString() {
        return "$";
    }
}
