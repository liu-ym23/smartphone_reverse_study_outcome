package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum FilterPredicate extends Enum<FilterPredicate> implements WireEnum {
    private static final /* synthetic */ FilterPredicate[] $VALUES = null;
    public static final ProtoAdapter<FilterPredicate> ADAPTER = null;
    public static final FilterPredicate EMPTY = null;
    public static final FilterPredicate EQUAL = null;
    public static final FilterPredicate EXCLUDE = null;
    public static final FilterPredicate GREATER_THAN = null;
    public static final FilterPredicate GREATER_THAN_EQUAL = null;
    public static final FilterPredicate INCLUDE = null;
    public static final FilterPredicate LESS_THAN = null;
    public static final FilterPredicate LESS_THAN_EQUAL = null;
    public static final FilterPredicate NOT_EMPTY = null;
    public static final FilterPredicate NOT_EQUAL = null;
    public static final FilterPredicate RANGE = null;
    public static final FilterPredicate UNKNOWN_PREDICATE = null;
    private final int value;

    static {
        FilterPredicate r0 = new FilterPredicate("UNKNOWN_PREDICATE", 0, 0);
        UNKNOWN_PREDICATE = r0;
        FilterPredicate r1 = new FilterPredicate("EQUAL", 1, 1);
        EQUAL = r1;
        FilterPredicate r3 = new FilterPredicate("NOT_EQUAL", 2, 2);
        NOT_EQUAL = r3;
        FilterPredicate r5 = new FilterPredicate("EMPTY", 3, 3);
        EMPTY = r5;
        FilterPredicate r7 = new FilterPredicate("NOT_EMPTY", 4, 4);
        NOT_EMPTY = r7;
        FilterPredicate r9 = new FilterPredicate("INCLUDE", 5, 5);
        INCLUDE = r9;
        FilterPredicate r11 = new FilterPredicate("EXCLUDE", 6, 6);
        EXCLUDE = r11;
        FilterPredicate r13 = new FilterPredicate("GREATER_THAN", 7, 7);
        GREATER_THAN = r13;
        FilterPredicate r15 = new FilterPredicate("LESS_THAN", 8, 8);
        LESS_THAN = r15;
        FilterPredicate r14 = new FilterPredicate("GREATER_THAN_EQUAL", 9, 9);
        GREATER_THAN_EQUAL = r14;
        FilterPredicate r12 = new FilterPredicate("LESS_THAN_EQUAL", 10, 10);
        LESS_THAN_EQUAL = r12;
        FilterPredicate r10 = new FilterPredicate("RANGE", 11, 11);
        RANGE = r10;
        $VALUES = new FilterPredicate[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        ADAPTER = ProtoAdapter.newEnumAdapter(FilterPredicate.class);
    }

    public static FilterPredicate[] values() {
        return (FilterPredicate[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FilterPredicate fromValue(int r0) {
        switch(r0) {
            case 0: goto L28;
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L22;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L10;
            case 10: goto L8;
            case 11: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return RANGE;
    L8:
        return LESS_THAN_EQUAL;
    L10:
        return GREATER_THAN_EQUAL;
    L12:
        return LESS_THAN;
    L14:
        return GREATER_THAN;
    L16:
        return EXCLUDE;
    L18:
        return INCLUDE;
    L20:
        return NOT_EMPTY;
    L22:
        return EMPTY;
    L24:
        return NOT_EQUAL;
    L26:
        return EQUAL;
    L28:
        return UNKNOWN_PREDICATE;
    }

    public static FilterPredicate valueOf(String r1) {
        return (FilterPredicate) a.a(FilterPredicate.class, r1);
    }

    private FilterPredicate(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
