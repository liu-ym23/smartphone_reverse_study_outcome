package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum TenantNameStatus extends Enum<TenantNameStatus> implements WireEnum {
    private static final /* synthetic */ TenantNameStatus[] $VALUES = null;
    public static final ProtoAdapter<TenantNameStatus> ADAPTER = null;
    public static final TenantNameStatus TENANT_NAME_STATUS_HIDE = null;
    public static final TenantNameStatus TENANT_NAME_STATUS_NOT_FRIEND = null;
    public static final TenantNameStatus TENANT_NAME_STATUS_UNKNOWN = null;
    public static final TenantNameStatus TENANT_NAME_STATUS_VISIBLE = null;
    private final int value;

    static {
        TenantNameStatus r0 = new TenantNameStatus("TENANT_NAME_STATUS_UNKNOWN", 0, 0);
        TENANT_NAME_STATUS_UNKNOWN = r0;
        TenantNameStatus r1 = new TenantNameStatus("TENANT_NAME_STATUS_NOT_FRIEND", 1, 1);
        TENANT_NAME_STATUS_NOT_FRIEND = r1;
        TenantNameStatus r3 = new TenantNameStatus("TENANT_NAME_STATUS_VISIBLE", 2, 2);
        TENANT_NAME_STATUS_VISIBLE = r3;
        TenantNameStatus r5 = new TenantNameStatus("TENANT_NAME_STATUS_HIDE", 3, 3);
        TENANT_NAME_STATUS_HIDE = r5;
        $VALUES = new TenantNameStatus[]{r0, r1, r3, r5};
        ADAPTER = ProtoAdapter.newEnumAdapter(TenantNameStatus.class);
    }

    public static TenantNameStatus[] values() {
        return (TenantNameStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TenantNameStatus fromValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return TENANT_NAME_STATUS_HIDE;
    L14:
        return TENANT_NAME_STATUS_VISIBLE;
    L16:
        return TENANT_NAME_STATUS_NOT_FRIEND;
    L18:
        return TENANT_NAME_STATUS_UNKNOWN;
    }

    public static TenantNameStatus valueOf(String r1) {
        return (TenantNameStatus) a.a(TenantNameStatus.class, r1);
    }

    private TenantNameStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
