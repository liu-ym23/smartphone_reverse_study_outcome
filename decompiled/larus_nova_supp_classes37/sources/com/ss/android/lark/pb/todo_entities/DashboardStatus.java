package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum DashboardStatus extends Enum<DashboardStatus> implements WireEnum {
    private static final /* synthetic */ DashboardStatus[] $VALUES = null;
    public static final ProtoAdapter<DashboardStatus> ADAPTER = null;
    public static final DashboardStatus CREATED = null;
    public static final DashboardStatus CREATING = null;
    public static final DashboardStatus DELETED = null;
    public static final DashboardStatus FAILED = null;
    public static final DashboardStatus NOT_CREATED = null;
    private final int value;

    static {
        DashboardStatus r0 = new DashboardStatus("NOT_CREATED", 0, 0);
        NOT_CREATED = r0;
        DashboardStatus r1 = new DashboardStatus("CREATING", 1, 1);
        CREATING = r1;
        DashboardStatus r3 = new DashboardStatus("CREATED", 2, 2);
        CREATED = r3;
        DashboardStatus r5 = new DashboardStatus("FAILED", 3, 3);
        FAILED = r5;
        DashboardStatus r7 = new DashboardStatus("DELETED", 4, 4);
        DELETED = r7;
        $VALUES = new DashboardStatus[]{r0, r1, r3, r5, r7};
        ADAPTER = ProtoAdapter.newEnumAdapter(DashboardStatus.class);
    }

    public static DashboardStatus[] values() {
        return (DashboardStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DashboardStatus fromValue(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return null;
    L14:
        return DELETED;
    L16:
        return FAILED;
    L18:
        return CREATED;
    L20:
        return CREATING;
    L22:
        return NOT_CREATED;
    }

    public static DashboardStatus valueOf(String r1) {
        return (DashboardStatus) a.a(DashboardStatus.class, r1);
    }

    private DashboardStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
