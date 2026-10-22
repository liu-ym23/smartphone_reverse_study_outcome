package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ProcessorType extends Enum<ProcessorType> implements WireEnum {
    private static final /* synthetic */ ProcessorType[] $VALUES = null;
    public static final ProtoAdapter<ProcessorType> ADAPTER = null;
    public static final ProcessorType ProcessorType_AI_ENGINE = null;
    public static final ProcessorType ProcessorType_APAAS = null;
    public static final ProcessorType ProcessorType_INNER = null;
    public static final ProcessorType ProcessorType_OPENAPI = null;
    private final int value;

    static {
        ProcessorType r0 = new ProcessorType("ProcessorType_AI_ENGINE", 0, 1);
        ProcessorType_AI_ENGINE = r0;
        ProcessorType r1 = new ProcessorType("ProcessorType_APAAS", 1, 2);
        ProcessorType_APAAS = r1;
        ProcessorType r4 = new ProcessorType("ProcessorType_OPENAPI", 2, 3);
        ProcessorType_OPENAPI = r4;
        ProcessorType r6 = new ProcessorType("ProcessorType_INNER", 3, 4);
        ProcessorType_INNER = r6;
        $VALUES = new ProcessorType[]{r0, r1, r4, r6};
        ADAPTER = ProtoAdapter.newEnumAdapter(ProcessorType.class);
    }

    public static ProcessorType[] values() {
        return (ProcessorType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ProcessorType fromValue(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L13;
        return null;
    L13:
        return ProcessorType_INNER;
    L15:
        return ProcessorType_OPENAPI;
    L17:
        return ProcessorType_APAAS;
    L19:
        return ProcessorType_AI_ENGINE;
    }

    public static ProcessorType valueOf(String r1) {
        return (ProcessorType) a.a(ProcessorType.class, r1);
    }

    private ProcessorType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
