package com.google.devtools.ksp.symbol;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/devtools/ksp/symbol/FunctionKind;", "", "TOP_LEVEL", "MEMBER", "STATIC", "ANONYMOUS", "LAMBDA", "api"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum FunctionKind extends Enum<FunctionKind> {
    public static final FunctionKind ANONYMOUS = null;
    public static final FunctionKind LAMBDA = null;
    public static final FunctionKind MEMBER = null;
    public static final FunctionKind STATIC = null;
    public static final FunctionKind TOP_LEVEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FunctionKind[] f9452a = null;

    static {
        FunctionKind r5 = new FunctionKind("TOP_LEVEL", 0);
        TOP_LEVEL = r5;
        FunctionKind r10 = new FunctionKind("MEMBER", 1);
        MEMBER = r10;
        FunctionKind r11 = new FunctionKind("STATIC", 2);
        STATIC = r11;
        FunctionKind r12 = new FunctionKind("ANONYMOUS", 3);
        ANONYMOUS = r12;
        FunctionKind r13 = new FunctionKind("LAMBDA", 4);
        LAMBDA = r13;
        f9452a = new FunctionKind[]{r5, r10, r11, r12, r13};
    }

    public static FunctionKind valueOf(String r5) {
        return (FunctionKind) Enum.valueOf(FunctionKind.class, r5);
    }

    public static FunctionKind[] values() {
        return (FunctionKind[]) f9452a.clone();
    }
}
