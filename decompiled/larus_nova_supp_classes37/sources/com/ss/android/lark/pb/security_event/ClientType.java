package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ClientType extends Enum<ClientType> implements WireEnum {
    private static final /* synthetic */ ClientType[] $VALUES = null;
    public static final ProtoAdapter<ClientType> ADAPTER = null;
    public static final ClientType ClientAndroid = null;
    public static final ClientType ClientHarmonyOS = null;
    public static final ClientType ClientIOS = null;
    public static final ClientType ClientLarkPC = null;
    public static final ClientType ClientUnknown = null;
    public static final ClientType ClientWeb = null;
    private final int value;

    static {
        ClientType r0 = new ClientType("ClientUnknown", 0, 0);
        ClientUnknown = r0;
        ClientType r1 = new ClientType("ClientLarkPC", 1, 1);
        ClientLarkPC = r1;
        ClientType r3 = new ClientType("ClientAndroid", 2, 2);
        ClientAndroid = r3;
        ClientType r5 = new ClientType("ClientIOS", 3, 3);
        ClientIOS = r5;
        ClientType r7 = new ClientType("ClientWeb", 4, 4);
        ClientWeb = r7;
        ClientType r9 = new ClientType("ClientHarmonyOS", 5, 5);
        ClientHarmonyOS = r9;
        $VALUES = new ClientType[]{r0, r1, r3, r5, r7, r9};
        ADAPTER = ProtoAdapter.newEnumAdapter(ClientType.class);
    }

    public static ClientType[] values() {
        return (ClientType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ClientType fromValue(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L16;
        return null;
    L16:
        return ClientHarmonyOS;
    L18:
        return ClientWeb;
    L20:
        return ClientIOS;
    L22:
        return ClientAndroid;
    L24:
        return ClientLarkPC;
    L26:
        return ClientUnknown;
    }

    public static ClientType valueOf(String r1) {
        return (ClientType) a.a(ClientType.class, r1);
    }

    private ClientType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
