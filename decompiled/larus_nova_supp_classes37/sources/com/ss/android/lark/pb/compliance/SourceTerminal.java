package com.ss.android.lark.pb.compliance;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum SourceTerminal extends Enum<SourceTerminal> implements WireEnum {
    private static final /* synthetic */ SourceTerminal[] $VALUES = null;
    public static final ProtoAdapter<SourceTerminal> ADAPTER = null;
    public static final SourceTerminal Browser = null;
    public static final SourceTerminal Mobile = null;
    public static final SourceTerminal PC = null;
    public static final SourceTerminal UNKNOWN = null;
    private final int value;

    static {
        SourceTerminal r0 = new SourceTerminal("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        SourceTerminal r1 = new SourceTerminal("Browser", 1, 1);
        Browser = r1;
        SourceTerminal r3 = new SourceTerminal("PC", 2, 2);
        PC = r3;
        SourceTerminal r5 = new SourceTerminal("Mobile", 3, 3);
        Mobile = r5;
        $VALUES = new SourceTerminal[]{r0, r1, r3, r5};
        ADAPTER = ProtoAdapter.newEnumAdapter(SourceTerminal.class);
    }

    public static SourceTerminal[] values() {
        return (SourceTerminal[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SourceTerminal fromValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return Mobile;
    L14:
        return PC;
    L16:
        return Browser;
    L18:
        return UNKNOWN;
    }

    public static SourceTerminal valueOf(String r1) {
        return (SourceTerminal) a.a(SourceTerminal.class, r1);
    }

    private SourceTerminal(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
