package kotlin.reflect.jvm.internal.impl.util;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class OperatorNameConventions {

    @JvmField
    public static final Set<Name> ALL_BINARY_OPERATION_NAMES = null;

    @JvmField
    public static final Name AND = null;

    @JvmField
    public static final Set<Name> ASSIGNMENT_OPERATIONS = null;

    @JvmField
    public static final Set<Name> BINARY_OPERATION_NAMES = null;

    @JvmField
    public static final Set<Name> BITWISE_OPERATION_NAMES = null;

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
        Name r5 = Name.identifier("getValue");
        GET_VALUE = r5;
        Name r10 = Name.identifier("setValue");
        SET_VALUE = r10;
        Name r11 = Name.identifier("provideDelegate");
        PROVIDE_DELEGATE = r11;
        Name r12 = Name.identifier("equals");
        EQUALS = r12;
        HASH_CODE = Name.identifier("hashCode");
        Name r13 = Name.identifier("compareTo");
        COMPARE_TO = r13;
        Name r14 = Name.identifier("contains");
        CONTAINS = r14;
        INVOKE = Name.identifier("invoke");
        ITERATOR = Name.identifier("iterator");
        GET = Name.identifier("get");
        SET = Name.identifier("set");
        NEXT = Name.identifier("next");
        HAS_NEXT = Name.identifier("hasNext");
        TO_STRING = Name.identifier("toString");
        COMPONENT_REGEX = new Regex("component\\d+");
        Name r15 = Name.identifier("and");
        AND = r15;
        Name r16 = Name.identifier("or");
        OR = r16;
        Name r17 = Name.identifier("xor");
        XOR = r17;
        Name r18 = Name.identifier("inv");
        INV = r18;
        Name r19 = Name.identifier("shl");
        SHL = r19;
        Name r110 = Name.identifier("shr");
        SHR = r110;
        Name r111 = Name.identifier("ushr");
        USHR = r111;
        Name r112 = Name.identifier("inc");
        INC = r112;
        Name r113 = Name.identifier("dec");
        DEC = r113;
        Name r20 = Name.identifier("plus");
        PLUS = r20;
        Name r21 = Name.identifier("minus");
        MINUS = r21;
        Name r114 = Name.identifier("not");
        NOT = r114;
        Name r115 = Name.identifier("unaryMinus");
        UNARY_MINUS = r115;
        Name r116 = Name.identifier("unaryPlus");
        UNARY_PLUS = r116;
        Name r117 = Name.identifier("times");
        TIMES = r117;
        Name r22 = Name.identifier("div");
        DIV = r22;
        Name r23 = Name.identifier("mod");
        MOD = r23;
        Name r24 = Name.identifier("rem");
        REM = r24;
        Name r25 = Name.identifier("rangeTo");
        RANGE_TO = r25;
        Name r26 = Name.identifier("rangeUntil");
        RANGE_UNTIL = r26;
        Name r27 = Name.identifier("timesAssign");
        TIMES_ASSIGN = r27;
        Name r28 = Name.identifier("divAssign");
        DIV_ASSIGN = r28;
        Name r29 = Name.identifier("modAssign");
        MOD_ASSIGN = r29;
        Name r30 = Name.identifier("remAssign");
        REM_ASSIGN = r30;
        Name r31 = Name.identifier("plusAssign");
        PLUS_ASSIGN = r31;
        Name r32 = Name.identifier("minusAssign");
        MINUS_ASSIGN = r32;
        UNARY_OPERATION_NAMES = SetsKt.setOf(new Name[]{r112, r113, r116, r115, r114, r18});
        SIMPLE_UNARY_OPERATION_NAMES = SetsKt.setOf(new Name[]{r116, r115, r114, r18});
        Set<Name> r33 = SetsKt.setOf(new Name[]{r117, r20, r21, r22, r23, r24, r25, r26});
        BINARY_OPERATION_NAMES = r33;
        Set<Name> r34 = SetsKt.setOf(new Name[]{r15, r16, r17, r18, r19, r110, r111});
        BITWISE_OPERATION_NAMES = r34;
        ALL_BINARY_OPERATION_NAMES = SetsKt.plus(SetsKt.plus(r33, r34), SetsKt.setOf(new Name[]{r12, r14, r13}));
        ASSIGNMENT_OPERATIONS = SetsKt.setOf(new Name[]{r27, r28, r29, r30, r31, r32});
        DELEGATED_PROPERTY_OPERATORS = SetsKt.setOf(new Name[]{r5, r10, r11});
    }

    private OperatorNameConventions() {
    }
}
