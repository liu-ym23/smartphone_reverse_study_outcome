package com.ss.android.lark.pb.authorization;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ResultType extends Enum<ResultType> implements WireEnum {
    private static final /* synthetic */ ResultType[] $VALUES = null;
    public static final ProtoAdapter<ResultType> ADAPTER = null;
    public static final ResultType Allow = null;
    public static final ResultType Deny = null;
    public static final ResultType Null = null;
    public static final ResultType RESULT_TYPE_UNKNOWN = null;
    private final int value;

    static {
        ResultType r0 = new ResultType("RESULT_TYPE_UNKNOWN", 0, 0);
        RESULT_TYPE_UNKNOWN = r0;
        ResultType r1 = new ResultType("Deny", 1, 1);
        Deny = r1;
        ResultType r3 = new ResultType("Allow", 2, 2);
        Allow = r3;
        ResultType r5 = new ResultType("Null", 3, 3);
        Null = r5;
        $VALUES = new ResultType[]{r0, r1, r3, r5};
        ADAPTER = ProtoAdapter.newEnumAdapter(ResultType.class);
    }

    public static ResultType[] values() {
        return (ResultType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ResultType fromValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return Null;
    L14:
        return Allow;
    L16:
        return Deny;
    L18:
        return RESULT_TYPE_UNKNOWN;
    }

    public static ResultType valueOf(String r1) {
        return (ResultType) a.a(ResultType.class, r1);
    }

    private ResultType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
