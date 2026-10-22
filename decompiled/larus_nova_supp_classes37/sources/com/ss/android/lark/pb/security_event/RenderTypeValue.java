package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum RenderTypeValue extends Enum<RenderTypeValue> implements WireEnum {
    private static final /* synthetic */ RenderTypeValue[] $VALUES = null;
    public static final ProtoAdapter<RenderTypeValue> ADAPTER = null;
    public static final RenderTypeValue CopyText = null;
    public static final RenderTypeValue PlainText = null;
    public static final RenderTypeValue TimeText = null;
    private final int value;

    static {
        RenderTypeValue r0 = new RenderTypeValue("PlainText", 0, 1);
        PlainText = r0;
        RenderTypeValue r1 = new RenderTypeValue("CopyText", 1, 2);
        CopyText = r1;
        RenderTypeValue r4 = new RenderTypeValue("TimeText", 2, 3);
        TimeText = r4;
        $VALUES = new RenderTypeValue[]{r0, r1, r4};
        ADAPTER = ProtoAdapter.newEnumAdapter(RenderTypeValue.class);
    }

    public static RenderTypeValue[] values() {
        return (RenderTypeValue[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static RenderTypeValue fromValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return TimeText;
    L13:
        return CopyText;
    L15:
        return PlainText;
    }

    public static RenderTypeValue valueOf(String r1) {
        return (RenderTypeValue) a.a(RenderTypeValue.class, r1);
    }

    private RenderTypeValue(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
