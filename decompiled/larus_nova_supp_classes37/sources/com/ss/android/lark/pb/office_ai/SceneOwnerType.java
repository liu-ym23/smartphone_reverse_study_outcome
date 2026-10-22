package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum SceneOwnerType extends Enum<SceneOwnerType> implements WireEnum {
    private static final /* synthetic */ SceneOwnerType[] $VALUES = null;
    public static final ProtoAdapter<SceneOwnerType> ADAPTER = null;
    public static final SceneOwnerType MyAIOwnerType_APP = null;
    public static final SceneOwnerType MyAIOwnerType_OFFICIAL = null;
    public static final SceneOwnerType MyAIOwnerType_USER = null;
    private final int value;

    static {
        SceneOwnerType r0 = new SceneOwnerType("MyAIOwnerType_USER", 0, 1);
        MyAIOwnerType_USER = r0;
        SceneOwnerType r1 = new SceneOwnerType("MyAIOwnerType_APP", 1, 2);
        MyAIOwnerType_APP = r1;
        SceneOwnerType r4 = new SceneOwnerType("MyAIOwnerType_OFFICIAL", 2, 3);
        MyAIOwnerType_OFFICIAL = r4;
        $VALUES = new SceneOwnerType[]{r0, r1, r4};
        ADAPTER = ProtoAdapter.newEnumAdapter(SceneOwnerType.class);
    }

    public static SceneOwnerType[] values() {
        return (SceneOwnerType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SceneOwnerType fromValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return MyAIOwnerType_OFFICIAL;
    L13:
        return MyAIOwnerType_APP;
    L15:
        return MyAIOwnerType_USER;
    }

    public static SceneOwnerType valueOf(String r1) {
        return (SceneOwnerType) a.a(SceneOwnerType.class, r1);
    }

    private SceneOwnerType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
