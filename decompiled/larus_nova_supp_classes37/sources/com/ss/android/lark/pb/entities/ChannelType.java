package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ChannelType extends Enum<ChannelType> implements WireEnum {
    private static final /* synthetic */ ChannelType[] $VALUES = null;
    public static final ProtoAdapter<ChannelType> ADAPTER = null;
    public static final ChannelType CHAT_CHANNEL = null;
    public static final ChannelType EMAIL_CHANNEL = null;
    public static final ChannelType UNKNOWN_CHANNEL_TYPE = null;
    private final int value;

    static {
        ChannelType r0 = new ChannelType("UNKNOWN_CHANNEL_TYPE", 0, 0);
        UNKNOWN_CHANNEL_TYPE = r0;
        ChannelType r1 = new ChannelType("CHAT_CHANNEL", 1, 1);
        CHAT_CHANNEL = r1;
        ChannelType r3 = new ChannelType("EMAIL_CHANNEL", 2, 2);
        EMAIL_CHANNEL = r3;
        $VALUES = new ChannelType[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChannelType.class);
    }

    public static ChannelType[] values() {
        return (ChannelType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChannelType fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return EMAIL_CHANNEL;
    L12:
        return CHAT_CHANNEL;
    L14:
        return UNKNOWN_CHANNEL_TYPE;
    }

    public static ChannelType valueOf(String r1) {
        return (ChannelType) a.a(ChannelType.class, r1);
    }

    private ChannelType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
