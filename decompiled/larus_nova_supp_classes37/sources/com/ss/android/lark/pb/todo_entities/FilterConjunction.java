package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum FilterConjunction extends Enum<FilterConjunction> implements WireEnum {
    private static final /* synthetic */ FilterConjunction[] $VALUES = null;
    public static final ProtoAdapter<FilterConjunction> ADAPTER = null;
    public static final FilterConjunction AND = null;
    public static final FilterConjunction OR = null;
    private final int value;

    static {
        FilterConjunction r0 = new FilterConjunction("AND", 0, 1);
        AND = r0;
        FilterConjunction r1 = new FilterConjunction("OR", 1, 2);
        OR = r1;
        $VALUES = new FilterConjunction[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(FilterConjunction.class);
    }

    public static FilterConjunction[] values() {
        return (FilterConjunction[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FilterConjunction fromValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return OR;
    L11:
        return AND;
    }

    public static FilterConjunction valueOf(String r1) {
        return (FilterConjunction) a.a(FilterConjunction.class, r1);
    }

    private FilterConjunction(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
