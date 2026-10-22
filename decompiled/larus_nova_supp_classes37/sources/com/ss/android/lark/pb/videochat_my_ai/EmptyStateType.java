package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum EmptyStateType extends Enum<EmptyStateType> implements WireEnum {
    private static final /* synthetic */ EmptyStateType[] $VALUES = null;
    public static final ProtoAdapter<EmptyStateType> ADAPTER = null;
    public static final EmptyStateType EMPTY_STATE_GET_MATERIALS = null;
    public static final EmptyStateType EMPTY_STATE_REPORT_DISPLAY = null;
    public static final EmptyStateType EMPTY_STATE_SEND_SUMMARY = null;
    public static final EmptyStateType EMPTY_STATE_UNKNOWN = null;
    private final int value;

    static {
        EmptyStateType r0 = new EmptyStateType("EMPTY_STATE_UNKNOWN", 0, 0);
        EMPTY_STATE_UNKNOWN = r0;
        EmptyStateType r1 = new EmptyStateType("EMPTY_STATE_GET_MATERIALS", 1, 1);
        EMPTY_STATE_GET_MATERIALS = r1;
        EmptyStateType r3 = new EmptyStateType("EMPTY_STATE_REPORT_DISPLAY", 2, 2);
        EMPTY_STATE_REPORT_DISPLAY = r3;
        EmptyStateType r5 = new EmptyStateType("EMPTY_STATE_SEND_SUMMARY", 3, 3);
        EMPTY_STATE_SEND_SUMMARY = r5;
        $VALUES = new EmptyStateType[]{r0, r1, r3, r5};
        ADAPTER = ProtoAdapter.newEnumAdapter(EmptyStateType.class);
    }

    public static EmptyStateType[] values() {
        return (EmptyStateType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EmptyStateType fromValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return EMPTY_STATE_SEND_SUMMARY;
    L14:
        return EMPTY_STATE_REPORT_DISPLAY;
    L16:
        return EMPTY_STATE_GET_MATERIALS;
    L18:
        return EMPTY_STATE_UNKNOWN;
    }

    public static EmptyStateType valueOf(String r1) {
        return (EmptyStateType) a.a(EmptyStateType.class, r1);
    }

    private EmptyStateType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
