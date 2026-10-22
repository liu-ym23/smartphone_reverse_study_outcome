package com.ss.android.lark.pb.security;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum EntityType extends Enum<EntityType> implements WireEnum {
    private static final /* synthetic */ EntityType[] $VALUES = null;
    public static final ProtoAdapter<EntityType> ADAPTER = null;
    public static final EntityType RESERVED = null;
    private final int value;

    static {
        EntityType r0 = new EntityType("RESERVED", 0, 0);
        RESERVED = r0;
        $VALUES = new EntityType[]{r0};
        ADAPTER = ProtoAdapter.newEnumAdapter(EntityType.class);
    }

    public static EntityType[] values() {
        return (EntityType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EntityType fromValue(int r0) {
        if (r0 == 0) goto L6;
        return null;
    L6:
        return RESERVED;
    }

    public static EntityType valueOf(String r1) {
        return (EntityType) a.a(EntityType.class, r1);
    }

    private EntityType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
