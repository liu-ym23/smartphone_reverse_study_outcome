package org.apache.poi.ss.formula.eval;

/* JADX INFO: loaded from: classes7.dex */
public final class NotImplementedFunctionException extends NotImplementedException {
    private static final long serialVersionUID = 1208119411557559057L;
    private String functionName;

    public NotImplementedFunctionException(String r1) {
        super(r1);
        this.functionName = r1;
    }

    public NotImplementedFunctionException(String r1, NotImplementedException r2) {
        super(r1, r2);
        this.functionName = r1;
    }

    public String getFunctionName() {
        return this.functionName;
    }
}
