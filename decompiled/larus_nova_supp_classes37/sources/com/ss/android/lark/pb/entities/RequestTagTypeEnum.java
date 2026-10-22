package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum RequestTagTypeEnum extends Enum<RequestTagTypeEnum> implements WireEnum {
    private static final /* synthetic */ RequestTagTypeEnum[] $VALUES = null;
    public static final ProtoAdapter<RequestTagTypeEnum> ADAPTER = null;
    public static final RequestTagTypeEnum RELATION_TAG = null;
    public static final RequestTagTypeEnum UNKNOWN_TAG_TYPE = null;
    private final int value;

    static {
        RequestTagTypeEnum r0 = new RequestTagTypeEnum("UNKNOWN_TAG_TYPE", 0, 0);
        UNKNOWN_TAG_TYPE = r0;
        RequestTagTypeEnum r1 = new RequestTagTypeEnum("RELATION_TAG", 1, 1);
        RELATION_TAG = r1;
        $VALUES = new RequestTagTypeEnum[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(RequestTagTypeEnum.class);
    }

    public static RequestTagTypeEnum[] values() {
        return (RequestTagTypeEnum[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static RequestTagTypeEnum fromValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return RELATION_TAG;
    L10:
        return UNKNOWN_TAG_TYPE;
    }

    public static RequestTagTypeEnum valueOf(String r1) {
        return (RequestTagTypeEnum) a.a(RequestTagTypeEnum.class, r1);
    }

    private RequestTagTypeEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
