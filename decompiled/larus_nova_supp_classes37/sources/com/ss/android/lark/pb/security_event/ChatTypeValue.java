package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ChatTypeValue extends Enum<ChatTypeValue> implements WireEnum {
    private static final /* synthetic */ ChatTypeValue[] $VALUES = null;
    public static final ProtoAdapter<ChatTypeValue> ADAPTER = null;
    public static final ChatTypeValue GROUP = null;
    public static final ChatTypeValue P2P = null;
    private final int value;

    static {
        ChatTypeValue r0 = new ChatTypeValue("P2P", 0, 1);
        P2P = r0;
        ChatTypeValue r1 = new ChatTypeValue("GROUP", 1, 2);
        GROUP = r1;
        $VALUES = new ChatTypeValue[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChatTypeValue.class);
    }

    public static ChatTypeValue[] values() {
        return (ChatTypeValue[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatTypeValue fromValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return GROUP;
    L11:
        return P2P;
    }

    public static ChatTypeValue valueOf(String r1) {
        return (ChatTypeValue) a.a(ChatTypeValue.class, r1);
    }

    private ChatTypeValue(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
