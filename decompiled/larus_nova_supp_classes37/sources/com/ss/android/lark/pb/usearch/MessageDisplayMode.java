package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum MessageDisplayMode extends Enum<MessageDisplayMode> implements WireEnum {
    private static final /* synthetic */ MessageDisplayMode[] $VALUES = null;
    public static final ProtoAdapter<MessageDisplayMode> ADAPTER = null;
    public static final MessageDisplayMode DISABLE = null;
    public static final MessageDisplayMode INVISIBLE = null;
    public static final MessageDisplayMode UNKNOWN_MODE = null;
    private final int value;

    static {
        MessageDisplayMode r0 = new MessageDisplayMode("UNKNOWN_MODE", 0, 0);
        UNKNOWN_MODE = r0;
        MessageDisplayMode r1 = new MessageDisplayMode("DISABLE", 1, 1);
        DISABLE = r1;
        MessageDisplayMode r3 = new MessageDisplayMode("INVISIBLE", 2, 2);
        INVISIBLE = r3;
        $VALUES = new MessageDisplayMode[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(MessageDisplayMode.class);
    }

    public static MessageDisplayMode[] values() {
        return (MessageDisplayMode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MessageDisplayMode fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return INVISIBLE;
    L12:
        return DISABLE;
    L14:
        return UNKNOWN_MODE;
    }

    public static MessageDisplayMode valueOf(String r1) {
        return (MessageDisplayMode) a.a(MessageDisplayMode.class, r1);
    }

    private MessageDisplayMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
