package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ExtensionMode extends Enum<ExtensionMode> implements WireEnum {
    private static final /* synthetic */ ExtensionMode[] $VALUES = null;
    public static final ProtoAdapter<ExtensionMode> ADAPTER = null;
    public static final ExtensionMode MULTI = null;
    public static final ExtensionMode SINGLE = null;
    private final int value;

    static {
        ExtensionMode r0 = new ExtensionMode("SINGLE", 0, 0);
        SINGLE = r0;
        ExtensionMode r1 = new ExtensionMode("MULTI", 1, 1);
        MULTI = r1;
        $VALUES = new ExtensionMode[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(ExtensionMode.class);
    }

    public static ExtensionMode[] values() {
        return (ExtensionMode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ExtensionMode fromValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return MULTI;
    L10:
        return SINGLE;
    }

    public static ExtensionMode valueOf(String r1) {
        return (ExtensionMode) a.a(ExtensionMode.class, r1);
    }

    private ExtensionMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
