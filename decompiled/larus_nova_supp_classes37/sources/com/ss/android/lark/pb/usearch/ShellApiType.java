package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ShellApiType extends Enum<ShellApiType> implements WireEnum {
    private static final /* synthetic */ ShellApiType[] $VALUES = null;
    public static final ProtoAdapter<ShellApiType> ADAPTER = null;
    public static final ShellApiType OpenWindow = null;
    private final int value;

    static {
        ShellApiType r0 = new ShellApiType("OpenWindow", 0, 1);
        OpenWindow = r0;
        $VALUES = new ShellApiType[]{r0};
        ADAPTER = ProtoAdapter.newEnumAdapter(ShellApiType.class);
    }

    public static ShellApiType[] values() {
        return (ShellApiType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ShellApiType fromValue(int r1) {
        if (r1 == 1) goto L7;
        return null;
    L7:
        return OpenWindow;
    }

    public static ShellApiType valueOf(String r1) {
        return (ShellApiType) a.a(ShellApiType.class, r1);
    }

    private ShellApiType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
