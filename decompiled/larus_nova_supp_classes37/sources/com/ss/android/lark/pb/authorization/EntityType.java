package com.ss.android.lark.pb.authorization;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum EntityType extends Enum<EntityType> implements WireEnum {
    private static final /* synthetic */ EntityType[] $VALUES = null;
    public static final ProtoAdapter<EntityType> ADAPTER = null;
    public static final EntityType ANY = null;
    public static final EntityType CCM_BITABLE = null;
    public static final EntityType CCM_DOC = null;
    public static final EntityType CCM_FILE = null;
    public static final EntityType CCM_MINDNOTE = null;
    public static final EntityType CCM_SHEET = null;
    public static final EntityType CCM_SLIDE = null;
    public static final EntityType ENTITY_TYPE_UNKNOWN = null;
    public static final EntityType IM_FILE = null;
    public static final EntityType IM_IMAGE = null;
    public static final EntityType IM_VIDEO = null;
    public static final EntityType USER = null;
    private final int value;

    static {
        EntityType r0 = new EntityType("ENTITY_TYPE_UNKNOWN", 0, 0);
        ENTITY_TYPE_UNKNOWN = r0;
        EntityType r1 = new EntityType("ANY", 1, 1);
        ANY = r1;
        EntityType r3 = new EntityType("USER", 2, 2);
        USER = r3;
        EntityType r5 = new EntityType("IM_IMAGE", 3, 3);
        IM_IMAGE = r5;
        EntityType r7 = new EntityType("IM_VIDEO", 4, 4);
        IM_VIDEO = r7;
        EntityType r9 = new EntityType("IM_FILE", 5, 5);
        IM_FILE = r9;
        EntityType r11 = new EntityType("CCM_DOC", 6, 6);
        CCM_DOC = r11;
        EntityType r13 = new EntityType("CCM_SHEET", 7, 7);
        CCM_SHEET = r13;
        EntityType r15 = new EntityType("CCM_BITABLE", 8, 8);
        CCM_BITABLE = r15;
        EntityType r14 = new EntityType("CCM_MINDNOTE", 9, 9);
        CCM_MINDNOTE = r14;
        EntityType r12 = new EntityType("CCM_FILE", 10, 10);
        CCM_FILE = r12;
        EntityType r10 = new EntityType("CCM_SLIDE", 11, 11);
        CCM_SLIDE = r10;
        $VALUES = new EntityType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        ADAPTER = ProtoAdapter.newEnumAdapter(EntityType.class);
    }

    public static EntityType[] values() {
        return (EntityType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EntityType fromValue(int r0) {
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
        return CCM_SLIDE;
    L8:
        return CCM_FILE;
    L10:
        return CCM_MINDNOTE;
    L12:
        return CCM_BITABLE;
    L14:
        return CCM_SHEET;
    L16:
        return CCM_DOC;
    L18:
        return IM_FILE;
    L20:
        return IM_VIDEO;
    L22:
        return IM_IMAGE;
    L24:
        return USER;
    L26:
        return ANY;
    L28:
        return ENTITY_TYPE_UNKNOWN;
    }

    public static EntityType valueOf(String r1) {
        return (EntityType) a.a(EntityType.class, r1);
    }

    private EntityType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
