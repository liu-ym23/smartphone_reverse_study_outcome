package com.squareup.kotlinpoet;

import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import androidx.room.writer.DaoWriter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b \b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006\""}, d2 = {"Lcom/squareup/kotlinpoet/KOperator;", "", "", "operator", "Ljava/lang/String;", "getOperator$kotlinpoet", "()Ljava/lang/String;", "functionName", "getFunctionName$kotlinpoet", "UNARY_PLUS", "PLUS", "UNARY_MINUS", "MINUS", "TIMES", "DIV", "REM", "PLUS_ASSIGN", "MINUS_ASSIGN", "TIMES_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", "INC", "DEC", "EQUALS", "NOT_EQUALS", "NOT", "RANGE_TO", "CONTAINS", "NOT_CONTAINS", "GT", "LT", "GE", "LE", "ITERATOR", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum KOperator extends Enum<KOperator> {
    public static final KOperator CONTAINS = null;
    public static final KOperator DEC = null;
    public static final KOperator DIV = null;
    public static final KOperator DIV_ASSIGN = null;
    public static final KOperator EQUALS = null;
    public static final KOperator GE = null;
    public static final KOperator GT = null;
    public static final KOperator INC = null;
    public static final KOperator ITERATOR = null;
    public static final KOperator LE = null;
    public static final KOperator LT = null;
    public static final KOperator MINUS = null;
    public static final KOperator MINUS_ASSIGN = null;
    public static final KOperator NOT = null;
    public static final KOperator NOT_CONTAINS = null;
    public static final KOperator NOT_EQUALS = null;
    public static final KOperator PLUS = null;
    public static final KOperator PLUS_ASSIGN = null;
    public static final KOperator RANGE_TO = null;
    public static final KOperator REM = null;
    public static final KOperator REM_ASSIGN = null;
    public static final KOperator TIMES = null;
    public static final KOperator TIMES_ASSIGN = null;
    public static final KOperator UNARY_MINUS = null;
    public static final KOperator UNARY_PLUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KOperator[] f15070a = null;
    private final String functionName;
    private final String operator;

    static {
        KOperator r5 = new KOperator("UNARY_PLUS", 0, "+", "unaryPlus");
        UNARY_PLUS = r5;
        KOperator r10 = new KOperator("PLUS", 1, "+", "plus");
        PLUS = r10;
        KOperator r11 = new KOperator("UNARY_MINUS", 2, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, "unaryMinus");
        UNARY_MINUS = r11;
        KOperator r12 = new KOperator("MINUS", 3, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, "minus");
        MINUS = r12;
        KOperator r13 = new KOperator("TIMES", 4, XPath.WILDCARD, "times");
        TIMES = r13;
        KOperator r14 = new KOperator("DIV", 5, "/", "div");
        DIV = r14;
        KOperator r15 = new KOperator("REM", 6, "%", "rem");
        REM = r15;
        KOperator r16 = new KOperator("PLUS_ASSIGN", 7, "+=", "plusAssign");
        PLUS_ASSIGN = r16;
        KOperator r17 = new KOperator("MINUS_ASSIGN", 8, "-=", "minusAssign");
        MINUS_ASSIGN = r17;
        KOperator r18 = new KOperator("TIMES_ASSIGN", 9, "*=", "timesAssign");
        TIMES_ASSIGN = r18;
        KOperator r19 = new KOperator("DIV_ASSIGN", 10, "/=", "divAssign");
        DIV_ASSIGN = r19;
        KOperator r110 = new KOperator("REM_ASSIGN", 11, "%=", "remAssign");
        REM_ASSIGN = r110;
        KOperator r111 = new KOperator("INC", 12, "++", "inc");
        INC = r111;
        KOperator r112 = new KOperator("DEC", 13, "--", "dec");
        DEC = r112;
        KOperator r113 = new KOperator("EQUALS", 14, "==", "equals");
        EQUALS = r113;
        KOperator r114 = new KOperator("NOT_EQUALS", 15, "!=", "equals");
        NOT_EQUALS = r114;
        KOperator r115 = new KOperator("NOT", 16, XPath.NOT, "not");
        NOT = r115;
        KOperator r116 = new KOperator("RANGE_TO", 17, "..", "rangeTo");
        RANGE_TO = r116;
        KOperator r117 = new KOperator("CONTAINS", 18, "in", "contains");
        CONTAINS = r117;
        KOperator r118 = new KOperator("NOT_CONTAINS", 19, "!in", "contains");
        NOT_CONTAINS = r118;
        KOperator r119 = new KOperator("GT", 20, ">", "compareTo");
        GT = r119;
        KOperator r120 = new KOperator("LT", 21, "<", "compareTo");
        LT = r120;
        KOperator r121 = new KOperator("GE", 22, ">=", "compareTo");
        GE = r121;
        KOperator r122 = new KOperator("LE", 23, "<=", "compareTo");
        LE = r122;
        KOperator r123 = new KOperator("ITERATOR", 24, "in", "iterator");
        ITERATOR = r123;
        f15070a = new KOperator[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123};
    }

    public KOperator(String r5, int r10, String r11, String r12) {
        super(r5, r10);
        this.operator = r11;
        this.functionName = r12;
    }

    public static KOperator valueOf(String r5) {
        return (KOperator) Enum.valueOf(KOperator.class, r5);
    }

    public static KOperator[] values() {
        return (KOperator[]) f15070a.clone();
    }

    public final String getFunctionName$kotlinpoet() {
        return this.functionName;
    }

    public final String getOperator$kotlinpoet() {
        return this.operator;
    }
}
