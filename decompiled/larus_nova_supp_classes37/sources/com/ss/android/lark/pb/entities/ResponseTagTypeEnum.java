package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ResponseTagTypeEnum extends Enum<ResponseTagTypeEnum> implements WireEnum {
    private static final /* synthetic */ ResponseTagTypeEnum[] $VALUES = null;
    public static final ProtoAdapter<ResponseTagTypeEnum> ADAPTER = null;
    public static final ResponseTagTypeEnum RELATION_TAG_EXTERNAL = null;
    public static final ResponseTagTypeEnum RELATION_TAG_PARTNER = null;
    public static final ResponseTagTypeEnum RELATION_TAG_TENANT_NAME = null;
    public static final ResponseTagTypeEnum RELATION_TAG_UNSET = null;
    private final int value;

    static {
        ResponseTagTypeEnum r0 = new ResponseTagTypeEnum("RELATION_TAG_UNSET", 0, 0);
        RELATION_TAG_UNSET = r0;
        ResponseTagTypeEnum r1 = new ResponseTagTypeEnum("RELATION_TAG_EXTERNAL", 1, 1);
        RELATION_TAG_EXTERNAL = r1;
        ResponseTagTypeEnum r3 = new ResponseTagTypeEnum("RELATION_TAG_PARTNER", 2, 2);
        RELATION_TAG_PARTNER = r3;
        ResponseTagTypeEnum r5 = new ResponseTagTypeEnum("RELATION_TAG_TENANT_NAME", 3, 3);
        RELATION_TAG_TENANT_NAME = r5;
        $VALUES = new ResponseTagTypeEnum[]{r0, r1, r3, r5};
        ADAPTER = ProtoAdapter.newEnumAdapter(ResponseTagTypeEnum.class);
    }

    public static ResponseTagTypeEnum[] values() {
        return (ResponseTagTypeEnum[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ResponseTagTypeEnum fromValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return RELATION_TAG_TENANT_NAME;
    L14:
        return RELATION_TAG_PARTNER;
    L16:
        return RELATION_TAG_EXTERNAL;
    L18:
        return RELATION_TAG_UNSET;
    }

    public static ResponseTagTypeEnum valueOf(String r1) {
        return (ResponseTagTypeEnum) a.a(ResponseTagTypeEnum.class, r1);
    }

    private ResponseTagTypeEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
