package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum EmployeeKind extends Enum<EmployeeKind> implements WireEnum {
    private static final /* synthetic */ EmployeeKind[] $VALUES = null;
    public static final ProtoAdapter<EmployeeKind> ADAPTER = null;
    public static final EmployeeKind AGENT = null;
    public static final EmployeeKind HUMAN = null;
    private final int value;

    static {
        EmployeeKind r0 = new EmployeeKind("HUMAN", 0, 0);
        HUMAN = r0;
        EmployeeKind r1 = new EmployeeKind("AGENT", 1, 1);
        AGENT = r1;
        $VALUES = new EmployeeKind[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(EmployeeKind.class);
    }

    public static EmployeeKind[] values() {
        return (EmployeeKind[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EmployeeKind fromValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return AGENT;
    L10:
        return HUMAN;
    }

    public static EmployeeKind valueOf(String r1) {
        return (EmployeeKind) a.a(EmployeeKind.class, r1);
    }

    private EmployeeKind(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
