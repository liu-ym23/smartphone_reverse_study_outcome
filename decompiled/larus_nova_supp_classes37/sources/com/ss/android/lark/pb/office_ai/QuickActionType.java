package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum QuickActionType extends Enum<QuickActionType> implements WireEnum {
    private static final /* synthetic */ QuickActionType[] $VALUES = null;
    public static final ProtoAdapter<QuickActionType> ADAPTER = null;
    public static final QuickActionType API = null;
    public static final QuickActionType EXTERNAL_LINK = null;
    public static final QuickActionType PROMPT_TASK = null;
    public static final QuickActionType QUERY = null;
    private final int value;

    static {
        QuickActionType r0 = new QuickActionType("PROMPT_TASK", 0, 0);
        PROMPT_TASK = r0;
        QuickActionType r1 = new QuickActionType("API", 1, 1);
        API = r1;
        QuickActionType r3 = new QuickActionType("QUERY", 2, 2);
        QUERY = r3;
        QuickActionType r5 = new QuickActionType("EXTERNAL_LINK", 3, 3);
        EXTERNAL_LINK = r5;
        $VALUES = new QuickActionType[]{r0, r1, r3, r5};
        ADAPTER = ProtoAdapter.newEnumAdapter(QuickActionType.class);
    }

    public static QuickActionType[] values() {
        return (QuickActionType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static QuickActionType fromValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return EXTERNAL_LINK;
    L14:
        return QUERY;
    L16:
        return API;
    L18:
        return PROMPT_TASK;
    }

    public static QuickActionType valueOf(String r1) {
        return (QuickActionType) a.a(QuickActionType.class, r1);
    }

    private QuickActionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
