package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

/* JADX INFO: loaded from: classes.dex */
public class SingletonPredictionContext extends PredictionContext {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final PredictionContext parent;
    public final int returnState;

    public SingletonPredictionContext(PredictionContext r5, int r10) {
        if (r5 == null) goto L4;
        int r11 = PredictionContext.calculateHashCode(r5, r10);
    L5:
        super(r11);
        this.parent = r5;
        this.returnState = r10;
        return;
    L4:
        r11 = PredictionContext.calculateEmptyHashCode();
        goto L5
    }

    public static SingletonPredictionContext create(PredictionContext r5, int r10) {
        if (r10 != Integer.MAX_VALUE) goto L8;
        if (r5 != null) goto L8;
        return PredictionContext.EMPTY;
    L8:
        return new SingletonPredictionContext(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContext
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SingletonPredictionContext) == true) goto L9;
        return false;
    L9:
        if (hashCode() == r5.hashCode()) goto L11;
        return false;
    L11:
        SingletonPredictionContext r10 = (SingletonPredictionContext) r5;
        if (this.returnState != r10.returnState) goto L19;
        PredictionContext r11 = this.parent;
        if (r11 == null) goto L19;
        if (r11.equals(r10.parent) == false) goto L19;
        return true;
    L19:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContext
    public PredictionContext getParent(int r5) {
        return this.parent;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContext
    public int getReturnState(int r5) {
        return this.returnState;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContext
    public int size() {
        return 1;
    }

    public String toString() {
        PredictionContext r5 = this.parent;
        if (r5 == null) goto L5;
        String r10 = r5.toString();
    L7:
        if (r10.length() != 0) goto L15;
        int r11 = this.returnState;
        if (r11 != Integer.MAX_VALUE) goto L13;
        return "$";
    L13:
        return String.valueOf(r11);
    L15:
        return String.valueOf(this.returnState) + " " + r10;
    L5:
        r10 = "";
        goto L7
    }
}
