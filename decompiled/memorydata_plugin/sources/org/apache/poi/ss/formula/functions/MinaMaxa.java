package org.apache.poi.ss.formula.functions;

/* JADX INFO: loaded from: classes7.dex */
public abstract class MinaMaxa extends MultiOperandNumericFunction {
    public static final Function MAXA = null;
    public static final Function MINA = null;

    static {
        MAXA = new AnonymousClass1();
        MINA = new AnonymousClass2();
    }

    public MinaMaxa() {
        super(true, true);
    }
}
