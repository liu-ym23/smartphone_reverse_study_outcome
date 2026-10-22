package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum PermissionSettingType extends Enum<PermissionSettingType> implements WireEnum {
    private static final /* synthetic */ PermissionSettingType[] $VALUES = null;
    public static final ProtoAdapter<PermissionSettingType> ADAPTER = null;
    public static final PermissionSettingType CanEditByLinkInInternet = null;
    public static final PermissionSettingType CanEditByLinkInTenant = null;
    public static final PermissionSettingType CanReadByLinkInInternet = null;
    public static final PermissionSettingType CanReadByLinkInTenant = null;
    public static final PermissionSettingType DisableLinkShare = null;
    public static final PermissionSettingType PermissionSettingTypeUnknown = null;
    private final int value;

    static {
        PermissionSettingType r0 = new PermissionSettingType("PermissionSettingTypeUnknown", 0, 0);
        PermissionSettingTypeUnknown = r0;
        PermissionSettingType r1 = new PermissionSettingType("DisableLinkShare", 1, 1);
        DisableLinkShare = r1;
        PermissionSettingType r3 = new PermissionSettingType("CanReadByLinkInTenant", 2, 2);
        CanReadByLinkInTenant = r3;
        PermissionSettingType r5 = new PermissionSettingType("CanEditByLinkInTenant", 3, 3);
        CanEditByLinkInTenant = r5;
        PermissionSettingType r7 = new PermissionSettingType("CanReadByLinkInInternet", 4, 4);
        CanReadByLinkInInternet = r7;
        PermissionSettingType r9 = new PermissionSettingType("CanEditByLinkInInternet", 5, 5);
        CanEditByLinkInInternet = r9;
        $VALUES = new PermissionSettingType[]{r0, r1, r3, r5, r7, r9};
        ADAPTER = ProtoAdapter.newEnumAdapter(PermissionSettingType.class);
    }

    public static PermissionSettingType[] values() {
        return (PermissionSettingType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PermissionSettingType fromValue(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L16;
        return null;
    L16:
        return CanEditByLinkInInternet;
    L18:
        return CanReadByLinkInInternet;
    L20:
        return CanEditByLinkInTenant;
    L22:
        return CanReadByLinkInTenant;
    L24:
        return DisableLinkShare;
    L26:
        return PermissionSettingTypeUnknown;
    }

    public static PermissionSettingType valueOf(String r1) {
        return (PermissionSettingType) a.a(PermissionSettingType.class, r1);
    }

    private PermissionSettingType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
