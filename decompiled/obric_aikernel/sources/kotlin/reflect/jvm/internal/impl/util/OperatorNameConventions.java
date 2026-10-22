package kotlin.reflect.jvm.internal.impl.util;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class OperatorNameConventions {

    @JvmField
    public static final Name AND = null;

    @JvmField
    public static final Set<Name> ASSIGNMENT_OPERATIONS = null;

    @JvmField
    public static final Set<Name> BINARY_OPERATION_NAMES = null;

    @JvmField
    public static final Name COMPARE_TO = null;

    @JvmField
    public static final Regex COMPONENT_REGEX = null;

    @JvmField
    public static final Name CONTAINS = null;

    @JvmField
    public static final Name DEC = null;

    @JvmField
    public static final Set<Name> DELEGATED_PROPERTY_OPERATORS = null;

    @JvmField
    public static final Name DIV = null;

    @JvmField
    public static final Name DIV_ASSIGN = null;

    @JvmField
    public static final Name EQUALS = null;

    @JvmField
    public static final Name GET = null;

    @JvmField
    public static final Name GET_VALUE = null;

    @JvmField
    public static final Name HASH_CODE = null;

    @JvmField
    public static final Name HAS_NEXT = null;

    @JvmField
    public static final Name INC = null;
    public static final OperatorNameConventions INSTANCE = null;

    @JvmField
    public static final Name INV = null;

    @JvmField
    public static final Name INVOKE = null;

    @JvmField
    public static final Name ITERATOR = null;

    @JvmField
    public static final Name MINUS = null;

    @JvmField
    public static final Name MINUS_ASSIGN = null;

    @JvmField
    public static final Name MOD = null;

    @JvmField
    public static final Name MOD_ASSIGN = null;

    @JvmField
    public static final Name NEXT = null;

    @JvmField
    public static final Name NOT = null;

    @JvmField
    public static final Name OR = null;

    @JvmField
    public static final Name PLUS = null;

    @JvmField
    public static final Name PLUS_ASSIGN = null;

    @JvmField
    public static final Name PROVIDE_DELEGATE = null;

    @JvmField
    public static final Name RANGE_TO = null;

    @JvmField
    public static final Name RANGE_UNTIL = null;

    @JvmField
    public static final Name REM = null;

    @JvmField
    public static final Name REM_ASSIGN = null;

    @JvmField
    public static final Name SET = null;

    @JvmField
    public static final Name SET_VALUE = null;

    @JvmField
    public static final Name SHL = null;

    @JvmField
    public static final Name SHR = null;

    @JvmField
    public static final Set<Name> SIMPLE_UNARY_OPERATION_NAMES = null;

    @JvmField
    public static final Name TIMES = null;

    @JvmField
    public static final Name TIMES_ASSIGN = null;

    @JvmField
    public static final Name TO_STRING = null;

    @JvmField
    public static final Name UNARY_MINUS = null;

    @JvmField
    public static final Set<Name> UNARY_OPERATION_NAMES = null;

    @JvmField
    public static final Name UNARY_PLUS = null;

    @JvmField
    public static final Name USHR = null;

    @JvmField
    public static final Name XOR = null;

    static {
        INSTANCE = new OperatorNameConventions();
        Name r10 = Name.identifier("getValue");
        Intrinsics.checkNotNullExpressionValue(r10, "identifier(\"getValue\")");
        GET_VALUE = r10;
        Name r11 = Name.identifier("setValue");
        Intrinsics.checkNotNullExpressionValue(r11, "identifier(\"setValue\")");
        SET_VALUE = r11;
        Name r12 = Name.identifier("provideDelegate");
        Intrinsics.checkNotNullExpressionValue(r12, "identifier(\"provideDelegate\")");
        PROVIDE_DELEGATE = r12;
        Name r13 = Name.identifier("equals");
        Intrinsics.checkNotNullExpressionValue(r13, "identifier(\"equals\")");
        EQUALS = r13;
        Name r14 = Name.identifier("hashCode");
        Intrinsics.checkNotNullExpressionValue(r14, "identifier(\"hashCode\")");
        HASH_CODE = r14;
        Name r15 = Name.identifier("compareTo");
        Intrinsics.checkNotNullExpressionValue(r15, "identifier(\"compareTo\")");
        COMPARE_TO = r15;
        Name r16 = Name.identifier("contains");
        Intrinsics.checkNotNullExpressionValue(r16, "identifier(\"contains\")");
        CONTAINS = r16;
        Name r17 = Name.identifier("invoke");
        Intrinsics.checkNotNullExpressionValue(r17, "identifier(\"invoke\")");
        INVOKE = r17;
        Name r18 = Name.identifier("iterator");
        Intrinsics.checkNotNullExpressionValue(r18, "identifier(\"iterator\")");
        ITERATOR = r18;
        Name r19 = Name.identifier("get");
        Intrinsics.checkNotNullExpressionValue(r19, "identifier(\"get\")");
        GET = r19;
        Name r20 = Name.identifier("set");
        Intrinsics.checkNotNullExpressionValue(r20, "identifier(\"set\")");
        SET = r20;
        Name r21 = Name.identifier("next");
        Intrinsics.checkNotNullExpressionValue(r21, "identifier(\"next\")");
        NEXT = r21;
        Name r22 = Name.identifier("hasNext");
        Intrinsics.checkNotNullExpressionValue(r22, "identifier(\"hasNext\")");
        HAS_NEXT = r22;
        Name r23 = Name.identifier("toString");
        Intrinsics.checkNotNullExpressionValue(r23, "identifier(\"toString\")");
        TO_STRING = r23;
        COMPONENT_REGEX = new Regex("component\\d+");
        Name r24 = Name.identifier("and");
        Intrinsics.checkNotNullExpressionValue(r24, "identifier(\"and\")");
        AND = r24;
        Name r25 = Name.identifier("or");
        Intrinsics.checkNotNullExpressionValue(r25, "identifier(\"or\")");
        OR = r25;
        Name r26 = Name.identifier("xor");
        Intrinsics.checkNotNullExpressionValue(r26, "identifier(\"xor\")");
        XOR = r26;
        Name r27 = Name.identifier("inv");
        Intrinsics.checkNotNullExpressionValue(r27, "identifier(\"inv\")");
        INV = r27;
        Name r28 = Name.identifier("shl");
        Intrinsics.checkNotNullExpressionValue(r28, "identifier(\"shl\")");
        SHL = r28;
        Name r29 = Name.identifier("shr");
        Intrinsics.checkNotNullExpressionValue(r29, "identifier(\"shr\")");
        SHR = r29;
        Name r30 = Name.identifier("ushr");
        Intrinsics.checkNotNullExpressionValue(r30, "identifier(\"ushr\")");
        USHR = r30;
        Name r31 = Name.identifier("inc");
        Intrinsics.checkNotNullExpressionValue(r31, "identifier(\"inc\")");
        INC = r31;
        Name r32 = Name.identifier("dec");
        Intrinsics.checkNotNullExpressionValue(r32, "identifier(\"dec\")");
        DEC = r32;
        Name r33 = Name.identifier("plus");
        Intrinsics.checkNotNullExpressionValue(r33, "identifier(\"plus\")");
        PLUS = r33;
        Name r34 = Name.identifier("minus");
        Intrinsics.checkNotNullExpressionValue(r34, "identifier(\"minus\")");
        MINUS = r34;
        Name r35 = Name.identifier("not");
        Intrinsics.checkNotNullExpressionValue(r35, "identifier(\"not\")");
        NOT = r35;
        Name r36 = Name.identifier("unaryMinus");
        Intrinsics.checkNotNullExpressionValue(r36, "identifier(\"unaryMinus\")");
        UNARY_MINUS = r36;
        Name r110 = Name.identifier("unaryPlus");
        Intrinsics.checkNotNullExpressionValue(r110, "identifier(\"unaryPlus\")");
        UNARY_PLUS = r110;
        Name r111 = Name.identifier("times");
        Intrinsics.checkNotNullExpressionValue(r111, "identifier(\"times\")");
        TIMES = r111;
        Name r112 = Name.identifier("div");
        Intrinsics.checkNotNullExpressionValue(r112, "identifier(\"div\")");
        DIV = r112;
        Name r113 = Name.identifier("mod");
        Intrinsics.checkNotNullExpressionValue(r113, "identifier(\"mod\")");
        MOD = r113;
        Name r114 = Name.identifier("rem");
        Intrinsics.checkNotNullExpressionValue(r114, "identifier(\"rem\")");
        REM = r114;
        Name r115 = Name.identifier("rangeTo");
        Intrinsics.checkNotNullExpressionValue(r115, "identifier(\"rangeTo\")");
        RANGE_TO = r115;
        Name r37 = Name.identifier("rangeUntil");
        Intrinsics.checkNotNullExpressionValue(r37, "identifier(\"rangeUntil\")");
        RANGE_UNTIL = r37;
        Name r38 = Name.identifier("timesAssign");
        Intrinsics.checkNotNullExpressionValue(r38, "identifier(\"timesAssign\")");
        TIMES_ASSIGN = r38;
        Name r39 = Name.identifier("divAssign");
        Intrinsics.checkNotNullExpressionValue(r39, "identifier(\"divAssign\")");
        DIV_ASSIGN = r39;
        Name r40 = Name.identifier("modAssign");
        Intrinsics.checkNotNullExpressionValue(r40, "identifier(\"modAssign\")");
        MOD_ASSIGN = r40;
        Name r41 = Name.identifier("remAssign");
        Intrinsics.checkNotNullExpressionValue(r41, "identifier(\"remAssign\")");
        REM_ASSIGN = r41;
        Name r42 = Name.identifier("plusAssign");
        Intrinsics.checkNotNullExpressionValue(r42, "identifier(\"plusAssign\")");
        PLUS_ASSIGN = r42;
        Name r43 = Name.identifier("minusAssign");
        Intrinsics.checkNotNullExpressionValue(r43, "identifier(\"minusAssign\")");
        MINUS_ASSIGN = r43;
        UNARY_OPERATION_NAMES = SetsKt.setOf(new Name[]{r31, r32, r110, r36, r35, r27});
        SIMPLE_UNARY_OPERATION_NAMES = SetsKt.setOf(new Name[]{r110, r36, r35, r27});
        BINARY_OPERATION_NAMES = SetsKt.setOf(new Name[]{r111, r33, r34, r112, r113, r114, r115, r37});
        ASSIGNMENT_OPERATIONS = SetsKt.setOf(new Name[]{r38, r39, r40, r41, r42, r43});
        DELEGATED_PROPERTY_OPERATORS = SetsKt.setOf(new Name[]{r10, r11, r12});
    }

    private OperatorNameConventions() {
    }
}
