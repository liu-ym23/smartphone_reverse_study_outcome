package com.ss.android.lark.pb.chats;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum AddChatChatterSource extends Enum<AddChatChatterSource> implements WireEnum {
    private static final /* synthetic */ AddChatChatterSource[] $VALUES = null;
    public static final ProtoAdapter<AddChatChatterSource> ADAPTER = null;
    public static final AddChatChatterSource BY_MENTION = null;
    public static final AddChatChatterSource UNKNOWN_SOURCE = null;
    private final int value;

    static {
        AddChatChatterSource r0 = new AddChatChatterSource("UNKNOWN_SOURCE", 0, 0);
        UNKNOWN_SOURCE = r0;
        AddChatChatterSource r1 = new AddChatChatterSource("BY_MENTION", 1, 1);
        BY_MENTION = r1;
        $VALUES = new AddChatChatterSource[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(AddChatChatterSource.class);
    }

    public static AddChatChatterSource[] values() {
        return (AddChatChatterSource[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AddChatChatterSource fromValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return BY_MENTION;
    L10:
        return UNKNOWN_SOURCE;
    }

    public static AddChatChatterSource valueOf(String r1) {
        return (AddChatChatterSource) a.a(AddChatChatterSource.class, r1);
    }

    private AddChatChatterSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
