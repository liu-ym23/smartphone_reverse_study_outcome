package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ClientType extends Enum<ClientType> implements WireEnum {
    private static final /* synthetic */ ClientType[] $VALUES = null;
    public static final ProtoAdapter<ClientType> ADAPTER = null;
    public static final ClientType ANDROID = null;
    public static final ClientType HARMONY = null;
    public static final ClientType IOS = null;
    public static final ClientType UNKNOWN_CLIENT_TYPE = null;
    public static final ClientType WEB = null;
    private final int value;

    static {
        ClientType r0 = new ClientType("UNKNOWN_CLIENT_TYPE", 0, 0);
        UNKNOWN_CLIENT_TYPE = r0;
        ClientType r1 = new ClientType("WEB", 1, 1);
        WEB = r1;
        ClientType r3 = new ClientType("ANDROID", 2, 2);
        ANDROID = r3;
        ClientType r5 = new ClientType("IOS", 3, 3);
        IOS = r5;
        ClientType r7 = new ClientType("HARMONY", 4, 4);
        HARMONY = r7;
        $VALUES = new ClientType[]{r0, r1, r3, r5, r7};
        ADAPTER = ProtoAdapter.newEnumAdapter(ClientType.class);
    }

    public static ClientType[] values() {
        return (ClientType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ClientType fromValue(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return null;
    L14:
        return HARMONY;
    L16:
        return IOS;
    L18:
        return ANDROID;
    L20:
        return WEB;
    L22:
        return UNKNOWN_CLIENT_TYPE;
    }

    public static ClientType valueOf(String r1) {
        return (ClientType) a.a(ClientType.class, r1);
    }

    private ClientType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
