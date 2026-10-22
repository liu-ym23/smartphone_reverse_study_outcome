package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ContainerType extends Enum<ContainerType> implements WireEnum {
    private static final /* synthetic */ ContainerType[] $VALUES = null;
    public static final ProtoAdapter<ContainerType> ADAPTER = null;
    public static final ContainerType ContainerTypeUnknown = null;
    public static final ContainerType Wiki = null;
    private final int value;

    static {
        ContainerType r0 = new ContainerType("ContainerTypeUnknown", 0, 0);
        ContainerTypeUnknown = r0;
        ContainerType r1 = new ContainerType("Wiki", 1, 1);
        Wiki = r1;
        $VALUES = new ContainerType[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(ContainerType.class);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ContainerType fromValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return Wiki;
    L10:
        return ContainerTypeUnknown;
    }

    public static ContainerType valueOf(String r1) {
        return (ContainerType) a.a(ContainerType.class, r1);
    }

    private ContainerType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
